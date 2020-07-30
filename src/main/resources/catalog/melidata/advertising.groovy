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

    "/advertising/landings/pads2/mail/congrats"(platform: "/web", type: TrackType.View) {
        user_id(required:true, description: "User id")
        items_id(required:true, description: "Items ids")
    }

    "/advertising/pads2"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/card"(platform: "/", isAbstract: true) {}
    "/advertising/pads2/manager/ssl"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager"(platform: "/web", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
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
        ui_version(required: false, description: "UI version rendered in Search", inheritable:false)
    }

    "/advertising/pads2/landing/main_action"(platform: "/web", type: TrackType.Event) {
        button(required: true, description: "Button that redirects to confirm page")
        budget(required: true, description: "Budget related to the landing", inheritable:false)
        id(required: false, values: ["adq_pads"], description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, values: ["home_desktop"], description: "indicates the position of the main slide")
        free_trial_ad(required: false, description: "Indicates if user is suitable for free trial")
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

    "/advertising/pads2/manager/upselling/modal/show"(platform: "/web", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        multi (required: true, description: "Indicates if it is a multicampaign dashboard")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget_suggested(required: false, description: "Suggested budget related to the campaign")
        budget(required: false, description: "Current budget related to the campaign")
        version(required: false, description: "Version")
        
    }

    "/advertising/pads2/manager/upselling/modal/go"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        multi (required: true, description: "Indicates if it is a multicampaign dashboard")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget_suggested(required: false, description: "Suggested budget related to the campaign")
        budget_selected(required: false, description: "Selected budget related to the campaign")
        budget(required: false, description: "Current budget related to the campaign")
        version(required: false, description: "Version")
    }

    "/advertising/pads2/manager/upselling/modal/close"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        multi (required: true, description: "Indicates if it is a multicampaign dashboard")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget_suggested(required: false, description: "Suggested budget related to the campaign")
        budget_selected(required: false, description: "Selected budget related to the campaign")
        budget(required: false, description: "Current budget related to the campaign")
    }

    "/advertising/pads2/manager/upselling/banner/show"(platform: "/web", type: TrackType.View) {}

    "/advertising/pads2/manager/upselling/banner/go"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/upselling/banner/close"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/upselling/mark"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        campaign_id(required: true, description: "Id related to the campaign")
        multi (required: true, description: "Indicates if it is a multicampaign dashboard")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
        version(required: false, description: "Version")
    }

    "/advertising/pads2/manager/upselling/tooltip/go"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        multi (required: true, description: "Indicates if it is a multicampaign dashboard")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
        version(required: false, description: "Version")
    }

    "/advertising/pads2/manager/upselling/tooltip/close"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        multi (required: true, description: "Indicates if it is a multicampaign dashboard")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
        version(required: false, description: "Version")
    }

    "/advertising/pads2/manager/box"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/box/upselling"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/upselling/tooltip"(platform: "/web", type: TrackType.Event) {}


    "/advertising/pads2/manager/box/upselling/go"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        multi (required: true, description: "Indicates if it is a multicampaign dashboard")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        budget(required: false, description: "Current budget related to the campaign")
        version(required: false, description: "Version")
    }

    //Generic landing free trial
    "/advertising/pads2/landing_freetrial"(platform: "/web", type: TrackType.View) {
        free_trial_type(required: true, description: "type of free trial with which the user enters the landing pads")
        budget(required: true, description: "Budget related to the landing")
    }

    "/advertising/pads2/landing_freetrial/cta"(platform: "/web", type: TrackType.Event) {
        button(required: true, description: "Button that redirects to confirm page")
        id(required: false, description: "Indicates if the user was redirected to the landing using the main slide of the home")
        position(required: false, description: "indicates the position of the main slide")
        free_trial_type(required: true, description: "type of free trial with which the user enters the landing pads")
        budget(required: false, description: "Budget related to the landing")
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
    "/advertising/pads2/manager/lift/details/close"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/lift/chart"(platform: "/web", isAbstract: true) {}
    "/advertising/pads2/manager/lift/chart/show"(platform: "/web", type: TrackType.Event) {}
    "/advertising/pads2/manager/lift/chart/close"(platform: "/web", type: TrackType.Event) {}

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

    //Card Upselling
    "/advertising/pads2/manager/card/upselling"(platform: "/web", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Current budget related to the campaign")
        budget_new(required: false, type: PropertyType.String, description: "New budget related to the campaig")
    }

    "/advertising/pads2/manager/card/upselling"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Current budget related to the campaign")
        budget_new(required: false, type: PropertyType.String, description: "New budget related to the campaig")
    }

    //SLL
    "/advertising/pads2/manager/card/sll"(platform: "/web", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/advertising/pads2/manager/card/sll"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/advertising/pads2/manager/ssl/landing"(platform: "/web", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/advertising/pads2/manager/ssl/landing/activated"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total_activated(required: false, type: PropertyType.String, description: "Indicates the number total of sll activated")
    }

    "/advertising/pads2/manager/ssl/landing/breadcrumb"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: true, type: PropertyType.String, description: "Indicates the number total of sll")

    }

    //Sorting
    "/advertising/pads2/manager/sort"(
        platform: "/web",
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
    }

    //Filters
    def filters_definition = objectSchemaDefinitions {
        status(required: false, type: PropertyType.String)
        release_date(required: false, type: PropertyType.String)
        category(required: false, type: PropertyType.String)
        features(required: false, type: PropertyType.String)
        query(required: false, type: PropertyType.String)
    }

    "/advertising/pads2/manager/filters"(
        platform: "/web",
        type: TrackType.Event) {
        filters(
                required: true,
                type: PropertyType.Map(filters_definition)
            )
    }

    //Landings Deals
    "/deals"(platform: "/", isAbstract: true) {}

    "/deals/landing"(platform: "/") {
        deal_id(required: false, type: PropertyType.String)
        deal_print_id(required: false, type: PropertyType.String)
    }

    // Range
    "/advertising/pads2/manager/metrics_range"(
        platform: "/web",
        type: TrackType.Event) {
        days(required: true, type: PropertyType.Numeric)
        to(required: true, type: PropertyType.String)
        from(required: true, type: PropertyType.String)
    }

    // Massive Actions
    "/advertising/pads2/manager/massive_actions"(
        platform: "/web",
        type: TrackType.Event) {
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

}
