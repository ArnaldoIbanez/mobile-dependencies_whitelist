package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {

    initiative = '1142'

    propertyDefinitions {   
        session_id(required: false, description: "Session id")
        flow(required: false, description: "Flow name")
    }

    propertyGroups {
        externalData(session_id, flow)
    }

    // Events:
    "/esc_manager"(platform: "/mobile", isAbstract: true){
        externalData
    }

    // Save ESC event
    "/esc_manager/save"(platform: "/mobile", type: TrackType.Event) {
        externalData
        key(required: true, type: PropertyType.String , description: "Key being saved")
        esc_length(required: false, type: PropertyType.Numeric, description: "ESC length being saved")
    }

    // Delete ESC event
    "/esc_manager/delete"(platform: "/mobile", type: TrackType.Event) {
        externalData
        key(required: true, type: PropertyType.String , description: "Key being deleted")
    }

    // Delete all events
    "/esc_manager/delete/all"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Error events
    "/esc_manager/unavailable"(platform: "/mobile", type: TrackType.Event) {
        externalData
        key(required: false, type: PropertyType.String , description: "Key being process")
        error_code(required: false, type: PropertyType.String , description: "Error code")
    }

    "/esc_manager/invalid"(platform: "/mobile", isAbstract: true) {
    }

    "/esc_manager/invalid/esc"(platform: "/mobile", type: TrackType.Event) {
        externalData
        key(required: true, type: PropertyType.String , description: "Invalid key")
    }

    "/esc_manager/invalid/key"(platform: "/mobile", type: TrackType.Event) {
        externalData
    }
}
