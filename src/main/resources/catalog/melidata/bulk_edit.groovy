package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1029"

    "/seller_central"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk"(platform: "/", isAbstract: true) {}


    "/seller_central/bulk/massive_action"(platform: "/", isAbstract: true) {
        column_id(required: true, type: PropertyType.String, description: "Column affected")
        operation_id(required: true, type: PropertyType.String, description: "Operation Id change")
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation",  values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green", "none", "no_reputation", "newbie"])
        user_type(required: true, type: PropertyType.String, description: "The user type", values: ["normal", "brand", "car_dealer", "real_state", "real_estate_agency", "official_store", "franchise", "seller_reg"])
        user_shops_status(required: true, type: PropertyType.String, description: "Indicates if seller has mshops experience", values: ["active", "inactive"])
        session_id(required: true, type:PropertyType.String, description: "Session id")
    }

    "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation",  values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green", "none", "no_reputation", "newbie"])
        user_type(required: true, type: PropertyType.String, description: "The user type", values: ["normal", "brand", "car_dealer", "real_state", "real_estate_agency", "official_store", "franchise", "seller_reg"])
        user_shops_status(required: true, type: PropertyType.String, description: "Indicates if seller has mshops experience", values: ["active", "inactive"])
        session_id(required: true, type:PropertyType.String, description: "Session id")
    }

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
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation",  values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green", "none", "no_reputation", "newbie"])
        user_type(required: true, type: PropertyType.String, description: "The user type", values: ["normal", "brand", "car_dealer", "real_state", "real_estate_agency", "official_store", "franchise", "seller_reg"])
        user_shops_status(required: true, type: PropertyType.String, description: "Indicates if seller has mshops experience", values: ["active", "inactive"])
        session_id(required: true, type:PropertyType.String, description: "Session id")
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
        old_value(required: true, type: PropertyType.String, description: "Old value of the price cell")
        new_value(required: true, type: PropertyType.String, description: "New value")
        item_id(required: true, type: PropertyType.String, description: "Id of the modified item")
    }

    "/seller_central/bulk/massive_action/price"(platform: "/", type: TrackType.Event) {
        price(required: true, PropertyType.Numeric, description: "New price value")
    }

    "/seller_central/bulk/massive_action/channel"(platform: "/", type: TrackType.Event) {
        value_id(required: true, PropertyType.String, description: "Value id channel applied")
    }

    "/seller_central/bulk/massive_action/quantity"(platform: "/", type: TrackType.Event) {
        quantity(required: true, PropertyType.Numeric, description: "New quantity value")
    }

    "/seller_central/bulk/massive_action/listing_type"(platform: "/", type: TrackType.Event) {
        listing_type(required: true, PropertyType.String, description: "Listing type applied")
    }

    "/seller_central/bulk/massive_action/secondary_action"(platform: "/", type: TrackType.Event) {
        secondary_actions(required: true, PropertyType.String, description: "Secondary action applied")
    }

    "/seller_central/bulk/massive_action/shipping_type"(platform: "/", type: TrackType.Event) {
        local_pickup(required: true, PropertyType.Boolean, description: "Local pickup value applied")
    }

    "/seller_central/bulk/massive_action/manufacturing_time"(platform: "/", type: TrackType.Event) {
        time(required: true, PropertyType.Numeric, description: "Manufacturing time in days applied")
    }

    "/seller_central/bulk/massive_action/warranty"(platform: "/", type: TrackType.Event) {
        type_value(required: true, PropertyType.String, description: "Warranty type applied")
        time_option(required: true, PropertyType.String, description: "Measure of time applied")
        time_value(required: true, PropertyType.Numeric, description: "Numeric value applied to warrany")
    }


    "/seller_central/bulk/massive_action/shipping_method"(platform: "/", type: TrackType.Event) {}


    "/seller_central/bulk/massive_action/sync_price"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/massive_action/status"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/shipping/tooltip"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "item's id that showed the tooltip")
    }
}


