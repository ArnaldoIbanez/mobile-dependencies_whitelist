package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// TRACKS Marketing performance landings
	//------------------------------------------------------------------------------------------------------------------------------------------------------

trackTests {

	defaultBusiness = "mercadopago"

	test("Marketing Performance Landing Recharge track MP") {
		"/mkt_performance_landing/recharge"(platform: '/web'){}

		"/mkt_performance_landing/recharge/sms"(platform: '/web'){}

		"/mkt_performance_landing/recharge/copy-clipboard"(platform: '/web'){
			position = 'coupon'
		}

		"/mkt_performance_landing/recharge/copy-clipboard"(platform: '/web'){
			position = 'steps'
		}

		"/mkt_performance_landing/recharge/button"(platform: '/web'){
			position = 'hero'
		}

		"/mkt_performance_landing/recharge/button"(platform: '/web'){
			position = 'fixed'
		}

		"/mkt_performance_landing/recharge/button"(platform: '/web'){
			position = 'footer'
		}
	}

	test("Marketing Performance Landing Transport track MP") {
		"/mkt_performance_landing/transport"(platform: '/web'){}

		"/mkt_performance_landing/transport/sms"(platform: '/web'){}

		"/mkt_performance_landing/transport/copy-clipboard"(platform: '/web'){
			position = 'coupon'
		}

		"/mkt_performance_landing/transport/copy-clipboard"(platform: '/web'){
			position = 'steps'
		}

		"/mkt_performance_landing/transport/button"(platform: '/web'){
			position = 'hero'
		}

		"/mkt_performance_landing/transport/button"(platform: '/web'){
			position = 'fixed'
		}

		"/mkt_performance_landing/transport/button"(platform: '/web'){
			position = 'footer'
		}
		
	}
}
