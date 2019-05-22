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

    def item = objectSchemaDefinitions {
        ordinal(required: true, type: PropertyType.Numeric)
        id(required: true, type: PropertyType.String)
        type(required: true, type: PropertyType.String)
        item_tracking_data(required: true, type: PropertyType.Map)
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
    "/front_core/pull"(platform: "/mobile", type: TrackType.Event) {

    }

    "/front_core/show"(platform: "/mobile", type: TrackType.Event) {
        header(type: PropertyType.Map, required: true)
        // items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item)))
        // backend_tracking_data(required: true, type: PropertyType.Map)
    }
}