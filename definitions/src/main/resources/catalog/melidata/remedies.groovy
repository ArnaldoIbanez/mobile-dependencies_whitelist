import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Remedies

    "/remedies"(platform: "/", isAbstract: true) {}

    "/remedies/activity"(platform: "/", isAbstract: true) {}

    "/remedies/executed_action"(platform: "/mobile", type: TrackType.Event) {
        executed_action(type: PropertyType.String, required: true, description: "Action executed from component actions")
        deeplink_params(type: PropertyType.String, required: false, description: "The deeplink params with which the flow was invoked")
    }

    "/remedies/resolve_model"(platform: "/mobile", type: TrackType.Event) {
        model_id(type: PropertyType.String, required: true, description: "Model id to resolve")
        deeplink(type: PropertyType.String, required: true, description: "The deeplink associated to next activity")
        action_type(type: PropertyType.String, required: true, description: "Type of action. Ej. internal_navigation")
    }

    "/remedies/business_error"(platform: "/mobile/android", type: TrackType.Event) {
        error_message(type: PropertyType.String, required: true, description: "error message returned from frapi")
        api_call_identificator(type: PropertyType.Numeric, required: true, description: "Api call identificator")
    }

    "/remedies/failure_api_call"(platform: "/mobile", type: TrackType.Event) {
        error_message(type: PropertyType.String, required: true, description: "error message of the exception")
        error_cause(type: PropertyType.String, required: true, description: "error cause of the exception")
        exception(type: PropertyType.String, required: true, description: "exception")
    }

    "/remedies/on_back_pressed"(platform: "/mobile", type: TrackType.Event) {
        on_back_go_check_step(type: PropertyType.Boolean, required: true, description: "onBackGoCheckStep parameter")
        skip_landing(type: PropertyType.Boolean, required: true, description: "skipLanding parameter")
    }

    "/remedies/modal_element_selected"(platform: "/mobile", type: TrackType.Event) {
        modal_name(type: PropertyType.String, required: true, description: "name of the open modal")
        element_selected(type: PropertyType.String, required: true, description: "Modal element selected")
    }

    "/remedies/open_modal"(platform: "/mobile", type: TrackType.Event) {
        modal_name(type: PropertyType.String, required: true, description: "name of the open modal")
    }

    "/remedies/unsupported_deeplink"(platform: "/mobile", type: TrackType.Event) {
        unsupported_deeplink(type: PropertyType.String, required: true, description: "Unsupported deeplink")
    }

    "/remedies/activity/check_step"(platform: "/mobile/android", type: TrackType.View) {}
    "/remedies/activity/landing"(platform: "/mobile/android", type: TrackType.View) {}
    "/remedies/activity/phone_landing"(platform: "/mobile/android", type: TrackType.View) {}
    "/remedies/activity/phone_validation"(platform: "/mobile/android", type: TrackType.View) {}
    "/remedies/activity/image_upload"(platform: "/mobile/android", type: TrackType.View) {}
    "/remedies/activity/congrats"(platform: "/mobile/android", type: TrackType.View) {}
    "/remedies/activity/documentation_number"(platform: "/mobile/android", type: TrackType.View) {}
    "/remedies/activity/custom_camera"(platform: "/mobile/android", type: TrackType.View) {}
    "/remedies/activity/picture_confirmation"(platform: "/mobile/android", type: TrackType.View) {}
}