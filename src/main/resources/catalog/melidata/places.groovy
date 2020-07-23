package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1180"

    propertyDefinitions {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
        shipment_id(required: true, type: PropertyType.Numeric,
                description: "ID of shipment being validated for reception.")
        display(required: true, type: PropertyType.String, values: ["browser", "standalone", "none"],
                description: "Specifies the display mode app is running as.")
        validation_error(required: true, type: PropertyType.String,
                values: ["duplicated", "invalid_shipment", "not_found", "internal_error", "no_connection", "invalid_data"],
                description: "Specifies what kind of validation error happened.")
        camera_error(required: true, type: PropertyType.String,
                values: ["not_allowed", "blocked"],
                description: "Specifies what kind of camera error happened.")
        code_type(required: true, type: PropertyType.String,
                values: ["QRCode", "Datamatrix", "Barcode"],
                description: "Specifies what kind of 1D/2D code were scanned")
        scanner_input(required: true, type: PropertyType.String,
                description: "Specifies the raw input of the external scanner")
        scanner_output(required: true, type: PropertyType.String,
                description: "Specifies the processed output of the external scanner")
        scanner_end_char(required: true, type: PropertyType.Number,
                values: [13, 16],
                description: "Specifies which character uses the external scanner as ending")
    }

    propertyGroups {
        place_view(place_id, display)
        place_shipment(place_id, shipment_id, display)
        place_validation(place_id, shipment_id, display, validation_error)
        place_camera(place_id, display, camera_error)
        place_external_scanner(place_id, code_type, scanner_input, scanner_output, scanner_end_char)
    }

    "/places"(platform: "/web", isAbstract: true) {}

    "/places/home"(platform: "/web", type: TrackType.View) {
        place_view
    }

    "/places/reception"(platform: "/web", type: TrackType.View) {
        place_view
    }

    "/places/reception/congrats"(platform: "/web", type: TrackType.View) {
        place_view
    }

    "/places/reception/list/remove_shipment/confirmed"(platform: "/web", type: TrackType.Event) {
        place_shipment
    }

    "/places/reception/manual"(platform: "/web", type: TrackType.Event) {
        place_shipment
    }

    "/places/reception/validate_shipment/error"(platform: "/web", type: TrackType.Event) {
        place_validation
    }

    "/places/reception/access_camera/error"(platform: "/web", type: TrackType.Event) {
        place_camera
    }

    "/places/reception/external_scan"(platform: "/web", type: TrackType.Event) {
        place_external_scanner
    }

    "/places/outbounds/buyer-qr-scan"(platform: "/web", type: TrackType.View) {}
    "/places/outbounds/package-qr-scan"(platform: "/web", type: TrackType.View) {}
    "/places/outbounds/package-identification"(platform: "/web", type: TrackType.View) {}
    "/places/outbounds/signature"(platform: "/web", type: TrackType.View) {}
    "/places/outbounds/package-delivery"(platform: "/web", type: TrackType.View) {}
    "/places/outbounds/package-issue"(platform: "/web", type: TrackType.View) {}
    "/places/outbounds/early-pickup-error"(platform: "/web", type: TrackType.View) {}
    "/places/outbounds/scan-validation-error"(platform: "/web", type: TrackType.View) {}

    "/places/returns/package-scan"(platform: "/web", type: TrackType.View) {}
    "/places/returns/driver-license-scan"(platform: "/web", type: TrackType.View) {}
    "/places/returns/congrats"(platform: "/web", type: TrackType.View) {}
}