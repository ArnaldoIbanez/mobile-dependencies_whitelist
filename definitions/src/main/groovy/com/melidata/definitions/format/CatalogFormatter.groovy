package com.melidata.definitions.format

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.CatalogFactory
import com.ml.melidata.catalog.tree.PlatformTree


abstract class CatalogFormatter {

    abstract def getLine(def k, def v)
    abstract def generate()
    abstract def formatOutput(def data)

    def extractProps(def t) {
        t.definition ? t.definition.properties.collectEntries{k,v -> [k,[v.type?.toString(),v.required,v.serverSide,v.description]]} : [:]
    }

    protected Catalog getCatalog() {
        CatalogFactory.catalog
    }

    def getPlatforms(def t) {
        traverse(t).collectEntries{[it.key,it.value]}
    }

    def traverse(PlatformTree t) {
        combine((t.segment ? new MapEntry(t.segment,t) : null), (t.children ? t.children.collect{k,v -> traverse(v)} : []).flatten())
    }

    def combine(def a, def b) {
        a ? [a] + b.collect {new MapEntry(concatenateKeys(a.key, it.key), it.value)} : b
    }

    def concatenateKeys(def a, def b) {
        (a + '/' + b).replaceAll("/{2,}","/")
    }

    def getOutput() {
        formatOutput(generate())
    }

}
