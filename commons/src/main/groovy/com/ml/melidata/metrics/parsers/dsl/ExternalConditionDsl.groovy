package com.ml.melidata.metrics.parsers.dsl

class ExternalConditionDsl {
    def externalUrl
    def replacementFields
    def httpMethod
    def successfulCodes
    def jsonPath

    def methodMissing(String method, args) {
        if ( method == "url") {
            externalUrl = args[0]
        } else if ( method == "replace") {
            replacementFields = args.collect()
        } else if ( method == "method" ) {
            httpMethod = args[0]
        } else if ( method == "successfulCodes" ) {
            successfulCodes = args.collect()
        } else if ( method == "jsonPath" ) {
            jsonPath = args[0]
        } else {
             return
        }
        return
    }
}
