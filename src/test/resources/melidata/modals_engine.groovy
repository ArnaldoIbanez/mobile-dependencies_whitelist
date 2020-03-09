package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PayersGrowth
    //------------------------------------------------------------------------------------------------------------------------------------------------------
	["mercadolibre", "mercadopago"].each { business ->
		defaultBusiness = business
		test("Modals Engine ${business} tests") {

			// Show
			"/modals_engine"(platform: "/mobile", type: TrackType.View) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
				from = "notifications_center"
			}
			"/modals_engine"(platform: "/mobile", type: TrackType.View) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
			}
			"/modals_engine/dismiss"(platform: "/mobile", type: TrackType.Event) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
				from = "notifications_center"
			}
			"/modals_engine/dismiss"(platform: "/mobile", type: TrackType.Event) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
			}
			"/modals_engine/cta"(platform: "/mobile", type: TrackType.Event) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
				from = "notifications_center"
				button_type = "option"
				link = "meli://wallet"
			}
			"/modals_engine/cta"(platform: "/mobile", type: TrackType.Event) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
				button_type = "primary"
				link = "mercadopago://wallet"
			}
			"/modals_engine/swipe"(platform: "/mobile", type: TrackType.Event) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
				from = "notifications_center"
				position = 0
			}
			"/modals_engine/swipe"(platform: "/mobile", type: TrackType.Event) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
				position = 0
			}
			"/modals_engine/error"(platform: "/mobile", type: TrackType.Event) {
				id = "modal_id"
				bu = "bu"
				bu_line = "bu_line"
				flow = "flow"
				modal_type = "modal_type"
				type = "no_modal_found"
			}
		}
	}
}
