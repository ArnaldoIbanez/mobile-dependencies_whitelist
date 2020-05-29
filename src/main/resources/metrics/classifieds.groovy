import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def classiExperiments = "(.*/classi.*|vip/newDesignMotors|vip/newDesktopDesignMotors|buyingflow/reservationMLAv5|sell/congrats_upgrade_listing_type|vip/servicesNewDesignMobileMLA|vip/servicesNewDesignDesktopMLA|search.*|vip/realEstate.*)"

metrics {

	"reservation"(description: "orders that belong to a are a reservation", compute_order: true) {

		startWith {
			experiment(regex("(search/.*|vip/.*|classifieds/.*)"))
		}

		countsOn {
			condition {
				and (
						equals("path", "/orders/ordercreated"),
						equals("event_data.reservation", true)
				)
			}
		}
	}

	"vip/reservation_intention"(description: "track vip reservations init process for classifieds") {
		startWith {
			experiment(regex("(search/.*|vip/.*|classifieds/.*)"))
		}
		countsOn {
			condition {
				path("/vip/reservation_intention")
			}
		}
	}

	"seller_contacted"(description: "track vip contact seller as success for classifieds") {
		startWith {
			experiment(regex("(search/.*|vip/.*|classifieds/.*)"))
		}
		countsOn {
			condition {
				path("/vip/call_seller", "/vip/contact_seller")
			}
		}
	}


	"classifieds_user_contact"(description: "track vip user interaction as success for classifieds") {
		startWith {
			experiment(regex("(classifieds/.*)"))
		}

		countsOn {
			condition {
				path("/vip/call_seller", "/vip/show_phone", "/vip/contact_seller")
			}
		}
	}

	"classifieds_user_contact_mobile"(description: "track vip user interaction as success for classifieds mobile") {
		startWith {
			experiment(regex("(classifieds/.*)"))
		}

		countsOn {
			condition {
				path("/vip/call_seller", "/questions/ask/post")
			}
		}
	}

	"call_seller"(description: "track vip call seller as success for classifieds") {
		startWith {
			experiment(regex(classiExperiments))
		}

		countsOn {
			condition {
				path("/vip/call_seller")
			}
		}
	}

	"show_phone"(description: "track vip show phone as success for classifieds") {
		startWith {
			experiment(regex("(search/.*|vip/.*|classifieds/.*)"))
		}

		countsOn {
			condition {
				path("/vip/show_phone")
			}
		}
	}

	"contact_seller"(description: "track vip contact seller as success for classifieds") {
		startWith {
			experiment(regex("(search/.*|vip/.*)"))
		}

		countsOn {
			condition {
				path("/vip/contact_seller")
			}
		}
	}

	"quotations"(description: "track quotation as success for classifieds") {
		startWith {
			experiment(regex("(search/.*|vip/.*|classifieds/.*)"))
		}
		countsOn {
			condition {
				path("/quotation/congrats","/quotation/congrats/unregistered")
			}
		}
	}

}
