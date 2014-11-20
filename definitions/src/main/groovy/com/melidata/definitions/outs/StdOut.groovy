package com.melidata.definitions.outs
/**
 * Created by apetalas on 20/11/14.
 */
class StdOut implements TestOut {

    def messages = [:]

    def successTests = 0
    def failTests = 0

    PrintWriter p = new PrintWriter(System.out)

    @Override
    def fail(Object test) {
        messages.put(test.name, test.messages)
        failTests++
    }

    @Override
    def success(Object test) {
        successTests++
    }

    @Override
    def beforeRun(catalog, tests) {
        println "\n\n*************************************"
        println "Ready to run ${tests.size()} track's test"
        println "*************************************\n"
    }

    @Override
    def afterRun() {
        println("\033[32m - Success Tests: "+successTests+"\033[0m")
        println("\033[31m - Failed Tests: "+failTests+"\033[0m")
        println "\n*************************************"
        println("\tFails Details")
        println "*************************************\n"
        this.messages.each { test, msgs ->
            print " - ${test}: \n"
            msgs.each {m -> print("\033[31m  -  "+m+"\033[0m\n")}
            print "\n"
        }
        println "*************************************"
    }
}

