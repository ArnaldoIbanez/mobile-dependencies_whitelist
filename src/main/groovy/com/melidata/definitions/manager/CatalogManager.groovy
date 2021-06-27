package com.melidata.definitions.manager

import com.ml.melidata.catalog.Catalog
import com.ml.melidata.Track
import com.ml.melidata.catalog.initiatives.InitiativeAPI

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by mtencer on 15/4/16.
 */
class CatalogManager implements Runnable {

	Map<String, CatalogHandler> catalogHandlers

	CatalogManager() {
		this.catalogHandlers = [:]
		addCatalogHandler("melidata")
		addCatalogHandler("shipping")
		addCatalogHandler("advertising")
		addCatalogHandler("component_prints")
		addCatalogHandler("cx_help_channels")
		addCatalogHandler("pushnotifications")
		addCatalogHandler("recommendations")
		addCatalogHandler("reviews")
	}

	CatalogManager(String catalogName) {
		this.catalogHandlers = [:]
		addCatalogHandler(catalogName)
	}

	void addCatalogHandler(String catalogName) {
		catalogHandlers[catalogName] = new CatalogHandler(catalogName)
	}

	void init() {
		InitiativeAPI.getInstance().init()
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
