package com.melidata.catalog.test

import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree
import org.junit.Test

import static org.junit.Assert.*


class CoverageTest {

    def getCatalog() {
        ClassLoader cl = Thread.currentThread().contextClassLoader
        GroovyShell shell = new GroovyShell(cl)
        Reader data = new InputStreamReader(cl.getResourceAsStream("catalog.groovy"))
        shell.parse(data).run()
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

    @Test
    void shouldReturnTrees() {
        def catalog = getCatalog()
        def platforms = getPlatforms(catalog.platformTrees.mercadolibre)

        println "PLATFORMS: $platforms"

        def out = getPaths(platforms)

        println "TREE: ${out}"

        assertNotNull platforms
        assertNotNull out
    }

}
