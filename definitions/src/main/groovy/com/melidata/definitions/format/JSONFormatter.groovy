package com.melidata.definitions.format

import groovy.json.JsonOutput


class JSONFormatter extends CatalogFormatter {

    JSONFormatter(String catalogDir, String s3CatalogFile) {
        super(catalogDir, s3CatalogFile)
    }

    def generate(String business) {
        def platforms = getPlatforms(catalog.platformTrees.get(business))

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
}
