package com.melidata.catalog.test

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.Track
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.TrackType
import com.ml.melidata.catalog.tree.TrackValidationResponse
import org.junit.Test
import static org.junit.Assert.*

/**
 * Created by geisbruch on 11/11/14.
 */
class CatalogTest {

    Catalog getDefaultEmptyCatalog() {
        Catalog c = new Catalog()
        c.addPlatform("/");
        c.addPlatform("/mobile");
        c.addPlatform("/mobile/ios");
        c.addPlatform("/mobile/android");
        c.addPlatform("/mobile/web");
        c.addPlatform("/desktop");
        return c;
    }

    @Test void shouldEnableAddTracks() {
        Catalog c = getDefaultEmptyCatalog()
        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", description: "query", required: true)));


        Track t = Track.createTrack("/search",TrackType.View,"/mobile");
        TrackValidationResponse validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["query"] = "q"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["category"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)
    }

    @Test void shouldKeepHierarchy() {
        Catalog c = getDefaultEmptyCatalog()
        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", description: "query", required: true)));
        c.addTrackDefinition(new TrackDefinition("/search/refine")
                .addProperty(new TrackDefinitionProperty(name:"filter", description: "filter", required: true)));
        c.addTrackDefinition(new TrackDefinition("/search/refine",TrackType.View, "/mobile/ios")
                .addProperty(new TrackDefinitionProperty(name:"position", description: "position", required: true)));
        /**
         * Test that all properties on /search should be in /search/refine + their own properties, but
         * properties of /search/refine for ios are not present
         */
        Track t = Track.createTrack("/search/refine",TrackType.View,"/mobile");
        TrackValidationResponse validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["filter"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)
        t.properties["position"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
    }

    @Test void shouldKeepHierarchyByPlatform() {
        Catalog c = getDefaultEmptyCatalog()
        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", description: "query", required: true)));
        c.addTrackDefinition(new TrackDefinition("/search/refine")
                .addProperty(new TrackDefinitionProperty(name:"filter", description: "filter", required: true)));
        c.addTrackDefinition(new TrackDefinition("/search/refine",TrackType.View,"/mobile/ios")
                .addProperty(new TrackDefinitionProperty(name:"position", description: "position", required: true)));


        Track t = Track.createTrack("/search/refine",TrackType.View,"/mobile/ios");
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        t.properties["filter"] = "c"
        def validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["position"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

    }

    @Test void shouldKeepHierarchyByPlatformWithoutTakeCareDefinitionOrder() {
        Catalog c = getDefaultEmptyCatalog()
        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", description: "query", required: true)));
        c.addTrackDefinition(new TrackDefinition("/search/refine",TrackType.View,"/mobile/ios")
                .addProperty(new TrackDefinitionProperty(name:"position", description: "position", required: true)));
        c.addTrackDefinition(new TrackDefinition("/search/refine")
                .addProperty(new TrackDefinitionProperty(name:"filter", description: "filter", required: true)));

        Track t = Track.createTrack("/search/refine",TrackType.View,"/mobile/ios");
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        t.properties["filter"] = "c"
        def validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["position"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

    }

    @Test void shouldEnableRedefinePropertiesByPlatform() {
        Catalog c = getDefaultEmptyCatalog()
        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", description: "query", required: true)));

        c.addTrackDefinition(new TrackDefinition("/search/refine",TrackType.View,"/mobile/ios")
                .addProperty(new TrackDefinitionProperty(name:"filter", description: "filter", required: false)));


        c.addTrackDefinition(new TrackDefinition("/search/refine")
                .addProperty(new TrackDefinitionProperty(name:"filter", description: "filter", required: true)));


        Track t = Track.createTrack("/search/refine",TrackType.View,"/mobile/ios");
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        def validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t = Track.createTrack("/search/refine",TrackType.View,"/mobile");
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["filter"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t = Track.createTrack("/search/refine",TrackType.View,"/desktop");
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["filter"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)
    }

    @Test void shouldUseTreeHierarchyInAllPlatforms() {

        Catalog c = getDefaultEmptyCatalog()
        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", description: "query", required: true)));

        c.addTrackDefinition(new TrackDefinition("/search/refine")
                .addProperty(new TrackDefinitionProperty(name:"filter", description: "filter", required: true)));
        c.addTrackDefinition(new TrackDefinition("/search/refine/filter")
                .addProperty(new TrackDefinitionProperty(name:"selection", description: "selection", required: true)));



        Track t = Track.createTrack("/search/refine/filter",TrackType.View,"/desktop");
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        def validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["filter"] = "test"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.properties["selection"] = "test"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t = Track.createTrack("/search/refine/filter",TrackType.View,"/mobile");
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        t.properties["filter"] = "test"
        t.properties["selection"] = "test"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t = Track.createTrack("/search/refine/filter",TrackType.View,"/mobile/android");
        t.properties["query"] = "q"
        t.properties["category"] = "c"
        t.properties["filter"] = "test"
        t.properties["selection"] = "test"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)
    }
}
