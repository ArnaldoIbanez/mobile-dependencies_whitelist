package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*****************************
*   RESELLER TRACKS   *
******************************/

tracks {

    initiative = "1305"
	
    "/reseller" (platform: "/mobile", isAbstract: true) {
        session_id(required: true, type: PropertyType.String, description: "Internal session id")
    }
    "/reseller/scanner" (platform: "/mobile", type: TrackType.View) {
        seller_id(required: true, type: PropertyType.String, inheritable: false, description: "The seller id")
        store_id(required: true, type: PropertyType.String, inheritable: false, description: "The store  id")
        campaign_zone_id(required: true, type: PropertyType.String, inheritable: false, description: "The campaign zone id")
        show_store_in_map(required: true, type: PropertyType.String, inheritable: false, description: "The flag indicates if store is shown on map")
    }
}
