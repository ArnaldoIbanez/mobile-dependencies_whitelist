package com.melidata.metrics.format

import com.ml.melidata.metrics.MetricDefinition
import com.ml.melidata.metrics.Metrics
import com.ml.melidata.metrics.NameWrapper
import com.ml.melidata.metrics.RegExWrapper
import groovy.json.JsonOutput

class QueryFormatter {

	def QueryFormatter() {}

	def buildJson() {
		//TODO: in a future we merge sql scripts to this json. Right now we edit just a single file, read it and print
		if(file.exists()){
			val jsontxt = this.getClass().getResource('/data-dependencies-catalog/jsonmelidata.json').getText('UTF-8')
			new JsonSlurper().parseText(jsontxt)
			return jsontxt
		}
		return [:]
	}
}
