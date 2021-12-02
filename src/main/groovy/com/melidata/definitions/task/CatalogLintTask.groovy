package com.melidata.definitions.task

import com.melidata.definitions.linters.CatalogLinter
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.utils.DslUtils
import groovy.json.JsonSlurper

class CatalogLintTask {

    static void main(String[] args) {
        def status = true

        def context = System.getenv('BUILD_CONTEXT')
        def parser = new JsonSlurper()
        def json = parser.parseText(context)
        
        println(json['git_is_merge'])

        CatalogLinter cl = new CatalogLinter()
        args.each { catalogName ->
            status = status && cl.run(catalogName)
        }

        //If any test fails main program will exit with status=1
        if (!status)
            System.exit(1)
    }
}
