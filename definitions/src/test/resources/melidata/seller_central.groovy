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
            item_type = "default"
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
            item_type = "default"
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
            item_type = "default"
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
            item_type = "default"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            category_domain = "MLA-FRAGRANCES"
            category_path = ["MLA1234", "MLA12345"]
            seller_profile = "ADVANCED"
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
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central modify pdp items
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("seller central price value updated for pdp items"){
        "/seller_central/modify/product_detail/update_price"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            comparison_table = [
                    item_data : [
                            item_price : 1500,
                            item_currency_id : "ARS",
                            item_premium : true,
                            item_free_shipping : true,
                            item_flex : false
                    ],
                    winner_data : [
                            winner_price : 1000,
                            winner_currency_id : "ARS",
                            winner_premium : true,
                            winner_free_shipping : true,
                            winner_flex : true
                    ]
            ]
            product_title = "Motorola G6 64 Gb Blush"
            product_id = "MLA9707912"
            products_quantity = 40
            listing_type = "gold_pro"
            shipping_local_pickup = "YES"
            buy_box_status = "LOSE"
            new_buy_box_status = "PENDING"
            from = "1200"
            to = "1500"
        }
    }

    test("seller central quantity value updated for pdp items"){
        "/seller_central/modify/product_detail/update_quantity"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            comparison_table = [
                    item_data : [
                            item_price : 1500,
                            item_currency_id : "ARS",
                            item_premium : true,
                            item_free_shipping : true,
                            item_flex : false
                    ],
                    winner_data : [
                            winner_price : 1000,
                            winner_currency_id : "ARS",
                            winner_premium : true,
                            winner_free_shipping : true,
                            winner_flex : true
                    ]
            ]
            product_title = "Motorola G6 64 Gb Blush"
            product_id = "MLA9707912"
            products_quantity = 40
            listing_type = "gold_pro"
            shipping_local_pickup = "YES"
            buy_box_status = "LOSE"
            new_buy_box_status = "PENDING"
            from = "3"
            to = "4"
        }
    }

    test("seller central local pickup value updated for pdp items"){
        "/seller_central/modify/product_detail/update_localpickup_options"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            comparison_table = [
                    item_data : [
                            item_price : 1500,
                            item_currency_id : "ARS",
                            item_premium : true,
                            item_free_shipping : true,
                            item_flex : false
                    ],
                    winner_data : [
                            winner_price : 1000,
                            winner_currency_id : "ARS",
                            winner_premium : true,
                            winner_free_shipping : true,
                            winner_flex : true
                    ]
            ]
            product_title = "Motorola G6 64 Gb Blush"
            product_id = "MLA9707912"
            products_quantity = 40
            listing_type = "gold_pro"
            shipping_local_pickup = "YES"
            buy_box_status = "LOSE"
            new_buy_box_status = "PENDING"
            from = "NO"
            to = "SI"
        }
    }

    test("seller central warranty value updated for pdp items"){
        "/seller_central/modify/product_detail/update_warranty"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            comparison_table = [
                    item_data : [
                            item_price : 1500,
                            item_currency_id : "ARS",
                            item_premium : true,
                            item_free_shipping : true,
                            item_flex : false
                    ],
                    winner_data : [
                            winner_price : 1000,
                            winner_currency_id : "ARS",
                            winner_premium : true,
                            winner_free_shipping : true,
                            winner_flex : true
                    ]
            ]
            product_title = "Motorola G6 64 Gb Blush"
            product_id = "MLA9707912"
            products_quantity = 40
            listing_type = "gold_pro"
            shipping_local_pickup = "YES"
            buy_box_status = "LOSE"
            new_buy_box_status = "PENDING"
            from = "WARRANTY_TYPE 6150835"
            to = "WARRANTY_TYPE 2230280"
        }
    }

    test("seller central invoice value updated for pdp items"){
        "/seller_central/modify/product_detail/update_invoice"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            comparison_table = [
                    item_data : [
                            item_price : 1500,
                            item_currency_id : "ARS",
                            item_premium : true,
                            item_free_shipping : true,
                            item_flex : false
                    ],
                    winner_data : [
                            winner_price : 1000,
                            winner_currency_id : "ARS",
                            winner_premium : true,
                            winner_free_shipping : true,
                            winner_flex : true
                    ]
            ]
            product_title = "Motorola G6 64 Gb Blush"
            product_id = "MLA9707912"
            products_quantity = 40
            listing_type = "gold_pro"
            shipping_local_pickup = "YES"
            buy_box_status = "LOSE"
            new_buy_box_status = "PENDING"
            from = "NO"
            to = "SI"
        }
    }

    test("seller central listing type value updated for pdp items"){
        "/seller_central/modify/product_detail/update_listing_types"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            comparison_table = [
                    item_data : [
                            item_price : 1500,
                            item_currency_id : "ARS",
                            item_premium : true,
                            item_free_shipping : true,
                            item_flex : false
                    ],
                    winner_data : [
                            winner_price : 1000,
                            winner_currency_id : "ARS",
                            winner_premium : true,
                            winner_free_shipping : true,
                            winner_flex : true
                    ]
            ]
            product_title = "Motorola G6 64 Gb Blush"
            product_id = "MLA9707912"
            products_quantity = 40
            listing_type = "gold_pro"
            shipping_local_pickup = "YES"
            buy_box_status = "LOSE"
            new_buy_box_status = "PENDING"
            from = "gold_special"
            to = "gold_pro"
        }
    }

    test("seller central flex value updated for pdp items"){
        "/seller_central/modify/product_detail/update_shipping_flex"(platform: "/", type: TrackType.Event){
            item_type = "product"
            category_id = "MLA390784"
            item_id = "MLA682118081"
            session_id = "123-update-abc123"
            seller_profile = "ADVANCED"
            comparison_table = [
                    item_data : [
                            item_price : 1500,
                            item_currency_id : "ARS",
                            item_premium : true,
                            item_free_shipping : true,
                            item_flex : false
                    ],
                    winner_data : [
                            winner_price : 1000,
                            winner_currency_id : "ARS",
                            winner_premium : true,
                            winner_free_shipping : true,
                            winner_flex : true
                    ]
            ]
            product_title = "Motorola G6 64 Gb Blush"
            product_id = "MLA9707912"
            products_quantity = 40
            listing_type = "gold_pro"
            shipping_local_pickup = "YES"
            buy_box_status = "LOSE"
            new_buy_box_status = "PENDING"
            from = "true"
            to = "false"
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

    test("seller central sales search") {
        "/seller_central/sales/list/search"(platform: "/", type: TrackType.Event) {}
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

    test("seller central sales pagination") {
        "/seller_central/sales/list/pagination"(platform: "/", type: TrackType.Event) {
            page = 2
            total = 10
        }
    }

    test("seller central sales list action modal open") {
        "/seller_central/sales/list/modal_action/open"(platform: "/", type: TrackType.Event) {
            id = "action_modal_id"
        }
    }

    test("seller central sales list action modal close") {
        "/seller_central/sales/list/modal_action/close"(platform: "/", type: TrackType.Event) {
            id = "action_modal_id"
        }
    }

    test("seller central sales list action modal apply") {
        "/seller_central/sales/list/modal_action/apply"(platform: "/", type: TrackType.Event) {
            id = "action_modal_id"
            option = "option_id"
        }
    }

    test("seller central sales detail action modal open") {
        "/seller_central/sales/detail/modal_action/open"(platform: "/", type: TrackType.Event) {
            id = "action_modal_id"
        }
    }

    test("seller central sales detail action modal close") {
        "/seller_central/sales/detail/modal_action/close"(platform: "/", type: TrackType.Event) {
            id = "action_modal_id"
        }
    }

    test("seller central sales detail action modal apply") {
        "/seller_central/sales/detail/modal_action/apply"(platform: "/", type: TrackType.Event) {
            id = "action_modal_id"
            option = "option_id"
        }
    }

    test("seller central sales dashboard tasks") {
        "/seller_central/sales/list/dashboard/show"(platform: "/", type: TrackType.Event) {
            substates = ["card_id_1", "card_id_2"]
        }
    }

    test("seller central sales dashboard open") {
        "/seller_central/sales/list/dashboard/open"(platform: "/", type: TrackType.Event) {}
    }
    
    test("seller central sales dashboard close") {
        "/seller_central/sales/list/dashboard/close"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central sales dashboard task") {
        "/seller_central/sales/list/dashboard/apply"(platform: "/", type: TrackType.Event) {
            state = "column_id"
            substate = "card_id"
            count = 5
        }
    }

    test("seller central sales massive action") {
        "/seller_central/sales/list/massive"(platform: "/", type: TrackType.Event) {
            id = "massive_action_id"
            count = 20
        }
    }

    test("seller central sales row open") {
        "/seller_central/sales/list/row/open"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central sales row close") {
        "/seller_central/sales/detail/row/close"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central sales filters open") {
        "/seller_central/sales/list/filters/open"(platform: "/", type: TrackType.Event) {}
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

    test("seller central sales print action") {
        "/seller_central/sales/detail/action/print"(platform: "/", type: TrackType.Event) {}
    }

    test("seller central sales list primary action show") {
        "/seller_central/sales/list/action/primary/show"(platform: "/", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales list primary action") {
        "/seller_central/sales/list/action/primary"(platform: "/", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales list secondary secondary") {
        "/seller_central/sales/list/action/secondary"(platform: "/", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales detail primary action show") {
        "/seller_central/sales/detail/action/primary/show"(platform: "/", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales detail primary action") {
        "/seller_central/sales/detail/action/primary"(platform: "/", type: TrackType.Event) {
            id = "action_id"
        }
    }

    test("seller central sales detail secondary action") {
        "/seller_central/sales/detail/action/secondary"(platform: "/", type: TrackType.Event) {
            id = "action_id"
        }
    }
}
