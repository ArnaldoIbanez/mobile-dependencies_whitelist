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
}
