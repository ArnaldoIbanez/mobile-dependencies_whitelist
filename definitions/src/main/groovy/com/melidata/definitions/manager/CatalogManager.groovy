package com.melidata.definitions.manager

import com.ml.melidata.catalog.Catalog

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by mtencer on 15/4/16.
 */
class CatalogManager implements Runnable {

    private Map<String, CatalogHandler> catalogHandlers

	CatalogManager() {
		this.catalogHandlers = [:]
		addCatalogHandler("melidata")
		addCatalogHandler("shipping")
	}

	CatalogManager(catalogHandlers) {
		this.catalogHandlers = catalogHandlers
	}

	void addCatalogHandler(String catalogName) {
		catalogHandlers[catalogName] = new CatalogHandler(catalogName)
	}

	void init() {
		catalogHandlers.each{ _, catalogHandler -> catalogHandler.reload()}
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this, 0, 5, TimeUnit.MINUTES)
	}

	@Override
	void run() {
		try {
			for (catalogHandler in catalogHandlers.values()) {
				if (catalogHandler.reload()) {
					log.info(String.format("New catalog [version: %s] has been loaded", catalogHandler.getVersion()))
					//log.info(String.format("New catalog [version: %s] [etag: %s] has been loaded", catalogHandler.getVersion(), catalogHandler.getLastEtag()));
				}
				//updateVersionInDynamo();
			}

		}catch (Throwable e){
			//log.error("Error checking catalog", e);
		}
	}

	Catalog getCatalog(String catalogName) {
		return catalogHandlers[catalogName]?.getCatalog()
	}

    int getCatalogVersion(String catalogName) {
		return catalogHandlers[catalogName]?.getVersion()
	}
}
