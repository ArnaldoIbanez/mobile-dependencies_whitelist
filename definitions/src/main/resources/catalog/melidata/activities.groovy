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
    "/listing"(platform: "/web", isAbstract: true){}

    "/listing/activities"(platform: "/web", type: TrackType.View){
        shown_modal_id(required: true, type: PropertyType.String, description: 'Indicates the id of the modal shown.')
    }

    "/listing/gateway"(platform: "/web", type: TrackType.View){}

    // MP details
    "/activity"(platform: "/web", isAbstract: true){}
    "/activity/detail"(platform: "/web", type: TrackType.View){}
    "/activity/detail/shipping"(platform: "/web", type: TrackType.View){}

    // MP Balance/Advances
    "/activities"(platform: "/web", isAbstract: true){}
    "/activities/balance"(platform: "/web", type: TrackType.View){}
    "/activities/balance/advances"(platform: "/web", type: TrackType.View){}
    "/activities/balance/advances/congrats"(platform: "/web", type: TrackType.View){}

    // MP Activities Export
    "/activities/export"(platform: "/web", type: TrackType.View){}


    /*************************
    *     ACTIVITY MOBILE    *
    *************************/

    // MP Activities List
    "/activities"(platform: "/mobile", isAbstract: true){}
    "/activities/list"(platform: "/mobile", type: TrackType.View){}
    "/activities/list/removefilter" (platform: "/mobile", type: TrackType.Event){}

    // MP Activities Filters
    "/activities/filters"(platform: "/mobile", type: TrackType.View){}
    "/activities/filters/options"(platform: "/mobile", type: TrackType.View){}
    "/activities/filters/apply" (platform: "/mobile", type: TrackType.Event){}

    // MP Activities Opertion Detail
    "/activities/detail"(platform: "/mobile", type: TrackType.View){}
    "/activities/detail/add_note"(platform: "/mobile", type: TrackType.View){}
    "/activities/detail/list"(platform: "/mobile", type: TrackType.View){}
    "/activities/detail/web_view"(platform: "/mobile", type: TrackType.View){
        url(required: true, PropertyType.String, description: "The url that will load the webview")
    }

}

