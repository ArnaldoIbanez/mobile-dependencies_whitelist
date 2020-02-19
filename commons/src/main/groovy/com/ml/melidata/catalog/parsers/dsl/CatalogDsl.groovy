package com.ml.melidata.catalog.parsers.dsl

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.DslUtils

/**
 * Created by geisbruch on 11/17/14.
 */
class CatalogDsl {

    //it is not thread safe
    def static String baseDir = "src/main/resources/catalog/melidata/"

    def Catalog catalog;

    def platforms = []

    def String defaultBusiness;

    def CatalogDsl() {
        catalog = new Catalog()
    }

    def static setBaseDir(String dir) {
        baseDir = dir
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
        TrackDsl trackDsl = new TrackDsl()
        closure.delegate = trackDsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure();
        add(trackDsl.trackDefinitions, defaultBusiness)
    }

    def include(String fileName) {
        include(defaultBusiness, fileName)
    }

    def include(String business, String fileName) {
        def file = new File(baseDir + fileName)
        def trackDsl = DslUtils.parse(file)
        add(trackDsl, business)
        catalog.addFile(file)
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

    def setAbPlatforms(arr) {
        catalog.addAbPlatforms(arr)
    }

    def setAbPlatformsSubscriptions(arr) {
        catalog.addAbPlatformsSubscriptions(arr)
    }

}
