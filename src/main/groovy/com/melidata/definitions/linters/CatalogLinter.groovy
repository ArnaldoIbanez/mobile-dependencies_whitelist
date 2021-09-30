package com.melidata.definitions.linters

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl
import com.ml.melidata.catalog.utils.DslUtils
import com.ml.melidata.manager.CatalogHandler

class CatalogLinter {

    List<AbstractLinter> linters = []

    CatalogLinter() {

        linters.add(new PropertiesQuantityLinter(20))
        linters.add(new ObligatoryPropertiesLinter(["required", "description", "type", "name"]))
        linters.add(new MinimumRequiredTrueLinter(4))
        linters.add(new NamingLinter())
        linters.add(new ViewsAndEventsLinter(["show", "click", "action", "view", "tap"]))
        linters.add(new RequireValuesLinter(["mode", "type"]))
        linters.add(new DeprecatedTypesLinter([PropertyType.Map, PropertyType.ArrayList]))
        linters.add(new PropertyNameBlackListLinter(
                ["data", "extra_info", "extra_data", "extra", "event_data"],
                ["platform", "user", "device", "name", "required", "description", "mode"],
                ["user_id", "site_id", "colaborator_id", "bu", "business", "site", "experiment", "experiments"])
        )
    }

    CatalogLinter(List<AbstractLinter> lintersList) {
        this.linters = lintersList
    }

    boolean run(String catalogName) {
        boolean isValid = true

        def localDefinitions = getLocalDefinitions(catalogName)
        def prodDefinitions = getProdDefinitions(catalogName)

        localDefinitions.forEach {newDefinition ->
            def prodDef = prodDefinitions.findAll {it -> it.path == newDefinition.path && it.platform == newDefinition.platform}.toList()

            //Local definition is new to prod
            if(prodDef.isEmpty()) {
                if(!linters.every {it.passValidation(newDefinition)}) {
                    isValid = false
                }
            } else {
                if(!prodDef.any {newDefinition.equals(it)}) {
                    Map<String, TrackDefinitionProperty> propertiesMerge = [:]

                    newDefinition.properties.each {String name, TrackDefinitionProperty prop ->
                        if(!prodDef.collect {((Map) it.properties).values()}.flatten().contains(prop)) {
                            propertiesMerge.put(name, prop)
                        }
                    }


                    newDefinition.properties = propertiesMerge

                    if(!linters.every {it.validateProperties(newDefinition)}) {
                        isValid = false
                    }
                }
            }
        }

        return isValid
    }

    private Set getLocalDefinitions(String catalogName) {
        CatalogDsl.setBaseDir("src/main/resources/catalog/" + catalogName + "/")

        return DslUtils.parseCatalog(new File("src/main/resources/catalog/" + catalogName + "/catalog.groovy")).platformTree.allDefinitions.toSet()
    }

    private Set getProdDefinitions(String catalogName) {
        CatalogDsl.setBaseDir("/")
        def handlerProd = new CatalogHandler(catalogName)
        handlerProd.reload()

        return handlerProd.catalog.platformTree.allDefinitions.toSet()
    }
}
