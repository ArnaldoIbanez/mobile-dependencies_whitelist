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

    test("Quotation unregistered:: Show unregistered details tracking") {

        "/quotation/details/unregistered"(platform: "/web") {
            item_id = "MLM2222222"
            seller_id = 123456789
            category_id = "MLM170531"
            vertical = "REAL_ESTATE"
            error_type = ""
            model_id = "102B"
            unit_id = 23544349337
        }
    }

    test("Quotation :: Show select models tracking event old web vip") {

        "/quotation/details/show"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "primary"
        }
    }

    test("Quotation :: Show select models tracking event new vpp") {

        "/quotation/details/show"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "primary"
            seller_id = 123456789
            buying_mode= "classified"
            category_path= ["MLA1540","MLA122258"]
            item_condition = "new"
            item_seller_type = "normal"
            item_status = "active"
            listing_type_id = "gold_premium"
            deal_ids = []
        }
    }

    test("Quotation :: Show select models unregistered tracking event") {

        "/quotation/details/unregistered/show"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "primary"
        }
    }


    test("Quotation :: Show select models tracking") {

        "/quotation/models"(platform: "/") {
            item_id = "MLM2222222"
        }

        "/quotation/models"(platform: "/") {
            item_id = "MLM2222222"
            model_id = "102B"
        }
    }

    test("Quotation :: Scroll selector models tracking") {

        "/quotation/models/scroll"(platform: "/web") {
            item_id = "MLM2222222"
        }
    }

    test("Quotation :: Show select units tracking") {

        "/quotation/units"(platform: "/") {
            item_id = "MLM2222222"
        }

        "/quotation/units"(platform: "/") {
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

        "/quotation/quote_intention"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "vip"
        }
    }

    test("Quotation :: Quote unregistered intention tracking") {

        "/quotation/unregistered/quote_intention"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "vip"
        }

        "/quotation/unregistered/quote_intention"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "congrats"
        }

        "/quotation/unregistered/quote_intention"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "vip_unregistered_form"
        }
    }


    test("Quotation :: Edit info unregistered quotation tracking") {

        "/quotation/unregistered/edit_info"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "vip"
        }
    }

    test("Quotation :: Close modal quotation tracking") {

        "/quotation/modal/close"(platform: "/web", type: TrackType.Event) {
            item_id = "MLC12345"
            source = "vip"
        }
    }

    test("Quotation :: Show captcha unregistered form quotation tracking") {

        "/quotation/unregistered_form/captcha"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "vip_unregistered_form"
        }
    }

    test("Quotation :: Action to show unregistered form quotation tracking") {

        "/quotation/unregistered_form/show"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
            source = "vip_unregistered_form"
        }
    }

    test("Quotation :: Show unregistered form quotation tracking") {

        "/quotation/unregistered_form"(platform: "/web", type: TrackType.Event) {
            item_id = "MLM2222222"
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

    test("Quotation :: Show unregistered congrats tracking") {

        "/quotation/congrats/unregistered"(platform: "/web") {
            item_id = "MLM2222222"
            category_id = "MLM170531"
            seller_id = 123456789
            vertical = "REAL_ESTATE"
            model_id = "102B"
            unit_id = 54321
            error_type = ""
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

    test("Quotation :: Click Credits Link") {
        "/quotation/credits_intention/card"(platform: "/web", type: TrackType.Event) {
            item_id = "MLC12345"
            source = "congrats_link"
            unit_id = 98123
        }
    }
}
