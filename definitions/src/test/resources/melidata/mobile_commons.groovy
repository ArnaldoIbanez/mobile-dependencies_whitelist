package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Generic error") {

        "/friction"(platform: "/mobile", type: TrackType.Event) {
            path = "/px_checkout/generic_error"
            style = "screen"
            id = "px_generic_error"
            message = "Hubo un error"
            extra_info = {
                api_status_code = "code"
                api_error_message =  "message"
                api_url = "get_preference"
                retry_available = true
            }
            attributable_to = "mercadopago"
        }
    }

    defaultBusiness = "mercadopago"

    test("Generic error") {

        "/friction"(platform: "/mobile", type: TrackType.Event) {
            path = "/px_checkout/generic_error"
            style = "screen"
            id = "px_generic_error"
            message = "Hubo un error"
            extra_info = {
                api_status_code = "code"
                api_error_message =  "message"
                api_url = "get_preference"
                retry_available = true
            }
            attributable_to = "mercadopago"
        }


        "/friction"(platform: "/mobile", type: TrackType.Event) {
            path = "/checkout/review"
            style = "non_screen"
            id = "invalid_esc"
            extra_info = {
                api_status_code = "code"
                api_error_message =  "message"
                api_url = "get_preference"
                retry_available = true
            }
            attributable_to = "mercadopago"
            session_id = "user_session_id"
        }
    }
    
}