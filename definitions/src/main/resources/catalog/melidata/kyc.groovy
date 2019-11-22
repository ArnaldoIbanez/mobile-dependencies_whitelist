import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/kyc"(platform: "/", isAbstract: true) {}
    "/kyc/challenge"(platform: "/", isAbstract: true) {}

    // Challenges
    "/kyc/challenge_pep"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_fatca"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_regulated_entity"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_manual_input_dob"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_manual_input_document"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_mismatch"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_cx_pending"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_number_of_attempts_exceeded"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identity_validation"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identification_bad_quality"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_country_of_birth"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_document_type"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_gender"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_terms_and_conditions"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_terms_and_conditions_company"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_selfie"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_selfie_bad_quality"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_company_relationship"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identification"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_nationality"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identifier_type"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identity"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identity_mismatch"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_birthdate"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_address"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_phone"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_single_pep_fatca_so"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_kyc_name_mismatch"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_company_confirmation"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_company_relationship"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_marital_status"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_occupation"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_cellphone"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_name_mismatch"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_address_confirmation"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_activity"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_proof_of_address"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_death"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_under_age"(platform: "/", type: TrackType.View) {}
    "/kyc/identity_handler"(platform: "/", type: TrackType.View) {}

    "/kyc/identity_handler"(platform: "/", type: TrackType.Event) {
        identifier (required: true, type: PropertyType.String)
        status (required: false, type: PropertyType.String)
    }

    // WebView events
    "/kyc/url_external"(platform: "/", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external webview URL")
    }

    // Browser events
    "/kyc/browser_external"(platform: "/", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external browser URL")
    }

    // Errors
    "/kyc/error"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
        verbose (required: false, type: PropertyType.String, description: "The error description for the error occurred")
    }
    "/kyc/profile"(platform: "/", type: TrackType.Event) {}

    // challenge life cycle
    "/kyc/challenge/start"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

    "/kyc/challenge/send"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

    "/kyc/challenge/success"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

    "/kyc/challenge/fail"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

    "/kyc/challenge/retry"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }
}
