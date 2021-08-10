package com.melidata.definitions.linters

import com.ml.melidata.catalog.MapProperty
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

abstract class AbstractLinter {

    String errorMessage

    boolean passValidation(TrackDefinition definition) {
        if(!validateTrack(definition) || !validateProperties(definition)) {
            printFails("Track ${definition.path} with platform ${definition.platform} " +
                    "didn't pass validation => ${errorMessage}")

            return false
        }

        return true
    }

    abstract boolean validateTrack(TrackDefinition definition)
    abstract boolean validatePropertySet(List<TrackDefinitionProperty> properties)

    def printFails(String message) {
        print("\033[91m  -  "+message+"\033[0m\n")
    }


    List<TrackDefinitionProperty> getPropertiesFromDefinition(TrackDefinition definition) {
        return ((Map<String,TrackDefinitionProperty>) definition.properties).values().toList()
    }

    boolean validateProperties(TrackDefinition trackDefinition) {
        def definitionsProperties = getPropertiesFromDefinition(trackDefinition)
        def isValid = validatePropertySet(definitionsProperties)

        def allNestedStructures = definitionsProperties.findAll{it.type instanceof MapProperty}.toList()

        isValid = isValid && allNestedStructures.every {
            def nestedProperties = ((MapProperty)it.type).nestedProperties.values().toList()
            return validatePropertySet(nestedProperties)
        }

        return isValid
    }

}
