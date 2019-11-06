package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("Remedies mobile android") {

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            action_type = "internal_navigation"
        }

        "/remedies/business_error"(platform: "/mobile/android") {
            error_message = "telefono incorrecto"
            api_call_identificator = 1
        }

        "/remedies/on_back_pressed"(platform: "/mobile") {
            on_back_go_check_step = true
            skip_landing = true
        }

        "/remedies/open_modal"(platform: "/mobile/android") {
            modal_name = "iv_modal"
        }

        "/remedies/modal_element_selected"(platform: "/mobile/android") {
            modal_name = "iv_modal"
            element_selected = "V"
        }

        "/remedies/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/remedies/generic_error"(platform: "/mobile") {
            error_type = "instantiate_camera"
            error_cause = "error"
        }

        "/remedies/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/remedies/ask_permissions"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/remedies/permissions_fallback"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/remedies/permission_denied"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/remedies/permission_accepted"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/remedies/camera_init_state"(platform: "/mobile/android") {
            default_flash = "off"
            switch_flash= true
            default_lens = "back"
            switch_lens = true
            compression_rate = 100
            max_size = 1200
        }

        "/remedies/proof_of_life_validation"(platform: "/mobile") {
            validation = "face_too_small"
            reset_gestures = true
        }

        "/remedies/proof_of_life_gesture"(platform: "/mobile") {
            gestures_probabilities = [
                left_eye: 0.99,
                right_eye: 0.98
            ]
            gesture = "open_eye"
        }

        "/remedies/activity/check_step"(platform: "/mobile/android") {
            initiative = 'asset'
            kyc_flow_id = "123abcd"
            flow = "asset_management"
        }
        "/remedies/activity/landing"(platform: "/mobile/android") {}
        "/remedies/activity/phone_landing"(platform: "/mobile/android") {}
        "/remedies/activity/phone_validation"(platform: "/mobile/android") {}
        "/remedies/activity/image_upload"(platform: "/mobile/android") {}
        "/remedies/activity/image_upload/landing"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/image_upload/uploading"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/image_upload/result"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/congrats"(platform: "/mobile/android") {}
        "/remedies/activity/documentation_number"(platform: "/mobile/android") {}
        "/remedies/activity/custom_camera"(platform: "/mobile/android") {}
        "/remedies/activity/picture_confirmation"(platform: "/mobile/android") {}
    }

    test("Remedies mobile ios") {

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            action_type = "internal_navigation"
        }

        "/remedies/business_error"(platform: "/mobile/ios") {
            error_message = "telefono incorrecto"
        }

        "/remedies/open_modal"(platform: "/mobile/ios") {
            modal_name = "iv_modal"
        }

        "/remedies/modal_element_selected"(platform: "/mobile/ios") {
            modal_name = "iv_modal"
            element_selected = "V"
        }


        "/remedies/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/remedies/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/remedies/ask_permissions"(platform: "/mobile/ios") {
            permissions = "CAMERA"
        }

        "/remedies/permissions_fallback"(platform: "/mobile/ios") {
            permissions = "CAMERA"
        }

        "/remedies/permission_denied"(platform: "/mobile/ios") {
            permissions = "READ_EXTERNAL_STORAGE"
        }

        "/remedies/permission_accepted"(platform: "/mobile/ios") {
            permissions = "READ_EXTERNAL_STORAGE"
        }

        "/remedies/camera_init_state"(platform: "/mobile/ios") {
            default_flash = "off"
            switch_flash= true
            default_lens = "back"
            switch_lens = true
            compression_rate = 100
            max_size = 1200
        }

        "/remedies/activity/check_step"(platform: "/mobile/ios") {}
        "/remedies/activity/landing"(platform: "/mobile/ios") {}
        "/remedies/activity/phone_landing"(platform: "/mobile/ios") {}
        "/remedies/activity/phone_validation"(platform: "/mobile/ios") {}
        "/remedies/activity/image_upload"(platform: "/mobile/ios") {}
        "/remedies/activity/image_upload/landing"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/image_upload/uploading"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/image_upload/result"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/congrats"(platform: "/mobile/ios") {}
        "/remedies/activity/documentation_number"(platform: "/mobile/ios") {}
        "/remedies/activity/custom_camera"(platform: "/mobile/ios") {}
        "/remedies/activity/picture_confirmation"(platform: "/mobile/ios") {}
    }

    test("Remedies web") {
        "/remedies/landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/phone_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/phone_validation"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/documentation_front"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/documentation_back"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/documentation_number"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/selfie"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/congrats"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            congrats_type = "warning"
            transaction_user_id = 109479273
        }
        "/remedies/continue_phone_landing"(platform: "/web/desktop") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/remedies/continue_phone_congrats"(platform: "/web/desktop") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/remedies/detail_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/threeds"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/company"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/center/card"(platform: "/web") {
            status = "landing"
            transaction_user_id = 109479273
        }

        "/remedies/center/row"(platform: "/mobile") {
            status = "landing"
        }

        "/remedies/camera/open_camera"(platform: "/web") {
            devices = 2
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/remedies/camera/open_camera"(platform: "/web") {
            devices = 2
            transaction_user_id = 109479273
        }

        "/remedies/camera/capture_image"(platform: "/web") {
            is_landscape = false
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/remedies/camera/capture_image"(platform: "/web") {
            is_landscape = false
            transaction_user_id = 109479273
        }


        "/remedies/camera/pick_from_gallery"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/remedies/camera/pick_from_gallery"(platform: "/web") {}

        "/remedies/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            reason = "broken_camera"
        }

        "/remedies/camera/unavailable"(platform: "/web") {}

        "/remedies/camera/take_another_picture"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/remedies/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/remedies/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479272
            is_landscape = true
        }

        "/remedies/camera/take_picture"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/remedies/camera/open_camera_error"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            error = "epic_error"
            error_reason = "permission_denied"
        }

        "/remedies/camera/exit_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/remedies/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479272
            reason = "thereason"
        }
    }

    defaultBusiness = "mercadopago"

    test("Remedies mobile android") {

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            action_type = "internal_navigation"
        }

        "/remedies/business_error"(platform: "/mobile/android") {
            error_message = "telefono incorrecto"
            api_call_identificator = 1
        }

        "/remedies/on_back_pressed"(platform: "/mobile") {
            on_back_go_check_step = true
            skip_landing = true
        }

        "/remedies/open_modal"(platform: "/mobile/android") {
            modal_name = "iv_modal"
        }

        "/remedies/modal_element_selected"(platform: "/mobile/android") {
            modal_name = "iv_modal"
            element_selected = "V"
        }

        "/remedies/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/remedies/generic_error"(platform: "/mobile") {
            error_type = "instantiate_camera"
            error_cause = "error"
        }

        "/remedies/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/remedies/ask_permissions"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/remedies/permissions_fallback"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/remedies/permission_denied"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/remedies/permission_accepted"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/remedies/camera_init_state"(platform: "/mobile/android") {
            default_flash = "off"
            switch_flash= true
            default_lens = "back"
            switch_lens = true
            compression_rate = 100
            max_size = 1200
        }

        "/remedies/proof_of_life_validation"(platform: "/mobile") {
            validation = "face_too_small"
            reset_gestures = true
        }

        "/remedies/proof_of_life_gesture"(platform: "/mobile") {
            gesture = "open_eye"
            gestures_probabilities = [
                left_eye: 0.99,
                right_eye: 0.98
            ]
        }

        "/remedies/activity/check_step"(platform: "/mobile/android") {}
        "/remedies/activity/landing"(platform: "/mobile/android") {}
        "/remedies/activity/phone_landing"(platform: "/mobile/android") {}
        "/remedies/activity/phone_validation"(platform: "/mobile/android") {}
        "/remedies/activity/image_upload"(platform: "/mobile/android") {}
        "/remedies/activity/image_upload/landing"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/image_upload/uploading"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/image_upload/result"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/congrats"(platform: "/mobile/android") {}
        "/remedies/activity/documentation_number"(platform: "/mobile/android") {}
        "/remedies/activity/custom_camera"(platform: "/mobile/android") {}
        "/remedies/activity/picture_confirmation"(platform: "/mobile/android") {}
    }

    test("Remedies mobile ios") {

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            action_type = "internal_navigation"
        }

        "/remedies/business_error"(platform: "/mobile/ios") {
            error_message = "telefono incorrecto"
        }

        "/remedies/open_modal"(platform: "/mobile/ios") {
            modal_name = "iv_modal"
        }

        "/remedies/modal_element_selected"(platform: "/mobile/ios") {
            modal_name = "iv_modal"
            element_selected = "V"
        }


        "/remedies/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/remedies/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/remedies/ask_permissions"(platform: "/mobile/ios") {
            permissions = "CAMERA"
        }

        "/remedies/permissions_fallback"(platform: "/mobile/ios") {
            permissions = "CAMERA"
        }

        "/remedies/permission_denied"(platform: "/mobile/ios") {
            permissions = "READ_EXTERNAL_STORAGE"
        }

        "/remedies/permission_accepted"(platform: "/mobile/ios") {
            permissions = "READ_EXTERNAL_STORAGE"
        }

        "/remedies/camera_init_state"(platform: "/mobile/ios") {
            default_flash = "off"
            switch_flash= true
            default_lens = "back"
            switch_lens = true
            compression_rate = 100
            max_size = 1200
        }

        "/remedies/activity/check_step"(platform: "/mobile/ios") {}
        "/remedies/activity/landing"(platform: "/mobile/ios") {}
        "/remedies/activity/phone_landing"(platform: "/mobile/ios") {}
        "/remedies/activity/phone_validation"(platform: "/mobile/ios") {}
        "/remedies/activity/image_upload"(platform: "/mobile/ios") {}
        "/remedies/activity/image_upload/landing"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/image_upload/uploading"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/image_upload/result"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/remedies/activity/congrats"(platform: "/mobile/ios") {}
        "/remedies/activity/documentation_number"(platform: "/mobile/ios") {}
        "/remedies/activity/custom_camera"(platform: "/mobile/ios") {}
        "/remedies/activity/picture_confirmation"(platform: "/mobile/ios") {}
    }

    test("Remedies web") {
        "/remedies/landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/phone_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/phone_validation"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/documentation_front"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/documentation_back"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/documentation_number"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/selfie"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/congrats"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            congrats_type = "warning"
            transaction_user_id = 109479273
        }
        "/remedies/continue_phone_landing"(platform: "/web/desktop") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/remedies/continue_phone_congrats"(platform: "/web/desktop") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/remedies/detail_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/threeds"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/remedies/company"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        
        "/remedies/center/card"(platform: "/web") {
            status = "landing"
            transaction_user_id = 109479273
        }

        "/remedies/center/row"(platform: "/mobile") {
            status = "landing"
        }

        "/remedies/camera/open_camera"(platform: "/web") {
            devices = 2
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/remedies/camera/open_camera"(platform: "/web") {
            devices = 2
            transaction_user_id = 109479273
        }

        "/remedies/camera/capture_image"(platform: "/web") {
            is_landscape = false
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/remedies/camera/capture_image"(platform: "/web") {
            is_landscape = false
            transaction_user_id = 109479273
        }


        "/remedies/camera/pick_from_gallery"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/remedies/camera/pick_from_gallery"(platform: "/web") {}

        "/remedies/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            reason = "broken_camera"
        }

        "/remedies/camera/unavailable"(platform: "/web") {}

        "/remedies/camera/take_another_picture"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/remedies/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/remedies/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479272
            is_landscape = true
        }

        "/remedies/camera/take_picture"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/remedies/camera/open_camera_error"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            error = "epic_error"
            error_reason = "permission_denied"
        }

        "/remedies/camera/exit_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/remedies/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479272
            reason = "thereason"
        }
    }

}
