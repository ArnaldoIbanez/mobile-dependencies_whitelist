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

    "/login"(platform: "/", isAbstract: true) {
	flow(type: PropertyType.String, required: false)
        source(type: PropertyType.String, required: false, description: "Context on which the login is presented")
        old_user_id(type: PropertyType.String, required: false)
        old_user_nick(type: PropertyType.String, required: false)
        user_reg_date(type: PropertyType.String, required: false)
        user_points(type: PropertyType.Numeric, required: false)
        otp_section(type: PropertyType.String, required: false)
        rememberme_enabled(type:PropertyType.Boolean, required: false)
    }

    "/login/form"(type: TrackType.View) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        source(type: PropertyType.String, required: true, description: "Context on which the login is presented")
        tx(type: PropertyType.String, required: true)
        operator_id(type: PropertyType.String, required: false, description: "Indicates the id of the operator when login is carried out by one")
        has_error(type: PropertyType.Boolean, required: false)
        recaptcha(type: PropertyType.Boolean, required: false, description: "Indicates whether recaptcha is present or not")
        push_control_group_user(type: PropertyType.Boolean, required: false)
    }

    "/login/recovery"(platform: "/web", type: TrackType.Event) {}

    "/login/recovery"(platform: "/mobile", type: TrackType.View) {}

    "/login/registration"(platform: "/", type: TrackType.Event) {}

    "/login/auth"(platform: "/", isAbstract: true){}

    "/login/auth/success"(platform: "/web", type: TrackType.Event) {
        source(type: PropertyType.String, required: true, description: "Context on which the login is presented")
        tx(type: PropertyType.String, required: true)
        is_transaction(type: PropertyType.Boolean, required: true)
        is_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via a One Time Password")
        is_admin_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via an Admin One Time Password")
        operator_id(type: PropertyType.String, required: false, description: "Indicates the id of the operator when login is carried out by one")
        push_control_group_user(type:PropertyType.Boolean, required: false)
        rememberme_enabled(type:PropertyType.Boolean, required: false)
    }

    "/login/auth/success"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        is_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via a One Time Password")
        is_admin_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via an Admin One Time Password")
    }

    "/login/auth/failure"(platform: "/web", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        source(type: PropertyType.String, required: true, description: "Context on which the login is presented")
        tx(type: PropertyType.String, required: true)
        reason(type: PropertyType.Map, required: true, description: "Reason behind the failure of the current login step")
        operator_id(type: PropertyType.String, required: false, description: "Indicates the id of the operator when login is carried out by one")
    }

    "/login/auth/failure"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        is_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via a One Time Password")
        is_admin_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via an Admin One Time Password")
        reason(type: PropertyType.Map, required: true, description: "Reason behind the failure of the current login step")
    }

    "/login/auth/challenge_success"(platform: "/web", type: TrackType.View) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        source(type: PropertyType.String, required: true, description: "Context on which the login is presented")
        tx(type: PropertyType.String, required: true)
        operator_id(type: PropertyType.String, required: false, description: "Indicates the id of the operator when login is carried out by one")
    }


    "/login/auth/challenge_success"(platform: "/mobile", type: TrackType.View) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        is_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via a One Time Password")
        is_admin_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via an Admin One Time Password")
    }

    "/login/auth/challenge_decline"(platform: "/", type: TrackType.View) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        source(type: PropertyType.String, required: true, description: "Context on which the login is presented")
        tx(type: PropertyType.String, required: true)
        operator_id(type: PropertyType.String, required: false, description: "Indicates the id of the operator when login is carried out by one")
    }

    // New Multi Step Login Android
    "/login/auth/render"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true)
        tracking_id(type: PropertyType.String, required: true)
        user(type: PropertyType.Map, required: false)
    }

    "/login/auth/submit"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true)
        tracking_id(type: PropertyType.String, required: true)
        user(type: PropertyType.Map, required: false)
    }

    "/login/auth/cancel"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true)
        tracking_id(type: PropertyType.String, required: true)
        user(type: PropertyType.Map, required: false)
    }

    "/login/auth/error"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true)
        tracking_id(type: PropertyType.String, required: true)
        user(type: PropertyType.Map, required: false)
        errors(type: PropertyType.ArrayList, required: true)
    }

    "/login/auth/restart"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true)
    }

    "/logout"(platform: "/", type: TrackType.Event) {
        flow(type: PropertyType.String, required: false)
    }

    "/login/auth/push"(platform: "/", type: TrackType.Event) {
        view(type: PropertyType.String, required: true)
        event_type(type: PropertyType.String, required: true)
        challenge(type: PropertyType.String, required: true, description: "Login step")
        tx(type: PropertyType.String, required: true)
    }

    "/login/status"(platform: "/mobile", type: TrackType.Event) {
        is_logged(type: PropertyType.Boolean, required: true)
        smartlock_status(type: PropertyType.String, required: true)
        section(type: PropertyType.String, required: true)
    }

    "/login/smartlock"(platform: "/mobile", type: TrackType.Event) {}

    "/login/smartlock/success"(platform: "/mobile", type: TrackType.Event) {
        attempt_type(type: PropertyType.String, required: false, values: ["auto_sign_in", "retrieve_credentials","multiple_credentials"])
    }

    "/login/smartlock/failure"(platform: "/mobile", type: TrackType.Event) {
        error(type: PropertyType.String, required: true)
        attempt_type(type: PropertyType.String, required: false, values: ["auto_sign_in", "retrieve_credentials","multiple_credentials"])
    }

    "/login/smartlock/save_credentials"(platform: "/mobile", isAbstract: true) {}

    "/login/smartlock/save_credentials/already_saved"(platform: "/mobile", type: TrackType.Event) {}

    "/login/smartlock/save_credentials/resolution_required"(platform: "/mobile", type: TrackType.Event) {
        success(type: PropertyType.Boolean, required: true)
    }

    "/login/smartlock/save_credentials/failure"(platform: "/mobile", type: TrackType.Event) {
        status(type: PropertyType.String, required: true)
    }

    "/login/smartlock/multiple_credentials" (platform: "/mobile", isAbstract: true) {}

    "/login/smartlock/multiple_credentials/credential_selected"(platform: "/mobile", type: TrackType.Event) {}

    "/login/smartlock/multiple_credentials/cancel"(platform: "/mobile", type: TrackType.Event) {}

    "/oauth"(platform: "/", isAbstract: true) {}

    "/oauth/authorization"(platform: "/", isAbstract: true) {}

    "/oauth/authorization/form"(platform: "/", type: TrackType.View) {
        source(type: PropertyType.String, required: true, description: "Context on which the login is presented")
    }

    "/oauth/authorization/form/access"(platform: "/", type: TrackType.Event) {
        authorize(type: PropertyType.Boolean, required: true)
    }

    //Abuse Prevention
    "/auth"(platform: "/", isAbstract: true) {}
    "/auth/abuse_prevention"(platform: "/", type: TrackType.Event) {
      result(type: PropertyType.String, required: true)
    }
    "/auth/abuse_prevention/login"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
      device_id(type: PropertyType.String, required: true)
      platform(type: PropertyType.String, required: true)
    }
    "/auth/abuse_prevention/ban"(platform: "/", type: TrackType.Event) {
      result(type: PropertyType.String, required: true)
    }

    //Security Feedback
    "/login/auth/feedback"(platform: "/", type: TrackType.Event) {
        view(type: PropertyType.String, required: true, description: "Current Feedback step name where the action is taking place")
        event_type(type: PropertyType.String, required: true, description: "Describes user action in current step")
        view_type(type: PropertyType.String, required: false, description: "Feedback step flavor, dependent on user answer")
    }

    //SMS Enrollment
    "/auth/recovery"(platform: "/", isAbstract: true) {}

    "/auth/recovery/phone"(platform: "/", isAbstract: true) {
        redirect_url(type: PropertyType.String, required: true, description: "Go to Url after enrollment")
        flow_type(type: PropertyType.String, required: true, description: "Current enrollment flow type")
        flow_sub_type(type: PropertyType.String, required: false, description: "Name that represents previous flow")
    }

    "/auth/recovery/phone/registration"(platform: "/", type: TrackType.Event) {}

    "/auth/recovery/phone/save"(platform: "/", type: TrackType.Event) {
        selected_phone_source(type: PropertyType.String, required: true, description: "Source of phone number, could be manual or the name of the suggestion used")
        verified(type: PropertyType.String, required: true, description: "Is selected phone already verified")
        visual_validation_allowed(type: PropertyType.Boolean, required: true, description: "Is phone available for visual validation")
    }

    "/auth/recovery/phone/verified"(platform: "/", type: TrackType.Event) {
        selected_phone_source(type: PropertyType.String, required: true, description: "Source of phone number, could be manual or the name of the suggestion used")
    }

    // Push Notification
    "/auth/push_notification"(platform: "/mobile", type: TrackType.Event) {
        notified_user(type: PropertyType.String, required: false)
    }
}
