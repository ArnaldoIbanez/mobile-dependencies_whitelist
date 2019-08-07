package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"


    test("Buy intention event tests"){

        def buyIntentionDataSet = {
            session_id=1234
            vertical="core"
            loyalty_level=3
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
            item_with_garex = true
            total_amount_including_garex = 1869.89
            stored_cards_quantity = 3
        }
        "/buy_intention"(platform:"/mobile/android") {
            buyIntentionDataSet()
            context = "checkout_recovery_combo"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/android") {
            buyIntentionDataSet()
            context = "cart_combo_reco"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/android") {
            buyIntentionDataSet()
            context = "vip"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/ios") {
            buyIntentionDataSet()
            context = "cart"
            checkout_flow="subscription"
        }

        "/buy_intention"(platform:"/web/mobile") {
            buyIntentionDataSet()
            context = "cart_item"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/web/desktop") {
            buyIntentionDataSet()
            context = "saved_for_later"
            checkout_flow="cart"

        }

        "/buy_intention"(platform:"/mobile/android") {
            buyIntentionDataSet()
            context = "home_cart-overview"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/ios") {
            buyIntentionDataSet()
            context = "home_cart-overview"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/android") {
            buyIntentionDataSet()
            context = "home_dropout"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/ios") {
            buyIntentionDataSet()
            context = "home_dropout"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/android") {
            buyIntentionDataSet()
            context = "home_last-buy"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/mobile/ios") {
            buyIntentionDataSet()
            context = "home_last-buy"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/web/mobile") {
            buyIntentionDataSet()
            context = "garex"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/web/mobile") {
            buyIntentionDataSet()
            context = "garex"
            checkout_flow="cart"
        }

        "/buy_intention"(platform:"/web/desktop") {
            buyIntentionDataSet()
            context = "garex"
            checkout_flow="direct"
        }

        "/buy_intention"(platform:"/web/desktop") {
            buyIntentionDataSet()
            context = "garex"
            checkout_flow="cart"
        }

    }

}
