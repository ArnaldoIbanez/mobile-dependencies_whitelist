import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //PDP FLOW
    test("pdp core tracking") {
//        def products = {
//            catalog_product_id = "MLA123"
//            selected = false
//            disabled = false
//        }
//
//        def pickers = {
//            pickers_id = "MLA12345"
//            products = [products()]
//        }

        def mandatory = {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            domain_id = "?"
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            vertical = "core"//todo creo que esto no tiene sentido en pdp
            item_condition = "new"
            listing_type_id = "gold_special"
            seller_id = 131662738
            pickers = {}
        }

        def optionals = {
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
        }

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
            mandatory()
            optionals()
            cart()
            shipping()
            pickup()
        })

        //mandatory
        "/pdp/buy_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            seller_id = 1234
            shipping_conditions = "free_special"
            bo_pick_up_conditions = "free_other"
        })

        "/pdp/add_to_cart_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            seller_id = 1234
            shipping_conditions = "free_loyal"
            bo_pick_up_conditions = "free_loyal"
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
            domain_id = "core"
        })

        //all
        //all
        //all
        //all
        //all
        "/pdp/buy_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            seller_id = 1234

            item_id = "MLA533657947"
            quantity = 3
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            loyalty_level = 2
            vertical = "core"//todo creo que esto no tiene sentido en pdp
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
        })

        "/pdp/add_to_cart_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            seller_id = 1234

            item_id = "MLA533657947"
            quantity = 3
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            loyalty_level = 2
            vertical = "core"//todo creo que esto no tiene sentido en pdp
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
            domain_id = "core"

            seller_name = "fulano"
            official_store_id = 1234
            filter = "new"
        })


    }
}
