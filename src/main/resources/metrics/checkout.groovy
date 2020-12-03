import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def checkoutExperiments = "(checkout|buyingflow)/.*"

metrics {

	"checkout_congrats"( description: "all congrats, including carrito and checkout congrats", compute_order:true){

		countsOn {
			condition{
				equals("event_data.congrats_seq",1)
			}
		}
	}

	"checkout_congrats.single"(description: "/checkout/congrats* unique for each order_id (congrats_seq = 1)", compute_order: true) {
		startWith {
			experiment(regex(checkoutExperiments))
		}
		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))
				equals("event_data.congrats_seq", 1)
			}
		}
	}


	"checkout_congrats.cart"(description: "/cart/checkout/congrats unique for each purchase_id (congrats_seq = 1)", compute_order: true) {
		startWith {
			experiment(regex(checkoutExperiments))
		}
		countsOn {
			condition {
				path("/cart/checkout/congrats")
				equals("event_data.congrats_seq", 1)
			}
		}
	}

	"checkout.loading"(description: "The checkout V5 first-page after performing a buy_intention ") {
		startWith {
			experiment(regex(checkoutExperiments))
		}
		countsOn {
			condition {
				path("/checkout/loading")
			}
		}
	}

	"checkout.login"(description: "path: /checkout/login/confirm_authenticated or /checkout/login/first_purchase_not_authenticated or /checkout/login/confirm_not_authenticated") {
		startWith {
			experiment(regex("(search|vip)/.*"))
		}
		countsOn {
			condition {
				path("/checkout/login/confirm_authenticated", "/checkout/login/first_purchase_not_authenticated", "/checkout/login/confirm_not_authenticated")
			}
		}
	}


	"checkout_congrats.with_payment.sameOrder"(description: "congrats view with payments containing 'payment' string", compute_order: true) {
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


//	"checkout_congrats.payment_count"(description: "all orders by payment count (0mp vs 1mp vs 2mp)", compute_order: true) {
//		startWith {
//			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
//		}
//
//		countsOn {
//			condition {
//				path(regex("^/checkout/congrats(/.*|\$)"))
//
//				equals("event_data.congrats_seq", 1)
//			}
//
//			openBy {
//				"event_data.payments.payment_type"(default: "", function: "size")
//			}
//		}
//	}

//	"checkout_congrats.by_payment"(description: "all orders by payment type, payment_method and installments (eg: credit_card/visa/1 vs credit_card/visa/6 vs credit_card/master/12 vs atm/redlink vs ticket/rapidpag)", compute_order: true) {
//		startWith {
//			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
//		}
//
//		countsOn {
//			condition {
//				path(regex("^/checkout/congrats(/.*|\$)"))
//
//				equals("event_data.congrats_seq", 1)
//			}
//
//			openBy {
//				"event_data.payments.payment_type"(default: "default")
//				"event_data.payments.payment_method"(default: "default")
//				"event_data.payments.installments"(default: "default")
//			}
//		}
//	}

//	"checkout_congrats.by_payment_type"(description: "all orders by payment type (eg: credit_card vs atm vs ticket vs cash)", compute_order: true) {
//		startWith {
//			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
//		}
//
//		countsOn {
//			condition {
//				path(regex("^/checkout/congrats(/.*|\$)"))
//
//				equals("event_data.congrats_seq", 1)
//			}
//
//			openBy {
//				"event_data.payments.payment_type"(default: "default")
//			}
//		}
//	}

//	"checkout_congrats.by_payment_method"(description: "all orders by payment type, payment_method (eg: credit_card/visa vs cre    dit_card/master vs atm/redlink vs ticket/rapidpag)", compute_order: true) {
//		startWith {
//			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
//		}
//
//		countsOn {
//			condition {
//				path(regex("^/checkout/congrats(/.*|\$)"))
//
//				equals("event_data.congrats_seq", 1)
//			}
//
//			openBy {
//				"event_data.payments.payment_type"(default: "default")
//				"event_data.payments.payment_method"(default: "default")
//			}
//		}
//	}

//	"checkout_congrats.by_payment_installments"(description: "all orders by payment installments (eg: /1 vs /6 vs /12)", compute_order: true) {
//		startWith {
//			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
//		}
//
//		countsOn {
//			condition {
//				path(regex("^/checkout/congrats(/.*|\$)"))
//
//				and(
//						equals("event_data.congrats_seq", 1),
//						like("event_data.payments.payment_type", "credit_card")
//				)
//			}
//
//			openBy {
//				"event_data.payments.installments"(default: "default")
//			}
//		}
//	}

//	"checkout_congrats.by_payment_installments_and_without_fee"(description: "all orders by payment installments and without_fee (true or empty) (eg: /1/true vs /6 vs /12 vs /1-5/true-true)", compute_order: true) {
//		startWith {
//			experiment(regex("(mlinsights/.*|buyingflow/.*)"))
//		}
//
//		countsOn {
//			condition {
//				path(regex("^/checkout/congrats(/.*|\$)"))
//
//				and(
//						equals("event_data.congrats_seq", 1),
//						like("event_data.payments.payment_type", "credit_card")
//				)
//			}
//
//			openBy {
//				"event_data.payments.installments"(default: "default")
//				"event_data.payments.without_fee"(default: "default")
//			}
//		}
//	}

}
