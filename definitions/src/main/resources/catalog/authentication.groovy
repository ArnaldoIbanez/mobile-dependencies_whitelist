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
	flow(type: PropertyType.String, required: false)
        source(type: PropertyType.String, required: false)
        old_user_id(type: PropertyType.String, required: false)
        old_user_nick(type: PropertyType.String, required: false)
    }

    "/login/form"(type: TrackType.View) {
        has_error(type: PropertyType.Boolean, required: true)
        challenge(type: PropertyType.String, required: false)
        recaptcha(type: PropertyType.Boolean, required: false)
        tx(type: PropertyType.String, required: false)
        variant(type: PropertyType.String, required: false)
        operator_id(required: false)
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
        challenge(type: PropertyType.String, required: false)
    }

    "/login/auth/failure"(platform: "/", type: TrackType.Event) {
        reason(type: PropertyType.Map, required: true)
        challenge(type: PropertyType.String, required: false)
    }

    "/login/auth/challenge_success"(platform: "/", type: TrackType.View) {
        challenge(type: PropertyType.String, required: true)
    }

    "/logout"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: false)
    }

    "/login/auth/push"(platform: "/", type: TrackType.Event) {
        view(type: PropertyType.String, required: true)
        event_type(type: PropertyType.String, required: true)
        challenge(type: PropertyType.String, required: true)
        tx(type: PropertyType.String, required: true)
    }

    "/login/status"(platform: "/mobile", type: TrackType.Event) {
        is_logged(type: PropertyType.Boolean, required: true)
        smartlock_status(type: PropertyType.String, required: true)
        section(type: PropertyType.String, required: true)
    }

    "/login/smartlock"(platform: "/mobile", type: TrackType.Event) {}

    "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {}

    "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
        error(type: PropertyType.String, required: true)
    }

    "/login/smartlock/save_credentials"(platform: "/mobile", isAbstract: true) {}

    "/login/smartlock/save_credentials/already_saved"(platform: "/mobile", type: TrackType.Event) {}

    "/login/smartlock/save_credentials/resolution_required"(platform: "/mobile", type: TrackType.Event) {
        success(type: PropertyType.Boolean, required: true)
    }

    "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
        status(type: PropertyType.String, required: true)
    }

    "/oauth"(platform: "/", isAbstract: true) {}

    "/oauth/authorization"(platform: "/", isAbstract: true) {}

    "/oauth/authorization/form"(platform: "/", type: TrackType.View) {
        source(type: PropertyType.String, required: true)
    }

    "/oauth/authorization/form/access"(platform: "/", type: TrackType.Event) {
        authorize(type: PropertyType.Boolean, required: true)
    }

    //Abuse Prevention
    "/auth/abuse_prevention"(platform: "/", isAbstract: true) {}

}
