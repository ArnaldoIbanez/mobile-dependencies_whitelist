package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1144"

    "/sentry"(platform: "/", isAbstract: true) {}

    "/sentry/update_browser"(platform: "/", type: TrackType.View) {}

    "/sentry/update_browser/download_intention"(platform: "/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "Label name", values: ["chrome", "edge", "firefox"])
    }

    "/sentry/update_browser/download_reject"(platform: "/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "Label name", values: ["not_now"])
    }
}