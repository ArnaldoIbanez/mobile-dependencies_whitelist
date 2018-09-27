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
    "/instore/map"(platform: "/mobile", type: TrackType.View) {}
    "/instore/scan_qr/ftu"(platform: "/mobile", type: TrackType.View) {}

    "/instore/waiting"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {}

    "/instore/required_action"(platform: "/mobile", type: TrackType.View) {}
    "/instore/required_action"(platform: "/mobile", isAbstract: true) {}
    "/instore/required_action/data_required"(platform: "/mobile", type: TrackType.View) {}
    "/instore/required_action/bluetooth_on"(platform: "/mobile", type: TrackType.View) {}
}
