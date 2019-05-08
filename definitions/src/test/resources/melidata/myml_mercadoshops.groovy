package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Mercadoshops Optin
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Optin") {
        "/mercado_shops/optin"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = "myml_menu"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Mercadoshops Admin
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Admin") {
        "/mercado_shops/admin"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
    }

    test("Mercadoshops Admin Sidebars") {
        "/mercado_shops/admin/sidebar"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            sidebar_name = "SHOP_NAME"
        }
    }

    test("Mercadoshops Admin Sidebars Configuration Events") {
        "/mercado_shops/admin/sidebar/afip"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            success = true
        }
        "/mercado_shops/admin/sidebar/banner"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            image_id = "784348-MLA28624404159_112018"
            alignment = "center"
            success = true
        }
        "/mercado_shops/admin/sidebar/colors"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            preset_name = "dummy preset"
            colors = ["#000", "#fff"]
            success = true
        }
        "/mercado_shops/admin/sidebar/logo"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            image_id = "784348-MLA28624404159_112018"
            success = true
        }
        "/mercado_shops/admin/sidebar/shop_name"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            success = true
        }
        "/mercado_shops/admin/sidebar/slider"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            image_list = ["784348-MLA28624404159_112018", "784348-MLA28624404159_112019", "784348-MLA28624404159_112020"]
            slider_size = 'medium'
            success = true
        }
        "/mercado_shops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            subdomain = "test-shop"
        }
    }

    test("Mercadoshops Admin Deactivate") {
        "/mercado_shops/admin/deactivate_form"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
    }

    test("Mercadoshops Admin Dismiss Event") {
        "/mercado_shops/admin/deactivate"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            reason_id = "REASON_1"
            additional_comments = "Additional comment."
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Mercadoshops Domains Delegation flow
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Domains Delegation") {
        "/mercado_shops/domains"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "NOT_DELEGATED"
            ref = ""
        }
    }

    test("Mercadoshops Domains Delegation flow views") {
        "/mercado_shops/domains/summary"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "NOT_DELEGATED"
            ref = ""
        }
        "/mercado_shops/domains/subdomain"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "NOT_DELEGATED"
            ref = ""
        }
        "/mercado_shops/domains/delegation_form"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "NOT_DELEGATED"
            ref = ""
        }
        "/mercado_shops/domains/emails"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "REGISTERED"
            mx_registers = ["test1.register.mx", "test2.register.mx"]
            ref = ""
        }
        "/mercado_shops/domains/delegation_instructions"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "REGISTERED"
            dns_list = ["dnsps1.mercadolibre.com", "dnsps2.mercadolibre.com"]
            ref = ""
        }
        "/mercado_shops/domains/congrats"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "CHECK_FOR_TOTAL_DELEGATION"
            ref = ""
        }
        "/mercado_shops/domains/error_details"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "DELEGATION_ERROR"
            ref = ""
        }
    }

    test("Mercadoshops Domains Delegation flow events") {
        "/mercado_shops/domains/delegation_init"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "NOT_DELEGATED"
            domain = "testdomain.com"
            ref = ""
            success = true
        }
        "/mercado_shops/domains/subdomain_change"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "NOT_DELEGATED"
            subdomain = "testsubdomain.mercadoshops.com"
            ref = ""
            success = true
        }
        "/mercado_shops/domains/delegation_cancel"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            delegation_status = "ACTIVE"
            ref = ""
            success = true
        }
    }
}
