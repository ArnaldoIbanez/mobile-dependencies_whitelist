
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

    //Login conversion
    "/login"(platform: "/", isAbstract: true) {
        source(type: PropertyType.String, required: true)
        country_name(type: PropertyType.String, required: true)
    }

    "/login/form"(type: TrackType.View) {
        "has_error"(PropertyType.Boolean, required: false)
    }

    "/login/recovery"(platform: "/web", type: TrackType.Event) {}

    "/login/recovery"(platform: "/mobile", type: TrackType.View) {}

    "/login/registration"(platform: "/", type: TrackType.Event) {}

    "/login/auth"(platform: "/", isAbstract: true) {
        dps_id(type: PropertyType.String, required: true)
    }

    "/login/auth/success"(platform: "/", type: TrackType.Event) {}

    "/login/auth/failure"(platform: "/", type: TrackType.Event) {
        username(type: PropertyType.String, required: false)
        reason(type: PropertyType.String, required: true)
    }
}