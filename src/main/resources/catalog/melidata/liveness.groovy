package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    initiative = '1127'

    "/liveness"(platform: "/", isAbstract: true) {
    	model_id(type: PropertyType.String, required: false, description: "Model id of view")
    }

    "/liveness/enrollment"(platform: "/", type: TrackType.Event) {
    	params(type: PropertyType.String, required: true, description: "Params with which the flow was invoked")
    }

    "/liveness/authentication"(platform: "/", type: TrackType.Event) {
    	params(type: PropertyType.String, required: true, description: "Params with which the flow was invoked")
    }

    "/liveness/initialization"(platform: "/", type: TrackType.Event) {
    	initialization_result(type: PropertyType.Boolean, required: true, description: "Status of initialization")
    }

	"/liveness/challenge_time"(platform: "/", type: TrackType.Event) {
		time(type: PropertyType.Numeric, required: true, description: "Time to complete challenge")
		challenge_result(type: PropertyType.Numeric, required: true, description: "Result of client validation")
    }

	"/liveness/result"(platform: "/", type: TrackType.Event) {
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

	"/liveness/landing"(platform: "/", type: TrackType.View) {}

	"/liveness/fallback"(platform: "/", type: TrackType.View) {
		type(type: PropertyType.String, required: true, values: ["timeout", "cancel"], description: "Type of fallback")
	}

	"/liveness/unsupported"(platform: "/", type: TrackType.View) {}
}