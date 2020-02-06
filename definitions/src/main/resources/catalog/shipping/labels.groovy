package src.main.resources.catalog.shipping

import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    def responded_data = objectSchemaDefinitions {
        status(type: PropertyType.Numeric, required: true)
        error_code(type: PropertyType.String, required: false)
    }

    def notification_response = objectSchemaDefinitions {
        status(type: PropertyType.Numeric, required: true)
        notification_id(type: PropertyTypeString, required: false, description: "notification_id, if success")
    }


    "/"(platform: "/api") {}

    "/shipping"(platform: "/api") {}

    "/shipping/labels"(platform: "/api") {}

    "/shipping/labels/labels_api"(platform: "/api") {}

    "/shipping/labels/labels_api/requested"(platform: "/api") {
        response(type: PropertyType.Map(responded_data), required: true, description: "Response information")
        uri(type: PropertyType.String, required: true, description: "Requested Label Uri")
        shipment_ids(type: PropertyType.ArrayList, required: true, description: "Shipments for wich label was requested")
        client_id(type: PropertyType.Numeric, required: true, description: "Request client")
        caller_id(type: PropertyType.Numeric, required: true, description: "Request caller")
        response_type(type: PropertyType.String, required: true, description: "Type of response requested")
        download_file(type: PropertyType.Boolean, required:true, description: "Download requested")
        generated_label_link(type: PropertyType.String, required: true)
    }


    "/shipping/labels/labels_api/notified"(platform: "/api") {
        code(type: PropertyType.String, required: true, description: "Meli standard code")
        shipment_id(type: PropertyType.Numeric, required: true, description: "Shipment id notified")
        response(type:PropertyType.Map(notification_response), required: true, description: "Response info received from notifications")
        notifier(type: PropertyType.String, values:["primary","secondary"])
    }
}
