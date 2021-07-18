package com.melidata.definitions.validators

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.utils.DslUtils
import com.ml.melidata.catalog.initiatives.InitiativeAPI
import com.ml.melidata.manager.CatalogMetrics
import com.ml.melidata.manager.helpers.TrackMetricDTO
import groovy.json.JsonBuilder
import groovyx.net.http.RESTClient

class InitiativeValidate {

    private static Set validPaths = ["/"]
    private static Set totalPaths = []
    private static double baseCoverage = 100
    private static Set coveragebleCatalogs = ['melidata']

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
                println("\tGetting catalog metrics report!")

                def localMetrics = getLocalMetrics(catalog)
                Map catalogReport = getProdMetrics()

                Set<String> trackKeys = catalogReport.keySet()
                Map<String, TrackMetricDTO> filteredTracks = localMetrics.allDefinitions.findAll {!trackKeys.contains(it.key) }


                println("You are adding ${filteredTracks.size()} \n")

                println starBar()+"\n"
            }
        }

        validPaths = ["/"]
        totalPaths = []

        return isValidStatus
    }

    static getLocalMetrics(Catalog catalog) {
        def catalogMetric = new CatalogMetrics()
        catalogMetric.refreshCatalogedDefinitions(catalog)

        return catalogMetric
    }

    static Map getProdMetrics() {
        def clientFuryWeb = new RESTClient('http://api.mercadolibre.com/')
        return clientFuryWeb.get(path: '/melidata/catalog/report').data
    }

    def static starBar() {
        return "**************************************************"
    }
}
