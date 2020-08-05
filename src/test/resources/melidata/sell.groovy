package src.test.resources.melidata
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
            classi_category_prediction_available = true
            classi_landing_for_reservation = true
            classi_year_unification = true
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
        "/sell/relist/congrats"(platform: "/web/desktop"){
            can_complete_attributes= true
            item_id = "MLA12345"
        }
        "/sell/relist/congrats"(platform: "/mobile"){
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

        "/sell/list/congrats"(platform: "/web/desktop", {
            itemData
            chosen_categorization_model = "ZORDON"
        })
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
    }

    test("Sell Flow view Pages upselling pads"){
        def itemData = {
            reputation_level = "platinum"
            placement = "syi_congrats"
            adv_segmentation = "1-Active (0-30)"
        }

        "/sell/list/congrats"(platform: "/web/desktop", itemData)
    }

    test("Sell landing free_listing"){
        def data={
            referer = "1234L"
        }

        "/sell/landing/free_listing"(platform: "/", data)
        "/sell/landing/free_listing"(platform: "/"){}
        "/sell/list/pictures_uploader"(platform: "/web/desktop") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_uploader/validations"(platform: "/web/desktop") {
            session_id = "214464778-list-d5e5a20b2935"
            error_key = "ERROR"
        }
    }

    test("Native upgrade flow"){
        "/sell/upgrade"(platform: "/mobile"){
            item_id = "MLA12345"
        }
        "/sell/upgrade/listing_types"(platform: "/mobile"){
            item_id = "MLA12345"
        }
        "/sell/upgrade/congrats"(platform: "/mobile"){
            item_id = "MLA12345"
        }
        "/sell/upgrade/congrats/payment_pending"(platform: "/mobile"){
            item_id = "MLA12345"
        }
    }

    test("Native Sell List flow steps"){
        "/sell/list/congrats"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/hub"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip"(platform: "/mobile" ) {
            session_id = "214464778-list-d5e5a20b2935"
            has_selected_pictures = true
        }
        "/sell/list/sip_catalog"(platform: "/mobile" ) { session_id = "214464778-list-d5e5a20b2935" }
        "/sell/list/sip/publish/publish_cancel"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/publish/abandonment"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/publish/back_selected"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/section/disabled"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/location"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/size_selection_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update" (platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/condition"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/condition_review"(platform:"/mobile") {session_id = "214464778-list-d5e5a20b2935"}

        "/sell/list/sip/update/product_identifier_review"(platform: "/mobile"){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/product_identifier"(platform: "/mobile"){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/technical_specifications_review"(platform: "/mobile"){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/technical_specifications"(platform: "/mobile"){session_id = "214464778-list-d5e5a20b2935"}
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
        "/sell/list/catalog_trim_selection"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/catalog_vehicle_year_selection"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category_suggestion"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category_navigation"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/catalog"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/catalog/decision"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/classifieds_reservation_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/color_selection"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/color_selection_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/color_selection_fallback"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/condition"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/condition_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/condition_fallback"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description_fallback"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description_included"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description_included_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description_not_included"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description_additional_information"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/description_additional_information_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/payment_methods"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/payment_methods_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types_catalog"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/warranty_type"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/warranty_time"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/warranty_time_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/warranty_type_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/warranty_time_condition_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/warranty_type_condition_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/whatsapp_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/gallery"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/album_selector"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/pictures_selector"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/editor"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/crop"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_fallback"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_fallback/album_selector"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_fallback/pictures_selector"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_fallback/editor"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_fallback/crop"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_uploader/delete"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_uploader/rotate"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review/album_selector"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review/pictures_selector"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review/editor"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_review/crop"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_preview_landing"(platform: "/mobile", type: TrackType.View){session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/seller_registration"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/seller_registration_zip_code"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/size_selection"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/size_selection_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/size_selection_fallback"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/title"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/title_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/shipping_options_me"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures_landing_fallback"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/registration_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/shipping_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/shipping_mandatory_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/title_landing"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/congrats/payment_pending" (platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}

        "/sell/list/technical_specifications_review"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/product_detail"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/product_identifier"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/attribute"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/attribute/kilometers"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/l1"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/l2"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/l3"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/l4"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/l5"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/confirm_suggested"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/category/selection/wrong_suggested"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/location"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/location_map"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/location_suggestion"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/location_street"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/manufacturing_time"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/manufacturing_time_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/phone"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_editor/function/crop"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_editor/function/delete"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_uploader/mode/camera"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/crop/crop_accepted"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/pictures/crop/crop_canceled"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/price_modality"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/free_shipping"(platform: "/mobile" ) {session_id = "214464778-list-d5e5a20b2935"}

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
        "/sell/list/sip/notification/congrats"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/listing_types"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/sip/update/extra_description"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/picture_editor/function/rotate"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/condition_confirmation_landing"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/quotable_category_landing"(platform: "/mobile") {session_id = "214464778-list-d5e5a20b2935"}
    }

    test("Native Sell List draft flow steps") {
        "/sell/list/drafts"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/drafts/draft_action/draft_deleted"(platform: "/mobile", type: TrackType.Event) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/drafts/draft_action/draft_resumed"(platform: "/mobile", type: TrackType.Event) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/attribute"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/attribute/kilometers"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/category_navigation"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/category_suggestion"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/color_selection"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/color_selection_fallback"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/condition"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/condition_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/condition_fallback"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/congrats"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/congrats/payment_pending"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/description"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/description_fallback"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/description_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/description_included"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/free_shipping"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/listing_types"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/listing_types_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/location"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/location_suggestion"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/payment_methods"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/phone_suggestion"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/picture_preview_landing"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_landing"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures/album_selector"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures/pictures_selector"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures/editor"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_fallback"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_landing_fallback"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_fallback/album_selector"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_fallback/pictures_selector"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_fallback/editor"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_review/album_selector"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_review/pictures_selector"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/pictures_review/editor"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/price"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/price_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/price_modality"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/product_detail"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/product_identifier"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/registration_landing"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/seller_registration"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/seller_registration_zip_code"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/shipping_landing"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/shipping_mandatory_landing"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/shipping_options_me"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/sip_landing"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/sip"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/size_selection"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/size_selection_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/size_selection_fallback"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/technical_specifications_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/title"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/title_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/warranty_time"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/warranty_time_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/warranty_type"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/list/draft/warranty_type_review"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
    }

    test("Native Sell Catalog Optin flow steps") {
        "/sell/catalog_optin/on_boarding"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/confirmation_landing"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/variation_selection"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/product_detail"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/category_navigation"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/condition"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/warranty_type"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/warranty_time"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/invoice"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/congrats"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/congrats_invalid_product"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
        "/sell/catalog_optin/color_selection_buybox"(platform: "/mobile", type: TrackType.View) {session_id = "214464778-list-d5e5a20b2935"}
    }

    test("Custom color name changed - Update"){
        "/sell/update/color_selection/custom_color"(platform: "/web"){
            session_id = "290061169-update-32b1d9b3eae8"
            is_custom_name = true
            item_id = "MLA12345"
        }
    }

    test("Custom color name changed - List"){
        "/sell/list/color_selection/custom_color"(platform: "/web"){
            session_id = "290061169-list-32b1d9b3eae8"
            category_domain = "MLA-GLOVES"
            is_custom_name = true
            category_path = ["MLA12345", "MLA61216"]
        }
    }

    test("Native Sell Modify Steps") {
        "/sell/update/attribute"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA123456"
        }
        "/sell/update/sip"(platform: "/mobile") {
            item_id = "MLA123456"
            has_selected_pictures = false
            is_catalog_boost = true
            is_item_inactive_moderated = true
        }
        "/sell/update/sip/publish/fail"(platform: "/mobile") {
            item_id = "MLA123456"
            error_message="error"
        }
        "/sell/update/goals"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/picture_editor/function/crop"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/picture_editor/function/delete"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/picture_editor/function/rotate"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/description_included"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/description_not_included"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/manufacturing_time"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/section/disabled"(platform: "/mobile") {
            item_id = "MLA123456"
            section_id = "section"
        }
        "/sell/update/sip/update"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/add_stock" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/condition" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/description" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/list_closed_step" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/list_paused_step" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/listing_types" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/modify_variations" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/technical_specifications" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/pictures" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/price" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/quantity" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/relist" (platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/sip/update/statistics" (platform: "/mobile") {item_id = "MLA123456"}

        "/sell/update/color_selection"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/condition"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/description"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/payment_methods"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/warranty_type"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/warranty_type_catalog"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/warranty_type_force_change"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/warranty_time"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/warranty_time_catalog"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/warranty_time_force_change"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/whatsapp"(platform: "/mobile", type: TrackType.View) {item_id = "MLA123456"}
        "/sell/update/phone"(platform: "/mobile", type: TrackType.View) {item_id = "MLA123456"}
        "/sell/update/pictures"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/crop/crop_accepted"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/crop/crop_canceled"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/album_selector"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/pictures_selector"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/editor"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures/crop"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/picture_uploader/crop/crop_canceled"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/picture_uploader/crop/crop_acepted"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/picture_uploader/rotate"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/picture_uploader/delete"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/price"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/title"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/shipping_options_me"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/listing_types"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/closed_sip/section"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/closed_sip/section/disabled"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/location"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/picture_preview_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_variations"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_variations/album_selector"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_variations/pictures_selector"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/pictures_variations/editor"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/quantity"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/quantity_maximum_free_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/shipping_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/shipping_mandatory_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/shipping/flex/free_shipping_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/shipping/flex/optin"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/shipping/flex_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/technical_specifications"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/product_identifier"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/variations"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/variations_pi"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/statistics"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/free_shipping"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/condition_confirmation_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/health_goal_loss_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/listing_type_not_available_landing"(platform: "/mobile") {item_id = "MLA123456"}
        "/sell/update/quotable_category_landing"(platform: "/mobile") {item_id = "MLA123456"}
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

    test("Landing for donwload app at web mobile"){
        "/sell/landing_download_app"(platform: "/web/mobile", type: TrackType.View){
            vertical = "core"
        }
        "/sell/landing_download_app"(platform: "/web/mobile", type: TrackType.View){}
        "/sell/landing_download_app/download_intention"(platform: "/web/mobile", type: TrackType.Event){
            vertical = "services"
        }
        "/sell/landing_download_app/download_intention"(platform: "/web/mobile", type: TrackType.Event){}
        "/sell/landing_hub"(platform: "/web/mobile", type: TrackType.View){}
        "/sell/landing_hub/sell_intention"(platform: "/web/mobile", type: TrackType.Event){
            vertical = "realEstate"
        }
    }

    test("Mobile flow - complete technical specifications"){
        "/sell/complete_technical_specifications/technical_specifications"(platform: "/mobile"){item_id = "MLA123456"}
        "/sell/complete_technical_specifications/landing_finish_no_complete"(platform: "/mobile"){item_id = "MLA123456"}
        "/sell/complete_technical_specifications/landing_continue"(platform: "/mobile"){item_id = "MLA123456"}
        "/sell/complete_technical_specifications/landing_no_items"(platform: "/mobile"){item_id = "MLA123456"}
        "/sell/complete_technical_specifications/congrats_finish"(platform: "/mobile"){item_id = "MLA123456"}
        "/sell/complete_technical_specifications/landing_intro"(platform: "/mobile"){item_id = "MLA123456"}
        "/sell/complete_technical_specifications/congrats_has_more"(platform: "/mobile"){item_id = "MLA123456"}
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS SYI v4
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    test("SYI v4 render draft"){
        "/sell/draft"(platform: "/web", type: TrackType.View){}
    }
    test("SYI v4 render hub"){
        "/sell/hub"(platform: "/web", type: TrackType.View){}
    }
    test("SYI v4 hub vertical selection"){
        "/sell/hub/select_vertical"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 render item_data"){
        "/sell/item_data"(platform: "/web", type: TrackType.View){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 title card showed"){
        "/sell/item_data/title/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 title card confirmed"){
        "/sell/item_data/title/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 category suggested card showed"){
        "/sell/item_data/category_suggested/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            list_mode = "LIST"
        }
    }
    test("SYI v4 category suggested card confirmed"){
        "/sell/item_data/category_suggested/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            confirm_category_detail = "not_present"
            list_mode = "LIST"
        }
    }
    test("SYI v4 category suggested click wrong category"){
        "/sell/item_data/category_suggested/wrong_category"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            title_predicted = "celular"
            categorization_flow_successful = false
            chosen_categorization_model = "ZORDON"
            list_mode = "LIST"
        }
    }
    test("SYI v4 category card showed"){
        "/sell/item_data/category/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            list_mode = "LIST"
        }
    }
    test("SYI v4 category card confirmed"){
        "/sell/item_data/category/confirm"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            confirm_category_detail = "not_present"
            list_mode = "LIST"
        }
    }
    test("SYI v4 category card confirmed motors"){
        "/sell/item_data/category/confirm"(platform: "/web", type: TrackType.Event){
            category_id = "MLM24287"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            list_mode = "LIST"
        }
    }
    test("SYI v4 wrong category"){
        "/sell/item_data/category/wrong_category"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            list_mode = "LIST"
        }
    }
    test("SYI v4 product resume card showed"){
        "/sell/item_data/product_bullet_resume/show"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            product_title = "Iphone X"
            list_mode = "LIST"
        }
    }
    test("SYI v4 flow decision card showed"){
        "/sell/item_data/flow_decision/show"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 flow decision card confirmed"){
        "/sell/item_data/flow_decision/confirm"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            flow_decision = true
            list_mode = "LIST"
            catalog_forced = true
        }
    }
    test("SYI v4 quantity with specifications card showed"){
        "/sell/item_data/quantity_with_specifications/show"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 quantity with specifications card confirmed"){
        "/sell/item_data/quantity_with_specifications/confirm"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 consequences modal showed"){
        "/sell/item_data/consequences_modal/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 consequences modal confirmed"){
        "/sell/item_data/consequences_modal/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 pks card showed"){
        "/sell/item_data/pks/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 pks card confirmed"){
        "/sell/item_data/pks/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 item condition card showed"){
        "/sell/item_data/item_condition/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 item condition card confirmed"){
        "/sell/item_data/item_condition/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 main variation card showed"){
        "/sell/item_data/main_variation/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 main variation card confirmed"){
        "/sell/item_data/main_variation/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 item variations card showed"){
        "/sell/item_data/variations/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 item variations card confirmed"){
        "/sell/item_data/variations/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 specifications card showed"){
        "/sell/item_data/specifications/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 specifications card confirmed"){
        "/sell/item_data/specifications/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 technical specifications card showed"){
        "/sell/item_data/technical_specifications/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 technical specifications card confirmed"){
        "/sell/item_data/technical_specifications/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 set multivalue input"){
        "/sell/item_data/multivalue"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            category_domain = "SMARTPHONES"
            attribute_id = "MLA12345678"
            hierarchy = "FAMILY"
            quantity = 3
            previous_quantity = 0
            container = "technical_specifications"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 set autocomplete input"){
        "/sell/item_data/autocomplete"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            category_domain = "SMARTPHONES"
            attribute_id = "MLA12345678"
            hierarchy = "FAMILY"
            type = "suggested"
            container = "technical_specifications"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 item kilometers card showed"){
        "/sell/item_data/kilometers/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 item kilometers card showed"){
        "/sell/item_data/kilometers/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 item kilometers card confirmed"){
        "/sell/item_data/kilometers/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 item color card showed"){
        "/sell/item_data/color/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 item color card confirmed"){
        "/sell/item_data/color/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 render item_conditions"){
        "/sell/item_conditions"(platform: "/web", type: TrackType.View){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 price and currency card showed"){
        "/sell/item_conditions/price_and_currency/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 price and currency card confirmed"){
        "/sell/item_conditions/price_and_currency/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 listing types card showed"){
        "/sell/item_conditions/listing_types/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            has_free = true
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 listing types card confirmed"){
        "/sell/item_conditions/listing_types/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 free shipping card showed"){
        "/sell/item_conditions/free_shipping/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 free shipping card confirmed"){
        "/sell/item_conditions/free_shipping/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 consequences modal showed"){
        "/sell/item_conditions/consequences_modal/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 consequences modal confirmed"){
        "/sell/item_conditions/consequences_modal/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 calculator showed"){
        "/sell/item_conditions/calculator/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 calculator hide"){
        "/sell/item_conditions/calculator/hide"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 shipping card showed"){
        "/sell/item_conditions/shipping/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 shipping card confirmed"){
        "/sell/item_conditions/shipping/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 localpickup card showed"){
        "/sell/item_conditions/localpickup/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 localpickup card confirmed"){
        "/sell/item_conditions/localpickup/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 payment_methods card showed"){
        "/sell/item_conditions/payment_methods/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 payment_methods card confirmed"){
        "/sell/item_conditions/payment_methods/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 warranty card showed"){
        "/sell/item_conditions/warranty/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 warranty card confirmed"){
        "/sell/item_conditions/warranty/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 manufacturing time card showed"){
        "/sell/item_conditions/manufacturing_time/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 manufacturing time card confirmed"){
        "/sell/item_conditions/manufacturing_time/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 description card showed"){
        "/sell/item_conditions/description/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            listing_type_id = "gold"
        }
    }
    test("SYI v4 description card confirmed"){
        "/sell/item_conditions/description/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            listing_type_id = "gold"
        }
    }
    test("SYI v4 video card showed"){
        "/sell/item_conditions/video/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            listing_type_id = "gold"
        }
    }
    test("SYI v4 video card confirmed"){
        "/sell/item_conditions/video/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            listing_type_id = "gold"
        }
    }
    test("SYI v4 invoice card showed"){
        "/sell/item_conditions/invoice/show"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 invoice card confirmed"){
        "/sell/item_conditions/invoice/confirm"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 reservation info card showed"){
        "/sell/item_conditions/reservation_info/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 reservation info card confirmed"){
        "/sell/item_conditions/reservation_info/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 location info card showed"){
        "/sell/item_conditions/location/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 location info card confirmed"){
        "/sell/item_conditions/location/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 seller contact card showed"){
        "/sell/item_conditions/seller_contact/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 seller contact  card confirmed"){
        "/sell/item_conditions/seller_contact/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 instant pay listings card showed"){
        "/sell/item_conditions/instant_pay_listings/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 instant pay listings  card confirmed"){
        "/sell/item_conditions/instant_pay_listings/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 instant pay listings card with free showed"){
        "/sell/item_conditions/instant_pay_listings_free/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 instant pay listings with free card confirmed"){
        "/sell/item_conditions/instant_pay_listings_free/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 sidebar listing type card showed"){
        "/sell/item_conditions/sidebar_listing_type/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 render congrats"){
        "/sell/congrats"(platform: "/web", type: TrackType.View){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            categorization_flow_successful = true
            item_id = "MLA123456789"
            item_type = "default"
            seller_reputation = "green"
            domain_id = "MLA_CELLPHONES"
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            list_mode = "LIST"
            listing_type_id = "gold"
        }
    }
    test("SYI v4 congrats card showed"){
        "/sell/congrats/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            list_mode = "LIST"
        }
    }
    test("SYI v4 listing types card showed"){
        "/sell/congrats/listing_types/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            has_free = true
            list_mode = "LIST"
        }
    }

    test("SYI v4 render sip"){
        "/sell/sip"(platform: "/web", type: TrackType.View){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 calculator showed"){
        "/sell/sip/calculator/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            list_mode = "LIST"
        }
    }

    test("SYI v4 sidebar listing type showed"){
        "/sell/sip/sidebar_listing_type/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            list_mode = "LIST"
        }
    }

    test("SYI v4 Category breadcrumb update"){
        "/sell/item_data/category_breadcrumb/update"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            list_mode = "LIST"
        }
    }
    test("SYI v4 Category breadcrumb mount"){
        "/sell/item_data/category_breadcrumb/mount"(platform: "/web", type: TrackType.Event){
            category_id = "MLA390784"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            categorization_flow_successful = true
            chosen_categorization_model = "ZORDON"
            title_predicted = "test"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("List Equals V3 Modifications"){
        def originalItemData = [
                has_variations: false,
                category_id: "MLA123",
                domain_id : null,
                catalog_listing: false
        ]
        "/sell/list_similar/result"(platform: "/web/desktop", type: TrackType.Event){
            session_id = "123-list-abc123"
            list_mode = "list_equals"
            seller_segment = "professional_sellers"
            original_item_data = originalItemData
            modifications = ["currency", "price"]
        }
    }

    test("List Similar V3 Modifications"){
        def originalItemData = [
                has_variations: true,
                category_id: "MLA1055",
                domain_id : "MLA_CELLPHONES",
                catalog_listing: true

        ]
        "/sell/list_similar/result"(platform: "/web/desktop", type: TrackType.Event) {
            session_id = "123-list-abc123"
            list_mode = "list_similar"
            seller_segment = "professional_sellers"
            original_item_data = originalItemData
            modifications = ["currency", "price", "variations", "title"]
        }
    }

    test("SYI v4 Catalog decision show"){
        "/sell/item_data/catalog_decision/show"(platform: "/web", type: TrackType.Event){
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            domain_id = "MLA_CELLPHONES"
            list_mode = "LIST"
            item_type = "default"
            parent_product_id = "MLA390783"
        }
    }

    test("SYI v4 Catalog decision confirm"){
        "/sell/item_data/catalog_decision/confirm"(platform: "/web", type: TrackType.Event){
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            domain_id = "MLA_CELLPHONES"
            list_mode = "LIST"
            item_type = "default"
            parent_product_id = "MLA390783"
            flow_decision = true
            catalog_forced = false
        }
    }

    test("SYI v4 Catalog forced show"){
        "/sell/item_data/catalog_forced/show"(platform: "/web", type: TrackType.Event){
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            domain_id = "MLA_CELLPHONES"
            list_mode = "LIST"
            item_type = "default"
            parent_product_id = "MLA390783"
        }
    }

    test("SYI v4 Catalog forced confirm"){
        "/sell/item_data/catalog_forced/confirm"(platform: "/web", type: TrackType.Event){
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            domain_id = "MLA_CELLPHONES"
            list_mode = "LIST"
            item_type = "default"
            parent_product_id = "MLA390783"
            flow_decision = false
            catalog_forced = true
        }
    }

    test("SYI v4 Congrats catalog items displayer"){
        "/sell/congrats/congrats_catalog_items/show"(platform: "/web", type: TrackType.Event) {
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            item_type = "product"
            list_mode = "LIST"
        }
    }

    test("SYI v4 marketplace customizer show"){
        "/sell/item_data/marketplace_customizer/show"(platform: "/web", type: TrackType.Event) {
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            item_type = "product"
            list_mode = "LIST"
            domain_id = "MLA_CELLPHONES"
            parent_product_id = "MLA390783"
        }
    }

    test("SYI v4 marketplace customizer confirm"){
        "/sell/item_data/marketplace_customizer/confirm"(platform: "/web", type: TrackType.Event) {
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            item_type = "product"
            list_mode = "LIST"
            domain_id = "MLA_CELLPHONES"
            parent_product_id = "MLA390783"
        }
    }

    test("SYI v4 marketplace customizer inner edit"){
        "/sell/item_data/marketplace_customizer/edit"(platform: "/web", type: TrackType.Event) {
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            item_type = "product"
            list_mode = "LIST"
            domain_id = "MLA_CELLPHONES"
            parent_product_id = "MLA390783"
            id = "description"
            new_value = "this is the new description"
        }
    }

    test("SYI v4 List Similar variation selection page"){
        "/sell/variation_selection"(platform: "/web", type: TrackType.View) {
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            seller_reputation = "green"
            list_mode = "LIST"
            vertical = "core"
        }
    }

    test("SYI v4 List Similar variation selection, source variations, card show"){
        "/sell/variation_selection/source_variations/show"(platform: "/web", type: TrackType.Event) {
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            seller_reputation = "green"
            list_mode = "LIST"
            vertical = "core"
            variations_id = [123423, 123123, 123123]
        }
    }

    test("SYI v4 List Similar variation selection, source variations, confirm variation"){
        "/sell/variation_selection/source_variations/confirm_variation"(platform: "/web", type: TrackType.Event) {
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            seller_reputation = "green"
            list_mode = "LIST"
            vertical = "core"
            variation_id = 123
        }
    }

    test("SYI v4 List Similar variation selection, source variations, confirm variation null"){
        "/sell/variation_selection/source_variations/confirm_variation"(platform: "/web", type: TrackType.Event) {
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            seller_reputation = "green"
            list_mode = "LIST"
            vertical = "core"
            variation_id = null
        }
    }

}
