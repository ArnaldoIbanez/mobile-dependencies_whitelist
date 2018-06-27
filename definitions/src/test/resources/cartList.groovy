package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"


//------------------------------------------------------------------------------------------------------------------------------------------------------
// TRACKS CART LIST
//------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Cart List") {

        def dataSet = {

            items = [
                    [
                            currency_id: "ARS",
                            unit_price: 100,
                            quantity: 1,
                            item: [
                                    category_id: "MLA63385",
                                    buying_mode: "buy_it_now",
                                    category_path: [ "MLA1499", "MLA2467", "MLA754486062" ],
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
                                    category_path: [ "MLA1499", "MLA2467", "MLA754486062" ],
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

        "/cart/my_cart"(platform: "/web", dataSet)

        "/cart/my_cart/save_for_later"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]

            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/my_cart/delete_item"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/my_cart/change_quantity"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            quantity_change = -1
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/my_cart/select_address"(platform: "/web", dataSet)

        "/cart/my_cart/dont_know_cp"(platform: "/web", dataSet)

        "/cart/my_cart/view_similar"(platform: "/web", dataSet)

        "/cart/my_cart/open_change_notification"(platform: "/web", dataSet)

        "/cart/my_cart/close_change_notification"(platform: "/web", dataSet)

        "/cart/saved_for_later"(platform: "/web", dataSet)

        "/cart/saved_for_later/add_to_cart"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/saved_for_later/delete_item"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/saved_for_later/change_quantity"(platform: "/web"){
            item = [
                    id: "MLA754486062",
                    listing_type: "gold_special",
                    international_delivery_mode: "none",
            ]


            loyalty_level = 2
            currency_id = "MXN"
            quantity = 2
            quantity_change = -1
            free_shipping_benefit = false
            unit_price = 173
        }

        "/cart/my_cart/change_address"(platform: "/web", dataSet)

        "/cart/my_cart/add_cp/"(platform: "/web", dataSet)

        "/cart/my_cart/confirm_address"(platform: "/web", dataSet)

        "/cart/my_cart/my_addresses"(platform: "/web", dataSet)

        "/cart/my_cart/confirm_cp"(platform: "/web", dataSet)

        "/cart/my_cart/add_cp/confirm_cp"(platform: "/web", dataSet)

        "/cart/my_cart/add_cp/dont_know_cp"(platform: "/web", dataSet)

    }

//------------------------------------------------------------------------------------------------------------------------------------------------------
// TRACKS MYML CART
//------------------------------------------------------------------------------------------------------------------------------------------------------


}
