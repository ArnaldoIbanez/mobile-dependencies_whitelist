import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "point_congrats"(description: "Arrival to congrats page from Point landings", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex("mpos/.*"))

        countsOn {
            condition {
                path("/checkout_off/v1/checkout_confirmed")
                or(
                    equals("event_data.collector_id", "228415881"),
                    equals("event_data.collector_id", "179504451"),
                    equals("event_data.collector_id", "193054976")
                )
            }
        }
    }

    "point_buy_intention"(description: "Point Landings buy intention", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex("mpos/.*"))

        countsOn {
            condition {
                path("/point/landings/buy")
            }
        }
    }
}
