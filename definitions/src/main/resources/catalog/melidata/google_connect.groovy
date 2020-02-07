import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


/**
*
* The events means actions that happens without launch a View,
* as example of that we can consider Bookmark an item in a VIP page
* Every event is an action, so the verbs available are:
*
* - back:  the event of back from a page, specially in mobile
* - abort: the user abort the action (e.g: back pressed before api response)
* - delete: when something is deleted
* - apply: when a criteria is applied
* - post: create a new entity
*/

tracks {

    initiative = '1125'

    "/google_connect"(platform: "/mobile", isAbstract: true) {}
    "/google_connect/init_flow"(platform: "/mobile") {
        type (required:true, type: PropertyType.String, description: "type of operation that google want", values: ["normal", "reauthentication", "no_params"])
        withToken (required:false, type: PropertyType.Boolean, description: "The user was logged in MP?")
        withAuthRequest (required:false, type: PropertyType.Boolean, description: "Is google asking for re-authentication?")
    }

    "/google_connect/end_flow"(platform: "/mobile") {
        status (required:true, type: PropertyType.String, description: "Operation result status", values: ["approved", "canceled", "first_user"])
    }
}



