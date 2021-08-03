package com.melidata.definitions.linters

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.utils.DslUtils

class CatalogLinter {

    static boolean run(String catalogName) {
        Catalog catalog = DslUtils.parseLocalCatalogByName(catalogName)

        catalog.platformTree.allDefinitions.toSet().forEach { TrackDefinition definition ->
            Map<String, TrackDefinitionProperty> props = (Map<String,TrackDefinitionProperty>) definition.properties
            println("Track ${definition.path} has ${props.size()} properties for platform ${definition.platform}")
        }

        return true
    }
}
