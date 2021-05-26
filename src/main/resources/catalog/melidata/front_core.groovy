package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**************************************************************
 * CONTACT: In case of changes over this file, please send us
 *  a message to our e-mail: front_native_devs@mercadolibre.com
 **************************************************************/

/*************************
 *   WALLET HOME TRACKS   *
 *************************/

tracks {

    initiative = '1074'
    propertyDefinitions {
        section_id(required: false, type: PropertyType.String, description: "Section ID")
        link(required: false, type: PropertyType.String, description: "deeplink to execute")
        component_id(required: true, type: PropertyType.String, description: "Component ID")
        action_id(required: false, type: PropertyType.String, description: "The action executed")
        audience(required: true, type: PropertyType.String, description: "The audience of the user that saw the content")
        bu(required: true, type: PropertyType.String, description: "The business unit: MP or ML")
        bu_line(required: true, type: PropertyType.String, description: "The business unit related to the content - Ex: Point")
        content_id(required: true, type: PropertyType.String, description: "Identifier for the unique content shown")
        flow(required: true, type: PropertyType.String, description: "The flow related to the content - Ex: cellphone_recharge")
        logic(required: true, type: PropertyType.String, description: "Origin of the content - Ex: priority_messages")
        position(required: false, type: PropertyType.Numeric, description: "Position starting at 1 where it was shown")
    }
    propertyGroups {
        walletHomeMerchEngineFields(
            section_id, link, component_id, action_id, audience, bu, bu_line, content_id, flow, logic, position
        )
    }

    def balance_definition = objectSchemaDefinitions {
        pending_balance(required: true, type: PropertyType.Boolean, description: "Unavailable balance")
        balance_histogram(required: true, type: PropertyType.Numeric, description: "Balance segmentation")
    }

    def cards_definition = objectSchemaDefinitions {
        prepaid(required: true, type: PropertyType.Boolean, description: "Unavailable balance")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of cards")
        debit(required: false, type: PropertyType.Boolean, description: "If the card debit is present in the cards row")
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

    def banking_v2_definition = objectSchemaDefinitions {
        hidden(required: true, type: PropertyType.Boolean, description: "hidden status")
    }

    def credits_home_definition = objectSchemaDefinitions {}    

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

    def repentance_button_definition = objectSchemaDefinitions {
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
        items(required: false, type: PropertyType.ArrayList(PropertyType.Map(discount_center_item_definition)), description: "The discount center items information")
    }

    def paragraph_definition = objectSchemaDefinitions {
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'] )
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
    }

    def complaints_book_definition = objectSchemaDefinitions {
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        content_type( type: PropertyType.String, required: true, values: ['partial','default','complete'])
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

    def metadata_user_definition = objectSchemaDefinitions {
        type(type: PropertyType.String, required: true, values: ['payer', 'seller', 'newbie'], description: "The user profile")
    }

    def loyalty_section_definition = objectSchemaDefinitions {
        content_type(type: PropertyType.String, required: false, values: ['partial','default','complete'])
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        level(type: PropertyType.Numeric, required: true, description: "The user's loyalty level")
        percentage(type: PropertyType.Numeric, required: false, description: "The user's current level")
    }

    def subscription_section_definition = objectSchemaDefinitions {
        content_type(type: PropertyType.String, required: false, values: ['partial','default','complete'])
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        level(type: PropertyType.Numeric, required: true, description: "The user's loyalty level")
        partner(type: PropertyType.String, required: true, description: "Subscription Partner")
       
    }

    def shortcuts_section_definition = objectSchemaDefinitions {
        content_type(type: PropertyType.String, required: true, values: ['partial', 'default', 'complete'])
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        favorite_ids(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The list of favorite ids")
        shortcut_ids(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The list of shortcut ids")
        has_view_more(required: true, type: PropertyType.Boolean, description: "If has view more shortcut")
        has_view_more_ripple(required: false, type: PropertyType.Boolean, description: "If has view more ripple animation")
    }

    def header_definition = objectSchemaDefinitions {
        link(required: false, type: PropertyType.String, description: "If header is tapeable")
        button_link(required: false, type: PropertyType.String, description: "If button is present")
        loyalty(required: false, type: PropertyType.Map(loyalty_header_definition), description: "The loyalty current info") // TODO: Will be deprecated for newer versions
        metadata_user(required: false, type: PropertyType.Map(metadata_user_definition), description: "The user metadata")
    }

    def metadata_definition = objectSchemaDefinitions {
        accessibility_voice(required: false, type: PropertyType.Boolean, description: "If the accessibility voice assistant is activated or not")
    }

    "/wallet/home" (platform: "/mobile", isAbstract: true) {}
    "/home_wallet/drawer" (platform: "/mobile", isAbstract: true) {}
    "/wallet/home/secondary_actions" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/wallet/home" (platform: "/mobile", type: TrackType.View) {}
    "/home_wallet" (platform: "/mobile", type: TrackType.View) {}

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

    "/home_wallet/drawer/tap" (platform: "/mobile", type: TrackType.Event) {
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

    "/wallet_home" (platform: "/mobile") {
        metadata_user(required: false, type: PropertyType.Map(metadata_user_definition), description: "The user metadata")
    }
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

    "/wallet_home/secondary_actions/toggle" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: true) {
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
        content_type(required: true, type: PropertyType.String, values: ['partial','default','complete'])
        from(required: false, type: PropertyType.String, description: "The origin path when it's opened from meli")
        banking(required: false, type: PropertyType.Map(banking_definition), description: "The banking section information")
        banking_v2(required: false, type: PropertyType.Map(banking_v2_definition), description: "The banking v2 section information")
        credits(required: false, type: PropertyType.Map(credits_home_definition), description: "The credits section information")
        main_actions(required: false, type: PropertyType.Map(main_actions_definition), description: "The main actions section information")
        shortcuts(required: false, type: PropertyType.Map(shortcuts_section_definition), description: "The shortcuts section information")
        prepaid_banner(required: false, type: PropertyType.Map(realestate_definition), description: "The banner section information")
        secondary_actions(required: false, type: PropertyType.Map(secondary_actions_definition), description: "The secondary actions section information")
        benefits(required: false, type: PropertyType.Map(realestate_definition), description: "The benefits section information")
        cross_selling(required: false, type: PropertyType.Map(realestate_definition), description: "The cross_selling section information")
        ads_top_banner(required: false, type: PropertyType.Map(realestate_definition), description: "The advertising section information")
        loyalty(required: false, type: PropertyType.Map(loyalty_section_definition), description: "The loyalty section information")
        subscription(required: false, type: PropertyType.Map(subscription_section_definition), description: "The subscription section")
        activities(required: false, type: PropertyType.Map(activities_definition), description: "The activities section information")
        qr_map(required: false, type: PropertyType.Map(qr_map_definition), description: "The qr_map section information")
        activities_link(required: false, type: PropertyType.Map(activities_link_definition), description: "The activities_link section information")
        discount_center(required: false, type: PropertyType.Map(discount_center_definition), description: "The discount_center section information")
        survey(required: false, type: PropertyType.Map(survey_definition), description: "The survey definition section information")
        repentance_button(required: false, type: PropertyType.Map(repentance_button_definition), description: "The repentance button definition section information")
        bcra_regulation(required: false, type: PropertyType.Map(paragraph_definition), description: "The section that show only text")
        ifpe_regulation(required: false, type: PropertyType.Map(paragraph_definition), description: "The section that show only text")
        complaints_book(required: false, type: PropertyType.Map(complaints_book_definition), description: "The complaints book section information")
        metadata(required: false, type: PropertyType.Map(metadata_definition), description: "this tracking section will contain multiple information about the user metadata(location, accessibility, info, etc)")
    }

    "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
        header(required: false, type: PropertyType.Map(header_definition), description: "The header information")
        content_type(required: true, type: PropertyType.String, values: ['partial','default','complete'])
        from(required: false, type: PropertyType.String, description: "The origin path when it's opened from meli")
        banking(required: false, type: PropertyType.Map(banking_definition), description: "The banking section information")
        banking_v2(required: false, type: PropertyType.Map(banking_v2_definition), description: "The banking v2 section information")
        credits(required: false, type: PropertyType.Map(credits_home_definition), description: "The credits section information")
        main_actions(required: false, type: PropertyType.Map(main_actions_definition), description: "The main actions section information")
        shortcuts(required: false, type: PropertyType.Map(shortcuts_section_definition), description: "The shortcuts section information")
        prepaid_banner(required: false, type: PropertyType.Map(realestate_definition), description: "The banner section information")
        secondary_actions(required: false, type: PropertyType.Map(secondary_actions_definition), description: "The secondary actions section information")
        benefits(required: false, type: PropertyType.Map(realestate_definition), description: "The benefits section information")
        cross_selling(required: false, type: PropertyType.Map(realestate_definition), description: "The cross_selling section information")
        ads_top_banner(required: false, type: PropertyType.Map(realestate_definition), description: "The advertising section information")
        loyalty(required: false, type: PropertyType.Map(loyalty_section_definition), description: "The loyalty section information")
        subscription(required: false, type: PropertyType.Map(subscription_section_definition), description: "The subscription section")
        activities(required: false, type: PropertyType.Map(activities_definition), description: "The activities section information")
        qr_map(required: false, type: PropertyType.Map(qr_map_definition), description: "The qr_map section information")
        activities_link(required: false, type: PropertyType.Map(activities_link_definition), description: "The activities_link section information")
        discount_center(required: false, type: PropertyType.Map(discount_center_definition), description: "The discount_center section information")
        survey(required: false, type: PropertyType.Map(survey_definition), description: "The survey definition section information")
        repentance_button(required: false, type: PropertyType.Map(repentance_button_definition), description: "The repentance button definition section information")
        bcra_regulation(required: false, type: PropertyType.Map(paragraph_definition), description: "The section that show only text")
        ifpe_regulation(required: false, type: PropertyType.Map(paragraph_definition), description: "The section that show only text")
        complaints_book(required: false, type: PropertyType.Map(complaints_book_definition), description: "The complaints book section information")
        metadata(required: false, type: PropertyType.Map(metadata_definition), description: "this tracking section will contain multiple information about the user metadata(location, accessibility, info, etc)")
    }

    //Control Group - Merch Engine
    "/wallet_home/merch" (platform: "/mobile", isAbstract: true) {}
    "/wallet_home/merch/control_group" (platform: "/mobile", type: TrackType.Event) {
        walletHomeMerchEngineFields
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

    "/wallet_home/loyalty/tap" (platform: "/mobile", type: TrackType.Event) { // TODO: Will be deprecated
        loyalty(required: false, type: PropertyType.Map(loyalty_header_definition), description: "The loyalty header information")
        metadata_user(required: false, type: PropertyType.Map(metadata_user_definition), description: "The user metadata")
        button_link(required: false, type: PropertyType.String, description: "The loyalty header button link.")
        link(required: false, type: PropertyType.String, description: "The loyalty header button link.")
    }

    // New header
    "/wallet_home/header_profile" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/header_data_button" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/header_profile/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "If header is tapeable")
        button_link(required: false, type: PropertyType.String, description: "If button is present")
    }

    "/wallet_home/header_data_button/tap" (platform: "/mobile", type: TrackType.Event) {}

    /**********************************/
    //    NEW TRACKS HOME TAP v3      //
    /**********************************/

    "/wallet_home/section" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/banking_v2" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/banking_v2/tap" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/section/tap" (platform: "/mobile", isAbstract: true) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
        section_id(required: true, type: PropertyType.String, description: "Section where the deeplink was launched")
        component_id(required: false, type: PropertyType.String, description: "Specific component id where the user tapped")
    }

    "/wallet_home/section/tap/banking" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/banking_v2" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/banking_v2-cards" (platform: "/mobile", type: TrackType.Event) {
        prepaid(required: true, type: PropertyType.Boolean, description: "If user has a prepaid card")
        debit(required: true, type: PropertyType.Boolean, description: "If user has a debit card")
        quantity(required: true, type: PropertyType.Numeric, description: "User's cards quantity")
    }

    "/wallet_home/section/tap/banking_v2-mpcard" (platform: "/mobile", type: TrackType.Event) {
        pill(required: false, type: PropertyType.String, description: "Pill text in card")
        has_card(required: false, type: PropertyType.Boolean, description: "If user has a active card")
        card_status(required: false, type: PropertyType.String, description: "Card status")
        has_nfc_card(required: false, type: PropertyType.Boolean, description: "If user has a NFC card")
        nfc_status(required: false, type: PropertyType.Map, description: "NFC status")
    }

    "/wallet_home/section/tap/banking_v2-assets" (platform: "/mobile", type: TrackType.Event) {
        content_id(type: PropertyType.String, required: true, description: "The asset content id")
        investment_counter(type: PropertyType.Numeric, required: false, description: "the investment counter")
        optin_process(type: PropertyType.String, required: false, description: "the opt in process identifier")
    }

    "/wallet_home/section/tap/banking_v2-actions" (platform: "/mobile", type: TrackType.Event) {
        content_id(type: PropertyType.String, required: true, description: "The id of the item")
        position(type: PropertyType.Numeric, required: true, description: "The position in the section")
        enabled(type: PropertyType.Boolean, required: true, description: "If the item is show enabled")
    }
    
    "/wallet_home/section/tap/banking_v2-balance" (platform: "/mobile", type: TrackType.Event) {
        hidden(required: true, type: PropertyType.Boolean, description: "hidden status")
        pending_balance(required: true, type: PropertyType.Boolean, description: "Unavailable balance")
        balance_histogram(required: true, type: PropertyType.Numeric, description: "Balance segmentation")
    }

    //hidden state
    "/wallet_home/banking_v2/hidden_state" (platform: "/mobile", type: TrackType.View) {
        hidden(type: PropertyType.Boolean, required: true, description: "Shows the hidden state status")
    }

    "/wallet_home/banking_v2/tap/hidden_state" (platform: "/mobile", type: TrackType.Event) {
        hidden(type: PropertyType.Boolean, required: true, description: "Shows the hidden state status")
    }

    // Walkthrough

    "/wallet_home/walkthrough" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/walkthrough/next" (platform: "/mobile", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Walkthrough id")
        step_id(type: PropertyType.String, required: true, description: "Walkthrough's step id")
        step_number(type: PropertyType.Numeric, required: true, description: "Walkthrough's step number")
    }

    "/wallet_home/walkthrough/finish" (platform: "/mobile", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Walkthrough id")
        step_id(type: PropertyType.String, required: true, description: "Walkthrough's step id")
        step_number(type: PropertyType.Numeric, required: true, description: "Walkthrough's step number")
    }

    "/wallet_home/walkthrough/close" (platform: "/mobile", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Walkthrough id")
        step_id(type: PropertyType.String, required: true, description: "Walkthrough's step id")
        step_number(type: PropertyType.Numeric, required: true, description: "Walkthrough's step number")
    }

    "/wallet_home/walkthrough/view" (platform: "/mobile", type: TrackType.View) {
        id(type: PropertyType.String, required: true, description: "Walkthrough id")
        total_steps(type: PropertyType.Numeric, required: true, description: "Walkthrough's number of steps")
        step_ids(type: PropertyType.ArrayList(PropertyType.String), required: true, description: "Walkthrough's steps ids")
    }

    "/wallet_home/section/tap/qr_fab" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/credits" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/main_actions" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/activities" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/activities_link" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/qr_map" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/discount_center" (platform: "/mobile", type: TrackType.Event){}

    "/wallet_home/section/tap/loyalty" (platform: "/mobile", type: TrackType.Event) {
        level(type: PropertyType.Numeric, required: true, description: "The user's loyalty level")
        percentage(type: PropertyType.Numeric, required: true, description: "The user's loyalty level percentage")
    }

    "/wallet_home/section/tap/subscription" (platform: "/mobile", type: TrackType.Event) {
        level(required: false, type: PropertyType.Numeric, description: "Loyalty level")
        partner(required: false, type: PropertyType.String, description: "The partner description.")
    }

    "/wallet_home/section/tap/shortcuts"(platform: "/mobile", type: TrackType.Event) {
        from(type: PropertyType.String, required: true, values: ['section', 'sheet'])
        content_id(type: PropertyType.String, required: true, description: "The identification of shown content")
        position(required: true, type: PropertyType.Numeric, description: "Position starting at 1 where it was shown")
        enabled(type: PropertyType.Boolean, required: true, description: "If the item has tap enabled indicating that it has a link")
        is_favorite(type: PropertyType.Boolean, required: true, description: "If the item was selected as favorite")
        has_aware(type: PropertyType.Boolean, required: true, description: "If has an aware badge")
        has_ripple(type: PropertyType.Boolean, required: false, description: "If has ripple animation")
        has_label(type: PropertyType.Boolean, required: true, description: "If has a label of promotion")

        group_id(required: false, type: PropertyType.String, description: "The component id of the item")
        group_position(required: false, type: PropertyType.String, description: "The group position of the item")

        audience(type: PropertyType.String, required: false, description: "The audience used for showing the shortcut")
        bu(type: PropertyType.String, required: false, description: "The business unit of the shortcut")
        bu_line(type: PropertyType.String, required: false, description: "The business unit's line of the shortcut")
        flow(type: PropertyType.String, required: false, description: "The business unit line's flow of the shortcut")
        logic(type: PropertyType.String, required: false, description: "The logic applied for showing the shortcut")
        user_profile(type: PropertyType.String, required: false, description: "The user profile", values: ["seller", "payer", "newbie"])
    }

    "/wallet_home/section/tap/survey" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/repentance_button" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/complaints_book" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/section/tap/secondary_actions" (platform: "/mobile", type: TrackType.Event, initiative: "1176") {
        walletHomeMerchEngineFields
    }

    "/wallet_home/section/tap/ads_top_banner" (platform: "/mobile", type: TrackType.Event, initiative: "1176") {
        walletHomeMerchEngineFields
    }

    "/wallet_home/section/tap/cross_selling" (platform: "/mobile", type: TrackType.Event, initiative: "1176") {
        walletHomeMerchEngineFields
    }
    "/wallet_home/section/tap/prepaid_banner" (platform: "/mobile", type: TrackType.Event, initiative: "1176") {
        walletHomeMerchEngineFields
    }

    "/wallet_home/section/tap/prepaid_banner/dismiss" (platform: "/mobile", type: TrackType.Event, initiative: "1176") {
        walletHomeMerchEngineFields
    }

    "/wallet_home/section/tap/benefits" (platform: "/mobile", type: TrackType.Event, initiative: "1176") {
        walletHomeMerchEngineFields
    }

    "/wallet_home/shortcuts_sheet" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/shortcuts_sheet/view" (platform: "/mobile", type: TrackType.View) {
        group_ids(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The list of group ids")
        shortcut_ids(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The list of shortcut ids")
        favorite_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "The list of favorite ids to save")
        has_ftu(required: false, type: PropertyType.Boolean, description: "If FTU is visible")
    }

    "/wallet_home/shortcuts_sheet/dismiss" (platform: "/mobile", type: TrackType.Event) {
        from(required: true, type: PropertyType.String, description: "How was the sheet dismiss")
        time_spent(required: false, type: PropertyType.Numeric, description: "How many milliseconds was the sheet open")
    }

    "/wallet_home/shortcuts_sheet/edit" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/shortcuts_sheet/edit/drop" (platform: "/mobile", type: TrackType.Event) {
        initial_position(required: true, type: PropertyType.Numeric, description: "Where does the shortcut come from in a drag event")
        end_position(required: true, type: PropertyType.Numeric, description: "Where does the shortcut end in a drag event")
        shortcut_id(required: true, type: PropertyType.String, description: "What shortcut was move")
    }

    "/wallet_home/shortcuts_sheet/cancel" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet_home/shortcuts_sheet/save" (platform: "/mobile", type: TrackType.Event) {
        favorite_ids(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The list of favorite ids to save")
        from(required: false, type: PropertyType.String, values: ["modal", "sheet"], description: "How did user saved his shortcuts")
    }

    /************************************/
    //  TRACKS CROSS SELL EXPERIMENTS   //
    /************************************/

    "/wallet_home/cross_sell" (platform: "/mobile", type: TrackType.Event) {}

    /**
     * New Digital Wallet Tracks - Ukraine Lab
     */
    "/new_digital_wallet_landing"(platform: "/", type: TrackType.View, initiative: "1176") {
        landing_id (required: true, type: PropertyType.String, description: "Indicate landing id")
    }
    "/new_digital_wallet_landing/click_download_app"(platform: "/", type: TrackType.Event) {
        landing_id (required: true, type: PropertyType.String, description: "Indicate landing id")
        section (required: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Section from which the event comes")
    }

}
