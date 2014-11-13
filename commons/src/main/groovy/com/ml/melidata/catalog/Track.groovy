package com.ml.melidata.catalog
/**
 * Created by geisbruch on 11/10/14.
 */
class Track {

    def path = "";
    def properties = [:]
    def TrackType trackType = TrackType.View
    def String platform = "/"


    // tiene sentido hacer un create method por convinacion type and platform?? depende: que tanto puede crecer?
    public static Track createTrack(String path, TrackType type, String platform){
        return new Track(path:path, trackType: type, platform: platform)
    }

    def addProperties(Object[] args){
        this.properties.putAll(args[0])
        return this
    }
}
