package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1144"

    "/sentry"(platform: "/", isAbstract: true) {}

    "/sentry/update_browser"(platform: "/", type: TrackType.View) {}

    "/sentry/update_browser"(platform: "/", type: TrackType.Event) {
        category(required: true, type: PropertyType.String, description: "Event category")
        label(required: true, type: PropertyType.String, description: "Event label")
        action(required: true, type: PropertyType.String, description: "Event action")
    }
}