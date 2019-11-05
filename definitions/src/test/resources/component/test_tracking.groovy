package src.test.resources.component

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "component"

    test("test path") {

        "/"(platform: "/") {}

        "/component"(platform: "/mobile/android", type: TrackType.Event) {}
        "/component"(platform: "/mobile/ios", type: TrackType.Event) {}
        "/component"(platform: "/web/desktop", type: TrackType.Event) {}
        "/component"(platform: "/web/mobile", type: TrackType.Event) {}
    }
}
