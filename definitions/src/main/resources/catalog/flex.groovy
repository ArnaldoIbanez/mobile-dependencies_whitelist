import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    propertyDefinitions {
        packs_info(required: true, type: PropertyType.ArrayList, description: "Array of packages to deliver")
    }

    "/flex"(platform: "/", isAbstract: true) {}

    "/flex/landing"(platform: "/", type: TrackType.View) {}

    "/flex/optin"(platform: "/", type: TrackType.Event) {
        view(required: true, type: PropertyType.String, description: "specific view the app returned")
    }

    "/flex/optout"(platform: "/", type: TrackType.Event) {
        view(required: true, type: PropertyType.String, description: "specific view the app returned")
    }

    "/flex/login/name"(platform: "/mobile", type: TrackType.View) {
    }

    "/flex/package/start"(platform: "/mobile", type: TrackType.View) {
    }

    "/flex/package/add"(platform: "/mobile", type: TrackType.View) {
    }

    "/flex/package/add/qr_detected"(platform: "/mobile", type: TrackType.Event) {
        status(required: true, type: PropertyType.String,  values: ["ok", "already_registered", "invalid_format"],
            description: "specific view the app returned")
    }

    "/flex/package/add/start_delivery"(platform: "/mobile", type: TrackType.Event) {
        packs_info
    }

    "/flex/package/add/view_list"(platform: "/mobile", type: TrackType.Event) {
    }
}
