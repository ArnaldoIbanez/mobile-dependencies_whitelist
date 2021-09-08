package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1074'

    /*************************
    *    ACTIVITY TRACKS    *
    *************************/

    /********************************
    *     ACTIVITY MOBILE TRACKS    *
    *********************************/

    def filter_definition = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "The id of the Filter")
        ordinal(required: true, type: PropertyType.Numeric, description: "The position of the filter")
    }

    // MP Activities List
    "/listing/activities" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/pull" (platform: "/mobile", type: TrackType.Event) {
        has_changes(required: true, type: PropertyType.Boolean, description: "If changed the list of activities") 
    }

    // MP Activities Filters
    "/listing/activities/filters" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/filters/options" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/removefilter" (platform: "/mobile", type: TrackType.Event) {}
    "/listing/activities/filters/apply" (platform: "/mobile", type: TrackType.Event) {
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(filter_definition)), description: "The filters applied")
    }

    // MP Activities Opertion Detail
    "/listing/activities/detail" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/add_note" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/add_note/added" (platform: "/mobile", type: TrackType.Event) {}
    "/listing/activities/detail/list" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/user_info" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/shipping" (platform: "/mobile", type: TrackType.View) {}
    "/listing/activities/detail/web_view" (platform: "/mobile", type: TrackType.View) {
        url(required: true, type: PropertyType.String, description: "The url that will load the webview")
    }

    "/listing/activities/real_time" (platform: "/mobile", isAbstract: true) {}
    "/listing/activities/real_time/total" (platform: "/mobile", type: TrackType.View) {
        total(required: false, type: PropertyType.Numeric, description: "Total realtime activities pushed")        
    }
    "/listing/activities/real_time/push" (platform: "/mobile", type: TrackType.View) {
        activity_id(required: true, type: PropertyType.String, description: "The id's activity")
        date_created(required: true, type: PropertyType.String, description: "The date it was created")
    }

    "/listing/activities/show_rta" (platform: "/mobile", type: TrackType.Event) {
        has_rta(required: true, type: PropertyType.Boolean, description: "Describes whether or not there is a rta")        
    }   
    
}
