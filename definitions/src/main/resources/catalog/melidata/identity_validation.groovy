import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1100"

    //Identity Validation

    "/identity-validation"(platform: "/", isAbstract: true) {}

    "/identity-validation/landing"(platform: "/", isAbstract: true) {}

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

    "/identity-validation/final_reached"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: true, description: "The flow to call identity validation. Ej. ms_hard_validation")
        result(type: PropertyType.String, required: true, description: "The result of validation. Ej. valid, invalid")
    }

    "/identity-validation/upload_compress"(platform: "/", type: TrackType.Event) {
        upload_time(type: PropertyType.Numeric, required: true, description: "The time in second to upload image")
        compression_time(type: PropertyType.Numeric, required: true, description: "The time in second to compress a image.")
        _label(type: PropertyType.String, required: false, description: "The activity name")
    }

    "/identity-validation/skip_flow"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: true, description: "The flow the user skipped. Ej. ms_hard_validation")
        step(type: PropertyType.String, required: true, description: "The challenge the user skipped. Ej. documentation")
    }

    "/identity-validation/take_photo"(platform: "/mobile/android", type: TrackType.Event) {
        _label(type: PropertyType.String, required: true, description: "The activity name")
    }

    "/identity-validation/landing/back"(platform: "/", type: TrackType.Event) {
    }

    "/identity-validation/phone_code"(platform: "/", type: TrackType.View) {}
    "/identity-validation/phone"(platform: "/", type: TrackType.View) {}
    "/identity-validation/upload_doc"(platform: "/", type: TrackType.View) {
        from(type: PropertyType.String, required: false, description: "Describes from where the user entered the flow")
        flow(type: PropertyType.String, required: false, description: "The flow the user skipped. Ej. ms_hard_validation")
    }
    "/identity-validation/landing"(platform: "/", type: TrackType.View) {
        from(type: PropertyType.String, required: false, description: "Describes from where the user entered the flow")
        flow(type: PropertyType.String, required: false, description: "The flow the user skipped. Ej. ms_hard_validation")
    }
    "/identity-validation/congrats"(platform: "/", type: TrackType.View) {
        from(type: PropertyType.String, required: false, description: "Describes from where the user entered the flow")
        flow(type: PropertyType.String, required: false, description: "The flow the user skipped. Ej. ms_hard_validation")
    }
    "/identity-validation/landing_doc"(platform: "/", type: TrackType.View) {}
    "/identity-validation/doc_number"(platform: "/", type: TrackType.View) {}
}