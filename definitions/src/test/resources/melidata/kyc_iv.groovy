package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("KYC IV mobile android") {

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/kyc/iv/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/kyc/iv/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            action_type = "internal_navigation"
        }

        "/kyc/iv/business_error"(platform: "/mobile/android") {
            error_message = "telefono incorrecto"
            api_call_identificator = 1
        }

        "/kyc/iv/on_back_pressed"(platform: "/mobile") {
            on_back_go_check_step = true
            skip_landing = true
        }

        "/kyc/iv/open_modal"(platform: "/mobile/android") {
            modal_name = "iv_modal"
        }

        "/kyc/iv/modal_element_selected"(platform: "/mobile/android") {
            modal_name = "iv_modal"
            element_selected = "V"
        }

        "/kyc/iv/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/kyc/iv/generic_error"(platform: "/mobile") {
            error_type = "instantiate_camera"
            error_cause = "error"
        }

        "/kyc/iv/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/kyc/iv/permissions/ask"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/fallback"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/denied"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/accepted"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/camera_init_state"(platform: "/mobile/android") {
            default_flash = "off"
            switch_flash= true
            default_lens = "back"
            switch_lens = true
            compression_rate = 100
            max_size = 1200
        }

        "/kyc/iv/proof_of_life_validation"(platform: "/mobile") {
            validation = "face_too_small"
            reset_gestures = true
        }

        "/kyc/iv/proof_of_life_gesture"(platform: "/mobile") {
            gestures_probabilities = [
                left_eye: 0.99,
                right_eye: 0.98
            ]
            gesture = "open_eye"
        }

        "/kyc/iv/activity/check_step"(platform: "/mobile/android") {
            initiative = 'asset'
            kyc_flow_id = "123abcd"
            flow = "asset_management"
        }
        "/kyc/iv/activity/landing"(platform: "/mobile/android") {}
        "/kyc/iv/activity/phone_landing"(platform: "/mobile/android") {}
        "/kyc/iv/activity/phone_validation"(platform: "/mobile/android") {}
        "/kyc/iv/activity/image_upload"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/landing"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/result"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/congrats"(platform: "/mobile/android") {}
        "/kyc/iv/activity/documentation_number"(platform: "/mobile/android") {}
        "/kyc/iv/activity/custom_camera"(platform: "/mobile/android") {}
        "/kyc/iv/activity/picture_confirmation"(platform: "/mobile/android") {}
    }

    test("KYC IV mobile ios") {

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/kyc/iv/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/kyc/iv/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            action_type = "internal_navigation"
        }

        "/kyc/iv/business_error"(platform: "/mobile/ios") {
            error_message = "telefono incorrecto"
        }

        "/kyc/iv/open_modal"(platform: "/mobile/ios") {
            modal_name = "iv_modal"
        }

        "/kyc/iv/modal_element_selected"(platform: "/mobile/ios") {
            modal_name = "iv_modal"
            element_selected = "V"
        }


        "/kyc/iv/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/kyc/iv/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/kyc/iv/permissions/ask"(platform: "/mobile/ios") {
            permissions = "CAMERA"
        }

        "/kyc/iv/permissions/fallback"(platform: "/mobile/ios") {
            permissions = "CAMERA"
        }

        "/kyc/iv/permissions/denied"(platform: "/mobile/ios") {
            permissions = "READ_EXTERNAL_STORAGE"
        }

        "/kyc/iv/permissions/accepted"(platform: "/mobile/ios") {
            permissions = "READ_EXTERNAL_STORAGE"
        }

        "/kyc/iv/camera_init_state"(platform: "/mobile/ios") {
            default_flash = "off"
            switch_flash= true
            default_lens = "back"
            switch_lens = true
            compression_rate = 100
            max_size = 1200
        }

        "/kyc/iv/activity/check_step"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/landing"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/phone_landing"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/phone_validation"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/image_upload"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/landing"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/result"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/congrats"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/documentation_number"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/custom_camera"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/picture_confirmation"(platform: "/mobile/ios") {}
    }

    test("KYC IV web") {
        "/kyc/iv/landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/phone_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/phone_validation"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/documentation_front"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
            custom_cam_offered = true
        }
        "/kyc/iv/documentation_back"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
            custom_cam_offered = true
        }
        "/kyc/iv/documentation_number"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/selfie"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/congrats"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            congrats_type = "warning"
            transaction_user_id = 109479273
        }
        "/kyc/iv/continue_phone_landing"(platform: "/web/desktop") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/kyc/iv/continue_phone_landing"(platform: "/web/mobile") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/kyc/iv/continue_phone_congrats"(platform: "/web/desktop") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/kyc/iv/continue_phone_congrats"(platform: "/web/mobile") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/kyc/iv/detail_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/threeds"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/company"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/center/card"(platform: "/web") {
            status = "landing"
            transaction_user_id = 109479273
        }

        "/kyc/iv/center/row"(platform: "/mobile") {
            status = "landing"
        }

        "/kyc/iv/camera/open_camera"(platform: "/web") {
            devices = 2
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/open_camera"(platform: "/web") {
            devices = 2
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/capture_image"(platform: "/web") {
            is_landscape = false
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/capture_image"(platform: "/web") {
            is_landscape = false
            transaction_user_id = 109479273
        }


        "/kyc/iv/camera/pick_from_gallery"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/pick_from_gallery"(platform: "/web") {}

        "/kyc/iv/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            reason = "broken_camera"
        }

        "/kyc/iv/camera/unavailable"(platform: "/web") {}

        "/kyc/iv/camera/take_another_picture"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479272
            is_landscape = true
        }

        "/kyc/iv/camera/take_picture"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/open_camera_error"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            error = "epic_error"
            error_reason = "permission_denied"
        }

        "/kyc/iv/camera/exit_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479272
            reason = "thereason"
        }
    }

    defaultBusiness = "mercadopago"

    test("KYC IV mobile android") {

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/kyc/iv/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/kyc/iv/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            action_type = "internal_navigation"
        }

        "/kyc/iv/business_error"(platform: "/mobile/android") {
            error_message = "telefono incorrecto"
            api_call_identificator = 1
        }

        "/kyc/iv/on_back_pressed"(platform: "/mobile") {
            on_back_go_check_step = true
            skip_landing = true
        }

        "/kyc/iv/open_modal"(platform: "/mobile/android") {
            modal_name = "iv_modal"
        }

        "/kyc/iv/modal_element_selected"(platform: "/mobile/android") {
            modal_name = "iv_modal"
            element_selected = "V"
        }

        "/kyc/iv/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/kyc/iv/generic_error"(platform: "/mobile") {
            error_type = "instantiate_camera"
            error_cause = "error"
        }

        "/kyc/iv/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/kyc/iv/permissions/ask"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/fallback"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/denied"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/accepted"(platform: "/mobile/android") {
            permissions = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/camera_init_state"(platform: "/mobile/android") {
            default_flash = "off"
            switch_flash= true
            default_lens = "back"
            switch_lens = true
            compression_rate = 100
            max_size = 1200
        }

        "/kyc/iv/proof_of_life_validation"(platform: "/mobile") {
            validation = "face_too_small"
            reset_gestures = true
        }

        "/kyc/iv/proof_of_life_gesture"(platform: "/mobile") {
            gesture = "open_eye"
            gestures_probabilities = [
                left_eye: 0.99,
                right_eye: 0.98
            ]
        }

        "/kyc/iv/activity/check_step"(platform: "/mobile/android") {}
        "/kyc/iv/activity/landing"(platform: "/mobile/android") {}
        "/kyc/iv/activity/phone_landing"(platform: "/mobile/android") {}
        "/kyc/iv/activity/phone_validation"(platform: "/mobile/android") {}
        "/kyc/iv/activity/image_upload"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/landing"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/result"(platform: "/mobile/android") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/congrats"(platform: "/mobile/android") {}
        "/kyc/iv/activity/documentation_number"(platform: "/mobile/android") {}
        "/kyc/iv/activity/custom_camera"(platform: "/mobile/android") {}
        "/kyc/iv/activity/picture_confirmation"(platform: "/mobile/android") {}
    }

    test("KYC IV mobile ios") {

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/kyc/iv/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/kyc/iv/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            action_type = "internal_navigation"
        }

        "/kyc/iv/business_error"(platform: "/mobile/ios") {
            error_message = "telefono incorrecto"
        }

        "/kyc/iv/open_modal"(platform: "/mobile/ios") {
            modal_name = "iv_modal"
        }

        "/kyc/iv/modal_element_selected"(platform: "/mobile/ios") {
            modal_name = "iv_modal"
            element_selected = "V"
        }


        "/kyc/iv/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/kyc/iv/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/kyc/iv/permissions/ask"(platform: "/mobile/ios") {
            permissions = "CAMERA"
        }

        "/kyc/iv/permissions/fallback"(platform: "/mobile/ios") {
            permissions = "CAMERA"
        }

        "/kyc/iv/permissions/denied"(platform: "/mobile/ios") {
            permissions = "READ_EXTERNAL_STORAGE"
        }

        "/kyc/iv/permissions/accepted"(platform: "/mobile/ios") {
            permissions = "READ_EXTERNAL_STORAGE"
        }

        "/kyc/iv/camera_init_state"(platform: "/mobile/ios") {
            default_flash = "off"
            switch_flash= true
            default_lens = "back"
            switch_lens = true
            compression_rate = 100
            max_size = 1200
        }

        "/kyc/iv/activity/check_step"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/landing"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/phone_landing"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/phone_validation"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/image_upload"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/landing"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/result"(platform: "/mobile/ios") {
            doc_type = "front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/congrats"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/documentation_number"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/custom_camera"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/picture_confirmation"(platform: "/mobile/ios") {}
    }

    test("KYC web") {
        "/kyc/iv/landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/phone_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/phone_validation"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/documentation_front"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
            custom_cam_offered = true
        }
        "/kyc/iv/documentation_back"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
            custom_cam_offered = true
        }
        "/kyc/iv/documentation_number"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/selfie"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/congrats"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            congrats_type = "warning"
            transaction_user_id = 109479273
        }
        "/kyc/iv/continue_phone_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/kyc/iv/continue_phone_congrats"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            challenge = "documentation"
            transaction_user_id = 109479273
        }
        "/kyc/iv/detail_landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/threeds"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/company"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        
        "/kyc/iv/center/card"(platform: "/web") {
            status = "landing"
            transaction_user_id = 109479273
        }

        "/kyc/iv/center/row"(platform: "/mobile") {
            status = "landing"
        }

        "/kyc/iv/camera/open_camera"(platform: "/web") {
            devices = 2
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/open_camera"(platform: "/web") {
            devices = 2
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/capture_image"(platform: "/web") {
            is_landscape = false
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/capture_image"(platform: "/web") {
            is_landscape = false
            transaction_user_id = 109479273
        }


        "/kyc/iv/camera/pick_from_gallery"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/pick_from_gallery"(platform: "/web") {}

        "/kyc/iv/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            reason = "broken_camera"
        }

        "/kyc/iv/camera/unavailable"(platform: "/web") {}

        "/kyc/iv/camera/take_another_picture"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479272
            is_landscape = true
        }

        "/kyc/iv/camera/take_picture"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/open_camera_error"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
            error = "epic_error"
            error_reason = "permission_denied"
        }

        "/kyc/iv/camera/exit_camera"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            custom_cam_offered = true
            transaction_user_id = 109479272
            reason = "thereason"
        }
    }
}