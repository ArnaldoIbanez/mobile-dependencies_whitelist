package com.melidata.metrics.format

import com.ml.melidata.metrics.NameWrapper
import com.ml.melidata.metrics.RegExWrapper
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class QueryFormatter {

	def filesMap = { basedirname ->
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
		return map
	}

	def merge = { jsonSnippets, sqlSnippets ->
		def sqlscripts = sqlSnippets.keySet()
		def list = []
		jsonSnippets.values().each{ json ->
			sqlscripts.each{ scriptname ->
				if(json.contains(scriptname)){
                    def query = sqlSnippets[scriptname]
                    list.add(json.replace(scriptname, sanitize(query) ))
				}
			}
		}
		return list
	}

    def sanitize = { query ->
        //def sanitizedQuery = new String(query)
        return query.replace("\n", " ").replace("\t","").replace("     ","")
    }

	def buildJson() {
		String jsonString = concatQueries()

		//def jsontxt = new File('./src/main/resources/data-dependencies-catalog/jsonmelidata.json').getText('UTF-8')
        def json = new JsonSlurper().parseText(jsonString)
        return new groovy.json.JsonBuilder(json).toPrettyString()
	}

    def concatQueries() {
        //TODO: in a future we merge sql scripts to this json. Right now we edit just a single file, read it and print
        def jsonSnippets = filesMap("src/main/resources/data-dependencies-catalog/json/")
        def sqlSnippets = filesMap("src/main/resources/data-dependencies-catalog/sql/")

        def queries = merge(jsonSnippets, sqlSnippets)

        def jsonString = String.format("{\"data\": %s}", queries)
        jsonString
    }
}
