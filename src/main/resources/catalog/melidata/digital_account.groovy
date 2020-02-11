package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * Onboarding Screen Tracks
     */

    "/anses"(platform: "/", isAbstract: true) {}

    "/anses/onboarding"(platform: "/", isAbstract: true) {}

    "/anses/onboarding/terms_and_conditions"(platform: "/", type: TrackType.View) {}

    "/anses/onboarding/webview"(platform: "/", type: TrackType.View) {}

    "/anses/onboarding/iv_walkthrough"(platform: "/", type: TrackType.View) {}

    "/anses/onboarding/congrats"(platform: "/", type: TrackType.View) {
        result_status(required: true, description: "Operation result status")
        status_detail(required: false, description: "Operation result status detail")
    }

    /**
     * Onboarding Events Tracks
     */

    "/anses/onboarding/terms_and_conditions"(platform: "/", type: TrackType.Event) {
        terms_and_conditions_row(required: false, description: "When the row is shown")
        terms_and_conditions_checkbox(required: false, description: "When the checkbox is clicked")
    }
    
}