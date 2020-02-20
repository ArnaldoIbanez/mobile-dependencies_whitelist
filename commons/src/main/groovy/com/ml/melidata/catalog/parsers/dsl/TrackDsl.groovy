package com.ml.melidata.catalog.parsers.dsl

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

/**
 * Created by geisbruch on 11/17/14.
 */
class TrackDsl {

    Map<String, TrackDefinitionProperty> propertyDefinitions = [:]
    Map<String, Collection<TrackDefinitionProperty>> propertyDefinitionGroups = [:]

    List<TrackDefinition> trackDefinitions = [];

    Map applicationForPlatform
    String initiative

    def static tracks(Closure closure) {
        TrackDsl dsl = new TrackDsl()
        closure.delegate = dsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        return dsl.trackDefinitions
    }


    def propertyDefinitions (closure) {
        propertyDefinitions.putAll(retrievePropertyDefinitions(closure));
    }

    def propertyGroups (closure) {
        PropertyGroupDefinitionDsl propertyGroupDefinitionDsl = new PropertyGroupDefinitionDsl(propertyDefinitions: propertyDefinitions)
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.delegate = propertyGroupDefinitionDsl
        closure()
        propertyDefinitionGroups.putAll(propertyGroupDefinitionDsl.propertyDefinitionGroups)
    }

    def methodMissing(String method, args) {
        def path = method;

        def trackArgs = ["path":path]
        for(def i =0; i < args.size() -1 ; i++) {
            trackArgs = trackArgs+args[i]
        }
        TrackDefinition trackDefinition = new TrackDefinition(trackArgs)
        trackDefinition.setApplicationForPlatform(applicationForPlatform)
        trackDefinition.setDefaultInitiative(initiative)

        def closure = args[-1]

        def properties = objectSchemaDefinitions(closure)
        trackDefinition.properties.putAll(properties);
        trackDefinitions.add(trackDefinition)
    }

    def retrievePropertyDefinitions (closure, providedPropertyDefinitionGroups = [:]) {
        PropertyDefinitionDsl propertyDefinitionDsl = new PropertyDefinitionDsl(providedPropertyDefinitionGroups: providedPropertyDefinitionGroups);
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.delegate = propertyDefinitionDsl
        closure()
        propertyDefinitionDsl.properties
    }

    def objectSchemaDefinitions (closure) {
        retrievePropertyDefinitions(closure, propertyDefinitionGroups)
    }

}
