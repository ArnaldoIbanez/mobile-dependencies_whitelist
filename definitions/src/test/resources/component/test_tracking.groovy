package src.test.resources.component

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "component_prints"

    test("test path") {
        "/component"(platform: "/mobile/android", type: TrackType.Event) {}
        "/component"(platform: "/mobile/ios", type: TrackType.Event) {}
        "/component"(platform: "/web/desktop", type: TrackType.Event) {}
        "/component"(platform: "/web/mobile", type: TrackType.Event) {}
    }
}






