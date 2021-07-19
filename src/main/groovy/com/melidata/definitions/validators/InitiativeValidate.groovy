package com.melidata.definitions.validators

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.utils.DslUtils
import com.ml.melidata.catalog.initiatives.InitiativeAPI
import com.ml.melidata.manager.CatalogMetrics
import groovyx.net.http.RESTClient

class InitiativeValidate {

    private static Set validPaths = ["/"]
    private static Set totalPaths = []
    private static double baseCoverage = 100
    private static Set coveragebleCatalogs = ['melidata']
    private static clientFuryWeb = new RESTClient('http://api.mercadolibre.com/')

    static setUp() {
        if(!InitiativeAPI.getInstance().initiatives) {
            InitiativeAPI.getInstance().run()
        }
    }

    static validateInitiative(String path, String initiativeId) {
        totalPaths << path
        if(initiativeId && (InitiativeAPI.getInstance().applications.values().any() { it == initiativeId }
                || InitiativeAPI.getInstance().initiatives.any() { Integer init -> init.toString() == initiativeId })) {
            validPaths << path
            return true
        } else {
            return false
        }
    }

    static boolean checkCoverage(Catalog catalog) {
        def isValidStatus = true

        if(DslUtils.getCatalogName() in coveragebleCatalogs) {
            def actualCoverage = (validPaths.size() / totalPaths.size()) * 100
            isValidStatus = actualCoverage >= baseCoverage
            if(!isValidStatus) {
                println "\n"+starBar()
                println("\tInitiatives coverage is too low!")
                println starBar()+"\n"

                println("\033[91m - Actual coverage: "+actualCoverage+"\033[0m")
                println("\033[92m - Intended coverage: "+baseCoverage+"\033[0m")
                println(totalPaths - validPaths)
            } else {
                println "\n"+starBar()
                println("\tGetting catalog usage report!")
                println starBar()+"\n"


                def localMetrics = getLocalMetrics(catalog)
                Map prodMetrics = getProdMetrics()

                Map<String, List<String>> newTracks = getAddedTracksByInitiative(localMetrics, prodMetrics)

                validateInitiativeCoverage(newTracks)

            }
        }

        validPaths = ["/"]
        totalPaths = []

        return isValidStatus
    }

    static validateInitiativeCoverage(Map<String, List<String>> newTracks) {
        newTracks.forEach {initiative_id, List<String> newMetrics ->
            Map<String, List<String>> catalogReport = clientFuryWeb.get(path: "/melidata/catalog/report/initiative/${initiative_id}").data

            List<String> newCatalogueds = catalogReport.uncatalogued.findAll {keyTracked ->
                newMetrics.any {keyDefined ->
                    keyTracked.contains(keyDefined)
                }
            }

            double newCoverage = (catalogReport.catalogued.size() + newMetrics.size()) * 100 / (catalogReport.catalogued.size() + newMetrics.size() + catalogReport.uncatalogued.size() - newCatalogueds.size() )

            println("\033[92m - Initiative ${initiative_id} tracking coverage is ${newCoverage.round(2)}%\033[0m")
        }
    }

    static getLocalMetrics(Catalog catalog) {
        def catalogMetric = new CatalogMetrics()
        catalogMetric.refreshCatalogedDefinitions(catalog)

        return catalogMetric
    }

    static Map getProdMetrics() {
        return clientFuryWeb.get(path: '/melidata/catalog/report').data
    }

    static Map<String, List<String>> getAddedTracksByInitiative(localMetrics, prodMetrics) {
        Map<String, List<String>> tracksByInitiative = [:]
        Set<String> trackKeys = prodMetrics.keySet()
        Map newTracks = localMetrics.allDefinitions.findAll {!trackKeys.contains(it.key) }
        newTracks.forEach {keyDefinition, metric ->
            metric.initiatives.forEach { initiative ->
                if(!tracksByInitiative[initiative]) {
                    tracksByInitiative[initiative] = []
                }

                tracksByInitiative[initiative].add(keyDefinition)
            }
        }

        return tracksByInitiative
    }

    def static starBar() {
        return "**************************************************"
    }
}
