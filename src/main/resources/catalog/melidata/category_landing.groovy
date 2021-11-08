package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1202"

    "/category_landing"(platform: "/", type: TrackType.View) {
        category_id(required: true,  description: "Home's category")
        category_path(required: true, description: "Category path of this category home")
        last_modified(required: false, description: "Date of last modification")
        deal_print_id(required: false, description: "Unique id hash")
    }

    "/category_landing/tap"(platform: "/",  type: TrackType.Event, parentPropertiesInherited:false) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }

}
