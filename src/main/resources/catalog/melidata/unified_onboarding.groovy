package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    
    initiative="1218"
    
    "/unified_onboarding" (platform: "/mobile", isAbstract: true) {
        session_id(required: true, type: PropertyType.String, description: "Session identifier")
        session_id_from(required: true, type: PropertyType.String, description: "Origin Session identifier")
        challenge_id(required: true, type: PropertyType.String, description: "Functional Challenge identifier")
        challenge_type(required: true, type: PropertyType.String, description: "Technical Challenge identifier")
        from(required: true, type: PropertyType.String, description: "Initiative")
    }

    "/unified_onboarding/challenge" (platform: "/mobile", type: TrackType.View) {
        progress(required: false, type: PropertyType.String, description: "Wizard Step Number")
    }

    "/unified_onboarding/challenge/open" (platform: "/mobile", type: TrackType.Event) {
    }

    "/unified_onboarding/challenge/back" (platform: "/mobile", type: TrackType.Event) {
    }

    "/unified_onboarding/challenge/confirm" (platform: "/mobile", type: TrackType.Event) {
        is_last_challenge(required: true, type: PropertyType.Boolean, description: "Flag indicating whether challenge is last challenge in wizard")
    }
    
    "/unified_onboarding/challenge/validation" (platform: "/mobile", type: TrackType.Event) {
        validations(required: true, type: PropertyType.String, description: "Challenge's validations")
    }

    "/unified_onboarding/challenge/validation/to_action" (platform: "/mobile", type: TrackType.Event) {
    }
    
    "/unified_onboarding/challenge/component" (platform: "/mobile", isAbstract: true) {
        value(required: true, type: PropertyType.String, description: "Component's value")
        component_id(required: true, type: PropertyType.String, description: "Component's id")
        component_type(required: true, type: PropertyType.String, description: "Component's type")
    }

    "/unified_onboarding/challenge/component/validation" (platform: "/mobile", type: TrackType.Event) {
        validations(required: true, type: PropertyType.String, description: "Component's validations")
    }
    
    "/unified_onboarding/challenge/component/focus" (platform: "/mobile", type: TrackType.Event) {
    }

    "/unified_onboarding/challenge/component/unfocus" (platform: "/mobile", type: TrackType.Event) {
    }

    "/unified_onboarding/challenge/component/tap" (platform: "/mobile", type: TrackType.Event) {
    }
}
