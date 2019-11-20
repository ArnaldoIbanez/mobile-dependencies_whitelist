package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    def defaultLocation =
            {
                latitude = "-36.34443"
                longitude = "-35.34332"
            }

    test("Testing logistics") {
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
        "/logistics/login/select_country"(platform: "/mobile", type: TrackType.View) {
            device_id = "123"
            defaultLocation()
        }

        //Login vehicle disclaimer
        "/logistics/login/vehicle/start"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Login vehicle scanner
        "/logistics/login/vehicle/scanner"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Login vehicle detected
        "/logistics/login/vehicle/scanner/vehicle_detected"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            status = "ok"
            vehicle_id = "123"
        }

        //Login document input
        "/logistics/login/document"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Login account disabled error
        "/logistics/login/account_disabled"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            error_type = "vehicle"
        }

        //Login error generic
        "/logistics/login/error"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Login vehicle on route error
        "/logistics/login/vehicle_on_route"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            vehicle_id = "123"
        }

        //Login driver on route error
        "/logistics/login/driver_on_route"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            driver_id = "987"
        }

        //Profile
        "/logistics/login/profile"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Camera permission
        "/logistics/flow_decision/start/ask_geolocation"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Geolocation permission
        "/logistics/flow_decision/start/ask_camera"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Flow decision scanner disclaimer
        "/logistics/flow_decision/start"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Flow decision scanner
        "/logistics/flow_decision/scanner"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Flow decision scanner error
        "/logistics/flow_decision/add_package/invalid"(platform: "/mobile", type: TrackType.View) {
            pack_id = "124"
            defaultLocation()
        }

        //Flow decision container error
        "/logistics/flow_decision/add_container/invalid"(platform: "/mobile", type: TrackType.View) {
            container_id = "AD_123"
            defaultLocation()
        }

        //Conciliation sorting fail
        "/logistics/conciliation/fail"(platform: "/mobile") {}

        //Conciliation sorting ok
        "/logistics/conciliation/ok"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Testing Logistics Last Mile") {
        "/logistics/last_mile/login/recover_trip"(platform: "/mobile", type: TrackType.View){
            route_id = "123"
            defaultLocation()
        }
        "/logistics/last_mile/profile"(platform: "/mobile", type: TrackType.View){
            defaultLocation()
        }
        "/logistics/last_mile/add_package/invalid"(platform: "/mobile", type: TrackType.View) {
            pack_id = "124"
            defaultLocation()
        }
        "/logistics/last_mile/package/scanner"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            route_id = "125"
        }
        "/logistics/last_mile/package/scanner/manual"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }
        "/logistics/last_mile/package/scanner/qr_detected"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            status = "ok"
            json_data = "json"
        }
        "/logistics/last_mile/list"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            route_id = "123"
            packs_info= "packs info"
            route_status = "pending"
        }
        "/logistics/last_mile/list/old_route"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            route_id = "123"
            packs_amount= 1
        }

        "/logistics/last_mile/list/start_trip"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            packs_info = "pack"
        }

        "/logistics/last_mile/list/retry_trip"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            packs_info = "pack"
            route_status = "pending"
        }

        "/logistics/last_mile/list/fraud"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/logistics/last_mile/congrats/final"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/logistics/last_mile/congrats/ok"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/logistics/last_mile/congrats/fail"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
        }

        "/logistics/last_mile/detail"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            is_next_destination = true
        }

        "/logistics/last_mile/detail/distance_modal"(platform: "/mobile", type: TrackType.View) {
            defaultLocation()
            current_distance = "500"
            context = "could_not_deliver"
        }

        "/logistics/last_mile/detail/start_trip"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            packs_info = "pack"
        }

        "/logistics/last_mile/detail/retry_trip"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            packs_info = "pack"
        }

        "/logistics/last_mile/detail/call_buyer"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            packs_info = "pack"
            buyer_id = "132"
        }

        "/logistics/last_mile/detail/view_map"(platform: "/mobile", type: TrackType.Event) {
            defaultLocation()
            packs_info = "pack"
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
        "/logistics/last_mile/profile"(platform: "/mobile", type: TrackType.View){
            defaultLocation()
        }
    }

}
