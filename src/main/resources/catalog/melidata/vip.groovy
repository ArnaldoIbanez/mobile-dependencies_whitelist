package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1171"

    def qadb_info_definition = objectSchemaDefinitions {
        results(required:false, type: PropertyType.ArrayList(PropertyType.Map(question_result)), description: "Initial results")
    }

    Object attributes_values_map = objectSchemaDefinitions {
        attribute_id(type: PropertyType.String, required: true, description: "Attribute id")
        value_id(type: PropertyType.String, required: false, description: "Attribute value_id")
        value_name(type: PropertyType.String, required: true, description: "Attribute value_name")
    }

    Object available_promotions_map = objectSchemaDefinitions {
        campaign_id(required: true, type: PropertyType.String, description: "Promotion campaign id")
        type(required: true, type: PropertyType.String, description: "Promotion campaign type")
        original_value(required: true, type: PropertyType.Numeric, description: "Promotion campaign item original value")
        value(required: true, type: PropertyType.Numeric, description: "Promotion campaign item value")
    }


    propertyDefinitions {
        // TODO, podemos hacerlo required? Hay casos donde un item no tengan price?
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        cart_content(required: false, type: PropertyType.Boolean,
                description: "Indicates if the VIP has cart features (only for core items)")
        add_to_cart_availability(required: false, type: PropertyType.String, values: ["yes_default", "yes_discount", "yes_fs", "no_high_ratio", "no_too_many_items", "no_item_price_too_low"],
                description: "Indicates which add_to_cart button the VIP is showing (Default, Discount, Free Shipping). In case it doesn't show it, also indicates the reason why it doesn't show it (High Ratio, Item price too low, Too many items in cart)")
        main_action(required: false, type: PropertyType.String, values: ["buy", "a2c_fs", "a2c_discount", "a2c_default"],
                description: "Indicates which button the VIP is showing as main_action (ie, shown as blue button). If it is a2c, it then specifies which button type (default, fs, discount)")

        // SHIPPING_FIELDS (NOT PRESENT IN CLASI)
        shipping_preference(required: false, type: PropertyType.String,
                description: "Shipping method's name shown when the user has zipcode/location preloaded")
        shipping_mode(required: false, type: PropertyType.String, values: ["not_specified", "custom", "me1", "me2"],
                description: "Mercado Envios mode")
        free_shipping(required: false, type: PropertyType.Boolean,
                description: "Indicates if the items has free shipping")
        local_pick_up(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has local pick up")
        logistic_type(required: false,
                values: ["not_specified", "default", "drop_off", "xd_drop_off", "custom", "cross_docking", "fulfillment", "self_service"],
                type: PropertyType.String, description: "Indicates the logistic type of the item")
        free_shipping_benefit(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has free shipping or free by loyalty")
        shipping_promise(required: false, description: "Array of shippping promise in the order with following data")
        free_shipping_benefit_lyl(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has free shipping benefit by loyalty")
        discount_shipping_benefit_lyl(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has discount benefit by loyalty")

        // VARIATION FIELDS
        preselection_type(required: false, type: PropertyType.String, values: ["none", "parcial", "full"], description: "Indicates the variation preselection type for this instance of the VIP")
        enforced_preselection(required: false, type: PropertyType.String, values: ["search", "cart", "gallery", "stock"], description: "Indicates the type of enforced variation preselection for this instance of the VIP")

        // PRICING 2.0
        available_promotions(required: false, type: PropertyType.ArrayList(PropertyType.Map(available_promotions_map)),
                description: "Lists the available promotions for the item")
        discount_reasons(required: false, type: PropertyType.ArrayList, description: "The discounts applied to this item original_price, to finally show price (loyalty, deal)")

        //afterDispatch: if unknown or unknown_frame (true/false)
        //min_days: minimum number of days of the promise. (int)
        //max_days: maximun number of days of the promise. (int or null -If it doesn´t apply-)
        //price: {amount, currency_id, is_loyalty_discount}
        //destination: zipcode | city/state
    }

    propertyGroups {
        add_cart_info(cart_content, add_to_cart_availability, main_action)
        shipping_info(shipping_preference, shipping_mode, free_shipping, local_pick_up,
                logistic_type, free_shipping_benefit, shipping_promise, free_shipping_benefit_lyl, discount_shipping_benefit_lyl)
        variation_info(preselection_type, enforced_preselection)
        pricing_info(available_promotions, discount_reasons, price, original_price, currency_id)
    }

    def highlights_definition  = objectSchemaDefinitions {
        id(required: false, type: PropertyType.String, description: "Id of the highlight")
        best_seller_position(required: false, type: PropertyType.Numeric, description: "Position of Best Seller Product")
        melichoice_score(required: false, type: PropertyType.Numeric, description: "Score of Melichoice Product")
        melichoice_origin(required: false, type: PropertyType.String, description: "Origin of Melichoice Product")
        melichoice_domain(required: false, type: PropertyType.String, description: "Domain of Melichoice Product")
    }

    def apparel_definition = objectSchemaDefinitions {
        has_size_chart(required: false, type: PropertyType.Boolean, description: "Indicates whether the item has size chart")
    }

    //VIP FLOW

    "/vip"(platform: "/") {
        // TEMP FIELDS
        best_seller_position(required: false, type: PropertyType.Numeric, description: "Position of Best Seller Item")

        cac_item(required: false, type: PropertyType.Boolean,
                 description: "Indicates whether the item is listed as 'CodoACodo'")

        cac_status(required: false, type: PropertyType.String,
                values: ["normal", "after_dispatch", "unknown"],
                description: "Indicates items status of Elbow to Elbow (Codo a Codo) initiative")

        // ITEM FIELDS
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_path(required: true, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        deal_ids(required: true, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        billboard_clicked_position(required: false, type: PropertyType.String, description: "Clicked billboard index. We use it to track when the user entered to VIP via Billboard")
        has_technical_specification(required: false, type: PropertyType.Boolean, description: "Indicates if the item has technical specifications")
        catalog_listing(required: true, inheritable: false, type: PropertyType.Boolean, description: "Item's catalog listing")
        domain_id(required: false, type: PropertyType.String, description: "Item's domain id")
        city(required: false, type: PropertyType.String, description: "Item location's city name, 'none' if unavailable")
        neighborhood(required: false, type: PropertyType.String, description: "Item location's neighborhood name, 'none' if unavailable")
        state(required: false, type: PropertyType.String, description: "Item location's state name, 'none' if unavailable")

        // ONLY CORE FIELDS
        quantity( required: false, type: PropertyType.Numeric, description: "Available items quantity show at this vip")

        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
        reviews_attributes(required: false, type: PropertyType.ArrayList, inheritable: false, description: "Reviewable catalog attribute names")
        return_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has free return for the item")
        has_variations(required: false, type: PropertyType.Boolean, description: "Indicates if the item has variations")
        attribute_combinations(required: false, type: PropertyType.Numeric, description: "Indicates the amount of variation pickers an item has")
        attributes_quantities(required: false, type: PropertyType.ArrayList, description: "Indicates the amount of values of each variation")
        stock_type(required: false, type: PropertyType.String, inheritable: false, values: ["normal", "deferred"], description: "Indicates the type of stock for the product (normal = immediate stock, deferred = within x days)")
        stock_deferred_time(required: false, type: PropertyType.Numeric, inheritable: false, description: "Amount of days when the product will have available stock. Will only be used when stock_type = deferred")

        // CART
        add_cart_info

        has_credit_available(required: false, type: PropertyType.Boolean,
                           description: "Indicates if the user has a credit available for the current item")

        //SELLER FIELDS
        seller_id(required: true, type: PropertyType.Numeric)
        seller_type(required: false, type: PropertyType.String, description: "Seller type: normal, real_estate_user, etc")
        power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                description: "Seller's Mercado Lider level")
        reputation_level(required: false, type: PropertyType.String,
                values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green", "none"],
                description: "Seller's reputation level")

        // VIS FIELDS
        reservation_price(required: false, description: "Price of the reservation")
        quotation_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item can be quoted (cotizado)")
        quotation_limit_reached(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user can not quote the item because he reached the maximum quotations")
        comparator_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if clasi item has model comparator available")
        gallery_pattern(required: false, type: PropertyType.String,
                description: "String in which each char indicates if the image's maxSize is bigger than the " +
                        "double of the gallery size ('X'), smaller than the double but bigger than de gallery size ('Y'), " +
                        "or smaller than the gallery size ('Z')")
        price_comparison_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has price comparison available")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
        catalog_market_price(required: false, type: PropertyType.Numeric,
                description: "Price of item according the market, for example FIPE in MLB")
        price_comparison_position(required: false, type: PropertyType.Numeric,
                description: "Indicates position price comparison")
        has_seller_level_kyc(required: false, type: PropertyType.Boolean,
                description: "Indicates if seller has checked by kyc in level 5 or above")
        points_interest_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has points of interest available")
        available_consumer_credit(required: false, type: PropertyType.Boolean, description: "Indicates if the item has a credit available for the item's seller")
        bank(
                required: false,
                type: PropertyType.String,
                description: "bank identifier in vis items with available credits",
                values: [
                        "Amicar",
                        "Autofin",
                        "Banco do Brasil",
                        "Bbva",
                        "Bradesco",
                        "Caixa",
                        "Credihome",
                        "Credimejora",
                        "Creditel",
                        "Daycoval",
                        "Finaer",
                        "Itau",
                        "not specified",
                        "null",
                        "Santander",
                        "Scotiabank",
                        "Votorantim",
                ]
        )

        // OFFICIAL_STORES
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        store_type(required: false, type: PropertyType.String, values: ["normal", "brand"], description: "Indicates store type")

        // PAYMENT
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")

        //QADB
        qadb_info(required: false, type: PropertyType.Map(qadb_info_definition), description: "Tracking info for QADB component.")

        // SHIPPING
        shipping_info

        // USER FIELD
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")

        // SUBSCRIPTIONS (ONLY CORE)
        available_subscriptions(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has available subscriptions")
        subscription_discount(required: false, type: PropertyType.Numeric,
                description: "The value of the discount when the user subscribes to the item")
        default_tab(required: false, type: PropertyType.String, values: ["buy", "subscription"],
                description: "Indicates if the 'buy' tab or the 'subscription' tab is shown by default in the short description")

        // TOOLTIPS
        shown_tooltip(required: false, type: PropertyType.String,
                      description: "Indicates which tooltip is shown in the VIP at the time, if any. In case it does not show anything, it should be 'none'. E.g: 'credits', 'subscription', 'cart_benefit_free_shipping', etc.")

        whatsapp_available(required: false, type: PropertyType.String, description: "determines if whatsapp is available")
        video_type(required: false, type: PropertyType.String, values: ["TOUR360", "VIDEO", "NONE"], description: "determines the video type of the item")
        quote_demand_available(required: false, type: PropertyType.Boolean, description: "determines if an item has quote demand available")
        new_wording_free(required: false, type: PropertyType.Boolean, description: "determines if the new free wording is available" )

        // PUBLI FIELDS
        tracking_id(required: false, description: "UUID for each page print", PropertyType.String)

        quantity_models(required: false, type: PropertyType.Numeric, description: "Quantity models real estate developments")

        // ITEM_ATTRIBUTES
        item_attributes(required: false, type: PropertyType.String, description: "attributes of the item: discount, promotion, stock, cbt type")

        original_item(required: false, type: PropertyType.Boolean , description:  "Indicates if it is an original item")

        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")

        map_item_attributes(required: false, type: PropertyType.ArrayList(PropertyType.Map(attributes_values_map)), description: "Map of items attributes")


        // Highlights
        best_seller_position(required: false, type: PropertyType.Numeric, description: "Position of Best Seller Product")

        highlights(required: false, type: PropertyType.Map(highlights_definition), description: "Highlights Map")

        // PRICING 2.0
        pricing_info
        description_type(required: false, description: "Description type: plain text, html, both, none",
                values: ["plain_text", "html", "both", "none"])

        // Apparel
        apparel(required: false, type: PropertyType.Map(apparel_definition), description: "Apparel tracks")
    }

    "/vip"(platform: "/web") {
        specifications_size(required: false, type: PropertyType.Numeric, description: "Specifications attributes quantity")
        max_size_gallery(required: false, type: PropertyType.String, description: "Max_size of first picture gallery")
        contract_available(required: false, type: PropertyType.Boolean)
        gallery_dimension(required: false, type: PropertyType.String, values: ["wide", "square", "artsinfoto"],
                description: "Indicates the gallery dimension format")
    }

    "/vip"(platform: "/mobile") {
        context(required: false)
        resolution(required: false, description: "Indicates if the device has high or low resolution")
        whatsapp_installed(required: false, type: PropertyType.Boolean, description: "determines if whatsapp is installed on the device")
        contract_available(required: false, type: PropertyType.Boolean)
    }

    "/vip/profile_intention"(platform: "/", type: TrackType.Event) {
        context(required: false, type: PropertyType.String, values: ["/vip"], description: "Indicates where the page was opened from")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        buying_mode(required: false, type: PropertyType.String, description: "Indicates if it's an auction, buy_it_now or classified")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item id")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        catalog_listing(required: false, PropertyType.Boolean, description: "Item is catalog_listing or not")
        review_rate(required: false, type: PropertyType.Numeric, description: "The rating average of the reviews")
        source(required: false, type: PropertyType.String, description: "Indicate from which component within VIP comes the event")
    }

    "/vip/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/vip/price_comparison"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_path(required: true, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        deal_ids(required: true, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        seller_id(required: false, type: PropertyType.Numeric)
        contract_available(required: false, type: PropertyType.Boolean)
        comparator_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if clasi item has model comparator available")
        gallery_pattern(required: false, type: PropertyType.String,
                description: "String in which each char indicates if the image's maxSize is bigger than the " +
                        "double of the gallery size ('X'), smaller than the double but bigger than de gallery size ('Y'), " +
                        "or smaller than the gallery size ('Z')")
        price_comparison_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has price comparison available")
        price_comparison_position(required: false, type: PropertyType.Numeric,
                description: "Indicates position price comparison")
        description_type(required: false, description: "Description type: plain text, html, both, none",
                values: ["plain_text", "html", "both", "none"])
    }

    "/vip/failure"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String,
                description: "Item ID")
        error_message()
    }

    "/vip/back"(platform: "/mobile", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        buying_mode(required: false, type: PropertyType.String, description: "Indicates if it's an auction, buy_it_now or classified")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: false, type: PropertyType.String, description: "Vertical of the item")
        item_condition(required: false, type: PropertyType.String, description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String, description: "Listing type of the item")
        item_status(required: false, type: PropertyType.String, description: "Whenever the items is active, closed or paused")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        billboard_clicked_position(required: false, type: PropertyType.String, description: "Clicked billboard index. We use it to track when the user entered to VIP via Billboard")
        seller_id(required: false, type: PropertyType.Numeric)
        review_rate(required: false, type: PropertyType.Numeric, description: "The rating average of the reviews")
        reviews_attributes(required: false, type: PropertyType.ArrayList, description: "Reviewable catalog attribute names")
    }

    "/vip/quantity_change"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        zip_code(required: false,  PropertyType.Numeric, description: "Indicates the buyer's zip_code")
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of this item that the user is trying to buy")
        shipping_method(required: false)
        has_shipping(requered: true,type: PropertyType.Boolean)
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/buy_action"(platform: "/", parentPropertiesInherited: false) {
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        quantity(required: false, type: PropertyType.Numeric, description: "Quantity of this item that the user is trying to buy")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        is_valid_variation(required: false, type: PropertyType.Boolean, description: "Is the selected variation valid")
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
        vertical(required: false, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        return_available(required: false, type: PropertyType.Boolean, description: "Indicates if the user has free return for the item")
        has_technical_specification(required: false, type: PropertyType.Boolean, description: "Indicates if the item has technical specifications")
        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        reputation_level(required: false, type: PropertyType.String, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green", "none"], description: "Seller's reputation level")
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")
        has_variations(required: false, type: PropertyType.Boolean, description: "Indicates if the item has variations")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                description: "Seller's Mercado Lider level")
        add_cart_info
        shipping_info
        credits_opensea(required: false, type: PropertyType.Boolean, description: "Indicates that it was initiated by the purchase from Credits Open Sea")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
        attribute_combinations(required: false, type: PropertyType.Numeric, description: "Indicates the amount of variation pickers an item has")
        pricing_info
    }

    "/vip/buy_action"(platform: "/web", parentPropertiesInherited: false) {
        shipping_pay_before(required: false, type: PropertyType.Boolean, description: "Indicates if the shipping option selected has pay before")
        variation_info
    }

    "/vip/add_cart_action"(platform: "/", parentPropertiesInherited: false) {
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        quantity(required: false, type: PropertyType.Numeric, description: "Quantity of this item that the user is trying to a2c")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        is_valid_variation(required: false, type: PropertyType.Boolean, description: "Is the selected variation valid")
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
        vertical(required: false, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        return_available(required: false, type: PropertyType.Boolean, description: "Indicates if the user has free return for the item")
        has_technical_specification(required: false, type: PropertyType.Boolean, description: "Indicates if the item has technical specifications")
        review_rate(required: false, type: PropertyType.Numeric, inheritable: false, description: "The rating average of the reviews")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        reputation_level(required: false, type: PropertyType.String, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green", "none"], description: "Seller's reputation level")
        installment_info(required: false, type: PropertyType.String, description: "Indicates the amount of installments and if they are free or not")
        has_variations(required: false, type: PropertyType.Boolean, description: "Indicates if the item has variations")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                description: "Seller's Mercado Lider level")
        attribute_combinations(required: false, type: PropertyType.Numeric, description: "Indicates the amount of variation pickers an item has")
        credits_opensea(required: false, type: PropertyType.Boolean, description: "Indicates that it was initiated by the purchase from Credits Open Sea")
        add_cart_info
        shipping_info
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
        pricing_info
    }

    "/vip/add_cart_action"(platform: "/web", parentPropertiesInherited: false) {
        shipping_pay_before(required: false, type: PropertyType.Boolean, description: "Indicates if the shipping option selected has pay before")
        variation_info
    }

    "/vip/input_zip_code"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {}

    "/vip/input_zip_code/dont_know_my_zip_code"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {}

    "/vip/seller_reputation"(platform: "/mobile", parentPropertiesInherited: false) {}

    "/vip/seller_reputation/ratings"(platform: "/mobile") {}

    "/vip/color_and_size"(platform: "/mobile") {}

    "/vip/item_gallery"(platform: "/mobile", parentPropertiesInherited: false) {
        context(required: false)
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/sizechart"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {
         item_id(required: true, type: PropertyType.String, description: "Item ID")
         referer(required: false, type: PropertyType.String, description: "Size chart referer")
    }

    "/vip/sizechart/tutorial"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {
         item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/sizechart/preview"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {
         item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/apparel"(platform: "/", parentPropertiesInherited: false, isAbstract:true) {}

    "/vip/apparel/fit_as_expected"(platform: "/", parentPropertiesInherited: false, isAbstract:true) {}

    "/vip/apparel/fit_as_expected/open"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/apparel/size_chart_preview"(platform: "/", parentPropertiesInherited: false, isAbstract:true) {}

    "/vip/apparel/size_chart_preview/show"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {}

    "/vip/item_gallery/back"(platform: "/mobile") {}

    "/vip/video_focus"(platform: "/web", type: TrackType.Event) {
        catalog_listing(required: false, type: PropertyType.Boolean, description: "Item's catalog listing. it will be true when comes from VPP")
        contract_available(required: false, type: PropertyType.Boolean)
        description_type(required: false, description: "Description type: plain text, html, both, none",
                values: ["plain_text", "html", "both", "none"])
        video_type(required: true, type: PropertyType.String, values: ["TOUR360", "VIDEO", "NONE"],
                description: "Video type of the item"
            )
        item_seller_type(required: false, type: PropertyType.String, values: ["car_dealer", "normal", "real_estate_agency", "branch", "franchise", "brand"],
                description: "Seller type: normal, car_dealer, etc")
    }

    "/vip/video_focus"(platform: "/mobile", parentPropertiesInherited: false) {
        video_type(required: true, type: PropertyType.String, values: ["TOUR360", "VIDEO"],
                description: "Video type of the item"
            )
        item_seller_type(required: false, type: PropertyType.String, values: ["car_dealer", "normal", "real_estate_agency", "branch", "franchise", "brand"],
                description: "Seller type: normal, car_dealer, etc")
    }

    "/vip/contact_seller"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String,
                description: "Item's category ID"
        )
        item_id(required: true, type: PropertyType.String,
                description: "Item ID"
        )
        from_view(required: false, type: PropertyType.String,
                values: ["vip", "description", "technicalSpecs", "form", "unitsAvailable", "vipUnitsAvailable", ""],
                description: "Section where it's coming from"
        )
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        source(required: false, description: "Source of the referred")
        unregistered_contact(required: false, type: PropertyType.Boolean, "User is unregister type")
        captcha_showed(required: false, type: PropertyType.Boolean, description: "If captcha is showed")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
        failed( required: false, type: PropertyType.Boolean, description: "whenever the post was successful or not")
    }

    "/vip/call_seller"(platform: "/", type: TrackType.Event) {
        category_id(required: true, type: PropertyType.String, description: "Item's category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        vertical(required: true, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        event_source(required: true, type: PropertyType.String, description: "source of the event", values: ["button", "link", "modal"])
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        catalog_listing(required: false, PropertyType.Boolean, description: "Item is catalog_listing or not")
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/contact_whatsapp"(platform: "/web", type: TrackType.Event) {
        category_id(required: true, type: PropertyType.String, description: "Item's category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        vertical(required: true, description: "Vertical name over show phone event is displayed")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        event_source(required: true, type: PropertyType.String, description: "source of the event", values: ["button", "link", "modal"])
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        catalog_listing(required: true, PropertyType.Boolean, description: "Item is catalog_listing or not")
        source(required: true,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/contact_whatsapp"(platform: "/mobile", type: TrackType.Event) {
        catalog_listing(required: false, PropertyType.Boolean, description: "Item is catalog_listing or not")
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        event_source(required: false, type: PropertyType.String, description: "source of the event", values: ["button", "link", "modal"])
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/call_seller_intention"(platform: "/", type: TrackType.Event) {
        category_id(required: true, type: PropertyType.String, description: "Item's category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        vertical(required: true, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        event_source(required: true, type: PropertyType.String, description: "source of the event", values: ["button", "link", "modal"])
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        catalog_listing(required: false, PropertyType.Boolean, description: "Item is catalog_listing or not")
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/contact_whatsapp_intention"(platform: "/", type: TrackType.Event) {
        category_id(required: true, type: PropertyType.String, description: "Item's category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        vertical(required: true, description: "Vertical name over show phone event is displayed")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        event_source(required: true, type: PropertyType.String, description: "source of the event", values: ["button", "link", "modal"])
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        catalog_listing(required: false, PropertyType.Boolean, description: "Item is catalog_listing or not")
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/show_phone_intention"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String, description: "Item's category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        catalog_listing(required: false, type: PropertyType.Boolean, description: "Item's catalog listing. it will be true when comes from VPP")
    }

    "/vip/show_phone"(platform: "/", type: TrackType.Event) {
        category_id(required: false, type: PropertyType.String, description: "Item's category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        catalog_listing(required: false, type: PropertyType.Boolean, description: "Item's catalog listing. it will be true when comes from VPP")
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/coordinate_availability"(platform: "/mobile", type: TrackType.Event) {
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
        deal_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "IDs of applied discounts")
        from_view(required: false, type: PropertyType.String,
                values: ["vip", "description", "technicalSpecs", "form", "howToContract", "reputation"],
                description: "Section where it's coming from"
        )
        catalog_listing(
                required: false,
                type: PropertyType.Boolean,
                description: "Item's catalog listing"
        )
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
    }

    "/vip/coordinate_intention"(platform: "/web", type: TrackType.Event) {
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        catalog_listing(
                required: false,
                type: PropertyType.Boolean,
                description: "Item's catalog listing"
        )
    }

    "/vip/contract_intention"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        buying_mode(required: true, type: PropertyType.String, values: ["classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        from_view(required: true, type: PropertyType.String,
                values: ["vip", "description", "technicalSpecs", "form", "howToContract", "reputation"],
                description: "Section where it's coming from"
        )
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
        item_status(required: true, type: PropertyType.String, description: "Whenever the items is active, closed or paused")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        seller_id(required: true, type: PropertyType.Numeric)
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")

    }
    "/vip/contract_intention"(platform: "/web", type: TrackType.Event) {
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        catalog_listing(
                required: false,
                type: PropertyType.Boolean,
                description: "Item's catalog listing"
        )
    }

    "/vip/similar_vehicles"(platform: "/", type: TrackType.Event) {
        item_seller_type(required: false, description: "Seller type: normal, car_dealer, etc")
    }

    "/vip/map/"(platform: "/mobile") {}

    "/vip/payment_method"(platform: "/mobile", parentPropertiesInherited: false) {}

    "/vip/payment_method/back"(platform: "/mobile", parentPropertiesInherited: false) {}

    "/payment_methods"(platform: "/", type: TrackType.View, isAbstract: true) {}

    "/payment_methods/show"(platform: "/", type: TrackType.View) {
        item_id(required: true, type: PropertyType.String,
                description: "Item ID")
        context(required: true, type: PropertyType.String, values: ["pdp", "vip"], description: "Context in where the payments modal is used")
    }

    "/vip/variations"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String,
                description: "Item ID")
        category_id(required: false, type: PropertyType.String,
                description: "Item's category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
    }

    "/vip/picker_selection"(platform: "/", parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        picker_id(required: true, type: PropertyType.String, description: "Item's picker ID")
        attribute_id(required: true, type: PropertyType.String, description: "The attribute ID")
    }

    "/vip/variations/back"(platform: "/mobile") {}

    "/vip/protected_purchase"(platform: "/web/mobile", type: TrackType.Event, isAbstract: true) {}

    "/vip/protected_purchase/show"(platform: "/web/mobile", type: TrackType.Event) {}

    "/vip/protected_purchase/close"(platform: "/web/mobile", type: TrackType.Event) {}

    "/vip/quantity"(platform: "/mobile", parentPropertiesInherited: false) {
         item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/show_sizechart_reviews"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/reviews"(platform: "/", type: TrackType.View) {
        show(required: false, inheritable: false, type: PropertyType.String)
    }

    "/vip/item"(parentPropertiesInherited: false, isAbstract: true) {}

    "/vip/item/free_return"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/item/mercado_credits_modal"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    //  QUESTION

    "/vip/question"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String,
                description: "Item ID")
        category_id(required: false, type: PropertyType.String,
                description: "Category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: false, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"],
                description: "Vertical of the item")
        unregistered_contact(required: false, type: PropertyType.Boolean,
                description: "User is unregister type")
        unregistered_contact_context(required: false, type: PropertyType.Boolean,
                description: "User is unregister after returning from email")
        event_source(required: false, type: PropertyType.String,
                values: ["vip", "technicalSpecs", "description"],
                description: "source of the event")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
    }

    "/vip/questions"(parentPropertiesInherited: false, isAbstract: true){

    }

    "/vip/questions/show"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String)
        catalog_product_id(required: false, type: PropertyType.String)
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
    }

    "/vip/questions/quick_access"(platform: "/", parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        type(required: true, type: PropertyType.String,values: ["payment", "returns", "shipping", "warranty", "credits"], description: "quick access type")
        domain_id(required: true, type: PropertyType.String, description: "Product's domain id")
        context(required: true, type: PropertyType.String, description: "Indicates if is qadb or questions", values:["/qadb","/questions"])
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/qadb"(parentPropertiesInherited: false, isAbstract: true) {}

    "/vip/qadb/call-to-action"(platform: "/", parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID in case of having a PDP with BBW")
    }

    "/vip/question_intention"(platform: "/", type: TrackType.Event) {
        unregistered_contact(required: true, type: PropertyType.Boolean,
                description: "User is unregister type")
        unregistered_contact_context(required: true, type: PropertyType.Boolean,
                description: "User is unregister after returning from email")
        event_source(required: true, type: PropertyType.String,
                values: ["vip", "technicalSpecs", "description", "button"],
                description: "source of the event")
        source(required: false, description: "Source of the referred")
        item_seller_type(required: false, type: PropertyType.String,
                description: "Seller type: normal, real_estate_user, etc"
        )
        catalog_listing(required: false, type: PropertyType.Boolean, description: "Item's catalog listing. it will be true when comes from VPP")
    }

    "/vip/captcha_showed"(platform: "/web", type: TrackType.Event) {
    }

    "/vip/question/ask"(platform: "/web", type: TrackType.Event, isAbstract: true) {}

    "/vip/question/ask/prevent_stock"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true)
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }


    // Environment Information

    "/vip/comparator_price"(platform: "/web", type: TrackType.View, isAbstract: true) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        price_comparison_available(required: true, type: PropertyType.Boolean,
                description: "Indicates if the item has price comparison available")
    }

    "/vip/comparator_price/similar_properties"(platform: "/web", type: TrackType.Event) {}

    "/vip/comparator_price/info_tooltip"(platform: "/web", type: TrackType.Event) {}


    "/vip/comparator_price/interactive_bin"(platform: "/web", type: TrackType.View, isAbstract: true) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        price_comparison_available(required: true, type: PropertyType.Boolean,
                description: "Indicates if the item has price comparison available")
    }

    "/vip/comparator_price/interactive_bin/tooltip"(platform: "/web", type: TrackType.Event) {}

    "/vip/comparator_price/interactive_bin/bar"(platform: "/web", type: TrackType.Event) {}

    "/vip/points_of_interest"(platform: "/web", type: TrackType.View, isAbstract: true) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        points_interest_available(required: true, type: PropertyType.Boolean,
                description: "Indicates if the item has points of interest available")
        item_seller_type(required: false, values: ['normal', 'real_estate_agency'], description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/points_of_interest/transport"(platform: "/web", type: TrackType.Event) {}
    "/vip/points_of_interest/education"(platform: "/web", type: TrackType.Event) {}
    "/vip/points_of_interest/leisure"(platform: "/web", type: TrackType.Event) {}
    "/vip/points_of_interest/commerce"(platform: "/web", type: TrackType.Event) {}
    "/vip/points_of_interest/health"(platform: "/web", type: TrackType.Event) {}
    "/vip/points_of_interest/link_map"(platform: "/web", type: TrackType.Event) {}

    //TODO chequear con mobile estos tracks
    //  DESCRIPTION

    "/vip/description"(platform: "/", parentPropertiesInherited: false, isAbstract: true, type: TrackType.View){

        //  DESCRIPTION/ATTRIBUTES
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: false, type: PropertyType.String, description: "Category ID")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: false, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"],
                description: "Vertical of the item")

        //  DESCRIPTION ONLY
        item_seller_type(required: false, type: PropertyType.String,
                description: "Seller type: normal, real_estate_user, etc"
        )
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        source(required: false, type: PropertyType.String,
                values: ["htmlView"],
                description: "Source of the refered"
        )
    }

    "/vip/show_all_description"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: false, type: PropertyType.String, description: "Category ID")
        category_path(required: false, type: PropertyType.ArrayList, description: "Category path of the the item")
        vertical(required: false, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"],
                description: "Vertical of the item")
        catalog_product_id(required: false, type: PropertyType.String)
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
    }

    "/vip/description/failure"(platform: "/mobile") {}

    "/vip/description/abort"(platform: "/mobile") {}

    "/vip/description/back"(platform: "/mobile") {}

    // ADDRESS

    "/address"(platform: "/mobile", isAbstract: true) {}

    "/address/add_address"(platform: "/mobile", type: TrackType.View) {
        context()
    }

    "/address/add_address/back"(platform: "/mobile", type: TrackType.Event) {}

    "/address/add_address/apply"(platform: "/mobile", type: TrackType.Event) {}


    // SHIPPING FLOW

    "/shipping"(platform: '/mobile', isAbstract: true, initiative: "1123") {}

    "/shipping/mercadoenvios"(platform: '/mobile', isAbstract: true) {}

    "/shipping/shipping_cost"(platform: "/mobile") {
        context()
        item_id()
    }

    "/shipping/shipping_cost/back"(platform: "/mobile", type: TrackType.Event) {}

    "/shipping/mercadoenvios/shipping_cost"(platform: "/mobile") {
        item_id()
        context()
        zip_code(required: false)
    }

    "/shipping/mercadoenvios/shipping_cost/get"(platform: "/mobile", type: TrackType.Event) {
        destination()
    }

    "/shipping/mercadoenvios/shipping_cost/apply"(platform: "/mobile", type: TrackType.Event) {
        shipping_id()
        destination()
    }

    "/shipping/mercadoenvios/shipping_cost/fail"(platform: "/mobile", type: TrackType.Event) {
    }

    //New Shipping calculator

    "/vip/shipping"(platform: "/", isAbstract: true, parentPropertiesInherited:false) {
    }

    "/vip/shipping/calculator"(platform: "/", isAbstract: true, type: TrackType.View) { //no están required ya que en mobile se manda este track pero sin parámetros
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        vertical(required: false, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"],
                description: "Vertical of the item")
    }

    "/vip/shipping/calculator/preloaded"(platform: "/web/mobile", type: TrackType.View){}

    "/vip/shipping/calculator/shipping_options"(platform: "/web/mobile", type: TrackType.View){}

    "/vip/shipping/calculator/calculate"(platform: "/", type: TrackType.Event) {
        cp_autocomplete(required: false, type: PropertyType.String,
                values: ["yes", "no"],
                description: "Indicates if the default cp was the one used for the query"
        )
    }

    "/vip/shipping/calculator/i_dont_know_my_code"(platform: "/", type: TrackType.Event) {
    }

    "/vip/shipping/calculator/calculate_error"(platform: "/", type: TrackType.Event) {
        error_type()
    }

    "/vip/shipping/calculator/agencies"(platform: "/", isAbstract: true) {
    }

    "/vip/shipping/calculator/agencies/show_agencies_map_for_pickup"(platform: "/", type: TrackType.View) {
    }

    "/vip/shipping/calculator/choose_state"(platform: "/", type: TrackType.View) {
    }

    "/vip/shipping/calculator/choose_city"(platform: "/", type: TrackType.View) {
    }

    "/vip/shipping/calculator/go_to_vip"(platform: "/", type: TrackType.Event) {
        item_id(required: true, description: "Item ID")
        item_selected_quantity(required: true)
        item_shipping_quantity(required: true)
        shipping_default(required: false)
        shipping_selected(required: true)
        shipping_available_opcion(required: true, type:PropertyType.ArrayList)
    }

    "/vip/landing_services"(platform: "/web", type: TrackType.Event) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        vertical(required: true, type: PropertyType.String,
                values: ["services"],
                description: "Vertical of the item")
    }
    "/vip/free_shipping_cart_available"(platform: "/web", parentPropertiesInherited: false, type: TrackType.Event){}

    // RESERVATION

    "/vip/reservation_onboard"(platform: "/web", type: TrackType.View) {
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/reservation_onboard/ok"(platform: "/web", type: TrackType.Event) {
    }

    "/vip/reservation_onboard/close"(platform: "/web", type: TrackType.Event) {
    }

    "/vip/reservation_information"(platform: "/web", parentPropertiesInherited: false, type: TrackType.View) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["motors"],
                description: "Vertical of the item")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/reservation_payment_options"(platform: "/web", parentPropertiesInherited: false, type: TrackType.View) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["motors"],
                description: "Vertical of the item")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/technical_specs"(platform: "/", type: TrackType.View, parentPropertiesInherited: false){
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: false, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_status(required: false, type: PropertyType.String, description: "Whenever the items is active, closed or paused")
        seller_id(required: false, type: PropertyType.Numeric)
        buying_mode(required: false, type: PropertyType.String, values: ["classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        from_view(required: false, type: PropertyType.String,
                values: ["vip", "description", "technicalSpecs", "form", "unitsAvailable", ""],
                description: "Section where it's coming from"
        )
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_seller_type(required: false, values: ['real_estate_agency'], description: "Seller type: normal, real_estate_user, etc")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
    }

    "/vip/technical_specs/show"(platform: "/", parentPropertiesInherited: true) {
    }

    "/vip/technical_specs/see_more"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_status(required: true, type: PropertyType.String, description: "Whenever the items is active, closed or paused")
        seller_id(required: false, type: PropertyType.Numeric)
        buying_mode(required: false, type: PropertyType.String, values: ["classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        deal_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "IDs of applied discounts")
        item_seller_type(required: false, values: ['car_dealer','normal', 'real_estate_agency', 'branch', 'franchise', 'brand'], description: "Seller type: normal, car_dealer, etc")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
    }

    "/vip/denounce_intention"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_status(required: true, type: PropertyType.String, description: "Whenever the items is active, closed or paused")
        seller_id(required: false, type: PropertyType.Numeric)
        buying_mode(required: false, type: PropertyType.String, values: ["classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        deal_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "IDs of applied discounts")
        item_seller_type(required: false, values: ['car_dealer'], description: "Seller type: normal, car_dealer, etc")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
    }

    "/vip/show_fulfillment_popup"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: true, type: PropertyType.Numeric)
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/show_fulfillment_tooltip"(platform: "/", parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/close_fulfillment_tooltip"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/show_fulfillment_fs_popup"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: true, type: PropertyType.Numeric)
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/show_fulfillment_fs_tooltip"(platform: "/", parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/close_fulfillment_fs_tooltip"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/shipping_calculator"(platform: "/", type: TrackType.View, parentPropertiesInherited: false){
        location(required: true, description: "User Location")
        //Location
            //type: [address | zip_code]
            //value: String
        shipping_methods(required: true,  type: PropertyType.ArrayList,description: "Shipping Methods")
    //Shipping Method
        //promise
        //  from: Integer
        //  to: Integer
        //  deferred: Bool
        //cost: Integer
        //promoted_amount: Integer
        //delivery_type: [seller_agreement|puis|delivery|post_office]
        //selected: BOOL
        item_id(required: false, type: PropertyType.String, description: "Item ID")
    }

    "/vip/shipping_calculator/select"(platform: "/", type: TrackType.Event){
        selected_method(required: true, description: "Shipping Methods")
    }

    "/vip/shipping_calculator/cancel"(platform: "/web", type: TrackType.Event){
    }
     "/vip/shipping_calculator/cancel"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false){
    }

     "/vip/shipping_calculator/show_map"(platform: "/", type: TrackType.Event){
    }

    "/vip/shipping_calculator/modify"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
    }

    Object new_shipping_calc_offset_definition = objectSchemaDefinitions {
        shipping(required: false, type: PropertyType.Numeric, description: "")
    }

    Object new_shipping_calc_estimated_delivery_time_definition  = objectSchemaDefinitions {
        type(required: true, type: PropertyType.String, description: "Promise type [known, known_frame, unknown, unknown_frame]" , values: ["known", "known_frame","unknown","unknown_frame"])
        date(required: false, type: PropertyType.String, description: "Date of the promise")
        shipping(required: false, type: PropertyType.Numeric, description: "Delivery time  component of the promise")
        handling(required: false, type: PropertyType.Numeric, description: "Handling time(dispatch) component of the promise ")
        schedule(required: false, type: PropertyType.Numeric, description: "Manufacturing time component of the promise, only if the publication have manufacturing")
        offset(required: false, type: PropertyType.Map(new_shipping_calc_offset), description: "Range offset of the promise, only if the promise type is known_frame")
        pay_before(required: false, type: PropertyType.String, description: "Define until when the promise is valid")
        time_frame(requered: false, type: PropertyType.Map, description: "")
    }

    Object new_shipping_calculator_promises_definition  = objectSchemaDefinitions {
        type(required: true, type: PropertyType.String, description: "Specify is the shipping option is delivery or store pick up")
        display(required: false, type: PropertyType.String, description: "Define the promise visibility/priority [recommended, always]")
        discount_type(required: false, type: PropertyType.String, description: "Discount type applied if it have discount ")
        free_shipping(required: true, type: PropertyType.Boolean, description: "Define is the shipping is free")
        shipping_preference(required: true, type: PropertyType.String, description: "Description of the shipping method, Standar or Mail PickUp")
        after_dispatch(required: true, type: PropertyType.Boolean, description: "If its value is 'true' when the promise doesnt have a delivery estimated time (unknown, unknown_frame).")
        min_days(required: false, type: PropertyType.Numeric, description: "Promise time component expresed on days")
        max_days(required: false, type: PropertyType.Numeric, description: "Promise time component expresed on days, it differs of min_days when the promise type is known_frame")
        list_cost(required: false, type: PropertyType.Numeric, description: "")
        cost(required: true, type: PropertyType.Numeric, description: "Shipping Cost")
        shipping_method_type(required: true, type: PropertyType.String, description: "Shipping Method expressed in days , ejample : three_days")
        estimated_delivery_time(required: true,  type: PropertyType.Map(new_shipping_calc_estimated_delivery_time),description: "Shipping Promises")
    }

    "/vip/new_shipping_calculator"(platform: "/", type: TrackType.View, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        quantity(required: true, type: PropertyType.Numeric, description: "Item quantity")
        shipping_promises(required: false, type: PropertyType.ArrayList(PropertyType.Map(new_shipping_calculator_promises)),
                description: "Shipping Promise Information")
    }

    "/vip/new_shipping_calculator/show_map"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
    }

    "/vip/new_shipping_calculator/modify"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
    }

    "/vip/new_shipping_calculator/cancel"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
    }

    "/vip/quote_demand_intention"(platform: "/", type: TrackType.Event) {
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
        deal_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "IDs of applied discounts")
        from_view(required: false, type: PropertyType.String,
                values: ["vip", "description", "technicalSpecs", "form"],
                description: "Section where it's coming from"
        )
        catalog_listing(
                required: false,
                type: PropertyType.Boolean,
                description: "Item's catalog listing"
        )
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/quote_demand_intention_lower"(platform: "/", type: TrackType.Event) {
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
        deal_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "IDs of applied discounts")
        from_view(required: false, type: PropertyType.String,
                values: ["vip", "description", "technicalSpecs", "form"],
                description: "Section where it's coming from"
        )
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/quote_demand_messages"(platform: "/", type: TrackType.Event) {
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
        deal_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "IDs of applied discounts")
        from_view(required: false, type: PropertyType.String,
                values: ["vip", "description", "technicalSpecs", "form"],
                description: "Section where it's coming from"
        )
        catalog_listing(
                required: false,
                type: PropertyType.Boolean,
                description: "Item's catalog listing"
        )
    }

    "/vip/public_similar_intention"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList , description:  "Category path of the the item")
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
        source(required: false, description: "specify the platform and the freemium text type - We are deprecating this attribute " +
                "for the new vip so we will get rid of it as soon as the old vip is turned off")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/units_available"(platform: "/", type: TrackType.View, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["realEstate"], description: "Vertical of the item")
        item_status(required: true, type: PropertyType.String, description: "Whenever the items is active, closed or paused")
        seller_id(required: true, type: PropertyType.Numeric)
        buying_mode(required: true, type: PropertyType.String, values: ["classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        from_view(required: true, type: PropertyType.String,
                values: ["vip", "description", "technicalSpecs", "form", "unitsAvailable", "vipUnitsAvailable", ""],
                description: "Section where it's coming from"
        )
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_seller_type(required: true, values: ['real_estate_agency'], description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/reservation_intention"(platform: "/", type: TrackType.Event, isAbstract: true){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, card dealer etc")
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/contact_seller/preload"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
    }

    "/vip/call_seller/preload"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/reservation_intention/preload"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/back_to_listing"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        domain_id(required: false, type: PropertyType.String, description: "Item's domain id")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/free_list_adv"(platform: "/",  type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["motors"],
                description: "Vertical of the item")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_seller_type(required: true, description: "Seller type: normal, real_estate_user, etc")
    }

    //BEGIN -  Classifieds Credits


    "/vip/classi_credits_onboard"(platform: "/", type: TrackType.View) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        catalog_listing(required: false, inheritable: true, PropertyType.Boolean, description: "Item is catalog_listing or not")
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        vip_version(required: false, type: PropertyType.String, description: "Migration state")
    }

    "/vip/classi_credits_onboard/ok"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        vip_version(required: false, type: PropertyType.String, description: "Migration state")
    }

    "/vip/classi_credits_onboard/close"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        vip_version(required: false, type: PropertyType.String, description: "Migration state")
    }

    "/vip/credits_intention"(platform: "/", type: TrackType.Event, isAbstract: true) {}
    "/vip/credits_intention/main_action"(platform: "/", type: TrackType.Event, isAbstract: true) {}

    "/vip/credits_intention/card"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
        financial_institution(required: false, type: PropertyType.String, description: "Name of the financial institution linked to card")
    }

    "/vip/credits_intention/main_action/up"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        source(required: false,  type: PropertyType.String, description: "Source of the referred")
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
    }

    "/vip/credits_intention/main_action/down"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")
        source(required: fasle,  type: PropertyType.String, description: "Source of the referred")
        from_view(required: false, type: PropertyType.String, description: "Section where it's coming from")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")
        has_highlighted_sale_specs(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has attributes highlighted sale specification")
    }

    "/vip/credits_tooltip" (platform: "/", parentPropertiesInherited: false, isAbstract: true) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/credits_tooltip/close"(platform: "/", type: TrackType.Event) {}

    "/vip/credits_tooltip/show"(platform: "/", type: TrackType.Event) {}

    //END -  Classifieds Credits

    "/vip/denounce"(platform: "/", parentPropertiesInherited: false, type: TrackType.View) {}

    "/vip/show_cbt_popup"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList, description: "Category path of the the item")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/vip/copy_seller_info"(platform: "/web/", parentPropertiesInherited: false, type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        buyer_id(required: false, type: PropertyType.String, description: "Buyer ID")
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")
        shipping_preference(required: false, type: PropertyType.String,
                description: "Shipping method's name shown when the user has zipcode/location preloaded")
        shipping_cost(required: false, type: PropertyType.Numeric, description: "Indicates shipping cost")
        shipping_method(required: false, type: PropertyType.String, description: "Shipping Method")
        free_shipping(required: false, type: PropertyType.Boolean,
                description: "Indicates if the items has free shipping")
        free_shipping_benefit(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has free shipping or free by loyalty")
        shipping_promise(required: false, description: "Array of shippping promise in the order with following data")
        free_shipping_benefit_lyl(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has free shipping benefit by loyalty")
        discount_shipping_benefit_lyl(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has discount benefit by loyalty")
        shipping_mode(required: false, type: PropertyType.String, values: ["not_specified", "custom", "me1", "me2"],
                description: "Mercado Envios mode")
    }

    //Server Side
    "/vip/backend"(platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        item_id(required: false, type: PropertyType.String, description: "Item ID")
    }

    "/vip/pricing_rebates"(platform: "/", isAbstract: true) {}
    "/vip/pricing_rebates/modal_payments_action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
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

    "/vip/advertising"(platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        advertising_id(required: true, type: PropertyType.String, description: "Indica el identificador del banner")
        item_id(required: false, type: PropertyType.String, description: "Indica el identificador del item")
        is_component_tracker(required: false, type: PropertyType.String, description: "Indica si el componente es el backup track")
    }

    "/vip/official_store"(platform: "/", isAbstract: true) {}
    "/vip/official_store/official_store_link"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        official_store_id(required: true, type: PropertyType.Numeric, description: "Link's Official store id")
    }

    "/vip/location"(platform: "/", type: TrackType.View, isAbstract: true) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_seller_type(required: false, values: ['normal', 'real_estate_agency'], description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/location/dynamic_map"(platform: "/", type: TrackType.Event) {}

    "/vip/print_file_pdf"(platform: "/", type: TrackType.Event) {
        item_seller_type(required: false, values: ['normal', 'real_estate_agency'], description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/back_to_top"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        item_id(required: true, type: PropertyType.String, description: "Item ID")
    }

    "/vip/back_to_top/top"(platform: "/", type: TrackType.Event, parentPropertiesInherited: true) {}

}
