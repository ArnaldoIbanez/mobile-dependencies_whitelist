package com.ml.melidata

import com.ml.melidata.TrackType


enum TrackType {
    View, Event, Email, Control

    public static TrackType fromString(String a){
        def result;
        switch (a.toUpperCase()) {
            case "VIEW": result = View; break;
            case "EVENT":result = Event; break;
            case "EMAIL": result = Email; break;
            case "CONTROL": result = Control; break;
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
    def String path = "";
    def event_data = [:]
    def TrackType type = TrackType.View
    def String business
    def String platform = "/"


    def Track(String path, type = TrackType.View, platform = "/", String business = null){
        this.path = path
        this.type = type
        this.platform = platform
        this.business = business;
    }

    public Track(Map map) {
        map?.each { k, v -> this[k] = v }
    }

    def addProperty(key, value){
        this.event_data.put(key, value)
        return this
    }

}
