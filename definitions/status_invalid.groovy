@GrabConfig(systemClassLoader= true)
@GrabResolver(name='meli', root='http://git.ml.com/nexus/content/groups/ML')
@Grab(group='com.googlecode.json-simple', module='json-simple', version='1.1.1')
@Grab(group='org.hamcrest', module='hamcrest-core', version='1.3')
@Grab(group='joda-time', module='joda-time', version='2.9.4')
@Grab(group='junit', module='junit', version='4.12')
@Grab(group='com.facebook.presto', module='presto-jdbc', version='0.130')
@Grab(group='com.mercadolibre.melidata.catalog', module='definitions',version='0.1.21')

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

def date = " ds >= '$from' and ds < '$to'"
def path = ""
def business = ""
def platform = ""
def site = ""

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

query = "select count(if(catalog_data.is_valid = true,1,null)) valids, count(if(catalog_data.is_valid = false,1,null)) invalids  from tracks where ${date} ${path} ${business} ${platform} ${site}".toString()
System.err.println("Query: ${query}")

def db = [url:'jdbc:presto://melidata-jdbc.ml.com:80/hive/default', user:'catalog', password:'psw', driver:'com.facebook.presto.jdbc.PrestoDriver']
def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

println ""
sql.eachRow(query) { row ->
	println "Total Valid Tracks: $row.valids"
	println "Invalid Catalog Tracks: $row.invalids (${row.invalids * 100 / (row.valids+row.invalids)} %)"
}

