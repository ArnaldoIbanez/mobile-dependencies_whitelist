package com.melidata.definitions.linters

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.TrackDefinition

class CatalogLinter {

    List<AbstractLinter> linters = []

    CatalogLinter() {
        linters.add(new PropertiesQuantityLinter(10))
        linters.add(new ObligatoryPropertiesLinter(["required", "description", "type"]))
        linters.add(new NamingLinter())
        linters.add(new ViewsAndEventsLinter(["show", "click", "action", "view", "tap"]))
        linters.add(new PropertyNameBlackListLinter(
                ["data", "extra_info", "extra_data", "extra", "event_data"],
                ["platform", "user", "device", "name", "required", "description"],
                ["user_id", "site_id", "colaborator_id", "bu", "business", "site"])
        )
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
