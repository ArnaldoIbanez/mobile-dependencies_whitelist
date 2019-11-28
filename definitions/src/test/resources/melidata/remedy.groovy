package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

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
        "/remedy/challenge_kyc_name_mismatch"(platform: "/mobile") {}
        "/remedy/challenge_company_confirmation"(platform: "/mobile") {}
        "/remedy/challenge_company_relationship"(platform: "/mobile") {}
        "/remedy/challenge_marital_status"(platform: "/mobile") {}
        "/remedy/challenge_occupation"(platform: "/mobile") {}
        "/remedy/challenge_cellphone"(platform: "/mobile") {}
        "/remedy/challenge_name_mismatch"(platform: "/mobile") {}
        "/remedy/challenge_address_confirmation"(platform: "/mobile") {}
        "/remedy/challenge_activity"(platform: "/mobile") {}
        "/remedy/challenge_proof_of_address"(platform: "/mobile") {}
        "/remedy/challenge_death"(platform: "/mobile") {}
        "/remedy/challenge_under_age"(platform: "/mobile") {}
        "/remedy/identity_handler"(platform: "/mobile") {}
        "/remedy/identity_handler"(platform: "/mobile", business: "mercadolibre") {}

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
            verbose = "SE AGOTO EL TIEMPO DE ESPERA"
        }
        "/remedy/error"(platform: "/mobile") {
            label = "service_error"
            verbose = "THE JSON APPEARS TO BE MALFORMED"
        }
        "/remedy/error"(platform: "/mobile") {
            label = "service_error_connection"
            verbose = "LA CONEXIÓN DE RED SE PERDIÓ"
        }
        "/remedy/error"(platform: "/mobile") {
            label = "date_validation_underage"
        }
        "/remedy/error"(platform: "/mobile") {
            label = "date_validation_invalid"
        }

        "/remedy/challenge/start"(platform: "/mobile") {
            label = "pep"
        }

        "/remedy/challenge/send"(platform: "/mobile") {
            label = "pep"
        }

        "/remedy/challenge/success"(platform: "/mobile") {
            label = "pep"
        }

        "/remedy/challenge/fail"(platform: "/mobile") {
            label = "pep"
        }

        "/remedy/challenge/retry"(platform: "/mobile") {
            label = "pep"
        }

        "/remedy/profile"(platform: "/mobile") {}

        // Meli tests
        "/remedy/challenge_pep"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_fatca"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_regulated_entity"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_manual_input_dob"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_manual_input_document"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_cx_pending"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_number_of_attempts_exceeded"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_identity_validation"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_identification_bad_quality"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_country_of_birth"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_review_and_confirm"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_document_type"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_gender"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_terms_and_conditions"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_birthdate"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_company_relationship"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_identification"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_identifier_type"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_identity"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_identity_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_nationality"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_selfie"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_selfie_bad_quality"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_terms_and_conditions_company"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_address"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_phone"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_single_pep_fatca_so"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_kyc_name_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_company_confirmation"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_company_relationship"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_marital_status"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_occupation"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_cellphone"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_name_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_address_confirmation"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_activity"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_proof_of_address"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_death"(platform: "/mobile", business: "mercadolibre") {}
        "/remedy/challenge_under_age"(platform: "/mobile", business: "mercadolibre") {}

        "/remedy/url_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/remedy/challenge_pep"
        }

        "/remedy/url_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/remedy/challenge_review_and_confirm"
        }

        "/remedy/browser_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/remedy/challenge_pep"
        }

        "/remedy/browser_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/remedy/challenge_review_and_confirm"
        }

        // Error
        "/remedy/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error_generic"
            verbose = "SE AGOTO EL TIEMPO DE ESPERA"
        }
        "/remedy/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error"
            verbose = "THE JSON APPEARS TO BE MALFORMED"
        }
        "/remedy/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error_connection"
            verbose = "LA CONEXIÓN DE RED SE PERDIÓ"
        }
        "/remedy/error"(platform: "/mobile", business: "mercadolibre") {
            label = "date_validation_underage"
        }
        "/remedy/error"(platform: "/mobile", business: "mercadolibre") {
            label = "date_validation_invalid"
        }

        "/remedy/challenge/start"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/remedy/challenge/send"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/remedy/challenge/success"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/remedy/challenge/fail"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/remedy/challenge/retry"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/remedy/profile"(platform: "/mobile", business: "mercadolibre") {}
    }
}