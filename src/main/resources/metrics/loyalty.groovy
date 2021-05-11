package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

    "loyalty.suscription.disneyplus.intention"(description: "define what type of plan to show in VPD to see which one converts better", deprecation_date: "2021/01/30") {
        startWith {
            experiment("loyalty/subscription_disneyplus")
        }

        countsOn {
            condition {
                path("/loyalty/partners/vdp/action")
                equals("event_data.subscription_partner", "disneyplus")
            }
        }
    }

    "loyalty.suscription.disneyplus"(description: "Finally makes a suscription to disneyplus", deprecation_date: "2021/01/30") {
        startWith {
            experiment("loyalty/subscription_disneyplus")
        }

        countsOn {
            condition {
                path("/loyalty/partners/checkout/congrats")
                equals("event_data.subscription_partner", "disneyplus")
            }
        }
    }

    // Loyalty HUB

    "loyalty.hub"(description: "Loyalty Hub View") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/hub")
            }
        }
    }

    "loyalty.hub.mp"(description: "Loyalty Hub View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

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
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/vdp")
                and(
                        equals("application.business", "mercadopago")
                )
            }
        }
    }

    "loyalty.subscriptions.mp.disney"(description: "Partner (Disney) VDP View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/vdp")
                and(
                        equals("application.business", "mercadopago"),
                        equals("event_data.subscription_partner", "disneyplus")
                )
            }
        }
    }

    "loyalty.subscriptions.mp.deezer"(description: "Partner (Deezer) VDP View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/vdp")
                and(
                        equals("application.business", "mercadopago"),
                        equals("event_data.subscription_partner", "deezer")
                )
            }
        }
    }

    "loyalty.subscriptions.mp.hbo"(description: "Partner (HBO) VDP View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/vdp")
                and(
                        equals("application.business", "mercadopago"),
                        equals("event_data.subscription_partner", "hbo")
                )
            }
        }
    }

    "loyalty.subscriptions.mp.paramount"(description: "Partner (Paramount) VDP View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/vdp")
                and(
                        equals("application.business", "mercadopago"),
                        equals("event_data.subscription_partner", "paramount")
                )
            }
        }
    }

    "loyalty.subscriptions.congrats.mp"(description: "Partner Congrats View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/congrats")
                and(
                        equals("application.business", "mercadopago")
                )
            }
        }
    }

    "loyalty.subscriptions,congrats.mp.disney"(description: "Partner (Disney) Congrats View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/congrats")
                and(
                        equals("application.business", "mercadopago"),
                        equals("event_data.subscription_partner", "disneyplus")
                )
            }
        }
    }

    "loyalty.subscriptions.congrats.mp.deezer"(description: "Partner (Deezer) Congrats View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/congrats")
                and(
                        equals("application.business", "mercadopago"),
                        equals("event_data.subscription_partner", "deezer")
                )
            }
        }
    }

    "loyalty.subscriptions.congrats.mp.hbo"(description: "Partner (HBO) Congrats View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/congrats")
                and(
                        equals("application.business", "mercadopago"),
                        equals("event_data.subscription_partner", "hbo")
                )
            }
        }
    }

    "loyalty.subscriptions.congrats.mp.paramount"(description: "Partner (Paramount) Congrats View in MP") {
        startWith {
            experiment(regex("wallet/.*"))
        }

        countsOn {
            condition {
                path("/loyalty/partners/congrats")
                and(
                        equals("application.business", "mercadopago"),
                        equals("event_data.subscription_partner", "paramount")
                )
            }
        }
    }

}
