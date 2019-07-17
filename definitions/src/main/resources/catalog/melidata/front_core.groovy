import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*************************
*   WALLET HOME TRACKS   *
*************************/

tracks {

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
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        collapsed(required: true, type: PropertyType.Boolean, description: "If banking is collapsed")
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
        assets(required: false, type: PropertyType.Map(cards_definition), description: "The assets section information")
        credits(required: false, type: PropertyType.Map(cards_definition), description: "The credits section information")
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
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of main actions")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(main_action_definition)), description: "The main action items information")
    }

    def realestate_definition = objectSchemaDefinitions {
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        realestates(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestate)), description: "The realestate information")
    }

    def secondary_actions_definition = objectSchemaDefinitions {
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
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        quantity(type: PropertyType.Numeric, required: true, description: "Quantity of activities")
        is_ftu(type: PropertyType.Boolean, required: true, description: "Whether it is an ftu or not")
        has_footer(type: PropertyType.Boolean, required: true, description: "whether it has a footer or not")
    }

    def qr_map_definition = objectSchemaDefinitions {
        ordinal(type: PropertyType.Numeric, required: true, description: "The identification of shown content")
        header_title(type: PropertyType.String, required: true, description: "The container header title")
        items(required: true, PropertyType.ArrayList(PropertyType.String), description: "the items recived form endpoint or cache")
        link(type: PropertyType.String, required: true, description: "The link to execute")
    }

    "/wallet/home" (platform: "/mobile", isAbstract: true) {}
    "/home_wallet/drawer" (platform: "/mobile", isAbstract: true) {}
    "/wallet/home/secondary_actions" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/wallet/home" (platform: "/mobile", type: TrackType.View) {}
    "/home_wallet" (platform: "/mobile", type: TrackType.View) {}

    // Events
    "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {}

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
    }

    "/wallet_home/banking/expand" (platform: "/mobile", type: TrackType.Event) {
        balance(required: false, type: PropertyType.Map(balance_definition), description: "The balance section information")
        cards(required: false, type: PropertyType.Map(cards_definition), description: "The cards section information")
    }

    "/wallet_home/home" (platform: "/mobile", type: TrackType.View) {
        header(required: true, type: PropertyType.String, description: "Contains the header text's home", inheritable: false)
        banking(required: false, type: PropertyType.Map(banking_definition), description: "The banking section information")
        main_actions(required: false, type: PropertyType.Map(main_actions_definition), description: "The main actions section information")
        prepaid_banner(required: false, type: PropertyType.Map(realestate_definition), description: "The banner section information")
        secondary_actions(required: false, type: PropertyType.Map(secondary_actions_definition), description: "The secondary actions section information")
        benefits(required: false, type: PropertyType.Map(realestate_definition), description: "The benefits section information")
        cross_selling(required: false, type: PropertyType.Map(realestate_definition), description: "The cross_selling section information")
        activities(required: false, type: PropertyType.Map(activities_definition), description: "The activities section information")
        qr_map(required: false, type: PropertyType.Map(qr_map_definition), description: "The qr_map section information")
    }

    "/wallet_home/update" (platform: "/mobile", type: TrackType.View) {
        header(required: true, type: PropertyType.String, description: "Contains the header text's home", inheritable: false)
        banking(required: false, type: PropertyType.Map(banking_definition), description: "The banking section information")
        main_actions(required: false, type: PropertyType.Map(main_actions_definition), description: "The main actions section information")
        prepaid_banner(required: false, type: PropertyType.Map(realestate_definition), description: "The banner section information")
        secondary_actions(required: false, type: PropertyType.Map(secondary_actions_definition), description: "The secondary actions section information")
        benefits(required: false, type: PropertyType.Map(realestate_definition), description: "The benefits section information")
        cross_selling(required: false, type: PropertyType.Map(realestate_definition), description: "The cross_selling section information")
        activities(required: false, type: PropertyType.Map(activities_definition), description: "The activities section information")
        qr_map(required: false, type: PropertyType.Map(qr_map_definition), description: "The qr_map section information")
    }

    //Notification Center
    "/wallet_home/notification" (platform: "/mobile", isAbstract: true) {}

    "/wallet_home/notification/show" (platform: "/mobile", type: TrackType.View) {}

    "/wallet_home/notification/tap" (platform: "/mobile", type: TrackType.Event) {
        badge_count(required: true, type: PropertyType.Numeric, description: "The amount of notifications that is been showed in the notification label icon")
    }

}