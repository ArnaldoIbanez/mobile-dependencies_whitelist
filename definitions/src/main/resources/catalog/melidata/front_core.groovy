import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    // def homeTrackStructure = objectSchemaDefinitions {
    //     id(required: true, type: PropertyType.String)
    //     period(required: true, type: PropertyType.Numeric)
    //     cost(required: true, type: PropertyType.Numeric)
    //     revenue_share_fee(required: true, type: PropertyType.Numeric)
    //     revenue(required: true, type: PropertyType.Numeric)
    //     currency_id(required: true, type: PropertyType.String)
    // }

//******************************************************************//
    def headerTitle = objectSchemaDefinitions {
        title(required: true, type: PropertyType.String)
    }

    // def track_event_definition = objectSchemaDefinitions {
    //     header(required: true, type: PropertyType.Map(headerTitle))
    //     items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item)))
    //     backend_tracking_data(required: true, type: PropertyType.Map)
    // }

    /*************************
    *       FRONT CORE       *
    *************************/

    "/front_core"(platform: "/mobile", isAbstract: true) {}

    // Views
    "/front_core/home"(platform: "/mobile", type: TrackType.View) {}

    // Events
    "/front_core/home/pull"(platform: "/mobile", type: TrackType.Event) {
        backend_tracking_data(required: true, type: PropertyType.Map)
     }

    "/front_core/home/show"(platform: "/mobile", type: TrackType.Event) {
        header(required: false, type: PropertyType.Map(headerTitle))
        items(required: false, type: PropertyType.ArrayList)
        backend_tracking_data(required: false, type: PropertyType.Map)
    }

    "/front_core/home/show/banking"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/show/main_actions"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/show/secondary_actions"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/show/benefits"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/show/cross_selling"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/show/activities"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }

    "/front_core/home/show/qr_map"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String)
        ordinal(required: true, type: PropertyType.Numeric)
    }
}