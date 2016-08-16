import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

  defaultBusiness = "mercadopago"

  test("Root tracking") {
    "/"(platform: "/mobile") {}

    "/"(platform: "/web/desktop") {}
  }
}


