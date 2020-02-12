package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("current location hub page view") {
        "/current_location/hub"(platform: "/", type: TrackType.View) {
            has_errors=true
            addresses_quantity=2
            zipcode="8999"
        }
    }

    test("current location navigation pick") {
        "/current_location/navigation/pick"(platform: "/", type: TrackType.Event) {}
        "/current_location/navigation/pick"(platform: "/", type: TrackType.Event) {
            app="homes-palpatine"
        }
    }

    test("current location navigation close modal") {
        "/current_location/navigation/close"(platform: "/", type: TrackType.Event) {}
    }

    test("current location navigation pick by the onboarding") {
        "/current_location/navigation/pick_onboarding"(platform: "/", type: TrackType.Event) {
            origin="header"
            type="newbie"
        }

        "/current_location/navigation/pick_onboarding"(platform: "/", type: TrackType.Event) {
            origin="header"
            type="location"
        }
    }

    test("current location navigation close onboarding tooltip") {
        "/current_location/navigation/close_onboarding"(platform: "/", type: TrackType.Event) {
            origin="cross"
            type="location"
        }
        "/current_location/navigation/close_onboarding"(platform: "/", type: TrackType.Event) {
            origin="cross"
            type="newbie"
        }
    }

    test("current location hub create address") {
        "/current_location/hub/create_address"(platform: "/", type: TrackType.Event) {}
    }

    test("current location hub zipcode finder") {
        "/current_location/hub/find_zipcode"(platform: "/", type: TrackType.Event) {}
    }

    test("current location hub address selected") {
        "/current_location/hub/select_address"(platform: "/", type: TrackType.Event) {}
    }

    test("current location hub added zipcode") {
        "/current_location/hub/add_zipcode"(platform: "/", type: TrackType.Event) {
            has_errors=true
            zipcode="8999"
        }
    }
}
