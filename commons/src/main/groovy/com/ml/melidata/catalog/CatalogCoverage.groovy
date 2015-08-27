package com.ml.melidata.catalog

/**
 * Created by mtencer on 20/8/15.
 */
class CatalogCoverage {

	def Catalog catalog
	def Set<String> testedPaths

	def CatalogCoverage(Catalog catalog) {
		this.catalog = catalog
		this.testedPaths = new HashSet<String>()
	}

	def addTestRun(String path) {
		this.testedPaths.add(path)
	}

	def getCoverage() {
		//TODO: iterar los paths del catalogo y verificar cuales no estan en testedPaths
	}
}
