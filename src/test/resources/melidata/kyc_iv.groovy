package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("KYC IV mobile android") {

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "none"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "permission"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "landing"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "landing_vanilla"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "landing_error"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "camera"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "confirmation"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "uploading"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "result"
        }

        "/kyc/iv/challenge_time"(platform: "/mobile") {
            challenge_type = "doc_front"
            challenge_time = 24000
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
            permission = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/fallback"(platform: "/mobile/android") {
            permission = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/denied"(platform: "/mobile/android") {
            permission = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/accepted"(platform: "/mobile/android") {
            permission = "{android.permission.READ_EXTERNAL_STORAGE}"
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
            initiative = "iv-initiative"
            challenge_id = 123456789
        }

        "/kyc/iv/proof_of_life_gesture"(platform: "/mobile") {
            gestures_probabilities = [
                left_eye: 0.99,
                right_eye: 0.98
            ]
            gesture = "open_eye"
            challenge_id = 123456789
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
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/landing"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/result"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/congrats"(platform: "/mobile/android") {}
        "/kyc/iv/activity/documentation_number"(platform: "/mobile/android") {}
        "/kyc/iv/activity/custom_camera"(platform: "/mobile/android") {}
        "/kyc/iv/activity/custom_camera/permission"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }

        "/kyc/iv/object_detection/model_download"(platform: "/mobile/android")  {
            success = true
            model_name = "test"
            time = 141231
        }
        "/kyc/iv/object_detection/validation"(platform: "/mobile/android")  {
            validation = "ok"
            value = "detection OK"
        }
        "/kyc/iv/object_detection/error"(platform: "/mobile/android")  {
            error = "error al descargar"
        }

        "/kyc/iv/activity/custom_camera/error"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/landing"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/camera"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/preview"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/uploading"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/result"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/picture_confirmation"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/liveness"(platform: "/mobile/android") {}
    }

    test("KYC IV mobile ios") {

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/kyc/iv/challenge_time"(platform: "/mobile") {
            challenge_type = "doc_front"
            challenge_time = 24000
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

        "/kyc/iv/object_detection/model_download"(platform: "/mobile/ios")  {
            success = true
            model_name = "test"
            time = 141231
        }
        "/kyc/iv/object_detection/validation"(platform: "/mobile/ios")  {
            validation = "aspect_ratio"
            value = "1.3"
        }
        "/kyc/iv/object_detection/error"(platform: "/mobile/ios")  {
            error = "error al descargar"
        }

        "/kyc/iv/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/kyc/iv/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/kyc/iv/permissions/ask"(platform: "/mobile/ios") {
            permission = "CAMERA"
        }

        "/kyc/iv/permissions/fallback"(platform: "/mobile/ios") {
            permission = "CAMERA"
        }

        "/kyc/iv/permissions/denied"(platform: "/mobile/ios") {
            permission = "READ_EXTERNAL_STORAGE"
        }

        "/kyc/iv/permissions/accepted"(platform: "/mobile/ios") {
            permission = "READ_EXTERNAL_STORAGE"
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
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/landing"(platform: "/mobile/ios") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile/ios") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/result"(platform: "/mobile/ios") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/congrats"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/documentation_number"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/custom_camera"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/custom_camera/permission"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/error"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/landing"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/camera"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/preview"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/uploading"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/result"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/picture_confirmation"(platform: "/mobile/ios") {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/liveness"(platform: "/mobile/ios") {}
    }

    test("KYC IV web") {
        "/kyc/iv/landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }

        "/kyc/iv/challenge_time"(platform: "/web") {
            challenge_type = "doc_front"
            challenge_time = 24000
        }

        "/kyc/iv/phone_landing"(platform: "/") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/phone_validation"(platform: "/") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/documentation_front"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }
        "/kyc/iv/documentation_back"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
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
        "/kyc/iv/image_upload"(platform: "/web") {
            flow = "credits_address"
            transaction_user_id = 109479273
            doc_type = "address"
        }
        "/kyc/iv/center/card"(platform: "/web") {
            status = "landing"
            transaction_user_id = 109479273
        }

        "/kyc/iv/vanilla"(platform: "/") {
            vanilla_document_id = "passport"
            transaction_user_id = 109479273
        }

        "/kyc/iv/center/row"(platform: "/mobile") {
            status = "landing"
        }

        "/kyc/iv/camera/open_camera"(platform: "/web") {
            devices = 2
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/open_camera"(platform: "/web") {
            devices = 2
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/capture_image"(platform: "/web") {
            is_landscape = false
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/capture_image"(platform: "/web") {
            is_landscape = false
            transaction_user_id = 109479273
        }


        "/kyc/iv/camera/pick_from_gallery"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/pick_from_gallery"(platform: "/web") {}

        "/kyc/iv/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            reason = "broken_camera"
        }

        "/kyc/iv/camera/unavailable"(platform: "/web") {}

        "/kyc/iv/camera/take_another_picture"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479272
            is_landscape = true
        }

        "/kyc/iv/camera/take_picture"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/open_camera_error"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            error = "epic_error"
            error_reason = "permission_denied"
        }

        "/kyc/iv/camera/exit_camera"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/cc_scan/landing"(platform: "/web") { 
            flow = "ss_cc_scan"
            transaction_user_id = 109479273 
        }

        "/kyc/iv/cc_scan/start_camera"(platform: "/web") {  
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/cc_scan/start_scan"(platform: "/web") {  
            flow = "ss_cc_scan"
            transaction_user_id = 109479273 
        }

        "/kyc/iv/cc_scan/scan_error"(platform: "/web") {  
            error_reason = "Wrong card issuer"
            flow = "ss_cc_scan"
            transaction_user_id = 109479273 
        }

        "/kyc/iv/cc_scan/upload_image"(platform: "/web") {  
            flow = "ss_cc_scan"
            transaction_user_id = 109479273 
        }

        "/kyc/iv/documentation/uploader_change"(platform: "/") {
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/documentation/select_option"(platform: "/web/desktop") {
            flow = "flow_doc"
            option = "continue_from_desktop"
            transaction_user_id = 109479273
        }

        "/kyc/iv/documentation/uploader_click"(platform: "/") {
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479272
            reason = "thereason"
        }
        "/kyc/iv/trust_vote_recommender"(platform: "/") {
            flow = "poc_trust_vote_tc"
            transaction_user_id = 109479273
        }
        "/kyc/iv/trust_vote_recommendation"(platform: "/web") {
            flow = "poc_trust_vote_tc"
            transaction_user_id = 109479273
        }
        "/kyc/iv/error_page"(platform: "/web") {
            flow = "poc_trust_vote_tc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/handoff"(platform: "/web") {
            flow = "poc_trust_vote_tc"
            transaction_user_id = 109479273
            url = "https://www.mercadolibre.com.ar"
            challenge = "documentation"
            handoff_type = "user_swap"
        }
    }

    defaultBusiness = "mercadopago"

    test("KYC IV mobile android") {

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/kyc/iv/step_time"(platform: "/mobile") {
            step_time = 10000
            step_name = "none"
        }

        "/kyc/iv/challenge_time"(platform: "/mobile") {
            challenge_type = "doc_front"
            challenge_time = 24000
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
            permission = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/fallback"(platform: "/mobile/android") {
            permission = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/denied"(platform: "/mobile/android") {
            permission = "{android.permission.READ_EXTERNAL_STORAGE}"
        }

        "/kyc/iv/permissions/accepted"(platform: "/mobile/android") {
            permission = "{android.permission.READ_EXTERNAL_STORAGE}"
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
            initiative = "iv-initiative"
            challenge_id = 123456789
        }

        "/kyc/iv/proof_of_life_gesture"(platform: "/mobile") {
            gesture = "open_eye"
            gestures_probabilities = [
                left_eye: 0.99,
                right_eye: 0.98
            ]
        }

        "/kyc/iv/object_detection/model_download"(platform: "/mobile/android")  {
            success = true
            model_name = "test"
            time = 141231
        }
        "/kyc/iv/object_detection/validation"(platform: "/mobile/android")  {
            validation = "aspect_ratio"
            value = "1.3"
        }
        "/kyc/iv/object_detection/error"(platform: "/mobile/android")  {
            error = "error al descargar"
        }

        "/kyc/iv/activity/check_step"(platform: "/mobile/android") {}
        "/kyc/iv/activity/landing"(platform: "/mobile/android") {}
        "/kyc/iv/activity/phone_landing"(platform: "/mobile/android") {}
        "/kyc/iv/activity/phone_validation"(platform: "/mobile/android") {}
        "/kyc/iv/activity/image_upload"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/landing"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/result"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/congrats"(platform: "/mobile/android") {}
        "/kyc/iv/activity/documentation_number"(platform: "/mobile/android") {}
        "/kyc/iv/activity/custom_camera"(platform: "/mobile/android") {}

        "/kyc/iv/activity/custom_camera/permission"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/error"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/landing"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/camera"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/preview"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/uploading"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/result"(platform: "/mobile/android")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/picture_confirmation"(platform: "/mobile/android") {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/liveness"(platform: "/mobile/android") {}
    }

    test("KYC IV mobile ios") {

        "/kyc/iv/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            extra_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/kyc/iv/challenge_time"(platform: "/mobile") {
            challenge_type = "doc_front"
            challenge_time = 24000
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

        "/kyc/iv/object_detection/model_download"(platform: "/mobile/ios")  {
            success = true
            model_name = "test"
            time = 141231
        }
        "/kyc/iv/object_detection/validation"(platform: "/mobile/ios")  {
            validation = "aspect_ratio"
            value = "1.3"
        }
        "/kyc/iv/object_detection/error"(platform: "/mobile/ios")  {
            error = "error al descargar"
        }

        "/kyc/iv/unsupported_deeplink"(platform: "/mobile") {
            unsupported_deeplink = "meli://unsupported_deeplink"
        }

        "/kyc/iv/executed_camera_action"(platform: "/mobile") {
            executed_camera_action = "action"
        }

        "/kyc/iv/permissions/ask"(platform: "/mobile/ios") {
            permission = "CAMERA"
        }

        "/kyc/iv/permissions/fallback"(platform: "/mobile/ios") {
            permission = "CAMERA"
        }

        "/kyc/iv/permissions/denied"(platform: "/mobile/ios") {
            permission = "READ_EXTERNAL_STORAGE"
        }

        "/kyc/iv/permissions/accepted"(platform: "/mobile/ios") {
            permission = "READ_EXTERNAL_STORAGE"
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
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/landing"(platform: "/mobile/ios") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/uploading"(platform: "/mobile/ios") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/image_upload/result"(platform: "/mobile/ios") {
            doc_type = "doc_front"
            model_id = "documentation_front"
        }
        "/kyc/iv/activity/congrats"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/documentation_number"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/custom_camera"(platform: "/mobile/ios") {}
        "/kyc/iv/activity/custom_camera/permission"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/error"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/landing"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/camera"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/preview"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/uploading"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/custom_camera/result"(platform: "/mobile/ios")  {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/picture_confirmation"(platform: "/mobile/ios") {
            doc_type = "doc_front"
            model_id = "documentation"
        }
        "/kyc/iv/activity/liveness"(platform: "/mobile/ios") {}
    }

    test("KYC web") {
        "/kyc/iv/landing"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
        }

        "/kyc/iv/challenge_time"(platform: "/web") {
            challenge_type = "doc_front"
            challenge_time = 24000
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
        }
        "/kyc/iv/documentation_back"(platform: "/web") {
            flow = "ss_approve_iv_selfie"
            transaction_user_id = 109479273
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
        "/kyc/iv/image_upload"(platform: "/web") {
            flow = "address_company"
            transaction_user_id = 109479273
            doc_type = "address_company"
        }
        "/kyc/iv/trust_vote_recommender"(platform: "/") {
            flow = "poc_trust_vote_tc"
            transaction_user_id = 109479273
        }
        "/kyc/iv/trust_vote_recommendation"(platform: "/web") {
            flow = "poc_trust_vote_tc"
            transaction_user_id = 109479273
        }
        "/kyc/iv/error_page"(platform: "/web") {
            flow = "poc_trust_vote_tc"
            transaction_user_id = 109479273
        }
        
        "/kyc/iv/center/card"(platform: "/web") {
            status = "landing"
            transaction_user_id = 109479273
        }

        "/kyc/iv/vanilla"(platform: "/web") {
            vanilla_document_id = "passport"
            transaction_user_id = 109479273
        }

        "/kyc/iv/center/row"(platform: "/mobile") {
            status = "landing"
        }

        "/kyc/iv/camera/open_camera"(platform: "/web") {
            devices = 2
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/open_camera"(platform: "/web") {
            devices = 2
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/capture_image"(platform: "/web") {
            is_landscape = false
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/capture_image"(platform: "/web") {
            is_landscape = false
            transaction_user_id = 109479273
        }


        "/kyc/iv/camera/pick_from_gallery"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/pick_from_gallery"(platform: "/web") {}

        "/kyc/iv/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            reason = "broken_camera"
        }

        "/kyc/iv/camera/unavailable"(platform: "/web") {}

        "/kyc/iv/camera/take_another_picture"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/change_camera"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479272
            is_landscape = true
        }

        "/kyc/iv/camera/take_picture"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            is_landscape = false
        }

        "/kyc/iv/camera/open_camera_error"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
            error = "epic_error"
            error_reason = "permission_denied"
        }

        "/kyc/iv/camera/exit_camera"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/cc_scan/landing"(platform: "/web") { 
            flow = "ss_cc_scan"
            transaction_user_id = 109479273 
        }

        "/kyc/iv/cc_scan/start_camera"(platform: "/web") {  
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/cc_scan/start_scan"(platform: "/web") {  
            flow = "ss_cc_scan"
            transaction_user_id = 109479273 
        }

        "/kyc/iv/cc_scan/scan_error"(platform: "/web") {  
            error_reason = "Wrong card issuer"
            flow = "ss_cc_scan"
            transaction_user_id = 109479273 
        }

        "/kyc/iv/cc_scan/upload_image"(platform: "/web") {  
            flow = "ss_cc_scan"
            transaction_user_id = 109479273 
        }

        "/kyc/iv/documentation/uploader_change"(platform: "/") {
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/documentation/select_option"(platform: "/web/desktop") {
            flow = "flow_doc"
            option = "continue_from_desktop"
            transaction_user_id = 109479273
        }

        "/kyc/iv/documentation/uploader_click"(platform: "/") {
            flow = "flow_doc"
            transaction_user_id = 109479273
        }

        "/kyc/iv/camera/unavailable"(platform: "/web") {
            flow = "flow_doc"
            transaction_user_id = 109479272
            reason = "thereason"
        }

        "/kyc/iv/handoff"(platform: "/web") {
            flow = "documentation"
            transaction_user_id = 109479273
            url = "https://www.mercadolibre.com.ar"
            challenge = "documentation"
            handoff_type = "no_camera"
        }
    }
}