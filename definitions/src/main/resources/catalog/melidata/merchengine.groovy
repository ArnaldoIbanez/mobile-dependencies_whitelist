package src.main.resources.catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * Merchengine Screen Tracks
    */

    "/merchengine"(platform: "/mobile", isAbstract: true) {}

    //Modal Events
    "/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
        realestate_id(required: true, type: PropertyType.String, description: "The container where we show the modal")
        content_id(required: true, type: PropertyType.String, description: "The identification of shown modal")
        origin(required: true, type: PropertyType.String, description: "The application that returns the modal")
    }

    "/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
    }

    "/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Which type of button did the user clicked", values: ["primary", "secondary", "option"])
    }

    "/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
        position(required: true, type: PropertyType.String, description: "Which position is being shown on slider modal")
    }

}
