import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
	defaultBusiness = "mercadolibre"
	test("Track variations edit") {
		def itemModel1 = {
			id = "MLAITEM1"
    		attributes_variations = [{
                            label = "color"
                            quantity_options =5
                            custom = false
                            }]
		}
		def itemModel2 = {
			id  ="MLAITEM2"
    		attributes_variations = [{
                            label = "talle"
                            quantity_options = 5
                            custom = false
                            }]
		}

        def model1 = {
            context = "test-context"
            items = [itemModel1(), itemModel2()]
        }

        def model2 = {
            context = "test-context"
            close_index = 1
            items = [itemModel1(), itemModel2()]
        }

        "/variations/edit"(platform:"/", {
			model1()
        })

        "/variations/close"(platform:"/web", {
        	model2()
        })

         "/variations/close"(platform:"/", {
        	model1()
        })

        "/vip/select"(platform:"/", {
            model1()
        })    
    }
}