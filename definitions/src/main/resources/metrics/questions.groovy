import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

    "questions"(description: "questions count") {
        countsOn {
            condition {
                path("/questions/ask/post")
            }
        }
    }


    "questions.pdp"(description: "Track PDP questions") {
      	countsOn {
		condition {
			path("/questions/ask/post")
			and(
				or(
					equals("event_data.context", "/pdp"),
					equals("event_data.context", "/qadb/pdp"),
					and(
						equals("event_data.context", "/qadb"),
						empty("event_data.catalog_product_id", false)
						)
				),
				or (
					equals("event_data.failed", false) ,
					isNull("event_data.failed" )
				)
			)
		}
	}
    }

	"questions.sameItem"(description: "questions count over same item") {
		countsOn {
			condition {
				path("/questions/ask/post")
				equals("event_data.item_id", property("item_id"))
			}
		}
	}
}
