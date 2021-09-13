package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1161"

    /**
    * Unification Screen Tracks
    */

    // Unification - New Transfer
    "/funds_movements"(platform: "/mobile", isAbstract: true) {}
    "/funds_movements/new_transfer"(platform: "/mobile", type: TrackType.View) {}
    "/funds_movements/new_transfer/search"(platform: "/mobile", type: TrackType.Event) {}
    "/funds_movements/new_transfer/search_result"(platform: "/mobile", type: TrackType.Event) {
        is_empty(required: true, type:  PropertyType.Boolean, description: "true if search results are empty")
    }
    "/funds_movements/new_transfer/contact_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/funds_movements/new_transfer/pill/tapped"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, inheritable: false, type:  PropertyType.String, description: "Selected pill type. Values come from backend and depends on site")
    }
    "/funds_movements/new_transfer/pill/tapped/format_match"(platform: "/mobile", type: TrackType.Event) {
        success(required: true, type: PropertyType.Boolean, description: "true if format input matches with the pill’s type")
    }
    "/funds_movements/new_transfer/pill/tapped/account_match"(platform: "/mobile", type: TrackType.Event) {
        success(required: true, type: PropertyType.Boolean, description: "true if input has an account")
    }

    // Unification - Bottom Sheet
    "/funds_movements/bottom_sheet"(platform: "/mobile", type: TrackType.View) {}
    "/funds_movements/bottom_sheet/warnings"(platform: "/mobile", type: TrackType.Event) {
        types(type: PropertyType.ArrayList(PropertyType.String), required: true, description: "Warning types")
    }
    "/funds_movements/bottom_sheet/without_warnings"(platform: "/mobile", type: TrackType.Event) {}
    "/funds_movements/bottom_sheet/accounts"(platform: "/mobile", type: TrackType.Event) {
        total(required: true, type: PropertyType.Numeric, description: "Total number of accounts")
        type(required: true, type: PropertyType.String, values: ["MP", "BANKING", "VIA PIX", "MP_BANKING"],description: "account type")
    }
    "/funds_movements/bottom_sheet/contact_selected"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, values: ["EMAIL", "PHONE"],description: "Contact selected type")
    }

    // Unification - Manual Amount
    "/funds_movements/manual_amount"(platform: "/mobile", type: TrackType.View) {}
    "/funds_movements/manual_amount/continue"(platform: "/mobile", type: TrackType.Event) {
        transaction_amount(required: true, PropertyType.Numeric, description: "The transaction amount")
        has_reason(required: false, PropertyType.Boolean, description: "If the transaction has a reason message")
    }
    "/funds_movements/manual_amount/emoji_selected"(platform: "/mobile", type: TrackType.Event) {}
}
