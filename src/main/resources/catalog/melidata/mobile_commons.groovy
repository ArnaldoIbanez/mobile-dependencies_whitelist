package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {

    initiative = '1096'


    // Splash
    "/splash_activity"(platform: "/mobile", type: TrackType.View) {}

    // Generic error
    "/friction"(platform: "/mobile", type: TrackType.Event) {
        path(required: true, type: PropertyType.String , description: "Error path")
        style(required: true, type: PropertyType.String , description: "Error style")
        id(required: true, type: PropertyType.String , description: "Error id")
        message(required: false, type: PropertyType.String , description: "Error message")
        attributable_to(required: true, type: PropertyType.String , description: "Responsable for error", values: ["mercadopago" , "merchant", "user"])
        extra_info(required: true, description: "Extra error info")
        session_id(required: false, descriptiono: "Identifier of the user session")
    }

    "/in_app_updates"(platform: "/mobile", isAbstract: true){}
    "/in_app_updates/inactive"(platform: "/mobile", isAbstract: true){}
    "/in_app_updates/inactive/showed"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update FLEXIBLE | IMMEDIATE | LEGACY")
    }
    "/in_app_updates/inactive/accepted"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update IMMEDIATE | LEGACY")
    }
    "/in_app_updates/updatable"(platform: "/mobile", isAbstract: true){}
    "/in_app_updates/updatable/showed"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update FLEXIBLE | IMMEDIATE | LEGACY")
    }
    "/in_app_updates/updatable/accepted"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update FLEXIBLE | IMMEDIATE | LEGACY")
    }
    "/in_app_updates/updatable/postponed"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update FLEXIBLE | IMMEDIATE | LEGACY")
    }
    "/in_app_updates/updatable/update_failed"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update FLEXIBLE | IMMEDIATE | LEGACY")
    }
    "/in_app_updates/inactive/update_failed"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update FLEXIBLE | IMMEDIATE | LEGACY")
    }    
    "/in_app_updates/updatable/update_not_available"(platform: "/mobile", type: TrackType.Event){
        cause (required: true, type: PropertyType.String, description: "why we dont show the dialog of update")
    }
    "/in_app_updates/updatable/installed"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update FLEXIBLE | IMMEDIATE | LEGACY")
    }
    "/in_app_updates/inactive/installed"(platform: "/mobile", type: TrackType.Event){
        version (required: true, type: PropertyType.String, description: "v1 if bump legacy, v2 if in-app-update implemented")
        type (required: true, type: PropertyType.String, description: "type of in-app-update FLEXIBLE | IMMEDIATE | LEGACY")
    }

    "/cross_app_links"(platform: "/mobile", isAbstract: true){}
    "/cross_app_links/dispatch"(platform: "/mobile", type: TrackType.Event){
        link (required: true, type: PropertyType.String, description: "dispatched link")
        result (required: true, type: PropertyType.String, description: "result class name")
        reason (required: false, type: PropertyType.String, description: "result reason class in case its result is error")
        from (required: false, type: PropertyType.String, description: "a descriptor that will allow to differentiate sources for the same dispatched deeplink")
        id (required: false, type: PropertyType.String, description: "a string to allow a unique identification of the links")
        store_replacement_link (required: false, type: PropertyType.String, description: "the deeplink that was provided to replace the app store link")
        store_replacement_link_scheme_is_valid (required: false, type: PropertyType.Boolean, description: "validation status of the store replacement link")
    }
    "/cross_app_links/fetch"(platform: "/mobile", type: TrackType.Event){
        link (required: true, type: PropertyType.String, description: "fetched link")
        provider (required: true, type: PropertyType.String, description: "provider class name")
        from (required: false, type: PropertyType.String, description: "a descriptor that will allow to differentiate sources for the same dispatched deeplink")
        id (required: false, type: PropertyType.String, description: "a string to allow a unique identification of the links")
    }
    "/cross_app_links/fetch_time"(platform: "/mobile", type: TrackType.Event){
        link (required: true, type: PropertyType.String, description: "fetched link")
        provider (required: true, type: PropertyType.String, description: "provider class name")
        from (required: false, type: PropertyType.String, description: "a descriptor that will allow to differentiate sources for the same dispatched deeplink")
        id (required: false, type: PropertyType.String, description: "a string to allow a unique identification of the links")
        spent_time(required: true, type: PropertyType.String, description: "the time spent doing the request to obtain a deferred link from the provider")
    }
}
