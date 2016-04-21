package com.melidata.definitions.manager

import com.ml.melidata.catalog.Catalog

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by mtencer on 15/4/16.
 */
class CatalogManager implements Runnable {

	private CatalogHandler catalogHandler

	public CatalogManager() {
		catalogHandler = new CatalogHandler();
	}

	public void init() {
		catalogHandler.reload()
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this, 0, 5, TimeUnit.MINUTES);
	}

	@Override
	public void run() {
		try {
			if ( catalogHandler.reload() ) {
				log.info(String.format("New catalog [version: %s] [etag: %s] has been loaded", catalogHandler.getVersion(), catalogHandler.getLastEtag()))
				//log.info(String.format("New catalog [version: %s] [etag: %s] has been loaded", catalogHandler.getVersion(), catalogHandler.getLastEtag()));
			}
			//updateVersionInDynamo();

		}catch (Throwable e){
			//log.error("Error checking catalog", e);
		}
	}

	@Override
	public void close() throws IOException {
	}

	public Catalog getCatalog() {
		return catalogHandler.getCatalog()
	}

	public int getVersion() {
		return catalogHandler.getVersion()
	}
}
