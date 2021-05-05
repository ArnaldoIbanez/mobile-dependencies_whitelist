package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1171"

    def product_picker_definition = objectSchemaDefinitions {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        selected(required: true, type: PropertyType.Boolean, description: "indicates if the product picker is selected or not")
        picker_type(required: true, type: PropertyType.String, values: ["smart", "no_stock", "normal"], description: "indicates the type of the picker")
    }

    def alternative_buying_option_definition = objectSchemaDefinitions {
        alternative_buying_option_info
    }

    Object available_promotions_map = objectSchemaDefinitions {
        campaign_id(required: true, type: PropertyType.String, description: "Promotion campaign id")
        type(required: true, type: PropertyType.String, description: "Promotion campaign type")
        original_value(required: true, type: PropertyType.Numeric, description: "Promotion campaign item original value")
        value(required: true, type: PropertyType.Numeric, description: "Promotion campaign item value")
    }

    propertyDefinitions {
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")

        cart_content(required: false, type: PropertyType.Boolean, description: "Indicates if the PDP has cart features")

        //ITEM SHIPPING CONDITIONS
        shipping_mode(required: false, type: PropertyType.String, values: ["not_specified", "custom", "me1", "me2"],
                description: "Mercado Envios mode")
        free_shipping(required: false, type: PropertyType.Boolean,
                description: "Indicates if shipping is free")
        local_pick_up(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has local pick up")
        store_pick_up(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has store pick up")
        logistic_type(required: false,
                values: ["not_specified", "default", "drop_off", "xd_drop_off", "custom", "cross_docking", "fulfillment"],
                type: PropertyType.String, description: "Indicates the logistic type of the item")

        //SHIPPING CONDITIONS
        shipping_conditions(required: false, type: PropertyType.String, values: ["no_me", "me_non_free", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                description: "Shipping conditions for item related to the BBW - Products without a BBW won't have this information")

        //BRACH_OFFICE CONDITIONS
        bo_pick_up_conditions(required: false, type: PropertyType.String, values: ["no_bo_pick_up", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                description: "Branch office pick up conditions for item related to the BBW - Products without a BBW won't have this information")

        //PUIS
        showing_puis(required: false, type: PropertyType.Boolean, description: "Indicates if PDP BBW is showing PUIS pickup option in pickup row")
        pushing_puis(required: false, type: PropertyType.Boolean, description: "Indicates PUIS is being pushed over branch office pickup option")

        //Alternative Buying Options - BBW Alternatives
        position(required: true, type: PropertyType.Numeric, description: "The position of the buying option alternative in PDP")
        item_id(required: true, type: PropertyType.String, description: "The itemId of the buying option alternative")
        buying_option_id(required: true, type: PropertyType.String, description: "The identifier of the alternative buying option that is being highlighted")
        seller_id(required: true, type: PropertyType.Numeric, description: "The Id of the seller")
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")

        // PRICING 2.0
        available_promotions(required: false, type: PropertyType.ArrayList(PropertyType.Map(available_promotions_map)),
                description: "Lists the available promotions for the item")
        discount_reasons(required: false, type: PropertyType.ArrayList, description: "The discounts applied to this item original_price, to finally show price (loyalty, deal)")

    }

    propertyGroups {
        add_cart_info(cart_content)
        shipping_info(shipping_mode, free_shipping, local_pick_up, store_pick_up, logistic_type, shipping_conditions)
        pickup_info(showing_puis, pushing_puis, bo_pick_up_conditions)
        alternative_buying_option_info(position, item_id, buying_option_id, seller_id, seller_name)
        pricing_info(available_promotions, discount_reasons, price, original_price, currency_id)
    }

    def item_info_definition = objectSchemaDefinitions {
        item_id(required: true, type: PropertyType.String, description: "ID for item")
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")
        item_condition(required: false, type: PropertyType.String, description: "Indicates if an item is new/used/refurbished")
        sold_quantity(required: false, type: PropertyType.Numeric, description: "Quantity of items sold")
        shipping_conditions(required: false, type: PropertyType.String, values: ["no_me", "me_non_free", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                description: "Shipping conditions for product")

        //BRACH_OFFICE CONDITIONS
        bo_pick_up_conditions(required: false, type: PropertyType.String, values: ["no_bo_pick_up", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                description: "Branch office pick up conditions for product")

        //PUIS
        showing_puis(required: false, type: PropertyType.Boolean, description: "Indicates if PDP BBW is showing PUIS pickup option in pickup row")
        pushing_puis(required: false, type: PropertyType.Boolean, description: "Indicates PUIS is being pushed over branch office pickup option")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        seller_id(required: false, type: PropertyType.Numeric, description: "ID for seller")
        seller_name(required: false, type: PropertyType.String, description: "Name of seller")
        subtitle_types(required: false, type: PropertyType.ArrayList, description: "seller subtitles types")
        available_quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")
        cart_content(required: false, type: PropertyType.Boolean, description: "Content of cart")
        has_full_filment(required: false, type: PropertyType.Boolean, description: "If an item is available via fullfilment")
        logistic_type(required: false,
                values: ["not_specified", "default", "drop_off", "xd_drop_off", "custom", "cross_docking", "fulfillment"],
                type: PropertyType.String, description: "Indicates the logistic type of the item")

        // PRICING 2.0
        pricing_info

    }

    def qadb_info_definition = objectSchemaDefinitions {
        results(required:false, type: PropertyType.ArrayList(PropertyType.Map(question_result)), description: "Initial results")
    }

    def highlights_definition  = objectSchemaDefinitions {
        id(required: false, type: PropertyType.String, description: "Id of the highlight")
        best_seller_position(required: false, type: PropertyType.Numeric, description: "Position of Best Seller Product")
        melichoice_score(required: false, type: PropertyType.Numeric, description: "Score of Melichoice Product")
        melichoice_origin(required: false, type: PropertyType.String, description: "Origin of Melichoice Product")
        melichoice_domain(required: false, type: PropertyType.String, description: "Domain of Melichoice Product")
    }

    //VPP FLOW

    "/pdp"(platform: "/") {
        // Temp fields
        cac_item(required: false, type: PropertyType.Boolean,
                 description: "Indicates whether the product is listed as 'CodoACodo'")

        cac_status(required: false, type: PropertyType.String,
                values: ["normal", "after_dispatch", "unknown"],
                description: "Indicates items status of Elbow to Elbow (Codo a Codo) initiative")

        //Product fields
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog Product ID")
        catalog_parent_id(required: false, type: PropertyType.String, description: "Parent Catalog Product ID")
        item_id(required: false, type: PropertyType.String, description: "Item ID in case of having a PDP with BBW")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        //TODO: set to required true when it is fixed in products api
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        previous_catalog_product_id(required: false, type: PropertyType.String, description: "Previous Catalog Product ID")

        //picker definition
        pickers(required: false, type: PropertyType.Map(PropertyType.String, PropertyType.ArrayList(PropertyType.Map(product_picker_definition))), description: "Available pickers for the given product")
        collapsed_pickers(required: false, type: PropertyType.Boolean, description: "Indicates if a pdp has collapsed pickers")

        category_path(required: false, type: PropertyType.ArrayList, description: "Category path of the the item")
        vertical(required: true, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item in case of having a PDP with BBW")

        // ONLY CORE FIELDS
        quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")
        available_quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")

        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")

        // CART
        add_cart_info

        //SELLER FIELDS
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller id in case of having a PDP with BBW")
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller in case of having a PDP with BBW")
        power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                description: "Seller's Mercado Lider level in case of having a PDP with BBW")
        reputation_level(required: false, type: PropertyType.String,
                values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"],
                description: "Seller's reputation level in case of having a PDP with BBW")
        subtitle_types(required: false, type: PropertyType.ArrayList, description: "seller subtitles types")

        // OFFICIAL_STORES
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        store_type(required: false, type: PropertyType.String, values: ["normal", "brand"], description: "Indicates store type")

        // PAYMENT
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")

        // SHIPPING
        shipping_info

        // PICKUP
        pickup_info

        // QADB
        qadb_info(required: false, type: PropertyType.Map(qadb_info_definition), description: "Tracking info for QADB component.")

        // USER FIELD
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")

        // FILTERS
        filters(required: false, type: PropertyType.Map(PropertyType.String, PropertyType.String), description: "Filters applied to get buy box winner")

        //Alternative Buying Options - BBW Alternatives
        alternative_buying_options(required: false, type: PropertyType.ArrayList(PropertyType.Map(alternative_buying_option_definition)), description: "Alternative Buying Options - BBW Alternatives")

        // Stock
        stock_type(required: false, type: PropertyType.String, inheritable: false, values: ["normal", "deferred"], description: "Indicates the type of stock for the product (normal = immediate stock, deferred = within x days)")
        stock_deferred_time(required: false, type: PropertyType.Numeric, inheritable: false, description: "Amount of days when the product will have available stock. Will only be used when stock_type = deferred")

        // Multiple Offer
        multiple_offer_type(required: false, type: PropertyType.String, inheritable: false, values: ["BEST_PRICE", "BEST_INSTALLMENTS"], description: "Indicates the type of multiple offer selected")
        multiple_offer_default_winner_item_id(required: false, type: PropertyType.String, inheritable: false, description: "Indicates the item id of the default winner of the multiple offer options")

        // General
        pdp_type(required: false, type: PropertyType.String, inheritable: false, values: ["NO_STOCK","RED", "GREEN_WITH_OFFER", "GREEN_NO_OFFER", "YELLOW_WITH_OFFER", "YELLOW_NO_OFFER"], description: "Indicates the type of pdp")

        //Highlights
        best_seller_position(required: false, type: PropertyType.Numeric, description: "Position of Best Seller Product")

        highlights(required: false, type: PropertyType.Map(highlights_definition), description: "Highlights Map")

        // PRICING 2.0
        pricing_info
    }

    "/pdp/buy_action"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        quantity(required: false, type: PropertyType.Numeric, description: "Quantity of this item that the user is trying to buy")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList, description: "Category path of the the item")
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
        vertical(required: false, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        reputation_level(required: false, type: PropertyType.String, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"], description: "Seller's reputation level")
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                description: "Seller's Mercado Lider level")
        add_cart_info
        shipping_info
        pickup_info
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        pdp_type(required: false, type: PropertyType.String, inheritable: false, values: ["NO_STOCK","RED", "GREEN_WITH_OFFER", "GREEN_NO_OFFER", "YELLOW_WITH_OFFER", "YELLOW_NO_OFFER"], description: "Indicates the type of pdp")
        credits_opensea(required: false, type: PropertyType.Boolean, description: "Indicates that it was initiated by the purchase from Credits Open Sea")
        pricing_info
    }

    "/pdp/add_to_cart_action"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        quantity(required: false, type: PropertyType.Numeric, description: "Quantity of this item that the user is trying to buy")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList, description: "Category path of the the item")
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
        vertical(required: false, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        has_technical_specification(required: false, type: PropertyType.Boolean, description: "Indicates if the item has technical specifications")
        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        reputation_level(required: false, type: PropertyType.String, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"], description: "Seller's reputation level")
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")
        has_variations(required: false, type: PropertyType.Boolean, description: "Indicates if the item has variations")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                description: "Seller's Mercado Lider level")
        add_cart_info
        shipping_info
        pickup_info
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        pdp_type(required: false, type: PropertyType.String, inheritable: false, values: ["NO_STOCK","RED", "GREEN_WITH_OFFER", "GREEN_NO_OFFER", "YELLOW_WITH_OFFER", "YELLOW_NO_OFFER"], description: "Indicates the type of pdp")
        credits_opensea(required: false, type: PropertyType.Boolean, description: "Indicates that it was initiated by the purchase from Credits Open Sea")
        pricing_info
    }

    "/pdp/multiple_offer"(platform: "/", isAbstract:true) {}

    "/pdp/multiple_offer/select_offer"(platform: "/", parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, inheritable: false, description: "Selected Option Item ID")
        multiple_offer_type(required: true, type: PropertyType.String, inheritable: false, values: ["BEST_PRICE", "BEST_INSTALLMENTS"], description: "Indicates the type of multiple offer selected")
    }

    "/pdp/quantity_change"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of this item that the user is trying to buy")
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
    }

    "/pdp/picker_selection"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        picker_id(required: false, type: PropertyType.String, description: "Product's picker ID")
        picker_type(required: false, type: PropertyType.String, values: ["smart", "no_stock", "normal"], description: "indicates the type of the picker")
        visible(required: false, type: PropertyType.Boolean, description: "Indicates if product picker is originally visible")
    }

    "/pdp/picker_collapse"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        picker_id(required: false, type: PropertyType.String, description: "Product's picker ID")
        collapse(required: false, type: PropertyType.Boolean, description: "Indicates if picker is collapse")
    }

    "/pdp/show_picker_selection_modal"(platform: "/mobile", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        picker_id(required: false, type: PropertyType.String, description: "Product's picker ID")
        modal_type(required: false, type: PropertyType.String, description: "Variation's modal type")
    }

    "/pdp/other_buying_options"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        seller_id(required: false, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        product_status(required: false, type: PropertyType.String, values: ["pending", "active", "inactive",
                "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        context(required: true, type: PropertyType.String, values: ["other_products_new", "alternatives", "main_actions_no_winner"], description: "Indicates the context in where the event was triggered from the PDP")
    }

    "/pdp/share"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
    }

    "/pdp/show_complete_description"(platform: "/mobile", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        product_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
    }

    "/pdp/show_complete_description"(platform: "/web/desktop", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
    }

    "/pdp/description"(platform: "/", isAbstract: true) {}
    "/pdp/description/show"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
    }

    "/pdp/show_more_features"(platform: "/mobile", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        product_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
    }

    "/pdp/show_all_reviews"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        product_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
    }



    "/pdp/sellers"(platform: "/", parentPropertiesInherited: false) {
        catalog_parent_id(required: false, type: PropertyType.String, description: "Product ID")
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        vertical(required: true, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
        collapsed_pickers(required: false, type: PropertyType.Boolean, description: "Indicates if a pdp has collapsed pickers")
        pickers(required: false, type: PropertyType.Map(PropertyType.String, PropertyType.ArrayList(PropertyType.Map(product_picker_definition))), description: "Available pickers for the given product")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_info_definition)), description: "Items listed on the page")
        pdp_type(required: false, type: PropertyType.String, inheritable: false, values: ["NO_STOCK","RED", "GREEN_WITH_OFFER", "GREEN_NO_OFFER", "YELLOW_WITH_OFFER", "YELLOW_NO_OFFER"], description: "Indicates the type of pdp")
    }

    "/pdp/sellers/quantity_change"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product id")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of the product that the user is trying to buy or add to cart")
        available_quantity(required: true, type: PropertyType.Numeric, description: "Max Available quantity for the selected product")
    }

    "/pdp/questions"(platform: "/", isAbstract:true) {}

    "/pdp/questions/quick_access"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product id")
        item_id(required: true, type: PropertyType.String, description: "Item ID in case of having a PDP with BBW")
        type(required: true, type: PropertyType.String,values: ["payment", "returns", "shipping", "warranty"], description: "quick access type")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        context(required: true, type: PropertyType.String, description: "The context is qadb", values:["/qadb","/questions"])
    }

    "/pdp/qadb"(parentPropertiesInherited: false, isAbstract: true) {}

    "/pdp/qadb/call-to-action"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product id")
        item_id(required: true, type: PropertyType.String, description: "Item ID in case of having a PDP with BBW")
    }

    "/pdp/qadb/search-all-action"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product id")
        item_id(required: true, type: PropertyType.String, description: "Item ID in case of having a PDP with BBW")
    }

    "/pdp/questions/show"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product id")
        item_id(required: false, type: PropertyType.String, description: "Item ID in case of having a PDP with BBW")
        seller_id(required: false, type: PropertyType.Numeric, description: "")
    }

    "/pdp/sellers/picker_selection"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        picker_id(required: true, type: PropertyType.String, description: "Product's picker ID")
        picker_type(required: false, type: PropertyType.String, values: ["smart", "no_stock", "normal"], description: "indicates the type of the picker")
        visible(required: false, type: PropertyType.Boolean, description: "Indicates if product picker is originally visible")
    }

    "/pdp/sellers/page_selection"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        selected_quantity(required: true, type: PropertyType.Numeric, description: "Quantity of the product that the user is trying to buy or add to cart")
        selected_page(required: true, type: PropertyType.Numeric, description: "Selected page in PDS")
        total_pages(required: true, type: PropertyType.Numeric, description: "Total amount of pages in PDS")
        total_items(required: true, type: PropertyType.Numeric, description: "Total amount of items in PDS")
    }

    "/pdp/sellers/buy_action"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        reputation_level(required: false, type: PropertyType.String, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"], description: "Seller's reputation level")
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        pdp_type(required: false, type: PropertyType.String, inheritable: false, values: ["NO_STOCK","RED", "GREEN_WITH_OFFER", "GREEN_NO_OFFER", "YELLOW_WITH_OFFER", "YELLOW_NO_OFFER"], description: "Indicates the type of pdp")
    }

    "/pdp/sellers/add_to_cart_action"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        reputation_level(required: false, type: PropertyType.String, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"], description: "Seller's reputation level")
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        pdp_type(required: false, type: PropertyType.String, inheritable: false, values: ["NO_STOCK","RED", "GREEN_WITH_OFFER", "GREEN_NO_OFFER", "YELLOW_WITH_OFFER", "YELLOW_NO_OFFER"], description: "Indicates the type of pdp")
    }

    "/pdp/alternative_buying_options" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        alternative_buying_option_info
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
    }

    "/pdp/alternative_buying_options/buy_action" (platform: "/"){}

    "/pdp/alternative_buying_options/add_to_cart_action" (platform: "/"){}

    "/pdp/onboarding_catalog" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
    }

    "/pdp/onboarding_catalog/close" (platform: "/"){}

    "/pdp/onboarding_catalog/show" (platform: "/"){
        referer(required: true, type: PropertyType.String, values: ["onboarding", "tag", ""], description: "Onboarding catalog modal referer")
    }

    "/pdp/catalog_tag_click" (platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
    }

    "/pdp/public_similar_intention" (platform: "/web/desktop", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        domain_id(required: true, type: PropertyType.String, description: "Item's domain ID")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        vertical(required: false, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
    }

    //Stock modal
    "/pdp/questions/ask" (parentPropertiesInherited: false, isAbstract : true) {}

    "/pdp/questions/ask/prevent_stock" (platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    //Server Side
    "/pdp/backend"(platform: "/", isAbstract : true) {}

    "/pdp/backend/questions_redirect"(platform: "/", parentPropertiesInherited: false) {
    }

    "/pdp/fulfillment_modal" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {}

    "/pdp/fulfillment_modal/show"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: true, type: PropertyType.Numeric)
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
    }

    "/pdp/fulfillment_fs_modal/show"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: true, type: PropertyType.Numeric)
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
    }

    "/pdp/cbt_modal" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {}

    "/pdp/cbt_modal/show"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: true, type: PropertyType.Numeric)
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")

    }

    "/pdp/fulfillment_tooltip" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
    }

    "/pdp/fulfillment_tooltip/show"(platform: "/") {}

    "/pdp/fulfillment_tooltip/close"(platform: "/", type: TrackType.Event) {}

    "/pdp/fulfillment_fs_modal" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {}

    "/pdp/fulfillment_fs_tooltip" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
    }

    "/pdp/fulfillment_fs_tooltip/show"(platform: "/") {}

    "/pdp/fulfillment_fs_tooltip/close"(platform: "/", type: TrackType.Event) {}

    "/pdp/credits_tooltip" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
    }

    "/pdp/credits_tooltip/show"(platform: "/", type: TrackType.Event) {}

    "/pdp/credits_tooltip/close"(platform: "/", type: TrackType.Event) {}

    "/pdp/pricing_rebates"(platform: "/", isAbstract: true) {}
    "/pdp/pricing_rebates/modal_payments_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        is_cash_price(required: true, type: PropertyType.Boolean, description: "Indicates if it is an offer with rebate discount")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        installments_value_total(required:true, type: PropertyType.Numeric, description: "The final price with installments in payment method")
        installments_value_each(required:true, type: PropertyType.Numeric, description: "The price of each installment in payment method")
        installments_amount(required:true, type: PropertyType.Numeric, description: "The amount of installments in payment method")
        is_free_installments(required: true, type: PropertyType.Boolean, description: "Indicates if installments are without interest in payment method")
    }

    "/pdp/advertising"(platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        advertising_id(required: true, type: PropertyType.String, description: "Indica el identificador del banner")
        is_component_tracker(required: false, type: PropertyType.String, description: "Indica si el componente es el backup track")
        item_id(required: false, type: PropertyType.String, description: "Indica el identificador del item")
   }

    "/pdp/technical_specs"(platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        is_highlighted(required: true, type: PropertyType.Boolean, description: "If the layout displayed is highlighted")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        seller_id(required: false, type: PropertyType.Numeric, description: "The Id of the seller")
        category_path(required: false, type: PropertyType.ArrayList, description: "Category path of the the item")
    }

    "/pdp/technical_specs/show"(platform: "/", parentPropertiesInherited: true) {
    }

    "/pdp/technical_specs/view_more"(platform: "/", parentPropertiesInherited: true) {
    }

    "/pdp/technical_specs_features"(platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        is_highlighted(required: true, type: PropertyType.Boolean, description: "If the layout displayed is highlighted")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        seller_id(required: false, type: PropertyType.Numeric, description: "The Id of the seller")
        category_path(required: false, type: PropertyType.ArrayList, description: "Category path of the the item")
    }

    "/pdp/technical_specs_features/view_more"(platform: "/", parentPropertiesInherited: true) {
    }

    "/pdp/html_description"(platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
    }

    "/pdp/html_description/show"(platform: "/", parentPropertiesInherited: true) {
    }

    "/pdp/html_description/view_all_action"(platform: "/", parentPropertiesInherited: true) {
    }

    "/pdp/vertical_gallery"(platform: "/", parentPropertiesInherited: false, isAbstract: true) {
    }

    "/pdp/vertical_gallery/show"(platform: "/", parentPropertiesInherited: true) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
    }

    "/pdp/back_to_top"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
    }

    "/pdp/back_to_top/top"(platform: "/", type: TrackType.Event, parentPropertiesInherited: true) {}
}
