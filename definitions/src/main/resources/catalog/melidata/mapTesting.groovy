import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {

    /**
     * ACCOUNT FUND Screen Tracks
     */

    def item_definition = objectSchemaDefinitions {
        item_id(required:true, description: "Operation result status", type: PropertyType.String)
        price (required:true, description: "quantity", type: PropertyType.Numeric)
        shipping (required:true, description: "shippings", type: PropertyType.ArrayList)
    }

    def purchased_item_definition = objectSchemaDefinitions {
        item(required:true, description: "Operation result status", type:PropertyType.Map, schemaDefinitions: item_definition)
        quantity (required:true, description: "quantity", type: PropertyType.Numeric)
    }

    "/mapTesting"(platform: "/", type: TrackType.View) {
        recommended_item (required:true, description: "Operation result type", type:PropertyType.Map, schemaDefinitions: item_definition)
        purchased_item (required:true, description: "Operation result type", type:PropertyType.Map, schemaDefinitions: purchased_item_definition)
    }

    "/mapTesting/subdir"(platform: "/", type: TrackType.View) {}

    "/mapTesting/websubdir"(platform: "/web", type: TrackType.View) {}
}
