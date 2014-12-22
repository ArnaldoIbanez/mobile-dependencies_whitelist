package com.ml.melidata

import com.ml.melidata.TrackType


enum TrackType {
    View, Event, Email

    public static TrackType fromString(String a){
        def result;
        switch (a.toUpperCase()) {
            case "VIEW": result = View; break;
            case "EVENT":result = Event; break;
            case "EMAIL": result = Email; break;
        }
        return result;
    }
}
/**
 * Created by geisbruch on 11/10/14.
 */
class Track {

    def id
    def timestamp
    def path = "";
    def event_data = [:]
    def TrackType type = TrackType.View
    def String platform = "/"


    def Track(String path, type = TrackType.View, platform = "/"){
        this.path = path
        this.type = type
        this.platform = platform
    }

    public Track(Map map) {
        map?.each { k, v -> this[k] = v }
    }

    def addProperty(key, value){
        this.event_data.put(key, value)
        return this
    }

}
