package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree

/**
 * Created by mtencer on 20/8/15.
 */
class CatalogCoverage {

	def Catalog catalog
	def Set<String> testedPaths

	def Map<String, Boolean> coverage
	def Double coveragePercent

	//TODO. esto es temporal, calcular los path internos que no son tracks validos (no estan en el catalogo) para no validarlos
	private def _exceptions

	def getExceptions() {
		if (!_exceptions)
			_exceptions = findAbstracts(getPlatforms(catalog.platformTrees.mercadolibre))

		_exceptions
	}


	def CatalogCoverage(Catalog catalog) {
		this.catalog = catalog
		this.testedPaths = new HashSet<String>()
	}

	def addTestRun(String path) {
		this.testedPaths.add(path)

		coverage = null
		coveragePercent = null
	}

	def traverse(PlatformTree t) {
		return t.children ? t.children.collect { k,v ->
			def c = traverse(v)
			c ?
				c.collect {
					new MapEntry(k+(k != '/' ? '/' : '')+it.key,it.value)
				}
			:
				[new MapEntry(k,v)]}.flatten()
		: []
	}

	def traverse(CatalogTree t) {
		return t.children ? t.children.collect { k,v ->
			def c = traverse(v)
			c ?
				[k] + c.collect{
					k+(k != '/' ? '/' : '')+it
				}
			: [k]
			}.flatten()
		: []
	}

	def getPlatforms(def t) {
		return traverse(t).collectEntries{[it.key,it.value]}
	}

	def getPaths(def p) {
		return p.collectEntries{k,v -> [k,traverse(v.tracksTree)]}
	}

	def findAbstracts(def p) {
		def c = p.children.values()
		c ? c.findAll{ it.definition?.isAbstract }*.definition?.path + c.collect{findAbstracts(it)}.flatten() : []
	}

	def findAbstracts(Map m) {
		m ? m.collect{findAbstracts(it.value.tracksTree)}.flatten().toSet() : []
	}

	def private computeCoverage() {
		if ( coverage == null ) {

			//compute coverage of all paths without platform
			def platforms = getPlatforms(catalog.platformTrees.mercadolibre)
			def pathsByPlatform = getPaths(platforms)
			def allPaths = new HashSet<String>()
			pathsByPlatform.each { platform, platformPaths ->
				allPaths.addAll(platformPaths)
			}

			def totalCount = 0
			def testsCount = 0

			coverage = [:]
			allPaths.toList().sort().each { path ->
				def tested = testedPaths.contains(path) || exceptions.contains(path)
				coverage.put(path, tested)
				totalCount++
				if (tested) testsCount++
			}


			coveragePercent = testsCount * 100 / totalCount
		}
	}

	def printCoverage() {
		computeCoverage()

		coverage.each { path, tested ->
			if ( ! tested ) {
				println "${path}: MISSING"
			}
		}

		printf("\nCoverage: %3.2f %%\n\n", coveragePercent)
	}

	def assertCoverage() {
		computeCoverage()

		if ( coveragePercent < 100 ) {
			throw new RuntimeException("Low Coverage (100 % expected but was ${coveragePercent} %)")
		}
	}
}
