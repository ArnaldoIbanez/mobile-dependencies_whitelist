package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*************************
*   WALLET HOME TRACKS   *
*************************/

tracks {

    initiative = '1074'

    def balance_definition = objectSchemaDefinitions {
        pending_balance(required: true, type: PropertyType.Boolean, description: "Unavailable balance")
        balance_histogram(required: true, type: PropertyType.Numeric, description: "Balance segmentation")
    }

    def cards_definition = objectSchemaDefinitions {
        prepaid(required: true, type: PropertyType.Boolean, description: "Unavailable balance")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of cards")
    }

    def assets_definition = objectSchemaDefinitions {}

    def credits_definition = objectSchemaDefinitions {}

    def banking_definition = objectSchemaDefinitions {
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        collapsed(required: true, type: PropertyType.Boolean, description: "If banking is collapsed")
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
        assets(required: false, type: PropertyType.Map(assets_definition), description: "The assets section information")
        credits(required: false, type: PropertyType.Map(credits_definition), description: "The credits section information")
        money_in(required: false, type: PropertyType.Map(balance_definition), description: "The balance money in section information")
    }

    def item_value_definition = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "The id of the section")
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        type(required: true, type: PropertyType.String, description: "The layout of the view")
    }
    
    def main_action_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "The id of the item")
        ordinal(type: PropertyType.Numeric, required: true, description: "The position in the section")
        has_promotion(type: PropertyType.Boolean, required: true, description: "If has a label of promotion")
        enabled(type: PropertyType.Boolean, required: true, description: "If the item is show enabled")
    }

    def main_actions_definition = objectSchemaDefinitions {
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of main actions")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(main_action_definition)), description: "The main action items information")
    }

    def realestate_definition = objectSchemaDefinitions {
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        realestates(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestate)), description: "The realestate information")
    }

    def secondary_actions_definition = objectSchemaDefinitions {
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        realestates_payers(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestate)), description: "The realestate payers information")
        realestates_sellers(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestate)), description: "The realestate sellers information")
    }

    def realestate = objectSchemaDefinitions {
        realestate_id(type: PropertyType.String, required: true, description: "The container where we show contents")
        content_id(type: PropertyType.String, required: true, description: "The identification of shown content")
        origin(type: PropertyType.String, required: false, description: "The application that returns the content")
    }

    def action = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "The container where we show contents")
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        has_promotion(type: PropertyType.Boolean, required: true, description: "The application that returns the content")
    }

    def activities_definition = objectSchemaDefinitions {
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        quantity(type: PropertyType.Numeric, required: true, description: "Quantity of activities")
        is_ftu(type: PropertyType.Boolean, required: true, description: "Whether it is an ftu or not")
        has_footer(type: PropertyType.Boolean, required: true, description: "whether it has a footer or not")
    }

    def activities_link_definition = objectSchemaDefinitions {
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
    }

    def survey_definition = objectSchemaDefinitions {
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'])
    }

    def qr_map_definition = objectSchemaDefinitions {
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        header_title(type: PropertyType.String, required: true, description: "The container header title")
        items(required: true, PropertyType.ArrayList(PropertyType.String), description: "the items recived form endpoint or cache")
        link(type: PropertyType.String, required: true, description: "The link to execute")
    }

    def discount_center_definition = objectSchemaDefinitions {
        content_type( type: PropertyType.String, required: false, values: ['partial','default','complete'] )
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(discount_center_item_definition)), description: "The discount center items information")
    }

    def discount_center_item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the item we are showing")
        blocked(type: PropertyType.Boolean, required: false, description: "If the discount is blocked or not")
        name(type: PropertyType.String, required: false, description: "The name of the discount")
        category(type: PropertyType.String, required: false, description: "The category of the discount")
        mcc(type: PropertyType.Numeric, required: false, description: "The mcc of the category of the discount")
        position(type: PropertyType.Numeric, required: false, description: "The position of the discount in the list")
        availability(type: PropertyType.String, required: false, values: ['full', 'fewleft', 'soldout', 'soldout_today'], description: "Availability status of the discount")
        level(type: PropertyType.Numeric, required: false, description: "The minimum loyalty level required for the discount")
        distance(type: PropertyType.Numeric, required: false, description: "The distance to the closest store")
        store_id(type: PropertyType.Numeric, required: false, description: "The store id of the closest store")
        amount_type(type: PropertyType.String, required: true, values: ['fixed', 'percent'], description: "The amount type")
        amount(type: PropertyType.Numeric, required: false, description: "The discount amount in fixed values")
        priority(type: PropertyType.Numeric, required: false, description: "The discount brand priority")
        collector_id(type: PropertyType.Numeric, required: false, description: "The collector_id of the campaign")
        has_logo(type: PropertyType.Boolean, required: true, description: "If the discount has a logo or not")
        coupon_used(type: PropertyType.Boolean, required: true, description: "If the coupon is used")
    }
    
    def loyalty_header_definition = objectSchemaDefinitions {
        level(type: PropertyType.Numeric, required: true, description: "The user's loyalty level")
    }

    def loyalty_section_definition = objectSchemaDefinitions {
        content_type(type: PropertyType.String, required: false, values: ['partial','default','complete'])
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        level(type: PropertyType.Numeric, required: true, description: "The user's loyalty level")
        percentage(type: PropertyType.Numeric, required: false, description: "The user's current level")
    }

    def header_definition = objectSchemaDefinitions {
        loyalty(required: false, type: PropertyType.Map(loyalty_header_definition), description: "The loyalty current info")
    }

    "/wallet/home" (platform: "/mobile", isAbstract: true) {}
    "/wallet/home/secondary_actions" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/wallet/home" (platform: "/mobile", type: TrackType.View) {}


    // Events
    "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {}
    
    // TODO: This track will be removed
    "/wallet/home/show" (platform: "/mobile", type: TrackType.Event) {
        header(required: true, type: PropertyType.String, description: "Contains the header text's home", inheritable: false)
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_value_definition)), description: "Contains the sections payload", inheritable: false)
    }

    "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
    }


    //Sections
    // TODO: This track will be removed
    "/wallet/home/show/main_actions" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        quantity(required: true, type: PropertyType.Numeric, description: "The number of main actions displayed")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(main_action_definition)), description: "The items of the view")
    }

    // TODO: This track will be removed
    "/wallet/home/show/secondary_actions" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        realestates_payers(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Secondary actions payers containers")
        realestates_sellers(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Secondary actions sellers containers")
    }

    "/wallet/home/secondary_actions/toggle" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        id(required: true, PropertyType.String, description: "the tab ID")
        quantity(required: true, PropertyType.String, description: "secondary actions quantity")
        is_showing_aware(required: true, type: PropertyType.Boolean, description: "If secondary actions is showing the aware")
        actions(type: PropertyType.ArrayList(PropertyType.Map(action)), required: true, description: "Secondaty action actions")
    }

    // TODO: This track will be removed
    "/wallet/home/show/discount_benefits" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        realestates(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Discount benefits containers")
    }

    // TODO: This track will be removed
    "/wallet/home/show/dismissible_row" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        realestates(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Dismissible row containers")
    }

    // TODO: This track will be removed
    "/wallet/home/show/cross_selling" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        realestates(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required: true, description: "Cross selling containers")
    }
    // TODO: This track will be removed
    "/wallet/home/show/banking" (platform: "/mobile", type: TrackType.Event) {
        collapsed(required: false, type: PropertyType.Boolean, description: "If banking is collapsed")
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
    }

    // TODO: This track will be removed
    "/wallet/home/show/activities" (platform: "/mobile", type: TrackType.Event) {
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of activities")
        is_ftu(required: true, type: PropertyType.Boolean, description: "If is present the FTU in activities section")
        has_footer(required: true, type: PropertyType.Boolean, description: "If has a footer")
    }

    // TODO: This track will be removed
    // Instore
    "/wallet/home/show/instore"(platform: "/mobile", isAbstract: true) {}
    "/wallet/home/show/instore/promotion"(platform: "/mobile", isAbstract: true) {}
    "/wallet/home/show/instore/promotion/generic"(platform: "/mobile", type: TrackType.Event) {
        header_title(required: true, PropertyType.String, description: "the title form endpoint or cache")
        link(required: true, PropertyType.String, description: "the deeplink recived form endpoint or cache")
        items(required: true, PropertyType.ArrayList(PropertyType.String), description: "the items recived form endpoint or cache")
        items_size(required: true, PropertyType.Numeric, description: "the size of items recived form endpoint or cache")
    }
    "/wallet/home/show/instore/promotion/qr_map"(platform: "/mobile", type: TrackType.Event) {
        header_title(required: true, PropertyType.String, description: "the title form endpoint or cache")
        link(required: true, PropertyType.String, description: "the title form endpoint or cache")
        items(required: true, PropertyType.ArrayList(PropertyType.String), description: "the items recived form endpoint or cache")
        items_size(required: true, PropertyType.Numeric, description: "the size of items recived form endpoint or cache")
    }

    "/wallet/home/banking" (platform: "/mobile", isAbstract: true) {}

    "/wallet/home/banking/initial_state" (platform: "/mobile", type: TrackType.Event) {
        collapsed(required: true, type: PropertyType.Boolean, description: "If banking is collapsed")
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
    }

    "/wallet/home/banking/collapse" (platform: "/mobile", type: TrackType.Event) {
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
    }

    "/wallet/home/banking/expand" (platform: "/mobile", type: TrackType.Event) {
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
    }

    /*************************
    * WALLET HOME TRACKS v2  *
    *************************/

    "/wallet_home" (platform: "/mobile", isAbstract: true) {}
    "/wallet_home/drawer" (platform: "/mobile", isAbstract: true) {}
    "/wallet_home/secondary_actions" (platform: "/mobile", isAbstract: true) {}
    "/wallet_home/banking" (platform: "/mobile", isAbstract: true) {}

    //Views
    "/wallet_home" (platform: "/mobile", type: TrackType.View) {}

    //Events
    "/wallet_home/pull" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
        section_id(required: true, type: PropertyType.String, description: "section where the deeplink was launched")
        component_id(required: false, type: PropertyType.String, description: "specific component id where the user tapped")
    }

    "/wallet_home/drawer/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
    }

    "/wallet_home/secondary_actions/toggle" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        id(required: true, PropertyType.String, description: "the tab ID")
        quantity(required: true, PropertyType.String, description: "secondary actions quantity")
        is_showing_aware(required: true, type: PropertyType.Boolean, description: "If secondary actions is showing the aware")
        actions(type: PropertyType.ArrayList(PropertyType.Map(action)), required: true, description: "Secondaty action actions")
    }

    "/wallet_home/banking/collapse" (platform: "/mobile", type: TrackType.Event) {
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
        assets(required: false, type: PropertyType.Map(assets_definition), description: "The assets section information")
        credits(required: false, type: PropertyType.Map(credits_definition), description: "The credits section information")
        money_in(required: false, type: PropertyType.Map(balance_definition), description: "The balance money in section information")
    }

    "/wallet_home/banking/expand" (platform: "/mobile", type: TrackType.Event) {
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
        assets(required: false, type: PropertyType.Map(assets_definition), description: "The assets section information")
        credits(required: false, type: PropertyType.Map(credits_definition), description: "The credits section information")
        money_in(required: false, type: PropertyType.Map(balance_definition), description: "The balance money in section information")
    }

    "/wallet_home/home" (platform: "/mobile", type: TrackType.View) {
        header(required: false, type: PropertyType.Map(header_definition), description: "The header information")
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
        from(required: false, type: PropertyType.String, description: "The origin path when it's opened from meli")
        banking(required: false, type: PropertyType.Map(banking_definition), description: "The banking section information")
        main_actions(required: false, type: PropertyType.Map(main_actions_definition), description: "The main actions section information")
        prepaid_banner(required: false, type: PropertyType.Map(realestate_definition), description: "The banner section information")
        secondary_actions(required: false, type: PropertyType.Map(secondary_actions_definition), description: "The secondary actions section information")
        benefits(required: false, type: PropertyType.Map(realestate_definition), description: "The benefits section information")
        cross_selling(required: false, type: PropertyType.Map(realestate_definition), description: "The cross_selling section information")
        loyalty(required: false, type: PropertyType.Map(loyalty_section_definition), description: "The loyalty section information")
        activities(required: false, type: PropertyType.Map(activities_definition), description: "The activities section information")
        qr_map(required: false, type: PropertyType.Map(qr_map_definition), description: "The qr_map section information")
        activities_link(required: false, type: PropertyType.Map(activities_link_definition), description: "The activities_link section information")
        discount_center(required: false, type: PropertyType.Map(discount_center_definition), description: "The discount_center section information")
        survey(required: false, type: PropertyType.Map(survey_definition), description: "The survey definition section information")
    }

    "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
        header(required: false, type: PropertyType.Map(header_definition), description: "The header information")
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'])
        from(required: false, type: PropertyType.String, description: "The origin path when it's opened from meli")
        banking(required: false, type: PropertyType.Map(banking_definition), description: "The banking section information")
        main_actions(required: false, type: PropertyType.Map(main_actions_definition), description: "The main actions section information")
        prepaid_banner(required: false, type: PropertyType.Map(realestate_definition), description: "The banner section information")
        secondary_actions(required: false, type: PropertyType.Map(secondary_actions_definition), description: "The secondary actions section information")
        benefits(required: false, type: PropertyType.Map(realestate_definition), description: "The benefits section information")
        cross_selling(required: false, type: PropertyType.Map(realestate_definition), description: "The cross_selling section information")
        loyalty(required: false, type: PropertyType.Map(loyalty_section_definition), description: "The loyalty section information")
        activities(required: false, type: PropertyType.Map(activities_definition), description: "The activities section information")
        qr_map(required: false, type: PropertyType.Map(qr_map_definition), description: "The qr_map section information")
        activities_link(required: false, type: PropertyType.Map(activities_link_definition), description: "The activities_link section information")
        discount_center(required: false, type: PropertyType.Map(discount_center_definition), description: "The discount_center section information")
        survey(required: false, type: PropertyType.Map(survey_definition), description: "The survey definition section information")
    }

    //Notification Center
    "/wallet_home/notification" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/notification/show" (platform: "/mobile", type: TrackType.View) {
        badge_count(required: true, type: PropertyType.Numeric, description: "The amount of notifications that's been showed in the initial load notification label icon")
    }

    "/wallet_home/notification/tap" (platform: "/mobile", type: TrackType.Event) {
        badge_count(required: true, type: PropertyType.Numeric, description: "The amount of notifications that's been showed in the notification label icon")
    }

    // Modal Mercadopago-Mercadolibre
    "/wallet_home/modal" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/modal/show" (platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "The modal's id")
    }

    "/wallet_home/modal/tap" (platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "The modal's id")
    }

    "/wallet_home/modal/close" (platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "The modal's id")
    }

    //Loyalty
    "/wallet_home/loyalty" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/loyalty/tap" (platform: "/mobile", type: TrackType.Event) {
        loyalty(required: false, type: PropertyType.Map(loyalty_header_definition), description: "The loyalty header information")
    }

    /**********************************/
    //    NEW TRACKS HOME TAP v3      //
    /**********************************/

    "/wallet_home/section" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/section/tap" (platform: "/mobile", isAbstract: true) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
        section_id(required: true, type: PropertyType.String, description: "Section where the deeplink was launched")
        component_id(required: false, type: PropertyType.String, description: "Specific component id where the user tapped")
    }

    "/wallet_home/section/tap/banking" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/main_actions" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/activities" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/activities_link" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/qr_map" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/discount_center" (platform: "/mobile", type: TrackType.Event){}

    "/wallet_home/section/tap/loyalty" (platform: "/mobile", type: TrackType.Event) {
        level(type: PropertyType.Numeric, required: true, description: "The user's loyalty level")
        percentage(type: PropertyType.Numeric, required: true, description: "The user's loyalty level percentage")
    }

    "/wallet_home/section/tap/survey" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/secondary_actions" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/cross_selling" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/prepaid_banner" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/benefits" (platform: "/mobile", type: TrackType.Event) {}
}
