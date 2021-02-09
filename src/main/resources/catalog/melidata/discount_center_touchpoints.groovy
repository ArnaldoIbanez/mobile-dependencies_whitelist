package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*****************************
*   DISCOUNT CENTER TOUCHPOINTS TRACKS   *
******************************/

tracks {

    initiative = "1218"
	
    "/discount_center" (platform: "/mobile", isAbstract: true) {}
    "/discount_center/payers" (platform: "/mobile", isAbstract: true) {}
    "/discount_center/payers/touchpoint" (platform: "/mobile", isAbstract: true) {}
    "/discount_center/payers/touchpoint/px_congrats" (platform: "/mobile", isAbstract: true) {}

    propertyDefinitions {
        flow_detail(required: false, description: "External info")
        flow(required: false, type: PropertyType.String, description: "External flow name")
        session_id(required: false, type: PropertyType.String, description: "Internal session id")
        session_time(required: false, type: PropertyType.Numeric, description: "Session time")
        checkout_type(required: false, type: PropertyType.String, description: "Checkout type")
        collector_id(required: false, description: "Collector external id")
        security_enabled(required: false, type: PropertyType.Boolean, description: "If the user has biometric or passcode validation to make a payment")
        category(type: PropertyType.String, required: false, description: "The category id")
        experiments(required: false, type: PropertyType.String, description: "Active experiments")
    }

    propertyGroups {
        externalData(flow, flow_detail, collector_id, session_id, session_time, checkout_type, security_enabled, category, experiments)
    }

    def touchpoint_item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the item we are showing")
    }

    "/discount_center/payers/touchpoint/px_congrats/tap" (platform: "/mobile", type: TrackType.Event) {
        externalData
        tracking_id(required: true, type: PropertyType.String, description: "The id campaign")
    }

    "/discount_center/payers/touchpoint/px_congrats/show" (platform: "/mobile", type: TrackType.Event) {
        externalData
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(touchpoint_item_definition)), description: "The items")
    }

    "/discount_center/payers/touchpoint/px_congrats/print" (platform: "/mobile", type: TrackType.Event) {
        externalData
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(touchpoint_item_definition)), description: "The items")
    }
}
