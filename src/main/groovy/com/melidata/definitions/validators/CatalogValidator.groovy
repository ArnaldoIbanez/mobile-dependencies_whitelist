package com.melidata.definitions.validators

import com.melidata.definitions.parsers.dsl.TestDsl
import com.melidata.definitions.outs.DefinitionsOut
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.initiatives.InitiativeAPI
import groovy.transform.Synchronized
/**
 * Created by apetalas on 20/11/14.
 */
class CatalogValidator {

    def static boolean run(Catalog catalog, ArrayList<TestDsl> tests, DefinitionsOut out){
        def runOk = true
        out.beforeRun(catalog, tests)
        if(!InitiativeAPI.getInstance().initiatives) {
            InitiativeAPI.getInstance().run()
        }
        tests?.each { singleTest ->
            println( "Running test: ${singleTest.name}")

            if(singleTest.assertValid(catalog)) {
                out.success(singleTest)
            } else {
                out.fail(singleTest)
                runOk = false
            }
        }
        try {
            out.afterRun(catalog)
        } catch(Exception e) {
            runOk = false
        }
        runOk = runOk && InitiativeValidate.checkCoverage()
        return runOk
    }

    @Synchronized
    def static boolean run(String catalogName, DefinitionsOut out){
        try{
            def pathTests = getTests(catalogName)
            def catalogScript = getScriptFromFile("src/main/resources/catalog/" + catalogName + "/catalog.groovy")
            def testsScript = new ArrayList<Script>()
            pathTests.each { testsScript.add(getScriptFromFile(it)) }

            println("Building catalog ${catalogName}....")
            def catalog = runScript(catalogScript)
            println("Ready")

            def tests = new ArrayList<TestDsl>()
            testsScript.each { tests.addAll(runScript(it)) }

            return run(catalog, tests, out)

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

    private static List<String> getTests(String catalogName) {
        return new File("src/test/resources/" + catalogName + "/").listFiles().collect{ it -> it.getAbsolutePath() }
    }
}
