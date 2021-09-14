package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyTypeValidator
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class DeprecatedTypesLinter extends AbstractLinter {

    List<PropertyTypeValidator> deprecatedTypes

    DeprecatedTypesLinter(List<PropertyTypeValidator> deprecatedTypes) {
        this.deprecatedTypes = deprecatedTypes
        this.errorMessage = "${deprecatedTypes} are deprecated types. Please define their internal schema"
    }

    @Override
    boolean validateTrack(TrackDefinition definition) {
        return true
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> definition) {
        return definition.every {
            !(it.type in deprecatedTypes)
        }
    }
}
