package com.ml.melidata.metrics

class Metrics {

	def metricDefinitions = []

	def addMetricDefinition(MetricDefinition metric) {
		metricDefinitions.add(metric)
	}

	def getDefinitions() {
		return metricDefinitions
	}
}