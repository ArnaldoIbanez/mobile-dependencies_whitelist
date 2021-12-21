package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**
* Selling_flow tracks
*/
tracks {

    initiative = "1348"

    "/selling_flow"(platform: "/", isAbstract: true) {}
    "/selling_flow/catalog"(platform: "/", isAbstract: true) {}
    
    //CATALOG
    "/selling_flow/catalog/start"(platform: "/", type: TrackType.View) {
        flow_id(required: true, type: PropertyType.String, description: "Flow id", values: ['mplink', 'mppoint'])
        empty_state(required: true, type: PropertyType.Boolean, description: "Show empty state")
    }

    //PRODUCTS
    "/selling_flow/catalog/add_product"(platform: "/", type: TrackType.Event) {}
    "/selling_flow/catalog/edit_products"(platform: "/", type: TrackType.Event) {}

    //SEARCH
    "/selling_flow/catalog/search"(platform: "/", type: TrackType.Event) {}
    "/selling_flow/catalog/exit_search"(platform: "/", type: TrackType.Event) {}

    //ITEMS
    "/selling_flow/catalog/select_section"(platform: "/", type: TrackType.Event) {}
    "/selling_flow/catalog/select_item"(platform: "/", type: TrackType.Event) {}
    "/selling_flow/catalog/deselect_item"(platform: "/", type: TrackType.Event) {}
    "/selling_flow/catalog/continue_flow"(platform: "/", type: TrackType.Event) {}

}
