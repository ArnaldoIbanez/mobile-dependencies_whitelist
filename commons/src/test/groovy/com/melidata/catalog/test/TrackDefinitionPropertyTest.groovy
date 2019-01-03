package com.melidata.catalog.test

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.CategoryValidator

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.NestedValidator
import com.ml.melidata.catalog.TypeValidator
import org.junit.Test
import static org.junit.Assert.*
/**
 * Created by geisbruch on 11/11/14.
 */
class TrackDefinitionPropertyTest {


    @Test void shouldRaiseErrorWhenDefiningSchemaWithoutAMap() {
        // Arrange
        try {
            new TrackDefinitionProperty(name: "layout", type: PropertyType.String, schemaDefinitions: [
                    width: new TrackDefinitionProperty(name: "width", description: "The layout used in the search query", type: PropertyType.String)])

            fail("it should have failed")
        } catch (CatalogException e) {}
    }

    @Test void shouldCreateNestedValidatorFromTrackDefinitionBothWithSameNestedProperties() {
        // Arrange
        def definition = new TrackDefinitionProperty(name: "layout", type: PropertyType.Map, schemaDefinitions: [
                    heigth: new TrackDefinitionProperty(name: "width", description: "The layout used in the search query", type: PropertyType.String),
                    width: new TrackDefinitionProperty(name: "width", description: "The layout used in the search query", type: PropertyType.String)])

        def typeValidator = definition.validators.get(0)
        def nestedValidator = definition.validators.get(1)

        // Assert
        assertEquals(definition.validators.size(), 2)
        assertTrue(typeValidator instanceof TypeValidator)
        assertTrue(nestedValidator instanceof NestedValidator)
        assertEquals(definition.nestedProperties, nestedValidator.nestedProperties)
    }
}