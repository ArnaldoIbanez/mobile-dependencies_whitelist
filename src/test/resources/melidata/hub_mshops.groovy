package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
     
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Hub Mercadoshops
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercado Shops hub view") {
        "/shops/hub"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            shop_status = "active"
            domain_status = "shops_domain"
            configuration = [
                "whatsapp": "not_configured",
                "facebook_shop": "configured",
                "facebook_pixel": "configuring",
                "instagram": "error",
                "google_analytics": "blocked",
                "google_shopping": "unavailable",
                "google_ads": "configured",
                "google_search": "configured",
            ]
            cards = [
                "publications": 0,
                "sales": 19,
                "promotions": 5,
                "marketing": 1,
            ]
        }
    }

    test("Mercado Shops edit section") {
        "/shops/hub/edit"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
            type = "logo"
        }
    }

    test("Mercado Shops manage tools") {
        "/shops/hub/configuration"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
            tool = "whatsapp"
        }

        "/shops/hub/modify"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
            tool = "facebook_shop"
        }

        "/shops/hub/link"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
            tool = "facebook_pixel"
        }

        "/shops/hub/know_more"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
            tool = "google_analytics"
        }

        "/shops/hub/review"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
            tool = "instagram"
        }

        "/shops/hub/verify"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
            tool = "google_shopping"
        }

        "/shops/hub/solve"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
            tool = "google_ads"
        }

        "/shops/hub/configuration/show_more"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            business = "shops"
        }
    }
}
