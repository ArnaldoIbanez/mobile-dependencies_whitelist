import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "asset_management_congrats"(description: "Arrival to congrats for Asset Management", deprecation_date:"2020/08/12") {
        startWith {
            experiment("mpmobile/asset_management")
        }

        countsOn {
            condition {
                path("/asset_management/result_investing")
            }
        }
    }

    "asset_management_start_investing"(description: "Touches the button 'Quiero invertir' from onboarding", deprecation_date:"2020/08/12") {
        startWith {
            experiment("mpmobile/asset_management")
        }

        countsOn {
            condition {
                path("/asset_management/start_investing")
            }
        }
    }
}
