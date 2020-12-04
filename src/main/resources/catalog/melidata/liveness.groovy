package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    initiative = '1127'

    "/liveness"(platform: "/mobile", isAbstract: true) {
        transaction_id(type: PropertyType.String, required: false, description: "Transaction id for user identifier")
        transaction_user_id(type: PropertyType.Numeric, required: false, description: "Indicates the user of the actual transaction")
    }

    "/liveness"(platform: "/web", isAbstract: true) {
        transaction_id(type: PropertyType.String, required: true, description: "Transaction id for user identifier")
        transaction_user_id(type: PropertyType.Numeric, required: true, description: "Indicates the user of the actual transaction")
    }

    "/liveness/enrollment"(platform: "/", type: TrackType.Event) {
        params(type: PropertyType.String, required: true, description: "Params with which the flow was invoked")
    }

    "/liveness/authentication"(platform: "/", type: TrackType.Event) {
        params(type: PropertyType.String, required: true, description: "Params with which the flow was invoked")
    }

    "/liveness/initialization"(platform: "/", type: TrackType.Event) {
        initialization_result(type: PropertyType.Boolean, required: true, description: "Result of initialization")
        initialization_status(type: PropertyType.Numeric, required: true, description: "Status of initialization")
        initialization_description(type: PropertyType.String, required: true, description: "Description of initialization")
    }

    "/liveness/challenge"(platform: "/", type: TrackType.Event) {
        time(type: PropertyType.Numeric, required: true, description: "Time to complete challenge")
        challenge_result(type: PropertyType.Numeric, required: true, description: "Result of client validation")
        challenge_result_description(type: PropertyType.String, required: true, description: "Description of validation")
        is_low_light_mode_active(type: PropertyType.Boolean, required: false, description: "Status type of customization")
    }

    "/liveness/result"(platform: "/", type: TrackType.Event) {
        success(type: PropertyType.Boolean, required: true, description: "Result of response")
        upload_time(type: PropertyType.Numeric, required: true, description: "Time to upload challenge")
        liveness_result(type: PropertyType.Numeric, required: true, description: "Result of server validation")
    }

    "/liveness/redirect"(platform: "/mobile", type: TrackType.Event) {
        deeplink(type: PropertyType.String, required: true, description: "The deeplink associated to next view")
    }

    "/liveness/redirect"(platform: "/web", type: TrackType.Event) {
        url(type: PropertyType.String, required: true, description: "The url associated to next view")
    }

    "/liveness/bussines_error"(platform: "/", type: TrackType.Event) {
        error_message(type: PropertyType.String, required: true, description: "Error message returned from middle")
    }

    "/liveness/generic_error"(platform: "/", type: TrackType.Event) {
        error_type(type: PropertyType.String, required: true, description: "Type of error")
        error_cause(type: PropertyType.String, required: true, description: "Error cause")
    }

    "/liveness/action"(platform: "/", type: TrackType.Event) {
        type(type: PropertyType.String, required: true, values: [
                "close",
                "back",
                "start_liveness"
        ], description: "Type of actions")
    }

    "/liveness/landing"(platform: "/", type: TrackType.View) {}

    "/liveness/fallback"(platform: "/", type: TrackType.View) {}

    "/liveness/unsupported"(platform: "/", type: TrackType.View) {}
}