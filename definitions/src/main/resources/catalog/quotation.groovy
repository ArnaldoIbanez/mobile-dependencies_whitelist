import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //TODO: Se agregaron al catálogo unos fix con los datos que hoy mandan las apis y los fronts, como estos van a ser refactorizados, queda pendiente volver a ajustar este catálogo y dejarlo con la info correcta.

    //Quotation
    "/quotation"(platform: "/", isAbstract: true) {}

    //Quotation :: Details
    "/quotation/details"(platform: "/") {
        item_id(required: true, type:PropertyType.String,description: "Item id")
        seller_id(required: true, type:PropertyType.Numeric)
    }

    "/quotation/details"(platform: "/web") {
        category_id(required: false, type:PropertyType.String, description: "Item category id")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
        model_id(required: false, type:PropertyType.String, "Model Id" )
        unit_id(required: false, type:PropertyType.Numeric, description: "Unit Id")
    }

    "/quotation/details"(platform: "/mobile") {
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        model_id(required: false, type:PropertyType.String, "Model Id" )
        unit_id(required: false, type:PropertyType.Numeric, description: "Unit Id")
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
    "/quotation/disclaimer"(platform: "/") {
        item_id(required: false, type:PropertyType.String, description: "Item id")
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
        unit_id(required: true, type:PropertyType.Numeric, description: "Unit id")
    }

    "/quotation/congrats"(platform: "/web") {
        seller_id(required: true, type:PropertyType.Numeric)
        model_id(required: true, type:PropertyType.String, description: "Model id" )
        category_id(required: false, type:PropertyType.String, description: "Item category id")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
    }

    //Quotation :: Show price
    "/quotation/show_price"(platform: "/") {
        seller_id(required: true, type:PropertyType.Numeric)
        vertical(required: true, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        item_id(required: true, type:PropertyType.String, description: "Item id")
    }

    "/quotation/show_price"(platform: "/web") {
        unit_id(required: false, type:PropertyType.Numeric, description: "Unit id")
        model_id(required: false, type:PropertyType.String, description: "Model id" )
    }
}
