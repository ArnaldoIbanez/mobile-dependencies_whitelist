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
            source = 'off'
            result = 'approved'
        }

        //Events
        "/credits/consumer/opensea/integrated_flow/start/application_start"(platform: "/web/mobile", type: TrackType.Event, business:"mercadolibre") {
            source = 'cho'
        }
        "/credits/consumer/opensea/integrated_flow/start/application_start"(platform: "/web/mobile", type: TrackType.Event, business:"mercadopago") {
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
        "/credits/consumer/opensea/integrated_flow/congrats/back_to_publication"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            result = 'manual_review'
            source = 'off'
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
    }
}
