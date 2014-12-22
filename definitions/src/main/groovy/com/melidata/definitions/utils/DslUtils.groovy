package com.melidata.definitions.utils

import com.ml.melidata.catalog.Catalog

/**
 * Created by geisbruch on 17/12/14.
 */
class DslUtils {
    def public static Catalog parseCatalog(InputStream stream) {
        return parseCatalog(new InputStreamReader(stream))
    }

    def public static Catalog parseCatalog(Reader stream) {
        GroovyShell shell = new GroovyShell()
        return (Catalog)shell.parse(stream).run()
    }

    def public static Catalog parseCatalog(File file) {
        GroovyShell shell = new GroovyShell()
        return (Catalog)shell.parse(new File(file)).run()
    }
}
