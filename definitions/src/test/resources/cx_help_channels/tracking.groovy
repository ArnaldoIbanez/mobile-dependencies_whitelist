package src.test.resources.cx_help_channels

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "cx_help_channels"

    test("test path") {
        "/"(platform: "/") {}
    }

}