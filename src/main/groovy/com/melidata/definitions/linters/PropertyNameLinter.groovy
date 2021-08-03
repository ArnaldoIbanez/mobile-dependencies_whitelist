package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition

class PropertyNameLinter extends AbstractLinter {

    PropertyNameLinter() {
        this.errorMessage = "Paths and property names should be in snake_case"
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        return trackDefinition.path.equals(toSnakeCase(trackDefinition.path))
    }

    static String toSnakeCase( String text ) {
        return text.replaceAll( /([A-Z])/, /_$1/ ).toLowerCase().replaceAll( /^_/, '' )
    }
}
