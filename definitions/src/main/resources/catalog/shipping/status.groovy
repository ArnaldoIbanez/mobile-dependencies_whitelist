import com.ml.melidata.Track
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/"(platform: "/", isAbstract: true) {}

    "/shipping"(platform: "/", isAbstract: true) {}

    "/ "(platform: "/api", type: TrackType.Event) {
        status_code(required:true, description: "API Response code", type: PropertyType.String)
    }

    "/shipping/tracking/select_status"(platform: "/api", type: TrackType.Event) {
        status_selected(required:true, description: "Shippment status selected", type: PropertyType.String)
    }
}
