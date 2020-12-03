package src.main.resources.catalog.component_prints

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/"(platform: "/") {}

    "/component"(platform: "/") {
        c_id (required:false)
        c_event (required:false)
        c_campaign (required:false)
        c_element_order (required:false)
        c_original_target (required:false)
        merch_data (required:false, type: PropertyType.Map)
    }

    "/wallet_home"(platform: "/" , isAbstract: true) {}

    "/wallet_home/print"(platform: "/mobile") {
        qr_map (required:false)
        banking (required:false)
    }

}
