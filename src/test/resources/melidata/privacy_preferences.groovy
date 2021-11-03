import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("MercadoLibre: Privacy Preferences Hub") {
        "/privacy_preferences"(platform: "/") {}
        "/privacy_preferences/data_usage"(platform: "/", type: TrackType.Event) {
            denied = true
        }
    }

    test("MercadoLibre: Privacy Preferences Export") {
        "/privacy_preferences/export"(platform: "/") {}
        "/privacy_preferences/export/download"(platform: "/") {}
        "/privacy_preferences/export/create"(platform: "/", type: TrackType.Event) {
            entity_groups = ['personal_data-description', 'my_account-description', 'purchases-description']
        }
        "/privacy_preferences/onboarding"(platform: "/") {}
    }

    test("MercadoLibre: Privacy Preferences Cookies") {
        "/privacy_preferences/cookies"(platform: "/") {}
        "/privacy_preferences/cookies/save"(platform: "/", type: TrackType.Event) {
            advertising = true
        }
        "/privacy_preferences/cookies/switch"(platform: "/", type: TrackType.Event) {
            advertising = true
        }
        "/privacy_preferences/cookies/cancel"(platform: "/") {}
    }

   test("MercadoPago: Privacy Preferences Cookies") {
        "/privacy_preferences/cookies"(platform: "/", business: "mercadopago") {}
        "/privacy_preferences/cookies/save"(platform: "/", business: "mercadopago", type: TrackType.Event) {
            advertising = true
        }
        "/privacy_preferences/cookies/switch"(platform: "/", business: "mercadopago", type: TrackType.Event) {
            advertising = true
        }
        "/privacy_preferences/cookies/cancel"(platform: "/", business: "mercadopago") {}
    }

    test("MercadoPago: Privacy Preferences Hub ") {
        "/privacy_preferences"(platform: "/", business: "mercadopago") {}
        "/privacy_preferences/data_usage"(platform: "/", business: "mercadopago", type: TrackType.Event) {
            denied = true
        }
    }

    test("MercadoPago: Privacy Preferences Export") {
        "/privacy_preferences/export"(platform: "/", business: "mercadopago") {}
        "/privacy_preferences/export/download"(platform: "/", business: "mercadopago") {}
        "/privacy_preferences/export/create"(platform: "/", business: "mercadopago", type: TrackType.Event) {
            entity_groups = ['personal_data-description', 'my_account-description', 'purchases-description']
        }
        "/privacy_preferences/onboarding"(platform: "/", business: "mercadopago") {}
    }

    test("MercadoPago: Privacy view for LGPD") {
        "/advertising"(platform: "/", business: "mercadopago"){}
        "/advertising/privacy"(platform: "/", business: "mercadopago", type: TrackType.View) {}
        "/advertising/privacy/modal"(platform: "/", business: "mercadopago", type: TrackType.Event) {}
        "/advertising/privacy/modal/show"(platform: "/", business: "mercadopago", type: TrackType.Event) {
            switch_status = "enabled"
        }
        "/advertising/privacy/modal/deactivate_ads"(platform: "/", business: "mercadopago", type: TrackType.Event) {}
        "/advertising/privacy/modal/keep_ads_active"(platform: "/", business: "mercadopago", type: TrackType.Event) {}
        "/advertising/privacy/modal/dismiss"(platform: "/", business: "mercadopago", type: TrackType.Event) {
            switch_status = "deactivate"
        }
        "/advertising/privacy/switch"(platform: "/", business: "mercadopago", type: TrackType.Event) {}
        "/advertising/privacy/switch/activated"(platform: "/", business: "mercadopago", type: TrackType.Event) {
            switch_status = "activated"
        }
    }
}
