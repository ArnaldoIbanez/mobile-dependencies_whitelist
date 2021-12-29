package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class PropertiesQuantityLinter extends AbstractLinter {

    private int maxProps
    private List allowList = ["/pdp", "/vip", "/search", "/checkout", "/cart/checkout"]

    PropertiesQuantityLinter(int maximumProperties) {
        this.maxProps = maximumProperties
        this.errorMessage = "Track has a lot of lose properties (${maxProps}). Make sure you only track what you need. Create abstractions grouping certain properties as if you were modeling a class."
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        if(allowList.any {trackDefinition.path.startsWith(it)}) return true
        return trackDefinition.properties.size() <= maxProps
    }

    @Override
    List<String> validatePropertySet(List<TrackDefinitionProperty> props) {
        return []
    }
}