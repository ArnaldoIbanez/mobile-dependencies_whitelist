import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("Security Settings") {
        "/security_settings"(platform: "/", type: TrackType.View) {}

        "/security_settings/2fa"(platform: "/", type: TrackType.View) {}

        "/security_settings/2fa/switch"(platform: "/", type: TrackType.Event) {
            status = "opted_in"
        }
    }
}