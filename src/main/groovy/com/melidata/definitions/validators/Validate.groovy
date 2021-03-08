package com.melidata.definitions.validators

import com.ml.melidata.catalog.DslUtils
import com.ml.melidata.catalog.tree.TrackValidationResponse
import groovy.json.*
import groovy.sql.Sql
import java.text.SimpleDateFormat

class Validate {

    public static String BASE_CATALOG_DIR = "src/main/resources/catalog/"
    public static String DEFAULT_CATALOG = "catalog.groovy"
    public static String DEFAULT_CATALOG_DIR = BASE_CATALOG_DIR + "melidata/"

    static void main(String[] args) {
        def cli = buildCli(args)
        def options = cli.parse(args)

        println "Generating Catalog..."

        String pathCatalog
        if (options.catalog) {
            String catalogName = options.catalog
            def catalogDir = BASE_CATALOG_DIR + catalogName + "/"
            pathCatalog = catalogDir + DEFAULT_CATALOG
            DslUtils.setBaseDir(catalogDir)
        } else {
            pathCatalog = DEFAULT_CATALOG_DIR + DEFAULT_CATALOG
            DslUtils.setBaseDir(DEFAULT_CATALOG_DIR)
        }
        def catalogScript = CatalogValidator.getScriptFromFile(pathCatalog)
        def catalog = CatalogValidator.runScript(catalogScript)

        println "Done. Will fetch for tracks for validating..."
        
        def result = generateResult(options, catalog)
        if (result.size() > 0) {
            writeResults(result, options)
            if (options.summary) printSummary(result)
        } else {
            println "No results found. Is the query OK?"
        }
    }


    private static void writeResults(List result, options) {
        if (options.to_file) {
            def filepath = options.to_file
            def writer = new BufferedWriter(new FileWriter(filepath))
            result.each {
                writer.writeLine(JsonOutput.toJson(it))
            }
            writer.close()
            println "File $filepath generated"
        } else {
            result.each { track ->
                println "Track [Path:$track.path, Type:$track.type, Business:$track.business, Platform:$track.platform, Version:$track.version]: $track.event_data"
                println "Status: ${track.status}"
                println "Messages: ${track.message}"
                println ""
            }
        }
    }

    private static void printSummary(List result) {
        def map = [:]
        result.each { track ->
            if ( map[track.message] ) {
                map[track.message] = map[track.message] + 1
            } else {
                map[track.message] = 1
            }
        }

        println "Summary:"
        // Sort map by count (desc)
        def fails = map.collect{msg, count -> [msg, count]}.sort{f1, f2 -> f2[1] <=> f1[1]}
        fails.each { fail ->
            println "${fail[0]} : ${fail[1]}"
        }

        println ""
        println "Total: ${result.size()}"
    }

    private static List generateResult(options, catalog) {
        if (options.from_file)
            return generateResultFromFile(options, catalog)
        else
            return generateResultFromPresto(options, catalog)
    }

    private static List generateResultFromPresto(options, catalog) {
        def query = buildQuery(options)
        def presto_certs_path = System.getProperty("user.dir") + "/src/main/resources/presto_cacerts"
        System.err.println("Query:")
        System.err.println("${query}")
        System.err.println("")

        def db = [url:"jdbc:presto://melidata-presto.adminml.com:443/hive/default?SSL=true&SSLKeyStorePath=${presto_certs_path}&applicationNamePrefix=catalog",
                  user:'catalog_md', password:'Entrada.10', driver:'com.facebook.presto.jdbc.PrestoDriver']
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
        def result = []
        sql.eachRow(query) { row ->
            com.ml.melidata.Track track = new com.ml.melidata.Track(
                    row.path, 
                    com.ml.melidata.TrackAdapterHelper.adaptType(row.type.toUpperCase()), 
                    row.platform, 
                    row.application.business,
                    row.application.version)
            track.setEvent_data(new JsonSlurper().parseText(row.event_data))
            TrackValidationResponse response = catalog.validate(track)
            result << [path: track.path, type: track.type, business: track.business, version: track.version,
                        platform: track.platform, event_data: track.event_data,
                        status: response.getStatus(), message: response.getMessages() ]
        }

        return result
    }

    private static List generateResultFromFile(options, catalog) {
        def result = []
        def slurper = new JsonSlurper()
        def reader = new BufferedReader(new FileReader(options.from_file.toString()))
        def line
        while ( (line = reader.readLine()) != null ) {
            def json = slurper.parseText(line)
            com.ml.melidata.Track track = new com.ml.melidata.Track(
                    json.path, 
                    com.ml.melidata.TrackAdapterHelper.adaptType(json.type.toUpperCase()), 
                    json.platform, 
                    json.business)
            track.setEvent_data(json.event_data)
            TrackValidationResponse response = catalog.validate(track)
            json.status = response.getStatus()
            json.message = response.getMessages()

            result << json
        }
        return result
    }

    private static def getFromDate(options) {
        def calendar = Calendar.getInstance()
        if (options.date) {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(options.date))
        } else {
            calendar.setTime(new Date())
            calendar.add(Calendar.DATE, -1)
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
    }

    private static def getToDate(options) {
        def calendar = Calendar.getInstance()
        if (options.date) {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(options.date))
            calendar.add(Calendar.DATE, 1)
        } else {
            calendar.setTime(new Date())
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
    }

    private static String buildQuery(options) {
        def from = getFromDate(options)
        def to = getToDate(options)
        def date = "AND ds >= '${from}' AND ds < '${to}' \n"
        def path = ""
        def exact_path = ""
        def business = ""
        def platform = ""
        def site = ""
        def version = ""
        def pool_name = ""
        def limit = "100"
	def table = "tracks"
	def platform_column = "device.platform"

	if (options.catalog) {
		table = "shipping"
		platform_column = "platform"
	}
        if (options.exact_path) exact_path = "AND path = '/${options.exact_path}' \n"
        if (options.path) path = "AND path LIKE '/${options.path}%' \n"
        if (options.business) business = "AND application.business = '${options.business}' \n"
        if (options.platform) platform = "AND ${platform_column} = '${options.platform}' \n"
        if (options.site) site = "AND application.site_id = '${options.site}' \n"
        if (options.version) version = "AND application.version = '${options.version}' \n"
        if (options.pool_name) pool_name = "AND application.server_poolname LIKE '%${options.pool_name}%' \n"
        if (options.limit) limit = options.limit


        return ("SELECT id, type, path, event_data, ${platform_column}, application \n" +
               "FROM ${table} \n" +
               "WHERE catalog_data.is_valid = false \n" +
               "${date}${path}${exact_path}${business}${platform}${site}${version}${pool_name}" +
               "limit ${limit}").toString()
    }

    private static CliBuilder buildCli(String[] args) {
        def cli = new CliBuilder()
        cli.catalog(args:1, "catalog")
        cli.date(args:1, "date")
        cli.exact_path(args:1, "exact_path")
        cli.path(args:1, "path")
        cli.business(args:1, "business")
        cli.platform(args:1, "platform")
        cli.site(args:1, "site")
        cli.limit(args:1, "limit")
        cli.to_file(args:1, "to_file")
        cli.from_file(args:1, "from_file")
        cli.summary(args:0, "summary")
        cli.version(args:1, "version")
        cli.pool_name(args:1, "pool_name")

        return cli
    }

}
