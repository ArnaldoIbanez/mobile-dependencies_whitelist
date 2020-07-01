package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests { 

    test("qadb tracks") {

        def qadbDefaultTrack = {
            catalog_product_id = "MLA14141085"
            catalog_parent_id = "MLA1234"
            item_id = "MLA8092342"
            context = "PDP"
            results = [
                {
                    question_id = "1452322"
                    answers = [
                        {
                            id = "10293"
                        }
                        {
                            id = "97328"
                        }
                    ]
                },
                {
                    question_id = "98273"
                    answers = [
                        {
                            id = "22222"
                        }
                        {
                            id = "2098173"
                        }
                    ]
                }
            ]
        }

        def qadbBaseInfo = {
            catalog_product_id = "MLA14141085"
            catalog_parent_id = "MLA1234"
            item_id = "MLA8092342"
            query = "Tenes Stock?"
        }

        "/questions/qadb/view"(platform: "/", type: TrackType.Event) {
            qadbDefaultTrack()
        }

        "/questions/qadb/show"(platform: "/", type: TrackType.View) {
            qadbDefaultTrack()
        }

        "/questions/qadb/search"(platform: "/", type: TrackType.Event) {
            qadbDefaultTrack()
            query = "Stock"
            transactional_results = [
                {
                    transactional_type = "SHIPPING"
                }
            ]
            intentions = [
                    {
                        transactional_type = "SHIPPING"
                    },
                    {
                        transactional_type = "STOCK"
                    }
            ]
        }

        "/questions/qadb/feedback"(platform: "/", type: TrackType.Event) {
            qadbBaseInfo()
            transactional_type = "SHIPPING"
            feedbackMessage = true
        }

        "/questions/qadb/see_more"(platform: "/", type: TrackType.Event) {
            qadbBaseInfo()
            see_more_limit = 3
            total_answers = 8
            context = "PDP"
        }

        "/questions/qadb/more_info"(platform: "/", type: TrackType.Event) {
            qadbBaseInfo()
            transactional_type = "SHIPPING"
            context = "PDP"
        }

        "/questions/qadb/input_focus"(platform: "/", type: TrackType.Event) {
            catalog_product_id = "MLA14141085"
            catalog_parent_id = "MLA1234"
            item_id = "MLA8092342"
            context = "PDP"
        }

        "/questions/qadb/question"(platform: "/") {
            qadbBaseInfo()
            context = "PDP"
        }

        "/questions/qadb/smart_vs_modal"(platform: "/", type: TrackType.Event) {
            catalog_product_id = "MLA14141085"
            catalog_parent_id = "MLA1234"
            item_id = "MLA8092342"
            context = "PDP"
        }
    }
}