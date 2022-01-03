package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1075"

    def attributesStructure = objectSchemaDefinitions {
        attribute_id(required: true, type: PropertyType.String, description: "atribute id to verificate")
        attribute_value(required: true, type: PropertyType.String, description: "atribute value to verificate")
        attribute_name(required: false, type: PropertyType.String, description: "attribute name to verificate")
    }

    def pricesBandsStructure = objectSchemaDefinitions {
        lower_band (required:true, type: PropertyType.Numeric, description: "Lower band from price suggestion")
        lower_limit (required:true, type: PropertyType.Numeric, description: "lower limit band from price suggestion")
        upper_band (required:true, type: PropertyType.Numeric, description: "Upper band from price suggestion")
        upper_limit (required:true, type: PropertyType.Numeric, description: "Upper limit band from price suggestion")
        estimated_price (required:true, type: PropertyType.Numeric, description: "Estimated price from price suggestion")
    }

    "/vis/supply/price_suggestion/bands"(platform: "/", type: TrackType.Event){
        app_name (required:true, type: PropertyType.String, description: "App name from each app which uses price suggestion")
        client_id (required:false, type: PropertyType.Numeric, description: "Client id from each app which uses price suggestion")
        item_id (required:false, type: PropertyType.String, description: "Item id")
        attributes(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributesStructure)), description: "attributes")
        prices_bands (required: true, type: PropertyType.Map(pricesBandsStructure), description: "bands from suggestion")
        price (required:true, type: PropertyType.Numeric, description: "Item price")
    }
}
