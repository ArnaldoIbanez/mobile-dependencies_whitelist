package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1096"

    /**
     * Error UX Tracks Definition
     */
    "/error/generic"(platform: "/mobile", isAbstract: true, type: TrackType.View) {
        team( required: true, description: "the responsible team", type: PropertyType.String)
        visual_type(required: true, type: PropertyType.String, values: ["snackbar", "full_screen"], description: "error’s visual type")
        number( required: false, description: "the error name/type, represents the error Code 01..99", type: PropertyType.String)
        screen( required: false, description: "the current screen", type: PropertyType.String)
        detail( required: false, description: "the detail of the error / stack", type: PropertyType.String)
    }

}
