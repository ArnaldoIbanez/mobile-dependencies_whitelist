package src.main.resources.catalog

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1205"

    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/merchant"(platform: "/", isAbstract: true) {}
    "/credits/consumer/upsell"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea/integrated_flow"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea/pre_approved_flow"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea/remedy"(platform: "/", isAbstract: true) {}

    /******************************************
    *       Start: Flujo Upsell Consumer
    ******************************************/
        //ML
    "/credits/consumer/upsell/remedy"(platform: "/", type: TrackType.View) {
        remedy_name(description: "Remedy Name", type: PropertyType.String, required: true, values: ["declarative_info"])
        source_key(description: "Source key", type: PropertyType.String, required: true)
    }
    "/credits/consumer/upsell/remedy/save_info"(platform: "/", type: TrackType.Event) {
        remedy_name(description: "Remedy Name", type: PropertyType.String, required: true, values: ["declarative_info"])
        source_key(description: "Source key", type: PropertyType.String, required: true)
    }
    "/credits/consumer/upsell/congrats"(platform: "/", type: TrackType.View) {
        result(description: "Congrats result", type: PropertyType.String, required: true, values: ["started", "manual_review", "approved", "rejected", "error", "data_sent"])
    }
    "/credits/consumer/upsell/congrats/admin"(platform: "/", type: TrackType.Event) {
        result(description: "Congrats result", type: PropertyType.String, required: true, values: ["started", "manual_review", "approved", "rejected", "error", "data_sent"])
    }
    "/credits/consumer/upsell/congrats/help"(platform: "/", type: TrackType.Event) {
        result(description: "Congrats result", type: PropertyType.String, required: true, values: ["started", "manual_review", "approved", "rejected", "error", "data_sent"])
    }

    "/credits/consumer/upsell/stop"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/upsell/stop/admin"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/upsell/cx"(platform: "/", type: TrackType.Event) {}
    /******************************************
    *       End: Flujo Upsell Consumer
    ******************************************/

    /***********************************************
     *       Start: Consumers Integrated Flow (mercadolibre - mercadopago)
     ***********************************************/
    //Integrated Flow - Start

    //Page view
    "/credits/consumer/opensea/integrated_flow/start"(platform: "/", type: TrackType.View) {
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }
    "/credits/consumer/opensea/integrated_flow/credit_line_status"(platform: "/", type: TrackType.View) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected", "error"])
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }

    //Events
    "/credits/consumer/opensea/integrated_flow/start/application_start"(platform: "/", type: TrackType.Event) {
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }
    "/credits/consumer/opensea/integrated_flow/start/application_cancel"(platform: "/", type: TrackType.Event) {
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }

    //Integrated Flow - Congrats

    //Page view
    "/credits/consumer/opensea/integrated_flow/congrats"(platform: "/", type: TrackType.View) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected", "error"])
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }

    //Events
    "/credits/consumer/opensea/integrated_flow/congrats/buy_intention"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected", "error"])
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }
    "/credits/consumer/opensea/integrated_flow/congrats/back_to_publication"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected", "error"])
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }
    "/credits/consumer/opensea/integrated_flow/congrats/back_to_site"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the IV application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected", "error"])
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }

    /*********************************************
     *       End: Consumers Integrated Flow
     *********************************************/

    /***********************************************
     *       Start: Consumers Pre Approved Flow (mercadolibre - mercadopago)
     ***********************************************/
    //Pre Approved Flow - Start

    //Page view
    "/credits/consumer/opensea/pre_approved_flow/start"(platform: "/", type: TrackType.View) {
        source(description: "Pre approved flow source", type: PropertyType.String, required: true)
    }

    //Events
    "/credits/consumer/opensea/pre_approved_flow/start/application_start"(platform: "/", type: TrackType.Event) {
        source(description: "Pre approved flow source", type: PropertyType.String, required: true)
    }
    "/credits/consumer/opensea/pre_approved_flow/start/application_cancel"(platform: "/", type: TrackType.Event) {
        source(description: "Pre approved flow source", type: PropertyType.String, required: true)
    }

    /*********************************************
     *       End: Consumers Pre Approved Flow
     *********************************************/

    /******************************************
     *    Start: Consumers Opensea Integrations
     ******************************************/

    "/credits/consumer/opensea/redirect"(platform: "/mobile", type: TrackType.View) {}
    "/credits/consumer/opensea/integrated_flow/vip"(platform: "/web", type: TrackType.Event){}

    /******************************************
     *   End: Consumers  Opensea Integrations
     ******************************************/

    /******************************************
     *    Start: Consumers Opensea Flow
     ******************************************/

    "/credits/consumer/opensea/start"(platform: "/mobile", type: TrackType.View) {}
    "/credits/consumer/opensea/congrats"(platform: "/mobile", type: TrackType.View){
        result(description: "Current status of the IV/KyC application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected"])
        offer_type(description: "Offer Type on Approved Credits Lines", type: PropertyType.String, required: false, values: ["special_full_offer", "full_offer", "early_offer"])
    }

    /* Remedy MLM */
    "/credits/consumer/opensea/remedy/authorization"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/opensea/remedy/authorization/open_detail"(platform: "/web", type: TrackType.Event) {}
    "/credits/consumer/opensea/remedy/authorization/give_consent"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/opensea/remedy/authorization/deny_consent"(platform: "/web", type: TrackType.Event) {}
    "/credits/consumer/opensea/remedy/authorization/modal"(platform: "/mobile", type: TrackType.View) {}
    "/credits/consumer/opensea/remedy/authorization/recovery"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/opensea/remedy/authorization/quit_remedy"(platform: "/", type: TrackType.Event) {}
    /* Remedy MLM WebView */
    "/credits/consumer/opensea/remedy/opt_in_authorization"(platform: "/mobile", type: TrackType.View) {}
    "/credits/consumer/opensea/remedy/opt_in_authorization/give_consent"(platform: "/mobile", type: TrackType.Event) {}
    "/credits/consumer/opensea/remedy/opt_in_authorization/deny_consent"(platform: "/mobile", type: TrackType.Event) {}

    /******************************************
     *   End: Consumers Opensea Flow
     ******************************************/

     /******************************************
     *       Start: Credits Optins
     ******************************************/

    "/credits/preferences"(platform: "/", isAbstract: true, type: TrackType.View) {
        initiative(
            type: PropertyType.String,
            required: true,
            inheritable: true,
            values: [
                'merchant_enrollment',
                'merchant_express_money',
                'merchant_open_market',
                'merchant_administrator',
                'consumer_open_sea',
                'consumer_personal_loan',
                'consumer_administrator',
                'credit_card_open_sea'
            ]
        )
        step(
            type: PropertyType.String,
            required: false,
            inheritable: true,
            values: [
                'whatsapp', 
                'whatsapp_sms', 
                'sms', 
                'telcel', 
                'credit_circle', 
                'telcel_credit_circle'
            ]
        )
    }
    "/credits/preferences/error"(platform: "/", type: TrackType.View) {}
    "/credits/preferences/accept"(platform: "/", type: TrackType.Event){}
    "/credits/preferences/decline"(platform: "/", type: TrackType.Event){}
    

    /******************************************
     *       End: Credits Optins
     ******************************************/


     /******************************************
     *       Start: Merchants Public Landings
     ******************************************/
    //Public landing
    "/credits/merchant/public_landing"(platform: "/", type: TrackType.View) {
        offers(
            type: PropertyType.ArrayList(PropertyType.String),
            required: false,
            inheritable: false
        )
    }
    
    "/credits/merchant/public_landing/ftl_offer"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/public_landing/spl_offer"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/public_landing/em_offer"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/public_landing/new_account"(platform: "/", type: TrackType.Event) {}
    "/credits/merchant/public_landing/credits_access"(platform: "/", type: TrackType.Event) {}

    // Credits Marketing Performance landing 
    "/credits/mkt_landing"(platform: "/web", type: TrackType.View, initiative: "1176") {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/credits/mkt_landing/sms"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/credits/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/credits/mkt_landing/button"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }

    /******************************************
     *       End: Merchants Public Landings
     ******************************************/
}
