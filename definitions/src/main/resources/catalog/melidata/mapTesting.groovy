import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {

    /**
     * ACCOUNT FUND Screen Tracks
     */

    propertyDefinitions {
        price (required:true, description: "quantity", type: PropertyType.Numeric)
    }
    propertyGroups {
        priceGroup(price)
    }


    def item_definition = objectSchemaDefinitions {
        item_id(required:true, description: "Operation result status", type: PropertyType.String)
        priceGroup
        shipping (required:true, description: "shippings", type: PropertyType.ArrayList(PropertyType.String))
        currency (required:true, type: PropertyType.String)
        op_id (required:true, type: PropertyType.Numeric)
        stars (required:true, type: PropertyType.Numeric)
    }

    def purchased_item_definition = objectSchemaDefinitions {
        item(required:true, description: "Operation result status", type:PropertyType.Map(item_definition))
        quantity (required:true, description: "quantity", type: PropertyType.Numeric)
    }

    "/mapTestingIterated"(platform: "/", type: TrackType.View) {
        recommendeds_item (required:true, description: "Operation result type", type:PropertyType.ArrayList(PropertyType.Map(item_definition)))
    }

    "/mapTesting"(platform: "/", type: TrackType.View) {
        recommended_item (required:true, description: "Operation result type", type:PropertyType.Map(item_definition))
        purchased_item (required:true, description: "Operation result type", type:PropertyType.Map(purchased_item_definition))
    }

    "/mapTesting/subdir"(platform: "/", type: TrackType.View) {}

    "/mapTesting/websubdir"(platform: "/web", type: TrackType.View) {}

    "/mapManual"(platform:"/", type: TrackType.View) {
        item_id(required:true, description: "Operation result status", type: PropertyType.String)
        price (required:true, description: "quantity", type: PropertyType.Numeric)
        shipping (required:true, description: "shippings", type: PropertyType.ArrayList)
    }

    "/integrationMapTesting"(platform: "/", type: TrackType.View) {
        priceGroup
    }
}
