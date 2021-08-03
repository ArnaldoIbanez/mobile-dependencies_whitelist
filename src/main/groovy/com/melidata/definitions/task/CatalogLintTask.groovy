package com.melidata.definitions.task

import com.melidata.definitions.linters.CatalogLinter
import com.melidata.definitions.outs.StdOut
import com.melidata.definitions.validators.CatalogValidator
import com.ml.melidata.catalog.parsers.dsl.CatalogDsl

class CatalogLintTask {

    static void main(String[] args) {
        def status = true
        args.each { catalogName ->
            status = status && CatalogLinter.run(catalogName)
        }

        //If any test fails main program will exit with status=1
        if (!status)
            System.exit(1)
    }
}
