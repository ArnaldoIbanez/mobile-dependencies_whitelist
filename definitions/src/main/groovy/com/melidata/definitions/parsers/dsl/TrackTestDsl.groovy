package com.melidata.definitions.parsers.dsl

import com.ml.melidata.Track

/**
 * Created by apetalas on 19/11/14.
 */

class TrackTestDsl {

    def ArrayList<Track> tracksToValidate = [];
    def ArrayList<TestDsl> tests = [];

    def static trackTests(closure) {
        TrackTestDsl dsl = new TrackTestDsl()
        closure.delegate = dsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        return dsl.tests
    }


    def test(params, closure) {
        //println "test: ${params}"

        TestDsl dsl = new TestDsl()
        dsl.name = params
        closure.delegate = dsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        //println "fin test:"
        this.tests.push(dsl)
        this.tracksToValidate = this.tracksToValidate + dsl.tracks
        return
    }
}

