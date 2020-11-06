package com.melidata.definitions.manager


class LambdaCatalogManager extends CatalogManager {

    public LambdaCatalogManager() {
        super()
    }
    public LambdaCatalogManager(String catalogName) {
        super(catalogName)
    }

    @Override
    void addCatalogHandler(String catalogName) {
        catalogHandlers[catalogName] = new LambdaCatalogHandler(catalogName)
    }

    @Override
    void init() {
        catalogHandlers.each {_, catalogHandler -> catalogHandler.reload()}
    }
}
