package com.melidata.metrics

import org.junit.Test

import static org.junit.Assert.*

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

/**
 * Created by mtencer on 2/6/16.
 */
class MetricsJsonTest {

	@Test void testStartWithEmpty() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true) {
			}
		}

		def formatter = new com.melidata.metrics.definitions.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals([null], json.measures.experiments)
		assertEquals([null], json.measures.experiment)
		assertEquals(["checkout first congrats"], json.measures.description)
		assertEquals([true], json.measures.order)
	}

	@Test void testStartWithExperiment1() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true) {
				startWith {
					experiment("exp1")
				}
			}
		}

		def formatter = new com.melidata.metrics.definitions.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals([["exp1"]], json.measures.experiments)
		assertEquals([null], json.measures.experiment)
	}

	@Test void testStartWithExperiment2() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true) {
				startWith {
					experiment("exp1", "exp2")
				}
			}
		}

		def formatter = new com.melidata.metrics.definitions.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals([["exp1", "exp2"]], json.measures.experiments)
		assertEquals([null], json.measures.experiment)
	}

	@Test void testStartWithExperimentRegEx() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true) {
				startWith {
					experiment(regex("exp.*"))
				}
			}
		}

		def formatter = new com.melidata.metrics.definitions.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals(["exp.*"], json.measures.experiment)
		assertEquals([null], json.measures.experiments)
	}


	@Test void testCountsOn() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true) {
				startWith {
					experiment("exp1", "exp2")
				}

				countsOn {
					condition {
						path("/checkout/congrats", "/checkout/failure")

						equals("event_data.congrats_seq", 1)
					}
				}
			}
		}

		def formatter = new com.melidata.metrics.definitions.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals(["orders.congrats"], json.measures.name)
		assertEquals(["checkout first congrats"], json.measures.description)
		assertEquals([true], json.measures.order)
		assertEquals([["exp1","exp2"]], json.measures.experiments)
		assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
		assertEquals([["field":"event_data.congrats_seq","operator":"equals","value":"1"]], json.measures.condition)
	}

	@Test void testConditonAnd() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true) {
				startWith {
					experiment("exp1", "exp2")
				}

				countsOn {
					condition {
						path("/checkout/congrats", "/checkout/failure")

						and(
							equals("event_data.congrats_seq", 1),
							notEquals("event_data.payments", "cash")
						)
					}
				}
			}
		}

		def formatter = new com.melidata.metrics.definitions.format.MetricsFormatter(metrics)
		def json = formatter.generate()


		assertEquals(["orders.congrats"], json.measures.name)
		assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
		assertEquals("and", json.measures.condition[0].operator)
		assertEquals(["field":"event_data.congrats_seq","operator":"equals","value":"1"], json.measures.condition[0].values[0])
		assertEquals(["field":"event_data.payments","operator":"notEquals","value":"cash"], json.measures.condition[0].values[1])
	}


	@Test void testTwoMeasures() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true) {
				startWith {
					experiment("exp1", "exp2")
				}

				countsOn {
					condition {
						path("/checkout/congrats", "/checkout/failure")

						equals("event_data.congrats_seq", 1)
					}
				}
			}

			"search"(description: "count search") {
				startWith {
					experiment("exp3")
				}

				countsOn {
					condition {
						path("/search")
					}
				}
			}

		}

		def formatter = new com.melidata.metrics.definitions.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals("orders.congrats", json.measures[0].name)
		assertEquals("checkout first congrats", json.measures[0].description)
		assertEquals(true, json.measures[0].order)
		assertEquals(["exp1","exp2"], json.measures[0].experiments)
		assertEquals(["/checkout/congrats","/checkout/failure"], json.measures[0].paths)
		assertEquals(["field":"event_data.congrats_seq","operator":"equals","value":"1"], json.measures[0].condition)

		assertEquals("search", json.measures[1].name)
		assertEquals("count search", json.measures[1].description)
		assertEquals(null, json.measures[1].order)
		assertEquals(["exp3"], json.measures[1].experiments)
		assertEquals(["/search"], json.measures[1].paths)
		assertEquals(null, json.measures[1].condition)

	}

}
