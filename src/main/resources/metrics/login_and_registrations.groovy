import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType


metrics {
    "logins"(description: "logins count", tags:[TagType.CoreMetric]) {
        experiment(regex("login/.*"))

        countsOn {
            condition {
                path("/login/auth/success")
            }
        }
    }

    "registrations"(description: "registrations count", tags:[TagType.Important]) {
        countsOn {
            condition {
                path("/register/success")
            }
        }
    }

}
