package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    def trackData = {
        warehouse_id = "BRWT01"
        user_id = "12345"
        email = "email@mercadolibre.com.ar",
        first_name = "Some first name",
        last_name = "Some last name",
        error_type = "SERVER",
        feedback_type = "WARNING"
    }

    test("wms app") {

        //Views
        "/wms/receiving"(platform: "/mobile", type: TrackType.View) {
        	trackData()
        }
		"/wms/put_away"(platform: "/mobile", type: TrackType.View) {
			trackData()
		}
		"/wms/inbound_audit"(platform: "/mobile", type: TrackType.View) {
			trackData()
		}
		"/wms/transfer"(platform: "/mobile", type: TrackType.View) {
			trackData()
		}
		"/wms/found"(platform: "/mobile", type: TrackType.View) {
			trackData()
		}
		"/wms/restock"(platform: "/mobile", type: TrackType.View) {
			trackData()
		}
		"/wms/picking"(platform: "/mobile", type: TrackType.View) {
			trackData()
		}
		"/wms/return"(platform: "/mobile", type: TrackType.View) {
			trackData()
		}

    }
}
