package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {
	"bookmarks"(description: "bookmarsk count", categorization:"important") {
		countsOn {
			condition {
				path("/bookmarks/post", "/bookmarks/action/post")
			}
		}
	}

	"checkout_congrats_with_garex"(description: "orders_with_garex", sum_by: ["event_data.total_amount_including_garex"]) {
		startWith {
			experiment("buyingflow/garex_mlm")
		}

		countsOn {
			condition {
				and(
						equals("event_data.congrats_seq",1),
						empty("event_data.total_amount_including_garex", false),
						equals("event_data.item_with_garex", true)
				)
			}
		}
	}
}
