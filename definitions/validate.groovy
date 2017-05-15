@GrabConfig(systemClassLoader= true)
@GrabResolver(name='meli', root='http://git.ml.com/nexus/content/groups/ML')
@Grab(group='com.googlecode.json-simple', module='json-simple', version='1.1.1')
@Grab(group='org.hamcrest', module='hamcrest-core', version='1.3')
@Grab(group='joda-time', module='joda-time', version='2.9.4')
@Grab(group='junit', module='junit', version='4.12')
@Grab(group='com.facebook.presto', module='presto-jdbc', version='0.166')
@Grab(group='com.mercadolibre.melidata.catalog', module='definitions',version='0.1.22')

import com.melidata.definitions.TestRunner
import com.melidata.definitions.outs.StdOut
import com.ml.melidata.Track
import com.ml.melidata.TrackAdapterHelper
import com.ml.melidata.catalog.tree.TrackValidationResponse
import groovy.json.*
import groovy.util.CliBuilder
import groovy.sql.Sql;


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
def options = cli.parse(args)

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
def calendar = Calendar.getInstance()
calendar.setTime(new Date())
def to = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
calendar.add(Calendar.DATE, -1)
def from = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())

if ( options.date ) {
	calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(options.date))
	from = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
	calendar.add(Calendar.DATE, 1)
	to = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())
}

def date = "and ds >= '$from' and ds < '$to'"
def path = ""
def business = ""
def platform = ""
def site = ""
def limit = "100"

if ( options.path ) {
        path = "and path = '${options.path}'"
}

if ( options.business ) {
	business = "and application.business = '${options.business}'"
}

if ( options.platform ) {
	platform = "and device.platform = '${options.platform}'"
}

if ( options.site ) {
	site = "and application.site_id = '${options.site}'"
}

if ( options.limit ) {
	limit = options.limit
}

def pathCatalog = "src/main/resources/catalog/catalog.groovy"
def catalogScript = TestRunner.getScriptFromFile(pathCatalog)
com.ml.melidata.catalog.DslUtils.setBaseDir("src/main/resources/catalog/")
def catalog = TestRunner.runScript(catalogScript)

def result = []

if ( options.from_file ) {
	def slurper = new JsonSlurper()
	def reader = new BufferedReader(new FileReader(options.from_file.toString()))
	def line
	while ( (line = reader.readLine()) != null ) {
		def json = slurper.parseText(line)

		com.ml.melidata.Track track = new com.ml.melidata.Track(json.path, com.ml.melidata.TrackAdapterHelper.adaptType(json.type.toUpperCase()), json.platform, json.business)
		track.setEvent_data(json.event_data)
		TrackValidationResponse response = catalog.validate(track)
		json.status = response.getStatus()
		json.message = response.getMessages()

		result << json
	}
} else {
	query = "select id, type, path, event_data, device, application, platform from tracks where catalog_data.is_valid = false ${date} ${path} ${business} ${platform} ${site} limit ${limit}".toString()
	System.err.println("Query: ${query}")

	def db = [url:'jdbc:presto://melidata-presto.ml.com:80/hive/default', user:'catalog', password:'psw', driver:'com.facebook.presto.jdbc.PrestoDriver']
	def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

	sql.eachRow(query) { row ->
		com.ml.melidata.Track track = new com.ml.melidata.Track(row.path, com.ml.melidata.TrackAdapterHelper.adaptType(row.type.toUpperCase()), row.device.platform, row.application.business)
		track.setEvent_data(new JsonSlurper().parseText(row.event_data))
		TrackValidationResponse response = catalog.validate(track)
		result << [path: track.path, type: track.type, business: track.business, platform: track.platform, event_data: track.event_data,
				   status: response.getStatus(), message: response.getMessages() ]
	}
}


if ( options.to_file ) {
	def writer = new BufferedWriter(new FileWriter(options.to_file.toString()))
	result.each {
		writer.writeLine(JsonOutput.toJson(it))
	}
	writer.close()
	println "File $options.to_file generated"
} else {
	result.each { track ->
		println "Track [$track.type, $track.business, $track.platform]: $track.event_data"
		println "Status: ${track.status}"
		println "Messages: ${track.message}"
		println ""
	}
}

if ( options.summary ) {
	def map = [:]
	def total = 0
	def fail = 0
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
