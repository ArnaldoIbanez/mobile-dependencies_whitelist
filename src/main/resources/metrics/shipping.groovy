package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {
    "packs"(description: "total packs and total free shipping packs from /purchase/purchasecreated", sum_by:["event_data.total_packs"]) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
            }
        }
    }

    "packs_with_discount"(description: "total packs and total free shipping packs from /purchase/purchasecreated", sum_by:["event_data.discount_packs"]) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
            }
        }
    }

    "packs_with_free_shipping"(description: "total packs and total free shipping packs from /purchase/purchasecreated", sum_by:["event_data.free_shipping_packs"]) {
        countsOn {
            condition {
                path("/purchases/purchasecreated")
            }
        }
    }
}
