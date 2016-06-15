package com.ml.melidata.metrics

class MetricDefinition {

	String name
	String description
	Boolean compute_order = false
	def experiments
	def condition
	def open
	def properties

	Boolean acceptMultiVariantSession = false
   	Boolean parametricName = false

	public MetricDefinition(Map map) {
		map?.each { k, v ->
			this[k] = v
		}
	}
}
