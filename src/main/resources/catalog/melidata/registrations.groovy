package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1254"

    // REGISTER

    "/register"(platform: "/", isAbstract: true) {}
    "/register/company"(platform: "/", isAbstract: true) {}

    "/register/success"(platform: "/") {
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
        // TODO: In the future register_type might be "required: true". We have to do some changes for that
        register_type(type: PropertyType.String, required:false, description: "User type", values: ["person", "company"])
    }

    "/register/failure"(platform: "/mobile") {
        source()
    }

    "/register/facebook_permissions"(platform: "/") {
        login_status(type: PropertyType.String, description: "Success, Cancel, Error", required:true)
        email(type: PropertyType.Boolean, description : "Needed  to access the user main email address.", required:false)
        user_birthday(type: PropertyType.Boolean, description : "Needed  to access date (day and month) of the user birthday.", required:false)
        user_likes(type: PropertyType.Boolean, description : "Needed  to access user liked pages.", required:false)
    }

    // REGISTER WEB

    "/register/form"(platform: "/web", type: TrackType.View) {
        app(type: PropertyType.String, description: "Current Flow", required:true)
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        source(type: PropertyType.String, description: "Source", required:true, values:["email","facebook","facebook_to_email"])
        item_id(type: PropertyType.String, description: "Item", required:false)
        captcha_showed(type: PropertyType.Boolean, description: "If captcha is showed", required:true)
        prog_reg_version(type: PropertyType.Numeric, description: "Version of progressive registration, if is 0 is normal registration", required:true)
        registration_version(type: PropertyType.String, required:false, description: "Registration Version")
    }

    "/register/optin"(platform: "/web", type: TrackType.View) {
        app(type: PropertyType.String, description: "Current Flow", required:true)
        source(type: PropertyType.String, description: "Source", required:true, values:["email","facebook","facebook_to_email"])
        item_id(type: PropertyType.String, description: "Item", required:false)
        captcha_showed(type: PropertyType.Boolean, description: "If captcha is showed", required:true)
        prog_reg_version(type: PropertyType.Numeric, description: "Version of progressive registration, if is 0 is normal registration", required:true)
    }

    "/register/form/error"(platform: "/web", type: TrackType.View) {
        errors_validation(type: PropertyType.String, description: "Where the validation is performed. back|front", required:false)
        errors(type: PropertyType.ArrayList, description: "Errors on form", required:false)
    }

    "/register/form/another-email"(platform: "/web", type: TrackType.View) {
        errors_validation(type: PropertyType.String, description: "Where the validation is performed. back|front", required:false)
        errors(type: PropertyType.ArrayList, description: "Errors on form", required:false)
    }

    "/register/form/site-identification"(platform: "/web", type: TrackType.View) {
        ip_site_id(type: PropertyType.String, description: "site_id of IP site identification", required:true)
    }

    "/register/form/site-identification/url-site-selected"(platform: "/web", type: TrackType.Event) {}
    "/register/form/site-identification/ip-site-selected"(platform: "/web", type: TrackType.Event) {}

    "/register/form/geolocation"(platform: "/web/mobile", type: TrackType.Event) {
        geo_location_code(type: PropertyType.Numeric, description: "Code of geolocation result", required:true)
    }

    "/register/success"(platform: "/web", type: TrackType.Event) {
        source(type: PropertyType.String, required:true, description: "Source", values:["email","facebook","facebook_to_email"])
        app(type: PropertyType.String, required:true, description: "Current Flow")
        captcha_showed(type: PropertyType.Boolean, required:true, description: "If captcha is showed")
        prog_reg_version(type: PropertyType.Numeric, required:true, description: "Version of progressive registration, if is 0 is normal registration")
    }

    "/register/successful-update"(platform: "/web", type: TrackType.Event) {
        source(type: PropertyType.String, required:true, description: "Source", values:["email","facebook","facebook_to_email"])
        app(type: PropertyType.String, required:true, description: "Current Flow")
        captcha_showed(type: PropertyType.Boolean, required:true, description: "If captcha is showed")
        prog_reg_version(type: PropertyType.Numeric, required:true, description: "Version of progressive registration, if is 0 is normal registration")
    }

    "/register/congrats"(platform: "/web", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        source(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
        // TODO: In the future register_type might be "required: true". We have to do some changes for that
        register_type(type: PropertyType.String, required: false, description: "User type", values: ["person", "company"])
        registration_version(type: PropertyType.String, required: false, description: "Registration Version")
        captcha_showed(type: PropertyType.Boolean, description: "Checks if the registration done had a recaptcha")
        prog_reg_version(type: PropertyType.Numeric, required:false, description: "Version of progressive registration, if is 0 is normal registration")
    }

    "/register/form/skip-update"(platform: "/web", type: TrackType.View){}
    "/register/optin/push"(platform: "/web", type: TrackType.View){}
    "/register/optin/skip"(platform: "/web", type: TrackType.View){}
    "/register/form/email-suggest"(platform: "/web", type: TrackType.Event){}

    // REGISTER MOBILE

    // Account recovery event
    "/register/accountRecovery"(platform: "/mobile", type: TrackType.Event) {
        error_type(required:true, description: "connectionError/invalidOneTimePassword/operatorNotSupported")
    }

    "/register/hub"(platform: "/mobile", type: TrackType.View){
        registration_version(type: PropertyType.String, description: "Registration Version")
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
    }
    "/register/hub/register-with-email"(platform: "/mobile", type: TrackType.Event){}

    "/register/form"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
        // TODO: In the future register_type might be "required: true". We have to do some changes for that
        register_type(type: PropertyType.String, required: false, description: "User type", values: ["person", "company"])
        source(type: PropertyType.String, description: "Source", required:false, values:["email","facebook","facebook_to_email"])
        captcha_showed(type: PropertyType.Boolean, description: "If captcha is showed", required:false)
        prog_reg_version(type: PropertyType.Numeric, description: "Version of progressive registration, if is 0 is normal registration", required:false)
        registration_version(type: PropertyType.String, required:false, description: "Registration Version")
    }
    "/register/form/validate"(platform: "/mobile/ios", type: TrackType.Event){
      step_valid(type: PropertyType.String, required: true, description: "checks if TyC checkbox is marked")
      checkbox_valid(type: PropertyType.String, required: true, description: "checks if all fields have been completed")
      components_valid(type: PropertyType.String, required: true, description: "checks if all fields, tyc included, are completed")
    }
    "/register/form/validate"(platform: "/mobile/android", type: TrackType.Event){
      step_valid(type: PropertyType.Boolean, required: true, description: "checks if TyC checkbox is marked")
      checkbox_valid(type: PropertyType.Boolean, required: true, description: "checks if all fields have been completed")
      components_valid(type: PropertyType.Boolean, required: true, description: "checks if all fields, tyc included, are completed")
    }
    "/register/form/continue"(platform: "/mobile", type: TrackType.Event){}

    "/register/form/email-suggest"(platform: "/mobile", type: TrackType.Event){}
    "/register/form/google_hint"(platform: "/mobile", isAbstract: true){
        step(type: PropertyType.String, required: true, values: ["registration", "phoneRegistration", "getEmail"], description: "Step where the google hint is provided to the user")
        field(type: PropertyType.String, required: true, values: ["email", "phone"], description: "Field where the google hint is provided to the user")
    }
    "/register/form/google_hint/show"(platform: "/mobile", type: TrackType.Event){}
    "/register/form/google_hint/select"(platform: "/mobile", type: TrackType.Event){}

    "/register/form/challenge"(platform: "/mobile", isAbstract: true){}
    "/register/form/challenge/require"(platform: "/mobile", type: TrackType.Event){}
    "/register/form/challenge/show"(platform: "/mobile", type: TrackType.Event){}
    "/register/form/challenge/cancel"(platform: "/mobile", type: TrackType.Event){}
    "/register/form/challenge/solve"(platform: "/mobile", type: TrackType.Event){}

    "/register/success"(platform: "/mobile", type: TrackType.Event){
        source(type: PropertyType.String, description: "Source", required:false, values:["email","facebook","facebook_to_email", "phone"])
        app(type: PropertyType.String, required:false, description: "Current Flow")
    }

    "/register/form/error"(platform: "/mobile", type: TrackType.View) {
        errors_validation(type: PropertyType.String, description: "Where the validation is performed. back|front", required:false)
        errors(type: PropertyType.ArrayList, description: "Errors on form", required:false)
    }

    "/register/form/another-email"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
    }

    "/register/account-recovery-hub"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
        registration_version(type: PropertyType.String, required:false, description: "Registration Version")
    }

    "/register/account-recovery-hub/account-recovery"(platform: "/mobile", type: TrackType.Event){}
    "/register/account-recovery-hub/use-another-email"(platform: "/mobile", type: TrackType.Event){}

    "/register/congrats"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
        // TODO: In the future register_type might be "required: true". We have to do some changes for that
        register_type(type: PropertyType.String, required: false, description: "User type", values: ["person", "company"])
        registration_version(type: PropertyType.String, description: "Registration Version")
    }

    "/register/form/update"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
    }

    "/register/form/update/error"(platform: "/mobile", type: TrackType.View) {
        errors_validation(type: PropertyType.String, description: "Where the validation is performed. back|front", required:false)
        errors(type: PropertyType.ArrayList, description: "Errors on form", required:false)
    }

    "/register/form/update/save"(platform: "/mobile", type: TrackType.Event){}
    "/register/form/update/not-now"(platform: "/mobile", type: TrackType.Event){}

    "/register/successful-update"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
    }

    "/register/upgrade_version"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, description: "Current Flow")
        origin(type: PropertyType.String, description: "The source where the flow was called")
        registration_version(type: PropertyType.String, description: "Registration Version" )
    }

    // TODO, PLEASE MOVE THIS TO SOMETHING LIKE /register/progresive o algo que sea más acorde a todo el tracking del modulo
    "/progressive_registration"(platform: "/mobile", type: TrackType.View, initiative:'1125') {}


    // Company Registration

    "/register/company/form"(platform: "/web", type: TrackType.View){}
    "/register/company/congrats"(platform: "/web", type: TrackType.View){}
    "/register/company/form/error"(platform: "/web", type: TrackType.Event){
        errors(type: PropertyType.ArrayList, description: "Errores en el formulario", required: true)
    }

    "/register/congrats/complete-fiscal-data"(platform: "/mobile", type: TrackType.Event){}
    "/register/congrats/complete-fiscal-data-later"(platform: "/mobile", type: TrackType.Event){}

    // Registro V3 HUB
    "/register/v3"(platform: "/", isAbstract: true){}
    "/register/v3/hub"(platform: "/", isAbstract: true){}
    "/register/v3/hub/landing"(platform: "/", type: TrackType.View){}
    "/register/v3/hub/main"(platform: "/", type: TrackType.View){
      status(type: PropertyType.String, required: true, values: ["finished", "in_progress"], description: "Registration HUB global status")
      steps(type: PropertyType.ArrayList, , required:true, description: "Array of objects indicating each step id and status")
    }
    
    "/register/v3/hub/email_validation"(platform: "/", isAbstract: true){}
    "/register/v3/hub/phone_validation"(platform: "/", isAbstract: true){}
    "/register/v3/hub/kyc"(platform: "/", isAbstract: true){}
    "/register/v3/hub/pix"(platform: "/", isAbstract: true){}
    "/register/v3/hub/regulation"(platform: "/", isAbstract: true){}
    "/register/v3/hub/congrats"(platform: "/", isAbstract: true){}
    "/register/v3/hub/email_validation/congrats"(platform: "/", type: TrackType.View){}
    "/register/v3/hub/phone_validation/congrats"(platform: "/", type: TrackType.View){}
    "/register/v3/hub/kyc/congrats"(platform: "/", type: TrackType.View){}
    "/register/v3/hub/pix/congrats"(platform: "/", type: TrackType.View){}
    "/register/v3/hub/regulations/congrats"(platform: "/", type: TrackType.View){}
    "/register/v3/hub/tyc/congrats"(platform: "/", type: TrackType.View){}
    "/register/v3/hub/congrats"(platform: "/", type: TrackType.View){}
}
