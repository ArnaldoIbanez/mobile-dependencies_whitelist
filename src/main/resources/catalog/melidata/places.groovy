package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1180"

    propertyDefinitions {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
        shipment_id(required: true, type: PropertyType.String,
                description: "ID of shipment being validated for reception.")
        content(required: true, type: PropertyType.String,
                description: "ID of content being validated.")
        display(required: false, type: PropertyType.String, values: ["browser", "standalone", "none"],
                description: "Specifies the display mode app is running as.")
        validation_error(required: false, type: PropertyType.String,
                description: "Specifies what kind of validation error happened.")
        input_type(required: true, type: PropertyType.String,
                values: ["camera", "external_scan", "manual_input"],
                description: "Specifies by what means you entered the input")
        flow(required: true, type: PropertyType.String,
                description: "Specifies the flow that is being operated")
        camera_error(required: true, type: PropertyType.String,
                description: "Specifies what kind of camera error happened.")
        code_type(required: true, type: PropertyType.String,
                values: ["QR", "Datamatrix", "Barcode", "Unknown"],
                description: "Specifies what kind of 1D/2D code were scanned")
        scanner_input(required: false, type: PropertyType.String,
                description: "Specifies the raw input of the external scanner")
        scanner_output(required: false, type: PropertyType.String,
                description: "Specifies the processed output of the external scanner")
        scanner_end_char(required: false, type: PropertyType.Numeric,
                description: "Specifies which character uses the external scanner as ending")
        operator_id(required: false, type: PropertyType.Numeric,
                description: "ID of user.")
    }

    propertyGroups {
        place_view(place_id, display)
        place_shipment(place_id, shipment_id, display, operator_id)
        place_validation(place_id, operator_id, scanner_input, content, input_type, display, validation_error, flow)
        place_camera(place_id, display, camera_error, operator_id)
        place_external_scanner(place_id, code_type, scanner_input, scanner_output, scanner_end_char)
    }

    "/places"(platform: "/web", isAbstract: true) {}

    "/places/home"(platform: "/web", type: TrackType.View) {}

    "/places/home/geolocation_error"(platform: "/web", type: TrackType.Event) {
        geolocation_error_message(required: true, type: PropertyType.String,
                description: "Specifies the error occurred when trying to get geolocation.")
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/reception"(platform: "/web", type: TrackType.View) {
        place_view
    }

    "/places/outbounds"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/returns"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/reception/congrats"(platform: "/web", type: TrackType.View) {
        place_view
    }

    "/places/inbounds/remove_shipment/confirmed"(platform: "/web", type: TrackType.Event) {
        place_shipment
    }

    "/places/scanner/validate_content"(platform: "/web", type: TrackType.Event) {
        place_validation
    }

    "/places/scanner/error/access_camera"(platform: "/web", type: TrackType.Event) {
        place_camera
    }

    "/places/reception/geolocation_error"(platform: "/web", type: TrackType.Event) {
        geolocation_error_message(required: true, type: PropertyType.String,
                description: "Specifies the error occurred when trying to get geolocation.")
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/outbounds/buyer_qr_scan"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/outbounds/package_qr_scan"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/outbounds/package_identification"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/outbounds/signature"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/outbounds/package_delivery"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/outbounds/package_issue"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/outbounds/early_pickup_error"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/outbounds/scan_validation_error"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/returns/package_scan"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/returns/driver_license_scan"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/returns/congrats"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/home"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/unified_scan_step"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/unified_flow_identification_step"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/helper_info_scanner_view_step"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/helper_info_manual_input_view_step"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/early_pickup_step"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/redirect_outbound_view_step"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/error_step_return"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/error_step_outbound"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/error_step_inbound"(platform: "/web", type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/geolocation_error"(platform: "/web", type: TrackType.Event) {
        geolocation_error_message(required: true, type: PropertyType.String,
                description: "Specifies the error occurred when trying to get geolocation.")
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/containers/container_identification_step"(platform: "/web",
            type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/containers/container_scanner_step"(platform: "/web",
            type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/containers/container_inbound_congrats_view"(platform: "/web",
            type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    "/places/operations/containers/inbound_error_congrats_view"(platform: "/web",
            type: TrackType.View) {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }
}
