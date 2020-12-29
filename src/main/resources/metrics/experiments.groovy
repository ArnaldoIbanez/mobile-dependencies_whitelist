package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	
	"loyalty/buy_level_installments"(description: "define which buy level button to show in VIP modal to see which converts best", deprecation_date:"2020/08/12") {
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

	"identity-validation/uniqueness.recommendation"(description: "Trust vote to login user", deprecation_date:"2020/08/12") {
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

	"idfa.deny"(description: "IDFA alert shown", deprecation_date:"2021/01/31") {
		startWith {
			experiment("mobile/IDFA_Banner")
		}

		countsOn {
			condition {
				path("/permissions/idfa/deny")
			}
		}
	}

	"idfa.accept"(description: "IDFA permission accepted", deprecation_date:"2021/01/31") {
		startWith {
			experiment("mobile/IDFA_Banner")
		}

		countsOn {
			condition {
				path("/permissions/idfa/accept")
			}
		}
	}
}
