import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def classiExperiments = "(.*/classi.*|vip/newDesignMotors|vip/newDesktopDesignMotors|buyingflow/reservationMLAv5|sell/congrats_upgrade_listing_type|vip/servicesNewDesignMobileMLA|vip/servicesNewDesignDesktopMLA|search.*|vip/realEstate.*)"

metrics {

    "reservation"(description: "orders that belong to a are a reservation", compute_order: true) {
	    
   	startWith {
		experiment(regex(classiExperiments))
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

	"loyalty/buy_level_installments"(description: "define which buy level button to show in VIP modal to see which converts best") {
        startWith {
            experiment("loyalty/buy-level-installments")
        }

		countsOn {
			condition {
				path("/loyalty/vip/modal/action")
				and(
                	equals("event_data.type", "buy_level")
				)
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

	//TODO esto se debe eliminar una vez que deje de ser experimento, o cuando la data ya sea concluyente. La métrica fue reemplazada por su equivalente "classifieds_user_contact"
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

	"classifieds_user_contact"(description: "track vip user interaction as success for classifieds") {
		startWith {
			experiment(regex(classiExperiments))
		}

		countsOn {
			condition {
				path("/vip/call_seller", "/vip/show_phone", "/vip/contact_seller")
			}
		}
	}

	"classifieds_user_contact_mobile"(description: "track vip user interaction as success for classifieds mobile") {
		startWith {
			experiment(regex(classiExperiments))
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
				path("/quotation/congrats", "/quotation/congrats/unregistered")
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

	"asset_management_congrats"(description: "Arrival to congrats for Asset Management") {
		startWith {
			experiment("mpmobile/asset_management")
		}

		countsOn {
			condition {
				path("/asset_management/result_investing")
			}
		}
	}

	"asset_management_start_investing"(description: "Touches the button 'Quiero invertir' from onboarding") {
		startWith {
			experiment("mpmobile/asset_management")
		}

		countsOn {
			condition {
				path("/asset_management/start_investing")
			}
		}
	}

	"seller_central/goal_achieved"(description: "Goal achieved") {
		startWith {
			experiment("sell/health-goals_order")
		}

		countsOn {
			condition {
				path("/seller_central/modify/success")
				and(
					empty("event_data.goals_achieved", false)
				)
			}
		}
	}

	"pdp_questions_qadb"(description: "Track PDP questions of users in QADB experiment") {
		startWith {
			experiment("qadb/qadb-on")
		}

		countsOn {
			condition {
				path("/questions/ask/post")
				and(
					or(
						equals("event_data.context", "/pdp"),
						equals("event_data.context", "/qadb"),
						equals("event_data.context", "/questions/qadb")
					)
				)
			}
		}
	}

	"pdp_buys_qadb"(description: "Track buys of users in QADB experiment", compute_order: true) {
		startWith {
			experiment("qadb/qadb-on")
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

	"credits-open-sea_vip.vip_conversion"(description: "vip total conversion under credits open sea experiment") {
		startWith {
			experiment("credits/openSeaVIPIntegration")
		}
		countsOn {
			condition {
				or(
					and(
						equals("path", "/buy_intention"),
						equals("event_data.context", "vip")
					),
					and(
						equals("path", "/credits/consumer/opensea/integrated_flow/start"),
						equals("event_data.source", "vip")
					)
				)
			}
		}
	}

	"credits-open-sea_vip.credits_conversion"(description: "credits open sea conversion from experiment in vip") {
		startWith {
			experiment("credits/openSeaVIPIntegration")
		}
		countsOn {
			condition {
				and(
					equals("path", "/credits/consumer/opensea/integrated_flow/start"),
					equals("event_data.source", "vip")
				)
			}
		}
	}

	"credits-open-sea_vip.checkout_conversion"(description: "checkout conversion under credits opensea experiment in vip") {
		startWith {
			experiment("credits/openSeaVIPIntegration")
		}
		countsOn {
			condition{
				equals("event_data.congrats_seq",1)
			}
		}
	}

	"credits-open-sea_vip.checkout_conversion_with_credits"(description: "checkout conversion, using credits as payment method, under credits opensea experiment in vip") {
		startWith {
			experiment("credits/openSeaVIPIntegration")
		}
		countsOn {
			condition{
				and(
					equals("event_data.congrats_seq",1),
					equals("event_data.payments.payment_method", "consumer_credits")
				)
			}
		}
	}

	"credits-open-sea.remedies_conversion"(description: "credits conversion under remedies experiment") {
		startWith {
			experiment("credits/openSeaRemedy")
		}
		countsOn {
			condition {
				equals("path", "/credits/consumer/public_landing/application_result")
			}
		}
	}

}
