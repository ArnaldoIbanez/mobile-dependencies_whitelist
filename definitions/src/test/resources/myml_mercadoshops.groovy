
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Mercadoshops Admin
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Admin") {
        "/myml/mercadoshops/admin"(platform: "/", type: TrackType.View) {
            custId = 158689680
            shopDomain = "www.test-shop.mercadoshops.com.ar"
            shopName = "Test Shop"
        }
    }

    test("Mercadoshops Admin Sidebars") {
        "/myml/mercadoshops/admin/sidebar"(platform: "/", type: TrackType.Event) {
            sidebarName = "SHOP_NAME"
        }
    }

    test("Mercadoshops Admin Sidebars Configuration Events") {
        "/myml/mercadoshops/admin/sidebar/afip"(platform: "/", type: TrackType.Event) {}
        "/myml/mercadoshops/admin/sidebar/banner"(platform: "/", type: TrackType.Event) {
            imageId = "784348-MLA28624404159_112018"
            alignment = "center"
        }
        "/myml/mercadoshops/admin/sidebar/colors"(platform: "/", type: TrackType.Event) {
            presetName = "dummy preset"
            colors = ["#000", "#fff"]
        }
        "/myml/mercadoshops/admin/sidebar/logo"(platform: "/", type: TrackType.Event) {
            imageId = "784348-MLA28624404159_112018"
        }
        "/myml/mercadoshops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event) {
            shopName = "Test Shop"
        }
        "/myml/mercadoshops/admin/sidebar/slider"(platform: "/", type: TrackType.Event) {
            imageList = ["784348-MLA28624404159_112018", "784348-MLA28624404159_112019", "784348-MLA28624404159_112020"]
            sliderSize = 'medium'
        }
        "/myml/mercadoshops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event) {
            subdomain = "test-shop"
        }
    }
}
