package com.ml.melidata.catalog.parsers.dsl

import com.ml.melidata.catalog.TrackDefinitionProperty


class PropertyGroupDefinitionDsl {
    def Map<String, TrackDefinitionProperty> propertyDefinitions = [:]
    def Map<String, Collection<TrackDefinitionProperty>> propertyDefinitionGroups = [:]

    def methodMissing(String method, args) {
        def groupName = method
        def proposedPropertyDefinitions = args

        propertyDefinitionGroups[groupName] = proposedPropertyDefinitions
    }

    def propertyMissing (name, value) {
        propertyDefinitions[name]
    }
}
