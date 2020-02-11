package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1096"

    /**
    * Dynamic Links Tracks
    */

    "/dynamiclink"(platform: "/mobile", isAbstract: true) {}

    // Dynamic Links Events
    "/dynamiclink/url-opened"(platform: "/mobile", type: TrackType.Event) {
        url(required: true, type: PropertyType.String, description: "url opened")
    }

    "/dynamiclink/link"(platform: "/mobile", isAbstract: true) {}

    "/dynamiclink/link/success"(platform: "/mobile", type: TrackType.Event) {
        url(required: true, type: PropertyType.String, description: "url opened success")
    }
    "/dynamiclink/link/failed"(platform: "/mobile", type: TrackType.Event) {}
}
