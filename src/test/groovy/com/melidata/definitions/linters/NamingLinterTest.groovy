package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class NamingLinterTest {

    def linter = new NamingLinter()

    @Test void failsOnCamelCase() {
        def td = new TrackDefinition("/searchCamelCase")
        assertFalse(linter.validateTrack(td))
    }

    @Test void allowsRootPath() {
        def td = new TrackDefinition("/")
        assertTrue(linter.validateTrack(td))
    }

    @Test void pathsShouldStartWithSlash() {
        def validDefinition = new TrackDefinition("/search")
        def invalidDefinition = new TrackDefinition("search")

        assertTrue(linter.validateTrack(validDefinition))
        assertFalse(linter.validateTrack(invalidDefinition))
    }

    @Test void pathsShouldntEndWithSlash() {
        def validDefinition = new TrackDefinition("/search")
        def invalidDefinition = new TrackDefinition("/search/")

        assertTrue(linter.validateTrack(validDefinition))
        assertFalse(linter.validateTrack(invalidDefinition))
    }

    @Test void allowsSnakeCase() {
        def td = new TrackDefinition("/search_snake_case")
        assertTrue(linter.validateTrack(td))
    }
}
