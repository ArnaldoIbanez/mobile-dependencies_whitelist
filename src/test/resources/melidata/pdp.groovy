import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    def alternative_buying_options_data = {
        [
            [
                    position: 1,
                    item_id: "MLA123",
                    buying_option_id: "PUIS",
                    seller_id: 123,
                    seller_name: "any seller"
            ],
            [
                    position: 2,
                    item_id: "MLA321",
                    buying_option_id: "OFFICIAL_STORE",
                    seller_id: 321,
                    seller_name: "any other seller"
            ]
        ]
    }

    def pickers_data = {
        [
                "COLOR" : [
                        [
                                catalog_product_id: "MLA123",
                                selected          : true,
                                picker_type       : "normal"
                        ],
                        [
                                catalog_product_id: "MLA125",
                                selected          : false,
                                picker_type       : "normal"
                        ]
                ],
                "MEMORY": [
                        [
                                catalog_product_id: "MLA123",
                                selected          : true,
                                picker_type       : "normal"
                        ],
                        [
                                catalog_product_id: "MLA125",
                                selected          : false,
                                picker_type       : "normal"
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
                has_full_filment     : false,
                available_promotions : [
                    [
                        campaign_id     : "1761",
                        type            : "DISCOUNT",
                        original_value  : 953,
                        value           : 643.5
                    ]
                ],
                discount_reasons : ["deal"]
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
            best_seller_position = 3
            highlights = [
                "best_seller_position": 5,
                "melichoice_domain": "CELLPHONES",
                "melichoice_origin": "killer",
                "melichoice_score": 0.3
            ]
            cac_item = false
            cac_status = "normal"
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
            credits_opensea = true
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
            visible = true
        })

        "/pdp/other_buying_options"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
            item_condition = "used"
            listing_type_id = "gold_special"
            product_status = "paused"
            domain_id = "celulares"
            context = "alternatives"
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

        def alternative_buying_option = {
            position = 1
            item_id = "MLA123"
            buying_option_id = "PUIS"
            seller_id = 123
            seller_name = "any seller"
        }

        def pricingTwoPointO = {
            available_promotions = [
                {
                    campaign_id = "1761"
                    type = "DISCOUNT"
                    original_value = 953
                    value = 643.5
                }
            ]
            discount_reasons = ["deal"]
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
            alternative_buying_options = alternative_buying_options_data()

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
            collapsed_pickers = true

            filters = ["installments": "no_interest", "price":"1000-2000"]

            multiple_offer_type="BEST_PRICE"
            multiple_offer_default_winner_item_id="MLB1432864987"

            cart()
            shipping()
            pickup()
            pricingTwoPointO()
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
            pricingTwoPointO()

            price = 8400
            currency_id = "ARS"
            credits_opensea = false
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
            pricingTwoPointO()

            price = 8400
            currency_id = "ARS"
        })

        "/pdp/multiple_offer/select_offer"(platform: "/") {
            item_id = "MLA12345678"
            multiple_offer_type = "BEST_PRICE"
        }

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
            picker_type = "normal"
            visible = false
        })

        "/pdp/picker_collapse"(platform: "/", {
            catalog_product_id = "MLA1234"
            picker_id = "MLA14545"
            collapse = true
        })

        "/pdp/other_buying_options"(platform: "/", {
            catalog_product_id = "MLA1234"
            domain_id = "celulares"
            context = "main_actions_no_winner"
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
            collapsed_pickers = true

            pickers = pickers_data()
            items = items_data()
        })

        "/pdp/alternative_buying_options/buy_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            alternative_buying_option()
        })

        "/pdp/alternative_buying_options/add_to_cart_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            alternative_buying_option()
        })

        "/pdp/onboarding_catalog/show"(platform: "/", {
            catalog_product_id = "MLA1234"
            referer = "onboarding"
        })

        "/pdp/onboarding_catalog/close"(platform: "/", {
            catalog_product_id = "MLA1234"
        })

        "/pdp/catalog_tag_click"(platform: "/", {
            catalog_product_id = "MLA1234"
        })

        "/pdp/public_similar_intention"(platform: "/web/desktop", {
            catalog_product_id = "MLA1234"
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            item_id = "MLA99221"
            vertical = "core"
            domain_id = "MLA-CELLPHONES"
            item_condition = "new"
        })

        "/pdp/description/show"(platform: "/", {
            catalog_product_id = "MLA1234"
        })

        "/pdp/show_complete_description"(platform: "/web/desktop", {
            catalog_product_id = "MLA1234"
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
        "/pdp/questions/show"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            seller_id = 2345678
        })

        "/pdp/questions/quick_access"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
            domain_id = "celulares"
            type = "payment"
            context = "/qadb"
        })
    }

    //QADB call to action
    test("Qadb call to action tracking"){
        "/pdp/qadb/call-to-action"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
        })
    }

    //QADB search all action
    test("Qadb search all action tracking"){
        "/pdp/qadb/search-all-action"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA112341"
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
            picker_type = "normal"
            visible = false
        })

        "/pdp/sellers/page_selection"(platform: "/", {
            catalog_product_id = "MLA1234"
            selected_quantity = 1
            selected_page = 5
            total_pages = 10
            total_items = 100
        })

        "/pdp/sellers/buy_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA123"
            reputation_level = "1_red"
            seller_id = 123
            seller_name = "name"
            price = 123
            original_price = 12
            currency_id = "ARS"
            pdp_type = "RED"
        })

        "/pdp/sellers/add_to_cart_action"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA123"
            reputation_level = "1_red"
            seller_id = 123
            seller_name = "name"
            price = 123
            original_price = 12
            currency_id = "ARS"
            pdp_type = "RED"
        })
    }

    //Stock modal
    test("Stock modal tracking") {
        "/pdp/questions/ask/prevent_stock"(platform: "/", type: TrackType.Event, {})
    }

    test("Pdp Server Side") {
        "/pdp/backend/questions_redirect"(platform: "/") {}
    }

    test("PDP onboardings") {

        "/pdp/fulfillment_modal/show"(platform: "/", type: TrackType.Event, {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            item_condition = "new"
            seller_id = 131662738
            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
        })

        "/pdp/fulfillment_fs_modal/show"(platform: "/", type: TrackType.Event, {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            item_condition = "new"
            seller_id = 131662738
            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
        })
        
        "/pdp/cbt_modal/show"(platform: "/", type: TrackType.Event, {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            item_condition = "new"
            seller_id = 131662738
            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
        })

        "/pdp/fulfillment_tooltip/show"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            buyer_id = "12343718"
        })

        "/pdp/fulfillment_tooltip/close"(platform: "/", type: TrackType.Event, {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            buyer_id = "12343718"
        })

        "/pdp/fulfillment_fs_tooltip/show"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            buyer_id = "12343718"
        })

        "/pdp/credits_tooltip/show"(platform: "/", {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            buyer_id = "12343718"
        })

        "/pdp/fulfillment_fs_tooltip/close"(platform: "/", type: TrackType.Event, {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            buyer_id = "12343718"
        })

        "/pdp/credits_tooltip/close"(platform: "/", type: TrackType.Event, {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            buyer_id = "12343718"
        })
    }

    // Pricing 2.0 - Payments Modal Track
    test("PDP Pricing 2.0 - Payments Modal track") {
        "/pdp/pricing_rebates/modal_payments_action"(platform: "/", type: TrackType.Event) {
            item_id = "MLB1640051252"
            is_cash_price = true
            original_price = 100
            price = 85
            currency_id = "BRL"
            installments_value_total = 104.4
            installments_value_each = 8.7
            installments_amount = 12
            is_free_installments = false
        }
    }

    test("Pdp Advertising banners") {
        "/pdp/advertising"(platform: "/", type: TrackType.Event) {
            advertising_id = "fullscreen"
        }
    }

    test("Technical Specs Viewport") {
        "/pdp/technical_specs/show"(platform: "/", type: TrackType.Event) {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            domain_id = "MLA-CELLPHONES"
            is_highlighted = true
            category_id = "MLA43718"
            seller_id = 131662738
            category_path = ["MLA1234", "MLA6789"]
        }
    }

    test("Technical Specs View More") {
        "/pdp/technical_specs/view_more"(platform: "/", type: TrackType.Event) {
            catalog_product_id = "MLA1234"
            item_id = "MLA533657947"
            domain_id = "MLA-CELLPHONES"
            is_highlighted = true
            category_id = "MLA43718"
            seller_id = 131662738
            category_path = ["MLA1234", "MLA6789"]
        }
    }
}
