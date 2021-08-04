package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = 1267

    def stream_info_definition = objectSchemaDefinitions {
        stream_title(required: false, type: PropertyType.String, description: "Title of the stream")
        template_id(required: false, type: PropertyType.String, description: "Template id configuration")
        start_at(required: false, type: PropertyType.String, description: "Start when stream should start")
        status(required: false, type: PropertyType.String, description: "Current status of the stream")
        channel_id(required: false, type: PropertyType.Numeric, description: "channel id where stream belongs")
    }

    def product_info_definition = objectSchemaDefinitions {
        item_id(required: false, type: PropertyType.String, description: "Id that identify the item")
        currency_id(required: false, type: PropertyType.String, description: "Id that identify the currency type")
        price(required: false, type: PropertyType.Numeric, description: "Price for the item")
    }

    // Tracks

    "/livecommerce"(platform: "/" , isAbstract:true ) {}

    "/livecommerce/stream"(platform: "/", type: TrackType.View) {
        stream(required: false, type: PropertyType.Map(stream_info_definition), description: "Stream information")
        products(required: false, type: PropertyType.ArrayList(PropertyType.Map(product_info_definition)), description: "Products associated to the stream")
    }
}


