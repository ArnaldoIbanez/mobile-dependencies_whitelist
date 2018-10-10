import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    propertyDefinitions {
        category_id(required: true, type: PropertyType.String, description: "Id for category item")
        item_id(required: true, type: PropertyType.String, description: "Id of item used to")
        site_id(required: true, type: PropertyType.String, description: "Id of the site")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller id")
        seller_profile(required: true, type: PropertyType.String, description: "Type of seller")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        category_domain(required: false, type: PropertyType.String, description: "Item category domain")
        category_path(required: false, type: PropertyType.ArrayList, description: "Path of category")
    }

    propertyGroups {
        sellerCentralModifyGroup(category_id, site_id, seller_id, seller_profile, item_id, session_id, category_domain, category_path)
    }

    "/seller_central"(platform: "/", isAbstract: true) {}
    "/seller_central/listings"(platform: "/", isAbstract: true) {}
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}

    "/seller_central/listings/onboarding"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "rollback", "start"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
    }

    "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of the communication", values: ["news", "task"])
        id(required: false, type: PropertyType.String, description: "Id of the communication ")
    }

    "/seller_central/listings/communication/more_info"(platform: "/mobile", type: TrackType.Event) {}

    "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/filters"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/listings/filters/action"(platform: "/") {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["apply", "clear"])
    }

    "/seller_central/listings/search"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
    }

    "/seller_central/listings/preferences"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Preference id", values:["shipping", "advertising"])
    }

    "/seller_central/bulk"(platform: "/", isAbstract: true) {}
    "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values:["start","close", "rollback", "dismiss"])
    }

    "/seller_central/bulk/domain"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the domaing group")
    }

    "/seller_central/bulk/filters"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values:["apply", "clear"])

    }
    "/seller_central/bulk/search"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/undo_changes"(platform: "/", type: TrackType.Event) {}


    "/seller_central/bulk/columns"(platform: "/", type: TrackType.Event){
        columns(required: true, type: PropertyType.ArrayList, description: "List of the available columns and his order")
    }

    "/seller_central/bulk/offline"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/upload"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download/user_selection"(platform: "/", type: TrackType.Event){
        columns(required: true, type: PropertyType.ArrayList, description: "List of the selected columns")
        domains(required: true, type: PropertyType.ArrayList, description: "List of the selected domains")
    }

    "/seller_central/bulk/offline/download/error"(platform: "/", type: TrackType.Event){}

    "/seller_central/bulk/offline/download/warning"(platform: "/", type: TrackType.Event){}



    "/seller_central/modify"(platform: "/", type: TrackType.View) {
        sellerCentralModifyGroup
    }

    "/seller_central/modify/variations"(platform: "/", type: TrackType.View) {
        sellerCentralModifyGroup
    }

    "/seller_central/modify/variations_custom"(platform: "/", type: TrackType.View) {
        sellerCentralModifyGroup
    }

    "/seller_central/modify/listing_type"(platform: "/", type: TrackType.View) {
        sellerCentralModifyGroup
    }

    "/seller_central/modify/update_listing_types"(platform: "/", type: TrackType.View) {
        sellerCentralModifyGroup
        from(required: true, type: PropertyType.String, description: "Current listing type value")
        to(required: true, type: PropertyType.String, description: "Updated listing type value")
    }
}
