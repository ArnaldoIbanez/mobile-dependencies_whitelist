package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("zip finder search page") {
        "/zip_finder/search"(platform: "/", type: TrackType.View) {}
    }

    test("zip finder final step") {
        "/zip_finder/finish"(platform: "/", type: TrackType.View) {}
    }

    test("zip finder listing page") {
        "/zip_finder/list"(platform: "/", type: TrackType.View) {}
    }

    test("zip finder interaction with zipcode") {
        "/zip_finder/list/select_zip_code"(platform: "/", type: TrackType.Event) {
            action = "use"
        }
        "/zip_finder/list/select_zip_code"(platform: "/", type: TrackType.Event) {
            action = "copy"
        }
    }

    defaultBusiness = "mercadopago"

    test("zip finder search page") {
        "/zip_finder/search"(platform: "/", type: TrackType.View) {}
    }

    test("zip finder final step") {
        "/zip_finder/finish"(platform: "/", type: TrackType.View) {}
    }

    test("zip finder listing page") {
        "/zip_finder/list"(platform: "/", type: TrackType.View) {}
    }

    test("zip finder interaction with zipcode") {
        "/zip_finder/list/select_zip_code"(platform: "/", type: TrackType.Event) {
            action = "use"
        }
        "/zip_finder/list/select_zip_code"(platform: "/", type: TrackType.Event) {
            action = "copy"
        }
    }
}
