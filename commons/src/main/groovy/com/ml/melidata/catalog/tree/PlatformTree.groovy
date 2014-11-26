package com.ml.melidata.catalog.tree

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.exceptions.CatalogException

/**
 * Created by geisbruch on 11/11/14.
 */
class PlatformTree extends TreeNode<CatalogTree> {

    CatalogTree platformTree;

    PlatformTree(String path) {
        super(path)
        platformTree = new CatalogTree();
    }

    def setNodeData(CatalogTree data, List<TreeNode<CatalogTree>> parents, Boolean override = false) {
        data != null ? platformTree = data: platformTree;
        return platformTree
    }

    /**
     * This helper will add the node to the platform and propagate the change
     * to all sub-platforms
     *
     * @param definition
     * @param override
     * @return
     */
    def addTrackDefinition(TrackDefinition definition, Boolean override = true) {
        platformTree.addNode(definition.path, definition, override);
        this.children.each {k,c ->
            //On sub-elements should not override
            c.addTrackDefinition(definition, false);
        }
    }

    /**
     * It will look in the catalog tree for the definition
     * @param path
     * @return
     */
    def getTrackDefinition(String path) {
        def catalogNode = platformTree.getNodeByPath(path);
        if(!catalogNode) {
            throw  new CatalogException("Path '${path}' not found in catalog (check if it's defined in " +
                    "the catalog file and if it's defined for the specified platform)")
        }
        return catalogNode.getNodeData();
    }

    def CatalogTree getNodeData(){
        return platformTree
    }
}
