package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class MinimumRequiredTrueLinter extends AbstractLinter {

    int minAmountToEnableLint = 4

    MinimumRequiredTrueLinter(int minAmountToEnableLint) {
        this.minAmountToEnableLint = minAmountToEnableLint
        this.errorMessage = "Tracks should have some required:true"
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        List<TrackDefinitionProperty> properties = getPropertiesFromDefinition(trackDefinition)
        def isValid = true

        if(properties.size() > minAmountToEnableLint) {
            isValid = properties.any {propertyDefinition ->
                propertyDefinition.required
            }
        }

        return isValid
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> properties) {
        return true
    }
}
