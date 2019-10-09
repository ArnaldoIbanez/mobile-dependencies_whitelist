import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Remedies

    "/remedies"(platform: "/mobile", isAbstract: true) {}

    "/remedies"(platform: "/web", isAbstract: true) {
        track_info(required: false, type: PropertyType.Map(track_info_definition), description: "Map of key value elements to be tracked in web apps")
    }

    "/remedies/activity"(platform: "/", isAbstract: true) {
        track_info(required: false, type: PropertyType.Map(track_info_definition), description: "Map of key value elements to be tracked in mobile apps")
    }

    "/remedies/center"(platform: "/", isAbstract: true) {}

    "/remedies/executed_action"(platform: "/mobile", type: TrackType.Event) {
        executed_action(type: PropertyType.String, required: true, description: "Action executed from component actions")
        extra_params(type: PropertyType.String, required: false, description: "The deeplink params with which the flow was invoked")
    }

    "/remedies/resolve_model"(platform: "/mobile", type: TrackType.Event) {
        model_id(type: PropertyType.String, required: true, description: "Model id to resolve")
        deeplink(type: PropertyType.String, required: false, description: "The deeplink associated to next activity")
        action_type(type: PropertyType.String, required: true, description: "Type of action. Ej. internal_navigation")
    }

    "/remedies/business_error"(platform: "/mobile/android", type: TrackType.Event) {
        error_message(type: PropertyType.String, required: true, description: "error message returned from frapi")
        api_call_identificator(type: PropertyType.Numeric, required: true, description: "Api call identificator")
    }

    "/remedies/business_error"(platform: "/mobile/ios", type: TrackType.Event) {
        error_message(type: PropertyType.String, required: true, description: "error message returned from frapi")
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

    "/remedies/generic_error"(platform: "/mobile", type: TrackType.Event) {
        error_type(type: PropertyType.String, required: true, description: "Type of error")
        error_cause(type: PropertyType.String, required: false, description: "Error cause")
    }

    "/remedies/executed_camera_action"(platform: "/mobile", type: TrackType.Event) {
        executed_camera_action(type: PropertyType.String, required: true, description: "Executed camera action")
    }

    "/remedies/ask_permissions"(platform: "/mobile", type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Asked permissions")
    }

    "/remedies/permissions_fallback"(platform: "/mobile", type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Permissions fallback")
    }

    "/remedies/permission_denied"(platform: "/mobile", type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Denied permissions")
    }

    "/remedies/permission_accepted"(platform: "/mobile", type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Accepted permissions")
    }

    "/remedies/camera_init_state"(platform: "/mobile", type: TrackType.Event) {
        default_flash(type: PropertyType.String, required: true, description: "Default flash configuration")
        switch_flash(type: PropertyType.Boolean, required: true, description: "Possibility of switch flash enable")
        default_lens(type: PropertyType.String, required: true, description: "Default camera mode")
        switch_lens(type: PropertyType.Boolean, required: true, description: "Possibility of switch camera mode enable")
        compression_rate(type: PropertyType.Numeric, required: true, description: "Compression rate")
        max_size(type: PropertyType.Numeric, required: true, description: "Max side size")
    }

    "/remedies/proof_of_life_validation"(platform: "/mobile", type: TrackType.Event) {
        validation(type: PropertyType.String, required: true, description: "Gesture made by the user")
        reset_gestures(type: PropertyType.Boolean, required: true, description: "Indicates if the user has to start again in the array of gestures")
    }

    def gestures_probabilities_definition = objectSchemaDefinitions {
        left_eye(type: PropertyType.Numeric, required: false, description: "left eye probability")
        right_eye(type: PropertyType.Numeric, required: false, description: "right eye probability")
        smile(type: PropertyType.Numeric, required: false, description: "simle probability ")
        rotation(type: PropertyType.Numeric, required: false, description: "rotation probability")
    }

     def track_info_definition = objectSchemaDefinitions {
        initiative(required: false, type: PropertyType.String, description: "Users initiative")
        kyc_flow_id(required: false, type: PropertyType.String, description: "Kyc flow")
        flow(required: false, type: PropertyType.String, description: "Remedies flow")
    }

    "/remedies/proof_of_life_gesture"(platform: "/mobile", type: TrackType.Event) {
        gesture(type: PropertyType.String, required: true, description: "Type of validation made")
        gestures_probabilities(type: PropertyType.Map(gestures_probabilities_definition), required: true, description: "Map of probabilities of each gesture")
    }

    "/remedies/activity/check_step"(platform: "/mobile", type: TrackType.View) {
    }
    
    "/remedies/activity/landing"(platform: "/mobile", type: TrackType.View) {
    }

    "/remedies/activity/phone_landing"(platform: "/mobile", type: TrackType.View) {
    }

    "/remedies/activity/phone_validation"(platform: "/mobile", type: TrackType.View) {
    }
    "/remedies/activity/image_upload"(platform: "/mobile", type: TrackType.View) {
    }

    "/remedies/activity/image_upload/landing"(platform: "/mobile", type: TrackType.View) {
        doc_type(type: PropertyType.String, required: true, description: "Type of document")
        model_id(type: PropertyType.String, required: true, description: "Model id")
    }

    "/remedies/activity/image_upload/uploading"(platform: "/mobile", type: TrackType.View) {
        doc_type(type: PropertyType.String, required: true, description: "Type of document")
        model_id(type: PropertyType.String, required: true, description: "Model id")
    }

    "/remedies/activity/image_upload/result"(platform: "/mobile", type: TrackType.View) {
        doc_type(type: PropertyType.String, required: true, description: "Type of document")
        model_id(type: PropertyType.String, required: true, description: "Model id")
    }

    "/remedies/activity/congrats"(platform: "/mobile", type: TrackType.View) {
    }

    "/remedies/activity/documentation_number"(platform: "/mobile", type: TrackType.View) {
    }

    "/remedies/activity/custom_camera"(platform: "/mobile", type: TrackType.View) {
    }

    "/remedies/activity/picture_confirmation"(platform: "/mobile", type: TrackType.View) {
    }

    // Mobile tracks
    "/remedies/center/row"(platform: "/mobile", type: TrackType.View) {
        status(type: PropertyType.String, required: true, description: "Remedy center status of user")
    }

    // Web desktop and web mobile tracks
    "/remedies/landing"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/phone_landing"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/phone_validation"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/documentation_front"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/documentation_back"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/documentation_number"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/selfie"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/congrats"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        congrats_type(type: PropertyType.String, required: true, description: "Type of the congrats we show")
    }
    "/remedies/continue_phone_landing"(platform: "/web/desktop", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        challenge(type: PropertyType.String, required: true, description: "Current challenge")
    }

    "/remedies/continue_phone_congrats"(platform: "/web/desktop", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        challenge(type: PropertyType.String, required: true, description: "Current challenge")
    }

    "/remedies/detail_landing"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/threeds"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/company"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/remedies/center/card"(platform: "/web", type: TrackType.View) {
        status(type: PropertyType.String, required: true, description: "Remedy center status of user")
    }

    "/remedies/camera"(platform: "/web", isAbstract: true) {}

    "/remedies/camera/open_camera"(platform: "/web", type: TrackType.Event) {
        devices(type: PropertyType.Numeric, required: true, description: "The number of camera devices the user has")
    }

    "/remedies/camera/capture_image"(platform: "/web", type: TrackType.Event) {
        is_landscape(type: PropertyType.Boolean, required: true, description: "Indicates if the picture was taken on landscape mode")
    }

    "/remedies/camera/pick_from_gallery"(platform: "/web", type: TrackType.Event) {}

    "/remedies/camera/unavailable"(platform: "/web", type: TrackType.Event) {}
}
