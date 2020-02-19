package com.ml.melidata.catalog

import com.ml.melidata.Track
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.tree.TrackValidationResponse

/**
 * Created by geisbruch on 11/10/14.
 */



class TrackDefinition {

    String path = ""
    String platform = "/"
    String business

    String initiative
    String defaultInitiative
    Map applicationForPlatform
    String application

    Map<String,TrackDefinitionProperty> properties = [:]
    TrackType type
    Boolean parentPropertiesInherited = true

    Boolean isAbstract

    TrackDefinition(String path) {
        this.path = path
    }

    TrackDefinition(String path, TrackType type, String platform) {
        this.path = path
        this.type = type
        this.platform = platform
    }

    TrackDefinition(String path, String initiative, String defaultInitiative,
                    String application, Map applicationForPlatform,TrackType type = TrackType.View,
                    String platform = "/", String business = null, Boolean parentPropertiesInherited = true,
                    Boolean isAbstract = false) {
        this.path = path
        this.initiative = initiative
        this.defaultInitiative = defaultInitiative
        this.platform = platform
        this.type = type
        this.business = business
        this.parentPropertiesInherited = parentPropertiesInherited
        this.isAbstract = isAbstract
        this.application = application
        this.applicationForPlatform = applicationForPlatform
    }

    public TrackDefinition(Map map) {
        map?.each { k, v -> this[k] = v }
    }

    def addProperty(TrackDefinitionProperty p) {
        this.properties.put(p.name, p)
        this
    }

    def addProperty(Object[] args) {
        this.addProperty(new TrackDefinitionProperty(args[0]))
        this
    }

    def getDefinitionProperty(String name){
        return this.properties.get(name)
    }

    def getProperties() {
        return this.properties;
    }

    /**
     * Validate the track event_data for track parameter
     * no validate the platform and path because that catalogs responsibility
     * By Default: ServerSideValidation = false
     * */
    def TrackValidationResponse validate(Track t) {
        return validate(t, false)
    }

    /**
     * Validate the track event_data for track parameter
     * no validate the platform and path because that catalogs responsibility
     * */
    def TrackValidationResponse validate(Track t, boolean serverSideValidation) {
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
            if(trackValueForThisProperty == null){
                if(isPropertyRequired(v, serverSideValidation)) {
                    response.addValidation(false, "Property '${key}'" +
                            "${v.description?'('+v.description+')':''} is required")
                }
            } else {
                v.validate(response, key,trackValueForThisProperty)
            }
        }

        return response
    }

    def isPropertyRequired(TrackDefinitionProperty p, Boolean serverSideValidation) {
        return p.required && (!p.serverSide || serverSideValidation)
    }

    String getTrackInitiative() {
        return this.initiative?: this.defaultInitiative
    }

    String getTrackApplication(String platform) {
        return this.application?: getDefaultApplication(platform)
    }

    String getDefaultApplication(String trackPlatform) {
        def returnableApplication

        if(!applicationForPlatform) return null

        def iterablePlatform = trackPlatform
        List segments = trackPlatform.split("/") as List

        if (segments.size() == 0) {
            segments[0] = "/"
        }

        segments.reverseEach { s ->
            if (applicationForPlatform.get(iterablePlatform)) {
                returnableApplication = applicationForPlatform.get(iterablePlatform)
                return true
            } else {
                iterablePlatform = iterablePlatform - ("/" + s)
                if (iterablePlatform == "") {
                    iterablePlatform = "/"
                }

                return false
            }
        }

        return returnableApplication
    }
}


