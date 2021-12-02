package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class RequireValuesLinterTest {

    def linter = new RequireValuesLinter(["mode"])

    @Test void propertyShouldHaveValues() {
        def td = new TrackDefinition("/search_snake_case")
        def prop = new TrackDefinitionProperty(name: "shipping_mode", required: true,
                description: "mode", type: PropertyType.String)
        td.addProperty(prop)
        td.addProperty(new TrackDefinitionProperty(name: "shipping_id", required: true,
                description: "id", type: PropertyType.String))


        assertFalse(linter.validateProperties(td))

        prop.values = ["delivery", "local"]

        assertTrue(linter.validateProperties(td))
    }

    @Test void validateTrackAlwaysTrue() {
        def td = new TrackDefinition("/search_snake_case")
        assertTrue(linter.validateTrack(td))
    }
}
