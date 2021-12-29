package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoshops"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PROMOFF
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("PROMOFF - Document download") {
        "/mercadoshops/promoff/document/download"(platform: "/", type: TrackType.Event) {
            user_type = "normal"
            seller_profile = "seller_profile"
            seller_reputation = "platinum"
            seller_segment = "professional_sellers"
            file_id = "2139121d-b80e-4fd0-a1e8-78a7bf9fd200"
            promotion_id = "TR-624512800-202111161533343334"
            promotion_type = "by_item"
            categories = ["MLA-REFRIGERATORS", "MLA-CELLPHONES"]
            filters = ["ACTIVE_WITH_MISSING_PRODUCT_IDENTIFIERS", "BASIC_HEALTH"]
        }
    }

    test("PROMOFF - Document upload") {
        "/mercadoshops/promoff/document/upload"(platform: "/", type: TrackType.Event) {
            user_type = "normal"
            seller_profile = "seller_profile"
            seller_reputation = "platinum"
            seller_segment = "professional_sellers"
            file_id = "2139121d-b80e-4fd0-a1e8-78a7bf9fd200"
            promotion_id = "TR-624512800-202111161533343334"
            promotion_type = "by_item"
            excel_type = "DEFAULT"
            min_discount = 5.0
            max_discount = 20.0
            average_discount = 16.67
        }
    }

    test("PROMOFF - Document error") {
        "/mercadoshops/promoff/document/error"(platform: "/", type: TrackType.Event) {
            user_type = "normal"
            seller_profile = "seller_profile"
            seller_reputation = "platinum"
            seller_segment = "professional_sellers"
            file_id = "2139121d-b80e-4fd0-a1e8-78a7bf9fd200"
            promotion_id = "TR-624512800-202111161533343334"
            promotion_type = "by_item"
            errors = ["CC01", "IPA01"]
        }
    }

    test("PROMOFF - hup page") {
        "/seller_central/cdp/offline_editor/hub"(platform: "/", type: TrackType.View) {
            campaign_id = "TRM-1234-567890"
            campaign_type = "traditional"
            discount_type = "by_item"
            status = "active"
            target = "LISTED_PRODUCTS"
        }
    }

    test("PROMOFF - upload file") {
        "/seller_central/cdp/offline_editor/hub/upload_file"(platform: "/", type: TrackType.Event) {
            campaign_id = "TRM-1234-567890"
            campaign_type = "traditional"
            discount_type = "by_item"
            status = "active"
            target = "LISTED_PRODUCTS"
            file_id = "1234adbc"
        }
    }

    test("PROMOFF - click download card") {
        "/seller_central/cdp/offline_editor/hub/card_click"(platform: "/", type: TrackType.Event) {
            campaign_id = "TRM-1234-567890"
            campaign_type = "traditional"
            discount_type = "by_item"
            status = "active"
            target = "LISTED_PRODUCTS"
        }
    }

    test("PROMOFF - categories page") {
        "/seller_central/cdp/offline_editor/categories"(platform: "/", type: TrackType.View) {
            campaign_id = "TRM-1234-567890"
            campaign_type = "traditional"
            discount_type = "by_item"
            status = "active"
            target = "LISTED_PRODUCTS"
        }
    }

    test("PROMOFF - download file") {
        "/seller_central/cdp/offline_editor/categories/download_file"(platform: "/", type: TrackType.Event) {
            campaign_id = "TRM-1234-567890"
            campaign_type = "traditional"
            discount_type = "by_item"
            status = "active"
            target = "LISTED_PRODUCTS"
            total_items = 24
            total_selected = 10
        }
    }

    test("PROMOFF - congrats") {
        "/seller_central/cdp/offline_editor/congrats"(platform: "/", type: TrackType.Event) {
            campaign_id = "TRM-1234-567890"
            campaign_type = "traditional"
            discount_type = "by_item"
            status = "active"
            target = "LISTED_PRODUCTS"
            file_id = "1234adbc"
        }
    }
}
