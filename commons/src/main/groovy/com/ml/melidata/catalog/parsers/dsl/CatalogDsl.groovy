package com.ml.melidata.catalog.parsers.dsl

import com.ml.melidata.catalog.Catalog

/**
 * Created by geisbruch on 11/17/14.
 */
class CatalogDsl {

    def String baseDir = "catalog/"

    def Catalog catalog;

    def platforms = []

    def String defaultBusiness;

    def CatalogDsl() {
        catalog = new Catalog()
    }

    def static catalog(Closure closure) {
        CatalogDsl dsl = new CatalogDsl()
        closure.delegate = dsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        return dsl.catalog
    }

    def setDefaultBusiness(business) {
        defaultBusiness = business
        catalog.setDefaultBusiness(business)
    }

    def tracks(closure) {
       TrackDsl trackDsl = new TrackDsl();
       closure.delegate = trackDsl
       closure.resolveStrategy = Closure.DELEGATE_FIRST
       closure();
       add(trackDsl.trackDefinitions, defaultBusiness)
    }

    def include(String fileName) {
        include(defaultBusiness, fileName)
    }

    def include(String business, String fileName) {
        GroovyShell shell = new GroovyShell()
        def trackDsl = shell.parse(new File(baseDir + fileName)).run()
        add(trackDsl, business)
    }

    def add(list, overridedBusiness) {
        list.each { tr ->
            if(!tr.business) {
                tr.business = overridedBusiness;
            }
            catalog.addBusiness(tr.business)
            catalog.addTrackDefinition(tr)
        }
    }

    def setPlatforms(arr) {
        platforms.addAll(arr)
        platforms.each {p ->
            catalog.addPlatform(p)
        }
    }

}
