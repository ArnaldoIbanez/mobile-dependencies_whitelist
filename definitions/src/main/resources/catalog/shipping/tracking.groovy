package src.main.resources.catalog.shipping

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    def notification_payload_definition = objectSchemaDefinitions {
        client_id(type: PropertyType.String, required: false, description: "Carrier client id")
        date(type: PropertyType.String, required: true, description: "Carrier notification date")
        carrier_id(type: PropertyType.String, required: false, description: "Carrier id")
    }

    def notification_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "Notification id")
        origin(type: PropertyType.String, required: true, description: "Notification origin (push-pull)")
        tracking_number(type: PropertyType.String, required: true, description: "Tracking number")
        code(type: PropertyType.String, required: true, description: "Code sent by carrier")
        carrier_code(type: PropertyType.String, required: false, description: "Carrier code")
        payload(type: PropertyType.Map(notification_payload_definition), required: true, description: "Notification payload")
    }

    def configuration_definition = objectSchemaDefinitions {
    }

    "/notifications"(platform: "/") {
        shipment_id(type: PropertyType.Numeric, required: true, description: "Shipment id")
        notification(type: PropertyType.Map(notification_definition), required: true, description: "Carrier notification")
        action(type: PropertyType.String, required: true, description: "Action taken with notification")
    }

    "/notifications/event_processing"(platform: "/") {
        configuration(type: PropertyType.Map(configuration_definition), required: true)
        new_notification(type: PropertyType.Map(configuration_definition), required: true)
    }

    "/notifications/ssm"(platform: "/") {
        response(type: PropertyType.String, required: true)
        cause(type: PropertyType.String, required: true)
    }
}
