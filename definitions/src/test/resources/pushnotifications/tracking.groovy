package src.test.resources.pushnotifications

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("test path") {
        "/"(platform: "/") {}
    }

}