package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // Reservation

    test("Black friday reservation view") {
        "/blackfriday/reservation" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Black friday reservation back event") {
        "/blackfriday/reservation/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Black friday reservation tap event") {
        "/blackfriday/reservation/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "reservation"
        }
    }

    // KYC

    test("Black friday kyc view") {
        "/blackfriday/kyc" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Black friday back event") {
        "/blackfriday/kyc/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Black friday kyc tap event") {
        "/blackfriday/kyc/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "start"
        }
    }

    // Congrats

    test("Black friday congrats view") {
        "/blackfriday/congrats" (platform: "/mobile", type: TrackType.View) {
            result = "success"
        }
    }

    test("Black friday congrats close event") {
        "/blackfriday/congrats/close" (platform: "/mobile", type: TrackType.Event) {
            result = "success"
        }
    }

    test("Black friday congrats tap event") {
        "/blackfriday/congrats/cta" (platform: "/mobile", type: TrackType.Event) {
            result = "success"
            type = "exit"
        }
    }

    // Reserved

    test("Black friday reserved view") {
        "/blackfriday/reserved" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Black friday reserved close event") {
        "/blackfriday/reserved/close" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Black friday reserved tap event") {
        "/blackfriday/reserved/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "exit"
        }
    }

    // Sold out

    test("Black friday sold out view") {
        "/blackfriday/soldout" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Black friday sold out close event") {
        "/blackfriday/soldout/close" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Black friday sold out tap event") {
        "/blackfriday/soldout/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "exit"
        }
    }

    // Discounts

    test("Black friday discounts view") {
        "/blackfriday/discounts" (platform: "/mobile", type: TrackType.View) {
            discount_mcdonalds_enabled = true
            discount_ragazzo_enabled = true
            discount_habibs_enabled = false
        }
    }

    test("Black friday discounts back event") {
        "/blackfriday/discounts/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Black friday discounts tap event") {
        "/blackfriday/discounts/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "tyc"
        }
    }

    // How to

    test("Black friday how to view") {
        "/blackfriday/howto" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Black friday how to back event") {
        "/blackfriday/howto/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Black friday how to tap event") {
        "/blackfriday/howto/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "exit"
        }
    } 

    // Used

    test("Black friday used ftu view") {
        "/blackfriday/ftu-used" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Black friday used ftu back event") {
        "/blackfriday/ftu-used/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Black friday used ftu tap event") {
        "/blackfriday/ftu-used/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "exit"
        }
    } 


}
