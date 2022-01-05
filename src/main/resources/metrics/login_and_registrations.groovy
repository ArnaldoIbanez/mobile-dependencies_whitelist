import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType


metrics {
    "logins"(description: "logins count", tags:[TagType.CoreMetric], bu: BuType.MercadoLibre, extent: ExtentType.Company) {
        experiment(regex("login/.*"))

        countsOn {
            condition {
                path("/login/auth/success")
            }
        }
    }

    "registrations"(description: "registrations count", tags:[TagType.Important], bu: BuType.MercadoLibre, extent: ExtentType.Company) {
        countsOn {
            condition {
                path("/register/success")
            }
        }
    }

}
