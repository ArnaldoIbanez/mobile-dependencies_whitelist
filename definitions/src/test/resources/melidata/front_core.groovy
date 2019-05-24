package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


/*************************
*       FRONT CORE       *
*************************/

trackTests {

    defaultBusiness = "mercadopago"

    test("Mercadopago Home") {
        "/front_core/home"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/front_core/home/pull"(platform: "/mobile", type: TrackType.Event) {
            backend_tracking_data = [ title: "name" ]
        }
    }

    test("Mercadopago Home Show") {
        "/front_core/home/show"(platform: "/mobile", type: TrackType.Event) {
            header = [ title : "name" ]
            items = [
                banking: [
                    ordinal: 1,
                    type: "BANKING"
                ]
            ]
            backend_tracking_data = [ title: "name" ]
        }
    }
    
    test("Mercadopago Home Show by Id") {
        "/front_core/home/banking"(platform: "/mobile", type: TrackType.Event) {
            type = "BANKING"
            ordinal = 1
        }

        "/front_core/home/main_actions"(platform: "/mobile", type: TrackType.Event) {
            type = "VERTICAL_LIST"
            ordinal = 2
        }

        "/front_core/home/secondary_actions"(platform: "/mobile", type: TrackType.Event) {
            type = "VERTICAL_LIST"
            ordinal = 3
        }

        "/front_core/home/benefits"(platform: "/mobile", type: TrackType.Event) {
            type = "VERTICAL_LIST"
            ordinal = 4
        }

        "/front_core/home/cross_selling"(platform: "/mobile", type: TrackType.Event) {
            type = "VERTICAL_LIST"
            ordinal = 5
        }

        "/front_core/home/activities"(platform: "/mobile", type: TrackType.Event) {
            type = "VERTICAL_LIST"
            ordinal = 6
        }

        "/front_core/home/qr_map"(platform: "/mobile", type: TrackType.Event) {
            type = "VERTICAL_LIST"
            ordinal = 7
        }
    }
}