package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class NamingLinterTest {

    def linter = new NamingLinter()

    @Test void namingLinterFailsOnCamelCase() {
        def td = new TrackDefinition("/searchCamelCase")
        assertFalse(linter.validateTrack(td))
    }

    @Test void namingLinterAllowsSnakeCase() {
        def td = new TrackDefinition("/search_snake_case")
        assertTrue(linter.validateTrack(td))
    }

    @Test void namingLinterFailsCamelCaseProperties() {
        def td = new TrackDefinition("/search_snake_case")
        td.addProperty(new TrackDefinitionProperty(name: "queryCamelCase", required: true,
                description: "searched string", type: PropertyType.String))

        assertFalse(linter.validateProperties(td))
    }

    @Test void namingLinterAllowsSnakeCaseProperties() {
        def td = new TrackDefinition("/search_snake_case")
        td.addProperty(new TrackDefinitionProperty(name: "query_snake_case", required: true,
                description: "searched string", type: PropertyType.String))

        assertTrue(linter.validateProperties(td))
    }
}
