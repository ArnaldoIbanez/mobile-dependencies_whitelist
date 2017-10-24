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
        }
    }

    test("catalog_widget skip should be tracked"){
        "/catalogwidget/omit"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "none"
            items_left = 15
            missing_attributes = "BRAND,MODEL,GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
        }
    }

    test("catalog_widget skip should be tracked"){
        "/catalogwidget/omit_save"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "none"
            items_left = 15
            missing_attributes = "BRAND,MODEL,GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            motive = "notApply"
        }
    }

    test("catalog_widget skip should be tracked"){
        "/catalogwidget/omit_save"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "none"
            items_left = 15
            missing_attributes = "BRAND,MODEL,GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            motive = "noData"
        }
    }

    test("catalog_widget skip should be tracked"){
        "/catalogwidget/omit_save"(platform: "/", type: TrackType.Event){
            category_id = "MLA390784"
            page = "summary"
            item_id = "MLA682118081"
            officialstore = false
            completeness_level = "none"
            items_left = 15
            missing_attributes = "BRAND,MODEL,GTIN"
            domain_id = "MLA-FRAGRANCES"
            seller_id = "241616388"
            motive = "Custom reason"
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
        }
    }
}