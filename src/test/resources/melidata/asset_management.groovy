package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("Asset management") {

        // Onboarding
        "/asset_management/onboarding"(platform: "/mobile") {}
        "/asset_management/onboarding_bcra"(platform: "/mobile") {}
        "/asset_management/onboarding_bcra"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/start_investing"(platform: "/mobile") {}
        "/asset_management/know_more"(platform: "/mobile") {}
        "/asset_management/optin"(platform: "/mobile") {}
        "/asset_management/optin"(platform: "/mobile", business: "mercadolibre") {}

        // First time
        "/asset_management/first_time"(platform: "/mobile") {}

        // Blocking screen
        "/asset_management/blocker"(platform: "/mobile") {}
        "/asset_management/legal_entity_selector"(platform: "/mobile") {}
        "/asset_management/legal_entity_continue"(platform: "/mobile") {}
        "/asset_management/legal_entity_block"(platform: "/mobile") {}

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

        // Congrats View
        "/asset_management/congrats_success"(platform: "/mobile", type: TrackType.View) {}
        "/asset_management/congrats_success"(platform: "/web", type: TrackType.View) {}
        "/asset_management/congrats_error"(platform: "/mobile", type: TrackType.View) {}
        "/asset_management/congrats_error"(platform: "/web", type: TrackType.View) {}

        // Terms & Conditions Views
        "/asset_management/terms_and_conditions"(platform: "/mobile") {}
        "/asset_management/terms_and_conditions"(platform: "/web") {}
        "/asset_management/accept_tyc"(platform: "/mobile", type: TrackType.View) {}
        "/asset_management/accept_tyc"(platform: "/web", type: TrackType.View) {}
        "/asset_management/accepted_tyc"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/accepted_tyc"(platform: "/web", type: TrackType.Event) {}

        // Bind Reports View
        "/asset_management/bind_reports"(platform: "/mobile", type: TrackType.View) {}
        "/asset_management/bind_reports"(platform: "/web", type: TrackType.View) {}

        // Activities View
        "/asset_management/activities"(platform: "/mobile", type: TrackType.View) {}
        "/asset_management/activities"(platform: "/web", type: TrackType.View) {}

        // Generic Error View
        "/asset_management/legacy/error"(platform: "/mobile") {}
        "/asset_management/legacy/error"(platform: "/web") {}

        // KYC Blocker View
        "/asset_management/kyc_blocker"(platform: "/mobile") {}
        "/asset_management/kyc_blocker"(platform: "/web") {}

        // Not eligible View
        "/asset_management/not_eligible"(platform: "/mobile") {}
        "/asset_management/not_eligible"(platform: "/web") {}

        // Opt-out
        "/asset_management/opt_out"(platform: "/mobile") {}
        "/asset_management/opt_out"(platform: "/web") {}
        "/asset_management/result_stop_investing"(platform: "/mobile") {}
        "/asset_management/result_stop_investing"(platform: "/web") {}

        // Detail
        "/asset_management/investment_detail"(platform: "/mobile") {}
        "/asset_management/investment_detail"(platform: "/web") {}

        // Earnings report
        "/asset_management/investment_reports"(platform: "/web") {}
        "/asset_management/investment_reports"(platform: "/mobile") {}

        "/asset_management/landing"(platform: "/web") {}
        "/asset_management/invest"(platform: "/web") {}
        "/asset_management/investment_report"(platform: "/web") {
            year = "2018"
            quarter = "1"
        }
        "/asset_management/investment_report"(platform: "/web") {
            year = "2018"
            quarter = "2"
        }
        "/asset_management/investment_report"(platform: "/web") {
            year = "2018"
            quarter = "3"
        }
        "/asset_management/investment_report"(platform: "/web") {
            year = "2018"
            quarter = "4"
        }
        "/asset_management/investment_report"(platform: "/web") {
            year = "2018"
        }

        // Operations
        "/asset_management/operations"(platform: "/mobile") {} // new name
        "/asset_management/operations/detail"(platform: "/mobile") {} // specific operation

        // Congrats
        "/asset_management/result_investing"(platform: "/mobile") {}
        "/asset_management/result_unavailable"(platform: "/mobile") {}
        "/asset_management/result_investing_company/approved"(platform: "/mobile") {}
        "/asset_management/result_investing_company/pending"(platform: "/mobile") {}
        "/asset_management/result_investing_company/rejected"(platform: "/mobile") {}

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
        "/asset_management/network_error"(platform: "/mobile") {}
        "/asset_management/error"(platform: "/mobile") {
            label = "service_error_generic"
            verbose = "SE AGOTO EL TIEMPO DE ESPERA"
        }
        "/asset_management/error"(platform: "/mobile") {
            label = "service_error"
            verbose = "LA CONEXIÓN DE RED SE PERDIÓ"
        }
        "/asset_management/error"(platform: "/mobile") {
            label = "service_error_connection"
            verbose = "THE JSON APPEARS TO BE MALFORMED"
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

        "/asset_management/browser_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/onboarding"
        }

        "/asset_management/browser_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/faqs"
        }

        "/asset_management/browser_external"(platform: "/mobile") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/operations"
        }

        "/asset_management/simulator_slide"(platform: "/mobile") {}

        //Chart events
        "/asset_management/tab_year"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/tab_year"(platform: "/web", type: TrackType.Event) {}
        "/asset_management/tab_month"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/tab_month"(platform: "/web", type: TrackType.Event) {}
        "/asset_management/previous_year"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/next_year"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/previous_month"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/next_month"(platform: "/mobile", type: TrackType.Event) {}
        
        //Clarifications events
        "/asset_management/show_clarifications"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/show_clarifications"(platform: "/web", type: TrackType.Event) {}

        // Meli tests

        // Onboarding
        "/asset_management/onboarding"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/start_investing"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/know_more"(platform: "/mobile", business: "mercadolibre") {}

        // First time
        "/asset_management/first_time"(platform: "/mobile", business: "mercadolibre") {}

        // Blocking screen
        "/asset_management/blocker"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/legal_entity_selector"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/legal_entity_continue"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/legal_entity_block"(platform: "/mobile", business: "mercadolibre") {}

        // Challenges
        "/asset_management/challenge_pep"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_fatca"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_regulated_entity"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_manual_input_dob"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_manual_input_document"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_cx_pending"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_number_of_attempts_exceeded"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_identity_validation"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_identification_bad_quality"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_country_of_birth"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_review_and_confirm"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_document_type"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_gender"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_terms_and_conditions"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_birthdate"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_company_relationship"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_identification"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_identifier_type"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_identity"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_identity_mismatch"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_nationality"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_selfie"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_selfie_bad_quality"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_terms_and_conditions_company"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_address"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_phone"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/challenge_single_pep_fatca_so"(platform: "/mobile", business: "mercadolibre") {}

        // Terms and conditions View
        "/asset_management/terms_and_conditions"(platform: "/mobile", business: "mercadolibre") {}

        // Not eligible view
        "/asset_management/not_eligible"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/not_eligible"(platform: "/web", business: "mercadolibre") {}

        // Opt-out
        "/asset_management/opt_out"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/result_stop_investing"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/result_stop_investing"(platform: "/web", business: "mercadolibre") {}

        // Detail
        "/asset_management/investment_detail"(platform: "/mobile", business: "mercadolibre") {
            empty_state_case = "available_money"
        }
        "/asset_management/investment_detail"(platform: "/web", business: "mercadolibre") {
            empty_state_case = "available_money"
        }

        "/asset_management/investment_detail"(platform: "/mobile", business: "mercadolibre") {
            has_simulator = "true"
        }

        // Earnings report
        "/asset_management/investment_reports"(platform: "/web", business: "mercadolibre") {}

        "/asset_management/landing"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/invest"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/investment_report"(platform: "/web", business: "mercadolibre") {
            year = "2018"
            quarter = "1"
        }
        "/asset_management/investment_report"(platform: "/web", business: "mercadolibre") {
            year = "2018"
            quarter = "2"
        }
        "/asset_management/investment_report"(platform: "/web", business: "mercadolibre") {
            year = "2018"
            quarter = "3"
        }
        "/asset_management/investment_report"(platform: "/web", business: "mercadolibre") {
            year = "2018"
            quarter = "4"
        }
        "/asset_management/investment_report"(platform: "/web", business: "mercadolibre") {
            year = "2018"
        }

        // Operations
        "/asset_management/operations"(platform: "/mobile", business: "mercadolibre") {} // new name
        "/asset_management/operations/detail"(platform: "/mobile", business: "mercadolibre") {} // specific operation

        // Congrats
        "/asset_management/result_investing"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/result_unavailable"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/result_investing_company/approved"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/result_investing_company/pending"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/result_investing_company/rejected"(platform: "/mobile", business: "mercadolibre") {}

        // Faqs
        "/asset_management/faqs"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/faqs"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/faq"(platform: "/mobile", business: "mercadolibre") {}

        "/asset_management/url_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/onboarding"
        }

        "/asset_management/url_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/faqs"
        }

        "/asset_management/url_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/operations"
        }

        "/asset_management/clarification"(platform: "/mobile", business: "mercadolibre") {
            label = "/asset_management/movements_detail"
        }

        "/asset_management/add_funds"(platform: "/mobile", business: "mercadolibre") {}

        // Splitter
        "/asset_management/splitter"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/profile"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/stop_investing"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/swipe"(platform: "/mobile", business: "mercadolibre") {
            label = "first"
        }
        "/asset_management/swipe"(platform: "/mobile", business: "mercadolibre") {
            label = "second"
        }
        "/asset_management/swipe"(platform: "/mobile", business: "mercadolibre") {
            label = "third"
        }

        // Error
        "/asset_management/network_error"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error_generic"
        }
        "/asset_management/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error"
        }
        "/asset_management/error"(platform: "/mobile", business: "mercadolibre") {
            label = "service_error_connection"
        }
        "/asset_management/error"(platform: "/mobile", business: "mercadolibre") {
            label = "date_validation_underage"
        }
        "/asset_management/error"(platform: "/mobile", business: "mercadolibre") {
            label = "date_validation_invalid"
        }

        // Identity handler
        "/asset_management/identity_handler"(platform: "/mobile", business: "mercadolibre") {
            remedy_id = "49cdb9b5-9585-42f3-a680-9d44548c8888"
        }
        "/asset_management/identity_handler"(platform: "/mobile", business: "mercadolibre") {
            remedy_id = "49cdb9b5-9585-42f3-a680-9d44548c9822"
            status = "mismatch"
        }
        "/asset_management/identity_handler"(platform: "/mobile", business: "mercadolibre") {
            remedy_id = "49cdb9b5-9585-42f3-a680-9d44548c9822"
            status = "number_of_attempts_exceeded"
        }

        "/asset_management/browser_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/onboarding"
        }

        "/asset_management/browser_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/faqs"
        }

        "/asset_management/browser_external"(platform: "/mobile", business: "mercadolibre") {
            url = "https://www.mercadopago.com.ar/ayuda/Ayuda_con_tus_Inversiones_4048"
            context = "/asset_management/operations"
        }

        "/asset_management/simulator_slide"(platform: "/mobile", business: "mercadolibre") {}

        "/asset_management/accept_tyc"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/accepted_tyc"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/accepted_tyc"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/activities"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/activities"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/bind_reports"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/bind_reports"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/congrats_success"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/congrats_success"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/congrats_error"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/congrats_error"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/kyc_blocker"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/kyc_blocker"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/legacy/error"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/legacy/error"(platform: "/web", business: "mercadolibre") {}

        "/asset_management/tab_year"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/tab_year"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/tab_month"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/tab_month"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/next_year"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/next_year"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/next_month"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/next_month"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/previous_year"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/previous_year"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/previous_month"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/previous_month"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/show_clarifications"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/show_clarifications"(platform: "/mobile", business: "mercadolibre") {}
    }
}