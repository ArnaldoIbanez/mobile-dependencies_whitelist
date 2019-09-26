package src.main.resources.catalog.shipping

import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    def geolocation_definition = objectSchemaDefinitions {
        latitude(type: PropertyType.String, required: true)
        longitude(type: PropertyType.String, required: true)
    }

    def payload_location_definition = objectSchemaDefinitions {
        city_name(type: PropertyType.String, required: false, description: "Shipment city name")
        country_id(type: PropertyType.String, required: false, description: "Shipment country id")
        neighborhood_name(type: PropertyType.String, required: false, description: "Shipment neighborhood name")
        state_id(type: PropertyType.String, required: false, description: "Shipment state id")
        geolocation(type: PropertyType.Map(geolocation_definition), required: false, description: "Geolocation Event")
    }

    def payload_dimensions_definition = objectSchemaDefinitions {
        height(type: PropertyType.Numeric, required: true)
        width(type: PropertyType.Numeric, required: true)
        length(type: PropertyType.Numeric, required: true)
        weight(type: PropertyType.Numeric, required: true)
    }

    def notification_payload_definition = objectSchemaDefinitions {
        agency_id(type: PropertyType.String, required: false, description: "Carrier agency id")
        carrier_id(type: PropertyType.String, required: false)
        client_id(type: PropertyType.String, required: false, description: "Carrier client id")
        comment(type: PropertyType.String, required: false, description: "Carrier notification comment")
        logistic_center(type: PropertyType.String, required: false, description: "Notification logistic center")
        cost(type: PropertyType.String, required: false, description: "Shipment cost")
        date(type: PropertyType.String, required: true, description: "Carrier notification date")
        location(type: PropertyType.Map(payload_location_definition), required: false, description: "Event location")
        dimensions(type: PropertyType.Map(payload_dimensions_definition), required: false, description: "Package dimensions")
        extra(type: PropertyType.String, required: false, description: "Extra information")
    }

    def notification_definition = objectSchemaDefinitions {
        code(type: PropertyType.String, required: true, description: "Standard integration code")
        carrier_code(type: PropertyType.String, required: false, description: "Carrier internal code")
        id(type: PropertyType.String, required: false, description: "Notification id")
        origin(type: PropertyType.String, required: false, description: "Notification origin",values: ["carrier-push", "carrier-pull", "meli", "shipping-back-office", "self-generated", "MELI-PUT"])
        payload(type: PropertyType.Map(notification_payload_definition), required: true, description: "Notification payload")
        shipment_id(type: PropertyType.Numeric, required: false)
        tracking_number(type: PropertyType.String, required: false, description: "Shipment tracking number")
        delay_date(type: PropertyType.String, required: false, description: "Delay to process notification")
    }

    "/"(platform: "/api") {}

    "/shipping"(platform: "/api") {}

    "/shipping/tracking"(platform: "/api") {
    }

    "/shipping/tracking/notifications"(platform: "/api") {
        shipment_id(type: PropertyType.Numeric, required: true)
    }

    "/shipping/tracking/notifications/received"(platform: "/api") {
        notification_id(type: PropertyType.String, required: true, description: "Notification id")
        status(type: PropertyType.Numeric, required: true, description: "Status code")
        client_id(type: PropertyType.Numeric, required: false, description: "Client id")
        notification(type: PropertyType.Map, required: true, description: "Carrier notification body")
    }

    "/shipping/tracking/notifications/validated"(platform: "/api") {
        notification(type: PropertyType.Map(notification_definition), required: true, description: "Carrier notification")
    }

    "/shipping/tracking/event_processor"(platform: "/api") {
    }

    "/shipping/tracking/event_processor/metrics"(platform: "/api") {
        shipment(type: PropertyType.Numeric, required: true)
        carrier_id(type: PropertyType.Numeric, required: false)
        order_cost_usd(type: PropertyType.Numeric, required: false)
        shipment_cost_usd(type: PropertyType.Numeric, required: false)
        total_cost_usd(type: PropertyType.Numeric, required: false)
        enqueue_date(type: PropertyType.String, required: false)
        stage_type(type: PropertyType.String, required: true)
        stage_id(type: PropertyType.String, required: true)
        notification(type: PropertyType.Map(notification_definition), required: true, description: "Original notifications")
        notification_after(type: PropertyType.Map(notification_definition), required: true, description: "Carrier notification after event processing")
        action_params(type: PropertyType.Map, required: true, description: "Generic configuration params")
        configuration_filters(type: PropertyType.ArrayList, required: true, description: "Generic configuration filters")
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
