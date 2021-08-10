package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class AbstractLinterTest {

    def linter = new NamingLinter()

    @Test void passValidationMeansTrackAndProperties() {
        def td = new TrackDefinition("/search_snake_case")
        td.addProperty(new TrackDefinitionProperty(name: "query_snake_case", required: true,
                description: "searched string", type: PropertyType.String))

        assertTrue(linter.passValidation(td))
    }

    @Test void failsValidationIfOneIsFalse() {
        def propertyFalse = new TrackDefinition("/search_snake_case")
        propertyFalse.addProperty(new TrackDefinitionProperty(name: "invalidProperty", required: true,
                description: "invalid", type: PropertyType.String))

        assertFalse(linter.passValidation(propertyFalse))

        def pathFalse = new TrackDefinition("/searchInvalid")
        pathFalse.addProperty(new TrackDefinitionProperty(name: "query_snake_case", required: true,
                description: "searched string", type: PropertyType.String))

        assertFalse(linter.passValidation(pathFalse))
    }

    @Test void propertyValidationGoesIteratesMaps() {
        def propertyFalse = new TrackDefinition("/search_snake_case")
        def propertiesMap = ["name": new TrackDefinitionProperty(name: "invalidProperty", required: true,
                description: "invalid", type: PropertyType.String)]

        propertyFalse.addProperty(new TrackDefinitionProperty(name: "products", required: true,
                description: "products", type: PropertyType.Map(propertiesMap)))

        assertFalse(linter.passValidation(propertyFalse))
    }
}
