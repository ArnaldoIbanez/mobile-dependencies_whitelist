import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    def track_info_definition = objectSchemaDefinitions {
        has_recommendations(required: true, type: PropertyType.Boolean, description: "Has recommended items")
        model_id(required: false, type: PropertyType.String, description: "Model which generated the recommendation")
        model_version(required: false, type: PropertyType.String, description: "Version of the model / training data")
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        empty_result_cause(required: false, type: PropertyType.String, description: "Explanation for the empty result.")
        trigger(required: false)
        recommended_items(required: false)
        train_date(required: false, type: PropertyType.String)
        multiget(required: false, type: PropertyType.Boolean, description: "Data fetched via multiget api call")
        recommendation_source(required: false, type: PropertyType.String)
        combo_type(required: false, type: PropertyType.String)
        combo_free_shipping(required: false, type: PropertyType.Boolean)

    }

    def recos_info = objectSchemaDefinitions {
        backend_id(required: true, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")
        track_info(required: true, type: PropertyType.Map(track_info_definition))
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        hidden_by_client(required: false, type: PropertyType.Boolean, description: "The client hide the recommendation")
        recommendation_id(required: false, type: PropertyType.String, description: "Unique string that identifies the recommendation from were the item comes from")
    }

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
        see_more(backend_id, client)
    }

    "/recommendations/add_to_cart"(platform: "/", type: TrackType.Event) {
        add_cart_info
    }

    "/recommendations/see_more"(platform: "/", type: TrackType.Event) {
        recommendations(recos_info)
    }

    "/recommendations/view"(platform: "/") {
        recommendations(recos_info)
    }

}
