package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1041"

    propertyDefinitions {
        item_id(required: true, type: PropertyType.String, description: "Item id which visit will be scheduled")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String, values: ["motors", "realEstate", "services"], description: "Vertical of the item")
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller id")
        selected_days(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "days of the visit")
        selected_hours_range(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "hours of the visit")

        // realEstate definitions
        is_ltr(required: false, type: PropertyType.Boolean, description: "Indicates if the item is a long term rental property")
    }

    propertyGroups {
        step_properties(
                item_id,
                category_id,
                vertical,
                buyer_id,
                seller_id,
                is_ltr
        )
        days(
                selected_days
        )
        hours(
                selected_hours_range
        )
    }

    "/vis/scheduling"(platform: "/", isAbstract: true) {
        step_properties
    }

    // terms and conditions step
    "/vis/scheduling/terms_conditions"(platform: "/", type: TrackType.View) {}
    "/vis/scheduling/terms_conditions/continue"(platform: "/", type: TrackType.Event) {}
    "/vis/scheduling/terms_conditions/accept"(platform: "/", type: TrackType.Event) {
        accept_conditions(required: true, type: PropertyType.Boolean, description: "if the user accepts terms and conditions")
    }

    // scheduling selection step
    "/vis/scheduling/calendar"(platform: "/", type: TrackType.View) {}
    "/vis/scheduling/calendar/days"(platform: "/", type: TrackType.Event) {
        days
    }
    "/vis/scheduling/calendar/hours_range"(platform: "/", type: TrackType.Event) {
        hours
    }
    "/vis/scheduling/calendar/schedule"(platform: "/", type: TrackType.Event) {
        days
        hours
    }

    // congrats step
    "/vis/scheduling/congrats"(platform: "/", type: TrackType.View) {}
    "/vis/scheduling/congrats/view_more_items"(platform: "/", type: TrackType.Event) {}
    "/vis/scheduling/congrats/my_data"(platform: "/", type: TrackType.Event) {}
}
