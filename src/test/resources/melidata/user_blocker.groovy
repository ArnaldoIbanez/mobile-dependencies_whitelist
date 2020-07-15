package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("user_blocker") {
        "/user_blocker/shield"(platform: "/mobile") {}
        "/user_blocker/webview"(platform: "/mobile") {}
        "/user_blocker/redirect"(platform: "/mobile") {}

        //Redirect events
        "/user_blocker/redirect/load"(platform: "/") {
            label = "service"
            deeplink = "mercadopago://user_blocker/shield"
        }
        "/user_blocker/redirect/skip"(platform: "/") {
            label = "service_error"
            verbose = "se agoto el tiempo de espera"
        }
        "/user_blocker/redirect/block"(platform: "/") {
            deeplink = "mercadopago://user_blocker/shield"
        }
        "/user_blocker/redirect/continue"(platform: "/") {
            label = "service"
            duration = "1245"
        }

        //Shield events
        "/user_blocker/shield/close"(platform: "/") {
            label = "kyc-afip"
            deeplink = "mercadopago://user_blocker/finish"
        }
        "/user_blocker/shield/link_action"(platform: "/") {
            label = "kyc-afip"
            deeplink = "mercadopago://user_blocker/webview?title=Faqs&url=www.mercadopago.com/faqs"
        }
        "/user_blocker/shield/main_action"(platform: "/") {
            label = "kyc-afip"
            deeplink = "mercadopago://kyc/"
        }
        "/user_blocker/shield/secondary_action"(platform: "/") {
            label = "kyc-afip"
            deeplink = "mercadopago://user_blocker/logout"
        }
        "/user_blocker/shield/skip"(platform: "/") {
            label = "kyc-afip"
            deeplink = "mercadopago://home"
        }

        //Finish events
        "/user_blocker/finish"(platform: "/") {
            deeplink = "mercadopago://home"
        }

        //Async mode events
        "/user_blocker/async_mode_load"(platform: "/") {
            label = "service_success"
            deeplink = "mercadopago://home"
        }

        //Meli Tests

        "/user_blocker/shield"(platform: "/mobile", business: "mercadolibre") {}
        "/user_blocker/webview"(platform: "/mobile", business: "mercadolibre") {}
        "/user_blocker/redirect"(platform: "/mobile", business: "mercadolibre") {}

        //Redirect events
        "/user_blocker/redirect/load"(platform: "/", business: "mercadolibre") {
            label = "service"
            deeplink = "meli://user_blocker/shield"
        }
        "/user_blocker/redirect/skip"(platform: "/", business: "mercadolibre") {
            label = "service_error"
            verbose = "se agoto el tiempo de espera"
        }
        "/user_blocker/redirect/block"(platform: "/", business: "mercadolibre") {
            deeplink = "meli://user_blocker/shield"
        }
        "/user_blocker/redirect/continue"(platform: "/", business: "mercadolibre") {
            label = "service"
            duration = "1245"
        }

        //Shield events
        "/user_blocker/shield/close"(platform: "/", business: "mercadolibre") {
            label = "kyc-afip"
            deeplink = "meli://user_blocker/finish"
        }
        "/user_blocker/shield/link_action"(platform: "/", business: "mercadolibre") {
            label = "kyc-afip"
            deeplink = "meli://user_blocker/webview?title=Faqs&url=www.mercadolibre.com/faqs"
        }
        "/user_blocker/shield/main_action"(platform: "/", business: "mercadolibre") {
            label = "kyc-afip"
            deeplink = "meli://kyc/"
        }
        "/user_blocker/shield/secondary_action"(platform: "/", business: "mercadolibre") {
            label = "kyc-afip"
            deeplink = "meli://user_blocker/logout"
        }
        "/user_blocker/shield/skip"(platform: "/", business: "mercadolibre") {
            label = "kyc-afip"
            deeplink = "meli://home"
        }

        //Finish events
        "/user_blocker/finish"(platform: "/", business: "mercadolibre") {
            deeplink = "meli://home"
        }

        //Async mode events
        "/user_blocker/async_mode_load"(platform: "/", business: "mercadolibre") {
            label = "service_success"
            deeplink = "meli://home"
        }
    }
}