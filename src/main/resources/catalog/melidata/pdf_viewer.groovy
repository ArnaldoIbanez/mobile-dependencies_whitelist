package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1096"

    propertyDefinitions {
        flow(required:true, type: PropertyType.String, description: "Name of the current flow")
    }

    propertyGroups {
        mandatory(flow)
    }

    /**
     * PDF Viewer Tracks
     */

    "/pdf_viewer" (platform: "/mobile", isAbstract: true) {
        mandatory
    }

    // PDF Visualization
    "/pdf_viewer"(platform: "/mobile", type: TrackType.View) {}

    // Back
    "/pdf_viewer/back"(platform: "/mobile", type: TrackType.Event) {}

    // Share Document
    "/pdf_viewer/share"(platform: "/mobile", type: TrackType.Event) {}

    // Error
    "/pdf_viewer/show_error"(platform: "/mobile", type: TrackType.Event) {}

    // Retry
    "/pdf_viewer/retry"(platform: "/mobile", type: TrackType.Event) {}
}


