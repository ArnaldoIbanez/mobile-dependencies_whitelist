package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    ["mercadolibre", "mercadopago"].each { business ->
        defaultBusiness = business

        def consent_types = [
            disclaimer: "disclaimer",
            bottom: "bottom",
            modal: "modal",
        ]

        test("navigation cookies-consent show track") {
            "/navigation/cookies_consent/show"(platform: "/web/mobile", type: TrackType.Event) {
                consent_type = consent_types.disclaimer
            }
            "/navigation/cookies_consent/show"(platform: "/web/desktop", type: TrackType.Event) {
                consent_type = consent_types.disclaimer
            }

            "/navigation/cookies_consent/show"(platform: "/web/mobile", type: TrackType.Event) {
                consent_type = consent_types.bottom
            }
            "/navigation/cookies_consent/show"(platform: "/web/desktop", type: TrackType.Event) {
                consent_type = consent_types.bottom
            }

            "/navigation/cookies_consent/show"(platform: "/web/mobile", type: TrackType.Event) {
                consent_type = consent_types.modal
            }
            "/navigation/cookies_consent/show"(platform: "/web/desktop", type: TrackType.Event) {
                consent_type = consent_types.modal
            }
        }

        test("navigation cookies-consent acknowledge event") {
            "/navigation/cookies_consent/ack"(platform: "/web/mobile", type: TrackType.Event) {}
            "/navigation/cookies_consent/ack"(platform: "/web/desktop", type: TrackType.Event) {}
        }

        test("navigation cookies-consent accept-all event") {
            "/navigation/cookies_consent/accept_all"(platform: "/web/mobile", type: TrackType.Event) {
                consent_type = consent_types.bottom
            }
            "/navigation/cookies_consent/accept_all"(platform: "/web/mobile", type: TrackType.Event) {
                consent_type = consent_types.modal
            }
            "/navigation/cookies_consent/accept_all"(platform: "/web/desktop", type: TrackType.Event) {
                consent_type = consent_types.bottom
            }
            "/navigation/cookies_consent/accept_all"(platform: "/web/desktop", type: TrackType.Event) {
                consent_type = consent_types.modal
            }
        }

        test("navigation cookies-consent personalize event") {
            "/navigation/cookies_consent/personalize"(platform: "/web/mobile", type: TrackType.Event) {
                consent_type = consent_types.bottom
            }
            "/navigation/cookies_consent/personalize"(platform: "/web/mobile", type: TrackType.Event) {
                consent_type = consent_types.modal
            }
            "/navigation/cookies_consent/personalize"(platform: "/web/desktop", type: TrackType.Event) {
                consent_type = consent_types.bottom
            }
            "/navigation/cookies_consent/personalize"(platform: "/web/desktop", type: TrackType.Event) {
                consent_type = consent_types.modal
            }
        }

        test("navigation cookies-consent close event") {
            "/navigation/cookies_consent/close"(platform: "/web/mobile", type: TrackType.Event) {
                consent_type = consent_types.modal
            }
            "/navigation/cookies_consent/close"(platform: "/web/desktop", type: TrackType.Event) {
                consent_type = consent_types.modal
            }
        }
    }
}
