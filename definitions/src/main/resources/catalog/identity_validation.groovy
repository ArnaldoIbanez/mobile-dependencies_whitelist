import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Identity Validation

    "/identity-validation"(platform: "/web", isAbstract: true) {}

    "/identity-validation/landing_phone"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
    }

    "/identity-validation/finish_phone"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
    }

    "/identity-validation/finish_validation"(platform: "/web", type: TrackType.View) {
        result(type: PropertyType.String, required: true, description: "The result of validation")
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
    }

}