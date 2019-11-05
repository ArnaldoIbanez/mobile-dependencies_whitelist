import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/mgm_seller" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/mgm_seller/referal" (platform: "/mobile", type: TrackType.View) {}
    "/mgm_seller/dashboard" (platform: "/mobile", type: TrackType.View) {}
    
    // Events
    "/mgm_seller/referal/tap" (platform: "/mobile", type: TrackType.Event) {
        media(required: true, type: PropertyType.String, description: "media to share the content")
        device(required: false, type: PropertyType.String, description: "Device to share")
    }
    "/mgm_seller/referal/swipe" (platform: "/mobile", type: TrackType.Event) {}
}