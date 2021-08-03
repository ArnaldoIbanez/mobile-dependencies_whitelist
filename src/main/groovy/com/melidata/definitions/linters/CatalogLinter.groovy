package com.melidata.definitions.linters

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.utils.DslUtils

class CatalogLinter {

    List<LinterInterface> linters = []

    CatalogLinter() {
        linters.add(new PropertiesQuantityLinter(5))
    }

    CatalogLinter(List<LinterInterface> lintersList) {
        this.linters = lintersList
    }

    boolean run(Catalog catalog) {
        boolean isValid = true

        catalog.platformTree.allDefinitions.toSet().forEach { TrackDefinition definition ->
            if(!linters.every {it.passValidation(definition)}) {
                isValid = false
            }
        }

        return isValid
    }
}
