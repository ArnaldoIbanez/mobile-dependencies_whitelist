import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * INSTORES Screen Tracks
    */

    "/instore"(platform: "/mobile", isAbstract: true) {}

    "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {}
    "/instore/manual_price"(platform: "/mobile", type: TrackType.View) {}
    "/instore/generic_error"(platform: "/mobile", type: TrackType.View) {
        additional_info (required:false, description: "Extra info")
    }
    "/instore/map"(platform: "/mobile", type: TrackType.View) {}
    "/instore/scan_qr/ftu"(platform: "/mobile", type: TrackType.View) {}

    "/instore/waiting"(platform: "/mobile", type: TrackType.View) {}

    "/instore/waiting"(platform: "/mobile", type: TrackType.Event) {
        view (required:true, description: "View type", type: PropertyType.String)
    }

}
