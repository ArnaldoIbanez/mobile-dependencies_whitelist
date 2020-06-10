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
                        index: 0,
                        level: 1,
                        distance: 258,
                        store_id: 30091709,
                        availability: "full",
                        amount_type: "fixed",
                        amount: 15,
                        priority: 9,
                        collector_id: 1234567,
                        has_logo: false,
                        coupon_used: true
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
                    index: 0,
                    level: 1,
                    distance: 258,
                    store_id: 30091709,
                    availability: "full",
                    amount_type: "fixed",
                    amount: 15,
                    priority: 9,
                    collector_id: 1234567,
                    has_logo: false,
                    coupon_used: true
                 ]
            ]
            offset= 0
            filters= [
                "gastronomy",
                "bars"
            ]
            user_loyalty_level= 2
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
            has_logo = false
            coupon_used = true
            sections= [
                    [
                        id: "header",
                        type: "header",
                        position: 0
                    ]
            ]
            tracking_id= "1004194"
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            referer_origin= "12341234"
            category="Restaurant"
            collector_id="1234"
            store_id="1234"
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
            has_logo = false
            coupon_used = true
            sections= [
                    [
                        id: "header",
                        type: "header",
                        position: 0
                    ]
            ]
            tracking_id= "1004194"
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            referer_origin= "12341234"
            category="Restaurant"
            collector_id="1234"
            store_id="1234"
        }
    }

    test("Mercado Pago discount center payers detail terms") {
        "/discount_center/payers/detail/terms" (platform: "/mobile", type: TrackType.Event) {
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
            has_logo = false
            coupon_used = true
            sections= [
                    [
                            id: "header",
                            type: "header",
                            position: 0
                    ]
            ]
            tracking_id= "1004194"
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            referer_origin= "12341234"
            category="Restaurant"
            collector_id="1234"
            store_id="1234"
        }
    }

    test("Mercado Pago discount center payers detail tap") {
        "/discount_center/payers/detail/tap" (platform: "/mobile", type: TrackType.Event) {
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
            has_logo = false
            coupon_used = true
            sections= [
                    [
                            id: "header",
                            type: "header",
                            position: 0
                    ]
            ]
            tracking_id= "1004194"
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            referer_origin= "12341234"
            category="Restaurant"
            collector_id="1234"
            store_id="1234"
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

    // TOUCH POINT

    test("Mercado Pago discount center payers touchpoint px congrats tap") {
        "/discount_center/payers/touchpoint/px_congrats/tap" (platform: "/mobile", type: TrackType.Event) {
            tracking_id= "346859234"
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                store_id: "30974197",
                pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }

    test("Mercado Pago discount center payers touchpoint px congrats show") {
        "/discount_center/payers/touchpoint/px_congrats/show" (platform: "/mobile", type: TrackType.Event) {
            items= [
                [
                    tracking_id: "346859234"
                ]
            ]
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                store_id: "30974197",
                pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }

    test("Mercado Pago discount center payers touchpoint px congrats print") {
        "/discount_center/payers/touchpoint/px_congrats/print" (platform: "/mobile", type: TrackType.Event) {
            items= [
                    [
                            tracking_id: "346859234"
                    ]
            ]
            flow= "/instore"
            checkout_type= "one_tap"
            security_enabled= false
            session_id= "65c7168b-cf25-4033-ad7a-e7874868a164"
            session_time= 58
            flow_detail= [
                    store_id: "30974197",
                    pos_id: "7414488"
            ]
            category="category_test"
            experiments="experiment_test"
        }
    }

    // MARKETPLACE

    test("Mercado Pago discount center payers marketplace") {
        "/discount_center/payers/marketplace" (platform: "/mobile", type: TrackType.View) {
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers marketplace components") {
        "/discount_center/payers/marketplace/components" (platform: "/mobile", type: TrackType.View) {
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers marketplace show") {
        "/discount_center/payers/marketplace/components/show" (platform: "/mobile", type: TrackType.Event) {
            components= [
                main_slider: [
                    [
                        marketplace_type: "main_slider",
                        segment_id: "main_slider",
                        marketplace_index: 0,
                        items: [
                            [
                                tracking_id: "123456",
                                index: 0
                            ]
                        ]
                    ]
                ],
                main_actions: [
                    [
                        marketplace_type: "main_actions",
                        segment_id: "main_actions",
                        marketplace_index: 1,
                        items: [
                            [
                                tracking_id: "123456",
                                index: 0
                            ]
                        ]
                    ]
                ],
                carousel: [
                    [
                        marketplace_type: "carousel",
                        segment_id: "top_brands",
                        marketplace_index: 2,
                        items: [
                            [   tracking_id: "1004194",
                                blocked: false,
                                name: "Mc Donalds",
                                category: "Fast Food",
                                mcc: 5611201,
                                position: 0,
                                index: 0,
                                level: 1,
                                distance: 258,
                                store_id: 30091709,
                                availability: "full",
                                amount_type: "fixed",
                                amount: 15,
                                priority: 9,
                                collector_id: 1234567,
                                has_logo: false,
                                coupon_used: true
                            ]
                        ]
                    ]
                ],
                row: [
                    [
                        marketplace_type: "row",
                        segment_id: "neighborhood",
                        marketplace_index: 4,
                        items: [
                            [   tracking_id: "1004194",
                                blocked: false,
                                name: "Mc Donalds",
                                category: "Fast Food",
                                mcc: 5611201,
                                position: 0,
                                index: 0,
                                level: 1,
                                distance: 258,
                                store_id: 30091709,
                                availability: "full",
                                amount_type: "fixed",
                                amount: 15,
                                priority: 9,
                                collector_id: 1234567,
                                has_logo: false,
                                coupon_used: true
                            ]
                        ]
                    ]
                ],
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            marketplace_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers marketplace print") {
        "/discount_center/payers/marketplace/components/print" (platform: "/mobile", type: TrackType.Event) {
            components= [
                main_slider: [
                    [
                        marketplace_type: "main_slider",
                        segment_id: "main_slider",
                        marketplace_index: 0,
                        items: [
                            [
                                tracking_id: "123456",
                                index: 0
                            ]
                        ]
                    ]
                ],
                main_actions: [
                    [
                        marketplace_type: "main_actions",
                        segment_id: "main_actions",
                        marketplace_index: 1,
                        items: [
                            [
                                tracking_id: "123456",
                                index: 0
                            ]
                        ]
                    ]
                ],
                carousel: [
                    [
                        marketplace_type: "carousel",
                        segment_id: "top_brands",
                        marketplace_index: 2,
                        items: [
                            [   tracking_id: "1004194",
                                blocked: false,
                                name: "Mc Donalds",
                                category: "Fast Food",
                                mcc: 5611201,
                                position: 0,
                                index: 0,
                                level: 1,
                                distance: 258,
                                store_id: 30091709,
                                availability: "full",
                                amount_type: "fixed",
                                amount: 15,
                                priority: 9,
                                collector_id: 1234567,
                                has_logo: false,
                                coupon_used: true
                            ]
                        ]
                    ]
                ],
                row: [
                    [
                        marketplace_type: "row",
                        segment_id: "neighborhood",
                        marketplace_index: 4,
                        items: [
                            [   tracking_id: "1004194",
                                blocked: false,
                                name: "Mc Donalds",
                                category: "Fast Food",
                                mcc: 5611201,
                                position: 0,
                                index: 0,
                                level: 1,
                                distance: 258,
                                store_id: 30091709,
                                availability: "full",
                                amount_type: "fixed",
                                amount: 15,
                                priority: 9,
                                collector_id: 1234567,
                                has_logo: false,
                                coupon_used: true
                            ]
                        ]
                    ]
                ],
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            marketplace_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers marketplace show") {
        "/discount_center/payers/marketplace/components/tap" (platform: "/mobile", type: TrackType.Event) {
            components= [
                row: [
                    [
                        marketplace_type: "row",
                        segment_id: "neighborhood",
                        marketplace_index: 4,
                        items: [
                            [   tracking_id: "1004194",
                                blocked: false,
                                name: "Mc Donalds",
                                category: "Fast Food",
                                mcc: 5611201,
                                position: 0,
                                index: 0,
                                level: 1,
                                distance: 258,
                                store_id: 30091709,
                                availability: "full",
                                amount_type: "fixed",
                                amount: 15,
                                priority: 9,
                                collector_id: 1234567,
                                has_logo: false,
                                coupon_used: true
                            ]
                        ]
                    ]
                ],
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            marketplace_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    //WHATSAPP

    test("Mercado Pago discount center payers detail Whatsapp") {
        "/discount_center/payers/detail/whatsapp" (platform: "/mobile", type: TrackType.View) {
            collector_id="1234"
            store_id="1234"
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            category="Restaurant"
            title = "Angus"
            tracking_id= "1004194"
        }
    }
}
