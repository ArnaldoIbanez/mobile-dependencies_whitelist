package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// TRACKS Dynamic stop landing
	//------------------------------------------------------------------------------------------------------------------------------------------------------

trackTests {

	defaultBusiness = "mercadolibre"

	test("Dynamic Stop Landing track ML") {
		"/stop_landing"(platform: '/'){
			campaign = 'copa_america'
		}
		"/stop_landing"(platform: '/'){
			campaign = 'sube'
			extra_params = 'booster_id=1234'
		}
		"/stop_landing"(platform: '/'){
			campaign = 'coupons'
			extra_params = 'booster_id=1234&media=whatsapp'
		}
		"/stop_landing/redirect"(platform: '/'){
			campaign = 'sube'
			extra_params = 'booster_id=1234&media=whatsapp'
		}
		"/stop_landing/redirect"(platform: '/'){
			campaign = 'copa_america'
			extra_params = 'booster_id=1234'
		}
		"/stop_landing/redirect"(platform: '/'){
			campaign = 'copa_america'
		}
		"/stop_landing/button"(platform: '/'){
			campaign = 'copa_america'
		}
		"/stop_landing/button"(platform: '/'){
			campaign = 'copa_america'
			extra_params = 'booster_id=1234&media=whatsapp'
		}
	}

	defaultBusiness = "mercadopago"

	test("Dynamic Stop Landing track MP") {
		"/stop_landing"(platform: '/'){
			campaign = 'copa_america'
		}
		"/stop_landing"(platform: '/'){
			campaign = 'sube'
			extra_params = 'booster_id=1234'
		}
		"/stop_landing"(platform: '/'){
			campaign = 'coupons'
			extra_params = 'booster_id=1234&media=whatsapp'
		}
		"/stop_landing/redirect"(platform: '/'){
			campaign = 'sube'
			extra_params = 'booster_id=1234&media=whatsapp'
		}
		"/stop_landing/redirect"(platform: '/'){
			campaign = 'copa_america'
			extra_params = 'booster_id=1234'
		}
		"/stop_landing/redirect"(platform: '/'){
			campaign = 'copa_america'
		}
		"/stop_landing/button"(platform: '/'){
			campaign = 'copa_america'
		}
		"/stop_landing/button"(platform: '/'){
			campaign = 'copa_america'
			extra_params = 'booster_id=1234&media=whatsapp'
		}
	}
}
