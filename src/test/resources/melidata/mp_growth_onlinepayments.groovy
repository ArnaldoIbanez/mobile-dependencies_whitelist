package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Landing mercadopago online payments websites") {
        "/landing/onlinepayments/websites" (platform: "/web") {}
    }

    test("Landing mercadopago online payments websites with browser_id") {
        "/landing/onlinepayments/websites" (platform: "/web") {
            browser_id = "111111-22222-333333-444444"
        }
    }

    test("Landing mercadopago online payments social") {
        "/landing/onlinepayments/social" (platform: "/web") {}
    }

    test("Landing mercadopago online payments social with browser_id") {
        "/landing/onlinepayments/social" (platform: "/web") {
            browser_id = "111111-22222-333333-444444"
        }
    }

    test("Landing mercadopago online payments") {
        "/landing/onlinepayments" (platform: "/web") {}
    }

    test("Landing mercadopago online payments with browser_id") {
        "/landing/onlinepayments" (platform: "/web") {
            browser_id = "111111-22222-333333-444444"
        }
    }

    test("Landing mercadopago online payments shopify") {
        "/landing/shopify" (platform: "/web") {}
    }

    test("Landing mercadopago online payments shopify with browser_id") {
        "/landing/shopify" (platform: "/web") {
            browser_id = "111111-22222-333333-444444"
        }
    }

}
