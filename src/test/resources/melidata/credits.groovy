package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("consumer credits ml y mp") {

        "/credits/consumer/public_landing/paused"(platform: "/", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/public_landing/paused"(platform: "/", type: TrackType.View, business:"mercadopago") {}

        /******************************************
        *       Start: Flujo Upsell Consumer
        ******************************************/
        "/credits/consumer/upsell/remedy"(platform: "/", type: TrackType.View, business:"mercadolibre") {
            remedy_name = 'declarative_info'
            source_key = 'landing'
        }
        "/credits/consumer/upsell/remedy/save_info"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            remedy_name = 'declarative_info'
            source_key = 'landing'
        }
        "/credits/consumer/upsell/congrats"(platform: "/", type: TrackType.View, business:"mercadolibre") {
            result = 'approved'
        }
        "/credits/consumer/upsell/remedy"(platform: "/", type: TrackType.View, business:"mercadopago") {
            remedy_name = 'declarative_info'
            source_key = 'landing'
        }
        "/credits/consumer/upsell/remedy/save_info"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            remedy_name = 'declarative_info'
            source_key = 'landing'
        }
        "/credits/consumer/upsell/congrats"(platform: "/", type: TrackType.View, business:"mercadopago") {
            result = 'rejected'
        }
        "/credits/consumer/upsell/congrats/admin"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            result = 'approved'
        }
        "/credits/consumer/upsell/congrats/admin"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            result = 'rejected'
        }
        "/credits/consumer/upsell/congrats/help"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            result = 'rejected'
        }
        "/credits/consumer/upsell/congrats/help"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            result = 'approved'
        }

        "/credits/consumer/upsell/stop"(platform: "/", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/upsell/stop"(platform: "/", type: TrackType.View, business:"mercadopago") {}
        "/credits/consumer/upsell/stop/admin"(platform: "/", type: TrackType.Event, business:"mercadopago") {}
        "/credits/consumer/upsell/stop/admin"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/consumer/upsell/cx"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            list_status = "white_list"
            dashboard_status = "on_time"
        }
        "/credits/consumer/upsell/cx"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            list_status = "black_list"
            dashboard_status = "overdue"
        }
        "/credits/consumer/upsell/shared_data_congrats"(platform: "/", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/upsell/shared_data_congrats"(platform: "/", type: TrackType.View, business:"mercadopago") {}
        "/credits/consumer/upsell/shared_data_congrats/admin"(platform: "/", type: TrackType.Event, business:"mercadopago") {}
        "/credits/consumer/upsell/shared_data_congrats/admin"(platform: "/", type: TrackType.Event, business:"mercadolibre") {}
        /******************************************
        *       End: Flujo Upsell Consumer
        ******************************************/


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

         /***********************************************
         *       Start: Consumers Pre Approved Flow
         ***********************************************/
        //Pre Approved Flow - Start

        //Page view
        "/credits/consumer/opensea/pre_approved_flow/start"(platform: "/web/desktop", type: TrackType.View, business:"mercadolibre") {
            source = 'on'
        }
        "/credits/consumer/opensea/pre_approved_flow/start"(platform: "/web/desktop", type: TrackType.View, business:"mercadopago") {
            source = 'off'
        }

        //Events
        "/credits/consumer/opensea/pre_approved_flow/start/application_start"(platform: "/web/mobile", type: TrackType.Event, business:"mercadolibre") {
            source = 'on'
        }
        "/credits/consumer/opensea/pre_approved_flow/start/application_start"(platform: "/web/mobile", type: TrackType.Event, business:"mercadopago") {
            source = 'off'
        }
         "/credits/consumer/opensea/pre_approved_flow/start/application_cancel"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {
            source = 'on'
        }
        "/credits/consumer/opensea/pre_approved_flow/start/application_cancel"(platform: "/web/desktop", type: TrackType.Event, business:"mercadopago") {
            source = 'off'
        }

        /*********************************************
         *       End: Consumers Pre Approved Flow
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
        "/credits/consumer/opensea/risk_provider/share_data"(platform: "/mobile", type: TrackType.Event, business:"mercadopago") {{
            risk_provider = 'open_finance'
        }
        "/credits/consumer/opensea/risk_provider/share_data"(platform: "/web/desktop", type: TrackType.Event, business:"mercadolibre") {{
            risk_provider = 'klippa'
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
        /* Remedy MLM WebView */
        "/credits/consumer/opensea/remedy/opt_in_authorization"(platform: "/mobile", type: TrackType.View, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/opt_in_authorization"(platform: "/mobile", type: TrackType.View, business:"mercadopago") {}
        "/credits/consumer/opensea/remedy/opt_in_authorization/give_consent"(platform: "/mobile", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/opt_in_authorization/give_consent"(platform: "/mobile", type: TrackType.Event, business:"mercadopago") {}
        "/credits/consumer/opensea/remedy/opt_in_authorization/deny_consent"(platform: "/mobile", type: TrackType.Event, business:"mercadolibre") {}
        "/credits/consumer/opensea/remedy/opt_in_authorization/deny_consent"(platform: "/mobile", type: TrackType.Event, business:"mercadopago") {}
        /******************************************
         *   End: Consumers Opensea Flow
         ******************************************/
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

    test("Personal Loans Adoption") {

        /******************************************
         *   Start: Personal Loans Adoption
         ******************************************/

        "/credits/consumer/personal"(platform: "/mobile", type: TrackType.View) {
        }

        "/credits/consumer/personal/adoption"(platform: "/mobile", type: TrackType.View) {
            prepaid = true
            virtual_card = true
            physical_card = false
        }

        "/credits/consumer/personal/adoption/onboarding"(platform: "/mobile", type: TrackType.View) {
            prepaid = false
            page = 1
            source_key = 'sk1234'
        }

        "/credits/consumer/personal/adoption/onboarding/go_simulation"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
            page = 4
        }

        "/credits/consumer/personal/adoption/onboarding/close"(platform: "/mobile", type: TrackType.Event) {
            prepaid = true
        }

        "/credits/consumer/personal/adoption/simulator"(platform: "/mobile", type: TrackType.View) {
            source_key = 'sk1234'
            prepaid = false
            virtual_card = false
            physical_card = false
        }

        "/credits/consumer/personal/adoption/simulator/go_review"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review"(platform: "/mobile", type: TrackType.View) {
            prepaid = false
            virtual_card = false
            physical_card = false
        }

        "/credits/consumer/personal/adoption/review/general_terms"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/particular_terms"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/above_confirm"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/review/below_confirm"(platform: "/mobile", type: TrackType.Event) {
            prepaid = false
        }

        "/credits/consumer/personal/adoption/congrats"(platform: "/mobile", type: TrackType.View) {
            status = 'no_prepaid'
        }

        "/credits/consumer/personal/adoption/congrats/go_wallet"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/congrats/go_prepaid"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_disabled'
        }

        "/credits/consumer/personal/adoption/congrats/go_withdrawals"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/generic_message"(platform: "/mobile", type: TrackType.View) {
            status = 'prepaid_enabled'
        }

        "/credits/consumer/personal/adoption/generic_message/go_prepaid"(platform: "/mobile", type: TrackType.Event) {
            status = 'prepaid_disabled'
        }

        /******************************************
         *   End: Personal Loans Adoption
         ******************************************/
    }
}
