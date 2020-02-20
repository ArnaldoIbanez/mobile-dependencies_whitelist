package com.ml.melidata.metrics

import java.text.SimpleDateFormat

class MetricDefinition {

	String name
	String description
	Date deprecation_date = null
	Boolean compute_order = false
	Long ttl = null
	def experiments
	def condition
	def open
	def properties
	List sum_by

	Boolean acceptMultiVariantSession = false
   	Boolean parametricName = false

	public MetricDefinition(Map map) {
		map?.each { k, v ->
			this[k] = k == "deprecation_date"? new SimpleDateFormat("yyyy/MM/dd").parse(v) : v
		}
	}
}
