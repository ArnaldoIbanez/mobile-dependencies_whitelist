package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class NamingLinter extends AbstractLinter {

    NamingLinter() {
        this.errorMessage = "Paths and property names should be in snake_case"
    }

    @Override
    boolean validateTrack(TrackDefinition trackDefinition) {
        return trackDefinition.path.equals(toSnakeCase(trackDefinition.path))
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> props) {
        return props.every { TrackDefinitionProperty prop ->
            prop.name.equals(toSnakeCase(prop.name))
        }
    }

    static String toSnakeCase(String text ) {
        return text.replaceAll( /([A-Z])/, /_$1/ ).toLowerCase().replaceAll( /^_/, '' )
    }
}
