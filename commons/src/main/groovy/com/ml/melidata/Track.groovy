package com.ml.melidata

/**
 * Created by geisbruch on 11/10/14.
 */
class Track {

    def id
    def timestamp
    def String path = "";
    def event_data = [:]
    def TrackType type = TrackType.View
    def String business
    def String platform = "/"
    def String version = ""

    def Track(String path, type = TrackType.View, platform = "/", String business = null, String version = null){
        this.path = path
        this.type = type
        this.platform = platform
        this.business = business
        this.version = version
    }

    public Track(Map map) {
        map?.each { k, v -> this[k] = v }
    }

    def addProperty(key, value){
        this.event_data.put(key, value)
        return this
    }

}
