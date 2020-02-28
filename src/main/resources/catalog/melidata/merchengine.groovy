package src.main.resources.catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1034'

    /**
    * Merchengine Screen Tracks
    */

    "/merchengine"(platform: "/mobile", isAbstract: true) {}

    //Modal Events
    "/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
        content_id(required: true, type: PropertyType.String, description: "The identification of shown modal")
        component_id(required: true, type: PropertyType.String, description: "The identification of the component")
        position(required: false, type: PropertyType.Numeric, description: "Position starting at 1 where it was shown")
        audience(required: true, type: PropertyType.String, description: "The audience of the user that saw the content")
        bu_line(required: true, type: PropertyType.String, description: "The business unit related to the content - Ex: Point")
        flow(required: true, type: PropertyType.String, description: "The flow related to the content - Ex: cellphone_recharge")
        logic(required: true, type: PropertyType.String, description: "Origin of the content - Ex: priority_messages")
    }

    "/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) { 
    }

    "/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Which type of button did the user clicked", values: ["primary", "secondary", "option", "content_link"])
        link(required: true, type: PropertyType.String, description: "The link to be executed")
    }

    "/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
    }

}
