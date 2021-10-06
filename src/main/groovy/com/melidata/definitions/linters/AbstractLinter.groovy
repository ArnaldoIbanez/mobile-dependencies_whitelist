package com.melidata.definitions.linters

import com.ml.melidata.catalog.MapProperty
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

abstract class AbstractLinter {

    String errorMessage

    boolean passValidation(TrackDefinition definition) {
        return validateTrackDefinition(definition) && validateProperties(definition)
    }

    boolean validateTrackDefinition(TrackDefinition definition) {
        if(!validateTrack(definition)) {
            printFails("Track ${definition.path} with platform ${definition.platform} " +
                    "didn't pass validation => ${errorMessage}")

            return false
        }

        return true
    }

    boolean validateProperties(TrackDefinition definition) {
        List<TrackDefinitionProperty> invalidProps = getPropertiesAnalysis(getPropertiesFromDefinition(definition))
        if(!invalidProps.isEmpty()) {
            printFails("Track ${definition.path} with platform ${definition.platform} has invalid properties.")
            invalidProps.forEach {prop  ->
                print("\033[91m  *  Porperty ${prop.name}: ${errorMessage}\033[0m\n")
            }

            return false
        }

        return true
    }

    List<String> getPropertiesAnalysis(List<TrackDefinitionProperty> definitionsProperties) {
        List<String> invalidProps = validatePropertySet(definitionsProperties)

        def allNestedStructures = definitionsProperties.findAll{it.type instanceof MapProperty}.toList()

        allNestedStructures.every {
            def nestedProperties = ((MapProperty)it.type).nestedProperties != null ? ((MapProperty)it.type).nestedProperties.values().toList() : new ArrayList<TrackDefinitionProperty>()
            invalidProps.addAll(validatePropertySet(nestedProperties))
        }

        return invalidProps
    }

    List<TrackDefinitionProperty> getPropertiesFromDefinition(TrackDefinition definition) {
        return ((Map<String,TrackDefinitionProperty>) definition.properties).values().toList()
    }

    abstract boolean validateTrack(TrackDefinition definition)
    abstract List<TrackDefinitionProperty> validatePropertySet(List<TrackDefinitionProperty> properties)

    private void printFails(message) {
        print("\033[91m  -  "+message+"\033[0m\n")
    }
}
