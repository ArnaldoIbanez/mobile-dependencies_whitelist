package com.melidata.definitions.format

import groovy.json.JsonOutput

class DDLFormatter extends CatalogFormatter {

    def generate() {
        def platforms = getPlatforms(catalog.platformTrees.mercadolibre)

        platforms.collectEntries{k,v -> [k,getPathInfo(v.tracksTree.children)]}
    }

    def getPathInfo(def c) {
        getTrackInfo(c).collectEntries{[it.key,it.value]}.findAll{it.value}
    }

    def getTrackInfo(def c) {
        if (c?.containsKey('/') && c?.size() == 1) {
            def v = c.'/'
            return getLine('/',v)
        } else
            return c ? c.collect {k,v -> getLine(k,v) }.flatten() : []
    }

    def getLine(def k, def v) {
        combine(new MapEntry(k,extractProps(v)), getTrackInfo(v.children))
    }

    def formatOutput(def data) {
        JsonOutput.toJson(data)
    }

    static void main(String[] args) {
        def file = new File("catalog.json")
        file.delete()

        file << new DDLFormatter().output
    }
}
