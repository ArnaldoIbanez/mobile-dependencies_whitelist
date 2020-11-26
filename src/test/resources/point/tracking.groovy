package src.test.resources.point

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("test path") {
        "/"(platform: "/") {}
    }

}