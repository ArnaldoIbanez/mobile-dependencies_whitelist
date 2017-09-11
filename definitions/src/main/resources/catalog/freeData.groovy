import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**
 *  Tracks for the Free Data project where Mercado Libre pays for its users mobile data consumption.
 */
tracks {

    "/free_navigation"(platform:"/mobile", type:TrackType.Event) {
    }

    "/free_navigation/sponsored_data"(platform:"/mobile", type:TrackType.Event) {
    }

    "/free_navigation/mobile_data_not_sponsored"(platform:"/mobile", type:TrackType.Event) {
    }

    "/free_navigation/dialog_shown"(platform:"/mobile", type:TrackType.Event) {
    }

    "/free_navigation/snackbar_shown"(platform:"/mobile", type:TrackType.Event) {
    }

    "/free_navigation/dialog_dismissed"(platform:"/mobile", type:TrackType.Event) {
        is_checkbox_checked(required:true)
    }
}