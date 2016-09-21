package com.melidata.metrics.format

import com.ml.melidata.metrics.NameWrapper
import com.ml.melidata.metrics.RegExWrapper
import groovy.json.JsonOutput

class QueryFormatter {

	def buildJson() {
		//TODO: in a future we merge sql scripts to this json. Right now we edit just a single file, read it and print
		def basedirname = "src/main/resources/data-dependencies-catalog/sql/"
		def files = [] as Queue
		files.add(new File(basedirname))
		def map = [:]
		while(!files.isEmpty()){
			def file = files.poll()
			if(file.isDirectory()){
				file.listFiles().each {
					f -> files.add(f)
				}
			}else{
				def abs = file.getAbsolutePath()
				map[abs.split(basedirname)[1]]=file.text
			}
		}
		map.entrySet().each {e ->
			println(String.format("%s;%s", e.key, e.value))
		}

		def jsontxt = new File('./src/main/resources/data-dependencies-catalog/jsonmelidata.json').getText('UTF-8')
		new groovy.json.JsonSlurper().parseText(jsontxt)
		return jsontxt
	}
}
