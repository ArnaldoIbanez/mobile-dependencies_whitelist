package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1029"

    "/seller_central"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/changes"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/shipping"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/open_tooltip"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["start", "close", "rollback", "dismiss"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
        viewId(required: false, type: PropertyType.String, descritpion: "Onboarding id if applies")
    }

    "/seller_central/bulk/domain"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the domaing group")
    }

    "/seller_central/bulk/filters"(platform: "/", type: TrackType.Event) {
        filters(required: true, type: PropertyType.ArrayList, description: "List of selected filters")
    }

    "/seller_central/bulk/search"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/undo_changes"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/columns"(platform: "/", type: TrackType.Event) {
        columns(required: true, type: PropertyType.ArrayList, description: "List of the available columns and his order")
    }

    "/seller_central/bulk/changes/price"(platform: "/", type: TrackType.Event) {
        oldValue(required: true, type: PropertyType.String, description: "Old value of the price cell")
        newValue(required: true, type: PropertyType.String, description: "New value")
        item_id(required: true, type: PropertyType.String, description: "Id of the modified item")
    }

    "/seller_central/bulk/changes/price_mshops"(platform: "/", type: TrackType.Event) {
        oldValue(required: true, type: PropertyType.String, description: "Old value of the price cell")
        newValue(required: true, type: PropertyType.String, description: "New value")
        item_id(required: true, type: PropertyType.String, description: "Id of the modified item")
    }

    "/seller_central/bulk/shipping/tooltip"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "item's id that showed the tooltip")
    }
}

