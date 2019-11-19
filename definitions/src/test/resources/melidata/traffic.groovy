package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("Traffic") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
        }
    }

    test("Traffic") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
        }
    }

    test("Mercado Pago Traffic from mobile/ios") {
        "/traffic/inbound/matt"(platform: "/mobile/ios", business:"mercadopago") {
            tool = 123456
            word = "campaignName"
            go = "https://www.mercadopago.com.mx/qr-code"
        }
    }

    test("Mercado Pago Traffic from mobile/android") {
        "/traffic/inbound/matt"(platform: "/mobile/android", business:"mercadopago") {
            tool = 123456
            word = "campaignName"
            go = "https://www.mercadopago.com.mx/qr-code"
        }
    }

    test("Mercado Pago Traffic from mobile/ios no word") {
        "/traffic/inbound/matt"(platform: "/mobile/ios", business:"mercadopago") {
            tool = 123456
            go = "https://www.mercadopago.com.mx/qr-code"
        }
    }

    test("Mercado Pago Traffic from mobile/android no word") {
        "/traffic/inbound/matt"(platform: "/mobile/android", business:"mercadopago") {
            tool = 123456
            go = "https://www.mercadopago.com.mx/qr-code"
        }
    }

    test("Google search traffic") {
        "/traffic/inbound/organic"(platform: "/") {
            referrer = "www.google.com"
        }

        "/traffic/inbound/organic"(platform: "/", business: "mercadopago") {
            referrer = "www.google.com"
        }
    }

    test("Notification traffic") {
        "/traffic/inbound/notification"(platform: "/") {
            news_id = "12332323"
        }

        "/traffic/inbound/notification"(platform: "/", business: "mercadopago") {
            news_id = "12332323"
        }
    }
}