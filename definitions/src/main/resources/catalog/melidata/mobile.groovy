import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType

tracks {

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
    "/in_app_updates/updatable/update_not_available"(platform: "/mobile", type: TrackType.Event){
        cause (required: true, type: PropertyType.String, description: "why wer dont show the dialog of update")
    }
    "/in_app_updates/updatable/install"(platform: "/mobile", type: TrackType.Event){}
    
}
