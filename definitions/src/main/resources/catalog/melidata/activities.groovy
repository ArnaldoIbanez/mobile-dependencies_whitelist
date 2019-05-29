import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /*************************
    *    ACTIVITY TRACKS    *
    *************************/


    /*************************
    *      ACTIVITY WEB      *
    *************************/

    // MP Activities
    "/listing"(platform: "/", isAbstract: true) {}

    "/listing/activities"(platform: "/web", type: TrackType.View) {
        shown_modal_id(required: true, type: PropertyType.String, description: 'Indicates the id of the modal shown.')
    }

    "/listing/gateway"(platform: "/web", type: TrackType.View) {}

    // MP details
    "/activity"(platform: "/web", isAbstract: true) {}
    "/activity/detail"(platform: "/web", type: TrackType.View) {}
    "/activity/detail/shipping"(platform: "/web", type: TrackType.View) {}

    // MP Balance/Advances
    "/activities"(platform: "/web", isAbstract: true) {}
    "/activities/balance"(platform: "/web", type: TrackType.View) {}
    "/activities/balance/advances"(platform: "/web", type: TrackType.View) {}
    "/activities/balance/advances/congrats"(platform: "/web", type: TrackType.View) {}

    // MP Activities Export
    "/activities/export"(platform: "/web", type: TrackType.View) {}
    
    /********************************
    *     ACTIVITY MOBILE TRACKS    *
    *********************************/


    // MP Activities List
    "/listing/activities" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/remove_filter" (platform: "/mobile", type: TrackType.Event) {}

    // MP Activities Filters
    "/listing/activities/filters" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/filters/options" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/filters/apply" (platform: "/mobile", type: TrackType.Event) {}

    // MP Activities Opertion Detail
    "/listing/activities/detail" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/add_note" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/list" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/user_info" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/shipping" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/web_view" (platform: "/mobile", type: TrackType.View) {
        url(required: true, PropertyType.String, description: "The url that will load the webview")
    }
    
}

