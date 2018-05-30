package src.test.resources
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
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
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
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
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
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
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
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
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
            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
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

            inferred_attributes= [[id: "BRAND", old_value: "Inferred", new_value: "Inferred", sucess: true ], [id: "BRAND", old_value: "Inferred", new_value: "New", sucess: false]]
        }
    }

    test("catalog_widget congrats should be tracked"){
        "/catalogwidget/final_congrats"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            pi = false

        }
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
        }
    }
}
