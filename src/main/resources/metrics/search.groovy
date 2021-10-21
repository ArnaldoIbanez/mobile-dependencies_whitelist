import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "search.applied_filters"(description: "Applied filters") {
        experiment(regex("(search|filters)/.*"))

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.\\bapplied_filter_id.*')
            }
        }
    }

    "search.unapplied_filters"(description: "Unapplied filters") {
        experiment(regex("(search|filters)/.*"))

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.unapplied_filter_id.*')
            }
        }
    }

    "search.enhanced_search_filters_applied"(description: "Enhanced Search filters applied") {
        experiment(regex("(search|filters)/.*"))

        countsOn {
            condition {
                path("/search")
                like('platform.fragment', '.*enhanced_position.*')
            }
        }
    }
}
