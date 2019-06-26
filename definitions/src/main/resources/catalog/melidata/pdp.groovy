import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    def product_picker_definition = objectSchemaDefinitions {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        selected(required: true, type: PropertyType.Boolean, description: "indicates if the product picker is selected or not")
        disabled(required: true, type: PropertyType.Boolean, description: "indicates if the product picker is disabled or not")
    }
    def item_info_definition = objectSchemaDefinitions {
        item_id(required: true, type: PropertyType.String, description: "")
        price(required: false, type: PropertyType.Numeric, description: "")
        original_price(required: false, type: PropertyType.Numeric, description: "")
        currency_id(required: false, type: PropertyType.String, description: "")
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")
        item_condition(required: false, type: PropertyType.String, description: "")
        sold_quantity(required: false, type: PropertyType.Numeric, description: "")
        shipping_conditions(required: false, type: PropertyType.String, values: ["no_shipping", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                description: "Shipping conditions for product")

        //BRACH_OFFICE CONDITIONS
        bo_pick_up_conditions(required: false, type: PropertyType.String, values: ["no_bo_pick_up", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                description: "Branch office pick up conditions for product")

        //PUIS
        showing_puis(required: false, type: PropertyType.Boolean, description: "Indicates if PDP BBW is showing PUIS pickup option in pickup row")
        pushing_puis(required: false, type: PropertyType.Boolean, description: "Indicates PUIS is being pushed over branch office pickup option")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        seller_id(required: false, type: PropertyType.Numeric, description: "")
        seller_name(required: false, type: PropertyType.String, description: "")
        available_quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")
        cart_content(required: false, type: PropertyType.Boolean, description: "")
        has_full_filment(required: false, type: PropertyType.Boolean, description: "")
        logistic_type(required: false,
                values: ["not_specified", "default", "drop_off", "xd_drop_off", "custom", "cross_docking", "fulfillment"],
                type: PropertyType.String, description: "Indicates the logistic type of the item")

    }

    propertyDefinitions {
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
        shipping_conditions(required: true, type: PropertyType.String, values: ["no_shipping", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                description: "Shipping conditions for product")

        //BRACH_OFFICE CONDITIONS
        bo_pick_up_conditions(required: true, type: PropertyType.String, values: ["no_bo_pick_up", "free_mandatory", "free_loyal", "discount_mandatory", "discount_loyal", "free_special", "discount_special", "free_ratio", "discount_ratio", "free_gap", "discount_gap", "free_other", "discount_other", "no_discount"],
                description: "Branch office pick up conditions for product")

        //PUIS
        showing_puis(required: false, type: PropertyType.Boolean, description: "Indicates if PDP BBW is showing PUIS pickup option in pickup row")
        pushing_puis(required: false, type: PropertyType.Boolean, description: "Indicates PUIS is being pushed over branch office pickup option")

    }

    propertyGroups {
        add_cart_info(cart_content)
        shipping_info(shipping_mode, free_shipping, local_pick_up, store_pick_up, logistic_type, shipping_conditions)
        pickup_info(showing_puis, pushing_puis, bo_pick_up_conditions)
    }

    //VPP FLOW

    "/pdp"(platform: "/") {

        //Product fields
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog Product ID")
        catalog_parent_id(required: false, type: PropertyType.String, description: "Parent Catalog Product ID")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        //TODO: set to required true when it is fixed in products api
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        previous_catalog_product_id(required: false, type: PropertyType.String, description: "Previous Catalog Product ID")

        //picker definition
        pickers(required: true, type: PropertyType.Map(PropertyType.String, PropertyType.ArrayList(PropertyType.Map(product_picker_definition))), description: "Available pickers for the given product")

        category_path(required: false, type: PropertyType.ArrayList, description: "Category path of the the item")
        vertical(required: true, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")

        // ONLY CORE FIELDS
        quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")
        available_quantity(required: false, type: PropertyType.Numeric, description: "Available product quantity at this pdp")

        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")

        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")

        // CART
        add_cart_info

        //SELLER FIELDS
        seller_id(required: true, type: PropertyType.Numeric)
        seller_name(required: false, type: PropertyType.String, description: "The name of the seller")
        power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                description: "Seller's Mercado Lider level")
        reputation_level(required: false, type: PropertyType.String,
                values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"],
                description: "Seller's reputation level")

        // OFFICIAL_STORES
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        store_type(required: false, type: PropertyType.String, values: ["normal", "brand"], description: "Indicates store type")

        // PAYMENT
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")

        // SHIPPING
        shipping_info

        // PICKUP
        pickup_info

        // USER FIELD
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
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
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
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
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
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
        picker_disabled(required: false, type: PropertyType.Boolean, description: "Indicates if the selected picker is disabled")
    }

    "/pdp/show_picker_selection_modal"(platform: "/mobile", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        picker_id(required: false, type: PropertyType.String, description: "Product's picker ID")
        modal_type(required: false, type: PropertyType.String, description: "Variation's modal type")
    }

    "/pdp/other_buying_options"(platform: "/", parentPropertiesInherited: false) {
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
        filter(required: false, type: PropertyType.String, values: ["new", "none"], description: "Indicates filter type when going to other buying options")
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
        catalog_parent_id(required: true, type: PropertyType.String, description: "Product ID")
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        vertical(required: true, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
        pickers(required: true, type: PropertyType.Map(PropertyType.String, PropertyType.ArrayList(PropertyType.Map(product_picker_definition))), description: "Available pickers for the given product")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_info_definition)), description: "Items listed on the page")
    }

    "/pdp/sellers/quantity_change"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Catalog product id")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of the product that the user is trying to buy or add to cart")
        available_quantity(required: true, type: PropertyType.Numeric, description: "Max Available quantity for the selected product")
    }

    "/pdp/sellers/picker_selection"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String, description: "Product ID")
        picker_id(required: true, type: PropertyType.String, description: "Product's picker ID")
        picker_disabled(required: false, type: PropertyType.Boolean, description: "Indicates if the selected picker is disabled")
    }
}
