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
        "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {
            backend_tracking_data = [ title: "name" ]
        }
    }

    test("Mercadopago Home TAP") {
        "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
        }
    }

    test("Mercadopago Home Show") {
        "/wallet/home/draw" (platform: "/mobile", type: TrackType.Event) {
            header = "name"
            items = [
                [
                    id: "banking",
                    ordinal: 1,
                    type: "BANKING"
                ],
                [
                    id: "cross_selling",
                    ordinal: 2,
                    type: "CARROUSEL"
                ]
            ]
            backend_tracking_data = [ partial: false ]
        }
    }
    

}