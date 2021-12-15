package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {
    "packs"(description: "total packs from /purchase/purchasecreated", sum_by:["event_data.total_packs"]) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
                equals("application.business", "mercadolibre")
            }
        }
    }

    "packs.discount"(description: "total packs with discount from /purchase/purchasecreated", sum_by:["event_data.discount_packs"]) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
                equals("application.business", "mercadolibre")
            }
        }
    }

    "packs.free_shipping"(description: "total free shipping packs from /purchase/purchasecreated", sum_by:["event_data.free_shipping_packs"]) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
                equals("application.business", "mercadolibre")
            }
        }
    }
}
