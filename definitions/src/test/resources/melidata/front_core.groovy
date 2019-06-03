package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


/**************************
* WALLET HOME TEST TRACKS *
**************************/


trackTests {

    defaultBusiness = "mercadopago"

    test("Mercadopago Home") {
        "/wallet/home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Tap") {
        "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
        }
    }

    test("Mercadopago Home Show") {
        "/wallet/home/show" (platform: "/mobile", type: TrackType.Event) {
            header = "name"
            items = [
                [
                    id: "banking",
                    ordinal: 1,
                    type: "BANKING"
                ]
            ]
        }
    }
    
    test("Mercadopago Home Banking Section Show") {
        "/wallet/home/show/banking" (platform: "/mobile", type: TrackType.Event) {
            collapsed = true
        }
    }

    test("Mercadopago Home Banking Initial State") {
        "/wallet/home/banking/initial_state" (platform: "/mobile", type: TrackType.Event) {
            collapsed = true
        }
    }

    test("Mercadopago Home Banking Collapse") {
        "/wallet/home/banking/collapse" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Banking Expand") {
        "/wallet/home/banking/expand" (platform: "/mobile", type: TrackType.Event) {}
    }

}