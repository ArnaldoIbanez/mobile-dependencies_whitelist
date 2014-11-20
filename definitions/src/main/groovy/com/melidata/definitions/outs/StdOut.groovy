package com.melidata.definitions.outs
/**
 * Created by apetalas on 20/11/14.
 */
class StdOut implements TestOut {

    def messages = [:]

    @Override
    def fail(Object test) {
        messages.put(test.name, test.messages)
        print "X"

    }

    @Override
    def success(Object test) {
        //print("\033[32m"); // green
        print "."
        //print("\033[37m"); // white
    }

    @Override
    def beforeRun(catalog, tests) {
        println "*************************************"
        println "Ready to run ${tests.size()} track's test"
        println "*************************************"
    }

    @Override
    def afterRun() {
        println " "
        println "*************************************"

        this.messages.each { test, msgs ->
            print "${test}: "
            msgs.each {m -> print m}
            println ""
        }
        println "*************************************"
    }
}

