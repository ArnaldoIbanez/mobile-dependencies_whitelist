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
        "/asset_management/pre_boarding"(platform: "/", type: TrackType.View) {}

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
         "/asset_management/congrats_success"(platform: "/", type: TrackType.View) {}
         "/asset_management/congrats_success"(platform: "/", type: TrackType.View) {
            congratsName = 'idCongrats'
        }
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

        // Detail
        "/asset_management/investment_detail"(platform: "/mobile") {}
        "/asset_management/investment_detail"(platform: "/web") {}

        // Earnings report
        "/asset_management/investment_reports"(platform: "/web") {}
        "/asset_management/investment_reports"(platform: "/mobile") {}

        "/asset_management/landing"(platform: "/web") {}
        "/asset_management/invest"(platform: "/web") {}
        "/asset_management/investment_report"(platform: "/") {
            year = "2018"
            quarter = "1"
        }
        "/asset_management/investment_report"(platform: "/") {
            year = "2018"
            quarter = "2"
        }
        "/asset_management/investment_report"(platform: "/") {
            year = "2018"
            quarter = "3"
        }
        "/asset_management/investment_report"(platform: "/") {
            year = "2018"
            quarter = "4"
        }
        "/asset_management/investment_report"(platform: "/") {}

        // Operations
        "/asset_management/operations"(platform: "/mobile") {} // new name
        "/asset_management/operations/detail"(platform: "/mobile") {} // specific operation

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

        //Investment Settings
        "/asset_management/investment_settings"(platform: "/", type: TrackType.View) {}
        "/asset_management/investment_settings/switch_false"(platform: "/", type: TrackType.Event) {}
        "/asset_management/investment_settings/switch_true"(platform: "/", type: TrackType.Event) {}
        "/asset_management/investment_settings/continue_investing"(platform: "/", type: TrackType.Event) {}
        "/asset_management/investment_settings/show_opt_out"(platform: "/", type: TrackType.Event) {}
        
        //Keypad
        "/asset_management/investment_keypad"(platform: "/", type: TrackType.View) {}
        "/asset_management/investment_keypad/click_button_money_to_invest"(platform: "/", type: TrackType.Event) {
            invested=30
        }
        
        //Invest Section
        "/asset_management/invest_section/empty_no_money"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/empty_no_returns"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/money_to_invest"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/all_invested"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/automatic_invest_ready"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/auto_enabled"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/not_enough_money_nor_returns"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/enough_money_or_returns"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/max_udis_reached"(platform: "/", type: TrackType.View) {}
        "/asset_management/invest_section/max_udis_not_reached"(platform: "/", type: TrackType.View) {}

        "/asset_management/invest_section/show_estimated_yield"(platform: "/", type: TrackType.Event) {}
        "/asset_management/invest_section/click_button_empty_no_money"(platform: "/", type: TrackType.Event) {}
        "/asset_management/invest_section/click_button_money_to_invest"(platform: "/", type: TrackType.Event) {}
        "/asset_management/invest_section/click_button_edit_amount"(platform: "/", type: TrackType.Event) {}
        "/asset_management/invest_section/click_button_automatic_invest_ready"(platform: "/", type: TrackType.Event) {}

        //Update App
        "/asset_management/update_app"(platform: "mobile", type: TrackType.View) {}
    
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
        "/asset_management/investment_report"(platform: "/", business: "mercadolibre") {
            year = "2018"
            quarter = "1"
        }
        "/asset_management/investment_report"(platform: "/", business: "mercadolibre") {
            year = "2018"
            quarter = "2"
        }
        "/asset_management/investment_report"(platform: "/", business: "mercadolibre") {
            year = "2018"
            quarter = "3"
        }
        "/asset_management/investment_report"(platform: "/", business: "mercadolibre") {
            year = "2018"
            quarter = "4"
        }
        "/asset_management/investment_report"(platform: "/", business: "mercadolibre") {}

        // Operations
        "/asset_management/operations"(platform: "/mobile", business: "mercadolibre") {} // new name
        "/asset_management/operations/detail"(platform: "/mobile", business: "mercadolibre") {} // specific operation

        // Congrats
        "/asset_management/congrats_success"(platform: "/", business: "mercadolibre") {}
        "/asset_management/congrats_success"(platform: "/", business: "mercadolibre") {
            congratsName = "idCongrats"
        }
        

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
        "/asset_management/accepted_tyc"(platform: "/", business: "mercadolibre") {}
        "/asset_management/activities"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/activities"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/bind_reports"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/bind_reports"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/congrats_error"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/congrats_error"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/kyc_blocker"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/kyc_blocker"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/legacy/error"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/legacy/error"(platform: "/web", business: "mercadolibre") {}
        "/asset_management/pre_boarding"(platform: "/", business: "mercadolibre") {}

        "/asset_management/tab_year"(platform: "/", business: "mercadolibre") {}
        "/asset_management/tab_month"(platform: "/", business: "mercadolibre") {}
        "/asset_management/next_year"(platform: "/", business: "mercadolibre") {}
        "/asset_management/next_month"(platform: "/", business: "mercadolibre") {}
        "/asset_management/previous_year"(platform: "/", business: "mercadolibre") {}
        "/asset_management/previous_month"(platform: "/", business: "mercadolibre") {}
        "/asset_management/show_clarifications"(platform: "/", business: "mercadolibre") {}

        //Investment Settings
        "/asset_management/investment_settings"(platform: "/", business: "mercadolibre") {}
        "/asset_management/investment_settings/switch_false"(platform: "/", business: "mercadolibre") {}
        "/asset_management/investment_settings/switch_true"(platform: "/", business: "mercadolibre") {}
        "/asset_management/investment_settings/continue_investing"(platform: "/", business: "mercadolibre") {}
        "/asset_management/investment_settings/show_opt_out"(platform: "/", business: "mercadolibre") {}
        
        //Keypad
        "/asset_management/investment_keypad"(platform: "/", business: "mercadolibre") {}
        "/asset_management/investment_keypad/click_button_money_to_invest"(platform: "/", business: "mercadolibre") {
            invested= 30
        }
        
        //Invest Section
        //"/asset_management/invest_section"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/empty_no_money"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/empty_no_returns"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/money_to_invest"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/all_invested"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/automatic_invest_ready"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/auto_enabled"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/not_enough_money_nor_returns"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/enough_money_or_returns"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/max_udis_reached"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/max_udis_not_reached"(platform: "/", business: "mercadolibre") {}

        "/asset_management/invest_section/show_estimated_yield"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/click_button_empty_no_money"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/click_button_money_to_invest"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/click_button_edit_amount"(platform: "/", business: "mercadolibre") {}
        "/asset_management/invest_section/click_button_automatic_invest_ready"(platform: "/", business: "mercadolibre") {}

        //UpdateApp
        "/asset_management/update_app"(platform: "/mobile", business: "mercadolibre") {}

        //Kyc Onboarding
        "/asset_management/kyc_onboarding"(platform: "/mobile", type: TrackType.View) {}
        "/asset_management/kyc_onboarding/send_to_kyc"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/kyc_onboarding/show_more"(platform: "/mobile", type: TrackType.Event) {}
        "/asset_management/kyc_onboarding"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/kyc_onboarding/send_to_kyc"(platform: "/mobile", business: "mercadolibre") {}
        "/asset_management/kyc_onboarding/show_more"(platform: "/mobile", business: "mercadolibre") {}

        //Redirect onbaording mobile
        "/asset_management/kyc_web_blocker"(platform: "/web", type: TrackType.View) {}
        "/asset_management/kyc_web_blocker/play_store"(platform: "/web", type: TrackType.Event) {}
        "/asset_management/kyc_web_blocker/app_store"(platform: "/web", type: TrackType.Event) {}
        "/asset_management/kyc_web_blocker"(platform: "/web",  business: "mercadolibre") {}
        "/asset_management/kyc_web_blocker/play_store"(platform: "/web",  business: "mercadolibre") {}
        "/asset_management/kyc_web_blocker/app_store"(platform: "/web",  business: "mercadolibre") {}


        //Loading gbm
        "/asset_management/loading_gbm"(platform: "/", type: TrackType.View) {}
        "/asset_management/loading_gbm"(platform: "/", business: "mercadolibre") {}

        //status blocker
        "/asset_management/status_blocker"(platform: "/mobile", type: TrackType.View, business: "mercadolibre") {}
        "/asset_management/status_blocker/go_to_home"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}
        "/asset_management/status_blocker/know_requirements"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}
        "/asset_management/status_blocker/contact_bind"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}
        
        "/asset_management/status_blocker"(platform: "/", type: TrackType.View) {}
        "/asset_management/status_blocker"(platform: "/", type: TrackType.View) {
            status_id = 'pending'
        }

        //blocker v2
        "/asset_management/blocker_v2/go_to_home"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}
        "/asset_management/blocker_v2/complete_data"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}
        "/asset_management/blocker_v2/how_to_complete_data"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}
        "/asset_management/blocker_v2/know_documentation"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}
        "/asset_management/blocker_v2/know_requirements"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}
        "/asset_management/blocker_v2/contact_bind"(platform: "/mobile", type: TrackType.Event, business: "mercadolibre") {}

        "/asset_management/blocker_v2"(platform: "/", type: TrackType.View) {
            blocker_type = 'kyc'
        }
        "/asset_management/blocker_v2"(platform: "/", type: TrackType.View) {
            blocker_type = 'pending'
        }
    }
}
