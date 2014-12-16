package com.ml.melidata.catalog.tree

import com.ml.melidata.catalog.TrackDefinition

/**
 * Created by geisbruch on 11/11/14.
 */
class CatalogTree extends TreeNode<TrackDefinition> {

    def TrackDefinition definition;

    def TrackDefinition basicDefinition;

    CatalogTree(String path) {
        super(path)
    }

    @Override
    def setNodeData(TrackDefinition data, List<TreeNode<TrackDefinition>> parents, Boolean override) {

        if(override) {
            basicDefinition = data;
        }

        TrackDefinition newDefinition = new TrackDefinition(data.path, data.type, data.platform);

        /**
         * If definition is already set, the new definition starts at least with
         * the actual content
         */
        if(definition)
            newDefinition.properties.putAll(definition.properties)

        parents.each { p ->
            def nodeData = p.getNodeData()
            if (nodeData)
                newDefinition.properties.putAll(nodeData.properties)
        }
        newDefinition.properties.putAll(data.properties)

        if(basicDefinition)
            newDefinition.properties.putAll(basicDefinition.properties)

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
