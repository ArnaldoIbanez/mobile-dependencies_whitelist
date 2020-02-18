package com.melidata.definitions.manager

import com.ml.melidata.catalog.Catalog

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by mtencer on 15/4/16.
 */
class MetricsManager implements Runnable {

	private MetricsHandler metricsHandler

	public MetricsManager() {
		metricsHandler = new MetricsHandler();
	}

	public void init() {
		metricsHandler.reload()
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this, 0, 5, TimeUnit.MINUTES);
	}

	@Override
	public void run() {
		try {
			if ( metricsHandler.reload() ) {
				log.info(String.format("New metrics [version: %s] [etag: %s] has been loaded", metricsHandler.getVersion(), metricsHandler.getLastEtag()))
			}
			//updateVersionInDynamo();

		}catch (Throwable e){
			//log.error("Error checking metrics", e);
		}
	}

	public void close() throws IOException {
	}

	public getMetrics() {
		return metricsHandler.getMetrics()
	}

	public int getVersion() {
		return metricsHandler.getVersion()
	}
}
