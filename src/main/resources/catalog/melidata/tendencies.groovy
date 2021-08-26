
package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1171"

    def itemStructure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "Item's id")
        position(required: false, type: PropertyType.Numeric)
    }

    propertyDefinitions {
        tendency_print_id(required: true, type: PropertyType.String, description: "Unique id per render")
        origin(required: false, type: PropertyType.String, description: "The page section where the user interact")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(itemStructure)),
                description: "List of page's items")
        tendency_type(required: false, type: PropertyType.String, description: "The current tendency type")
        selected_filters(required: false, type: PropertyType.Map, description: "The data of all applied filters")
    }

    propertyGroups {
        general_tendencies_info(tendency_print_id, origin, items, tendency_type, selected_filters)
    }

    //Tendencies Landing
    "/tendencies"(platform: "/", type: TrackType.View) {
        general_tendencies_info
    }
}
