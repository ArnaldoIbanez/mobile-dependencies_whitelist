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
        matching_status(
                required: false,
                values: ["matching_inversion", "matching_inversion_end", "matching_bonificacion", "matching_bonificacion_end", "matching_bonificacion_extended", "matching_bonificacion_extended_end"],
                description: "Free trial matching status bar"
        )
        multi(required: false, type: PropertyType.String, description: "Indicates if it is a multicampaign dashboard")
    }

    "/advertising/pads2/manager/box"(platform: "/web", type: TrackType.Event, isAbstract: true) {}

    "/advertising/pads2/manager/box/upselling"(platform: "/web", type: TrackType.Event) {
        version(required: false, description: "Version")
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

    "/advertising/pads2/manager/upselling/mark"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        campaign_id(required: true, description: "Id related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
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

    "/advertising/pads2/manager/catalog/edit/publication"(platform: "/web", type: TrackType.Event) {}

    //Matching
    "/advertising/pads2/manager/winbacks"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager/winbacks/onboarding"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, description: "Current budget related to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
        step(required: true, description: "Current modal step")
    }

    "/advertising/pads2/manager/winbacks/onboarding/cta"(platform: "/web", type: TrackType.Event) {
    }

    "/advertising/pads2/manager/winbacks/onboarding/cta/close"(platform: "/web", type: TrackType.Event) {
    }

    "/advertising/pads2/manager/winbacks/confirmation"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, description: "Current budget related to the campaign")
        new_budget(required: true, description: "New budget assigned to the campaign")
        status(required: true, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    "/advertising/pads2/manager/winbacks/confirmation/cta"(platform: "/web", type: TrackType.Event) {
    }

    "/advertising/pads2/manager/winbacks/confirmation/cta/close"(platform: "/web", type: TrackType.Event) {
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
        budget(required: false, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        multi(required: false, type: PropertyType.Boolean, description: "Indicates if it is a multicampaign dashboard")
    }

    //Filters
    def filters_definition = objectSchemaDefinitions {
        status(required: false, type: PropertyType.String)
        release_date(required: false, type: PropertyType.String)
        category(required: false, type: PropertyType.String)
        features(required: false, type: PropertyType.String)
        multi(required: false, type: PropertyType.String)
        query(required: false, type: PropertyType.String)
        catalog(required: false, type: PropertyType.String)
    }

    //Campaigns
    def campaigns_definition = objectSchemaDefinitions {
        campaign_id(required: true, type: PropertyType.String)
        budget(required: true, type: PropertyType.Numeric)
        status(required: true, type: PropertyType.String, values: ['active', 'paused'])
    }
    
    "/advertising/pads2/manager/filters"(
        platform: "/web",
        type: TrackType.Event) {
        filters(
                required: true,
                type: PropertyType.Map(filters_definition)
            )

        multi(required: false, type: PropertyType.String, description: "Indicates if it is a multicampaign dashboard")
        campaign_id(required: false, description: "Id related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Current budget related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
    }

    // Range
    "/advertising/pads2/manager/metrics_range"(
        platform: "/web",
        type: TrackType.Event) {
        multi(required: false, type: PropertyType.String, description: "Indicates if it is a multicampaign dashboard")
        days(required: true, type: PropertyType.Numeric)
        to(required: true, type: PropertyType.String)
        from(required: true, type: PropertyType.String)
    }

    // Massive Actions
    "/advertising/pads2/manager/massive_actions"(
        platform: "/web",
        type: TrackType.Event) {
        multi(required: false, type: PropertyType.Boolean, description: "Indicates if it is a multicampaign dashboard")
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
    "/advertising/pads2/hub"(platform: "/web", type: TrackType.View) {
        tab(required: true, description: "It could be: Campaigns or Ads tab", values: ['campaigns', 'ads'])
        campaigs(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaigns_definition)), description: "Array campaigns")
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
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Current budget related to the campaign")
        budget_new(required: true, type: PropertyType.String, description: "New budget related to the campaign.")
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
        campaign_id_from(required: true, description: "Id related to the original campaign")
        status_from(required: true, description: "Status related to the original campaign")
        campaign_id_to(required: true, description: "Id related to the destination campaign")
        status_to(required: true, description: "Status related to the destination campaign")
        check(required: true, description: "Check which indicates if all moved pads must be activated by default")
        //preguntar por mayuscula de q_Ads
        q_Ads(required: true, description: "Quantity of moved pads")
    }

    "/advertising/pads2/hub/moveads/cancel"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/hub/moveads/filters"(platform: "/web", type: TrackType.Event) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/createcampaign"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step1"(platform: "/web", type: TrackType.View) {
        //CONSULTAR SOBRE VALORES 
        campaign_name(required: false, type: PropertyType.String, description: "Name related to the campaign")
        budget(required: false, type: PropertyType.String, description: "Budget related to the campaign")
    }

    "/advertising/pads2/createcampaign/step1/next"(platform: "/web", type: TrackType.Event) {
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
    }

    "/advertising/pads2/createcampaign/step1/breadcrumb"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step1/helperbudget"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/createcampaign/step2"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
    }

    "/advertising/pads2/createcampaign/step2/createcampaign"(platform: "/web", type: TrackType.Event) {
        ads(required: true, description: "Number of ads included for new campaign")
        check_active(required: true, description: "Indicates if all included ads must be activated", values: ['true', 'false'])
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

    "/advertising/pads2/createcampaign/confirm"(platform: "/web", type: TrackType.View) {
        status_check(required: true, description: "uncheck or mark the check to create the campaign with active ads", values: ['true', 'false'])
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
        ads(required: true, type: PropertyType.Numeric, description: "Included ads in campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
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

    "/advertising/pads2/manager/addads/breadcrumb"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/addads/filters"(platform: "/web", type: TrackType.Event) {
        filters(required: true, type: PropertyType.Map(filters_definition), description: "List of applied filters")
    }

    "/advertising/pads2/manager/addads/add"(platform: "/web", type: TrackType.Event) {
        total_ads(required: true, type: PropertyType.Numeric, description: "Total ads added to the campaign")
    }

    "/advertising/pads2/manager/addads/confirm"(platform: "/web", type: TrackType.Event) {
        ads(required: true, description: "Current ads")
        new_ads(required: true, type: PropertyType.String, description: "Total ads added to the campaign" )
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
        multi(required: true, type: PropertyType.Boolean, description: "Indicates if it is a multicampaign dashboard")
        campaign_id(required: true, description: "Id related to the campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
    }

    "/advertising/pads2/manager/update/name/go"(platform: "/web", type: TrackType.Event) {
        multi(required: true, type: PropertyType.Boolean, description: "Indicates if it is a multicampaign dashboard")
        campaign_id(required: true, description: "Id related to the campaign")
        name_previous(required: true, type: PropertyType.String, description: "Previous name related to the campaign.")
        name_new(required: true, type: PropertyType.String, description: "New name related to the campaign.")
    }

    "/advertising/pads2/manager/update/name/close"(platform: "/web", type: TrackType.Event) {
        multi(required: true, type: PropertyType.Boolean, description: "Indicates if it is a multicampaign dashboard")
        campaign_id(required: true, description: "Id related to the campaign")
        campaign_name(required: true, type: PropertyType.String, description: "Name related to the campaign")
    }

    "/advertising/pads2/manager/update/budget"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/update/budget/pencil"(platform: "/web", type: TrackType.Event) {
        multi(required: true, type: PropertyType.Boolean, description: "Indicates if it is a multicampaign dashboard")
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
    }

    "/advertising/pads2/manager/update/budget/go"(platform: "/web", type: TrackType.Event) {
        multi(required: true, type: PropertyType.Boolean, description: "Indicates if it is a multicampaign dashboard")
        campaign_id(required: true, description: "Id related to the campaign")
        budget_previous(required: true, description: "Previous budget related to the campaign")
        budget_new(required: true, type: PropertyType.Numeric, description: "New budget related to the campaign.")
    }

    "/advertising/pads2/manager/update/budget/close"(platform: "/web", type: TrackType.Event) {
        multi(required: true, type: PropertyType.Boolean, description: "Indicates if it is a multicampaign dashboard")
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
    }

    //Admin Mobile

    "/advertising/pads2/manager/faqs"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        has_problem(required: true, description: "Problem related to the campaign")
        problem_type(required: true, description: "Type problem related to the campaign")
    }

    "/advertising/pads2/manager/budget"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        campaign_id(required: true, description: "Id related to the campaign")
        budget(required: true, type: PropertyType.String, description: "Budget related to the campaign")
        status(required: false, description: "Current status related to the campaign", values: ['active', 'paused'])
        suggested_budget(required: true, description: "Suggested budget related to the campaign")
    }

    "/advertising/pads2/manager/budget/suggested"(platform: "/web", type: TrackType.Event) {}

    "/advertising/pads2/manager/budget/suggested"(platform: "/web", type: TrackType.View) {}

}
