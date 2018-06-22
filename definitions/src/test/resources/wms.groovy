package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    def trackData = {
        warehouse_id = "BRWT01",
        email = "email@mercadolibre.com.ar",
        first_name = "Some first name",
        last_name = "Some last name",
        error_type = "SERVER",
        feedback_type = "WARNING"
    }

    test("wms app") {

        //Views
        "/wms/login"(platform: "/mobile/android") {
        	trackData()
        }
		"/wms/home"(platform: "/mobile/android") {
			trackData()
		}
        "/wms/receiving"(platform: "/mobile/android") {
        	trackData()
        }
		"/wms/put_away"(platform: "/mobile/android") {
			trackData()
		}
		"/wms/inbound_audit"(platform: "/mobile/android") {
			trackData()
		}
		"/wms/transfer"(platform: "/mobile/android") {
			trackData()
		}
		"/wms/found"(platform: "/mobile/android") {
			trackData()
		}
		"/wms/restock"(platform: "/mobile/android") {
			trackData()
		}
		"/wms/picking"(platform: "/mobile/android") {
			trackData()
		}
		"/wms/return"(platform: "/mobile/android") {
			trackData()
		}

    }
}
