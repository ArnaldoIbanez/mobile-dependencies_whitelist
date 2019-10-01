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

    test("seller central listing item_description") {
        "/seller_central/listings/list/item_description"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central listing health") {
        "/seller_central/listings/list/health"(platform: "/", type: TrackType.Event) {
            health_id = "ID"
        }
    }

    test("seller central listing action") {
        "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
            action_id = "MODIFY"
        }
    }

    test("seller central listing secondary_actions") {
        "/seller_central/listings/list/secondary_actions"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central listing filters view") {
        "/seller_central/listings/filters"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central listing filters view") {
        "/seller_central/listings/filters/applied"(platform: "/", type: TrackType.Event) {
            checkedFilters = ["inactive", "premium"]
        }
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
            viewId = "inventario"
        }
        "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
            action = "start"
            page = 1
        }
    }

    test("seller central listing onboarding pdp") {
        "/seller_central/listings/onboarding/pdp"(platform: "/", type: TrackType.View) {}
    }

    test("seller central listing onboarding pdp action") {
        "/seller_central/listings/onboarding/pdp/action"(platform: "/", type: TrackType.Event) {
            action = "accept"
        }
        "/seller_central/listings/onboarding/pdp/action"(platform: "/", type: TrackType.Event) {
            action = "cancel"
        }
    }

    test("seller central listing communications") {
        "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
            type = "news"
        }
        "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
            type = "task"
            id = "MODIFY"
            action = "show"
        }
        "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
            type = "task"
            id = "LOW_HEALTH"
            action = "edit"
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
        "/seller_central/listings/communication/go"(platform: "/", type: TrackType.Event) {
            type = "news"
            placement = "publicidad-banner"
            reputation_level="yellow"
        }
        "/seller_central/listings/communication/show"(platform: "/", type: TrackType.View) {
            type = "news"
            placement = "publicidad-banner"
            reputation_level="yellow"
        }
        "/seller_central/listings/communication/go"(platform: "/", type: TrackType.Event) {
            type = "news"
            placement = "publicidad-banner"
            adv_segmentation = "winback"
        }
        "/seller_central/listings/communication/show"(platform: "/", type: TrackType.View) {
            type = "news"
            placement = "publicidad-banner"
            adv_segmentation = "winback"
        }
        "/seller_central/listings/communication/go"(platform: "/", type: TrackType.Event) {
            type = "news"
            placement = "publicidad-banner"
        }
        "/seller_central/listings/communication/show"(platform: "/", type: TrackType.View) {
            type = "news"
            placement = "publicidad-banner"
        }
    }

    test("seller central list to bulk editor") {
        "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central show help me modal") {
        "/seller_central/listings/helpme"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central listing preferences") {
        "/seller_central/listings/preferences"(platform: "/", type: TrackType.Event) {
            id = "shipping"
        }
    }

    test("seller central listing inventory moderation remedy") {
        "/seller_central/listings/inventory_status/remedy"(platform: "/", type: TrackType.Event) {
            id = "reactivate"
        }
    }

    test("seller central listing quantity +info") {
        "/seller_central/listings/quantity/info"(platform: "/", type: TrackType.Event) {}
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
            viewId = "fulfillment"
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

    test("seller central bulk changes price") {
        "/seller_central/bulk/changes/price"(platform: "/", type: TrackType.Event) {
            oldValue = "20"
            newValue = "25"
            itemId = "MLB341920"
        }
    }

    test("seller central bulk shipping tooltip") {
        "/seller_central/bulk/shipping/tooltip"(platform: "/", type: TrackType.Event) {
            itemId = "MLB341920"
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
    // TRACKS Seller Central BULK Publish
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    test("seller central bulk publish hub view") {
        "/seller_central/bulk/publish/hub"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish categories view") {
        "/seller_central/bulk/publish/categories"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish upload view") {
        "/seller_central/bulk/publish/upload"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish download congrats view") {
        "/seller_central/bulk/publish/download/congrats"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish upload congrats view") {
        "/seller_central/bulk/publish/upload/congrats"(platform: "/web", type: TrackType.View) {}
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central modify
    //------------------------------------------------------------------------------------------------------------------------------------------------------


    test("seller central render detail"){
        "/seller_central/modify/detail"(platform: "/", type: TrackType.View){
            item_type = "default"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central render variations"){
        "/seller_central/modify/variations"(platform: "/", type: TrackType.View){
            item_type = "default"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central render custom variations"){
        "/seller_central/modify/variations_custom"(platform: "/", type: TrackType.View){
            item_type = "default"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central render listing_type"){
        "/seller_central/modify/listing_type"(platform: "/", type: TrackType.View){
            item_type = "default"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central render subflow"){
        "/seller_central/modify/subflow"(platform: "/", type: TrackType.View){
            item_type = "default"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central price value updated"){
        "/seller_central/modify/update_price"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "1200"
            to = "1500"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central quantity value updated"){
        "/seller_central/modify/update_quantity"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "3"
            to = "4"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central local pickup value updated"){
        "/seller_central/modify/update_localpickup_options"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "NO"
            to = "SI"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central warranty value updated"){
        "/seller_central/modify/update_warranty"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "WARRANTY_TYPE 6150835"
            to = "WARRANTY_TYPE 2230280"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central listing type value updated"){
        "/seller_central/modify/update_listing_types"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "gold_special"
            to = "gold_pro"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central flex value updated"){
        "/seller_central/modify/update_shipping_flex"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "true"
            to = "false"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central item condition value updated"){
        "/seller_central/modify/update_item_condition"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "new"
            to = "used"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central item size_chart value updated"){
        "/seller_central/modify/update_size_chart"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "-1"
            to = "6270"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central item price push winner was updated"){
        "/seller_central/modify/update_price_push_winner_pdp"(platform: "/", type: TrackType.Event) {
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            from = "-1"
            to = "6270"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    test("seller central track to measure health changes"){
        "/seller_central/modify/success"(platform: "/web", type: TrackType.Event){
            item_type = "default"
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

    test("seller central flex subflow"){
        "/seller_central/modify/optin_flex_subflow"(platform: "/", type: TrackType.View){
            item_type = "default"
            category_id = "MLA12812"
            item_id = "MLA776923789"
            session_id = "416163910-update-79c25d849574"
            seller_profile = "NEWBIE"
            listing_type = "gold_pro"
            shipping_local_pickup = true
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Structured Data
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("structured data hint available"){
        "/seller_central/modify/technical_specifications/hints/available"(platform: "/", type: TrackType.Event){
            item_type = "default"
            type = "actionable"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
            hint_id = "REPEATED_ATTRIBUTE"
        }
    }

    test("structured data hint showed"){
        "/seller_central/modify/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event){
            item_type = "default"
            type = "info"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
            hint_id = "REPEATED_ATTRIBUTE"
        }
    }

    test("structured data hint completed"){
        "/seller_central/modify/technical_specifications/hints/completed"(platform: "/", type: TrackType.Event){
            item_type = "default"
            type = "actionable"
            user_action = "click"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
            hint_id = "REPEATED_ATTRIBUTE"
        }
    }

    test("structured data hint available"){
        "/seller_central/bulk/technical_specifications/hints/available"(platform: "/", type: TrackType.Event){
            type = "actionable"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
            hint_id = "REPEATED_ATTRIBUTE"
        }
    }

    test("structured data hint showed"){
        "/seller_central/bulk/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event){
            type = "info"
            attribute = "BRAND"
            category_domain= "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
            hint_id = "REPEATED_ATTRIBUTE"
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
            hint_id = "REPEATED_ATTRIBUTE"
        }
    }

    test("structured data multivalue"){
        "/seller_central/modify/technical_specifications/multivalue"(platform: "/", type: TrackType.Event){
            item_type = "default"
            quantity = 3
            previous_quantity = 0
            category_domain = "MLA-SHORTS"
            hierarchy = "PRODUCT_IDENTIFIER"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
            attribute= "BRAND"
        }
    }

    test("structured data suggested values"){
        "/seller_central/modify/technical_specifications/suggested"(platform: "/", type: TrackType.Event){
            item_type = "default"
            type = "dynamic"
            category_domain = "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
            hierarchy = "PRODUCT_IDENTIFIER"
            attribute = "BRAND"
        }
    }

    test("structured data change category"){
        "/seller_central/modify/update_change_category"(platform: "/", type: TrackType.Event){
            item_type = "default"
            category_domain = "MLA-CAMERAS"
            item_id= "MLA682118081"
            session_id = "123-update-abc123"
        }
    }

    test("structured data hidden attributes (open)"){
        "/seller_central/modify/technical_specifications/hidden_attributes/open"(platform: "/", type: TrackType.Event){
            session_id = "123-update-abc123"
            seller_id = 415920446
            item_id = "MLA682118081"
            item_type = "default"
            category_domain = "MLA-CAMERAS"
            times_showed = 1
            attributes = 3
            type = "CONFIRM"
        }
    }

    test("structured data hidden attributes (add)"){
        "/seller_central/modify/technical_specifications/hidden_attributes/add"(platform: "/", type: TrackType.Event){
            session_id = "123-update-abc123"
            seller_id = 415920446
            item_id = "MLA682118081"
            item_type = "default"
            category_domain = "MLA-CAMERAS"
            attribute = "BRAND"
            type = "CONFIRM"
        }
    }

    test("structured data hidden attributes (change)"){
        "/seller_central/modify/technical_specifications/hidden_attributes/change"(platform: "/", type: TrackType.Event){
            session_id = "123-update-abc123"
            seller_id = 415920446
            item_id = "MLA682118081"
            item_type = "default"
            category_domain = "MLA-CAMERAS"
            attribute = "BRAND"
            value = "Sony"
            type = "CONFIRM"
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

    test("seller central sales onboarding action") {
        "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
            id = "start"
            page = 1
        }
        "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
            id = "dismiss"
            page = 2
        }
        "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
            id = "close"
            page = 3
        }
    }

    test("seller central sales nfe onboarding action") {
        "/seller_central/sales/list/nfe_onboarding/action"(platform: "/", type: TrackType.Event) {
            id = "start"
            page = 1
        }
        "/seller_central/sales/list/nfe_onboarding/action"(platform: "/", type: TrackType.Event) {
            id = "dismiss"
            page = 2
        }
        "/seller_central/sales/list/nfe_onboarding/action"(platform: "/", type: TrackType.Event) {
            id = "close"
            page = 3
        }
    }

    test("seller central sales search") {
        "/seller_central/sales/list/search"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central sales pagination") {
        "/seller_central/sales/list/pagination"(platform: "/web", type: TrackType.Event) {
            page = 2
            total = 10
        }
    }

    test("seller central sales list action modal open") {
        "/seller_central/sales/list/modal_action/open"(platform: "/web", type: TrackType.Event) {
            id = "action_modal_id"
        }
    }

    test("seller central sales list action modal close") {
        "/seller_central/sales/list/modal_action/close"(platform: "/web", type: TrackType.Event) {
            id = "action_modal_id"
        }
    }

    test("seller central sales list action modal apply") {
        "/seller_central/sales/list/modal_action/apply"(platform: "/web", type: TrackType.Event) {
            id = "action_modal_id"
            option = "option_id"
        }
    }

    test("seller central sales web dashboard open") {
        "/seller_central/sales/list/dashboard/open"(platform: "/web", type: TrackType.Event) {
            substates = ["card_id_1", "card_id_2"]
        }
    }

    test("seller central sales mobile dashboard open") {
        "/seller_central/sales/list/dashboard/open"(platform: "/mobile", type: TrackType.Event) {
            state = "state_id"
            substates = ["card_id_1", "card_id_2"]
        }
    }

    test("seller central sales dashboard close") {
        "/seller_central/sales/list/dashboard/close"(platform: "/web", type: TrackType.Event) {}
    }

    test("seller central sales dashboard task") {
        "/seller_central/sales/list/dashboard/apply"(platform: "/", type: TrackType.Event) {
            state = "column_id"
            substate = "card_id"
            count = 5
        }
    }

    test("seller central sales list filters view") {
        "/seller_central/sales/list/filters"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central sales filters open") {
        "/seller_central/sales/list/filters/open"(platform: "/web", type: TrackType.Event) {}
    }

    test("seller central sales filters action") {
        "/seller_central/sales/list/filters/action"(platform: "/", type: TrackType.Event) {
            id = "apply"
            filters = ["filter_id_1", "filter_id_2"]
            sort = "ASC"
        }
        "/seller_central/sales/list/filters/action"(platform: "/", type: TrackType.Event) {
            id = "clear"
            filters = ["filter_id_1", "filter_id_2"]
            sort = "DESC"
        }
    }

    test("seller central sales massive action") {
        "/seller_central/sales/list/massive"(platform: "/web", type: TrackType.Event) {
            id = "massive_action_id"
            count = 20
        }
    }

    test("seller central sales row open") {
        "/seller_central/sales/list/row/open"(platform: "/web", type: TrackType.Event) {}
    }

    test("seller central sales list primary action show") {
        "/seller_central/sales/list/action/primary/show"(platform: "/web", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales list primary action") {
        "/seller_central/sales/list/action/primary"(platform: "/web", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales list secondary secondary") {
        "/seller_central/sales/list/action/secondary"(platform: "/web", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales detail view") {
        "/seller_central/sales/detail"(platform: "/", type: TrackType.View) {}
    }

    test("seller central sales detail row close") {
        "/seller_central/sales/detail/row/close"(platform: "/web", type: TrackType.Event) {}
    }

    test("seller central sales detail primary action show") {
        "/seller_central/sales/detail/action/primary/show"(platform: "/web", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales detail primary action") {
        "/seller_central/sales/detail/action/primary"(platform: "/web", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales detail secondary action") {
        "/seller_central/sales/detail/action/secondary"(platform: "/web", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales print action") {
        "/seller_central/sales/detail/action/print"(platform: "/web", type: TrackType.Event) {}
    }

    test("seller central sales detail action modal open") {
        "/seller_central/sales/detail/modal_action/open"(platform: "/web", type: TrackType.Event) {
            id = "action_modal_id"
        }
    }

    test("seller central sales detail action modal close") {
        "/seller_central/sales/detail/modal_action/close"(platform: "/web", type: TrackType.Event) {
            id = "action_modal_id"
        }
    }

    test("seller central sales detail action modal apply") {
        "/seller_central/sales/detail/modal_action/apply"(platform: "/web", type: TrackType.Event) {
            id = "action_modal_id"
            option = "option_id"
        }
    }

    test("seller central sales detail main action") {
        "/seller_central/sales/detail/main_action"(platform: "/mobile", type: TrackType.Event) {
            id = "PRODUCT_DELIVERED"
        }
    }

    test("seller central sales detail secondary action") {
        "/seller_central/sales/detail/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            id = "HELP_ACTION"
        }
    }

    test("seller central sales detail payment") {
        "/seller_central/sales/detail/payment"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central sales detail shipping") {
        "/seller_central/sales/detail/shipping"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central sales detail shipping action") {
        "/seller_central/sales/detail/shipping/action"(platform: "/mobile", type: TrackType.Event) {
            id = "FOLLOW_SHIPPING"
        }
    }

    test("seller central sales detail invoice information") {
        "/seller_central/sales/detail/invoice_info"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central sales detail buyer information") {
        "/seller_central/sales/detail/buyer_info"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central sales detail buyer information action") {
        "/seller_central/sales/detail/buyer_info/action"(platform: "/mobile", type: TrackType.Event) {
            id = "CALL"
        }
    }

    test("seller central sales detail driver information") {
        "/seller_central/sales/detail/driver_info"(platform: "/mobile", type: TrackType.View) {}
    }

    // TODO actor info

    test("seller central sales detail congrats") {
        "/seller_central/sales/detail/congrats"(platform: "/mobile", type: TrackType.View) {}
    }

    test("seller central sales detail cancellation flow") {
        "/seller_central/sales/detail/cancellation/landing"(platform: "/mobile", type: TrackType.View) {}
        "/seller_central/sales/detail/cancellation/order_selection"(platform: "/mobile", type: TrackType.View) {}
        "/seller_central/sales/detail/cancellation/reason_selection"(platform: "/mobile", type: TrackType.View) {}
        "/seller_central/sales/detail/cancellation/reason_input"(platform: "/mobile", type: TrackType.View) {}
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Catalog Optin
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central catalog optin") {
        "/seller_central/catalog"(platform: "/web", type: TrackType.View) {}
    }


    test("seller central catalog optin page view") {
        "/seller_central/catalog/optin"(platform: "/web", type: TrackType.View) {
            item_id = "MLA123"
            session_id = "123-product_optin-abc123"
            category_id = "MLA390784"
            category_domain = "MLA-FRAGRANCES"
            original_catalog_product_id = "MLA1055"
            variation_id = 1234567
            has_variations_already_opt_in = true
            children_catalog_products_ids = ["MLA1055"]
            has_variations = true
            seller_profile = "ADVANCED"
            reputation_level= "yellow"
            selected_catalog_product_id = "MLA1055"
            opt_in_item_id = "MLA234567"
            invalid_product_cause = "INVALID_CARRIER"
        }
    }

    test("seller central catalog invalid product page view") {
        "/seller_central/catalog/optin/invalid_product"(platform: "/web", type: TrackType.View) {
            item_id = "MLA123"
            session_id = "123-product_optin-abc123"
            category_id = "MLA390784"
            category_domain = "MLA-FRAGRANCES"
            original_catalog_product_id = "MLA1055"
            variation_id = 1234567
            has_variations_already_opt_in = true
            children_catalog_products_ids = ["MLA1055"]
            has_variations = true
            seller_profile = "ADVANCED"
            reputation_level= "yellow"
            selected_catalog_product_id = "MLA1055"
            opt_in_item_id = "MLA234567"
            invalid_product_cause = "INVALID_CARRIER"
        }
    }

    test("seller central catalog congrats page view") {
        "/seller_central/catalog/optin/congrats"(platform: "/web", type: TrackType.View) {
            item_id = "MLA123"
            session_id = "123-product_optin-abc123"
            category_id = "MLA390784"
            category_domain = "MLA-FRAGRANCES"
            original_catalog_product_id = "MLA1055"
            variation_id = 1234567
            has_variations_already_opt_in = true
            children_catalog_products_ids = ["MLA1055"]
            has_variations = true
            seller_profile = "ADVANCED"
            reputation_level= "yellow"
            selected_catalog_product_id = "MLA1055"
            opt_in_item_id = "MLA234567"
            invalid_product_cause = "INVALID_CARRIER"
        }
    }

    test("seller central catalog optin confirm card event") {
        "/seller_central/catalog/optin/confirm"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA123"
            session_id = "123-product_optin-abc123"
            category_id = "MLA390784"
            category_domain = "MLA-FRAGRANCES"
            original_catalog_product_id = "MLA1055"
            variation_id = 1234567
            has_variations_already_opt_in = true
            children_catalog_products_ids = ["MLA1055"]
            has_variations = true
            seller_profile = "ADVANCED"
            reputation_level= "yellow"
            selected_catalog_product_id = "MLA1055"
            opt_in_item_id = "MLA234567"
            invalid_product_cause = "INVALID_CARRIER"
            task_id = "product_picker"
            to = "MLA1074"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central - Promotions
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Seller Central Promotions - View event sending original promotion data"){
        "/seller_central/promotions"(platform: "/web", type: TrackType.View){
          original_promotion = [
              id: "MLA808249210",
              seller_id: 450981020,
              buying_mode: "buy_it_now",
              sale_terms: [
                  [
                      id: "LOYALTY_LEVEL_4",
                      value_id: null,
                      value_struct: [
                          number: 400,
                          unit: "ARS"
                      ]
                  ],
                  [
                      id: "LOYALTY_LEVEL_5",
                      value_id: null,
                      value_struct: [
                          number: 400,
                          unit: "ARS"
                      ]
                  ],
                  [
                      id: "LOYALTY_LEVEL_3",
                      value_id: null,
                      value_struct: [
                          number: 400,
                          unit: "ARS"
                      ]
                  ],
                  [
                      id: "LOYALTY_LEVEL_6",
                      value_id: null,
                      value_struct: [
                          number: 400,
                          unit: "ARS"
                      ]
                  ]
              ],
              campaigns: [],
              best_offer: null,
              price: 500,
              original_price: 1000,
              promotion: [
                  status: "started",
                  price: 500,
                  start_date: "2019-09-18T03:00:00.000Z",
                  finish_date: "2019-10-05T02:59:00.000Z",
                  list_price: 1000,
                  prime_price: 400
              ],
              visits: 27,
              available_quantity: 97,
              title: "Item De Testeo, Por Favor No Ofertar --kc:off",
              sold_quantity: 3,
              secure_thumbnail: "https://http2.mlstatic.com/resources/frontend/statics/processing-image/1.0.0/I-ES.jpg",
              currency: [
                  id: "ARS",
                  decimal_places: 2,
                  symbol: "\$"
              ],
              tags: [
                  "loyalty_discount_eligible",
                  "test_item",
                  "immediate_payment"
              ],
              validations: [],
              campaign_offers: [
                  [
                      offer_mode: "LONG_TAIL",
                      offer: null,
                      campaign: [
                          name: "campanianueva",
                          identifier: "MLA626",
                          start_date: "2018-10-26T16:10:00.000Z",
                          finish_date: "2019-12-12T13:17:21.000Z",
                          dead_line: "2019-03-03T00:57:00.000Z",
                          type: "discounts",
                          status: "started",
                          is_active: false,
                          is_available: false,
                          applied_offer: false
                      ]
                  ]
              ]
          ]
        }

        "/seller_central/promotions/actions"(platform: "/web", type: TrackType.Event){
            action = "SAVE_PROMOTION"
            promotion = [
                site_time_offset: 0,
                start_date: "2019-09-18T03:00:00.000Z",
                finish_date: "2019-10-05T02:59:00.000Z",
                state: "started",
                is_highlight: false,
                price: 500,
                prime_price: 400,
                list_price: 1000,
                error_price: null,
                error_prime: null,
                input_pice: "500",
                input_prime_price: "400",
                type: "always_on",
            ]
            promotion_duration = 17
        }
    }
}
