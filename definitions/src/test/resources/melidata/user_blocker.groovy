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
    }
}