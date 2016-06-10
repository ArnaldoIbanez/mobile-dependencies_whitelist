package com.ml.melidata.metrics.parsers.dsl

import com.ml.melidata.metrics.RegExWrapper
import com.ml.melidata.metrics.SetProperty

/**
 * Created by mtencer on 05/23/2016.
 */
class StartWithDsl {

    def experiments

    def condition

    def open

    def properties = []


    def methodMissing(String method, args) {
        //println "StartWithDsl $method $args"

        if ( method == "experiment" || method == "insight" ) {
            if ( args[0] instanceof RegExWrapper ) {
                experiments = [ args[0] ]
            } else {
                experiments = args.collect { new com.ml.melidata.metrics.NameWrapper(it) }
            }
        } else if ( method == "regex") {
            experiments = new RegExWrapper(args[0])

        } else if ( method == "condition") {
            def closure = args[-1]
            ConditionDsl conditionDsl = new ConditionDsl();
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            closure.delegate = conditionDsl
            def result = closure()
            condition = [ path: conditionDsl.path, condition: result ]

        } else if ( method == "openBy" ) {
            def closure = args[-1]
            OpenByDsl openByDsl = new OpenByDsl();
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            closure.delegate = openByDsl
            closure()
            open = openByDsl.fields

        } else if ( method == "set_property" ) {
            properties << new SetProperty(args[0], args[1])
        }

    }
}
