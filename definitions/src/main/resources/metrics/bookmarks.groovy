import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {
    "bookmarks"(description: "bookmarsk count") {
        countsOn {
            condition {
                path("/bookmarks/post", "/bookmarks/action/post")
            }
        }
    }




}
