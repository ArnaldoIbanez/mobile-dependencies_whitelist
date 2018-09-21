    
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Listing
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central listing main page") {
        "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}
    }

    test("seller central listing action") {
        "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
            action_id = "MODIFY"
        }
    }

    test("seller central listing filters view") {
        "/seller_central/listings/filters"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central listing filters actions and search") {
        "/seller_central/listings/filters/action"(platform: "/", type: TrackType.Event) {
            action = "apply"
        }
        "/seller_central/listings/filters/action"(platform: "/", type: TrackType.Event) {
            action = "clear"
        }

        "/seller_central/listings/search"(platform: "/", type: TrackType.Event) {}
    }



    test("seller central listing onboarding view") {
        "/seller_central/listings/onboarding"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central listing onboarding actions") {
        "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
            action = "dismiss"
        }
        "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
            action = "start"
        }
    }

    test("seller central listing communications") {
        "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
            type = "news"
        }
        "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
            type = "task"
            id = "MODIFY"
        }
        "/seller_central/listings/communication/more_info"(platform: "/mobile", type: TrackType.Event) {
            type = "news"
        }
    }

    test("seller central list to bulk editor") {
        "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central listing preferences") {
        "/seller_central/listings/preferences"(platform: "/", type: TrackType.Event) {
            id = "shipping"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Bulk
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central bulk view") {
        "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}
    }

    test("seller central bulk onboarding") {
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "start"
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "dismiss"
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "rollback"
        }
    }

    test("seller central bulk view") {
        "/seller_central/bulk/domain"(platform: "/", type: TrackType.Event) {
            id = "technical_specification"
        }
    }

    test("seller central bulk offline tracks") {
        "/seller_central/bulk/offline"(platform: "/", type: TrackType.View) {
            action = "download"
        }
    }

    test("seller central bulk filters and search") {
        "/seller_central/bulk/filters"(platform: "/", type: TrackType.Event) {
            action = "clear";
        }
    }

    test("seller central bulk filters and search") {
        "/seller_central/bulk/undo_changes"(platform: "/", type: TrackType.Event) {}
        "/seller_central/bulk/search"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central render detail"){
        "/seller_central/modify"(platform: "/", type: TrackType.View){
            categoryId = "MLA390784"
            itemId = "MLA682118081"
            sessionId = "123-update-abc123"
            categoryDomain = "MLA-FRAGRANCES"
            categoryPath = ["MLA1234", "MLA12345"]
            sellerId = 12345467
            sellerProfile = "ADVANCED"
            siteId = "MLA"
        }
    }

    test("seller central render variations"){
        "/seller_central/modify/variations"(platform: "/", type: TrackType.View){
            categoryId = "MLA390784"
            itemId = "MLA682118081"
            sessionId = "123-update-abc123"
            categoryDomain = "MLA-FRAGRANCES"
            categoryPath = ["MLA1234", "MLA12345"]
            sellerId = 12345467
            sellerProfile = "ADVANCED"
            siteId = "MLA"
        }
    }

    test("seller central render custom variations"){
        "/seller_central/modify/variations_custom"(platform: "/", type: TrackType.View){
            categoryId = "MLA390784"
            itemId = "MLA682118081"
            sessionId = "123-update-abc123"
            categoryDomain = "MLA-FRAGRANCES"
            categoryPath = ["MLA1234", "MLA12345"]
            sellerId = 12345467
            sellerProfile = "ADVANCED"
            siteId = "MLA"
        }
    }

    test("seller central render listing_type"){
        "/seller_central/modify/listing_type"(platform: "/", type: TrackType.View){
            categoryId = "MLA390784"
            itemId = "MLA682118081"
            sessionId = "123-update-abc123"
            categoryDomain = "MLA-FRAGRANCES"
            categoryPath = ["MLA1234", "MLA12345"]
            sellerId = 12345467
            sellerProfile = "ADVANCED"
            siteId = "MLA"
        }
    }

}
