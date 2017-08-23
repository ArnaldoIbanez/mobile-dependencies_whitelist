package com.melidata.metrics.format

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import org.json.simple.JSONObject
import com.google.gson.Gson
import com.google.gson.GsonBuilder



class QueryFormatter {

    public static void main(String[] args) {
        String output = args.length > 1 ? args[1] : "/tmp/jsonmelidata.json"
        String json = new QueryFormatter().buildJson()
        new File(output).write(json)
        println("JSON written to " + output)
    }

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

    def merge(jsonSnippets, sqlSnippets) {
        def sqlscripts = sqlSnippets.keySet()
        def list = []
        jsonSnippets.values().each{ json ->
            Map jsonMap = new JsonSlurper().parseText(json)
            sqlscripts.each { scriptname ->
                String scriptValue = jsonMap.extract.sql.script
                if (scriptname.equals(scriptValue)) {
                    jsonMap.extract.sql.script = sanitize(sqlSnippets[scriptname])
                    list.add(jsonMap)
                }
            }
        }
        return list
    }

    def sanitize = { query ->
        //def sanitizedQuery = new String(query)
        return query.split().join(' ')
    }

    def buildJson() {
        String jsonString = concatQueries()

        // jsonString may not be pretty printed, so we make sure it is
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()
        return gson.toJson(gson.fromJson(jsonString, Map))
    }

    def concatQueries() {
        //TODO: in a future we merge sql scripts to this json. Right now we edit just a single file, read it and print
        def jsonSnippets = filesMap("src/main/resources/data-dependencies-catalog/json/")
        def sqlSnippets = filesMap("src/main/resources/data-dependencies-catalog/sql/")

        def queries = merge(jsonSnippets, sqlSnippets)

        return new Gson().toJson([data: queries])
    }
}
