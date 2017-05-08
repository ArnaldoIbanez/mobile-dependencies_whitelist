import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Quotation
    "/quotation"(platform: "/", isAbstract: true) {}

    //Quotation :: Details
    "/quotation/details"(platform: "/") {
        item_id(required: true, type:PropertyType.String,description: "Item id")
    }

    "/quotation/details"(platform: "/web") {
        category_id(required: true, type:PropertyType.String, description: "Item category id")
        seller_id(required: true, type:PropertyType.Numeric)
        listing_type_id(required: true, type:PropertyType.String, description: "Item listing type id")
        item_status(required: true, type:PropertyType.String, description: "Item status")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
    }

    "/quotation/details"(platform: "/mobile") {
        model_id(required: false, type:PropertyType.String, description: "Model id")
    }

    //Quotation :: Gallery
    "/quotation/gallery"(platform: "/mobile") { }

    // Quotation :: Models
    "/quotation/models"(platform: "/mobile") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        model_id(required: false, type:PropertyType.String, description: "Model id")
    }

    //Quotation :: Units
    "/quotation/units"(platform: "/mobile") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        unit_id(required: false, type:PropertyType.String, description: "Unit id")
    }

    //Quotation :: Disclaimer
    "/quotation/disclaimer"(platform: "/mobile") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
    }

    //Quotation :: Quote intention
    "/quotation/quote_intention"(platform: "/mobile", type: TrackType.Event) {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        model_id(required: true, type:PropertyType.String, description: "Model id")
        unit_id(required: true, type:PropertyType.String, description: "Unit id")
    }

    //Quotation :: Quotation success
    "/quotation/success"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        unit_id(required: true, type:PropertyType.String, description: "Unit id")
    }

    //Quotation :: Congrats
    "/quotation/congrats"(platform: "/") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        unit_id(required: true, type:PropertyType.String, description: "Unit id")
    }

    "/quotation/congrats"(platform: "/web") {
        category_id(required: true, type:PropertyType.String, description: "Item category id")
        seller_id(required: true, type:PropertyType.Numeric)
        listing_type_id(required: true, type:PropertyType.String, description: "Item listing type id")
        item_status(required: true, type:PropertyType.String, description: "Item status")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
        model_id(required: true, type:PropertyType.Numeric )
    }

}
