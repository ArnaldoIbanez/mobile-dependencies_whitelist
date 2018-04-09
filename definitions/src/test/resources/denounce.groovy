import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Denounce tracks") {

        "/denounce/form"(platform: "/") {}
        "/denounce/form/success"(platform: "/") {}

        "/denounce/form/error"(platform: "/") {}
        "/denounce/error"(platform: "/") {}

    }
}
