package com.melidata.catalog.test

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.tree.CatalogTree
import org.junit.Test
import static org.junit.Assert.*

/**
 * Created by geisbruch on 11/11/14.
 */

class CatalogTreeTest {

    @Test void testAddElementToCatalogTree() {
        CatalogTree tree = new CatalogTree();
        tree.addNode("/search",new TrackDefinition("/search")
                                    .addProperty(new TrackDefinitionProperty("name":"test","description":"1"))
                                    .addProperty(new TrackDefinitionProperty("name":"test2","description":"1")))

        TrackDefinition node = tree.getNodeByPath("/search").getNodeData()
        assertNotNull(node)
        assertEquals("1",node.properties["test"].description)
        assertEquals("1", node.properties["test2"].description)

    }

    @Test void testCheckSimpleHierarchy() {
        CatalogTree tree = new CatalogTree();
        tree.addNode("/search",new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty("name":"test","description":"1"))
                .addProperty(new TrackDefinitionProperty("name":"test2","description":"1")))
        tree.addNode("/search/refine",new TrackDefinition("/search/refine")
                .addProperty(new TrackDefinitionProperty("name":"test3","description":"3"))
                .addProperty(new TrackDefinitionProperty("name":"test4","description":"4")))

        TrackDefinition node = tree.getNodeByPath("/search").getNodeData()
        assertNotNull(node)
        assertEquals("1",node.properties["test"].description)
        assertEquals("1", node.properties["test2"].description)
        node = tree.getNodeByPath("/search/refine").getNodeData()
        assertNotNull(node)
        assertEquals("1",node.properties["test"].description)
        assertEquals("1", node.properties["test2"].description)
        assertEquals("3",node.properties["test3"].description)
        assertEquals("4", node.properties["test4"].description)
    }

    @Test void checkInverseOrderHierarchy() {
        CatalogTree tree = new CatalogTree();
        tree.addNode("/search/refine",new TrackDefinition("/search/refine")
                .addProperty(new TrackDefinitionProperty("name":"test3","description":"3"))
                .addProperty(new TrackDefinitionProperty("name":"test4","description":"4")))
        tree.addNode("/search",new TrackDefinition("/search")
                .addProperty(new TrackDefinitionProperty("name":"test3","description":"1"))
                .addProperty(new TrackDefinitionProperty("name":"test4","description":"1")))

        TrackDefinition node = tree.getNodeByPath("/search").getNodeData()
        assertNotNull(node)
        assertEquals("1",node.properties["test3"].description)
        assertEquals("1", node.properties["test4"].description)
        node = tree.getNodeByPath("/search/refine").getNodeData()
        assertNotNull(node)
        assertEquals("3",node.properties["test3"].description)
        assertEquals("4", node.properties["test4"].description)
    }

    @Test void addDefaultsToSlash() {
        CatalogTree tree = new CatalogTree();

        tree.addNode("/homes/categories",new TrackDefinition("/homes/categories")
                .addProperty(new TrackDefinitionProperty(name:"category", description: "category", required: true)));

        tree.addNode("/homes",new TrackDefinition("/homes")
                .addProperty(new TrackDefinitionProperty(name:"promotions", description: "promotions", required: true))
                .addProperty(new TrackDefinitionProperty(name:"layout", description:"layout", required: true)));

        tree.addNode("/", new TrackDefinition("/")
                .addProperty(new TrackDefinitionProperty(name:"time",description:"time")));

        TrackDefinition node = tree.getNodeByPath("/homes").getNodeData()
        assertNotNull(node)
        assertEquals("promotions",node.properties["promotions"].description)
        assertEquals("layout", node.properties["layout"].description)
        assertEquals("time", node.properties["time"].description)
        node = tree.getNodeByPath("/homes/categories").getNodeData()
        assertNotNull(node)
        assertEquals("promotions",node.properties["promotions"].description)
        assertEquals("layout", node.properties["layout"].description)
        assertEquals("time", node.properties["time"].description)
        assertEquals("category", node.properties["category"].description)

    }

    @Test void shouldInheritFromFather() {
        CatalogTree tree = new CatalogTree()

        assertFalse(tree.shouldInheritAttribute(false, false))
        assertFalse(tree.shouldInheritAttribute(false, true))
        assertTrue(tree.shouldInheritAttribute(true, false))
        assertFalse(tree.shouldInheritAttribute(true, true))
    }
}
