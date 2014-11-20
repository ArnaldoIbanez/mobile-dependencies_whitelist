package com.melidata.definitions.outs
/**
 * Created by apetalas on 20/11/14.
 */
public interface TestOut {

    def fail(test)

    def success(test)

    def beforeRun(catalog, tests)

    def afterRun()

}


