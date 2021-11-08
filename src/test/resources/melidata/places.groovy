package src.text.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

	test("places operations home step with place_id") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/home"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations home step without place_id") {
        def defaultTrackInformation = {
            place_id = null
        }

        "/places/operations/home"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations invalid user validation view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/init_validation/error/invalid_user"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    // Unified Screens
	test("places operations unified qr scanner step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/unified/qr_scanner"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations unified qr scanner helper view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/unified/helper_info_qr_scanner"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations unified manual input helper view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/unified/helper_info_manual_input"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    // Identification Views
	test("places operations buyer returns identification step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/identification/buyer_returns"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations containers identification step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/identification/containers"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations inbounds identification step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/identification/inbounds"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations returns identification step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/identification/returns"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	// Inbounds
	test("places operations containers qr scanner step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/inbounds/containers/qr_scanner"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations inbounds multiple scanner step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/inbounds/multiple_scanner"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations inbounds congrats step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/inbounds/congrats"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations containers inbound congrats step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/inbounds/containers/congrats"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations containers error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/inbounds/error/containers_screen"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations inbounds invalid input error") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/inbounds/error/invalid_input_format_data"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations inbounds congrats step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/inbounds/error/congrats"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations inbounds error invalid scan view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/inbounds/error/invalid_scan"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	// Outbounds
	test("places operations outbounds early pickup view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/early_pickup"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds package identification step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/package_identification"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds package qr scanner step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/package_qr_scanner"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds deliver package to buyer step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/package_delivery_to_buyer"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds issue with package delivery to buyer step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/package_delivery_issue_buyer_report"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds issue with package step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/package_issue_report"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds congrats step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/package_delivery_congrats"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds package rejected step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/reports_package_rejected_reason"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds error status view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/error/status"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds package scan validation error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/error/package_scan_validation"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations outbounds report package problem error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/error/reports_package_problem"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations invalid qr driver error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/outbounds/error/invalid_qr_driver"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	// Returns
	test("places operations returns qr scanner view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/returns/qr_scanner"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations returns qr driver scanner step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/returns/qr_driver_scanner"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations returns qr driver instructions view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/returns/scan_qr_driver_instruction"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations returns congrats step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/returns/delivery_congrats"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	test("places operations returns invalid package error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/eturns/error/invalid_package_for_return"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	// Buyer Returns
    test("places operations buyer returns content qr scanner step") {
        def defaultTrackInformation = {
          	place_id = "123456"
        }

        "/places/operations/buyer_returns/content_qr_scan"(platform: "/web", type: TrackType.View) {
        	defaultTrackInformation()
        }
    }

    test("places operations returns error scan validation view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/error/content_scan_validation"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations buyer returns invalid phrase error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/error/invalid_phrase"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations outbounds package qr scanned first error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/error/label_qr_scanned_first"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations duplicated label error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/error/label_duplicated_validation"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations qr scan validation error view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/error/label_qr_scan_validation"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations buyer returns label already printed validation view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/label_printed_issue"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations buyer returns label scan view") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/label_scan"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations buyer returns label already printed verification step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/label_printed_verification"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations buyer returns congrats step") {
        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/buyer_returns/reception_congrats"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

	// Events
    test("places operations geolocation error View") {
        def defaultTrackInformation = {
            geolocation_error_message = "geolocation error message test"
            place_id = "123456"
        }

        "/places/operations/geolocation_error"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }
}
