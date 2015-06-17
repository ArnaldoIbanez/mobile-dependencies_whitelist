package com.melidata.definitions

import com.melidata.definitions.parsers.dsl.TestDsl
import com.melidata.definitions.outs.DefinitionsOut
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.TrackSourceType

/**
 * Created by apetalas on 20/11/14.
 */
class TestRunner {

    def static boolean run(Catalog catalog, List<TestDsl> tests, DefinitionsOut out, TrackSourceType sourceType = TrackSourceType.CLIENT){
        def runOk = true
        out.beforeRun(catalog, tests)
        tests?.each { singleTest ->
            if(singleTest.assertValid(catalog, sourceType)) {
                out.success(singleTest)
            } else {
                out.fail(singleTest)
                runOk = false
            }
        }
        out.afterRun()
        return runOk
    }

    def static boolean run(String pathCatalog, String pathTests, DefinitionsOut out, TrackSourceType sourceType = TrackSourceType.CLIENT){

        try{
            def catalogScript = getScriptFromFile(pathCatalog)
            def testsScript = getScriptFromFile(pathTests)

            def catalog = runScript(catalogScript)
            def tests = runScript(testsScript)

            return TestRunner.run(catalog, tests, out, sourceType)
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
