import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType

metrics {

    "questions"(description: "questions count", tags:[TagType.Important, TagType.CoreMetric], bu: BuType.MercadoLibre, extent: ExtentType.Company) {
        countsOn {
            condition {
                path("/questions/ask/post")
                or (
                        equals("event_data.failed", false) ,
                        isNull("event_data.failed")
                )
            }
        }
    }

    "qadb_search"(description: "qadb zqps generated ", tags:[TagType.CoreMetric], bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex("qadb/.*"))
	    
        countsOn {
            condition {
                path("/questions/qadb/search")
            }
        }
    }	
	
   "qadb_zqp"(description: "qadb searches perform by user ", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex("qadb/.*"))
	    
        countsOn {
            condition {
                path("/questions/qadb/search")
       	        empty("event_data.results", true)
            }
        }
    }		

    "questions.pdp"(description: "Track PDP questions", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex("qadb/.*"))

		countsOn {
		condition {
			path("/questions/ask/post")
			and(
				or(
					equals("event_data.context", "/pdp"),
					equals("event_data.context", "/qadb/pdp"),
          				equals("event_data.context", "/qadb-auto/pdp"),
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

	"questions.sameItem"(description: "questions count over same item", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
		experiment(regex("qadb/.*"))

		countsOn {
			condition {
				path("/questions/ask/post")
				and(
					equals("event_data.item_id", property("item_id")),
					or (
						equals("event_data.failed", false) ,
						isNull("event_data.failed")
					)
				)
			}
		}
	}
}
