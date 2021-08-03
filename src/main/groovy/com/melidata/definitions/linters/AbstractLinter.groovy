package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

abstract class AbstractLinter {

    String errorMessage

    boolean passValidation(TrackDefinition definition) {
        if(!validateTrack(definition)) {
            printFails("Track ${definition.path} with platform ${definition.platform} " +
                    "didn't pass validation => ${errorMessage}")

            return false
        }

        return true
    }

    List<TrackDefinitionProperty> getPropertiesFromDefinition(TrackDefinition definition) {
        return ((Map<String,TrackDefinitionProperty>) definition.properties).values().toList()
    }

    abstract boolean validateTrack(TrackDefinition definition)

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
