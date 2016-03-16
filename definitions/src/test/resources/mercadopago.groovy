import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

  defaultBusiness = "mercadopago"

  test("mercadopago") {
    "/mp/test"(platform: "/", business: "mercadopago") {
      id = "123"
    }

  }

}


