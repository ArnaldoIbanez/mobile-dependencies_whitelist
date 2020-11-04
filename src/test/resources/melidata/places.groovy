package src.text.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    test("places reception view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/reception"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places reception_congrats view") {

        def defaultTrackInformation = {
            place_id = "123456"
            display = "browser"
        }

        "/places/reception/congrats"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places reception remove shipment confirmed event") {

        def defaultTrackInformation = {
            place_id = "123456"
            shipment_id = "12345678901"
            display = "browser"
        }

        "/places/reception/list/remove_shipment/confirmed"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places reception manual input event") {

        def defaultTrackInformation = {
            place_id = "123456"
            shipment_id = "12345678901"
            display = "browser"
        }

        "/places/reception/manual"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places reception external scan") {

        def defaultTrackInformation = {
            place_id = "123456"
            code_type = "QR"
            scanner_input = "{'id':'12345678901', hash: 'jndiSD_FSGXn289352hjfXF'}"
            scanner_output = "{'id':'12345678901'}"
            scanner_end_char = 13
        }

        "/places/reception/external_scan"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places reception validation error event with valid data") {

        def defaultTrackInformation = {
            place_id = "123456"
            shipment_id = "12345678901"
            display = "browser"
            validation_error = "duplicated"
        }

        "/places/reception/validate_shipment/error"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places reception validation error event with invalid data") {

        def defaultTrackInformation = {
            place_id = "123456"
            display = "browser"
            validation_error = "invalid_data"
            invalid_data = "I8fhuje2324fffkklfsnN"
        }

        "/places/reception/validate_shipment/error"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places reception camera error event") {

        def defaultTrackInformation = {
            place_id = "123456"
            display = "browser"
            camera_error = "not_allowed"
        }

        "/places/reception/access_camera/error"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places outbounds buyer qr scan view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/outbounds/buyer_qr_scan"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places outbounds package qr scan view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/outbounds/package_qr_scan"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places outbounds package identification view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/outbounds/package_identification"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places outbounds client signature view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/outbounds/signature"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places outbounds package delivery successful view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/outbounds/package_delivery"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places outbounds issue with package to deliver view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/outbounds/package_issue"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places outbounds pickup too soon view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/outbounds/early_pickup_error"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places outbounds scan validation error view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/outbounds/scan_validation_error"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places returns package scan view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/returns/package_scan"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places returns last mile driver license scan view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/returns/driver_license_scan"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places returns successful return view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/returns/congrats"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }
}
