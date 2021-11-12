package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class MinimumRequiredTrueLinterTest {

    def linter = new MinimumRequiredTrueLinter(4)

    @Test void validatePropertiesAlwaysTrue() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "query", type: PropertyType.String,
                description: "query", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "limit", type: PropertyType.String,
                description: "limit", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "category_id", type: PropertyType.String,
                description: "category_id", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "category_path", type: PropertyType.String,
                description: "category_path", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "has_tags", type: PropertyType.String,
                description: "category_path", required: false))

        assertTrue(linter.validateProperties(td))
    }

    @Test void propertiesAreValidWithTrackValidation() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "query", type: PropertyType.String,
                description: "query", required: true))
        td.addProperty(new TrackDefinitionProperty(name: "limit", type: PropertyType.String,
                description: "limit", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "category_id", type: PropertyType.String,
                description: "category_id", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "category_path", type: PropertyType.String,
                description: "category_path", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "has_tags", type: PropertyType.String,
                description: "category_path", required: false))
        assertTrue(linter.validateTrack(td))
    }

    @Test void withLotsOfPropertiesOneShouldBeRequired() {
        def td = new TrackDefinition("/search")
        td.addProperty(new TrackDefinitionProperty(name: "query", type: PropertyType.String,
                description: "query", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "limit", type: PropertyType.String,
                description: "limit", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "category_id", type: PropertyType.String,
                description: "category_id", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "category_path", type: PropertyType.String,
                description: "category_path", required: false))
        td.addProperty(new TrackDefinitionProperty(name: "has_tags", type: PropertyType.String,
                description: "category_path", required: false))

        assertFalse(linter.validateTrack(td))

    }
}
