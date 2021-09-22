package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("Settings Merchant Account") {
        "/your_business/merchant-settings/merchant-account" (platform: "/web") {}
    }

    test("Settings Aggregator Payment Method") {
        "/your_business/merchant-settings/aggregator-payment-method" (platform: "/web") {}
    }

    test("Settings Aggregator Payment Method - Detail") {
        "/your_business/merchant-settings/aggregator-payment-method/detail" (platform: "/web") {}
    }

    test("Settings Accept Payment Method Gateway - Create Agreement") {
        "/your_business/merchant-settings/accepted-payment-methods/gateway/create-agreement" (platform: "/web") {}
    }

    test("Settings Accept Payment Method Gateway - Create Merchant Account") {
        "/your_business/merchant-settings/accepted-payment-methods/gateway/create-merchant-account" (platform: "/web") {}
    }

    test("Settings Payment Methods") {
        "/your_business/merchant-settings/payment-method" (platform: "/web") {}
    }

    test("Settings Payment Methods - Detail") {
        "/your_business/merchant-settings/payment-method/detail" (platform: "/web") {}
    }

    test("Merchant Account - Congrats") {
        "/your_business/merchant-settings/merchant-account/congrats" (platform: "/web") {}
    }

}
