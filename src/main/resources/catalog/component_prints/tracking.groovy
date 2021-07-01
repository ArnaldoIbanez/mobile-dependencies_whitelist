package src.main.resources.catalog.component_prints

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/"(platform: "/") {}

    def merchdata = objectSchemaDefinitions {
        content_id(type: PropertyType.String, required: true,  description: "content id")
        component_id(type: PropertyType.String, required: true,  description: "realestate id")
        audience(type: PropertyType.String, required: true, description: "audience for the content")
        bu(type: PropertyType.String, required: true, description: "business unit for the content")
        bu_line(type: PropertyType.String, required: true, description: "vertical for the content")
        flow(type: PropertyType.String, required: true, description: "flow for the content")
        logic(type: PropertyType.String, required: true, description: "logic of the content")
        campaign_id(type: PropertyType.Numeric, required: false, description: "campaign id of the content")
        c_category(type: PropertyType.String, required: false, description: "category of the content")
        position(type: PropertyType.Numeric, required: false, description: "position in array of the content")
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
