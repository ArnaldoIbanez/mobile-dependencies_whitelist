package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {

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
}