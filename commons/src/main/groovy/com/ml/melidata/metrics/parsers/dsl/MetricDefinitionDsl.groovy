package com.ml.melidata.metrics.parsers.dsl
/**
 * Created by mtencer on 05/23/2016.
 */
class MetricDefinitionDsl {

    def experiments = []

    def condition

    def open

    def properties

    def methodMissing(String method, args) {
        //println "MetricDefinitionDsl $method $args"

        if ( method == "startWith") {
            def closure = args[-1]
            StartWithDsl startWithDsl = new StartWithDsl();
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            closure.delegate = startWithDsl
            closure()

            if ( startWithDsl.experiments ) {
                experiments = startWithDsl.experiments
            } else {
                experiments = [ condition: startWithDsl.condition, open: startWithDsl.open ]
            }
            properties = startWithDsl.properties
        } else if ( method == "countsOn") {
            def closure = args[-1]
            CountsOnDsl countsOnDsl = new CountsOnDsl();
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            closure.delegate = countsOnDsl
            closure()

            condition = countsOnDsl.condition
            open = countsOnDsl.open
        }

    }
}
