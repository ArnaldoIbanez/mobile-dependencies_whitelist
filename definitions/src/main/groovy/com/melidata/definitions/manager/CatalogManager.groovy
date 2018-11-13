package com.melidata.definitions.manager

import com.ml.melidata.catalog.Catalog

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by mtencer on 15/4/16.
 */
class CatalogManager implements Runnable {

	private MeliDataCatalogHandler meliDatacatalogHandler
	private ShippingCatalogHandler shippingCatalogHandler

	public CatalogManager() {
		meliDatacatalogHandler = new MeliDataCatalogHandler()
		shippingCatalogHandler = new ShippingCatalogHandler()
	}

	public void init() {
		meliDatacatalogHandler.reload()
		shippingCatalogHandler.reload()
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this, 0, 5, TimeUnit.MINUTES);
	}

	@Override
	public void run() {
		try {
			if ( meliDatacatalogHandler.reload() ) {
				log.info(String.format("New meli data catalog [version: %s] has been loaded", meliDatacatalogHandler.getVersion()))
				//log.info(String.format("New catalog [version: %s] [etag: %s] has been loaded", catalogHandler.getVersion(), catalogHandler.getLastEtag()));
			}
			if ( shippingCatalogHandler.reload() ) {
				log.info(String.format("New shipping catalog [version: %s] has been loaded", shippingCatalogHandler.getVersion()))
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

	public Catalog getMeliDataCatalog() { ////razon para la cual hacer varios catalogs manager
		return meliDatacatalogHandler.getCatalog()
	}

	public Catalog getShippingCatalog() { ////razon para la cual hacer varios catalogs manager
		return shippingCatalogHandler.getCatalog()
	}

	public int getMeliDataVersion() { ////razon para la cual hacer varios catalogs manager
		return meliDatacatalogHandler.getVersion()
	}

	public int getShippingVersion() { ////razon para la cual hacer varios catalogs manager
		return shippingCatalogHandler.getVersion()
	}
}
