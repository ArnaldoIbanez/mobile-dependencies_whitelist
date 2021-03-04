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

    test("Selected a photo album in the modify flow") {
        "/sell/update/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA1234"
            album_name = "Galería de fotos"
            seller_reputation="NO_REPUTATION"
            seller_segment=""
            seller_profile="NEWBIE"
            vertical="core"
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

        def itemDataForRelist = {
            item_id = "MLA123456"
            listing_type_id = "gold_special"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "used"
            price = 123.456
            quantity = 8
            session_id = "516954617-reactivateres-f2831864de5d"
        }

        def massiveItemData = {
            items_amount = 2
        }

        "/sell/quick_relist/single"  (platform: "/web/desktop", itemData)
        "/sell/quick_relist/massive" (platform: "/web/desktop", massiveItemData)

        "/sell/modify_and_relist/single/row"   (platform: "/web/desktop", itemDataForRelist)
        "/sell/modify_and_relist/single/cards" (platform: "/web/desktop", itemData)
        "/sell/modify_and_relist/massive/row"  (platform: "/web/desktop", massiveItemData)
        "/sell/relist/congrats"(platform: "/web/desktop"){
            can_complete_attributes= true
            item_id = "MLA12345"
        }
        "/sell/relist/congrats"(platform: "/web/desktop"){
            can_complete_attributes= true
            item_id = "MLA12345"
            session_id = "516954617-reactivateres-f2831864de5d"
            listing_type = "silver"
        }
        "/sell/relist/congrats"(platform: "/mobile"){
            item_id = "MLA12345"
            seller_segment = ""
            seller_profile = "NEWBIE"
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
            itemData()
            chosen_categorization_model = "ZORDON"
        })
        
        "/sell/upgrade_on"(platform: "/web/desktop", itemData)

    }

    test("Sell Flow view Pages upselling pads"){
        def itemData = {
            item_id = "MLA123456"
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
        "/sell/upgrade"(platform: "/mobile") {
            item_id = "MLA12345"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/upgrade/listing_types"(platform: "/mobile") {
            item_id = "MLA12345"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/upgrade/congrats"(platform: "/mobile") {
            item_id = "MLA12345"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/upgrade/congrats/payment_pending"(platform: "/mobile") {
            item_id = "MLA12345"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical="core"
        }
        "/sell/sip_upgrade"(platform: "/mobile"){
            source = "section"
            vertical = "motors"
        }
    }

    test("Native Sell List flow steps"){
        def defaultCatalogFlowMobile =
                {
                    category_id = "MLA123"
                    category_path = ["MLA12345", "MLA61216"]
                    parent_product_id = "MLA1234"
                    product_id = "MLA12345";
                    categorization_flow_successful = false
                    attribute_id = "TEST"
                    domain_id = "MLA_TEST"
                    chosen_categorization_model = "ZORDON"
                    title_predicted = "test"
                    category_prediction_selected_index = 0
                    attribute_values = [
                            [
                                    "name": "test",
                                    "id": "TEST",
                                    "value_id": "123",
                                    "value_name": "TEST"
                            ]
                    ]
                    predictions = [
                            attributes: [
                                    [
                                            "id": "TEST",
                                            "value_id": "123"
                                    ]
                            ],
                            categories: [
                                    [
                                            path: ["MLA123", "MLA1234"],
                                            score: 0.99
                                    ]
                            ]
                    ]
                }


        "/sell/list/congrats"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            item_id = "MLA12345"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/hub"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            has_selected_pictures = true
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip_catalog"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip/publish/publish_cancel"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip/publish/abandonment"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip/publish/back_selected"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip/section/disabled"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/catalog_trim_selection"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/catalog_vehicle_year_selection"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/category_suggestion"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/domain_suggestion"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/category_navigation"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/catalog"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            categorization_flow_successful= true
            title_predicted = "test"
        }
        "/sell/list/catalog/decision"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/catalog/customize_marketplace_item_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/catalog/forced"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            catalog_listing_forced_type = "open"
            defaultCatalogFlowMobile()
        }
        "/sell/list/catalog/forced"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            catalog_listing_forced_type = "closed"
            defaultCatalogFlowMobile()
        }
        "/sell/list/classifieds_reservation_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/color_selection"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/color_selection_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/color_selection_fallback"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/condition"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/condition_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/condition_fallback"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/description"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/description_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/description_fallback"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/description_included"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/description_included_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/description_not_included"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/description_additional_information"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/description_additional_information_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/payment_methods"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/payment_methods_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/listing_types"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/listing_types_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/listing_types_catalog"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/warranty_type"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/warranty_time"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/warranty_time_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/warranty_type_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/warranty_time_condition_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/warranty_type_condition_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/whatsapp_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures/album_selector"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
            session_id = "245084411-list-4519bc3c72aa"
            album_name = "Galería de fotos"
            seller_reputation="NO_REPUTATION"
            seller_segment=""
            seller_profile="NEWBIE"
            vertical="core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures/pictures_selector"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures/editor"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures/crop"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures_fallback"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures_fallback/album_selector"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures_fallback/pictures_selector"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures_fallback/editor"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures_fallback/crop"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/picture_uploader/mode/camera"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/picture_uploader/crop"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/picture_uploader/delete"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/picture_uploader/rotate"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures_review/album_selector"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures_review/pictures_selector"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures_review/editor"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures_review/crop"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/picture_preview_landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/price"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/price_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/seller_registration"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/seller_registration_zip_code"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/size_selection"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/size_selection_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/size_selection_fallback"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/title"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/title_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/shipping_options_me"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures_landing_fallback"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/registration_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/shipping_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/shipping_mandatory_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip_optional_landing"(platform: "/mobile",  type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/title_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/listing_types"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/congrats/payment_pending"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            item_id = "MLA12345"
            defaultCatalogFlowMobile()
        }

        "/sell/list/technical_specifications_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/technical_specifications_catalog"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/product_detail"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/product_identifier"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/attribute"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/attribute/kilometers"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/category/selection/l1"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/category/selection/l2"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/category/selection/l3"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/category/selection/l4"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/category/selection/l5"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/category/selection/confirm_suggested"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/category/selection/wrong_suggested"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/location"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/location_map"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/location_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/location_street"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/manufacturing_time"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/manufacturing_time_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/phone"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/pictures/crop/crop_accepted"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/pictures/crop/crop_canceled"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/price_modality"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/free_shipping"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/free_shipping_review"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/sip/publish/pictures_fail"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            fail_pictures = 2
            total_pictures = 6
            pictures_errors = ["error 1" , "error 2"]
        }
        "/sell/list/sip/publish/fail"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            error_message="error"
        }
        "/sell/list/sip/notification/congrats"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/listing_types"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/condition_confirmation_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/quotable_category_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/license_plate"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "motors"
        }
    }

    test("Native Sell List Real State flow steps") {
        "/sell/list/congrats"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
            item_id = "MLA12345"
        }
        "/sell/list/sip"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            has_selected_pictures = true
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/category_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/category_navigation"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/description"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/description_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/listing_types"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/listing_types_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/whatsapp_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures/album_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
            session_id = "245084411-list-4519bc3c72aa"
            album_name = "Galería de fotos"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical="real_estate"
        }
        "/sell/list/pictures/pictures_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures/editor"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures/crop"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures_review/album_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures_review/pictures_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures_review/editor"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures_review/crop"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/price"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/price_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/title"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/title_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/listing_types"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/attribute"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/category/selection/confirm_suggested"(platform: "/mobile", type: TrackType.Event) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/category/selection/wrong_suggested"(platform: "/mobile", type: TrackType.Event) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/location"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/location_map"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/location_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/location_street"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/phone_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "11111"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/phone"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures/crop/crop_accepted"(platform: "/mobile", type: TrackType.Event) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/pictures/crop/crop_canceled"(platform: "/mobile", type: TrackType.Event) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/listing_types"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "real_estate"
        }
        "/sell/list/kyc_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
    }

    test("Native Sell List draft flow steps") {
        def defaultCatalogFlowMobile =
                {
                    category_id = "MLA123"
                    category_path = ["MLA12345", "MLA61216"]
                    parent_product_id = "MLA1234"
                    product_id = "MLA12345";
                    categorization_flow_successful = false
                    attribute_id = "TEST"
                    domain_id = "MLA_TEST"
                    chosen_categorization_model = "ZORDON"
                    title_predicted = "test"
                    category_prediction_selected_index = 0
                    attribute_values = [
                            [
                                    "name": "test",
                                    "id": "TEST",
                                    "value_id": "123",
                                    "value_name": "TEST"
                            ]
                    ]
                    predictions = [
                            attributes: [
                                    [
                                            "id": "TEST",
                                            "value_id": "123"
                                    ]
                            ],
                            categories: [
                                    [
                                            path: ["MLA123", "MLA1234"],
                                            score: 0.99
                                    ]
                            ]
                    ]
                }

        "/sell/list/drafts"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/drafts/draft_action/draft_deleted"(platform: "/mobile", type: TrackType.Event) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/drafts/draft_action/draft_resumed"(platform: "/mobile", type: TrackType.Event) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/attribute"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/attribute/kilometers"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/category_navigation"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/category_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/domain_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/color_selection"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/color_selection_fallback"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/condition"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/condition_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/condition_fallback"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/congrats"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            item_id = "MLA12345"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/congrats/payment_pending"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            item_id = "MLA12345"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/description"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/description_fallback"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/description_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/description_included"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/free_shipping"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/listing_types"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/listing_types_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/location"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/location_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/payment_methods"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/phone_suggestion"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/picture_preview_landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures_landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures/album_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures/pictures_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures/editor"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures_fallback"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/pictures_landing_fallback"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/pictures_fallback/album_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/pictures_fallback/pictures_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/pictures_fallback/editor"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/pictures_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures_review/album_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures_review/pictures_selector"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/pictures_review/editor"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/price"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/price_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/price_modality"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/product_detail"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/product_identifier"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/registration_landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/seller_registration"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/seller_registration_zip_code"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/shipping_landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/shipping_mandatory_landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/shipping_options_me"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/sip_landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/sip_optional_landing"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/sip"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/size_selection"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/size_selection_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/size_selection_fallback"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/technical_specifications_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/technical_specifications_catalog"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/title"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/title_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/warranty_time"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/warranty_time_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/warranty_type"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/warranty_type_review"(platform: "/mobile", type: TrackType.View) {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/catalog/decision"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/catalog/customize_marketplace_item_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/list/draft/catalog/forced"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            catalog_listing_forced_type = "open"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/catalog/forced"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
            catalog_listing_forced_type = "closed"
            defaultCatalogFlowMobile()
        }
        "/sell/list/draft/kyc_landing"(platform: "/mobile") {
            session_id = "214464778-list-d5e5a20b2935"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
    }

    test("Native Sell Catalog Optin flow steps") {
        "/sell/catalog_optin/init"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA12341"
            seller_segment = ""
            seller_profile = "NEWBIE"}
        "/sell/catalog_optin/on_boarding"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12345"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/confirmation_landing"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/variation_selection"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/product_detail"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/category_navigation"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"}
        "/sell/catalog_optin/condition"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/warranty_type"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/warranty_time"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"}
        "/sell/catalog_optin/invoice"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/congrats"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/congrats_invalid_product"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/color_selection_buybox"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/catalog_optin/attributes_confirmation"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA12341"
            session_id = "214464778-list-d5e5a20b2935"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
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
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/buybox_competition"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA123456"
            buybox_status = "losing_by_price"
            is_catalog_listing = true
            seller_profile = "NEWBIE"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            vertical = "core"
            rebate_status = "not_boosted"
        }
        "/sell/update/buybox_competition/push_action"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA123456"
            buybox_status = "losing_by_price"
            is_catalog_listing = true
            seller_profile = "NEWBIE"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            vertical = "core"
            rebate_status = "not_boosted"
        }
        "/sell/update/buybox_competition/row_action"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA123456"
            boost_id = "same_day_shipping"
            boost_status = "opportunity"
            buybox_status = "losing_by_price"
            is_catalog_listing = true
            seller_profile = "NEWBIE"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            vertical = "core"
            rebate_status = "not_boosted"
        }
        "/sell/update/sip/rebate/action"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA123456"
            buybox_status = "winning"
            is_catalog_listing = true
            seller_profile = "NEWBIE"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            vertical = "core"
        }
        "/sell/update/sip"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA123456"
            buybox_status = "losing_by_price"
            has_selected_pictures = false
            is_catalog_boost = true
            is_catalog_listing = true
            is_item_inactive_moderated = true
            seller_profile = "NEWBIE"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            vertical = "core"
            rebate_status = "boosted"
        }
        "/sell/update/sip/header_modal/open"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA123456"
            buybox_status = "losing_by_bad_reputation"
            is_catalog_listing = true
            seller_profile = "NEWBIE"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            vertical = "core"
            header_type = "buybox"
        }
        "/sell/update/sip/header_modal/action"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA123456"
            buybox_status = "losing_by_bad_reputation"
            is_catalog_listing = true
            seller_profile = "NEWBIE"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            vertical = "core"
            header_type = "buybox"
            action_id = "reputation"
        }
        "/sell/update/sip"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA123456"
            buybox_status = "losing_by_free_listing_type"
            has_selected_pictures = false
            is_catalog_boost = true
            is_catalog_listing = true
            is_item_inactive_moderated = true
            seller_profile = "NEWBIE"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            vertical = "core"
            rebate_status = "none"
        }
        "/sell/update/sip/publish/fail"(platform: "/mobile") {
            item_id = "MLA123456"
            error_message="error"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            vertical = "core"
        }
        "/sell/update/goals"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/description_included"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/description_not_included"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/manufacturing_time"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/sip/section/disabled"(platform: "/mobile") {
            item_id = "MLA123456"
            section_id = "section"
            seller_reputation="NO_REPUTATION"
            seller_segment=""
            seller_profile="NEWBIE"
        }
        "/sell/update/color_selection"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/condition"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/description"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/payment_methods"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/warranty_type"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/warranty_type_catalog"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/warranty_type_force_change"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/warranty_time"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/warranty_time_catalog"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/warranty_time_force_change"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/whatsapp"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/phone"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures/crop/crop_accepted"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures/crop/crop_canceled"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures/album_selector"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures/pictures_selector"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures/editor"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures/crop"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/picture_uploader/mode/camera"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/picture_uploader/crop"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/picture_uploader/delete"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/picture_uploader/rotate"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/price"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/title"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping_options_me"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/listing_types"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/closed_sip/section"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/closed_sip/section/disabled"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/location"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/picture_preview_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures_variations"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures_variations/album_selector"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures_variations/pictures_selector"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/pictures_variations/editor"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/quantity"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/quantity_maximum_free_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping_mandatory_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping/flex/free_shipping_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping/flex/optin"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping/flex/optin/date_selection"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping/optin_lazy_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping/flex/optin/comunication"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/shipping/flex_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/technical_specifications"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/product_identifier"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            value_type = "single_value"
        }
        "/sell/update/variations"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/variations_pi"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
            value_type = "single_value"
        }
        "/sell/update/statistics"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/free_shipping"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/condition_confirmation_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/health_goal_loss_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/listing_type_not_available_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/update/quotable_category_landing"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
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

    test("Mobile flow - complete technical specifications") {
        "/sell/complete_technical_specifications/technical_specifications"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/complete_technical_specifications/landing_finish_no_complete"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/complete_technical_specifications/landing_continue"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/complete_technical_specifications/landing_no_items"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/complete_technical_specifications/congrats_finish"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/complete_technical_specifications/landing_intro"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
        "/sell/complete_technical_specifications/congrats_has_more"(platform: "/mobile") {
            item_id = "MLA123456"
            seller_segment = ""
            seller_profile = "NEWBIE"
        }
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
            item_from = {
                item_id = "MLA123"
                sold_quantity = 2
                status = "under_review"
                substatus = "finalized_for_prevention"
            }
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
    test("SYI v4 products finder showed"){
        "/sell/item_data/products_finder/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 products finder confirmed"){
        "/sell/item_data/products_finder/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 products finder updated"){
        "/sell/item_data/products_finder/update"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 products finder category selected"){
        "/sell/item_data/products_finder/category_selection"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 products finder product selected"){
        "/sell/item_data/products_finder/product_selection"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_PRODUCT_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_PRODUCT_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 products finder click on back to search"){
        "/sell/item_data/products_finder/restart"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 products finder bar confirmed"){
        "/sell/item_data/products_finder_bar/confirm"(platform: "/web", type: TrackType.Event){
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
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 product resume previous"){
        "/sell/item_data/product_resume/previous"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 carrier showed"){
        "/sell/item_data/carrier/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 carrier confirmed"){
        "/sell/item_data/carrier/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 redirect to syi-core confirmed"){
        "/sell/item_data/redirect_syi_core/confirm"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }
    test("SYI v4 redirect from title to install the app"){
        "/sell/item_data/title/redirect_store"(platform: "/web/mobile", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = ""
            category_id = "MLA1743"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "NO_REPUTATION"
            list_mode = "LIST"
            session_id = "1234-wm-08f2d"
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
            item_from = {
                item_id = "MLA123"
                sold_quantity = 2
                status = "under_review"
                substatus = "finalized_for_prevention"
            }
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
    test("SYI v4 product identifier card showed"){
        "/sell/item_data/product_identifier/show"(platform: "/web", type: TrackType.Event){
            category_id = "MLA1055"
            session_id = "123-update-abc123"
            item_type = "default"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
        }
    }
    test("SYI v4 product identifier card confirmed"){
        "/sell/item_data/product_identifier/confirm"(platform: "/web", type: TrackType.Event){
            category_id = "MLA1055"
            session_id = "123-update-abc123"
            item_type = "default"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
        }
    }
    test("SYI v4 product identifier card required"){
        "/sell/item_data/product_identifier/required"(platform: "/web", type: TrackType.Event){
            category_id = "MLA1055"
            session_id = "123-update-abc123"
            item_type = "default"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
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
        "/sell/item_data/kilometers"(platform: "/web", type: TrackType.View){
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

    test("SYI v4 item License Plate card showed"){
        "/sell/item_data/license_plate"(platform: "/web", type: TrackType.View){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 item License Plate card showed"){
        "/sell/item_data/license_plate/show"(platform: "/web", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "motors"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 item License Plate card confirmed"){
        "/sell/item_data/license_plate/confirm"(platform: "/web", type: TrackType.Event){
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
        "/sell/item_data/color"(platform: "/web", type: TrackType.View){
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
            health_card_shown = true
            kyc_card_shown = true
            share_card_shown = true
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

    test("SYI v4 render presip"){
        "/sell/presip"(platform: "/web", type: TrackType.View){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 review presip"){
        "/sell/presip/review"(platform: "/web/mobile", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 confirm presip"){
        "/sell/presip/confirm"(platform: "/web/mobile", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
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

    test("SYI v4 confirm sip"){
        "/sell/sip/confirm"(platform: "/web/mobile", type: TrackType.Event){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 render listing type show free"){
        "/sell/item_conditions/listing_types/free"(platform: "/web", type: TrackType.View){
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-update-abc123"
            vertical = "core"
            item_type = "default"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 listing type show free"){
        "/sell/item_conditions/listing_types/free/show"(platform: "/web/mobile", type: TrackType.Event){
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
    test("SYI v4 Category breadcrumb previous"){
        "/sell/item_data/category_breadcrumb/previous"(platform: "/web", type: TrackType.Event){
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
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }
    test("SYI v4 Category breadcrumb navigate"){
        "/sell/item_data/category_breadcrumb/navigate"(platform: "/web", type: TrackType.Event){
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
            gtin_experience = "ENABLED"
            query_type = "QUERY_STRING"
            query_search = "test search"
            result_type = "QUERY_DOMAIN_SUGGESTIONS"
            product_predictions = [{ product_id: "id_of_product"}]
            accumulated_search_results = [{
                query_type: "QUERY_STRING"
                query_search: "test search"
                result_type: "QUERY_DOMAIN_SUGGESTIONS"
            }]
            products_selected_index = -1
        }
    }

    test("SYI v4 flow catalog optional card showed"){
        "/sell/item_data/catalog_optional/show"(platform: "/web", type: TrackType.Event){
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            item_type = "default"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            seller_reputation = "green"
            list_mode = "LIST"
        }
    }

    test("SYI v4 flow catalog optional card confirmed"){
        "/sell/item_data/catalog_optional/confirm"(platform: "/web", type: TrackType.Event){
            session_id = "123-update-abc123"
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            item_type = "default"
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
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

    test("SYI v4 render pictures"){
        "/sell/item_data/pictures"(platform: "/web/mobile", type: TrackType.View){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 render phone"){
        "/sell/item_conditions/seller_contact/phone"(platform: "/web/mobile", type: TrackType.View){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 render whatsapp"){
        "/sell/item_conditions/seller_contact/whatsapp"(platform: "/web/mobile", type: TrackType.View){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 render default address"){
        "/sell/item_conditions/location/default_address"(platform: "/web/mobile", type: TrackType.View){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }

    test("SYI v4 pictures confirm"){
        "/sell/item_data/pictures/confirm"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }

    test("SYI v4 pictures first intention to add"){
        "/sell/item_data/pictures/add_intention"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }

    test("SYI v4 pictures intention to add more "){
        "/sell/item_data/pictures/add_more_intention"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 pictures delete one picture"){
        "/sell/item_data/pictures/delete"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 pictures check suggestions to take better picture"){
        "/sell/item_data/pictures/suggestions_modal_show"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 pictures confirm"){
        "/sell/item_data/pictures/upload_errors"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
            limit_errors = true
            format_errors = 1
            size_errors = 0
        }
    }
    test("SYI v4 pictures upload"){
        "/sell/item_data/pictures/upload"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
            quantity = 3
        }
    }
    test("SYI v4 phone confirm"){
        "/sell/item_conditions/seller_contact/phone/confirm"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 whatsapp confirm"){
        "/sell/item_conditions/seller_contact/whatsapp/confirm"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 default address confirm"){
        "/sell/item_conditions/location/default_address/confirm"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }
    test("SYI v4 default address wrong suggestion"){
        "/sell/item_conditions/location/default_address/wrong_suggestion"(platform: "/web/mobile", type: TrackType.Event){
            category_id = "MLA390784"
            category_path = ["MLA1", "MLA2", "MLA3"]
            seller_profile = "ADVANCED"
            seller_segment = "professional_sellers"
            session_id = "123-list-abc123"
            seller_reputation = "green"
            vertical = "motors"
            item_type = "default"
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS SYI v4 Publicar - RealEstate
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("SYI v4 publicar - title and description card ") {
        "/sell/item_data/title_and_description/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            listing_type_id = "silver"
        }
    }
    test("SYI v4 publicar - title and  description card confirmed") {
        "/sell/item_data/title_and_description/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - realEstate location info card showed") {
        "/sell/item_data/location/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            listing_type_id = "silver"
        }
    }

    test("SYI v4 publicar - realEstate location info card confirmed") {
        "/sell/item_data/location/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - realEstate location info card confirmed") {
        "/sell/item_data/location/intent"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            intent_type = "drag"
        }

        "/sell/item_data/location/intent"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            intent_type = "valid_street_number"
        }
    }

    test("SYI v4 publicar - picture card showed") {
        "/sell/item_data/pictures/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - picture card confirmed") {
        "/sell/item_data/pictures/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            listing_type_id = "silver"
        }
    }

    test("SYI v4 publicar - picture card intents") {
        "/sell/item_data/pictures/intent"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            seller_segment = ""
            category_id = "MLC183186"
            item_type = "default"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-7afd00a54af7"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            listing_type_id = "silver"
            intent_type = "pictures_upload"
            pictures_info = [
                    [
                            "width": 100,
                            "height": 500,
                            "size": 2048,
                            "format": "image/jpeg",
                            "valid": true
                    ],
                    [
                            "width": 800,
                            "height": 600,
                            "size": 1024,
                            "format": "image/png",
                            "valid": false
                    ],
                    [
                            "width": 800,
                            "height": 600,
                            "valid": false
                    ],
            ]
        }
    }

    test("SYI v4 publicar - sidebar listing type showed") {
        "/sell/sip/sidebar_listing_type/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-4793d18a6b24"
            vertical = "real_estate"
            listing_type_id = "gold_premium"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - sip showed") {
        "/sell/sip"(platform: "/web", type: TrackType.View) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-4793d18a6b24"
            vertical = "real_estate"
            listing_type_id = "gold_premium"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - category card showed") {
        "/sell/item_data/category/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            categorization_flow_successful = false
            seller_segment = ""
            category_id = "MLC1459"
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }
    test("SYI v4 publicar - category card confirmed") {
        "/sell/item_data/category/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            categorization_flow_successful = false
            seller_segment = ""
            category_id = "MLC1459"
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - instant pay listings card showed") {
        "/sell/item_conditions/instant_pay_listings/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - item data showed") {
        "/sell/item_data"(platform: "/web", type: TrackType.View) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            item_from = null
        }
    }

    test("SYI v4 publicar - technical_specifications card showed") {
        "/sell/item_data/technical_specifications/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            listing_type_id = "silver"
        }
    }

    test("SYI v4 publicar - technical_specifications card confirmed") {
        "/sell/item_data/technical_specifications/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }


    test("SYI v4 publicar - technical_specifications card intents") {
        "/sell/item_data/technical_specifications/intent"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            intent_type = "invalid_intent"
            field_intent_ids = ["CONTACT_SCHEDULE", "OPERATION_SUBTYPE", "TOTAL_AREA"]
        }
    }


    test("SYI v4 publicar - price_and_currency card showed") {
        "/sell/item_conditions/price_and_currency/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - price_and_currency card confirmed") {
        "/sell/item_conditions/price_and_currency/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - seller_contact card showed") {
        "/sell/item_conditions/seller_contact/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - seller_contact card confirmed") {
        "/sell/item_conditions/seller_contact/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - video card showed") {
        "/sell/item_conditions/video/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }

    }

    test("SYI v4 publicar - video card confirmed") {
        "/sell/item_conditions/video/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }


    test("SYI v4 publicar - sidebar_listing_type card showed") {
        "/sell/item_conditions/sidebar_listing_type/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - sidebar_listing_type card hide") {
        "/sell/item_conditions/sidebar_listing_type/hide"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - instant_pay_listings card confirmed") {
        "/sell/item_conditions/instant_pay_listings/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            category_id = "MLC183186"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - congrats view") {
        "/sell/congrats"(platform: "/web", type: TrackType.View) {
            seller_reputation = "NO_REPUTATION"
            categorization_flow_successful = true
            category_id = "MLC183186"
            item_id = "MLC531828782"
            seller_segment = ""
            item_type = "default"
            seller_profile = "NEWBIE"
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            listing_type_id = "silver"
        }
    }

    test("SYI v4 publicar - congrats view catalog_and_marketplace listing") {
        "/sell/congrats"(platform: "/web", type: TrackType.View) {
            seller_reputation = "NO_REPUTATION"
            categorization_flow_successful = true
            category_id = "MLC183186"
            item_type = "default"
            item_id = "MLC531828782"
            seller_profile = "NEWBIE"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_segment = ""
            session_id = "571359341-listres-718003de5fdc"
            vertical = "real_estate"
            user_type = "real_estate_agency"
            business = "classified"
            platform = "pi"
            listing_type_id = "silver"
            decision_flow_label = "BY_CATALOG"
        }
    }

     test("SYI v4 publicar - leave suggestion show link") {
        "/sell/item_data/category/leave_suggestion_link/show"(platform: "/web", type: TrackType.View) {
            session_id = "571359341-listres-718003de5fdc"
            category_id = "MLC183186"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            item_type = "default"
            seller_profile = "NEWBIE"
            seller_segment = ""
            seller_reputation = "NO_REPUTATION"
            list_mode = "LIST"
        }
    }

    test("SYI v4 publicar - leave product show link") {
        "/sell/item_data/category/default_product_link/show"(platform: "/web", type: TrackType.View) {
            session_id = "571359341-listres-718003de5fdc"
            category_id = "MLC183186"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            item_type = "default"
            seller_profile = "NEWBIE"
            seller_segment = ""
            seller_reputation = "NO_REPUTATION"
            list_mode = "LIST"
        }
    }


    test("SYI v4 publicar - wrong category") {
        "/sell/item_data/category/wrong_category"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            business = "classified"
            item_type = "default"
            session_id = "583247067-listres-08604897e645"
            vertical = "real_estate"
            platform = "pi"
            category_id = "MLC183186"
            seller_segment = ""
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
            seller_profile = "NEWBIE"
        }
    }

    test("SYI v4 publicar - congrats free showed") {
        "/sell/congrats/instant_pay_listings/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            categorization_flow_successful = true
            business = "classified"
            item_id = "MLC533953132"
            item_type = "default"
            title_predicted = ""
            session_id = "583247067-listres-0a5ad0c976ff"
            vertical = "real_estate"
            platform = "pi"
            seller_segment = ""
            seller_profile = "NEWBIE"
            listing_type_id = "free"
        }
    }

    test("SYI v4 publicar - splash screen - show ") {
        "/sell/onboarding/splash/show"(platform: "/web", type: TrackType.Event) {
            business = "classified"
            category_id: "MLC1459"
            vertical = "real_estate"
            platform = "pi"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
        }
    }

    test("SYI v4 publicar - splash screen - confirm") {
        "/sell/onboarding/splash/confirm"(platform: "/web", type: TrackType.Event) {
            business = "classified"
            category_id: "MLC1459"
            vertical = "real_estate"
            platform = "pi"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
        }
    }

    test("SYI v4 publicar - publication package required - show ") {
        "/sell/error_step/package_error/show"(platform: "/web", type: TrackType.Event) {
            session_id = "473569667-listres-29d4faa1bc5a"
            platform = "pi"
        }
    }

    test("SYI v4 publicar - publication package required - confirm") {
        "/sell/error_step/package_error/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            business = "classified"
            item_type = "default"
            session_id = "473569667-listres-29d4faa1bc5a"
            vertical = "real_estate"
            platform = "pi"
        }
    }

    test("SYI v4 publicar -  user with debt - confirm") {
        "/sell/error_step/user_has_debt_error/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            business = "classified"
            item_type = "default"
            session_id = "473569667-listres-29d4faa1bc5a"
            vertical = "real_estate"
            platform = "pi"
        }
    }

    test("SYI v4 publicar -  user with debt - show") {
        "/sell/error_step/user_has_debt_error/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            business = "classified"
            item_type = "default"
            session_id = "473569667-listres-29d4faa1bc5a"
            vertical = "real_estate"
            platform = "pi"
        }
    }

    test("SYI v4 publicar -  package limit exceeded  - show") {
        "/sell/error_step/package_empty/show"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            business = "classified"
            item_type = "default"
            session_id = "473569667-listres-29d4faa1bc5a"
            vertical = "real_estate"
            platform = "pi"
        }
    }

    test("SYI v4 publicar -  package limit exceeded - confirm") {
        "/sell/error_step/package_empty/confirm"(platform: "/web", type: TrackType.Event) {
            seller_reputation = "NO_REPUTATION"
            business = "classified"
            item_type = "default"
            session_id = "473569667-listres-29d4faa1bc5a"
            vertical = "real_estate"
            platform = "pi"
        }
    }

    test("SYI V4 Publicar - Paso Uno - Card de pictures  y Ver Planes") {
        def dataSet = {
            seller_reputation = "NO_REPUTATION"
            business = "classified"
            item_type = "default"
            session_id = "600095330-listres-5a85212250cd"
            vertical = "real_estate"
            platform = "pi"
            seller_segment = ""
            category_id = "MLC183186"
            seller_profile = "NEWBIE"
            listing_type_id = "silver"
            category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
        }
        "/sell/item_data/plans/confirm"(platform: "/web", type: TrackType.Event, dataSet)
        "/sell/item_data/pictures_modal/show"(platform: "/web", type: TrackType.Event, dataSet)
        "/sell/item_data/video/show"(platform: "/web", type: TrackType.Event, dataSet)
        "/sell/item_data/video/confirm"(platform: "/web", type: TrackType.Event, dataSet)
    }

    test("Validate goals - Update"){
        def dataSet = {
            item_id = "MLB1676065989"
            seller_profile = "INTERMEDIATE"
            seller_segment = "NONE"
            sent_again = false
            vertical = "motors"
        }
        "/sell/update/technical_spec_goal_not_supported_landing"(platform: "/mobile", type: TrackType.Event, dataSet)
        "/sell/update/video_goal_not_supported_landing"(platform: "/mobile", type: TrackType.Event, dataSet)
    }

    test("product suggestion with title with personal data validation error"){
        "/sell/product_suggestion/title/personal_data_validation"(platform: "/web", type: TrackType.Event){
            text = "Title text with personal data error"
            seller_profile = "NEWBIE"
            domain_id = "MLA-CELLPHONES"
            product_id = "MLA123"
            has_validation_error = true
            error_references = ["BILLING"]
        }
    }

    test("product suggestion with other suggestion with personal data validation error"){
        "/sell/product_suggestion/other_suggestion/personal_data_validation"(platform: "/web", type: TrackType.Event){
            text = "Other suggestion text with personal data error"
            seller_profile = "NEWBIE"
            domain_id = "MLA-CELLPHONES"
            product_id = "MLA123"
            has_validation_error = true
            error_references = ["BILLING"]
        }
    }

    test("SYI v4 congrats share email"){
        "/sell/congrats/share_task/email"(platform: "/web", type: TrackType.Event){
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
            item_id = "MLA123"
        }
    }

    test("SYI v4 congrats share facebook"){
        "/sell/congrats/share_task/facebook"(platform: "/web", type: TrackType.Event){
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
            item_id = "MLA123"
        }
    }

    test("SYI v4 congrats share twitter"){
        "/sell/congrats/share_task/twitter"(platform: "/web", type: TrackType.Event){
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
            item_id = "MLA123"
        }
    }

    test("SYI v4 congrats health action"){
        "/sell/congrats/go_health_action"(platform: "/web", type: TrackType.Event){
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
            item_id = "MLA123"
            action = "picture"
        }
    }

    test("SYI v4 congrats kyc onboarding"){
        "/sell/congrats/go_kyc_onboarding"(platform: "/web", type: TrackType.Event){
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
            item_id = "MLA123"
            seller_type = "normal"
            seller_id = 123
        }
    }
}
