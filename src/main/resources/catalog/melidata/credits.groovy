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
    "/credits/consumer/opensea"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea/integrated_flow"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea/remedy"(platform: "/", isAbstract: true) {}

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
    }

    /* Remedy MLM */
    "/credits/consumer/opensea/remedy/authorization"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/opensea/remedy/authorization/open_detail"(platform: "/web", type: TrackType.Event) {}
    "/credits/consumer/opensea/remedy/authorization/give_consent"(platform: "/", type: TrackType.Event) {}
    "/credits/consumer/opensea/remedy/authorization/deny_consent"(platform: "/web", type: TrackType.Event) {}
    "/credits/consumer/opensea/remedy/authorization/modal"(platform: "/mobile", type: TrackType.View) {}
    "/credits/consumer/opensea/remedy/authorization/recovery"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/opensea/remedy/authorization/quit_remedy"(platform: "/", type: TrackType.Event) {}

    /******************************************
     *   End: Consumers Opensea Flow
     ******************************************/

     /******************************************
     *       Start: Merchants Public Landings
     ******************************************/
    //Public landing
    "/credits/merchant/public_landing"(platform: "/", type: TrackType.View) {
        user_profile(
            type: PropertyType.String,
            required: true
        )
    }

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
