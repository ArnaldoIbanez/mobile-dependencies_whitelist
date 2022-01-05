import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def experimentsRegex = "(wallet|credits)/.*"

metrics {
    "credits_merchant_enrollment_entries"(description: "Credits merchant entries under enrollmment flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment", "/credits/merchant/enrollment/onboarding", "/credits/merchant/enrollment/hub", "/credits/merchant/enrollment/simulator") 
            } 
        }
    }

    "credits_merchant_enrollment_entries.hub"(description: "Credits merchant hub entries under enrollmment flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment/hub")
            } 
        }
    }
    
    "credits_merchant_enrollment_entries.ftl"(description: "Credits merchant entries under enrollmment flow with fixed term loan", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment", "/credits/merchant/enrollment/onboarding", "/credits/merchant/enrollment/hub", "/credits/merchant/enrollment/simulator")
                like("event_data.product_types", ".*fixed_term_loan.*")
            } 
        }
    }

    "credits_merchant_enrollment_entries.spl"(description: "Credits merchant entries under enrollmment flow with sales percentage loan", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment", "/credits/merchant/enrollment/onboarding", "/credits/merchant/enrollment/hub", "/credits/merchant/enrollment/simulator")
                like("event_data.product_types", ".*sales_percentage_loan.*")
            } 
        }
    }

    "credits_merchant_enrollment_conversions"(description: "Credits merchant conversions under enrollmment flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment/congrats")
            } 
        }
    }

    "credits_merchant_enrollment_conversions.ftl"(description: "Credits merchant fixed term loan conversions under enrollmment flow", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment/congrats")
                equals("event_data.product_type", "fixed_term_loan")
            } 
        }
    }

    "credits_merchant_enrollment_conversions.spl"(description: "Credits merchant sales percentage loan conversions under enrollmment flow", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/enrollment/congrats")
                equals("event_data.product_type", "sales_percentage_loan")
            } 
        }
    }
    

    "credits_merchant_express_money_entries"(description: "Credits merchant entries under express money flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/express_money/amount_input", "/credits/express_money/onboarding")
            } 
        }
    }

    "credits_merchant_express_money_entries.with_onboarding"(description: "Credits merchant entries under express money flow with onboarding", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/express_money/onboarding")
            } 
        }
    }

    "credits_merchant_express_money_conversions"(description: "Credits merchant conversions under express money flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/express_money/congrats")
            } 
        }
    }

    "credits_merchant_open_market_entries"(description: "Credits merchant entries under open market flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market")
            } 
        }
    }

    "credits_merchant_open_market_entries.upsell_offer"(description: "Credits merchant entries under open market upsell offer flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market")
                equals("event_data.flow", "upsell_offer")
            } 
        }
    }

    "credits_merchant_open_market_entries.request_offer"(description: "Credits merchant entries under open market request offer flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market")
                equals("event_data.flow", "request_offer")
            } 
        }
    }

    "credits_merchant_open_market_conversions"(description: "Credits merchant financial files conversions under open market flow", bu: BuType.MercadoLibre, extent: ExtentType.Product) {
        experiment(regex(experimentsRegex))

        countsOn { 
            condition { 
                path("/credits/merchant/open_market/congrats")
            } 
        }
    }

    "credits_merchant_open_market_conversions.upsell_offer_financial_files"(description: "Credits merchant financial files conversions under open market upsell offer flow", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
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

    "credits_merchant_open_market_conversions.upsell_offer_financial_scraping"(description: "Credits merchant financial scraping conversions under open market upsell offer flow", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
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

    "credits_merchant_open_market_conversions.request_offer_financial_files"(description: "Credits merchant financial files conversions under open market request offer flow", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
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

    "credits_merchant_open_market_conversions.request_offer_financial_scraping"(description: "Credits merchant financial scraping conversions under open market request offer flow", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
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