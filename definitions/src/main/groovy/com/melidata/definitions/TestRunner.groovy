package com.melidata.definitions

import com.melidata.definitions.parsers.dsl.TestDsl
import com.melidata.definitions.outs.DefinitionsOut
import com.ml.melidata.catalog.Catalog
import groovy.transform.Synchronized

/**
 * Created by apetalas on 20/11/14.
 */
class TestRunner {

    def static boolean run(Catalog catalog, ArrayList<TestDsl> tests, DefinitionsOut out){
        def runOk = true
        out.beforeRun(catalog, tests)
        tests?.each { singleTest ->
            println( "Running test: ${singleTest.name}")

            if(singleTest.assertValid(catalog)) {
                out.success(singleTest)
            } else {
                out.fail(singleTest)
                runOk = false
            }
        }
        out.afterRun(catalog)
        return runOk
    }

    @Synchronized
    def static boolean run(String pathCatalog, String pathTests, DefinitionsOut out) {
        return run(pathCatalog, Arrays.asList(pathTests), out)
    }

    @Synchronized
    def static boolean run(String pathCatalog, List<String> pathTests, DefinitionsOut out){

        try{
            def catalogScript = getScriptFromFile(pathCatalog)
            def testsScript = new ArrayList<Script>()
            pathTests.each { testsScript.add(getScriptFromFile(it)) }

            println("Building catalog....")
            def catalog = runScript(catalogScript)
            println("Ready")

            def tests = new ArrayList<TestDsl>()
            testsScript.each { tests.addAll(runScript(it)) }

            return TestRunner.run(catalog, tests, out)

        }
        catch (FileNotFoundException x){
            throw x
        }
    }

    def static Script getScriptFromFile(String path){
        GroovyShell shell = new GroovyShell()
        return shell.parse(new File(path))
    }

    def static Object runScript(Script toRun){
        return toRun.run()
    }
}
