package com.ml.melidata.catalog.tree

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

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

        TrackDefinition newDefinition = new TrackDefinition(data.path, data.initiative, data.defaultInitiative, data.application, data.applicationForPlatform, data.type, data.platform, data.business,
                data.parentPropertiesInherited, data.isAbstract)

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
                    nodeData.properties.each { String name, TrackDefinitionProperty property ->
                        if ( property.inheritable ) {
                            newDefinition.properties.put(name, property)
                        }
                    }
                }
            }

            validParents.each { CatalogTree p ->
                TrackDefinition nodeData = p.getNodeData()
                if(nodeData) {
                    if (shouldInheritAttribute(nodeData.application, newDefinition.application)) {
                        newDefinition.application = nodeData.application
                    }

                    if (shouldInheritAttribute(nodeData.initiative, newDefinition.initiative)) {
                        newDefinition.initiative = nodeData.initiative
                        return
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
                throw new Exception("Missing path ${definition.path}/${k}. Probably you forgot to declare it abstract or for the specified platform")
            c.setNodeData(c.getNodeData(), [this], false)
        }
    }

    @Override
    TrackDefinition getNodeData() {
        return definition
    }

    boolean shouldInheritAttribute(fatherAttribute, childAttribute) {
        return fatherAttribute && !childAttribute
    }


}
