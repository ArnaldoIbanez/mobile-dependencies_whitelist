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
        }

        //Login vehicle disclaimer
        "/logistics/login/vehicle/start"(platform: "/mobile", type: TrackType.View){}

        //Login vehicle scanner
        "/logistics/login/vehicle/scan"(platform: "/mobile", type: TrackType.View){}

        //Login document input
        "/logistics/login/document"(platform: "/mobile", type: TrackType.View){}

        //Last Mile active route disclaimer
        "/logistics/last_mile/login/recover_trip"(platform: "/mobile", type: TrackType.View){
            route_id = "123"
        }

        //Conciliation sorting fail
        "/logistics/conciliation/fail"(platform: "/mobile"){}

        //Conciliation sorting ok
        "/logistics/conciliation/ok"(platform: "/mobile", type: TrackType.View){}
    }

}
