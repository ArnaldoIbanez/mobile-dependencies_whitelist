package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def loyaltyExperimentsRegex = '(loyalty|wallet)/.*'

metrics {

    "loyalty.subscription.congrats"(description: "define what type of distribution of components to show in Summary suscriptions to see which one converts better", deprecation_date: "2021/06/20") {
        experiment("loyalty/subscription_summary")

        countsOn {
            condition {
                path("/loyalty/partners/checkout/congrats")
            }
        }
    }

    "loyalty.suscription.disneyplus.intention"(description: "define what type of plan to show in VPD to see which one converts better", deprecation_date: "2021/01/30") {
        experiment("loyalty/subscription_disneyplus")

        countsOn {
            condition {
                path("/loyalty/partners/vdp/action")
                equals("event_data.subscription_partner", "disneyplus")
            }
        }
    }

    "loyalty.suscription.disneyplus"(description: "Finally makes a suscription to disneyplus", deprecation_date: "2021/01/30") {
        experiment("loyalty/subscription_disneyplus")

        countsOn {
            condition {
                path("/loyalty/partners/checkout/congrats")
                equals("event_data.subscription_partner", "disneyplus")
            }
        }
    }

      "loyalty.suscription.deezer.intention"(description: "define what type of distribution of components to show in VPD to see which one converts better", deprecation_date: "2021/06/14") {
        experiment("loyalty/subscription_deezer")

        countsOn {
            condition {
                path("/loyalty/partners/vdp/action")
                equals("event_data.subscription_partner", "deezer")
            }
        }
    }

    "loyalty.suscription.deezer"(description: "Finally makes a suscription to deezer", deprecation_date: "2021/06/14") {
        experiment("loyalty/subscription_deezer")

        countsOn {
            condition {
                path("/loyalty/partners/checkout/congrats")
                equals("event_data.subscription_partner", "deezer")
            }
        }
    }

    // Loyalty HUB

    "loyalty.hub.mp"(description: "Loyalty Hub View in MP") {
        experiment(regex(loyaltyExperimentsRegex))

        countsOn {
            condition {
                path("/loyalty/hub")
                and(
                        equals("application.business", "mercadopago")
                )
            }
        }
    }

    //Subscriptions

    "loyalty.subscriptions.mp"(description: "Partner VDP View in MP") {
        experiment(regex(loyaltyExperimentsRegex))

        countsOn {
            condition {
                path("/loyalty/partners/vdp")
                and(
                        equals("application.business", "mercadopago")
                )
            }
        }
    }

    "loyalty.subscriptions.congrats.mp"(description: "Partner Congrats View in MP") {
        experiment(regex(loyaltyExperimentsRegex))

        countsOn {
            condition {
                path("/loyalty/partners/congrats")
                and(
                        equals("application.business", "mercadopago")
                )
            }
        }
    }

    "loyalty.subscription.level6"(description: "User who subscribed to level 6") {
        countsOn {
            condition {
                path("/loyalty/buylevel/congrats")
                and(
                        equals("event_data.payment_status", "approve"),
                        or(
                                equals("event_data.payment_status", "pending"),
                                equals("event_data.payment_status", "in_process")
                        )
                )
            }
        }
    }

}
