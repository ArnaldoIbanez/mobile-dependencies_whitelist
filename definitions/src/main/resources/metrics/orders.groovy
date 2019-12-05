import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	"checkout_congrats"( description: "all congrats, including carrito and checkout congrats", compute_order:true, deprecation_date:"2019/12/10"){
		countsOn {
			condition{
				equals("event_data.congrats_seq",1)
			}
		}
	}

	"single_checkout_congrats"(description: "/checkout/congrats* unique for each order_id (congrats_seq = 1)", compute_order: true, deprecation_date:"2019/12/10") {
		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))
				equals("event_data.congrats_seq", 1)
			}
		}
	}


	"cart_checkout_congrats"(description: "/cart/checkout/congrats unique for each purchase_id (congrats_seq = 1)", compute_order: true, deprecation_date:"2019/12/10") {
		countsOn {
			condition {
				path("/cart/checkout/congrats")
				equals("event_data.congrats_seq", 1)
			}
		}
	}

	"checkout_congrats.official.stores"(description: "Checkout congrats for items in any official store", compute_order: true, deprecation_date:"2019/12/10") {
		countsOn {
			condition {
				and(
					equals("event_data.congrats_seq",1),
					empty("event_data.items.item.official_store_id", false)
				)
			}
		}
	}

	"checkout_congrats.samedeal"(description: "Checkout congrats for items in the same deal of exposition", compute_order: true, deprecation_date:"2019/12/10") {
		countsOn {
			condition {
				and(
					equals("event_data.congrats_seq",1),
					sameDeal("event_data.items.item.deal_ids", true)
				)
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

	"orders_paid"(description: "/orders/ordercreated from feed with Orders-API confirmation", compute_order: true, deprecation_date:"2019/12/10") {
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

	"bids_paid"(description: "/orders/ordercreated from feed with Orders-API confirmation", compute_order: true, deprecation_date:"2019/12/10") {
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

	"bids.paid"(description: "/orders/ordercreated from feed with Orders-API confirmation", compute_order: true) {
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

	"orders_new_buyers"(description: "New buyers from feed", compute_order: true, deprecation_date:"2019/12/10") {
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

	"orders.new_buyers"(description: "New buyers from feed", compute_order: true) {
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
	
	"orders_inactive_buyers"(description: "New buyer and buyers without more than 1-year buys (New & Recovered buyers)", compute_order: true, deprecation_date:"2019/12/10") {
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

	"orders.inactive_buyers"(description: "New buyer and buyers without more than 1-year buys (New & Recovered buyers)", compute_order: true) {
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
	
	"orders_active_buyers"(description: "Active buyers from feed", compute_order: true, deprecation_date:"2019/12/10") {
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

	"orders.active_buyers"(description: "Active buyers from feed", compute_order: true) {
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

	"buyingflow/accountmoney_not_bep"(description: "define properties for order_id") {
		startWith {
			set_property("order_id", "event_data.order_id")
		}
	}

	"congrats_with_payment.sameOrder"(description: "congrats view with payments containing 'payment' string", compute_order: true, deprecation_date:"2019/12/10") {
		startWith {
			experiment(regex("(.*email/order.*)"))
		}

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))

				and(
						like("event_data.payments", ".*payment.*"),
						equals("event_data.order_id", property("order_id"))
				)
			}
		}
	}

	"checkout_congrats.payment_count"(description: "all orders by payment count (0mp vs 1mp vs 2mp)", compute_order: true, deprecation_date:"2019/12/10") {
		startWith {
			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
		}

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))

				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "", function: "size")
			}
		}
	}

	"checkout_congrats.by_payment"(description: "all orders by payment type, payment_method and installments (eg: credit_card/visa/1 vs credit_card/visa/6 vs credit_card/master/12 vs atm/redlink vs ticket/rapidpag)", compute_order: true, deprecation_date:"2019/12/10") {
		startWith {
			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
		}

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))

				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "default")
				"event_data.payments.payment_method"(default: "default")
				"event_data.payments.installments"(default: "default")
			}
		}
	}

	"checkout_congrats.by_payment_type"(description: "all orders by payment type (eg: credit_card vs atm vs ticket vs cash)", compute_order: true, deprecation_date:"2019/12/10") {
		startWith {
			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
		}

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))

				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "default")
			}
		}
	}

	"checkout_congrats.by_payment_method"(description: "all orders by payment type, payment_method (eg: credit_card/visa vs cre    dit_card/master vs atm/redlink vs ticket/rapidpag)", compute_order: true, deprecation_date:"2019/12/10") {
		startWith {
			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
		}

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))

				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "default")
				"event_data.payments.payment_method"(default: "default")
			}
		}
	}

	"checkout_congrats.by_payment_installments"(description: "all orders by payment installments (eg: /1 vs /6 vs /12)", compute_order: true, deprecation_date:"2019/12/10") {
		startWith {
			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
		}

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))

				and(
						equals("event_data.congrats_seq", 1),
						like("event_data.payments.payment_type", "credit_card")
				)
			}

			openBy {
				"event_data.payments.installments"(default: "default")
			}
		}
	}

	"checkout_congrats.by_payment_installments_and_without_fee"(description: "all orders by payment installments and without_fee (true or empty) (eg: /1/true vs /6 vs /12 vs /1-5/true-true)", compute_order: true, deprecation_date:"2019/12/10") {
		startWith {
			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
		}

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))

				and(
						equals("event_data.congrats_seq", 1),
						like("event_data.payments.payment_type", "credit_card")
				)
			}

			openBy {
				"event_data.payments.installments"(default: "default")
				"event_data.payments.without_fee"(default: "default")
			}
		}
	}

	"checkout_congrats.by.payment"(description: "all orders by payment type, payment_method and installments (eg: credit_card/visa/1 vs credit_card/visa/6 vs credit_card/master/12 vs atm/redlink vs ticket/rapidpag)", compute_order: true, deprecation_date:"2019/12/10") {
		startWith {
			experiment(regex("(mlinsights/.*)"))
		}

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))
				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "default")
				"event_data.payments.payment_method"(default: "default")
				"event_data.payments.installments"(default: "default")
			}
		}
	}

	"buys.pdp|qadb"(description: "Track buys of users in QADB experiment", compute_order: true) {
		startWith {
			experiment(regex("qadb/(qadb-on|qadb-on-viewport)"))
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

	"buys.vip|qadb_domains"(description: "Track buys only in qadb-enabled domains") {
		startWith {
			experiment("qadb/qadb-on-vip")
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
}
