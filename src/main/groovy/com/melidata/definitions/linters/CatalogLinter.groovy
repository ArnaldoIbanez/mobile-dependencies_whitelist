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
        linters.add(new PropertiesQuantityLinter(20))
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

    List<TrackDefinition> getDefinitionsToEvaluate(String catalogName) {
        CatalogDsl.setBaseDir("src/main/resources/catalog/" + catalogName + "/")

        def allLocalDefinitions = DslUtils.parseCatalog(new File("src/main/resources/catalog/" + catalogName + "/catalog.groovy")).platformTree.allDefinitions.toSet()

        CatalogDsl.setBaseDir("/")
        def handlerProd = new CatalogHandler(catalogName)
        handlerProd.reload()
        def allProdDefinitions = handlerProd.catalog.platformTree.allDefinitions.toSet()

        return allLocalDefinitions.findAll {newDefinition ->
            !allProdDefinitions.any {alreadyDefined ->
                newDefinition.equals(alreadyDefined)
            }
        }.toList()
    }

    boolean run(String catalogName) {
        def touchedDefinitions = getDefinitionsToEvaluate(catalogName)
        boolean isValid = true

        touchedDefinitions.forEach { TrackDefinition definition ->
            if(!linters.every {it.passValidation(definition)}) {
                isValid = false
            }
        }
        
        println(touchedDefinitions.collect {"${it.path}-${it.platform}"}.sort())

        return isValid
    }
}
