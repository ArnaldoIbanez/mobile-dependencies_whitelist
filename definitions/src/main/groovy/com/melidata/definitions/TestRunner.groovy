package com.melidata.definitions

import com.melidata.definitions.parsers.dsl.TestDsl
import com.melidata.definitions.outs.TestOut
import com.ml.melidata.catalog.Catalog

/**
 * Created by apetalas on 20/11/14.
 */
class TestRunner {

    def static boolean run(Catalog catalog, ArrayList<TestDsl> tests, TestOut out){
        def runOk = true
        out.beforeRun(catalog, tests)
        tests?.each { singleTest ->
            if(singleTest.assertValid(catalog)) {
                out.success(singleTest)
            } else {
                out.fail(singleTest)
                runOk = false
            }
        }
        out.afterRun()
        return runOk
    }

    def static boolean run(String pathCatalog, String pathTests, TestOut out){
        GroovyShell shell = new GroovyShell()

        def catalogScript = shell.parse(new File(pathCatalog))
        def testsScript = shell.parse(new File(pathTests))
        def catalog = catalogScript.run()
        def tests = testsScript.run()

        return TestRunner.run(catalog, tests, out)


    }
}
