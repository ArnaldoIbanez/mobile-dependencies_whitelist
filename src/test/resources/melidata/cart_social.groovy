package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoshops"

     test("Social networks") {
        "/cart/social"(platform: "/", type: TrackType.Event) {
            social_network = "facebook"
        }
     }
     
}
