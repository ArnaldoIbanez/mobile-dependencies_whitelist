package metrics

import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {
    "packs"(description: "total packs from /purchase/purchasecreated", sum_by:["event_data.total_packs"], bu: BuType.MercadoEnvios, extent: ExtentType.Product) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
                equals("application.business", "mercadolibre")
            }
        }
    }

    "packs.discount"(description: "total packs with discount from /purchase/purchasecreated", sum_by:["event_data.discount_packs"], bu: BuType.MercadoEnvios, extent: ExtentType.Product) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
                equals("application.business", "mercadolibre")
            }
        }
    }

    "packs.free_shipping"(description: "total free shipping packs from /purchase/purchasecreated", sum_by:["event_data.free_shipping_packs"], bu: BuType.MercadoEnvios, extent: ExtentType.Product) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
                equals("application.business", "mercadolibre")
            }
        }
    }
}
