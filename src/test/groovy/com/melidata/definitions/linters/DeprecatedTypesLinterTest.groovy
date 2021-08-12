package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class DeprecatedTypesLinterTest {

    def linter = new DeprecatedTypesLinter([PropertyType.Map])

    @Test void failIfType() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "shipping", required: true,
                description: "shipping", type: PropertyType.Map))

        assertFalse(linter.validateProperties(td))
    }

    @Test void passIfPathIsDeclarative() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "shipping_mode", required: true,
                description: "mode", type: PropertyType.String))

        assertTrue(linter.validateProperties(td))
    }

    @Test void trackValidatorAlwaysTrue() {
        def td = new TrackDefinition("/search/filter/apply")

        assertTrue(linter.validateTrack(td))
    }
}
