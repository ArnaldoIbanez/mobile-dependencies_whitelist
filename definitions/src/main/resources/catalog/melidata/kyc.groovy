import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/kyc"(platform: "/", isAbstract: true) {}
    "/kyc/challenge"(platform: "/", isAbstract: true) {}

    // Challenges
    "/kyc/challenge_pep"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_fatca"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_regulated_entity"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_manual_input_dob"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_manual_input_document"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_mismatch"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_cx_pending"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_number_of_attempts_exceeded"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identity_validation"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identification_bad_quality"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_country_of_birth"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_document_type"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_gender"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_terms_and_conditions"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_terms_and_conditions_company"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_selfie"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_selfie_bad_quality"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_company_relationship"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identification"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_nationality"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identifier_type"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identity"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_identity_mismatch"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_birthdate"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_address"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_phone"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_single_pep_fatca_so"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_kyc_name_mismatch"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_company_confirmation"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_company_relationship"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_marital_status"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_occupation"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_cellphone"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_name_mismatch"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_address_confirmation"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_activity"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_proof_of_address"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_death"(platform: "/", type: TrackType.View) {}
    "/kyc/challenge_under_age"(platform: "/", type: TrackType.View) {}
    "/kyc/identity_handler"(platform: "/", type: TrackType.View) {}

    "/kyc/identity_handler"(platform: "/", type: TrackType.Event) {
        identifier (required: true, type: PropertyType.String)
        status (required: false, type: PropertyType.String)
    }

    // WebView events
    "/kyc/url_external"(platform: "/", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external webview URL")
    }

    // Browser events
    "/kyc/browser_external"(platform: "/", type: TrackType.Event) {
        context (required: true, type: PropertyType.String, description: "The context where this event occurred")
        url (required: true, type: PropertyType.String, description: "The external browser URL")
    }

    // Errors
    "/kyc/error"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
        verbose (required: false, type: PropertyType.String, description: "The error description for the error occurred")
    }
    "/kyc/profile"(platform: "/", type: TrackType.Event) {}

    // challenge life cycle
    "/kyc/challenge/start"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

    "/kyc/challenge/send"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

    "/kyc/challenge/success"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

    "/kyc/challenge/fail"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

    "/kyc/challenge/retry"(platform: "/", type: TrackType.Event) {
        label (required: false, type: PropertyType.String, description: "The label attached to the current event")
    }

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

    "/kyc/iv/permissions"(platform: "/mobile", isAbstract: true, type: TrackType.Event) {
        permissions(type: PropertyType.String, required: true, description: "Asked permissions")
    }

    "/kyc/iv/permissions/ask"(platform: "/mobile", type: TrackType.Event) {}

    "/kyc/iv/permissions/fallback"(platform: "/mobile", type: TrackType.Event) {}

    "/kyc/iv/permissions/denied"(platform: "/mobile", type: TrackType.Event) {}

    "/kyc/iv/permissions/accepted"(platform: "/mobile", type: TrackType.Event) {}

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

    "/kyc/iv/activity/check_step"(platform: "/mobile", type: TrackType.View) {}
    
    "/kyc/iv/activity/landing"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/phone_landing"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/phone_validation"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/image_upload"(platform: "/mobile", isAbstract: true, type: TrackType.View) {
        doc_type(type: PropertyType.String, required: true, description: "Type of document")
        model_id(type: PropertyType.String, required: true, description: "Model id")
    }
    
    "/kyc/iv/activity/image_upload/landing"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/image_upload/result"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/congrats"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/documentation_number"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/custom_camera"(platform: "/mobile", type: TrackType.View) {}

    "/kyc/iv/activity/picture_confirmation"(platform: "/mobile", type: TrackType.View) {}

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
