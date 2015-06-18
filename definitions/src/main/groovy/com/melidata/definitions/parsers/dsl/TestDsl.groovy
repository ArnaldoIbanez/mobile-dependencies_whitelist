package com.melidata.definitions.parsers.dsl

import com.ml.melidata.Track
import com.ml.melidata.catalog.TrackSourceType

/**
 * Created by apetalas on 19/11/14.
 */

class TestDsl{

    List<Track> tracks = []
    String name
    List messages = []
    boolean status = true

    def propertyMissing(String name, value){
        this.tracks.last().event_data[name] = value
    }

    def methodMissing(String method, args) {

        def path = method;
        def trackArgs = ["path":path]
        for(def i =0; i < args.size() -1 ; i++) {
            trackArgs = trackArgs+args[i]
        }
        this.tracks.push(new Track(trackArgs))
        def closure = args[-1]
        closure()
    }

    def assertValid(def catalog, TrackSourceType sourceType = TrackSourceType.CLIENT){
        def result = null

        this.tracks.each { singleTrack ->
            result = catalog.validate(singleTrack, sourceType)
            status = status && result.status;
            messages = messages + result.menssages
        }

        return status
    }
}

