package src.test.resources

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
            context = '/myml'
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
            context = '/vip'
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

            context = '/search'
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

            context = '/recommendations'
        }
    }


}


