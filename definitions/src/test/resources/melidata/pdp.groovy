import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    def pickers_data = {
        [
                "COLOR" : [
                        [
                                catalog_product_id: "MLA123",
                                selected          : true,
                                disabled          : false
                        ],
                        [
                                catalog_product_id: "MLA125",
                                selected          : false,
                                disabled          : false
                        ]
                ],
                "MEMORY": [
                        [
                                catalog_product_id: "MLA123",
                                selected          : true,
                                disabled          : false
                        ],
                        [
                                catalog_product_id: "MLA125",
                                selected          : false,
                                disabled          : false
                        ]
                ]
        ]
    }

    def items_data = {
        [
                [
                        item_id              : "MLA787787584",
                        price                : 8400,
                        original_price       : 10000,
                        currency_id          : "ARS",
                        installment_info     : "6f",
                        item_condition       : "new",
                        sold_quantity        : 5,
                        shipping_conditions  : "discount_gap",
                        bo_pick_up_conditions: "no_discount",
                        pushing_puis         : false,
                        showing_puis         : false,
                        official_store_id    : 231,
                        seller_id            : 1234,
                        seller_name          : "fulano",
                        available_quantity   : 31,
                        cart_content         : true,
                        logistic_type        : "cross_docking",
                        has_full_filment     : false
                ],
                [
                        item_id              : "MLA7877875184",
                        shipping_conditions  : "discount_gap",
                        bo_pick_up_conditions: "no_discount"

                ]
        ]
    }

    //PDP FLOW
    test("pdp mandatory tracking") {
        "/pdp"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            domain_id = "MLA-CELLPHONES"
//            category_id = "MLA43718" //TODO: uncomment when they are required
//            category_path = ["MLA1234", "MLA6789"]
            vertical = "core"//todo creo que esto no tiene sentido en pdp
            item_condition = "new"
            listing_type_id = "gold_special"
            seller_id = 131662738
            pickers = pickers_data()

            shipping_conditions = "free_other"
            bo_pick_up_conditions = "free_other"
        })

        "/pdp/buy_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            domain_id = "MLA-CELLPHONES"
            seller_id = 1234
            shipping_conditions = "free_special"
            bo_pick_up_conditions = "free_other"
            price = 8400
            currency_id = "ARS"
        })

        "/pdp/add_to_cart_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            domain_id = "MLA-CELLPHONES"
            seller_id = 1234
            shipping_conditions = "free_loyal"
            bo_pick_up_conditions = "free_loyal"
            price = 8400
            currency_id = "ARS"
        })

        "/pdp/quantity_change"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA1234"
            quantity = 2
            seller_id = 12345
        })

        "/pdp/picker_selection"(platform: "/", {
            catalog_product_id = "MLA1234"
        })

        "/pdp/other_buying_options"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"
        })

        "/pdp/share"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            domain_id = "core"
        })

        "/pdp/show_all_reviews"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"
        })

        "/pdp/sellers"(platform: "/", {
            catalog_parent_id = "MLA11137440"
            catalog_product_id = "MLA11137441"
            vertical = "core"
            domain_id = "MLA-CELLPHONES"
            pickers = pickers_data()
            items = items_data()
        })
    }


    test("pdp all tracking") {
        def cart = {
            cart_content = true
        }

        def shipping = {
            shipping_mode = "not_specified"
            free_shipping = false
            local_pick_up = true
            store_pick_up = true
            logistic_type = "default"
            shipping_conditions = "discount_mandatory"
        }

        def pickup = {
            showing_puis = true
            pushing_puis = false
            bo_pick_up_conditions = "discount_ratio"
        }

        "/pdp"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            domain_id = "MLA-CELLPHONES"
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            vertical = "core"//todo creo que esto no tiene sentido en pdp
            item_condition = "new"
            listing_type_id = "gold_special"
            seller_id = 131662738
            pickers = pickers_data()

            catalog_parent_id = "MLA123"
            quantity = 3
            available_quantity = 6
            price = 15.3
            original_price = 18.0
            currency_id = "ARS"
            review_rate = 4.6
            seller_name = "fulanito"
            power_seller_status = "platinum"
            reputation_level = "5_green"
            official_store_id = 1
            store_type = "brand"
            installment_info = "6f"
            loyalty_level = 2
            previous_catalog_product_id = "MLA43720"

            filters = ["installments": "no_interest", "price":"1000-2000"]

            cart()
            shipping()
            pickup()
        })

        "/pdp/buy_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            seller_id = 1234
            domain_id = "MLA-CELLPHONES"

            item_id = "MLA533657947"
            quantity = 3
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            loyalty_level = 2
            vertical = "core"
            review_rate = 4.6
            official_store_id = 1
            reputation_level = "5_green"
            installment_info = "6f"
            item_condition = "new"
            listing_type_id = "gold_special"
            power_seller_status = "platinum"
            seller_name = "fulanito"

            cart()
            shipping()
            pickup()

            price = 8400
            currency_id = "ARS"
        })

        "/pdp/add_to_cart_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            seller_id = 1234
            domain_id = "MLA-CELLPHONES"

            item_id = "MLA533657947"
            quantity = 3
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            loyalty_level = 2
            vertical = "core"
            review_rate = 4.6
            official_store_id = 1
            reputation_level = "5_green"
            installment_info = "6f"
            item_condition = "new"
            listing_type_id = "gold_special"
            power_seller_status = "platinum"
            seller_name = "fulanito"

            cart()
            shipping()
            pickup()

            price = 8400
            currency_id = "ARS"
        })

        "/pdp/quantity_change"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA1234"
            quantity = 2
            seller_id = 12345
            seller_name = "fulano"
        })

        "/pdp/picker_selection"(platform: "/", {
            catalog_product_id = "MLA1234"
            picker_id = "MLA14545"
            picker_disabled = false
        })

        "/pdp/other_buying_options"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"

            seller_name = "fulano"
            official_store_id = 1234
            filter = "new"
        })

        "/pdp/share"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            domain_id = "celulares"

            seller_name = "fulano"
            official_store_id = 1234
        })

        "/pdp/show_all_reviews"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"

            seller_name = "fulano"
            official_store_id = 1234
            review_rate = 5
        })

        "/pdp/sellers"(platform: "/", {
            catalog_parent_id = "MLA11137440"
            catalog_product_id = "MLA11137441"
            vertical = "core"
            domain_id = "MLA-CELLPHONES"
            review_rate = 1
            loyalty_level = 3

            pickers = pickers_data()
            items = items_data()
        })
    }

    test("mobile special actions") {

        //mandatory
        "/pdp/show_picker_selection_modal"(platform: "/mobile", {
            catalog_product_id = "MLA1234"
        })

        "/pdp/show_complete_description"(platform: "/mobile", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"
        })

        "/pdp/show_more_features"(platform: "/mobile", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"
        })

        //all
        "/pdp/show_picker_selection_modal"(platform: "/mobile", {
            catalog_product_id = "MLA1234"
            picker_id = "MLA2135"
            modal_type = "list"
        })

        "/pdp/show_complete_description"(platform: "/mobile", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"

            seller_name = "fulano"
            official_store_id = 1234
        })


        "/pdp/show_more_features"(platform: "/mobile", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"

            seller_name = "fulano"
            official_store_id = 1234
        })

    }

    //Track Questions Show
    test("Show questions tracking"){
        "/pdp/question/show"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
        })
    }

    //Sellers page FLOW
    test("Sellers page tracking") {
        "/pdp/sellers/quantity_change"(platform: "/", {
            catalog_product_id = "MLA1234"
            quantity = 2
            available_quantity = 10
        })

        "/pdp/sellers/picker_selection"(platform: "/", {
            catalog_product_id = "MLA1234"
            picker_id = "COLOR"
            picker_disabled = false
        })

        "/pdp/sellers/page_selection"(platform: "/", {
            catalog_product_id = "MLA1234"
            selected_quantity = 1
            selected_page = 5
            total_pages = 10
            total_items = 100
        })
    }
}
