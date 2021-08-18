package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class AbstractLinterTest {

    def linterProp = new DeprecatedTypesLinter([PropertyType.Map, PropertyType.ArrayList])
    def linterPath = new NamingLinter()

    @Test void passValidationMeansTrackAndProperties() {
        def td = new TrackDefinition("/search_snake_case")
        td.addProperty(new TrackDefinitionProperty(name: "query_snake_case", required: true,
                description: "searched string", type: PropertyType.String))

        assertTrue(linterProp.passValidation(td))
        assertTrue(linterPath.passValidation(td))
    }

    @Test void failsValidationIfOneIsFalse() {
        def propertyFalse = new TrackDefinition("/search_snake_case")
        propertyFalse.addProperty(new TrackDefinitionProperty(name: "invalid_type", required: true,
                description: "invalid", type: PropertyType.Map))

        assertFalse(linterProp.passValidation(propertyFalse))

        def pathFalse = new TrackDefinition("/searchInvalid")
        pathFalse.addProperty(new TrackDefinitionProperty(name: "query_snake_case", required: true,
                description: "searched string", type: PropertyType.String))

        assertFalse(linterPath.passValidation(pathFalse))
    }

    @Test void propertyValidationGoesIteratesMaps() {
        def propertyFalse = new TrackDefinition("/search_snake_case")
        def propertiesMap = ["name": new TrackDefinitionProperty(name: "invalid_prop", required: true,
                description: "invalid", type: PropertyType.Map)]

        propertyFalse.addProperty(new TrackDefinitionProperty(name: "products", required: true,
                description: "products", type: PropertyType.Map(propertiesMap)))

        assertFalse(linterProp.passValidation(propertyFalse))
    }
}
