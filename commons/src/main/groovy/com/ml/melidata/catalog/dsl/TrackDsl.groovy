package com.ml.melidata.catalog.dsl

import com.ml.melidata.catalog.TrackDefinition

/**
 * Created by geisbruch on 11/17/14.
 */
class TrackDsl {

    def List<TrackDefinition> trackDefinitions = [];


    def methodMissing(String method, args) {
        def path = method;

        def trackArgs = ["path":path]
        for(def i =0; i < args.size() -1 ; i++) {
            trackArgs = trackArgs+args[i]
        }
        TrackDefinition trackDefinition = new TrackDefinition(trackArgs)
        printf(method)
        def closure = args[-1]
        PropertyDefinitionDsl propertyDefinitionDsl = new PropertyDefinitionDsl();
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.delegate = propertyDefinitionDsl
        closure()
        trackDefinition.properties.putAll(propertyDefinitionDsl.properties);
        trackDefinitions.add(trackDefinition)
    }

}
