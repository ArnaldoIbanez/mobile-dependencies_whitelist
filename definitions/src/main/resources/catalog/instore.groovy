import com.ml.melidata.TrackType

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
    "/instore/scan_qr/ftu"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting"(platform: "/mobile", type: TrackType.View) {}
    "/instore/map"(platform: "/mobile", type: TrackType.View) {}

}
