package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1202"

    "/category_landing"(platform: "/", type: TrackType.View) {
        category_id(required: false,  description: "Home's category")
        category_path(required: false, description: "Category path of this category home")
        last_modified(required: false, description: "Date of last modification")
    }

    "/category_landing"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }

}
