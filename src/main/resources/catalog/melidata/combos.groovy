package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = "1024"


    def item_definition = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "currency symbol")
        category_id(required: true, type: PropertyType.Numeric, description: "Price item")
        variation(required: false, type: PropertyType.Map(item_definition), description: "Balance hidden by user")
    }

    def items_definition = objectSchemaDefinitions {
        currency_id(required: true, type: PropertyType.String, description: "currency symbol")
        price(required: true, type: PropertyType.Numeric, description: "Price item")
        item(required: true, type: PropertyType.Map(item_definition), description: "Balance hidden by user")
        quantity(required: true, type: PropertyType.Numeric, description: "Balance pending")
    }




    propertyDefinitions {
        //Tracks Combos
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        item(required: true, type: PropertyType.String, description: "Unique string that identifies the recommendation from were the item comes from")
        items(required: true, description: "Item ids that are being added", type: PropertyType.ArrayList(PropertyType.Map(items_definition)))
        quantity(required: false, type: PropertyType.Numeric, description: "Items selected at the moment")
    }

    propertyGroups {
        combosGroup(backend_id, client, has_errors, item, items, quantity)
    }

    "/combos"(platform:"/", isAbstract: true) {
    }
    
    "/combos/print" (platform: "/"){}


    "/combos/add_to_cart"(platform: "/", type: TrackType.Event) {
        combosGroup
    }

    "/combos/checked"(platform: "/", type: TrackType.Event) {
        combosGroup
    }

    "/combos/view_combos"(platform: "/", type: TrackType.View) {
        combosGroup
    }

}
