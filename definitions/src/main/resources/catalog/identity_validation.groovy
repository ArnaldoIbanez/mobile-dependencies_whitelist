import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Identity Validation

    "/identity-validation"(platform: "/", isAbstract: true) {}

    "/identity-validation/validation_landing"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
    }

    "/identity-validation/start_validation"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
    }

    "/identity-validation/finish_challenge"(platform: "/", type: TrackType.Event) {
        type(type: PropertyType.String, required: true, description: "Challenge type. Ej. documentation, phone, recommendation")
        success(type: PropertyType.Boolean, required: true, description: "The success of completed challenge")
    }

    "/identity-validation/finish_validation"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
        result(type: PropertyType.String, required: true, description: "The result of validation. Ej. valid, invalid")
    }

    "/identity-validation/upload_compress"(platform: "/", type: TrackType.Event) {
        upload_time(type: PropertyType.Numeric, required: true, description: "The time in second to upload image")
        compression_time(type: PropertyType.Numeric, required: true, description: "The time in second to compress a image.")
    }

    "/identity-validation/upload_compress"(platform: "/", type: TrackType.Event) {
        upload_time(type: PropertyType.Numeric, required: true, description: "The time in second to upload image")
        compression_time(type: PropertyType.Numeric, required: true, description: "The time in second to compress a image.")
    }

    "/identity-validation/phone_code"(platform: "/", type: TrackType.View) {}
    "/identity-validation/phone"(platform: "/", type: TrackType.View) {}
    "/identity-validation/upload_doc"(platform: "/", type: TrackType.View) {}
    "/identity-validation/landing"(platform: "/", type: TrackType.View) {}
    "/identity-validation/congrats"(platform: "/", type: TrackType.View) {}
    "/identity-validation/landing_doc"(platform: "/", type: TrackType.View) {}
    "/identity-validation/doc_number"(platform: "/", type: TrackType.View) {}

}