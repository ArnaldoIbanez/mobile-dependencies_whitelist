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
        "/login/auth/challenge_decline"(platform: "/", type: TrackType.View) {
            challenge = "pass"
            source = "QUESTION"
            tx = "tx"
            operator_id = null
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

    test("App authorization tracks") {
        "/oauth/authorization/form"(platform: "/", type: TrackType.Event) {
            source = "LFE"
        }
        "/oauth/authorization/form/access"(platform: "/", type: TrackType.Event) {
            source = "LFE"
            authorize = true
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
        "/auth/account_recovery/congrats"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/landing"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/phone_number_verification"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/on_hold"(platform: "/web", type: TrackType.View) {
            id = "id--fury"
            is_webview = true
        }
        "/auth/account_recovery/congrats/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
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
        "/auth/account_recovery/phone_number_verification/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "continue_button"
            is_webview = true
        }
        "/auth/account_recovery/on_hold/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            status_code = "429"
            is_webview = true
        }
        "/auth/account_recovery/on_hold/action"(platform: "/web", type: TrackType.Event) {
            id = "id--fury"
            event_type = "click"
            target = "go_home_button"
            status_code = "403"
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

    test("Phone Enrollment flow") {
        "/auth/recovery/phone/registration"(platform: "/web", type: TrackType.Event) {
            redirect_url = 'www.mercadolibre.com'
            flow_type = 'sms_enrollment'
            flow_sub_type = 'ULTIMATUM'
        }
        "/auth/recovery/phone/save"(platform: "/web", type: TrackType.Event) {
            redirect_url = "www.mercadolibre.com"
            selected_phone_source = "manual"
            verified = false
            flow_type = "sms_enrollment"
            flow_sub_type = "LOGIN"
            visual_validation_allowed = true
        }
        "/auth/recovery/phone/verified"(platform: "/web", type: TrackType.Event) {
            redirect_url = "www.mercadolibre.com"
            selected_phone_source = "manual"
            flow_type = "sms_enrollment"
            flow_sub_type = "LOGIN_NOTIF"
        }
        "/auth/phone_confirmation"(platform: "/", type: TrackType.Event) {
            event = "confirm"
        }
    }

    test("Push Notification") {
        "/auth/push_notification"(platform: "/mobile", type: TrackType.Event) {}
        "/auth/push_notification"(platform: "/mobile", type: TrackType.Event) {
            notified_user = "123"
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

    test("Authenticators") {
        "/auth/authentication_factors/sms"(platform: "/web", type: TrackType.Event) {
            event = "method_selector"
            flow_type = 'sms_enrollment'
            risk_context = false
            reauthentication = false
            sms_option = true
            call_option = true
            push_option = false
            option_selected = "sms"
            authenticator = "phoneValidation"
        }
        "/auth/authentication_factors/primary_email"(platform: "/web", type: TrackType.Event) {
            event = "start_validation"
            flow_type = 'sms_enrollment'
            risk_context = true
            reauthentication = true
            option_selected = "primary_email"
            primary_email_option = true
            domain = "gmail"
            authenticator = "emailValidation"
            email_id = "123465789"
        }
        "/auth/authentication_factors/social_connect"(platform: "/web", type: TrackType.Event) {
            event = "close_validation"
            flow_type = 'sms_enrollment'
            risk_context = true
            reauthentication = false
            option_selected = "microsoft_connect"
            google_connect_option = true
            domain = "gmail"
            is_google_account_of_different_user = "false"
            authenticator = "emailValidation"
        }
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
            status = "approve"
        }
    }

    test("Device Authorization - Enrollment") {
        "/authenticators/device_authorization/enrollment/greeting"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }

        "/authenticators/device_authorization/enrollment/access_request"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }

        "/authenticators/device_authorization/enrollment/access_request/fallback"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }

        "/authenticators/device_authorization/enrollment/access_answer"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }

        "/authenticators/device_authorization/enrollment/access_answer/send"(platform: "/", type: TrackType.Event) {
            section = "security_settings"
            status = "approve"
        }

        "/authenticators/device_authorization/enrollment/congrats"(platform: "/", type: TrackType.View) {
            section = "security_settings"
        }
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

        test("Email validation - Authentication") {

            "/authenticators/email_validation/max_attempts"(platform: "/", type: TrackType.View) {}

            "/authenticators/email_validation/enter_code"(platform: "/", type: TrackType.View) {}

            "/authenticators/email_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {
                validation_status = "success"
            }

            "/authenticators/email_validation/social_oauth"(platform: "/", type: TrackType.View) {
                social_option = "Google"
            }

            "/authenticators/email_validation/social_oauth/submit"(platform: "/", type: TrackType.Event) {
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
            }

            "/screenlock/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                flow_id = "flow"
                enrollment_status = "enabled"
                os_status = "basic_screenlock"
                elapsed_time = 50
                result = "error"
                errors = ["user_cancelled"]
            }

            "/screenlock/validation_end"(platform: "/mobile/ios", type: TrackType.Event) {
                flow_id = "flow"
                enrollment_status = "enabled"
                os_status = "basic_screenlock"
                elapsed_time = 50
                result = "success"
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

            "/screenlock/security_blocker"(platform: "/mobile/ios", type: TrackType.Event) {
                enrollment_status = "enabled"
                os_status = "basic_screenlock"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled"
                ]
                scenario = "single_enrolled"
            }

            "/screenlock/security_blocker"(platform: "/mobile/android", type: TrackType.Event) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "enabled"
                ]
                scenario = "both_enrolled"
            }

            "/screenlock/security_blocker"(platform: "/mobile/ios", type: TrackType.Event) {
                enrollment_status = "disabled"
                os_status = "basic_screenlock"
                config = [
                        "transaction": "enabled",
                        "opening_lock": "disabled"
                ]
                scenario = "never_auto_enrolled"
            }
        }

        test("Screenlock app opening lock feature") {

            "/screenlock/opening_lock"(platform: "/mobile/android", type: TrackType.View) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled"
                ]
            }

            "/screenlock/opening_lock"(platform: "/mobile/ios", type: TrackType.View) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled"
                ]
            }

            "/screenlock/opening_lock/retry"(platform: "/mobile/android", type: TrackType.Event) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled"
                ]
            }

            "/screenlock/opening_lock/retry"(platform: "/mobile/ios", type: TrackType.Event) {
                enrollment_status = "enabled"
                os_status = "biometrics"
                config = [
                        "transaction": "disabled",
                        "opening_lock": "enabled"
                ]
            }

        }
    }
}
