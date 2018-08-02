package src.test.resources

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

	defaultBusiness = "mercadoenvios"

    def trackData = {
        warehouse_id = "BRWT01"
        email = "email@mercadolibre.com.ar"
        first_name = "Some first name"
        last_name = "Some last name"
        error_type = "SERVER"
        feedback_type = "WARNING"
    }

    def trackPutAwayData = {
        warehouse_id = "BRWT01"
        email = "email@mercadolibre.com.ar"
        first_name = "Some first name"
        last_name = "Some last name"
        error_type = "SERVER"
        feedback_type = "WARNING"
        put_away_id = "1234"
        check_in_id = "4567"
        cart = "CA-0-001-000-00-00"
    }

    test("WMS App") {

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
            trackPutAwayData()
        }
        "/wms/put_away/confirmation"(platform: "/mobile/android") {
            trackPutAwayData()
        }
        "/wms/put_away/scan_cart"(platform: "/mobile/android") {
            trackPutAwayData()
        }
        "/wms/put_away/scan_inventory"(platform: "/mobile/android") {
            trackPutAwayData()
        }
        "/wms/put_away/item"(platform: "/mobile/android") {
            trackPutAwayData()
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

        //Events
        "/wms/put_away/scan_cart/start_put_away"(platform: "/mobile/android") {
            trackPutAwayData()
        }
        "/wms/put_away/scan_inventory/cancel_put_away"(platform: "/mobile/android") {
            trackPutAwayData()
        }
        "/wms/put_away/scan_inventory/end_put_away"(platform: "/mobile/android") {
            trackPutAwayData()
        }
    }
}
