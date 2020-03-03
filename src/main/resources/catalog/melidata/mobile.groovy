package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType

tracks {

    initiative = "1096"

    //Navigation
    "/navigation"(platform: "/mobile") {
        origin(required: false, type: PropertyType.String, description: "Analytic's name of the screen where the menu was opened")
    }

    "/navigation/drawer"(platform: "/mobile/android", type: TrackType.Event) {
        section(required: true, type: PropertyType.String, description: "Destination host after click")
    }

    "/navigation/tabs"(platform: "/mobile/ios", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Kind of navigation action")
        tab(required: true, type: PropertyType.String, description: "Indicates which tab was selected")
    }

    "/navigation/cart"(platform: "/mobile/ios", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Kind of navigation action")
        origin(required: true, type: PropertyType.String, description: "Name of the screen where the Cart button was selected")
    }

    "/application"(platform:"/mobile", isAbstract: true) {}
    "/application/open"(platform:"/mobile", type: TrackType.Event) { }

    "/application/workaround"(platform: "/mobile/android", isAbstract: true) {}
    "/application/workaround/nohistory"(platform: "/mobile/android", type: TrackType.Event) {}

    "/application/install_event" (platform: "/mobile", type: TrackType.Event){
        deeplink (required: false, type: PropertyType.String)
        exception (required: false, type: PropertyType.String)
    }

    "/application/uninstall_event" (platform: "/mobile", type: TrackType.Event){
        type (required: true, type: PropertyType.String)
        date_created (required: true, type: PropertyType.String)
        lang (required: true, type: PropertyType.String)
        timezone (required: true, type: PropertyType.String)
    }

    "/permissions"(platform: "/mobile", isAbstract: true){}
    "/permissions/location"(platform: "/mobile", type: TrackType.View){
        context(required: "true", description: "Where are we requesting the permissions")
    }
    "/permissions/location/custom"(platform: "/mobile", isAbstract: true){}
    "/permissions/location/custom/accept"(platform: "/mobile", type: TrackType.Event){}
    "/permissions/location/custom/deny"(platform: "/mobile", type: TrackType.Event){}
    "/permissions/location/native"(platform: "/mobile", isAbstract: true){}
    "/permissions/location/native/accept"(platform: "/mobile", type: TrackType.Event){}
    "/permissions/location/native/deny"(platform: "/mobile", type: TrackType.Event){}

    "/settings"(platform: "/mobile", isAbstract: true){}
    "/settings/about"(platform: "/mobile", type: TrackType.View){}
    "/settings/country"(platform: "/mobile", type: TrackType.View){}

    "/landing"(platform: "/mobile", isAbstract: true) {}

    "/landing/generic"(platform: "/mobile") {
        version(required:false, descripcion: "Version of generic landing")
        url(required:true, descripcion:"The url to be loaded by the generic landing")
        is_main_url(required:false, type: PropertyType.Boolean,
                descripcion: "True if the url is the first url to be loaded. Next urls will have this flag in false (redirects, taps)")
    }

    "/sso" (platform: "/mobile", isAbstract: true){}
    "/sso/login_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/logout_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/attempt_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/attempt_error" (platform: "/mobile", type: TrackType.Event){}

    /**
     * DEVICES
     */

    // Device Metadata sent from backend (Notifications ACK) & application startup
    "/device_metadata"(platform: "/", type: TrackType.Event) {
        total_storage(required: true, type: PropertyType.Numeric, description: "Total storage in the device in bytes")
        free_storage(required: true, type: PropertyType.Numeric, description: "Free storage in the device in bytes")
        app_storage(required: true, type: PropertyType.Numeric, description: "Application occupied storage in bytes")
    }

    "/devices_settings"(platform:"/mobile", isAbstract:true) {}

    //Bloqueo de notificaciones (Android > = API 19)
    "/devices_settings/notifications"(platform:"/mobile", type:TrackType.Event) {
        enable(required:true, type:PropertyType.Boolean)
        registration_id(required:true, type:PropertyType.String)
        device_id(required:true, type:PropertyType.String)
    }

    "/device_settings"(platform: "/", isAbstract: true){}

    "/device_settings/notifications"(platform: "/mobile/android", type:TrackType.Event) {
        device_id(required: true, description: "The real device_id, may differ from device field")
        enable(required:true, type:PropertyType.Boolean, description: "Indicates if settings are enabled")
        registration_id(required: false, description: "The registration id", type: PropertyType.String)
    }
}
