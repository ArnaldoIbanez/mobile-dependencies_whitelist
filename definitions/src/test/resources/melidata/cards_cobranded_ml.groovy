package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("cards cobranded ML landing") {

        // View desktop
        "/cobranded/landing/card_request"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/landing/pending_card"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/landing/approved_card"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/landing/rejected_card"(platform: "/web/desktop", type: TrackType.View){}

        // View mobile
        "/cobranded/landing/card_request"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/landing/pending_card"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/landing/approved_card"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/landing/rejected_card"(platform: "/web/mobile", type: TrackType.View){}

    }

    test("cards cobranded ML acquisition") {

        // View desktop
        "/cobranded/acquisition"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/welcome"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/personal_info"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/cards"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/last_digits"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/welcome_address"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/address"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/additional_info"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/welcome_phone"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/phone"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/review"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/congrats"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/congrats/approved"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/congrats/pending"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/congrats/rejected"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/error"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/error/has_card"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/error/corporation"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/error/operator"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/error/without_credit_card"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/landing/delivered_card"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/landing/active_card"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/summary_date"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/error/cnpj"(platform: "/web/desktop", type: TrackType.View){} 
        "/cobranded/acquisition/welcome_signature"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/signature"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/welcome_work_address"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/work_address"(platform: "/web/desktop", type: TrackType.View){}

        // View mobile
        "/cobranded/acquisition"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/welcome"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/personal_info"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/cards"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/last_digits"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/welcome_address"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/address"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/additional_info"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/welcome_phone"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/phone"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/review"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/congrats"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/congrats/approved"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/congrats/pending"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/congrats/rejected"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/error"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/error/has_card"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/error/corporation"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/error/operator"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/error/without_credit_card"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/landing/delivered_card"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/landing/active_card"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/summary_date"(platform: "/web/mobile", type: TrackType.View){}
        "/cobranded/acquisition/error/cnpj"(platform: "/web/mobile", type: TrackType.View){}

        
    }

    test("cards cobranded ML error") {

        // View desktop
        "/cobranded/error"(platform: "/web/desktop", type: TrackType.View){}

        // View mobile
        "/cobranded/error"(platform: "/web/mobile", type: TrackType.View){}
    }
}
