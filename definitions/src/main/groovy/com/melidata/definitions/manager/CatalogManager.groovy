package com.melidata.definitions.manager

import com.ml.melidata.catalog.Catalog

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by mtencer on 15/4/16.
 */
class CatalogManager implements Runnable {

    private CatalogHandler catalogHandler

	CatalogManager(String lastVersionObject, String lastVersionFileName, String localFolder, String s3Container, String s3CatalogFile, String csvFileName) {
        catalogHandler = new CatalogHandler(lastVersionObject, lastVersionFileName, localFolder, s3Container, s3CatalogFile, csvFileName)
	}

	void init() {
		catalogHandler.reload()
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this, 0, 5, TimeUnit.MINUTES)
	}

	@Override
	void run() {
		try {
			if ( catalogHandler.reload() ) {
				log.info(String.format("New catalog [version: %s] has been loaded", catalogHandler.getVersion()))
				//log.info(String.format("New catalog [version: %s] [etag: %s] has been loaded", catalogHandler.getVersion(), catalogHandler.getLastEtag()));
			}
			//updateVersionInDynamo();

		}catch (Throwable e){
			//log.error("Error checking catalog", e);
		}
	}

	@Override
	void close() throws IOException {
	}

	Catalog getCatalog() {
		return catalogHandler.getCatalog()
	}

    int getVersion() {
		return catalogHandler.getVersion()
	}
}
