import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    "/security_settings"(platform: "/", type: TrackType.View) {}

    "/security_settings/2fa"(platform: "/", type: TrackType.View) {}

    "/security_settings/2fa/switch"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values: ["opted_in", "opted_out"], description: "The user interacted with the two-factor authentication switch")
    }
}