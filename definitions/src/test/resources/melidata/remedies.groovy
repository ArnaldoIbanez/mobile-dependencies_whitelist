package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("Remedies mobile android") {

        "/remedies/executed_action"(platform: "/mobile") {
            executed_action = "check_step"
            deeplink_params = "meli://identity_validation/?flow=uniqueness"
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

        "/remedies/activity/check_step"(platform: "/mobile/android") {}
        "/remedies/activity/landing"(platform: "/mobile/android") {}
        "/remedies/activity/phone_landing"(platform: "/mobile/android") {}
        "/remedies/activity/phone_validation"(platform: "/mobile/android") {}
        "/remedies/activity/image_upload"(platform: "/mobile/android") {}
        "/remedies/activity/congrats"(platform: "/mobile/android") {}
        "/remedies/activity/documentation_number"(platform: "/mobile/android") {}
        "/remedies/activity/custom_camera"(platform: "/mobile/android") {}
        "/remedies/activity/picture_confirmation"(platform: "/mobile/android") {}
    }

}
