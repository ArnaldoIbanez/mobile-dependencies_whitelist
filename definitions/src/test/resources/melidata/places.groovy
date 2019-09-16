package src.text.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    test("places home view") {

        def defaultTrackInformation = {
            place_id = "123456"
            display = "browser"
        }

        "/places/home"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }

    }

    test("places reception view") {

        def defaultTrackInformation = {
            place_id = "123456"
            display = "browser"
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

        "/places/reception_congrats"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }

    }

    test("places reception remove shipment confirmed event") {

        def defaultTrackInformation = {
            place_id = "123456"
            shipment_id = 12345678901
            display = "browser"
        }

        "/places/reception/remove_shipment/confirmed"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

    }

    test("places reception manual input event") {

        def defaultTrackInformation = {
            place_id = "123456"
            shipment_id = 12345678901
            display = "browser"
        }

        "/places/reception/manual"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

    }

    test("places reception validation error event") {

        def defaultTrackInformation = {
            place_id = "123456"
            shipment_id = 12345678901
            validation_error = "duplicated"
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

}