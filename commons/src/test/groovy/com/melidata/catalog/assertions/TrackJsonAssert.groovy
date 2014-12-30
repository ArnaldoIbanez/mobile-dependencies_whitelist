package com.melidata.catalog.assertions

import groovy.json.JsonSlurper
import org.assertj.core.api.AbstractAssert

/**
 * Created by apetalas on 12/11/14.
 */
public class TrackJsonAssert extends AbstractAssert<TrackJsonAssert, Object> {

    public TrackJsonAssert(Object actual) {
        super(actual, TrackJsonAssert.class);
    }

    public static TrackJsonAssert assertThat(String path) {
        def inputFile = new File(path)
        def inputJSON = new JsonSlurper().parseText(inputFile.text)
        return new TrackJsonAssert(inputJSON)
                .hasRootProperty("event_data")
                    .hasInnerProperty("event_data", "path")
    }

    public TrackJsonAssert hasRootProperty(String name){
        if(actual[name] == null)
            failWithMessage("Expected root property required <%s>", name);

        return this
    }

    public TrackJsonAssert hasInnerProperty(String root, String name) {

        if(actual[root][name] == null)
            failWithMessage("Expected inner property required <%s>.<%s>", root, name);

        return this;
    }


}