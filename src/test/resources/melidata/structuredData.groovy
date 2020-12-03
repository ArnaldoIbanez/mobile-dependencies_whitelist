package src.test.resources.melidata
import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("catalog_widget render should be tracked"){
    	"/catalogwidget/show"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
    	}
    }

    test("catalog_widget item render should be tracked"){
        "/catalogwidget/showitem"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = true
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
            attributes_showed = 2
        }
    }

    test("catalog_widget save with total completeness_level should be tracked"){
        "/catalogwidget/save"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "total"
            items_left = 10
            missing_attributes = "GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
            attribute_type = "item_attribute"
            attributes_submitted = 2
        }
    }

    test("catalog_widget save with partial completeness_level should be tracked"){
        "/catalogwidget/save"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "partial"
            items_left = 9
            missing_attributes = "GTIN,BRAND,MODEL"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget save with total_pi completeness_level should be tracked"){
        "/catalogwidget/save"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "total_pi"
            items_left = 8
            missing_attributes = ""
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = true
            category_path = ["MLA1234", "MLA12345"]
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget save with total_pi completeness_level should be tracked"){
        "/catalogwidget/save"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "total_pi"
            items_left = 8
            missing_attributes = ""
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = true
            category_path = ["MLA1234", "MLA12345"]
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget cancel should be tracked"){
        "/catalogwidget/cancel"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            items_left = 8
            missing_attributes = "GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget forced cancel should be tracked"){
        "/catalogwidget/cancel/forced"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            items_left = 8
            missing_attributes = "GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget cancel should be tracked"){
        "/catalogwidget/cancel"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            items_left = 8
            missing_attributes = "GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = true
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget render minimize should be tracked"){
        "/catalogwidget/minimize"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget render minimize should be tracked"){
        "/catalogwidget/minimize"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget render minimize should be tracked"){
        "/catalogwidget/maximize"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget skip should be tracked"){
        "/catalogwidget/omit"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget skip should be tracked"){
        "/catalogwidget/omit_save"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            items_left = 15
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget benefits should be tracked"){
        "/catalogwidget/discover"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget pi view should be tracked"){
        "/catalogwidget/pi"(platform: "/", type: TrackType.Event) {
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget pi confirmation should be tracked"){
        "/catalogwidget/pi_save"(platform: "/", type: TrackType.Event) {
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget pi cancel should be tracked"){
        "/catalogwidget/pi_cancel"(platform: "/", type: TrackType.Event) {
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget navigation should be tracked"){
        "/catalogwidget/next"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "none"
            items_left = 15
            missing_attributes = "BRAND,MODEL,GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget save error should be tracked"){
        "/catalogwidget/save_again"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            status_code = "200"
            error = "Null exception"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget generic error should be tracked"){
        "/catalogwidget/redo"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            status_code = "200"
            error = "Generic error"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget middle congrats should be tracked"){
        "/catalogwidget/middle_congrats"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "total"
            items_left = 3
            missing_attributes = ""
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget congrats should be tracked"){
        "/catalogwidget/final_congrats"(platform: "/", type: TrackType.Event){}
    }

    test("catalog_widget coachmark should be tracked"){
        "/catalogwidget/coachmark"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget new omit should be tracked"){
        "/catalogwidget/omit_attributes"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            condition = "new"
            item_id = "MLA682118081"
            officialstore = false
            seller_id = "241616388"
            pi = false
            domain_id = "MLA-FRAGRANCES"
            empty_attrs_not_pk = 4
            empty_attrs_pk = 2
            category_path = ["MLA1234", "MLA12345"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget new omit save should be tracked"){
        "/catalogwidget/omit_attributes/submit"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            condition = "new"
            item_id = "MLA682118081"
            officialstore = false
            seller_id = "241616388"
            pi = false
            domain_id = "MLA-FRAGRANCES"
            attribute_id = "BRAND"
            hierarchy = "PARENT_PK"
            option_selected = "not_possible"
            value = "Not apply"
            category_path = ["MLA12345", "MLA4356"]
            attribute_type = "item_attribute"
        }
    }

    test("catalog_widget show welcome for leaders should be tracked"){
        "/catalogwidget/welcome/leaders/show"(platform: "/",type: TrackType.View) {}
    }

    test("catalog_widget continue in welcome for leaders should be tracked"){
        "/catalogwidget/welcome/leaders/continue"(platform: "/",type: TrackType.Event) {}
    }

    test("catalog_widget omit in welcome for leaders should be tracked"){
        "/catalogwidget/welcome/leaders/omit"(platform: "/",type: TrackType.Event) {}
    }

    test("catalog_widget close in welcome for leaders should be tracked"){
        "/catalogwidget/welcome/leaders/close"(platform: "/",type: TrackType.Event) {}
    }

    test("Updated items in Massive Attribute Editor from SW_MKT"){
        "/bulk_attributes/incomplete/save" (platform: "/web",type: TrackType.Event) {
            campaignId = "SW_MKT"
            totalItems = 6
            updatedItems = 2
            badItems = false
        }
    }

    test("product_creator new other domain action should be tracked"){
        "/structure_data/product_creator/other_domain"(platform: "/", type: TrackType.Event){
            score = 0.9913573265075684
            is_same_domain = true
            domain_id = "MLA-MOTORCYCLE_HELMETS"
            suggested_domain = "MOTORCYCLE_HELMETS"
            item_id = "MLA763560508"
            user_action = "OTHER_DOMAIN"
            user_initials = "FKE"
        }
    }

    test("product_creator taken action over item with product data should be tracked"){
        "/structure_data/product_creator/taken-action-with-product-data"(platform: "/", type: TrackType.Event){
            item_id = "MLA763560508"
            user_action = "OTHER_DOMAIN"
            user_initials = "FKE"
        }
    }
    

    test("product_creator ignore hints action should be tracked"){
        "/structure_data/product_creator/ignored_hints"(platform: "/", type: TrackType.Event){
            domain_id = "MLA-MOTORCYCLE_HELMETS"
            hint_id = "SUGGEST_KNOWN"
            attribute = "MATERIALS"
            lang = "es"
            suggested_value_id = "2262161"
            suggested_value_name = "aluminio"
            written_value = "alu"
            final_value ="alumi"
            user_initials = "FKE"
        }
    }

    test("product_reviewer review should be tracked") {
        "/structure_data/product_reviewer/review"(platform: "/", type: TrackType.Event) {
            review_id = "MLM123456-414124-23233-43434"
            review_version = 1
            sheet_id = "MLM123456"
            domain_id = "MLM-BACKPACKS"
            publication_id = "MLM721126131"
            review_status = "REJECTED"
            action_tag = "NPP"
            time = 4000        
            sections_comments =  ["action_source:1", "association:2"]
            errors_codes = ["E-ADS:1", "E-COM:2", "E-FOR:3"]
            user_initials = "FKE"
        }
    }

    test("product_modificator quality resports"){
        "/structure_data/product_modificator/quality-reports"(platform: "/", type: TrackType.Event) {
            domain_id = "MLA-CAMERAS"
            parent_id = "22711"
            product_id = "22711"
            errors = ["ProductIdentifierInvalid"]
            warnings = ["ParentsWithProductIdentifier", "ColorFormat"]
            errors_quantity = 1
            warning_quantity = 2
            step = "PARENT"
        }
    }

    // Borrado de productos duplicados
    test("product_merge parent view should be tracked"){
        "/structure_data/product_merge/parent_analysis"(platform: "/web/desktop", type: TrackType.View) {
            session_id = "12334.1-sdweurw2873423hwrhweh"
            sheet_id = "12334.1"
            is_retake = true
        }
    }

    test("product_merge children view should be tracked"){
        "/structure_data/product_merge/children_analysis"(platform: "/web/desktop", type: TrackType.View) {
            session_id = "12334.1-sdweurw2873423hwrhweh"
            sheet_id = "12334.1"
            is_retake = true
        }
    }

    test("product_merge congrats view should be tracked"){
        "/structure_data/product_merge/congrats"(platform: "/web/desktop", type: TrackType.View) {
            session_id = "12334.1-sdweurw2873423hwrhweh"
            sheet_id = "12334.1"
            is_retake = true
        }
    }

     test("load available products event should be tracked"){
        "/structure_data/product_merge/available_products"(platform: "/web/desktop", type: TrackType.View) {
            products_ids = [12223, 343343]
        }
    }

    // Catalog search

    def searchProductQuery = {
        site_filter = "MLA"
        query_filter = "philips"
        domain_filter = "tv"
        is_gtin = false
        displayed_sources = [
                "ice-cat",
                "meli",
                "bi_competence"
        ]
    }

    def searchGtinQuery = {
        site_filter = null
        query_filter = "01234567890123"
        domain_filter = null
        is_gtin = true
        displayed_sources = [
                "meli",
                "ice-cat",
                "marca",
                "to",
                "gepir",
        ]
    }

    test("catalog_search product query should be tracked"){
        "/structure_data/catalog_search/query"(platform: "/web/desktop", type: TrackType.Event) {
            searchProductQuery()
            has_results = true
        }
    }

    test("catalog_search product query without results should be tracked"){
        "/structure_data/catalog_search/query"(platform: "/web/desktop", type: TrackType.Event) {
            searchProductQuery()
            has_results = false
        }
    }

    test("catalog_search gtin query should be tracked"){
        "/structure_data/catalog_search/query"(platform: "/web/desktop", type: TrackType.Event) {
            searchGtinQuery()
            has_results = true
            unknown_info_sources = ["upc_item_db"]
        }
    }

    test("catalog_search gtin query without results not unknown sources should be tracked"){
        "/structure_data/catalog_search/query"(platform: "/web/desktop", type: TrackType.Event) {
            searchGtinQuery()
            has_results = false
            unknown_info_sources = []
        }
    }


    test("catalog_search query with no site should be tracked"){
        "/structure_data/catalog_search/query"(platform: "/web/desktop", type: TrackType.Event) {
            query_filter = "philips"
            domain_filter = "tv"
            is_gtin = false
            has_results = true
        }
    }

    test("catalog_search query with no domain should be tracked"){
        "/structure_data/catalog_search/query"(platform: "/web/desktop", type: TrackType.Event) {
            site_filter = "MLB"
            query_filter = "philips"
            is_gtin = false
            has_results = true
        }
    }

    test("catalog_search query with no query should be tracked"){
        "/structure_data/catalog_search/query"(platform: "/web/desktop", type: TrackType.Event) {
            site_filter = "MLB"
            query_filter = "AUTOMOTIVE_TIRES"
            is_gtin = false
            has_results = true
        }
    }

    test("catalog_search wrong domain prediction should be tracked"){
        "/structure_data/catalog_search/wrong_domain_prediction"(platform: "/web/desktop", type: TrackType.Event) {
            product_id = "b7c088e9-502f-4ed2-9446-0c865e024d7a"
            product_source = "ice-cat"
            product_external_id = "554178"
            external_domain = "Ordenadores móviles industriales"
            predicted_domain = "Tablets"
            selected_domain = "Notebooks"
        }
    }

    test("catalog_search wrong domain prediction without selected domain should be tracked"){
        "/structure_data/catalog_search/wrong_domain_prediction"(platform: "/web/desktop", type: TrackType.Event) {
            product_id = "b7c088e9-502f-4ed2-9446-0c865e024d7a"
            product_source = "ice-cat"
            product_external_id = "554178"
            external_domain = "Ordenadores móviles industriales"
            predicted_domain = "Tablets"
        }
    }

    test("catalog_search wrong external domain should be tracked"){
        "/structure_data/catalog_search/wrong_external_domain"(platform: "/web/desktop", type: TrackType.Event) {
            product_id = "b7c088e9-502f-4ed2-9446-0c865e024d7a"
            product_source = "ice-cat"
            product_external_id = "554178"
            external_domain = "Ordenadores móviles industriales"
        }
    }

    test("catalog_search wrong external attribute should be tracked"){
        "/structure_data/catalog_search/wrong_external_attribute"(platform: "/web/desktop", type: TrackType.Event) {
            product_id = "b7c088e9-502f-4ed2-9446-0c865e024d7a"
            product_source = "ice-cat"
            product_external_id = "554178"
            external_domain = "Ordenadores móviles industriales"
            external_attribute_key = "Interfaz"
            external_attribute_value = "Bluetooth v2.0"
        }
    }

    test("catalog_search copied external attribute"){
        "/structure_data/catalog_search/copied_external_attribute"(platform: "/web/desktop", type: TrackType.Event) {
            is_gtin = false
            displayed_sources = [
                    "meli",
            ]
            product_id = "b7c088e9-502f-4ed2-9446-0c865e024d7a"
            product_source = "ice-cat"
            product_external_id = "554178"
            external_domain = "Ordenadores móviles industriales"
            external_attribute_key = "GTIN"
            external_attribute_value = "0882780449312,0882780449459"
        }
    }

    test("catalog_search copied metadata attribute should be tracked"){
        "/structure_data/catalog_search/copied_external_attribute"(platform: "/web/desktop", type: TrackType.Event) {
            is_gtin = false
            displayed_sources = [
                    "upc_item_db",
            ]
            searchProductQuery()
            product_source = "gepir"
            external_attribute_key = "GTIN"
            external_attribute_value = "0882780449312"
        }
    }
}