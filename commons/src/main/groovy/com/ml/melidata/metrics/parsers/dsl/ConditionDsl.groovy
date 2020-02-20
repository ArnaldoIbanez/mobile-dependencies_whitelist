package com.ml.melidata.metrics.parsers.dsl

/**
 * Created by mtencer on 05/23/2016.
 */
class ConditionDsl {
    def path
    def externalCondition

    def methodMissing(String method, args) {
        //println "ConditionDsl $method $args"

        if ( method == "path") {
            if ( args[0] instanceof com.ml.melidata.metrics.RegExWrapper ) {
                path = [ args[0] ]
            } else {
                path = args.collect { new com.ml.melidata.metrics.NameWrapper(it) }
            }
            return null
        } else if ( method == "externalCondition") {
            externalCondition = getExternalCondition(args)
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
            if (externalCondition == null)
                return (args[0] instanceof Map ? args[0] : [ field: args[0] ])  +
                        [ operator: convert(method) ] +
                        (args.length > 1 ? (args[1] instanceof Map ? args[1] : [ value: args[1].toString() ]) : [:])
            def result = [ field: "external", operator: convert(method), externalCondition: externalCondition ] +
                    (args.length > 1 ? (args[1] instanceof Map ? args[1] : [ value: args[1].toString() ]) : [:])
            externalCondition = null
            return result
        }
    }

    static def getExternalCondition(args) {
        def closure = args[-1]
        ExternalConditionDsl externalConditionDsl = new ExternalConditionDsl();
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.delegate = externalConditionDsl
        def result = closure()

        return [ externalUrl: externalConditionDsl.externalUrl, replacementFields:externalConditionDsl.replacementFields] +
                [ method:externalConditionDsl.httpMethod, successfulCodes:externalConditionDsl.successfulCodes] +
                [jsonPath:externalConditionDsl.jsonPath ]
    }

    def convert(method) {
        switch (method) {
            case "gt": return ">"
            case "gte": return ">"
            case "lt": return ">"
            case "lte": return ">"
        }

        return method

    }
}
