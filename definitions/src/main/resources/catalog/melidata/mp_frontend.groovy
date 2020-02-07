import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1074'

    "/activity_detail"(platform: "/mobile") { }
    "/activity_detail"(platform: "/mobile") {}
    "/home_wallet/drawer" (platform: "/mobile", isAbstract: true) {}
    "/home_wallet" (platform: "/mobile", type: TrackType.View) {}
    "/home_wallet/drawer/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
    }
}