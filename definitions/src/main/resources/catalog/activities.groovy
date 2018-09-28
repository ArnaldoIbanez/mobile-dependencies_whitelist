import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    // MP Activities
    "/listing"(platform: "/web", isAbstract: true){}

    "/listing/activities"(platform: "/web"){
        shown_modal_id(required: true, type: PropertyType.String, description: 'Indicates the id of the modal shown.')
    }

    "/listing/gateway"(platform: "/web"){}

    // MP details
    "/activity"(platform: "/web", isAbstract: true){}
    "/activity/detail"(platform: "/web"){}
    "/activity/detail/shipping"(platform: "/web"){}

    // MP Balance/Advances
    "/activities"(platform: "/web", isAbstract: true){}
    "/activities/balance"(platform: "/web"){}
    "/activities/balance/advances"(platform: "/web"){}
    "/activities/balance/advances/congrats"(platform: "/web"){}
}
