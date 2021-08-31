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

        "/places/reception/geolocation_error"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
            geolocation_error_message = "Error acquiring geolocation"
        }
    }

    test("places home view") {
        "/places/home"(platform: "/web", type: TrackType.View) {}
    }

    test("places home geolocation_error") {

        def defaultTrackInformation = {
            place_id = "123456"
            geolocation_error_message = "Permission denied"
        }

        "/places/home/geolocation_error"(platform: "/web", type: TrackType.Event) {
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

    test("places reception geolocation_error") {

        def defaultTrackInformation = {
            place_id = "123456"
            geolocation_error_message = "Permission denied"
        }

        "/places/home/geolocation_error"(platform: "/web", type: TrackType.Event) {
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

        "/places/outbounds"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
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

        "/places/returns"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
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

    test("places operations home") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/home"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations unified scanner step") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/unified_scan_step"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations detailed transition screen") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/unified_flow_identification_step"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations helper screen in scanner") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/helper_info_scanner_view_step"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations helper screen in manual input") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/helper_info_manual_input_view_step"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations early pickup information screen") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/early_pickup_step"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations spinner only transition view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/redirect_outbound_view_step"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations returns error") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/error_step_return"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations outbounds error") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/error_step_outbound"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations inbounds error") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/error_step_inbound"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations geolocation_error") {

        def defaultTrackInformation = {
            place_id = "123456"
            geolocation_error_message = "Permission denied"
        }

        "/places/operations/geolocation_error"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("places operations containers container_identification_step") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/containers/container_identification_step"(platform: "/web",
                type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations containers container_scanner_step") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/containers/container_scanner_step"(platform: "/web",
                type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations containers container_inbound_congrats_view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/containers/container_inbound_congrats_view"(platform: "/web",
                type: TrackType.View) {
            defaultTrackInformation()
        }
    }

    test("places operations containers inbound_error_congrats_view") {

        def defaultTrackInformation = {
            place_id = "123456"
        }

        "/places/operations/containers/inbound_error_congrats_view"(platform: "/web",
                type: TrackType.View) {
            defaultTrackInformation()
        }
    }
}
