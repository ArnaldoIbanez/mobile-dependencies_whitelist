package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Quotation :: Show details tracking") {

        "/quotation/details"(platform: "/") {
            item_id = "MLM2222222"
        }

        "/quotation/details"(platform: "/web") {
            item_id = "MLM2222222"
            category_id = "MLM170531"
            seller_id = 123456789
            listing_type_id = "silver"
            item_status = "closed"
            vertical = "REAL_ESTATE"
            error_type = ""
        }

        "/quotation/details"(platform: "/mobile") {
            item_id = "MLM2222222"
        }

        "/quotation/details"(platform: "/mobile") {
            item_id = "MLM2222222"
            model_id = "MLM170531"
        }
    }

    test("Quotation :: Show select models tracking") {

        "/quotation/models"(platform: "/mobile") {
            item_id = "MLM2222222"
        }

        "/quotation/models"(platform: "/mobile") {
            item_id = "MLM2222222"
            model_id = "MLM170531"
        }
    }

    test("Quotation :: Show select units tracking") {

        "/quotation/units"(platform: "/mobile") {
            item_id = "MLM2222222"
        }

        "/quotation/units"(platform: "/mobile") {
            item_id = "MLM2222222"
            unit_id = "MLM170531"
        }
    }

    test("Quotation :: Show gallery tracking") {

        "/quotation/gallery"(platform: "/mobile") { }

    }

    test("Quotation :: Show disclaimer tracking") {

        "/quotation/disclaimer"(platform: "/mobile") {
            item_id = "MLM2222222"
        }
    }

    test("Quotation :: Quote intention tracking") {

        "/quotation/quote_intention"(platform: "/mobile") {
            item_id = "MLM2222222"
            model_id = "MLM170531"
            unit_id = "54321"
        }
    }

    test("Quotation :: Quotation success tracking") {

        "/quotation/success"(platform: "/") {
            item_id = "MLM2222222"
            unit_id = "54321"
        }
    }

    test("Quotation :: Show congrats tracking") {
        "/quotation/congrats"(platform: "/") {
            item_id = "MLM2222222"
            unit_id = "54321"
        }

        "/quotation/congrats"(platform: "/web") {
            item_id = "MLM2222222"
            category_id = "MLM170531"
            seller_id = 123456789
            listing_type_id = "silver"
            item_status = "closed"
            vertical = "REAL_ESTATE"
            model_id = 12345
            unit_id = "54321"
            error_type = ""
        }
    }
}
