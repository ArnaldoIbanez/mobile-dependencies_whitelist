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
                "mercado_ads": "not_configured",
                "whatsapp": "not_configured",
                "facebook_shop": "configured",
                "facebook_pixel": "configuring",
                "instagram_shop": "error",
                "google_analytics": "blocked",
                "google_shopping": "unavailable",
                "google_ads": "configured",
                "google_search_console": "configured",
                "domain": "configured",
                "contact_data": "not_configured",
            ]
            cards = [
                "publications": 0,
                "sales": 19,
                "promotions": 5,
                "marketing": 1,
            ]
        }
    }

    test("Mercado Shops hub onboarding") {
        "/shops/hub/onboarding"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }
    }

    test("Mercado Shops edit section") {
        "/shops/hub/edit"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            type = "logo"
        }
    }

    test("Mercado Shops manage tools") {
        "/shops/hub/configuration"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "whatsapp"
        }

        "/shops/hub/modify"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "facebook_shop"
        }

        "/shops/hub/link"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "facebook_pixel"
        }

        "/shops/hub/know_more"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "google_analytics"
        }

        "/shops/hub/review"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "instagram_shop"
        }

        "/shops/hub/verify"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "google_shopping"
        }

        "/shops/hub/solve"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "google_ads"
        }

        "/shops/hub/activate"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "mercado_ads"
        }

        "/shops/hub/engage"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "mercado_ads"
        }

        "/shops/hub/reactivate"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "mercado_ads"
        }

        "/shops/hub/configuration/show_more"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }
    }

    test("Mercado Shops cards") {
        "/shops/hub/manage/listings"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/view/listings"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/modify/listings"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/add/codes"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/add/listings"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/edit/prices_combos"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            card = "listings"
        }

        "/shops/hub/manage_sales"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/modify/sales_listings"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/promotions_configuration"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            card = "promotions"
        }

        "/shops/hub/promotions_central"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            card = "promotions"
        }

        "/shops/hub/view_report"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            card = "promotions"
        }

        "/shops/hub/marketing_configuration"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            card = "marketing"
        }

        "/shops/hub/marketing_configuration"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            card = "marketing"
        }

        "/shops/hub/show_more"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            card = "promotions"
        }

        "/shops/hub/review_sales"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            sale_status = "to_review"
        }
    }

    test("Mercado Shops metrics section") {
        "/shops/hub/metrics/show_more"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }
    }

    test("Mercado Shops seller coach") {
        "/shops/hub/social"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            location = "footer"
            social_network = "youtube"
        }

        "/shops/hub/play"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "tutorial"
            video_id = "1_manage_your_shop"
        }

        "/shops/hub/inspiration_store"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            example_store = "example_store_name"
        }

        "/shops/hub/seller_central"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/content_center"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/play_video"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            video_id = 1
        }

        "/shops/hub/skip_note"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            note_id = 1
        }

        "/shops/hub/read_note"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            note_id = 1
        }
    }

    test("Mercado Shops tips and news") {
        "/shops/hub/more_about/show_more"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
        }

        "/shops/hub/tips_news/show_more"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "whatsapp"
        }

        "/shops/hub/tips_news/configuration"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "facebook_shop"
        }

        "/shops/hub/tips_news/link"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            tool = "google_shopping"
        }
    }

    test("Mercado Shops sidebars") {
        "/shops/hub/sidebar"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            sidebar_name = "logo"
        }

        "/shops/hub/sidebar/save_changes"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            success = true
            sidebar_name = "whatsapp"
        }

        "/shops/hub/sidebar/save_changes"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            success = true
            sidebar_name = "social_networks"
            configured_fields = ["twitter", "facebook", "instagram"]
        }
    }
}
