package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class PropertiesQuantityLinter extends AbstractLinter {

    private int maxProps

    PropertiesQuantityLinter(int maximumProperties) {
        this.maxProps = maximumProperties
        this.errorMessage = "Track shouldn't have more than ${maxProps} properties."
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        return true
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> props) {
        return props.size() <= maxProps
    }
}