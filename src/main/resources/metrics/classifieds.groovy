import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType
import com.ml.melidata.metrics.TagType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def searchVipClassifiedExperiments = "((search|vip|classifieds|vis|sparkle)/.*)|(pdp/viewItemPageMigration.*)"
def viewItemPageMigration = "pdp/viewItemPageMigration.*"
def visRegex="(vis|vip)/.*"

metrics {

	"reservation"(description: "orders that belong to a are a reservation", compute_order: true, bu: BuType.MercadoLibre, extent: ExtentType.Company) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				and (
						equals("path", "/orders/ordercreated"),
						equals("event_data.reservation", true)
				)
			}
		}
	}

	"vip/reservation_intention"(description: "track vip reservations init process for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Company) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/reservation_intention")
			}
		}
	}

	"seller_contacted"(description: "track vip contact seller as success for classifieds", tags:[TagType.CoreMetric], bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/call_seller", "/vip/contact_seller", "/vip/contact_whatsapp", "/contact_seller", "/vip/coordinate_availability")
			}
		}
	}


	"classifieds_user_contact"(description: "track vip user interaction as success for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/call_seller", "/vip/show_phone", "/vip/contact_seller", "/vip/contact_whatsapp")
			}
		}
	}

	"classifieds_user_contact_mobile"(description: "track vip user interaction as success for classifieds mobile", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/call_seller", "/questions/ask/post", "/vip/contact_whatsapp")
			}
		}
	}

	"call_seller"(description: "track vip call seller as success for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/call_seller")
			}
		}
	}

	"show_phone"(description: "track vip show phone as success for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/show_phone")
			}
		}
	}

	"contact_seller"(description: "track vip contact seller as success for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/contact_seller", "/contact_seller", "/vip/coordinate_availability")
			}
		}
	}

	"contact_whatsapp"(description: "track vip contact whatsapp as success for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/contact_whatsapp")
			}
		}
	}

	"whatsapp_support"(description: "track vip whatsapp support as success for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/vip/whatsapp_support")
			}
		}
	}

	"quotations"(description: "track quotation as success for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(searchVipClassifiedExperiments))

		countsOn {
			condition {
				path("/quotation/congrats","/quotation/congrats/unregistered")
			}
		}
	}

	"vis_credits_intention"(description: "track credits intention as success for vis", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(visRegex))

		countsOn {
			condition {
				path("/vip/credits_intention/main_action/down", "/vip/credits_intention/card")
			}
		}
	}

	"vis_credits_congrats"(description: "track credits congrats as success for vis", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(visRegex))

		countsOn {
			condition {
				path("/vis_credits/congrats")
				and(
						equals("event_data.congrats_status", "APPROVED")
				)
			}
		}
	}

	"vis_credits.contact_intention"(description: "track contact intention as success for vis", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(visRegex))

		countsOn {
			condition {
				path("/vis_credits/congrats/contact_intention", "/vis_credits/congrats/call_intention", "/vis_credits/congrats/whatsapp_intention")
			}
		}
	}

	"quotations.services"(description: "track quotation as success for services (classifieds)", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(viewItemPageMigration))

		countsOn {
			condition {
				path("/quote_demand/buyer/create/submit_quote_demand")
			}
		}
	}

	"contract_intention"(description: "track contract intention for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(viewItemPageMigration))

		countsOn {
			condition {
				path("/vip/contract_intention")
			}
		}
	}

	"quotation.intention"(description: "track quotation intention for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(viewItemPageMigration))

		countsOn {
			condition {
				path("/vip/quotation_intention")
			}
		}
	}

	"quotation.details"(description: "track quotation details of models for classifieds", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex(viewItemPageMigration))

		countsOn {
			condition {
				path("/quotation/details")
			}
		}
	}
}
