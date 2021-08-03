package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition

class ObligatoryPropertiesLinter extends AbstractLinter {

    List<String> requiredProperties = []

    ObligatoryPropertiesLinter(List<String> properties) {
        this.requiredProperties = properties
        this.errorMessage = "Tracks should have ${requiredProperties} at all their properties"
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        def props = getPropertiesFromDefinition(trackDefinition)
        return props.every {propertyDefinition ->
            requiredProperties.every {requiredProperty ->
                propertyDefinition.properties[requiredProperty] != null
            }
        }
    }
}
