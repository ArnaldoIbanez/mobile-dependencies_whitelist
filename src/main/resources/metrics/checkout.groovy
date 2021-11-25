import com.ml.melidata.metrics.TagType

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
		experiment(regex(checkoutExperiments))

		countsOn {
			condition {
				path(regex("^/checkout/congrats(/.*|\$)"))
				equals("event_data.congrats_seq", 1)
			}
		}
	}


	"checkout_congrats.cart"(description: "/cart/checkout/congrats unique for each purchase_id (congrats_seq = 1)", compute_order: true) {
		experiment(regex(checkoutExperiments))

		countsOn {
			condition {
				path("/cart/checkout/congrats")
				equals("event_data.congrats_seq", 1)
			}
		}
	}

	"checkout.loading"(description: "The checkout V5 first-page after performing a buy_intention ", tags:[TagType.CoreMetric]) {
		experiment(regex(checkoutExperiments))

		countsOn {
			condition {
				path("/checkout/loading")
			}
		}
	}

	"checkout.login"(description: "path: /checkout/login/confirm_authenticated or /checkout/login/first_purchase_not_authenticated or /checkout/login/confirm_not_authenticated") {
		experiment(regex("(search|vip)/.*"))

		countsOn {
			condition {
				path("/checkout/login/confirm_authenticated", "/checkout/login/first_purchase_not_authenticated", "/checkout/login/confirm_not_authenticated")
			}
		}
	}


	"checkout_congrats.with_payment.sameOrder"(description: "congrats view with payments containing 'payment' string", compute_order: true) {
		experiment(regex("(.*email/order.*)"))

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

}
