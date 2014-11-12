package com.ml.melidata.catalog.tree

import com.ml.melidata.catalog.TrackDefinition

/**
 * Created by geisbruch on 11/11/14.
 */
class CatalogTree extends TreeNode<TrackDefinition> {

    def TrackDefinition originalDefinition;

    def TrackDefinition definition;

    CatalogTree(String path) {
        super(path)
    }

    @Override
    def setNodeData(TrackDefinition data, List<TreeNode<TrackDefinition>> parents, Boolean override) {
        //Check for override or merge
        if (!override && originalDefinition) {
            //Keep original data
            data.properties.putAll(originalDefinition.properties);
            originalDefinition = data
        }
        originalDefinition = data;
        TrackDefinition newDefinition = new TrackDefinition(data.path, data.type, data.platform, data.subPlatform);
        parents.each { p ->
            def nodeData = p.getNodeData()
            if (nodeData)
                newDefinition.properties.putAll(nodeData.properties)
        }
        newDefinition.properties.putAll(originalDefinition.properties)
        definition = newDefinition;
        fireDataChange();

    }

    def fireDataChange() {
        children.each { k, c ->
            c.setNodeData(c.getNodeData(), [this], false)
        }
    }

    @Override
    def TrackDefinition getNodeData() {
        return definition
    }


}
