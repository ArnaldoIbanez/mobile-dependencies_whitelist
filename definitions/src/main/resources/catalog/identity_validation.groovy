import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Identity Validation

    "/identity-validation"(platform: "/", isAbstract: true) {}

    "/identity-validation/init_validation"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
    }

    "/identity-validation/phone_challenge"(platform: "/", type: TrackType.Event) {
    }

    "/identity-validation/documentation_challenge"(platform: "/", type: TrackType.Event) {
        result(type: PropertyType.String, required: true, description: "The result of validation")
    }

    "/identity-validation/recommendation_challenge"(platform: "/", type: TrackType.Event) {
        result(type: PropertyType.String, required: true, description: "The result of validation")
    }

    "/identity-validation/facebook_challenge"(platform: "/", type: TrackType.Event) {}

    "/identity-validation/gmail_challenge"(platform: "/", type: TrackType.Event) {}

    "/identity-validation/yahoo_challenge"(platform: "/", type: TrackType.Event) {}

    "/identity-validation/gplus_challenge"(platform: "/", type: TrackType.Event) {}

    "/identity-validation/finish_validation"(platform: "/", type: TrackType.Event) {
        result(type: PropertyType.String, required: true, description: "The result of validation")
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
    }

}