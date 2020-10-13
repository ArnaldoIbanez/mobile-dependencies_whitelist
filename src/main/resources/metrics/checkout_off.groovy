import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "checkout_off_congrats"(description: "Arrival to congrats page from Checkout Off") {
        startWith {
            experiment(regex("checkout_off/.*"))
        }

        countsOn {
            condition {
                path("/checkout_off/congrats")
            }
        }
    }

    "checkout_off_congrats_success"(description: "Arrival to congrats success page from Checkout Off") {
        startWith {
            experiment(regex("checkout_off/.*"))
        }

        countsOn {
            condition {
                path("/checkout_off/congrats")
                equals("event_data.payment_status","approved")
            }
        }
    }

}
