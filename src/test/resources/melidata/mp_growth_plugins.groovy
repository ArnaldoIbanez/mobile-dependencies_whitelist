package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Landing mercadopago plugins woocommerce") {
        "/landing/woocommerce" (platform: "/web") {}
    }

    test("Landing mercadopago plugins woocommerce with browser_id") {
        "/landing/woocommerce" (platform: "/web") {
            browser_id = "111111-22222-333333-444444"
        }
    }

}
