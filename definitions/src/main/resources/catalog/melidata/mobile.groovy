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
}
