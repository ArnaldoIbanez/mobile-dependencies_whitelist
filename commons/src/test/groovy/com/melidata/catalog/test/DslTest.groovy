package com.melidata.catalog.test

import org.junit.Assert

import static com.ml.melidata.catalog.dsl.UtilDsl.utils
import static com.ml.melidata.catalog.dsl.TracksDsl.tracks
import org.junit.Test
import static org.junit.Assert.*


/**
 * Created by apetalas on 14/11/14.
 */
public class DslTest {

    @Test void shouldCreateEnumForPlatforms(){

        utils {
            platform "mobile", default:true
            platform "mobile/ios"
            platform "mobile/android"

            eventType "view", default: true
            eventType "action"
        }
    }

    @Test void shouldCreateATrackFromTrackDSL(){

        def tracksCreated = tracks {
            "/search" (platform:"mobile") {
                layout (
                        type: int,
                        values: [1,2,4]
                )
                query (
                        type:String
                )
            }

            "/search/active" (platform: "web") {
                query (
                    type: String
                )
            }
        }

        assertNotNull(tracksCreated)
        assertEquals(tracksCreated.size(), 2)
        assertEquals(tracksCreated[0].path, "/search")
        assertEquals(tracksCreated[1].path, "/search/active")

    }
}
