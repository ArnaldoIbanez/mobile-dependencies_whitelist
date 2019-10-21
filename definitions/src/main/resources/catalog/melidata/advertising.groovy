import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    //Advertising flow
    "/advertising"(platform: "/", isAbstract: true) {}

    "/advertising/landings"(platform: "/", isAbstract: true) {}

    "/advertising/landings/pads2"(platform: "/", isAbstract: true) {}

    "/advertising/landings/pads2/mail"(platform: "/", isAbstract: true) {}

    "/advertising/landings/pads2/mail/congrats"(platform: "/web", type: TrackType.View) {
        user_id(required:true, description: "User id")
        items_id(required:true, description: "Items ids")
    }

    "/advertising/pads2"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager"(platform: "/web", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, description: "Current budget related to the campaign")
        share_value(required: false,  description: "Porcentual share value")
        chart_visible(required: false, type: PropertyType.Boolean, description: "If the chart is visible")
        detailsMeli_visible(required: false, type: PropertyType.Boolean, description: "If the details are visible")
        share_visible(required: false, type: PropertyType.Boolean, description: "If the share is visible")
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
    "/advertising/pads2/manager/onboarding"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/onboarding/modal"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/onboarding/steps"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/onboarding/steps/show"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/onboarding/steps/finish"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/onboarding/modal/show"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/onboarding/modal/close"(platform: "/web", type: TrackType.Event) {}

    //Generic landing
    "/advertising/pads2/landing"(platform: "/web", type: TrackType.View) {
        free_trial_ad(required: true, description: "Indicates if user is suitable for free trial")
        budget(required: true, description: "Budget related to the landing", inheritable:false)
    }

    "/advertising/pads2/landing/main_action"(platform: "/web", type: TrackType.Event) {
        button(required: true, description: "Button that redirects to confirm page")
        budget(required: true, description: "Budget related to the landing", inheritable:false)
        id(required: false, values: ["adq_pads"], description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, values: ["home_desktop"], description: "indicates the position of the main slide")
    }

    "/advertising/pads2/landing/from_main_slider"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        id(required: false, values: ["adq_pads"], description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, values: ["home_desktop"], description: "indicates the position of the main slide")
    }

    "/advertising/pads2/landing/contract_confirmation"(platform: "/web", type: TrackType.View) {
    }

    "/advertising/pads2/landing/contract_confirmation/confirm"(platform: "/web", type: TrackType.Event) {
        budget(required: true, description: "Budget related to the campaign")
        free_trial_ad(required: true, description: "Indicates if user is suitable for free trial")
        id(required: false, description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, description: "indicates the position of the main slide")
    }

    "/advertising/pads2/landing/contract_confirmation/confirmOfficialStore"(platform: "/web", type: TrackType.Event) {
        budget(required: true, description: "Budget related to the campaign")
        free_trial_ad(required: true, description: "Indicates if user is suitable for free trial")
        id(required: false, values: ["adq_pads"], description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, values: ["home_desktop"], description: "indicates the position of the main slide")
    }

    "/advertising/pads2/landing/change_budget"(platform: "/web", type: TrackType.Event) {
    }

    "/advertising/pads2/landing/contract_confirmation/change_budget"(platform: "/web", type: TrackType.Event) {
    }

    "/advertising/pads2/landing/contract_confirmation/change_budget/confirm"(platform: "/web", type: TrackType.Event) {
        budget(required: true, description: "Budget defined before hiring, it's related to the campaign")
    }

    //Upselling
    "/advertising/pads2/manager/upselling"(platform: "/", isAbstract: true) {
        budget_new(required: true, description: "New budget assigned to the user")
    }

    "/advertising/pads2/manager/upselling/banner"(platform: "/", isAbstract: true) {}
    "/advertising/pads2/manager/upselling/modal"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/upselling/modal/show"(platform: "/web", type: TrackType.View) {}

    "/advertising/pads2/manager/upselling/modal/go"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/upselling/modal/close"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/upselling/banner/show"(platform: "/web", type: TrackType.View) {}

    "/advertising/pads2/manager/upselling/banner/go"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/upselling/banner/close"(platform: "/web", type: TrackType.Event) {}

    //Generic landing free trial
    "/advertising/pads2/landing_freetrial"(platform: "/web", type: TrackType.View) {
        free_trial_type(required: true, description: "type of free trial with which the user enters the landing pads")
        budget(required: true, description: "Budget related to the landing")
    }

    "/advertising/pads2/landing_freetrial/cta"(platform: "/web", type: TrackType.Event) {
        button(required: true, description: "Button that redirects to confirm page")
        id(required: false, description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, description: "indicates the position of the main slide")
    }

    "/advertising/pads2/landing_freetrial/confirm"(platform: "/web", type: TrackType.View) {
    }

    "/advertising/pads2/landing_freetrial/confirm/cta"(platform: "/web", type: TrackType.Event) {
        id(required: false, description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, description: "indicates the position of the main slide")
    }
  
    //Lift
    "/advertising/pads2/manager/lift"(platform: "/web", isAbstract: true) {}

    "/advertising/pads2/manager/lift/details"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/details/show"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/details/hide"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/lift/chart"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/chart/show"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/chart/hide"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/lift/tooltip"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/tooltip/adv_sales"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/tooltip/meli_sales"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/tooltip/info"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/tooltip/prints"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/tooltip/clics"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/tooltip/income"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/tooltip/investment"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/tooltip/take_rate"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/lift/modal"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/modal/open"(platform: "/web", type: TrackType.Event) {
        share_value(required: true, description: "Porcentual share value")
    }
    "/advertising/pads2/manager/lift/modal/pause"(platform: "/web", type: TrackType.Event) {
        share_value(required: true, description: "Porcentual share value")
    }
    "/advertising/pads2/manager/lift/modal/continue"(platform: "/web", type: TrackType.Event) {
        share_value(required: true, description: "Porcentual share value")
    }
    "/advertising/pads2/manager/lift/modal/close"(platform: "/web", type: TrackType.Event) {
        share_value(required: true, description: "Porcentual share value")
    }
}
