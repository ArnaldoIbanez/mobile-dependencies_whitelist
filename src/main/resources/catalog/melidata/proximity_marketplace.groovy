package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/proximity_marketplace"(platform: "/",isAbstract: true, initiative: "1305") {}

    // Views:

    "/proximity_marketplace/ftu"(platform: "/", type: TrackType.View) {
        value(required: false, inheritable: false, type: PropertyType.String, description: "TrackType View")
    }

    "/proximity_marketplace/shipping"(platform: "/", isAbstract: true) {
        value(required: false, inheritable: false, type: PropertyType.String, view: "TrackType View")
    }

    "/proximity_marketplace/shipping/conditions-acceptance"(platform: "/", type: TrackType.View) {}

    "/proximity_marketplace/settings"(platform: "/", isAbstract: true) {
        value(required: false, inheritable: false, type: PropertyType.String, view: "TrackType View")
    }

    "/proximity_marketplace/settings/coverage"(platform: "/", type: TrackType.View) {}

    // Events:

    "/proximity_marketplace/ftu/ou"(platform: "/", type: TrackType.Event) {}

    "/proximity_marketplace/component" (platform: "/", isAbstract: true) {
        component_id(required: true, type: PropertyType.String, description: "Component's id")
        component_type(required: true, type: PropertyType.String, description: "Component's type")
        value(required: true, type: PropertyType.String, description: "Component's value")
    }

    "/proximity_marketplace/component/tap" (platform: "/", type: TrackType.Event) {}

    "/proximity_marketplace/ftu/error"(platform: "/", type: TrackType.Event) {
        value(required: true, inheritable: false, type: PropertyType.String, description: "Error description Ftu")
    }

    "/proximity_marketplace/shipping/conditions-acceptance/error"(platform: "/", type: TrackType.Event) {
        value(required: true, inheritable: false, type: PropertyType.String, description: "Error description Congrat")
    }

    "/proximity_marketplace/settings/coverage/error"(platform: "/", type: TrackType.Event) {
        value(required: true, inheritable: false, type: PropertyType.String, description: "Error description Setting Coverage")
    }

}
