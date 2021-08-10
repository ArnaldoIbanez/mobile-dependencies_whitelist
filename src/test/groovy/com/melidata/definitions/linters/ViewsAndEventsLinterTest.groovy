package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class ViewsAndEventsLinterTest {

    def linter = new ViewsAndEventsLinter(["tap"])

    @Test void failIfPathIsNotDeclarative() {
        def td = new TrackDefinition("/search/filter/tap")

        assertFalse(linter.validateTrack(td))
    }

    @Test void passIfPathIsDeclarative() {
        def td = new TrackDefinition("/search/filter/apply")

        assertTrue(linter.validateTrack(td))
    }

    @Test void propertiesValidatorAlwaysTrue() {
        def td = new TrackDefinition("/search/filter/apply")

        assertTrue(linter.validateProperties(td))
    }
}
