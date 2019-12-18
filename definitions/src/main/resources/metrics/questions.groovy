import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "questions"(description: "questions count") {
        countsOn {
            condition {
                path("/questions/ask/post")
            }
        }
    }

    "pdp_questions_qadb"(description: "Track PDP questions of users in QADB experiment") {
        startWith {
            experiment("qadb/qadb-on")
        }

        countsOn {
            condition {
                path("/questions/ask/post")
                and(
                        or(
                                equals("event_data.context", "/pdp"),
                                equals("event_data.context", "/qadb"),
                                equals("event_data.context", "/questions/qadb")
                        )
                )
            }
        }
    }

    "pdp_questions"(description: "Track PDP questions") {
        countsOn {
            condition {
                path("/questions/ask/post")
                and(
                        or(
                                equals("event_data.context", "/pdp"),
                                equals("event_data.context", "/qadb"),
                                equals("event_data.context", "/questions/qadb")
                        )
                )
            }
        }
    }



}
