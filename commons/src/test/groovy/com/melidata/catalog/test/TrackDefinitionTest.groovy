package com.melidata.catalog.test

import com.ml.melidata.TrackType
import com.ml.melidata.Track
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.model.ApplicationModel
import org.junit.Test
import static org.junit.Assert.*

/**
 * Created by geisbruch on 11/11/14.
 */
class TrackDefinitionTest {


    @Test
    void shouldEnableAddPropertiesWithOutTrackDefinitionProperty() {
        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name: "layout", description: "The layout used in the search query")
        definition.addProperty(name: "query", description: "Query wrote by the user", required: true)

        // Assert
        assertTrue(definition.properties.size() == 2)
        assertEquals(definition.getDefinitionProperty("layout").description, "The layout used in the search query")
        assertEquals(definition.getDefinitionProperty("query").required, true)
    }

    @Test
    void shouldEnableAddPropertiesWithTrackDefinitionProperty() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(new TrackDefinitionProperty(name: "layout", description: "The layout used in the search query"))
        definition.addProperty(new TrackDefinitionProperty(name: "query", description: "Query wrote by the user", required: true))

        // Assert
        assertTrue(definition.properties.size() == 2)
        assertEquals(definition.getDefinitionProperty("layout").description, "The layout used in the search query")
        assertEquals(definition.getDefinitionProperty("query").required, true)
    }

    @Test
    void shouldEnableAddPropertiesValues() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name: "view_mode", values: ["LIST", "MOSAIC", "GALLERY"], description: "platform", required: true)

        // Assert
        assertTrue(definition.getDefinitionProperty("view_mode").values.size() == 3)
        assertTrue(definition.getDefinitionProperty("view_mode").hasValue("LIST"))
        assertTrue(definition.getDefinitionProperty("view_mode").hasValue("MOSAIC"))
        assertTrue(definition.getDefinitionProperty("view_mode").hasValue("GALLERY"))
    }

    @Test
    void shouldEnableAddPropertiesRequired() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name: "platform", description: "platform", required: true)

        // Assert
        assertTrue(definition.getDefinitionProperty("platform").required)
    }

    @Test
    void shouldEnableAddPropertiesRequiredFalseByDefault() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name: "platform", description: "platform")

        // Assert
        assertTrue(definition.getDefinitionProperty("platform").required)
    }

    @Test
    void shouldValidateTrackWithValidValue() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "layout", values: ["stack", "gallery", "mosaic"], description: "client layout")

        // Act
        def result = definition.validate(new Track(path: "/search", event_data: ["layout": "gallery"]))

        // Assert
        assertTrue(result.status)
        assertEquals(result.messages.size(), 0)
    }

    @Test
    void shouldValidateTrackWithInvalidValue() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "view_mode", values: ["LIST", "MOSAIC", "GALLERY"], description: "client layout")

        // Act
        def result = definition.validate(new Track(path: "/search", event_data: ["view_mode": "gallery"]))

        // Assert
        assertEquals(result.status, false)
        assertEquals(result.messages.size(), 1)
    }

    @Test
    void shouldValidateTrackWithNonRequiredProperties() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "platform", values: ["mobile", "web"], description: "client platform", required: false)
                .addProperty(name: "query", description: "query params", required: false)

        // Act
        def result = definition.validate(new Track(path: "/search", event_data: ["platform": "mobile"]))

        // Assert
        assertEquals(result.status, true)
        assertEquals(result.messages.size(), 0)
    }

    @Test
    void shouldValidateTrackWithNonRequiredButWithValuesProperties() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "platform", values: ["mobile", "web"], description: "client platform", required: false)
                .addProperty(name: "query", description: "query params", required: false)

        // Act
        def result = definition.validate(new Track(path: "/search", event_data: ["query": "iphone"]))

        // Assert
        assertEquals(result.status, true)
        assertEquals(result.messages.size(), 0)
    }

    @Test
    void shouldValidateTrackWithRequiredProperties() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "platform", values: ["mobile", "web"], description: "client platform", required: true)
                .addProperty(name: "query", description: "query params", required: true)

        // Act
        def result = definition.validate(new Track(path: "/search", event_data: ["platform": "mobile"]))

        // Assert
        assertEquals(result.status, false)
        assertEquals(result.messages.size(), 1)
    }

    @Test
    void shouldValidateTrackWithManyProperties() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "limit", description: "limit of query result")
                .addProperty(name: "offset", description: "offset of query data", required: true)
                .addProperty(name: "query", description: "string query", required: true)
                .addProperty(name: "total_result", description: "count of result query", required: true)

        // Act
        /*"event_data":{
            "path":"/search",
            "limit":50,
            "offset":0,
            "query":"ipod",
            "custom":{},
            "total_results":1230
        }*/
        def result = definition.validate(
                new Track(path: "/search", event_data: ["limit": 50, "offset": 0, "query": "ipod", "total_result": 1230]))

        // Assert
        assertEquals(result.status, true)
        assertEquals(result.messages.size(), 0)

    }

    @Test
    void shouldValidateTrackWithTypeValidator() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "limit", description: "limit of query result", type: PropertyType.Numeric)

        def result = definition.validate(
                new Track(path: "/search", event_data: ["limit": 50]))

        // Assert
        assertEquals(result.status, true)
        assertEquals(result.messages.size(), 0)

    }

    @Test
    void shouldFailValidateTrackWithTypeValidator() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "limit", description: "limit of query result", type: PropertyType.Numeric)

        def result = definition.validate(
                new Track(path: "/search", event_data: ["limit": "50"]))

        // Assert
        assertEquals(result.status, false)
        assertEquals(result.messages.size(), 1)
    }

    @Test
    void shouldFailValidateTrackWithInvalidFormatCategory() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "category", description: "category of", regex: /[a-zA-Z]{1,3}[0-9]+/)

        def result = definition.validate(
                new Track(path: "/search", event_data: ["category": "MARGEN1234"]))

        // Assert
        assertEquals(result.status, false)
        assertEquals(result.messages.size(), 1)

    }

    @Test
    void shouldValidateTrackWithValidFormatCategory() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "category", description: "category of", regex: /[a-zA-Z]{1,3}[0-9]+/)

        def result = definition.validate(
                new Track(path: "/search", event_data: ["category": "MAR123"]))

        // Assert
        assertEquals(result.status, true)

    }

    @Test
    void shouldFailTrackWithPropertyNotCataloged() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "category", description: "category of", regex: /[a-zA-Z]{1,3}[0-9]+/)

        def result = definition.validate(
                new Track(path: "/search", event_data: ["layout": "ver"]))

        // Assert
        assertEquals(result.status, false)

    }

    @Test
    void shouldThrowExceptionWhenRegexAndValuesArePresent() {

        // Arrange
        try {
            def definition = new TrackDefinition("/search")
                    .addProperty(name: "category", description: "category of", values: ["a", "b"], regex: "/[a-zA-Z]{1,3}[0-9]+/")
        }
        catch (Exception x) {
            assertEquals(x.class, CatalogException)
        }
    }

    @Test
    void shouldCreateTrackView() {

        // solo para probar variantes creacionales
        def track = new Track("/search", TrackType.View, "/mobile")

        assertTrue(track.type.equals(TrackType.View))
    }

    @Test
    void schemaDefinitionsPropertiesArentTracksProperties() {

        def definition = new TrackDefinition("/search")
                .addProperty(name: "category", description: "category of", type: PropertyType.Map, schemaDefinitions: [
                heigth: new TrackDefinitionProperty(name: "width", description: "The layout used in the search query", type: PropertyType.String),
                width : new TrackDefinitionProperty(name: "width", description: "The layout used in the search query", type: PropertyType.String)
        ])

        assertNull(definition.getProperties()["heigth"])
        assertNotNull(definition.getProperties()["category"])
    }

    @Test
    void isPropertyRequiredTesting() {

        def propertyRequired = new TrackDefinitionProperty(name: "category", description: "category of", type: PropertyType.String, required: true)
        def propertyNotRequiredNotServer = new TrackDefinitionProperty(name: "offset", description: "category of", type: PropertyType.String, required: false)
        def propertyRequiredYesServer = new TrackDefinitionProperty(name: "height", description: "category of", type: PropertyType.String, required: true, serverSide: true)

        def definition = new TrackDefinition("/search")
                .addProperty(propertyRequired)
                .addProperty(propertyNotRequiredNotServer)
                .addProperty(propertyRequiredYesServer)

        assertTrue(definition.isPropertyRequired(propertyRequired, false))
        assertTrue(definition.isPropertyRequired(propertyRequired, true))

        assertFalse(definition.isPropertyRequired(propertyNotRequiredNotServer, false))
        assertFalse(definition.isPropertyRequired(propertyNotRequiredNotServer, true))

        assertFalse(definition.isPropertyRequired(propertyRequiredYesServer, false))
        assertTrue(definition.isPropertyRequired(propertyRequiredYesServer, true))
    }

     @Test
    void applicationModelTest() {

         def model = new ApplicationModel("1171", "search-frontend")

         assertEquals("1171", model.getInitiativeId())
         assertEquals("search-frontend", model.getApplicationName())

         model.setInitiativeId("1170")
         model.setApplicationName("search-backend")

         assertEquals("1170", model.getInitiativeId())
         assertEquals("search-backend", model.getApplicationName())
     }
}