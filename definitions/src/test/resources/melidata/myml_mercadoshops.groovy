package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Mercadoshops Admin
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Admin") {
        "/mercado_shops/admin"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }

    test("Mercadoshops Admin Sidebars") {
        "/mercado_shops/admin/sidebar"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            sidebar_name = "SHOP_NAME"
        }
    }

    test("Mercadoshops Admin Sidebars Configuration Events") {
        "/mercado_shops/admin/sidebar/afip"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/admin/sidebar/banner"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            image_id = "784348-MLA28624404159_112018"
            alignment = "center"
        }
        "/mercado_shops/admin/sidebar/colors"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            preset_name = "dummy preset"
            colors = ["#000", "#fff"]
        }
        "/mercado_shops/admin/sidebar/logo"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            image_id = "784348-MLA28624404159_112018"
        }
        "/mercado_shops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/admin/sidebar/slider"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            image_list = ["784348-MLA28624404159_112018", "784348-MLA28624404159_112019", "784348-MLA28624404159_112020"]
            slider_size = 'medium'
        }
        "/mercado_shops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            subdomain = "test-shop"
        }
    }
}
