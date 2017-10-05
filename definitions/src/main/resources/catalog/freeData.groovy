import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**
 *  Tracks for the Free Data project where Mercado Libre pays for its users mobile data consumption.
 */
tracks {

    "/free_navigation"(platform:"/mobile", type:TrackType.Event) {
        status(type: PropertyType.String, required: false)
    }

    "/free_navigation/dialog"(platform:"/mobile", type:TrackType.View) {
    }

    "/free_navigation/snackbar"(platform:"/mobile", type:TrackType.View) {
    }

    "/free_navigation/dialog_dismissed"(platform:"/mobile", type:TrackType.Event) {
        is_checkbox_checked(type: PropertyType.Boolean, required:true)
    }

    "/free_navigation/purchase"(platform:"/mobile", type:TrackType.Event) {
        status(type: PropertyType.String, required: true)
    }
}