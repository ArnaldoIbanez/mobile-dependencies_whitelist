
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Mercadoshops Admin
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Admin") {
        "/myml/mercadoshops/admin"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }

    test("Mercadoshops Admin Sidebars") {
        "/myml/mercadoshops/admin/sidebar"(platform: "/", type: TrackType.Event) {
            sidebar_name = "SHOP_NAME"
        }
    }

    test("Mercadoshops Admin Sidebars Configuration Events") {
        "/myml/mercadoshops/admin/sidebar/afip"(platform: "/", type: TrackType.Event) {}
        "/myml/mercadoshops/admin/sidebar/banner"(platform: "/", type: TrackType.Event) {
            image_id = "784348-MLA28624404159_112018"
            alignment = "center"
        }
        "/myml/mercadoshops/admin/sidebar/colors"(platform: "/", type: TrackType.Event) {
            preset_name = "dummy preset"
            colors = ["#000", "#fff"]
        }
        "/myml/mercadoshops/admin/sidebar/logo"(platform: "/", type: TrackType.Event) {
            image_id = "784348-MLA28624404159_112018"
        }
        "/myml/mercadoshops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event) {
            shop_name = "Test Shop"
        }
        "/myml/mercadoshops/admin/sidebar/slider"(platform: "/", type: TrackType.Event) {
            image_list = ["784348-MLA28624404159_112018", "784348-MLA28624404159_112019", "784348-MLA28624404159_112020"]
            slider_size = 'medium'
        }
        "/myml/mercadoshops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event) {
            subdomain = "test-shop"
        }
    }
}
