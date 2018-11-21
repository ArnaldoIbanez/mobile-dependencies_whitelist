import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    // Root
    "/asset_management"(platform: "/", isAbstract: true) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
        category (required: false, type: PropertyType.String, description: "The category of the current event") // for backwards compatibility with old tracks
    }

    // Onboarding
    "/asset_management/onboarding"(platform: "/mobile", type: TrackType.View) {}

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
    "/asset_management/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}

    // Opt-out
    "/asset_management/opt_out"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/result_stop_investing"(platform: "/mobile", type: TrackType.View) {}

    // Detail
    "/asset_management/investment_detail"(platform: "/mobile", type: TrackType.View) {}
    "/asset_management/movements_detail"(platform: "/mobile", type: TrackType.View) {}

    // Congrats
    "/asset_management/result_investing"(platform: "/mobile", type: TrackType.View) {}

    // Faqs
    "/asset_management/faqs"(platform: "/mobile", type: TrackType.View) {}

    // Splitter
    "/asset_management/splitter"(platform: "/mobile", type: TrackType.View) {}

    // Errors
    "/asset_management/error"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/stop_investing"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/profile"(platform: "/mobile", type: TrackType.Event) {}

    // Other events
    "/asset_management/swipe"(platform: "/mobile", type: TrackType.Event) {}
    "/asset_management/identity_handler"(platform: "/mobile", type: TrackType.Event) {
        remedyId (required: true, type: PropertyType.String, description: "The remedy that was resolved by IV")
        status (required: false, type: PropertyType.String, description: "On failure, this represents why the flow failed")
    }
}