package src.main.resources.catalog.shipping

import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/"(platform: "/api") {}

    "/shipping"(platform: "/api") {}

    "/shipping/tracking"(platform: "/api") {
    }

    "/shipping/tracking/notifications"(platform: "/api") {
        notification(type: PropertyType.Map, required: true, description: "Carrier notification")
        shipment_id(type: PropertyType.Numeric, required: true)
    }

    "/shipping/tracking/notifications/received"(platform: "/api") {
        notification_id(type: PropertyType.String, required: true, description: "Notification id")
        status(type: PropertyType.Numeric, required: true, description: "Status code")
        client_id(type: PropertyType.Numeric, required: false, description: "Client id")
    }

    "/shipping/tracking/notifications/validated"(platform: "/api") {
    }

    "/shipping/tracking/event_processor"(platform: "/api") {
    }

    "/shipping/tracking/event_processor/metrics"(platform: "/api") {
        shipment(type: PropertyType.Numeric, required: true)
        carrier_id(type: PropertyType.Numeric, required: true)
        order_cost_usd(type: PropertyType.Numeric, required: false)
        shipment_cost_usd(type: PropertyType.Numeric, required: false)
        total_cost_usd(type: PropertyType.Numeric, required: false)
        enqueue_date(type: PropertyType.String, required: false)
        stage_type(type: PropertyType.String, required: true)
        stage_id(type: PropertyType.String, required: true)
        notification(type: PropertyType.Map, required: true, description: "Original notifications")
        notification_after(type: PropertyType.Map, required: true, description: "Carrier notification after event processing")
        action_params(type: PropertyType.Map, required: true)
        configuration_filters(type: PropertyType.ArrayList, required: true)
    }

    "/shipping/tracking/event_processor/metrics/effective"(platform: "/api") {

    }

    "/shipping/tracking/event_processor/metrics/ineffective"(platform: "/api") {
    }

    "/shipping/tracking/adapters"(platform: "/api") {
    }

    "/shipping/tracking/adapters/validations"(platform: "/api") {
        validation_type(type: PropertyType.String, required: true, description: "Pull consumer validation type")
        shipment_data(required: true, description: "Data sent by the carrier into their pull tracking response")
    }
}
