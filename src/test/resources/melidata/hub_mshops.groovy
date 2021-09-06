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
        "/shops/hub/sidebar/whatsapp/success"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "success"
            event_label = "whatsapp"
        }

        "/shops/hub/sidebar/whatsapp/error"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "error"
            event_label = "whatsapp"
        }

        "/shops/hub/sidebar/shop_name/success"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "success"
            event_label = "shop_name"
        }

        "/shops/hub/sidebar/shop_name/error"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "error"
            event_label = "shop_name"
        }

        "/shops/hub/sidebar/logo/success"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "success"
            event_label = "logo"
        }

        "/shops/hub/sidebar/logo/error"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "error"
            event_label = "logo"
        }

        "/shops/hub/sidebar/contact"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "show"
            event_label = "contact"
        }

        "/shops/hub/sidebar/contact/success"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "success"
            event_label = "contact"
        }

        "/shops/hub/sidebar/contact/error"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "error"
            event_label = "contact"
        }

        "/shops/hub/sidebar/social_networks"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "show"
            event_label = "social_networks"
        }

        "/shops/hub/sidebar/social_networks/success"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "success"
            event_label = "social_networks"
        }

        "/shops/hub/sidebar/social_networks/error"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "error"
            event_label = "social_networks"
        }

        "/shops/hub/sidebar/afip"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "show"
            event_label = "afip"
        }

        "/shops/hub/sidebar/afip/success"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "success"
            event_label = "afip"
        }

        "/shops/hub/sidebar/afip/error"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "error"
            event_label = "afip"
        }

        "/shops/hub/sidebar/fiscal_data"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "show"
            event_label = "fiscal_data"
        }

        "/shops/hub/sidebar/fiscal_data/success"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "success"
            event_label = "fiscal_data"
        }

        "/shops/hub/sidebar/fiscal_data/error"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_name = "TESTSHOP"
            shop_domain = "test.mercadolibre.com.co"
            domain_status = "shops_domain"
            event_category = "sidebar"
            event_action = "error"
            event_label = "fiscal_data"
        }
    }
}
