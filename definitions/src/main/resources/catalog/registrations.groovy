
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

    "/register/facebook_permissions"(platform: "/mobile"){
        login_status(type: PropertyType.String, description: "Success, Cancel, Error" )
        email(type: PropertyType.Boolean, description : " Needed  to access date (day and month) of the user birthday.")
        user_birthday(type: PropertyType.Boolean, description : " Needed  to access the user main email address.")
        user_likes(type: PropertyType.Boolean, description : " Needed  to access user liked pages.")
    }

    //REGISTER WEB

    "/register/form"(platform:"/web", type: TrackType.View) {
        app(type: PropertyType.String, description: "Registration app", required:true)
        source(type: PropertyType.String, description: "Source (on mobile is facebook/email, on web at the moment is only email)", required:true)
        item_id(type: PropertyType.String, description: "Item", required:false)
        captcha_showed(type: PropertyType.Boolean, description: "If captcha is showed", required:true)
    }

    "/register/form/error"(platform:"/web", type: TrackType.View) {
        errors(type: PropertyType.ArrayList, description: "Errors on form", required:false)
    }

    "/register/form/another-email"(platform:"/web", type: TrackType.View) {
        errors(type: PropertyType.ArrayList, description: "Errors on form", required:false)
    }

    "/register/success"(platform:"/web", type: TrackType.Event) {
        app(type: PropertyType.String, description: "Registration app", required:true)
        item_id(type: PropertyType.String, description: "Item", required:false)
        captcha_showed(type: PropertyType.Boolean, description: "If captcha is showed", required:true)
    }

    // Account recovery event
    "/register/accountRecovery"(platform: "/mobile", type: TrackType.Event) {
        error_type(required:true, description: "connectionError/invalidOneTimePassword/operatorNotSupported")
    }
}

