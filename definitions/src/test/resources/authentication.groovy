package src.test.resources

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

    test("Abuse Prevention in Identification and Authentication") {
        "/auth/abuse_prevention"(platform: "/mobile", type: TrackType.Event) {
            result = "low"
        }
        "/auth/abuse_prevention/ban"(platform: "/web", type: TrackType.Event) {
            result = "low"
        }
        "/auth/abuse_prevention/login"(platform: "/web", type: TrackType.Event) {
            device_id = "1"
            platform = "web"
        }
        "/auth/abuse_prevention/login"(platform: "/mobile", type: TrackType.Event) {
            device_id = "1"
            platform = "mobile"
        }
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
            push_control_group_user = false
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
            tx = "tx"
            is_transaction = false
            is_otp = true
            is_admin_otp = false
        }
        "/login/auth/success"(platform: "/web", type: TrackType.Event) {
            source = "DEFAULT"
            tx = "tx"
            is_transaction = true
            is_otp = false
            is_admin_otp = false
            operator_id = null
            push_control_group_user = false
            rememberme_enabled = true
        }
        "/login/auth/success"(platform: "/mobile", type: TrackType.Event) {
            challenge = "password"
            is_otp = true
            is_admin_otp = false
            user_reg_date = "2018"
            user_points = 100
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
        "/login/auth/push"(platform: "/", type: TrackType.Event) {
            view = "waiting_view"
            event_type = "click_go_to_password_button"
            challenge = "push_authentication"
            tx = "adHgjskcD01lM6EeLs7zUGgBaA1GiWqF6w_XQUgLJk0QAmdhE"
        }
        "/logout"(platform: "/", type: TrackType.Event) {
            flow = "internal"
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
            verified = "false"
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
    }

    test("Push Notification") {
        "/auth/push_notification"(platform: "/mobile", type: TrackType.Event) {}
        "/auth/push_notification"(platform: "/mobile", type: TrackType.Event) {
            notified_user = "123"
        }
    }

    test("Multi Step Login Android") {
        "/login/auth/render"(platform: "/mobile", TrackType.View) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/render"(platform: "/mobile", TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
        }
        "/login/auth/render"(platform: "/mobile", TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/submit"(platform: "/mobile", TrackType.Event) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/submit"(platform: "/mobile", TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/cancel"(platform: "/mobile", TrackType.Event) {
            challenge = "nickname_or_email"
            tracking_id = "123"
        }
        "/login/auth/cancel"(platform: "/mobile", TrackType.Event) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
        }
        "/login/auth/error"(platform: "/mobile", TrackType.View) {
            challenge = "nickname_or_email"
            tracking_id = "123"
            errors = ["user_not_found"]
        }
        "/login/auth/error"(platform: "/mobile", TrackType.View) {
            challenge = "enter_password"
            tracking_id = "123"
            user = [nickname: "nickname", email:"email@email.com"]
            errors = ["user_not_found"]
        }
        "/login/auth/restart"(platform: "/mobile", TrackType.Event) {
            challenge = "enter_password"
        }
    }
}
