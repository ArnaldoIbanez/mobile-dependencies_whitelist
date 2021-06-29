package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    
    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Dynamic Features
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Dynamic features track - ML") {

		"/dynamic_features/failed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            failed_reason = "some failed reason"
            static_deeplink = "meli://old_deeplink"
		}
        "/dynamic_features/launched"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
		}    
        "/dynamic_features/canceled"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            static_deeplink = "meli://old_deeplink"
		}
        "/dynamic_features/dispatched"(platform: "/mobile", type: TrackType.Event) {
            static_deeplink = "meli://old_deeplink"
		}

        "/dynamic_features/installed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
		}
    }

    defaultBusiness = "mercadopago"

    test("Dynamic features track - MP") {

		"/dynamic_features/failed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_module_size = "500k"
            static_deeplink = "meli://old_deeplink"
		}
        "/dynamic_features/launched"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
		}    
        "/dynamic_features/canceled"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            static_deeplink = "meli://old_deeplink"
		}
        "/dynamic_features/dispatched"(platform: "/mobile", type: TrackType.Event) {
            static_deeplink = "meli://old_deeplink"
		}

        "/dynamic_features/installed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            dynamic_deeplink = "meli://new_deeplink"
            static_deeplink = "meli://old_deeplink"
		}
    }
}