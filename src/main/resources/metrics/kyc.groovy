package metrics

import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType
import com.ml.melidata.metrics.TagType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

    "kyc.error.timeout"(description: "timeout error screen count", tags: [TagType.Important, TagType.CoreMetric], bu: BuType.ITTech, extent: ExtentType.Feature) {
        countsOn {
            condition {
                path("/kyc/error/timeout")
            }
        }
    }

    "kyc.error.parsing"(description: "parsing error screen count", tags: [TagType.Important, TagType.CoreMetric], bu: BuType.ITTech, extent: ExtentType.Feature) {
        countsOn {
            condition {
                path("/kyc/error/parsing")
            }
        }
    }

    "kyc.error.service"(description: "service error screen count", tags: [TagType.Important, TagType.CoreMetric], bu: BuType.ITTech, extent: ExtentType.Feature) {
        countsOn {
            condition {
                path("/kyc/error/service")
            }
        }
    }
}
