package src.main.resources.catalog.shipping

import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    def payload_location_definition = objectSchemaDefinitions {
        city_name(type: PropertyType.String, required: false, description: "Shipment city name")
        country_id(type: PropertyType.String, required: false, description: "Shipment country id")
        geolocation(type: PropertyType.String, required: false, description: "Shipment geolocation")
        neighborhood_name(type: PropertyType.String, required: false, description: "Shipment neighborhood name")
        state_id(type: PropertyType.String, required: false, description: "Shipment state id")
    }

    def notification_payload_definition = objectSchemaDefinitions {
        agency_id(type: PropertyType.String, required: false, description: "Carrier agency id")
        carrier_id(type: PropertyType.String, required: false)
        client_id(type: PropertyType.String, required: false, description: "Carrier client id")
        comment(type: PropertyType.String, required: false, description: "Carrier notification comment")
        date(type: PropertyType.String, required: true, description: "Carrier notification date")
        location(type: PropertyType.Map(payload_location_definition), required: false, description: "Carrier location")
    }

    def notification_definition = objectSchemaDefinitions {
        code(type: PropertyType.String, required: true, description: "Code sent by carrier")
        id(type: PropertyType.String, required: false, description: "Notification id")
        origin(type: PropertyType.String, required: false, description: "Notification origin (push-pull)")
        payload(type: PropertyType.Map(notification_payload_definition), required: true, description: "Notification payload")
        shipment_id(type: PropertyType.Numeric, required: false)
        tracking_number(type: PropertyType.String, required: true, description: "Shipment tracking number")

        //Event processor track for notification after
        delay_date(type: PropertyType.String, required: false, description: "Date of delay")
    }

    def values_definition = objectSchemaDefinitions {
        codes(type: PropertyType.ArrayList(PropertyType.String), required: false, description: "Carrier codes")
        types(type: PropertyType.ArrayList(PropertyType.String), required: false, description: "Logistic types")
    }

    def configuration_filters_definition = objectSchemaDefinitions {
        filter(type: PropertyType.String, required: true, description: "Filter id")
        values(type: PropertyType.Map(values_definition), required: false)
    }

    def action_params_definition = objectSchemaDefinitions {
        delay_time_hours(type: PropertyType.String, required: false)
        convertion_code(type: PropertyType.String, required: false)
    }

    "/"(platform: "/api") {}

    "/notifications"(platform: "/api") {
    }

    "/tracking"(platform: "/api") {
    }

    "/tracking/adapters"(platform: "/api") {
    }

    "/notifications/tracking"(platform: "/api") {
        notification(type: PropertyType.Map(notification_definition), required: true, description: "Carrier notification")
        shipment_id(type: PropertyType.Numeric, required: true)
    }

    "/notifications/tracking/received"(platform: "/api") {
        notification_id(type: PropertyType.String, required: true, description: "Notification id")
        status(type: PropertyType.Numeric, required: true, description: "Error code")
        client_id(type: PropertyType.Numeric, required: true, description: "Carrier client id")
    }

    "/notifications/tracking/validated"(platform: "/api") {
    }

    "/tracking/adapters/validations"(platform: "/api") {
        validation_type(type: PropertyType.String, required: true, description: "Pull consumer validation type")
        shipment_data(required: true, description: "Data sent by the carrier into their pull tracking response")
    }

    "/notifications/tracking/event_processing"(platform: "/api") {
        action_params(type: PropertyType.Map(action_params_definition), required: true)
        carrier_id(type: PropertyType.Numeric, required: true)
        configuration_filters(type: PropertyType.ArrayList(PropertyType.Map(configuration_filters_definition)), required: true)
        notification_after(type: PropertyType.Map(notification_definition), required: true, description: "Carrier notification after event processing")
        stage_id(type: PropertyType.String, required: true)
        stage_type(type: PropertyType.String, required: true, description: "Type of actual stage")
    }

    "/notifications/ssm"(platform: "/api") {
        cause(type: PropertyType.String, required: false)
        response(type: PropertyType.String, required: false)
    }
}
