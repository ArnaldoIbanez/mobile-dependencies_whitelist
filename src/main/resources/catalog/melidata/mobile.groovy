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
        type (required: true, type: PropertyType.String, description: "Kind of device")
        date_created (required: true, type: PropertyType.String, description: "Device registration")
        lang (required: true, type: PropertyType.String, description: "Device language")
        timezone (required: true, type: PropertyType.String, description: "Device timezone")
        last_seen (required: false, type: PropertyType.String, description: "Last alive's signal")
        source (required: false, type: PropertyType.String, values: ["test", "uninstalls_checker_flow", "token_purge"], description: "Source that set status")
        current_checking_day (required: false, type: PropertyType.Numeric, description: "Day that is checking status")
        execution_id (required: false, type: PropertyType.String, description: "The execution id")
        app_storage (required: false, type: PropertyType.Numeric, description: "App storage on device")
        free_storage (required: false, type: PropertyType.Numeric, description: "Free storage on device")
        total_storage (required: false, type: PropertyType.Numeric, description: "Total storage on device")
    }

    "/application/not_engaged" (platform: "/mobile", type: TrackType.Event){
        type (required: true, type: PropertyType.String, description: "Kind of device")
        date_created (required: true, type: PropertyType.String, description: "Device registration")
        lang (required: true, type: PropertyType.String, description: "Device language")
        timezone (required: true, type: PropertyType.String, description: "Device timezone")
        last_seen (required: false, type: PropertyType.String, description: "Last alive's signal")
        source (required: false, type: PropertyType.String, values: ["test", "uninstalls_checker_flow", "token_purge"], description: "Source that set status")
        current_checking_day (required: false, type: PropertyType.Numeric, description: "Day that is checking status")
        execution_id (required: false, type: PropertyType.String, description: "The execution id")
        app_storage (required: false, type: PropertyType.Numeric, description: "App storage on device")
        free_storage (required: false, type: PropertyType.Numeric, description: "Free storage on device")
        total_storage (required: false, type: PropertyType.Numeric, description: "Total storage on device")
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
    
    "/permissions/idfa"(platform: "/mobile", isAbstract: true){}
    "/permissions/idfa/accept"(platform: "/mobile", type: TrackType.Event){}
    "/permissions/idfa/denied"(platform: "/mobile", type: TrackType.Event){}
    "/permissions/idfa/shown"(platform: "/mobile", type: TrackType.Event){}

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

    "/landing/deeplinks"(platform: "/mobile") {
        desired_link(required:true, type: PropertyType.String, descripcion: "Original Link where we want to search for a Target Link")
        target_link(required:false, type: PropertyType.String, descripcion:"The Target Link that was retrieved by the Original Link")
        message(required:false, type: PropertyType.String, descripcion: "Extra message for Error Description")
    }

    "/landing/load"(platform: "/mobile") {
        status(required: true, type: PropertyType.String, values: ["success", "cancelled", "error"], description: "Loading finish status")
        url(required: true, type: PropertyType.String, description: "The url to be loaded in the landing webview")
        loading_time(required: true, type: PropertyType.Numeric, description: "Loading time in milliseconds")
    }

    "/sso" (platform: "/mobile", isAbstract: true){}
    "/sso/login_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/logout_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/attempt_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/attempt_error" (platform: "/mobile", type: TrackType.Event){}

    /**
     * DEVICES
     */

    "/devices"(platform: "/", isAbstract: true){}
    
    // Device Metadata sent from backend (Notifications ACK) & application startup
    "/devices/metadata"(platform: "/", type: TrackType.Event) {
        total_storage(required: true, type: PropertyType.Numeric, description: "Total storage in the device in bytes")
        free_storage(required: true, type: PropertyType.Numeric, description: "Free storage in the device in bytes")
        app_storage(required: true, type: PropertyType.Numeric, description: "Application occupied storage in bytes")
        app_cache(required: false, type: PropertyType.Numeric, description: "Application cache occupied storage in bytes")
        app_data(required: false, type: PropertyType.Numeric, description: "Application data occupied storage in bytes")
        dark_mode_status(required: false, type: PropertyType.String, values: ["enabled", "battery_enabled", "disabled", "undefined"],
         description: "Dark Mode status")
        battery_save_mode(required: false, type: PropertyType.String, values: ["enabled", "disabled"], description: "Battery Save mode")
        data_save_mode(required: false, type: PropertyType.String, values: ["enabled", "disabled", "whitelisted", "undefined"], description: "Data Save mode")
        do_not_disturb_mode(required: false, type: PropertyType.String, values: ["disabled", "important_interruptions", "no_interruptions", "alarms_only", "undefined"], description: "Do Not Disturb mode")
        carrier_code(required: false, type: PropertyType.String, description: "Carrier code of the network provider (MCC+MNC)")
        carrier_name(required: false, type: PropertyType.String, description: "Name of the carrier network provider")
        nfc_compatible(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Nfc compatible with the device")
        nfc_enabled(required: false, type: PropertyType.Boolean, description: "Nfc is enabled or not")
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

    "/devices/websec"(platform:"/mobile/android", isAbstract:true) {}

    "/devices/websec/deeplinks_data"(platform: "/mobile/android", type:TrackType.Event){
        from(required: false, type: PropertyType.String, description: "From where is the navigation originated")
        destination(required: false, type: PropertyType.String, description: "Activity which will render the deeplink")
        scheme(required: false, type: PropertyType.String, description: "The scheme")
        encodedUri(required: false, type: PropertyType.String, description: "Full encoded deeplink uri")
        segments(required: false, type: PropertyType.String, description: "All segments")
        query(required: false, type: PropertyType.String, description: "Full deeplink query")
    }

    //apprater
    "/apprater"(platform:"/mobile", isAbstract:true) {}

    "/apprater/add_track"(platform: "/mobile") {
        type_track(required: true, type: PropertyType.String, description:"Type of track that happen in the app (PAYMENT_APPROVE,CRASHED,WITHDRAW,etc")
    }
    "/apprater/error_service_rules"(platform: "/mobile") {
    }
    "/apprater/popup"(platform: "/mobile") {
    }
}
