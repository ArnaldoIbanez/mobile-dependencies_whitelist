package com.ml.melidata.catalog

class CatalogFactory {

    public static Catalog getCatalog() {
        ClassLoader cl = Thread.currentThread().contextClassLoader
        GroovyShell shell = new GroovyShell(cl)
        Reader data = new InputStreamReader(cl.getResourceAsStream("catalog.groovy"))
        shell.parse(data).run()
    }

}
