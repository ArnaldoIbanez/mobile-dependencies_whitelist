package com.melidata.definitions.outs
/**
 * Created by apetalas on 20/11/14.
 */
class StdOut implements DefinitionsOut {

    def messages = [:]

    def successTests = 0
    def failTests = 0

    PrintWriter p = new PrintWriter(System.out)

    @Override
    def fail(Object test) {
        messages.put(test.name, test._messages)
        failTests++
    }

    @Override
    def success(Object test) {
        successTests++
    }

    @Override
    def beforeRun(catalog, tests) {
        println "\n\n"+starBar()
        println "Ready to run ${tests.size()} track's test"
        println starBar()+"\n"
    }

    @Override
    def afterRun(catalog) {
        catalog.catalogCoverage.printCoverage()


        println("\033[92m - Successful Tests: "+successTests+"\033[0m")
        println("\033[91m - Failed Tests: "+failTests+"\033[0m")

        if(this.messages.size() > 0 ) {
            printFails()
        } else {
            printOk()
            catalog.catalogCoverage.assertCoverage()
        }

    }

    def starBar() {
        return "*************************************"
    }

    def printOk() {
        println "\n"+starBar()
        println("\tTest run successfully")
        println starBar()+"\n"
    }

    def printFails() {
        println "\n"+starBar()
        println("\tFails Details")
        println starBar()+"\n"
        this.messages.each { test, msgs ->
            print " - ${test}: \n"
            msgs.each {m -> print("\033[91m  -  "+m+"\033[0m\n")}
            print "\n"
        }
        println starBar()
    }
}

