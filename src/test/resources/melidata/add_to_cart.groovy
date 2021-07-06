package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Add to cart tracks") {
        "/add_to_cart"(platform: "/web/desktop", type: TrackType.Event) {
            items = [
                    [
                            unit_price : 100,
                            quantity   : 1,
                            item       : [
                                    category_id: "MLB63385",
                                    id         : "MLB754486062"
                            ],
                            currency_id: "BRL"
                    ],
                    [
                            unit_price : 50,
                            quantity   : 3,
                            item       : [
                                    category_id: "MLB512315",
                                    id         : "MLB512313"
                            ],
                            currency_id: "BRL"
                    ]
            ]
            context = 'recommendations'
        }

        "/add_to_cart"(platform: "/mobile/ios", type: TrackType.Event) {
            items = [
                    [
                            unit_price : 100,
                            quantity   : 1,
                            item       : [
                                    category_id: "MLB63385",
                                    id         : "MLB754486062"
                            ],
                            currency_id: "BRL"
                    ]
            ]
            context = 'vip'
        }

        "/add_to_cart"(platform: "/mobile/android", type: TrackType.Event) {
            items = [
                    [
                            unit_price : 100,
                            quantity   : 1,
                            item       : [
                                    category_id: "MLB63385",
                                    id         : "MLB754486062"
                            ],
                            currency_id: "BRL"
                    ]
            ]

            context = 'search'
        }

        "/add_to_cart"(platform: "/web/mobile", type: TrackType.Event) {
            items = [
                    [
                            unit_price : 100,
                            quantity   : 1,
                            item       : [
                                    category_id: "MLB63385",
                                    id         : "MLB754486062"
                            ],
                            currency_id: "BRL"
                    ]
            ]

            context = 'recommendations'
        }

        "/add_to_cart"(platform: "/mobile/android", type: TrackType.Event) {
            items = [
                    [
                            quantity   : 1,
                            item       : [
                                    category_id: "MLB63385",
                                    id         : "MLB754486062"
                            ],
                    ]
            ]
            carousel_type = "normal"
            carousel_label = "Limpieza"
            component = 3
            context = "supermarket_home"
        }

        "/add_to_cart"(platform: "/web/desktop", type: TrackType.Event) {
            items = [
                    [
                            quantity   : 1,
                            item       : [
                                    category_id: "MLB63385",
                                    id         : "MLB754486062"
                            ],
                    ]
            ]
            carousel_type = 'home'
            carousel_label = 'Bebés'
            component = 3
            context = 'supermarket_home'
        }
    }

     test("Add to cart intention tracks") {
        "/add_cart_intention"(platform: "/web/desktop", type: TrackType.Event) {
            add_to_cart_availability = "no_high_ratio"
            main_action = "buy"
            context = "vip"
            items = []
        }

        "/add_cart_intention"(platform: "/mobile/ios", type: TrackType.Event) {
            add_to_cart_availability = "no_high_ratio"
            main_action = "buy"
            context = "vip"
            items = [
                [
                        unit_price : 100,
                        quantity   : 1,
                        item       : [
                                category_id: "MLB63385",
                                id         : "MLB754486062"
                        ],
                        currency_id: "BRL"
                ],
                [
                        unit_price : 50,
                        quantity   : 3,
                        item       : [
                                category_id: "MLB512315",
                                id         : "MLB512313"
                        ],
                        currency_id: "BRL"
                ]
            ]
        }

        "/add_cart_intention"(platform: "/mobile/android", type: TrackType.Event) {
            add_to_cart_availability = "no_high_ratio"
            main_action = "buy"
            context = "vip"
            items = [
                [
                        unit_price : 100,
                        quantity   : 1,
                        item       : [
                                category_id: "MLB63385",
                                id         : "MLB754486062"
                        ],
                        currency_id: "BRL"
                ],
                [
                        unit_price : 50,
                        quantity   : 3,
                        item       : [
                                category_id: "MLB512315",
                                id         : "MLB512313"
                        ],
                        currency_id: "BRL"
                ]
            ]
        }

        "/add_cart_intention"(platform: "/web/mobile", type: TrackType.Event) {
            add_to_cart_availability = "no_high_ratio"
            main_action = "buy"
            context = "vip"
            items = [
                [
                        unit_price : 100,
                        quantity   : 1,
                        item       : [
                                category_id: "MLB63385",
                                id         : "MLB754486062"
                        ],
                        currency_id: "BRL"
                ],
                [
                        unit_price : 50,
                        quantity   : 3,
                        item       : [
                                category_id: "MLB512315",
                                id         : "MLB512313"
                        ],
                        currency_id: "BRL"
                ]
            ]
        }
    }

    test("Remove From Cart"){
        "/remove_from_cart"(platform: "/"){
            context = "search"
            items = [
                [
                    currency_id: "MXN",
                    item: [
                        id: "MLA1234",
                        category_id: "MLM123456"
                    ],
                    quantity: 2,
                    unit_price: 100
                ]
            ]
        }
    }
}


