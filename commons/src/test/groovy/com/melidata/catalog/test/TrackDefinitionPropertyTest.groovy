package com.melidata.catalog.test

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.MapProperty
import com.ml.melidata.catalog.TrackDefinitionProperty
import org.junit.Test
import static org.junit.Assert.*

class TrackDefinitionPropertyTest {
    @Test void shouldCreateNestedValidatorFromTrackDefinitionBothWithSameNestedProperties() {
        // Arrange
        def definition = new TrackDefinitionProperty(name: "layout", type: PropertyType.Map([
                heigth: new TrackDefinitionProperty(name: "width", description: "The layout used in the search query", type: PropertyType.String),
                width: new TrackDefinitionProperty(name: "width", description: "The layout used in the search query", type: PropertyType.String)]))

        def nestedValidator = definition.validators.get(0)

        // Assert
        assertEquals(definition.validators.size(), 1)
        assertTrue(nestedValidator.type instanceof MapProperty)
    }
}