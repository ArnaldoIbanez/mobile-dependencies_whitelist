package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	"loyalty.suscription.disneyplus.intention"(description: "define what type of plan to show in VPD to see which one converts better", deprecation_date:"2021/01/30") {
        startWith {
            experiment("loyalty/subscription_disneyplus")
        }

		countsOn {
			condition {
				path("/loyalty/partners/vdp/action")
	                	equals("event_data.subscription_partner", "disneyplus")
			}
		}
	}

	"loyalty.suscription.disneyplus"(description: "Finally makes a suscription to disneyplus", deprecation_date:"2021/01/30") {
        startWith {
            experiment("loyalty/subscription_disneyplus")
        }

		countsOn {
			condition {
				path("/loyalty/partners/checkout/congrats")
                		equals("event_data.subscription_partner", "disneyplus")
			}
		}
	}

}
