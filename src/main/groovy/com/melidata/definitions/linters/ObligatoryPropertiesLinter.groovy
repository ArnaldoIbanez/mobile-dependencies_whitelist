package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class ObligatoryPropertiesLinter extends AbstractLinter {

    List<String> requiredProperties = []

    ObligatoryPropertiesLinter(List<String> properties) {
        this.requiredProperties = properties
        this.errorMessage = "Tracks should have ${requiredProperties} at all their properties and some required:true"
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        return true
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> properties) {
        def isValid = properties.every {propertyDefinition ->
            requiredProperties.every {requiredProperty ->
                propertyDefinition.properties[requiredProperty] != null
            }
        }

        if(properties.size() > 4) {
            isValid = isValid && properties.any {propertyDefinition ->
                propertyDefinition.required
            }
        }

        return isValid
    }
}
