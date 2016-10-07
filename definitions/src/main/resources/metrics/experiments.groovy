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
            experiment(regex("(.*email/order.*|congrats_accord|buyingflow/accordAccordPay)"))
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


    "search/newFiltersAndSortWebMobile.seller_called"(description: "track vip call seller as success for classifieds in the new filters mobile experiment") {
	    startWith {
            experiment("search/newFiltersAndSortWebMobile", "search/newFiltersAndSortWebMobile.classifieds")
        }

  		countsOn {
			condition {
				path("/vip/call_seller", "/vip/show_phone")
			}
		}
	}

	"newFiltersWebMobileTwoVariants.seller_called"(description: "track vip call seller as success for classifieds in the new filters mobile experiment") {
	    startWith {
            experiment("search/newFiltersWebMobileTwoVariants", "search/newFiltersWebMobileTwoVariants.classifieds")
        }

  		countsOn {
			condition {
				path("/vip/call_seller", "/vip/show_phone")
			}
		}
	}

	"search/newFiltersAndSortWebMobile.classifieds"(description: "extend experiment /search/newFiltersAndSortWebMobile for classifieds", parametricName: false) {
		startWith {
			condition {
				and(
					empty("experiments.search/newFiltersAndSortWebMobile", false),
					or(
					    like('event_data.category_path', '.*M..1743(-|$).*'),
					    like('event_data.category_path', '.*M..1459(-|$).*')
					)
				)
			}

			openBy {
				"experiments.search/newFiltersAndSortWebMobile"(default: "DEFAULT")
			}
		}
	}

	"search/newFiltersWebMobileTwoVariants.classifieds"(description: "extend experiment /search/newFiltersWebMobileTwoVariants for classifieds", parametricName: false) {
		startWith {
			condition {
				and(
						empty("experiments.search/newFiltersWebMobileTwoVariants", false),
						or(
								like('event_data.category_path', '.*M..1743(-|$).*'),
								like('event_data.category_path', '.*M..1459(-|$).*')
						)
				)
			}

			openBy {
				"experiments.search/newFiltersWebMobileTwoVariants"(default: "DEFAULT")
			}

		}
	}

	"upgrade_on"(description: "A Item was upgrade in a higher listing type after see congrats page") {
		startWith {
			experiment("sell/radio_vs_submit_button_upgrade_on")
		}

		countsOn {
			condition {
				path("/item/change_listing_type")
				and(
					equals("event_data.source", "upgrade_on"),
					equals("event_data.vertical", "CORE")
				)
			}
		}
	}

	"relist_upgrade"(description: "An Item was relisted in a higher listing type than its parent") {
		startWith {
			experiment("sell/full_relist_single_item")

			set_property("item_id", "event_data.item_id")
		}

		countsOn {
			condition {
				path("/item/relist")
				and(
					equals("event_data.change_listing_type", "upgrade"),
					equals("event_data.item_id", property("item_id"))
				)
			}
		}
	}

	"relist_downgrade"(description: "An Item was relisted in a lower listing type than its parent") {
		startWith {
			experiment("sell/full_relist_single_item")

			set_property("item_id", "event_data.item_id")
		}

		countsOn {
			condition {
				path("/item/relist")
				and(
					equals("event_data.change_listing_type", "downgrade"),
					equals("event_data.item_id", property("item_id"))
				)
			}
		}
	}

	"search/newFiltersWebMobileTwoVariants.low"(description: "Experiment open by device.resolution_height") {
		startWith {
			condition {
				and(
						empty("experiments.search/newFiltersWebMobileTwoVariants", false),
						or(
								and(
										equals("device.vendor", "apple"),
										lte("device.resolution_height", 500)
								),
								and(
										notEquals("device.vendor", "apple"),
										lte("device.resolution_height", 639))
						)

				)
			}

			openBy {
				"experiments.search/newFiltersWebMobileTwoVariants"(default: "DEFAULT")
			}
		}
	}

	"search/newFiltersWebMobileTwoVariants.medium"(description: "Experiment open by device.resolution_height") {
		startWith {
			condition {
				and(
						empty("experiments.search/newFiltersWebMobileTwoVariants", false),
						or(
								and(
										equals("device.vendor", "apple"),
										gt("device.resolution_height", 500),
										lte("device.resolution_height", 600)
								),
								and(
										notEquals("device.vendor", "apple"),
										equals("device.resolution_height", 640)
								)
						)
				)
			}

			openBy {
				"experiments.search/newFiltersWebMobileTwoVariants"(default: "DEFAULT")
			}
		}
	}

	"search/newFiltersWebMobileTwoVariants.high"(description: "Experiment open by device.resolution_height") {
		startWith {
			condition {
				and(
						empty("experiments.search/newFiltersWebMobileTwoVariants", false),
						or(
								and(
										equals("device.vendor", "apple"),
										gt("device.resolution_height", 600)
								),
								and(
										notEquals("device.vendor", "apple"),
										gt("device.resolution_height", 640)
								)
						)
				)
			}

			openBy {
				"experiments.search/newFiltersWebMobileTwoVariants"(default: "DEFAULT")
			}
		}


	}

	"seller_called"(description: "track vip call seller as success for classifieds") {
		countsOn {
			condition {
				path("/vip/call_seller", "/vip/show_phone")
			}
		}
	}

	"search/filtersNewOrderDealsAndroid.deal"(description: "extend experiment /search/filtersNewOrderDealsAndroid with deal filter", parametricName: false) {
		startWith {
			condition {
				and(
						empty("experiments.search/filtersNewOrderDealsAndroid", false),
						empty("event_data.filters.deal", false)
				)
			}

			openBy {
				"experiments.search/filtersNewOrderDealsAndroid"(default: "default")
			}

			set_property("deal_id", "event_data.filters.deal")
		}
	}
}
