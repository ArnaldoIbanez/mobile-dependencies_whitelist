package com.melidata.catalog.test

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertNull

/**
 * Created by geisbruch on 11/11/14.
 */

class PlatformTreeTest {

    @Test void testAddElementToPlatformTree() {
        PlatformTree tree = new PlatformTree();
        tree.addNode("/");
        tree.addNode("/mobile");
        tree.addNode("/mobile/ios");

        assertNotNull(tree.getNodeByPath("/"))
        assertNotNull(tree.getNodeByPath("/mobile"))
        assertNotNull(tree.getNodeByPath("/mobile/ios"))

    }

    @Test void testAddTrackDefinition() {
        PlatformTree tree = new PlatformTree();
        tree.addNode("/");
        tree.addNode("/mobile");
        tree.addNode("/mobile/ios");

        tree.getNodeByPath("/").addTrackDefinition(new TrackDefinition("/homes/categories")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true)));

        tree.getNodeByPath("/").addTrackDefinition(new TrackDefinition("/homes")
                .addProperty(new TrackDefinitionProperty(name:"promotions", description: "promotions", required: true))
                .addProperty(new TrackDefinitionProperty(name:"layout", description:"layout", required: true)));


        TrackDefinition node = tree.getNodeByPath("/").getTrackDefinition("/homes")
        assertNotNull(node)
        assertEquals("promotions",node.properties["promotions"].description)
        assertEquals("layout", node.properties["layout"].description)
        node = tree.getNodeByPath("/").getTrackDefinition("/homes/categories")
        assertNotNull(node)
        assertEquals("promotions",node.properties["promotions"].description)
        assertEquals("layout", node.properties["layout"].description)
        assertEquals("category", node.properties["category"].description)

    }

    @Test void testPropagateConfigToSubPlatforms() {
        PlatformTree tree = new PlatformTree();
        tree.addNode("/");
        tree.addNode("/mobile");
        tree.addNode("/mobile/ios");

        tree.getNodeByPath("/mobile/ios").addTrackDefinition(new TrackDefinition("/homes/categories")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true)));

        tree.getNodeByPath("/").addTrackDefinition(new TrackDefinition("/homes")
                .addProperty(new TrackDefinitionProperty(name:"promotions", description: "promotions", required: true))
                .addProperty(new TrackDefinitionProperty(name:"layout", description:"layout", required: true)));


        //Check no platform
        TrackDefinition node = tree.getNodeByPath("/").getTrackDefinition("/homes")
        assertNotNull(node)
        assertEquals("promotions",node.properties["promotions"].description)
        assertEquals("layout", node.properties["layout"].description)

        //For mobile should be equals to no platform
        node = tree.getNodeByPath("/mobile").getTrackDefinition("/homes")
        assertNotNull(node)
        assertEquals("promotions",node.properties["promotions"].description)
        assertEquals("layout", node.properties["layout"].description)

        //For ios should have all things of no platform plus the ios specific
        node = tree.getNodeByPath("/mobile/ios").getTrackDefinition("/homes/categories")
        assertNotNull(node)
        assertEquals("promotions",node.properties["promotions"].description)
        assertEquals("layout", node.properties["layout"].description)
        assertEquals("category", node.properties["category"].description)
    }


    @Test void shouldGetNullIfPlatformNotFound() {
        PlatformTree tree = new PlatformTree();
        tree.addNode("/");
        tree.addNode("/mobile");
        tree.addNode("/mobile/ios");
        assertNotNull(tree.getNodeByPath("/"))
        assertNotNull(tree.getNodeByPath("/mobile"))
        assertNotNull(tree.getNodeByPath("/mobile/ios"))
        assertNull(tree.getNodeByPath("/test"))
    }

    @Test void shouldThrowExceptionIfTrackDefinitionNotFound() {
        PlatformTree tree = new PlatformTree();
        tree.addNode("/");
        tree.addNode("/mobile");
        tree.addNode("/mobile/ios");
        tree.getNodeByPath("/").addTrackDefinition(new TrackDefinition("/homes/categories")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true)));
        assertNotNull(tree.getNodeByPath("/").getTrackDefinition("/homes/categories"))

        try {
            tree.getNodeByPath("/").getTrackDefinition("/test")
            fail("It should throw an exception")
        } catch (CatalogException e) {

        }

    }

}
