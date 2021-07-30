package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("Liveness mobile android ml") {

        "/liveness/enrollment"(platform: "/mobile/android") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/authentication"(platform: "/mobile/android") {
            params = "test=true"
        }

        "/liveness/validation"(platform: "/mobile/android") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
            initiative_id = "iv"
        }

        "/liveness/initialization"(platform: "/mobile/android") {
            initialization_result = true
            initialization_status = 0
            initialization_description = "test"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
        }

        "/liveness/challenge"(platform: "/mobile/android") {
            time = 1241
            challenge_result = 0
            challenge_result_description = "test"
        }

        "/liveness/result"(platform: "/mobile/android") {
            success = false
            upload_time = 1413
            liveness_result = 0 
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/redirect"(platform: "/mobile/android") {
            deeplink = "meli:/home"
        }

        "/liveness/bussines_error"(platform: "/mobile/android") {
            error_message = "error 200"
        }

        "/liveness/generic_error"(platform: "/mobile/android") {
            error_type = "test"
            error_cause = "true"
        }

        "/liveness/action"(platform: "/mobile/android") {
            type = "close"
        }

        "/liveness/landing"(platform: "/mobile/android") {}

        "/liveness/fallback"(platform: "/mobile/android") {}

        "/liveness/unsupported"(platform: "/mobile/android") {}
    }

    test("Liveness mobile ios ml") {

        "/liveness/enrollment"(platform: "/mobile/ios") {
            params = "test=true"
            initiative_id = "iv"
        }

        "/liveness/authentication"(platform: "/mobile/ios") {
            params = "test=true"
        }

        "/liveness/validation"(platform: "/mobile/ios") {
            params = "test=true"
        }

        "/liveness/initialization"(platform: "/mobile/ios") {
            initialization_result = true
            initialization_status = 0
            initialization_description = "test"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/challenge"(platform: "/mobile/ios") {
            time = 1241
            challenge_result = 0
            challenge_result_description = "test"
        }

        "/liveness/result"(platform: "/mobile/ios") {
            success = true
            upload_time = 1413
            liveness_result = 0
        }

        "/liveness/redirect"(platform: "/mobile/ios") {
            deeplink = "meli:/home"
        }

        "/liveness/bussines_error"(platform: "/mobile/ios") {
            error_message = "error 200"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
        }

        "/liveness/generic_error"(platform: "/mobile/ios") {
            error_type = "test"
            error_cause = "true"
        }
        "/liveness/action"(platform: "/mobile/ios") {
            type = "close"
        }

        "/liveness/landing"(platform: "/mobile/ios") {}

        "/liveness/fallback"(platform: "/mobile/ios") {}

        "/liveness/unsupported"(platform: "/mobile/ios") {}
    }

    test("Liveness mobile web ml") {

        "/liveness/enrollment"(platform: "/web") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/authentication"(platform: "/web") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }
        
        "/liveness/validation"(platform: "/web") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/initialization"(platform: "/web") {
            initialization_result = true
            initialization_status = 0
            initialization_description = "test"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/challenge"(platform: "/web") {
            time = 1241
            challenge_result = 0
            challenge_result_description = "test"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/result"(platform: "/web") {
            success = true
            upload_time = 1413
            liveness_result = 0 
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/redirect"(platform: "/web") {
            url = "www.mercadolibre.com"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/bussines_error"(platform: "/web") {
            error_message = "error 200"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/generic_error"(platform: "/web") {
            error_type = "test"
            error_cause = "true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/action"(platform: "/web") {
            type = "close"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/landing"(platform: "/web") {
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/fallback"(platform: "/web") {
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/unsupported"(platform: "/web") {
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }
    }

    defaultBusiness = "mercadopago"

    test("Liveness mobile android mp") {

        "/liveness/enrollment"(platform: "/mobile/android") {
            params = "test=true"
        }

        "/liveness/authentication"(platform: "/mobile/android") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
        }
        
        "/liveness/validation"(platform: "/mobile/android") {
            params = "test=true"
        }

        "/liveness/initialization"(platform: "/mobile/android") {
            initialization_result = true
            initialization_status = 0
            initialization_description = "test"
            initiative_id = "iv"
        }

        "/liveness/challenge"(platform: "/mobile/android") {
            time = 1241
            challenge_result = 0
            challenge_result_description = "test"
            transaction_id = "fdsf21341fdsf13123"
            initiative_id = "iv"
        }

        "/liveness/result"(platform: "/mobile/android") {
            success = true
            upload_time = 1413
            liveness_result = 0
        }

        "/liveness/redirect"(platform: "/mobile/android") {
            deeplink = "mercadopago:/home"
        }

        "/liveness/bussines_error"(platform: "/mobile/android") {
            error_message = "error 200"
        }

        "/liveness/generic_error"(platform: "/mobile/android") {
            error_type = "test"
            error_cause = "true"
            transaction_id = "fdsf21341fdsf13123"
        }

        "/liveness/action"(platform: "/mobile/android") {
            type = "close"
        }

        "/liveness/action"(platform: "/mobile/android") {
            type = "back"
        }

        "/liveness/action"(platform: "/mobile/android") {
            type = "start_liveness"
        }

        "/liveness/landing"(platform: "/mobile/android") {}

        "/liveness/fallback"(platform: "/mobile/android") {}

        "/liveness/unsupported"(platform: "/mobile/android") {}
    }

    test("Liveness mobile ios mp") {

        "/liveness/enrollment"(platform: "/mobile/ios") {
            params = "test=true"
        }

        "/liveness/authentication"(platform: "/mobile/ios") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
        }
        
        "/liveness/validation"(platform: "/mobile/ios") {
            params = "test=true"
        }

        "/liveness/initialization"(platform: "/mobile/ios") {
            initialization_result = true
            initialization_status = 0
            initialization_description = "test"
            initiative_id = "iv"
        }

        "/liveness/challenge"(platform: "/mobile/ios") {
            time = 1241
            challenge_result = 0
            challenge_result_description = "test"
            transaction_id = "fdsf21341fdsf13123"
            initiative_id = "iv"
        }

        "/liveness/result"(platform: "/mobile/ios") {
            success = true
            upload_time = 1413
            liveness_result = 0
        }

        "/liveness/redirect"(platform: "/mobile/ios") {
            deeplink = "mercadopago:/home"
        }

        "/liveness/bussines_error"(platform: "/mobile/ios") {
            error_message = "error 200"
            transaction_id = "fdsf21341fdsf13123"
        }

        "/liveness/generic_error"(platform: "/mobile/ios") {
            error_type = "test"
            error_cause = "true"
        }

        "/liveness/action"(platform: "/mobile/ios") {
            type = "close"
        }

        "/liveness/action"(platform: "/mobile/ios") {
            type = "back"
        }

        "/liveness/action"(platform: "/mobile/ios") {
            type = "start_liveness"
        }

        "/liveness/landing"(platform: "/mobile/ios") {}

        "/liveness/fallback"(platform: "/mobile/ios") {}

        "/liveness/unsupported"(platform: "/mobile/ios") {}
    }

    test("Liveness mobile web mp") {

        "/liveness/enrollment"(platform: "/web") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/authentication"(platform: "/web") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }
        
        "/liveness/validation"(platform: "/web") {
            params = "test=true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/initialization"(platform: "/web") {
            initialization_result = true
            initialization_status = 0
            initialization_description = "test"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/challenge"(platform: "/web") {
            time = 1241
            challenge_result = 0
            challenge_result_description = "test"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/result"(platform: "/web") {
            success = true
            upload_time = 1413
            liveness_result = 0 
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/redirect"(platform: "/web") {
            url = "www.mercadopago.com"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/bussines_error"(platform: "/web") {
            error_message = "error 200"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/generic_error"(platform: "/web") {
            error_type = "test"
            error_cause = "true"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/action"(platform: "/web") {
            type = "close"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/action"(platform: "/web") {
            type = "back"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/action"(platform: "/web") {
            type = "start_liveness"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/action"(platform: "/web") {
            type = "redirect"
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/landing"(platform: "/web") {
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/fallback"(platform: "/web") {
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }

        "/liveness/unsupported"(platform: "/web") {
            transaction_id = "fdsf21341fdsf13123"
            transaction_user_id = 124123123
            initiative_id = "iv"
        }
    }
}