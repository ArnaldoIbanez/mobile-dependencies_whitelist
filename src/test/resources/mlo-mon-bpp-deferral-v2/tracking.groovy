package src.test.resources.mlo_mon_fda_test_app

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("test path") {
        "/"(platform: "/") {}
    }

}