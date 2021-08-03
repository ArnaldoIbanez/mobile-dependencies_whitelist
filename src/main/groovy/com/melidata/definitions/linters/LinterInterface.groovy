package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition

abstract class LinterInterface {

    String errorMessage

    boolean passValidation(TrackDefinition definition) {
        if(!validate(definition)) {
            printFails("Track ${definition.path} with platform ${definition.platform} " +
                    "didn't pass validation => ${errorMessage}")

            return false
        }

        return true
    }

    abstract boolean validate(TrackDefinition definition)

    def printFails(String message) {
        println "\n"+starBar()
        println("\tFails Details")
        println starBar()
        print("\033[91m  -  "+message+"\033[0m\n")
        println starBar()
    }

    def starBar() {
        return "*************************************"
    }
}
