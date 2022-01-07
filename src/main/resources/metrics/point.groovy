import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "point_congrats"(description: "Arrival to Point congrats page.",
            bu: BuType.MercadoPago,
            extent: ExtentType.Product) {

        countsOn {
            condition {
                path("/point/buyingflow/congrats")
            }
        }
    }

}

