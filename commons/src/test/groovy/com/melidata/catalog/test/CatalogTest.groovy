package com.melidata.catalog.test

import com.ml.melidata.Track
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.parsers.json.CatalogJsonOutput
import com.ml.melidata.catalog.tree.TrackValidationResponse
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.junit.Test
import static org.junit.Assert.*

/**
 * Created by geisbruch on 11/11/14.
 */


class CatalogTest {

    Catalog getDefaultEmptyCatalog() {
        Catalog c = new Catalog()
        c.addBusiness("ml")
        c.setDefaultBusiness("ml");
        c.addPlatform("/");
        c.addPlatform("/mobile");
        c.addPlatform("/mobile/ios");
        c.addPlatform("/mobile/android");
        c.addPlatform("/mobile/web");
        c.addPlatform("/desktop");
        return c;
    }

    @Test void shouldCheckBusiness() {
        Catalog c = getDefaultEmptyCatalog()
        c.addBusiness("test")
        c.addBusiness("test2")

        c.addTrackDefinition(new TrackDefinition(path:  "/search", business: "test"));
        c.addTrackDefinition(new TrackDefinition(path:  "/search2", business: "test2"));

        TrackValidationResponse validationResponse = c.validate(new Track("/search",TrackType.View,"/mobile"));
        assertFalse(validationResponse.status)

        validationResponse = c.validate(new Track("/search",TrackType.View,"/mobile", "test"));
        assertTrue(validationResponse.status)

        validationResponse = c.validate(new Track("/search",TrackType.View,"/mobile", "test2"));
        assertFalse(validationResponse.status)

        validationResponse = c.validate(new Track("/search2",TrackType.View,"/mobile", "test2"));
        assertTrue(validationResponse.status)
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

    @Test void testJsonOutput() {
        Catalog c = new Catalog()
        c.addBusiness("ml")
        c.setDefaultBusiness("ml");
        c.addPlatform("/");
        c.addPlatform("/mobile/ios");
        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", description: "query", required: false)));


        c.addTrackDefinition(new TrackDefinition(path: "/search",platform: "/mobile/ios"))



        JSONParser parser = new JSONParser();
        JSONObject j = parser.parse(new CatalogJsonOutput().toJson(c));
        assertTrue(j.containsKey("platforms"))
        assertTrue(j.containsKey("tracks"))
        assertEquals(3,j.get("platforms").size())
        assertEquals(3,j.get("tracks").size())
        j.get("tracks").each { t ->
            assertEquals("/search",t.get("path"))
            def props = t.get("properties");
            assertEquals(2, props.size())
            props.each {v ->
                if(v.get("name") == "category") {
                    assertEquals("category",v.get("description"))
                    assertTrue(v.get("required"))
                }else if(v.get("name") == "query") {
                    assertEquals("query",v.get("description"))
                    assertFalse(v.get("required"))
                } else {
                    fail();
                }
            }
        }
    }

    @Test void shouldNOTKeepHierarchy() {
        //use of parentPropertiesInherited to override default behavior of inherite properties of parent path

        Catalog c = getDefaultEmptyCatalog()

        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", required: true)));

        c.addTrackDefinition(new TrackDefinition(path: "/search/refine", parentPropertiesInherited: false)
                .addProperty(new TrackDefinitionProperty(name:"filter", required: true)));

        /**
         * Test that all event_data on /search not should be in /search/refine but their own event_data
         */
        Track t = new Track("/search/refine",TrackType.View,"/mobile");
        TrackValidationResponse validationResponse = c.validate(t);
        assertFalse(validationResponse.status)

        t.event_data["filter"] = "c"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
    }

    @Test void shouldNOTKeepHierarchySecondLevel() {
        //use of parentPropertiesInherited to override default behavior of inherite properties of parent path

        Catalog c = getDefaultEmptyCatalog()

        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", required: true)));

        c.addTrackDefinition(new TrackDefinition(path: "/search/refine", parentPropertiesInherited: false)
                .addProperty(new TrackDefinitionProperty(name:"filter", required: true)));

        c.addTrackDefinition(new TrackDefinition(path: "/search/refine/child")
                .addProperty(new TrackDefinitionProperty(name:"child_filter", required: true)));

        /**
         * Test that all event_data on /search not should be in /search/refine/child but filter should be
         */
        Track t = new Track("/search/refine/child",TrackType.View,"/mobile");
        t.event_data["filter"] = "c1"
        t.event_data["child_filter"] = "c2"
        def validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
    }

    @Test void shouldNOTKeepHierarchyThirdLevel() {
        //use of parentPropertiesInherited to override default behavior of inherite properties of parent path

        Catalog c = getDefaultEmptyCatalog()

        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", required: true)));

        c.addTrackDefinition(new TrackDefinition(path: "/search/refine", parentPropertiesInherited: false)
                .addProperty(new TrackDefinitionProperty(name:"filter", required: true)));

        c.addTrackDefinition(new TrackDefinition(path: "/search/refine/child")
                .addProperty(new TrackDefinitionProperty(name:"child_filter", required: true)));

        c.addTrackDefinition(new TrackDefinition(path: "/search/refine/child/child2")
                .addProperty(new TrackDefinitionProperty(name:"child2_filter", required: true)));

        /**
         * Test that all event_data on /search not should be in /search/refine/child but filter should be
         */
        Track t = new Track("/search/refine/child/child2",TrackType.View,"/mobile");
        t.event_data["filter"] = "c1"
        t.event_data["child_filter"] = "c2"
        def validationResponse = c.validate(t);
        assertFalse(validationResponse.status)

        t.event_data["child2_filter"] = "c3"
        validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t.event_data["query"] = "q"
        t.event_data["category"] = "c"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
    }

    @Test void shouldNotInheritableProperty() {
        Catalog c = getDefaultEmptyCatalog()

        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"only_local", required: true, inheritable: false)));

        c.addTrackDefinition(new TrackDefinition(path: "/search/refine")
                .addProperty(new TrackDefinitionProperty(name:"filter", required: true)));

        Track t = new Track("/search/refine",TrackType.View,"/mobile");
        t.event_data["category"] = "c1"
        t.event_data["filter"] = "c2"
        def validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        t.event_data["only_local"] = "c3"
        validationResponse = c.validate(t);
        assertFalse(validationResponse.status)
    }

    @Test void shouldValidateServerSide() {
        Catalog c = getDefaultEmptyCatalog()

        c.addTrackDefinition(new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty(name:"category", required: true))
                .addProperty(new TrackDefinitionProperty(name:"query", description: "query", required: true))
                .addProperty(new TrackDefinitionProperty(name:"server_property", required: true, serverSide: true)));

        Track t = new Track("/search",TrackType.View,"/mobile");
        t.event_data["category"] = "category"
        t.event_data["query"] = "query"
        def validationResponse = c.validate(t);
        assertTrue(validationResponse.status)

        validationResponse = c.validate(t, true);
        assertFalse(validationResponse.status)

        t.event_data["server_property"] = "anyvalue"
        validationResponse = c.validate(t, true);
        assertTrue(validationResponse.status)
    }

}
