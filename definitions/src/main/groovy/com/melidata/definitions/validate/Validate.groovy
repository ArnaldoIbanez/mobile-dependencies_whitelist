package com.melidata.definitions.validate

import com.melidata.definitions.TestRunner
import com.melidata.definitions.outs.StdOut
import com.ml.melidata.Track
import com.ml.melidata.TrackAdapterHelper
import com.ml.melidata.catalog.tree.TrackValidationResponse
import groovy.json.*
import groovy.util.CliBuilder
import groovy.sql.Sql;
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


class Validate {

    def static void main(String[] args) {
        def cli = buildCli(args)
        def options = cli.parse(args)

        def pathCatalog = "src/main/resources/catalog/catalog.groovy"
        def catalogScript = TestRunner.getScriptFromFile(pathCatalog)
        com.ml.melidata.catalog.DslUtils.setBaseDir("src/main/resources/catalog/")
        def catalog = TestRunner.runScript(catalogScript)
        
        def result = generateResult(options, catalog)
        writeResults(result, options)
        if (options.summary) printSummary(result)
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
                println "Track [$track.type, $track.business, $track.platform]: $track.event_data"
                println "Status: ${track.status}"
                println "Messages: ${track.message}"
                println ""
            }
        }
    }

    private static void printSummary(List result) {
        def map = [:], total = 0, fail = 0
        result.each { track ->
            if ( map[track.message] ) {
                map[track.message] = map[track.message] + 1
            } else {
                map[track.message] = 1
            }
            total++
            if ( ! track.status ) fail++
        }

        println "Summary:"
        map.each { message, count ->
            println "$message : $count"
        }

        println ""
        println "Total: $total"
        println "Fail: $fail (${fail * 100 / total} %)"
    }

    private static List generateResult(options, catalog) {
        if (options.from_file)
            return generateResultFromFile(options, catalog)
        else
            return generateResultFromPresto(options, catalog)
    }

    private static List generateResultFromPresto(options, catalog) {
        def query = buildQuery(options)
        System.err.println("Query: ${query}")

        def db = [url:'jdbc:presto://melidata-presto.ml.com:80/hive/default', 
                    user:'catalog', password:'psw', 
                    driver:'com.facebook.presto.jdbc.PrestoDriver']
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

        def result = []
        sql.eachRow(query) { row ->
            com.ml.melidata.Track track = new com.ml.melidata.Track(
                    row.path, 
                    com.ml.melidata.TrackAdapterHelper.adaptType(row.type.toUpperCase()), 
                    row.device.platform, 
                    row.application.business)
            track.setEvent_data(new JsonSlurper().parseText(row.event_data))
            TrackValidationResponse response = catalog.validate(track)
            result << [path: track.path, type: track.type, business: track.business, 
                        platform: track.platform, event_data: track.event_data,
                        status: response.getStatus(), message: response.getMessages() ]
        }

        return result
    }

    private static List generateResultsFromFile(options, catalog) {
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
        def date = "AND ds >= '${from}' AND ds < '${to}'"
        def path = ""
        def business = ""
        def platform = ""
        def site = ""
        def limit = "100"

        if (options.path) path = "AND path = '${options.path}'"
        if (options.business) business = "AND application.business = '${options.business}'"
        if (options.platform) platform = "AND device.platform = '${options.platform}'"
        if (options.site) site = "AND application.site_id = '${options.site}'"
        if (options.limit) limit = options.limit

        return ("SELECT id, type, path, event_data, device, application, platform " +
               "FROM tracks " +
               "WHERE catalog_data.is_valid = false "+
               "${date} ${path} ${business} ${platform}  ${site} " +
               "limit ${limit}").toString()
    }

    private static CliBuilder buildCli(String[] args) {
        def cli = new CliBuilder()
        cli.date(args:1, "date")
        cli.path(args:1, "path")
        cli.business(args:1, "business")
        cli.platform(args:1, "site")
        cli.site(args:1, "site")
        cli.limit(args:1, "limit")
        cli.to_file(args:1, "to_file")
        cli.from_file(args:1, "from_file")
        cli.summary(args:0, "summary")
        return cli
    }

}
