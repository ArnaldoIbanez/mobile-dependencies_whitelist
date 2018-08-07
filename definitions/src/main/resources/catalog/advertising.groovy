import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    //ADVERTISING FLOW

    "/advertising"(platform: "/", isAbstract: true) {}

    "/advertising/pads2"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager"(platform: "/web", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, description: "Current budget related to the campaign")
    }

    "/advertising/pads2/manager/update_campaign_status"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, description: "Current budget related to the campaign")
        previous_status (required: true, description: "Previous status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/manager/update_campaign_budget"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, description: "Current budget related to the campaign")
        previous_budget (required: true, description: "Previous budget related to the campaign")
    }

    "/advertising/pads2/manager/update_ad_status"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, description: "Current budget related to the campaign")
        item_id(required:true, description: "Item id related to the ad")
        ad_status(required: true, description: "Current status related to the ad", values: ['active', 'paused'])
        previous_ad_status (required: true, description: "Previous status related to the ad", values: ['active', 'paused'])
    }

//    Generic landing
    "/advertising/pads2/generic_landing"(platform: "/", type: TrackType.View) {

    }

    "/advertising/pads2/generic_landing/main_action"(platform: "/", type: TrackType.Event) {
        button(required: true, description: "Button that redirects to confirm page")
    }

    "/advertising/pads2/generic_landing/change_budget"(platform: "/", type: TrackType.Event) {

    }

    "/advertising/pads2/generic_landing/contract_confirmation"(platform: "/", type: TrackType.View) {

    }

    "/advertising/pads2/generic_landing/contract_confirmation/change_budget"(platform: "/", type: TrackType.Event) {

    }

    "/advertising/pads2/generic_landing/contract_confirmation/change_budget/confirm"(platform: "/", type: TrackType.Event) {
        budget(required: true, description: "Budget defined before hiring, it's related to the campaign")
    }

    "/advertising/pads2/generic_landing/contract_confirmation/confirm"(platform: "/", type: TrackType.Event) {
        budget(required: true, description: "Budget related to the campaign")
    }
}
