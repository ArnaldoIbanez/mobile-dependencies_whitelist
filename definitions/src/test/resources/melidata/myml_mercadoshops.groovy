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
    // TRACKS Mercadoshops Landing
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Landing") {
        "/mercado_shops/landing"(platform: "/", type: TrackType.View) {}
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Mercado Shops Migration
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Migration") {
        "/mercado_shops/migration"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = "myml_menu"
            is_migration_banner = false
            is_confirmation_banner = false
            is_show_dday_banner = false
        }

        "/mercado_shops/migration"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            is_migration_banner = true
            is_confirmation_banner = true
            is_show_dday_banner = true
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

    test("Mercadoshops Welcome") {
        "/mercado_shops/admin/welcome"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
    }

    test("Mercadoshops Welcome Modal Accept") {
        "/mercado_shops/admin/welcome/accept"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }

    test("Mercadoshops Welcome Modal Cancel") {
        "/mercado_shops/admin/welcome/cancel"(platform: "/", type: TrackType.Event) {
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

    test("Mercadoshops Admin Onboarding") {
        "/mercado_shops/admin/onboarding"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            trigger = "MODAL"
        }
    }

    test("Mercadoshops Admin Onboarding Steps") {
        "/mercado_shops/admin/onboarding/steps"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            scope = "STEP_1"
            trigger = "ICON"
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

    test("Mercadoshops Marketing Tools flow views") {
        "/mercado_shops/marketing/summary"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/marketing/google-analytics"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
    }

    test("Mercadoshops Merketing Tools events") {
        "/mercado_shops/marketing/google-analytics/save"(platform: "/", type: TrackType.event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google-analytics/open-faqs"(platform: "/", type: TrackType.event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google-analytics/cancel"(platform: "/", type: TrackType.event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google-analytics/context-help"(platform: "/", type: TrackType.event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Mercadoshops migration flow
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Migration flow events") {
        "/mercado_shops/admin/confirm_migration"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            scope = "editor"
        }
        "/mercado_shops/optin/step"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            index = 9124
            step = "fourth-step"
        }
    }
}
