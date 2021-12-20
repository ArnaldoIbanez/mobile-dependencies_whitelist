package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1096"

    /**
     * Error UX Tracks Definition
     */
    "/error_ux"(platform: "/mobile", isAbstract: true) {
        team( required: true, description: "the responsible team", type: PropertyType.String)
        number( required: false, description: "the error name/type, represents the error Code 01..99", type: PropertyType.String)
        screen( required: false, description: "the current screen", type: PropertyType.String)
    }

    // Error UX Views
    "/error_ux/error_screen"(platform: "/mobile", type: TrackType.View) {}
    "/error_ux/error_snackbar"(platform: "/mobile", type: TrackType.View) {}
}
