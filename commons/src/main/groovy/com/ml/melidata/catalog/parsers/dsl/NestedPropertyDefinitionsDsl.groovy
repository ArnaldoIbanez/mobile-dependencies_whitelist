package com.ml.melidata.catalog.parsers.dsl

import com.ml.melidata.catalog.TrackDefinitionProperty

/**
 * Created by geisbruch on 11/17/14.
 */
class NestedPropertyDefinitionDsl {
    Map<String,TrackDefinitionProperty> properties = [:]

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

    def object (Closure closure) {
        NestedPropertyDefinitionDsl nestedPropertyDefinitionDsl = new NestedPropertyDefinitionDsl()
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.delegate = nestedPropertyDefinitionDsl
        closure()
        nestedPropertyDefinitionDsl.properties
    }
}
