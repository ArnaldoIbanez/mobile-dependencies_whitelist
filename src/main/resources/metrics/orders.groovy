package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType

metrics {

	"bids"(description: "/orders/ordercreated from feed (carrito included)", compute_order: true, tags:[TagType.Important, TagType.CoreMetric]) {
		countsOn {
			condition {
				path("/orders/ordercreated")
			}
		}
	}

	"bids.pdp"(description: "/orders/ordercreated from feed (carrito included) from PDP", compute_order: true, tags:[TagType.Important, TagType.CoreMetric]) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.is_pdp", true)
			}
		}
	}

	"bids.quick"(description: "/orders/ordercreated from feed (carrito included) with short attribution time (3h)", compute_order: true, ttl: 180) {
		startWith {
			experiment(regex("qadb/.*"))
		}
		countsOn {
			condition {
				path("/orders/ordercreated")
			}
		}
	}

	"bids.paid"(description: "/orders/ordercreated from feed with Orders-API confirmation", compute_order: true, tags:[TagType.Important]) {
		countsOn {
			condition {
				path("/orders/ordercreated")
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
					equals("event_data.is_pdp", true)
				)
			}
		}
	}
	
	"bids.cbt.paid"(description: "/orders/ordercreated that belong to our CBT vertical and are currently paid", compute_order: true) {
		startWith {
			experiment(regex(".*(cbt/|/cbt).*"))
		}
		
		
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
					equals("event_data.is_cbt", true)
				)
			}
		}
	}
	
	"bids.cpg.paid"(description: "/orders/ordercreated that belong to our CPG vertical and are currently paid", compute_order: true) {
		startWith {
			experiment(regex("cpg/.*"))
		}
		
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
					equals("event_data.is_cpg", true)
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
				)
			}
		}
		divisionBy {
			divisionMetric("bids")
		}
	}

	"bids.official_stores"(description: "Checkout congrats for items in any official store", compute_order: true) {
		startWith {
			experiment(regex("(search|vip)/.*"))
		}

		countsOn {
			condition {
				path("/orders/ordercreated")
				empty("event_data.items.item.official_store_id", false)
			}
		}
	}

	"mediations"(description: "/orders/ordercreated that had mediations.", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				notEquals(
						externalCondition {
							url("internal/orders/\$0")
							replace("event_data.order_id")
							method("get")
							successfulCodes(200,206)
							jsonPath("mediations")
						},
						""
				)
			}
		}
	}

	"purchases"(description: "/purchase/purchasecreated from feed", compute_order: true, tags:[TagType.CoreMetric]) {
		countsOn {
			condition {
				path("/purchases/purchasecreated")
			}
		}
	}

	"buys"(description: "orders or purchases created from feed", compute_order: true) {
		countsOn {
			condition {
				or(
					and (
						equals("path", "/orders/ordercreated"),
						equals("event_data.is_carrito", false)
					),
					and (
						equals("path","/purchases/purchasecreated")
					)
				)
			}
		}
	}

	"bids.sameItem"(description: "/orders/ordercreated from feed in the sam item of experiement", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.id", property("item_id"))
			}
		}
	}

	"bids.sameItemQuick"(description: "Quick attribution of bids", compute_order: true, ttl: 30) {
		startWith {
			experiment(regex("qadb/.*"))
		}
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.id", property("item_id"))

			}
		}
	}

	"bids.sameProduct"(description: "/orders/ordercreated from feed in the same product of experiement", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.catalog_product_id", property("catalog_product_id"))
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
				equals("event_data.items.item.catalog_product_id", property("catalog_product_id"))
				)
			}
		}
	}

	"bids.sameProduct.cancelled"(description: "/orders/ordercreated that were finally cancelled. https://sites.google.com/mercadolibre.com/apicore/purchases/order/faq#h.p_2qPD6v_1dTSd && https://sites.google.com/mercadolibre.com/apicore/purchases/order/faq#h.p_XLySDD9XvDh9", compute_order: true, tags:[TagType.Important]) {
		startWith {
			experiment(regex("qadb/.*"))
		}

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
				)
			}
		}
	}

	"bids.sameProductQuick"(description: "/orders/ordercreated from feed", compute_order: true, ttl: 30) {
		startWith {
			experiment(regex("qadb/.*"))
		}
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.catalog_product_id", property("catalog_product_id"))
			}
		}
	}

	"bids.sameParent"(description: "/orders/ordercreated from feed in the same parent product of experiement", compute_order: true) {
		startWith {
			experiment(regex("(vip|pdp|qadb)/.*"))
		}
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.catalog_parent_id", property("catalog_parent_id"))
			}
		}
	}


	"bids.sameSearch"(description: "/orders/ordercreated from feed in items that were present in the experiments search", compute_order: true) {
		startWith {
			experiment(regex("(search|filters)/.*"))
		}

		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.id", property("item_ids"))
			}
		}
	}

	"bids.sameSearch.paid"(description: "/orders/ordercreated from feed in items that were present in the experiments search", compute_order: true) {
		startWith {
			experiment(regex("(search|filters)/.*"))
		}

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
				equals("event_data.items.item.id", property("item_ids"))
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
								equals('event_data.is_pdp',true)
						),
						and(
								equals("path","/purchases/purchasecreated"),
								equals('event_data.is_pdp',true)
						)
				)
			}
		}
	}

	"buys.qadb_domains"(description: "Track buys only in qadb-enabled domains") {
		startWith {
			experiment(regex("qadb/(qadb-on-vip|qadb-on-viewport-vip)"))
		}

		countsOn {
			condition {
				and(
						or(
								and(
										equals("path", "/orders/ordercreated"),
										equals("event_data.is_carrito", false),

								),
								equals("path", "/purchases/purchasecreated"),
						),
						like('event_data.items.item.category_path', '.*MLA(398582|1387|1676).*')
				)
			}
		}
	}

	"buys.fashion"(description: "Track buys only in fashion domain for Sparkle exp", compute_order: true, deprecation_date:"2020/08/12") {
		startWith {
			experiment(regex("sparkle/.*"))
		}

		countsOn {
			condition {
				and(
						like('event_data.items.item.category_path', '.*ML(A|M)1430.*'),
						or(
								and(
										equals("path", "/orders/ordercreated"),
										equals("event_data.is_carrito", false)
								),
								and(
										equals("path","/purchases/purchasecreated")
								)
						)
				)
			}
		}
	}

	"bids.sameOrder.paid"(description: "/orders/ordercreated from feed in the same order with Orders-API confirmation of experiement", compute_order: true) {
		startWith {
			experiment(regex("(checkout|buyingflow)/.*"))
		}

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
						))
			}
		}
	}

	"bids.with_garex"(description: "/orders/ordercreated that has a meli_warranty in internal tags meaning that garex has been purchased.", compute_order: true) {
		startWith {
			experiment(regex("insurtech/.*"))
		}
		countsOn {
			condition {
				path("/orders/ordercreated")
				like(
						externalCondition {
							url("internal/orders/\$0")
							replace("event_data.order_id")
							method("get")
							successfulCodes(200,206)
							jsonPath("internal_tags")
						},
						"meli_warranty"
				)
			}
		}
	}
}
