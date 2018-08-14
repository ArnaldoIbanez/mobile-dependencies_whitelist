import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

//	Advertising experiments
//  dpto.page.action.scope

	"advertising.confirmation.contract_confirm"(description: "Track user advertising contracts as success ") {
		startWith {
			experiment("mclics/landingpads2")
		}

		openBy {
			"experiments.mclics/landingpads2"(default: "none")
		}

		countsOn {
			condition {
				path("/advertising/pads2/landing/contract_confirmation/confirm")
			}
		}
	}
}
