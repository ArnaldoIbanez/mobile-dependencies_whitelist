package src.test.resources.melidata

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

        def dataSetWithSummary = {

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

            summary = [
                    "total":[
                            "amount":1446.61,
                            "symbol":"\$"
                    ],
                    "shipping_total":[
                            "amount":0,
                            "symbol":"\$"
                    ],
                    "shipping_promoted_amount": 0
            ]
        }

        def dataSetWithSummaryAndAttributes = {

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

            summary = [
                    "total":[
                            "amount":1446.61,
                            "symbol":"\$"
                    ],
                    "shipping_total":[
                            "amount":0,
                            "symbol":"\$"
                    ],
                    "shipping_promoted_amount": 0
            ]

            item_attributes = [ "STOCK_AVAILABLE" ]

            page_vertical = "CORE"
        }

        "/cart/my_cart"(platform: "/", dataSetWithSummaryAndAttributes)

        "/cart/my_cart"(platform: "/web", dataSetWithSummary)

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

        "/cart/my_cart/more_seller_items"(platform: "/web"){
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

        "/cart/my_cart/select_address"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/dont_know_cp"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/view_similar"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/open_change_notification"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/close_change_notification"(platform: "/web", dataSetWithSummary)

        "/cart/saved_for_later"(platform: "/web", dataSetWithSummary)

        "/cart/saved_for_later"(platform: "/", dataSetWithSummaryAndAttributes)

        "/cart/saved_for_later/open_change_notification"(platform: "/web", dataSet)

        "/cart/saved_for_later/close_change_notification"(platform: "/web", dataSet)

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

        def cannotAddModalDataSet ={
            cant_add_motive = "ratio"
        }

        def itemAddErrorDataSet ={
            error_type = "cart_full"
        }

        "/cart/saved_for_later/cant_add_to_cart"(platform: "/web", cannotAddModalDataSet)

        "/cart/saved_for_later/cant_add_to_cart/buy_now"(platform: "/web", cannotAddModalDataSet)

        "/cart/my_cart/change_address"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/add_cp/"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/confirm_address"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/my_addresses"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/confirm_cp"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/add_cp/confirm_cp"(platform: "/web", dataSetWithSummary)

        "/cart/my_cart/add_cp/dont_know_cp"(platform: "/web", dataSetWithSummary)

        "/cart/item_add"(platform: "/web", dataSet)

        "/cart/item_add/error"(platform: "/web", itemAddErrorDataSet)

        def errorsForModal = {
            cart_ratio = "applies"
            cant_update_motive = "quantity_up"
        }

        "/cart/my_cart/free_shipping_lost_warning"(platform: "/web", errorsForModal)

        "/cart/my_cart/free_shipping_lost_warning/dismiss"(platform: "/web", errorsForModal)

        "/cart/my_cart/free_shipping_lost_warning/confirm"(platform: "/web", errorsForModal)

        def changeProgressModel = {
            motive = "saved_for_later"
            cart_ratio = "applies"
            previous_free_shipping_progress = 50
            actual_free_shipping_progress = 60
            free_shipping_benefit = false
        }

        "/cart/my_cart/change_free_shipping_progress_status"(platform: "/web", changeProgressModel)

    }

//------------------------------------------------------------------------------------------------------------------------------------------------------
// TRACKS MYML CART
//------------------------------------------------------------------------------------------------------------------------------------------------------


}
