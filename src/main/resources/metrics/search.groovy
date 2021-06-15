import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "applied_filters"(description: "Applied filters") {
        startWith {
            experiment(regex(".*filters.*"))
        }

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.*applied_filter_id.*')
            }
        }
    }
}
