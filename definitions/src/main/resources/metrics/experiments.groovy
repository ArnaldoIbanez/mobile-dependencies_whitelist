import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	"buyingflow/accountmoney_not_bep"(description: "define properties for order_id") {
		startWith {
			set_property("order_id", "event_data.order_id")
		}
	}

	"proactive_2PM"(description: "define properties for order_id") {
		startWith {
			set_property("order_id", "event_data.order_id")
		}
	}


	"buyingflow/accordAccordPay"(description: "define properties for order_id") {
		startWith {
			set_property("order_id", "event_data.order_id")
		}
	}


	"payments_from_click"(description: "payments view with tracking_referer_page not empty") {
		startWith {
			experiment("congrats_accord")
		}

		countsOn {
			condition {
				path("/checkout/payments")

				notEquals("event_data.tracking_referer_page", "")
			}
		}
	}

	"payments_from_back"(description: "payments view with tracking_referer_page empty") {
		startWith {
			experiment("congrats_accord")
		}

		countsOn {
			condition {
				path("/checkout/payments")

				equals("event_data.tracking_referer_page", "")
			}
		}
	}

	"congrats_with_payment"(description: "congrats view with payments containing 'payment' string", compute_order: true) {
		startWith {
			experiment("congrats_accord", "buyingflow/accordAccordPay")
		}

		countsOn {
			condition {
				path(regex("/checkout/congrats(/.*|\$)"))

				like("event_data.payments", ".*payment.*")
			}
		}
	}

	"congrats_with_payment.sameOrder"(description: "congrats view with payments containing 'payment' string", compute_order: true) {
		startWith {
			experiment("congrats_accord", "buyingflow/accordAccordPay")
		}

		countsOn {
			condition {
				path(regex("/checkout/congrats(/.*|\$)"))

				and(
					like("event_data.payments", ".*payment.*"),
					equals("event_data.order_id", property("order_id"))
				)
			}
		}
	}

	"orders.by.payment_count"(description: "all orders by payment count (0mp vs 1mp vs 2mp)", compute_order: true) {
		startWith {
			experiment(regex("(mlinsights/.*|buyingflow/.*|proactive_2PM)"))
		}

		countsOn {
			condition {
				path(regex("/checkout/congrats(/.*|\$)"))

				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "", function: "size")
			}
		}
	}

	"orders.by.payment"(description: "all orders by payment type, payment_method and installments (eg: credit_card/visa/1 vs credit_card/visa/6 vs credit_card/master/12 vs atm/redlink vs ticket/rapidpag)", compute_order: true) {
		startWith {
			experiment(regex("(mlinsights/.*|congrats_accord|psjMla|buyingflow/.*|proactive_2PM)"))
		}

		countsOn {
			condition {
				path(regex("/checkout/congrats(/.*|\$)"))

				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "default")
				"event_data.payments.payment_method"(default: "default")
				"event_data.payments.installments"(default: "default")
			}
		}
	}

	"orders.by.payment_type"(description: "all orders by payment type (eg: credit_card vs atm vs ticket vs cash)", compute_order: true) {
		startWith {
			experiment(regex("(mlinsights/.*|congrats_accord|psjMla|buyingflow/.*|proactive_2PM)"))
		}

		countsOn {
			condition {
				path(regex("/checkout/congrats(/.*|\$)"))

				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "default")
			}
		}
	}

	"orders.by.payment_method"(description: "all orders by payment type, payment_method (eg: credit_card/visa vs cre    dit_card/master vs atm/redlink vs ticket/rapidpag)", compute_order: true) {
		startWith {
			experiment(regex("(mlinsights/.*|congrats_accord|psjMla|buyingflow/.*|proactive_2PM)"))
		}

		countsOn {
			condition {
				path(regex("/checkout/congrats(/.*|\$)"))

				equals("event_data.congrats_seq", 1)
			}

			openBy {
				"event_data.payments.payment_type"(default: "default")
				"event_data.payments.payment_method"(default: "default")
			}
		}
	}

	"orders.by.payment_installments"(description: "all orders by payment installments (eg: /1 vs /6 vs /12)", compute_order: true) {
		startWith {
			experiment(regex("(mlinsights/.*|congrats_accord|psjMla|buyingflow/.*|proactive_2PM)"))
		}

		countsOn {
			condition {
				path(regex("/checkout/congrats(/.*|\$)"))

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

	"orders.by.payment_installments_and_without_fee"(description: "all orders by payment installments and without_fee (true or empty) (eg: /1/true vs /6 vs /12 vs /1-5/true-true)", compute_order: true) {
		startWith {
			experiment(regex("(mlinsights/.*|congrats_accord|psjMla|buyingflow/.*|proactive_2PM)"))
		}

		countsOn {
			condition {
				path(regex("/checkout/congrats(/.*|\$)"))

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

	"orders.by.review_rate"(description: "all orders by review_rate", compute_order: true) {
		startWith {
			experiment("reviewsOnOff")
		}

		countsOn {
			condition {
				equals("event_data.first_for_order", true)
			}

			openBy {
				"event_data.order_items.item.review_rate"(default: "", function: "round")
			}
		}
	}

	"search/filtersNewOrder.deal"(description: "extend experiment /search/filtersNewOrder with deal filter", parametricName: false) {
		startWith {
			condition {
				and(
					empty("experiments.search/filtersNewOrder", false),
					empty("event_data.filters.deal", false)
				)
			}

			openBy {
				"experiments.search/filtersNewOrder"(default: "default")
			}

			set_property("deal_id", "event_data.filters.deal")
		}
	}

    "seller_contacted"(description: "track vip contacts as success for classifieds in the new order experiment") {
        startWith {
            experiment("search/filtersNewOrder", "search/filtersNewOrder.deal", "search/filtersNewOrder.classifieds")
        }

        countsOn {
            condition {
                path("/vip/call_seller", "/vip/contact_seller", "/vip/show_phone")
            }
        }
    }

    "seller_called"(description: "track vip call seller as success for classifieds in the new order experiment") {
	    startWith {
            experiment("search/filtersNewOrder", "search/filtersNewOrder.deal", "search/filtersNewOrder.classifieds")
        }

  		countsOn {
			condition {
				path("/vip/call_seller", "/vip/show_phone")
			}
		}
	}

	"search/filtersNewOrder.classifieds"(description: "extend experiment /search/filtersNewOrder for classifieds", parametricName: false) {
		startWith {
			condition {
				and(
					empty("experiments.search/filtersNewOrder", false),
					or(
					    like('event_data.category_path', '.*M..1743(-|$).*'),
					    like('event_data.category_path', '.*M..1459(-|$).*')
					)
				)
			}
		}
	}
}
