package com.ml.melidata.catalog
/**
 * Created by geisbruch on 11/10/14.
 */
class Track {

    def path = "";
    def Map<String, TrackDefinitionProperty> properties = [:]
    def TrackType trackType = TrackType.View
    def String platform = "/"


    def Track(path, trackType = TrackType.View, platform = "/"){
        this.path = path
        this.trackType = trackType
        this.platform = platform
    }



    def addProperty(key, value){
        this.properties.put(key, value)
        return this
    }

    def addProperties(Object[] args){
        this.properties.putAll(args[0])
        return this
    }
}
