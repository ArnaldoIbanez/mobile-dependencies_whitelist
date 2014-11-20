package com.melidata.definitions

import com.melidata.definitions.parsers.dsl.TestDsl
import com.melidata.definitions.outs.TestOut
import com.ml.melidata.catalog.Catalog

/**
 * Created by apetalas on 20/11/14.
 */
class TestRunner {

    def static run(Catalog catalog, ArrayList<TestDsl> tests, TestOut out){

        out.beforeRun(catalog, tests)
        tests?.each { singleTest ->
            singleTest.assertThat(catalog) ? out.success(singleTest) : out.fail(singleTest)
        }

        out.afterRun()
    }

    def static run(String pathCatalog, String pathTests, TestOut out){
        GroovyShell shell = new GroovyShell()

        def catalogScript = shell.parse(new File(pathCatalog))
        def testsScript = shell.parse(new File(pathTests))
        def catalog = catalogScript.run()
        def tests = testsScript.run()

        TestRunner.run(catalog, tests, out)


    }
}
