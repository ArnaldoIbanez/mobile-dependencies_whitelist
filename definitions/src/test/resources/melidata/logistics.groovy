package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    test("Testing logistics") {

        def defaultLocation =
                {
                    latitude = "-36.34443"
                    longitude = "-35.34332"
                }

        def vehicleInfo = {
            vehicle_id = "123"
            license_plate = "AAB456"
            carrier_id = "17044503"
        }

        def driverInfo = {
            driver_id = "987"
            document_number = "12345678912"
        }

        //Snackbar error event success
        "/logistics/error/snackbar"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            error_type = "delivery_failed"
            error_step_id = "example_step_id"
        }

        //Full error view page success
        "/logistics/error"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            error_type = "connection"
            error_step_id = "example_step_id"
        }

        //Login country selector
        "/logistics/login/select_country"(platform: "/mobile", type: TrackType.View){
            device_id = "123"
            defaultLocation()
        }

        //Login vehicle disclaimer
        "/logistics/login/vehicle/start"(platform: "/mobile", type: TrackType.View){}

        //Login vehicle scanner
        "/logistics/login/vehicle/scanner"(platform: "/mobile", type: TrackType.View){}

        //Login vehicle detected
        "/logistics/login/vehicle/scan/vehicle_detected"(platform: "/mobile", type: TrackType.Event) {
            status = "ok"
            vehicleInfo()
        }

        //Login document input
        "/logistics/login/document"(platform: "/mobile", type: TrackType.View){}

        //Login account disabled error
        "/logistics/login/account_disabled"(platform: "/mobile", type: TrackType.View) {
            error_type = "vehicle"
        }

        //Login error generic
        "/logistics/login/error"(platform: "/mobile", type: TrackType.View) {}

        //Login vehicle on route error
        "/logistics/login/vehicle_on_route"(platform: "/mobile", type: TrackType.View) {
            vehicleInfo()
        }

        //Login driver on route error
        "/logistics/login/driver_on_route"(platform: "/mobile", type: TrackType.View) {
            driverInfo()
        }

        //Conciliation sorting fail
        "/logistics/conciliation/fail"(platform: "/mobile"){}

        //Conciliation sorting ok
        "/logistics/conciliation/ok"(platform: "/mobile", type: TrackType.View){}
    }

    test("Testing Logistics Last Mile") {
        "/logistics/last_mile/login/recover_trip"(platform: "/mobile", type: TrackType.View){
            route_id = "123"
        }
    }

    test("Testing Logistics First Mile") {
        "/logistics/first_mile/scanner/modal_back"(platform: "/mobile", type: TrackType.View) {
            packs_amount = 1
        }

        "/logistics/first_mile/scanner/modal_back/back"(platform: "/mobile", type: TrackType.Event) {
            packs_amount = 2
        }

        "/logistics/first_mile/scanner/modal_back/cancel"(platform: "/mobile", type: TrackType.Event) {
            packs_amount = 3
        }
    }

}
