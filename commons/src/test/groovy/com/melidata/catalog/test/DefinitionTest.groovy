package com.melidata.catalog.test


import com.ml.melidata.catalog.CategoryValidator


import com.ml.melidata.catalog.Track
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.TrackType
import com.ml.melidata.catalog.TypeValidator
import com.ml.melidata.catalog.ValuesValidator
import org.junit.Test
import static org.junit.Assert.*
/**
 * Created by geisbruch on 11/11/14.
 */
class DefinitionTest {


    @Test void shouldEnableAddPropertiesWithOutTrackDefinitionProperty() {
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

    @Test void shouldEnableAddPropertiesWithTrackDefinitionProperty() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(new TrackDefinitionProperty(name: "layout",description: "The layout used in the search query"))
        definition.addProperty(new TrackDefinitionProperty(name: "query", description: "Query wrote by the user", required: true))


        // Assert
        assertTrue(definition.properties.size() == 2)
        assertEquals(definition.getDefinitionProperty("layout").description, "The layout used in the search query")
        assertEquals(definition.getDefinitionProperty("query").required, true)
    }

    @Test void shouldEnableAddPropertiesValues() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name:"layout", values:["stack", "gallery", "mosaic"], description: "platform", required: true)

        // Assert
        assertTrue(definition.getDefinitionProperty("layout").values.size() == 3)
        assertTrue(definition.getDefinitionProperty("layout").hasValue("stack"))
        assertTrue(definition.getDefinitionProperty("layout").hasValue("gallery"))
        assertTrue(definition.getDefinitionProperty("layout").hasValue("mosaic"))
    }

    @Test void shouldEnableAddPropertiesRequired() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name: "platform", description: "platform", required: true)

        // Assert
        assertTrue(definition.getDefinitionProperty("platform").required)
    }

    @Test void shouldEnableAddPropertiesRequiredFalseByDefault() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name: "platform", description: "platform")

        // Assert
        assertFalse(definition.getDefinitionProperty("platform").required)
    }

    @Test void shouldValidateTrackWithValidValue() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "layout", validators:[new ValuesValidator(["stack", "gallery", "mosaic"])], description: "client layout", required: true)

        // Act
        def result = definition.validate(new Track(path: "/search", properties: ["layout":"gallery"]))

        // Assert
        assertTrue(result.status)
        assertEquals(result.menssages.size(), 0)
    }

    @Test void shouldValidateTrackWithInvalidValue() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "layout", validators:[new ValuesValidator(["stack", "gallery", "mosaic"])], description: "client layout", required: true)

        // Act
        def result = definition.validate(new Track(path: "/search", properties: ["layout":"galeria"]))

        // Assert
        assertEquals(result.status, false)
        assertEquals(result.menssages.size(), 1)
        //println result.menssages
    }

    @Test void shouldValidateTrackWithNonRequiredProperties() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "platform", values:["mobile", "web"], description: "client platform", required: false)
                .addProperty(name: "query", description: "query params", required: false)

        // Act
        def result = definition.validate(new Track(path:"/search", properties:["platform":"mobile"]))

        // Assert
        assertEquals(result.status, true)
        assertEquals(result.menssages.size(), 0)
        //println result.menssages
    }

    @Test void shouldValidateTrackWithRequiredProperties() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "platform", values:["mobile", "web"], description: "client platform", required: true)
                .addProperty(name: "query", description: "query params", required: true)

        // Act
        def result = definition.validate(new Track(path:"/search", properties:["platform":"mobile"]))

        // Assert
        assertEquals(result.status, false)
        assertEquals(result.menssages.size(), 1)
        //println result.menssages
    }

    @Test void shouldValidateTrackWithManyProperties() {

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
                new Track(path:"/search", properties: ["limit":50,"offset":0,"query":"ipod","total_result":1230]))

        // Assert
        //println result.menssages
        assertEquals(result.status, true)
        assertEquals(result.menssages.size(), 0)

    }

    @Test void shouldValidateTrackWithTypeValidator() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "limit", description: "limit of query result", validators:[new TypeValidator(Integer)])

        def result = definition.validate(
                new Track(path:"/search", properties: ["limit":50]))

        // Assert
        //println result.menssages
        assertEquals(result.status, true)
        assertEquals(result.menssages.size(), 0)

    }

    @Test void shouldFailValidateTrackWithTypeValidator() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "limit", description: "limit of query result", validators:[new TypeValidator(Integer)])

        def result = definition.validate(
                new Track(path:"/search", properties: ["limit":"50"]))

        // Assert
        //println result.menssages
        assertEquals(result.status, false)
        assertEquals(result.menssages.size(), 1)

    }

    @Test void shouldFailValidateTrackWithInvalidFormatCategory() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "category", description: "category of", validators:[new CategoryValidator()])

        def result = definition.validate(
                new Track(path:"/search", properties: ["category":"MARGEN1234"]))

        // Assert
        println result.menssages
        assertEquals(result.status, false)
        assertEquals(result.menssages.size(), 1)

    }

    @Test void shouldCreateTrackView(){

        // solo para probar variantes creacionales
        def track = Track.createTrack("/search", TrackType.View, "/mobile")

        assertTrue(track.trackType.equals(TrackType.View))
    }

}
