import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("current location hub page view") {
        "/current_location/hub"(platform: "/", type: TrackType.View) {}
    }

    test("current location navigation pick") {
        "/current_location/navigation/pick"(platform: "/", type: TrackType.Event) {}
    }

    test("current location navigation close modal") {
        "/current_location/navigation/close"(platform: "/", type: TrackType.Event) {}
    }

    test("current location hub pick error") {
        "/current_location/hub/pick/error"(platform: "/", type: TrackType.Event) {
            action = "address"
            text = "Ocurrio un error"
        }
    }

    test("current location hub create address") {
        "/current_location/hub/create_address"(platform: "/", type: TrackType.Event) {}
    }

    test("current location hub zipcode finder") {
        "/current_location/hub/zipcode_finder"(platform: "/", type: TrackType.Event) {}
    }

    test("current location hub address selected") {
        "/current_location/hub/pick"(platform: "/", type: TrackType.Event) {
            action = "address"
        }
        "/current_location/hub/pick"(platform: "/", type: TrackType.Event) {
            action = "zipcode"
        }
    }
}
