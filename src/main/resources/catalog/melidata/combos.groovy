package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = "1024"


    def combos_info = objectSchemaDefinitions {
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")
        track_info(required: false, type: PropertyType.Map)
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        item(required: true, type: PropertyType.String, description: "Unique string that identifies the recommendation from were the item comes from")
        items(required: true, description: "Item ids that are being added", type: PropertyType.ArrayList)
        action(required: false, type: PropertyType.String, description: "User action"),
        quantity(required: false, type: PropertyType.Number, description: "Items selected at the moment"),
        experiments(required: false, type: PropertyType.ArrayList, description: "Experiment Info")
    }

    "/combos/print" (platform: "/"){}


    "/combos/add_to_cart"(platform: "/", type: TrackType.Event) {
       recommendations(type: PropertyType.Map(combos_info), description: "Tracking info for combos component click add to cart.", required: true)
    }

    "/combos/checked"(platform: "/", type: TrackType.Event) {
       recommendations(type: PropertyType.Map(combos_info), description: "Tracking info for combos component click checkbox.", required: true)
    }

    "/combos/view"(platform: "/") {
        recommendations(type: PropertyType.Map(combos_info), description: "Tracking info for combos component.", required: true)
    }

}
