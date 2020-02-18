package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	
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




}
