package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1029"

    def winnerData = objectSchemaDefinitions {
        winner_price(required: true, type: PropertyType.Numeric, description: "The item winner of the buy box price")
        winner_currency_id(required: true, type: PropertyType.String, description: "The item winner of the buy box currency")
        winner_premium(required: true, type: PropertyType.Boolean, description: "True if the item winner of the buy box has listing type premium")
        winner_free_shipping(required: true, type: PropertyType.Boolean, description: "True if the item winner of the buy box has free shipping")
        winner_flex(required: true, type: PropertyType.Boolean, description: "True if the item winner of the buy box has flex")
        winner_fulfillment(required: true, PropertyType.Boolean, description: "True if the item winner of the buy box has fulfillment")
    }

    def itemData = objectSchemaDefinitions {
        item_price(required: true, type: PropertyType.Numeric, description: "The item price")
        item_currency_id(required: true, type: PropertyType.String, description: "The item currency")
        item_premium(required: true, type: PropertyType.Boolean, description: "True if the item has listing type premium")
        item_free_shipping(required: true, type: PropertyType.Boolean, description: "True if the item has free shipping")
        item_flex(required: true, type: PropertyType.Boolean, description: "True if the item has flex")
        item_fulfillment(required: true, type: PropertyType.Boolean, description: "True if the item has fulfillment")
    }

    def comparisonTable = objectSchemaDefinitions {
        item_data(type: PropertyType.Map(itemData), required: true)
        winner_data(type: PropertyType.Map(winnerData), required: false)
    }

    // --------------------------------------------------------------------------------------------------------------
    //  PROMOTIONS DEFINITIONS
    // --------------------------------------------------------------------------------------------------------------

    //  ORIGINAL PROMO STRUCTURE
    def campaingStructure = objectSchemaDefinitions {
        name(type: PropertyType.String, required: false)
        identifier(type: PropertyType.String, required: false)
        start_date(type: PropertyType.String, required: false)
        finish_date(type: PropertyType.String, required: false)
        dead_line(type: PropertyType.String, required: false)
        type(type: PropertyType.String, required: false)
        status(type: PropertyType.String, required: false)
        is_active(type: PropertyType.Boolean, required: false)
        is_available(type: PropertyType.Boolean, required: false)
        applied_offer(type: PropertyType.Boolean, required: false)
    }

    def campaingOffersStructure = objectSchemaDefinitions {
        offer_mode(type: PropertyType.String, required: false)
        offer(type: PropertyType.String, required: false)
        campaign(type: PropertyType.Map(campaingStructure), required: false)
    }

    def currencyStructure = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        decimal_places(type: PropertyType.Numeric, required: true)
        symbol(type: PropertyType.String, required: true)
    }

    def promotionStructure = objectSchemaDefinitions {
        status(type: PropertyType.String, required: false)
        price(type: PropertyType.Numeric, required: false)
        start_date(type: PropertyType.String, required: false)
        finish_date(type: PropertyType.String, required: false)
        list_price(type: PropertyType.Numeric, required: true)
        prime_price(type: PropertyType.Numeric, required: false)
    }

    def valueStructure = objectSchemaDefinitions {
        number(type: PropertyType.Numeric, required: true)
        unit(type: PropertyType.String, required: true)
    }

    def saleTermStructure = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        value_id(type: PropertyType.String, required: false)
        value_struct(type: PropertyType.Map(valueStructure), required: true)
    }

    def attributeStructure = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true)
        value_id(type: PropertyType.String, required: false)
        value_name(type: PropertyType.String, required: false)
        variation_id(type: PropertyType.Numeric, required: false)
    }

    def originalPromotionStructure = objectSchemaDefinitions {
        start_date(type: PropertyType.String, required: true, description: "the local date/time when the promotion starts")
        finish_date(type: PropertyType.String, required: true, description: "the local date/time when the promotion ends")
        seller_id(type: PropertyType.Numeric, required: true, description: "the id of the seller creating the promotion")
        item_id(type: PropertyType.String, required: true, description: "the id of the item to which the promotion is associated")
        price(type: PropertyType.Numeric, required: true, description: "the price to be impacted. It matches the item's price attribute")
        list_price(type: PropertyType.Numeric, required: true, description: "the struckthrough price shown to the user. It mathces the item's original_price attribute")
        prime_price(type: PropertyType.Numeric, required: false, description: "the discounted price shown to users with a loyalty level over 3")
        status(type: PropertyType.String, required: true, description: "the status of the promotion", values: ["pending", "started"])
        type(type: PropertyType.String, required: true, description: "the type of promotion", values: ["price_discount", "lightning", "deal_of_the_day"])
        initial_orders(type: PropertyType.Numeric, required: false, description: "Optional number of orders before the promotion started")
        total_orders(type: PropertyType.Numeric, required: false, description: "Optional number of orders for the promotion")
        last_updated(type: PropertyType.String, required: true, description: "the date/time with timezone when the promotion was last modified")
        created_date(type: PropertyType.String, required: true, description: "the date/time with timezone when the promotion was created")
        involved_stock(type: PropertyType.Numeric, required: false, description: "stock pledged to be possessed at the time the promotion is starting")
        discount_delta(type: PropertyType.Numeric, required: false, description: "Tolerance used to calculate the discounted prices for candidate items")
    }

    //  FINAL PROMO STRUCTURE
    def finalPromotionStructure = objectSchemaDefinitions {
        state(type: PropertyType.String, required: false, description: "the state of the promotion. Could be null in case of error")
        site_time_offset(type: PropertyType.Numeric, required: false, description: "time difference between UTC and the site's timezone")
        start_date(type: PropertyType.String, required: true, description: "the local date/time when the promotion starts")
        finish_date(type: PropertyType.String, required: true, description: "the local date/time when the promotion ends")
        is_highlight(type: PropertyType.Boolean, required: false, description: "whether the promotion is being featured in the 'sección de ofertas' ")
        price(type: PropertyType.Numeric, required: true, description: "the price to be impacted. It matches the item's price attribute")
        prime_price(type: PropertyType.Numeric, required: false, description: "the discounted price shown to users with a loyalty level over 3")
        list_price(type: PropertyType.Numeric, required: true, description: "the struckthrough price shown to the user. It mathces the item's original_price attribute")
        error_price(type: PropertyType.String, required: false, description: "filled when there's an error creating the promotion and the error was related to the price")
        error_prime(type: PropertyType.String, required: false, description: "filled when there's an error creating the promotion and the error was related to the prime price")
        input_price(type: PropertyType.String, required: true, description: "the exact text representing the price, including money sign, decimal and thousands separators")
        input_prime_price(type: PropertyType.String, required: false, description: "the exact text representing the prime price, including money sign, decimal and thousands separators")
        type(type: PropertyType.String, required: true, description: "the type of promotion", values: ["price_discount", "lightning", "deal_of_the_day"])
        involvedStock(type: PropertyType.Numeric, required: false, description: "stock pledged to be possessed at the time the promotion is starting")
        criteria(type: PropertyType.String, required: false, description: "sent only during the creation of some promotions to indicated the criteria used by the candidates api to propose that item")
    }

    def attributes_values_map = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "Attribute id")
        value_id(type: PropertyType.String, required: false, description: "Attribute selected value")
        value_name(type: PropertyType.String, required: false, description: "Attribute custom value")
    }

    def summaryModule = objectSchemaDefinitions {
        module_id(required: true, type: PropertyType.String, description: "Id of the module")
        kind(required: true, type: PropertyType.String, description: "Kind of the render", values: ["fallback", "normal"])
    }

    def sellerCoachCard = objectSchemaDefinitions {
        type(required: true,  type: PropertyType.String, description: "Type of the card", values: ['RECOMMENDATION', 'CONTENT', 'TASK', 'ITEM'])
        key(required: true,  type: PropertyType.String, description: "Key of the card defined in the backoffice")
        page(required: false, type: PropertyType.Numeric, description: "Number of page where the card is shown")
        position(required: false, type: PropertyType.Numeric, description: "Position of the card (relative to the page)")
        item_id(required: false, type: PropertyType.String, description: "Id of the listing featured in this recommendation")
        rules_applied(required: true, type: PropertyType.String, description: "Type of rules applied to show this card", values: ['hard', 'soft', 'none'])
        with_random_order(required: true, type: PropertyType.Boolean, description: "Whether the order of the cards was randomized")
        tags(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Categories of the card (used for filtering)")
        selected_tag(required: false, type: PropertyType.String, description: "Currently selected category")
    }

    def sellerCoachTag = objectSchemaDefinitions {
        key(required: true,  type: PropertyType.String, description: "Unique identifier of the tag")
        position(required: true, type: PropertyType.Numeric, description: "Position where the tag is shown")
    }

    def picture_info_map = objectSchemaDefinitions {
        width(required: true, type: PropertyType.Numeric, description: "this property describes width of the image")
        height(required: true, type: PropertyType.Numeric, description: "this property describes height of the image")
        size(required: false, type: PropertyType.String, description: "this property describes size of the image in bytes")
        format(required: false, type: PropertyType.String, description: "this property describes format of the image")
        valid(required: true, type: PropertyType.Boolean, description: "this property describes if this picture is valid")
    }

    def optinatorNewListingProcessingDataStructure = objectSchemaDefinitions {
        item_cat_id(required: true, type: PropertyType.String, description: "Item/Variation optined ID")
        catalog_product_id(required: true, type: PropertyType.String, description: "ID of the catalog product related to the optined item/variation")
        match_type(required: true, values: ["CATALOG", "AUTO", "SELLER", "none"], type: PropertyType.String, description: "Match type of the association related to the item/variation")
        safe_match(required: true, type: PropertyType.Boolean, description: "Property that describes whether the association match is safe or not for the item/variation")
        is_eligible(required: true, type: PropertyType.Boolean, description: "Property that describes whether the item/variation is eligible or not")
        eligibility_status(required: true, type: PropertyType.String, description: "Eligibility status related to the item/variation")
        eligibility_reason(required: true, type: PropertyType.String, description: "Eligibility reason related to the item/variation")
        status(required: true, values: ["success", "enqueue", "not_enqueue", "syi_client"], type: PropertyType.String, description: "Property that describes the final state of the processing for the item/variation")
        is_already_optined(required: true, type: PropertyType.Boolean, description: "Property that describes whether the item/variation is already optined or not")
    }

    def optinatorVariationNewListingProcessingDataStructure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "ID of the processed variation")
        processing_data(required: true, type: PropertyType.Map(optinatorNewListingProcessingDataStructure), description: "Relevant processing data")
    }

    def orderStructure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.Numeric, description: "The order id")
        quantity(required: true, type: PropertyType.Numeric, description: "The selected quantity")
    }

    def packStructure = objectSchemaDefinitions {
        orders(required: true, type: PropertyType.Map(orderStructure), description: "List of orders in the pack")
    }

    def categoryStructure = objectSchemaDefinitions {
        category_id(required: true, type: PropertyType.String, description: "The category id")
        domain_id(required: false, type: PropertyType.String, description: "The category domain id")
    }

    def processingOptionStructure = objectSchemaDefinitions {
        day(required: true, type: PropertyType.String, description: "The day of the week", values: ["monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"])
        processing_time(required: true, type: PropertyType.String, description: "The processing time")
    }

    // --------------------------------------------------------------------------------------------------------------
    //  LANDING PRODUCTS STRUCTURE
    // --------------------------------------------------------------------------------------------------------------

    def productsLandingPaginStructure = objectSchemaDefinitions {
        limit(required: true, type: PropertyType.Numeric, description: "This property describes limit of pagination")
        offset(required: true, type: PropertyType.Numeric, description: "This property describes offset of pagination")
        total(required: true, type: PropertyType.Numeric, description: "This property describes total result of pagination")
    }

    def productsLandingSelectedFiltersStructure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "This property describes id of attribute")
        name(required: true, type: PropertyType.String, description: "This property describes value name of attribute")
        value_id(required: true, type: PropertyType.String, description: "This property describes value id of attribute")
        value_name(required: true, type: PropertyType.String, description: "This property describes value name of attribute")
    }

    def productsLandingRowStructure = objectSchemaDefinitions {
      catalog_product_id(required: true, type: PropertyType.String, description: "The product id")
      row_index(required: false, type: PropertyType.Numeric, description: "This property describes row index in results")
    }
    def CardItemStructure = objectSchemaDefinitions {
        item_id(required: false, type: PropertyType.String, description: "Item id to which the action is executed")
        seller_pct(required: false, type: PropertyType.Numeric, description: "percentage of discount assumed by the seller")
        meli_pct(required: false, type: PropertyType.Numeric, description: "percentage of discount assumed by meli")
        adv_pct(required: false, type: PropertyType.Numeric, description: "percentage of discount in advertising credit that is given to the seller")
    }

    //  FINAL LANDING PRODUCTS STRUCTURE

    // --------------------------------------------------------------------------------------------------------------
    //  Seller Central Verifications Structure
    // --------------------------------------------------------------------------------------------------------------

    def attributesStructure = objectSchemaDefinitions {
        attribute_id(required: true, type: PropertyType.String, description: "atribute id to verificate")
        attribute_value(required: true, type: PropertyType.String, description: "atribute value to verificate")
        attribute_name(required: false, type: PropertyType.String, description: "attribute name to verificate")
    }

    def pricesBandsStructure = objectSchemaDefinitions {
        lower_band (required:true, type: PropertyType.String, description: "Lower band from price suggestion")
        lower_limit (required:true, type: PropertyType.String, description: "lower limit band from price suggestion")
        upper_band (required:true, type: PropertyType.String, description: "Upper band from price suggestion")
        upper_limit (required:true, type: PropertyType.String, description: "Upper limit band from price suggestion")
        estimated_price (required:true, type: PropertyType.String, description: "Estimated price from price suggestion")
    }

    def syiVerificationStructure = objectSchemaDefinitions {
        identifier(required: true, type: PropertyType.String, description: "identifier to search and verificate")
        flow(required: true, type: PropertyType.String, description: "flow type is used to know which logic could be implemented to verificate")
        domain_id(required: true, type: PropertyType.String, description: "to know which category belong the identifier")
        verification_site(required: true, type: PropertyType.String, description: "to know which site belong the identifier")
        attributes(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributesStructure)), description: "attributes to verificate")
    }

    def dratStructure = objectSchemaDefinitions {
        flow_id(required: true, type: PropertyType.String, description: "flow type is used to know which logic could be implemented to verificate")
        attributes(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributesStructure)), description: "attributes to verificate")
    }

    propertyDefinitions {
        category_id(required: true, type: PropertyType.String, description: "Id for category item")
        item_id(required: true, type: PropertyType.String, description: "Id of item used to")
        seller_profile(required: false, type: PropertyType.String, description: "Type of seller")
        seller_reputation(required: false, type: PropertyType.String, description: "Reputation of the seller")
        seller_segment(required: false, type: PropertyType.String, description: "Seller segment by GMV")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        category_domain(required: false, type: PropertyType.String, description: "Item category domain")
        category_path(required: false, type: PropertyType.ArrayList, description: "Path of category")
        type(required: true, type: PropertyType.String, description: "Type of hint", values: ["info", "actionable"])
        attribute(required: true, type: PropertyType.String, description: "Id of the attribute")
        reputation_level(required: false, type: PropertyType.String, description: "user reputation level")
        item_type(required: true, type: PropertyType.String, description: "product: A PDP item, default: A marketplace item, associated_default: A marketplace item which has at least 1 variation that is associated  with a PDP item, associated_products: A PDP item associated with a marketplace item", values: ["product", "default", "associated_products", "associated_default"])
        domain_id(required: false, type: PropertyType.String, description: "Category domain id")
        moderated(required: false, type: PropertyType.Boolean, description: "Determine if the item is moderated")

        comparison_table(required: false, type: PropertyType.Map(comparisonTable), description: "Information about the winner and the original item")
        competition_status(required: false, type: PropertyType.String, description: "The actual buy box status of the item")
        new_competition_status(required: false, type: PropertyType.String, description: "The new buy box status of the item")
        catalog_product_id(required: false, type: PropertyType.String, description: "The product id")
        listing_type(required: true, type: PropertyType.String, description: "The product listing type")
        shipping_local_pickup(required: false, type: PropertyType.Boolean, description: "The product local pick up")
        winner_item_id(required: false, type: PropertyType.String, description: "The item id of the winner")
        price_to_win(required: false, type: PropertyType.Numeric, description: "The price to win that we suggest to the user")

        to(required: true, type: PropertyType.String, description: "The new value of a field, for example quantity, warranty,etc")
        from(required: false, type: PropertyType.String, description: "The original value of a field, for example quantity, warranty,etc")

        hierarchy(required: true, type: PropertyType.String, description: "Attribute type")

        original_catalog_product_id(required: true, type: PropertyType.String, description: "The original item catalog product id")
        selected_catalog_product_id(required: false, type: PropertyType.String, description: "The optined item catalog product id")
        variation_id(required: false, type: PropertyType.Numeric, description: "The variation id of the original item")
        variations_list_id(required: false, type: PropertyType.ArrayList(PropertyType.Numeric), description: "List of variations id of the original item")
        suggested_correction_product_id(required: false, description: "Suggested Correction product ID", type: PropertyType.String)
        has_variations_already_opt_in(required: true, type: PropertyType.Boolean, description: "True if the item has a variation optined")
        invalid_product_cause(required: false, type: PropertyType.String, description: "The invalid product causes")
        opt_in_item_id(required: false, type: PropertyType.String, description: "The optined item id")
        rejected_products(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The list of item and variations with their products catalog ids, when seller select is bad productize")
        has_variations(required: true, type: PropertyType.Boolean, description: "True if the item has variations")
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")

        item_attributes(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributes_values_map)), description: "List of attributes from the original item")
        catalog_product_attributes(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributes_values_map)), description: "List of attributes from the product associated to an item")
        item_title(required: true, type: PropertyType.String, description: "Item title")
        catalog_product_title(required: true, type: PropertyType.String, description: "Product title associated with an item")
        vertical(required: false, type: PropertyType.String, values: ["core", "motors", "realEstate", "real_estate", "services"], description: "Vertical of the item")
        mercado_lider(required: false, type: PropertyType.Boolean, description: "Seller is mercadolider")
        user_type(required: false, type: PropertyType.String, description: "The user type")
        business(required: false, values: ["classified", "none", "marketplace"], type: PropertyType.String, description: "this is the user site business")
        platform(required: false, values: ["pi", "ml", "mp"], type: PropertyType.String, description: "this is the user site platform")

        // RE V4 Intents
        intent_type(required: true, type: PropertyType.String, description: "this property describes the intent type to be perform", values: ["drag", "valid_street_number", "invalid_street_number", "new_location_accepted", "new_location_rejected", "new_location_auto_accepted", "valid_intent", "invalid_intent", "pictures_upload"])
        intent_value(required: false, type: PropertyType.String, description: "this property describes the intent value if exists")
        field_intent_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "this property describes the field ids for the intent")
        pictures_info(required: true, type: PropertyType.ArrayList(PropertyType.Map(picture_info_map)), description: "this property describes array of pictures information")

        // Seller Metrics
        applied_filters(required: false, type: PropertyType.ArrayList, description: "List of applied filters")
        finish_period(required: false, type: PropertyType.String, description: "Finish period ID")
        start_period(required: false, type: PropertyType.String, description: "Start period ID")
        from_previous(required: false, type: PropertyType.String, description: "From start date")
        from_current(required: false, type: PropertyType.String, description: "From end date")
        to_previous(required: false, type: PropertyType.String, description: "To start date")
        to_current(required: false, type: PropertyType.String, description: "To end date")

        // Seller Central Questions
        question_id(requested: false, type: PropertyType.String, description: "Question ID")
        site_id(requested: true, type: PropertyType.String, description: "Site ID")
        item_status(requested: true, type: PropertyType.String, description: "Current item status")
        question_date_created(required: true, type: PropertyType.String, description: "Question creation date")
        question_date_action(required: true, type: PropertyType.String, description: "Question response date")

        // Seller Central Optinator New Listing
        flow(required: true, values: ["new_listing", "live_listing"], type: PropertyType.String, description: "Flow that generated the topic's news")
        item_mk_id(required: true, type: PropertyType.String, description: "Processed item ID")
        item_mk_status(required: true, type: PropertyType.String, description: "Processed item status")
        item_mk_sub_status(required: true, type: PropertyType.ArrayList, description: "Processed item sub status")
        item_mk_tags(required: true, type: PropertyType.ArrayList, description: "Processed item tags")
        processing_data(required: true, type: PropertyType.Map(optinatorNewListingProcessingDataStructure), description: "Relevant processing data")
        variations(required: true, type: PropertyType.ArrayList(PropertyType.Map(optinatorVariationNewListingProcessingDataStructure)), description: "Processed item variations")

        //Products landing
        query(required: true, type: PropertyType.String, description: "This property describes value of search query")
        query_type(required: true, type: PropertyType.String, values: ["PRODUCT_NAME", "GTIN", "PRODUCT_ID"], description: "This property describes search type")
        result_type(required: true, type: PropertyType.String, values: ["SUGGESTED_PRODUCTS", "SUGGESTED_DOMAINS", "PRODUCT_ONE_SHOT"], description: "This property describes result type")
        results(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "This property describe IDs of results")
        paging(required: true, type: PropertyType.Map(productsLandingPaginStructure), description: "This property describe the pagination")
        selected_filters(required: true, type: PropertyType.ArrayList(PropertyType.Map(productsLandingSelectedFiltersStructure)), description: "This property describe seleted filters")
        selected_filters_quantity(required: true, type: PropertyType.Numeric, description: "This property describes total filters selected")
        row_index(required: false, type: PropertyType.Numeric, description: "This property describes row index in results")

        // Split Orders
        orders_quantity(required: false, type: PropertyType.Numeric, description: "Number of orders")
        orders(required: false, type: PropertyType.ArrayList(PropertyType.Map(orderStructure)), description: "List of orders")
        selected_orders(required: false, type: PropertyType.ArrayList(PropertyType.Map(orderStructure)), description: "List of selected orders")
        packs(required: false, type: PropertyType.ArrayList(PropertyType.Map(packStructure)), description: "List of packs")
        categories(required: true, type: PropertyType.ArrayList(PropertyType.Map(categoryStructure)), description: "List of categories")
        logistic_type(required: true, type: PropertyType.String, description: "Logistic type of the shipment")

        // Processing Time
        logistic_types(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "List of logistic types")
        processing_options(required: false, type: PropertyType.ArrayList(PropertyType.Map(processingOptionStructure)), description: "List of processing time options")
    }

    propertyGroups {
        sellerCentralModifyGroup(item_id, session_id, item_type)
        sellerCentralModifyCardsGroup(category_id, seller_profile, category_domain, category_path, catalog_product_id, listing_type, shipping_local_pickup, seller_reputation, vertical, user_type, business, platform)
        sellerCentralModifyCardsGroupMotors(category_id, seller_profile, category_domain, category_path, catalog_product_id, listing_type, shipping_local_pickup, seller_reputation, vertical, user_type)
        sellerCentralModifyGroupTableForPdp(comparison_table, competition_status, new_competition_status, winner_item_id, price_to_win)
        sellerCentralModifyCardsGroupValue(to, from)
        technicalSpecificationsGroup(category_domain, attribute, hierarchy)
        hintsGroup(type, attribute)

        sellerCentralCatalogOptinGroup(item_id, session_id, category_id, category_path, category_domain, domain_id, moderated, original_catalog_product_id, variation_id, has_variations_already_opt_in, rejected_products, has_variations, seller_profile, reputation_level, selected_catalog_product_id, opt_in_item_id, invalid_product_cause)
        sellerCentralCatalogOptinTaskGroup(task_id, to, from)

        sellerCentralCatalogOptinGroupV2(item_id, category_id, domain_id, variation_id, moderated, original_catalog_product_id, suggested_correction_product_id)
        sellerCentralCatalogOptinGroupV2Variations(item_id, category_id, domain_id, variations_list_id, original_catalog_product_id)

        sellerCentralCatalogSuggestionGroup(category_domain, item_id, catalog_product_id, reputation_level, seller_profile, seller_segment, session_id, user_type)

        sellerCentralCatalogProductizationGroup(item_id, session_id, category_id, domain_id, moderated, original_catalog_product_id, variation_id, has_variations_already_opt_in, rejected_products, has_variations, seller_profile, reputation_level, selected_catalog_product_id, opt_in_item_id, invalid_product_cause, item_type)

        sellerCentralCatalogBoostGroup(item_attributes, catalog_product_attributes, item_title, catalog_product_title)

        sellerCentralUserSales(seller_profile, seller_reputation, mercado_lider, seller_segment, user_type)

        intentGroup(intent_type, intent_value)
        technicalSpecsIntentsGroup(intent_type, intent_value, field_intent_ids)
        pictureIntentGroup(intent_type, pictures_info)

        // Settings
        sellerCentralSettingsGroup(seller_profile, reputation_level)
        sellerCentralProcessingTimeGroup(user_type, seller_profile, reputation_level, logistic_types, processing_options)

        // Seller Metrics
        sellerMetricsContext(applied_filters, finish_period, start_period, from_previous, from_current, to_previous, to_current)

        // Seller Questions
        sellerCentralActionQuestionsGroup(seller_profile, seller_segment, question_id, item_id, site_id, item_status, question_date_created, question_date_action)
        sellerCentralModalQuestionsGroup(seller_profile, seller_segment, question_date_action)

        // Seller Central Optinator New Listings
        sellerCentralOptinatorNewListingsGroup(flow, domain_id, item_mk_id, item_mk_status, item_mk_sub_status, item_mk_tags, processing_data, variations)

        // Products Landing
        productsLandingDataGroup(query, query_type, result_type, results, paging, selected_filters, selected_filters_quantity)
        productsLandingRowGroup(catalog_product_id, row_index)

        // Split Orders
        sellerCentralSplitOrdersGroup(user_type, seller_profile, reputation_level, orders_quantity, orders, selected_orders, packs, has_variations, categories, logistic_type)
    }


    // Central of News
    "/seller_central/news"(platform: "/", type: TrackType.View) {}
    "/seller_central/news/filter"(platform: "/", type: TrackType.Event) {}
    "/seller_central/news/filter/primary"(platform: "/", type: TrackType.Event) {}
    "/seller_central/news/filter/secondary"(platform: "/", type: TrackType.Event) {}
    "/seller_central/news/tag"(platform: "/", type: TrackType.Event) {
        tag(description: "The tag of selected notice")
    }
    "/seller_central/news/expand"(platform: "/", type: TrackType.Event) {
        notice_id(description: "The NoticeId of selected notice")
        category(description: "The Category of selected notice")
        sub_category(description: "The SubCategory of selected notice")
    }
    "/seller_central/news/primary"(platform: "/", type: TrackType.Event) {
        notice_id(description: "The NoticeId of selected notice")
        category(description: "The Category of selected notice")
        sub_category(description: "The SubCategory of selected notice")
    }
    "/seller_central/news/secondary"(platform: "/", type: TrackType.Event) {
        notice_id(description: "The NoticeId of selected notice")
        category(description: "The Category of selected notice")
        sub_category(description: "The SubCategory of selected notice")
    }
    "/seller_central/news/keep"(platform: "/", type: TrackType.Event) {
        notice_id(required: true, description: "The id of selected notice")
    }
    "/seller_central/news/lib/primary"(platform: "/", type: TrackType.Event) {
        notice_id(required: true, type: PropertyType.String, description: "The NoticeId of selected notice")
        category(required: true, type: PropertyType.String, description: "The Category of selected notice")
        sub_category(required: true, type: PropertyType.String, description: "The SubCategory of selected notice")
    }
    "/seller_central/news/lib/secondary"(platform: "/", type: TrackType.Event) {
        notice_id(required: true, type: PropertyType.String, description: "The NoticeId of selected notice")
        category(required: true, type: PropertyType.String, description: "The Category of selected notice")
        sub_category(required: true, type: PropertyType.String, description: "The SubCategory of selected notice")
    }

    // Summary
    "/seller_central/summary"(platform: "/", type: TrackType.View) {}

    // La idea es saber como fue la ejecución de cada módulo
    "/seller_central/summary/modules_render"(platform: "/", type: TrackType.Event) {
        modules(required: true, type: PropertyType.ArrayList(PropertyType.Map(summaryModule)), description: "Array of modules")
        seller_experience(required: false, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE', 'INTERMEDIATE', 'ADVANCED'])
    }

    "/seller_central/summary/show_advertising"(platform: "/web", type: TrackType.View) {
        placement(required: true, values: ["publicidad_news", "publicidad_modal", "publicidad_tooltip", "publicidad_tipbox", "publicidad_card", "publicidad_banner"], description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Advertisement segmentation ")
        reputation_level(required: false, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"], description: "Reputation for Pads")
        seller_experience(required: false, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE', 'INTERMEDIATE', 'ADVANCED'])
    }

    "/seller_central/summary/go_advertising"(platform: "/web", type: TrackType.Event) {
        placement(required: true, values: ["publicidad_news", "publicidad_modal", "publicidad_tooltip", "publicidad_tipbox", "publicidad_card", "publicidad_banner"], description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Advertisement segmentation ")
        reputation_level(required: false, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"], description: "Reputation for Pads")
        seller_experience(required: false, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE', 'INTERMEDIATE', 'ADVANCED'])
    }

    "/seller_central/summary/notice"(platform: "/web", type: TrackType.Event) {
        goal(required: true, description: "The primary goal of the clicked notice")
        seller_experience(required: true, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE', 'INTERMEDIATE', 'ADVANCED'])
    }

    "/seller_central/summary/task"(platform: "/", type: TrackType.Event) {
        module_id(required: true, description: "Identification for group task module")
        task_id(required: true, description: "The id of selected task")
        seller_experience(required: true, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE', 'INTERMEDIATE', 'ADVANCED'])
    }

    // Seller coach
    "/seller_central/seller_coach"(platform: "/", isAbstract: true) {
        power_seller_status(required: true, type: PropertyType.String, description: "Type of experience. ", values: ['0', '1_red', '2_orange', '3_yellow', '4_light_green', '5_green', 'gold', 'none', 'platinum', 'silver'])
        reputation(required: true, type: PropertyType.String, values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green", "newbie", "none"], description: "Reputation of the user")
        seller_experience(required: true, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE', 'INTERMEDIATE', 'ADVANCED'])
        user_session_id(required: true, type: PropertyType.String, description: "User's session uuid")
        source(required: true, type: PropertyType.String, description: "Frontend where the track was generated")
    }
    "/seller_central/seller_coach/recommendation"(platform: "/", isAbstract: true) {
        card(required: true, type: PropertyType.Map(sellerCoachCard), description: "Card actioned")
    }
    "/seller_central/seller_coach/recommendation/open"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/recommendation/dismiss"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/recommendation/bookmark"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/recommendation/unbookmark"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/recommendations/display"(platform: "/", type: TrackType.View) {
        cards(required: true, type: PropertyType.ArrayList(PropertyType.Map(sellerCoachCard)), description: "Cards viewed")
    }
    "/seller_central/seller_coach/tag/select"(platform: "/", type: TrackType.Event) {
        tag(required: true, type: PropertyType.Map(sellerCoachTag), description: "Tag clicked")
    }
    "/seller_central/seller_coach/tags/display"(platform: "/", type: TrackType.View) {
        tags(required: true, type: PropertyType.ArrayList(PropertyType.Map(sellerCoachTag)), description: "Tags viewed")
    }
    "/seller_central/seller_coach/carousel/scroll"(platform: "/", type: TrackType.Event) {
        page(required: true, type: PropertyType.Numeric, description: "Target page scrolled")
        scroll_type(required: true, type: PropertyType.String, values: ['prev', 'next'], description: "Direction of the scroll")
    }
    "/seller_central/seller_coach/module"(platform: "/", isAbstract: true) {
        card(required: false, type: PropertyType.Map(sellerCoachCard), description: "Card displayed when the module was actioned")
    }
    "/seller_central/seller_coach/module/open"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/module/close"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/coachmark/display"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/coachmark/action"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/accompaniment"(platform: "/", isAbstract: true) {
        card(required: true, type: PropertyType.Map(sellerCoachCard), description: "Card displayed when the module was actioned")
        previous_page(required: true, type: PropertyType.String, description: "Frontend the user came from")
    }
    "/seller_central/seller_coach/accompaniment/display"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/accompaniment/action"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/accompaniment/apply"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/congrats"(platform: "/", isAbstract: true) {
        previous_page(required: true, type: PropertyType.String, description: "Frontend the user came from")
        last_recommendation(required: true, type: PropertyType.Boolean, description: "Whether it's the last recommendation of the set for that user")
    }
    "/seller_central/seller_coach/congrats/display"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/congrats/action"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/empty_state/display"(platform: "/", type: TrackType.Event) {}
    "/seller_central/seller_coach/empty_state/action"(platform: "/", type: TrackType.Event) {}


    //LISTING SECTION
    "/seller_central"(platform: "/", isAbstract: true) {}
    "/seller_central/listings"(platform: "/", isAbstract: true) {}
    "/seller_central/listings/quantity"(platform: "/", isAbstract: true) {}
    "/seller_central/listings/inventory_status"(platform: "/", isAbstract: true) {}

    // Start SLL SC
    "/seller_central/listings/communication"(platform: "/", isAbstract: true) {}

    "/seller_central/listings/communication/advertising"(platform: "/", type: TrackType.Event) {
        action(required: false, type: PropertyType.String, description: "Action excecuted from advertising task")
        id(required: false, type: PropertyType.String, description: "Action id")
        type(required: false, type: PropertyType.String, description: "Action type")
    }

    "/seller_central/listings/communication/advertising_click"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action excecuted from advertising task")
        id(required: true, type: PropertyType.String, description: "Action id")
        type(required: false, type: PropertyType.String, description: "Action type")
    }

    "/seller_central/listings/communication/advertising/sll_landing"(platform: "/", isAbstract: true) {}

    "/seller_central/listings/communication/advertising/sll_landing/activated"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total_activated(required: false, type: PropertyType.String, description: "Indicates the number total of sll activated")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/seller_central/listings/communication/advertising/sll_landing/breadcrum"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total_activated(required: false, type: PropertyType.String, description: "Indicates the number total of sll activated")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/seller_central/listings/communication/advertising/sll_landing/tooltip"(platform: "/", type: TrackType.Event) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total_activated(required: false, type: PropertyType.String, description: "Indicates the number total of sll activated")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }

    "/seller_central/listings/advertising_sll_landing"(platform: "/", type: TrackType.View) {
        sll_total(required: true, type: PropertyType.Numeric, description: "Indicates the number total of sll")
        campaign_id(required: true, type: PropertyType.String, description: "Id related to the campaign")
    }

    "/seller_central/listings/advertising_sll_landing/activated"(platform: "/", type: TrackType.View) {
        campaign_id(required: true, description: "Id related to the campaign")
        sll_total(required: false, type: PropertyType.String, description: "Indicates the number total of sll")
    }
    // End SLL SC

    "/seller_central/listings/video_focus"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/onboarding"(platform: "/", type: TrackType.View) {}

    "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "rollback", "start", "reopen"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
        viewId(required: false, type: PropertyType.String, description: "Onboarding id if applies")
        user_type(required: false, type: PropertyType.String, description: "Authenticated user type")
    }

    "/seller_central/listings/onboarding/pdp"(platform: "/", type: TrackType.View) {}

    "/seller_central/listings/onboarding/pdp/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["accept", "cancel"])
    }


    "/seller_central/listings/hunting"(platform: "/", isAbstract: true) {
        view_id(required: true, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/hunting/change_step"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/hunting/view_more"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/hunting/sell_with_full"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of the communication", values: ["news", "task", "user_restriction"])
        id(required: false, type: PropertyType.String, description: "Id of the communication ")
        action(required: false, type: PropertyType.String, description: "The action used in the communication if applies")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/communication/go"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of the communication", values: ["news", "task", "user_restriction"])
        id(required: false, type: PropertyType.String, description: "Id of the communication ")
        action(required: false, type: PropertyType.String, description: "The action used in the communication if applies")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/communication/hide"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of the communication", values: ["news", "task", "user_restriction"])
        id(required: false, type: PropertyType.String, description: "Id of the communication ")
        action(required: false, type: PropertyType.String, description: "The action used in the communication if applies")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/communication/more_info"(platform: "/mobile", type: TrackType.Event) {}

    "/seller_central/listings/helpme"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/filters"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/listings/action/confirm"(platform: "/", type: TrackType.Event) {
        id_row_selected(required: false, type: PropertyType.String, description: "Row id to which the action is executed")
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        item_id(required: false, type: PropertyType.String, description: "Item id to which the action is executed")
        id_row_selected(required: false, type: PropertyType.String, description: "Row id to which the action is executed")
        has_variations(required: false, type: PropertyType.Boolean, description: "If the item to which the action is executed has variations")
        operator_id(required: false, type: PropertyType.String, description: "If it is an operator, operator id that executes the action")
    }

    "/seller_central/listings/massive_action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        count(required: true, type: PropertyType.Numeric, description: "Selected rows count")
        ideal_rows(required: false, type: PropertyType.Numeric, description: "Selected ideal rows count")
    }

    "/seller_central/listings/preferences"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Preference id", values: ["shipping", "advertising"])
    }

    "/seller_central/listings/quantity/info"(platform: "/", type: TrackType.Event) {
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/quantity/change_tab"(platform: "/", type: TrackType.Event) {
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        target_view_id(required: false, type: PropertyType.String, description: "View to which the event has changed")
    }

    "/seller_central/listings/inventory_status/remedy"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the remedy applied to solve moderation")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/show"(platform: "/", type: TrackType.View) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Advertasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/hide"(platform: "/", type: TrackType.Event) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Advertasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/go"(platform: "/", type: TrackType.Event) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Advertasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/survey"(platform: "/", type: TrackType.Event) {
        hotjar_survey(required: true, type: PropertyType.String, description: "hotjar survey value")
    }

    //LISTING SECTION - TABS
    "/seller_central/listings/list/promos"(platform: "/", type: TrackType.Event) {}


    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central BULK Offline
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/bulk"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/offline"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/offline/home"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/hub"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/offline/download"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download/confirm"(platform: "/", type: TrackType.Event) {
        selected_columns(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Excel columns selected for the seller")
        type(required: true, type: PropertyType.String, description: "Flux type selected for the seller")
        categories(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Categories selected for download")
        filters(required: true, type: PropertyType.String, description: "Filters selected for the seller")
    }

    "/seller_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/upload"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download/user_selection"(platform: "/", type: TrackType.Event) {
        columns(required: true, type: PropertyType.ArrayList, description: "List of the selected columns")
        domains(required: true, type: PropertyType.ArrayList, description: "List of the selected domains")
    }

    "/seller_central/bulk/offline/download/error"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/offline/download/warning"(platform: "/", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central BULK Discounts
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/bulk/discounts"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/discounts/list"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["start", "close", "rollback", "dismiss"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
    }

    "/seller_central/bulk/discounts/filters"(platform: "/", type: TrackType.Event) {
        filters(required: true, type: PropertyType.ArrayList, description: "List of selected filters")
    }

    "/seller_central/bulk/discounts/search"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/discounts/undo_changes"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/discounts/columns"(platform: "/", type: TrackType.Event) {
        columns(required: true, type: PropertyType.ArrayList, description: "List of the available columns and his order")
    }

    "/seller_central/bulk/discounts/save"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/discounts/offline"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/discounts/offline/home"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/download"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/download/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/upload"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/upload/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/download/user_selection"(platform: "/", type: TrackType.Event) {
        columns(required: true, type: PropertyType.ArrayList, description: "List of the selected columns")
        domains(required: true, type: PropertyType.ArrayList, description: "List of the selected domains")
    }

    "/seller_central/bulk/discounts/offline/download/error"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/discounts/offline/download/warning"(platform: "/", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central modify
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify"(platform: "/", isAbstract: true, initiative: "1151") {
        sellerCentralModifyGroup
    }

    "/seller_central/modify/detail"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroupMotors
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/variations"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/variations_custom"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroupMotors
    }

    "/seller_central/modify/listing_type"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroupMotors
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/subflow"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/update_sales_channel"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
        marketplace(required: true, type: PropertyType.Boolean, description: "if MercadoLibre channel is selected")
        mshops(required: true, type: PropertyType.Boolean, description: "if MercadoShops channel is selected")
    }

    "/seller_central/modify/update_price"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_mshops_price"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
        synced(required: true, type: PropertyType.Boolean, description: "if MercadoShops's price is synced with MarketPlace's price")
    }

    "/seller_central/modify/update_quantity"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_localpickup_options"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_warranty"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_3x_campaign"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_ahora_12"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_listing_types"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_item_condition"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_shipping_flex"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_size_chart"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_price_push_winner_pdp"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_rebate"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/update_conversion_price"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
    }

    /**
     * La idea es trackear en el snackbar informacion
     * del item original y algunos cambios que se produjeron.
     */
    "/seller_central/modify/success"(platform: "/web", type: TrackType.Event) {
        goals_achieved(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Goals achieved in this session, dataset target.")
        original_goals_not_completed(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Original goals available to complete ordered by source.")
        original_goals_completed(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Original goals completed ordered by source.")
        original_goals_not_applied(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Original goals that not applied for this item, ordered by source.")
        goal_order(required: true, type: PropertyType.String, description: "Goals order source.")
        original_price(required: true, type: PropertyType.Numeric, description: "Original item price")
        original_currency(required: true, type: PropertyType.String, description: "Original item currency")
        original_listing_type(required: true, type: PropertyType.String, description: "Original item listing type", values: ['free', 'bronze', 'silver', 'gold', 'gold_premium', 'gold_special', 'gold_pro'])
        original_quantity(required: true, type: PropertyType.Numeric, description: "Original item quantity")
        original_condition(required: true, type: PropertyType.String, description: "Original item condition", values: ['new', 'not_specified', 'used', 'refurbished'])
        original_shipping(required: false, type: PropertyType.String, description: "Original item shippgin mode.", values: ['ME_DISCOUNT', 'ME_FREE_SHIPPING', 'CUSTOM_SHIPPING', 'FREE_CUSTOM_SHIPPING', 'NO_SHIPPING', 'ME_BUYER'])
        original_local_pickup(required: false, type: PropertyType.Boolean, description: "Item original local_pickup")
        is_fbm(required: false, type: PropertyType.Boolean, description: "Is a FullFillment item")
        domain(required: true, type: PropertyType.String, description: "Item domain")
        is_catalog_product(required: true, type: PropertyType.Boolean, description: "Item is in catalog")
        technical_specifications_attributes_empty(required: false, type: PropertyType.Numeric, description: "Original Technical specifications attributes requested")
        technical_specifications_attributes_loaded(required: false, type: PropertyType.Numeric, description: "Original Technical specifications attributes completed")
        seller_experience(required: true, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE', 'INTERMEDIATE', 'ADVANCED'])
        is_official_store(required: true, type: PropertyType.Boolean, description: "User is official store")
    }

    "/seller_central/modify/catalog_boost"(platform: "/", type: TrackType.View) {
        sellerCentralCatalogBoostGroup
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/catalog_boost/original_item"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/catalog_boost/activate"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/catalog_boost/not_my_product"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/catalog_boost/modal"(platform: "/", isAbstract: true) {}

    "/seller_central/modify/catalog_boost/modal/confirm"(platform: "/", type: TrackType.Event) {
        seller_reasons(required: true, type: PropertyType.String, description: "reasons why a seller has decided not associate its item to a catalog product")
    }

    "/seller_central/modify/catalog_boost/modal/cancel"(platform: "/", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS CLASSI V4
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify/detail/quick_edit_standard"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/quick_edit_standard/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/quick_edit_standard/confirm"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/quick_edit_standard/intent"(platform: "/", type: TrackType.Event) {
        pictureIntentGroup
    }

    "/seller_central/modify/detail/consequences_modal"(platform: "/", type: TrackType.Event) {
        goal(required: true, type: PropertyType.String, description: "Goal that is losing")
        action(required: true, type: PropertyType.String, description: "Modal action", values:["show", "confirm", "cancel"])
    }

    "/seller_central/modify/detail/seller_contact"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/seller_contact/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/seller_contact/confirm"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/reservation_info"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/reservation_info/show"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/location"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/location/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/location/confirm"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/location/intent"(platform: "/", type: TrackType.Event) {
        intentGroup
    }

    "/seller_central/modify/detail/instant_pay_listings"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/instant_pay_listings/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/instant_pay_listings/confirm"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/description"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/description/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/description/confirm"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/video"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/video/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/video/confirm"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/change_category"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/change_category/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/change_category/confirm"(platform: "/", type: TrackType.Event) {}


    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MODA
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify/variations/picture_education"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/detail/selected_chart"(platform: "/", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central Structured Data
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify/technical_specifications"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/technical_specifications/hints"(platform: "/", isAbstract: true) {
        hintsGroup
        category_domain(required: true, type: PropertyType.String, description: "Item category domain")
        hint_id(required: true, type: PropertyType.String, description: "Id del hint que se mostro, pueden cambiar o generarse nuevos por lo que no conocemos todos los valores posibles.")
    }

    "/seller_central/modify/technical_specifications/hints/available"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/technical_specifications/hints/completed"(platform: "/", type: TrackType.Event) {
        user_action(required: false, type: PropertyType.String, description: "Type of user action", values: ["click", "write"])
    }

    "/seller_central/modify/optin_flex_subflow"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroupMotors
    }

    "/seller_central/bulk/technical_specifications"(platform: "/", isAbstract: true) {}
    "/seller_central/bulk/technical_specifications/hints"(platform: "/", isAbstract: true) {
        hintsGroup
        hint_id(required: true, type: PropertyType.String, description: "Id del hint que se mostro, pueden cambiar o generarse nuevos por lo que no conocemos todos los valores posibles.")
        category_domain(required: true, type: PropertyType.String, description: "Item category domain")
        item_id(required: true, type: PropertyType.String, description: "Id of item used to")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
    }

    "/seller_central/bulk/technical_specifications/hints/available"(platform: "/", type: TrackType.Event) {
    }

    "/seller_central/bulk/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event) {
    }

    "/seller_central/bulk/technical_specifications/hints/completed"(platform: "/", type: TrackType.Event) {
        user_action(required: false, type: PropertyType.String, description: "Type of user action", values: ["click", "write"])
    }

    "/seller_central/modify/technical_specifications/multivalue"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyGroup
        technicalSpecificationsGroup
        quantity(required: true, type: PropertyType.Numeric, description: "Added values")
        previous_quantity(required: true, type: PropertyType.Numeric, description: "Previous values")
    }

    "/seller_central/modify/technical_specifications/suggested"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyGroup
        technicalSpecificationsGroup
        type(required: true, type: PropertyType.String, description: "Suggestion type", values: ["suggested", "dynamic", "other"])
    }

    "/seller_central/modify/update_change_category"(platform: "/", type: TrackType.Event) {
        category_domain(required: true, type: PropertyType.String, description: "Item category domain")
        item_id(required: true, type: PropertyType.String, description: "Id of item used to")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
    }

    "/seller_central/modify/technical_specifications/hidden_attributes"(platform: "/", isAbstract: true) {
        sellerCentralModifyGroup
        seller_id(required: true, type: PropertyType.Numeric)
        category_domain(required: true, type: PropertyType.String, description: "Item category domain")
        type(required: true, type: PropertyType.String, description: "Trigger action", values: ["CONFIRM", "CANCEL"])
    }

    "/seller_central/modify/technical_specifications/hidden_attributes/open"(platform: "/", type: TrackType.Event) {
        times_showed(required: true, type: PropertyType.Numeric, description: "Number of views")
        attributes(required: true, type: PropertyType.Numeric, description: "Attributes available")
    }

    "/seller_central/modify/technical_specifications/hidden_attributes/add"(platform: "/", type: TrackType.Event) {
        attribute(required: true, type: PropertyType.String, description: "ID of the attribute")
    }

    "/seller_central/modify/technical_specifications/hidden_attributes/change"(platform: "/", type: TrackType.Event) {
        attribute(required: true, type: PropertyType.String, description: "ID of the attribute")
        value(required: true, type: PropertyType.String, description: "New attribute value")
    }

    "/seller_central/modify/broken_card"(platform: "/web", isAbstract: true) {}
    "/seller_central/modify/broken_card/show"(platform: "/web", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        broken_card_id(required: true, type: PropertyType.String, description: "Id of broken card")
    }

    "/seller_central/modify/technical_specifications/completed_attributes"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyGroup
        domain_id(required: true, type: PropertyType.String)
        attributes_before_update(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributeStructure)), description: "Completed attributes defore update")
        attributes_after_update(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributeStructure)), description: "Completed attributes after update")
    }

    "/seller_central/modify/detail/technical_specifications"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/technical_specifications/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/technical_specifications/confirm"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/technical_specifications/intent"(platform: "/", type: TrackType.Event) {
        technicalSpecsIntentsGroup
    }


    // SETTINGS SECTION

    "/seller_central/settings"(platform: "/", type: TrackType.View) {
        sellerCentralSettingsGroup
    }

    "/seller_central/empty_settings"(platform: "/", type: TrackType.View) {
        sellerCentralSettingsGroup
    }

    "/seller_central/settings/show_row"(platform: "/", type: TrackType.Event) {
        row_id(required: true, type: PropertyType.String, description: "Row Id displayed")
        ui_type(required: true, type: PropertyType.String, description: "UI Type of row", values: ["row", "row_disabled", "row_error"])
        section(required: true, type: PropertyType.String, description: "Section where the row is display")
    }

    "/seller_central/settings/update_row"(platform: "/", type: TrackType.Event) {
        to(required: true, type: PropertyType.String, description: "New value of the row")
        from(required: false, type: PropertyType.String, description: "Previous value of the row")
        section_id(required: true, type: PropertyType.String, description: "Section of the row")
        row_id(required: true, type: PropertyType.String, description: "Row Id")
    }

    // PROCESSING TIME SECTION

    "/seller_central/settings/processing_time"(platform: "/", type: TrackType.View) {
        sellerCentralProcessingTimeGroup
    }

    "/seller_central/settings/processing_time/action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "The action id", values: ["CONFIRM", "CANCEL"])
        sellerCentralProcessingTimeGroup
    }

    // SALES SECTION

    "/seller_central/sales"(platform: "/", isAbstract: true) {}

    "/seller_central/sales/list"(platform: "/", type: TrackType.View) {
        sellerCentralUserSales
    }

    "/seller_central/sales/list"(platform: "/web/mobile", type: TrackType.View) {}

    "/seller_central/sales/list/onboarding"(platform: "/", isAbstract: true, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "start"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
    }

    "/seller_central/sales/list/onboarding/massive"(platform: "/", isAbstract: true, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/onboarding/massive/confirm"(platform: "/", type: TrackType.Event) {}
    "/seller_central/sales/list/onboarding/massive/close"(platform: "/", type: TrackType.Event) {}

    "/seller_central/sales/list/nfe_onboarding"(platform: "/", isAbstract: true, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/nfe_onboarding/action"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "start"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
    }

    "/seller_central/sales/list/search"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/seller_central/sales/list/pagination"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        page(required: true, type: PropertyType.Numeric, description: "Page number")
        total(required: true, type: PropertyType.Numeric, description: "Total pages number")
    }

    "/seller_central/sales/list/modal_action"(platform: "/web", isAbstract: true, parentPropertiesInherited: false) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/list/modal_action/open"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/list/modal_action/close"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/list/modal_action/apply"(platform: "/web", type: TrackType.Event) {
        option(required: false, type: PropertyType.String, description: "Option selected")
    }

    "/seller_central/sales/list/widget"(platform: "/web", isAbstract: true, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/widget/header"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        collapsed(required: true, type: PropertyType.Boolean, description: "Collapsed state")
    }
    "/seller_central/sales/list/widget/dismiss"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        batch_id(required: true, type: PropertyType.String, description: "Batch id")
    }
    "/seller_central/sales/list/widget/close"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        processing(required: true, type: PropertyType.Boolean, description: "Processing state")
        batch_ids(required: true, type: PropertyType.ArrayList, description: "List of batch ids")
    }
    "/seller_central/sales/list/widget/action"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        action(required: true, type: PropertyType.String, description: "Action executed")
        type(required: true, type: PropertyType.String, description: "Type action executed")
        date_created(required: false, type: PropertyType.String, description: "Created date")
        date_finished(required: false, type: PropertyType.String, description: "Finished date")
        date_executed(required: false, type: PropertyType.String, description: "Executed date")
    }

    "/seller_central/sales/list/dashboard"(platform: "/", isAbstract: true, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/dashboard/open"(platform: "/web", type: TrackType.Event) {
        substates(required: true, type: PropertyType.ArrayList, description: "List of available tasks")
    }
    "/seller_central/sales/list/dashboard/open"(platform: "/mobile", type: TrackType.Event) {
        state(required: true, type: PropertyType.String, description: "Id of opened state")
        substates(required: true, type: PropertyType.ArrayList, description: "List of available tasks")
    }
    "/seller_central/sales/list/dashboard/close"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/list/dashboard/apply"(platform: "/", type: TrackType.Event) {
        state(required: false, type: PropertyType.String, description: "Column id")
        substate(required: true, type: PropertyType.String, description: "Card id")
        count(required: true, type: PropertyType.Numeric, description: "Task count")
    }

    "/seller_central/sales/list/filters"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/filters/open"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/filters/action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        id(required: true, type: PropertyType.String, description: "Id of the action", values: ["apply", "clear"])
        filters(required: false, type: PropertyType.ArrayList, description: "List of applied filters")
        sort(required: false, type: PropertyType.String, description: "Sort id")
    }

    "/seller_central/sales/list/massive"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        id(required: true, type: PropertyType.String, description: "Action id")
        count(required: true, type: PropertyType.Numeric, description: "Sale rows count")
    }

    "/seller_central/sales/list/excel"(platform: "/", isAbstract: true) {}

    "/seller_central/sales/list/excel/snackbar"(platform: "/web", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Error id")
    }

    "/seller_central/sales/list/excel/generation"(platform: "/web", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
        time(required: true, type: PropertyType.Numeric, description: "How much time does it takes to generate the excel")
    }


    "/seller_central/sales/list/excel/packs"(platform: "/web", type: TrackType.Event) {
        total_sales(required: true, type: PropertyType.Numeric, description: "Sales quantity")
        total_rows(required: true, type: PropertyType.Numeric, description: "Rows quantity")
        total_error_rows(required: true, type: PropertyType.Numeric, description: "Rows error quantity")
        total_error_cells(required: true, type: PropertyType.Numeric, description: "Cell error quantity")
        total_packs(required: true, type: PropertyType.Numeric, description: "Packs quantityy")
    }


    "/seller_central/sales/list/row"(platform: "/web", isAbstract: true, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/row/open"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/sales/list/row"(platform: "/mobile", isAbstract: true) {}
    "/seller_central/sales/list/row/messages_action"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of message action", values: ["send_messages", "view_messages", "view_new_messages", "legacy"])
    }
    "/seller_central/sales/list/row/claims_action"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of claim action", values: ["view_claim", "answer_claim", "legacy"])
    }

    "/seller_central/sales/list/action"(platform: "/web", isAbstract: true, parentPropertiesInherited: false) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/list/action/primary"(platform: "/web", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
        filters(required: false, type: PropertyType.ArrayList, description: "List of applied filters")
        sellerCentralUserSales


    }
    "/seller_central/sales/list/action/primary/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }

    "/seller_central/sales/list/action/secondary"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/sales/detail"(platform: "/", type: TrackType.View) {}
    "/seller_central/sales/detail/row"(platform: "/web", isAbstract: true) {}
    "/seller_central/sales/detail/row/close"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/sales/detail/action"(platform: "/web", isAbstract: true) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/detail/action/primary"(platform: "/web", type: TrackType.Event) {

    }
    "/seller_central/sales/detail/action/primary/show"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/detail/action/secondary"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/detail/action/print"(platform: "/web", parentPropertiesInherited: false, type: TrackType.Event) {}

    "/seller_central/sales/detail/modal_action"(platform: "/web", isAbstract: true) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/detail/modal_action/open"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/detail/modal_action/close"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/detail/modal_action/apply"(platform: "/web", type: TrackType.Event) {
        option(required: false, type: PropertyType.String, description: "Option selected")
    }

    "/seller_central/sales/detail/widget"(platform: "/web", isAbstract: true, parentPropertiesInherited: false) {}
    "/seller_central/sales/detail/widget/header"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        collapsed(required: true, type: PropertyType.Boolean, description: "Collapsed state")
    }
    "/seller_central/sales/detail/widget/dismiss"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        batch_id(required: true, type: PropertyType.String, description: "Batch id")
    }
    "/seller_central/sales/detail/widget/close"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        processing(required: true, type: PropertyType.Boolean, description: "Processing state")
        batch_ids(required: true, type: PropertyType.ArrayList, description: "List of batch ids")
    }
    "/seller_central/sales/detail/widget/action"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        action(required: true, type: PropertyType.String, description: "Action executed")
        type(required: true, type: PropertyType.String, description: "Type action executed")
        date_created(required: false, type: PropertyType.String, description: "Created date")
        date_finished(required: false, type: PropertyType.String, description: "Finished date")
        date_executed(required: false, type: PropertyType.String, description: "Executed date")
    }

    "/seller_central/sales/detail/main_action"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "ID of main action")
    }

    "/seller_central/sales/detail/messages_action"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of message action", values: ["send_messages", "view_messages", "view_new_messages", "legacy"])
    }

    "/seller_central/sales/detail/claims_action"(platform: "/mobile", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of claim action", values: ["view_claim", "answer_claim", "legacy"])
    }

    "/seller_central/sales/detail/secondary_action"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "ID of secondary action")
    }

    "/seller_central/sales/detail/payment"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/payment/more_payments"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/payment/products"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/shipping"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/shipping/action"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "ID of shipping action")
    }

    "/seller_central/sales/detail/invoice_info"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/billing_info"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/buyer_info"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/buyer_info/action"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "ID of buyer info action")
    }

    "/seller_central/sales/detail/driver_info"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/congrats"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/cancellation"(platform: "/mobile", isAbstract: true) {}
    "/seller_central/sales/detail/cancellation/landing"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/cancellation/order_selection"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/cancellation/reason_selection"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/cancellation/reason_input"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/message"(platform: "/web", type: TrackType.View) {}

    "/seller_central/sales/detail/message/action"(platform: "/web", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }

    "/seller_central/sales/fiscal_document"(platform: "/web", isAbstract: true, type: TrackType.Event) {}
    "/seller_central/sales/fiscal_document/action"(platform: "/web", isAbstract: true, type: TrackType.Event) {}
    "/seller_central/sales/fiscal_document/action/secondary"(platform: "/web", isAbstract: true, type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "action ID")
    }
    "/seller_central/sales/fiscal_document/action/primary"(platform: "/web", isAbstract: true, type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "action ID")
    }
    "/seller_central/sales/fiscal-document"(platform: "/web", isAbstract: true, type: TrackType.View) {}

    // METRICS SECTION

    "/seller_central/metrics"(platform: "/web", type: TrackType.View) {
        sellerCentralUserSales
    }

    "/seller_central/metrics"(platform: "/web/mobile", type: TrackType.View) {}

    "/seller_central/metrics"(platform: "/mobile", type: TrackType.View) {
        fragment_from_webview(required: false, type: PropertyType.String, description: "The webview where is opened the fragment")
    }

    "/seller_central/metrics/personalized_period"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        days_count(required: true, type: PropertyType.Numeric, description: "Custom period days count")
    }

    "/seller_central/metrics/show_filters"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        sellerMetricsContext
    }

    "/seller_central/metrics/clear_filters"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        sellerMetricsContext
    }

    "/seller_central/metrics/apply_filters"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        sellerMetricsContext
    }

    "/seller_central/metrics/close_filters"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        sellerMetricsContext
    }

    "/seller_central/metrics/chart_render"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        sellerMetricsContext
        metric(required: true, type: PropertyType.String, description: "Metric ID")
        value(required: true, type: PropertyType.String, description: "Value of metric")
        badget_type(required: true, type: PropertyType.String, description: "Badge type")
    }

    "/seller_central/metrics/date_picker_show"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        sellerMetricsContext
        period_type(required: true, type: PropertyType.String, description: "Period type")
    }

    "/seller_central/metrics/date_picker_apply"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        sellerMetricsContext
        period_type(required: true, type: PropertyType.String, description: "Period type")
    }

    // METRICS MY ATTENTION SECTION

    "/seller_central/metrics/attention"(platform: "/web", isAbstract: true) {}

    // Page Summary - My Attention

    "/seller_central/metrics/attention/summary"(platform: "/web", type: TrackType.View) {
        sellerCentralUserSales
        default_selected_period(required: false, type: PropertyType.String, description: "Seller's default reputation period")
    }

    "/seller_central/metrics/attention/summary"(platform: "/web/mobile", type: TrackType.View) {}

    "/seller_central/metrics/attention/summary"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/metrics/attention/summary/click_help"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        section_name(required: true, type: PropertyType.String, description: "Section where the button is placed")
    }

    "/seller_central/metrics/attention/summary/open_filter_modal"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
    }

    "/seller_central/metrics/attention/summary/apply_filters"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        filters(required: true, PropertyType.ArrayList(PropertyType.String), description: "List of applied filters")
        toggle_reputation(required: true, type: PropertyType.Boolean, description: "Reputation switch status")
    }

    "/seller_central/metrics/attention/summary/toggle_reputation"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        toggle_reputation(required: true, type: PropertyType.Boolean, description: "Reputation switch status")
    }

    "/seller_central/metrics/attention/summary/selected_period"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        selected_period(required: true, type: PropertyType.String, description: "Dropdown selected period")
    }

    "/seller_central/metrics/attention/summary/personalized_period"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        days_count(required: true, type: PropertyType.Numeric, description: "Custom period days count")
    }

    "/seller_central/metrics/attention/summary/open_onboarding"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
    }

    "/seller_central/metrics/attention/summary/summary_fallback"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        trigger_by(required: true, type: PropertyType.String, description: "How the fallback was triggered")
    }

    // Page Details - My Attention

    "/seller_central/metrics/attention/details"(platform: "/web", type: TrackType.View) {
        sellerCentralUserSales
        default_selected_period(required: false, type: PropertyType.String, description: "Seller's default reputation period")
    }

    "/seller_central/metrics/attention/details"(platform: "/web/mobile", type: TrackType.View) {}

    "/seller_central/metrics/attention/details"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/metrics/attention/details/click_help"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
    }

    "/seller_central/metrics/attention/details/open_filter_modal"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
    }

    "/seller_central/metrics/attention/details/apply_filters"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        filters(required: true, PropertyType.ArrayList(PropertyType.String), description: "List of applied filters")
        toggle_reputation(required: true, type: PropertyType.Boolean, description: "Reputation switch status")
    }

    "/seller_central/metrics/attention/details/toggle_reputation"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        toggle_reputation(required: true, type: PropertyType.Boolean, description: "Reputation switch status")
    }

    "/seller_central/metrics/attention/details/selected_period"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        selected_period(required: true, type: PropertyType.String, description: "Dropdown selected period")
    }

    "/seller_central/metrics/attention/details/personalized_period"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        days_count(required: true, type: PropertyType.Numeric, description: "Custom period days count")
    }

    "/seller_central/metrics/attention/details/top_sort"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        sort_type(required: true, type: PropertyType.String, description: "Sort option selected")
    }

    "/seller_central/metrics/attention/details/top_actions"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        action_type(required: true, type: PropertyType.String, description: "Product action selected")
    }

    "/seller_central/metrics/attention/details/show_problems"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        problems(required: true, PropertyType.ArrayList(PropertyType.String), description: "List of showed problems")
    }

    "/seller_central/metrics/attention/details/selected_problem"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        selected_problem(required: true, type: PropertyType.String, description: "Problem selected ID")
        problem_type(required: true, type: PropertyType.String, description: "Problem type", values: ["L1", "L2"])
    }
    
    // Delayed Shipping - My Attention

    "/seller_central/metrics/attention/delayed_shippings"(platform: "/web", type: TrackType.View) {
        sellerCentralUserSales
        default_selected_period(required: false, type: PropertyType.String, description: "Seller's default reputation period")
    }

    "/seller_central/metrics/attention/delayed_shippings"(platform: "/web/mobile", type: TrackType.View) {}

    "/seller_central/metrics/attention/delayed_shippings"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/metrics/attention/delayed_shippings/click_help"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        section_name(required: true, type: PropertyType.String, description: "Section where the button is placed")
    }

    "/seller_central/metrics/attention/delayed_shippings/open_filter_modal"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
    }

    "/seller_central/metrics/attention/delayed_shippings/apply_filters"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        filters(required: true, PropertyType.ArrayList(PropertyType.String), description: "List of applied filters")
    }

    "/seller_central/metrics/attention/delayed_shippings/start_period"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        start_period(required: true, type: PropertyType.String, description: "Dropdown selected period")
    }

    "/seller_central/metrics/attention/delayed_shippings/finish_period"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        finish_period(required: true, type: PropertyType.String, description: "Dropdown selected period")
    }

    "/seller_central/metrics/attention/delayed_shippings/personalized_period"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        days_count(required: true, type: PropertyType.Numeric, description: "Custom period days count")
    }

    "/seller_central/metrics/attention/delayed_shippings/products_actions"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        action_type(required: true, type: PropertyType.String, description: "Product action selected")
    }

    "/seller_central/metrics/attention/delayed_shippings/open_onboarding"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
    }

    // METRICS STOCK-FULL SECTION

    "/seller_central/metrics/stock_full"(platform: "/web", type: TrackType.View) {
        sellerCentralUserSales
        origin(required: false, type: PropertyType.String, description: "View where the event has been called",  name: "origin")
    }

    "/seller_central/metrics/stock_full"(platform: "/web/mobile", type: TrackType.View) {}

    "/seller_central/metrics/stock_full"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/metrics/stock_full/click_help"(platform: "/web", type: TrackType.Event) {
        sellerCentralUserSales
        section_name(required: true, type: PropertyType.String, description: "Section where the button is placed")
    }


    // CATALOG OPTIN SECTION

    "/seller_central/catalog"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin"(platform: "/web", type: TrackType.View) {
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "OPTIN_V0_PRODUCT"])
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/product_comparator"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/product_comparator/show"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/product_comparator/confirm"(platform: "/web", type: TrackType.View) {
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "OPTIN_V0_PRODUCT"])
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/invoice"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/invoice/confirm"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        to(required: true, type: PropertyType.String, description: "The new value of a field, for example quantity, warranty,etc")
        from(required: false, type: PropertyType.String, description: "The original value of a field, for example quantity, warranty,etc")
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/category"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/category/confirm"(platform: "/web", type: TrackType.View) {
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "OPTIN_V0_PRODUCT"])
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/product_problem"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/product_problem/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/product_problem/return"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/product_problem/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        reason(required: true, type: PropertyType.String, description: "Reason of problem with the product", values: ["PRODUCT_ERRORS", "KIT", "OTHER"])
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus_card"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/item_plus_card/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus_card/return"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus_card/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        reason(required: true, type: PropertyType.String, description: "Reason of problem with the product", values: ["PRODUCT_ERRORS", "KIT", "OTHER"])
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/category_breadcrumb"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/category_breadcrumb/mount"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN"])
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
    }

    "/seller_central/catalog/optin/category_breadcrumb/update"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN"])
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
    }

    "/seller_central/catalog/optin/product_bullet_resume"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/product_bullet_resume/show"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN"])
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        product_title(required: true, description: "title of catalog product", type: PropertyType.String)
    }

    "/seller_central/catalog/optin/v0_product_bullet_resume"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/v0_product_bullet_resume/show"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN_V0_PRODUCT"])
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        product_title(required: true, description: "title of catalog product", type: PropertyType.String)
    }
    // Suggestion v2 tracks
    "/seller_central/catalog/optin/leave_suggestion"(platform: "/web", isAbstract: true) {
        sellerCentralCatalogOptinGroup
    }
    "/seller_central/catalog/optin/leave_suggestion/confirm"(platform: "/web", type: TrackType.Event) {
        value(required: true, type: PropertyType.String, description: "Selecetd value")
    }
    "/seller_central/catalog/optin/leave_suggestion/show"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/catalog/optin/catalog_decision"(platform: "/web", isAbstract: true) {
        sellerCentralCatalogOptinGroup
    }
    "/seller_central/catalog/optin/catalog_decision/confirm"(platform: "/web", type: TrackType.Event) {
        value(required: true, type: PropertyType.String, description: "Selecetd value")
    }
    "/seller_central/catalog/optin/catalog_decision/show"(platform: "/web", type: TrackType.Event) {}

    // optin moderated suggestion v2 tracks
    "/seller_central/catalog/optin/optin_moderated/leave_suggestion"(platform: "/web", isAbstract: true) {
        sellerCentralCatalogOptinGroup
    }
    "/seller_central/catalog/optin/optin_moderated/leave_suggestion/confirm"(platform: "/web", type: TrackType.Event) {
        value(required: true, type: PropertyType.String, description: "Selecetd value")
    }
    "/seller_central/catalog/optin/optin_moderated/leave_suggestion/show"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/catalog/optin/optin_moderated/catalog_decision"(platform: "/web", isAbstract: true) {
        sellerCentralCatalogOptinGroup
    }
    "/seller_central/catalog/optin/optin_moderated/catalog_decision/confirm"(platform: "/web", type: TrackType.Event) {
        value(required: true, type: PropertyType.String, description: "Selecetd value")
    }
    "/seller_central/catalog/optin/optin_moderated/catalog_decision/show"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/catalog/optin/invalid_product"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/congrats"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
        sellerCentralCatalogOptinTaskGroup
    }

    "/seller_central/catalog/optin/congrats/redirect"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
        sellerCentralCatalogOptinTaskGroup
    }

    "/seller_central/catalog/optin/other_product_problem"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/variation_selection"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/product_comparator"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/optin_moderated/product_comparator/show"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/product_comparator/confirm"(platform: "/web", type: TrackType.View) {
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "OPTIN_V0_PRODUCT"])
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/invoice"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/optin_moderated/invoice/confirm"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        to(required: true, type: PropertyType.String, description: "The new value of a field, for example quantity, warranty,etc")
        from(required: false, type: PropertyType.String, description: "The original value of a field, for example quantity, warranty,etc")
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/category"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/optin_moderated/category/confirm"(platform: "/web", type: TrackType.View) {
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "OPTIN_V0_PRODUCT"])
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/product_problem"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/optin_moderated/product_problem/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/product_problem/return"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/product_problem/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        reason(required: true, type: PropertyType.String, description: "Reason of problem with the product", values: ["PRODUCT_ERRORS", "KIT", "OTHER"])
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/item_plus_card"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/optin_moderated/item_plus_card/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/item_plus_card/return"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/item_plus_card/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        reason(required: true, type: PropertyType.String, description: "Reason of problem with the product", values: ["PRODUCT_ERRORS", "KIT", "OTHER"])
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/optin_moderated/category_breadcrumb"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/optin_moderated/category_breadcrumb/mount"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN"])
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
    }

    "/seller_central/catalog/optin/optin_moderated/category_breadcrumb/update"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN"])
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
    }

    "/seller_central/catalog/optin/optin_moderated/product_bullet_resume"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/optin_moderated/product_bullet_resume/show"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN"])
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        product_title(required: true, description: "title of catalog product", type: PropertyType.String)
    }

    "/seller_central/catalog/optin/optin_moderated/v0_product_bullet_resume"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/optin_moderated/v0_product_bullet_resume/show"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN_V0_PRODUCT"])
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        product_title(required: true, description: "title of catalog product", type: PropertyType.String)
    }

    "/seller_central/catalog/optin/optin_moderated/congrats"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/product_comparator"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/item_plus/product_comparator/show"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/product_comparator/confirm"(platform: "/web", type: TrackType.View) {
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "OPTIN_V0_PRODUCT"])
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/invoice"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/item_plus/invoice/confirm"(platform: "/web", type: TrackType.View, parentPropertiesInherited: false) {
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        to(required: true, type: PropertyType.String, description: "The new value of a field, for example quantity, warranty,etc")
        from(required: false, type: PropertyType.String, description: "The original value of a field, for example quantity, warranty,etc")
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/category"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/item_plus/category/confirm"(platform: "/web", type: TrackType.View) {
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "OPTIN_V0_PRODUCT"])
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/product_problem"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/item_plus/product_problem/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/product_problem/return"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/product_problem/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        reason(required: true, type: PropertyType.String, description: "Reason of problem with the product", values: ["PRODUCT_ERRORS", "KIT", "OTHER"])
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/item_plus_card"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/item_plus/item_plus_card/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/item_plus_card/return"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/item_plus_card/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        reason(required: true, type: PropertyType.String, description: "Reason of problem with the product", values: ["PRODUCT_ERRORS", "KIT", "OTHER"])
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/item_plus/category_breadcrumb"(platform: "/web", isAbstract: true) {}
    "/seller_central/catalog/optin/item_plus/category_breadcrumb/mount"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN"])
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
    }

    "/seller_central/catalog/optin/item_plus/category_breadcrumb/update"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN"])
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
    }

    "/seller_central/catalog/optin/item_plus/congrats"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/other_product_problem/product_problem_description_task"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin/other_product_problem/product_problem_description_task/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited:false) {
        product_problem_reason(required: true, type: PropertyType.String, description: "Reason of other problem with the product")
        sellerCentralCatalogOptinGroup
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    |                                               OPTIN V2                                                      |
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    "/seller_central/catalog/optin_v2"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin_v2/init"(platform: "/web", type: TrackType.View) {
        item_id(required: true, type: PropertyType.String, description: "Item Id")
        category_id(required: false, type: PropertyType.String, description: "Id for category item")
        domain_id(required: true, type: PropertyType.String, description: "The category domain id")
        variation_id(required: false, type: PropertyType.Numeric, description: "The variation item")
        original_catalog_product_id(required: false, type: PropertyType.String, description: "The original item catalog product id")
        moderated(required: false, type: PropertyType.Boolean, description: "Determine if the item is moderated")
        variations_list_id(required: false, type: PropertyType.ArrayList(PropertyType.Numeric), description: "List of variations id of the original item")
        suggested_correction_product_id(required: false, description: "Suggested Correction product ID", type: PropertyType.String)
    }

    "/seller_central/catalog/optin_v2/variation_selection"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2Variations
    }

    "/seller_central/catalog/optin_v2/variation_selection/selected"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2Variations
        selected_variation_id(required: false, description: "Variation Selection", type: PropertyType.Numeric)
    }

    "/seller_central/catalog/optin_v2/congrats"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin_v2/congrats/success"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        confirmed_item_plus(required: false, description: "Confirmed Item Plus", type: PropertyType.Boolean)
        suggested_correction(required: false, description: "Confirmed Item Plus", type: PropertyType.Boolean)
    }

    "/seller_central/catalog/optin_v2/congrats/warning"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        reason(required: false, description: "Reason of warning congrats", type: PropertyType.String,  values: ["INACTIVE_PRODUCT", "CATALOG_NOT_REQUIRED", "PRODUCT_HAS_ERRORS_SUGGESTED", "WRONG_V0_PRODUCT", "PRODUCT_HAS_ERRORS", "IS_A_KIT"])
        suggested_correction(required: false, description: "Confirmed Item Plus", type: PropertyType.Boolean)
    }

    "/seller_central/catalog/optin_v2/product_comparator"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/product_comparator/selected"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        comparison_selected(required: true, description: "Comparison selected", type: PropertyType.String,  values: ["SAME_PRODUCT", "WRONG_PRODUCT"])
    }

    "/seller_central/catalog/optin_v2/suggested_corrections"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/suggested_corrections/selected"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        suggested_correction(required: true, description: "Suggested Correction", type: PropertyType.Boolean)
    }

    "/seller_central/catalog/optin_v2/product_search"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/product_search/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        response_type(required: true, description: "Response type of search", type: PropertyType.String,  values: ['one_shot', 'products', 'iterative_search'])
        search_value(required: true, description: "Title of search", type: PropertyType.String)
        product_selected(required: true, description: "Product Selection", type: PropertyType.String)
        product_index_selected(required: true, description: "Product Index Selection", type: PropertyType.Numeric)
    }

    "/seller_central/catalog/optin_v2/product_search/update"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        search_value(required: true, description: "Old title of search", type: PropertyType.String)
    }

    "/seller_central/catalog/optin_v2/iterative_search"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/iterative_search/update"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        iteration_count(required: false, description: "Iteration Count", type: PropertyType.Numeric)
    }

    "/seller_central/catalog/optin_v2/iterative_search/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        selected_catalog_product_id(required: false, type: PropertyType.String, description: "The optined item catalog product id")
    }

    "/seller_central/catalog/optin_v2/iterative_search/item_plus"(platform: "/web", type: TrackType.View) {
      sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/iterative_search/item_plus/return"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/iterative_search/item_plus/confirm"(platform: "/web", type: TrackType.View) {
      sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/iterative_search/category"(platform: "/web", type: TrackType.View) {
      sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/iterative_search/category/return"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/iterative_search/category/confirm"(platform: "/web", type: TrackType.View) {
      sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/review"(platform: "/web", type: TrackType.View) {
      sellerCentralCatalogOptinGroupV2
    }
    "/seller_central/catalog/optin_v2/catalog_no_required"(platform: "/web", type: TrackType.View) {
      sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/catalog_no_required/confirm"(platform: "/web", type: TrackType.View) {
      sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/product_problem"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/product_problem/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        wrong_type(required: true, description: "Wrong Type", type: PropertyType.String,  values: ["KIT", "PRODUCT_ERRORS", "OTHER"])
        v0(required: true, description: "Wrong Type", type: PropertyType.Boolean)
    }

    "/seller_central/catalog/optin_v2/product_problem/return"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/pictures"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/pictures/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV
    }

    "/seller_central/catalog/optin_v2/item_plus_step/gtin"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/gtin/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/title"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/title/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/description"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/description/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/button_update"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/item_plus_step/button_update/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
    }

    "/seller_central/catalog/optin_v2/invoice"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroupV2
        invoice_type(required: true, description: "Invoice Type", type: PropertyType.String,  values: ["ITEM_PLUS", "OPTIN"])
    }

    "/seller_central/catalog/optin_v2/invoice/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
        invoice_type(required: true, description: "Invoice Type", type: PropertyType.String,  values: ["ITEM_PLUS", "OPTIN"])
        invoice_selection(required: true, description: "Invoice Selection", type: PropertyType.Boolean)
    }

    "/seller_central/catalog/optin_v2/user_leaves"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroupV2
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    |                                             END OPTIN V2                                                    |
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    // + Paths for seller-centrall product suggestion

    "/seller_central/catalog/suggestion"(platform: "/web", isAbstract: true) {
        sellerCentralCatalogSuggestionGroup
    }

    "/seller_central/catalog/suggestion/suggest"(platform: "/web", type: TrackType.View) {}

    "/seller_central/catalog/suggestion/suggest/sent_suggestion"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/catalog/suggestion/suggest/invalid_suggestion"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/catalog/suggestion/congrats"(platform: "/web", type: TrackType.View) {}

    // - Paths for seller-centrall product suggestion

    "/seller_central/promotions"(platform: "/web", type: TrackType.View) {
        original_promotion(required: false, type: PropertyType.Map(originalPromotionStructure), description: "Original promotion data")
    }

    "/seller_central/promotions/actions"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller")
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
    }


    // CATALOG PRODUCTIZATION SECTION

    "/seller_central/catalog/productization"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogProductizationGroup
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "PRODUCTIZATION"])
    }

    "/seller_central/catalog/productization/products_finder_bar"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/productization/products_finder_bar/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
        sellerCentralCatalogProductizationGroup
    }

    "/seller_central/catalog/productization/products_finder"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/productization/products_finder/update"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        sellerCentralCatalogProductizationGroup
    }

    "/seller_central/catalog/productization/products_finder/product_selection"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        sellerCentralCatalogProductizationGroup
    }

    "/seller_central/catalog/productization/product_bullet_resume"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/productization/product_bullet_resume/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        sellerCentralCatalogProductizationGroup
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "PRODUCTIZATION"])
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        product_title(required: true, description: "title of catalog product", type: PropertyType.String)
    }

    "/seller_central/catalog/productization/category"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/productization/category/confirm"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        sellerCentralCatalogProductizationGroup
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["OPTIN", "PRODUCTIZATION"])
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        attribute_id(required: false, description: "Attribute id submitted", PropertyType.String)
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")
    }


    // ADD NEW PATHS FOR SELLER PROMOTIONS FORM
    // To be compatible with the actuals paths.
    "/seller_central/promotions/list"(platform: "/web", type: TrackType.View) {
        original_promotion(required: false, type: PropertyType.Map(originalPromotionStructure), description: "Original price_discount promotion data")
        original_lightning(required: false, type: PropertyType.Map(originalPromotionStructure), description: "Original lightning promotion data")
        original_dod(required: false, type: PropertyType.Map(originalPromotionStructure), description: "Original deal_of_they_day promotion data")
        context(required: false, type: PropertyType.String, description: "Context of the user", values: ["CREATE", "EDIT", "CREATE_LIGHTNING", "CREATE_DOD"])
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/confirm"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["CONFIRM", "CONFIRM_LIGHTNING", "CONFIRM_DOD"])
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
        origin(required: true, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/update"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["CONFIRM", "CONFIRM_LIGHTNING", "CONFIRM_DOD"])
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
        origin(required: true, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/delete"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["DELETE", "DELETE_LIGHTNING", "DELETE_DOD"])
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
        origin(required: true, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/error"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["CONFIRM", "CONFIRM_LIGHTNING", "CONFIRM_DOD", "DELETE", "DELETE_LIGHTNING", "DELETE_DOD"])
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
        error(required: false, type: PropertyType.String, description: "Error saving the promotion")
        origin(required: true, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/actions"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["DISABLE", "ENABLE", "RESET_PROMOTION", "RESET_PROMOTION_LIGHTNING", "RESET_PROMOTION_DOD", "DELETE_PROMOTION", "DELETE_PROMOTION_LIGHTNING", "DELETE_PROMOTION_DOD"])
        context(required: false, type: PropertyType.String, description: "Context of the user", values: ["CREATE", "EDIT", "PRIME_CHECKBOX", "RESET_PROMOTION"])
    }

    // ADD NEW PATHS FOR SELLER PROMOTIONS DISCOUNT TAB
    "/seller_central/promotions/filters"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/promotions/filters/applied"(platform: "/", type: TrackType.Event) {
        checkedFilters(required: true, type: PropertyType.ArrayList, description: "Id of the action")
    }

    "/seller_central/promotions/filters/action"(platform: "/") {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["apply", "clear"])
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        seller_id(required: false, type: PropertyType.Numeric, description: "The seller that triggered the action")
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        item_id(required: false, type: PropertyType.String, description: "Item id to which the action is executed")
        seller_id(required: false, type: PropertyType.Numeric, description: "The seller that triggered the action")
        operator_id(required: false, type: PropertyType.String, description: "If it is an operator, operator id that executes the action")
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
        promo_id(required: false, type: PropertyType.String, description: "Deals co-funded campaign identifier")
        seller_pct(required: false, type: PropertyType.Numeric, description: "percentage of discount assumed by the seller")
        meli_pct(required: false, type: PropertyType.Numeric, description: "percentage of discount assumed by meli")
        adv_pct(required: false, type: PropertyType.Numeric, description: "percentage of discount in advertising credit that is given to the seller")
    }

    "/seller_central/promotions/action/confirm"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        item_id(required: false, type: PropertyType.String, description: "Item id to which the action is executed")
        seller_id(required: false, type: PropertyType.Numeric, description: "The seller that triggered the action")
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
        promoId(required: false, type: PropertyType.String, description: "Card that was applied at the moment of confirmation, if any")
        promo_id(required: false, type: PropertyType.String, description: "Deals co-funded campaign identifier")
    }

    "/seller_central/promotions/action/error"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["CREATE", "CREATE_LIGHTNING", "CREATE_DOD", "CREATE_MARKETPLACE_CAMPAIGN", "DELETE", "DELETE_LIGHTNING", "DELETE_DOD", "DELETE_MARKETPLACE_CAMPAIGN"])
    }

    "/seller_central/promotions/action/tooltip_adv"(platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        promo_id(required: true, type: PropertyType.String, description: "Deals co-funded campaign identifier")
        item_id(required: true, type: PropertyType.String, description: "Item id to which the tooltip is executed")
    }

    "/seller_central/promotions/row/tooltip_help_adv"(platform: "/", type: TrackType.Event, parentPropertiesInherited:false) {
        promo_id(required: true, type: PropertyType.String, description: "Deals co-funded campaign identifier")
        item_id(required: true, type: PropertyType.String, description: "Item id to which the tooltip is executed")
    }

    "/seller_central/promotions/search"(platform: "/", type: TrackType.Event) {
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/promotions/list"(platform: "/", type: TrackType.Event) {}

    //LISTING - Secondary Actions Click
    "/seller_central/promotions/list/secondary_actions"(platform: "/", type: TrackType.Event) {
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        seller_id(required: false, type: PropertyType.Numeric, description: "The seller that triggered the action")
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    //LISTING - Candidates information
    "/seller_central/promotions/list/info"(platform: "/", type: TrackType.Event) {
        candidates(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Candidates for each type of promotion")
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/cards"(platform: "/", type: TrackType.Event) {}

    "/seller_central/promotions/cards/apply"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Applied filter type", values: ["dod", "lightning", "deal_of_the_day", "meli_campaign"])
        slide(required: false, type: PropertyType.Numeric, description: "Slide where the card is shown. Only tracked when there are multiple slides.")
        promo_id(required: false, type: PropertyType.String, description: "Promo id ")
        total_actives_items(required: false, type: PropertyType.Numeric, description: "number of total actives items")
        total_eligible_items(required: false, type: PropertyType.Numeric, description: "number of total elegible items")
        actives_items(required: false, type: PropertyType.ArrayList(PropertyType.Map(CardItemStructure)), description: "array of percentage data of active items")
        eligible_items(required: false, type: PropertyType.ArrayList(PropertyType.Map(CardItemStructure)), description: "total number of items that can be activated in promotion")
    }

    "/seller_central/promotions/onboarding"(platform: "/", type: TrackType.Event) {}

    "/seller_central/promotions/onboarding/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "rollback", "start"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
        viewId(required: false, type: PropertyType.String, description: "Onboarding id if applies")
    }

    "/seller_central/promotions/collapsible"(platform: "/", type: TrackType.View) {}

    "/seller_central/promotions/collapsible/opened"(platform: "/", type: TrackType.Event) {}

    "/seller_central/promotions/massive"(platform: "/", type: TrackType.View) {}

    "/seller_central/promotions/massive/add"(platform: "/", type: TrackType.Event) {}

    "/seller_central/promotions/massive/delete"(platform: "/", type: TrackType.Event) {}

    "/seller_central/promotions/massive/modify"(platform: "/", type: TrackType.Event) {}

    "/seller_central/promotions/massive/offline"(platform: "/", type: TrackType.Event) {}

    "/seller_central/promotions/massive/editor"(platform: "/", type: TrackType.View) {}

    "/seller_central/promotions/massive/editor/open"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.String, description: "Quantity of items")
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
        useFilters(required: true, type: PropertyType.Boolean, description: "If has filters applied")
    }

    "/seller_central/promotions/massive/editor/confirm"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.String, description: "Quantity of items")
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
        useFilters(required: true, type: PropertyType.Boolean, description: "If has filters applied")
        deleted(required: true, type: PropertyType.String, description: "Quantity of deleted items")
    }

    "/seller_central/promotions/massive/editor/cancel"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.String, description: "Quantity of items")
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
        useFilters(required: true, type: PropertyType.Boolean, description: "If has filters applied")
        deleted(required: true, type: PropertyType.String, description: "Quantity of deleted items")
    }

    "/seller_central/promotions/massive/editor/delete"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.String, description: "Quantity of items")
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
        useFilters(required: true, type: PropertyType.Boolean, description: "If has filters applied")
    }

    "/seller_central/promotions/massive/editor/toolbar"(platform: "/", type: TrackType.View) {}

    "/seller_central/promotions/massive/editor/toolbar/checkbox"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Toolbar checkbox action", values: ["select", "unselect"])
    }

    "/seller_central/promotions/massive/editor/offline"(platform: "/", type: TrackType.View) {}

    "/seller_central/promotions/massive/editor/offline/open"(platform: "/", type: TrackType.Event) {
        promoId(required: true, type: PropertyType.String, description: "Promotion Id")
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
    }

    "/seller_central/promotions/massive/editor/offline/upload"(platform: "/", type: TrackType.Event) {
        promoId(required: true, type: PropertyType.String, description: "Promotion Id")
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
    }

    "/seller_central/promotions/massive/editor/offline/categories"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
    }

    "/seller_central/promotions/massive/editor/offline/download"(platform: "/", type: TrackType.Event) {
        promoId(required: true, type: PropertyType.String, description: "Promotion Id")
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
    }

    "/seller_central/promotions/massive/editor/offline/email"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Promotion type", values: ["deal_of_the_day", "lightning", "pre_negotiated", "tiers", "co_funded", "volume"])
    }

    "/seller_central/promotions/massive/modal"(platform: "/", type: TrackType.View) {}

    "/seller_central/promotions/massive/modal/add"(platform: "/", type: TrackType.Event) {
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/massive/modal/delete"(platform: "/", type: TrackType.Event) {
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/widget"(platform: "/", type: TrackType.View) {}

    "/seller_central/promotions/widget/header"(platform: "/", type: TrackType.Event) {
        collapsed(required: true, type: PropertyType.Boolean, description: "If widget is collapsed")
    }

    "/seller_central/promotions/widget/dismiss"(platform: "/", type: TrackType.Event) {
        batch_id(required: true, type: PropertyType.String, description: "Id of batch to delete from widget")
    }

    "/seller_central/promotions/widget/close"(platform: "/", type: TrackType.Event) {
        processing(required: false, type: PropertyType.Boolean, description: "If widget is closed with processing batches")
        batch_ids(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Ids of batches to delete from widget")
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS SYI V4 - RealEstate
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify/detail/title_and_description"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/title_and_description/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/title_and_description/confirm"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/instant_pay_listings_info"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/instant_pay_listings_info/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/instant_pay_listings_info/confirm"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/listing_highlight_package_info"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/listing_highlight_package_info/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/listing_highlight_package_info/confirm"(platform: "/", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central Questions
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/questions"(platform: "/", type: TrackType.View) {}

    "/seller_central/questions/item"(platform: "/", type: TrackType.View) {}

    "/seller_central/questions/response"(platform: "/", type: TrackType.Event) {
        sellerCentralActionQuestionsGroup
    }

    "/seller_central/questions/delete"(platform: "/", type: TrackType.Event) {
        sellerCentralActionQuestionsGroup
    }

    "/seller_central/questions/denunciation"(platform: "/", type: TrackType.Event) {
        sellerCentralActionQuestionsGroup
    }

    "/seller_central/questions/block_buyer"(platform: "/", type: TrackType.Event) {
        sellerCentralActionQuestionsGroup
    }

    "/seller_central/questions/modal_stock"(platform: "/", type: TrackType.Event) {
        sellerCentralModalQuestionsGroup
    }

    "/seller_central/questions/modal_advice"(platform: "/", type: TrackType.Event) {
        sellerCentralModalQuestionsGroup
    }

    "/seller_central/questions/survey"(platform: "/", type: TrackType.Event) {
        hotjar_survey(required: true, type: PropertyType.String, description: "hotjar survey value")
    }

    "/seller_central/questions/filter"(platform: "/", type: TrackType.Event) {
        period(required: true, description: "The time frame to search questions", type: PropertyType.String)
        status(required: false, description: "The status of the question consulted", type: PropertyType.String)
        user_type(required: true, description: "The type of user looking for their questions", type: PropertyType.String)
    }


    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central Buyer Questions
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/buyer_questions"(platform: "/", type: TrackType.View) {}

    "/seller_central/buyer_questions/list_by_item"(platform: "/", type: TrackType.View) {}

    "/seller_central/buyer_questions/list_by_question"(platform: "/", type: TrackType.View) {}

    "/seller_central/buyer_questions/make_question_intention"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item id to which the question is sent")
    }

    "/seller_central/buyer_questions/delete_all_questions"(platform: "/", type: TrackType.Event) {
        item_id(required: false, type: PropertyType.String, description: "Item id needed to delete questions")
        failed(required: true, type: PropertyType.Boolean, description: "To know if the question have been deleted")
    }

    "/seller_central/buyer_questions/delete_all_questions_intention"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item id from questions to delete")
    }

    "/seller_central/buyer_questions/denounce_answer"(platform: "/", type: TrackType.Event) {
        item_id(required: false, type: PropertyType.String, description: "Item id to which the answer is denounced")
        question_id(requested: false, type: PropertyType.Numeric, description: "Question id to which the answer is denounced")
        failed(required: true, type: PropertyType.Boolean, description: "To know if the answer has been denounced")
    }

    "/seller_central/buyer_questions/denounce_answer_intention"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item id needed to denounce")
        question_id(requested: true, type: PropertyType.Numeric, description: "Question id needed to denounce")
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central Optinator New Listing
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/optinator"(platform: "/web", isAbstract: true) {}
    "/seller_central/optinator/new_listing"(platform: "/web", isAbstract: true) {}

    "/seller_central/optinator/new_listing/end"(platform: "/web", type: TrackType.Event) {
        sellerCentralOptinatorNewListingsGroup
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central - SYI ME1 Config
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/me1_transport_config"(platform: "/web", isAbstract: true) {}

    "/seller_central/me1_transport_config/hub"(platform: "/web", type: TrackType.View) {}

    "/seller_central/me1_transport_config/upload"(platform: "/web", type: TrackType.View) {}

    "/seller_central/me1_transport_config/congrats"(platform: "/web", type: TrackType.View) {}

    "/seller_central/me1_transport_config/upload/upload_files"(platform: "/web", type: TrackType.Event) {
        number_of_files(required: true, type: PropertyType.Numeric, description: "Number of files uploaded by the user")
    }

    "/seller_central/me1_transport_config/upload/exceed_characters_limit"(platform: "/web", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central - Split Orders
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/split_orders"(platform: "/web", isAbstract: true) {}

    "/seller_central/split_orders/splitter"(platform: "/web", isAbstract: true) {}

    "/seller_central/split_orders/splitter/prepare"(platform: "/web", type: TrackType.View) {}

    "/seller_central/split_orders/splitter/prepare/action"(platform: "/web", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "The action id", values: ["PREPARE", "CANCEL"])
        sellerCentralSplitOrdersGroup
    }

    "/seller_central/split_orders/splitter/split"(platform: "/web", type: TrackType.View) {}

    "/seller_central/split_orders/splitter/split/action"(platform: "/web", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "The action id", values: ["SPLIT", "CANCEL"])
        sellerCentralSplitOrdersGroup
    }

    "/seller_central/split_orders/congrats"(platform: "/web", type: TrackType.View) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // PRODUCTS LANDING PATHS
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/products_landing"(platform: "/web", isAbstract: true) {}

    "/seller_central/products_landing/home"(platform: "/web", isAbstract: true) {}
    "/seller_central/products_landing/home/code_help"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/products_landing/home/show"(platform: "/web", type: TrackType.View) {}

    "/seller_central/products_landing/search"(platform: "/web", isAbstract: true) {}
    "/seller_central/products_landing/search/code_help"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/products_landing/search/show"(platform: "/web", type: TrackType.View) {
        productsLandingDataGroup
    }

    "/seller_central/products_landing/search/publish"(platform: "/web", type: TrackType.Event) {
        productsLandingDataGroup
        productsLandingRowGroup
    }

    "/seller_central/products_landing/search/copied_code"(platform: "/web", type: TrackType.Event) {
        productsLandingDataGroup
        productsLandingRowGroup
    }

    "/seller_central/products_landing/search/tech_spec_show"(platform: "/web", type: TrackType.View) {
        productsLandingDataGroup
        productsLandingRowGroup
    }

    "/seller_central/products_landing/search/copied_product_row"(platform: "/web", type: TrackType.View) {
        productsLandingDataGroup
        productsLandingRowGroup
    }

    "/seller_central/products_landing/search/copied_products"(platform: "/web", type: TrackType.Event) {
        productsLandingDataGroup
        copied_products(required: true, type: PropertyType.ArrayList(PropertyType.Map(productsLandingRowStructure)), description: "This property describe copied products")
    }
    // FINAL PRODUCTS LANDING PATHS

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central Verifications
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/verification/result"(platform: "/", type: TrackType.Event) {
        syi_data (required:true, type: PropertyType.Map(syiVerificationStructure), description: "SYI object to validate")
        drat_data (required:true, type: PropertyType.Map(dratStructure), description: "Data recovery and transformation service response to validate")
        verified (required:true, type: PropertyType.Boolean, description: "Validation result between SYI and DRAT data")
    }

    "/seller_central/gema"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/gema/usage"(platform: "/web", type: TrackType.Event) {
        use_gema (required:true, type: PropertyType.Boolean, description: "Validate if the user use our new application")
        seller_reputation (required:true, type: PropertyType.String, description: "Seller Reputation")
    }

    "/seller_central/price_suggestion/bands"(platform: "/", type: TrackType.Event){
        app_name (required:true, type: PropertyType.String, description: "App name from each app which uses price suggestion")
        client_id (required:false, type: PropertyType.Numeric, description: "Client id from each app which uses price suggestion")
        item_id (required:false, type: PropertyType.String, description: "Item id")
        attributes(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributesStructure)), description: "attributes")
        prices_bands (required: true, type: PropertyType.Map(pricesBandsStructure), description: "bands from suggestion")
        price (required:true, type: PropertyType.String, description: "Item price")
    }
}
