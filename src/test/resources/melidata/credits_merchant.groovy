package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("merchant credits ml y mp") {
    }

    test('Merchant Public Landing') {
        // MercadoPago Business
        "/credits/merchant/public_landing"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            offers = ['fixed_term_loan', 'sales_percentage_loan', 'express_money']
        }
        "/credits/merchant/public_landing"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            offers = []
        }
        "/credits/merchant/public_landing/ftl_offer"(platform: "/", type: TrackType.Event, business:"mercadopago") {}
        "/credits/merchant/public_landing/spl_offer"(platform: "/", type: TrackType.Event, business:"mercadopago") {}
        "/credits/merchant/public_landing/em_offer"(platform: "/", type: TrackType.Event, business:"mercadopago") {}
        "/credits/merchant/public_landing/new_account"(platform: "/", type: TrackType.Event, business:"mercadopago") {}
        "/credits/merchant/public_landing/credits_access"(platform: "/", type: TrackType.Event, business:"mercadopago") {}

        // MercadoLibre business
        "/credits/merchant/public_landing"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            offers = ['fixed_term_loan', 'sales_percentage_loan', 'express_money']
        }
        "/credits/merchant/public_landing"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            offers = []
        }
        "/credits/merchant/public_landing/ftl_offer"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/merchant/public_landing/spl_offer"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/merchant/public_landing/em_offer"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/merchant/public_landing/new_account"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/merchant/public_landing/credits_access"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
    }

    // Credits Marketing Performance landing
    test("Credits Marketing landings") {
        // MercadoPago Business
        "/credits/mkt_landing"(platform: "/web", type: TrackType.View, business:"mercadopago"){
            campaign = "generic"
        }
        "/credits/mkt_landing/sms"(platform: "/web", type: TrackType.Event, business:"mercadopago"){
            campaign = "generic"
        } 
        "/credits/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event, business:"mercadopago"){
            campaign = "generic"
            position = "coupon"
        } 
        "/credits/mkt_landing/button"(platform: "/web", type: TrackType.Event, business:"mercadopago"){
            campaign = "generic"
            position = "hero"
        } 
        "/credits/mkt_landing/button"(platform: "/web", type: TrackType.Event, business:"mercadopago"){
            campaign = "generic"
            position = "fixed"
        } 

        // MercadoLibre business
        "/credits/mkt_landing"(platform: "/web", type: TrackType.View, business:"mercadolibre"){
            campaign = "proof-landing"
        }
        "/credits/mkt_landing/sms"(platform: "/web", type: TrackType.Event, business:"mercadolibre"){
            campaign = "generic"
        } 
        "/credits/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event, business:"mercadolibre"){
            campaign = "generic"
            position = "steps"
        } 
        "/credits/mkt_landing/button"(platform: "/web", type: TrackType.Event, business:"mercadolibre"){
            campaign = "generic"
            position = "footer"
        }
    }

    test('Credits Optins FrontEnd') {
        // MercadoPago Business
        "/credits/preferences"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            initiative = 'merchant_enrollment'
            step = 'whatsapp'
        }
        "/credits/preferences"(platform: "/", type: TrackType.View, business:"mercadopago") {
            initiative = 'credit_card_open_sea'
            step = 'whatsapp'
        }
        "/credits/preferences/error"(platform: "/web/mobile", type: TrackType.View, business:"mercadopago") {
            initiative = 'merchant_enrollment'
        }
        "/credits/preferences/accept"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            initiative = 'merchant_open_market'
            step = 'whatsapp_sms'
        }
        "/credits/preferences/decline"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            initiative = 'merchant_administrator'
            step = 'sms'
        }
        "/credits/preferences"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            initiative = 'consumer_open_sea_tx'
            step = 'telcel'
        }
        "/credits/preferences/decline"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            initiative = 'consumer_personal_loan_second_stage'
            step = 'telcel_credit_circle'
        }

        // MercadoLibre business
        "/credits/preferences"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            initiative = 'consumer_open_sea'
            step = 'telcel'
        }
        "/credits/preferences/error"(platform: "/web/mobile", type: TrackType.View, business:"mercadolibre") {
            initiative = 'merchant_enrollment'
        }
        "/credits/preferences/accept"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {
            initiative = 'consumer_administrator'
            step = 'credit_circle'
        }
        "/credits/preferences/decline"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {
            initiative = 'consumer_personal_loan'
            step = 'telcel_credit_circle'
        }
        "/credits/preferences"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            initiative = 'consumer_open_sea_tx'
            step = 'telcel'
        }
        "/credits/preferences/decline"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {
            initiative = 'consumer_personal_loan_second_stage'
            step = 'telcel_credit_circle'
        }
    }

}
