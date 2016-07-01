package com.ml.melidata.metrics.parsers.dsl

/**
 * Created by mtencer on 05/23/2016.
 */
class ConditionDsl {
    def path

    def methodMissing(String method, args) {
        //println "ConditionDsl $method $args"

        if ( method == "path") {
            if ( args[0] instanceof com.ml.melidata.metrics.RegExWrapper ) {
                path = [ args[0] ]
            } else {
                path = args.collect { new com.ml.melidata.metrics.NameWrapper(it) }
            }
            return null
        } else if ( method == "regex") {
            return new com.ml.melidata.metrics.RegExWrapper(args[0])
        } else if ( method == "and" ) {
            return [ operator: "and", values: args]
        } else if ( method == "or" ) {
            return [ operator: "or", values: args]
        } else if ( method == "property" ) {
            return [ property: args[0] ]
        } else if ( method == "first" ) {
            return [ function: "first", field: args[0]]
        } else {
            return (args[0] instanceof Map ? args[0] : [ field: args[0] ])  +
                    [ operator: method ] +
                    (args.length > 1 ? (args[1] instanceof Map ? args[1] : [ value: args[1].toString() ]) : [:])
        }
    }
}
