package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PayersGrowth
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Dynamic Links track") {

	    // Dynamic Links Events
	    "/dynamiclink/url-opened"(platform: "/mobile", type: TrackType.Event) {
			url = "http://www.mercadolibre.com"
		}
		"/dynamiclink/link/success"(platform: "/mobile", type: TrackType.Event) {
			url = "http://www.mercadolibre.com"
		}
	    "/dynamiclink/link/failed"(platform: "/mobile", type: TrackType.Event) {}
    }
}