package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = "1024"


   
    "/combos/print" (platform: "/"){
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")
        track_info(required: false, type: PropertyType.Map)
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        item(required: true, type: PropertyType.String, description: "Unique string that identifies the recommendation from were the item comes from")
        items(required: true, description: "Item ids that are being added", type: PropertyType.ArrayList)
        quantity(required: false, type: PropertyType.Numeric, description: "Items selected at the moment")
    }


    "/combos/add_to_cart"(platform: "/", type: TrackType.Event) {
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")
        track_info(required: false, type: PropertyType.Map)
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        item(required: true, type: PropertyType.String, description: "Unique string that identifies the recommendation from were the item comes from")
        items(required: true, description: "Item ids that are being added", type: PropertyType.ArrayList)
        quantity(required: false, type: PropertyType.Numeric, description: "Items selected at the moment")
    }

    "/combos/checked"(platform: "/", type: TrackType.Event) {
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")
        track_info(required: false, type: PropertyType.Map)
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        item(required: true, type: PropertyType.String, description: "Unique string that identifies the recommendation from were the item comes from")
        items(required: true, description: "Item ids that are being added", type: PropertyType.ArrayList)
        quantity(required: false, type: PropertyType.Numeric, description: "Items selected at the moment")
    }

    "/combos/view"(platform: "/", type: TrackType.View) {
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")
        track_info(required: false, type: PropertyType.Map)
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        item(required: true, type: PropertyType.String, description: "Unique string that identifies the recommendation from were the item comes from")
        items(required: true, description: "Item ids that are being added", type: PropertyType.ArrayList)
        quantity(required: false, type: PropertyType.Numeric, description: "Items selected at the moment")
    }

}
