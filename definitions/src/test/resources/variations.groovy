import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
	defaultBusiness = "mercadolibre"
	test("Track variations edit") {

        def model1 = {
            context = "test-context"
            items = [
                        [
                            label : "talle",
                            quantity_options  : 5,
                            custom : true,
                         ]
            ]
        }

        def model2 = {
            context = "test-context2"
            items = [
                        [
                            label : "talle",
                            quantity_options  : 5,
                            custom : true,
                         ]
            ]
        }


        def defaultCheckoutTrackInformation = {
            purchase_id = 1000000016961120
            purchase_status = "payment_in_process"
            shipping_type = "ENVIO"
            payments = [
                    [
                            id : 3753658455,
                            status : "in_process",
                            date_created : "2018-05-22T18:24:50Z",
                            status_detail : "pending_review_manual",
                            date_approved : "0001-01-01T00:00:00Z",
                            method_id : "hipercard",
                            type : "credit_card",
                            date_last_modified : "2018-05-22T18:24:50Z",
                    ]
            ]
            buy_equals_pay = true
        }

        "/variations/edit"(platform:"/", {
			model1()
        })

        "/variations/cancel"(platform:"/web", {
        	model2()
        })

         "/variations/cancel"(platform:"/", {
        	model1()
        })

        "/variations/select"(platform:"/", {
            model1()
        })    
    }
}