package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition

class ObligatoryPropertiesLinter extends AbstractLinter {

    List<String> requiredProperties = []

    ObligatoryPropertiesLinter(List<String> properties) {
        this.errorMessage = "Tracks should have description, requirement, and type defined"
        this.requiredProperties = properties
    }

    @Override
    boolean validate(TrackDefinition definition) {
        def props = getPropertiesFromDefinition(definition)

        return props.every {propertyName, propertyDefinition ->
            requiredProperties in propertyDefinition.properties.keySet()
        }
    }
}
