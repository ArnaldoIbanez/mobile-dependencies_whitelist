import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /*************************
    *    FRONT-CORE TRACKS   *
    *************************/

    /*************************
    *       HOME TRACKS      *
    *************************/

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

    "/wallet/home/show" (platform: "/mobile", type: TrackType.Event) {
        header(required: true, type: PropertyType.String, description: "Contains the header string")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_value_definition)), description: "Contains the sections payload")
        backend_tracking_data(required: true, type: PropertyType.Map)
    }

    "/wallet/home/show/banking" (platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the list of sections")
    }

    "/wallet/home/show/main_actions" (platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the list of sections")
    }

    "/wallet/home/show/secondary_actions" (platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the list of sections")
    }

    "/wallet/home/show/benefits" (platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the list of sections")
    }

    "/wallet/home/show/cross_selling" (platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the list of sections")
    }

    "/wallet/home/show/activities" (platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the list of sections")
    }

    "/wallet/home/show/qr_map" (platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric, description: "The position in the list of sections")
    }

}