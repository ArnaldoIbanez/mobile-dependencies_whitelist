package src.test.resources
import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("item_description step should be tracked"){
    	"/sell/list/item_description"(platform: "/", type: TrackType.View){
            session_id = "11111"
            listing_type_id = "1111"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "new"
            price = 10000
    	}
    }

    test("sale_condition step should be tracked"){
    	"/sell/list/sale_condition"(platform: "/", type: TrackType.View){
            session_id = "11111"
    	}
    }

    test("Selected a photo album in the list flow") {
        "/sell/list/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
            session_id = "245084411-list-4519bc3c72aa"
            album_name = "Galería de fotos"
        }
    }

    test("Selected a photo album in the modify flow") {
        "/sell/update/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA1234"
            album_name = "Galería de fotos"
        }
    }

    test("The intention of upgrading should be tracked"){
        "/sell/change_listing_type/upgrade_intention"(platform: "/web", type: TrackType.Event){
            source = "upgrade_on"
            seller_experience = "ADVANCED"
            item_id = "MLB13838282"
            vertical = "MOTOR"
        }
    }

    test("item_description step with attributes predicted"){
        "/sell/list/item_description/title_prediction"(platform: "/", type: TrackType.Event){
            session_id = "11111"
            category_id = "MLA123"
            domain_id = "MLA-CAMERAS"
            attributes = [
                [
                    OPERATING_SYSTEM:"Android"
                ]
            ]
        }
    }

    test("item_description step with attributes"){
        "/sell/list/item_description/final_attributes"(platform: "/", type: TrackType.Event){
            session_id = "11111"
            category_id = "MLA123"
            domain_id = "MLA-CAMERAS"
            attributes = [
                [
                    OPERATING_SYSTEM:"iOS"
                ]
            ]
        }
    }
    
    test("track qr barcode printing intention"){
        "/sell/qr/print_intention"(platform: "/web", type: TrackType.View){
            item_id = "MLA705994967"
            user_type = "normal"
            listing_type_id = "gold"
            vertical = "MOTOR" 
            referrer = "email"
        }
    }

    test("track for phone suggestion") {
        "/sell/list/phone_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "11111"
        }
    }

    test("tracks for zip code") {
        "/sell/list/zip_code"(platform: "/") { session_id = "214464778-list-d5e5a20b2935" }
        "/sell/list/zip_code/zip_code"(platform: "/") { session_id = "214464778-list-d5e5a20b2935" }
        "/sell/list/zip_code/zip_code/search_zip_code"(platform: "/") { session_id = "214464778-list-d5e5a20b2935" }
    }

    test("Sell change listing type track view"){
        def dataSetViewSingle = {
            source = "email_upgrade_7_days"
            item_id = "MLB123456"
            seller_experience = "ADVANCED"
            vertical = "CORE"
            listing_type_id = "gold_special"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            view_type = "upgrade_full_screen"
        }

        def dataSetViewMassive = {
            source = "my_account_listings"
            items_amount =  5
            seller_experience = "NEWBIE"
            view_type = "single_option"
        }

        "/sell/change_listing_type/single"(platform: "/web", dataSetViewSingle)
        "/sell/change_listing_type/massive"(platform: "/web", dataSetViewMassive)
    }

    test("Relist items"){
        def itemData = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            quantity = 8
        }

        def massiveItemData = {
            items_amount = 2
        }

        "/sell/quick_relist/single"  (platform: "/web/desktop", itemData)
        "/sell/quick_relist/massive" (platform: "/web/desktop", massiveItemData)

        "/sell/modify_and_relist/single/row"   (platform: "/web/desktop", itemData)
        "/sell/modify_and_relist/single/cards" (platform: "/web/desktop", itemData)
        "/sell/modify_and_relist/massive/row"  (platform: "/web/desktop", massiveItemData)
        "/sell/relist"
        "/sell/relist/congrats"(platform: "/web"){
            can_complete_attributes= true
        }
        "/sell/relist/relist_congrats"(platform: "/mobile"){
            item_id = "MLA12345"
        }
    }

    test("Sell Flow view Pages"){
        def itemData = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
        }

        "/sell/list/congrats"(platform: "/web/desktop", itemData)
        "/sell/upgrade_on"(platform: "/web/desktop", itemData)
    }
    test("Sell Flow view Pages"){
        def itemData = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "MOT"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            referer = "mail_upgrade_classified"
        }
        "/sell/upgradeOff"(platform: "/", itemData)
    }
    test("Sell landing free_listing"){
        def data={
            referer = "1234L"
        }

        "/sell/landing/free_listing"(platform: "/", data)
        "/sell/landing/free_listing"(platform: "/"){}
    }

    test("Native Sell List flow steps"){
        "/sell/list/congrats"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/sip"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/congrats"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_review"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/sip_landing"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/price_review"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/seller_registration"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/shipping_options_me"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/listing_types"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/price"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/picture_preview_landing"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_review/editor"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/listing_types_review"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/shipping_options_me_review"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/attribute"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/phone_suggestion"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/payment_methods"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/condition"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/congrats/payment_pending"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/color_selection"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/description_review"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/seller_registration_zip_code"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/category_navigation"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/category_suggestion"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/title"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/title_review"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/registration_landing"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/size_selection"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/description_included"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/location"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/size_selection_review"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/shipping_landing"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/shipping_flat_cost"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/price_modality"(platform:"/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/hub"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/walkthrough"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/hub_old"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip"(platform: "/mobile" ) {
            session_id = "214464778-list-d5e5a20b2935"
            has_selected_pictures = true
        }
        "/sell/list/sip/publish/back_selected"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/section/disabled"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/location"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/size_selection_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update" (platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/color_selection_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/condition"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/condition_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/description"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/description_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/include_description"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/listing_type"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/listing_types_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/manufacturing_time"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/manufacturing_time_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/payment_methods_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/payment_options"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/pictures"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/pictures_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/price"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/price_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/shipping_options"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/shipping_options_me_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/title"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category_suggestion"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category_navigation"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/color_selection"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/color_selection_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/condition"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/condition_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/payment_methods"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/payment_methods_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/gallery"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/editor"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/crop"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review/gallery"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review/editor"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review/crop"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price/similar_products"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price_review/similar_products"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/seller_registration"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/seller_registration_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/seller_registration_zip_code"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/size_selection"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/size_selection_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/title"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/title_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/shipping_options_me"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/shipping_options_me_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/registration_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/registration_zip_code_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/shipping_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip_price_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip_shipping_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip_condition_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip_condition_lt_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip_condition_listing_type_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/title_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types_upgrade"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/congrats_upgrade"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}

        "/sell/list/attribute"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/confirm_suggested"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/wrong_suggested"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/location"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/location_suggestion"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/manufacturing_time"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/modal/close/onboarding"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/phone"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_editor/function/crop"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_uploader/mode/camera"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/crop/crop_accepted"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/crop/crop_canceled"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price_modality"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/shipping_flat_cost"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}

        "/sell/list/drafts"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/drafts/draft_action/draft_deleted"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/drafts/draft_action/draft_resumed"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/publish/pictures_fail"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            fail_pictures = 2
            total_pictures = 6
            pictures_errors = ["error 1" , "error 2"]
        }
        "/sell/list/sip/publish/fail"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            error_message="error"
        }
        "/sell/list/sip/publish/publish_cancel"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/notification/view_item"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/notification/upgrade"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/notification/congrats"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price/similar_products/similar_item_selected"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price/similar_products/similar_item_shown"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types_upgrade"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/congrats_upgrade"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
    }

    test("Custom color name changed - Update"){
        "/sell/update/color_selection/custom_color"(platform: "/web"){
            session_id = "290061169-update-32b1d9b3eae8"
            category_domain = "MLA-GLOVES"
            is_custom_name = true
        }
    }

    test("Custom color name changed - List"){
        "/sell/list/color_selection/custom_color"(platform: "/web"){
            session_id = "290061169-list-32b1d9b3eae8"
            category_domain = "MLA-GLOVES"
            category_id = "MLA61216"
            is_custom_name = true
        }
    }

    test("Native Sell Modify Steps"){
        "/sell/update/sip"(platform: "/mobile") {
            item_id = "MLA123456"
            has_selected_pictures = false
        }
        "/sell/update/sip/publish/pictures_fail"(platform: "/mobile") {
            item_id = "MLA123456"
            fail_pictures = 2
            total_pictures = 6
            pictures_errors = ["error 1" , "error 2"]
        }
        "/sell/update/sip/publish/fail"(platform: "/mobile") {
            item_id = "MLA123456"
            error_message="error"
        }
        "/sell/update/sip/notification/view_item"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/notification/upgrade"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/notification/congrats"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/category_suggestion"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/category_navigation"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/color_selection"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/color_selection_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/condition"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/condition_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/description"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/description_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/payment_methods"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/payment_methods_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/updateing_types"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/updateing_types_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/gallery"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/editor"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/crop"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_uploader/crop/crop_canceled"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_uploader/crop/crop_acepted"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_review/gallery"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_review/editor"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_review/crop"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/price"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/price/similar_products/similar_item_selected"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/price/similar_products/similar_item_shown"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/price_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/price_review/similar_products"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/size_selection"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/size_selection_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/title"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/title_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/shipping_options_me"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/shipping_options_me_review"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip_price_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip_shipping_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip_condition_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip_condition_lt_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip_condition_listing_type_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/title_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/listing_types"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/listing_types_upgrade"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/congrats_upgrade"(platform: "/mobile") {item_id = "MLA123456"}
    }

    test("Modal attributes pseudo obligatory - List"){
        "/sell/list/modal_attributes"(platform: "/web") {
            domain_id ="MLA-CAMERAS"
            session_id = "214464778-list-d5e5a20b2935"
            empty_attrs_pk = 1
            empty_attrs_not_pk = 2
            condition = "new"
            category_path = ["MLA12345", "MLA4356"]
        }
        "/sell/list/modal_attributes/submit"(platform: "/web") {
            domain_id ="MLA-CAMERAS"
            session_id = "214464778-list-d5e5a20b2935"
            attribute_id = "MODEL"
            condition = "new"
            option_selected = "not_possible"
            category_path = ["MLA12345", "MLA4356"]
            hierarchy = "PARENT_PK"
            value = ""
        }
    }

    test("Modal attributes pseudo obligatory - Update"){
        "/sell/update/modal_attributes"(platform: "/web") {
            domain_id ="MLA-CAMERAS"
            empty_attrs_pk = 1
            empty_attrs_not_pk = 2
            condition = "new"
            item_id = "MLA123456"
            category_path = ["MLA12345", "MLA4356"]
        }
        "/sell/update/modal_attributes/submit"(platform: "/web") {
            category_path = ["MLA12345", "MLA4356"]
            domain_id ="MLA-CAMERAS"
            attribute_id = "MODEL"
            condition = "new"
            option_selected = "not_possible"
            item_id = "MLA123456"
            hierarchy = "PARENT_PK"
            value = ""
        }
    }

}
