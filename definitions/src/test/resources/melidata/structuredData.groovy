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
            sections_comments = '{ "action_source": 1, "association": 2, "attributes": 3 }'
            errors_codes = '{ "E-ADS": 1, "E-COM": 2, "E-FOR": 3 }'
        }
    }

}