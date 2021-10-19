package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class ObligatoryPropertiesLinterTest {

    def linter = new ObligatoryPropertiesLinter(["required", "type", "name", "description"])

    @Test void failsOnTrackWithPropertiesNotCompliant() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "query"))

        assertFalse(linter.validateProperties(td))
    }

    @Test void propertiesAreValid() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "query", type: PropertyType.String, description: "query", required: true))

        assertTrue(linter.validateProperties(td))
    }

}
