package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType

metrics {

	"bids"(description: "/orders/ordercreated from feed (carrito included)", compute_order: true, tags:[TagType.Important, TagType.CoreMetric]) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("application.business", "mercadolibre")
			}
		}
	}

	"bids.pdp"(description: "/orders/ordercreated from feed (carrito included) from PDP", compute_order: true, tags:[TagType.Important, TagType.CoreMetric]) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					equals("event_data.is_pdp", true),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.quick"(description: "/orders/ordercreated from feed (carrito included) with short attribution time (3h)", compute_order: true, ttl: 180) {
		experiment(regex("qadb/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("application.business", "mercadolibre")
			}
		}
	}

	"bids.paid"(description: "/orders/ordercreated from feed with Orders-API confirmation", compute_order: true, tags:[TagType.Important]) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
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
					equals("application.business", "mercadolibre")
				)
			}
		}
		divisionBy {
			divisionMetric("bids")
		}
	}

	"bids.pdp.paid"(description: "/orders/ordercreated from feed with Orders-API confirmation", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
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
					equals("event_data.is_pdp", true),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}
	
	"bids.cbt.paid"(description: "/orders/ordercreated that belong to our CBT vertical and are currently paid", compute_order: true) {
		experiment(regex(".*(cbt/|/cbt).*"))
		
		countsOn {
			condition {
				path("/orders/ordercreated")
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
					equals("event_data.is_cbt", true),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}
	
	"bids.cpg.paid"(description: "/orders/ordercreated that belong to our CPG vertical and are currently paid", compute_order: true) {
		experiment(regex("cpg/.*"))
		
		countsOn {
			condition {
				path("/orders/ordercreated")
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
					equals("event_data.is_cpg", true),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.cancelled"(description: "/orders/ordercreated that were finally cancelled. https://sites.google.com/mercadolibre.com/apicore/purchases/order/faq#h.p_2qPD6v_1dTSd  && https://sites.google.com/mercadolibre.com/apicore/purchases/order/faq#h.p_XLySDD9XvDh9", compute_order: true, tags:[TagType.Important]) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and (
					equals(
							externalCondition {
								url("internal/orders/\$0")
								replace("event_data.order_id")
								method("get")
								successfulCodes(200,206)
								jsonPath("status")
							},
							"cancelled"
					),
					equals(
							externalCondition {
								url("internal/orders/\$0")
								replace("event_data.order_id")
								method("get")
								successfulCodes(200,206)
								jsonPath("hidden_for_seller")
							},
							false
					),
					equals("application.business", "mercadolibre")
				)
			}
		}
		divisionBy {
			divisionMetric("bids")
		}
	}

	"bids.official_stores"(description: "Checkout congrats for items in any official store", compute_order: true) {
		experiment(regex("(search|vip)/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					empty("event_data.items.item.official_store_id", false),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"mediations"(description: "/orders/ordercreated that had mediations.", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					notEquals(
						externalCondition {
							url("internal/orders/\$0")
							replace("event_data.order_id")
							method("get")
							successfulCodes(200,206)
							jsonPath("mediations")
						},
						""
					),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"purchases"(description: "/purchase/purchasecreated from feed", compute_order: true, tags:[TagType.CoreMetric]) {
		countsOn {
			condition {
				and(
					path("/purchases/purchasecreated"),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"buys"(description: "orders or purchases created from feed", compute_order: true) {
		countsOn {
			condition {
				or(
					and (
						equals("path", "/orders/ordercreated"),
						equals("event_data.is_carrito", false),
						equals("application.business", "mercadolibre")
					),
					and (
						equals("path","/purchases/purchasecreated"),
						equals("application.business", "mercadolibre")
					)
				)
			}
		}
	}

	"bids.sameItem"(description: "/orders/ordercreated from feed in the same item of experiement", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					equals("event_data.items.item.id", property("item_id")),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.sameItemQuick"(description: "Quick attribution of bids", compute_order: true, ttl: 30) {
		experiment(regex("qadb/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					equals("event_data.items.item.id", property("item_id")),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.sameProduct"(description: "/orders/ordercreated from feed in the same product of experiement", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					equals("event_data.items.item.catalog_product_id", property("catalog_product_id")),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.sameProduct.paid"(description: "/orders/ordercreated from feed with Orders-API confirmation and in the same product of experiement", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
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
				equals("event_data.items.item.catalog_product_id", property("catalog_product_id")),
				equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.sameProduct.cancelled"(description: "/orders/ordercreated that were finally cancelled. https://sites.google.com/mercadolibre.com/apicore/purchases/order/faq#h.p_2qPD6v_1dTSd && https://sites.google.com/mercadolibre.com/apicore/purchases/order/faq#h.p_XLySDD9XvDh9", compute_order: true, tags:[TagType.Important]) {
		experiment(regex("qadb/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				and (
					equals(
							externalCondition {
								url("internal/orders/\$0")
								replace("event_data.order_id")
								method("get")
								successfulCodes(200,206)
								jsonPath("status")
							},
							"cancelled"
					),
					equals("event_data.items.item.catalog_product_id", property("catalog_product_id") ),
					equals(
							externalCondition {
								url("internal/orders/\$0")
								replace("event_data.order_id")
								method("get")
								successfulCodes(200,206)
								jsonPath("hidden_for_seller")
							},
							false
					),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.sameProductQuick"(description: "/orders/ordercreated from feed", compute_order: true, ttl: 30) {
		experiment(regex("qadb/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.catalog_product_id", property("catalog_product_id")),
				equals("application.business", "mercadolibre")
			}
		}
	}

	"bids.sameParent"(description: "/orders/ordercreated from feed in the same parent product of experiement", compute_order: true) {
		experiment(regex("(vip|pdp|qadb)/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.catalog_parent_id", property("catalog_parent_id")),
				equals("application.business", "mercadolibre")
			}
		}
	}


	"bids.sameSearch"(description: "/orders/ordercreated from feed in items that were present in the experiments search", compute_order: true) {
		experiment(regex("(search|filters)/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.id", property("item_ids")),
				equals("application.business", "mercadolibre")
			}
		}
	}

	"bids.sameSearch.paid"(description: "/orders/ordercreated from feed in items that were present in the experiments search", compute_order: true) {
		experiment(regex("(search|filters)/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
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
				equals("event_data.items.item.id", property("item_ids")),
				equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"buys.pdp"(description: "Track PDP buys", compute_order: true) {
		countsOn {
			condition {
				or(
						and(
								equals("path", "/orders/ordercreated"),
								equals("event_data.is_carrito", false),
								equals('event_data.is_pdp',true),
								equals("application.business", "mercadolibre")
						),
						and(
								equals("path","/purchases/purchasecreated"),
								equals('event_data.is_pdp',true),
								equals("application.business", "mercadolibre")
						)
				)
			}
		}
	}

	"buys.qadb_domains"(description: "Track buys only in qadb-enabled domains") {
		experiment(regex("qadb/(qadb-on-vip|qadb-on-viewport-vip)"))

		countsOn {
			condition {
				and(
						or(
								and(
										equals("path", "/orders/ordercreated"),
										equals("event_data.is_carrito", false),
										equals("application.business", "mercadolibre")

								),
								and(
									equals("path", "/purchases/purchasecreated"),
									equals("application.business", "mercadolibre")
								)
						),
						like('event_data.items.item.category_path', '.*MLA(398582|1387|1676).*')
				)
			}
		}
	}

	"buys.fashion"(description: "Track buys only in fashion domain for Sparkle exp", compute_order: true, deprecation_date:"2020/08/12") {
		experiment(regex("sparkle/.*"))

		countsOn {
			condition {
				and(
						like('event_data.items.item.category_path', '.*ML(A|M)1430.*'),
						or(
								and(
										equals("path", "/orders/ordercreated"),
										equals("event_data.is_carrito", false),
										equals("application.business", "mercadolibre")
								),
								and(
										equals("path","/purchases/purchasecreated"),
										equals("application.business", "mercadolibre")
								)
						)
				)
			}
		}
	}

	"bids.sameOrder.paid"(description: "/orders/ordercreated from feed in the same order with Orders-API confirmation of experiement", compute_order: true) {
		experiment(regex("(checkout|buyingflow)/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					equals("event_data.order_id", property("order_id")),
					equals(
							externalCondition {
								url("internal/orders/\$0")
								replace("event_data.order_id")
								method("get")
								successfulCodes(200, 206)
								jsonPath("status")
							},
							"paid"
					),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.with_garex"(description: "/orders/ordercreated that has a meli_warranty in internal tags meaning that garex has been purchased.", compute_order: true) {
		experiment(regex("insurtech/.*"))

		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					like(
						externalCondition {
							url("internal/orders/\$0")
							replace("event_data.order_id")
							method("get")
							successfulCodes(200,206)
							jsonPath("internal_tags")
						},
						"meli_warranty"
					),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}

	"bids.noUid"(description: "/orders/ordercreated from feed with no UID", compute_order: true, tags:[TagType.CoreMetric]) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					isNull("user.uid"),
					equals("application.business", "mercadolibre")
				)
			}
		}
	}
}
