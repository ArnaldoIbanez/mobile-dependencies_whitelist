package metrics

import com.ml.melidata.metrics.TagType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

    "user_blocker.shield.error"(description: "user blocker error screen count", tags: [TagType.Important, TagType.CoreMetric]) {
        countsOn {
            condition {
                path("/user_blocker/shield/error")
            }
        }
    }
}
