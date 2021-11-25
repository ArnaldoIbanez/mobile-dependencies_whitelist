package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

/**
*
* The events means actions that happens without launch a View,
* as example of that we can consider Bookmark an item in a VIP page
* Every event is an action, so the verbs available are:
*
* - back:  the event of back from a page, specially in mobile
* - abort: the user abort the action (e.g: back pressed before api response)
* - delete: when something is deleted
* - apply: when a criteria is applied
* - post: create a new entity
*
*/


tracks {

    initiative = "1171"

    //Compatibilities
    "/compatibilities"(platform: "/") {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        domain_id(required: true, type: PropertyType.String, description: "Item's domain id")
        event_source(required: true, type: PropertyType.String,
                values: ["vip", "pdp", "search"],
                description: "source of the event")
        widget_state(required: true, type: PropertyType.String, description: "Compabilities initial state") 
    }

    //Compatibilities :: Modal
    "/compatibilities/modal"(platform: "/") {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        domain_id(required: true, type: PropertyType.String, description: "Item's domain id")
        event_source(required: true, type: PropertyType.String,
                values: ["vip", "pdp", "search"],
                description: "source of the event")
        widget_state(required: true, type: PropertyType.String, description: "Compabilities initial state") 
    }

}
