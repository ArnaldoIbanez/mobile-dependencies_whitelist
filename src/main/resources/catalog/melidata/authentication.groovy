package catalog.melidata

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

    initiative = "1127"

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
    }

    "/login/recovery"(platform: "/web", type: TrackType.Event) {}

    "/login/recovery"(platform: "/mobile", type: TrackType.View) {}

    "/login/registration"(platform: "/", type: TrackType.Event) {}

    "/login/auth"(platform: "/", isAbstract: true){}

    "/login/auth/phone_validation"(platform: "/mobile", isAbstract: true){}

    "/login/auth/phone_validation/sms_detection"(platform: "/mobile", isAbstract: true){}

    "/login/auth/success"(platform: "/web", type: TrackType.Event) {
        source(type: PropertyType.String, required: true, description: "Context on which the login is presented")
        tracking_id(type: PropertyType.String, required: true, description: "tracking id for the transaction started")
        is_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via a One Time Password")
        is_admin_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via an Admin One Time Password")
        operator_id(type: PropertyType.String, required: false, description: "Indicates the id of the operator when login is carried out by one")
        rememberme_enabled(type:PropertyType.Boolean, required: false)
    }

    "/login/auth/success"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        tracking_id(type: PropertyType.String, required: false, description: "Indicates the id to track the transaction")
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
    "/login/auth/challenge"(platform: "/", type: TrackType.View) {
        challenge(type: PropertyType.String, required: true, description: "Login Step")
        tracking_id(type: PropertyType.String, required: true, description: "Indicates the id to track the transaction")
        user(type: PropertyType.Map, required: false, description: "Available user info")
        operator_id(type: PropertyType.String, required: false, description: "Indicates the id of the operator when login is carried out by one")
        source(type: PropertyType.String, required: false, description: "Context on which the login is presented")
        has_error(type: PropertyType.Boolean, required: false, description: "Indicates if there's an error shown in screen")
        recaptcha(type: PropertyType.Boolean, required: false, description: "Indicates whether recaptcha is present or not")
        flow(type: PropertyType.String, required: false, description: "indicates whether flow is native or generic", values: ["login_by_phone", "registration","change_user_phone", "login", "forgot_password"])
        channel(type: PropertyType.String, required: false, description: "indicates whether channel is SMS or call", values: ["sms", "call", "whatsApp"])
    }

    "/login/auth/error"(platform: "/", type: TrackType.View) {
        error(type: PropertyType.String, required: true, values: ["resource_not_found", "conflict", "network", "server"],
            description: "Indicates the error type shown in error view.")
    }

    "/login/auth/challenge/submit"(platform: "/", type: TrackType.Event) {}

    "/login/auth/challenge/cancel"(platform: "/mobile", type: TrackType.Event) {}

    "/login/auth/phone_validation/rechallenge"(platform: "/mobile", type: TrackType.Event) {}

    "/login/auth/phone_validation/fallback"(platform: "/mobile", type: TrackType.Event) {}

    "/login/auth/phone_validation/sms_detection/autodetect_code_success"(platform: "/mobile", type: TrackType.Event) {}

    "/login/auth/phone_validation/sms_detection/autodetect_code_failure"(platform: "/mobile", type: TrackType.Event) {}

    "/login/auth/challenge/decline"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        challenge(type: PropertyType.String, required: true, description: "Login Step")
        tracking_id(type: PropertyType.String, required: false, description: "Indicates the id to track the transaction")
        source(type: PropertyType.String, required: false, description: "Context on which the login is presented")
    }

    "/login/auth/challenge/restart"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        challenge(type: PropertyType.String, required: true, description: "Login Step")
        tracking_id(type: PropertyType.String, required: false, description: "Indicates the id to track the transaction")
    }

    "/login/auth/challenge/error"(platform: "/", type: TrackType.View) {
        errors(type: PropertyType.ArrayList, required: true, description: "Errors presented")
    }

    "/logout"(platform: "/", type: TrackType.Event) {
        source(type: PropertyType.String, required: false, values: ["LFE", "MSL"], description: "difference Legacy login and MSL")
        action(type: PropertyType.String, required: false, description: "Mobile only, action perceived")
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

    "/login/smartlock/multiple_credentials"(platform: "/mobile", isAbstract: true) {}

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

    //Security Feedback
    "/login/auth/feedback"(platform: "/", type: TrackType.Event) {
        view(type: PropertyType.String, required: true, description: "Current Feedback step name where the action is taking place")
        event_type(type: PropertyType.String, required: true, description: "Describes user action in current step")
        view_type(type: PropertyType.String, required: false, description: "Feedback step flavor, dependent on user answer")
        notification_id(type: PropertyType.String, required: false, description: "Current notification id, when it applies")
        phone_status(type: PropertyType.String, required: false, description: "Whether the user has phone or not, dependent on step")
    }

    //Account Recovery
    "/auth/account_recovery"(platform: "/", isAbstract: true) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        is_webview(type: PropertyType.Boolean, required: true, description: "Identifies if request comes from webview")
    }

    "/auth/account_recovery/congrats"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/landing"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/phone_number_verification"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/on_hold"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/congrats/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    "/auth/account_recovery/landing/action"(platform: "/", type: TrackType.View) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    "/auth/account_recovery/phone_number_verification/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    "/auth/account_recovery/on_hold/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
        status_code(type: PropertyType.String, required: true, description: "Describes relation between this view and current status code")
    }

    //TOTP
    "/auth/totp"(platform: "/", isAbstract: true) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
    }

    "/auth/totp/enrollment"(platform: "/", isAbstract: true) {
        is_another_enroll(type: PropertyType.Boolean, required: true, description: "Refers to add_other enroll flow")
    }

    "/auth/totp/enrollment/chooser"(platform: "/", type: TrackType.View) {}

    "/auth/totp/enrollment/congrats"(platform: "/", type: TrackType.View) {}

    "/auth/totp/enrollment/greeting"(platform: "/", type: TrackType.View) {}

    "/auth/totp/enrollment/scanner"(platform: "/", type: TrackType.View) {}

    "/auth/totp/enrollment/code"(platform: "/", type: TrackType.View) {}

    "/auth/totp/enrollment/validation"(platform: "/", type: TrackType.View) {}

    "/auth/totp/validation"(platform: "/", type: TrackType.View) {}

    "/auth/totp/too_many_attempts"(platform: "/", type: TrackType.View) {}

    "/auth/totp/enrollment/chooser/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp/enrollment/congrats/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp/enrollment/greeting/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp/enrollment/scanner/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp/enrollment/code/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp/enrollment/validation/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp/validation/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    //TOTP-IN-APP
    "/auth/totp-in-app"(platform: "/", isAbstract: true, initiative: 1127) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
    }

    "/auth/totp-in-app/validation/scan"(platform: "/", type: TrackType.View) {}

    "/auth/totp-in-app/validation/rejected"(platform: "/", type: TrackType.View) {}

    "/auth/totp-in-app/validation/max-attempts"(platform: "/", type: TrackType.View) {}

    "/auth/totp-in-app/validation/scan/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        status(type: PropertyType.String, required: true, values: ["approve", "reject", "expire", "decline_challenge"], description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp-in-app/validation/rejected/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, values: ["try_again", "decline_challenge"], description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp-in-app/validation/max-attempts/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, values: ["go_home", "decline_challenge"] description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    //Attestation App
    "/auth/attestation"(platform: "/mobile", isAbstract: true) {}

    "/auth/attestation/start"(platform: "/mobile", type: TrackType.Event) {
        mode(type: PropertyType.String, required: false, description: "In which mode attestation was started" , values:['publish_result', 'prefetch_only', 'cache_only'])
    }

    "/auth/attestation/signature"(platform: "/mobile", isAbstract: true) {}

    "/auth/attestation/signature/request"(platform: "/mobile", type: TrackType.Event) {}

    "/auth/attestation/signature/created"(platform: "/mobile", type: TrackType.Event) {}

    "/auth/attestation/signature/reuse"(platform: "/mobile", type: TrackType.Event) {}

    "/auth/attestation/signature/expired"(platform: "/mobile", type: TrackType.Event) {}

    "/auth/attestation/signature/fail"(platform: "/mobile", type: TrackType.Event) {
        reason(type: PropertyType.String, required: true, description: "Failure reason")
    }

    "/auth/attestation/nonce"(platform: "/mobile", isAbstract: true) {}

    "/auth/attestation/nonce/request"(platform: "/mobile", type: TrackType.Event) {}

    "/auth/attestation/nonce/created"(platform: "/mobile", type: TrackType.Event) {}

    "/auth/attestation/nonce/fail"(platform: "/mobile", type: TrackType.Event) {
        reason(type: PropertyType.String, required: true, description: "Failure reason")
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
        verified(type: PropertyType.Boolean, required: true, description: "Is selected phone already verified")
        visual_validation_allowed(type: PropertyType.Boolean, required: true, description: "Is phone available for visual validation")
    }

    "/auth/recovery/phone/verified"(platform: "/", type: TrackType.Event) {
        selected_phone_source(type: PropertyType.String, required: true, description: "Source of phone number, could be manual or the name of the suggestion used")
    }

    "/auth/phone_confirmation"(platform: "/", type: TrackType.Event) {
        event(type: PropertyType.String, required: true, description: "Describes which step is user doing in phone confirmation flow")
    }

    // Push Notification
    "/auth/push_notification"(platform: "/mobile", type: TrackType.Event) {
        notified_user(type: PropertyType.String, required: false)
    }

    // Authenticators
    "/auth/authentication_factors"(platform: "/", isAbstract: true) {
        event(type: PropertyType.String, required: true, description: "Describes which step is user doing in authentication flow")
        flow_type(type: PropertyType.String, required: true, description: "Current enrollment flow type")
        authenticator(type: PropertyType.String, required: false, description: "Authenticator name", values: ["phoneValidation", "emailValidation", "notVerifiedPhoneValidation"])
        risk_context(type: PropertyType.Boolean, required: false, description: "Is a risky context")
        reauthentication(type: PropertyType.Boolean, required: true, description: "Is reauthentication context")
        option_selected(type: PropertyType.String, required: false, description: "Describes authentication option selected by user", values: ["primary_email", "google_connect", "microsoft_connect", "sms", "call", "push", "got_code"])
        domain(type: PropertyType.String, required: false, description: "Describes email domain")
    }

    "/auth/authentication_factors/sms"(platform: "/", type: TrackType.Event) {
        sms_option(type: PropertyType.Boolean, required: true, description: "Is SMS available to authenticate user")
        call_option(type: PropertyType.Boolean, required: true, description: "Is CALL available to authenticate user")
        push_option(type: PropertyType.Boolean, required: true, description: "Is PUSH available to authenticate user")
    }

    "/auth/authentication_factors/primary_email"(platform: "/", type: TrackType.Event) {
        primary_email_option(type: PropertyType.Boolean, required: true, description: "Is email available to authenticate user")
        is_google_account_of_different_user(type: PropertyType.String, required: false, description: "Differs between user emails")
        is_microsoft_account_of_different_user(type: PropertyType.String, required: false, description: "Differs between user emails")
        email_id(type: PropertyType.String, required: false, description: "Email identification")
    }

    "/auth/authentication_factors/social_connect"(platform: "/", type: TrackType.Event) {
        microsoft_connect_option(type: PropertyType.Boolean, required: false, description: "Is microsoft connect available to authenticate user")
        primary_email_option(type: PropertyType.Boolean, required: false, description: "As a fallback for social connect")
        google_connect_option(type: PropertyType.Boolean, required: false, description: "Is google connect available to authenticate user")
        is_google_account_of_different_user(type: PropertyType.String, required: false, description: "Differs between user emails")
        is_microsoft_account_of_different_user(type: PropertyType.String, required: false, description: "Differs between user emails")
    }

    // Device Authorization Authenticator
    "/authenticators"(platform: "/", isAbstract: true) {}

    "/authenticators/device_authorization"(platform: "/", isAbstract: true) {}

    "/authenticators/device_authorization/access_request"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/access_request/fallback"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/access_answer"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/access_answer/send"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values: ["approve", "decline", "reject"], description: "Did the user approve the access?")
    }

    "/authenticators/device_authorization/enrollment"(platform: "/", isAbstract: true) {
        section(type: PropertyType.String, required: true, description: "How did the user land at the enrollment flow?")
    }

    "/authenticators/device_authorization/enrollment/greeting"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/enrollment/access_request"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/enrollment/access_request/fallback"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/enrollment/access_answer"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/enrollment/access_answer/send"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values: ["approve", "decline", "reject"], description: "Did the user approve the simulated access?")
    }

    "/authenticators/device_authorization/enrollment/congrats"(platform: "/", type: TrackType.View) {}

    // Phone Validation Authenticator
    "/authenticators/phone_validation"(platform: "/", isAbstract: true) {
        status(PropertyType.String, required: true, values: ["success", "failure", "pending_validation" ], description: "challenge status by response")
        available_channels(PropertyType.ArrayList, required: true, description: "channels available to select")
    }

    "/authenticators/phone_validation/channel_selector"(platform: "/", type: TrackType.View) {}

    "/authenticators/phone_validation/channel_selector/submit"(platform: "/", type: TrackType.Event) {
        selected_channel(PropertyType.String, required: true, values: ["push", "sms", "call", "whatsapp" ], description: "channel selected by user")
    }

    "/authenticators/phone_validation/enter_code"(platform: "/", type: TrackType.View) {
        selected_channel(PropertyType.String, required: true, values: ["push", "sms", "call", "whatsapp" ], description: "channel selected by user")
    }

    "/authenticators/phone_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {}

    def screenlockConfigStructure = objectSchemaDefinitions {
        transaction(required: true, type: PropertyType.String, values: ["enabled", "disabled"])
        opening_lock(required: true, type: PropertyType.String, values: ["enabled", "disabled"])
    }

    // Biometrics / Screenlock
    "/screenlock"(platform: "/mobile", isAbstract: true) {
        enrollment_status(type: PropertyType.String, required: true, values: ["enabled", "disabled"])
        os_status(type: PropertyType.String, required: true, values: ["biometrics", "basic_screenlock"])
    }

    "/screenlock/validation_start"(platform: "/mobile", type: TrackType.Event) {
        flow_id(type: PropertyType.String, required: true, description: "Flow identifier where validation is happening")
     }

    "/screenlock/validation_end"(platform: "/mobile", type: TrackType.Event) {
        flow_id(type: PropertyType.String, required: true)
        elapsed_time(type: PropertyType.Numeric, required: true, description: "elapsed time in os validation flow")
        result(type: PropertyType.String, required: true, values: ["success", "error"])
        errors(type: PropertyType.ArrayList, required: false)
    }

    "/screenlock/opening_lock"(platform: "/mobile", type: TrackType.View) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
    }

    "/screenlock/opening_lock/retry"(platform: "/mobile", type: TrackType.Event) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
    }


    //Maybe deprecated tracks
    "/login/splitter"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_in"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_up"(platform: "/mobile", type: TrackType.View) {}
    "/login/identification"(platform: "/mobile") {}
    "/login_success"(platform: "/mobile/ios", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "When user login success in ios")
    }

}
