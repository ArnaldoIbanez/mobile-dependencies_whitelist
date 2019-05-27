import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * User Onboarding Screen Tracks
     */

    "/user_onboarding"(platform: "/", isAbstract: true) {}

    "/user_onboarding/terms_and_conditions"(platform: "/", type: TrackType.View) {
        flow(required: true, description: "The flow type of onboarding")
    }

    "/user_onboarding/webview"(platform: "/", type: TrackType.View) {
        flow(required: false, description: "The flow type of onboarding")
    }

    "/user_onboarding/iv_walkthrough"(platform: "/", type: TrackType.View) {
        flow(required: true, description: "The flow type of onboarding")
    }

    "/congrats"(platform: "/", type: TrackType.View) {
        flow(required: true, description: "The flow type of onboarding")
        result_status(required: false, type: PropertyType.String, description: "Operation result status")
        status_detail(required: false, type: PropertyType.String, description: "Operation result status detail")
    }

    /**
     * User Onboarding Events Tracks
     */

    "/user_onboarding/terms_and_conditions"(platform: "/", type: TrackType.Event) {
        terms_and_conditions_row(required: false, description: "When the row is shown")
        terms_and_conditions_checkbox(required: false, description: "When the checkbox is clicked")
    }
}