package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*****************************
*   RESELLER TRACKS   *
******************************/

tracks {

    initiative = "1322"
	
    "/reseller" (platform: "/mobile", isAbstract: true) {
        session_id(required: true, type: PropertyType.String, description: "Internal session id")
    }
    "/reseller/scanner" (platform: "/mobile", type: TrackType.View) {
        seller_id(required: true, type: PropertyType.String, inheritable: false, description: "The seller id")
        store_id(required: true, type: PropertyType.String, inheritable: false, description: "The store  id")
        campaign_zone_id(required: true, type: PropertyType.String, inheritable: false, description: "The campaign zone id")
        show_store_in_map(required: true, type: PropertyType.String, inheritable: false, description: "The flag indicates if store is shown on map")
    }
    "/reseller/scanner/back" (platform: "/mobile", type: TrackType.Event) {}
    "/reseller/scanner/torch" (platform: "/mobile", type: TrackType.Event) {
        torch_enabled(required: true, type: PropertyType.Boolean, inheritable: true, description: "The flag indicate if torch is enabled")
    }
    "/reseller/scanner/scanned" (platform: "/mobile", type: TrackType.Event) {
        torch_enabled(required: true, type: PropertyType.Boolean, inheritable: true, description: "The flag indicate if torch is enabled")
        code(required: true, type: PropertyType.String, inheritable: false, description: "The scanned code")
    }
    "/reseller/scanner/camera_permission" (platform: "/mobile", type: TrackType.View) {}
    "/reseller/scanner/camera_permission/granted" (platform: "/mobile", type: TrackType.Event) {}
    "/reseller/scanner/camera_permission/rejected" (platform: "/mobile", type: TrackType.Event) {}
    "/reseller/scanner/camera_permission/configuration" (platform: "/mobile", type: TrackType.Event) {}

    //Congrats
    "/reseller/congrats" (platform: "/mobile", type: TrackType.Event) {
        status(required: true, type: PropertyType.String, inheritable: false, description: "The status of transaction")
    }
    "/reseller/congrats/close" (platform: "/mobile", type: TrackType.Event) {}
    "/reseller/congrats/continue" (platform: "/mobile", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, inheritable: false, description: "The action that the user did in the congrats view")
    }

    //Error
    "/reseller/scanner/error" (platform: "/mobile", type: TrackType.View) {
        type(required: true, type: PropertyType.String, inheritable: false, description: "The error type")
        can_retry(required: true, type: PropertyType.Boolean, inheritable: false, description: "The flag indicate if the user can retry")
    }
    "/reseller/scanner/error/retry" (platform: "/mobile", type: TrackType.Event) {}
}
