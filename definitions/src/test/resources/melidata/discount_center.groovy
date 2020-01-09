package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // LIST

    test("Mercado Pago discount center payers list") {
        "/discount_center/payers/list" (platform: "/mobile", type: TrackType.View) {
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers list print") {
        "/discount_center/payers/list/print" (platform: "/mobile", type: TrackType.Event) {
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
                        availability: "full",
                        amount: 15,
                        priority: 9,
                        collector_id: 1234567
                    ]
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
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
                    availability: "full",
                    amount: 15,
                    priority: 9,
                    collector_id: 1234567
                 ]
            ]
            offset= 0
            filters= [
                "gastronomy",
                "bars"
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers list tap filter") {
        "/discount_center/payers/list/tap_filter" (platform: "/mobile", type: TrackType.Event) {
            filter_id="Bar"
            index=0
            action="enabled"
        }
    }

    // DETAIL

    test("Mercado Pago discount center payers detail") {
        "/discount_center/payers/detail" (platform: "/mobile", type: TrackType.View) {
            title = "Angus"
            enabled = true
            availability = "full"
            level = 1
            blocked = false
            amount = 20.0
            amount_type = "percent"
            status = "active"
            stores_id = [
                    30091700
            ]
            sections= [
                    [
                        id: "header",
                        type: "header",
                        position: 0
                    ]
            ]
            tracking_id= "1004194"
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers detail share") {
        "/discount_center/payers/detail/share" (platform: "/mobile", type: TrackType.Event) {
            title = "Angus"
            enabled = true
            availability = "full"
            level = 1
            blocked = false
            amount = 20.0
            amount_type = "percent"
            status = "active"
            stores_id = [
                    30091700
            ]
            sections= [
                    [
                        id: "header",
                        type: "header",
                        position: 0
                    ]
            ]
            tracking_id= "1004194"
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    // REQUEST LOCATION

    test("Mercado Pago discount center payers request location") {
        "/discount_center/payers/request_location" (platform: "/mobile", type: TrackType.View) {
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers request location event") {
        "/discount_center/payers/request_location/result" (platform: "/mobile", type: TrackType.Event) {
            result= "enabled"
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers request location back") {
        "/discount_center/payers/request_location/back" (platform: "/mobile", type: TrackType.Event) {
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers session end") {
        "/discount_center/payers/session/end" (platform: "/mobile", type: TrackType.Event) {
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }
}
