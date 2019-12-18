import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	"orders"(description: "/orders/ordercreated from feed", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.is_carrito", false)
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
	
	"buys"(description: "orders or purchases creaated from feed", compute_order: true) {
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

	"orders_new_buyers"(description: "New buyers from feed", compute_order: true, deprecation_date:"2019/12/18") {
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
	
	"orders_inactive_buyers"(description: "New buyer and buyers without more than 1-year buys (New & Recovered buyers)", compute_order: true, deprecation_date:"2019/12/18") {
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
	
	"orders_active_buyers"(description: "Active buyers from feed", compute_order: true, deprecation_date:"2019/12/18") {
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

	"orders.fbm"(description: "orders of fbm items", compute_order: true) {
		startWith {
			experiment("search/show_akins")
		}

		countsOn {
			condition {
				path("/orders/ordercreated")

				equals("event_data.items.item.logistic_type", "fulfillment")
			}
		}
	}


	// TODO REMOVE WHEN THIS EXPERIMENT IS OVER
	"orders.InCarrouselCategories"(description: "extend experiment /search/brandCarrousel", parametricName: false, compute_order: true,deprecation_date:"2019/12/18" ) {
		startWith {
			experiment("search/officialStoresCarousel")
		}

		countsOn {
			condition {
				path("/orders/ordercreated")
				or(
						like('event_data.items.item.category_path', '.*MLM(6585|5607|120666|182735|81531|4651|8574|2827|158119|1271|180982|1676|168281|1285|187814|158842|1010|158828|1386|5723|1578|1712|8378),.*'),
						like('event_data.items.item.category_path', '.*MLB(23332|181294|1248|1002|181294|1676|191839|1286|264721|1580|1386|21168|1456),.*'),
						like('event_data.items.item.category_path', '.*MLA(109027|1002|398582|6839|1248|1676|1042|1285|409558|1575|409810|1618|1386|6750|18353|3959),.*')
				)
			}
		}
	}

	"orders.officialStores.InCarrouselCategories"(description: "extend experiment /search/brandCarrousel", parametricName: false, compute_order: true, deprecation_date:"2019/12/18") {
		startWith {
			experiment("search/officialStoresCarousel")
		}

		countsOn {
			condition {
				path("/orders/ordercreated")
				and(
						empty("event_data.items.item.official_store_id", false),
						or(
								like('event_data.items.item.category_path', '.*MLM(6585|5607|120666|182735|81531|4651|8574|2827|158119|1271|180982|1676|168281|1285|187814|158842|1010|158828|1386|5723|1578|1712|8378),.*'),
								like('event_data.items.item.category_path', '.*MLB(23332|181294|1248|1002|181294|1676|191839|1286|264721|1580|1386|21168|1456),.*'),
								like('event_data.items.item.category_path', '.*MLA(109027|1002|398582|6839|1248|1676|1042|1285|409558|1575|409810|1618|1386|6750|18353|3959),.*')
						)
				)
			}
		}
	}

	"pdp_buys_qadb"(description: "Track buys of users in QADB experiment", compute_order: true, deprecation_date:"2019/12/18") {
		startWith {
			experiment("qadb/qadb-on")
		}

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

	"pdp_buys"(description: "Track PDP buys", compute_order: true, deprecation_date:"2019/12/18") {
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

	"buys.pdp"(description: "Track PDP buys", compute_order: true, deprecation_date:"2019/12/18") {
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


}
