package com.melidata.definitions.validate

import com.ml.melidata.catalog.initiatives.InitiativeAPI
import com.ml.melidata.catalog.model.ApplicationModel

class InitiativeValidate {

    private static Set validPaths = []
    private static Set totalPaths = []
    private static double baseCoverage = 95


    static validateInitiative(String path, String initiativeId) {
        totalPaths << path

        if(initiativeId && InitiativeAPI.getInstance().applications.any() { ApplicationModel init -> init.getInitiativeId() == initiativeId }) {
            validPaths << path
            return true
        } else {
            return false
        }
    }

    static boolean checkCoverage() {
        def actualCoverage = (validPaths.size() / totalPaths.size()) * 100
        def isValidStatus = actualCoverage > baseCoverage
        if(!isValidStatus) {
            println "\n"+starBar()
            println("\tInitiatives coverage is too low!")
            println starBar()+"\n"

            println("\033[91m - Actual coverage: "+actualCoverage+"\033[0m")
            println("\033[92m - Intended coverage: "+baseCoverage+"\033[0m")
        }

        return isValidStatus
    }

    def static starBar() {
        return "**************************************************"
    }
}
