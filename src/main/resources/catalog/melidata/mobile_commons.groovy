package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {

    initiative = '1096'


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
    "/in_app_updates/updatable/update_not_available"(platform: "/mobile", type: TrackType.Event){
        cause (required: true, type: PropertyType.String, description: "why wer dont show the dialog of update")
    }
    "/in_app_updates/updatable/install"(platform: "/mobile", type: TrackType.Event){}
}