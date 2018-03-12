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
