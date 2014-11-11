package com.melidata.catalog.test

import com.ml.melidata.catalog.Track
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
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
        assertEquals(definition.properties.get("layout").description, "The layout used in the search query")
        assertEquals(definition.properties.get("query").required, true)
    }

    @Test void shouldEnableAddPropertiesWithTrackDefinitionProperty() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(new TrackDefinitionProperty(name: "layout",description: "The layout used in the search query"))
        definition.addProperty(new TrackDefinitionProperty(name: "query", description: "Query wrote by the user", required: true))


        // Assert
        assertTrue(definition.properties.size() == 2)
        assertEquals(definition.properties.get("layout").description, "The layout used in the search query")
        assertEquals(definition.properties.get("query").required, true)
    }

    @Test void shouldEnableAddPropertiesValues() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name:"layout", values:["stack", "gallery", "mosaic"], description: "platform", required: true)

        // Assert
        assertTrue(definition.properties.get("layout").values.size() == 3)
        assertTrue(definition.properties.get("layout").values[0] == "stack")
        assertTrue(definition.properties.get("layout").values[1] == "gallery")
        assertTrue(definition.properties.get("layout").values[2] == "mosaic")
    }

    @Test void shouldEnableAddPropertiesRequired() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name: "platform", description: "platform", required: true)

        // Assert
        assertTrue(definition.properties.get("platform").required)
    }

    @Test void shouldEnableAddPropertiesRequiredFalseByDefault() {

        // Arrange
        def definition = new TrackDefinition("/search")

        // Act
        definition.addProperty(name: "platform", description: "platform")

        // Assert
        assertFalse(definition.properties.get("platform").required)
    }

    @Test void shouldValidateTrackWithValidValue() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "layout", values:["stack", "gallery", "mosaic"], description: "client layout", required: true)

        // Act
        def track = new Track()
        track.path ="/search";
        track.properties.putAll(["layout":"gallery"])
        def result = definition.validateTrack(track)


        // Assert
        assertTrue(result.status)
        assertEquals(result.menssages.size(), 0)
    }

    @Test void shouldValidateTrackWithInvalidValue() {

        // Arrange
        def definition = new TrackDefinition("/search")
                .addProperty(name: "layout", values:["stack", "gallery", "mosaic"], description: "client layout", required: true)

        // Act
        def track = new Track()
        track.path ="/search";
        track.properties.putAll(["layout":"galeria"])
        def result = definition.validateTrack(track)


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
        def track = new Track()
        track.path = "/search";
        track.properties.putAll(["platform":"mobile"])
        def result = definition.validateTrack(track)

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
        def track = new Track()
        track.path = "/search";
        track.properties.putAll(["platform":"mobile"])
        def result = definition.validateTrack(track)

        // Assert
        assertEquals(result.status, false)
        assertEquals(result.menssages.size(), 1)
        //println result.menssages
    }

}
