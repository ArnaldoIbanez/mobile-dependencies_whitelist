import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "email.open"(description: "path: /email/orders and event_type: open", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        countsOn {
            condition {
                path("/email/orders")

                and(
                    equals("event_data.event_type", "open"),
                    equals("event_data.order_id", property("order_id"))
                )
            }
        }
    }

}
