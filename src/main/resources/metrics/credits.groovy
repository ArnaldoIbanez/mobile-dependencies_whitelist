import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


metrics {

    "credits-open-sea_vip.vip_conversion"(description: "vip total conversion under credits open sea experiment", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/openSeaVIPIntegration")
        }
        countsOn {
            condition {
                or(
                        and(
                                equals("path", "/buy_intention"),
                                equals("event_data.context", "vip")
                        ),
                        and(
                                equals("path", "/credits/consumer/opensea/integrated_flow/start"),
                                equals("event_data.source", "vip")
                        )
                )
            }
        }
    }

    "credits-open-sea_vip.credits_conversion"(description: "credits open sea conversion from experiment in vip", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/openSeaVIPIntegration")
        }
        countsOn {
            condition {
                and(
                        equals("path", "/credits/consumer/opensea/integrated_flow/start"),
                        equals("event_data.source", "vip")
                )
            }
        }
    }

    "credits-open-sea_vip.checkout_conversion"(description: "checkout conversion under credits opensea experiment in vip", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/openSeaVIPIntegration")
        }
        countsOn {
            condition{
                equals("event_data.congrats_seq",1)
            }
        }
    }

    "credits-open-sea_vip.checkout_conversion_with_credits"(description: "checkout conversion, using credits as payment method, under credits opensea experiment in vip", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/openSeaVIPIntegration")
        }
        countsOn {
            condition{
                and(
                        equals("event_data.congrats_seq",1),
                        equals("event_data.payments.payment_method", "consumer_credits")
                )
            }
        }
    }

    "credits-open-sea.remedies_conversion"(description: "credits conversion under remedies experiment", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/openSeaRemedy")
        }
        countsOn {
            condition {
                equals("path", "/credits/consumer/public_landing/application_result")
            }
        }
    }

    "installment_merchant_debit_payment_fifteen"(description: "Send email from automatic debit installment for fifteen overdue credits merchant", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/merchant_whatsapp_fifteen_overdue")
        }

        countsOn {
            condition {
                path("/email/generic")
                and(
                    equals("event_data.event_type", "send"),
                    equals("event_data.email_template", "CM_AUTOCOLLECT")
                )
            }
        }
    }



    "credits_merchant_enrollment_standard_simulator_redesign"(description: "Credits Merchant enrollment new design A/B testing for standard users", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/simulator")
        }

        countsOn {
            condition {
                path("/credits/merchant/enrollment/congrats")
                or (
                    path("/credits/merchant/enrollment/documentation/congrats")
                )
            }
        }
    }

    "credits_merchant_enrollment_point_simulator_redesign"(description: "Credits Merchant enrollment new design A/B testing for point users", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/simulator_point")
        }

        countsOn {
            condition {
                path("/credits/merchant/enrollment/congrats")
                or (
                    path("/credits/merchant/enrollment/documentation/congrats")
                )
            }
        }
    }


    "installment_merchant_debit_payment_five"(description: "Send email from automatic debit installment for five overdue credits merchant", deprecation_date:"2020/08/12") {
        startWith {
            experiment("credits/merchant_whatsapp_five_overdue")
        }

        countsOn {
            condition {
                path("/email/generic")
                and(
                    equals("event_data.event_type", "send"),
                    equals("event_data.email_template", "CM_AUTOCOLLECT")
                )
            }
        }
    }

    "credits_consumer.personal_loan_conversion"(description: "Credits conversion under adoption personal loans flow") {
        startWith {
            experiment("credits/credits_short_onboarding", "credits/credits_default_selected_loans", "wallet/merch_cross_sell_sort_hide_strategies")
        }
        countsOn {
            condition {
                path("/credits/consumer/personal/adoption/congrats")
            }
        }
    }

    "credits_consumer.personal_loan_access_order"(description: "Credits conversion under personal loans access order in admin flow", deprecation_date:"2020/12/31") {
        startWith {
            experiment("credits/credits_consumer_admin_pl_access_order")
        }
        countsOn {
            condition {
                path("/credits/consumer/personal/adoption/congrats")
            }
        }
    }
}
