package src.test.resources.melidata

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
            seller_id = 123456789
            category_id = "MLM170531"
            vertical = "REAL_ESTATE"
            error_type = ""
            model_id = "102B"
            unit_id = 23544349337
        }

        "/quotation/details"(platform: "/mobile") {
            item_id = "MLM2222222"
            vertical = "REAL_ESTATE"
            model_id = "102B"
            unit_id = 23544349337
        }
    }

    test("Quotation :: Show select models tracking") {

        "/quotation/models"(platform: "/mobile") {
            item_id = "MLM2222222"
        }

        "/quotation/models"(platform: "/mobile") {
            item_id = "MLM2222222"
            model_id = "102B"
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

        "/quotation/disclaimer"(platform: "/") {
            item_id = "MLM2222222"
        }
    }

    test("Quotation :: Quote intention tracking") {

        "/quotation/quote_intention"(platform: "/mobile") {
            item_id = "MLM2222222"
            model_id = "102B"
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
        }

        "/quotation/congrats"(platform: "/web") {
            item_id = "MLM2222222"
            category_id = "MLM170531"
            seller_id = 123456789
            vertical = "REAL_ESTATE"
            model_id = "102B"
            unit_id = 54321
            error_type = ""
        }

        "/quotation/congrats"(platform: "/mobile") {
            item_id = "MLM2222222"
            unit_id = "54321"
        }
    }

    test("Quotation :: Show price tracking") {
        "/quotation/show_price"(platform: "/") {
            seller_id = 123456789
            vertical = "REAL_ESTATE"
            item_id = "MLM2222222"
        }

        "/quotation/show_price"(platform: "/web") {
            seller_id = 123456789
            vertical = "REAL_ESTATE"
            item_id = "MLM2222222"
            model_id = "102B"
            unit_id = 54321
        }
    }

    test("Quotation :: Modal Model") {
        "/quotation/modal-model"(platform: "/") {
            seller_id = 123456789
            vertical = "REAL_ESTATE"
            item_id = "MLM2222222"
            model_id = "102B"
            unit_id = 54321
        }
    }
}
