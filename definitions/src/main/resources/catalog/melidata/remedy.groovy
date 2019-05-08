import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/remedy"(platform: "/", isAbstract: true) {}

    // Challenges
    "/remedy/challenge_pep"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_fatca"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_regulated_entity"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_manual_input_dob"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_manual_input_document"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_mismatch"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_cx_pending"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_number_of_attempts_exceeded"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_identity_validation"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_identification_bad_quality"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_country_of_birth"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_review_and_confirm"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_document_type"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_gender"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_terms_and_conditions_company"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_selfie"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_selfie_bad_quality"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_company_relationship"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_identification"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_nationality"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_identifier_type"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_identity"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_identity_mismatch"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_birthdate"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_address"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_phone"(platform: "/mobile", type: TrackType.View) {}
    "/remedy/challenge_single_pep_fatca_so"(platform: "/mobile", type: TrackType.View) {}

    // WebView events
    "/remedy/url_external"(platform: "/mobile", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external webview URL")
    }

    // Browser events
    "/remedy/browser_external"(platform: "/mobile", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external browser URL")
    }

    // Errors
    "/remedy/error"(platform: "/mobile", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }
    "/remedy/profile"(platform: "/mobile", type: TrackType.Event) {}
}