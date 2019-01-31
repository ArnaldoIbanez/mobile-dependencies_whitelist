package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Listing
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central listing main page") {
        "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}
    }

    test("seller central listing differents tabs") {
        "/seller_central/listings/list/promos"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central listing action") {
        "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
            action_id = "MODIFY"
        }
    }

    test("seller central listing filters view") {
        "/seller_central/listings/filters"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central listing filters actions and search") {
        "/seller_central/listings/filters/action"(platform: "/", type: TrackType.Event) {
            action = "apply"
        }
        "/seller_central/listings/filters/action"(platform: "/", type: TrackType.Event) {
            action = "clear"
        }

        "/seller_central/listings/search"(platform: "/", type: TrackType.Event) {}
    }



    test("seller central listing onboarding view") {
        "/seller_central/listings/onboarding"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central listing onboarding actions") {
        "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
            action = "dismiss"
        }
        "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
            action = "start"
        }
    }

    test("seller central listing communications") {
        "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
            type = "news"
        }
        "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
            type = "task"
            id = "MODIFY"
        }
        "/seller_central/listings/communication/more_info"(platform: "/mobile", type: TrackType.Event) {
            type = "news"
        }
        "/seller_central/listings/communication/go"(platform: "/", type: TrackType.Event) {
            type = "news"           
            placement = "publicidad-banner"
            adv_segmentation = "winback"
            reputation_level="yellow"
        }
        "/seller_central/listings/communication/show"(platform: "/", type: TrackType.View) {
            type = "news"           
            placement = "publicidad-banner"
            adv_segmentation = "winback"
            reputation_level="yellow"
        }
    }

    test("seller central list to bulk editor") {
        "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central listing preferences") {
        "/seller_central/listings/preferences"(platform: "/", type: TrackType.Event) {
            id = "shipping"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Bulk
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central bulk view") {
        "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}
    }

    test("seller central bulk onboarding") {
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "start"
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "dismiss"
            page = 2
        }
        "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
            action = "rollback"
        }
    }

    test("seller central bulk view") {
        "/seller_central/bulk/domain"(platform: "/", type: TrackType.Event) {
            id = "technical_specification"
        }
    }

    test("seller central bulk filters and search") {
        "/seller_central/bulk/filters"(platform: "/", type: TrackType.Event) {
            filters = ["active", "inactive"]
        }
    }

    test("seller central bulk filters and search") {
        "/seller_central/bulk/undo_changes"(platform: "/", type: TrackType.Event) {}
        "/seller_central/bulk/search"(platform: "/", type: TrackType.Event) {}
    }


    test("seller central bulk columns") {
        "/seller_central/bulk/columns"(platform: "/", type: TrackType.Event) {
            columns = ["price", "quantity"]
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Offline
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central offline view") {
        "/seller_central/bulk/offline/home"(platform: "/", type: TrackType.View) {}
    }

    test("seller central offline download views") {
        "/seller_central/bulk/offline/download"(platform: "/", type: TrackType.View) {}
        "/seller_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {}
    }

    test("seller central offline upload views") {
        "/seller_central/bulk/offline/upload"(platform: "/", type: TrackType.View) {}
        "/seller_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {}
    }

    test("seller central offline download apply user selected columns and domains") {
        "/seller_central/bulk/offline/download/user_selection"(platform: "/", type: TrackType.Event) {
            domains = ["Mochilas", "Banquetas", "Bicicletas"]
            columns = ["price", "status"]

        }
    }

    test("seller central offline warning and error") {
        "/seller_central/bulk/offline/download/warning"(platform: "/", type: TrackType.Event) {}
        "/seller_central/bulk/offline/download/error"(platform: "/", type: TrackType.Event) {}
    }

//------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Bulk - DISCOUNTS version
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central bulk view") {
        "/seller_central/bulk/discounts/list"(platform: "/", type: TrackType.View) {}
    }

    test("seller central bulk onboarding") {
        "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
            action = "close"
        }
        "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
            action = "start"
        }
        "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
            action = "dismiss"
            page = 2
        }
        "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
            action = "rollback"
        }
    }

    test("seller central bulk filters and search") {
        "/seller_central/bulk/discounts/filters"(platform: "/", type: TrackType.Event) {
            filters = ["active", "inactive"]
        }
    }

    test("seller central bulk filters and search") {
        "/seller_central/bulk/discounts/undo_changes"(platform: "/", type: TrackType.Event) {}
        "/seller_central/bulk/discounts/search"(platform: "/", type: TrackType.Event) {}
    }


    test("seller central bulk columns") {
        "/seller_central/bulk/discounts/columns"(platform: "/", type: TrackType.Event) {
            columns = ["price", "quantity"]
        }
    }

    test("seller central bulk save") {
        "/seller_central/bulk/discounts/save"(platform: "/", type: TrackType.Event) {}
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Offline - DISCOUNTS version
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central offline view") {
        "/seller_central/bulk/discounts/offline/home"(platform: "/", type: TrackType.View) {}
    }

    test("seller central offline download views") {
        "/seller_central/bulk/discounts/offline/download"(platform: "/", type: TrackType.View) {}
        "/seller_central/bulk/discounts/offline/download/congrats"(platform: "/", type: TrackType.View) {}
    }

    test("seller central offline upload views") {
        "/seller_central/bulk/discounts/offline/upload"(platform: "/", type: TrackType.View) {}
        "/seller_central/bulk/discounts/offline/upload/congrats"(platform: "/", type: TrackType.View) {}
    }

    test("seller central offline download apply user selected columns and domains") {
        "/seller_central/bulk/discounts/offline/download/user_selection"(platform: "/", type: TrackType.Event) {
            domains = ["Mochilas", "Banquetas", "Bicicletas"]
            columns = ["price", "status"]

        }
    }

    test("seller central offline warning and error") {
        "/seller_central/bulk/discounts/offline/download/warning"(platform: "/", type: TrackType.Event) {}
        "/seller_central/bulk/discounts/offline/download/error"(platform: "/", type: TrackType.Event) {}
    }


    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central modify
    //------------------------------------------------------------------------------------------------------------------------------------------------------


    test("seller central render detail"){
        "/seller_central/modify/detail"(platform: "/", type: TrackType.View){
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
        }
    }

    test("seller central render variations"){
        "/seller_central/modify/variations"(platform: "/", type: TrackType.View){
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
        }
    }

    test("seller central render custom variations"){
        "/seller_central/modify/variations_custom"(platform: "/", type: TrackType.View){
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
        }
    }

    test("seller central render listing_type"){
        "/seller_central/modify/listing_type"(platform: "/", type: TrackType.View){
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
        }
    }

    test("seller central listing type value updated"){
        "/seller_central/modify/update_listing_types"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "gold_special"
            to = "gold_pro"
        }
    }

    test("seller central track to measure health changes"){
        "/seller_central/modify/success"(platform: "/web", type: TrackType.Event){
            item_id = "MLA12345"
            session_id = "123-update-abc123"
            goals_achieved = ["mercado_envios"]
            original_goals_not_completed = ["mercado_envios", "pictures"]
            original_goals_completed = ["technical_specifications"]
            original_goals_not_applied = ["price_parity"]
            goal_order = "random"
            original_price = 123.4
            original_currency = "ARS"
            original_listing_type = "gold_special"
            original_quantity = 2
            original_condition = "used"
            original_shipping = "ME_BUYER"
            original_local_pickup = true
            domain = "cellphones"
            is_fbm = true
            is_catalog_product = true
            technical_specifications_attributes_empty = 0
            technical_specifications_attributes_loaded = 5
            seller_experience = "ADVANCED"
            is_official_store = true
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Structured Data
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("structured data hint available"){
        "/seller_central/modify/technical_specifications/hints/available"(platform: "/", type: TrackType.Event){
            type = "actionable"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
        }
    }

    test("structured data hint showed"){
        "/seller_central/modify/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event){
            type = "info"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
        }
    }

    test("structured data hint completed"){
        "/seller_central/modify/technical_specifications/hints/completed"(platform: "/", type: TrackType.Event){
            type = "actionable"
            user_action = "click"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
        }
    }

    test("structured data hint available"){
        "/seller_central/bulk/technical_specifications/hints/available"(platform: "/", type: TrackType.Event){
            type = "actionable"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
        }
    }

    test("structured data hint showed"){
        "/seller_central/bulk/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event){
            type = "info"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
        }
    }


    test("structured data hint completed"){
        "/seller_central/bulk/technical_specifications/hints/completed"(platform: "/", type: TrackType.Event){
            type = "actionable"
            user_action = "click"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central settings
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central settings view"){
        "/seller_central/settings"(platform: "/", type: TrackType.View){
            reputation_level = "5_green"
            seller_profile = "advanced"
        }
    }


    test("seller central empty settings view"){
        "/seller_central/empty_settings"(platform: "/", type: TrackType.View){
            seller_profile = "newbie"
        }
    }

    test("seller central settings view event when a row is displayed"){
        "/seller_central/settings/show_row"(platform: "/", type: TrackType.Event){
            row_id = "row_shipping_address"
            ui_type = "row"
            section = "shipping"
        }
    }

    test("seller central settings view event when a row is updated"){
        "/seller_central/settings/update_row"(platform: "/", type: TrackType.Event){
            to = "DEFAULT"
            from = "THERMAL"
            row_id = "row_printer_method"
            section_id = "shipping"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Sales
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central sales list view") {
        "/seller_central/sales/list"(platform: "/", type: TrackType.View) {}
    }

    test("seller central sales detail view") {
        "/seller_central/sales/detail"(platform: "/", type: TrackType.View) {}
    }

    test("seller central sales dashboard tasks") {
        "/seller_central/sales/list/dashboard/tasks"(platform: "/", type: TrackType.Event) {
            tasks = ["ready", "print"]
        }
    }

    test("seller central sales dashboard task") {
        "/seller_central/sales/list/dashboard/task"(platform: "/", type: TrackType.Event) {
            id = "prepare"
        }
    }

}