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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals(["orders.congrats"], json.measures.name)
		assertEquals(["checkout first congrats"], json.measures.description)
		assertEquals([true], json.measures.order)
		assertEquals([["exp1","exp2"]], json.measures.experiments)
		assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
		assertEquals([["field":"event_data.congrats_seq","operator":"equals","value":"1"]], json.measures.condition)
	}

	@Test void testDeprecationDate() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true, deprecation_date:"2019/11/29") {
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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals(["orders.congrats"], json.measures.name)
		assertEquals(["checkout first congrats"], json.measures.description)
		assertEquals([true], json.measures.order)
		assertEquals(["2019/11/29"], json.measures.deprecation_date)
		assertEquals([["exp1","exp2"]], json.measures.experiments)
		assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
		assertEquals([["field":"event_data.congrats_seq","operator":"equals","value":"1"]], json.measures.condition)
	}

	@Test void testWithTtl() {

		def metrics = metrics {
			"orders.congrats_quick"(description: "checkout first congrats", compute_order: true, ttl:180) {
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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals(1, json.measures.size())
		assertEquals(["orders.congrats_quick"], json.measures.name)
		assertEquals(["checkout first congrats"], json.measures.description)
		assertEquals([true], json.measures.order)
		assertEquals([["exp1","exp2"]], json.measures.experiments)
		assertEquals([180L], json.measures.ttl)
		assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
		assertEquals([["field":"event_data.congrats_seq","operator":"equals","value":"1"]], json.measures.condition)
	}

    @Test void testCountsOnExternal() {

		def metrics = metrics {
			"orders.congrats"(description: "checkout first congrats", compute_order: true) {
				startWith {
					experiment("exp1", "exp2")
				}

				countsOn {
					condition {
						path("/checkout/congrats", "/checkout/failure")
						equals(
								externalCondition {
									url("internal/orders/\$0")
									replace("event_data.order_id")
									method("get")
									successfulCodes(200,206)
									jsonPath("status")
								},
								"paid"
						)
					}
				}
			}
		}

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals(["orders.congrats"], json.measures.name)
		assertEquals(["checkout first congrats"], json.measures.description)
		assertEquals([true], json.measures.order)
		assertEquals([["exp1","exp2"]], json.measures.experiments)
		assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
		assertEquals([["field":"external","operator":"equals","value":"paid",
					   "externalCondition":["externalUrl":"internal/orders/\$0","replacementFields":["event_data.order_id"],
											"method":"get","successfulCodes":[200,206],"jsonPath":"status"]]], json.measures.condition)
	}

	@Test void testCountsOnExternalWithTtlAndUnknownParam() {

		def metrics = metrics {
			"orders.congrats_quick"(description: "checkout first congrats", compute_order: true, ttl: 30) {
				startWith {
					experiment("exp1", "exp2")
				}

				countsOn {
					condition {
						path("/checkout/congrats", "/checkout/failure")
						equals(
								externalCondition {
									url("internal/orders/\$0")
									replace("event_data.order_id")
									method("get")
									successfulCodes(200,206)
									jsonPath("status")
									unknown("234")
								},
								"paid"
						)
					}
				}
			}
		}

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals(["orders.congrats_quick"], json.measures.name)
		assertEquals(["checkout first congrats"], json.measures.description)
		assertEquals([true], json.measures.order)
		assertEquals([["exp1","exp2"]], json.measures.experiments)
		assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
		assertEquals([["field":"external","operator":"equals","value":"paid",
					   "externalCondition":["externalUrl":"internal/orders/\$0","replacementFields":["event_data.order_id"],
											"method":"get","successfulCodes":[200,206],"jsonPath":"status"]]], json.measures.condition)
	}

    @Test void testCountsOnExternalAnd() {

        def metrics = metrics {
            "orders.congrats"(description: "checkout first congrats", compute_order: true) {
                startWith {
                    experiment("exp1", "exp2")
                }

                countsOn {
                    condition {
                        path("/checkout/congrats", "/checkout/failure")
                        and (
                                equals(
                                        externalCondition {
                                            url("internal/orders/\$0")
                                            replace("event_data.order_id")
                                            method("get")
                                            successfulCodes(200,206)
                                            jsonPath("status")
                                        },
                                        "paid"
                                ),
                                equals("field2", "1234")
                        )
                    }
                }
            }
        }

        def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
        def json = formatter.generate()

        assertEquals(["orders.congrats"], json.measures.name)
        assertEquals(["checkout first congrats"], json.measures.description)
        assertEquals([true], json.measures.order)
        assertEquals([["exp1","exp2"]], json.measures.experiments)
        assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
        assertEquals("and", json.measures.condition[0].operator)
        assertEquals(["field":"field2","operator":"equals","value":"1234"], json.measures.condition[0].values[1])
        assertEquals(["field":"external","operator":"equals","value":"paid",
                      "externalCondition":["externalUrl":"internal/orders/\$0","replacementFields":["event_data.order_id"],
                                           "method":"get","successfulCodes":[200,206],"jsonPath":"status"]], json.measures.condition[0].values[0])

    }

    @Test void testCountsOnExternalBool() {

        def metrics = metrics {
            "orders.congrats"(description: "checkout first congrats", compute_order: true) {
                startWith {
                    experiment("exp1", "exp2")
                }

                countsOn {
                    condition {
                        path("/checkout/congrats", "/checkout/failure")
                        equals(
                                externalCondition {
                                    url("internal/orders/\$0")
                                    replace("event_data.order_id")
                                    method("get")
                                    successfulCodes(200,206)
                                    jsonPath("fulfilled")
                                },
                                true
                        )
                    }
                }
            }
        }

        def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
        def json = formatter.generate()

        assertEquals(["orders.congrats"], json.measures.name)
        assertEquals(["checkout first congrats"], json.measures.description)
        assertEquals([true], json.measures.order)
        assertEquals([["exp1","exp2"]], json.measures.experiments)
        assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
        assertEquals([["field":"external","operator":"equals","value":"true",
                       "externalCondition":["externalUrl":"internal/orders/\$0","replacementFields":["event_data.order_id"],
                                            "method":"get","successfulCodes":[200,206],"jsonPath":"fulfilled"]]], json.measures.condition)
    }
    @Test void testConditionAnd() {

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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
		def json = formatter.generate()


		assertEquals(["orders.congrats"], json.measures.name)
		assertEquals([["/checkout/congrats","/checkout/failure"]], json.measures.paths)
		assertEquals("and", json.measures.condition[0].operator)
		assertEquals(["field":"event_data.congrats_seq","operator":"equals","value":"1"], json.measures.condition[0].values[0])
		assertEquals(["field":"event_data.payments","operator":"notEquals","value":"cash"], json.measures.condition[0].values[1])
	}

	@Test void testTwoMetrics() {

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

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
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

	@Test void testStartWithCondition() {

		def metrics = metrics {
			"custom1"(description: "custom experiment") {
				startWith {
					condition {
						empty("experiments.exp1", false)
					}
				}

				countsOn {
					condition {
						path("/search")
					}
				}
			}
		}

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		println json
		assertEquals("custom1", json.insights[0].name)
		assertEquals("custom experiment", json.insights[0].description)
		assertEquals("experiments.exp1", json.insights[0].condition.field)
		assertEquals("empty", json.insights[0].condition.operator)
		assertEquals("false", json.insights[0].condition.value)
		assertEquals("custom1", json.measures[0].name)
		assertEquals(["/search"], json.measures[0].paths)
		assertEquals(["custom1"], json.measures[0].experiments)
	}

	@Test void testStartWithConditionAndCountsOn() {

		def metrics = metrics {
			"custom1"(description: "custom experiment") {
				startWith {
					condition {
						and(
								empty("experiments.exp1", false),
								or(
										like('event_data.category_path', 'reg1'),
										like('event_data.category_path', 'reg2')
								)
						)

					}
				}
			}

		}

		def formatter = new com.melidata.metrics.format.MetricsFormatter(metrics)
		def json = formatter.generate()

		assertEquals("custom1", json.insights[0].name)
		assertEquals("custom experiment", json.insights[0].description)
		assertEquals("and", json.insights[0].condition.operator)
		assertEquals("experiments.exp1", json.insights[0].condition.values[0].field)
		assertEquals("empty", json.insights[0].condition.values[0].operator)
		assertEquals("false", json.insights[0].condition.values[0].value)
		assertEquals("or", json.insights[0].condition.values[1].operator)
		assertEquals("event_data.category_path", json.insights[0].condition.values[1].values[0].field)
		assertEquals("like", json.insights[0].condition.values[1].values[0].operator)
		assertEquals("reg1", json.insights[0].condition.values[1].values[0].value)
		assertEquals("event_data.category_path", json.insights[0].condition.values[1].values[1].field)
		assertEquals("like", json.insights[0].condition.values[1].values[1].operator)
		assertEquals("reg2", json.insights[0].condition.values[1].values[1].value)
	}


}
