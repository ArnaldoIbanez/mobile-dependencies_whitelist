package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition

class PropertiesQuantityLinter extends AbstractLinter {

    private int maxProps

    PropertiesQuantityLinter(int maximumProperties) {
        this.maxProps = maximumProperties
        this.errorMessage = "Track shouldn't have more than ${maxProps} properties."
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        def props = getPropertiesFromDefinition(trackDefinition)

        return props.size() <= maxProps
    }
}