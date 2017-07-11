import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	"checkout_congrats"( description: "all congrats, including carrito and checkout congrats", compute_order:true){
		countsOn {
			condition{
				equals("event_data.congrats_seq",1)
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

	"checkout_congrats.official.stores"(description: "Checkout congrats for items in any official store", compute_order: true) {
		countsOn {
			condition {
				and(
					equals("event_data.congrats_seq",1),
					empty("event_data.items.item.official_store_id", false)
				)
			}
		}
	}

	"checkout_congrats.samedeal"(description: "Checkout congrats for items in the same deal of exposition", compute_order: true) {
		countsOn {
			condition {
				and(
					equals("event_data.congrats_seq",1),
					sameDeal("event_data.items.item.deal_ids", true)
				)
			}
		}
	}

	"checkout_congrats.sameitem"(description: "Checkout congrats for items in the same item of exposition", compute_order: true) {
		countsOn {
			condition {
				and(
					equals("event_data.congrats_seq",1),
					equals("event_data.items.item.id", property("item_id"))
				)
			}
		}
	}

	"orders.congrats.sameorder"(description: "congrats for order in the same order_id of exposition", compute_order: true) {
		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))
				equals("event_data.order_id", property("order_id"))
			}
		}
	}

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

}
