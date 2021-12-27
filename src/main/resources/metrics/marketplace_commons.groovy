import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType

metrics {
	"vip"(description: "vip count", tags:[TagType.Important, TagType.CoreMetric], bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		countsOn {
			condition {
				path("/vip", "/vip/abort", "/vip/failure")
			}
		}
	}

	"search"(description: "search count", tags:[TagType.CoreMetric], bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		countsOn {
			condition {
				path("/search", "/search/abort", "/search/failure")
			}
		}
	}

	"pdp"(description: "pdp` count", tags:[TagType.CoreMetric], bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		countsOn {
			condition {
				path("/pdp", "/pdp/abort", "/pdp/failure")
			}
		}
	}

}
