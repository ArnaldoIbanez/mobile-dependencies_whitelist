package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition

class ObligatoryPropertiesLinter extends AbstractLinter {

    ObligatoryPropertiesLinter() {
        this.errorMessage = "Tracks should have description, requirement, and type defined"
    }

    @Override
    boolean validate(TrackDefinition definition) {
        def props = getPropertiesFromDefinition(definition)

        return props.every {propertyName, propertyDefinition ->
            propertyDefinition.description && propertyDefinition.required != null && propertyDefinition.type
        }
    }
}
