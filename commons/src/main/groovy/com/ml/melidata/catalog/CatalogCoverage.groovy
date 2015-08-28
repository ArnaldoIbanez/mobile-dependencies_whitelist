package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree

import java.text.NumberFormat

/**
 * Created by mtencer on 20/8/15.
 */
class CatalogCoverage {

	def Catalog catalog
	def Set<String> testedPaths

	def Map<String, Boolean> coverage
	def Double coveragePercent

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
		return t.children ? t.children.collect{k,v -> def c = traverse(v); c ? c.collect{new MapEntry(k+(k != '/' ? '/' : '')+it.key,it.value)} : [new MapEntry(k,v)]}.flatten() : []
	}

	def traverse(CatalogTree t) {
		return t.children ? t.children.collect{k,v -> def c = traverse(v); c ? [k] + c.collect{k+(k != '/' ? '/' : '')+it} : [k]}.flatten() : []
	}

	def getPlatforms(def t) {
		return traverse(t).collectEntries{[it.key,it.value]}
	}

	def getPaths(def p) {
		return p.collectEntries{k,v -> [k,traverse(v.tracksTree)]}
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
				def tested = testedPaths.contains(path)
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
			println "${path}: ${tested ? "TESTED" : "MISSING"}"
		}

		printf("\nCoverage: %3.2f %%\n", coveragePercent)
	}

	def assertCoverage() {
		computeCoverage()

		if ( coveragePercent < 50 ) {
			throw new RuntimeException("Low Coverage (50 % expected but was ${coveragePercent} %%)")
		}
	}
}
