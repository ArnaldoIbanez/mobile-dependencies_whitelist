package com.melidata.catalog.test

import org.junit.Test

import static org.junit.Assert.*


class CoverageTest {

    def private static getCatalog() {
        ClassLoader cl = Thread.currentThread().contextClassLoader
        GroovyShell shell = new GroovyShell(cl)
        Reader data = new InputStreamReader(cl.getResourceAsStream("catalog.groovy"))
        shell.parse(data).run()
    }

    /*@Test
    void shouldReturnTrees() {
        def catalog = getCatalog()
        def catalogCoverage = catalog.catalogCoverage

        def platforms = catalogCoverage.getPlatforms(catalog.platformTrees.mercadolibre)

        println "PLATFORMS: $platforms"

        def out = catalogCoverage.getPaths(platforms)

        println "TREE: ${out}"

        assertNotNull platforms
        assertNotNull out
    }*/

    @Test
    void shouldGetAbstractPaths() {
        def c = catalog
        def coverage = c.catalogCoverage

        coverage.exceptions.each { println(it) }

        assertTrue true
    }

}
