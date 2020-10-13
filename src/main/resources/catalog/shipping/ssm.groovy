package src.main.resources.catalog.shipping

import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    def geolocation_definition = objectSchemaDefinitions {
        latitude(type: PropertyType.Numeric, required: true)
        longitude(type: PropertyType.Numeric, required: true)
    }

    def location_definition = objectSchemaDefinitions {
        address_line(type: PropertyType.String, required: false)
        agency_acronym(type: PropertyType.String, required: false)
        agency_id(type: PropertyType.String, required: false)
        agency_name(type: PropertyType.String, required: false)
        agency_phone(type: PropertyType.String, required: false)
        city(type: PropertyType.String, required: false)
        city_name(type: PropertyType.String, required: false)
        geolocation(type: PropertyType.Map(geolocation_definition), required: false)
        phones(type: PropertyType.String, required: false)
        state(type: PropertyType.String, required: false)
        state_name(type: PropertyType.String, required: false)
        street_name(type: PropertyType.String, required: false)
        street_number(type: PropertyType.String, required: false)
        zip_node(type: PropertyType.String, required: false)
        neighborhood_name(type: PropertyType.String, required: false)
        state_id(type: PropertyType.String, required: false)
    }

    def dimension_definition = objectSchemaDefinitions {
        height(type: PropertyType.Numeric, required: false)
        width(type: PropertyType.Numeric, required: false)
        length(type: PropertyType.Numeric, required: false)
        weight(type: PropertyType.Numeric, required: false)
    }

    def payload_definition = objectSchemaDefinitions {
        date(type: PropertyType.String, required: true)
        cost(type: PropertyType.Numeric, required: false)
        comment(type: PropertyType.String, required: false)
        agency_id(type: PropertyType.String, required: false)
        dimension(type: PropertyType.Map(dimension_definition), required: false)
        tracking_number(type: PropertyType.String, required: false)
        service_id(type: PropertyType.String, required: false)
        logistic_center(type: PropertyType.String, required: false)
        location(type: PropertyType.Map(location_definition), required: false)
        extra(type: PropertyType.String, required: false)
        client_id(type: PropertyType.String, required: false)
        carrier_id(type: PropertyType.String, required: false)
    }

    def notification_config_definition = objectSchemaDefinitions {
        should_check_duplicate_checkpoint(type: PropertyType.Boolean, required: true)
        sync(type: PropertyType.Boolean, required: true)
        reprocess(type: PropertyType.Boolean, required: true)
    }

    def step_type_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        description(type: PropertyType.String, required: true)
    }

    def notification_definition = objectSchemaDefinitions {
        origin(type: PropertyType.String, required: false)
        id(type: PropertyType.String, required: false)
        shipment_id(type: PropertyType.String, required: false)
        step_type(type: PropertyType.Map(step_type_definition), required: false)
        tracking_number(type: PropertyType.String, required: false)
        config(type: PropertyType.Map(notification_config_definition), required: false)
        code(type: PropertyType.String, required: true)
        payload(type: PropertyType.Map(payload_definition), required: true)
        company_name(type: PropertyType.String, required: false)
    }

    def shipment_snapshot_definition = objectSchemaDefinitions {
        id(type: PropertyType.Numeric, required: true)
        status(type: PropertyType.String, required: true)
        substatus(type: PropertyType.String, required: false)
        logistic_type(type: PropertyType.String, required: true)
        site_id(type: PropertyType.String, required: true)
        date_first_printed(type: PropertyType.String, required: true)
    }

    def substatus_history_definition = objectSchemaDefinitions {
        status(type: PropertyType.String, required: true)
        substatus(type: PropertyType.String, required: false)
        date(type: PropertyType.String, required: true)
    }

    def status_history_definition = objectSchemaDefinitions {
        date_handling(type: PropertyType.String, required: false)
        date_ready_to_ship(type: PropertyType.String, required: false)
        date_shipped(type: PropertyType.String, required: false)
        date_first_visit(type: PropertyType.String, required: false)
        date_delivered(type: PropertyType.String, required: false)
        date_cancelled(type: PropertyType.String, required: false)
        date_not_delivered(type: PropertyType.String, required: false)
        date_returned(type: PropertyType.String, required: false)
    }

    def shipment_transition_definition = objectSchemaDefinitions {
        status(type: PropertyType.String, required: true)
        substatus(type: PropertyType.String, required: false)
        status_history(type: PropertyType.Map(status_history_definition), required: true)
        date_first_printed(type: PropertyType.String, required: false)
        substatus_history(type: PropertyType.ArrayList(PropertyType.Map(substatus_history_definition)), required: false)
        need_status_update(type: PropertyType.Boolean, required: true)
        need_update_status_history(type: PropertyType.Boolean, required: true)
        need_update_substatus_history(type: PropertyType.Boolean, required: true)
        need_update_date_first_printed(type: PropertyType.Boolean, required: true)
    }

    def tracking_difference_definition = objectSchemaDefinitions {
        field(type: PropertyType.String, required: true)
        from(type: PropertyType.String, required: true)
        to(type: PropertyType.String, required: true)
    }

    def tracking_news_definition = objectSchemaDefinitions {
        shipment_id(type: PropertyType.Numeric, required: true)
        status(type: PropertyType.String, required: true)
        substatus(type: PropertyType.String, required: false)
        differences(type: PropertyType.ArrayList(PropertyType.Map(tracking_difference_definition)), required: false)
        delay(type: PropertyType.ArrayList(PropertyType.String), required: false)
        origin(type: PropertyType.String, required: false)
    }

    "/"(platform: "/api") {}

    "/shipping"(platform: "/api") {}

    "/shipping/ssm"(platform: "/api") {}

    "/shipping/ssm/notifications"(platform: "/api") {}

    "/shipping/ssm/notifications/received"(platform: "/api") {
        id(type: PropertyType.String, required: true, description: "Notification ID")
        notification(type: PropertyType.Map(notification_definition), required: true, description: "Received notification")
        shipment_snapshot(type: PropertyType.Map(shipment_snapshot_definition), required: true, description: "Shipment snapshot from when notification was received")
    }

    "/shipping/ssm/notifications/processed"(platform: "/api") {
        id(type: PropertyType.String, required: true, description: "Notification ID")
        notification(type: PropertyType.Map(notification_definition), required: true, description: "Processed notification")
        shipment_transition(type: PropertyType.Map(shipment_transition_definition), required: true, description: "Shipment transition description")
    }

    "/shipping/ssm/notifications/rejected"(platform: "/api") {
        id(type: PropertyType.String, required: true, description: "Notification ID")
        code(type: PropertyType.String, required: true, description: "Notification code")
        reason(type: PropertyType.String, required: true, description: "Rejection reason")
        shipment_snapshot(type: PropertyType.Map(shipment_snapshot_definition), required: true, description: "Shipment snapshot from when notification was rejected")
    }

    "/shipping/ssm/notifications/feed"(platform: "/api") {
        notification_id(type: PropertyType.String, required: true, description: "Notification ID")
        data(type: PropertyType.Map(tracking_news_definition), required: true, description: "Tracking news about the affected shipment")
    }
}
