package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"
    test("navigation download app show track") {
        "/navigation/download-app/show"(platform: "/", type: TrackType.View) {
            app_id="web-vip"
        }
    }

    test("navigation download app close track") {
        "/navigation/download-app/close"(platform: "/", type: TrackType.Event) {
            app_id="web-vip"
        }
    }

    test("navigation download app download track") {
        "/navigation/download-app/download"(platform: "/", type: TrackType.Event) {
            app_id="web-vip"
        }
    }
}
