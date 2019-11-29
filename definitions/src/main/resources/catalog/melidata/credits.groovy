package src.main.resources.catalog

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    /******************************************
     *       Abstract definitions
     ******************************************/
    "/credits"(platform: "/", isAbstract: true) {}
    "/credits/consumer"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea"(platform: "/", isAbstract: true) {}
    "/credits/consumer/opensea/integrated_flow"(platform: "/", isAbstract: true) {}

    /***********************************************
     *       Start: Consumers Integrated Flow (mercadolibre - mercadopago)
     ***********************************************/
    //Integrated Flow - Start

    //Page view
    "/credits/consumer/opensea/integrated_flow/start"(platform: "/", type: TrackType.View) {
        source(description: "Integrated flow source", type: PropertyType.String, required: true)
    }
    "/credits/consumer/opensea/integrated_flow/credit_line_status"(platform: "/", type: TrackType.View) {}

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
}
