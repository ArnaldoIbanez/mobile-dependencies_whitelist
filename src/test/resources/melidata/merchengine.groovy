package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

	defaultBusiness = "mercadolibre"

	test("Merchengine ML track") {

		//Modal Events
		"/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
			realestate_id = "modal_home_mp_v2"
			content_id = "ftu_recarga_discount"
			origin = "user_journey"
		}

		"/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
			realestate_id = "modal_home_mp_v2"
			content_id = "ftu_recarga_discount"
			origin = "user_journey"
		}

		"/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
			realestate_id = "modal_home_mp_v2"
			content_id = "ftu_recarga_discount"
			origin = "user_journey"
			type = "primary"
		}

		"/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
			realestate_id = "modal_home_mp_v2"
			content_id = "ftu_recarga_discount"
			origin = "user_journey"
			position = "1"
		}
	}

	defaultBusiness = "mercadopago"

	test("Merchengine MP tracks") {

		//Modal Events
		"/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
			realestate_id = "modal_home_mp_v2"
			content_id = "ftu_recarga_discount"
			origin = "user_journey"
		}

		"/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
			realestate_id = "modal_home_mp_v2"
			content_id = "ftu_recarga_discount"
			origin = "user_journey"
		}

		"/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
			realestate_id = "modal_home_mp_v2"
			content_id = "ftu_recarga_discount"
			origin = "user_journey"
			type = "primary"
		}

		"/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
			realestate_id = "modal_home_mp_v2"
			content_id = "ftu_recarga_discount"
			origin = "user_journey"
			position = "1"
		}
	}
}