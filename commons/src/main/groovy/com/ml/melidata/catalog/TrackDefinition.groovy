package com.ml.melidata.catalog
/**
 * Created by geisbruch on 11/10/14.
 */

enum Platform {
    Desktop, Mobile, all
}

enum SubPlatform {
    Android, IOS, all
}

enum TrackType {
    View, Event, Email
}

class TrackDefinition {

    def String path = ""
    def Platform platform;
    def SubPlatform subPlatform;
    def Map<String,TrackDefinitionProperty> properties = [:];
    def TrackType type;

    def TrackDefinition(String path, TrackType type = TrackType.View,
                        Platform platform = Platform.all, SubPlatform subPlatform = SubPlatform.all) {
        this.path = path;
        this.platform = platform;
        this.subPlatform = subPlatform;
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
     * Obsolete
     * */
    def Boolean validate(Track t) {
        def comments = ""
        def status = true;

        t.properties.each { property, value ->
            def p = properties.get(property);
            if(!p) {
                status = false;
                comments+="Property ${property} is not cataloged\n";
            }
        }
        properties.each { k , v ->

            def trackValueForThisProperty = t.properties.get(v.name)
            if(v.required && trackValueForThisProperty == null) {
                status = false;
                comments+="Property ${k} is required\n"
            }

            if(v.values.size() > 0 && !v.values.find{va -> va.equals(trackValueForThisProperty)}) {
                status = false;
                comments += "Property ${k} has invalid value '${trackValueForThisProperty}'. (possible values: ${v.values})"
            }
        }

        println(comments);
        return status
    }

    /**
     * Validate the track properties for track parameter
     * no validate the type, platform and path because that catalogs responsibility
     * */
    def TrackValidationResponse validateTrack(Track t) {
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


            v.validate(response, trackValueForThisProperty)

            /*if(v.values && v.values.size() > 0 && !v.values.find{va -> va.equals(trackValueForThisProperty)})
                response.addValidation(false, "Property ${key} (${v.description}) has invalid value '${trackValueForThisProperty}'. (possible values: ${v.values})")
            */
        }

        return response
    }
}

class TrackValidationResponse {

    boolean status = true
    ArrayList<String> menssages

    def TrackValidationResponse(){
        menssages = new ArrayList<String>()
    }

    def addValidation(boolean status, String message){
        // if all the status are true -> the result is true!
        // if one is false -> the result es false :(
        this.status = this.status && status
        this.menssages.push(message)
    }
}
