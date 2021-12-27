package metrics

import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType
import com.ml.melidata.metrics.TagType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

    "user_blocker.shield.error"(description: "user blocker error screen count", tags: [TagType.Important, TagType.CoreMetric], bu: BuType.ITTech, extent: ExtentType.Feature) {
        countsOn {
            condition {
                path("/user_blocker/shield/error")
            }
        }
    }
}
