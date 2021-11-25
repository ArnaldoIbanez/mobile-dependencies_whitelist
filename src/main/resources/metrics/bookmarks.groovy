import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType


metrics {
    "bookmarks"(description: "bookmarks count", tags:[TagType.Important, TagType.CoreMetric]) {
        countsOn {
            condition {
                path("/bookmarks/post", "/bookmarks/action/post")
            }
        }
    }
}
