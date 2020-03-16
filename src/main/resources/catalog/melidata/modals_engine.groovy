package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1176'

    /**
    * Modals Engine Screen Tracks
    */

    "/modals_engine"(platform: "/mobile", type: TrackType.View) {
        id(required: true, type: PropertyType.String, description: "modal content ID")
        bu(required: true, type: PropertyType.String, description: "Numeric id of business: MP | ML | etc")
        bu_line(required: true, type: PropertyType.String, description: "Numeric id of line: Credits | wallet Point | etc")
        flow(required: true, type: PropertyType.String, description: "numeric id of app flow: Cellphone Recharge | Money transfer | Pago con QR | etc")
        modal_type(required: true, type: PropertyType.String, description: "Layout type of the modal", values: ["full", "card"])
        from(required: false, type: PropertyType.String, description: "Text to identify multiple sources to access the same content.")
    }

    "/modals_engine/dismiss"(platform: "/mobile", type: TrackType.Event) {} 

    "/modals_engine/cta"(platform: "/mobile", type: TrackType.Event) {
        button_type(required: true, type: PropertyType.String, description: "primary / secondary / option", values: ["primary", "secondary", "option", "content_link"])
        link(required: true, type: PropertyType.String, description: "link to where the app was navigating to")
    } 
    "/modals_engine/swipe"(platform: "/mobile", type: TrackType.Event) {
        position(required: true, type: PropertyType.String)
    } 
    "/modals_engine/error"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "modal content ID")
        modal_type(required: true, type: PropertyType.String, description: "Layout type of the modal", values: ["full", "card"])
        type(required: true, type: PropertyType.String, description: "internal error code")
    }
}
