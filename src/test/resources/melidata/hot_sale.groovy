package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Hot sale view") {
        "/instore_hot_sale" (platform: "/mobile", type: TrackType.View) {}
    }

    // Reservation

    test("Hot sale reservation view") {
        "/instore_hot_sale/reservation" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Hot sale reservation back event") {
        "/instore_hot_sale/reservation/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Hot sale reservation tap event") {
        "/instore_hot_sale/reservation/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "reservation"
        }
    }

    // KYC

    test("Hot sale kyc view") {
        "/instore_hot_sale/kyc" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Hot sale back event") {
        "/instore_hot_sale/kyc/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Hot sale kyc tap event") {
        "/instore_hot_sale/kyc/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "start"
        }
    }

    // Error

    test("Hot sale error view") {
        "/instore_hot_sale/error" (platform: "/mobile", type: TrackType.View) {}
    }

    // Congrats

    test("Hot sale congrats view") {
        "/instore_hot_sale/congrats" (platform: "/mobile", type: TrackType.View) {
            result = "success"
        }
    }

    test("Hot sale congrats close event") {
        "/instore_hot_sale/congrats/close" (platform: "/mobile", type: TrackType.Event) {
            result = "success"
        }
    }

    test("Hot sale congrats tap event") {
        "/instore_hot_sale/congrats/cta" (platform: "/mobile", type: TrackType.Event) {
            result = "success"
            type = "exit"
        }
    }

    // Reserved

    test("Hot sale reserved view") {
        "/instore_hot_sale/reserved" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Hot sale reserved close event") {
        "/instore_hot_sale/reserved/close" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Hot sale reserved tap event") {
        "/instore_hot_sale/reserved/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "exit"
        }
    }

    // Sold out

    test("Hot sale sold out view") {
        "/instore_hot_sale/soldout" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Hot sale sold out close event") {
        "/instore_hot_sale/soldout/close" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Hot sale sold out tap event") {
        "/instore_hot_sale/soldout/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "exit"
        }
    }

    // Discounts

    test("Hot sale discounts view") {
        "/instore_hot_sale/discounts" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Hot sale discounts cupon_status event") {
        "/instore_hot_sale/discounts/cupon_status" (platform: "/mobile", type: TrackType.Event) {
            used_campaigns_status = [
                [brand_name = "Starbucks", cupon_status = false],
                [brand_name = "Burger King", cupon_status = false],
                [brand_name = "Domino’s", cupon_status = true],
                [brand_name = "Benavides", cupon_status = true],
            ]
        }
    }
    test("Hot sale discounts back event") {
        "/instore_hot_sale/discounts/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Hot sale discounts tap event") {
        "/instore_hot_sale/discounts/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "tyc"
        }
    }

    // How to

    test("Hot sale how to view") {
        "/instore_hot_sale/howto" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Hot sale how to back event") {
        "/instore_hot_sale/howto/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Hot sale how to tap event") {
        "/instore_hot_sale/howto/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "exit"
        }
    } 

    // Used

    test("Hot sale used ftu view") {
        "/instore_hot_sale/ftu-used" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Hot sale used ftu back event") {
        "/instore_hot_sale/ftu-used/back" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Hot sale used ftu tap event") {
        "/instore_hot_sale/ftu-used/cta" (platform: "/mobile", type: TrackType.Event) {
            type = "exit"
        }
    } 


}
