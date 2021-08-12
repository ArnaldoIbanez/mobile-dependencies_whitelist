package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class NamingLinter extends AbstractLinter {

    NamingLinter() {
        this.errorMessage = "Paths and property names should be in snake_case. " +
                "Additionaly paths shouldnt end on / and MUST start with / "
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        if(trackDefinition.path == '/') return true

        return shouldBeSnakeCase(trackDefinition.path) && !trackDefinition.path.endsWith("/") &&
                trackDefinition.path.startsWith("/")
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> props) {
        return true
    }

    static boolean shouldBeSnakeCase(String text) {
        return text == text
                .replaceAll( /([A-Z])/, /_$1/ )
                .toLowerCase()
                .replaceAll( /^_/, '' )
    }
}
