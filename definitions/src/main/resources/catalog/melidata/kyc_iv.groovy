import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    
    //kyc/iv

    "/kyc/iv"(platform: "/", isAbstract: true) {}

    "/kyc/iv"(platform: "/mobile", isAbstract: true) {}

    "/kyc/iv"(platform: "/web", isAbstract: true) {
        transaction_user_id(type: PropertyType.Numeric, required: false, description: "Indicates the user of the actual transaction")
        initiative(required: false, type: PropertyType.String, description: "Users initiative")
        kyc_flow_id(required: false, type: PropertyType.String, description: "Kyc flow")
        flow(required: false, type: PropertyType.String, description: "Remedies flow")
    }

    "/kyc/iv/activity"(platform: "/", isAbstract: true) {
        initiative(required: false, type: PropertyType.String, description: "Users initiative")
        kyc_flow_id(required: false, type: PropertyType.String, description: "Kyc flow")
        flow(required: false, type: PropertyType.String, description: "Remedies flow")
    }

    "/kyc/iv/center"(platform: "/", isAbstract: true) {}

    "/kyc/iv/executed_action"(platform: "/mobile", type: TrackType.Event) {
        executed_action(type: PropertyType.String, required: true, description: "Action executed from component actions")
        extra_params(type: PropertyType.String, required: false, description: "The deeplink params with which the flow was invoked")
    }

    "/kyc/iv/resolve_model"(platform: "/mobile", type: TrackType.Event) {
        model_id(type: PropertyType.String, required: true, description: "Model id to resolve")
        deeplink(type: PropertyType.String, required: false, description: "The deeplink associated to next activity")
        action_type(type: PropertyType.String, required: true, description: "Type of action. Ej. internal_navigation")
    }

    "/kyc/iv/business_error"(platform: "/mobile/android", type: TrackType.Event) {
        error_message(type: PropertyType.String, required: true, description: "error message returned from frapi")
        api_call_identificator(type: PropertyType.Numeric, required: true, description: "Api call identificator")
    }

    "/kyc/iv/business_error"(platform: "/mobile/ios", type: TrackType.Event) {
        error_message(type: PropertyType.String, required: true, description: "error message returned from frapi")
    }

    "/kyc/iv/on_back_pressed"(platform: "/mobile", type: TrackType.Event) {
        on_back_go_check_step(type: PropertyType.Boolean, required: true, description: "onBackGoCheckStep parameter")
        skip_landing(type: PropertyType.Boolean, required: true, description: "skipLanding parameter")
    }

    "/kyc/iv/modal_element_selected"(platform: "/mobile", type: TrackType.Event) {
        modal_name(type: PropertyType.String, required: true, description: "name of the open modal")
        element_selected(type: PropertyType.String, required: true, description: "Modal element selected")
    }

    "/kyc/iv/open_modal"(platform: "/mobile", type: TrackType.Event) {
        modal_name(type: PropertyType.String, required: true, description: "name of the open modal")
    }

    "/kyc/iv/unsupported_deeplink"(platform: "/mobile", type: TrackType.Event) {
        unsupported_deeplink(type: PropertyType.String, required: true, description: "Unsupported deeplink")
    }

    "/kyc/iv/generic_error"(platform: "/mobile", type: TrackType.Event) {
        error_type(type: PropertyType.String, required: true, description: "Type of error")
        error_cause(type: PropertyType.String, required: false, description: "Error cause")
    }

    "/kyc/iv/executed_camera_action"(platform: "/mobile", type: TrackType.Event) {
        executed_camera_action(type: PropertyType.String, required: true, description: "Executed camera action")
    }

    "/kyc/iv/ask_permissions"(platform: "/mobile", type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Asked permissions")
    }

    "/kyc/iv/permissions_fallback"(platform: "/mobile", type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Permissions fallback")
    }

    "/kyc/iv/permission_denied"(platform: "/mobile", type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Denied permissions")
    }

    "/kyc/iv/permission_accepted"(platform: "/mobile", type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Accepted permissions")
    }

    "/kyc/iv/camera_init_state"(platform: "/mobile", type: TrackType.Event) {
        default_flash(type: PropertyType.String, required: true, description: "Default flash configuration")
        switch_flash(type: PropertyType.Boolean, required: true, description: "Possibility of switch flash enable")
        default_lens(type: PropertyType.String, required: true, description: "Default camera mode")
        switch_lens(type: PropertyType.Boolean, required: true, description: "Possibility of switch camera mode enable")
        compression_rate(type: PropertyType.Numeric, required: true, description: "Compression rate")
        max_size(type: PropertyType.Numeric, required: true, description: "Max side size")
    }

    "/kyc/iv/proof_of_life_validation"(platform: "/mobile", type: TrackType.Event) {
        validation(type: PropertyType.String, required: true, description: "Gesture made by the user")
        reset_gestures(type: PropertyType.Boolean, required: true, description: "Indicates if the user has to start again in the array of gestures")
    }

    def gestures_probabilities_definition = objectSchemaDefinitions {
        left_eye(type: PropertyType.Numeric, required: false, description: "left eye probability")
        right_eye(type: PropertyType.Numeric, required: false, description: "right eye probability")
        smile(type: PropertyType.Numeric, required: false, description: "simle probability ")
        rotation(type: PropertyType.Numeric, required: false, description: "rotation probability")
    }

    "/kyc/iv/proof_of_life_gesture"(platform: "/mobile", type: TrackType.Event) {
        gesture(type: PropertyType.String, required: true, description: "Type of validation made")
        gestures_probabilities(type: PropertyType.Map(gestures_probabilities_definition), required: true, description: "Map of probabilities of each gesture")
    }

    "/kyc/iv/activity/check_step"(platform: "/mobile", type: TrackType.View) {
    }
    
    "/kyc/iv/activity/landing"(platform: "/mobile", type: TrackType.View) {
    }

    "/kyc/iv/activity/phone_landing"(platform: "/mobile", type: TrackType.View) {
    }

    "/kyc/iv/activity/phone_validation"(platform: "/mobile", type: TrackType.View) {
    }
    "/kyc/iv/activity/image_upload"(platform: "/mobile", type: TrackType.View) {
    }

    "/kyc/iv/activity/image_upload/landing"(platform: "/mobile", type: TrackType.View) {
        doc_type(type: PropertyType.String, required: true, description: "Type of document")
        model_id(type: PropertyType.String, required: true, description: "Model id")
    }

    "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile", type: TrackType.View) {
        doc_type(type: PropertyType.String, required: true, description: "Type of document")
        model_id(type: PropertyType.String, required: true, description: "Model id")
    }

    "/kyc/iv/activity/image_upload/result"(platform: "/mobile", type: TrackType.View) {
        doc_type(type: PropertyType.String, required: true, description: "Type of document")
        model_id(type: PropertyType.String, required: true, description: "Model id")
    }

    "/kyc/iv/activity/congrats"(platform: "/mobile", type: TrackType.View) {
    }

    "/kyc/iv/activity/documentation_number"(platform: "/mobile", type: TrackType.View) {
    }

    "/kyc/iv/activity/custom_camera"(platform: "/mobile", type: TrackType.View) {
    }

    "/kyc/iv/activity/picture_confirmation"(platform: "/mobile", type: TrackType.View) {
    }

    // Mobile tracks
    "/kyc/iv/center/row"(platform: "/mobile", type: TrackType.View) {
        status(type: PropertyType.String, required: true, description: "Remedy center status of user")
    }

    // Web desktop and web mobile tracks
    "/kyc/iv/landing"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/kyc/iv/phone_landing"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/kyc/iv/phone_validation"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/kyc/iv/documentation_front"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: true, description: "Indicates if custom cam is offered")
    }

    "/kyc/iv/documentation_back"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: true, description: "Indicates if custom cam is offered")
    }

    "/kyc/iv/documentation_number"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/kyc/iv/selfie"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/kyc/iv/congrats"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        congrats_type(type: PropertyType.String, required: true, description: "Type of the congrats we show")
    }
    "/kyc/iv/continue_phone_landing"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        challenge(type: PropertyType.String, required: true, description: "Current challenge")
    }

    "/kyc/iv/continue_phone_congrats"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        challenge(type: PropertyType.String, required: true, description: "Current challenge")
    }

    "/kyc/iv/detail_landing"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/kyc/iv/threeds"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/kyc/iv/company"(platform: "/web", type: TrackType.View) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
    }

    "/kyc/iv/center/card"(platform: "/web", type: TrackType.View) {
        status(type: PropertyType.String, required: true, description: "Remedy center status of user")
    }

    "/kyc/iv/camera"(platform: "/web", isAbstract: true) {}

    "/kyc/iv/camera/open_camera"(platform: "/web", type: TrackType.Event) {
        devices(type: PropertyType.Numeric, required: true, description: "The number of camera devices the user has")
        flow(type: PropertyType.String, required: false, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: false, description: "Indicates if custom cam is offered")
    }

    "/kyc/iv/camera/capture_image"(platform: "/web", type: TrackType.Event) {
        is_landscape(type: PropertyType.Boolean, required: true, description: "Indicates if the picture was taken on landscape mode")
        flow(type: PropertyType.String, required: false, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: false, description: "Indicates if custom cam is offered")
    }

    "/kyc/iv/camera/pick_from_gallery"(platform: "/web", type: TrackType.Event) {
        flow(type: PropertyType.String, required: false, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: false, description: "Indicates if custom cam is offered")
    }

    "/kyc/iv/camera/unavailable"(platform: "/web", type: TrackType.Event) {
        flow(type: PropertyType.String, required: false, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: false, description: "Indicates if custom cam is offered")
        reason(type: PropertyType.String, required: false, description: "Indicates the reason of the camera unavailable")
    }

    "/kyc/iv/camera/take_another_picture"(platform: "/web", type: TrackType.Event) {
        is_landscape(type: PropertyType.Boolean, required: true, description: "Indicates if the picture was taken on landscape mode")
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: true, description: "Indicates if custom cam is offered")
    }

    "/kyc/iv/camera/change_camera"(platform: "/web", type: TrackType.Event) {
        is_landscape(type: PropertyType.Boolean, required: true, description: "Indicates if the picture was taken on landscape mode")
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: true, description: "Indicates if custom cam is offered")
    }

    "/kyc/iv/camera/take_picture"(platform: "/web", type: TrackType.Event) {
        is_landscape(type: PropertyType.Boolean, required: true, description: "Indicates if the picture was taken on landscape mode")
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: true, description: "Indicates if custom cam is offered")
    }

    "/kyc/iv/camera/open_camera_error"(platform: "/web", type: TrackType.Event) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: true, description: "Indicates if custom cam is offered")
        error(type: PropertyType.String, required: true, description: "Type of error")
        error_reason(type: PropertyType.String, required: true, description: "Reason of the error")
    }

    "/kyc/iv/camera/exit_camera"(platform: "/web", type: TrackType.Event) {
        flow(type: PropertyType.String, required: true, description: "Name of the current flow")
        custom_cam_offered(type: PropertyType.Boolean, required: true, description: "Indicates if custom cam is offered")
    }
}