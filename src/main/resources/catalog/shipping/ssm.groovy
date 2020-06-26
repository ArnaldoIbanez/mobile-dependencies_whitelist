package src.main.resources.catalog.shipping

import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    def geolocation_definition = objectSchemaDefinitions {
        latitude(type: PropertyType.Numeric, required: true)
        longitude(type: PropertyType.Numeric, required: true)
    }

    def location_definition = objectSchemaDefinitions {
        addressLine(type: PropertyType.String, required: false)
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
        substatus(type: PropertyType.String, required: true)
        logistic_type(type: PropertyType.String, required: true)
        site_id(type: PropertyType.String, required: true)
        date_first_printed(type: PropertyType.String, required: true)
    }

    def status_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        name(type: PropertyType.String, required: true)
    }

    def substatus_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        name(type: PropertyType.String, required: true)
        parent(type: PropertyType.Map(status_definition), required: true)
    }

    def substatus_history_definition = objectSchemaDefinitions {
        status(type: PropertyType.String, required: true)
        substatus(type: PropertyType.String, required: true)
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
        status(type: PropertyType.Map(status_definition), required: true)
        substatus(type: PropertyType.Map(substatus_definition), required: true)
        status_history(type: PropertyType.Map(status_history_definition), required: true)
        date_first_printed(type: PropertyType.String, required: false)
        substatus_history(type: PropertyType.ArrayList(PropertyType.Map(substatus_history_definition)), required: true)
        need_status_update(type: PropertyType.Boolean, required: true)
        need_update_status_history(type: PropertyType.Boolean, required: true)
        need_update_substatus_history(type: PropertyType.Boolean, required: true)
        need_update_date_first_printed(type: PropertyType.Boolean, required: true)
    }

    def notification_received_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        notification(type: PropertyType.Map(notification_definition), required: true)
        shipment_snapshot(type: PropertyType.Map(shipment_snapshot_definition), required: true)
    }

    def notification_processed_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        notification(type: PropertyType.Map(notification), required: true)
        shipment_transition(type: PropertyType.Map(shipment_transition_definition), required: true)
    }

    def notification_rejected_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        code(type: PropertyType.String, required: true)
        reason(type: PropertyType.String, required: true)
        shipment_snapshot(type: PropertyType.Map(shipment_snapshot_definition), required: true)
    }

    def tracking_difference_definition = objectSchemaDefinitions {
        field(type: PropertyType.String, required: true)
        from(type: PropertyType.String, required: true)
        to(type: PropertyType.String, required: true)
    }

    def tracking_news_definition = objectSchemaDefinitions {
        shipment_id(type: PropertyType.Numeric, required: true)
        status(type: PropertyType.String, required: true)
        substatus(type: PropertyType.String, required: true)
        differences(type: PropertyType.ArrayList(PropertyType.Map(tracking_difference_definition)), required: true)
        delay(type: PropertyType.ArrayList(PropertyType.String), required: true)
        origin(type: PropertyType.String, required: true)
    }

    def melidata_object_definition = objectSchemaDefinitions {
        notification_id(type: PropertyType.String, required: true)
        data(type: PropertyType.Map(tracking_news_definition), required: true)
    }


    "/"(platform: "/api") {}

    "/shipping"(platform: "/api") {}

    "/shipping/ssm"(platform: "/api") {}

    "/shipping/ssm/notifications"(platform: "/api") {}

    "/shipping/ssm/notifications/received"(platform: "/api") {
        notification_received(type: PropertyType.Map(notification_received_definition, required: true, description: "Notification received including shipment snapshot"))
    }

    "/shipping/ssm/notifications/processed"(platform: "/api") {
        notification_processed(type: PropertyType.Map(notification_processed_definition, required: true, description: "Notification processed including shipment transition"))
    }

    "/shipping/ssm/notifications/rejected"(platform: "/api") {
        notification_rejected(type: PropertyType.Map(notification_rejected_definition, required: true, description: "Notification rejected including shipment snapshot and reason"))
    }

    "/shipping/ssm/notifications/feed"(platform: "/api") {
        melidata_object(type: PropertyType.Map(melidata_object_definition, required: true, description: "Notification ID and tracking news"))
    }
}
