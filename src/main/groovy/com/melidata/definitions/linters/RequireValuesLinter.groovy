package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class RequireValuesLinter extends AbstractLinter {

    List<String> candidateProperties

    RequireValuesLinter(List<String> candidateProperties) {
        this.candidateProperties = candidateProperties
    }

    @Override
    boolean validateTrack(TrackDefinition definition) {
        return true
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> properties) {
        return properties.every {property ->
            if(candidateProperties.any {candidateProperty -> property.name.contains(candidateProperty)}) {
                return property.values && !property.values.isEmpty()
            }

            return true
        }
    }
}
