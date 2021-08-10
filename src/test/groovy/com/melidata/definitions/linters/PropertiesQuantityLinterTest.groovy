package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class PropertiesQuantityLinterTest {

    def linter = new PropertiesQuantityLinter(1)

    @Test void allowsLimitQuantityOfProperties() {
        def td = new TrackDefinition("/search_snake_case")
        td.addProperty(new TrackDefinitionProperty(name: "query", required: true,
                description: "searched string", type: PropertyType.String))

        assertTrue(linter.validateProperties(td))

        td.addProperty(new TrackDefinitionProperty(name: "limit", required: true,
                description: "number of results", type: PropertyType.Numeric))

        assertFalse(linter.validateProperties(td))
    }

    @Test void validateTrackAlwaysTrue() {
        def td = new TrackDefinition("/search_snake_case")
        assertTrue(linter.validateTrack(td))
    }
}
