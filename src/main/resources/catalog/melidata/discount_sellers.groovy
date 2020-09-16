package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative="1218"

    "/discount_sellers" (platform: "/mobile", isAbstract: true) {
        session_id(required: true, type: PropertyType.String, description: "Session identifier")
    }
    
    // *******************************************************
    // ******************** Events - Form ********************
    // *******************************************************

    "/discount_sellers/form/open" (platform: "/mobile", type: TrackType.Event) {
        origin(required: false, type: PropertyType.String, description: "Form origin, like push, history, empty, etc")
    }

    "/discount_sellers/form" (platform: "/mobile", type: TrackType.View) {
        form_model(required: false, type: PropertyType.String, description: "Model to identify the sections drawed")
        mcc(required: false, type: PropertyType.String, description: "MCC Identifier")
        melicapaign_id(required: false, type: PropertyType.String, description: "Melicampaign identifier")
        origin(required: false, type: PropertyType.String, description: "Form origin, like push, history, empty, etc")
        clone_campaign_id(required: false, type: PropertyType.String, description: "Clone campaign identifier")
        tooltip(required: false, type: PropertyType.String, description: "Tooltip description")
    }

    "/discount_sellers/form/redirect" (platform: "/mobile", type: TrackType.Event) {
        melicampaign_id(required: false, type: PropertyType.String, description: "Melicampaign identifier")
	redirection_to(required: false, type: PropertyType.String, description: "profile_check, landing, disabled_feature, etc")
    }

    "/discount_sellers/form/section" (platform: "/mobile", isAbstract: true) {}

    "/discount_sellers/form/section/change" (platform: "/mobile", type: TrackType.Event) {
        section(required: true, type: PropertyType.String, description: "Section identifier")
        section_output(required: false, type: PropertyType.String, description: "Section Model")
    }

    "/discount_sellers/form/section/open" (platform: "/mobile", type: TrackType.Event) {
        modal(required: true, type: PropertyType.String, description: "Modal identifier")
    }

    "/discount_sellers/form/section/close" (platform: "/mobile", type: TrackType.Event) {
        modal(required: true, type: PropertyType.String, description: "Modal identifier")
    }

    "/discount_sellers/form/section/friction" (platform: "/mobile", type: TrackType.Event) {
        section(required: true, type: PropertyType.String, description: "Section identifier")
        description(required: false, type: PropertyType.String, description: "Error description")
    }
    
    "/discount_sellers/form/error" (platform: "/mobile", type: TrackType.Event) {
        description(required: false, type: PropertyType.String, description: "Error description")
    }

    "/discount_sellers/form/modal_confirm" (platform: "/mobile", isAbstract: true) {}
    
    "/discount_sellers/form/modal_confirm/open" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type description")
        description(required: false, type: PropertyType.String, description: "Modal description")
    }
    
    "/discount_sellers/form/modal_confirm/close" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type description")
        description(required: false, type: PropertyType.String, description: "Modal description")
    }

    "/discount_sellers/form/create" (platform: "/mobile", type: TrackType.Event) {
        form_output(required: true, type: PropertyType.String, description: "Model sent to create the campaign")
    }

    "/discount_sellers/form/back" (platform: "/mobile", type: TrackType.Event) {}

    "/discount_sellers/form/result" (platform: "/mobile", isAbstract: true) {}

    "/discount_sellers/form/result/success" (platform: "/mobile", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.String, description: "Campaign Identifier")
    }

    "/discount_sellers/form/result/pending" (platform: "/mobile", type: TrackType.Event) {
        campaign_id(required: false, type: PropertyType.String, description: "Campaign Identifier")
    }

    "/discount_sellers/form/result/rejected" (platform: "/mobile", type: TrackType.Event) {}

    // **********************************************************
    // ******************** Events - History ********************
    // **********************************************************

    "/discount_sellers/history/open" (platform: "/mobile", type: TrackType.Event) {}

    "/discount_sellers/history" (platform: "/mobile", type: TrackType.View) {
        campaigns(required: false, type: PropertyType.String, description: "Campaign list")
	moderation(required: false, type: PropertyType.String, description: "Moderation Banner")    
    }

    "/discount_sellers/history/redirect" (platform: "/mobile", type: TrackType.Event) {
	melicampaign_id(required: false, type: PropertyType.String, description: "Melicampaign identifier")
	redirection_to(required: false, type: PropertyType.String, description: "profile_check, landing, disabled_feature, etc")
    }

    "/discount_sellers/history/tap" (platform: "/mobile", type: TrackType.Event) {
        campaign_id(required: false, type: PropertyType.String, description: "Campaign Identifier")
        target(required: true, type: PropertyType.String, values: ["card", "button"], description: "Tap target")
        title(required: false, type: PropertyType.String, description: "Main action title")
    }

    "/discount_sellers/history/main_action" (platform: "/mobile", type: TrackType.Event) {
        title(required: true, type: PropertyType.String, description: "Main action title")
    }

    "/discount_sellers/history/error" (platform: "/mobile", type: TrackType.Event) {
        description(required: false, type: PropertyType.String, description: "Error description")
    }

    "/discount_sellers/history/back" (platform: "/mobile", type: TrackType.Event) {}

    // *********************************************************
    // ******************** Events - Detail ********************
    // *********************************************************

    "/discount_sellers/detail/open" (platform: "/mobile", type: TrackType.Event) {}

    "/discount_sellers/detail" (platform: "/mobile", type: TrackType.View) {
        campaign_id(required: false, type: PropertyType.String, description: "Campaign Identifier")
        status(required: true, inheritable: false, type: PropertyType.String, description: "Campaign Status")
        budget_total(required: false, type: PropertyType.String, description: "Campaign budget")
        budget_used(required: false, type: PropertyType.String, description: "Campaign budget used")
        payments(required: false, type: PropertyType.String, description: "Number of payments")
        payed_amount(required: false, type: PropertyType.String, description: "Payments amount")
        main_action_title(required: false, type: PropertyType.String, description: "Main action title")
        quick_actions(required: false, type: PropertyType.String, description: "Quick actions visibles for the campaign")
    }

    "/discount_sellers/detail/tap" (platform: "/mobile", type: TrackType.Event) {
        campaign_id(required: false, type: PropertyType.String, description: "Campaign Identifier")
        target(required: false, type: PropertyType.String, description: "Where was the tap")
        title(required: false, type: PropertyType.String, description: "Action title")
    }

    "/discount_sellers/detail/modal" (platform: "/mobile", isAbstract: true) {}

    "/discount_sellers/detail/modal/open" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, values: ["pause", "resume"], description: "Modal type")
    }

    "/discount_sellers/detail/modal/close" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, values: ["pause", "resume"], description: "Modal type")
    }

    "/discount_sellers/detail/modal/confirm" (platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, values: ["pause", "resume"], description: "Modal type")
    }

    "/discount_sellers/detail/error" (platform: "/mobile", type: TrackType.Event) {
        description(required: false, type: PropertyType.String, description: "Error description")
    }

    "/discount_sellers/detail/back" (platform: "/mobile", type: TrackType.Event) {}

    // **********************************************************
    // ******************** Events - Landing ********************
    // **********************************************************

    "/discount_sellers/landing" (platform: "/mobile", type: TrackType.View) {
        landing_id(required: true, inheritable: false, type: PropertyType.String, description: "Landing Identifier")
    }

    "/discount_sellers/landing/tap" (platform: "/mobile", type: TrackType.Event) {
        title(required: false, type: PropertyType.String, description: "Action title")
    }

    "/discount_sellers/landing/back" (platform: "/mobile", type: TrackType.Event) {}
}
