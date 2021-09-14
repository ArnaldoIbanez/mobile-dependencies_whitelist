import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType

metrics {
	"vip"(description: "vip count", tags:[TagType.Important]) {
		countsOn {
			condition {
				path("/vip", "/vip/abort", "/vip/failure")
			}
		}
	}

	"search"(description: "search count") {
		countsOn {
			condition {
				path("/search", "/search/abort", "/search/failure")
			}
		}
	}

	"pdp"(description: "pdp` count") {
		countsOn {
			condition {
				path("/pdp", "/pdp/abort", "/pdp/failure")
			}
		}
	}

}
