package com.melidata.definitions.format

import groovy.json.JsonOutput


class JSONFormatter extends CatalogFormatter {

    def generate() {
        def platforms = getPlatforms(catalog.platformTrees.mercadolibre)
        println(platforms)

        platforms.collectEntries{k,v -> [k,getTrackInfo(v.tracksTree.children)]}
    }

    def getTrackInfo(def c) {
        if (c?.containsKey('/') && c?.size() == 1) {
            def v = c.'/'
            return [properties: extractProps(v), children: getTrackInfo(v.children)]
        } else
            return c ? c.collectEntries {k,v -> [k,[properties: extractProps(v), children: getTrackInfo(v.children)]] } : [:]
    }

    def extractProps(def t) {
        t.definition ? t.definition.properties.collectEntries{k,v -> [k,v.type]} : [:]
    }

    static void main(String[] args) {
        println("OUTPUT")
        def out = new JSONFormatter().generate()
        def json = JsonOutput.toJson(out)

        def file = new File("catalog.json")
        file.delete()

        file << json
    }

}
