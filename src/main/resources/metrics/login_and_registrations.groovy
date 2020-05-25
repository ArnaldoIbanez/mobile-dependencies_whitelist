import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {
    "logins"(description: "logins count") {
        startWith {
            experiment(regex("login/.*"))
        }
        countsOn {
            condition {
                path("/login/auth/success")
            }
        }
    }

    "registrations"(description: "registrations count", categorization:"important") {
        countsOn {
            condition {
                path("/register/success")
            }
        }
    }

}
