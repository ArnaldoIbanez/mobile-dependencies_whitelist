package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1129"

    propertyDefinitions {
        // USER INFORMATION
        user_type(required: true, type: PropertyType.String, description: "User type")
        seller_profile(required: true, type: PropertyType.String, description: "Type of seller")
        seller_reputation(required: true, type: PropertyType.String, description: "Seller reputation")
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")

        // PROMOFF
        file_id(required: true, type: PropertyType.String, description: "File ID")
        promotion_id(required: true, type: PropertyType.String, description: "Promotion ID")
        promotion_type(required: true, values: ["percent", "fixed", "by_item"], type: PropertyType.String, description: "Promotion type")
        categories(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "List of categories selected by the user")
        filters(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Filters selected by the user")
        excel_type(required: true, values: ["DEFAULT", "ERROR"], type: PropertyType.String, description: "Excel type")
        min_discount(required: false, type: PropertyType.Numeric, description: "Minimum discount percentage established by the user")
        max_discount(required: false, type: PropertyType.Numeric, description: "Maximum discount percentage established by the user")
        average_discount(required: false, type: PropertyType.Numeric, description: "Calculated average discount percentage")
        errors(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "List of errors keys")
        campaign_id(required: true, type: PropertyType.String, description: "Campaign id for sellers promotions")
        campaign_type(required: true, values: ["traditional", "coupon"], type: PropertyType.String, description: "Type of Campaign for sellers promotions")
        discount_type(required: true, values: ["by_item", "all"], type: PropertyType.String, description: "Type of discount for Campaigns")
        status(required: true, values: ["active", "inactive"], type: PropertyType.String, description: "campaign status")
        target(required: true, values: ["LISTED_PRODUCTS"], type: PropertyType.String, description: "Type of listings")
    }

    propertyGroups {
        // PROMOFF BACKEND
        promoffDocumentDownload(user_type, seller_profile, seller_reputation, seller_segment, file_id, promotion_id, promotion_type, categories, filters)
        promoffDocumentUpload(user_type, seller_profile, seller_reputation, seller_segment, file_id, promotion_id, promotion_type, excel_type, min_discount, max_discount, average_discount)
        promoffDocumentError(user_type, seller_profile, seller_reputation, seller_segment, file_id, promotion_id, promotion_type, errors)
        // PROMOFF FRONTEND
        promoffFrontend(campaign_id, campaign_type, discount_type, status, target)
    }

    "/mercadoshops"(platform: "/", isAbstract: true) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PROMOFF BACKEND
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/mercadoshops/promoff"(platform: "/", isAbstract: true) {}
    "/mercadoshops/promoff/document"(platform: "/", isAbstract: true) {}

    "/mercadoshops/promoff/document/download"(platform: "/", type: TrackType.Event) {
        promoffDocumentDownload
    }

    "/mercadoshops/promoff/document/upload"(platform: "/", type: TrackType.Event) {
        promoffDocumentUpload
    }

    "/mercadoshops/promoff/document/error"(platform: "/", type: TrackType.Event) {
        promoffDocumentError
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PROMOFF FRONTEND
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central"(platform: "/", isAbstract: true) {}
    "/seller_central/cdp"(platform: "/", isAbstract: true) {}
    "/seller_central/cdp/offline_editor"(platform: "/", isAbstract: true) {}

    "/seller_central/cdp/offline_editor/hub"(platform: "/", type: TrackType.View) {
        promoffFrontend
    }

    "/seller_central/cdp/offline_editor/hub/upload_file"(platform: "/", type: TrackType.Event) {
        file_id(required: true, type: PropertyType.String, description: "Excel id uploaded")
        promoffFrontend
    }

    "/seller_central/cdp/offline_editor/hub/card_click"(platform: "/", type: TrackType.Event) {
        promoffFrontend
    }

    "/seller_central/cdp/offline_editor/categories"(platform: "/", type: TrackType.View) {
        promoffFrontend
    }

    "/seller_central/cdp/offline_editor/categories/download_file"(platform: "/", type: TrackType.View) {
        total_items(required: true, type: PropertyType.Numeric, description: "Quantity of items available for promotions")
        total_selected(required: true, type: PropertyType.Numeric, description: "Quantity of items selected")
        promoffFrontend
    }

    "/seller_central/cdp/offline_editor/congrats"(platform: "/", type: TrackType.View) {
        promoffFrontend
    }
}
