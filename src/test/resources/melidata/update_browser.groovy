package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Update browser tracks test") {
        def defaultTrackInformation = {
            category = "UPDATE_BROWSER"
            action = "DOWNLOAD_INTENTION"
            label = "CHROME"
        }

        "/sentry/update_browser"(platform: "/", type: TrackType.View) {}
        "/sentry/update_browser"(platform: "/web", type: TrackType.View) {}
        "/sentry/update_browser"(platform: "/mobile", type: TrackType.View) {}

        "/sentry/update_browser"(platform: "/", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/sentry/update_browser"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/sentry/update_browser"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }
}
