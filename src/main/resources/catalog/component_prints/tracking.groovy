package src.main.resources.catalog.component_prints

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/"(platform: "/") {}

    def merchdata = objectSchemaDefinitions {
        content_id(type: PropertyType.String, required: true)
        component_id(type: PropertyType.String, required: true)
        audience(type: PropertyType.String, required: true)
        bu(type: PropertyType.String, required: true)
        bu_line(type: PropertyType.String, required: true)
        flow(type: PropertyType.String, required: true)
        logic(type: PropertyType.String, required: true)
        position(type: PropertyType.String, required: true)
    }

    "/component"(platform: "/") {
        c_id (required:false)
        c_event (required:false)
        c_campaign (required:false)
        c_element_order (required:false)
        c_original_target (required:false)
        merch_data (required:false, type: PropertyType.Map(merchdata))
    }

    "/wallet_home"(platform: "/" , isAbstract: true) {}

    "/wallet_home/print"(platform: "/mobile") {
        qr_map (required:false)
        banking (required:false)
    }

}
