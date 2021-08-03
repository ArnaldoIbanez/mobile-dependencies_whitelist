package com.melidata.definitions.linters

import com.ml.melidata.catalog.ArrayListProperty
import com.ml.melidata.catalog.MapProperty
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

abstract class AbstractLinter {

    String errorMessage

    boolean passValidation(TrackDefinition definition) {
        List<TrackDefinitionProperty> properties = getPropertiesFromDefinition(definition)
        if(!validate(properties)) {
            printFails("Track ${definition.path} with platform ${definition.platform} " +
                    "didn't pass validation => ${errorMessage}")

            return false
        } else {
            def allNestedStructures = properties.findAll{it.type instanceof MapProperty}.toList()

            if(!allNestedStructures.every {
                properties = ((MapProperty)it.type).nestedProperties.values().toList()
                validate(properties)
            }) {
                printFails("Track ${definition.path} with platform ${definition.platform} " +
                        "didn't pass validation on nested structure => ${errorMessage}")

                return false
            }
        }

        return true
    }

    List<TrackDefinitionProperty> getPropertiesFromDefinition(TrackDefinition definition) {
        return ((Map<String,TrackDefinitionProperty>) definition.properties).values().toList()
    }

    abstract boolean validate(List<TrackDefinitionProperty> properties)

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
