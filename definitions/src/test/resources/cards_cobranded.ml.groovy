import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("cards tarjeta-credito landing") {

        // View desktop
        "/tarjeta_credito/landing/card_request"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/landing/pending_card"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/landing/approved_card"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/landing/rejected_card"(platform: "/web/desktop", type: TrackType.View){}

        // View mobile
        "/tarjeta_credito/landing/card_request"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/landing/pending_card"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/landing/approved_card"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/landing/rejected_card"(platform: "/web/mobile", type: TrackType.View){}

    }

    test("cards tarjeta-credito acquisition") {

        // View desktop
        "/tarjeta_credito/acquisition/"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/welcome"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/personal_info"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/cards"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/last_digits"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/welcome_address"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/address"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/additional_info"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/welcome_phone"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/phone"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/review"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/congrats/approved"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/congrats/pending"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/congrats/rejected"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error/has_card"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error/corporation"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error/operator"(platform: "/web/desktop", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error/without_credit_card"(platform: "/web/desktop", type: TrackType.View){}

        // View mobile
        "/tarjeta_credito/acquisition/"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/welcome"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/personal_info"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/cards"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/last_digits"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/welcome_address"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/address"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/additional_info"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/welcome_phone"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/phone"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/review"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/congrats"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/congrats/approved"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/congrats/pending"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/congrats/rejected"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error/has_card"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error/corporation"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error/operator"(platform: "/web/mobile", type: TrackType.View){}
        "/tarjeta_credito/acquisition/error/without_credit_card"(platform: "/web/mobile", type: TrackType.View){}
    }

    test("cards tarjeta-credito error") {

        // View desktop
        "/tarjeta_credito/error"(platform: "/web/desktop", type: TrackType.View){}

        // View mobile
        "/tarjeta_credito/error"(platform: "/web/mobile", type: TrackType.View){}
    }
}
