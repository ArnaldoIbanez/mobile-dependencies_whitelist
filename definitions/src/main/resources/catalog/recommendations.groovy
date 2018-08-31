import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    propertyDefinitions {
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")
        direct(required: true, type: PropertyType.Boolean, description: "Boolean flag to indicate if we have a direct CHO A2c")
        items(required: true, type: PropertyType.ArrayList, description: "Item ids that are being added")
        recommendation_id(required: true, type: PropertyType.String, description: "Unique string that identifies the recommendation from were the item comes from")
        shipping_benefit(required: false, type: PropertyType.String, values: ["none", "free", "save"], description: "Recommendations shipping benefit, indicates if shipping is free, has savings or does not have any benefit")
    }

    propertyGroups {
        add_cart_info(backend_id, client, direct, items, recommendation_id, shipping_benefit)
    }

    "/recommendations/add_to_cart"(platform: "/", type: TrackType.Event) {
        add_cart_info
    }

}
