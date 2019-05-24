import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {


    /*************************
    *    HOME-WALLET TRACKS  *
    *************************/

    /*************************
    *    FRONT-CORE TRACKS   *
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

    /*************************
    *     ACTIVITY MOBILE    *
    *************************/

 
    "/front_core/activities" (platform: "/mobile", isAbstract: true) {}

    // MP Activities List
    "/front_core/activities/list" (platform: "/mobile", type: TrackType.View) {}
    "/front_core/activities/list/remove_filter" (platform: "/mobile", type: TrackType.Event) {}

    // MP Activities Filters
    "/front_core/activities/filters" (platform: "/mobile", type: TrackType.View) {}
    "/front_core/activities/filters/options" (platform: "/mobile", type: TrackType.View) {}
    "/front_core/activities/filters/apply" (platform: "/mobile", type: TrackType.Event) {}

    // MP Activities Opertion Detail
    "/front_core/activities/detail" (platform: "/mobile", type: TrackType.View) {}
    "/front_core/activities/detail/add_note" (platform: "/mobile", type: TrackType.View) {}
    "/front_core/activities/detail/list" (platform: "/mobile", type: TrackType.View) {}
    "/front_core/activities/detail/user_info" (platform: "/mobile", type: TrackType.View) {}
    "/front_core/activities/detail/shipping" (platform: "/mobile", type: TrackType.View) {}
    "/front_core/activities/detail/web_view" (platform: "/mobile", type: TrackType.View) {
        url(required: true, type: PropertyType.String, description: "The url that will load the webview")
    }

    // MP Activities Realtime Activities
    "/front_core/activities/real_time" (platform: "/mobile", isAbstract: true) {}

    "/front_core/activities/real_time/push" (platform: "/mobile", type: TrackType.Event) {
        activity_id(required: true, type: PropertyType.String, description: "id of the activity")
        date_created(required: true, type: PropertyType.String, description: "the creation date of the activity")
    }

    "/front_core/activities/real_time/total" (platform: "/mobile", type: TrackType.Event) {
        total(required: true, type: PropertyType.Numeric, description: "Total of activities sended")
    }
}