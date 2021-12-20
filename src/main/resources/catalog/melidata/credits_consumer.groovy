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

    "/credits/consumer/public_landing/paused"(platform: "/", type: TrackType.View) {}

    /******************************************
    *       Start: Flujo Upsell Consumer
    ******************************************/
        //ML
    "/credits/consumer/upsell/remedy"(platform: "/", type: TrackType.View) {
        remedy_name(description: "Remedy Name", type: PropertyType.String, required: true, values: ["declarative_info"])
        from(description: "Identifies the origin of the user", type: PropertyType.String, required: false)
        additional_info(description: "Additional information about the navigation flow", type: PropertyType.String, required: false)
    }
    "/credits/consumer/upsell/remedy/save_info"(platform: "/", type: TrackType.Event) {
        remedy_name(description: "Remedy Name", type: PropertyType.String, required: true, values: ["declarative_info"])
        from(description: "Identifies the origin of the user", type: PropertyType.String, required: false)
        additional_info(description: "Additional information about the navigation flow", type: PropertyType.String, required: false)
    }
    "/credits/consumer/upsell/congrats"(platform: "/", type: TrackType.View) {
        result(description: "Congrats result", type: PropertyType.String, required: true, values: ["started", "manual_review", "approved", "rejected", "error", "data_sent"])
        from(description: "Identifies the origin of the user", type: PropertyType.String, required: false)
        additional_info(description: "Additional information about the navigation flow", type: PropertyType.String, required: false)
    }
    "/credits/consumer/upsell/congrats/admin"(platform: "/", type: TrackType.Event) {
        result(description: "Congrats result", type: PropertyType.String, required: true, values: ["started", "manual_review", "approved", "rejected", "error", "data_sent"])
        from(description: "Identifies the origin of the user", type: PropertyType.String, required: false)
        additional_info(description: "Additional information about the navigation flow", type: PropertyType.String, required: false)
    }
    "/credits/consumer/upsell/congrats/help"(platform: "/", type: TrackType.Event) {
        result(description: "Congrats result", type: PropertyType.String, required: true, values: ["started", "manual_review", "approved", "rejected", "error", "data_sent"])
        from(description: "Identifies the origin of the user", type: PropertyType.String, required: false)
        additional_info(description: "Additional information about the navigation flow", type: PropertyType.String, required: false)
    }

    "/credits/consumer/upsell/stop"(platform: "/", type: TrackType.View) {
        from(description: "Identifies the origin of the user", type: PropertyType.String, required: false)
        additional_info(description: "Additional information about the navigation flow", type: PropertyType.String, required: false)
    }
    "/credits/consumer/upsell/stop/admin"(platform: "/", type: TrackType.Event) {
        from(description: "Identifies the origin of the user", type: PropertyType.String, required: false)
        additional_info(description: "Additional information about the navigation flow", type: PropertyType.String, required: false)
    }
    "/credits/consumer/upsell/cx"(platform: "/", type: TrackType.Event) {
        list_status(description: "List Status", type: PropertyType.String, required: true, values: ["black_list", "white_list"])
        dashboard_status(description: "Dashboard Status", type: PropertyType.String, required: true,  values: ["empty_state", "on_time", "overdue", "finished"])
    }
    "/credits/consumer/upsell/shared_data_congrats"(platform: "/", type: TrackType.View) {}
    "/credits/consumer/upsell/shared_data_congrats/admin"(platform: "/", type: TrackType.Event) {}

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

    //Pre Approved Flow - Congrats

    //Page view
    "/credits/consumer/opensea/pre_approved_flow/congrats"(platform: "/", type: TrackType.View) {
        result(description: "Current status of the KyC application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected", "error"])
        source(description: "Pre approved flow source", type: PropertyType.String, required: true)
    }
    "/credits/consumer/opensea/pre_approved_flow/credit_line_status"(platform: "/", type: TrackType.View) {
        result(description: "Current status of the Credit Line", type: PropertyType.String, required: true, values: ["pending", "approved", "rejected", "paused"])
        source(description: "Pre approved flow source", type: PropertyType.String, required: true)
    }

    //Events
    "/credits/consumer/opensea/pre_approved_flow/congrats/back_to_site"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the KyC application", type: PropertyType.String, required: true, values: ["manual_review", "approved", "rejected", "error"])
        source(description: "Pre approved flow source", type: PropertyType.String, required: true)
    }
    "/credits/consumer/opensea/pre_approved_flow/credit_line_status/back_to_site"(platform: "/", type: TrackType.Event) {
        result(description: "Current status of the Credit Line", type: PropertyType.String, required: true, values: ["pending", "approved", "rejected", "paused"])
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
    "/credits/consumer/opensea/risk_provider/share_data"(platform: "/", type: TrackType.Event) {
        risk_provider(description: "Risk Integrator in congrats Open Sea", type: PropertyType.String, required: true, values: ["open_finance", "klippa"])
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
     *   Start: Personal Loans Adoption
     ******************************************/
    "/credits/consumer/personal"(platform: "/mobile", type: TrackType.View) {}

    "/credits/consumer/personal/adoption"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: true)
        virtual_card(description: "Identifies if the user has virtual card", type: PropertyType.Boolean, required: false)
        physical_card(description: "Identifies if the user has physical card", type: PropertyType.Boolean, required: false)
    }

    "/credits/consumer/personal/adoption/onboarding"(platform: "/mobile", type: TrackType.View) {
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: true)
        source_key(description: "Source key", type: PropertyType.String, required: false)
    }

    "/credits/consumer/personal/adoption/onboarding/go_simulation"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/onboarding/close"(platform: "/mobile", type: TrackType.Event) {
        page(description: "Onboarding page number", type: PropertyType.Numeric, required: false)
    }

    "/credits/consumer/personal/adoption/simulator"(platform: "/mobile", type: TrackType.View) {
        source_key(description: "Source key", type: PropertyType.String, required: false)
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        virtual_card(description: "Identifies if the user has virtual card", type: PropertyType.Boolean, required: false)
        physical_card(description: "Identifies if the user has physical card", type: PropertyType.Boolean, required: false)
    }

    "/credits/consumer/personal/adoption/simulator/go_review"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        virtual_card(description: "Identifies if the user has virtual card", type: PropertyType.Boolean, required: false)
        physical_card(description: "Identifies if the user has physical card", type: PropertyType.Boolean, required: false)
    }

    "/credits/consumer/personal/adoption/review/general_terms"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/particular_terms"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/above_confirm"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/review/below_confirm"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/congrats"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        status(
                description: "Status of the user prepaid",
                type: PropertyType.String,
                required: true,
                values: [
                        "no_prepaid",
                        "prepaid_enabled",
                        "prepaid_disabled",
                        "physical_card",
                        "virtual_card"
                ]
        )
        source_key(
                required: false,
                description: "Identifies the origin of the user",
                type: PropertyType.String,
        )
    }

    "/credits/consumer/personal/adoption/congrats/go_wallet"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/congrats/go_prepaid"(platform: "/mobile", type: TrackType.Event) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        status(description: "Status of the user prepaid", type: PropertyType.String, required: true, values: [
                "no_prepaid", "prepaid_enabled", "prepaid_disabled", "physical_card", "virtual_card"
        ])
    }

    "/credits/consumer/personal/adoption/congrats/go_withdrawals"(platform: "/mobile", type: TrackType.Event) {}

    "/credits/consumer/personal/adoption/generic_message"(platform: "/mobile", type: TrackType.View) {
        prepaid(description: "Identifies if the user has prepaid", type: PropertyType.Boolean, required: false)
        status(description: "Status of the user prepaid", type: PropertyType.String, required: true, values: [
                "no_prepaid", "prepaid_enabled", "prepaid_disabled", "physical_card", "virtual_card"
        ])
    }

    "/credits/consumer/personal/adoption/generic_message/go_prepaid"(platform: "/mobile", type: TrackType.Event) {}


    /******************************************
     *   End: Personal Loans Adoption
     ******************************************/
}
