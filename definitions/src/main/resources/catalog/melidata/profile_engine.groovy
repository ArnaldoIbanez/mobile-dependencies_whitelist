import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/profile_check" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/profile_check/landing" (platform: "/mobile", type: TrackType.View) {}
    "/profile_check/image-upload" (platform: "/mobile", type: TrackType.View) {}
    "/profile_check/branding" (platform: "/mobile", type: TrackType.View) {}
    "/profile_check/soft-descriptor" (platform: "/mobile", type: TrackType.View) {}
    "/profile_check/mcc" (platform: "/mobile", type: TrackType.View) {}
    "/profile_check/store" (platform: "/mobile", type: TrackType.View) {}
    "/profile_check/congrats" (platform: "/mobile", type: TrackType.View) {}

    // Events

    "/profile_check/landing/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
    }

}