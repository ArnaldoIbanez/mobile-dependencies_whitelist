package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1180"

    propertyDefinitions {
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }

    propertyGroups {
        mandatory(place_id)
    }

	// Generic

    "/places"(platform: "/web", isAbstract: true) {}

    "/places/operations/home"(platform: "/web", type: TrackType.View) {
            place_id(required: false, type: PropertyType.String,
            	description: "ID of place (agency) user operates in.")
    }

	"/places/operations/init_validation/error/invalid_user"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	// Unified Screens
	"/places/operations/unified/qr_scanner"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/unified/helper_info_qr_scanner"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/unified/helper_info_manual_input"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	// Identification Views
	"/places/operations/identification/buyer_returns"(platform: "/web", type: TrackType.View) {
		mandatory
    }

	"/places/operations/identification/containers"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/identification/inbounds"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/identification/returns"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	// Inbounds
	"/places/operations/inbounds/containers/qr_scanner"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/inbounds/multiple_scanner"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/inbounds/congrats"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/inbounds/containers/congrats"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/inbounds/error/containers_screen"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/inbounds/error/invalid_input_format_data"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/inbounds/error/congrats"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/inbounds/error/invalid_scan"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	// Outbounds
	"/places/operations/outbounds/early_pickup"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/package_identification"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/package_qr_scanner"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/package_delivery_to_buyer"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/package_delivery_issue_buyer_report"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/package_issue_report"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/package_delivery_congrats"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/reports_package_rejected_reason"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/error/status"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/error/package_scan_validation"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/error/reports_package_problem"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/outbounds/error/invalid_qr_driver"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	// Returns
	"/places/operations/returns/qr_scanner"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/returns/qr_driver_scanner"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/returns/scan_qr_driver_instruction"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/returns/delivery_congrats"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/eturns/error/invalid_package_for_return"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	// Buyer Returns
	"/places/operations/buyer_returns/content_qr_scan"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/buyer_returns/error/content_scan_validation"(platform: "/web", type: TrackType.View) {
        mandatory
    }

	"/places/operations/buyer_returns/error/invalid_phrase"(platform: "/web", type: TrackType.View) {
        mandatory
    }

    "/places/operations/buyer_returns/error/label_qr_scanned_first"(platform: "/web", type: TrackType.View) {
        mandatory
    }

    "/places/operations/buyer_returns/error/label_duplicated_validation"(platform: "/web", type: TrackType.View) {
        mandatory
    }

    "/places/operations/buyer_returns/error/label_qr_scan_validation"(platform: "/web", type: TrackType.View) {
        mandatory
    }

    "/places/operations/buyer_returns/label_printed_issue"(platform: "/web", type: TrackType.View) {
        mandatory
    }

    "/places/operations/buyer_returns/label_scan"(platform: "/web", type: TrackType.View) {
        mandatory
    }

    "/places/operations/buyer_returns/label_printed_verification"(platform: "/web", type: TrackType.View) {
        mandatory
    }

    "/places/operations/buyer_returns/reception_congrats"(platform: "/web", type: TrackType.View) {
    	mandatory
    }

	// Events
    "/places/operations/geolocation_error"(platform: "/web", type: TrackType.Event) {
        geolocation_error_message(required: true, type: PropertyType.String,
                description: "Specifies the error occurred when trying to get geolocation.")
        place_id(required: true, type: PropertyType.String,
                description: "ID of place (agency) user operates in.")
    }
}
