import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {

    /**
     * ACCOUNT FUND Screen Tracks
     */

    "/mapTesting"(platform: "/", type: TrackType.View) {
        result_type (required:true, description: "Operation result type", type:PropertyType.Map, propertyDefinitions: object {
            result_status(required:true, description: "Operation result status", type: PropertyType.String)
            money (required:true, description: "quantity", type: PropertyType.Numeric)
        })

        result_type_double_map (required:true, description: "Operation result type", type:PropertyType.Map, propertyDefinitions: object {
            result_map(required:true, description: "Operation result status", type:PropertyType.Map, propertyDefinitions: object {
                result_status(required:true, description: "Operation result status", type: PropertyType.String)
                money (required:true, description: "quantity", type: PropertyType.Numeric)
            })
            money (required:true, description: "quantity", type: PropertyType.Numeric)
        })
    }

    "/mapTesting/subdir"(platform: "/", type: TrackType.View) {}

    "/mapTesting/websubdir"(platform: "/web", type: TrackType.View) {}
}