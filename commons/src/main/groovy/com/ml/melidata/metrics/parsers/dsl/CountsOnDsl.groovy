package com.ml.melidata.metrics.parsers.dsl
/**
 * Created by mtencer on 05/23/2016.
 */
class CountsOnDsl {

    def condition

    def open

    def methodMissing(String method, args) {
        //println "CountsOnDsl $method $args"

        if ( method == "condition") {
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
        }
    }
}
