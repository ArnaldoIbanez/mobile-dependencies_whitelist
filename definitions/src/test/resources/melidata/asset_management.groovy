package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("Asset management") {

        // Onboarding
        "/asset_management/onboarding"(platform: "/mobile") {}
        "/asset_management/start_investing"(platform: "/mobile") {}
        "/asset_management/know_more"(platform: "/mobile") {}

        // First time
        "/asset_management/first_time"(platform: "/mobile") {}

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
        "/asset_management/challenge_terms_and_conditions"(platform: "/mobile") {}
        "/asset_management/challenge_birthdate"(platform: "/mobile") {}
        "/asset_management/challenge_company_relationship"(platform: "/mobile") {}
        "/asset_management/challenge_identification"(platform: "/mobile") {}
        "/asset_management/challenge_identifier_type"(platform: "/mobile") {}
        "/asset_management/challenge_identity"(platform: "/mobile") {}
        "/asset_management/challenge_identity_mismatch"(platform: "/mobile") {}
        "/asset_management/challenge_nationality"(platform: "/mobile") {}
        "/asset_management/challenge_selfie"(platform: "/mobile") {}
        "/asset_management/challenge_selfie_bad_quality"(platform: "/mobile") {}
        "/asset_management/challenge_terms_and_conditions_company"(platform: "/mobile") {}
        "/asset_management/challenge_address"(platform: "/mobile") {}
        "/asset_management/challenge_phone"(platform: "/mobile") {}
        "/asset_management/challenge_single_pep_fatca_so"(platform: "/mobile") {}

        // Terms and conditions View
        "/asset_management/terms_and_conditions"(platform: "/mobile") {}

        // Opt-out
        "/asset_management/opt_out"(platform: "/mobile") {}
        "/asset_management/result_stop_investing"(platform: "/mobile") {}
        "/asset_management/result_stop_investing"(platform: "/web") {}

        // Detail
        "/asset_management/investment_detail"(platform: "/mobile") {}
        "/asset_management/investment_detail"(platform: "/web") {}

        "/asset_management/landing"(platform: "/web") {}
        "/asset_management/invest"(platform: "/web") {}

        // Operations
        "/asset_management/movements_detail"(platform: "/mobile") {} // old name
        "/asset_management/operations"(platform: "/mobile") {} // new name
        "/asset_management/operations/detail"(platform: "/mobile") {} // specific operation

        // Congrats
        "/asset_management/result_investing"(platform: "/mobile") {}

        // Faqs
        "/asset_management/faqs"(platform: "/mobile") {}
        "/asset_management/faqs"(platform: "/web") {}
        "/asset_management/faq"(platform: "/mobile") {}

        "/asset_management/url_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/onboarding"
        }

        "/asset_management/url_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/faqs"
        }

        "/asset_management/url_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/operations"
        }

        "/asset_management/clarification"(platform: "/mobile") {
            label = "/asset_management/movements_detail"
        }

        "/asset_management/add_funds"(platform: "/mobile") {}

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