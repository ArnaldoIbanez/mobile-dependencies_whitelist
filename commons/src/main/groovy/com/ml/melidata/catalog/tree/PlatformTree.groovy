package com.ml.melidata.catalog.tree

import com.ml.melidata.catalog.TrackDefinition

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

    def addTrackDefinition(TrackDefinition definition) {
        platformTree.addNode(definition.path, definition);
        this.children.each {k,c ->
            c.addTrackDefinition(definition);
        }
    }

    def getTrackDefinition(String path) {
        platformTree.getNodeByPath(path).getNodeData();
    }

    def CatalogTree getNodeData(){
        return platformTree
    }
}
