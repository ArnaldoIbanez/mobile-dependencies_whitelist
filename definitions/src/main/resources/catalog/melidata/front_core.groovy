import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*************************
*   WALLET HOME TRACKS   *
*************************/

tracks {

    def item_value_definition = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
        type(required: true, type: PropertyType.String)
    }

    "/wallet/home" (platform: "/mobile", isAbstract: true) {}

    // Views
    "/wallet/home" (platform: "/mobile", type: TrackType.View) {}

    // Events
    "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {
        backend_tracking_data(required: true, type: PropertyType.Map)
     }

    "/wallet/home/draw" (platform: "/mobile", type: TrackType.Event) {
        header(required: true, type: PropertyType.String, description: "Contains the header string")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_value_definition)), description: "Contains the sections payload")
        backend_tracking_data(required: true, type: PropertyType.Map)
    }

    "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Deeplink to execute an action")
    }

}