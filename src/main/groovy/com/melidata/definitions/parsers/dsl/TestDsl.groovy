package com.melidata.definitions.parsers.dsl

import com.melidata.definitions.validate.InitiativeValidate
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
    boolean _status = true

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

        this.tracks.each { singleTrack ->
            catalog.catalogCoverage.addTestRun(singleTrack.path,singleTrack.business)

            validateEventData(catalog, singleTrack)
            validateInitiative(catalog, singleTrack)
        }

        return _status
    }

    def validateEventData(catalog, singleTrack) {
        def eventDataValidation = catalog.validate(singleTrack)
        _status = _status && eventDataValidation.status

        if ( !eventDataValidation.status ) {
            _messages = _messages + [(singleTrack.path): eventDataValidation.messages]
        }
    }

    private void validateInitiative(catalog, singleTrack) {
        def trackInitiative = catalog.getTrackInitiative(singleTrack)
        def trackApplication = catalog.getTrackApplication(singleTrack)

        if(!trackInitiative && trackApplication) {
            trackInitiative = InitiativeValidate.getInitiativeFromApplication(trackApplication)
        }

        InitiativeValidate.validateInitiative(singleTrack.path, trackInitiative)
    }
}

