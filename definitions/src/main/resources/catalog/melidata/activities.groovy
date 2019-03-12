import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

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
}
