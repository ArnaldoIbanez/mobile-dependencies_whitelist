package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("consumer credits ml y mp") {
        /***********************************************
         *       Start: Consumers Integrated Flow
         ***********************************************/
        //Integrated Flow - Start

        //Page view
        "/credits/consumer/opensea/integrated_flow/start"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            source = 'vip'
        }
        "/credits/consumer/opensea/integrated_flow/start"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            source = 'off'
        }
        "/credits/consumer/opensea/integrated_flow/credit_line_status"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            result = 'approved'
            source = 'off'
        }
        "/credits/consumer/opensea/integrated_flow/credit_line_status"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            result = 'approved'
            source = 'cho'
        }

        //Events
        "/credits/consumer/opensea/integrated_flow/start/application_start"(platform: "/web/mobile", type: TrackType.Event, business:"mercadolibre") {
            source = 'cho'
        }
        "/credits/consumer/opensea/integrated_flow/start/application_start"(platform: "/web/mobile", type: TrackType.Event, business:"mercadopago") {
            source = 'off'
        }
         "/credits/consumer/opensea/integrated_flow/start/application_cancel"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {
            source = 'off'
        }
        "/credits/consumer/opensea/integrated_flow/start/application_cancel"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            source = 'off'
        }

        //Integrated Flow - Congrats

        //Page view
        "/credits/consumer/opensea/integrated_flow/congrats"(platform: "/web/mobile", type: TrackType.View, business:"mercadolibre") {
            result = 'manual_review'
            source = 'cho'
        }
        "/credits/consumer/opensea/integrated_flow/congrats"(platform: "/web/mobile", type: TrackType.View, business:"mercadopago") {
            result = 'approved'
            source = 'off'
        }

        //Events
        "/credits/consumer/opensea/integrated_flow/congrats/buy_intention"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {
            result = 'manual_review'
            source = 'vip'
        }
        "/credits/consumer/opensea/integrated_flow/congrats/buy_intention"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            result = 'manual_review'
            source = 'off'
        }
        "/credits/consumer/opensea/integrated_flow/congrats/back_to_publication"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {
            result = 'manual_review'
            source = 'cho'
        }
        "/credits/consumer/opensea/integrated_flow/congrats/back_to_publication"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            result = 'manual_review'
            source = 'off'
        }
        "/credits/consumer/opensea/integrated_flow/congrats/back_to_site"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {
            result = 'approved'
            source = 'vip'
        }
        "/credits/consumer/opensea/integrated_flow/congrats/back_to_site"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            result = 'approved'
            source = 'off'
        }

        /*********************************************
         *       End: Consumers Integrated Flow
         *********************************************/

        /******************************************
         *    Start: Consumers Opensea Integrations
         ******************************************/

        "/credits/consumer/opensea/redirect"(platform: "/mobile", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/opensea/redirect"(platform: "/mobile", type: TrackType.View, business:"mercadopago") {}
        "/credits/consumer/opensea/integrated_flow/vip"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/consumer/opensea/integrated_flow/vip"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {}

        /******************************************
         *   End: Consumers  Opensea Integrations
         ******************************************/

         /******************************************
         *    Start: Consumers Opensea Flow
         ******************************************/

        "/credits/consumer/opensea/start"(platform: "/mobile", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/opensea/start"(platform: "/mobile", type: TrackType.View, business:"mercadopago") {}

        "/credits/consumer/opensea/congrats"(platform: "/mobile", type: TrackType.View, business:"mercadolibre") {
            result = 'manual_review'
        }
        "/credits/consumer/opensea/congrats"(platform: "/mobile", type: TrackType.View, business:"mercadopago") {
            result = 'approved'
        }

        /* Remedy MLM */
        "/credits/consumer/opensea/remedy/authorization"(platform: "/", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/authorization"(platform: "/", type: TrackType.View, business:"mercadopago") {}
        "/credits/consumer/opensea/remedy/authorization/open_detail"(platform: "/web", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/authorization/open_detail"(platform: "/web", type: TrackType.Event, business:"mercadopago") {}
        "/credits/consumer/opensea/remedy/authorization/give_consent"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/authorization/give_consent"(platform: "/", type: TrackType.Event, business:"mercadopago") {}
        "/credits/consumer/opensea/remedy/authorization/deny_consent"(platform: "/web", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/authorization/deny_consent"(platform: "/web", type: TrackType.Event, business:"mercadopago") {}
        "/credits/consumer/opensea/remedy/authorization/modal"(platform: "/mobile", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/authorization/modal"(platform: "/mobile", type: TrackType.View, business:"mercadopago") {}
        "/credits/consumer/opensea/remedy/authorization/recovery"(platform: "/", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/authorization/recovery"(platform: "/", type: TrackType.View, business:"mercadopago") {}
        "/credits/consumer/opensea/remedy/authorization/quit_remedy"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/authorization/quit_remedy"(platform: "/", type: TrackType.Event, business:"mercadopago") {}

        /******************************************
         *   End: Consumers Opensea Flow
         ******************************************/
    }

    test('Merchant Public Landing') {
        // MercadoPago Business
        "/credits/merchant/public_landing"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            user_profile = 'offer'
        }
        "/credits/merchant/public_landing"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            user_profile = 'no_offer'
        }

        // MercadoLibre business
        "/credits/merchant/public_landing"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            user_profile = 'offer'
        }
        "/credits/merchant/public_landing"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            user_profile = 'no_offer'
        }
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
        "/credits/mkt_landing/sms"(platform: "/web", type: TrackType.Event, business:"mecadolibre"){
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
}
