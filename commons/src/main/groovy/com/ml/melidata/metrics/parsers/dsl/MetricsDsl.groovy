package com.ml.melidata.metrics.parsers.dsl

import com.ml.melidata.metrics.MetricDefinition
import com.ml.melidata.metrics.Metrics

/**
 * Created by geisbruch on 11/17/14.
 */
class MetricsDsl {

    def String baseDir = "metrics/"

    def Metrics metrics;

    def MetricsDsl() {
        metrics = new Metrics()
    }

    def static metrics(Closure closure) {
        MetricsDsl dsl = new MetricsDsl()
        closure.delegate = dsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        return dsl.metrics
    }

    def metrics(closure) {
        com.ml.melidata.metrics.parsers.dsl.MetricDefinitionDsl metricDefinitionDsl = new com.ml.melidata.metrics.parsers.dsl.MetricDefinitionDsl();
        closure.delegate = metricDefinitionDsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure();
        //add(metricDefinitionDsl)
    }

    def methodMissing(String method, args) {
        def name = method;
        //println "MetricsDsl.methodMisssing ${method} ${args}"

        def metricArgs = ["name":name]
        for(def i =0; i < args.size() -1 ; i++) {
            metricArgs = metricArgs+args[i]
        }

        MetricDefinition metricDefinition = new MetricDefinition(metricArgs)
        metrics.addMetricDefinition(metricDefinition)

        def closure = args[-1]
        MetricDefinitionDsl metricDefinitionDsl = new MetricDefinitionDsl();
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure.delegate = metricDefinitionDsl
        closure()

        metricDefinition.experiments = metricDefinitionDsl.experiments
        metricDefinition.condition = metricDefinitionDsl.condition
        metricDefinition.open = metricDefinitionDsl.open
        metricDefinition.properties = metricDefinitionDsl.properties
    }

}
