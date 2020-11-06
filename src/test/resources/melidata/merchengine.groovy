package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    ["mercadolibre", "mercadopago"].each { business ->
        defaultBusiness = business
        //Modal Events
        test("Merchengine Modals tracking / [${business}]") {
            "/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
                component_id = "secondary_actions_payers_recharge_sube_mp"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                position = 0
                logic = "user_journey"
                flow = "default"
            }

            "/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
                component_id = "secondary_actions_payers_recharge_sube_mp"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                position = 0
                logic = "user_journey"
                flow = "default"
            }

            "/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
                component_id = "secondary_actions_payers_recharge_sube_mp"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                position = 0
                logic = "user_journey"
                flow = "default"
                action_id = "cta1"
                type = "primary"
                link = "mercadopago://wallet"
            }

            "/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
                component_id = "secondary_actions_payers_recharge_sube_mp"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                position = 3
                logic = "user_journey"
                flow = "default"
            }
            "/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
                component_id = "secondary_actions_payers_recharge_sube_mp"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                position = 0
                logic = "user_journey"
				audience = "all"
                flow = "default"
            }

            "/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
                component_id = "secondary_actions_payers_recharge_sube_mp"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                position = 0
                logic = "user_journey"
				audience = "all"
                flow = "default"
            }

            "/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
                component_id = "secondary_actions_payers_recharge_sube_mp"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                position = 0
                logic = "user_journey"
                flow = "default"
                action_id = "cta1"
                type = "primary"
				audience = "all"
                link = "mercadopago://wallet"
            }

            "/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
                component_id = "secondary_actions_payers_recharge_sube_mp"
                content_id = "recharge_sube"
                bu = "mp"
                bu_line = "default"
                position = 3
 				audience = "all"
                logic = "user_journey"
                flow = "default"
            }        
		}
    }
}