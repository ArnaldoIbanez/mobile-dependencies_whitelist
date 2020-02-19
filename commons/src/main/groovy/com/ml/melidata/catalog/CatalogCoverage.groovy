package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree

/**
 * Created by mtencer on 20/8/15.
 */
class CatalogCoverage {

	def Catalog catalog
	def Set<String> testedPaths
        def Set<String> assertCoverageBusiness = ["mercadolibre" , "mercadopago", "shipping", "advertising", "component_prints", "cx_help_channels", "pushnotifications", "recommendations", "reviews"]

	def Map<TestablePath, Boolean> coverage
	def Double coveragePercent

	//TODO. esto es temporal, calcular los path internos que no son tracks validos (no estan en el catalogo) para no validarlos
	private Set<TestablePath> _exceptions

	def getExceptions() {
		if (!_exceptions) {
			_exceptions = new HashSet<TestablePath>()
			catalog.platformTrees.each { b,v ->
                def abstracts = findAbstracts(getPlatforms(v))
                abstracts.each { a ->
                    _exceptions.addAll( new TestablePath( a, b))
                }
			}
		}

		_exceptions
	}


	def CatalogCoverage(Catalog catalog) {
		this.catalog = catalog
		this.testedPaths = new HashSet<TestablePath>()
	}

	def addTestRun(String path, String business) {
		assert path!=null
                assert business !=null
                this.testedPaths.add(new TestablePath(path,business))

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

	Set<String> findAbstracts(def p) {
		def c = p.children.values()
		c ? c.findAll{ it.definition?.isAbstract }*.definition?.path + c.collect{findAbstracts(it)}.flatten() : []
	}

	Set<String> findAbstracts(Map m) {
		m ? m.collect{findAbstracts(it.value.tracksTree)}.flatten().toSet() : []
	}

	def private computeCoverage() {
		if ( coverage == null ) {

			def totalCount = 0
			def testsCount = 0

			coverage = [:]
			def allPaths = new HashSet<String>()

			//compute coverage of all paths without platform
			catalog.platformTrees.each { b, v ->
                allPaths = new HashSet<String>()
				def platforms = getPlatforms(v)
				def pathsByPlatform = getPaths(platforms)
				pathsByPlatform.each { platform, platformPaths ->
                    if ( assertCoverageBusiness.contains(b)){
                        allPaths.addAll(platformPaths)
                    }
				}

				allPaths.toList().sort().each { path ->
                    def pathToTest = new TestablePath(path, b)
                    def tested = testedPaths.contains(pathToTest) || exceptions.contains(pathToTest)
					coverage.put(pathToTest, tested)
					totalCount++
					if (tested) testsCount++
				}

			}
			coveragePercent = testsCount * 100 / totalCount
		}
	}

	def printCoverage() {
		computeCoverage()

		coverage.each { testablePath, tested ->
			if ( ! tested ) {
				println "Path: ${testablePath.path} for business ${testablePath.business} => MISSING"
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

    class TestablePath {
        String path
        String business

        TestablePath(String path, String business) {
            this.path = path
            this.business = business
        }

        boolean equals(o) {
            if (this.is(o)) return true
            if (getClass() != o.class) return false

            TestablePath that = (TestablePath) o

            if (business != that.business) return false
            if (path != that.path) return false

            return true
        }

        int hashCode() {
            int result
            result = path.hashCode()
            result = 31 * result + business.hashCode()
            return result
        }
    }
}
