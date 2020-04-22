package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

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
        id(type: PropertyType.String, required: true)
        seller_id(type: PropertyType.Numeric, required: true)
        buying_mode(type: PropertyType.String, required: true)
        sale_terms(type: PropertyType.ArrayList(PropertyType.Map(saleTermStructure)), required: false)
        campaigns(type: PropertyType.ArrayList(PropertyType.String), required: false)
        best_offer(type: PropertyType.Numeric, required: false)
        price(type: PropertyType.Numeric, required: false)
        original_price(type: PropertyType.Numeric, required: false)
        promotion(type: PropertyType.Map(promotionStructure), required: false)
        visits(type: PropertyType.Numeric, required: true)
        available_quantity(type: PropertyType.Numeric, required: true)
        title(type: PropertyType.String, required: true)
        sold_quantity(type: PropertyType.Numeric, required: true)
        secure_thumbnail(type: PropertyType.String, required: true)
        currency(type: PropertyType.Map(currencyStructure), required: false)
        tags(type: PropertyType.ArrayList(PropertyType.String), required: false)
        validations(type: PropertyType.ArrayList(PropertyType.String), required: false)
        campaign_offers(type: PropertyType.ArrayList(PropertyType.Map(campaingOffersStructure)), required: false)
    }

    //  FINAL PROMO STRUCTURE
    def finalPromotionStructure = objectSchemaDefinitions {
        state(type: PropertyType.String, required: false)
        site_time_offset(type: PropertyType.Numeric, required: false)
        start_date(type: PropertyType.String, required: true)
        finish_date(type: PropertyType.String, required: true)
        is_highlight(type: PropertyType.Boolean, required: false)
        price(type: PropertyType.Numeric, required: true)
        prime_price(type: PropertyType.Numeric, required: false)
        list_price(type: PropertyType.Numeric, required: true)
        error_price(type: PropertyType.String, required: false)
        error_prime(type: PropertyType.String, required: false)
        input_price(type: PropertyType.String, required: true)
        input_prime_price(type: PropertyType.String, required: false)
        type(type: PropertyType.String, required: true)
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
        item_type(required: true, type: PropertyType.String, description: "product: A PDP item, default: A normal item, associated_products: A item which has at least 1 variation that is associated  with a product", values: ["product", "default", "associated_products"])

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
        has_variations_already_opt_in(required: true, type: PropertyType.Boolean, description: "True if the item has a variation optined")
        invalid_product_cause(required: false, type: PropertyType.String, description: "The invalid product causes")
        opt_in_item_id(required: false, type: PropertyType.String, description: "The optined item id")
        children_catalog_products_ids(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The list of the children catalog products ids")
        has_variations(required: true, type: PropertyType.Boolean, description: "True if the item has variations")
        task_id(required: true, type: PropertyType.String, description: "The task id that has been modified")

        item_attributes(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributes_values_map)), description: "List of attributes from the original item")
        catalog_product_attributes(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributes_values_map)), description: "List of attributes from the product associated to an item")
        item_title(required: true, type: PropertyType.String, description: "Item title")
        catalog_product_title(required: true, type: PropertyType.String, description: "Product title associated with an item")
        vertical(required: false, type: PropertyType.String, values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        mercado_lider(required: false, type: PropertyType.Boolean, description: "Seller is mercadolider")
        user_type(required: false, type: PropertyType.String, description: "The user type")

    }

    propertyGroups {
        sellerCentralModifyGroup(item_id, session_id, item_type)
        sellerCentralModifyCardsGroup(category_id, seller_profile, category_domain, category_path, catalog_product_id, listing_type, shipping_local_pickup, seller_reputation, vertical)
        sellerCentralModifyGroupTableForPdp(comparison_table, competition_status, new_competition_status, winner_item_id, price_to_win)
        sellerCentralModifyCardsGroupValue(to, from)
        sellerCentralSettingsGroup(seller_profile, reputation_level)
        technicalSpecificationsGroup(category_domain, attribute, hierarchy)
        hintsGroup(type, attribute)

        sellerCentralCatalogOptinGroup(item_id, session_id, category_id, category_path, category_domain, original_catalog_product_id, variation_id, has_variations_already_opt_in, children_catalog_products_ids, has_variations, seller_profile, reputation_level, selected_catalog_product_id, opt_in_item_id, invalid_product_cause)
        sellerCentralCatalogOptinTaskGroup(task_id, to, from)

        sellerCentralCatalogBoostGroup(item_attributes, catalog_product_attributes, item_title, catalog_product_title)

        sellerCentralUserSales(seller_profile, seller_reputation, mercado_lider, seller_segment, user_type)
    }

    // Summary
    "/seller_central/summary"(platform: "/web", type: TrackType.View) {}

    // La idea es saber como fue la ejecución de cada módulo
    "/seller_central/summary/modules_render"(platform: "/web", type: TrackType.Event) {
        modules(required: true, type: PropertyType.ArrayList(PropertyType.Map(summaryModule)), description: "Array of modules")
        seller_experience(required: false, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE','INTERMEDIATE','ADVANCED'])
    }


    //LISTING SECTION
    "/seller_central"(platform: "/", isAbstract: true) {}
    "/seller_central/listings"(platform: "/", isAbstract: true) {}
    "/seller_central/listings/quantity"(platform: "/", isAbstract: true) {}
    "/seller_central/listings/inventory_status"(platform: "/", isAbstract: true) {}
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {
      view_id(required:false, type: PropertyType.String, descritpion: "View that has been called")
    }

    "/seller_central/listings/onboarding"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "rollback", "start"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
        viewId(required:false, type: PropertyType.String, descritpion: "Onboarding id if applies")
    }

    "/seller_central/listings/onboarding/pdp"(platform: "/", type: TrackType.View) {}

    "/seller_central/listings/onboarding/pdp/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["accept", "cancel"])
    }


    "/seller_central/listings/hunting"(platform: "/", isAbstract: true) {
        view_id(required:true, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    "/seller_central/listings/hunting/change_step"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/hunting/view_more"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/hunting/sell_with_full"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of the communication", values: ["news", "task"])
        id(required: false, type: PropertyType.String, description: "Id of the communication ")
        action(required:false, type: PropertyType.String, description: "The action used in the communication if applies")
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    "/seller_central/listings/communication/show"(platform: "/", type: TrackType.View) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Adevrtasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    "/seller_central/listings/communication/go"(platform: "/", type: TrackType.Event) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Adevrtasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    "/seller_central/listings/communication/more_info"(platform: "/mobile", type: TrackType.Event) {}

    "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/helpme"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/filters"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/listings/filters/applied"(platform: "/", type: TrackType.Event) {
        checkedFilters(required: true, type: PropertyType.ArrayList, description: "Id of the action")
    }

    "/seller_central/listings/filters/action"(platform: "/") {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["apply", "clear"])
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
        checked_filters(required:false, type: PropertyType.ArrayList(PropertyType.String), description: "List of filters applied")
    }

    "/seller_central/listings/search"(platform: "/", type: TrackType.Event) {
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required:false, type: PropertyType.String, description: "View where the event has been called")
        item_id(required:false, type: PropertyType.String, description: "Item id to which the action is executed")
        inventory_id(required:false, type: PropertyType.String, description: "Inventory id to which the action is executed")
        operator_id(required:false, type: PropertyType.String, description: "If it is an operator, operator id that executes the action")
    }

    "/seller_central/listings/action/confirm"(platform: "/", type: TrackType.Event) {
        id_row_selected(required:false, type: PropertyType.String, description: "Row id to which the action is executed")
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required:false, type: PropertyType.String, description: "View where the event has been called")
        item_id(required:false, type: PropertyType.String, description: "Item id to which the action is executed")
        id_row_selected(required:false, type: PropertyType.String, description: "Row id to which the action is executed")
        has_variations(required: false, type: PropertyType.Boolean, description: "If the item to which the action is executed has variations")
        operator_id(required:false, type: PropertyType.String, description: "If it is an operator, operator id that executes the action")
    }

    "/seller_central/listings/massive_action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required:false, type: PropertyType.String, description: "View where the event has been called")
        count(required: true, type: PropertyType.Numeric, description: "Selected rows count")

    }

    "/seller_central/listings/preferences"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Preference id", values:["shipping", "advertising"])
    }

    "/seller_central/listings/quantity/info"(platform: "/", type: TrackType.Event) {
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    "/seller_central/listings/inventory_status/remedy"(platform: "/", type: TrackType.Event) {
        id(required:true, type: PropertyType.String, descritpion: "Id of the remedy applied to solve moderation")
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    //LISTING SECTION - TABS
    "/seller_central/listings/list/promos"(platform: "/", type: TrackType.Event) {}

    //LISTING - Item Description
    "/seller_central/listings/list/item_description"(platform: "/", type: TrackType.Event) {}
    "/seller_central/listings/list/health"(platform: "/", type: TrackType.Event) {
        health_id(required: true, type: PropertyType.String, description: "Health id")
    }

    "/seller_central/listings/list/moderation"(platform: "/", type: TrackType.Event) {
        moderation_id(required: true, type: PropertyType.String, description: "Moderation id")
    }

    //LISTING - Secondary Actions Click
    "/seller_central/listings/list/secondary_actions"(platform: "/", type: TrackType.Event) {
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    //BULK SECTION
    "/seller_central/bulk"(platform: "/", isAbstract: true) {}
    "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values:["start","close", "rollback", "dismiss"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
        viewId(required:false, type: PropertyType.String, descritpion: "Onboarding id if applies")

    }

    "/seller_central/bulk/domain"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the domaing group")
    }

    "/seller_central/bulk/filters"(platform: "/", type: TrackType.Event) {
        filters(required: true, type: PropertyType.ArrayList, description: "List of selected filters")
    }

    "/seller_central/bulk/search"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/undo_changes"(platform: "/", type: TrackType.Event) {}


    "/seller_central/bulk/columns"(platform: "/", type: TrackType.Event){
        columns(required: true, type: PropertyType.ArrayList, description: "List of the available columns and his order")
    }

    "/seller_central/bulk/changes"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/changes/price"(platform: "/", type: TrackType.Event) {
        oldValue(required: true, type: PropertyType.String, description: "Old value of the price cell")
        newValue(required: true, type: PropertyType.String, description: "New value")
        item_id(required: true, type: PropertyType.String, description: "Id of the modified item")
    }

    "/seller_central/bulk/shipping"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/shipping/tooltip"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "item's id that showed the tooltip")
    }

    "/seller_central/bulk/offline"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/offline/home"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/upload"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download/user_selection"(platform: "/", type: TrackType.Event){
        columns(required: true, type: PropertyType.ArrayList, description: "List of the selected columns")
        domains(required: true, type: PropertyType.ArrayList, description: "List of the selected domains")
    }

    "/seller_central/bulk/offline/download/error"(platform: "/", type: TrackType.Event){}

    "/seller_central/bulk/offline/download/warning"(platform: "/", type: TrackType.Event){}

    "/seller_central/bulk/open_tooltip"(platform: "/", type: TrackType.View) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central BULK Offline Cbt
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/bulk/offline/cbt"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/offline/cbt/hub"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/cbt/download"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/cbt/upload"(platform: "/", type: TrackType.View) {}


    "/seller_central/bulk/offline/cbt/download/confirm"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.Numeric, description: "Amount of downloaded items")
        filters(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "List of applied filters")
        categories(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "List of applied categories")
    }

    "/seller_central/bulk/offline/cbt/download/congrats"(platform: "/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: "Which congrats is the user redirected", values:["success","failed", "partial", "no changes", "mail"])
    }


    "/seller_central/bulk/offline/cbt/upload/congrats"(platform: "/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: "Which congrats is the user redirected", values:["success","failed", "partial", "no changes", "mail"])
    }


    //BULK SECTION - DISCOUNTS VERSION

    "/seller_central/bulk/discounts"(platform: "/", isAbstract: true) {}
    "/seller_central/bulk/discounts/list"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values:["start","close", "rollback", "dismiss"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
    }

    "/seller_central/bulk/discounts/filters"(platform: "/", type: TrackType.Event) {
        filters(required: true, type: PropertyType.ArrayList, description: "List of selected filters")
    }

    "/seller_central/bulk/discounts/search"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/discounts/undo_changes"(platform: "/", type: TrackType.Event) {}


    "/seller_central/bulk/discounts/columns"(platform: "/", type: TrackType.Event){
        columns(required: true, type: PropertyType.ArrayList, description: "List of the available columns and his order")
    }

    "/seller_central/bulk/discounts/save"(platform: "/", type: TrackType.Event) {}

    "/seller_central/bulk/discounts/offline"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/discounts/offline/home"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/download"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/download/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/upload"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/upload/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/discounts/offline/download/user_selection"(platform: "/", type: TrackType.Event){
        columns(required: true, type: PropertyType.ArrayList, description: "List of the selected columns")
        domains(required: true, type: PropertyType.ArrayList, description: "List of the selected domains")
    }

    "/seller_central/bulk/discounts/offline/download/error"(platform: "/", type: TrackType.Event){}

    "/seller_central/bulk/discounts/offline/download/warning"(platform: "/", type: TrackType.Event){}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central BULK Offline Cbt
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/bulk/offline"(platform: "/", isAbstract: true) {}

    "/seller_central/bulk/offline/home"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/upload"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller Central BULK Publish
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/bulk/publish"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish/hub"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/categories"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/download"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish/download/congrats"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/upload"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/upload/show_custom_mail_box"(platform: "/web", type: TrackType.Event) {
        show_custom_mail_box(required: true, type: PropertyType.Boolean, description: "Value to know if user has clicked on Add other email")
    }

    "/seller_central/bulk/publish/upload/send_custom_mail_box"(platform: "/web", type: TrackType.Event) {
        show_custom_mail_box(required: true, type: PropertyType.Boolean, description: "Value to know if user has clicked on Add other email")
        custom_mail(required: true, type: PropertyType.Boolean, description: "Value to know if user was completed the custom email field")
        invalid_mail(required: true, type: PropertyType.Boolean, description: "Value to know if email value is valid or invalid")
    }

    "/seller_central/bulk/publish/upload/congrats"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/categories/download_excel"(platform: "/web", type: TrackType.Event) {
        total(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded")
        last_published(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from last published section")
        most_used(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from most used section")
        search_list(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from search section")
        modal(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from modal")
    }

    "/seller_central/bulk/publish/categories/adult"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish/categories/adult/confirm"(platform: "/web", type: TrackType.Event) {
        adult(required: true, type: PropertyType.Boolean, description: "Value to know if user has select adult checkbox")
    }

    "/seller_central/bulk/publish/categories/adult/modal"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Modal action", values: ['confirm', 'cancel', 'show'])
        adult(required: true, type: PropertyType.Boolean, description: "Value to know if user has select adult checkbox")
    }

    "/seller_central/bulk/publish/categories/adult/modal/show"(platform: "/web", parentPropertiesInherited:false, type: TrackType.View) {
        adult(required: true, type: PropertyType.Boolean, description: "Value to know if user has select adult checkbox")
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central modify
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify"(platform: "/", isAbstract: true) {
        sellerCentralModifyGroup
    }

    "/seller_central/modify/detail"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/variations"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/variations_custom"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/listing_type"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyGroupTableForPdp
    }

    "/seller_central/modify/subflow"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/update_price"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
        sellerCentralModifyGroupTableForPdp
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

    /**
     * La idea es trackear en el snackbar informacion
     * del item original y algunos cambios que se produjeron.
     */
    "/seller_central/modify/success"(platform: "/web", type: TrackType.Event){
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
        seller_experience(required: true, type: PropertyType.String, description: "Type of experience. ", values: ['NEWBIE','INTERMEDIATE','ADVANCED'])
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
        seller_reasons(required: true, type: PropertyType.String, description: "reasons why a seller has decided not associate its item to a catalog product" )
    }

    "/seller_central/modify/catalog_boost/modal/cancel"(platform: "/", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS CLASSI V4
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify/detail/quick_edit_standard"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/quick_edit_standard/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/quick_edit_standard/confirm"(platform: "/", type: TrackType.Event) {}


    "/seller_central/modify/detail/seller_contact"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/seller_contact/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/seller_contact/confirm"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/reservation_info"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/reservation_info/show"(platform: "/", type: TrackType.Event) {}

    "/seller_central/modify/detail/location"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/location/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/location/confirm"(platform: "/", type: TrackType.Event) {}

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
    // TRACKS Seller central Structured Data
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify/technical_specifications"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/technical_specifications/hints"(platform: "/", isAbstract: true) {
        hintsGroup
        category_domain(required: true, type: PropertyType.String, description: "Item category domain")
        hint_id(required: true, type: PropertyType.String, description: "Id del hint que se mostro, pueden cambiar o generarse nuevos por lo que no conocemos todos los valores posibles.")
    }

    "/seller_central/modify/technical_specifications/hints/available"(platform: "/", type: TrackType.Event) {

    }

    "/seller_central/modify/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event) {
    }

    "/seller_central/modify/technical_specifications/hints/completed"(platform: "/", type: TrackType.Event) {
        user_action(required: false, type: PropertyType.String, description: "Type of user action", values: ["click", "write"])
    }

    "/seller_central/modify/optin_flex_subflow"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
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

    "/seller_central/modify/technical_specifications/completed_attributes"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyGroup
        domain_id(required: true, type: PropertyType.String)
        attributes_before_update(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributeStructure)), description: "Completed attributes defore update")
        attributes_after_update(required: true, type: PropertyType.ArrayList(PropertyType.Map(attributeStructure)), description: "Completed attributes after update")
    }

    "/seller_central/modify/detail/technical_specifications"(platform: "/", isAbstract: true) {}
    "/seller_central/modify/detail/technical_specifications/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/modify/detail/technical_specifications/confirm"(platform: "/", type: TrackType.Event) {}


    // SETTINGS SECTION

    "/seller_central/settings"(platform: "/", type: TrackType.View) {
        sellerCentralSettingsGroup
    }

    "/seller_central/empty_settings"(platform: "/", type: TrackType.View) {
        sellerCentralSettingsGroup
    }

    "/seller_central/settings/show_row"(platform: "/", type: TrackType.Event) {
        row_id(required: true, type: PropertyType.String, description: "Row Id displayed")
        ui_type(required: true, type: PropertyType.String, description: "UI Type of row", values: ["row","row_disabled","row_error"])
        section(required: true, type: PropertyType.String, description: "Section where the row is display")
    }

    "/seller_central/settings/update_row"(platform: "/", type: TrackType.Event) {
        to(required: true, type: PropertyType.String, description: "New value of the row")
        from(required: false, type: PropertyType.String, description: "Previous value of the row")
        section_id(required: true, type: PropertyType.String, description: "Section of the row")
        row_id(required: true, type: PropertyType.String, description: "Row Id")
    }

    // SALES SECTION

    "/seller_central/sales"(platform: "/", isAbstract: true) {}

    "/seller_central/sales/list"(platform: "/", type: TrackType.View) {
        sellerCentralUserSales
    }

    "/seller_central/sales/list/onboarding"(platform: "/", isAbstract: true, parentPropertiesInherited: false) {}
    "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "start"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
    }

    "/seller_central/sales/list/onboarding/massive"(platform: "/", isAbstract: true,  parentPropertiesInherited: false) {}
    "/seller_central/sales/list/onboarding/massive/confirm"(platform: "/", type: TrackType.Event) {}
    "/seller_central/sales/list/onboarding/massive/close"(platform: "/", type: TrackType.Event) {}

    "/seller_central/sales/list/nfe_onboarding"(platform: "/", isAbstract: true, parentPropertiesInherited:false) {}
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
    "/seller_central/sales/list/filters/open"(platform: "/web", type: TrackType.Event,  parentPropertiesInherited: false) {}
    "/seller_central/sales/list/filters/action"(platform: "/", type: TrackType.Event,  parentPropertiesInherited: false) {
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

    "/seller_central/sales/list/action"(platform: "/web", isAbstract: true, parentPropertiesInherited: false) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/list/action/primary"(platform: "/web", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
        filters(required: false, type: PropertyType.ArrayList, description: "List of applied filters")
        sellerCentralUserSales


    }
    "/seller_central/sales/list/action/primary/show"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false ) {
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
    "/seller_central/sales/detail/action/print"(platform: "/web", parentPropertiesInherited:false, type: TrackType.Event) {}

    "/seller_central/sales/detail/modal_action"(platform: "/web", isAbstract: true) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/detail/modal_action/open"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/detail/modal_action/close"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/sales/detail/modal_action/apply"(platform: "/web", type: TrackType.Event) {
        option(required: false, type: PropertyType.String, description: "Option selected")
    }

    "/seller_central/sales/detail/main_action"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "ID of main action")
    }

    "/seller_central/sales/detail/secondary_action"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "ID of secondary action")
    }

    "/seller_central/sales/detail/payment"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/shipping"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/sales/detail/shipping/action"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "ID of shipping action")
    }

    "/seller_central/sales/detail/invoice_info"(platform: "/mobile", type: TrackType.View) {}

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

    // CATALOG OPTIN SECTION

    "/seller_central/catalog"(platform: "/web", isAbstract: true) {}

    "/seller_central/catalog/optin"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/invalid_product"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/congrats"(platform: "/web", type: TrackType.View) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/confirm"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
        sellerCentralCatalogOptinTaskGroup
    }

    "/seller_central/catalog/optin/button/redirect"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/catalog/optin/link/redirect"(platform: "/web", type: TrackType.Event) {
        sellerCentralCatalogOptinGroup
    }

    "/seller_central/promotions"(platform: "/web", type: TrackType.View) {
        original_promotion(required: false, type: PropertyType.Map(originalPromotionStructure), description: "Original promotion data")
    }

    "/seller_central/promotions/actions"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller")
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
    }

    // ADD NEW PATHS FOR SELLER PROMOTIONS FORM
    // To be compatible with the actuals paths.
    "/seller_central/promotions/list"(platform: "/web", type: TrackType.View) {
        original_promotion(required: false, type: PropertyType.Map(originalPromotionStructure), description: "Original promotion data")
        context(required: false, type: PropertyType.String, description: "Context of the user", values: ["CREATE", "EDIT"])
    }

    "/seller_central/promotions/list/confirm"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["CONFIRM", "CONFIRM_LIGHTNING"])
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
        origin(required:false, type: PropertyType.String, descritpion: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/update"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["CONFIRM", "CONFIRM_LIGHTNING"])
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
        origin(required:false, type: PropertyType.String, descritpion: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/delete"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["DELETE", "DELETE_LIGHTNING"])
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
        origin(required:false, type: PropertyType.String, descritpion: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/error"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["CONFIRM", "CONFIRM_LIGHTNING", "DELETE", "DELETE_LIGHTNING"])
        promotion(required: true, type: PropertyType.Map(finalPromotionStructure), description: "Final promotion data")
        promotion_duration(required: false, type: PropertyType.Numeric, description: "Duration for the new promotion")
        error(required: false, type: PropertyType.String, description: "Error saving the promotion")
        origin(required:false, type: PropertyType.String, descritpion: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/list/actions"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action executed by the seller", values: ["DISABLE", "ENABLE", "RESET_PROMOTION", "RESET_PROMOTION_LIGHTNING", "DELETE_PROMOTION", "DELETE_PROMOTION_LIGHTNING"])
        context(required: false, type: PropertyType.String, description: "Context of the user", values: ["CREATE", "EDIT", "PRIME_CHECKBOX", "RESET_PROMOTION"])
    }

    // ADD NEW PATHS FOR SELLER PROMOTIONS DISCOUNT TAB
    "/seller_central/promotions/filters"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/promotions/filters/applied"(platform: "/", type: TrackType.Event) {
        checkedFilters(required: true, type: PropertyType.ArrayList, description: "Id of the action")
    }

    "/seller_central/promotions/filters/action"(platform: "/") {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["apply", "clear"])
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
        seller_id(required: false, type: PropertyType.Numeric, description: "The seller that triggered the action")
        origin(required:false, type: PropertyType.String, descritpion: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required:false, type: PropertyType.String, description: "View where the event has been called")
        item_id(required:false, type: PropertyType.String, description: "Item id to which the action is executed")
        seller_id(required: false, type: PropertyType.Numeric, description: "The seller that triggered the action")
        inventory_id(required:false, type: PropertyType.String, description: "Inventory id to which the action is executed")
        operator_id(required:false, type: PropertyType.String, description: "If it is an operator, operator id that executes the action")
        origin(required:false, type: PropertyType.String, descritpion: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/action/confirm"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required:false, type: PropertyType.String, description: "View where the event has been called")
        item_id(required:false, type: PropertyType.String, description: "Item id to which the action is executed")
        seller_id(required: false, type: PropertyType.Numeric, description: "The seller that triggered the action")
        id_row_selected(required:false, type: PropertyType.String, description: "Row id to which the action is executed")
        has_variations(required: false, type: PropertyType.Boolean, description: "If the item to which the action is executed has variations")
        operator_id(required:false, type: PropertyType.String, description: "If it is an operator, operator id that executes the action")
        origin(required:false, type: PropertyType.String, descritpion: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

    "/seller_central/promotions/search"(platform: "/", type: TrackType.Event) {
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
    }

    "/seller_central/promotions/list"(platform: "/", type: TrackType.Event) {}

    //LISTING - Secondary Actions Click
    "/seller_central/promotions/list/secondary_actions"(platform: "/", type: TrackType.Event) {
        view_id(required:false, type: PropertyType.String, descritpion: "View where the event has been called")
        seller_id(required: false, type: PropertyType.Numeric, description: "The seller that triggered the action")
        origin(required:false, type: PropertyType.String, descritpion: "View where the event has been called", values: ["listing", "promos", "mail"])
    }

}