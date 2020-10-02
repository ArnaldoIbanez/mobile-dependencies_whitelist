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
    // TRACKS MYML Mercadoshops Access Denied
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Access Denied") {
        "/mercado_shops/access_denied"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            operator_id = 158689681
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
        "/mercado_shops/admin/sidebar/brands"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            success = true
        }
        "/mercado_shops/admin/sidebar/categories"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            success = true
            categories = ["category1", "category2", "category3", "category4"]
        }
        "/mercado_shops/admin/sidebar/collection"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
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
        "/mercado_shops/admin/sidebar/contact"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            street = "Posta"
            number = "3651"
            city = "Saavedra"
            state = "Buenos Aires"
            email = "test@mercadolibre.com"
            phone = "011 1234-5678"
            success = true
        }
        "/mercado_shops/admin/sidebar/fiscal_data"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            fiscal_data_visible = true
            success = true
        }
        "/mercado_shops/admin/sidebar/whatsapp"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            success = true
        }
        "/mercado_shops/admin/sidebar/discovery_advanced"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            theme = "DEFAULT"
            success = true
        }
        "/mercado_shops/admin/sidebar/discovery"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            max_items = 4
            categories = ["category1", "category2", "category3", "category4"]
            success = true
        }
        "/mercado_shops/admin/sidebar/flash_info"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            success = true
        }
        "/mercado_shops/admin/sidebar/footer_message"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            success = true
        }
        "/mercado_shops/admin/sidebar/grid"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            items_per_row = 3
            max_items = 6
            success = true
        }
        "/mercado_shops/admin/sidebar/header_advanced"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            transparency = 0.3
            success = true
        }
        "/mercado_shops/admin/sidebar/header_info"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
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
        "/mercado_shops/admin/sidebar/menu"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            categories = ["category1", "category2", "category3", "category4"]
            success = true
        }
        "/mercado_shops/admin/sidebar/mosaic"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            max_items = 5
            success = true
        }
        "/mercado_shops/admin/sidebar/price_and_image"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            categories = ["category1", "category2", "category3", "category4"]
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
        "/mercado_shops/admin/sidebar/social_networks"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            facebook = true
            twitter = true
            instagram = true
            youtube = true
            success = true
        }
        "/mercado_shops/admin/sidebar/subdomain"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            subdomain = "test-shop"
        }
        "/mercado_shops/admin/sidebar/tabbed_carousel"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            filters = ['filter1', 'filter2', 'filter3']
            success = true
        }
        "/mercado_shops/admin/sidebar/text_banner"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
            desktop_image = "my first umage"
            mobile_image = "my second image"
            link_url = "google.com.ar"
            success = true
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

    test("Mercadoshops Unavailable view") {
        "/mercado_shops/admin/unavailable"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
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
        "/mercado_shops/marketing/google_analytics"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/marketing/google_ads"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/marketing/google_ads/confirmation"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/marketing/google_ads/intention"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/marketing/google_ads/remarketing"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/marketing/facebook_pixel"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/marketing/google_search_console"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/marketing/facebook"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/facebook/store"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/facebook/store/fan_pages"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/facebook/store/business_manager"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/facebook/store/user_procedure"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/facebook/store/pixel_activation"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/facebook/store/context_help"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google/shopping"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google/shopping/introduction"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google/shopping/introduction/context_help"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google/shopping/configuration"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google/shopping/product_feed"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google/shopping/procedure"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google/shopping/resume"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/instagram"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/instagram/context_help"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }

    test("Mercadoshops Merketing Tools events") {
        "/mercado_shops/marketing/google_analytics/save"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_analytics/delete"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_analytics/open_faqs"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_analytics/cancel"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_analytics/context_help"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_ads/confirmation/save"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_ads/confirmation/delete"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_ads/confirmation/cancel"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_ads/confirmation/context_help"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_ads/intention/save"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_ads/intention/delete"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_ads/intention/cancel"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_ads/intention/context_help"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_ads/remarketing/save"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_ads/remarketing/delete"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_ads/remarketing/cancel"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_ads/remarketing/context_help"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/facebook_pixel/save"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/facebook_pixel/delete"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/facebook_pixel/cancel"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/facebook_pixel/context_help"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_search_console/upload"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/google_search_console/delete"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/facebook/store/link_with_facebook"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/marketing/facebook/store/pixel_activation/active"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Mercadoshops Templates selection flow
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Template Selection flow views") {
        "/mercado_shops/template-selection/summary"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
        "/mercado_shops/template-selection/preview"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
    }

    test("Template Selection events") {
        "/mercado_shops/template-selection/save"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            theme = "sports"
            success = true
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Mercadoshops Themes Customize flow
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Themes customize views") {
        "/mercado_shops/themes/customize"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
        }
    }

    test("Mercadoshops Themes customize events") {
        "/mercado_shops/themes/customize/upload"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Mercadoshops Custom menu
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Custom menu events") {
        "/mercado_shops/custom-categories/save"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
        }
        "/mercado_shops/custom-categories/summary"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            ref = ""
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

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // HUB Mercadoshop
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Hub") {
        "/mercado_shops/hub"(platform: "/", type: TrackType.View){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }

        "/mercado_shops/hub/view"(platform: "/", type: TrackType.View){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }

        "/mercado_shops/hub/onboarding"(platform: "/", type: TrackType.View){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }

        "/mercado_shops/hub/quick_access"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            quick_access = "Delegacion de dominio"
        }

        "/mercado_shops/hub/boost"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            option = "Facebook pixel"
        }

        "/mercado_shops/hub/google"(platform: "/", type: TrackType.View){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }

        "/mercado_shops/hub/google/shopping"(platform: "/", type: TrackType.View){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }

        "/mercado_shops/hub/google/shopping/activate"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }

        "/mercado_shops/hub/google/shopping/deactivate"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }

        "/mercado_shops/hub/google/shopping/reactivate"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Mercadoshops discounts
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Migration discounts") {
        "/mercado_shops/discounts"(platform: "/", type: TrackType.View){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/discounts/set"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            success = true
            status = 'ACTIVE'
            percentage = 5
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML-MARKETING Mercadoshops
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercadoshops Google Shopping") {
        "/mercado_shops/marketing/google_shopping_smart"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/campaign"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/dashboard"(platform: "/", type: TrackType.View) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/context_help"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/campaign/set"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/campaign/context_help"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/dashboard/delete"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/dashboard/pause"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/dashboard/activate"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
        "/mercado_shops/marketing/google_shopping_smart/dashboard/context_help"(platform: "/", type: TrackType.Event) {
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }
}
