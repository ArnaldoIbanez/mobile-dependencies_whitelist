package src.main.resources.catalog.merch

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/merch"(platform: "/", type: TrackType.View) {
        content_id(required: true, type: PropertyType.String, description: "Content ID")
        component_id(required: true, type: PropertyType.String, description: "Realestate ID")
    }

    "/merch/dismiss"(platform: "/", type: TrackType.Event) {}
}