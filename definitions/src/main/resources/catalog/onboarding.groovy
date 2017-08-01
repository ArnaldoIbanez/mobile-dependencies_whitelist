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

    "/onboarding/step"(platform: "/mobile", type: TrackType.View) {
       type(type: PropertyType.String, required: true) 
    }

    "/onboarding/cancel"(platform: "/mobile", type: TrackType.Event) {}

    "/onboarding/login"(platform: "/mobile", type: TrackType.Event) {}

    "/onboarding/registration"(platform: "/mobile", type: TrackType.Event) {
        type(type: PropertyType.String, required: true)
    }
}
