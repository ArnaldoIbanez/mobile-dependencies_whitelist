package com.ml.melidata.catalog.parsers.dsl

import com.ml.melidata.catalog.Catalog

/**
 * Created by geisbruch on 11/17/14.
 */
class CatalogDsl {


    def Catalog catalog;

    def platforms;

    def List<String> business;

    def String default_business;

    def CatalogDsl() {
        catalog = new Catalog()
    }

    def static catalog(clousure) {
        CatalogDsl dsl = new CatalogDsl()
        clousure.delegate = dsl
        clousure.resolveStrategy = Closure.DELEGATE_FIRST
        clousure()
        return dsl.catalog
    }

    def tracks(closure) {
       TrackDsl trackDsl = new TrackDsl();
       closure.delegate = trackDsl
       closure.resolveStrategy = Closure.DELEGATE_FIRST
       closure();
       trackDsl.trackDefinitions.each { tr ->
           if(!tr.business) {
               tr.business = default_business;
           }
           if(business.indexOf(tr.business)) {
               throw new RuntimeException(tr.business+" is not a valid business");
           }
           catalog.addTrackDefinition(tr)
       }
    }

    def setPlatforms(arr) {
        platforms = arr
        platforms.each {p ->
            catalog.addPlatform(p)
        }
    }

}
