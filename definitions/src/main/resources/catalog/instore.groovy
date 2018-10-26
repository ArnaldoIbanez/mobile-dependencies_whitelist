import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * INSTORES Screen Tracks
    */

    "/instore"(platform: "/mobile", isAbstract: true) {}

    // Error
    "/instore/generic_error"(platform: "/mobile", type: TrackType.View) {
        additional_info (required:false, description: "Extra info")
    }

    // Permissions
    "/instore/permission"(platform: "/mobile", isAbstract: true) {}
    "/instore/permission/location"(platform: "/mobile", type: TrackType.View) {}
    "/instore/camera_permission"(platform: "/mobile", type: TrackType.View) {}

    // Scan qr
    "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {}
    "/instore/qr_first_time_use"(platform: "/mobile", type: TrackType.View) {}

    // Amount
    "/instore/amount"(platform: "/mobile", isAbstract: true) {}
    "/instore/amount/calculator"(platform: "/mobile", type: TrackType.View) {}
    "/instore/amount/price_list"(platform: "/mobile", type: TrackType.View) {}

    // Shell
    "/instore/gas_station_shell"(platform: "/mobile", type: TrackType.View) {}
    "/instore/shell_first_time_use"(platform: "/mobile", type: TrackType.View) {}

    // Vending
    "/instore/vending"(platform: "/mobile", isAbstract: true) {}
    "/instore/vending/select_product"(platform: "/mobile", type: TrackType.View) {}

    // Waiting
    "/instore/waiting"(platform: "/mobile", isAbstract: true) {}
    "/instore/waiting"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_jockey"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_pump"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gas_clock"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gastronomy_cashier"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/gastronomy_order"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/generic_cashier"(platform: "/mobile", type: TrackType.View) {}
    "/instore/waiting/generic_ticket"(platform: "/mobile", type: TrackType.View) {}

    // Required action
    "/instore/required_action"(platform: "/mobile", isAbstract: true) {}
    "/instore/required_action/data_required"(platform: "/mobile", type: TrackType.View) {}
    "/instore/required_action/data_required/dni"(platform: "/mobile", type: TrackType.View) {}
    "/instore/required_action/bluetooth_permission"(platform: "/mobile", type: TrackType.View) {}

    // Deprecated
    "/instore/required_action/bluetooth_on"(platform: "/mobile", type: TrackType.View) {}
    "/instore/map"(platform: "/mobile", type: TrackType.View) {}
    "/instore/scan_qr/ftu"(platform: "/mobile", type: TrackType.View) {}
    "/instore/manual_price"(platform: "/mobile", type: TrackType.View) {}
}
