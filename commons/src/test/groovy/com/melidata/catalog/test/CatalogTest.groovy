package com.melidata.catalog.test

import com.ml.melidata.Track
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
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


        Track t = new Track("/search",TrackType.View,"/mobile");
        TrackValidationResponse validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["query"] = "q"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["category"] = "c"
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
         * Test that all event_data on /search should be in /search/refine + their own event_data, but
         * event_data of /search/refine for ios are not present
         */
        Track t = new Track("/search/refine",TrackType.View,"/mobile");
        TrackValidationResponse validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["filter"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)
        t.event_data["position"] = "c"
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


        Track t = new  Track("/search/refine",TrackType.View,"/mobile/ios");
        t.addProperty("query", "q")
                .addProperty("category", "c")
                .addProperty("filter", "c")
        def validationResponse = c.validate(t)
        assertFalse(validationResponse.status)
        t.addProperty("position", "c")
        validationResponse = c.validate(t)
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

        Track t = new Track("/search/refine",TrackType.View,"/mobile/ios");
        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        t.event_data["filter"] = "c"
        def validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["position"] = "c"
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


        Track t = new Track("/search/refine",TrackType.View,"/mobile/ios");
        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        def validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t = new Track("/search/refine",TrackType.View,"/mobile");
        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["filter"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t = new Track("/search/refine",TrackType.View,"/desktop");
        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["filter"] = "c"
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



        Track t = new Track("/search/refine/filter",TrackType.View,"/desktop");
        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        def validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["filter"] = "test"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
        t.event_data["selection"] = "test"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t = new Track("/search/refine/filter",TrackType.View,"/mobile");
        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        t.event_data["filter"] = "test"
        t.event_data["selection"] = "test"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t = new Track("/search/refine/filter",TrackType.View,"/mobile/android");
        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        t.event_data["filter"] = "test"
        t.event_data["selection"] = "test"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)
    }
}
