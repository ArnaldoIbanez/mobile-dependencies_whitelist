package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("Remedy") {

        // Challenges
        "/remedy/challenge_pep"(platform: "/mobile") {}
        "/remedy/challenge_fatca"(platform: "/mobile") {}
        "/remedy/challenge_regulated_entity"(platform: "/mobile") {}
        "/remedy/challenge_manual_input_dob"(platform: "/mobile") {}
        "/remedy/challenge_manual_input_document"(platform: "/mobile") {}
        "/remedy/challenge_mismatch"(platform: "/mobile") {}
        "/remedy/challenge_cx_pending"(platform: "/mobile") {}
        "/remedy/challenge_number_of_attempts_exceeded"(platform: "/mobile") {}
        "/remedy/challenge_identity_validation"(platform: "/mobile") {}
        "/remedy/challenge_identification_bad_quality"(platform: "/mobile") {}
        "/remedy/challenge_country_of_birth"(platform: "/mobile") {}
        "/remedy/challenge_review_and_confirm"(platform: "/mobile") {}
        "/remedy/challenge_document_type"(platform: "/mobile") {}
        "/remedy/challenge_gender"(platform: "/mobile") {}
        "/remedy/challenge_terms_and_conditions"(platform: "/mobile") {}
        "/remedy/challenge_birthdate"(platform: "/mobile") {}
        "/remedy/challenge_company_relationship"(platform: "/mobile") {}
        "/remedy/challenge_identification"(platform: "/mobile") {}
        "/remedy/challenge_identifier_type"(platform: "/mobile") {}
        "/remedy/challenge_identity"(platform: "/mobile") {}
        "/remedy/challenge_identity_mismatch"(platform: "/mobile") {}
        "/remedy/challenge_nationality"(platform: "/mobile") {}
        "/remedy/challenge_selfie"(platform: "/mobile") {}
        "/remedy/challenge_selfie_bad_quality"(platform: "/mobile") {}
        "/remedy/challenge_terms_and_conditions_company"(platform: "/mobile") {}
        "/remedy/challenge_address"(platform: "/mobile") {}
        "/remedy/challenge_phone"(platform: "/mobile") {}
        "/remedy/challenge_single_pep_fatca_so"(platform: "/mobile") {}

        "/remedy/url_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/remedy/challenge_pep"
        }

        "/remedy/url_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/remedy/challenge_review_and_confirm"
        }

        "/remedy/browser_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/remedy/challenge_pep"
        }

        "/remedy/browser_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/remedy/challenge_review_and_confirm"
        }

        // Error
        "/remedy/error"(platform: "/mobile") {
            label = "service_error_generic"
        }
        "/remedy/error"(platform: "/mobile") {
            label = "service_error"
        }
        "/remedy/error"(platform: "/mobile") {
            label = "service_error_connection"
        }
        "/remedy/error"(platform: "/mobile") {
            label = "date_validation_underage"
        }
        "/remedy/error"(platform: "/mobile") {
            label = "date_validation_invalid"
        }

        "/remedy/profile"(platform: "/mobile") {}
    }
}