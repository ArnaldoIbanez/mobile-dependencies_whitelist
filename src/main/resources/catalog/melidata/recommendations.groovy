package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = "1024"

    def track_info_definition = objectSchemaDefinitions {
        has_recommendations(required: false, type: PropertyType.Boolean, description: "Has recommended items")
        model_id(required: false, type: PropertyType.String, description: "Model which generated the recommendation")
        model_version(required: false, type: PropertyType.String, description: "Version of the model / training data")
        has_errors(required: false, type: PropertyType.Boolean, description: "The recommendation has to be hidden because it has errors.")
        backend_id(required: false, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        empty_result_cause(required: false, type: PropertyType.String, description: "Explanation for the empty result.")
        trigger(required: false, description: "Starting point for the recommendation. Usually the VIP item.")
        recommended_items(required: false, description: "Items that this recommendation has.")
        train_date(required: false, type: PropertyType.String, description: "Model metadata.")
        multiget(required: false, type: PropertyType.Boolean, description: "Data fetched via multiget api call")
        recommendation_source(required: false, type: PropertyType.String, description: "Model metadata.")
        combo_type(required: false, type: PropertyType.String, description: "Type of combo generated")
        combo_free_shipping(required: false, type: PropertyType.Boolean, description: "This combo offers free-shipping if fully purchased")
        combo_total_shipping_cost(required: false, type: PropertyType.Numeric, description: "Shipping cost for this combo")
        combo_shipping_save(required: false, type: PropertyType.Numeric, description: "Amount saved on shipping for this combo")
        combo_shipping_promise_type(required: false, type: PropertyType.String, description: "Shipping promise for this combo")
        combo_direct_checkout(required: false, type: PropertyType.Boolean, description: "Combo has direct checkout instead of cart")
        combo_shipping_save_enabled(required: false, type: PropertyType.Boolean, description: "This combo has shipping savings")
    }

    def recos_info = objectSchemaDefinitions {
        backend_id(required: false, type: PropertyType.String, description: "Unique string that identifies the backend used to create the recommendation")
        client(required: true, type: PropertyType.String, description: "Unique string that identifies the spot")

        // track_info es un objeto opaco que no se maneja en frontend.
        // lo utilizan los modelos para reentrenarse, y cada backend tiene su propia estructura.
        track_info(required: true, type: PropertyType.Map)

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

    //Recommendations => Should be embebed in host tracks, except for client-side clientes ( i.e. /vip )
    "/recommendations"(platform: "/") {

    }

    "/recommendations/print" (platform: "/"){}


    "/recommendations/add_to_cart"(platform: "/", type: TrackType.Event) {
        add_cart_info
    }

    "/recommendations/see_more"(platform: "/", type: TrackType.Event) {
        recommendations(type: PropertyType.Map(recos_info), description: "Tracking info for recommendations component.", required: true)
    }

    "/recommendations/view"(platform: "/") {
        recommendations(type: PropertyType.Map(recos_info), description: "Tracking info for recommendations component.", required: true)
    }

}
