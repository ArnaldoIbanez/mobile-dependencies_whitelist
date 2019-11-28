package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("kyc") {

        // Challenges
        "/kyc/challenge_pep"(platform: "/mobile") {}
        "/kyc/challenge_fatca"(platform: "/mobile") {}
        "/kyc/challenge_regulated_entity"(platform: "/mobile") {}
        "/kyc/challenge_manual_input_dob"(platform: "/mobile") {}
        "/kyc/challenge_manual_input_document"(platform: "/mobile") {}
        "/kyc/challenge_mismatch"(platform: "/mobile") {}
        "/kyc/challenge_cx_pending"(platform: "/mobile") {}
        "/kyc/challenge_number_of_attempts_exceeded"(platform: "/mobile") {}
        "/kyc/challenge_identity_validation"(platform: "/mobile") {}
        "/kyc/challenge_identification_bad_quality"(platform: "/mobile") {}
        "/kyc/challenge_country_of_birth"(platform: "/mobile") {}
        "/kyc/challenge_review_and_confirm"(platform: "/mobile") {}
        "/kyc/challenge_document_type"(platform: "/mobile") {}
        "/kyc/challenge_gender"(platform: "/mobile") {}
        "/kyc/challenge_terms_and_conditions"(platform: "/mobile") {}
        "/kyc/challenge_birthdate"(platform: "/mobile") {}
        "/kyc/challenge_company_relationship"(platform: "/mobile") {}
        "/kyc/challenge_identification"(platform: "/mobile") {}
        "/kyc/challenge_identifier_type"(platform: "/mobile") {}
        "/kyc/challenge_identity"(platform: "/mobile") {}
        "/kyc/challenge_identity_mismatch"(platform: "/mobile") {}
        "/kyc/challenge_nationality"(platform: "/mobile") {}
        "/kyc/challenge_selfie"(platform: "/mobile") {}
        "/kyc/challenge_selfie_bad_quality"(platform: "/mobile") {}
        "/kyc/challenge_terms_and_conditions_company"(platform: "/mobile") {}
        "/kyc/challenge_address"(platform: "/mobile") {}
        "/kyc/challenge_phone"(platform: "/mobile") {}
        "/kyc/challenge_single_pep_fatca_so"(platform: "/mobile") {}
        "/kyc/challenge_kyc_name_mismatch"(platform: "/mobile") {}
        "/kyc/challenge_company_confirmation"(platform: "/mobile") {}
        "/kyc/challenge_company_relationship"(platform: "/mobile") {}
        "/kyc/challenge_marital_status"(platform: "/mobile") {}
        "/kyc/challenge_occupation"(platform: "/mobile") {}
        "/kyc/challenge_cellphone"(platform: "/mobile") {}
        "/kyc/challenge_name_mismatch"(platform: "/mobile") {}
        "/kyc/challenge_address_confirmation"(platform: "/mobile") {}
        "/kyc/challenge_activity"(platform: "/mobile") {}
        "/kyc/challenge_proof_of_address"(platform: "/mobile") {}
        "/kyc/challenge_death"(platform: "/mobile") {}
        "/kyc/challenge_under_age"(platform: "/mobile") {}
        
        "/kyc/identity_handler"(platform: "/mobile") {}
        "/kyc/identity_handler"(platform: "/mobile", business: "mercadolibre") {}

        "/kyc/url_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/kyc/challenge_pep"
        }

        "/kyc/url_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/kyc/challenge_review_and_confirm"
        }

        "/kyc/browser_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/kyc/challenge_pep"
        }

        "/kyc/browser_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/kyc/challenge_review_and_confirm"
        }

        // Error
        "/kyc/error"(platform: "/mobile") {
            label = "service_error_generic"
            verbose = "SE AGOTO EL TIEMPO DE ESPERA"
        }
        "/kyc/error"(platform: "/mobile") {
            label = "service_error"
            verbose = "THE JSON APPEARS TO BE MALFORMED"
        }
        "/kyc/error"(platform: "/mobile") {
            label = "service_error_connection"
            verbose = "LA CONEXIÓN DE RED SE PERDIÓ"
        }
        "/kyc/error"(platform: "/mobile") {
            label = "date_validation_underage"
        }
        "/kyc/error"(platform: "/mobile") {
            label = "date_validation_invalid"
        }

        "/kyc/challenge/start"(platform: "/mobile") {
            label = "pep"
        }

        "/kyc/challenge/send"(platform: "/mobile") {
            label = "pep"
        }

        "/kyc/challenge/success"(platform: "/mobile") {
            label = "pep"
        }

        "/kyc/challenge/fail"(platform: "/mobile") {
            label = "pep"
        }

        "/kyc/challenge/retry"(platform: "/mobile") {
            label = "pep"
        }

        "/kyc/profile"(platform: "/mobile") {}

        // Meli tests
        "/kyc/challenge_pep"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_fatca"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_regulated_entity"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_manual_input_dob"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_manual_input_document"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_cx_pending"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_number_of_attempts_exceeded"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_identity_validation"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_identification_bad_quality"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_country_of_birth"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_review_and_confirm"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_document_type"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_gender"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_terms_and_conditions"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_birthdate"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_company_relationship"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_identification"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_identifier_type"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_identity"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_identity_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_nationality"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_selfie"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_selfie_bad_quality"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_terms_and_conditions_company"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_address"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_phone"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_single_pep_fatca_so"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_kyc_name_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_company_confirmation"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_company_relationship"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_marital_status"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_occupation"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_cellphone"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_name_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_address_confirmation"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_activity"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_proof_of_address"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_death"(platform: "/mobile", business: "mercadolibre") {}
        "/kyc/challenge_under_age"(platform: "/mobile", business: "mercadolibre") {}

        "/kyc/url_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/kyc/challenge_pep"
        }

        "/kyc/url_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/kyc/challenge_review_and_confirm"
        }

        "/kyc/browser_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/kyc/challenge_pep"
        }

        "/kyc/browser_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/kyc/challenge_review_and_confirm"
        }

        // Error
        "/kyc/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error_generic"
            verbose = "SE AGOTO EL TIEMPO DE ESPERA"
        }
        "/kyc/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error"
            verbose = "THE JSON APPEARS TO BE MALFORMED"
        }
        "/kyc/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error_connection"
            verbose = "LA CONEXIÓN DE RED SE PERDIÓ"
        }
        "/kyc/error"(platform: "/mobile", business: "mercadolibre") {
            label = "date_validation_underage"
        }
        "/kyc/error"(platform: "/mobile", business: "mercadolibre") {
            label = "date_validation_invalid"
        }

        "/kyc/challenge/start"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/kyc/challenge/send"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/kyc/challenge/success"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/kyc/challenge/fail"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/kyc/challenge/retry"(platform: "/mobile", business: "mercadolibre") {
            label = "pep"
        }

        "/kyc/profile"(platform: "/mobile", business: "mercadolibre") {}
    }
}