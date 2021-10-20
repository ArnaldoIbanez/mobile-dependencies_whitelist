import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType


metrics {

    "relist_upgrade"(description: "An Item was relisted in a higher listing type than its parent", deprecation_date:"2020/08/12") {
        startWith {
            experiment("sell/full_relist_single_item")
        }

        countsOn {
            condition {
                path("/item/relist")
                and(
                        equals("event_data.change_listing_type", "upgrade"),
                        equals("event_data.item_id", property("item_id"))
                )
            }
        }
    }

    "relist_downgrade"(description: "An Item was relisted in a lower listing type than its parent", deprecation_date:"2020/08/12") {
        startWith {
            experiment("sell/full_relist_single_item")
        }

        countsOn {
            condition {
                path("/item/relist")
                and(
                        equals("event_data.change_listing_type", "downgrade"),
                        equals("event_data.item_id", property("item_id"))
                )
            }
        }
    }

    "upgrade_listing"(description: "upgrade listing success for sell experiments", deprecation_date:"2020/08/12") {
        startWith {
            experiment("sell/congrats_upgrade_listing_type")
        }

        countsOn {
            condition {
                path("/sell/upgrade/listing_types")
            }
        }
    }

    "seller_central/goal_achieved"(description: "Goal achieved", deprecation_date:"2020/08/12") {
        startWith {
            experiment("sell/health-goals_order")
        }

        countsOn {
            condition {
                path("/seller_central/modify/success")
                and(
                        empty("event_data.goals_achieved", false)
                )
            }
        }
    }

    "publish_congrats"(description: "Selling flow new item published - Does not track congrats view", tags:[TagType.Important]) {
        startWith {
            experiment(regex("sell/.*"))
        }

        countsOn {
            condition {
                path("/item/create")
            }
        }
    }

    "sell_upgrade_intention"(description: "Intention for upgrading - Selling flow") {
        startWith {
            experiment(regex("sell/.*"))
        }

        countsOn {
            condition {
                path("/sell/change_listing_type/upgrade_intention")
            }
        }
    }

    "sell_list_congrats"(description: "Arrival to congrats page - Selling flow", tags:[TagType.Important, TagType.CoreMetric]) {
        startWith {
            experiment(regex("sell/.*|vis/.*|pdp/postContactSYIRedirect|sparkle/vis/.*"))
        }

        countsOn {
            condition {
                path("/sell/list/congrats")
            }
        }
    }

}
