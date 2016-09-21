package com.melidata.metrics.format

import com.ml.melidata.metrics.NameWrapper
import com.ml.melidata.metrics.RegExWrapper
import groovy.json.JsonOutput

class QueryFormatter {

	def buildJson() {
		//TODO: in a future we merge sql scripts to this json. Right now we edit just a single file, read it and print
		def files = new File("./src/main/resources/data-dependencies-catalog/sql/").listFiles()
		files.each {file -> println(file.getAbsolutePath())}
		
		def jsontxt = new File('./src/main/resources/data-dependencies-catalog/jsonmelidata.json').getText('UTF-8')
		new groovy.json.JsonSlurper().parseText(jsontxt)
		return jsontxt
	}
}
