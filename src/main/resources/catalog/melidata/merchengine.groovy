package src.main.resources.catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1176'

    propertyDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Component ID")
        bu(required: true, type: PropertyType.String, description: "The business unit: MP or ML")
        bu_line(required: true, type: PropertyType.String, description: "The business unit related to the content - Ex: Point")
        content_id(required: true, type: PropertyType.String, description: "Identifier for the unique content shown")
        flow(required: true, type: PropertyType.String, description: "The flow related to the content - Ex: cellphone_recharge")
        logic(required: true, type: PropertyType.String, description: "Origin of the content - Ex: priority_messages")
        position(required: false, type: PropertyType.Numeric, description: "Position starting at 1 where it was shown")
        audience(required: false, type: PropertyType.String, description: "The audience for which this content was prepared")

        link(required: true, type: PropertyType.String, description: "deeplink to execute")
        action_id(required: true, type: PropertyType.String, description: "The action executed")
        type(required: true, type: PropertyType.String, description: "The action executed")
    }
    propertyGroups {
        modalV2Fields (
           component_id, bu, content_id, bu_line,position, logic, flow, audience
        )
        modalV2FieldsCTA (
           component_id, bu, content_id, bu_line,position, logic, flow, link, action_id, type, audience
        )
    }
    /**
    * Merchengine Screen Tracks
    */

    "/merchengine"(platform: "/mobile", isAbstract: true) {}

    //Modal Events
    "/merchengine/modal"(platform: "/mobile", type: TrackType.View) {
        modalV2Fields
    }

    "/merchengine/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
    }

    "/merchengine/modal/cta"(platform: "/mobile", type: TrackType.Event) {
        modalV2FieldsCTA
    }

    "/merchengine/modal/swipe"(platform: "/mobile", type: TrackType.Event) {
        position(required: true, type: PropertyType.Numeric, description: "Which position is being shown on slider modal")
    }
}
