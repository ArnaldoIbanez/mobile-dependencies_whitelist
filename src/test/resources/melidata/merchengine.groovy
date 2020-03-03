package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Merchengine ML track") {

	    //Modal Events
    	"/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
			content_id = "ftu_recarga_discount"
			position = 1.0
			component_id="user_secondary_actions"
			audience = "all"
			bu_line = "default"
			flow = "default"
			logic = "campaigns"
		}

    	"/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
			content_id = "ftu_recarga_discount"
			position = 1.0
			component_id="user_secondary_actions"
			audience = "all"
			bu_line = "default"
			flow = "default"
			logic = "campaigns"
		}

		"/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
			content_id = "ftu_recarga_discount"
			type = "primary"
			link = "mercadopago://asset-management/"
			position = 1.0
			component_id="user_secondary_actions"
			audience = "all"
			bu_line = "default"
			flow = "default"
			logic = "campaigns"
		}

		"/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
			content_id = "ftu_recarga_discount"
			position = 1.0
			component_id="user_secondary_actions"
			audience = "all"
			bu_line = "default"
			flow = "default"
			logic = "campaigns"
		}
    }

    defaultBusiness = "mercadopago"

    test("Merchengine MP tracks") {

		//Modal Events
		"/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
			content_id = "ftu_recarga_discount"
			position = 1.0
			component_id="user_secondary_actions"
			audience = "all"
			bu_line = "default"
			flow = "default"
			logic = "campaigns"
		}

		"/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
			content_id = "ftu_recarga_discount"
			position = 1.0
			component_id="user_secondary_actions"
			audience = "all"
			bu_line = "default"
			flow = "default"
			logic = "campaigns"
		}

		"/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
			content_id = "ftu_recarga_discount"
			type = "primary"
			link = "mercadopago://asset-management/"
			position = 1.0
			component_id="user_secondary_actions"
			audience = "all"
			bu_line = "default"
			flow = "default"
			logic = "campaigns"
		}

		"/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
			content_id = "ftu_recarga_discount"
			position = 1.0
			component_id="user_secondary_actions"
			audience = "all"
			bu_line = "default"
			flow = "default"
			logic = "campaigns"
		}
    }
}
