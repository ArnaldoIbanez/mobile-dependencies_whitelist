import com.melidata.definitions.TestRunner
import com.melidata.definitions.outs.StdOut
import com.ml.melidata.Track
import com.ml.melidata.TrackAdapterHelper
import com.ml.melidata.catalog.tree.TrackValidationResponse
import groovy.json.JsonSlurper

def onlyPrintFails = Boolean.getBoolean("onlyPrintFails")

def pathCatalog = "src/main/resources/catalog/catalog.groovy"
def catalogScript = TestRunner.getScriptFromFile(pathCatalog)
def catalog = TestRunner.runScript(catalogScript)
def status = true

def track =  System.getProperty("track", "")
if ( !new File(track).exists() ) {
	println("Validate single track")
	println("Track: $track")
	Track trackObj = TrackAdapterHelper.adaptTrack(new JsonSlurper().parseText(track))
	TrackValidationResponse response = catalog.validate(trackObj)
	println ""
	println "Status: ${response.getStatus()}"
	println "Messages: ${response.getMessages()}"

	status = response.status
} else {
	println "Tracks File: ${track}\n"

	new File(track).eachLine {
		Track trackObj = TrackAdapterHelper.adaptTrack(new JsonSlurper().parseText(it))
		TrackValidationResponse response = catalog.validate(trackObj)
		if ( !response.getMessages().toString().contains("unknown") && (!onlyPrintFails || !response.status) ) {
			println "Track: $it"
			println ""
			println "Status: ${response.getStatus()}"
			println "Path: ${trackObj.path}"
			println "Event Data: ${trackObj.event_data}"
			println "Messages: ${response.getMessages()}"
			println ""
		}

		if (!status) status = response.status
	}
}

if (!status)
	System.exit(1)
