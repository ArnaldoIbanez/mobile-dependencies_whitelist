package com.ml.melidata.catalog

import com.ml.melidata.Track
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.tree.TrackValidationResponse

/**
 * Created by geisbruch on 11/10/14.
 */



class TrackDefinition {

    def String path = ""
    def String platform;
    def Map<String,TrackDefinitionProperty> properties = [:];
    def TrackType type;

    def TrackDefinition(String path, TrackType type = TrackType.View,
                        String platform = "/") {
        this.path = path;
        this.platform = platform;
        this.type = type;
    }

    public TrackDefinition(Map map) {
        map?.each { k, v -> this[k] = v }
    }


    def addProperty(TrackDefinitionProperty p) {
        this.properties.put(p.name, p);
        this
    }

    def addProperty(Object[] args) {
        this.addProperty(new TrackDefinitionProperty(args[0]))
        this
    }

    def getDefinitionProperty(String name){
        return this.properties.get(name)
    }


    /**
     * Validate the track event_data for track parameter
     * no validate the platform and path because that catalogs responsibility
     * */
    def TrackValidationResponse validate(Track t) {
        def response = new TrackValidationResponse()

        // are all the track's event_data in my definition?:
        t?.event_data?.each { property, value ->
            if(!properties.get(property))
                response.addValidation(false, "Property '${property}' is not cataloged" +
                        " (you can't add properties to a track that are not declared in the catalog)")
        }

        // someone of my required event_data miss? and what about the valid values?:
        properties?.each { key , v ->

            def trackValueForThisProperty = t.event_data?.get(v.name)
            if(v.required && trackValueForThisProperty == null) {
                response.addValidation(false, "Property '${key}'" +
                        "${v.description?'('+v.description+')':''} is required")
            } else {
                v.validate(response, key,trackValueForThisProperty)
            }
        }

        return response
    }
}


