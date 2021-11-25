package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Landing mercadopago internal products suscripciones") {
        "/landing/subscriptions" (platform: "/web") {}
    }

    test("Landing mercadopago internal products checkouts") {
        "/landing/checkouts" (platform: "/web") {}
    }

    test("Landing mercadopago internal products buyer credits") {
        "/landing/buyers" (platform: "/web") {}
    }

}
