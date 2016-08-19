package com.melidata.definitions.parsers.dsl

import com.ml.melidata.Track

/**
 * Created by apetalas on 19/11/14.
 */

class TestDsl{

    def ArrayList<Track> tracks = []
    def String name
    def String defaultBusiness

    //prefix fields with _ to avoid conflict with test properties definition
    def _messages = []
    def _status = true

    def propertyMissing(String name, value){
        this.tracks.last().event_data[name] = value
    }

    def methodMissing(String method, args) {

        def path = method;
        def trackArgs = ["path":path]
        for(def i =0; i < args.size() -1 ; i++) {
            trackArgs = trackArgs+args[i]
        }
        def track = new Track(trackArgs)
        if (!track.business) {
            track.business = defaultBusiness
        }
        this.tracks.push(track)
        def closure = args[-1]
        closure()
    }

    def assertValid(catalog){
        def result = null

        this.tracks.each { singleTrack ->
            catalog.catalogCoverage.addTestRun(singleTrack.path,singleTrack.business)
            result = catalog.validate(singleTrack)
            _status = _status && result.status
            if ( !result.status ) {
                _messages = _messages + [(singleTrack.path): result.messages]
            }
        }

        return _status
    }

}

