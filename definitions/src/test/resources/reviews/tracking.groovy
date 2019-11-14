package src.test.resources.reviews

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "reviews"

    test("test path") {
        "/"(platform: "/") {}
    }

}