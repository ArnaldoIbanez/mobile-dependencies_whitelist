package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    test("Full landing buyer") {
        "/full/landing/buyer"(platform: "/", type: TrackType.View) {}
    }
}