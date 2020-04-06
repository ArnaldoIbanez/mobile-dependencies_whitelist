package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	"orders"(description: "/orders/ordercreated from feed (not from carrito)", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.is_carrito", false)
			}
		}
	}


	"orders.paid"(description: "/orders/ordercreated from feed with Orders-API confirmation", compute_order: true) {
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
						equals("event_data.is_carrito", false)
				)
			}
		}
	}


	"bids"(description: "/orders/ordercreated from feed (carrito included)", compute_order: true, categorization:"important") {
		countsOn {
			condition {
				path("/orders/ordercreated")
			}
		}
	}

	"bids.pdp"(description: "/orders/ordercreated from feed (carrito included) from PDP", compute_order: true, categorization:"important") {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.is_pdp", true)
			}
		}
	}

	"bids.quick"(description: "/orders/ordercreated from feed (carrito included) with short attribution time (3h)", compute_order: true, ttl: 180) {
		countsOn {
			condition {
				path("/orders/ordercreated")
			}
		}
	}

	"bids.paid"(description: "/orders/ordercreated from feed with Orders-API confirmation", compute_order: true, categorization:"important") {
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
	}
	
	"bids.cancelled"(description: "/orders/ordercreated that were finally cancelled. https://sites.google.com/mercadolibre.com/apicore/purchases/order/faq?authuser=0#h.p_2qPD6v_1dTSd", compute_order: true, categorization:"important") {
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
						"cancelled"
				)
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

	"purchases"(description: "/purchase/purchasecreated from feed", compute_order: true) {
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

	"orders|new_buyers"(description: "New buyers from feed", compute_order: true) {
		countsOn {
			condition {
				or(
						and (
								equals("path", "/orders/ordercreated"),
								equals("event_data.is_carrito", false),
								equals("event_data.buyer_segment", "new_buyer")
						),
						and (
								equals("path","/purchases/purchasecreated"),
								equals("event_data.buyer_segment", "new_buyer")
						)
				)
			}
		}
	}

	"orders|inactive_buyers"(description: "New buyer and buyers without more than 1-year buys (New & Recovered buyers)", compute_order: true) {
		countsOn {
			condition {
				or(
						and (
								equals("path", "/orders/ordercreated"),
								equals("event_data.is_carrito", false),
								or(
										equals("event_data.buyer_segment", "new_buyer"),
										equals("event_data.buyer_segment", "recovered_buyer")
								)
						),
						and (
								equals("path","/purchases/purchasecreated"),
								or(
										equals("event_data.buyer_segment", "new_buyer"),
										equals("event_data.buyer_segment", "recovered_buyer")
								)
						)
				)
			}
		}
	}

	"orders|active_buyers"(description: "Active buyers from feed", compute_order: true) {
		countsOn {
			condition {
				or(
						and (
								equals("path", "/orders/ordercreated"),
								equals("event_data.is_carrito", false),
								equals("event_data.buyer_segment", "active_buyer")
						),
						and (
								equals("path","/purchases/purchasecreated"),
								equals("event_data.buyer_segment", "active_buyer")
						)
				)
			}
		}
	}


	"orders.sameItem"(description: "/orders/ordercreated from feed (not from carrito)", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					equals("event_data.is_carrito", false),
					equals("event_data.items.item.id", property("item_id"))
				)
			}
		}
	}
	
	"orders.sameItemQuick"(description: "/orders/ordercreated from feed (not from carrito)", compute_order: true, ttl: 30) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
					equals("event_data.is_carrito", false),
					equals("event_data.items.item.id", property("item_id"))
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

	"orders.sameProduct"(description: "/orders/ordercreated from feed (not from carrito)", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
						equals("event_data.is_carrito", false),
						equals("event_data.items.item.catalog_product_id", property("catalog_product_id"))
				)
			}
		}
	}
	
	"orders.sameProductQuick"(description: "/orders/ordercreated from feed (not from carrito)", compute_order: true, ttl: 30) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
						equals("event_data.is_carrito", false),
						equals("event_data.items.item.catalog_product_id", property("catalog_product_id"))
				)
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

	"orders.sameParent"(description: "/orders/ordercreated from feed (not from carrito)", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
						equals("event_data.is_carrito", false),
						equals("event_data.items.item.catalog_parent_id", property("catalog_parent_id"))
				)
			}
		}
	}

	"bids.sameParent"(description: "/orders/ordercreated from feed in the same parent product of experiement", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.catalog_parent_id", property("catalog_parent_id"))
			}
		}
	}
				  

	"orders.sameSearch"(description: "/orders/ordercreated from feed (not from carrito)", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
						equals("event_data.is_carrito", false),
						equals("event_data.items.item.id", property("item_ids"))
				)
			}
		}
	}
				       
	"bids.sameSearch"(description: "/orders/ordercreated from feed in items that were present in the experiments search", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.items.item.id", property("item_ids"))
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

	"buys.fashion"(description: "Track buys only in fashion domain for Sparkle exp", compute_order: true) {
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


}
