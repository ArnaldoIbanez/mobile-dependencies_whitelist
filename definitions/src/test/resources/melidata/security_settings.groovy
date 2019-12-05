import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("Security Settings") {
        "/security_settings"(platform: "/", type: TrackType.View) {}

        "/security_settings/2fa"(platform: "/", type: TrackType.View) {}

        "/security_settings/2fa/switch"(platform: "/", type: TrackType.Event) {
            status = "opted_in"
        }
    }

    test("Devices Admin") {
        "/security_settings/devices"(platform: "/", type: TrackType.View) {}

        "/security_settings/devices/action"(platform: "/", type: TrackType.Event) {
            event_type = "click"
            target = "unlink_button"
        }

        "/security_settings/devices/action"(platform: "/", type: TrackType.Event) {
            event_type = "click"
            target = "confirm_unlink_button"
        }
    }

    test("Change Password") {
        "/security_settings/password"(platform: "/", type: TrackType.View) {
            context = "feedback"
        }

        "/security_settings/password"(platform: "/", type: TrackType.View) {
            context = "security_settings"
        }

        "/security_settings/password/maxlength"(platform: "/", type: TrackType.Event) {
            context = "feedback"
        }

        "/security_settings/password/maxlength"(platform: "/", type: TrackType.Event) {
            context = "security_settings"
        }

        "/security_settings/password/success"(platform: "/", type: TrackType.Event) {
            context = "forgot"
            delete_sessions = false
            lowend = true
        }

        "/security_settings/password/success"(platform: "/", type: TrackType.Event) {
            context = "feedback"
            delete_sessions = true
        }
    }

    test("Screenlock settings") {
        "/security_settings/screenlock"(platform: "/mobile/android", type: TrackType.View) {
            os_status = "biometrics"
            enrollment_status = "enabled"
            config = [
                "transaction": "enabled",
                "opening_lock": "disabled"
            ]
        }

        "/security_settings/screenlock"(platform: "/mobile/ios", type: TrackType.View) {
            os_status = "basic_screenlock"
            enrollment_status = "enabled"
            config = [
                "transaction": "disabled",
                "opening_lock": "enabled"
            ]
        }

        "/security_settings/screenlock/toggle"(platform: "/mobile/android", type: TrackType.Event) {
            enrollment_status = "enabled"
            os_status = "biometrics"
            config_name = "transaction"
            action = "enable"
            config = [
                "transaction": "disabled",
                "opening_lock": "enabled"
            ]
        }

        "/security_settings/screenlock/toggle"(platform: "/mobile/ios", type: TrackType.Event) {
            enrollment_status = "enabled"
            os_status = "biometrics"
            config_name = "opening_lock"
            action = "disable"
            config = [
                "transaction": "disabled",
                "opening_lock": "enabled"
            ]
        }

        "/security_settings/screenlock/toggle"(platform: "/mobile/android", type: TrackType.Event) {
            enrollment_status = "disabled"
            os_status = "biometrics"
            config_name = "opening_lock"
            action = "enable"
            config = [
                "transaction": "disabled",
                "opening_lock": "enabled"
            ]
        }

        "/security_settings/screenlock/toggle"(platform: "/mobile/ios", type: TrackType.Event) {
            enrollment_status = "disabled"
            os_status = "biometrics"
            config_name = "transaction"
            action = "disable"
            config = [
                "transaction": "disabled",
                "opening_lock": "enabled"
            ]
        }

                "/security_settings/screenlock/toggle/modal"(platform: "/mobile/android", type: TrackType.Event) {
            enrollment_status = "enabled"
            os_status = "biometrics"
            config_name = "opening_lock"
            action = "disable"
            config = [
                "transaction": "disabled",
                "opening_lock": "enabled"
            ]
        }

        "/security_settings/screenlock/toggle/modal"(platform: "/mobile/ios", type: TrackType.Event) {
            enrollment_status = "enabled"
            os_status = "biometrics"
            config_name = "transaction"
            action = "disable"
            config = [
                "transaction": "enabled",
                "opening_lock": "disabled"
            ]
        }

        "/security_settings/screenlock/toggle/modal"(platform: "/mobile/android", type: TrackType.Event) {
            enrollment_status = "disabled"
            os_status = "biometrics"
            config_name = "transaction"
            action = "disable"
            config = [
                "transaction": "enabled",
                "opening_lock": "disabled"
            ]
        }

        "/security_settings/screenlock/toggle/modal"(platform: "/mobile/ios", type: TrackType.Event) {
            enrollment_status = "disabled"
            os_status = "biometrics"
            config_name = "transaction"
            action = "disable"
            config = [
                "transaction": "enabled",
                "opening_lock": "disabled"
            ]
        }

        "/security_settings/screenlock/toggle/modal/confirmation"(platform: "/mobile/android", type: TrackType.Event) {
            enrollment_status = "enabled"
            os_status = "biometrics"
            config_name = "opening_lock"
            action = "disable"
            config = [
                "transaction": "disabled",
                "opening_lock": "enabled"
            ]
        }

        "/security_settings/screenlock/toggle/modal/confirmation"(platform: "/mobile/ios", type: TrackType.Event) {
            enrollment_status = "enabled"
            os_status = "biometrics"
            config_name = "transaction"
            action = "disable"
            config = [
                "transaction": "enabled",
                "opening_lock": "disabled"
            ]
        }

        "/security_settings/screenlock/toggle/modal/confirmation"(platform: "/mobile/android", type: TrackType.Event) {
            enrollment_status = "disabled"
            os_status = "biometrics"
            config_name = "transaction"
            action = "disable"
            config = [
                "transaction": "enabled",
                "opening_lock": "disabled"
            ]
        }

        "/security_settings/screenlock/toggle/modal/confirmation"(platform: "/mobile/ios", type: TrackType.Event) {
            enrollment_status = "disabled"
            os_status = "biometrics"
            config_name = "transaction"
            action = "disable"
            config = [
                "transaction": "enabled",
                "opening_lock": "disabled"
            ]
        }
    }
}
