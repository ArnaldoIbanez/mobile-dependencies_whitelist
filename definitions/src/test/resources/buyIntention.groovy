package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"


    test("Buy intention event tests"){

        def buyIntentionDataSet = {
            buy_equal_pay = true
            total_amount=2000

            seller = [
                    [id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                    [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]
            ]

            items = [
                    [
                            currency_id: "ARS",
                            unit_price: 100,
                            quantity: 1,
                            item: [
                                    category_id: "MLA63385",
                                    buying_mode: "buy_it_now",
                                    id: "MLA754486062",
                                    official_store: "Adidas",
                                    condition: "new",
                                    listing_type: "gold_special",
                                    title: "Conector 12 Vias",
                                    shipping_mode: "me2"
                            ]
                    ],
                    [
                            currency_id: "ARS",
                            unit_price: 1000,
                            quantity: 3,
                            item: [
                                    category_id: "MLA63385",
                                    buying_mode: "buy_it_now",
                                    id: "MLA754486062",
                                    official_store: "SportCenter",
                                    condition: "new",
                                    listing_type: "gold_pro",
                                    title: "Conector 12 Vias",
                                    shipping_mode: "me2"
                            ]
                    ]
            ]
        }

        "/buy_intention"(platform:"/mobile/android") {
            buyIntentionDataSet()
            from = "vip"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/ios") {
            buyIntentionDataSet()
            from = "cart"
            checkout_flow="subscription"
        }

        "/buy_intention"(platform:"/web/mobile") {
            buyIntentionDataSet()
            from = "cart_item"
            checkout_flow="reservation"
        }

        "/buy_intention"(platform:"/web/desktop") {
            buyIntentionDataSet()
            from = "saved_for_later"
            checkout_flow="contract"

        }

    }

}
