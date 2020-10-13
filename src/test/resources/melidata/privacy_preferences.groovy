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
}
