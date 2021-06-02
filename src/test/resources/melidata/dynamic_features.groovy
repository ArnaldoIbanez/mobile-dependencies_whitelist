package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    
    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Dynamic Features
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Dynamic features track - ML") {

	    // Dynamic Features Events
	    "/dynamic_features/downloaded"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            new_deeplink = "meli://new_deeplink"
            old_deeplink = "meli://old_deeplink"
		}

		"/dynamic_features/failed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            old_deeplink = "meli://old_deeplink"
		}
        "/dynamic_features/launched"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            new_deeplink = "meli://new_deeplink"
            old_deeplink = "meli://old_deeplink"
		}    
        "/dynamic_features/canceled"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            old_deeplink = "meli://old_deeplink"
		}
    }

    defaultBusiness = "mercadopago"

    test("Dynamic features track - MP") {

	    // Dynamic Features Events
	    "/dynamic_features/downloaded"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            new_deeplink = "meli://new_deeplink"
            old_deeplink = "meli://old_deeplink"
		}

		"/dynamic_features/failed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            old_deeplink = "meli://old_deeplink"
		}
        "/dynamic_features/launched"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            new_deeplink = "meli://new_deeplink"
            old_deeplink = "meli://old_deeplink"
		}    
        "/dynamic_features/canceled"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            old_deeplink = "meli://old_deeplink"
		}
    }
}