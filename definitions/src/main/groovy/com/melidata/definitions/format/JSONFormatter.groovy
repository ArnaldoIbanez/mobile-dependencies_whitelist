package com.melidata.definitions.format

import groovy.json.JsonOutput


class JSONFormatter extends CatalogFormatter {

    def generate() {
        def platforms = getPlatforms(catalog.platformTrees.mercadolibre)

        platforms.collectEntries{k,v -> [k,getTrackInfo(v.tracksTree.children)]}
    }

    def getLine(def k, def v) {
        [properties: extractProps(v), children: getTrackInfo(v.children)]
    }

    def getTrackInfo(def c) {
        if (c?.containsKey('/') && c?.size() == 1) {
            def v = c.'/'
            return getLine('/',v)
        } else
            return c ? c.collectEntries {k,v -> [k,getLine(k,v)] } : [:]
    }

    def formatOutput(def data) {
        JsonOutput.toJson(data)
    }

    static void main(String[] args) {
        def file = new File("catalog.json")
        file.delete()

        file << new JSONFormatter().output
    }

}
