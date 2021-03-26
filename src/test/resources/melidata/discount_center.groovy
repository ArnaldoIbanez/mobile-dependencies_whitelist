package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // VIP

    test("Mercado Pago discount center payers vip") {
        "/discount_center/payers/vip" (platform: "/mobile", type: TrackType.View) {
            collector_id = 20565408
            category_id = "MLA410861"
            item_id = "MLA886428635"
            item_name = "Duplao Burger"
            context_info = [
                    has_cart: true
            ]
            amount = [
                    final_price: 40.2,
                    currency: "ARS\$",
                    discount: 31,
                    original_price: 58
            ]
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    // MORE INFO

    test("Mercado Pago discount center payers More info") {
        "/discount_center/payers/more_info" (platform: "/mobile", type: TrackType.View) {
            store_id = 30286315
            collector_id = 20565408
            brand_id = 20565408
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }


    // VSP

    test("Mercado Pago discount center payers vsp") {
        "/discount_center/payers/vsp" (platform: "/mobile", type: TrackType.View) {
            store_id = 30286315
            collector_id = 20565408
            name = "Maqyherr De Jose Luis Mangini"
            distance = 1813
            category = "Ferretería"
            mcc = "523630"
            discounts = [
                [
                    campaign_id: 1070400,
                    index: 0,
                    blocked: false,
                    availability: "full",
                    level: 1,
                    amount_type: "percent",
                    amount: 5.0,
                    priority: 6
                ]
            ]
            delivery = [
                radius: 1000,
                delivery: true,
                pickup: false
            ]
            context_info = [
                    has_cart: true,
                    has_catalog: true,
                    version_code: 2,
                    version_name: "New VSP"
            ]
            session_id = "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers vsp tap") {
        "/discount_center/payers/vsp/components/tap" (platform: "/mobile", type: TrackType.Event) {
            components = [
                actionable_info: [
                        marketplace_type: "actionable_info",
                        segment_id: "delivery_whatsapp",
                        marketplace_index: 0,
                        items: [
                            [
                                index: 0,
                                tracking_id: "delivery_whatsapp",
                                store_id: 1235123,
                                collector_id: 1231415,
                            ]
                        ]
                ]
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers vsp print") {
        "/discount_center/payers/vsp/components/print" (platform: "/mobile", type: TrackType.Event) {
            components = [
                actionable_info: [
                        marketplace_type: "actionable_info",
                        segment_id: "delivery_whatsapp",
                        marketplace_index: 0,
                        items: [
                            [
                                index: 0,
                                tracking_id: "delivery_whatsapp",
                                store_id: 1235123,
                                collector_id: 1231415,
                            ]
                        ]
                ]
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers vsp show") {
        "/discount_center/payers/vsp/components/show" (platform: "/mobile", type: TrackType.Event) {
            components = [
                actionable_info: [
                        marketplace_type: "actionable_info",
                        segment_id: "delivery_whatsapp",
                        marketplace_index: 0,
                        items: [
                            [
                                index: 0,
                                tracking_id: "delivery_whatsapp",
                                store_id: 1235123,
                                collector_id: 1231415,
                            ]
                        ]
                ]
            ]
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

    // MARKETPLACE

    test("Mercado Pago discount center payers marketplace") {
        "/discount_center/payers/marketplace" (platform: "/mobile", type: TrackType.View) {
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
                            [
                                type: "store",
                                index: 0,
                                store: [
                                    store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                ]
                            ],
                            [
                                type: "see_more",
                                index: 1
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
                            [   store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                            ]
                        ]
                    ]
                ],
                image_banner: [
                        [
                                marketplace_type: "image_banner",
                                segment_id: "sellers_banner",
                                marketplace_index: 4,
                                items: [
                                        [
                                            tracking_id: "image_banner_1234",
                                            index: 0
                                        ]
                                ]
                        ]
                ],
                last_viewed: [
                        [
                                marketplace_type: "last_viewed",
                                segment_id: "neighborhood",
                                marketplace_index: 5,
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
                hybrid_last_viewed: [
                        [
                                marketplace_type: "hybrid_last_viewed",
                                segment_id: "neighborhood",
                                marketplace_index: 5,
                                items: [
                                        [   store_id: 30286315,
                                            collector_id: 20565408,
                                            name: "Maqyherr De Jose Luis Mangini",
                                            distance: 1813,
                                            category: "Ferretería",
                                            mcc: "523630",
                                            discounts: [
                                                    [
                                                            campaign_id: 1070400,
                                                            index: 0,
                                                            blocked: false,
                                                            availability: "full",
                                                            level: 1,
                                                            amount_type: "percent",
                                                            amount: 5.0,
                                                            priority: 6
                                                    ]
                                            ],
                                            delivery: [
                                                    radius: 1000,
                                                    delivery: true,
                                                    pickup: false
                                            ],
                                            session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                        ]
                                ]
                        ]
                ],
                hybrid_row: [
                    [
                        marketplace_type: "row",
                        segment_id: "neighborhood",
                        marketplace_index: 4,
                        items: [
                            [   store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                            ]
                        ]
                    ]
                ],
                hybrid_carousel: [
                        [
                                marketplace_type: "carousel",
                                segment_id: "top_brands",
                                marketplace_index: 2,
                                items: [
                                        [
                                                type: "store",
                                                index: 0,
                                                store: [
                                                        store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                                ]
                                        ],
                                        [
                                                type: "see_more",
                                                index: 1
                                        ]
                                ]
                        ]
                ],
                filters: [
                        [
                                index: 0,
                                selected: "selected",
                                tracking_id: "filter_tracking_id",
                        ],
                        [
                                index: 1,
                                selected: "none",
                                tracking_id: "filter1_tracking_id",
                        ],
                ],
                filters_l2: [
                        [
                                index: 0,
                                selected: "unselected",
                                tracking_id: "filter_tracking_id",
                        ],
                        [
                                index: 1,
                                selected: "selected",
                                tracking_id: "filter1_l2_tracking_id",
                        ],
                ],
                cover_carousel: [
                        [
                                marketplace_type: "cover_carousel",
                                segment_id: "top_brands",
                                marketplace_index: 2,
                                items: [
                                        [
                                                type: "store",
                                                index: 0,
                                                store: [
                                                        store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                                ]
                                        ],
                                        [
                                                type: "see_more",
                                                index: 1
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
                                        [
                                                type: "store",
                                                index: 0,
                                                store: [
                                                        store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                                ]
                                        ],
                                        [
                                                type: "see_more",
                                                index: 1
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
                                        [   store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                        ]
                                ]
                        ]
                ],
                image_banner: [
                        [
                                marketplace_type: "image_banner",
                                segment_id: "sellers_banner",
                                marketplace_index: 4,
                                items: [
                                        [
                                            tracking_id: "image_banner_1234",
                                            index: 0
                                        ]
                                ]
                        ]
                ],
                last_viewed: [
                        [
                                marketplace_type: "last_viewed",
                                segment_id: "neighborhood",
                                marketplace_index: 5,
                                items: [
                                        [   store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                        ]
                                ]
                        ]
                ],
                filters: [
                        [
                                index: 0,
                                selected: "unselected",
                                tracking_id: "filter_tracking_id",
                        ],
                        [
                                index: 1,
                                selected: "none",
                                tracking_id: "filter1_tracking_id",
                        ],
                        [
                                index: 2,
                                selected: "selected",
                                tracking_id: "filter2_tracking_id",
                        ],
                ],
                filters_l2: [
                        [
                                index: 0,
                                selected: "selected",
                                tracking_id: "filter_tracking_id",
                        ],
                        [
                                index: 1,
                                selected: "unselected",
                                tracking_id: "filter1_l2_tracking_id",
                        ],
                ],
                hybrid_last_viewed: [
                        [
                                marketplace_type: "hybrid_last_viewed",
                                segment_id: "neighborhood",
                                marketplace_index: 5,
                                items: [
                                        [   store_id: 30286315,
                                            collector_id: 20565408,
                                            name: "Maqyherr De Jose Luis Mangini",
                                            distance: 1813,
                                            category: "Ferretería",
                                            mcc: "523630",
                                            discounts: [
                                                    [
                                                            campaign_id: 1070400,
                                                            index: 0,
                                                            blocked: false,
                                                            availability: "full",
                                                            level: 1,
                                                            amount_type: "percent",
                                                            amount: 5.0,
                                                            priority: 6
                                                    ]
                                            ],
                                            delivery: [
                                                    radius: 1000,
                                                    delivery: true,
                                                    pickup: false
                                            ],
                                            session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                        ]
                                ]
                        ]
                ],
                cover_carousel: [
                        [
                                marketplace_type: "cover_carousel",
                                segment_id: "neighborhood",
                                marketplace_index: 5,
                                items: [
                                        [   store_id: 30286315,
                                            collector_id: 20565408,
                                            name: "Maqyherr De Jose Luis Mangini",
                                            distance: 1813,
                                            category: "Ferretería",
                                            mcc: "523630",
                                            discounts: [
                                                    [
                                                            campaign_id: 1070400,
                                                            index: 0,
                                                            blocked: false,
                                                            availability: "full",
                                                            level: 1,
                                                            amount_type: "percent",
                                                            amount: 5.0,
                                                            priority: 6
                                                    ]
                                            ],
                                            delivery: [
                                                    radius: 1000,
                                                    delivery: true,
                                                    pickup: false
                                            ],
                                            session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                        ]
                                ]
                        ]
                ]
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            marketplace_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }

    test("Mercado Pago discount center payers marketplace tap") {
        "/discount_center/payers/marketplace/components/tap" (platform: "/mobile", type: TrackType.Event) {
            components = [
                    row: [
                            [
                                    marketplace_type: "row",
                                    segment_id: "neighborhood",
                                    marketplace_index: 4,
                                    items: [
                                            [   store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                            ]
                                    ]
                            ]
                    ]
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            marketplace_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/discount_center/payers/marketplace/components/tap" (platform: "/mobile", type: TrackType.Event) {
            components = [
                    cover_carousel: [
                            [
                                    marketplace_type: "cover_carousel",
                                    segment_id: "neighborhood",
                                    marketplace_index: 4,
                                    items: [
                                            [   store_id: 30286315,
                                                collector_id: 20565408,
                                                name: "Maqyherr De Jose Luis Mangini",
                                                distance: 1813,
                                                category: "Ferretería",
                                                mcc: "523630",
                                                discounts: [
                                                        [
                                                                campaign_id: 1070400,
                                                                index: 0,
                                                                blocked: false,
                                                                availability: "full",
                                                                level: 1,
                                                                amount_type: "percent",
                                                                amount: 5.0,
                                                                priority: 6
                                                        ]
                                                ],
                                                delivery: [
                                                        radius: 1000,
                                                        delivery: true,
                                                        pickup: false
                                                ],
                                                session_id: "27131d31-6910-4855-85fe-70ad2d97f7ed"
                                            ]
                                    ]
                            ]
                    ]
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            marketplace_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }

        "/discount_center/payers/marketplace/components/tap" (platform: "/mobile", type: TrackType.Event) {
            components = [
                    filters_l2: [
                        [
                                index: 0,
                                selected: "selected",
                                tracking_id: "filter_tracking_id",
                        ]
                ],
            ]
            session_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
            marketplace_id= "27131d31-6910-4855-85fe-70ad2d97f7ed"
        }
    }
}
