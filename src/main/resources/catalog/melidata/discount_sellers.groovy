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
	
	
    // **********************************************************
    // ******************** Events - Congrats *******************
    // **********************************************************

    "/discount_sellers/congrats" (platform: "/mobile", type: TrackType.View) {
        status(required: true, inheritable: false, type: PropertyType.String, values: ["success", "pending", "rejected"], description: "Congrats Status")
    }

    "/discount_sellers/congrats/tap" (platform: "/mobile", type: TrackType.Event) {
        title(required: false, type: PropertyType.String, description: "Action title")
    }

    "/discount_sellers/congrats/close" (platform: "/mobile", type: TrackType.Event) {}
	
    // **********************************************************
    // ******************** Events - FTU ************************
    // **********************************************************

    "/discount_sellers/ftu" (platform: "/mobile", type: TrackType.View) {
        url(required: false, inheritable: false, type: PropertyType.String, description: "URL loaded in the FTU's web view")
    }

    "/discount_sellers/ftu/tap" (platform: "/mobile", type: TrackType.Event) {
        title(required: false, type: PropertyType.String, description: "Action title")
    }

    "/discount_sellers/ftu/back" (platform: "/mobile", type: TrackType.Event) {}
	
    "/discount_sellers/ftu/error" (platform: "/mobile", type: TrackType.Event) {
	description(required: false, type: PropertyType.String, description: "Error description")
    }
    
    // Instore (ISDT) - Webview - Prefecture Home > Pageview
    "/instore/prefecture"(platform: "/", type: TrackType.View) {}

    // Instore (ISDT) - Webview - Prefecture Error > Pageview
    "/instore/prefecture/error"(platform: "/", type: TrackType.View) {}

    // Instore (ISDT) - Webview - Prefecture Home > Events
    "/instore/prefecture/tap"(platform: "/", type: TrackType.Event) {
        link (type: PropertyType.String, required: true, values: ["stores","faqs","close"], description: "Name of tap, example: stores")
    }

    // Instore (ISDT) - Webview - Prefecture Error > Events
    "/instore/prefecture/error/tap"(platform: "/", type: TrackType.Event) {
        link (type: PropertyType.String, required: true, values: ["go_home"], description: "Name of tap, example: go_home")
    }

    "/discount_sellers/v2" (platform: "/", isAbstract: true) {
        session_id(required: true, type: PropertyType.String, description: "Session identifier")
    }
    "/discount_sellers/v2/error" (platform: "/", isAbstract: true) {}

    // Instore (ISDT) - Webview -  Home Sellers Error > Pageview
    "/discount_sellers/v2/error" (platform: "/",  type: TrackType.View) {
        session_id(type: PropertyType.String, description: "Session identifier")
        platform (type: PropertyType.String, required: false, values: ["web"])
    }
    "/discount_sellers/v2/error/tap" (platform: "/", type: TrackType.Event) {
        link (type: PropertyType.String, required: false, description: "Name of button on the screen error")
        
    }
    
    def campaign = objectSchemaDefinitions {
        component_id (type: PropertyType.String, description: "Id of campaign")
        status (type: PropertyType.String, values: ["ACTIVE","INACTIVE","PAUSED"], description: "status of campaign, example: ACTIVE")
        total_charges (type: PropertyType.String, description: "pyments of campaign, example: 342")
        budget_total (type: PropertyType.Numeric, description: "budget of campaign")
        budget_used (type: PropertyType.Numeric, description: "budget used of campaign")
    }
   
    // Instore (ISDT) - Webview -  Home Sellers Home > Pageview 
    "/discount_sellers/v2/home"(platform: "/", type: TrackType.View){
        session_id(required: true, type: PropertyType.String, description: "Session identifier")
        segments(PropertyType.ArrayList, required: false, description:"list of elements rendered in the home page")
        platform (type: PropertyType.String, required: false, values: ["web"], description: "tracks from webview")
    }
        
    // Instore (ISDT) - Webview -  Home Sellers Home > segment 
    "/discount_sellers/v2/home/segment" (platform: "/", type: TrackType.Event) {
        data (required: false, type: PropertyType.ArrayList, description: "infomation objects")
        drawing_type (type: PropertyType.String, description:"shape of element on the screen")
        segment_id (type: PropertyType.String, description: "identifier of segment")
        position (type: PropertyType.Numeric, description: "positon of element on the secreen")
        component_id (type: PropertyType.String, required: false, description: "id of the component")
        components (PropertyType.ArrayList(PropertyType.Map(campaign)), required: false, description: "array of elements on the screen")
        data_id (type: PropertyType.String, required: false, description: "moderation status example: more_clients")
        status (type: PropertyType.String, required: false, values: ["ACTIVE","INACTIVE","PAUSED"], description: "status of campaign, example: ACTIVE")
        payments (type: PropertyType.Numeric, required: false, description: "pyments of campaign, example: 342")
        budget_total (type: PropertyType.Numeric, required: false, description: "budget of campaign")
        payed_amount (type: PropertyType.Numeric, required: false, description: "tvpv of campaign")
        budget_used (type: PropertyType.Numeric, required: false, description: "budget used of campaign")
        see_more (type: PropertyType.Boolean, required: false, description: "check if user saw the button see more campaigns")
    }

    "/discount_sellers/v2/home/tap" (platform: "/", type: TrackType.View) {
        session_id(required: true, type: PropertyType.String, description: "Session identifier")
        drawing_type (type: PropertyType.String, description:"shape of element on the screen")
        component (required: false, type: PropertyType.ArrayList, description: "infomation objects")
        segment_id (type: PropertyType.String, description: "identifier of segment")
        position (type: PropertyType.Numeric, description: "positon of element on the secreen")
        component_id (type: PropertyType.String, required: false, description: "id of the component") 
    }

    // Instore (ISDT) - Webview -  Home Sellers History > Pageview
    "/discount_sellers/v2/history" (platform: "/", type: TrackType.View) {
        session_id(type: PropertyType.String, description: "Session identifier")
        campaigns(type: PropertyType.ArrayList, required: false, description: "Campaign list")
        campaign_id (type: PropertyType.String, required: false, description: "Id of campaign")
        component_id (type: PropertyType.String, required: false, description: "id of the component")
        payments (type: PropertyType.Numeric, required: false, description: "pyments of campaign, example: 342")
        budget_total (type: PropertyType.Numeric, required: false, description: "budget of campaign")
        payed_amount (type: PropertyType.Numeric, required: false, description: "tvpv of campaign")
        budget_used (type: PropertyType.Numeric, required: false, description: "budget used of campaign")
        status (type: PropertyType.String, values: ["ACTIVE","INACTIVE","PAUSED"], description: "status of campaign, example: ACTIVE")
        platform (type: PropertyType.String,  values: ["web"])
    }

    // Instore (ISDT) - Webview -  Home Sellers History > tap 
    "/discount_sellers/v2/history/tap" (platform: "/", type: TrackType.Event) {
         position (type: PropertyType.Numeric, description: "positon of element on the secreen")

    }

    // Instore (ISDT) - Webview -  Home Sellers Detail "Active" > Pageview
    "/discount_sellers/v2/detail" (platform: "/", type: TrackType.View) {
        session_id(type: PropertyType.String, description: "Session identifier")
        campaign_id (type: PropertyType.String, description: "Id of campaign")
        status (type: PropertyType.String, values: ["ACTIVE","INACTIVE","PAUSED"], description: "status of campaign, example: ACTIVE")
        payments (type: PropertyType.Numeric, required: false, description: "pyments of campaign, example: 342")
        budget_total (type: PropertyType.Numeric, required: false, description: "budget of campaign")
        payed_amount (type: PropertyType.Numeric, required: false, description: "tvpv of campaign")
        budget_used (type: PropertyType.Numeric, required: false, description: "budget used of campaign")
        actions (type: PropertyType.ArrayList,  required: false, description: "Name of buttons on the screen")
        platform (type: PropertyType.String, values: ["web"])   
    }

    "/discount_sellers/v2/detail/tap" (platform: "/", type: TrackType.View) {
        action (type: PropertyType.String,  description: "Name of button on the screen")
    }

    
}