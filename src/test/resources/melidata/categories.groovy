package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Home Categories Listing") {
        "/categories_root"(platform: "/", type: TrackType.View) {}
    }
}
