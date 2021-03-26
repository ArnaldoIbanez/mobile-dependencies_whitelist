package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("CDN Metrics tracks test") {
        def defaultTrackInformation = {
            fileName = "https://assets.mlstatic.com/frontend-assets/frontend-cdn-metrics/assets/home.desktop.css"
            size = 0
            duration = 601.4849999992293
            cdnProvider = "google"
            cacheStatus = "MISS"
            connection = "4g"
        }

        "/cdn/profiler"(platform: "/", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/cdn/profiler"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/cdn/profiler"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("CDN Metrics tracks test connection not required") {
        def defaultTrackInformation = {
            fileName = "https://assets.mlstatic.com/frontend-assets/frontend-cdn-metrics/assets/home.desktop.css"
            size = 0
            duration = 601.4849999992293
            cdnProvider = "google"
            cacheStatus = "MISS"
        }

        "/cdn/profiler"(platform: "/", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/cdn/profiler"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/cdn/profiler"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }
}
