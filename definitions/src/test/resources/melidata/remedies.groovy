package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("Remedies mobile android") {

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            deeplink_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/remedies/business_error"(platform: "/mobile/android") {
            error_message = "telefono incorrecto"
            api_call_identificator = 1
        }

        "/remedies/failure_api_call"(platform: "/mobile") {
            error_message = "NullPointerException"
            error_cause = "NullPointerException"
            exception = "NullPointerException"
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

    defaultBusiness = "mercadopago"

    test("Remedies mobile android") {

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            deeplink_params = "meli://identity_validation/?flow=uniqueness"
        }

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "start_validation"
        }

        "/remedies/resolve_model"(platform: "/mobile") {
            model_id = "landing"
            deeplink = "meli://identity_validation/landing"
            action_type = "internal_navigation"
        }

        "/remedies/business_error"(platform: "/mobile/android") {
            error_message = "telefono incorrecto"
            api_call_identificator = 1
        }

        "/remedies/failure_api_call"(platform: "/mobile") {
            error_message = "NullPointerException"
            error_cause = "NullPointerException"
            exception = "NullPointerException"
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

}
