package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Landing mercadopago internal products suscripciones") {
        "/landing/suscripciones" (platform: "/web") {}
    }

    test("Landing mercadopago internal products suscripciones with browser_id") {
        "/landing/suscripciones" (platform: "/web") {
            browser_id = "111111-22222-333333-444444"
        }
    }

}
