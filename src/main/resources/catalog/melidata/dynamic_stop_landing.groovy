package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * Dynamic stop landings Screen Tracks
    */
    // Web
    "/stop_landing"(platform: "/", type: TrackType.View) {
        campaign (required:true, type: PropertyType.String, description: "Indicates the id of the campaign")
        extra_params (required: false, type: PropertyType.String, description: "Extra information that comes on query parameters")
    }
    "/stop_landing/redirect"(platform: "/", type: TrackType.Event) {
        campaign (required: true, type: PropertyType.String, description: "Indicates the id of the campaign")
        extra_params (required: false, type: PropertyType.String, description: "Extra information that comes on query parameters")
    }
    "/stop_landing/button"(platform: "/", type: TrackType.Event) { 
        campaign (required: true, type: PropertyType.String, description: "Indicates the id of the campaign")
        extra_params (required: false, type: PropertyType.String, description: "Extra information that comes on query parameters")
    }
}
