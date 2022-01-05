package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

/**
* Pricing Point tracks
*/
trackTests {

    defaultBusiness = "mercadopago"

    test("MP Pricing Point pricing-scale") {
      "/point/pricing/scale"(platform: "/", type: TrackType.View) {}
      "/point/pricing/scale/success"(platform: "/", type: TrackType.View) {}
      "/point/pricing/scale/error"(platform: "/", type: TrackType.View) {}
    }

}