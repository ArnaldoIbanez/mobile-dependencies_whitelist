package com.melidata.definitions.linters

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.TrackDefinition

class CatalogLinter {

    List<AbstractLinter> linters = []

    CatalogLinter() {
        linters.add(new PropertiesQuantityLinter(8))
        linters.add(new ObligatoryPropertiesLinter(["required", "description", "type"]))
    }

    CatalogLinter(List<AbstractLinter> lintersList) {
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
