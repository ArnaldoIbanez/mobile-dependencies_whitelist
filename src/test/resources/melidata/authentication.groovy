package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Saving credentials to Smart Lock for Passwords") {
        "/login/smartlock/save_credentials"(platform: "/mobile") {}
        "/login/smartlock/save_credentials/already_saved"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/save_credentials/resolution_required"(platform: "/mobile", type: TrackType.Event) {
            success = true
        }
        "/login/smartlock/save_credentials/resolution_required"(platform: "/mobile", type: TrackType.Event) {
            success = false
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "CANCELED"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "TIMEOUT"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "NETWORK_ERROR"
        }
        "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
            status = "API_NOT_CONNECTED"
        }
    }

    test("Multiple credentials to Smart Lock for Passwords") {
        "/login/smartlock/multiple_credentials/credential_selected"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/multiple_credentials/cancel"(platform: "/mobile", type: TrackType.Event) {}
    }


    test("Logout action confirmed") {
        "/logout/modal"(platform: "/mobile") {
            action = "confirmed"
        }
    }

    test("Logout action canceled") {
        "/logout/modal"(platform: "/mobile") {
            action = "canceled"
        }
    }

    test("Login") {
        "/login/splitter"(platform: "/mobile") {
            flow = "/login"
        }
        "/login/sign_in"(platform: "/mobile") {
            flow = "/login"
        }
        "/login/sign_up"(platform: "/mobile") {
            flow = "/login"
        }
        "/login/identification"(platform: "/mobile") {
            flow = "/login"
        }
    }

    test("Login Success") {
        "/login_success"(platform: "/mobile/ios") {
        }
    }

    test("Login conversion tracks") {
        "/login"(platform: "/") {
            source = "LFE"
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            challenge = "password"
            source = "QUESTION"
            tx = "tx"
            operator_id = null
        }
        "/login/form"(platform: "/", type: TrackType.View) {
            challenge = "user"
            source = "EXPLICIT"
            tx = "tx"
            operator_id = "123"
            has_error = false
            recaptcha = false
            old_user_id = "123456"
            old_user_nick = "nick"
        }
        "/login/recovery"(platform: "/web", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/recovery"(platform: "/mobile", type: TrackType.View) {
            source = "LFE"
        }
        "/login/registration"(platform: "/", type: TrackType.Event) {
            source = "LFE"
        }
        "/login/auth/success"(platform: "/web", type: TrackType.Event) {
            source = "DEFAULT"
            tracking_id = "123"
            is_otp = true
            is_admin_otp = false
        }
        "/login/auth/success"(platform: "/web", type: TrackType.Event) {
            source = "DEFAULT"
            tracking_id = "123"
            is_otp = false
            is_admin_otp = false
            operator_id = null
            rememberme_enabled = true
        }
        "/login/auth/success"(platform: "/mobile", type: TrackType.Event) {
            challenge = "password"
            tracking_id = "123"
        }
        "/login/auth/failure"(platform: "/web", type: TrackType.Event) {
            challenge = "user"
            source = "FAVORITE"
            tx = "tx"
            reason = [error: "invalid user"]
            operator_id = null
        }
        "/login/auth/failure"(platform: "/mobile", type: TrackType.Event) {
            challenge = "user"
            is_otp = false
            is_admin_otp = true
            reason = [error: "invalid user"]
        }
        "/login/auth/challenge_success"(platform: "/web", type: TrackType.Event) {
            challenge = "pass"
            source = "QUESTION"
            tx = "tx"
            operator_id = "123"
        }
        "/login/auth/challenge_success"(platform: "/mobile", type: TrackType.Event) {
            challenge = "pass"
            is_otp = false
            is_admin_otp = false
        }
        "/login/auth/challenge/submit"(platform: "/web", type: TrackType.Event) {
            challenge = "pass"
            source = "QUESTION"
            tracking_id = "123"
            operator_id = "123"
        }
        "/login/auth/challenge/submit"(platform: "/mobile", type: TrackType.Event) {
            challenge = "pass"
            tracking_id = "123"
        }
        "/login/auth/challenge/decline"(platform: "/web", type: TrackType.View) {
            challenge = "pass"
            source = "QUESTION"
            tracking_id = "123"
        }
        "/logout"(platform: "/", type: TrackType.Event) {
            source = "MSL"
        }
    }

    test("Login Status with Smart Lock for Passwords") {
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = true
            smartlock_status = "SUCCESS"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = false
            smartlock_status = "SUCCESS"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = true
            smartlock_status = "RESOLUTION_REQUIRED"
            section = "application_startup"
        }
        "/login/status"(platform: "/mobile", type: TrackType.Event) {
            is_logged = false
            smartlock_status = "RESOLUTION_REQUIRED"
            section = "application_startup"
        }
    }

    test("Requesting credentials to Smart Lock for Passwords") {
        "/login/smartlock"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {}
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {
            attempt_type = "auto_sign_in"
        }
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {
            attempt_type = "retrieve_credentials"
        }
        "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {
            attempt_type = "multiple_credentials"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "RESOLUTION_REQUIRED"
            attempt_type = "retrieve_credentials"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "RESOLUTION_REQUIRED"
            attempt_type = "multiple_credentials"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "CANCELED"
            attempt_type = "auto_sign_in"
        }
        "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
            error = "VALIDATION_REQUIRED"
        }
    }

    test("Security feedback flow") {
        "/login/auth/feedback"(platform: "/web", type: TrackType.Event) {
            view = "answer"
            event_type = "click_go_change_pwd_button"
            view_type = "recognized"
        }
        "/login/auth/feedback"(platform: "/web", type: TrackType.Event) {
            view = "unrecognized"
            event_type = "click_go_home_button"
        }
        "/login/auth/feedback"(platform: "/web", type: TrackType.Event) {
            view = "review_login"
            event_type = "click_recongnized_button"
            notification_id = "a6bcc09b-ccef-4277-ad94"
        }
        "/login/auth/feedback"(platform: "/web", type: TrackType.Event) {
            view = "recognized"
            event_type = "render"
            phone_status = "hasPhone"
        }
    }

    test("Account recovery flow") {
        "/auth/account_recovery/landing"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/on_hold"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/confirm"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/congrats"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/landing/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "validate_identity_button"
            is_webview = true
        }
        "/auth/account_recovery/landing/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            is_webview = true
        }
        "/auth/account_recovery/on_hold/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            is_webview = true
        }
        "/auth/account_recovery/confirm/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "confirm_button"
            is_webview = true
        }
        "/auth/account_recovery/confirm/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "cancel_button"
            is_webview = true
        }
        "/auth/account_recovery/congrats/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            is_webview = true
        }
    }

    test("TOTP flow") {
        "/auth/totp/enrollment/chooser"(platform: "/", type: TrackType.View) {
            id = "id"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/congrats"(platform: "/", type: TrackType.View) {
            id = "id"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/greeting"(platform: "/", type: TrackType.View) {
            id = "id"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/scanner"(platform: "/", type: TrackType.View) {
            id = "id"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/code"(platform: "/", type: TrackType.View) {
            id = "id"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/validation"(platform: "/", type: TrackType.View) {
            id = "id"
            is_another_enroll = false
        }
        "/auth/totp/validation"(platform: "/", type: TrackType.View) {
            id = "id"
        }
        "/auth/totp/too_many_attempts"(platform: "/", type: TrackType.View) {
            id = "id"
        }
        "/auth/totp/enrollment/chooser/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            target = "config_on_this_device"
            event_type = "click"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/chooser/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            target = "config_manually"
            event_type = "click"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/congrats/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            event_type = "click"
            target = "continue"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/congrats/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            event_type = "click"
            target = "continue"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/greeting/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            event_type = "click"
            target = "continue"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/scanner/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            event_type = "click"
            target = "continue"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/code/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            event_type = "click"
            target = "continue"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/code/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            event_type = "click"
            target = "config_app_using_qr"
            is_another_enroll = false
        }
        "/auth/totp/enrollment/validation/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            event_type = "submit"
            target = "enter_code"
            is_another_enroll = false
        }
        "/auth/totp/validation/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            event_type = "submit"
            target = "enter_code"
        }
    }

    test("TOTP_IN_APP flow") {
        "/auth/totp_in_app/validation/scan"(platform: "/", type: TrackType.View) {
            id = "id"
        }
        "/auth/totp_in_app/validation/rejected"(platform: "/", type: TrackType.View) {
            id = "id"
        }
        "/auth/totp_in_app/validation/max_attempts"(platform: "/", type: TrackType.View) {
            id = "id"
        }
        "/auth/totp_in_app/validation/scan/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            status = "approved"
            event_type = "polling"
        }
        "/auth/totp_in_app/validation/rejected/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            target = "decline_challenge"
            event_type = "click"
        }
        "/auth/totp_in_app/validation/max_attempts/action"(platform: "/", type: TrackType.Event) {
            id = "id"
            target = "go_home"
            event_type = "click"
        }
    }

    test("Multi Step Login Android") {
        "/login/auth/challenge"(platform: "/mobile", type: TrackType.View) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/challenge"(platform: "/mobile", type: TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
        }
        "/login/auth/challenge"(platform: "/mobile", type: TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/challenge"(platform: "/mobile", type: TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
            flow = "login_by_phone"
            channel = "sms"
        }
        "/login/auth/error"(platform: "/mobile", type: TrackType.View) {
            error = "network"
        }
        "/login/auth/challenge/submit"(platform: "/mobile", type: TrackType.Event) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/challenge/submit"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/challenge/cancel"(platform: "/mobile", type: TrackType.Event) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/challenge/cancel"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/challenge/error"(platform: "/mobile", type: TrackType.Event) {
            challenge = "nickname_or_email"
            tracking_id = "123"
            errors = ["user_not_found"]
        }
        "/login/auth/challenge/error"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
            errors = ["user_not_found"]
        }
        "/login/auth/challenge/decline"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
        }
        "/login/auth/challenge/restart"(platform: "/mobile", type: TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
        }

        "/login/auth/phone_validation/rechallenge"(platform: "/mobile", type: TrackType.Event) {}

        "/login/auth/phone_validation/fallback"(platform: "/mobile", type: TrackType.Event) {}

        "/login/auth/phone_validation/sms_detection/autodetect_code_success"(platform: "/mobile", type: TrackType.Event) {}

        "/login/auth/phone_validation/sms_detection/autodetect_code_failure"(platform: "/mobile", type: TrackType.Event) {}
    }

    test("Device Attestation"){
        "/auth/attestation/start"(platform: "/mobile", type: TrackType.Event) {
            mode = "prefetch_only"
        }

        "/auth/attestation/start"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/request"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/created"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/reuse"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/expired"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/signature/fail"(platform: "/mobile", type: TrackType.Event) {
            reason = "quota exceeded"
        }

        "/auth/attestation/nonce/request"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/nonce/created"(platform: "/mobile", type: TrackType.Event) {}

        "/auth/attestation/nonce/fail"(platform: "/mobile", type: TrackType.Event) {
            reason = "missing vendor"
        }
    }

    test("Device Authorization - Authentication") {
        "/authenticators/device_authorization/access_request"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/access_request/fallback"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/access_answer"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/access_answer/send"(platform: "/", type: TrackType.Event) {
            status = "approved"
        }
        "/authenticators/device_authorization/access_answer/send"(platform: "/", type: TrackType.Event) {
            status = "rejected"
        }
        "/authenticators/device_authorization/access_answer/send"(platform: "/", type: TrackType.Event) {
            status = "aborted"
        }
    }

    test("Device Authorization - Enrollment") {
        "/authenticators/device_authorization/enrollment/greeting"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/enrollment/access_request"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/enrollment/access_request/fallback"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/enrollment/access_answer"(platform: "/", type: TrackType.View) {}

        "/authenticators/device_authorization/enrollment/access_answer/send"(platform: "/", type: TrackType.Event) {
          status = "approved"
        }
        "/authenticators/device_authorization/enrollment/access_answer/send"(platform: "/", type: TrackType.Event) {
          status = "aborted"
        }
        "/authenticators/device_authorization/enrollment/access_answer/send"(platform: "/", type: TrackType.Event) {
          status = "rejected"
        }

        "/authenticators/device_authorization/enrollment/congrats"(platform: "/", type: TrackType.View) {}
    }

    test("Phone Validation - Authentication") {
        "/authenticators/phone_validation/input_phone"(platform: "/", type: TrackType.View) {}

        "/authenticators/phone_validation/input_phone"(platform: "/", type: TrackType.View) {
            enrollment = true
            flow_type = "enrollment"
            flow_sub_type = "new_phone"
        }

        "/authenticators/phone_validation/input_phone/submit"(platform: "/", type: TrackType.Event) {
            phone_source = "manual"
        }

        "/authenticators/phone_validation/input_phone/submit"(platform: "/", type: TrackType.Event) {
            enrollment = true
            flow_type = "enrollment"
            flow_sub_type = "new_phone"
            phone_source = "manual"
        }

        "/authenticators/phone_validation/channel_selector"(platform: "/", type: TrackType.View) {
            status = "pending_validation"
            available_channels = ["push", "sms", "call"]
        }

        "/authenticators/phone_validation/channel_selector"(platform: "/", type: TrackType.View) {
            status = "pending_validation"
            available_channels = ["push", "sms", "call"]
            enrollment = true
            flow_type = "enrollment"
            flow_sub_type = "new_phone"
        }
        "/authenticators/phone_validation/channel_selector"(platform: "/", type: TrackType.View) {
            status = "validated"
            available_channels = ["whatsapp","sms","call"]
            enrollment = false
        }

        "/authenticators/phone_validation/channel_selector"(platform: "/mobile/android", type: TrackType.View) {
            status = "pending_validation"
            available_channels = ["sms","call"]
            enrollment = true
            flow_sub_type ="SESSION_ACTIVITY_NOTIF"
            phone_source = "input"
        }

        "/authenticators/phone_validation/channel_selector/submit"(platform: "/", type: TrackType.Event) {
            status = "pending_validation"
            available_channels = ["push", "sms", "call"]
            selected_channel = "push"
        }

        "/authenticators/phone_validation/channel_selector/submit"(platform: "/", type: TrackType.Event) {
            status = "pending_validation"
            available_channels = ["push", "sms", "call"]
            selected_channel = "push"
            enrollment = true
            flow_type = "enrollment"
            flow_sub_type = "new_phone"
        }

        "/authenticators/phone_validation/enter_code"(platform: "/", type: TrackType.View) {
            status = "pending_validation"
            available_channels = ["sms", "call"]
            selected_channel = "sms"
        }

        "/authenticators/phone_validation/enter_code"(platform: "/", type: TrackType.View) {
            status = "pending_validation"
            available_channels = ["sms", "call"]
            selected_channel = "sms"
            enrollment = true
            flow_type = "enrollment"
            flow_sub_type = "new_phone"
        }

        "/authenticators/phone_validation/enter_code"(platform: "/mobile/android", type: TrackType.View) {
            status = "pending_validation"
            available_channels = ["push","sms","call"]
            selected_channel = "push"
            enrollment = false
        }

        "/authenticators/phone_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {
            status = "success"
            available_channels = ["sms", "call"]
            selected_channel = "call"
        }

        "/authenticators/phone_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {
            status = "success"
            available_channels = ["sms", "call"]
            selected_channel = "call"
            phone_source = "manual"
            enrollment = true
            flow_type = "enrollment"
            flow_sub_type = "new_phone"
        }

        "/authenticators/phone_validation/phone_confirmation"(platform: "/", type: TrackType.View) {}

        "/authenticators/phone_validation/phone_confirmation"(platform: "/", type: TrackType.View) {
            enrollment = true
            flow_type = "enrollment"
            flow_sub_type = "new_phone"
        }

        "/authenticators/phone_validation/phone_confirmation/submit"(platform: "/", type: TrackType.Event) {
            action = "confirm"
        }

        "/authenticators/phone_validation/phone_confirmation/submit"(platform: "/", type: TrackType.Event) {
            action = "confirm"
            enrollment = true
            flow_type = "enrollment"
            flow_sub_type = "new_phone"
        }
    }

    ["mercadolibre", "mercadopago"].each { business ->

        defaultBusiness = business

        test("Phone Validation - Registration v3") {
            "/authenticators/phone_validation/input_phone"(platform: "/mobile", type: TrackType.View) {
                enrollment = false
                flow_type=  "registration_v3"
            }

            "/authenticators/phone_validation/input_phone/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "success"
            }
            "/authenticators/phone_validation/input_phone/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "user_exists"
            }
            "/authenticators/phone_validation/input_phone/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "invalid_phone_format"
            }
            "/authenticators/phone_validation/input_phone/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "empty"
            }
            "/authenticators/phone_validation/input_phone/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "server_error"
            }

            "/authenticators/phone_validation/enter_code"(platform: "/mobile", type: TrackType.View) {
                enrollment = false
                flow_type = "registration_v3"
                selected_channel = "sms"
            }

            "/authenticators/phone_validation/enter_code"(platform: "/mobile", type: TrackType.View) {
                enrollment = false
                flow_type = "registration_v3"
                selected_channel = "whatsapp"
            }

            "/authenticators/phone_validation/enter_code/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "success"
                selected_channel = "sms"
            }
            "/authenticators/phone_validation/enter_code/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "invalid_code_length"
                selected_channel = "sms"
            }
            "/authenticators/phone_validation/enter_code/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "empty"
                selected_channel = "sms"
            }
            "/authenticators/phone_validation/enter_code/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "server_error"
                selected_channel = "whatsapp"
            }
            "/authenticators/phone_validation/enter_code/submit"(platform: "/mobile", type: TrackType.Event) {
                enrollment = false
                flow_type = "registration_v3"
                validation_status = "failure"
                selected_channel = "whatsapp"
            }

            "/authenticators/phone_validation/max_attempts"(platform: "/mobile", type: TrackType.View) {
                enrollment = false
                flow_type = "registration_v3"
            }
          }

        test("Email validation - Authentication") {

            "/authenticators/email_validation/max_attempts"(platform: "/", type: TrackType.View) {}

            "/authenticators/email_validation/enter_email"(platform: "/", type: TrackType.View) {
                flow = "registration"
                client_type = "mobile"
            }

            "/authenticators/email_validation/enter_email/submit"(platform: "/", type: TrackType.Event) {
                flow = "registration"
                client_type = "mobile"
                validation_status = "success"
            }

            "/authenticators/email_validation/enter_email/submit"(platform: "/", type: TrackType.Event) {
                flow = "registration"
                client_type = "mobile"
                validation_status = "user_exists"
            }

            "/authenticators/email_validation/enter_code"(platform: "/", type: TrackType.View) {
                flow = "registration"
                client_type = "mobile"
            }

            "/authenticators/email_validation/enter_code"(platform: "/", type: TrackType.View) {
                flow = "pix"
                client_type = "mobile"
            }

            "/authenticators/email_validation/enter_code"(platform: "/", type: TrackType.View) {
                flow = "registration_v3"
                client_type = "mobile"
            }

            "/authenticators/email_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {
                flow = "registration"
                client_type = "mobile"
                validation_status = "success"
            }

            "/authenticators/email_validation/social_oauth"(platform: "/", type: TrackType.View) {
                flow = "login"
                client_type = "web"
                social_option = "Google"
            }

            "/authenticators/email_validation/social_oauth/submit"(platform: "/", type: TrackType.Event) {
                flow = "login"
                client_type = "web"
                validation_status = "success"
                social_option = "Microsoft"
                email_sign_in = false
            }
        }

        test("Biometrics / Screenlock") {
            "/screenlock/validation_start"(platform: "/mobile/android", type: TrackType.Event) {
                flow_id = "flow"
                enrollment_status = "enabled"
                os_status = "biometrics"
            }

            "/screenlock/validation_start"(platform: "/mobile/ios", type: TrackType.Event) {
                flow_id = "flow"
                enrollment_status = "disabled"
                os_status = "biometrics"
            }

            "/screenlock/validation_end"(platform: "/mobile/android", type: TrackType.Event) {
                flow_id = "flow"
                enrollment_status = "enabled"
                os_status = "biometrics"
                elapsed_time = 50
                result = "success"
                transaction_information = [
                    "amount": "100.0",
                    "type": "transactional"
                ]
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

            "/screenlock/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                flow_id = "flow"
                enrollment_status = "enabled"
                os_status = "basic_screenlock"
                elapsed_time = 50
                result = "error"
                errors = ["user_cancelled"]
                transaction_information = [
                    "amount": "0",
                    "type": "non_transactional"
                ]
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

            "/screenlock/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                flow_id = "flow"
                enrollment_status = "enabled"
                os_status = "basic_screenlock"
                elapsed_time = 50
                result = "success"
                transaction_information = [
                    "amount": "0",
                    "type": "other"
                ]
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

            "/screenlock/biometrics/failure"(platform: "/mobile/android", type: TrackType.Event) {
                os_status = "biometrics"
                error_msg_id = 501
                error_msg = "ERROR_CANT_VALIDATE"
            }

            "/screenlock/biometrics/failure"(platform: "/mobile/android", type: TrackType.Event) {
                os_status = "basic_screenlock"
                error_msg_id = 501
                error_msg = "ERROR_CANT_VALIDATE"
            }

            "/screenlock/biometrics/fallback"(platform: "/mobile/android", type: TrackType.Event) {}

            "/screenlock/security_blocker"(platform: "/mobile/ios", type: TrackType.View) {
                enrollment_status = "enabled"
                os_status = "basic_screenlock"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "single_enrolled"
            }

            "/screenlock/security_blocker"(platform: "/mobile/ios", type: TrackType.View) {
                from = "registration"
                enrollment_status = "enabled"
                os_status = "basic_screenlock"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "activate_security_success"
            }

            "/screenlock/security_blocker"(platform: "/mobile/android", type: TrackType.View) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "both_enrolled"
            }

            "/screenlock/security_blocker"(platform: "/mobile/android", type: TrackType.View) {
                from = "login"
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "auto_enroll"
            }

            "/screenlock/security_blocker"(platform: "/mobile/android", type: TrackType.View) {
                from = "campaign"
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "activate_security_success"
            }

            "/screenlock/security_blocker"(platform: "/mobile/ios", type: TrackType.View) {
                enrollment_status = "disabled"
                os_status = "basic_screenlock"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "disabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "never_auto_enrolled"
            }

            "/screenlock/security_blocker"(platform: "/mobile/android", type: TrackType.View) {
                from = "campaign"
                enrollment_status = "enabled"
                dismissible = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "activate_security_success"
            }

            "/screenlock/security_blocker"(platform: "/mobile/ios", type: TrackType.View) {
                enrollment_status = "disabled"
                os_status = "basic_screenlock"
                dismissible = "disabled"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "disabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "never_auto_enrolled"
            }

            "/screenlock/security_blocker/ok"(platform: "/mobile/android", type: TrackType.Event) {
                from = "login"
                enrollment_status = "enabled"
                dismissible = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "auto_enroll"
            }

            "/screenlock/security_blocker/ok"(platform: "/mobile/ios", type: TrackType.Event) {
                from = "login"
                enrollment_status = "enabled"
                dismissible = "disabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "auto_enroll"
            }

            "/screenlock/security_blocker/configure"(platform: "/mobile/android", type: TrackType.Event) {
                from = "login"
                enrollment_status = "enabled"
                dismissible = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "auto_enroll"
            }

            "/screenlock/security_blocker/dismiss"(platform: "/mobile/android", type: TrackType.Event) {
                from = "campaign"
                enrollment_status = "enabled"
                dismissible = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "auto_enroll"
            }

            "/screenlock/security_blocker/dismiss"(platform: "/mobile/ios", type: TrackType.Event) {
                from = "campaign"
                enrollment_status = "enabled"
                dismissible = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
                scenario = "auto_enroll"
            }

            "/screenlock/multiple_sessions_shield"(platform: "/mobile/android", type: TrackType.View) {
            }

            "/screenlock/multiple_sessions_shield"(platform: "/mobile/ios", type: TrackType.View) {
            }

        }

        test("Screenlock app opening lock feature") {

            "/screenlock/opening_lock"(platform: "/mobile/android", type: TrackType.View) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

            "/screenlock/opening_lock"(platform: "/mobile/ios", type: TrackType.View) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

            "/screenlock/opening_lock/retry"(platform: "/mobile/android", type: TrackType.Event) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

            "/screenlock/opening_lock/retry"(platform: "/mobile/ios", type: TrackType.Event) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

            "/screenlock/status"(platform: "/mobile/android", type: TrackType.Event) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

            "/screenlock/status"(platform: "/mobile/ios", type: TrackType.Event) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled",
                        "transaction_custom": "0",
                        "opening_custom": "0"
                ]
            }

        }

        test("IFPE auth restrictions") {
            "/auth/restrictions"(platform: "/", type: TrackType.View) {}
        }

        test("Reauth error page") {
            "/auth/restrictions/error"(platform: "/", type: TrackType.View) {
                retry_url_present = true
            }
        }

        test("Reauth error retry") {
            "/auth/restrictions/error/retry"(platform: "/", type: TrackType.Event) {
                retry_url_present = false
            }
        }

        test("Save Session") {
            "/login/save_login_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "sharedPreferences"
                keepnite_is_on = true
                api_version = true
            }

            "/login/save_login_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "localStorage"
                keepnite_is_on = true
                api_version = true
            }

            "/login/save_login_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "sharedPreferences"
                keepnite_is_on = false
                api_version = false
            }

            "/login/save_login_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "localStorage"
                keepnite_is_on = false
                api_version = false
            }

            "/login/save_login_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "sharedPreferences"
                keepnite_is_on = true
                api_version = false
            }

            "/login/save_login_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "localStorage"
                keepnite_is_on = false
                api_version = true
            }
        }

        test("Get Session") {
            "/login/get_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "sharedPreferences"
                keepnite_is_on = true
                api_version = true
            }

            "/login/get_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "localStorage"
                keepnite_is_on = true
                api_version = true
            }

            "/login/get_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "sharedPreferences"
                keepnite_is_on = false
                api_version = false
            }

            "/login/get_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "localStorage"
                keepnite_is_on = false
                api_version = false
            }

            "/login/get_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "sharedPreferences"
                keepnite_is_on = true
                api_version = false
            }

            "/login/get_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "localStorage"
                keepnite_is_on = false
                api_version = true
            }
        }

        test("Remove Session") {
            "/login/remove_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "both"
                keepnite_is_on = true
                api_version = true
            }

            "/login/remove_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "both"
                keepnite_is_on = true
                api_version = true
            }

            "/login/remove_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "both"
                keepnite_is_on = false
                api_version = false
            }

            "/login/remove_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "both"
                keepnite_is_on = false
                api_version = false
            }

            "/login/remove_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "both"
                keepnite_is_on = true
                api_version = false
            }

            "/login/remove_session"(platform: "/mobile", type: TrackType.Event) {
                strategy_used = "both"
                keepnite_is_on = false
                api_version = true
            }
        }

        test("Reauth Native") {
            //Validation Start
            "/native_reauth/validation_start"(platform: "/mobile/android", type: TrackType.Event) {
                reauth_mods_id = "1"
                operation_id = "1"
                flow_type = "other"
                amount = ""
            }

            "/native_reauth/validation_start"(platform: "/mobile/ios", type: TrackType.Event) {
                reauth_mods_id = "1"
                operation_id = "1"
                flow_type = "other"
                amount = ""
            }

            "/native_reauth/validation_start"(platform: "/mobile/android", type: TrackType.Event) {
                reauth_mods_id = "2"
                operation_id = "2"
                flow_type = "payment"
                amount = "10.0"
            }

            "/native_reauth/validation_start"(platform: "/mobile/ios", type: TrackType.Event) {
                reauth_mods_id = "2"
                operation_id = "2"
                flow_type = "payment"
                amount = "10.0"
            }

            //Validation End - Success
            "/native_reauth/validation_end"(platform: "/mobile/android", type: TrackType.Event) {
                reauth_mods_id = "1"
                operation_id = "1"
                flow_type = "other"
                amount = ""
                result = "success"
                transaction_id = "1"
                reauth_status = "created"
                screenlock_validated = false
            }

            "/native_reauth/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                reauth_mods_id = "1"
                operation_id = "1"
                flow_type = "other"
                amount = ""
                result = "success"
                transaction_id = "2"
                reauth_status = "created"
                screenlock_validated = false
            }

            "/native_reauth/validation_end"(platform: "/mobile/android", type: TrackType.Event) {
                reauth_mods_id = "2"
                operation_id = "2"
                flow_type = "payment"
                amount = "10.0"
                result = "success"
                transaction_id = "3"
                reauth_status = "created"
                screenlock_validated = false
            }

            "/native_reauth/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                reauth_mods_id = "2"
                operation_id = "2"
                flow_type = "payment"
                amount = "10.0"
                result = "success"
                transaction_id = "4"
                reauth_status = "created"
                screenlock_validated = false
            }

            "/native_reauth/validation_end"(platform: "/mobile/android", type: TrackType.Event) {
                reauth_mods_id = "1"
                operation_id = "1"
                flow_type = "other"
                amount = ""
                result = "success"
                reauth_status = "not_needed"
                screenlock_validated = true
            }

            "/native_reauth/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                reauth_mods_id = "1"
                operation_id = "1"
                flow_type = "other"
                amount = ""
                result = "success"
                reauth_status = "not_needed"
                screenlock_validated = true
            }

            "/native_reauth/validation_end"(platform: "/mobile/android", type: TrackType.Event) {
                reauth_mods_id = "2"
                operation_id = "2"
                flow_type = "payment"
                amount = "10.0"
                result = "success"
                reauth_status = "not_needed"
                screenlock_validated = true
            }

            "/native_reauth/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                reauth_mods_id = "2"
                operation_id = "2"
                flow_type = "payment"
                amount = "10.0"
                result = "success"
                reauth_status = "not_needed"
                screenlock_validated = true
            }


            //Validation End - Error
            "/native_reauth/validation_end"(platform: "/mobile/android", type: TrackType.Event) {
                reauth_mods_id = "1"
                operation_id = "1"
                flow_type = "other"
                amount = ""
                result = "error"
                errors = ["Ups error :S"]
                reauth_status = "error"
                screenlock_validated = false
            }

            "/native_reauth/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                reauth_mods_id = "1"
                operation_id = "1"
                flow_type = "other"
                amount = ""
                result = "error"
                errors = ["Ups error :S"]
                reauth_status = "error"
                screenlock_validated = false
            }

            "/native_reauth/validation_end"(platform: "/mobile/android", type: TrackType.Event) {
                reauth_mods_id = "2"
                operation_id = "2"
                flow_type = "payment"
                amount = "10.0"
                result = "error"
                errors = ["Ups error :S"]
                reauth_status = "error"
                screenlock_validated = false
            }

            "/native_reauth/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                reauth_mods_id = "2"
                operation_id = "2"
                flow_type = "payment"
                amount = "10.0"
                result = "error"
                errors = ["Ups error :S"]
                reauth_status = "error"
                screenlock_validated = false
            }

        }
    }
}
