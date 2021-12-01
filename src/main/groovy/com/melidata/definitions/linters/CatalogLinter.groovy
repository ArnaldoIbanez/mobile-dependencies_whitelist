package com.melidata.definitions.linters

import com.ml.melidata.Track
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.exceptions.CatalogException
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
        linters.add(new ViewsAndEventsLinter(["show", "click", "view", "tap"]))
        //linters.add(new RequireValuesLinter(["mode", "type"]))
        linters.add(new DeprecatedTypesLinter([PropertyType.Map, PropertyType.ArrayList]))
        linters.add(new PropertyNameBlackListLinter(
                ["data", "extra_info", "extra_data", "extra", "event_data", "payload", "response"],
                ["platform", "user", "device", "name", "mode"],
                ["user_id", "site_id", "colaborator_id", "business", "site", "experiment", "experiments"])
        )
    }

    CatalogLinter(List<AbstractLinter> lintersList) {
        this.linters = lintersList
    }

    boolean run(String catalogName) {
        boolean isValid = true

        def localCatalog = getLocalDefinitions(catalogName)
        def prodCatalog = getProdDefinitions(catalogName)

        def localDefinitions = localCatalog.platformTree.allDefinitions
        def prodDefinitions = prodCatalog.platformTree.allDefinitions

        def newPaths = []

        localDefinitions.forEach {newDefinition ->
            try {
                def prodDef = prodCatalog.getTrackDefinition(new Track(newDefinition.path, newDefinition.type, newDefinition.platform))

                //If the definition has a change, we validate its properties
                if(!prodDefinitions.any {newDefinition.equals(it)}) {
                    newDefinition.properties.keySet().removeAll(prodDef.properties.keySet())
                    if(!linters.every {it.validateProperties(newDefinition)}) {
                        isValid = false
                    }
                }
            } catch(CatalogException e) {
                def key = newDefinition.platform + "-" + newDefinition.path
                if (!newPaths.contains(key)) {
                    def inheritedProperties = []
                    newPaths.add(key)

                    newDefinition.properties.forEach { name, property ->
                        if(property.inherited) inheritedProperties.add(name)
                    }

                    newDefinition.properties.keySet().removeAll(inheritedProperties)
                    if(!linters.every {it.passValidation(newDefinition)}) {
                        isValid = false
                    }
                }
            }
        }

        return isValid
    }

    private Catalog getLocalDefinitions(String catalogName) {
        CatalogDsl.setBaseDir("src/main/resources/catalog/" + catalogName + "/")

        return DslUtils.parseCatalog(new File("src/main/resources/catalog/" + catalogName + "/catalog.groovy"))
    }

    private Catalog getProdDefinitions(String catalogName) {
        CatalogDsl.setBaseDir("/")
        def handlerProd = new CatalogHandler(catalogName)
        handlerProd.reload()

        return handlerProd.catalog
    }
}
