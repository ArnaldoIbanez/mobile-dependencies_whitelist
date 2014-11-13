package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.TrackValidationResponse

/**
 * Created by geisbruch on 11/10/14.
 */


enum TrackType {
    View, Event, Email
}

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
     * Validate the track properties for track parameter
     * no validate the type, platform and path because that catalogs responsibility
     * */
    def TrackValidationResponse validate(Track t) {
        def response = new TrackValidationResponse()

        // are all the track's properties in my definition?:
        t.properties.each { property, value ->
            if(!properties.get(property))
                response.addValidation(false, "Property ${property} is not cataloged")
        }

        // someone of my required properties miss? and what about the valid values?:
        properties.each { key , v ->

            def trackValueForThisProperty = t.properties.get(v.name)
            if(v.required && trackValueForThisProperty == null)
                response.addValidation(false, "Property ${key} (${v.description}) is required")

            if(v.values && v.values.size() > 0 && !v.values.find{va -> va.equals(trackValueForThisProperty)})
                response.addValidation(false, "Property ${key} (${v.description}) has invalid value '${trackValueForThisProperty}'. (possible values: ${v.values})")
        }

        return response
    }
}


