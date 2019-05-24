import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /*************************
    *       FRONT CORE       *
    *************************/

    def headerTitle = objectSchemaDefinitions {
        title(required: true, type: PropertyType.String)
    }

    "/front_core"(platform: "/mobile", isAbstract: true) {}

    // Views
    "/front_core/home"(platform: "/mobile", type: TrackType.View) {}

    // Events
    "/front_core/home/pull"(platform: "/mobile", type: TrackType.Event) {
        backend_tracking_data(required: true, type: PropertyType.Map)
     }

    "/front_core/home/show"(platform: "/mobile", type: TrackType.Event) {
        header(required: true, type: PropertyType.Map(headerTitle))
        items(required: true, type: PropertyType.Map)
        backend_tracking_data(required: true, type: PropertyType.Map)
    }

    "/front_core/home/banking"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/main_actions"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/secondary_actions"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/benefits"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/cross_selling"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/activities"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/qr_map"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }
}