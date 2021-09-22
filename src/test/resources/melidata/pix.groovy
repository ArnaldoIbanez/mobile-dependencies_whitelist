package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Pix Flows
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Pix Flows tracks") {

		// Landing
		"/pix_flows/landing"(platform: "/"){}
		"/pix_flows/landing/tap"(platform: "/"){
			action = 'pix_key'
		}
		"/pix_flows/landing/tap"(platform: "/"){
			action = 'money_in'
		}
		"/pix_flows/landing/tap"(platform: "/"){
			action = 'sell_cost'
		}
	}
}
