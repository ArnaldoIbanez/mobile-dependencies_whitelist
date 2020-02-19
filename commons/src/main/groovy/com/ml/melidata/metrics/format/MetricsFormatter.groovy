package com.melidata.metrics.format

import com.ml.melidata.metrics.MetricDefinition
import com.ml.melidata.metrics.Metrics
import com.ml.melidata.metrics.NameWrapper
import com.ml.melidata.metrics.RegExWrapper
import groovy.json.JsonOutput

class MetricsFormatter {

	Metrics metrics

	def MetricsFormatter(Metrics metrics) {
		this.metrics = metrics
	}

	def generateMeasure(MetricDefinition definition) {
		//return definition

		def result = [:]

		if ( definition.compute_order ) {
			result += [order: definition.compute_order]
		}

		if ( definition.sum_by ) {
			result += [sum_by: definition.sum_by]
		}

		//EXPERIMENT
		if ( definition.experiments && !definition.properties) {
			//result += add("experiment", "experiments", definition.experiments)

			if ( definition.experiments ) {
				if (definition.experiments.size == 1 && definition.experiments.get(0) instanceof RegExWrapper) {
					//regexp
					result += ["experiment": definition.experiments.get(0).regex]
				} else if (definition.experiments.size > 0 && definition.experiments.get(0) instanceof NameWrapper) {
					//list of names
					result += ["experiments": definition.experiments.collect { it.name }]
				} else if ( definition.condition ) {
					//insight defined in the same definition
					result += ["experiments": [ definition.name ] ]
				}
			}
		}

		//OPEN
		if ( definition.open ) {
			result += [ parametric_name: definition.open ]
		}

		//CONDITION
		if ( definition.condition )
			result += generateCondition(definition.condition)

		if ( result ) {
			//if it is not empty, add name and description
			result = [
					name       : definition.name,
					description: definition.description
			] + result

			if ( definition.deprecation_date ) {
				result += [ deprecation_date: definition.deprecation_date.format("yyyy/MM/dd")]
			}
			if ( definition.ttl ) {
				if ( definition.ttl != 0) {
					result += [ ttl: definition.ttl]
				}
			}
		}

		return result
	}

	def generateInsight(MetricDefinition definition) {
		//EXPERIMENT
	    def result = [:]

		if ( definition.experiments && !definition.properties ) {
			if ( !(definition.experiments.get(0) instanceof RegExWrapper) && !(definition.experiments.get(0) instanceof NameWrapper) ) {
				result += generatePath(definition.experiments?.condition?.path)

				if ( definition.acceptMultiVariantSession ) {
					result += [ acceptMultiVariantSession: definition.acceptMultiVariantSession ]
				}

				if ( definition.experiments.condition?.condition ) {
					result += [condition: definition.experiments.condition?.condition]
				}

				if ( definition.experiments.open ) {
					if (definition.parametricName) {
						result += [parametric_name: definition.experiments.open]
					} else {
						result += [variant_name: definition.experiments.open]
					}
				}
			}
		}

		//PROPERTIES
		if ( definition.properties ) {
			result += [ properties: definition.properties ]
			if ( definition.experiments.size == 1 ) {
				result += [ experiment_regex: definition.experiments.get(0).regex]
			}
		}

		if ( result ) {
			//if it is not empty, add name and description
			result = [
						name       : definition.name,
						description: definition.description
					 ] + result

			if ( definition.deprecation_date ) {
				result += [ deprecation_date: definition.deprecation_date.format("yyyy/MM/dd")]
			}

			if ( definition.ttl ) {
				if ( definition.ttl != 0) {
					result += [ ttl: definition.ttl]
				}
			}
		}

		return result
	}

	def generatePath(path) {
		if ( path ) {
			if (path.size == 1 && path.get(0) instanceof RegExWrapper) {
				return ["path": path.get(0).regex]
			} else if (path.size > 0 && path.get(0) instanceof NameWrapper) {
				return ["paths": path.collect { it.name }]
			}
		}

		return [:]
	}

	def generateCondition(condition) {
		//def result = add("path", "paths", condition.path)

		def result = [:]

		result += generatePath(condition.path)

		if ( condition.condition ) {
			result += [condition: condition.condition]
		}

		return result
	}

	def generate() {
		def insights = []
		def measures = []

		metrics?.getDefinitions().collect {
			def insight = generateInsight(it)
			if ( insight )
				insights += insight

			def measure = generateMeasure(it)
			if ( measure )
				measures += measure
		}

		return [
		        measures: measures,
				insights: insights
		]
	}

	def getOutput() {
		formatOutput(generate())
	}

	def formatOutput(def data) {
		JsonOutput.toJson(data)
	}

	static void main(String[] args) {
		def file = new File("metrics.json")
		file.delete()
		println("\nCompiling metrics to metrics.json...")

		def output = new MetricsFormatter(com.ml.melidata.metrics.MetricsFactory.metrics).output
		println(output)
		file << output

		println("\nFile $file generated")
	}

}
