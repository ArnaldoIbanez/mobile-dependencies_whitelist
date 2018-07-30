package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Identity Validation ") {

        "/identity-validation/validation_landing"(platform: "/web/mobile") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/web/mobile") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/web/mobile") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/web/mobile") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/web/mobile") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/web/desktop") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/web/desktop") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/web/desktop") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/web/desktop") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/mobile/android") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/mobile/android") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/android") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/mobile/android") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/validation_landing"(platform: "/mobile/ios") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/start_validation"(platform: "/mobile/ios") {
            flow = "ms_hard_validation"
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "documentation"
            success = true
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "phone"
            success = false
        }

        "/identity-validation/finish_challenge"(platform: "/mobile/ios") {
            type = "recommendation"
            success = true
        }

        "/identity-validation/finish_validation"(platform: "/mobile/ios") {
            result = "valid"
            flow = "ms_hard_validation"
        }

        "/identity-validation/upload_compress"(platform: "/mobile/ios") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/mobile/android") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/web/mobile") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/upload_compress"(platform: "/web/desktop") {
            upload_time = 10
            compression_time = 10
        }

        "/identity-validation/image_error"(platform: "/mobile/ios") {
            source = "TAKE_PHOTO"
        }

        "/identity-validation/image_error"(platform: "/mobile/android") {
            source = "TAKE_PHOTO"
        }

        "/identity-validation/image_error"(platform: "/web/mobile") {
            source = "TAKE_PHOTO"
        }

        "/identity-validation/image_error"(platform: "/web/desktop") {
            source = "TAKE_PHOTO"
        }

        "/identity-validation/phone_code"(platform: "/mobile") {}
        "/identity-validation/phone"(platform: "/mobile") {}
        "/identity-validation/upload_doc"(platform: "/mobile") {}
        "/identity-validation/landing"(platform: "/mobile") {}
        "/identity-validation/congrats"(platform: "/mobile") {}
        "/identity-validation/landing_doc"(platform: "/mobile") {}
        "/identity-validation/doc_number"(platform: "/mobile") {}

        "/identity-validation/phone_code"(platform: "/web/desktop") {}
        "/identity-validation/phone"(platform: "/web/desktop") {}
        "/identity-validation/upload_doc"(platform: "/web/desktop") {}
        "/identity-validation/landing"(platform: "/web/desktop") {}
        "/identity-validation/congrats"(platform: "/web/desktop") {}
        "/identity-validation/landing_doc"(platform: "/web/desktop") {}
        "/identity-validation/doc_number"(platform: "/web/desktop") {}

        "/identity-validation/phone_code"(platform: "/web/mobile") {}
        "/identity-validation/phone"(platform: "/web/mobile") {}
        "/identity-validation/upload_doc"(platform: "/web/mobile") {}
        "/identity-validation/landing"(platform: "/web/mobile") {}
        "/identity-validation/congrats"(platform: "/web/mobile") {}
        "/identity-validation/landing_doc"(platform: "/web/mobile") {}
        "/identity-validation/doc_number"(platform: "/web/mobile") {}
    }


}
