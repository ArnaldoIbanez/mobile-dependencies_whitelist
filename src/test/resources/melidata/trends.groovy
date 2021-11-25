package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Tendencias tracks test") {
        "/trends"(platform: "/", type: TrackType.View) {}
        "/trends"(platform: "/web", type: TrackType.View) {}
        "/trends"(platform: "/mobile", type: TrackType.View) {}

        "/trends/index"(platform: "/", type: TrackType.View) {}
        "/trends/index"(platform: "/web", type: TrackType.View) {}
        "/trends/index"(platform: "/mobile", type: TrackType.View) {}

        "/trends/categ"(platform: "/", type: TrackType.View) {}
        "/trends/categ"(platform: "/web", type: TrackType.View) {}
        "/trends/categ"(platform: "/mobile", type: TrackType.View) {}
    }
}
