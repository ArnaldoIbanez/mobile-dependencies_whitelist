package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

	"mlinsights/site"(description: "mlinsights/site", acceptMultiVariantSession: true, parametricName: false) {
		startWith {
			condition {
				path(regex(".*"))
			}

			openBy {
				"application.business"(default: "none")
			}
		}
	}

}
