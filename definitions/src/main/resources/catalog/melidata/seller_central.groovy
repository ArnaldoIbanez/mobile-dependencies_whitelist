import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    propertyDefinitions {
        category_id(required: true, type: PropertyType.String, description: "Id for category item")
        item_id(required: true, type: PropertyType.String, description: "Id of item used to")
        seller_profile(required: false, type: PropertyType.String, description: "Type of seller")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        category_domain(required: false, type: PropertyType.String, description: "Item category domain")
        category_path(required: false, type: PropertyType.ArrayList, description: "Path of category")
        type(required: true, type: PropertyType.String, description: "Type of hint", values: ["info", "actionable"])
        attribute(required: true, type: PropertyType.String, description: "Id of the attribute")
        reputation_level(required: false, type: PropertyType.String, description: "user reputation level")
        item_type(required: false, type: PropertyType.String, description: "product: A PDP item, default: A normal item, associated_products: A item which has at least 1 variation that is associated  with a product", values: ["product", "default", "associated_products"])

        item_price(required: true, type: PropertyType.Numeric, description: "The item price")
        item_currency_id(required: true, type: PropertyType.String, description: "The item currency")
        item_premium(required: true, type: PropertyType.Boolean, description: "True if the item has listing type premium")
        item_free_shipping(required: true, type: PropertyType.Boolean, description: "True if the item has free shipping")
        item_flex(required: true, type: PropertyType.Boolean, description: "True if the item has flex")
        winner_price(required: true, type: PropertyType.Numeric, description: "The item winner of the buy box price")
        winner_currency_id(required: true, type: PropertyType.String, description: "The item winner of the buy box currency")
        winner_premium(required: true, type: PropertyType.Boolean, description: "True if the item winner of the buy box has listing type premium")
        winner_free_shipping(required: true, type: PropertyType.Boolean, description: "True if the item winner of the buy box has free shipping")
        winner_flex(required: true, type: PropertyType.Boolean, description: "True if the item winner of the buy box has flex")
        buy_box_status(required: true, type: PropertyType.String, description: "The actual buy box status of the item", values: ["WIN", "LOSE", "PENDING", "DEFAULT", "ERROR"])
        new_buy_box_status(required: true, type: PropertyType.String, description: "The new buy box status of the item", values: ["WIN", "LOSE", "PENDING", "DEFAULT", "ERROR"])

        to(required: false, type: PropertyType.String, description: "The new value of a field, for example quantity, warranty,etc")
        from(required: false, type: PropertyType.String, description: "The original value of a field, for example quantity, warranty,etc")
    }

    propertyGroups {
        sellerCentralModifyGroup(item_id, session_id, item_type)
        sellerCentralModifyCardsGroup(category_id, seller_profile, category_domain, category_path)
        sellerCentralModifyGroupTableForPdp(item_price, item_currency_id, item_premium, item_free_shipping, item_flex, winner_price, winner_currency_id, winner_premium, winner_free_shipping, winner_flex, buy_box_status, new_buy_box_status)
        sellerCentralModifyCardsGroupValue(to, from)
        sellerCentralSettingsGroup(seller_profile, reputation_level)
        hintsGroup(type, attribute)
    }

    //LISTING SECTION
    "/seller_central"(platform: "/", isAbstract: true) {}
    "/seller_central/listings"(platform: "/", isAbstract: true) {}
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}

    "/seller_central/listings/onboarding"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "rollback", "start"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
    }

    "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of the communication", values: ["news", "task"])
        id(required: false, type: PropertyType.String, description: "Id of the communication ")
    }

    "/seller_central/listings/communication/show"(platform: "/", type: TrackType.View) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Adevrtasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
    }

    "/seller_central/listings/communication/go"(platform: "/", type: TrackType.Event) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Adevrtasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
    }

    "/seller_central/listings/communication/more_info"(platform: "/mobile", type: TrackType.Event) {}

    "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/filters"(platform: "/mobile", type: TrackType.View) {}

    "/seller_central/listings/filters/action"(platform: "/") {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["apply", "clear"])
    }

    "/seller_central/listings/search"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
    }

    "/seller_central/listings/preferences"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Preference id", values:["shipping", "advertising"])
    }

    //LISTING SECTION - TABS
    "/seller_central/listings/list/promos"(platform: "/", type: TrackType.Event) {}

    //BULK SECTION

    "/seller_central/bulk"(platform: "/", isAbstract: true) {}
    "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}

    "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Id of the action", values:["start","close", "rollback", "dismiss"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
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
    // TRACKS Seller central modify
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/modify"(platform: "/", isAbstract: true) {
        sellerCentralModifyGroup
    }

    "/seller_central/modify/detail"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/variations"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/variations_custom"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/listing_type"(platform: "/", type: TrackType.View) {
        sellerCentralModifyCardsGroup
    }

    "/seller_central/modify/update_price"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/update_quantity"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/update_localpickup_options"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/update_warranty"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/update_invoice"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/update_listing_types"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyCardsGroupValue
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central modify pdp items
    //------------------------------------------------------------------------------------------------------------------------------------------------------


    "/seller_central/modify/product_detail/update_price"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyGroupTableForPdp
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/product_detail/update_quantity"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyGroupTableForPdp
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/product_detail/update_localpickup_options"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyGroupTableForPdp
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/product_detail/update_warranty"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyGroupTableForPdp
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/product_detail/update_invoice"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyGroupTableForPdp
        sellerCentralModifyCardsGroupValue
    }

    "/seller_central/modify/product_detail/update_listing_types"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyCardsGroup
        sellerCentralModifyGroupTableForPdp
        sellerCentralModifyCardsGroupValue
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
        goal_order(required: true, type: PropertyType.String, description: "Goals order source.", values: ["random", "health-api"])
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
        quantity(required: true, type: PropertyType.Numeric, description: "Added values")
        previous_quantity(required: true, type: PropertyType.Numeric, description: "Previous values")
        category_domain(required: true, type: PropertyType.String, description: "Domain")
        hierarchy(required: true, type: PropertyType.String, description: "Attribute type")
    }

    "/seller_central/modify/technical_specifications/suggested"(platform: "/", type: TrackType.Event) {
        sellerCentralModifyGroup
        category_domain(required: true, type: PropertyType.String, description: "Domain")
        type(required: true, type: PropertyType.String, description: "Suggestion type")
        hierarchy(required: true, type: PropertyType.String, description: "Attribute type")
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
    "/seller_central/sales/list"(platform: "/", type: TrackType.View) {}
    "/seller_central/sales/detail"(platform: "/", type: TrackType.View) {}

    "/seller_central/sales/list/search"(platform: "/", type: TrackType.Event) {}

    "/seller_central/sales/list/onboarding"(platform: "/", isAbstract: true) {}
    "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the action", values: ["close", "dismiss", "start"])
        page(required: false, type: PropertyType.Numeric, description: "Page number")
    }

    "/seller_central/sales/list/pagination"(platform: "/", type: TrackType.Event) {
        page(required: true, type: PropertyType.Numeric, description: "Page number")
        total(required: true, type: PropertyType.Numeric, description: "Total pages number")
    }

    "/seller_central/sales/list/modal_action"(platform: "/", isAbstract: true) {}
    "/seller_central/sales/list/modal_action/open"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/list/modal_action/close"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/list/modal_action/apply"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
        option(required: false, type: PropertyType.String, description: "Option selected")
    }

    "/seller_central/sales/list/dashboard"(platform: "/", isAbstract: true) {}
    "/seller_central/sales/list/dashboard/show"(platform: "/", type: TrackType.Event) {
        substates(required: true, type: PropertyType.ArrayList, description: "List of available tasks")
    }
    "/seller_central/sales/list/dashboard/open"(platform: "/", type: TrackType.Event) {}

    "/seller_central/sales/list/dashboard/close"(platform: "/", type: TrackType.Event) {}

    "/seller_central/sales/list/dashboard/apply"(platform: "/", type: TrackType.Event) {
        state(required: false, type: PropertyType.String, description: "Column id")
        substate(required: true, type: PropertyType.String, description: "Card id")
        count(required: true, type: PropertyType.Numeric, description: "Task count")
    }

    "/seller_central/sales/list/massive"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
        count(required: true, type: PropertyType.Numeric, description: "Sale rows count")
    }

    "/seller_central/sales/list/row"(platform: "/", isAbstract: true) {}
    "/seller_central/sales/list/row/open"(platform: "/", type: TrackType.Event) {}

    "/seller_central/sales/detail/row"(platform: "/", isAbstract: true) {}
    "/seller_central/sales/detail/row/close"(platform: "/", type: TrackType.Event) {}

    "/seller_central/sales/list/filters"(platform: "/", isAbstract: true) {}
    "/seller_central/sales/list/filters/open"(platform: "/", type: TrackType.Event) {}
    "/seller_central/sales/list/filters/action"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id of the action", values: ["apply", "clear"])
        filters(required: false, type: PropertyType.ArrayList, description: "List of applied filters")
        sort(required: false, type: PropertyType.String, description: "Sort id")
    }
    
    "/seller_central/sales/list/action"(platform: "/", isAbstract: true) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/list/action/primary"(platform: "/", type: TrackType.Event) {}
    "/seller_central/sales/list/action/primary/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/sales/list/action/secondary"(platform: "/", type: TrackType.Event) {}

    "/seller_central/sales/detail/action"(platform: "/", isAbstract: true) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/detail/action/primary"(platform: "/", type: TrackType.Event) {}
    "/seller_central/sales/detail/action/primary/show"(platform: "/", type: TrackType.Event) {}
    "/seller_central/sales/detail/action/secondary"(platform: "/", type: TrackType.Event) {}
    "/seller_central/sales/detail/action/print"(platform: "/", parentPropertiesInherited:false, type: TrackType.Event) {}

    "/seller_central/sales/detail/modal_action"(platform: "/", isAbstract: true) {}
    "/seller_central/sales/detail/modal_action/open"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/detail/modal_action/close"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
    }
    "/seller_central/sales/detail/modal_action/apply"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Action id")
        option(required: false, type: PropertyType.String, description: "Option selected")
    }
}
