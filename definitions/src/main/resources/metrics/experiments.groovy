import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def classiExperiments = "(.*/classi.*|vip/newDesignMotors|vip/newDesktopDesignMotors|buyingflow/reservationMLAv5|sell/congrats_upgrade_listing_type|vip/servicesNewDesignMobileMLA|vip/servicesNewDesignDesktopMLA|search/goLocal)"

metrics {

    "sell/full_relist_single_item"(description: "define properties for item_id at full_relist experiment") {
        startWith {
            set_property("item_id", "event_data.item_id")
        }
    }


    "vip/plainText"(description: "define properties for item_id for vip description (html vs plain) experiment") {
        startWith {
            set_property("item_id", "event_data.item_id")
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
	"orders.InCarrouselCategories"(description: "extend experiment /search/brandCarrousel", parametricName: false, compute_order: true) {
		startWith {
			experiment("search/officialStoresCarrousel")
		}

		countsOn {
			condition {
				path("/orders/ordercreated")
				or(
					like('event_data.items.item.category_path', '.*MLM6585,.*'),
					like('event_data.items.item.category_path', '.*MLM5607,.*'),
					like('event_data.items.item.category_path', '.*MLM120666,.*'),
					like('event_data.items.item.category_path', '.*MLM182735,.*'),
					like('event_data.items.item.category_path', '.*MLM81531,.*'),
					like('event_data.items.item.category_path', '.*MLM4651,.*'),
					like('event_data.items.item.category_path', '.*MLM8574,.*'),
					like('event_data.items.item.category_path', '.*MLM2827,.*'),
					like('event_data.items.item.category_path', '.*MLM158119,.*'),
					like('event_data.items.item.category_path', '.*MLM1271,.*'),
					like('event_data.items.item.category_path', '.*MLM180982,.*'),
					like('event_data.items.item.category_path', '.*MLM1676 ,.*'),
					like('event_data.items.item.category_path', '.*MLM168281 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1285 ,.*'),
					like('event_data.items.item.category_path', '.*MLM187814 ,.*'),
					like('event_data.items.item.category_path', '.*MLM158842 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1010 ,.*'),
					like('event_data.items.item.category_path', '.*MLM158828 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1386 ,.*'),
					like('event_data.items.item.category_path', '.*MLM5723 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1578 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1712 ,.*'),
					like('event_data.items.item.category_path', '.*MLM8378 ,.*'),
					like('event_data.items.item.category_path', '.*MLB23332 ,.*'),
					like('event_data.items.item.category_path', '.*MLB181294 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1248 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1002 ,.*'),
					like('event_data.items.item.category_path', '.*MLB181294 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1676 ,.*'),
					like('event_data.items.item.category_path', '.*MLB191839 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1286 ,.*'),
					like('event_data.items.item.category_path', '.*MLB264721 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1580 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1386 ,.*'),
					like('event_data.items.item.category_path', '.*MLB21168 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1456 ,.*'),
					like('event_data.items.item.category_path', '.*MLA109027 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1002 ,.*'),
					like('event_data.items.item.category_path', '.*MLA398582 ,.*'),
					like('event_data.items.item.category_path', '.*MLA6839 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1248 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1676 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1042 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1285 ,.*'),
					like('event_data.items.item.category_path', '.*MLA409558 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1575 ,.*'),
					like('event_data.items.item.category_path', '.*MLA409810 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1618 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1386 ,.*'),
					like('event_data.items.item.category_path', '.*MLA6750 ,.*'),
					like('event_data.items.item.category_path', '.*MLA18353 ,.*'),
					like('event_data.items.item.category_path', '.*MLA3959 ,.*')
				)
			}
		}
	}

	"orders.officialStores.InCarrouselCategories"(description: "extend experiment /search/brandCarrousel", parametricName: false, compute_order: true) {
		startWith {
			experiment("search/officialStoresCarrousel")
		}

		countsOn {
			condition {
				and(
					path("/orders/ordercreated")
					empty("event_data.items.item.official_store_id", false)
				)
				or(
					like('event_data.items.item.category_path', '.*MLM6585,.*'),
					like('event_data.items.item.category_path', '.*MLM5607,.*'),
					like('event_data.items.item.category_path', '.*MLM120666,.*'),
					like('event_data.items.item.category_path', '.*MLM182735,.*'),
					like('event_data.items.item.category_path', '.*MLM81531,.*'),
					like('event_data.items.item.category_path', '.*MLM4651,.*'),
					like('event_data.items.item.category_path', '.*MLM8574,.*'),
					like('event_data.items.item.category_path', '.*MLM2827,.*'),
					like('event_data.items.item.category_path', '.*MLM158119,.*'),
					like('event_data.items.item.category_path', '.*MLM1271,.*'),
					like('event_data.items.item.category_path', '.*MLM180982,.*'),
					like('event_data.items.item.category_path', '.*MLM1676 ,.*'),
					like('event_data.items.item.category_path', '.*MLM168281 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1285 ,.*'),
					like('event_data.items.item.category_path', '.*MLM187814 ,.*'),
					like('event_data.items.item.category_path', '.*MLM158842 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1010 ,.*'),
					like('event_data.items.item.category_path', '.*MLM158828 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1386 ,.*'),
					like('event_data.items.item.category_path', '.*MLM5723 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1578 ,.*'),
					like('event_data.items.item.category_path', '.*MLM1712 ,.*'),
					like('event_data.items.item.category_path', '.*MLM8378 ,.*'),
					like('event_data.items.item.category_path', '.*MLB23332 ,.*'),
					like('event_data.items.item.category_path', '.*MLB181294 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1248 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1002 ,.*'),
					like('event_data.items.item.category_path', '.*MLB181294 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1676 ,.*'),
					like('event_data.items.item.category_path', '.*MLB191839 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1286 ,.*'),
					like('event_data.items.item.category_path', '.*MLB264721 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1580 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1386 ,.*'),
					like('event_data.items.item.category_path', '.*MLB21168 ,.*'),
					like('event_data.items.item.category_path', '.*MLB1456 ,.*'),
					like('event_data.items.item.category_path', '.*MLA109027 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1002 ,.*'),
					like('event_data.items.item.category_path', '.*MLA398582 ,.*'),
					like('event_data.items.item.category_path', '.*MLA6839 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1248 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1676 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1042 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1285 ,.*'),
					like('event_data.items.item.category_path', '.*MLA409558 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1575 ,.*'),
					like('event_data.items.item.category_path', '.*MLA409810 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1618 ,.*'),
					like('event_data.items.item.category_path', '.*MLA1386 ,.*'),
					like('event_data.items.item.category_path', '.*MLA6750 ,.*'),
					like('event_data.items.item.category_path', '.*MLA18353 ,.*'),
					like('event_data.items.item.category_path', '.*MLA3959 ,.*')
				)
			}
		}
	}

	"relist_upgrade"(description: "An Item was relisted in a higher listing type than its parent") {
		startWith {
			experiment("sell/full_relist_single_item")
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

	"seller_contacted"(description: "track vip contact seller as success for classifieds") {
		startWith {
			experiment(regex(classiExperiments))
		}
		countsOn {
			condition {
				path("/vip/call_seller", "/vip/contact_seller")
			}
		}
	}

	"user_vip_interaction"(description: "track vip user interaction as success for classifieds") {
		startWith {
			experiment(regex(classiExperiments))
		}

		countsOn {
			condition {
				path("/vip/call_seller", "/vip/show_phone", "/vip/contact_seller")
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
			experiment(regex(classiExperiments))
		}

		countsOn {
			condition {
				path("/vip/show_phone")
			}
		}
	}

	"contact_seller"(description: "track vip contact seller as success for classifieds") {
		startWith {
			experiment(regex(classiExperiments))
		}

		countsOn {
			condition {
				path("/vip/contact_seller")
			}
		}
	}

	"quotations"(description: "track quotation as success for classifieds") {
		countsOn {
			condition {
				path("/quotation/congrats")
			}
		}
	}

	"vip/reservation_intention"(description: "track vip reservations init process for classifieds") {
		countsOn {
			condition {
				path("/vip/reservation_intention")
			}
		}
	}

	"identity-validation/uniqueness.recommendation"(description: "Trust vote to login user") {
		startWith {
			experiment("auth/identity-validation_recommendation")
		}

		countsOn {
			condition {
				and(
						path("/identity-validation/finish_validation"),
						or(
								equals('event_data.flow', "uniqueness"),
								equals('event_data.flow', "recommendation")
						)
				)
			}
		}
	}

	"upgrade_listing"(description: "upgrade listing success for sell experiments") {
		startWith {
			experiment("sell/congrats_upgrade_listing_type")
		}

		countsOn {
			condition {
				path("/sell/upgrade/listing_types")
			}
		}
	}
}
