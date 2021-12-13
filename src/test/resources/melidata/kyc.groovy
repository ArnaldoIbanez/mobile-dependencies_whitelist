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
        "/kyc/error/timeout"(platform: "/mobile") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
            verbose = "SE AGOTO EL TIEMPO DE ESPERA"
        }
        "/kyc/error/parsing"(platform: "/mobile") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
            verbose = "THE JSON APPEARS TO BE MALFORMED"
        }
        "/kyc/error"(platform: "/web/desktop") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
            error_id = "BGOR4MSZTA-210622"
        }
        "/kyc/error/service"(platform: "/web/desktop") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
            verbose = "User not active"
        }
        "/kyc/connection_error"(platform: "/web/desktop") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
        }

        "/kyc/odr_error"(platform: "/") {
            image = "rmdy_ic_error_dni_ml"
            verbose = "LA CONEXIÓN DE RED SE PERDIÓ"
        }

        "/kyc/odr_error"(platform: "/", business: "mercadolibre") {
            image = "rmdy_ic_error_dni_ml"
            verbose = "LA CONEXIÓN DE RED SE PERDIÓ"
        }

        "/kyc/challenge/start"(platform: "/mobile") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/send"(platform: "/mobile") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/success"(platform: "/mobile") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/fail"(platform: "/mobile") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/retry"(platform: "/mobile") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/start"(platform: "/mobile") {
            id = "user_identification"
            initiative = "registration-fintech"
            callback = "mercadopago://home"
            kyc_flow_id = "069d529b-3d4c-47df-b0b3-4c82a0bfe952"
            transaction_id = "aBi2WUK4ay56MgJWVJagYFAmXeRfWt99"
        }

        "/kyc/challenge/send"(platform: "/mobile") {
            id = "user_identification"
            initiative = "registration-fintech"
            callback = "mercadopago://home"
            kyc_flow_id = "069d529b-3d4c-47df-b0b3-4c82a0bfe952"
            transaction_id = "aBi2WUK4ay56MgJWVJagYFAmXeRfWt99"
        }

        "/kyc/challenge/success"(platform: "/mobile") {
            id = "user_identification"
            initiative = "registration-fintech"
            callback = "mercadopago://home"
            kyc_flow_id = "069d529b-3d4c-47df-b0b3-4c82a0bfe952"
            transaction_id = "aBi2WUK4ay56MgJWVJagYFAmXeRfWt99"
        }

        "/kyc/challenge/fail"(platform: "/mobile") {
            id = "user_identification"
            initiative = "registration-fintech"
            callback = "mercadopago://home"
            kyc_flow_id = "069d529b-3d4c-47df-b0b3-4c82a0bfe952"
            transaction_id = "aBi2WUK4ay56MgJWVJagYFAmXeRfWt99"
        }

        "/kyc/challenge/retry"(platform: "/mobile") {
            id = "user_identification"
            initiative = "registration-fintech"
            callback = "mercadopago://home"
            kyc_flow_id = "069d529b-3d4c-47df-b0b3-4c82a0bfe952"
            transaction_id = "aBi2WUK4ay56MgJWVJagYFAmXeRfWt99"
        }

        "/kyc/profile"(platform: "/mobile") {}

        "/kyc/challenge"(platform: "/mobile") {
            id = "user_identification"
            initiative = "credits"
            configuration_token = "a9477c99-ab2a-4653-a288-5726fafafa9f8"
            callback = "meli://home"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile") {
            id = "user_identification"
            initiative = "credits"
            configuration_token = "a9477c99-ab2a-4653-a288-5726fafafa9f8"
            callback = "meli://home"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile") {
            id = "user_identification"
            initiative = "credits"
            callback = "meli://home"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile") {
            id = "user_identification"
            initiative = "credits"
            configuration_token = "a9477c99-ab2a-4653-a288-5726fafafa9f8"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile") {
            id = "user_identification"
            initiative = "credits"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile") {
            id = "user_identification"
            initiative = "registration-fintech"
            callback = "mercadopago://home"
            kyc_flow_id = "069d529b-3d4c-47df-b0b3-4c82a0bfe952"
            transaction_id = "aBi2WUK4ay56MgJWVJagYFAmXeRfWt99"
        }

        "/kyc/challenge"(platform: "/mobile", business: "mercadolibre") {
            id = "user_identification"
            initiative = "registration-fintech"
            callback = "mercadopago://home"
            kyc_flow_id = "069d529b-3d4c-47df-b0b3-4c82a0bfe952"
            transaction_id = "aBi2WUK4ay56MgJWVJagYFAmXeRfWt99"
        }

        "/kyc/challenge"(platform: "/mobile", business: "mercadolibre") {
            id = "user_identification"
            initiative = "credits"
            configuration_token = "a9477c99-ab2a-4653-a288-5726fafafa9f8"
            callback = "meli://home"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile", business: "mercadolibre") {
            id = "user_identification"
            initiative = "credits"
            configuration_token = "a9477c99-ab2a-4653-a288-5726fafafa9f8"
            callback = "meli://home"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile", business: "mercadolibre") {
            id = "user_identification"
            initiative = "credits"
            callback = "meli://home"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile", business: "mercadolibre") {
            id = "user_identification"
            initiative = "credits"
            configuration_token = "a9477c99-ab2a-4653-a288-5726fafafa9f8"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge"(platform: "/mobile", business: "mercadolibre") {
            id = "user_identification"
            initiative = "credits"
            kyc_flow_id = "SessionID560232788"
        }

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
        "/kyc/error/timeout"(platform: "/mobile", business: "mercadolibre") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
            verbose = "SE AGOTO EL TIEMPO DE ESPERA"
        }
        "/kyc/error/parsing"(platform: "/mobile", business: "mercadolibre") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
            verbose = "THE JSON APPEARS TO BE MALFORMED"
        }
        "/kyc/error"(platform: "/web/desktop", business: "mercadolibre") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
            error_id = "BGOR4MSZTA-210622"
        }
        "/kyc/error/service"(platform: "/web/desktop", business: "mercadolibre") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
            verbose = "User not active"
        }
        "/kyc/connection_error"(platform: "/web/desktop", business: "mercadolibre") {
            kyc_flow_id = "b930c36b-c789-40f6-a3e1-ec10e5c0afdb"
        }

        "/kyc/challenge/validation_fail"(platform: "/mobile", business: "mercadolibre") {
            id = "user_birthdate"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
            input = "birthdate"
            value = "20/__/____"
            reason = "Por favor ingrese una fecha válida"
        }

        "/kyc/challenge/tap"(platform: "/mobile", business: "mercadolibre") {
            id = "user_proof_of_income"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
            component = "linkable_label"
            link = "https://www.mercadolibre.com/"
        }

        "/kyc/challenge/tap"(platform: "/mobile", business: "mercadopago") {
            id = "user_proof_of_income"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
            component = "linkable_label"
            link = "https://www.mercadopago.com/"
        }

        "/kyc/challenge/validation_fail"(platform: "/mobile", business: "mercadopago") {
            id = "user_birthdate"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
            input = "birthdate"
            value = "20/__/____"
            reason = "Por favor ingrese una fecha válida"
        }

        "/kyc/challenge/start"(platform: "/mobile", business: "mercadolibre") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/send"(platform: "/mobile", business: "mercadolibre") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/success"(platform: "/mobile", business: "mercadolibre") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/fail"(platform: "/mobile", business: "mercadolibre") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/challenge/retry"(platform: "/mobile", business: "mercadolibre") {
            id = "pep"
            initiative = "cvu"
            kyc_flow_id = "SessionID560232788"
        }

        "/kyc/profile"(platform: "/mobile", business: "mercadolibre") {}

        // KYC File Upload
        "/kyc/upload_file/open_files"(platform: "/", business: "mercadolibre") {}

        "/kyc/upload_file/upload_start"(platform: "/", business: "mercadolibre") {
            amount = "5"
        }

        "/kyc/upload_file/upload_success"(platform: "/", business: "mercadolibre") {}

        "/kyc/upload_file/upload_fail"(platform: "/", business: "mercadolibre") {}

        "/kyc/upload_file/open_files"(platform: "/", business: "mercadopago") {}

        "/kyc/upload_file/upload_start"(platform: "/", business: "mercadopago") {
            amount = "2"
        }

        "/kyc/upload_file/upload_success"(platform: "/", business: "mercadopago") {}

        "/kyc/upload_file/upload_fail"(platform: "/", business: "mercadopago") {}

        // KYC Landing Congrats

        "/kyc/landing"(platform: "/", business: "mercadopago") { 
            initiative = "initiative"
            kyc_flow_id = "flowid"
        }

        "/kyc/congrats"(platform: "/", business: "mercadopago") { 
            initiative = "initiative"
            kyc_flow_id = "flowid"
        }

        "/kyc/landing"(platform: "/", business: "mercadolibre") { 
            initiative = "initiative"
            kyc_flow_id = "flowid"
        }

        "/kyc/congrats"(platform: "/", business: "mercadolibre") { 
            initiative = "initiative"
            kyc_flow_id = "flowid"
        }
    }
}
