package com.melidata.definitions.parsers.dsl

import com.ml.melidata.Track

/**
 * Created by apetalas on 19/11/14.
 */

class TestDsl{

    def ArrayList<Track> tracks = []
    def String name
    def messages = []
    def status = true

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

    def assertValid(catalog){
        def result = null

        this.tracks.each { singleTrack ->
            result = catalog.validate(singleTrack)
            status = status && result.status
            if ( !result.status ) {
                messages = messages + [(singleTrack.path): result.messages]
            }
        }

        return status
    }
}

