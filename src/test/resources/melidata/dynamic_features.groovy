package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Dynamic Features
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Dynamic features track") {

	    // Dynamic Features Events
	    "/dynamyc_features/downloaded"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            new_deeplink = "meli://new_deeplink"
            old_deeplink = "meli://old_deeplink"
		}

		"/dynamyc_features/failed"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            old_deeplink = "meli://old_deeplink"
		}
        "/dynamyc_features/launched"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            new_deeplink = "meli://new_deeplink"
            old_deeplink = "meli://old_deeplink"
		}    
        "/dynamyc_features/canceled"(platform: "/mobile", type: TrackType.Event) {
            module_name = "module_dynamic"
            old_deeplink = "meli://old_deeplink"
		}
}