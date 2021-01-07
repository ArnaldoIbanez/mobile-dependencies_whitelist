package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1172"

    "/remedy"(platform: "/", isAbstract: true) {}

    // Challenges v2
    "/remedy/challenge"(platform: "/", type: TrackType.View) {
        id (required: true, type: PropertyType.String, description: "The challenge name")
        process_id (required: true, type: PropertyType.String, description: "The initiative")
        callback (required: false, type: PropertyType.String, description: "The callback deeplink that is executed when the flow ends")
        kyc_flow_id(required: false, type: PropertyType.String, description: "The kyc flow identifier")
    }

    "/remedy/challenge/start"(platform: "/", type: TrackType.Event) {}
    "/remedy/challenge/send"(platform: "/", type: TrackType.Event) {}
    "/remedy/challenge/success"(platform: "/", type: TrackType.Event) {}
    "/remedy/challenge/fail"(platform: "/", type: TrackType.Event) {}
    "/remedy/challenge/retry"(platform: "/", type: TrackType.Event) {}

    // Challenges
    "/remedy/challenge_pep"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_fatca"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_regulated_entity"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_manual_input_dob"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_manual_input_document"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_mismatch"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_cx_pending"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_number_of_attempts_exceeded"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_identity_validation"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_identification_bad_quality"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_country_of_birth"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_document_type"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_gender"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_terms_and_conditions"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_terms_and_conditions_company"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_selfie"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_selfie_bad_quality"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_company_relationship"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_identification"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_nationality"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_identifier_type"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_identity"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_identity_mismatch"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_birthdate"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_address"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_phone"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_single_pep_fatca_so"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_kyc_name_mismatch"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_company_confirmation"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_company_relationship"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_marital_status"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_occupation"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_cellphone"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_name_mismatch"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_address_confirmation"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_activity"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_proof_of_address"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_death"(platform: "/", type: TrackType.View) {}
    "/remedy/identity_handler"(platform: "/", type: TrackType.View) {}
    "/remedy/challenge_under_age"(platform: "/", type: TrackType.View) {}

    "/remedy/identity_handler"(platform: "/", type: TrackType.Event) {}

    // WebView events
    "/remedy/url_external"(platform: "/", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external webview URL")
    }

    // Browser events
    "/remedy/browser_external"(platform: "/", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external browser URL")
    }

    // Errors
    "/remedy/error"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
        verbose (required: false, type: PropertyType.String, description: "The error description for the error occurred")
    }

    "/remedy/profile"(platform: "/", type: TrackType.Event) {}
}
