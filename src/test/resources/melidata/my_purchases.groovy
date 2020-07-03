package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
  	// TRACKS MY PURCHASES STATUS
  	//------------------------------------------------------------------------------------------------------------------------------------------------------

	test("My Purchases - Status Page") {

		def newPurchasesDataSet = {
			purchases_flow= "v2"
			purchase_status= "paid"
			checkout_flow= "order"
			garex= "no"
			vertical_case_id= "shipping"
			vertical_sub_case_id= "shipping_delivered_delivery_address"
			x_mc_request_id= "aaaaa-vvvvvv-cccc-ddd"
			purchase_id= 1234
			pack_id= 1234
			order_id= 1234
		}

	    "/my_purchases/status"(platform: "/", type: TrackType.View) {
	    	newPurchasesDataSet()
	    }
	}
}
