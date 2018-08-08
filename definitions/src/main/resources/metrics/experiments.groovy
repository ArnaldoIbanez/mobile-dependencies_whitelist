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

	"orders.officialStores.InCarrouselCategories"(description: "extend experiment /search/brandCarrousel", parametricName: false, compute_order: true) {
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

//	Advertising experiments
	"advertising.landing_interest"(description: "Track user interest on advertising as success") {
		startWith {
			experiment("advertising/pads2/contractFlow")
		}

		countsOn {
			condition {
				path("/advertising/pads2/generic_landing")
			}
		}
	}

	"advertising.contract_confirm_intention"(description: "Track user intention to contract advertising as success") {
		startWith {
			experiment("advertising/pads2/contractFlow")
		}

		countsOn {
			condition {
				path("/advertising/pads2/generic_landing/contract_confirmation")
			}
		}
	}

	"advertising.contract_confirm"(description: "Track user contracts advertising as success") {
		startWith {
			experiment("advertising/pads2/contractFlow")
		}

		countsOn {
			condition {
				path("/advertising/pads2/generic_landing/contract_confirmation/confirm")
			}
		}
	}

	"advertising.landing_change_budget"(description: "Track budget changes as success") {
		startWith {
			experiment("advertising/pads2/contractFlow")
		}

		countsOn {
			condition {
				path("/advertising/pads2/generic_landing/contract_confirmation/change_budget/confirm")
			}
		}
	}

	"advertising.landing_change_budget_intention"(description: "Track user interaction with change budget button from principal landing as success") {
		startWith {
			experiment("advertising/pads2/contractFlow")
		}

		countsOn {
			condition {
				path("/advertising/pads2/generic_landing/change_budget")
			}
		}
	}

	"advertising.landing_change_budget_intention"(description: "Track user interaction with change budget button from confirm page as success") {
		startWith {
			experiment("advertising/pads2/contractFlow")
		}

		countsOn {
			condition {
				path("/advertising/pads2/generic_landing/contract_confirmation/change_budget")
			}
		}
	}

	"advertising.contract_intention.button_top"(description: "Track user interaction with main action top button as success") {
		startWith {
			experiment("advertising/pads2/contractFlow")
		}

		countsOn {
			condition {
				path("/advertising/pads2/generic_landing/main_action")
				and(
						equals("event_data.button", "top")
				)
			}
		}
	}

	"advertising.contract_intention.button_bottom"(description: "Track user interaction with main action bottom button as success") {
		startWith {
			experiment("advertising/pads2/contractFlow")
		}

		countsOn {
			condition {
				path("/advertising/pads2/generic_landing/main_action")
				and(
						equals("event_data.button", "bottom")
				)
			}
		}
	}

}
