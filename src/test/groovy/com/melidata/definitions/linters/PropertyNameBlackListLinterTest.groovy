package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class PropertyNameBlackListLinterTest {

    def linter = new PropertyNameBlackListLinter(["data"], ["platform"], ["user_id"])

    @Test void failIfPropertyIsTooVague() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "data", required: true,
                description: "extra data for track", type: PropertyType.Map(PropertyType.String,PropertyType.String)))
        td.addProperty(new TrackDefinitionProperty(name: "shipping_mode", required: true,
                description: "shipping_mode", type: PropertyType.String))

        assertFalse(linter.validateProperties(td))
    }

    @Test void failIfPropertyIsReserved() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "platform", required: true,
                description: "platform the user is navigating", type: PropertyType.String))
        td.addProperty(new TrackDefinitionProperty(name: "shipping_mode", required: true,
                description: "shipping_mode", type: PropertyType.String))

        assertFalse(linter.validateProperties(td))
    }

    @Test void failIfPropertyIsAlreadyTracked() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "user_id", required: true,
                description: "users id", type: PropertyType.String))
        td.addProperty(new TrackDefinitionProperty(name: "shipping_mode", required: true,
                description: "shipping_mode", type: PropertyType.String))

        assertFalse(linter.validateProperties(td))
    }

    @Test void passIfPropertieIsntBlacklisted() {
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
