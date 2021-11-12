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
        accept_conditions(required: false, type: PropertyType.Boolean, description: "Indicates if the user accepted reservation terms and conditions")

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
    }

    "/vis/reservation"(platform: "/", isAbstract: true) {
        step_properties
    }

    // terms and conditions step
    "/vis/reservation/terms_conditions"(platform: "/", type: TrackType.View) {}
    "/vis/reservation/terms_conditions/continue"(platform: "/", type: TrackType.Event) {}
    "/vis/reservation/terms_conditions/privacy"(platform: "/", type: TrackType.Event) {}
    "/vis/reservation/terms_conditions/terms_conditions"(platform: "/", type: TrackType.Event) {}
    "/vis/reservation/terms_conditions/accept"(platform: "/", type: TrackType.Event) {
        accept_conditions(required: true, type: PropertyType.Boolean, description: "if the user accepts terms and conditions")
    }

    // reservation detail step
    "/vis/reservation/detail"(platform: "/", type: TrackType.View) {}
    "/vis/reservation/detail/reserve"(platform: "/", type: TrackType.Event) {}
    "/vis/reservation/detail/refund"(platform: "/", type: TrackType.Event) {}
    "/vis/reservation/detail/requirements"(platform: "/", type: TrackType.Event) {}
    "/vis/reservation/detail/payment_detail"(platform: "/", type: TrackType.Event) {}

    // congrats step success case
    "/vis/reservation/congrats/success"(platform: "/", type: TrackType.View) {}
    "/vis/reservation/congrats/success/view_item"(platform: "/", type: TrackType.Event) {}

    // congrats step failed case
    "/vis/reservation/congrats/failed"(platform: "/", type: TrackType.View) {}
    "/vis/reservation/congrats/failed/retry"(platform: "/", type: TrackType.Event) {}
}
