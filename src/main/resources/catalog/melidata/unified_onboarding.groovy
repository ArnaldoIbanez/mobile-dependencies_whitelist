package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative="1218"
    
    "/unified_onboarding" (platform: "/", isAbstract: true) {
        session_id(required: true, type: PropertyType.String, description: "Session identifier")
        session_id_from(required: true, type: PropertyType.String, description: "Origin Session identifier")
        challenge_id(required: true, type: PropertyType.String, description: "Functional Challenge identifier")
        challenge_type(required: true, type: PropertyType.String, description: "Technical Challenge identifier")
        from(required: true, type: PropertyType.String, description: "Initiative")
    }

    "/unified_onboarding/challenge" (platform: "/", type: TrackType.View) {
        progress(required: false, type: , description: "Wizard Step Number")
    }

    "/unified_onboarding/challenge/open" (platform: "/", type: TrackType.Event) {
    }

    "/unified_onboarding/challenge/back" (platform: "/", type: TrackType.Event) {
    }

    "/unified_onboarding/challenge/confirm" (platform: "/", type: TrackType.Event) {
        is_last_challenge(required: true, type: PropertyType.Boolean, description: "Flag indicating whether challenge is last challenge in wizard")
    }
}
