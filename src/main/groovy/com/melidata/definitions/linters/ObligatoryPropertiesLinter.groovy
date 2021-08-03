package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition

class ObligatoryPropertiesLinter extends AbstractLinter {

    List<String> requiredProperties = []

    ObligatoryPropertiesLinter(List<String> properties) {
        this.requiredProperties = properties
        this.errorMessage = "Tracks should have ${requiredProperties} at all their properties"
    }

    @Override
    boolean validate(TrackDefinition definition) {
        def props = getPropertiesFromDefinition(definition)

        return props.every {propertyName, propertyDefinition ->
            requiredProperties.every {requiredProperty ->
                propertyDefinition.properties[requiredProperty] != null
            }
        }
    }
}
