import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1148"

    "/meliplaces"(platform: "/", isAbstract: true) {}
    "/meliplaces/home/other_options"(platform: "/", isAbstract: true) {}
    "/meliplaces/transaction"(platform: "/", isAbstract: true) {}
    "/meliplaces/performance/tooltip"(platform: "/", isAbstract: true) {}
    "/meliplaces/performance/card"(platform: "/", isAbstract: true) {}
    "/meliplaces/activities"(platform: "/", isAbstract: true) {}

    /* HOME */
    "/meliplaces/home"(platform: "/", type: TrackType.View) {
        service_id(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "an array of services id", inheritable: false)
    }
    "/meliplaces/home/shield"(platform: "/", type: TrackType.View) {
        shield_id(required: true, type: PropertyType.String, description: "The id of the shield")
        error(required: false, type: PropertyType.Numeric, description: "The error code")
        message(required: true, type: PropertyType.String, description: "The error message")
    }
    "/meliplaces/home/close"(platform: "/mobile", type: TrackType.Event) {}
    "/meliplaces/home/other_options/tap"(platform: "/", type: TrackType.Event) {
        row_id(required: true, type: PropertyType.String, description: "The id of the tapped row")
    }
    "/meliplaces/transaction/start"(platform: "/", type: TrackType.Event) {
        service_id(required: true, type: PropertyType.String, description: "The service id of the new transaction")
    }

    /* PERFORMANCE */
    "/meliplaces/performance"(platform: "/", type: TrackType.View) {}
    "/meliplaces/performance/empty_state"(platform: "/", type: TrackType.View) {}
    "/meliplaces/performance/shield"(platform: "/", type: TrackType.View) {
        shield_id(required: true, type: PropertyType.String, description: "The id of the shield")
        error(required: false, type: PropertyType.Numeric, description: "The error code")
        message(required: true, type: PropertyType.String, description: "The error message")
    }
    "/meliplaces/performance/tooltip/show"(platform: "/", type: TrackType.Event) {
        tooltip_id(required: true, type: PropertyType.String, description: "The id of the tooltip")
    }
    "/meliplaces/performance/tooltip/hide"(platform: "/", type: TrackType.Event) {
        tooltip_id(required: true, type: PropertyType.String, description: "The id of the tooltip")
    }
    "/meliplaces/performance/card/footer"(platform: "/", type: TrackType.Event) {
        card_id(required: true, type: PropertyType.String, description: "The id of the card")
        footer_id(required: true, type: PropertyType.String, description: "The id of the footer")
    }

    /* ACTIVITY DETAIL */
    "/meliplaces/activities/detail"(platform: "/", type: TrackType.View) {}
    "/meliplaces/activities/detail/shield"(platform: "/", type: TrackType.View) {
        shield_id(required: true, type: PropertyType.String, description: "The id of the shield")
        error(required: false, type: PropertyType.Numeric, description: "The error code")
        message(required: true, type: PropertyType.String, description: "The error message")
    }
    "/meliplaces/activities/detail/receipt"(platform: "/", type: TrackType.Event) {}

    /* RESULT */
    "/meliplaces/result"(platform: "/mobile", type: TrackType.View) {
        service_id(required: true, type: PropertyType.String, description: "The service id that called the result", inheritable: false)
        status(required: true, type: PropertyType.String, description: "The result's status", values: ['approved', 'pending', 'rejected'], inheritable: false)
    }
    "/meliplaces/result/shield"(platform: "/mobile", type: TrackType.View) {
        shield_id(required: true, type: PropertyType.String, description: "The id of the shield")
        error(required: false, type: PropertyType.Numeric, description: "The error code")
        message(required: true, type: PropertyType.String, description: "The error message")
    }
    "/meliplaces/result/share"(platform: "/mobile", type: TrackType.Event) {}
    "/meliplaces/result/action"(platform: "/mobile", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "The id of the action")
        type(required: true, type: PropertyType.String, description: "The type of action", values: ['navigate', 'close'])
    }
    "/meliplaces/result/close"(platform: "/mobile", type: TrackType.Event) {}
}