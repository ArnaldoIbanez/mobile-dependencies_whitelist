import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "email.open"(description: "path: /email/orders and event_type: open") {
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
