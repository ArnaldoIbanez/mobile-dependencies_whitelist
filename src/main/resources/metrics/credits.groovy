import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def experimentsRegex = "(wallet|credits)/.*"

metrics {

    "credits-open-sea_vip.vip_conversion"(description: "vip total conversion under credits open sea experiment", deprecation_date:"2020/08/12") {
        experiment("credits/openSeaVIPIntegration")

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
        experiment("credits/openSeaVIPIntegration")

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
        experiment("credits/openSeaVIPIntegration")

        countsOn {
            condition{
                equals("event_data.congrats_seq",1)
            }
        }
    }

    "credits-open-sea_vip.checkout_conversion_with_credits"(description: "checkout conversion, using credits as payment method, under credits opensea experiment in vip", deprecation_date:"2020/08/12") {
        experiment("credits/openSeaVIPIntegration")

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
        experiment("credits/openSeaRemedy")

        countsOn {
            condition {
                equals("path", "/credits/consumer/public_landing/application_result")
            }
        }
    }

    "installment_merchant_debit_payment_fifteen"(description: "Send email from automatic debit installment for fifteen overdue credits merchant", deprecation_date:"2020/08/12") {
        experiment("credits/merchant_whatsapp_fifteen_overdue")

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
        experiment("credits/simulator")

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
        experiment("credits/simulator_point")

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
        experiment("credits/merchant_whatsapp_five_overdue")

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
        experiment("credits/credits_short_onboarding", "credits/credits_default_selected_loans", "wallet/merch_cross_sell_sort_hide_strategies")

        countsOn {
            condition {
                path("/credits/consumer/personal/adoption/congrats")
            }
        }
    }

    "credits_consumer.personal_loan_access_order"(description: "Credits conversion under personal loans access order in admin flow", deprecation_date:"2020/12/31") {
        experiment("credits/credits_consumer_admin_pl_access_order")

        countsOn {
            condition {
                path("/credits/consumer/personal/adoption/congrats")
            }
        }
    }

    "credits_selfservice.payment_promise_with_intermediate_step"(description: "New track to show the users the widget within all the payment promise information", deprecation_date:"2021/4/30") {
        experiment("credits/payment_promise_with_intermediate_step")

        countsOn {
            condition {
                path("/credits/self_service/promises/congrats")
            }
        }
    }

    "credits_merchant_enrollment_entries"(description: "Credits merchant entries under enrollmment flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment", "/credits/merchant/enrollment/onboarding", "/credits/merchant/enrollment/hub", "/credits/merchant/enrollment/simulator") 
            } 
        }
    }

    "credits_merchant_enrollment_entries.hub"(description: "Credits merchant hub entries under enrollmment flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment/hub")
            } 
        }
    }
    
    "credits_merchant_enrollment_entries.ftl"(description: "Credits merchant entries under enrollmment flow with fixed term loan") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment", "/credits/merchant/enrollment/onboarding", "/credits/merchant/enrollment/hub", "/credits/merchant/enrollment/simulator")
                like("event_data.product_types", ".*fixed_term_loan.*")
            } 
        }
    }

    "credits_merchant_enrollment_entries.spl"(description: "Credits merchant entries under enrollmment flow with sales percentage loan") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment", "/credits/merchant/enrollment/onboarding", "/credits/merchant/enrollment/hub", "/credits/merchant/enrollment/simulator")
                like("event_data.product_types", ".*sales_percentage_loan.*")
            } 
        }
    }

    "credits_merchant_enrollment_conversions"(description: "Credits merchant conversions under enrollmment flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment/congrats")
            } 
        }
    }

    "credits_merchant_enrollment_conversions.ftl"(description: "Credits merchant fixed term loan conversions under enrollmment flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment/congrats")
                equals("event_data.product_type", "fixed_term_loan")
            } 
        }
    }

    "credits_merchant_enrollment_conversions.spl"(description: "Credits merchant sales percentage loan conversions under enrollmment flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment/congrats")
                equals("event_data.product_type", "sales_percentage_loan")
            } 
        }
    }
    

    "credits_merchant_express_money_entries"(description: "Credits merchant entries under express money flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/express_money/amount_input", "/credits/express_money/onboarding")
            } 
        }
    }

    "credits_merchant_express_money_entries.with_onboarding"(description: "Credits merchant entries under express money flow with onboarding") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/express_money/onboarding")
            } 
        }
    }

    "credits_merchant_express_money_conversions"(description: "Credits merchant conversions under express money flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/express_money/congrats")
            } 
        }
    }

    "credits_merchant_open_market_entries"(description: "Credits merchant entries under open market flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market")
            } 
        }
    }

    "credits_merchant_open_market_entries.upsell_offer"(description: "Credits merchant entries under open market upsell offer flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market")
                equals("event_data.flow", "upsell_offer")
            } 
        }
    }

    "credits_merchant_open_market_entries.request_offer"(description: "Credits merchant entries under open market request offer flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market")
                equals("event_data.flow", "request_offer")
            } 
        }
    }

    "credits_merchant_open_market_conversions"(description: "Credits merchant financial files conversions under open market flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market/congrats")
            } 
        }
    }

    "credits_merchant_open_market_conversions.upsell_offer_financial_files"(description: "Credits merchant financial files conversions under open market upsell offer flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market/congrats")
                and (
                    equals("event_data.flow", "upsell_offer"),
                    like("event_data.reason", ".*financial_files.*")
                )
            } 
        }
    }

    "credits_merchant_open_market_conversions.upsell_offer_financial_scraping"(description: "Credits merchant financial scraping conversions under open market upsell offer flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market/congrats")
                and (
                    equals("event_data.flow", "upsell_offer"),
                    like("event_data.reason", ".*financial_scraping.*")
                )
            } 
        }
    }

    "credits_merchant_open_market_conversions.request_offer_financial_files"(description: "Credits merchant financial files conversions under open market request offer flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market/congrats")
                and (
                    equals("event_data.flow", "request_offer"),
                    like("event_data.reason", ".*financial_files.*")
                )        
            } 
        }
    }

    "credits_merchant_open_market_conversions.request_offer_financial_scraping"(description: "Credits merchant financial scraping conversions under open market request offer flow") {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market/congrats")
                and (
                    equals("event_data.flow", "request_offer"),
                    like("event_data.reason", ".*financial_scraping.*")
                )        
            } 
        }
    }
}