package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


/*************************
*       FRONT CORE       *
*************************/


trackTests {

    defaultBusiness = "mercadopago"

    /*************************
    *    HOME TEST TRACKS    *
    *************************/

    test("Mercadopago Home") {
        "/wallet/home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {
            backend_tracking_data = [ title: "name" ]
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
    
    test("Mercadopago Home Show by Id") {
        "/wallet/home/show/banking" (platform: "/mobile", type: TrackType.Event) {
            type = "BANKING"
            ordinal = 1
        }

        "/wallet/home/show/main_actions" (platform: "/mobile", type: TrackType.Event) {
            type = "MAIN_ACTIONS"
            ordinal = 2
        }

        "/wallet/home/show/secondary_actions" (platform: "/mobile", type: TrackType.Event) {
            type = "SECONDARY_ACTIONS"
            ordinal = 3
        }

        "/wallet/home/show/benefits" (platform: "/mobile", type: TrackType.Event) {
            type = "VERTICAL_LIST"
            ordinal = 4
        }

        "/wallet/home/show/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            type = "CAROUSEL"
            ordinal = 5
        }

        "/wallet/home/show/activities" (platform: "/mobile", type: TrackType.Event) {
            type = "ACTIVITIES"
            ordinal = 6
        }

        "/wallet/home/show/qr_map" (platform: "/mobile", type: TrackType.Event) {
            type = "PROMOTION"
            ordinal = 7
        }
    }
}