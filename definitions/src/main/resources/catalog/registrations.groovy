
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    // REGISTER

    "/register"(platform: "/", isAbstract: true) {}

    "/register/success"(platform: "/") {
        source()
    }

    "/register/failure"(platform: "/mobile") {
        source()
    }

    "/register/facebook_permissions"(platform: "/") {
        login_status(type: PropertyType.String, description: "Success, Cancel, Error")
        email(type: PropertyType.Boolean, description : "Needed  to access the user main email address.")
        user_birthday(type: PropertyType.Boolean, description : "Needed  to access date (day and month) of the user birthday.")
        user_likes(type: PropertyType.Boolean, description : "Needed  to access user liked pages.")
    }

    //REGISTER WEB

    "/register/form"(platform:"/web", type: TrackType.View) {
        app(type: PropertyType.String, description: "Registration app", required:true)
        source(type: PropertyType.String, description: "Source (on mobile is facebook/email, on web at the moment is only email)", required:true)
        item_id(type: PropertyType.String, description: "Item", required:false)
        captcha_showed(type: PropertyType.Boolean, description: "If captcha is showed", required:true)
        prog_reg_version(type: PropertyType.Numeric, description: "Version of progressive registration, if is 0 is normal registration", required:true)
    }

    "/register/optin"(platform:"/web", type: TrackType.View) {
        app(type: PropertyType.String, description: "Registration app", required:true)
        prog_reg_version(type: PropertyType.Numeric, description: "Version of progressive registration, if is 0 is normal registration", required:true)
    }

    "/register/form/error"(platform:"/web", type: TrackType.View) {
        errors_validation(type: PropertyType.String, description: "Where the validation is performed. back|front", required:false)
        errors(type: PropertyType.ArrayList, description: "Errors on form", required:false)
    }

    "/register/form/another-email"(platform:"/web", type: TrackType.View) {
        errors_validation(type: PropertyType.String, description: "Where the validation is performed. back|front", required:false)
        errors(type: PropertyType.ArrayList, description: "Errors on form", required:false)
    }

    "/register/form/site-identification"(platform:"/web", type: TrackType.View) {
        ip_site_id(type: PropertyType.String, description: "site_id of IP site identification", required:true)
    }

    "/register/form/site-identification/url-site-selected"(platform:"/web", type: TrackType.Event) {}
    "/register/form/site-identification/ip-site-selected"(platform:"/web", type: TrackType.Event) {}

    "/register/form/facebook-connect"(platform:"/web", type: TrackType.View) {
    }

    "/register/form/facebook-connect/facebook-register-selected"(platform:"/web", type: TrackType.Event) {}
    "/register/form/facebook-connect/email-register-selected"(platform:"/web", type: TrackType.Event) {}
    "/register/form/facebook-connect/login-selected"(platform:"/web", type: TrackType.Event) {}

    "/register/form/geolocation"(platform:"/web/mobile", type: TrackType.Event) {
        geo_location_code(type: PropertyType.Numeric, description: "Code of geolocation result", required:true)
    }

    "/register/success"(platform:"/web", type: TrackType.Event) {
        app(type: PropertyType.String, description: "Registration app", required:true)
        item_id(type: PropertyType.String, description: "Item", required:false)
        captcha_showed(type: PropertyType.Boolean, description: "If captcha is showed", required:true)
        prog_reg_version(type: PropertyType.Numeric, description: "Version of progressive registration, if is 0 is normal registration", required:true)
    }

    // Account recovery event
    "/register/accountRecovery"(platform: "/mobile", type: TrackType.Event) {
        error_type(required:true, description: "connectionError/invalidOneTimePassword/operatorNotSupported")
    }

    "/register/hub"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
    }
    "/register/hub/register-with-email"(platform: "/mobile", type: TrackType.Event){}
    "/register/hub/register-with-facebook"(platform: "/mobile", type: TrackType.Event){}

    "/register/form"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
    }

    "/register/form/error"(platform:"/mobile", type: TrackType.View) {
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
    }

    "/register/account-recovery-hub/account-recovery"(platform: "/mobile", type: TrackType.Event){}
    "/register/account-recovery-hub/use-another-email"(platform: "/mobile", type: TrackType.Event){}

    "/register/congrats"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
    }

    "/register/form/skip-update"(platform: "/web", type: TrackType.View){}
    "/register/optin/push"(platform: "/web", type: TrackType.View){}
    "/register/optin/skip"(platform: "/web", type: TrackType.View){}
    "/register/form/email-suggest"(platform: "/web", type: TrackType.Event){}

    "/register/form/update"(platform: "/mobile", type: TrackType.View){
        app(type: PropertyType.String, required:true, description: "Current Flow")
        origin(type: PropertyType.String, required:false, description: "The source where the flow was called")
        item_id(type: PropertyType.String, required:false, description: "Item" )
    }

    "/register/form/update/error"(platform:"/mobile", type: TrackType.View) {
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

}

