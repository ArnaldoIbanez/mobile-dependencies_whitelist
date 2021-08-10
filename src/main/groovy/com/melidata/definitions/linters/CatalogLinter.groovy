package com.melidata.definitions.linters

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl
import com.ml.melidata.catalog.utils.DslUtils
import com.ml.melidata.manager.CatalogHandler
import com.ml.melidata.manager.CatalogManager

class CatalogLinter {

    List<AbstractLinter> linters = []

    CatalogLinter() {
        linters.add(new PropertiesQuantityLinter(10))
        linters.add(new ObligatoryPropertiesLinter(["required", "description", "type", "name"]))
        linters.add(new NamingLinter())
        linters.add(new RequireValuesLinter(["mode", "type"]))
        linters.add(new ViewsAndEventsLinter(["show", "click", "action", "view", "tap"]))
        linters.add(new DeprecatedTypesLinter([PropertyType.Map, PropertyType.ArrayList]))
        linters.add(new PropertyNameBlackListLinter(
                ["data", "extra_info", "extra_data", "extra", "event_data", "id"],
                ["platform", "user", "device", "name", "required", "description"],
                ["user_id", "site_id", "colaborator_id", "bu", "business", "site", "experiment", "experiments"])
        )
    }

    CatalogLinter(List<AbstractLinter> lintersList) {
        this.linters = lintersList
    }

    boolean run(String catalogName) {
        def allLocalDefinitions = DslUtils.parseLocalCatalogByName(catalogName).platformTree.allDefinitions.toSet()

        CatalogDsl.setBaseDir("/")
        def handlerProd = new CatalogHandler(catalogName)
        handlerProd.reload()
        def allProdDefinitions = handlerProd.catalog.platformTree.allDefinitions.toSet()

        boolean isValid = true

        allLocalDefinitions.forEach { TrackDefinition definition ->
            if(!linters.every {it.passValidation(definition)}) {
                isValid = false
            }
        }


        println(allLocalDefinitions.findAll {newDefinition ->
            !allProdDefinitions.any {alreadyDefined ->
                println(newDefinition.path + " - " + alreadyDefined.path)
                alreadyDefined.equals(newDefinition)
            }
        }.collect {"${it.path}-${it.platform}"}.sort())

        return isValid
    }
}
