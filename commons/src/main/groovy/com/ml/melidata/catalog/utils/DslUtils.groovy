package com.ml.melidata.catalog.utils

import com.ml.melidata.catalog.parsers.dsl.CatalogDsl

/**
 * Created by geisbruch on 17/12/14.
 */
class DslUtils {
    def public static Catalog parseCatalog(InputStream stream) {
        return parseCatalog(new InputStreamReader(stream))
    }

    def public static Catalog parseCatalog(Reader stream) {
        GroovyShell shell = createShell()
        return (Catalog)shell.parse(stream).run()
    }

    def public static Catalog parseCatalog(File file) {
        return (Catalog)parse(file)
    }

    def public static parse(File file) {
        GroovyShell shell = createShell()
        return shell.parse(file).run()
    }

    def public static setBaseDir(String dir) {
        CatalogDsl.setBaseDir(dir)
    }

    private static GroovyShell createShell() {
        new GroovyShell(Thread.currentThread().getContextClassLoader())
    }
}

