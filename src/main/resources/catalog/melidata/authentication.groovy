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

    initiative = "1358"

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

    "/login/save_login_session"(platform: "/mobile", type: TrackType.Event) {
        strategy_used(type: PropertyType.String, required: true, values: ["sharedPreferences", "localStorage"], description: "Name of the strategy with which the data is saved")
        keepnite_is_on(type: PropertyType.Boolean, required: true, description: "Indicates if key authentication_session_local_storage is on")
        api_version(type: PropertyType.Boolean, required: true, description: "Indicates if Build.VERSION.SDK_INT is greater than or equal to 23")
    }

    "/login/get_session"(platform: "/mobile", type: TrackType.Event) {
        strategy_used(type: PropertyType.String, required: true, values: ["sharedPreferences", "localStorage"], description: "Name of the strategy with which the data is retrieved")
        keepnite_is_on(type: PropertyType.Boolean, required: true, description: "Indicates if key authentication_session_local_storage is on")
        api_version(type: PropertyType.Boolean, required: true, description: "Indicates if Build.VERSION.SDK_INT is greater than or equal to 23")
    }

    "/login/remove_session"(platform: "/mobile", type: TrackType.Event) {
        strategy_used(type: PropertyType.String, required: true, values: ["sharedPreferences", "localStorage", "both"], description: "Name of the strategy with which the data is deleted")
        keepnite_is_on(type: PropertyType.Boolean, required: true, description: "Indicates if key authentication_session_local_storage is on")
        api_version(type: PropertyType.Boolean, required: true, description: "Indicates if Build.VERSION.SDK_INT is greater than or equal to 23")
    }

    "/login/migrate_session"(platform: "/mobile", type: TrackType.Event) {
        migration_is_ok(type: PropertyType.Boolean, required: true, description: "Migration was ok")
        keepnite_is_on(type: PropertyType.Boolean, required: true, description: "Indicates if key authentication_session_local_storage is on")
        keepnite_remove_is_on(type: PropertyType.Boolean, required: true, description: "Indicates if ignite is on")    
    }

    "/login/auth/phone_validation"(platform: "/mobile", isAbstract: true){}

    "/login/auth/phone_validation/sms_detection"(platform: "/mobile", isAbstract: true){}

    "/login/auth/success"(platform: "/web", type: TrackType.Event) {
        source(type: PropertyType.String, required: true, description: "Context on which the login is presented")
        tracking_id(type: PropertyType.String, required: true, description: "tracking id for the transaction started")
        is_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via a One Time Password")
        is_admin_otp(type: PropertyType.Boolean, required: true, description: "Indicates if login was via an Admin One Time Password")
        operator_id(type: PropertyType.String, required: false, description: "Indicates the id of the operator when login is carried out by one")
        rememberme_enabled(type:PropertyType.Boolean, required: false)
        account_model(type: PropertyType.String, required: false, description: "indicates the user account model", values: ["traditional", "registered_by_phone"])  
    }

    "/login/auth/success"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true, description: "Login step")
        tracking_id(type: PropertyType.String, required: false, description: "Indicates the id to track the transaction")
        account_model(type: PropertyType.String, required: false, description: "indicates the user account model", values: ["traditional", "registered_by_phone"])
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
        reauthentication(type: PropertyType.Boolean, required: false, description: "indicates if the flow is reauth or login")
        account_model(type: PropertyType.String, required: false, description: "indicates the user account model", values: ["traditional", "registered_by_phone"])
    }

    "/login/auth/error"(platform: "/", type: TrackType.View) {
        error(type: PropertyType.String, required: true, values: ["resource_not_found", "conflict", "network", "server"],
            description: "Indicates the error type shown in error view.")
    }

    "/login/auth/challenge/submit"(platform: "/", type: TrackType.Event) {}

    "/login/auth/challenge/help"(platform: "/", type: TrackType.Event) {}

    "/login/auth/challenge/click_incomplete_registration"(platform: "/", type: TrackType.Event) {}

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

    //Login Transactional
    "/login/transactional"(platform: "/mobile", isAbstract: true, initiative: 1358) {
        authentication_id(type: PropertyType.String, required: true, description: "Authentication id Transaction")
    }

    "/login/transactional/success"(platform: "/mobile", type: TrackType.Event) {
        challenge(type: PropertyType.String, required: true, description: "Transactional step")
        tracking_id(type: PropertyType.String, required: true, description: "Indicates the id to track the transaction")
    }

    "/login/transactional/error"(platform: "/mobile", type: TrackType.View) {
        error(type: PropertyType.String, required: true, values: ["resource_not_found", "conflict", "network", "server"],
                description: "Indicates the error type shown in error view.")
    }

    "/login/transactional/challenge"(platform: "/mobile", type: TrackType.View) {
        challenge(type: PropertyType.String, required: true, description: "Transactional Step")
        tracking_id(type: PropertyType.String, required: true, description: "Indicates the id to track the transaction")
    }

    "/login/transactional/challenge/error"(platform: "/mobile", type: TrackType.View) {
        errors(type: PropertyType.ArrayList, required: true, description: "Errors presented")
    }

    "/login/transactional/challenge/decline"(platform: "/mobile", type: TrackType.Event) {
        tracking_id(type: PropertyType.String, required: false, description: "Indicates the id to track the transaction")
    }

    "/login/transactional/challenge/submit"(platform: "/mobile", type: TrackType.Event) {}

    //Abuse Prevention
    "/auth"(platform: "/", isAbstract: true) {}

    //Security Feedback
    "/login/auth/feedback"(platform: "/", type: TrackType.Event, initiative: 1358) {
        view(type: PropertyType.String, required: true, description: "Current Feedback step name where the action is taking place")
        event_type(type: PropertyType.String, required: true, description: "Describes user action in current step")
        view_type(type: PropertyType.String, required: false, description: "Feedback step flavor, dependent on user answer")
        notification_id(type: PropertyType.String, required: false, description: "Current notification id, when it applies")
        phone_status(type: PropertyType.String, required: false, description: "Whether the user has phone or not, dependent on step")
    }

    //Account Recovery
    "/auth/account_recovery"(platform: "/", isAbstract: true, initiative: 1376) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
    }

    "/auth/account_recovery/restrict"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/landing"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/on_hold"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/expired"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/confirm"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/congrats"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/landing/action"(platform: "/", type: TrackType.View) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    "/auth/account_recovery/on_hold/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    "/auth/account_recovery/expired/go_home"(platform: "/", type: TrackType.Event) {}

    "/auth/account_recovery/confirm/action"(platform: "/", type: TrackType.View) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    "/auth/account_recovery/congrats/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    //TOTP
    "/auth/totp"(platform: "/", isAbstract: true, initiative: 1374) {
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
    "/auth/totp_in_app"(platform: "/", isAbstract: true, initiative: 1374) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
    }

    "/auth/totp_in_app/validation"(platform: "/", isAbstract: true) {}

    "/auth/totp_in_app/validation/scan"(platform: "/", type: TrackType.View) {}

    "/auth/totp_in_app/validation/rejected"(platform: "/", type: TrackType.View) {}

    "/auth/totp_in_app/validation/max_attempts"(platform: "/", type: TrackType.View) {}

    "/auth/totp_in_app/validation/scan/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        status(type: PropertyType.String, required: true, values: ["approved", "rejected", "expired", "update_qr", "decline_challenge"], description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, values: ["polling", "click"], description: "Type of event")
    }

    "/auth/totp_in_app/validation/rejected/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, values: ["try_again", "decline_challenge"], description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    "/auth/totp_in_app/validation/max_attempts/action"(platform: "/", type: TrackType.Event) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, values: ["go_home", "decline_challenge"], description: "Describes element related to user action")
        event_type(type: PropertyType.String, required: true, description: "Type of event")
    }

    // Password
    "/auth/password_enrollment"(platform: "/", isAbstract: true, initiative: 1353) {
        transaction_id(type: PropertyType.String, required: true, description: "Current transaction id")
    }

    "/auth/password_enrollment/confirm"(platform: "/", type: TrackType.Event) {
        transaction_id(type: PropertyType.String, required: true, description: "Current transaction id")
        target(type: PropertyType.String, required: true, values: ["continue"], description: "Describes element related to user action")
    }

    //Attestation App
    "/auth/attestation"(platform: "/mobile", isAbstract: true, initiative: 1375) {}

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

    "/authenticators"(platform: "/", isAbstract: true) {}
    
    // Device Authorization Authenticator

    "/authenticators/device_authorization"(platform: "/", isAbstract: true, initiative: 1374) {}

    "/authenticators/device_authorization/access_request"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/access_request/fallback"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/access_answer"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/access_answer/send"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values: ["approved", "aborted", "rejected"], description: "Did the user approve the access?")
    }

    "/authenticators/device_authorization/enrollment"(platform: "/", isAbstract: true) {}

    "/authenticators/device_authorization/enrollment/greeting"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/enrollment/access_request"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/enrollment/access_request/fallback"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/enrollment/access_answer"(platform: "/", type: TrackType.View) {}

    "/authenticators/device_authorization/enrollment/access_answer/send"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values: ["approved", "aborted", "rejected"], description: "Did the user approve the simulated access?")
    }

    "/authenticators/device_authorization/enrollment/congrats"(platform: "/", type: TrackType.View) {}

    // Phone Validation Authenticator
    "/authenticators/phone_validation"(platform: "/", isAbstract: true) {
        enrollment(type: PropertyType.Boolean, required: false, description: "enrollment flow or not")
        flow_type(type: PropertyType.String, required: false, description: "Current enrollment flow type")
        flow_sub_type(type: PropertyType.String, required: false, description: "Name that represents previous flow")
    }

    "/authenticators/phone_validation/input_phone"(platform: "/", type: TrackType.View) {}

    "/authenticators/phone_validation/input_phone/submit"(platform: "/", type: TrackType.Event) {
        phone_source(type: PropertyType.String, required: true, description: "Source of phone number, could be manual or the name of the suggestion used")
    }

    "/authenticators/phone_validation/input_phone/submit"(platform: "/mobile", type: TrackType.Event) {
        phone_source(type: PropertyType.String, required: false, description: "Source of phone number, could be manual or the name of the suggestion used")
        validation_status(PropertyType.String, required: false, values: ["success", "user_exists", "invalid_phone_format", "empty", "server_error"], description: "validation status by response")
    }

    "/authenticators/phone_validation/channel_selector"(platform: "/", isAbstract: true) {
        status(PropertyType.String, required: true, values: ["success", "failure", "pending_validation", "validated"], description: "challenge status by response")
        available_channels(PropertyType.ArrayList, required: true, description: "channels available to select")
        phone_source(type: PropertyType.String, required: false, description: "Source of phone number, could be manual or the name of the suggestion used")
    }

    "/authenticators/phone_validation/channel_selector"(platform: "/", type: TrackType.View) {}

    "/authenticators/phone_validation/channel_selector/submit"(platform: "/", type: TrackType.Event) {
        selected_channel(PropertyType.String, required: true, values: ["push", "sms", "call", "whatsapp" ], description: "channel selected by user")
    }

    "/authenticators/phone_validation/enter_code"(platform: "/", isAbstract: true) {
        status(PropertyType.String, required: false, values: ["success", "failure", "pending_validation", "validated" ], description: "challenge status by response")
        available_channels(PropertyType.ArrayList, required: false, description: "channels available to select")
        selected_channel(PropertyType.String, required: true, values: ["push", "sms", "call", "whatsapp" ], description: "channel selected by user")
        phone_source(type: PropertyType.String, required: false, description: "Source of phone number, could be manual or the name of the suggestion used")
    }

    "/authenticators/phone_validation/enter_code"(platform: "/", type: TrackType.View) {}

    "/authenticators/phone_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {
        phone_source(type: PropertyType.String, required: false, description: "Source of phone number, could be manual or the name of the suggestion used")
    }

    "/authenticators/phone_validation/enter_code/submit"(platform: "/mobile", type: TrackType.Event) {
        validation_status(type: PropertyType.String, required: false, values: ["success", "invalid_code_length", "empty", "server_error", "failure" ], description: "validation status by response")
    }

    "/authenticators/phone_validation/phone_confirmation"(platform: "/", type: TrackType.View) {}

    "/authenticators/phone_validation/phone_confirmation/submit"(platform: "/", type: TrackType.Event) {
        action(type: PropertyType.String, required: true,values: ["confirm", "change_number"], description: "Option selected about current phone")
    }

    "/authenticators/phone_validation/max_attempts"(platform: "/", type: TrackType.View) {}

    // Email Validation Authenticator

    "/authenticators/email_validation"(platform: "/", isAbstract: true) {
        flow(PropertyType.String, required: false, values: ["login", "registration", "registration_v3", "forgot_password", "reauthentication", "pix" ], description: "Flow using authenticator")
        client_type(PropertyType.String, required: false, values: ["web", "mobile"], description: "Client using flow")
    }

    "/authenticators/email_validation/max_attempts"(platform: "/", type: TrackType.View) {}

    "/authenticators/email_validation/enter_email"(platform: "/", type: TrackType.View) {}

    "/authenticators/email_validation/enter_email/submit"(platform: "/", type: TrackType.Event) {
        validation_status(PropertyType.String, required: false, values:["success", "user_exists",  "email_max_length_exceeded", "invalid_email_format", "forbidden_email_domain", "forbidden_email_word", "malformed_email_address", "invalidEmail"], description: "Email submition status by response")
    }

    "/authenticators/email_validation/enter_code"(platform: "/", type: TrackType.View) {
      social_option(PropertyType.String, required: false, values: ["Google", "Microsoft"], description: "Social option displayed prior to this view")
    }

    "/authenticators/email_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {
        validation_status(PropertyType.String, required: false, values:["success", "failure"], description: "Challenge status by response")
    }

    "/authenticators/email_validation/enter_code/help"(platform: "/", isAbstract: true) {}

    "/authenticators/email_validation/enter_code/help/hard_bounce"(platform: "/", type: TrackType.Event) {}

    "/authenticators/email_validation/enter_code/open_email_app"(platform: "/mobile/android", type: TrackType.Event) {
        packages(PropertyType.ArrayList, required: true, description: "Packages for apps offered to the user when choosing to open their email")
    }

    "/authenticators/email_validation/enter_code/magic_link"(platform: "/", isAbstract: true) {}

    "/authenticators/email_validation/enter_code/magic_link"(platform: "/mobile/android", type: TrackType.Event) {}

    "/authenticators/email_validation/enter_code/magic_link/error"(platform: "/", type: TrackType.View) {
        cause(PropertyType.String, required: true, values:["native_not_listening", "opened_with_browser", "incorrect_code"], description: "Cause for showing an error screen")
    }

    "/authenticators/email_validation/social_oauth"(platform: "/", type: TrackType.View) {
        social_option(PropertyType.String, required: true, values: ["Google", "Microsoft"], description: "Social option displayed")
    }

    "/authenticators/email_validation/social_oauth/submit"(platform: "/", type: TrackType.Event) {
        validation_status(PropertyType.String, required: false, values:["success", "failure"], description: "Challenge status by response")
        email_sign_in(PropertyType.Boolean, required: false, description: "User decide to sign in with email")
    }

    // Face Validation
    "/authenticators/face_validation"(platform: "/", isAbstract: true) {}

    "/authenticators/face_validation/error"(platform: "/", type: TrackType.View) {
      error_code(PropertyType.String, required: true, values:["validation_error", "max_attempts", "server_error"], description: "Errors after face validation against database")
    }

    "/authenticators/face_validation/error/decline"(platform: "/", type: TrackType.Event) {}

    "/authenticators/face_validation/error/retry"(platform: "/", type: TrackType.Event) {}

    def screenlockConfigStructure = objectSchemaDefinitions {
        transaction(required: true, type: PropertyType.String, values: ["enabled", "disabled"])
        opening_lock(required: true, type: PropertyType.String, values: ["enabled", "disabled"])
        transaction_granularity_option(required: true, type: PropertyType.String, values: ["always", "daily_amount"], description: "Granularity option selected by user")
        transaction_accumulated_amount(required: true, type: PropertyType.String, description: "User tx accumulated amount")
        transaction_custom(required: true, type: PropertyType.String, description: "Granularity amount on which screenLock will be triggered")
        opening_custom(required: true, type: PropertyType.String, description: "Elapsed time to ask for screenLock")
    }

    def transactionInformationStructure = objectSchemaDefinitions {
        amount(required: true, type: PropertyType.String, description: "amount of the transaction")
        type(required: true, type: PropertyType.String, values: ["transactional", "non_transactional", "other"])
    }

    def securityStatusResponse = objectSchemaDefinitions {
        type(required: true, type: PropertyType.String, values: ["SECURITY_BLOCKER", "AUTO_ENROLL", "NONE", "FORCE_STATUS"], description: "security_status type")
        flow_lock(required: true, type: PropertyType.Boolean, description: "flow_lock required status")
        app_lock(required: true, type: PropertyType.Boolean, description: "app_lock required status")
    }
    
    def applockFlowlockStructure = objectSchemaDefinitions {
        enabled(type: PropertyType.String, required: true, values: ["enabled", "disabled"])
        elapsed_time(type: PropertyType.Numeric, required: true, description: "elapsed time from the last applock finish to the start of the next flowlock")
        screenlock_validated(type: PropertyType.Boolean, required: true, description: "Identify if screenlock was used in validation")
    }

    // Biometrics / Screenlock
    "/screenlock"(platform: "/mobile", isAbstract: true, initiative: 1375) {
        enrollment_status(type: PropertyType.String, required: true, values: ["enabled", "disabled"])
        os_status(type: PropertyType.String, required: true, values: ["biometrics", "basic_screenlock", "none"])
    }
    
    "/screenlock/challenge"(platform: "/mobile", type: TrackType.View) {
        transaction_id(type: PropertyType.String, required: false)
        valid_params(type: PropertyType.Boolean, required: false)
    }

    "/screenlock/challenge/start"(platform: "/mobile", type: TrackType.Event) {
        transaction_id(type: PropertyType.String, required: true)
    }

    "/screenlock/challenge/end"(platform: "/mobile", type: TrackType.Event) {
        transaction_id(type: PropertyType.String, required: true)
        elapsed_time(type: PropertyType.Numeric, required: true, description: "elapsed time since challenge start was called")
        result(type: PropertyType.String, required: true, values: ["success", "error", "cancel"])
        error(type: PropertyType.String, required: false)
    }

    "/screenlock/challenge/finish"(platform: "/mobile", type: TrackType.Event) {
        transaction_id(type: PropertyType.String, required: true)
        challenge_time(type: PropertyType.Numeric, required: true, description: "elapsed time since challenge was showed")
    }
    
    "/screenlock/challenge/error"(platform: "/mobile", type: TrackType.View) {
        transaction_id(type: PropertyType.String, required: false)
    }

    "/screenlock/challenge/error/retry"(platform: "/mobile", type: TrackType.Event) {
        transaction_id(type: PropertyType.String, required: true)
    }

    "/screenlock/validation_start"(platform: "/mobile", type: TrackType.Event) {
        flow_id(type: PropertyType.String, required: true, description: "Flow identifier where validation is happening")
    }

    "/screenlock/validation_end"(platform: "/mobile", type: TrackType.Event) {
        flow_id(type: PropertyType.String, required: true)
        elapsed_time(type: PropertyType.Numeric, required: true, description: "elapsed time in os validation flow")
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
        transaction_information(type: PropertyType.Map(transactionInformationStructure), required: true, description: "transaction information")
        applock_flowlock_information(type: PropertyType.Map(applockFlowlockStructure), required: false, description: "applock flowlock information")
        result(type: PropertyType.String, required: true, values: ["success", "error"], description: "validation result")
        errors(type: PropertyType.ArrayList(PropertyType.String), required: false, description: "error description when validation fails")
        fallback_disabled(type: PropertyType.Boolean, required: true, description: "when a screenlock validation is made, fallback may be disabled")
        screenlock_method_used(PropertyType.String, required: false, values: ["unknown","biometrics","basic_screenlock"], description: "when validation succeeds, the screenlock method used is sent")
        biometrics_hash(PropertyType.String, required: false, description: "when validation succeeds and user used biometrics, this is an OS automatically generated biometrics hash.")
    }

    "/screenlock/security_status"(platform: "/mobile/ios", isAbstract: true, initiative: 1375) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
        from(type: PropertyType.String, required: true, values: ["force_block_refresh", "security_status"], description: "which service asked to get security_status")
    }

    "/screenlock/security_status/get"(platform: "/mobile/ios", type: TrackType.Event) {
        remote_config(type: PropertyType.String, required: true, values: ["enabled", "disabled"], description: "remote_config status")
        called(type: PropertyType.Boolean, required: true, description: "defines if get security status request was sent")
        last_status_expired(type: PropertyType.Boolean, required: false, description: "determine if the last security status retrieved has expired")
    }

    "/screenlock/security_status/result"(platform: "/mobile/ios", type: TrackType.Event) {
        result(type: PropertyType.String, required: true, values: ["success", "error"])
        response(type: PropertyType.Map(securityStatusResponse), required: false, description: "security_status request response")
    }

    "/screenlock/status"(platform: "/mobile", type: TrackType.Event) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
    }

    "/screenlock/opening_lock"(platform: "/mobile", type: TrackType.View) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
    }

    "/screenlock/opening_lock/error_presenting"(platform: "/mobile/ios", type: TrackType.Event) {
        vc_exists(type: PropertyType.Boolean, required: true, description: "Whether a vc existed when blocker was being presented or not")
        modal_presented(type: PropertyType.Boolean, required: true, description: "Whether a modal was currently presented on top vc or not")
    }

    "/screenlock/opening_lock/error_routing"(platform: "/mobile/ios", type: TrackType.Event) { }

    "/screenlock/opening_lock/retry"(platform: "/mobile", type: TrackType.Event) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
    }

    // Biometrics lib
    "/screenlock/biometrics"(platform: "/mobile/android", isAbstract: true, parentPropertiesInherited: false) {}

    "/screenlock/biometrics/failure"(platform: "/mobile/android", parentPropertiesInherited: false ,type: TrackType.Event) {
        os_status(type: PropertyType.String, required: true, values: ["biometrics", "basic_screenlock", "none"])
        error_msg_id(type: PropertyType.Numeric, required: true, description: "Error validation and fingerprintManager ID")
        error_msg(type: PropertyType.String, required: true, description: "Error validation and fingerprintManager message")
    }

    "/screenlock/biometrics/fallback"(platform: "/mobile/android", parentPropertiesInherited: false ,type: TrackType.Event) {}

    // Security Blocker
    "/screenlock/security_blocker"(platform: "/mobile", type: TrackType.View) {
        from(type: PropertyType.String, required: false, values: ["login", "registration", "sso", "campaign"])
        dismissible(required: false, type: PropertyType.String, values: ["enabled", "disabled"])
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
        scenario(type: PropertyType.String, required: true, values: ["no_security", "activate_security_success", "help", "test", "auto_enroll", "awareness", "insistence", "reminder1", "reminder2", "never_auto_enrolled", "both_enrolled", "single_enrolled", "none_enrolled", "blocker_enrolled"])
    }

    "/screenlock/security_blocker/ok"(platform: "/mobile", type: TrackType.Event) {
    }

    "/screenlock/security_blocker/configure"(platform: "/mobile/android", type: TrackType.Event) {
    }

    "/screenlock/security_blocker/dismiss"(platform: "/mobile", type: TrackType.Event) {
    }

    "/screenlock/multiple_sessions_shield"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
    }

    // IFPE Auth restrictions & Reauth errors
    "/auth/restrictions"(platform: "/", isAbstract: true, initiative: 1375) {}
    "/auth/restrictions"(platform: "/", type: TrackType.View) {}
    "/auth/restrictions/error"(platform: "/", type: TrackType.View) {
        retry_url_present(type: PropertyType.Boolean, required: true, description: "Whether the page was loaded with a URL to retry reauth or not")
    }
    "/auth/restrictions/error/retry"(platform: "/", type: TrackType.Event) {}

    // Native Reauth Mobile

    propertyDefinitions {
        transaction_id(type: PropertyType.String, required: false, description: "Reauthentication id Transaction")
        reauth_status(type: PropertyType.String, required: true, values: ["created", "not_needed", "error", "server_error", "client_error"], description: "Identify 201, 204 o error status by api result workflow decide")
    }

    propertyGroups {
        status(reauth_status, transaction_id)
    }

    "/reauth"(platform: "/mobile", isAbstract: true, initiative: 1375) {
        reauth_mods_id(type: PropertyType.String, required: true, description: "Specific identifier")
        operation_id(type: PropertyType.String, required: true, description: "Operation identifier where validation is happening")
        flow_type(type: PropertyType.String, required: true, values: ["other", "payment", "withdraw"], description: "Operation type")
        amount(type: PropertyType.String, required: false, description: "amount of the operation")
    }

    "/reauth/operation_start"(platform: "/mobile", type: TrackType.Event) {}

    "/reauth/operation_status"(platform: "/mobile", type: TrackType.Event) {
        status
    }

    "/reauth/operation_end"(platform: "/mobile", type: TrackType.Event) {
        result(type: PropertyType.String, required: true, values: ["success", "error", "cancel"])
        error(type: PropertyType.String, required: false)
        status
        screenlock_validated(type: PropertyType.Boolean, required: true, description: "Identify if screenlock was used in reauth validation")
        elapsed_time(type: PropertyType.Numeric, required: true, description: "elapsed time in os operation flow")
    }
    
    "/reauth/error"(platform: "/mobile", type: TrackType.View) {}

    "/reauth/error/retry"(platform: "/mobile", type: TrackType.Event) {}

    "/reauth/error/close"(platform: "/mobile", type: TrackType.Event) {}

    //Maybe deprecated tracks
    "/login/splitter"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_in"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_up"(platform: "/mobile", type: TrackType.View) {}
    "/login/identification"(platform: "/mobile") {}
    "/login_success"(platform: "/mobile/ios", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "When user login success in ios")
    }

}
