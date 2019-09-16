import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    propertyDefinitions {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
        shipment_id(required: true, type: PropertyType.Numeric,
                description: "ID of shipment being validated for reception.")
        display(required: false, type: PropertyType.String, values: ["browser", "standalone", "none"],
                description: "Specifies the display mode app is running as.")
        validation_error(required: true, type: PropertyType.String,
                values: ["duplicated", "invalid_shipment", "not_found", "internal_error", "no_connection"],
                description: "Specifies what kind of validation error happened.")
        camera_error(required: true, type: PropertyType.String,
                values: ["not_allowed", "blocked"],
                description: "Specifies what kind of camera error happened.")
    }

    propertyGroups {
        place_view(place_id, display)
        place_shipment(place_id, shipment_id, display)
        place_validation(place_id, shipment_id, validation_error)
        place_camera(place_id, display, camera_error)
    }

    "/places"(platform: "/web", isAbstract: true) {}

    "/places/home"(platform: "/web", type: TrackType.View) {
        place_view
    }

    "/places/reception"(platform: "/web", type: TrackType.View) {
        place_view
    }

    "/places/reception_congrats"(platform: "/web", type: TrackType.View) {
        place_view
    }

    "/places/reception/remove_shipment/confirmed"(platform: "/web", type: TrackType.Event) {
        place_shipment
    }

    "/places/reception/manual"(platform: "/web", type: TrackType.Event) {
        place_shipment
    }

    "/places/reception/validate_shipment/error"(platform: "/web", type: TrackType.Event) {
        place_validation
    }

    "/places/reception/access_camera/error"(platform: "/web", type: TrackType.Event) {
        place_camera
    }

}