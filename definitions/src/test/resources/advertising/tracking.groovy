package src.test.resources.advertising

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "advertising"

    test("test path") {
        "/"(platform: "/") {}
    }

}