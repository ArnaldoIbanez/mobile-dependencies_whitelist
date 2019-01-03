package com.ml.melidata.catalog.parsers.dsl

import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.TypeValidator
import com.ml.melidata.catalog.Validator

/**
 * Created by geisbruch on 11/17/14.
 */
class PropertyDefinitionDsl {
    def Map<String, Collection<TrackDefinitionProperty>> providedPropertyDefinitionGroups = [:]
    def Map<String,TrackDefinitionProperty> properties = [:];

    def methodMissing(String method, args) {
        def propName = method
        def propArgs = [name:propName]
        if(args.size() > 0)
            args[0].each { k,v ->
                propArgs[k] = v
            }

        TrackDefinitionProperty prop = new TrackDefinitionProperty(propArgs)
        properties.put(propName,prop)
    }

    def propertyMissing (name, value) {
        providedPropertyDefinitionGroups[name]?.each { trackDefinitionProperty ->
            properties.put(trackDefinitionProperty.name, trackDefinitionProperty)
        }
    }

}
