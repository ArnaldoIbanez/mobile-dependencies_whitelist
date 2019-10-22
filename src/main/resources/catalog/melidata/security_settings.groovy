package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    // Security Settings
    "/security_settings"(platform: "/", type: TrackType.View) {}

    "/security_settings/2fa"(platform: "/", type: TrackType.View) {}

    "/security_settings/2fa/switch"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values: ["opted_in", "opted_out"], description: "The user interacted with the two-factor authentication switch")
    }

    // Devices Admin
    "/security_settings/devices"(platform: "/", type: TrackType.View) {}

    "/security_settings/devices/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: true, values: ["click"], description: "User clicked a button in the Devices Admin page")
        target(type: PropertyType.String, required: true, values: ["unlink_button", "confirm_unlink_button"], description: "Button clicked by the user in the Devices Admin page")
    }

    // Change Password
    "/security_settings/password"(platform: "/", type: TrackType.View) {
        context(type: PropertyType.String, required: true, description: "Point of access of change password view")
    }

    "/security_settings/password/maxlength"(platform: "/", type: TrackType.Event) {}

    "/security_settings/password/success"(platform: "/", type: TrackType.Event) {
        delete_sessions(type: PropertyType.Boolean, required: true, description: "Whether the user chose to delete sessions or not")
        lowend(type: PropertyType.Boolean, required: false, description: "Whether the user accessed from a lowend device or not")
    }

    // Biometrics
    "/security_settings/screenlock"(platform: "/mobile", type: TrackType.View) {
        os_status(type: PropertyType.String, required: true, values: ["biometrics", "basic_screenlock"], description: "Screenlock Operating System status upon view")
        enrollment_status(type: PropertyType.String, required: true, values: ["enabled", "disabled"], description: "Enrollment status")
    }

    "/security_settings/screenlock/toggle"(platform: "/mobile", type: TrackType.Event) { }
}
