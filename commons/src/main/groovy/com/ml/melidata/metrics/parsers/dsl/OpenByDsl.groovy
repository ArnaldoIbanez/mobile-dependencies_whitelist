package com.ml.melidata.metrics.parsers.dsl

/**
 * Created by mtencer on 05/23/2016.
 */
class OpenByDsl {

    def fields = []

    def methodMissing(String method, args) {
        //println "OpenBy $method $args ${args.getClass()}"

        fields << [ field: method ] + (args ? args[-1] : [:])
    }

}
