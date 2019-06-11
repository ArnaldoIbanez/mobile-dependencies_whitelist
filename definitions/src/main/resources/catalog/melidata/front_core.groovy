import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*************************
*   WALLET HOME TRACKS   *
*************************/

tracks {

    def item_value_definition = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "The id of the section")
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the home")
        type(required: true, type: PropertyType.String, description: "The layout of the view")
    }

    "/wallet/home" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/wallet/home" (platform: "/mobile", type: TrackType.View) {}

    // Events
    "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet/home/show" (platform: "/mobile", type: TrackType.Event) {
        header(required: true, type: PropertyType.String, description: "Contains the header text's home", inheritable: false)
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_value_definition)), description: "Contains the sections payload", inheritable: false)
    }

    "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
    }

    //Sections
    def main_action_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "The id of the item")
        ordinal(type: PropertyType.Numeric, required: true, description: "The position in the section")
        has_promotion(type: PropertyType.Boolean, required: true, description: "If has a label of promotion")
        enabled(type: PropertyType.Boolean, required: true, description: "If the item is show enabled")
    }

    "/wallet/home/show/main_actions" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        quantity(required: true, type: PropertyType.Numeric, description: "The number of main actions displayed")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(main_action_definition)), description: "The items of the view")
    }

    def realestate = objectSchemaDefinitions {
        realestate_id(type: PropertyType.String, required: true, description: "The container where we show contents")
        content_id(type: PropertyType.String, required: true, description: "The identification of shown content")
        origin(type: PropertyType.String, required: true, description: "The application that returns the content")
    }

    "/wallet/home/show/secondary_actions" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        realestates_payers(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Secondary actions payers containers")
        realestates_sellers(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Secondary actions sellers containers")
    }

    "/wallet/home/show/discount_benefits" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        realestates(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Discount benefits containers")
    }

    "/wallet/home/show/dismissible_row" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        realestates(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Dismissible row containers")
    }

    "/wallet/home/show/cross_selling" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        realestates(type: PropertyType.ArrayList(PropertyType.Map(realestate)), required:true, description: "Cross selling containers")
    }

    // TODO: This track will be removed
    "/wallet/home/show/banking" (platform: "/mobile", type: TrackType.Event) {
        collapsed(required: true, type: PropertyType.Boolean, description: "If banking is collapsed")
    }

    // TODO: This track will be removed
    "/wallet/home/show/activities" (platform: "/mobile", type: TrackType.Event) {
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of activities")
        is_ftu(required: true, type: PropertyType.Boolean, description: "If is present the FTU in activities section")
        has_footer(required: true, type: PropertyType.Boolean, description: "If has a footer")
    }

    "/wallet/home/banking" (platform: "/mobile", isAbstract: true) {}

    "/wallet/home/banking/initial_state" (platform: "/mobile", type: TrackType.Event) {
        collapsed(required: true, type: PropertyType.Boolean, description: "If banking is collapsed")
    }

    "/wallet/home/banking/collapse" (platform: "/mobile", type: TrackType.Event) {}

    "/wallet/home/banking/expand" (platform: "/mobile", type: TrackType.Event) {}
}