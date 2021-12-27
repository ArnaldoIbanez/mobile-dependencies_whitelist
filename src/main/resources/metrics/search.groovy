import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "search.applied_filters"(description: "Applied filters", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment(regex("(search|filters)/.*"))

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.\\bapplied_filter_id.*')
            }
        }
    }

    "search.unapplied_filters"(description: "Unapplied filters", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment(regex("(search|filters)/.*"))

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.unapplied_filter_id.*')
            }
        }
    }

    "search.enhanced_search_filters_applied"(description: "Enhanced Search filters applied", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment(regex("(search|filters)/.*"))

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.*enhanced_position.*')
            }
        }
    }
}
