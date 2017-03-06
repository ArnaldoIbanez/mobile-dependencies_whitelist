import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	"orders"(description: "all orders, does not include carrito. TODO: Remove", compute_order: true) {
		countsOn {
			condition {
				path(regex("^/checkout(/.*|\$)"))
				equals("event_data.first_for_order", true)
			}
		}
	}

	"orders.created"(description: "/checkout/ordercreated unique for each order_id (ordercreated_seq = 1)", compute_order: true) {
		countsOn {
			condition {
				equals("event_data.ordercreated_seq", 1)
			}
		}

	}

	"checkout_congrats"( description: "all congrats, including carrito and checkout congrats", compute_order:true){
		countsOn {
			condition{
				equals("event_data.congrats_seq",1)
			}
		}
	}

	"orders.congrats"(description: "/checkout/congrats* unique for each order_id (congrats_seq = 1)", compute_order: true) {
		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))
				equals("event_data.congrats_seq", 1)
			}
		}
	}

	"single_checkout_congrats"(description: "/checkout/congrats* unique for each order_id (congrats_seq = 1)", compute_order: true) {
		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))
				equals("event_data.congrats_seq", 1)
			}
		}
	}


	"cart_checkout_congrats"(description: "/cart/checkout/congrats unique for each purchase_id (congrats_seq = 1)", compute_order: true) {
		countsOn {
			condition {
				path("/cart/checkout/congrats")
				equals("event_data.congrats_seq", 1)
			}
		}
	}

	"orders.official.stores"(description: "orders for items in any official store", compute_order: true) {
		startWith {
			experiment("ShowOfficialStoresOnTopQcatDeals", "search/checkOnBehavior", "search/zrpOfficialStores")
		}

		countsOn {
			condition {
				path(regex("^/checkout(/.*|\$)"))
				and(
						equals("event_data.first_for_order", true),
						empty("event_data.items.item.official_store_id", false)
				)
			}
		}
	}

	"orders.deals"(description: "TODO: REMOVE orders for items in any deal", compute_order: true) {
		startWith {
			experiment(regex("/notification/.*"))
		}

		countsOn {
			condition {
				path(regex("^/checkout(/.*|\$)"))
				and(
						equals("event_data.first_for_order", true),
						empty("event_data.items.item.deal_ids", false)
				)
			}
		}
	}

	"orders.samedeal"(description: "orders for items in the same deal of exposition", compute_order: true) {
		countsOn {
			condition {
				path(regex("^/checkout(/.*|\$)"))
				and(
					equals("event_data.first_for_order", true),
					sameDeal("event_data.items.item.deal_ids", true)
				)
			}
		}
	}

	"orders.sameitem"(description: "orders for items in the same item of exposition", compute_order: true) {
		countsOn {
			condition {
				path(regex("^/checkout(/.*|\$)"))
				and(
					equals("event_data.first_for_order", true),
					equals("event_data.items.item.id", property("item_id"))
				)
			}
		}
	}

	"orders.congrats.sameorder"(description: "congrats for order in the same order_id of exposition", compute_order: true) {
		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))
				and(
						equals("event_data.congrats_seq", 1),
						equals("event_data.order_id", property("order_id"))
				)
			}
		}
	}

	"orders.feed"(description: "/orders/ordercreated from feed. TODO: Rename to 'orders'", compute_order: true) {
		countsOn {
			condition {
				path("/orders/ordercreated")
				equals("event_data.is_carrito", true)
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

}