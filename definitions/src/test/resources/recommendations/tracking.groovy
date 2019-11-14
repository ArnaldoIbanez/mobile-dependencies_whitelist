package src.test.resources.recommendations

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "recommendations"

    test("test path") {
        "/"(platform: "/") {}
    }

}