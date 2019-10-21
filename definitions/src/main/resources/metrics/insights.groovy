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

	"mlinsights/search"(description: "mlinsights/search", acceptMultiVariantSession: true, parametricName: false) {
		startWith {
			condition {
				path(regex("^/search.*"))
			}

			openBy {
				"application.business"(default: "none")
			}
		}
	}

	"mlinsights/vip"(description: "mlinsights/vip", acceptMultiVariantSession: true, parametricName: false) {
		startWith {
			condition {
				path(regex("^/vip.*"))

			}

			set_property("item_id", "event_data.item_id")

			openBy {
				"application.business"(default: "none")
			}
		}
	}

	"mlinsights/checkout"(description: "mlinsights/checkout", acceptMultiVariantSession: true, parametricName: false) {
		startWith {
			condition {
				path(regex("^/checkout.*"))

			}

			set_property("order_id", "event_data.order_id")

			openBy {
				"application.business"(default: "none")
			}
		}
	}

}