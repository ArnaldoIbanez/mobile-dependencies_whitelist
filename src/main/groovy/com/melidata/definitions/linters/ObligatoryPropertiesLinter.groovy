package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class ObligatoryPropertiesLinter extends AbstractLinter {

    List<String> requiredProperties = []

    ObligatoryPropertiesLinter(List<String> properties) {
        this.requiredProperties = properties
        this.errorMessage = "Tracks should have ${requiredProperties} at all their properties"
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        return true
    }

    @Override
    List<String> validatePropertySet(List<TrackDefinitionProperty> properties) {
        return properties.findAll {propertyDefinition ->
            !requiredProperties.every {requiredProperty ->
                propertyDefinition.properties[requiredProperty] != null
            }
        }
    }
}
