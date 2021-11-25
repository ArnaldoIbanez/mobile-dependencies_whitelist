package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1041"

    propertyDefinitions {
        seller_id(required: true, type:PropertyType.Numeric, inheritable: false)
        category_id(required: false, type:PropertyType.String, description: "Item category id")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
        model_id(required: false, type:PropertyType.String, "Model Id" )
        unit_id(required: false, type:PropertyType.Numeric, description: "Unit Id")
        item_id(required: true, type:PropertyType.String,description: "Item id")
        source(required: true, type:PropertyType.String,description: "Origen de donde se generó el evento")
    }

    propertyGroups {
        quotationDetails(seller_id, category_id, vertical, error_type, model_id, unit_id)
        quotationEventData(item_id, source, unit_id)
    }
    //TODO: Se agregaron al catálogo unos fix con los datos que hoy mandan las apis y los fronts, como estos van a ser refactorizados, queda pendiente volver a ajustar este catálogo y dejarlo con la info correcta.

    //Quotation
    "/quotation"(platform: "/", isAbstract: true) {}
    "/quotation/unregistered"(platform: "/", isAbstract: true) {}
    "/quotation/unregistered_form"(platform: "/", isAbstract: true) {}
    "/quotation/modal"(platform: "/", isAbstract: true) {}
    "/quotation/models"(platform: "/", isAbstract: true) {}
    "/quotation/credits_intention"(platform: "/", isAbstract: true) {}


    //Quotation :: Details
    "/quotation/details"(platform: "/") {
        item_id(required: true, type:PropertyType.String,description: "Item id")
        source(required: false, type:PropertyType.String, values: ["vip", "primary", "carousel"],
                description: "Source where item models are called")
    }

    "/quotation/details"(platform: "/web") {
        quotationDetails
    }

    "/quotation/details/unregistered"(platform: "/web") {
        quotationDetails
    }

    "/quotation/details"(platform: "/mobile") {
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        model_id(required: false, type:PropertyType.String, "Model Id" )
        unit_id(required: false, type:PropertyType.Numeric, description: "Unit Id")
    }

    "/quotation/details/show"(platform: "/web", type: TrackType.Event) {
        source(required: true, type:PropertyType.String,description: "Origen de donde se llego al selector de modelos")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_agency, etc")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_status(required: false, type: PropertyType.String, description: "Whenever the items is active, closed or paused")
        seller_id(required: false, type: PropertyType.Numeric)
        buying_mode(required: false, type: PropertyType.String, values: ["classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
    }

    "/quotation/details/unregistered/show"(platform: "/web", type: TrackType.Event) {
        source(required: true, type:PropertyType.String,description: "Origen de donde se generó el evento")
    }

    //Quotation :: Gallery
    "/quotation/gallery"(platform: "/mobile") { }

    // Quotation :: Models
    "/quotation/models"(platform: "/") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        model_id(required: false, type:PropertyType.String, description: "Model id")
    }

    "/quotation/models/scroll"(platform: "/web") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
    }

    //Quotation :: Units
    "/quotation/units"(platform: "/") {
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
        model_id(required: false, type:PropertyType.String, description: "Model id")
        unit_id(required: false, type:PropertyType.String, description: "Unit id")
        source(required: false, type:PropertyType.String, description: "Origen where the model was selected")
    }

    "/quotation/quote_intention"(platform: "/web", type: TrackType.Event) {
        item_id(required: true, type:PropertyType.String,description: "Item id")
        source(required: true, type:PropertyType.String,description: "Origen de donde se llego al selector de modelos")
    }

    //Quotation :: Quotation success
    "/quotation/success"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        unit_id(required: true, type:PropertyType.String, description: "Unit id")
    }

    //Quotation :: Congrats
    "/quotation/congrats"(platform: "/") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
    }

    "/quotation/congrats"(platform: "/web") {
        seller_id(required: true, type:PropertyType.Numeric)
        unit_id(required: true, type:PropertyType.Numeric, description: "Unit id")
        model_id(required: true, type:PropertyType.String, description: "Model id" )
        category_id(required: false, type:PropertyType.String, description: "Item category id")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
    }

    "/quotation/congrats/unregistered"(platform: "/web") {
        seller_id(required: true, type:PropertyType.Numeric)
        unit_id(required: true, type:PropertyType.Numeric, description: "Unit id")
        model_id(required: true, type:PropertyType.String, description: "Model id" )
        category_id(required: false, type:PropertyType.String, description: "Item category id")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
    }

    "/quotation/congrats"(platform: "/mobile") {
        unit_id(required: true, type:PropertyType.String, description: "Unit id")
    }

    //Quotation :: Show price
    "/quotation/show_price"(platform: "/") {
        seller_id(required: true, type:PropertyType.Numeric)
        vertical(required: true, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        item_id(required: true, type:PropertyType.String, description: "Item id")
    }

    "/quotation/show_price"(platform: "/web") {
        unit_id(required: false, type:PropertyType.Numeric, description: "Unit id")
        model_id(required: false, type:PropertyType.String, description: "Model id")
    }

    //Quotation :: Modal Model
    "/quotation/modal-model"(platform: "/") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        seller_id(required: true, type:PropertyType.Numeric)
        vertical(required: true, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        unit_id(required: false, type:PropertyType.Numeric, description: "Unit id")
        model_id(required: false, type:PropertyType.String, description: "Model id")
    }

    "/quotation/unregistered_form"(platform: "/web") {
        item_id(required: true, type:PropertyType.String,description: "Item id")
    }

    "/quotation/unregistered_form/show"(platform: "/web") {
        source(required: true, type:PropertyType.String,description: "Origen de donde se generó el evento")
    }

    "/quotation/unregistered_form/captcha"{
        source(required: true, type:PropertyType.String,description: "Origen de donde se generó el evento")
    }

    "/quotation/unregistered/quote_intention"(platform: "/web", type: TrackType.Event) {
        quotationEventData
    }

    "/quotation/unregistered/edit_info"(platform: "/web", type: TrackType.Event) {
        quotationEventData
    }

    "/quotation/modal/close"(platform: "/web", type: TrackType.Event) {
        quotationEventData
    }

    "/quotation/credits_intention/card"(platform: "/web", type: TrackType.Event) {
        quotationEventData
    }

}
