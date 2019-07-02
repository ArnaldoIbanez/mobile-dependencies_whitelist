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
        context(type: PropertyType.String, required: true, inheritable: false, description: "Point of access of change password view")
    }

    "/security_settings/password/success"(platform: "/", type: TrackType.Event) {
        password_security(type: PropertyType.Numeric, required: true, description: "Level of security of the new password")
    }
}
