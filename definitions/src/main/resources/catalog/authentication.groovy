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

    //Login conversion
    "/login"(platform: "/", isAbstract: true) {
        source(type: PropertyType.String, required: false)
    }

    "/login/form"(type: TrackType.View) {
        has_error(type: PropertyType.Boolean, required: true)
    }

    "/login/recovery"(platform: "/web", type: TrackType.Event) {}

    "/login/recovery"(platform: "/mobile", type: TrackType.View) {}

    "/login/registration"(platform: "/", type: TrackType.Event) {}

    "/login/auth"(platform: "/", isAbstract: true) {
        is_otp(type: PropertyType.Boolean, required: true)
        is_admin_otp(type: PropertyType.Boolean, required: true)
        rememberme_enabled(type:PropertyType.Boolean, required: false)
        otp_section(type: PropertyType.String, required: false)
    }

    "/login/auth/success"(platform: "/", type: TrackType.Event) {
        user_reg_date(type: PropertyType.String, required: true)
        user_points(type: PropertyType.Numeric, required: true)
    }

    "/login/auth/failure"(platform: "/", type: TrackType.Event) {
        reason(type: PropertyType.Map, required: true)
    }

    "/logout"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: false)
    }
}
