package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
	defaultBusiness = "mercadolibre"
	test("Track variations edit") {

        def model1 = {
            context = "cart"
            items = [
                        [
                            label : "talle",
                            quantity_options  : 5,
                            custom : true,
                         ]
            ]
        }

        def model2 = {
            context = "vip_combo"
            close_index = 1
            items = [
                        [
                            label : "talle",
                            quantity_options  : 5,
                            custom : true,
                         ]
            ]
        }

        def model3 = {
            context = "cart_saved_for_later"
            items = [
                        [
                            label : "talle",
                            quantity_options  : 5,
                            custom : true,
                         ]
            ]
        }

        "/variations/edit"(platform:"/", {
			model1()
        })

        "/variations/cancel"(platform:"/web/desktop", {
        	model2()
        })

         "/variations/cancel"(platform:"/", {
        	model1()
        })

        "/variations/select"(platform:"/", {
            model3()
        })    
    }
}