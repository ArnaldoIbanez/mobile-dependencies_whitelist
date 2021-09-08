package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Update browser tracks test") {
        "/sentry/update_browser"(platform: "/", type: TrackType.View) {}
        "/sentry/update_browser"(platform: "/web", type: TrackType.View) {}
        "/sentry/update_browser"(platform: "/mobile", type: TrackType.View) {}

        "/sentry/update_browser/download_intention"(platform: "/", type: TrackType.Event) {
            label = "chrome"
        }
        "/sentry/update_browser/download_intention"(platform: "/web", type: TrackType.Event) {
            label = "chrome"
        }
        "/sentry/update_browser/download_intention"(platform: "/mobile", type: TrackType.Event) {
            label = "chrome"
        }

        "/sentry/update_browser/download_intention"(platform: "/", type: TrackType.Event) {
            label = "firefox"
        }
        "/sentry/update_browser/download_intention"(platform: "/web", type: TrackType.Event) {
            label = "firefox"
        }
        "/sentry/update_browser/download_intention"(platform: "/mobile", type: TrackType.Event) {
            label = "firefox"
        }

        "/sentry/update_browser/download_intention"(platform: "/", type: TrackType.Event) {
            label = "edge"
        }
        "/sentry/update_browser/download_intention"(platform: "/web", type: TrackType.Event) {
            label = "edge"
        }
        "/sentry/update_browser/download_intention"(platform: "/mobile", type: TrackType.Event) {
            label = "edge"
        }

        "/sentry/update_browser/download_reject"(platform: "/", type: TrackType.Event) {
            label = "not_now"
        }
        "/sentry/update_browser/download_reject"(platform: "/web", type: TrackType.Event) {
            label = "not_now"
        }
        "/sentry/update_browser/download_reject"(platform: "/mobile", type: TrackType.Event) {
            label = "not_now"
        }
    }
}
