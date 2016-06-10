import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

        "deal_banner"(description: "Search deal banner", acceptMultiVariantSession: true) {
                startWith {
                        condition {
                                path("/search")

                                and(
                                        notEquals("event_data.banners.deal_id", ""),
                                        notEquals("event_data.banners.exhibitors_id", "")
                                )
                        }

                        set_property("deal_id", "event_data.banners.deal_id")
                        set_property("exhibitors_id", "event_data.banners.exhibitors_id")

                        openBy {
                                "event_data.banners.deal_id"(default: "-")
                        }
                }

                countsOn() {
                        condition {
                                path("/search")

                                and(
                                        equals("event_data.filters.deal", property("deal_id")),
                                        equals("event_data.click_banner.exhibitors_id", property("exhibitors_id"))
                                )
                        }
                }
        }
}
