import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("Asset management") {

        // Onboarding
        "/asset_management/onboarding"(platform: "/mobile") {}

        // Challenges
        "/asset_management/challenge_pep"(platform: "/mobile") {}
        "/asset_management/challenge_fatca"(platform: "/mobile") {}
        "/asset_management/challenge_regulated_entity"(platform: "/mobile") {}
        "/asset_management/challenge_manual_input_dob"(platform: "/mobile") {}
        "/asset_management/challenge_manual_input_document"(platform: "/mobile") {}
        "/asset_management/challenge_mismatch"(platform: "/mobile") {}
        "/asset_management/challenge_cx_pending"(platform: "/mobile") {}
        "/asset_management/challenge_number_of_attempts_exceeded"(platform: "/mobile") {}
        "/asset_management/challenge_identity_validation"(platform: "/mobile") {}
        "/asset_management/challenge_identification_bad_quality"(platform: "/mobile") {}
        "/asset_management/challenge_country_of_birth"(platform: "/mobile") {}
        "/asset_management/challenge_review_and_confirm"(platform: "/mobile") {}
        "/asset_management/challenge_document_type"(platform: "/mobile") {}
        "/asset_management/challenge_gender"(platform: "/mobile") {}
        "/asset_management/terms_and_conditions"(platform: "/mobile") {}

        // Opt-out
        "/asset_management/opt_out"(platform: "/mobile") {}
        "/asset_management/result_stop_investing"(platform: "/mobile") {}

        // Detail
        "/asset_management/investment_detail"(platform: "/mobile") {}
        "/asset_management/movements_detail"(platform: "/mobile") {}

        // Congrats
        "/asset_management/result_investing"(platform: "/mobile") {}

        // Faqs
        "/asset_management/faqs"(platform: "/mobile") {}

        "/asset_management/faq"(platform: "/mobile") {}

        "/asset_management/url_external"(platform: "/mobile") {
            label = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "onboarding"
        }

        "/asset_management/url_external"(platform: "/mobile") {
            label = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "faqs"
        }

        "/asset_management/url_external"(platform: "/mobile") {
            label = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "movements_detail"
        }

        // Splitter
        "/asset_management/splitter"(platform: "/mobile") {}
        "/asset_management/profile"(platform: "/mobile") {}
        "/asset_management/stop_investing"(platform: "/mobile") {}
        "/asset_management/swipe"(platform: "/mobile") {
            label = "first"
        }
        "/asset_management/swipe"(platform: "/mobile") {
            label = "second"
        }
        "/asset_management/swipe"(platform: "/mobile") {
            label = "third"
        }

        // Error
        "/asset_management/error"(platform: "/mobile") {
            label = "service_error_generic"
        }
        "/asset_management/error"(platform: "/mobile") {
            label = "service_error"
        }
        "/asset_management/error"(platform: "/mobile") {
            label = "service_error_connection"
        }
        "/asset_management/error"(platform: "/mobile") {
            label = "date_validation_underage"
        }
        "/asset_management/error"(platform: "/mobile") {
            label = "date_validation_invalid"
        }

        // Identity handler
        "/asset_management/identity_handler"(platform: "/mobile") {
            remedy_id = "49cdb9b5-9585-42f3-a680-9d44548c8888"
        }
        "/asset_management/identity_handler"(platform: "/mobile") {
            remedy_id = "49cdb9b5-9585-42f3-a680-9d44548c9822"
            status = "mismatch"
        }
        "/asset_management/identity_handler"(platform: "/mobile") {
            remedy_id = "49cdb9b5-9585-42f3-a680-9d44548c9822"
            status = "number_of_attempts_exceeded"
        }
    }
}