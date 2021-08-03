package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class PropertiesQuantityLinter extends LinterInterface {

    private int maxProps

    PropertiesQuantityLinter(int maximumProperties) {
        this.maxProps = maximumProperties
        this.errorMessage = "Track shouldn't have more than ${maxProps} properties."
    }

    @Override
    boolean validate(TrackDefinition definition) {
        Map<String, TrackDefinitionProperty> props = (Map<String,TrackDefinitionProperty>) definition.properties

        return props.size() <= maxProps
    }
}
