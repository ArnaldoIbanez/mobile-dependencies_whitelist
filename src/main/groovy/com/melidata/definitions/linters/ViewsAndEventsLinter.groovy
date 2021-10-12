package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class ViewsAndEventsLinter extends AbstractLinter {

    List<String> nonDeclarativeSections

    ViewsAndEventsLinter(List<String> nonDeclarativeSections) {
        this.nonDeclarativeSections = nonDeclarativeSections
        this.errorMessage = "Remember that melidata follows the convention /view_name/event_detail " +
                "avoid using any of ${nonDeclarativeSections}."
    }

    @Override
    boolean validateTrack(TrackDefinition definition) {
        if(definition.path == '/') return true

        String lastSection = definition.path.split('/').last()
        return !(lastSection in nonDeclarativeSections)
    }

    @Override
    List<String> validatePropertySet(List<TrackDefinitionProperty> definition) {
        return []
    }
}
