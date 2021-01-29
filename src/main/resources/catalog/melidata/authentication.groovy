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

    initiative = "1254"

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

    //Abuse Prevention
    "/auth"(platform: "/", isAbstract: true) {}

    //Security Feedback
    "/login/auth/feedback"(platform: "/", type: TrackType.Event, initiative: 1127) {
        view(type: PropertyType.String, required: true, description: "Current Feedback step name where the action is taking place")
        event_type(type: PropertyType.String, required: true, description: "Describes user action in current step")
        view_type(type: PropertyType.String, required: false, description: "Feedback step flavor, dependent on user answer")
        notification_id(type: PropertyType.String, required: false, description: "Current notification id, when it applies")
        phone_status(type: PropertyType.String, required: false, description: "Whether the user has phone or not, dependent on step")
    }

    //Account Recovery
    "/auth/account_recovery"(platform: "/", isAbstract: true, initiative: 1127) {
        id(type: PropertyType.String, required: true, description: "Current transaction id")
        is_webview(type: PropertyType.Boolean, required: true, description: "Identifies if request comes from webview")
    }

    "/auth/account_recovery/landing"(platform: "/", type: TrackType.View) {}

    "/auth/account_recovery/on_hold"(platform: "/", type: TrackType.View) {}

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

    "/auth/account_recovery/confirm/action"(platform: "/", type: TrackType.View) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    "/auth/account_recovery/congrats/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: false, description: "Describes user action in current step")
        target(type: PropertyType.String, required: false, description: "Describes element related to user action")
    }

    //TOTP
    "/auth/totp"(platform: "/", isAbstract: true, initiative: 1127) {
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

    //Attestation App
    "/auth/attestation"(platform: "/mobile", isAbstract: true, initiative: 1127) {}

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

    "/authenticators"(platform: "/", isAbstract: true, ) {}
    
    // Device Authorization Authenticator

    "/authenticators/device_authorization"(platform: "/", isAbstract: true, initiative: 1127) {}

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
        status(PropertyType.String, required: true, values: ["success", "failure", "pending_validation", "validated" ], description: "challenge status by response")
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

    "/authenticators/email_validation/enter_code"(platform: "/", type: TrackType.View) {}

    "/authenticators/email_validation/enter_code/submit"(platform: "/", type: TrackType.Event) {
        validation_status(PropertyType.String, required: false, values:["success", "failure"], description: "Challenge status by response")
    }

    "/authenticators/email_validation/social_oauth"(platform: "/", type: TrackType.View) {
        social_option(PropertyType.String, required: true, values: ["Google", "Microsoft"], description: "Social option displayed")
    }

    "/authenticators/email_validation/social_oauth/submit"(platform: "/", type: TrackType.Event) {
        validation_status(PropertyType.String, required: false, values:["success", "failure"], description: "Challenge status by response")
        email_sign_in(PropertyType.Boolean, required: false, description: "User decide to sign in with email")
    }

    def screenlockConfigStructure = objectSchemaDefinitions {
        transaction(required: true, type: PropertyType.String, values: ["enabled", "disabled"])
        opening_lock(required: true, type: PropertyType.String, values: ["enabled", "disabled"])
        transaction_custom(required: true, type: PropertyType.String, description: "Amount on which screenLock will be triggered")
        opening_custom(required: true, type: PropertyType.String, description: "Elapsed time to ask for screenLock")
    }

    def transactionInformationStructure = objectSchemaDefinitions {
        amount(required: true, type: PropertyType.String, description: "amount of the transaction")
        type(required: true, type: PropertyType.String, values: ["transactional", "non_transactional", "other"])
    }

    // Biometrics / Screenlock
    "/screenlock"(platform: "/mobile", isAbstract: true, initiative: 1127) {
        enrollment_status(type: PropertyType.String, required: true, values: ["enabled", "disabled"])
        os_status(type: PropertyType.String, required: true, values: ["biometrics", "basic_screenlock", "none"])
    }

    "/screenlock/validation_start"(platform: "/mobile", type: TrackType.Event) {
        flow_id(type: PropertyType.String, required: true, description: "Flow identifier where validation is happening")
     }

    "/screenlock/validation_end"(platform: "/mobile", type: TrackType.Event) {
        flow_id(type: PropertyType.String, required: true)
        elapsed_time(type: PropertyType.Numeric, required: true, description: "elapsed time in os validation flow")
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
        transaction_information(type: PropertyType.Map(transactionInformationStructure), required: true, description: "transaction information")
        result(type: PropertyType.String, required: true, values: ["success", "error"])
        errors(type: PropertyType.ArrayList, required: false)
    }

    "/screenlock/status"(platform: "/mobile", type: TrackType.Event) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
    }

    "/screenlock/opening_lock"(platform: "/mobile", type: TrackType.View) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
    }

    "/screenlock/opening_lock/retry"(platform: "/mobile", type: TrackType.Event) {
        config(type: PropertyType.Map(screenlockConfigStructure), required: true, description: "current screenlock config")
    }

    // Biometrics lib
    "/screenlock/biometrics"(platform: "/mobile/android", isAbstract: true, parentPropertiesInherited: false) {
    }

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
        scenario(type: PropertyType.String, required: true, values: ["no_security", "activate_security_success", "help", "test", "auto_enroll", "awareness", "insistence", "reminder1", "reminder2", "never_auto_enrolled", "both_enrolled", "single_enrolled", "none_enrolled"])
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
    "/auth/restrictions"(platform: "/", isAbstract: true, initiative: 1127) {}
    "/auth/restrictions"(platform: "/", type: TrackType.View) {}
    "/auth/restrictions/error"(platform: "/", type: TrackType.View) {
        retry_url_present(type: PropertyType.Boolean, required: true, description: "Whether the page was loaded with a URL to retry reauth or not")
    }
    "/auth/restrictions/error/retry"(platform: "/", type: TrackType.Event) {}

    //Maybe deprecated tracks
    "/login/splitter"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_in"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_up"(platform: "/mobile", type: TrackType.View) {}
    "/login/identification"(platform: "/mobile") {}
    "/login_success"(platform: "/mobile/ios", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "When user login success in ios")
    }

}
