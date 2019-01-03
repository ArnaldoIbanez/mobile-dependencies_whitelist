import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {

    /**
     * ACCOUNT FUND Screen Tracks
     */

    def results_dataset = retrievePropertyDefinitions {
        result_status(required:true, description: "Operation result status", type: PropertyType.String)
        money (required:true, description: "quantity", type: PropertyType.Numeric)
    }

    def double_results_dataset = retrievePropertyDefinitions {
        result_map(required:true, description: "Operation result status", type:PropertyType.Map, propertyDefinitions: results_dataset)
        money (required:true, description: "quantity", type: PropertyType.Numeric)
    }

    "/mapTesting"(platform: "/", type: TrackType.View) {
        result_type (required:true, description: "Operation result type", type:PropertyType.Map, propertyDefinitions: results_dataset)

        result_type_double_map (required:true, description: "Operation result type", type:PropertyType.Map, propertyDefinitions: double_results_dataset)
    }

    "/mapTesting/subdir"(platform: "/", type: TrackType.View) {}

    "/mapTesting/websubdir"(platform: "/web", type: TrackType.View) {}
}
