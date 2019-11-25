package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // LIST

    test("Mercado Pago discount center payers list") {
        "/discount_center/payers/list" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercado Pago discount center payers list show") {
        "/discount_center/payers/list/show" (platform: "/mobile", type: TrackType.Event) {
            items= [
                [   tracking_id: "1004194",
                    blocked: false,
                    name: "Mc Donalds",
                    category: "Fast Food",
                    mcc: 5611201,
                    position: 0,
                    level: 1,
                    distance: 258,
                    store_id: 30091709,
                    amount: 15,
                    priority: 9,
                    collector_id: 1234567
                 ]
            ]
        }
    }

    // DETAIL

    test("Mercado Pago discount center payers detail") {
        "/discount_center/payers/detail" (platform: "/mobile", type: TrackType.View) {
            tracking_id= "1004194"
        }
    }

    test("Mercado Pago discount center payers detail share") {
        "/discount_center/payers/detail/share" (platform: "/mobile", type: TrackType.Event) {
            tracking_id= "1004194"
        }
    }

    // REQUEST LOCATION

    test("Mercado Pago discount center payers request location") {
        "/discount_center/payers/request_location" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercado Pago discount center payers request location event") {
        "/discount_center/payers/request_location/result" (platform: "/mobile", type: TrackType.Event) {
            result= "enabled"
        }
    }

    test("Mercado Pago discount center payers request location back") {
        "/discount_center/payers/request_location/back" (platform: "/mobile", type: TrackType.Event) {}
    }
}
