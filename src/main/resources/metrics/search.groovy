import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "search.applied_filters"(description: "Applied filters") {
        startWith {
            experiment(regex("(search|filters)/.*"))
        }

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.*applied_filter_id.*')
            }
        }
    }

    "search.enhanced_search_filters_applied"(description: "Enhanced Search filters applied") {
        startWith {
            experiment(regex("(search|filters)/.*"))
        }

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.*enhanced_position.*')
            }
        }
    }
}
