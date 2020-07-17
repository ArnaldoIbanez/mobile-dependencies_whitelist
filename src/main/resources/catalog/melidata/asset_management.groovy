package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = '1047'

    // Root
    "/asset_management"(platform: "/", isAbstract: true) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
        category (required: false, type: PropertyType.String, description: "The category of the current event") // for backwards compatibility with old tracks
    }

    // First time
    "/asset_management/first_time"(platform: "/mobile", type: TrackType.View) {}

    // Onboarding
    "/asset_management/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/onboarding_bcra"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/onboarding"(platform: "/web", type: TrackType.View) {}
    "/asset_management/start_investing"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/legal_entity_continue"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/legal_entity_block"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/know_more"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/optin"(platform: "/mobile", type: TrackType.Event) {}

    // Blocking screen
    "/asset_management/blocker"(platform: "/web", type: TrackType.View) {}
    "/asset_management/blocker"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/legal_entity_selector"(platform: "/mobile", type: TrackType.View) {}

    // Challenges
    "/asset_management/challenge_pep"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_fatca"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_regulated_entity"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_manual_input_dob"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_manual_input_document"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_mismatch"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_cx_pending"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_number_of_attempts_exceeded"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_identity_validation"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_identification_bad_quality"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_country_of_birth"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_review_and_confirm"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_document_type"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_gender"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_terms_and_conditions_company"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_selfie"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_selfie_bad_quality"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_company_relationship"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_identification"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_nationality"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_identifier_type"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_identity"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_identity_mismatch"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_birthdate"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_address"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_phone"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/challenge_single_pep_fatca_so"(platform: "/mobile", type: TrackType.View) {}

    // Terms and conditions view
    "/asset_management/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}

    // Not eligible view
    "/asset_management/not_eligible"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/not_eligible"(platform: "/web", type: TrackType.View) {}

    // Opt-out
    "/asset_management/opt_out"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/result_stop_investing"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/result_stop_investing"(platform: "/web", type: TrackType.View) {}

    // Detail
    "/asset_management/investment_detail"(platform: "/", type: TrackType.View) {
        empty_state_case (required: false, type: PropertyType.String, description: "The empty state case")
        has_simulator (required: false, type: PropertyType.String, description: "if the simulator view is present")
    }

    // Earnings report
    "/asset_management/investment_reports"(platform: "/web", type: TrackType.View) {}

    // Operations
    "/asset_management/movements_detail"(platform: "/mobile", type: TrackType.View) {} // old name
    "/asset_management/operations"(platform: "/mobile") {}
    "/asset_management/operations"(platform: "/web") {}
    "/asset_management/operations/detail"(platform: "/mobile") {}
    "/asset_management/operations/detail"(platform: "/web") {}

    // Congrats
    "/asset_management/result_investing"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/result_investing"(platform: "/web", type: TrackType.View) {}
    "/asset_management/result_investing_company"(platform: "/mobile", isAbstract: true) {}
    "/asset_management/result_unavailable"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/result_investing_company/approved"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/result_investing_company/pending"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/result_investing_company/rejected"(platform: "/mobile", type: TrackType.View) {}

    // Faqs
    "/asset_management/faqs"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/faqs"(platform: "/web", type: TrackType.View) {}
    "/asset_management/faq"(platform: "/mobile", type: TrackType.Event) {}

    // Landing Web
    "/asset_management/landing"(platform: "/web", type: TrackType.View) {}
    "/asset_management/landing"(platform: "/mobile", type: TrackType.View) {}

    // Pre-landing
    "/asset_management/invest"(platform: "/web", type: TrackType.View) {}

    // Investment report
    "/asset_management/investment_report"(platform: "/web", type: TrackType.Event) {
        year (required: true, type: PropertyType.String, description: "The year of earnings requested")
        quarter (required: false, type: PropertyType.String, values: ["1", "2", "3", "4"], description: "The requested quarter of the year, if chosen")
    }

    // Clarification show event
    "/asset_management/clarification"(platform: "/mobile", type: TrackType.Event) {}

    // Money-In Specific event
    "/asset_management/add_funds"(platform: "/mobile", type: TrackType.Event) {}

    // WebView events
    "/asset_management/url_external"(platform: "/mobile", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external webview URL")
    }

    // Browser events
    "/asset_management/browser_external"(platform: "/mobile", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external browser URL")
    }

    // Splitter
    "/asset_management/splitter"(platform: "/mobile", type: TrackType.View) {}

    // Errors
    "/asset_management/error"(platform: "/mobile", type: TrackType.Event) {
        verbose (required: false, type: PropertyType.String, description: "The error description for the error occurred")
    }
    "/asset_management/network_error"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/stop_investing"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/stop_investing"(platform: "/web", type: TrackType.Event) {}
    "/asset_management/profile"(platform: "/mobile", type: TrackType.Event) {}

    // Other events
    "/asset_management/swipe"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/identity_handler"(platform: "/mobile", type: TrackType.Event) {
        remedy_id (required: true, type: PropertyType.String, description: "The remedy that was resolved by IV")
        status (required: false, type: PropertyType.String, description: "On failure, this represents why the flow failed")
    }
    "/asset_management/simulator_slide"(platform: "/mobile", type: TrackType.Event) {}
}
