import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {
    "bookmarks"(description: "bookmarks count", categorization:"important") {
        countsOn {
            condition {
                path("/bookmarks/post", "/bookmarks/action/post")
            }
        }
    }
}
