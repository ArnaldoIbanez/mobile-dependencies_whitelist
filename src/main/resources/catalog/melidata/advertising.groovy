package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1052"

    //Advertising flow
    "/advertising"(platform: "/", isAbstract: true) {}

    "/advertising/landings"(platform: "/", isAbstract: true) {}

    "/advertising/landings/pads2"(platform: "/", isAbstract: true) {}

    "/advertising/landings/pads2/mail"(platform: "/", isAbstract: true) {}

    "/advertising/landings/pads2/mail/congrats"(platform: "/", type: TrackType.View) {
        user_id(required:true, description: "User id")
        items_id(required:true, description: "Items ids")
    }

    "/advertising/communications"(platform: "/", isAbstract: true) {}

    "/advertising/communications"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "type of communication action", values: ['show', 'click'])
        source(required: true, type: PropertyType.String, description: "communication source")
        medium(required: true, type: PropertyType.String, description: "communication medium")
        campaigns(required: true, type: PropertyType.ArrayList, description: "Array of communications available for placement")
    }

    "/advertising/pads2"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/card"(platform: "/", isAbstract: true) {}
    "/advertising/pads2/manager/ssl"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
        matching_status(
                required: false,
                values: ["matching_inversion", "matching_inversion_end", "matching_bonificacion", "matching_bonificacion_end", "matching_bonificacion_extended", "matching_bonificacion_extended_end", "active", "canceled", "finished"],
                description: "Free trial matching status bar"
        )
        amount_invested(required: false, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: false, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        mode(required: false, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        has_shops(required: false, type: PropertyType.Boolean, description: "User's Shops")
        has_shops_integration(required: false, type: PropertyType.Boolean, description: "User shared Ads with Shops")
    }

    "/advertising/pads2/manager/box"(platform: "/web", type: TrackType.Event, isAbstract: true) {}

    "/advertising/pads2/manager/box/upselling"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/update_campaign_status"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, description: "Current budget related to the campaign")
        previous_status (required: true, description: "Previous status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/manager/update_campaign_budget"(platform: "/", type: TrackType.Event) {
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
    "/advertising/pads2/landing"(platform: "/", type: TrackType.View) {
        free_trial_ad(required: true, description: "Indicates if user is suitable for free trial")
        budget(required: true, description: "Budget related to the landing", inheritable:false)
        ui_version(required: false, description: "UI version rendered in Search", inheritable:false)
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
        official_stores(required: false, type: PropertyType.Boolean, description: "Indicates if the user is an official store")
        matching(required: false, type: PropertyType.Boolean, description: "Indicates if the user is matching")
        new_advertiser(required: false, type: PropertyType.Boolean, description: "Indicates if the user is a new advertiser")
        has_items(required: false, type: PropertyType.Boolean, description: "Indicates if the user has items")
        has_shops(required: false, type: PropertyType.Boolean, description: "Is Shops")
    }

    "/advertising/pads2/landing/main_action"(platform: "/", type: TrackType.Event) {
        button(required: true, description: "Button that redirects to confirm page")
        budget(required: true, description: "Budget related to the landing", inheritable:false)
        id(required: false, values: ["adq_pads"], description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, values: ["home_desktop"], description: "indicates the position of the main slide")
        free_trial_ad(required: false, description: "Indicates if user is suitable for free trial")
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
        has_shops(required: false, type: PropertyType.Boolean, description: "Is Shops")
    }

    "/advertising/pads2/landing/from_main_slider"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        id(required: false, values: ["adq_pads"], description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, values: ["home_desktop"], description: "indicates the position of the main slide")
    }

    "/advertising/pads2/landing/contract_confirmation"(platform: "/", type: TrackType.View) {
        budget(required: true, description: "Budget related to the campaign", inheritable:false)
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
        has_shops(required: false, type: PropertyType.Boolean, description: "Is Shops")
    }

    "/advertising/pads2/landing/contract_confirmation/confirm"(platform: "/", type: TrackType.Event) {
        budget(required: true, description: "Budget related to the campaign")
        free_trial_ad(required: true, description: "Indicates if user is suitable for free trial")
        id(required: false, description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, description: "indicates the position of the main slide")
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
        has_shops(required: false, type: PropertyType.Boolean, description: "Is Shops")
        has_shops_integration(required: false, type: PropertyType.Boolean, description: "Shops integration")
    }

    "/advertising/pads2/landing/contract_confirmation/confirm/sll"(platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        site_id(required: true, description: "Site of user who contract advertising")
        cust_id(required: true, type: PropertyType.Numeric, description: "User who contract advertising")
        quantity_sll(required: true, type: PropertyType.Numeric, description: "Indicates the number of items that are sll")
        quantity_no_sll(required: true, type: PropertyType.Numeric, description: "Indicates the number of items that are not sll")
        quantity_indexed_items(required: true, type: PropertyType.Numeric, description: "Indicates the number of indexed items")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        model(required: false, type: PropertyType.String, description: "Indicates the number of indexed items", values: ['bids', 'cvr'])
    }

    "/advertising/pads2/landing/contract_confirmation/confirmOfficialStore"(platform: "/", type: TrackType.Event) {
        budget(required: true, description: "Budget related to the campaign")
        free_trial_ad(required: true, description: "Indicates if user is suitable for free trial")
        id(required: false, values: ["adq_pads"], description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, values: ["home_desktop"], description: "indicates the position of the main slide")
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
    }

    "/advertising/pads2/landing/contract_confirmation/contractofficialstore"(platform: "/", type: TrackType.Event) {
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

    "/advertising/pads2/landing/modal"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/landing/modal/no_items"(platform: "/", type: TrackType.View, parentPropertiesInherited:false) {
        button(required: true, values: ["top", "bottom"], description: "Button that redirects to confirm page")
        free_trial_ad(required: false, type: PropertyType.Boolean, description: "Indicates if user is suitable for free trial")
    }

    "/advertising/pads2/landing/modal/no_items/go"(platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        button(required: true, values: ["top", "bottom"], description: "Button that redirects to confirm page")
        free_trial_ad(required: false, type: PropertyType.Boolean, description: "Indicates if user is suitable for free trial")
    }

    //Upselling
    "/advertising/pads2/manager/upselling"(platform: "/", isAbstract: true) {
        budget_new(required: false, description: "New budget assigned to the user")
    }

    "/advertising/pads2/manager/upselling/banner"(platform: "/", isAbstract: true) {}
    "/advertising/pads2/manager/upselling/modal"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/upselling/modal/show"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget_suggested(required: false, type: PropertyType.Numeric, description: "Suggested budget related to the campaign")
        budget(required: false, type: PropertyType.Numeric, description: "Current budget related to the campaign")
    }

    "/advertising/pads2/manager/upselling/modal/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget_suggested(required: false, type: PropertyType.Numeric, description: "Suggested budget related to the campaign")
        budget_selected(required: false, type: PropertyType.Numeric, description: "Selected budget related to the campaign")
        budget(required: false, type: PropertyType.Numeric, description: "Current budget related to the campaign")}

    "/advertising/pads2/manager/upselling/modal/close"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget_suggested(required: false, description: "Suggested budget related to the campaign")
        budget_selected(required: false, description: "Selected budget related to the campaign")
    }

    "/advertising/pads2/manager/upselling/banner/show"(platform: "/web", type: TrackType.View) {}

    "/advertising/pads2/manager/upselling/banner/go"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/upselling/banner/close"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/upselling/mark"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        campaign_id(required: true, description: "Id related to the campaign")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
    }

    "/advertising/pads2/manager/upselling/tooltip/go"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
    }

    "/advertising/pads2/manager/upselling/tooltip/close"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
    }

    "/advertising/pads2/manager/box"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/box/upselling"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
    }

    "/advertising/pads2/manager/upselling/tooltip"(platform: "/web", type: TrackType.Event) {}


    "/advertising/pads2/manager/box/upselling/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
    }

    //Generic landing free trial
    "/advertising/pads2/landing_freetrial"(platform: "/", type: TrackType.View) {
        free_trial_type(required: true, description: "type of free trial with which the user enters the landing pads")
        budget(required: true, description: "Budget related to the landing")
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
        official_stores(required: true, type: PropertyType.Boolean, description: "indicate if it is an official store")
    }

    "/advertising/pads2/landing_freetrial/cta"(platform: "/", type: TrackType.Event) {
        button(required: true, description: "Button that redirects to confirm page")
        id(required: false, description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, description: "indicates the position of the main slide")
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
    }

    "/advertising/pads2/landing_freetrial/confirm"(platform: "/", type: TrackType.View) {
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
    }

    "/advertising/pads2/landing_freetrial/confirm/cta"(platform: "/", type: TrackType.Event) {
        id(required: false, description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, description: "indicates the position of the main slide")
        experiment(required: false, description: "progressive rollout experiment", inheritable:false)
    }

    //Privacy
    "/advertising/privacy"(platform: "/", type: TrackType.View) {
    }

    "/advertising/privacy/modal"(platform: "/", type: TrackType.Event, isAbstract: true){
    }

    "/advertising/privacy/modal/show"(platform: "/", type: TrackType.Event) {
        switch_status(required: true, description: "Current state of switch")
    }

    "/advertising/privacy/modal/deactivate_ads"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/privacy/modal/keep_ads_active"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/privacy/modal/dismiss"(platform: "/", type: TrackType.Event) {
        switch_status(required: true, description: "Current state of switch")
    }

    "/advertising/privacy/switch"(platform: "/", type: TrackType.Event, isAbstract: true) {
    }

    "/advertising/privacy/switch/activated"(platform: "/", type: TrackType.Event) {
        switch_status(required: true, description: "Current state of switch")
    }

    // Privacy Frontend

    "/advertising/privacy/target"(platform: "/", type: TrackType.View) {
    }

    "/advertising/privacy/target/switch"(platform: "/", type: TrackType.Event, isAbstract: true) {
    }

    "/advertising/privacy/target/switch/activated"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/privacy/target/ads_desactivation_notice"(platform: "/", type: TrackType.View,) {
        switch_status(required: true, description: "Current state of switch", inheritable:false, values: ['active', 'inactive'])
    }

    "/advertising/privacy/target/ads_desactivation_notice/keep_ads_active"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/privacy/target/ads_desactivation_notice/deactivate_ads"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/privacy/target/ads_desactivation_notice/dismiss"(platform: "/", type: TrackType.Event) {
        switch_status(required: true, description: "Current state of switch", values: ['active', 'inactive'])
    }

    "/advertising/privacy/business_partners"(platform: "/", type: TrackType.View) {
    }

    "/advertising/privacy/business_partners/switch"(platform: "/", type: TrackType.Event, isAbstract: true) {
    }

    "/advertising/privacy/business_partners/switch/activated"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/privacy/business_partners/ads_desactivation_notice"(platform: "/", type: TrackType.View) {
        switch_status(required: true, description: "Current state of switch", inheritable:false, values: ['active', 'inactive'])
    }

    "/advertising/privacy/business_partners/ads_desactivation_notice/keep_ads_active"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/privacy/business_partners/ads_desactivation_notice/deactivate_ads"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/privacy/business_partners/ads_desactivation_notice/dismiss"(platform: "/", type: TrackType.Event) {
        switch_status(required: true, description: "Current state of switch", values: ['active', 'inactive'])
    }

    //Lift
    "/advertising/pads2/manager/lift"(platform: "/web", isAbstract: true ) {}

    "/advertising/pads2/manager/lift/details"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/details/show"(platform: "/", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/details/close"(platform: "/", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }

    "/advertising/pads2/manager/lift/chart"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/chart/show"(platform: "/", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/chart/close"(platform: "/", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }

    "/advertising/pads2/manager/lift/tooltip"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/tooltip/adv_sales"(platform: "/web", type: TrackType.Event ) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/tooltip/meli_sales"(platform: "/web", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/tooltip/info"(platform: "/web", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/tooltip/prints"(platform: "/web", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/tooltip/clicks"(platform: "/web", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/tooltip/income"(platform: "/web", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/tooltip/investment"(platform: "/web", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }
    "/advertising/pads2/manager/lift/tooltip/take_rate"(platform: "/web", type: TrackType.Event) {
        share_value(required: false,  description: "Porcentual share value", inheritable: true)
    }

    "/advertising/pads2/manager/lift/modal"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/modal/open"(platform: "/", type: TrackType.Event) {
        share_value(required: true, description: "Porcentual share value")
    }
    "/advertising/pads2/manager/lift/modal/pause"(platform: "/", type: TrackType.Event) {
        share_value(required: true, description: "Porcentual share value")
    }
    "/advertising/pads2/manager/lift/modal/continue"(platform: "/", type: TrackType.Event) {
        share_value(required: true, description: "Porcentual share value")
    }
    "/advertising/pads2/manager/lift/modal/close"(platform: "/", type: TrackType.Event) {
        share_value(required: true, description: "Porcentual share value")
    }

    //Card Upselling
    "/advertising/pads2/manager/card/upselling"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Current budget related to the campaign")
        budget_new(required: false, type: PropertyType.String, description: "New budget related to the campaig")
    }

    "/advertising/pads2/manager/card/upselling"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Current budget related to the campaign")
        budget_new(required: false, type: PropertyType.String, description: "New budget related to the campaig")
    }

    //SLL
    "/advertising/pads2/manager/card/sll"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/advertising/pads2/manager/card/sll"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/advertising/pads2/manager/ssl/landing"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/advertising/pads2/manager/ssl/landing/activated"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total_activated(required: false, type: PropertyType.String, description: "Indicates the number total of sll activated")
    }

    "/advertising/pads2/manager/ssl/landing/breadcrumb"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: true, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    //Budget Dynamic
    "/advertising/pads2/manager/update/budget"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
    }
    "/advertising/pads2/manager/update/budget/tooltip"(platform: "/", type: TrackType.Event) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])
    }

    "/advertising/pads2/manager/budget/edit_pencil"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])

    }
    "/advertising/pads2/manager/budget/tooltip"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])
    }
    "/advertising/pads2/manager/budget/tooltip/edit_new"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])

    }
    "/advertising/pads2/hub/budget"(platform: "/", type: TrackType.Event,parentPropertiesInherited: false) {
    }
    "/advertising/pads2/hub/budget/edit_pencil"(platform: "/", type: TrackType.Event) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])

    }


    //Buybox
    "/advertising/pads2/manager/buybox_winners"(platform: "/", isAbstract: true) {}
    "/advertising/pads2/manager/buybox_winners/landing"(platform: "/", isAbstract: true) {}
    "/advertising/pads2/manager/catalog"(platform: "/", isAbstract: true) {}
    "/advertising/pads2/manager/catalog/edit"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/card/buy_box_winner"(platform: "/web", type: TrackType.View) {
        winners_suggested(required: true, description: "Paused buybox winner ads suggested to activate")
        campaign_id(required: false, description: "Id related to the campaign")
    }

    "/advertising/pads2/manager/card/buybox_landing"(platform: "/web",type: TrackType.View) {
        winners_suggested(required: true, description: "Paused buybox winner ads viewed in landing")
        campaign_id(required: true, description: "Id related to the campaign")
    }

    "/advertising/pads2/manager/card/buybox_landing/activated"(platform: "/web", type: TrackType.Event) {
        winners_suggested(required: true, description: "Paused buybox winner ads viewed in landing")
        winners_activated(required: false, type: PropertyType.String, description: "Activated buybox winner ads through landing")
        campaign_id(required: true, description: "Id related to the campaign")
    }

    "/advertising/pads2/manager/buybox_winners/landing/breadcrumb"(platform: "/web", type: TrackType.Event){
        winners_suggested(required: true, description: "Paused buybox winner ads viewed in landing")
        campaign_id(required: true, description: "Id related to the campaign")
    }

    "/advertising/pads2/manager/catalog/edit/publication"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        ad_id(required: true, description: "Id related to pad")
        ad_status(required: true, description: "Current status related to the pad", values: ['active', 'paused'])
    }

    //Matching
    "/advertising/pads2/manager/winbacks"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/winbacks/onboarding"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, description: "Current budget related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        step(required: true, description: "Current modal step")
    }

    "/advertising/pads2/manager/winbacks/onboarding/cta"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/pads2/manager/winbacks/onboarding/cta/close"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/pads2/manager/winbacks/confirmation"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, description: "Current budget related to the campaign")
        new_budget(required: true, description: "New budget assigned to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/manager/winbacks/confirmation/cta"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/pads2/manager/winbacks/confirmation/cta/close"(platform: "/", type: TrackType.Event) {
    }

    //Credits
    "/advertising/pads2/manager/credits"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode(
                required: true, type: PropertyType.String,
                values: ["AUTOMATIC", "CUSTOM", "MONO_CAMPAIGN", "NONE"],
                description: "User mode, custom, automatic or mono")
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: true, type: PropertyType.String, description: "Campaign status (active, paused)")
        available_credit(required: true, type: PropertyType.Numeric, description: "Amount of credit available to spend")
        close_duedate(required: false, type: PropertyType.Boolean, description: "indicates if warning of credits due to expire is displayed")
    }

    "/advertising/pads2/manager/credits/go"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/credits/details"(platform: "/", type: TrackType.View) {
        used_credit(required: true, description:"Amount that has already been consumed")
    }

    "/advertising/pads2/manager/credits/download"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode(
                required: true, type: PropertyType.String,
                values: ["AUTOMATIC", "CUSTOM", "MONO_CAMPAIGN", "NONE"],
                description: "User mode, custom, automatic or mono")
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }

    "/advertising/pads2/manager/credits/duedate_tooltip"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode(
                required: true, type: PropertyType.String,
                values: ["AUTOMATIC", "CUSTOM", "MONO_CAMPAIGN", "NONE"],
                description: "User mode, custom, automatic or mono")
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }

    "/advertising/pads2/hub/credits"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode(
                required: true, type: PropertyType.String,
                values: ["AUTOMATIC", "CUSTOM", "MONO_CAMPAIGN", "NONE"],
                description: "User mode, custom, automatic or mono")
        available_credit(required: true, type: PropertyType.Numeric, description: "Amount of credit available to spend")
        close_duedate(required: false, type: PropertyType.Boolean, description: "indicates if warning of credits due to expire is displayed")
    }

    "/advertising/pads2/hub/credits/go"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/hub/credits/details"(platform: "/", type: TrackType.View) {
        used_credit(required: true, type: PropertyType.Numeric, description: "Amount that has already been consumed")
    }

    "/advertising/pads2/hub/credits/download"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode(
                required: true, type: PropertyType.String,
                values: ["AUTOMATIC", "CUSTOM", "MONO_CAMPAIGN", "NONE"],
                description: "User mode, custom, automatic or mono")
    }

    "/advertising/pads2/hub/credits/duedate_tooltip"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode(
                required: true, type: PropertyType.String,
                values: ["AUTOMATIC", "CUSTOM", "MONO_CAMPAIGN", "NONE"],
                description: "User mode, custom, automatic or mono")
    }

    //Sorting
    "/advertising/pads2/manager/sort"(
            platform: "/",
            type: TrackType.Event) {
        sort_by(
                required: true,
                description: "Sort column id"
        )
        sort_value(
                required: true,
                values: ["asc", "desc"],
                description: "Sort direction"
        )
        campaign_id(required: false, description: "Id related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        mode(required: false, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    //Filters
    def filters_definition = objectSchemaDefinitions {
        status(required: false, type: PropertyType.String)
        release_date(required: false, type: PropertyType.String)
        category(required: false, type: PropertyType.String)
        features(required: false, type: PropertyType.String)
        mode(required: false, type: PropertyType.String)
        query(required: false, type: PropertyType.String)
        catalog(required: false, type: PropertyType.String)
        // Successful Live Listing
        sll(required: false, type: PropertyType.String)
        // Item Publish Date
        date_created(required: false, type: PropertyType.String)
    }

    //Campaigns
    def campaigns_definition = objectSchemaDefinitions {
        campaign_id(required: true, type: PropertyType.Numeric)
        budget(required: true, type: PropertyType.Numeric)
        status(required: true, type: PropertyType.String, values: ['active', 'paused'])
    }

    def campaigns_budget_definition = objectSchemaDefinitions {
        campaign_id(required: true, type: PropertyType.Numeric)
        budget_old(required: true, type: PropertyType.Numeric)
        budget_new(required: true, type: PropertyType.Numeric)
    }

    //Campaigns paused
    def campaigns_paused = objectSchemaDefinitions {
        campaign_id(required: true, type: PropertyType.Numeric)
        pads(required: true, type: PropertyType.Numeric)
    }

    def campaigns_bidding = objectSchemaDefinitions {
        campaign_id(required: true, type: PropertyType.Numeric)
        strategy(required: true, type: PropertyType.String)
        trtarget(required: true, type: PropertyType.Numeric)
    }

    "/advertising/pads2/manager/filters"(
            platform: "/",
            type: TrackType.Event) {
        filters(
                required: true,
                type: PropertyType.Map(filters_definition)
        )

        mode(required: false, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: false, description: "Id related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    // Range
    "/advertising/pads2/manager/metrics_range"(
            platform: "/",
            type: TrackType.Event) {
        campaign_id(required: false, description: "Id related to the campaign")
        mode(required: false, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        days(required: true, type: PropertyType.Numeric)
        to(required: true, type: PropertyType.String)
        from(required: true, type: PropertyType.String)
    }

    // Massive Actions
    "/advertising/pads2/manager/massive_actions"(
            platform: "/web",
            type: TrackType.Event) {
        mode(required: false, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        action(required: true, type: PropertyType.String)
        total_items(required: true, type: PropertyType.Numeric)
    }

    // SortFilters Modal
    "/advertising/pads2/manager/sort_filters"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/sort_filters/modal"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/sort_filters/modal/show"(
            platform: "/web",
            type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }
    "/advertising/pads2/manager/sort_filters/modal/confirm"(
            platform: "/web",
            type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        step(required: true, type: PropertyType.Numeric , description: "Current modal step")
    }
    "/advertising/pads2/manager/sort_filters/modal/next_step"(
            platform: "/web",
            type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        step(required: true, type: PropertyType.Numeric , description: "Current modal step")
    }
    "/advertising/pads2/manager/sort_filters/modal/prev_step"(
            platform: "/web",
            type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        step(required: true, type: PropertyType.Numeric , description: "Current modal step")
    }
    "/advertising/pads2/manager/sort_filters/modal/show_later"(
            platform: "/web",
            type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        step(required: true, type: PropertyType.Numeric , description: "Current modal step")
    }

    // Multicampaña
    "/advertising/pads2/hub"(platform: "/", type: TrackType.View) {
        tab(required: true, description: "It could be: Campaigns or Ads tab", values: ['campaigns', 'ads'])
        campaigns(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_definition)), description: "Array campaigns")
        has_shops(required: false, type: PropertyType.Boolean, description: "User's Shops")
        has_shops_integration(required: false, type: PropertyType.Boolean, description: "User shared Ads with Shops")
        matching_status(
                required: false,
                values: ["matching_inversion", "matching_inversion_end", "matching_bonificacion", "matching_bonificacion_end", "matching_bonificacion_extended", "matching_bonificacion_extended_end", "active", "canceled", "finished"],
                description: "Free trial matching status bar"
        )
        amount_invested(required: false, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: false, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
    }

    "/advertising/pads2/hub/createcampaign"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        tab(required: true, description: "It could be: Campaigns or Ads tab", values: ['campaigns', 'ads'])
    }

    "/advertising/pads2/hub/campaign"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/campaign/update"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/campaign/update/name"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/campaign/update/name/pencil"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/campaign/update/name/go"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        name_new(required: true, type: PropertyType.String, description: "New name related to the campaign.")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/campaign/update/name/close"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        name_new(required: false, type: PropertyType.String, description: "New name related to the campaign.")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/campaign/update/budget"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/campaign/update/budget/pencil"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/campaign/update/budget/go"(
            platform: "/web",
            type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        budget(required: true, description: "Current budget related to the campaign")
        budget_new(required: true, description: "New budget related to the campaign.")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/campaign/update/budget/close"(
            platform: "/web",
            type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Current budget related to the campaign")
        budget_new(required: false, type: PropertyType.String, description: "New budget related to the campaign.")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/metrics_range"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        tab(required: true, description: "It could be: Campaigns or Ads tab", values: ['campaigns', 'ads'])
        days(required: true, type: PropertyType.Numeric)
        from(required: true, type: PropertyType.String, description: "from related to the campaign")
        to(required: true, description: "to related to the campaign")
    }

    "/advertising/pads2/hub/massive_actions"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        //"consultar sobre valores de action"
        action(required: true, type: PropertyType.String, description: "It could be activate, pause, move or create campaign")
        total_items(required: true, type: PropertyType.Numeric, description: "Indicates total of items")
    }

    "/advertising/pads2/hub/filters"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/hub/moveads"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/moveads/go"(platform: "/web", type: TrackType.Event) {
        check(required: true, description: "Check which indicates if all moved pads must be activated by default")
        q_ads(required: true, description: "Quantity of moved pads")
    }

    "/advertising/pads2/hub/moveads/cancel"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/moveads/filters"(platform: "/web", type: TrackType.Event) {
        query(required: true, type:PropertyType.String , description: "Indicates the query searched by the user")
    }

    "/advertising/pads2/createcampaign"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step1"(platform: "/", type: TrackType.View) {
        //CONSULTAR SOBRE VALORES 
        campaign_name(required: false, type: PropertyType.String, description: "Name related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Budget related to the campaign")
    }

    "/advertising/pads2/createcampaign/step1/next"(platform: "/", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        //BIDDING
        strategy(required: false, type: PropertyType.String, description: "Campaign Strategy")
    }

    "/advertising/pads2/createcampaign/step1/breadcrumb"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step1/helperbudget"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step2"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        //BIDDING
        strategy(required: false, type: PropertyType.String, description: "Campaign Strategy")
    }

    "/advertising/pads2/createcampaign/step2/createcampaign"(platform: "/", type: TrackType.Event) {
        ads(required: true, description: "Number of ads included for new campaign")
        check_active(required: true, description: "Indicates if all included ads must be activated", values: ['true', 'false'])
        //BIDDING
        trtarget(required: false, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/createcampaign/step2/breadcrumb"(platform: "/web", type: TrackType.Event) {
        ads(required: true, description: "Number of ads included for new campaign")
        check_active(required: true, description: "Indicates if all included ads must be activated", values: ['true', 'false'])
    }

    "/advertising/pads2/createcampaign/step2/helperbudget"(platform: "/web", type: TrackType.Event) {
        ads(required: true, description: "Number of ads included for new campaign")
        check_active(required: true, description: "Indicates if all included ads must be activated", values: ['true', 'false'])
    }

    "/advertising/pads2/createcampaign/step2/update"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/createcampaign/step2/update/name"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step2/update/name/pencil"(platform: "/web", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
    }

    "/advertising/pads2/createcampaign/step2/update/name/go"(platform: "/web", type: TrackType.Event) {
        name_previous(required: true, type: PropertyType.String, description: "Previous name related to the campaign.")
        name_new(required: true, type: PropertyType.String, description: "New name related to the campaign.")
    }

    "/advertising/pads2/createcampaign/step2/update/name/close"(platform: "/web", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
    }

    "/advertising/pads2/createcampaign/step2/update/budget"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step2/update/budget/pencil"(platform: "/web", type: TrackType.Event) {
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
    }

    "/advertising/pads2/createcampaign/step2/update/budget/go"(platform: "/web", type: TrackType.Event) {
        budget_previous(required: true, type: PropertyType.String, description: "Previous budget related to the campaign.")
        budget_new(required: true, type: PropertyType.String, description: "New budget related to the campaign.")
    }

    "/advertising/pads2/createcampaign/step2/update/budget/close"(platform: "/web", type: TrackType.Event) {
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
    }

    "/advertising/pads2/createcampaign/step2/addads"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads")
    }

    "/advertising/pads2/createcampaign/step2/filters"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/createcampaign/step2/editads"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step2/editads/deleteall"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        total_ads_deleted(required: true, type: PropertyType.Numeric, description: "Deleted ads number from the basket")
    }

    "/advertising/pads2/createcampaign/step2/editads/filters"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/createcampaign/step2/editads/delete"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        ad_id(type: PropertyType.String, required: true, description: "Id of deleted ad from the basket")
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/createcampaign/step2/editads/cancel"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads in basket")
        total_ads_deleted(required: true, type: PropertyType.Numeric, description: "Total deleted ads number from the basket")
    }

    "/advertising/pads2/createcampaign/step2/editads/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads in basket")
        total_ads_deleted(required: true, type: PropertyType.Numeric, description: "Total deleted ads number from the basket")
    }

    "/advertising/pads2/createcampaign/step2/editads/undo"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        ad_id(required: true, type: PropertyType.String, description: "Deleted ad id")
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/createcampaign/step2/activeads"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        status_check(required: true, description: "uncheck or mark the check to create the campaign with active ads", values: ['true', 'false'])
    }

    "/advertising/pads2/createcampaign/confirm"(platform: "/", type: TrackType.View) {
        status_check(required: true, description: "uncheck or mark the check to create the campaign with active ads", values: ['true', 'false'])
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        ads(required: true, type: PropertyType.Numeric, description: "Included ads in campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
        //BIDDING
        strategy(required: false, type: PropertyType.String, description: "Campaign Strategy")
        trtarget(required: false, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/createcampaign/seecampaign"(platform: "/web", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
        ads(required: true, type: PropertyType.Numeric, description: "Included ads in campaign")
    }

    "/advertising/pads2/createcampaign/gocampaign"(platform: "/web", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
        ads(required: true, type: PropertyType.Numeric, description: "Included ads in campaign")
    }

    "/advertising/pads2/manager/addads"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
    }
    "/advertising/pads2/manager/addads/budget"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/manager/addads/budget/tooltip"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])
    }
    "/advertising/pads2/manager/addads/breadcrumb"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/addads/filters"(platform: "/web", type: TrackType.Event) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/manager/addads/add"(platform: "/web", type: TrackType.Event) {
        total_ads(required: true, type: PropertyType.Numeric, description: "Total ads added to the campaign")
    }

    "/advertising/pads2/manager/addads/confirm"(platform: "/web", type: TrackType.Event) {
        ads(required: true, description: "Current ads")
        new_ads(required: true, type: PropertyType.Numeric, description: "Total ads added to the campaign" )
    }

    "/advertising/pads2/manager/addads/editads"(platform: "/web", type: TrackType.Event) {
        ads(required: true, description: "Current ads")
        new_ads(required: true, type: PropertyType.String, description: "Total ads added to the campaign" )
    }

    "/advertising/pads2/manager/addads/editads/deleteall"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        total_ads_deleted(required: true, type: PropertyType.Numeric, description: "Deleted ads number from the basket")
    }

    "/advertising/pads2/manager/addads/editads/filters"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/manager/addads/editads/delete"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        ad_id(type: PropertyType.String, required: true, description: "Identify the displayed ad")
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/manager/addads/editads/cancel"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads")
        total_ads_deleted(required: true, type: PropertyType.Numeric, description: "Deleted ads number from the basket")
    }

    "/advertising/pads2/manager/addads/editads/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads")
        total_ads_deleted(required: true, type: PropertyType.Numeric, description: "Deleted ads number from the basket")
    }

    "/advertising/pads2/manager/addads/editads/undo"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        ad_id(type: PropertyType.String, required: true, description: "Identify the displayed ad")
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/manager/update"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/manager/update/name"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/update/name/pencil"(platform: "/web", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, description: "Id related to the campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
    }

    "/advertising/pads2/manager/update/name/go"(platform: "/web", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, description: "Id related to the campaign")
        name_previous(required: true, type: PropertyType.String, description: "Previous name related to the campaign.")
        name_new(required: true, type: PropertyType.String, description: "New name related to the campaign.")
    }

    "/advertising/pads2/manager/update/name/close"(platform: "/web", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, description: "Id related to the campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
    }

    "/advertising/pads2/manager/update/budget"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/update/budget/pencil"(platform: "/web", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
    }

    "/advertising/pads2/manager/update/budget/go"(platform: "/", type: TrackType.Event) {
        mode(required: false, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, description: "Id related to the campaign")
        budget_previous(required: false, description: "Previous budget related to the campaign")
        budget_new(required: true, description: "New budget related to the campaign.")
        budget(required: true, description: "budget related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])
        budget_pct_new(required: true, description: "budget pct new Modal campaign")
        budget_type_new(required: true, description: "budget type new  F  or  D Modal campaign",values: ['D', 'F'])
        budget_pct_old(required: true, description: " budget pct old Modal campaign")


    }

    "/advertising/pads2/manager/update/budget/close"(platform: "/", type: TrackType.Event) {
        mode(required: false, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, description: "Budget related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])
    }

    // Multicampaña - Sads New

    "/advertising/pads2/hub/card"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/card/sads_new"(platform: "/web", type: TrackType.View) {
        tab(required: true, type: PropertyType.String, description: "Indicates the tab from where the track is sent")
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll ads without campaign")
    }

    "/advertising/pads2/hub/card/sads_new/go"(platform: "/web", type: TrackType.Event) {
        tab(required: true, type: PropertyType.String, description: "Indicates the tab from where the track is sent")
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll ads without campaign")
    }

    "/advertising/pads2/hub/sads_new"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/sads_new/landing"(platform: "/web", type: TrackType.View) {
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll ads without campaign")
    }

    "/advertising/pads2/hub/sads_new/createcampaign"(platform: "/web", type: TrackType.Event) {
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll ads without campaign")
        sads_selected(required: true, type: PropertyType.Numeric, description: "Number of sads selected to create a campaign")
    }

    "/advertising/pads2/hub/sads_new/moveads"(platform: "/web", type: TrackType.Event) {
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll ads without campaign")
        sads_selected(required: true, type: PropertyType.Numeric, description: "Number of sads selected to be moved")
    }

    "/advertising/pads2/hub/sads_new/filters"(platform: "/web", type: TrackType.Event) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/hub/sads_new/moveads/go"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        check(required: true, type: PropertyType.Boolean, description: "Indicates if the ads selected will be activated when moved")
        q_ads(required: true, type: PropertyType.Numeric, description: "Number of sads selected to be moved")
    }

    "/advertising/pads2/hub/sads_new/moveads/cancel"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/sads_new/moveads/filters"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        query(required: true, type:PropertyType.String , description: "Indicates the query searched by the user")
    }

    // Multicampaña - Sads paused

    "/advertising/pads2/hub/card/sads_paused"(platform: "/", type:TrackType.View){
        tab(required: true, type: PropertyType.String, description: "Indicates the tab from where the track is sent")
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll ads without campaign")
    }

    "/advertising/pads2/hub/card/sads_paused/go"(platform: "/", type:TrackType.Event){
        tab(required: true, type: PropertyType.String, description: "Indicates the tab from where the track is sent")
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll paused ads")
    }

    "/advertising/pads2/hub/sads_paused"(platform: "/web", type:TrackType.View, parentPropertiesInherited: false){}

    "/advertising/pads2/hub/sads_paused/landing"(platform: "/", type:TrackType.View, parentPropertiesInherited: false){
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll paused ads")
        campaigns(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_paused)), description: "Array campaign")
    }

    "/advertising/pads2/hub/sads_paused/landing/activated"(platform: "/", type:TrackType.Event, parentPropertiesInherited: false){
        sads_activated(required: true, type: PropertyType.Numeric, description: "Number  Sads to active")
        campaigns(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_paused)), description: "Array campaign")
    }

    "/advertising/pads2/hub/sads_paused/landing/breadcrumb"(platform: "/web", type:TrackType.Event, parentPropertiesInherited: false){
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll paused ads")
        campaigns(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_paused)), description: "Array campaign")
    }

    "/advertising/pads2/hub/sads_paused/landing/see_campaign"(platform: "/", type:TrackType.Event, parentPropertiesInherited: false){
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll paused ads")
    }

    "/advertising/pads2/sads_paused"(platform: "/web", type:TrackType.Event){}

    "/advertising/pads2/sads_paused/landing"(platform: "/web", type:TrackType.View){
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll paused ads")
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
    }

    "/advertising/pads2/sads_paused/landing/activated"(platform: "/web", type:TrackType.Event){
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll paused ads")
        sads_total_activated(required: true, type: PropertyType.Numeric, description: "Indicates the number total of sads activated")
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
    }

    "/advertising/pads2/sads_paused/landing/breadcrumb"(platform: "/web", type:TrackType.Event){
        sads_total(required: true, type: PropertyType.Numeric, description: "Number of sll paused ads")
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
    }

    "/advertising/pads2/sads_paused/landing/filters"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    // Multicampaña - Upselling

    "/advertising/pads2/hub/upselling"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget of the campaign")
        status(required: true, type: PropertyType.String, description: "Current status of the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/upselling/tooltip"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/upselling/tooltip/show"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget of the campaign")
        status(required: true, type: PropertyType.String, description: "Current status of the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/upselling/tooltip/close"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget of the campaign")
        status(required: true, type: PropertyType.String, description: "Current status of the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/upselling/tooltip/go"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget of the campaign")
        status(required: true, type: PropertyType.String, description: "Current status of the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/upselling/modal"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/upselling/modal/show"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget of the campaign")
        status(required: true, type: PropertyType.String, description: "Current status of the campaign", values: ['active', 'paused'])
        budget_suggested(required: true, type: PropertyType.Numeric, description: "Upselling budget suggested for the campaign")
    }

    "/advertising/pads2/hub/upselling/modal/close"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget of the campaign")
        status(required: true, type: PropertyType.String, description: "Current status of the campaign", values: ['active', 'paused'])
        budget_suggested(required: true, type: PropertyType.Numeric, description: "Upselling budget suggested for the campaign")
    }

    "/advertising/pads2/hub/upselling/modal/go"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget of the campaign")
        status(required: true, type: PropertyType.String, description: "Current status of the campaign", values: ['active', 'paused'])
        budget_suggested(required: true, type: PropertyType.Numeric, description: "Upselling budget suggested for the campaign")
        budget_selected(required: true, type: PropertyType.Numeric, description: "Upselling budget selected for the campaign")
    }

    "/advertising/pads2/manager/box/upselling/close"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id of the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget of the campaign")
        status(required: true, type: PropertyType.String, description: "Current status of the campaign", values: ['active', 'paused'])
    }

    // Multicampaña - Upselling x Campaigns

    "/advertising/pads2/hub/box"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/hub/box/upselling"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        total_campaigns(required: true, type: PropertyType.Numeric, description: "Number of total campaigns")
    }

    "/advertising/pads2/hub/box/upselling/go"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        total_campaigns(required: true, type: PropertyType.Numeric, description: "Number of total campaigns")
    }

    "/advertising/pads2/hub/box/upselling/close"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        total_campaigns(required: true, type: PropertyType.Numeric, description: "Number of total campaigns")
    }

    "/advertising/pads2/hub/upselling/landing"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        total_campaigns(required: true, type: PropertyType.Numeric, description: "Number of total campaigns")
        campaigns(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_budget_definition)), description: "Array campaigns")
    }

    "/advertising/pads2/hub/upselling/landing/breadcrumb"(platform: "/", type: TrackType.Event) {
        total_campaigns(required: true, type: PropertyType.Numeric, description: "Number of total campaigns")
        campaigns(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_budget_definition)), description: "Array campaigns")
    }


    "/advertising/pads2/hub/upselling/landing/go"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        total_campaigns(required: true, type: PropertyType.Numeric, description: "Number of total campaigns")
        campaigns(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_budget_definition)), description: "Array campaigns")
    }

    // Multicampaña - Winbacks

    "/advertising/pads2/hub/winbacks"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/winbacks/modal"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/winbacks/modal/show"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: true, type: PropertyType.String, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, type: PropertyType.Numeric, description: "Current budget related to the campaign")
        step(required: true, type: PropertyType.Numeric, description: "Current modal step")
    }

    "/advertising/pads2/hub/winbacks/modal/go"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: true, type: PropertyType.String, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, type: PropertyType.Numeric, description: "Current budget related to the campaign")
        step(required: true, type: PropertyType.Numeric, description: "Current modal step")
    }

    "/advertising/pads2/hub/winbacks/modal/close"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: true, type: PropertyType.String, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: true, type: PropertyType.Numeric, description: "Current budget related to the campaign")
        step(required: true, type: PropertyType.Numeric, description: "Current modal step")
    }

    "/advertising/pads2/hub/winbacks/confirmation"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/winbacks/confirmation/show"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Current budget related to the campaign")
        new_budget(required: true, type: PropertyType.Numeric, description: "New budget assigned to the campaign")
        status(required: true, type: PropertyType.String, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/winbacks/confirmation/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Current budget related to the campaign")
        new_budget(required: true, type: PropertyType.Numeric, description: "New budget assigned to the campaign")
        status(required: true, type: PropertyType.String, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/winbacks/confirmation/close"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Current budget related to the campaign")
        new_budget(required: true, type: PropertyType.Numeric, description: "New budget assigned to the campaign")
        status(required: true, type: PropertyType.String, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/hub/winbacks/createcampaign"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/winbacks/createcampaign/show"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/winbacks/createcampaign/go"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/winbacks/pause"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/winbacks/pause/show"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/winbacks/pause/go"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/winbacks/pause/close"(platform: "/web", type: TrackType.Event) {}


    //Admin Mobile

    "/advertising/pads2/manager/faqs"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        has_problem(required: true, type: PropertyType.Boolean, description: "Problem related to the campaign")
        problem_type(required: true, description: "Type problem related to the campaign")
    }

    "/advertising/pads2/manager/budget"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        suggested_budget(required: true, description: "Suggested budget related to the campaign")
    }

    "/advertising/pads2/manager/budget/suggested"(platform: "/", type: TrackType.Event) {}

    // Operation Traces

    "/advertising/pads2/manager/traces"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        action(required: true, type: PropertyType.String, description: "Action performed")
        owner_id(required: true, type: PropertyType.Numeric, description: "Owner user id")
        collaborator_id(required: false, type: PropertyType.Numeric, description: "Collaborator user id, if available")
        is_collaborator(required: true, type: PropertyType.Boolean, description: "User is collaborator")
        quantity(required: false, type: PropertyType.Numeric, description: "Quantity associated with event, if available")
        previous_value(required: false, type: PropertyType.String, description: "Previous value associated with event, if available")
        next_value(required: false, type: PropertyType.String, description: "Next value associated with event, if available")
        campaign_id(required: false, type: PropertyType.Numeric, description: "Campaing id, if available")
    }

    // Bidding Create Campaign

    "/advertising/pads2/createcampaign/strategy"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {}

    "/advertising/pads2/createcampaign/strategy/next"(platform: "/", type: TrackType.Event) {
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
    }
    "/advertising/pads2/createcampaign/strategy/breadcrumb"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/createcampaign/step1/helper"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/advertising/pads2/createcampaign/step1/helper/trtarget"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/createcampaign/step1/helper/strategy"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/createcampaign/step2/trtarget"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/createcampaign/step2/trtarget/pencil"(platform: "/", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/createcampaign/step2/modal"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/advertising/pads2/createcampaign/step2/modal/bidding"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget/changestrategy"(platform: "/", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/createcampaign/step2/modal/bidding/strategy"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step2/modal/bidding/strategy/show"(platform: "/", type: TrackType.View) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/createcampaign/step2/modal/bidding/strategy/helper"(platform: "/", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
    }

    "/advertising/pads2/createcampaign/step2/modal/bidding/strategy/go"(platform: "/", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy_previous(required: true, type: PropertyType.String, description: "Previous selected strategy")
        strategy_new(required: true, type: PropertyType.String, description: "New selected strategy")
    }

    "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget/show"(platform: "/", type: TrackType.View) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget/helper"(platform: "/", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/createcampaign/step2/modal/bidding/impact"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step2/modal/bidding/impact/helper"(platform: "/", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/createcampaign/step2/modal/bidding/trtarget/go"(platform: "/", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget_previous(required: true, type: PropertyType.Numeric, description: "Previous selected Take Rate")
        trtarget_new(required: true, type: PropertyType.Numeric, description: "New selected Take Rate")
    }

    //Bidding HUB

    "/advertising/pads2/hub/onboarding"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {}
    "/advertising/pads2/hub/onboarding/bidding"(platform: "/", type: TrackType.View) {}

    "/advertising/pads2/hub/onboarding/bidding/show"(platform: "/", type: TrackType.View) {}
    "/advertising/pads2/hub/onboarding/bidding/go"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/hub/tooltip"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/advertising/pads2/hub/tooltip/bidding"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/hub/tooltip/bidding/objective"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/hub/tooltip/bidding/show"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }
    "/advertising/pads2/hub/tooltip/bidding/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }

    "/advertising/pads2/hub/modal"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {}
    "/advertising/pads2/hub/modal/bidding"(platform: "/", type: TrackType.View) {}
    "/advertising/pads2/hub/modal/bidding/strategy"(platform: "/", type: TrackType.View) {}

    "/advertising/pads2/hub/modal/bidding/strategy/show"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }
    "/advertising/pads2/hub/modal/bidding/strategy/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy_previous(required: true, type: PropertyType.String, description: "Previous selected strategy")
        strategy_new(required: true, type: PropertyType.String, description: "New selected strategy")
    }
    "/advertising/pads2/hub/modal/bidding/strategy/helper"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }

    "/advertising/pads2/hub/modal/bidding/trtarget"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/modal/bidding/trtarget/show"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }
    "/advertising/pads2/hub/modal/bidding/trtarget/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget_previous(required: true, type: PropertyType.Numeric, description: "Previous selected Take Rate")
        trtarget_new(required: true, type: PropertyType.Numeric, description: "New selected Take Rate")
    }
    "/advertising/pads2/hub/modal/bidding/trtarget/helper"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }
    "/advertising/pads2/hub/modal/bidding/trtarget/helper/takerate"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }
    "/advertising/pads2/hub/modal/bidding/trtarget/helper/impact"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }
    "/advertising/pads2/hub/modal/bidding/trtarget/changestrategy"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/hub/update"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/advertising/pads2/hub/update/bidding"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/hub/update/bidding/trtarget"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/hub/update/budget"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/hub/update/budget/go"(platform: "/", type: TrackType.Event) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])
        budget_new(required: true, description: " new budget campaign Modal campaign")
        budget_pct_new(required: true, description: "budget pct new Modal campaign")
        budget_type_new(required: true, description: "budget type new  F  or  D Modal campaign",values: ['D', 'F'])
        budget_pct_old(required: true, description: " budget pct old Modal campaign")
        mode(required: false, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])

    }
    "/advertising/pads2/hub/update/budget/close"(platform: "/", type: TrackType.Event) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])

    }
    "/advertising/pads2/hub/update/budget/tooltip"(platform: "/web", type: TrackType.Event) {
        budget(required: true, description: "current budget related to the campaign")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_type(required: true, description: "Budget type related to the Modal campaign",values: ['D', 'F'])
    }

    "/advertising/pads2/hub/update/bidding/trtarget/pencil"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/hub/modal/bidding/warning"(platform: "/", type: TrackType.View) {}

    "/advertising/pads2/hub/modal/bidding/warning/changetime"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Current campaign strategy")
        trtarget(required: true, type: PropertyType.Numeric, description: "Current campaign take rate")
        days_since_modif(required: true, type: PropertyType.Numeric, description: "Number of days since last campaign modification")
    }


    "/advertising/pads2/hub/modal/bidding/warning/changetime/show"(platform: "/", type: TrackType.View) {
    }

    "/advertising/pads2/hub/modal/bidding/warning/changetime/stay"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/pads2/hub/modal/bidding/warning/changetime/change"(platform: "/", type: TrackType.Event) {
    }

    //Bidding Dashboard

    "/advertising/pads2/manager/bidding"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/advertising/pads2/manager/bidding/strategy"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/bidding/strategy/helper"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/manager/bidding/trtarget"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/bidding/trtarget/pencil"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/manager/modal"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/advertising/pads2/manager/modal/bidding"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/manager/modal/bidding/strategy"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/modal/bidding/strategy/show"(platform: "/", type: TrackType.View) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }
    "/advertising/pads2/manager/modal/bidding/strategy/go"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy_previous(required: true, type: PropertyType.String, description: "Previous selected strategy")
        strategy_new(required: true, type: PropertyType.String, description: "New selected strategy")
    }
    "/advertising/pads2/manager/modal/bidding/strategy/helper"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
    }

    "/advertising/pads2/manager/modal/bidding/trtarget"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/modal/bidding/trtarget/show"(platform: "/", type: TrackType.View) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }
    "/advertising/pads2/manager/modal/bidding/trtarget/go"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget_previous(required: true, type: PropertyType.Numeric, description: "Previous selected Take Rate")
        trtarget_new(required: true, type: PropertyType.Numeric, description: "New selected Take Rate")
    }
    "/advertising/pads2/manager/modal/bidding/trtarget/helper"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }
    "/advertising/pads2/manager/modal/bidding/trtarget/helper/takerate"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/manager/modal/bidding/trtarget/helper/impact"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/manager/modal/bidding/impact"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/modal/bidding/impact/helper"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }
    "/advertising/pads2/manager/modal/bidding/trtarget/changestrategy"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/manager/modal/bidding/warning"(platform: "/", type: TrackType.View) {}

    "/advertising/pads2/manager/modal/bidding/warning/changetime"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Current campaign strategy")
        trtarget(required: true, type: PropertyType.Numeric, description: "Current campaign take rate")
        days_since_modif(required: true, type: PropertyType.Numeric, description: "Number of days since last campaign modification")
    }


    "/advertising/pads2/manager/modal/bidding/warning/changetime/show"(platform: "/", type: TrackType.View) {
    }

    "/advertising/pads2/manager/modal/bidding/warning/changetime/stay"(platform: "/", type: TrackType.Event) {
    }

    "/advertising/pads2/manager/modal/bidding/warning/changetime/change"(platform: "/", type: TrackType.Event) {
    }

    // Bidding - Opportunities (HUB)

    "/advertising/pads2/hub/bidding"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){}
    "/advertising/pads2/hub/bidding/upgrade"(platform: "/", type: TrackType.Event){}
    "/advertising/pads2/hub/bidding/upgrade/row"(platform: "/", type: TrackType.Event){}

    "/advertising/pads2/hub/bidding/upgrade/row/show"(platform: "/", type: TrackType.View) {
        total_campaigns(required: true, type: PropertyType.Numeric, description: "Number of total campaigns")
        campaigns(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_bidding)), description: "Array campaign")
    }

    "/advertising/pads2/hub/bidding/upgrade/row/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/hub/bidding/upgrade/tooltip"(platform: "/", type: TrackType.Event){}

    "/advertising/pads2/hub/bidding/upgrade/tooltip/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/hub/bidding/upgrade/modal"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/hub/bidding/upgrade/modal/show"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget_previous(required: true, type: PropertyType.Numeric, description: "Previous selected Take Rate")
        trtarget_new(required: true, type: PropertyType.Numeric, description: "New selected Take Rate")
    }

    "/advertising/pads2/hub/bidding/upgrade/modal/go"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget_previous(required: true, type: PropertyType.Numeric, description: "Previous selected Take Rate")
        trtarget_new(required: true, type: PropertyType.Numeric, description: "New selected Take Rate")
    }

    // Bidding Opportunities (Dahsboard)

    "/advertising/pads2/manager/bidding/upgrade"(platform: "/", type: TrackType.Event) {}
    "/advertising/pads2/manager/bidding/upgrade/box"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/bidding/upgrade/box/show"(platform: "/", type: TrackType.View) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/manager/bidding/upgrade/box/go"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget(required: true, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/manager/bidding/upgrade/modal"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/manager/bidding/upgrade/modal/show"(platform: "/", type: TrackType.View) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget_previous(required: true, type: PropertyType.Numeric, description: "Previous selected Take Rate")
        trtarget_new(required: true, type: PropertyType.Numeric, description: "New selected Take Rate")
    }

    "/advertising/pads2/manager/bidding/upgrade/modal/go"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        strategy(required: true, type: PropertyType.String, description: "Strategy selected")
        trtarget_previous(required: true, type: PropertyType.Numeric, description: "Previous selected Take Rate")
        trtarget_new(required: true, type: PropertyType.Numeric, description: "New selected Take Rate")
    }

    // Ads from adserver

    def merchdata = objectSchemaDefinitions {
        content_id(type: PropertyType.String, required: true,  description: "content id")
        component_id(type: PropertyType.String, required: true,  description: "realestate id")
        audience(type: PropertyType.String, required: true, description: "audience for the content")
        bu(type: PropertyType.String, required: true, description: "business unit for the content")
        bu_line(type: PropertyType.String, required: true, description: "vertical for the content")
        flow(type: PropertyType.String, required: true, description: "flow for the content")
        logic(type: PropertyType.String, required: true, description: "logic of the content")
        position(type: PropertyType.Numeric, required: false, description: "position in array of the content")
    }

    "/advertising/adserver"(platform: "/", isAbstract: true) {}
    "/advertising/adserver/ads"(platform: "/", isAbstract: true) {}
    "/advertising/adserver/ads/view"(platform: "/", type: TrackType.View) {
        c_id (required: true, description: "component id")
        c_event (required: true, description: "trigger event")
        c_category (required: true, description: "category for the content")
        c_original_target (required: false, description: "target url or deeplink for the component")
        merch_data (required:false, type: PropertyType.Map(merchdata), description: "data from merch engine")
    }

    // Campaign Transition

    "/advertising/pads2/hub/faqs"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/configuration"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        has_shops(required: false, type: PropertyType.Boolean, description: "Is Shops")
        has_shops_integration(required: false, type: PropertyType.Boolean, description: "Shops integration")
    }

    "/advertising/pads2/configuration/mode"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/configuration/mode/change"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/configuration/mode/details"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status (required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        strategy(required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: false, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: false, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        ads_active (required: false, type: PropertyType.Numeric, description: "Active ads in this campaign transition")
        ads_deleted (required: false, type: PropertyType.Numeric, description: "Deleted ads in this campaign transition")
    }

    "/advertising/pads2/configuration/mode/details/next"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status (required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        strategy(required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: false, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: false, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        ads_active (required: false, type: PropertyType.Numeric, description: "Active ads in this campaign transition")
        ads_deleted (required: false, type: PropertyType.Numeric, description: "Deleted ads in this campaign transition")
    }

    "/advertising/pads2/configuration/mode/confirmation"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status (required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        strategy(required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: false, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: false, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        total_ads(required: false, type: PropertyType.Numeric, description: "Indicates total of ads")
    }

    "/advertising/pads2/configuration/mode/confirmation/cta"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status (required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        strategy(required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: false, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: false, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        total_ads(required: false, type: PropertyType.Numeric, description: "Indicates total of ads")
    }

    "/advertising/pads2/configuration/mode/confirmation/create_campaign"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['custom'])
    }

    "/advertising/pads2/configuration/emptystate"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
    }

    "/advertising/pads2/configuration/mode/strategy"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/configuration/mode/strategy/next"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
    }

    "/advertising/pads2/configuration/mode/settings"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
    }

    "/advertising/pads2/configuration/mode/settings/next"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/configuration/mode/addads"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
    }

    "/advertising/pads2/configuration/mode/addads/add"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads")
    }

    "/advertising/pads2/configuration/mode/addads/editads"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads")
    }

    "/advertising/pads2/configuration/mode/addads/editads/confirm"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads")
        total_ads_deleted(required: true, type: PropertyType.Numeric, description: "Indicates total of ads deleted")
    }

    "/advertising/pads2/configuration/mode/addads/confirm"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        total_ads(required: true, type: PropertyType.Numeric, description: "Indicates total of ads")
    }

    "/advertising/pads2/configuration/mode/details/showads"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode_previous (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        mode_new (required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        strategy (required: false, type: PropertyType.String, description: "Strategy selected")
        campaign_name (required: true, type: PropertyType.String, description: "Current name related to the campaign")
        budget (required: true, type: PropertyType.Numeric, description: "Budget related to the campaign")
        trtarget (required: false, type: PropertyType.Numeric, description: "Take Rate selected")
        ads_active (required: true, type: PropertyType.Numeric, description: "Active ads in this campaign transition")
        ads_deleted (required: true, type: PropertyType.Numeric, description: "Deleted ads in this campaign transition")
    }

    "/advertising/pads2/manager/auto"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/auto/modal"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/auto/modal/show"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/manager/auto/modal/close"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/manager/auto/modal/go"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['custom', 'automatic'])
        campaign_id (required: false, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/manager/addads/create_campaign"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['automatic'])
    }

    "/advertising/pads2/manager/addads/create_campaign/modal"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
    }

    "/advertising/pads2/manager/addads/create_campaign/modal/close"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
    }

    "/advertising/pads2/manager/addads/create_campaign/modal/go"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        mode(required: true, type: PropertyType.String, description: "mode of transition", values: ['automatic'])
    }

    //Data transparency
    "/advertising/pads2/reports"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String,  description: "user mode", values: ['custom', 'automatic'])
        type(required: false, type: PropertyType.String,  description: "Report type", values: ['unselected','pads_report', 'campaigns_report', 'sales_report'])
        days(required: false, type: PropertyType.String,  description: "Days Quantity", values: ['7_days','15_days', '30_days', '60_days', '90_days','custom'] )
        from(required: false, type: PropertyType.String,  description: "Date when the report data starts")
        to(required: false, type: PropertyType.String,  description: "Date when the report data ends")
        group_by(required: false, type: PropertyType.String,  description: "Data grouped by", values: ['monthly', 'total', 'daily', 'weekly'])
        filters(required: false, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/reports/range"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        days(required: false, type: PropertyType.String,  description: "Days Quantity", values: ['7_days','15_days', '30_days', '60_days', '90_days','custom'] )
        from(required: false, type: PropertyType.String,  description: "Date when the report data starts")
        to(required: false, type: PropertyType.String,  description: "Date when the report data ends")
        type(required: true, type: PropertyType.String, description: "report type", values: ['unselected', 'pads_report', 'campaigns_report', 'sales_report'])
    }

    "/advertising/pads2/reports/group"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        group_by(required: false, type: PropertyType.String,  description: "Data grouped by", values: ['monthly', 'total', 'daily', 'weekly'])
        type(required: true, type: PropertyType.String, description: "report type", values: ['unselected', 'pads_report', 'campaigns_report', 'sales_report'])
    }

    "/advertising/pads2/reports/filters"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        filters(required: false, type: PropertyType.Map(filters_definition), description: "List of applied filters")
        type(required: true, type: PropertyType.String, description: "report type", values: ['unselected', 'pads_report', 'campaigns_report', 'sales_report'])
    }

    "/advertising/pads2/reports/rows_warning"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        rows(required: false, type: PropertyType.Numeric,  description: "Number of data rows in report 0 - 10.000")
        type(required: true, type: PropertyType.String, description: "report type", values: ['unselected', 'pads_report', 'campaigns_report', 'sales_report'])
    }

    "/advertising/pads2/reports/create"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        mode(required: true, type: PropertyType.String,  description: "user mode", values: ['custom', 'automatic'])
        type(required: false, type: PropertyType.String,  description: "Report type", values: ['unselected', 'pads_report', 'campaigns_report', 'sales_report'])
        days(required: false, type: PropertyType.String,  description: "Days Quantity", values: ['7_days','15_days', '30_days', '60_days', '90_days','custom'] )
        from(required: false, type: PropertyType.String,  description: "Date when the report data starts")
        to(required: false, type: PropertyType.String,  description: "Date when the report data ends")
        group_by(required: false, type: PropertyType.String,  description: "Data grouped by", values: ['monthly', 'total', 'daily', 'weekly'])
        filters(required: false, type: PropertyType.Map(filters_definition), description: "List of applied filters")
        rows(required: false, type: PropertyType.Numeric,  description: "Number of data rows in report 0 - 10.000")
    }

    "/advertising/pads2/reports/confirmation"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        type(required: true, type: PropertyType.String, description: "report type", values: ['unselected', 'pads_report', 'campaigns_report', 'sales_report'])
    }

    "/advertising/pads2/reports/empty_state"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
    }

    "/advertising/pads2/reports/download"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        status(required: false, type: PropertyType.String,  description: "Report download status", values: ['success', 'fail'])
        type(required: true, type: PropertyType.String, description: "report type", values: ['unselected', 'pads_report', 'campaigns_report', 'sales_report'])
    }

    "/advertising/pads2/reports/delete_text_filter"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        text_filter(required: false, type: PropertyType.String, description: "Search text")
    }

    "/advertising/pads2/reports/return_manager"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/manager/report"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        filters(required: false, type: PropertyType.Map(filters_definition), description: "List of applied filters")
        days(required: false, type: PropertyType.String,  description: "Days Quantity", values: ['7_days','15_days', '30_days', '60_days', '90_days','custom'] )
        from(required: false, type: PropertyType.String,  description: "Date when the report data starts")
        to(required: false, type: PropertyType.String,  description: "Date when the report data ends")
    }

    // notifications - restriction - hub

    "/advertising/pads2/hub/restrictions"(platform: "/", type: TrackType.Event, isAbstract: true, parentPropertiesInherited: false) {
    }

    "/advertising/pads2/hub/restrictions/show"(platform: "/", type: TrackType.View) {
        types(required: true, type: PropertyType.ArrayList, description: "Array of errors from index policy")
    }

    "/advertising/pads2/hub/restrictions/paycheck"(platform: "/", type: TrackType.Event, isAbstract: true) {
    }

    "/advertising/pads2/hub/restrictions/paycheck/go"(platform: "/", type: TrackType.Event) {
        types(required: true, type: PropertyType.ArrayList, description: "Array of errors from index policy")
    }

    // notifications - restriction - dashboard

    "/advertising/pads2/manager/restrictions"(platform: "/", type: TrackType.Event, isAbstract: true, parentPropertiesInherited: false) {
    }

    "/advertising/pads2/manager/restrictions/show"(platform: "/", type: TrackType.View) {
        types(required: true, type: PropertyType.ArrayList, description: "Array of errors from index policy")
        cpg_campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }

    "/advertising/pads2/manager/restrictions/paycheck"(platform: "/", type: TrackType.Event, isAbstract: true) {
    }

    "/advertising/pads2/manager/restrictions/paycheck/go"(platform: "/", type: TrackType.Event) {
        types(required: true, type: PropertyType.ArrayList, description: "Array of errors from index policy")
        cpg_campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }


    /*
        Shops - Opt-in
     */

    "/advertising/pads2/configuration/shops"(platform: "/", type: TrackType.Event) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/configuration/shops/integration_status"(platform: "/", type: TrackType.Event) {
        previous_status(required: true, type: PropertyType.Boolean, description: "Previus status")
    }

    "/advertising/pads2/configuration/shops/help"(platform: "/", type: TrackType.Event) {
        has_shops(required: true, type: PropertyType.Boolean, description: "Is Shops")
        has_shops_integration(required: true, type: PropertyType.Boolean, description: "Shops integration")
    }

    "/advertising/pads2/configuration/shops/create"(platform: "/", type: TrackType.Event) {
    }

    /*
        Shops - Card
    */
    "/advertising/pads2/card"(platform: "/", isAbstract: true) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/card/shops"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/card/shops/show"(platform: "/", type: TrackType.View) {}

    "/advertising/pads2/card/shops/go"(platform: "/", type: TrackType.Event) {}

    /*
        Shops - Tooltips
     */
    "/advertising/pads2/tooltip"(platform: "/", isAbstract: true) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/tooltip/shops"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/tooltip/shops"(platform: "/", type: TrackType.View) {
        mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/tooltip/shops/show"(platform: "/", type: TrackType.View) {}

    "/advertising/pads2/tooltip/shops/go"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/landing/contract_confirmation/shops/update_integration_status"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        previous_status(required: true, type: PropertyType.Boolean, description: "Previus status")
    }


    // Matching Benefit Tracks
    // Pause Modal

    "/advertising/pads2/manager/matching/pause_modal/open"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        matching_start_date(required: true, type: PropertyType.String, description: "Date when Benefit matching did start")
        days_since_matching_start(required: true, type: PropertyType.Numeric, description: "Amount of days since matching benefit start date")
        amount_invested(required: true, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: true, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        adv_management_mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/manager/matching/pause_modal/close"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        matching_start_date(required: true, type: PropertyType.String, description: "Date when Benefit matching did start")
        days_since_matching_start(required: true, type: PropertyType.Numeric, description: "Amount of days since matching benefit start date")
        amount_invested(required: true, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: true, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        adv_management_mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/manager/matching/pause_modal/continue"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        matching_start_date(required: true, type: PropertyType.String, description: "Date when Benefit matching did start")
        days_since_matching_start(required: true, type: PropertyType.Numeric, description: "Amount of days since matching benefit start date")
        amount_invested(required: true, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: true, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        adv_management_mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/manager/matching/pause_modal/pause"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        matching_start_date(required: true, type: PropertyType.String, description: "Date when Benefit matching did start")
        days_since_matching_start(required: true, type: PropertyType.Numeric, description: "Amount of days since matching benefit start date")
        amount_invested(required: true, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: true, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        adv_management_mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/hub/matching/pause_modal/open"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        matching_start_date(required: true, type: PropertyType.String, description: "Date when Benefit matching did start")
        days_since_matching_start(required: true, type: PropertyType.Numeric, description: "Amount of days since matching benefit start date")
        amount_invested(required: true, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: true, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        adv_management_mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/hub/matching/pause_modal/close"(platform: "/", type: TrackType.Event,parentPropertiesInherited: false) {
        matching_start_date(required: true, type: PropertyType.String, description: "Date when Benefit matching did start")
        days_since_matching_start(required: true, type: PropertyType.Numeric, description: "Amount of days since matching benefit start date")
        amount_invested(required: true, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: true, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        adv_management_mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/hub/matching/pause_modal/continue"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        matching_start_date(required: true, type: PropertyType.String, description: "Date when Benefit matching did start")
        days_since_matching_start(required: true, type: PropertyType.Numeric, description: "Amount of days since matching benefit start date")
        amount_invested(required: true, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: true, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        adv_management_mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    "/advertising/pads2/hub/matching/pause_modal/pause"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        matching_start_date(required: true, type: PropertyType.String, description: "Date when Benefit matching did start")
        days_since_matching_start(required: true, type: PropertyType.Numeric, description: "Amount of days since matching benefit start date")
        amount_invested(required: true, type: PropertyType.Numeric, description: "Invested Budget Amount for matching benefit")
        matching_target_amount(required: true, type: PropertyType.Numeric, description: "Target Amount for matching benefit")
        adv_management_mode(required: true, type: PropertyType.String, description: "user mode", values: ['custom', 'automatic'])
    }

    //Buybox Modal

    "/advertising/pads2/hub/bb_campaign/modal"(platform: "/", type: TrackType.View, parentPropertiesInherited: false, isAbstract: true) {
        acos(required: true, type: PropertyType.Numeric, description: "ACOS related to the new campaign")
        bb_quantity(required: true, type: PropertyType.Numeric, description: "Buybox quantity items related to the new campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the new campaign")
        credit(required: true, type: PropertyType.Numeric, description: "Amount of credit available to spend")
    }

    "/advertising/pads2/hub/bb_campaign/modal/open"(platform: "/", type: TrackType.View) {}

    "/advertising/pads2/hub/bb_campaign/modal/continue"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/hub/bb_campaign/modal/close"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/hub/bb_campaign/modal/bb_quantity_tooltip"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/advertising/pads2/hub/bb_campaign/modal/budget_tooltip"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    //Buybox Card

    "/advertising/pads2/hub/card/bb_campaign"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        credit(required: true, type: PropertyType.Numeric, description: "Amount of credit available to spend")
    }

    "/advertising/pads2/hub/card/bb_campaign/go"(platform: "/", type: TrackType.Event) {}

    //Buybox Congrats

    "/advertising/pads2/hub/bb_campaign"(platform: "/", type: TrackType.View, parentPropertiesInherited: false, isAbstract: true) {
        bb_quantity(required: true, type: PropertyType.Numeric, description: "Buybox quantity items related to the new campaign")
        campaign_id(required: true, type: PropertyType.Numeric, description: "Id related to the campaign")
    }

    "/advertising/pads2/hub/bb_campaign/congrats"(platform: "/", type: TrackType.View) {
        acos(required: true, type: PropertyType.Numeric, description: "ACOS related to the new campaign")
        budget(required: true, type: PropertyType.Numeric, description: "Budget related to the new campaign")
        credit(required: true, type: PropertyType.Numeric, description: "Amount of credit available to spend")
    }

    "/advertising/pads2/hub/bb_campaign/view_ads"(platform: "/", type: TrackType.Event) {}

    "/advertising/pads2/hub/bb_campaign/view_campaign"(platform: "/", type: TrackType.Event) {}

}
