package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

        "deal_banner"(description: "Search deal banner", acceptMultiVariantSession: true) {
                startWith {
                        condition {
                                path("/search")

                                and(
                                        notEquals("event_data.banner.deal_id", ""),
                                        notEquals("event_data.banner.exhibitors_id", "")
                                )
                        }

                        set_property("campaign_id", "event_data.banner.deal_id")
                        set_property("exhibitors_id", "event_data.banner.exhibitors_id")

                        openBy {
                                "event_data.banner.deal_id"(default: "-")
                        }
                }

                countsOn() {
                        condition {
                                path("/search")

                                and(
                                        equals("event_data.filters.deal", property("campaign_id")),
                                        equals("event_data.click_banner.exhibitors_id", property("exhibitors_id"))
                                )
                        }
                }
        }

        "deal_banner_shown"(description: "Search deal banner shown", acceptMultiVariantSession: true) {
                startWith {
                        condition {
                                path("/search")

                                and(
                                        notEquals("event_data.banner.deal_id", ""),
                                        notEquals("event_data.banner.exhibitors_id", "")
                                )
                        }

                        set_property("campaign_id", "event_data.banner.deal_id")
                        set_property("exhibitors_id", "event_data.banner.exhibitors_id")

                        openBy {
                                "event_data.banner.deal_id"(default: "-")
                        }
                }
        }

        "deal_banner_click"(description: "Search deal banner clicked", deprecation_date:"2020/04/20") {
                startWith {
                        experiment("deal_banner_shown")
                }

                countsOn() {
                        condition {
                                path("/search")

                                and(
                                        equals("event_data.filters.deal", property("campaign_id")),
                                        equals("event_data.click_banner.exhibitors_id", property("exhibitors_id"))
                                )
                        }
                }
        }

        "deal_banner_after_click"(description: "After click search deal banner", acceptMultiVariantSession: true) {
                startWith {
                        condition {
                                path("/search")

                                and(
                                        empty("event_data.filters.deal", false),
                                        empty("event_data.click_banner.exhibitors_id", false)
                                )
                        }

                        set_property("campaign_id", "event_data.filters.deal")

                        openBy {
                                "event_data.filters.deal"(default: "-")
                        }
                }
        }
}
