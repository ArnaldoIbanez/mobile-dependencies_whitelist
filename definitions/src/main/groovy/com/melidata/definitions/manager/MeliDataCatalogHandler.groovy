package com.melidata.definitions.manager

/**
 * Created by mtencer on 5/4/16.
 */
class MeliDataCatalogHandler extends CatalogHandler {

    def MeliDataCatalogHandler() {
        super("lastMeliDataVersion", "lastMeliData", "/data/catalog/", ".dsl/", "catalog2.groovy", "melidata_last.csv/melidata_catalog.csv") //leerlos de una config
    }

}

