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

        TrackDefinition newDefinition = new TrackDefinition(data.path, data.type, data.platform, data.business, data.parentPropertiesInherited, data.isAbstract);

        /**
         * If definition is already set, the new definition starts at least with
         * the actual content
         */
        if(definition)
            newDefinition.properties.putAll(definition.properties)

        if ( newDefinition.parentPropertiesInherited ) {
            def validParents = []
            def stopAdding = false
            parents.reverseEach { p ->
                //add parents until first parentPropertiesInherited = false
                if ( !stopAdding ) {
                    validParents << p
                    if (p.getNodeData() != null && !p.getNodeData().getParentPropertiesInherited()) {
                        stopAdding = true
                    }
                }
            }
            validParents.reverseEach { p ->
                def nodeData = p.getNodeData()
                if (nodeData) {
                    nodeData.properties.each { name, property ->
                        if ( property.inheritable ) {
                            newDefinition.properties.put(name, property)
                        }
                    }

                }
            }
        }
        newDefinition.properties.putAll(data.properties)

        if(basicDefinition)
            newDefinition.properties.putAll(basicDefinition.properties)

        definition = newDefinition;
        fireDataChange();

    }

    def fireDataChange() {
        children.each { k, c ->
            if (c.getNodeData() == null)
                throw new Exception("Missing path ${definition.path}/${k}. Probably you forgot to declare it abstract")
            c.setNodeData(c.getNodeData(), [this], false)
        }
    }

    @Override
    def TrackDefinition getNodeData() {
        return definition
    }


}
