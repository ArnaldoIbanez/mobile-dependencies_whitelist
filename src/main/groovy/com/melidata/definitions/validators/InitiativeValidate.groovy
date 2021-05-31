package com.melidata.definitions.validators

import com.ml.melidata.catalog.utils.DslUtils
import com.ml.melidata.catalog.initiatives.InitiativeAPI

class InitiativeValidate {

    private static Set validPaths = ["/"]
    private static Set totalPaths = []
    private static double baseCoverage = 100
    private static Set coveragebleCatalogs = ['melidata']

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

    static boolean checkCoverage() {
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
            }
        }

        validPaths = ["/"]
        totalPaths = []

        return isValidStatus
    }

    def static starBar() {
        return "**************************************************"
    }
}
