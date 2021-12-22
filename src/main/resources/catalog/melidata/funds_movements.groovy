package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1161"

    /**
    * Unification Screen Tracks
    */


    def account = objectSchemaDefinitions {
        type(type: PropertyType.String, required: true, values: ["MP", "BANKING", "PIX"], description: "Possible types of accounts")
        warning(type: PropertyType.String, required: false, values: ["WARNING", "BLOCKER"], description: "The type of warning for the account, this value is optional")
    }
    
    // Unification - New Transfer
    "/funds_movements"(platform: "/mobile", isAbstract: true) {}
    "/funds_movements/new_transfer"(platform: "/mobile", type: TrackType.View) {}
    "/funds_movements/new_transfer/search"(platform: "/mobile", type: TrackType.Event) {}
    "/funds_movements/new_transfer/search_result"(platform: "/mobile", type: TrackType.Event) {
        is_empty(required: true, type: PropertyType.Boolean, description: "true if search results are empty")
    }
    "/funds_movements/new_transfer/contact_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/funds_movements/new_transfer/pill/tapped"(platform: "/mobile", type: TrackType.Event) {
        type_id(required: true, inheritable: false, type: PropertyType.String, description: "Selected pill type. Values come from backend and depends on site")
    }
    "/funds_movements/new_transfer/pill/tapped/format_match"(platform: "/mobile", type: TrackType.Event) {
        success(required: true, type: PropertyType.Boolean, description: "true if format input matches with the pill’s type")
    }
    "/funds_movements/new_transfer/continue"(platform: "/mobile", type: TrackType.Event) {}

    // Unification - Bottom Sheet
    "/funds_movements/bottom_sheet"(platform: "/mobile", type: TrackType.View) {
        total(required: true, type: PropertyType.Numeric, description: "Total number of accounts", inheritable: false)
        accounts(required: false, type: PropertyType.ArrayList(PropertyType.Map(account)), description: "Account information", inheritable: false)
    }
    "/funds_movements/bottom_sheet/account_selected"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, values: ["MP", "BANKING", "PIX"], description: "Account selected type")
    }

    // Unification - Manual Amount
    "/funds_movements/manual_amount"(platform: "/mobile", type: TrackType.View) {}
    "/funds_movements/manual_amount/continue"(platform: "/mobile", type: TrackType.Event) {
        transaction_amount(required: true, type: PropertyType.Numeric, description: "The transaction amount")
        has_reason(required: false, type: PropertyType.Boolean, description: "If the transaction has a reason message")
    }
    "/funds_movements/manual_amount/emoji_selected"(platform: "/mobile", type: TrackType.Event) {
        position(required: true, PropertyType.Numeric, description: "Position of the default emojis")
        emoji_id(required: false, PropertyType.String, description: "The emoji identifier, if available")
    }
}
