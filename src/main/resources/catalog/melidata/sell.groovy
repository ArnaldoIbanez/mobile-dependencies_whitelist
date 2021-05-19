package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1029"

    def attribute_map = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "Attribute ID")
        value_id(type: PropertyType.String, required: true, description: "Value ID")
        name(type: PropertyType.String, required: false, description: "Attribute Name")
        value_name(type: PropertyType.String, required: false, description: "Value Name")
    }
    def search_result_map = objectSchemaDefinitions {
        query_type(required: false,  values:["GTIN", "QUERY_STRING"], type: PropertyType.String, description: "GTIN or String query")
        query_search(required: false, type: PropertyType.String, description: "value of search query")
        result_type(required: false,  values:["GTIN_NOT_FOUND", "GTIN_INVALID", "GTIN_INACTIVE", "GTIN_ACTIVE", "QUERY_NO_RESULTS", "QUERY_DOMAIN_SUGGESTIONS", "QUERY_DOMAIN_ONE_SHOT", "QUERY_PRODUCT_SUGGESTIONS", "QUERY_PRODUCT_ONE_SHOT"], type: PropertyType.String, description: "Which type of result was offered to the user")
    }
    def product_prediction_map = objectSchemaDefinitions {
        product_id(type: PropertyType.String, required: true, description: "Product ID")
    }
    def category_prediction_map = objectSchemaDefinitions {
        path(type: PropertyType.ArrayList(PropertyType.String), required: true, description: "Category path")
        score(type: PropertyType.Numeric, required: true, description: "Score of the prediction")
        attributes(type: PropertyType.ArrayList(PropertyType.Map(attribute_map)), required: false, description: "Array of predictions of attributes")
        category_id(type: PropertyType.String, required: false, description: "Category ID")
        domain_id(type: PropertyType.String, required: false, description: "Domain ID")
    }
    def attribute_prediction_map = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "Attribute id")
        value_id(type: PropertyType.String, required: true, description: "Attribute selected value")
    }
    def predictions_map = objectSchemaDefinitions {
        categories(type: PropertyType.ArrayList(PropertyType.Map(category_prediction_map)), required: false, description: "Array of predictions of categories")
        attributes(type: PropertyType.ArrayList(PropertyType.Map(attribute_prediction_map)), required: false, description: "Array of predictions of attributes")
    }
    def attributes_values_map = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "Attribute id")
        value_id(type: PropertyType.String, required: false, description: "Attribute selected value")
        value_name(type: PropertyType.String, required: false, description: "Attribute custom value")
    }
    def originalItemData = objectSchemaDefinitions {
        has_variations(required: true, type: PropertyType.Boolean, description: "Item has variations or not")
        category_id(required: true, PropertyType.String, description: "Item's category id")
        domain_id(required: false, PropertyType.String, description: "Item's domain_id")
        catalog_listing(required: true, PropertyType.Boolean, description: "Item is catalog_listing or not")
    }
    def item_from_map = objectSchemaDefinitions {
        category_id(required: true, PropertyType.String, description: "Original item's category id")
        attribute_values(required: true, description: "Original item's attribute values", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        item_id(required: true, description: "Original item id", PropertyType.String)
        status(required: true, description: "Original item status", PropertyType.String)
        substatus(required: true, description: "Original item substatus", PropertyType.String)
        sold_quantity(required: true, description: "Original item sold quantity", PropertyType.Numeric)
    }
    def picture_info_map = objectSchemaDefinitions {
        width(required: true, type: PropertyType.Numeric, description: "this property describes width of the image")
        height(required: true, type: PropertyType.Numeric, description: "this property describes height of the image")
        size(required: false, type: PropertyType.String, description: "this property describes size of the image in bytes")
        format(required: false, type: PropertyType.String, description: "this property describes format of the image")
        valid(required: true, type: PropertyType.Boolean, description: "this property describes if this picture is valid")
    }

    def debug_model_map = objectSchemaDefinitions { 
              model_name(type: PropertyType.String, required: true, description: "") 
              score(type: PropertyType.Numeric, required: true, description: "") 
    } 

    def debug_domain_discovery_map = objectSchemaDefinitions { 
              debug_model_name(type: PropertyType.Map(debug_model_map), 
              required: true, description: "") 
    }
    
    propertyDefinitions {
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        domain_id(required: false, type: PropertyType.String, description: "Item's category domain id")
        attribute_id(required: false, type: PropertyType.String, description: "Attribute being selected")
        category_path(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Item's category tree")
        seller_profile(required: true, type: PropertyType.String, description: "Type of seller")
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation")
        categorization_flow_successful(required: false, description: "Categorization finished", type: PropertyType.Boolean)
        chosen_categorization_model(required: false, description: "Which predictor we used to predict category", values:["ZORDON", "DOMAIN_SEARCH", "DEFAULT", "DOMAIN_DISCOVERY", "PRODUCTS_SEARCH"], type: PropertyType.String)
        category_prediction_selected_index(required: false, description: "Index selected in Multiples Suggestions", PropertyType.Numeric)
        attribute_values(required: false, description: "Array of attributes in categorization", PropertyType.ArrayList(PropertyType.Map(attributes_values_map)))
        title_predicted(required: false, description: "Title used to predict category", type: PropertyType.String)
        predictions(required: false, type: PropertyType.Map(predictions_map), description: "Array of predictions of categories and/or attributes")
        parent_product_id(required: false, type: PropertyType.String, description: "Catalog product parent id for item")
        product_id(required: false, type: PropertyType.String, description: "Catalog product id for item")
        item_from(required: false, description: "Map with information about the original item in the LIST SIMILAR/LIST EQUAL/LIST AGAIN/CHANGE_CATEGORY  V4 flows.", PropertyType.Map(item_from_map))
        list_mode(required: false, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST", "LIST_AGAIN", "CHANGE_CATEGORY"])
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        listing_type_id(required: false, description: "Item listing type id")
        listing_type_free_available(required: false, type: PropertyType.Boolean, description: "Listing type free available")
        user_type(required: false, type: PropertyType.String, description: "The user type")
        business(required: false,  values:["classified", "none", "marketplace"], type: PropertyType.String, description: "this is the user site business")
        platform(required: false, values:["pi", "ml", "mp"], type: PropertyType.String, description: "this is the user site platform")
        intent_type(required: true, type: PropertyType.String, description: "this property describes the intent type to be perform", values:["drag", "valid_street_number", "invalid_street_number", "new_location_accepted", "new_location_rejected", "new_location_auto_accepted", "valid_intent", "invalid_intent", "pictures_upload"])
        intent_value(required: false, type: PropertyType.String, description: "this property describes the intent value if exists")
        field_intent_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "this property describes the field ids for the intent")
        pictures_info(required: true, type: PropertyType.ArrayList(PropertyType.Map(picture_info_map)), description: "this property describes array of pictures information")
        gtin_experience(required: false,  values:["ENABLED", "DISABLED", "NOT_PRESENT"], type: PropertyType.String, description: "Wether the user can see the GTIN experience or not")
        query_type(required: false,  values:["GTIN", "QUERY_STRING"], type: PropertyType.String, description: "GTIN or String query")
        query_search(required: false, type: PropertyType.String, description: "value of search query")
        result_type(required: false,  values:["GTIN_NOT_FOUND", "GTIN_INVALID", "GTIN_INACTIVE", "GTIN_ACTIVE", "QUERY_NO_RESULTS", "QUERY_DOMAIN_SUGGESTIONS", "QUERY_DOMAIN_ONE_SHOT", "QUERY_PRODUCT_SUGGESTIONS", "QUERY_PRODUCT_ONE_SHOT"], type: PropertyType.String, description: "Which type of result was offered to the user")
        product_predictions(required: false, type: PropertyType.ArrayList(PropertyType.Map(product_prediction_map)), description: "Product Predictions")
        accumulated_search_results(type: PropertyType.ArrayList(PropertyType.Map(search_result_map)), required: false, description: "Array of accumulated search results")
        products_selected_index(required: false, description: "Index of the selected product", type: PropertyType.Numeric)
        debug_domain_discovery(required: false, type: PropertyType.ArrayList(PropertyType.Map(debug_domain_discovery_map)), description: "Domain Discovery Model")
        user_shops_status(required: true, type: PropertyType.String, description: "MShops status", values: ["active", "inactive", "none"])
        sales_channels(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Selected sales channels")
    }

    propertyGroups {
        sellGroup(category_id, category_path, seller_profile, seller_segment, session_id, seller_reputation, list_mode, vertical, user_type, business, platform)
        sellGroupMobile( seller_segment, seller_profile, vertical)
        categoryFlow(domain_id, attribute_id, categorization_flow_successful, chosen_categorization_model, category_prediction_selected_index, attribute_values, title_predicted, predictions, parent_product_id, product_id, item_from)
        categoryFlowMobile(categorization_flow_successful, category_id, category_path, chosen_categorization_model, title_predicted)
        listingTypeFlow(listing_type_id)
        listingTypeFlowMobile(listing_type_id, listing_type_free_available)
        catalogFlowMobile(domain_id, attribute_id, category_prediction_selected_index, attribute_values, predictions, parent_product_id, product_id)
        locationIntentsGroup(has_drag, valid_street_number, accept_new_location, valid_intent)
        shieldGroup(business,session_id,vertical,platform)
        intentGroup(intent_type, intent_value)
        technicalSpecsIntentsGroup(intent_type, intent_value, field_intent_ids)
        pictureIntentGroup(intent_type, pictures_info)
        productFinderGroup(gtin_experience, query_type, query_search, result_type, product_predictions, accumulated_search_results, products_selected_index, debug_domain_discovery)
        mshopsGroup(user_shops_status, sales_channels)
    }

    // Sell
    "/sell"(platform: "/", isAbstract: true) {}
    "/sell"(platform: "/mobile", isAbstract: true) {
        sellGroupMobile
        listingTypeFlowMobile
        seller_reputation(required: false, type: PropertyType.String, description: "Seller's reputation")
        user_shops_status(required: false, type: PropertyType.String, description: "Mercado Shops status for de users", values: ["active", "inactive", "none"])
        sale_channels(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Item's sale channel values accepted: ['private', 'proximity', 'marketplace', 'mshops']")
    }
    "/sell/list"(platform: "/", isAbstract: true){
        session_id(required: false, description: "Session id for a specific user flow", type: PropertyType.String)
        classi_category_prediction_available(required: false, description: "this is an experiment on prediction step", type: PropertyType.Boolean)
        classi_landing_for_reservation(required: false, description: "this is an experiment on reservation step", type: PropertyType.Boolean)
        classi_year_unification(required: false, description: "this is an experiment on year step", type: PropertyType.Boolean)
    }
    "/sell/change_listing_type"(platform: "/web", isAbstract: true) {
        source(required: true, description: "Source could be differents types of email, my account, etc.", type: PropertyType.String)
        seller_experience(required: true, description: "Seller experience: newbie, intermediate or advanced")
    }
    "/sell/landing"(platform: "/", isAbstract: true){ }
    "/sell/landing/free_listing"(platform: "/", type: TrackType.View){
        referer(required:false , description: "Notification ID")
    }

    "/sell/change_listing_type/single"(platform: "/", type: TrackType.View){
        item_id(required: true, description: "Item id")
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: true, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: true, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: true, description: "Item condition: used/new/not_specified")
        price(required: true, description: "Item price")
        view_type(required:true, description: "Type of the view. Upgrade / Upgrade full screen / single option, ect...")
    }

    "/sell/change_listing_type/massive"(platform: "/", type: TrackType.View){
        items_amount(required: true, description: "Amount of items affected")
        view_type(required:true, description: "Type of the view. Upgrade / Upgrade full screen / single option, ect...")
    }

    "/sell/change_listing_type/upgrade_intention"(platform: "/web", type: TrackType.Event){
        item_id(required: true)
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
    }

    "/sell/quick_relist"(platform: "/web/desktop", isAbstract: true){}
    "/sell/quick_relist/single"(platform: "/web/desktop", type: TrackType.View){
        item_id(required: true, description: "Item id")
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        quantity(required: false, description: "Item quantity")
    }

    "/sell/quick_relist/massive"(platform: "/web/desktop", type: TrackType.View){
        items_amount(required: true, description: "Amount of items affected")
    }

    "/sell/modify_and_relist"(platform: "/web", isAbstract: true){}
    "/sell/modify_and_relist/single"(platform: "/web", isAbstract: true){
        item_id(required: true, description: "Item id")
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        quantity(required: false, description: "Item quantity")
        session_id(required: false, description: "Session ID for Supply Re V4 use case")
    }

    "/sell/modify_and_relist/single/row"(platform: "/web", type: TrackType.View){}
    "/sell/modify_and_relist/single/cards"(platform: "/web", type: TrackType.View){}

    "/sell/modify_and_relist/massive"(platform: "/web", isAbstract: true){
        items_amount(required: true, description: "Amount of items affected")
    }
    "/sell/modify_and_relist/massive/row"(platform: "/web", type: TrackType.View){}

    // Tambien se utiliza para Apps
    "/sell/list/congrats"(platform: "/", type: TrackType.View){
        session_id(required: false, description: "The listing session id")
        item_id(required: true, description: "Item id")
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        category_prediction(required: false, description: "Category prediction path result", type: PropertyType.ArrayList)
        category_prediction_score(required: false, description: "Category prediction scores result", type: PropertyType.ArrayList)
        category_prediction_zordon(required: false, description: "Category prediction path result from zordon", type: PropertyType.ArrayList)
        category_prediction_zordon_score(required: false, description: "Category prediction scores result from zordon", type: PropertyType.ArrayList)
        chosen_categorization_model(required: false, description: "Which predictor we used to predict category: ZORDON/DEFAULT/etc...", type: PropertyType.String)
        attributes_values_predicted(required: false, description: "Attributes values that we predict by matchers", type: PropertyType.ArrayList)
        attributes_ids_predicted(required: false, description: "Attributes ids that we predict by matchers", type: PropertyType.ArrayList)
        attributes_selected_in_tree(required: false, description: "Attributes values selected by user", type: PropertyType.ArrayList)
        title_predicted(required: false, description: "Title used to predict category", type: PropertyType.String)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
        category_path(required: false, description: "Category path", type: PropertyType.ArrayList)
        placement(required: false, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Adevrtasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
    }

    "/sell/list/congrats"(platform: "/mobile", type: TrackType.View){
        catalogFlowMobile
    }

    // List Similar/Equals modifications
    "/sell/list_similar"(platform: "/web/desktop", isAbstract: true){}
    "/sell/list_similar/result"(platform: "/web/desktop", type: TrackType.Event){
        session_id(required: true, type: PropertyType.String, description: "The listing session id")
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["list_equals", "list_similar"])
        modifications(required: true, type: PropertyType.ArrayList, description: "Item modifications on list equals or list similar flow")
        original_item_data(required: true, type: PropertyType.Map(originalItemData), description: "Some properties of the original item")
        seller_segment(required: true, type: PropertyType.String, description: "Type of seller")
    }

    // Upgrade On = El upgrade que se ofrece en la congrats del flujo de publicar
    "/sell/upgrade_on"(platform: "/web/desktop", type: TrackType.View){
        item_id(required: true, description: "Item id")
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
    }

    // Apps
    "/sell/list" (platform: "/mobile", isAbstract: true){
        categoryFlowMobile
    }
    "/sell/list/drafts"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/drafts/draft_action"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/drafts/draft_action/draft_deleted"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/drafts/draft_action/draft_resumed"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/draft"(platform:"/mobile", type: TrackType.View, isAbstract: true){}
    "/sell/list/draft/sip"(platform:"/mobile", type: TrackType.View){
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
        total_pictures(required: false, description: "Total pictures", type: PropertyType.Numeric)
        pending_pictures(required: false, description: "Pending pictures", type: PropertyType.Numeric)
        fail_pictures(required: false, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Array of pictures error", type: PropertyType.ArrayList)
    }
    "/sell/list/draft/attribute"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/attribute/kilometers"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/category_navigation"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/category_suggestion"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/color_selection"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/color_selection_fallback"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/condition"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/domain_suggestion"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/condition_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/condition_fallback"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/congrats"(platform:"/mobile", type: TrackType.View){
        item_id(required: true, description: "Item id")
        catalogFlowMobile
    }
    "/sell/list/draft/congrats/payment_pending"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/description"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/description_fallback"(platform:"/mobile", type: TrackType.View) {}
    "/sell/list/draft/description_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/description_included"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/free_shipping"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/listing_types"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/listing_types_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/location"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/location_suggestion"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/payment_methods"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/phone_suggestion"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/picture_preview_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures/album_selector"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures/pictures_selector"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures/editor"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_fallback"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/pictures_landing_fallback"(platform:"/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/pictures_fallback/album_selector"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_fallback/pictures_selector"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_fallback/editor"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_review/album_selector"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_review/pictures_selector"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_review/editor"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/price"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/price_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/price_modality"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/product_detail"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/draft/product_identifier"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/draft/registration_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/seller_registration"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/seller_registration_zip_code"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/shipping_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/shipping_mandatory_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/shipping_options_me"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/sip_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/sip_optional_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/size_selection"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/size_selection_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/size_selection_fallback"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/title"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/title_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/technical_specifications_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/draft/technical_specifications_catalog"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/draft/warranty_time"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/draft/warranty_time_review"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/draft/warranty_type"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/draft/warranty_type_review"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/draft/catalog"(platform:"/mobile", type: TrackType.View, isAbstract: true){}
    "/sell/list/draft/catalog/decision"(platform: "/mobile", type: TrackType.View){
        catalogFlowMobile
    }
    "/sell/list/draft/catalog/forced"(platform: "/mobile", type: TrackType.View) {
        catalog_listing_forced_type(required: true, description: "Forced type", values: ["open", "closed"], type: PropertyType.String)
        catalogFlowMobile
    }
    "/sell/list/draft/catalog/customize_marketplace_item_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/draft/kyc_landing"(platform: "/mobile", type: TrackType.View) {}

    "/sell/list/hub"(platform: "/", type: TrackType.View) {}
    "/sell/list/attribute"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/attribute/kilometers"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/picture_preview_landing"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/picture_uploader"(platform: "/mobile", isAbstract: true) {
        catalogFlowMobile
    }
    "/sell/list/picture_uploader/mode"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/picture_uploader/mode/camera"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/picture_uploader/crop"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/picture_uploader/delete"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/picture_uploader/rotate"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/manufacturing_time"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/manufacturing_time_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/free_shipping"(platform:"/mobile", type: TrackType.View) {}
    "/sell/list/free_shipping_review"(platform:"/mobile", type: TrackType.View) {}
    "/sell/list/quotable_category_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/kyc_landing"(platform: "/mobile", type: TrackType.View) {}


    "/sell/list/sip"(platform: "/mobile", type: TrackType.View) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
        total_pictures(required: false, description: "Total pictures", type: PropertyType.Numeric)
        pending_pictures(required: false, description: "Pending pictures", type: PropertyType.Numeric)
        fail_pictures(required: false, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Array of pictures error", type: PropertyType.ArrayList)
    }
    "/sell/list/sip_catalog"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/sip/publish"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/sip/publish/publish_cancel"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/publish/back_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/publish/pictures_fail"(platform: "/mobile", type: TrackType.Event) {
        total_pictures(required: true, description: "Total pictures", type: PropertyType.Numeric)
        fail_pictures(required: true, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Failed pictures", type: PropertyType.ArrayList)
    }
    "/sell/list/sip/publish/fail"(platform: "/mobile", type: TrackType.Event) {
        error_message(required: false, description: "Error message", type: PropertyType.String)
    }
    "/sell/list/sip/publish/abandonment"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/section"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/sip/section/disabled"(platform: "/mobile", type: TrackType.Event) {
        section_id(required: false, description: "Section of the SIP that is disabled and trigger the event.", type: PropertyType.String)
    }

    "/sell/list/sip/notification"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/sip/notification/congrats"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/congrats/payment_pending"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/payment_experience"(platform: "/mobile", type: TrackType.View){
        item_id(required: true, description: "Item id", type: PropertyType.String)
        catalogFlowMobile
    }
    "/sell/list/location"(platform: "/", type: TrackType.View) {}
    "/sell/list/location_map"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/location_suggestion"(platform: "/", type: TrackType.View) {}
    "/sell/list/location_street"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/catalog_trim_selection"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/catalog_vehicle_year_selection"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/category_suggestion"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/category_navigation"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/domain_suggestion"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/catalog"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/catalog/decision"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/catalog/forced"(platform: "/mobile", type: TrackType.View) {
        catalog_listing_forced_type(required: true, description: "Forced type", values: ["open", "closed"], type: PropertyType.String)
        catalogFlowMobile
    }
    "/sell/list/catalog/customize_marketplace_item_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/classifieds_reservation_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/color_selection"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/color_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection_fallback"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/color_selection/custom_color"(platform: "/web", type: TrackType.Event) {
        session_id(required: true, description: "Session Id of the list flow, that dies when the flow ends", type: PropertyType.String)
        category_domain(required: false, description: "Category Domain", type: PropertyType.String)
        is_custom_name(required: true, description: "True:The user changed the color´s name", type: PropertyType.Boolean)
        category_path(required: false, description: "Category path", type: PropertyType.ArrayList)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
    }
    "/sell/list/technical_specifications_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/technical_specifications_catalog"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/product_detail"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/product_identifier"(platform: "/", type: TrackType.View) {}
    "/sell/list/phone_suggestion"(platform:"/mobile", type:TrackType.View){}
    "/sell/list/condition"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/condition_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/condition_fallback"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/condition_confirmation_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/description"(platform: "/", type: TrackType.View) {}
    "/sell/list/description_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/description_fallback"(platform: "/", type: TrackType.View) {}
    "/sell/list/description_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/description_included_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/description_not_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/description_additional_information"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/description_additional_information_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/payment_methods"(platform: "/", type: TrackType.View) {}
    "/sell/list/payment_methods_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types_catalog"(platform: "/", type: TrackType.View) {}
    "/sell/list/warranty_type"(platform: "/", type: TrackType.View) {}
    "/sell/list/warranty_time"(platform: "/", type: TrackType.View) {}
    "/sell/list/warranty_type_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/warranty_time_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/warranty_type_condition_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/warranty_time_condition_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/whatsapp_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/pictures/album_selector"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures/pictures_selector"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures/editor"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/crop"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures/crop/crop_accepted"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/pictures/crop/crop_canceled"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
        album_name(required: false, description: "Album name", type: PropertyType.String)
    }
    "/sell/list/pictures_fallback"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/pictures_fallback/album_selector"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures_fallback/pictures_selector"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures_fallback/editor"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures_fallback/crop"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/album_selector"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures_review/pictures_selector"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures_review/editor"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/crop"(platform: "/", type: TrackType.View) {}
    "/sell/list/price"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/price_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/seller_registration"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration_zip_code"(platform: "/", type: TrackType.View) {}
    "/sell/list/zip_code"(platform: "/", type: TrackType.Event, isAbstract: true) {}
    "/sell/list/zip_code/zip_code"(platform: "/", type: TrackType.Event, isAbstract: true) {}
    "/sell/list/zip_code/zip_code/search_zip_code"(platform: "/", type: TrackType.Event) {}
    "/sell/list/manufacturing_time"(platform: "/", type: TrackType.View) {}
    "/sell/list/phone"(platform: "/", type: TrackType.View) {}
    "/sell/list/category"(platform: "/mobile", isAbstract: true) {
        catalogFlowMobile
    }
    "/sell/list/category/selection"(platform: "/mobile", isAbstract:true){}
    "/sell/list/category/selection/confirm_suggested"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/wrong_suggested"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l1"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l2"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l3"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l4"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l5"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/price_modality"(platform: "/mobile", type: TrackType.Event) {}

    "/sell/list/size_selection"(platform: "/", type: TrackType.View) {}
    "/sell/list/size_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/size_selection_fallback"(platform: "/", type: TrackType.View) {}
    "/sell/list/title"(platform: "/", type: TrackType.View) {}
    "/sell/list/title_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_options_me"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures_landing_fallback"(platform: "/mobile", type: TrackType.View) {
        catalogFlowMobile
    }
    "/sell/list/registration_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_mandatory_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_optional_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/title_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/list/item_description"(platform: "/", type: TrackType.View){
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
    }
    "/sell/list/sale_condition"(platform: "/", type: TrackType.View){}
    "/sell/list/license_plate"(platform: "/mobile", type: TrackType.View) {}

    //update flow
    "/sell/update" (platform: "/", isAbstract: true){
        item_id(required: true, description: "Item id", type: PropertyType.String)
        is_catalog_listing(required: false, description: "If core item is a catalog listing", type: PropertyType.Boolean)
        buybox_status(required: false, description: "Buy Box status of core catalog listing", type: PropertyType.String, values: ["winning", "losing_by_price", "losing_by_stock", "losing_by_bad_reputation", "losing_by_untrusted_seller", "losing_by_without_reputation", "calculating", "undefined", "losing_by_free_listing_type"])
    }
    "/sell/update/attribute"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/buybox_competition"(platform: "/mobile", type: TrackType.View) {
        rebate_status(required: true, description: "Status of rebate", type: PropertyType.String, values: ["not_boosted", "none"])
    }
    "/sell/update/buybox_competition/push_action"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/buybox_competition/row_action"(platform: "/mobile", type: TrackType.Event) {
        boost_id(required: true, description: "Id of buy box boost", type: PropertyType.String, values: ["free_shipping", "free_installments", "fulfillment", "mercado_envios", "price", "same_day_shipping", "shipping_quarantine"])
        boost_status(required: true, description: "Status of buy box boost", type: PropertyType.String, values: ["boosted", "not_boosted", "opportunity", "not_apply"])
    }
    "/sell/update/picture_uploader"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/picture_uploader/mode"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/picture_uploader/mode/camera"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/picture_uploader/crop"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/picture_uploader/delete"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/picture_uploader/rotate"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/goals"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/description_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/description_not_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/manufacturing_time"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/closed_sip"(platform: "/mobile", isAbstract: true){}
    "/sell/update/closed_sip/section"(platform: "/mobile", isAbstract: true){}
    "/sell/update/closed_sip/section/disabled"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip"(platform: "/mobile", type: TrackType.View) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
        total_pictures(required: false, description: "Total pictures", type: PropertyType.Numeric)
        pending_pictures(required: false, description: "Pending pictures", type: PropertyType.Numeric)
        fail_pictures(required: false, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Array of pictures error", type: PropertyType.ArrayList)
        is_catalog_boost(required: false, description: "boolean - true if the item was created by Optinator (forced catalog optin) and item status is paused", type: PropertyType.Boolean)
        is_item_inactive_moderated(required: false, description: "boolean - true if it is an inactive moderated item", type: PropertyType.Boolean)
        rebate_status(required: false, description: "Status of rebate", type: PropertyType.String, values: ["boosted", "not_boosted", "none"])
    }
    "/sell/update/sip/header_modal"(platform: "/mobile", isAbstract: true) {
        header_type(required: true, description: "Header type", type: PropertyType.String, values: ["advisory", "buybox", "health", "warning"])
    }
    "/sell/update/sip/header_modal/open"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/header_modal/action"(platform: "/mobile", type: TrackType.Event) {
        action_id(required: true, description: "ID of the modal action", type: PropertyType.String, values: ["cancel", "reputation"])
    }
    "/sell/update/sip/section"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/sip/section/disabled"(platform: "/mobile", type: TrackType.Event) {
        section_id(required:true, description: "Section of the SIP that is disabled and trigger the event.", type: PropertyType.String)
    }
    "/sell/update/sip/rebate"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/sip/rebate/action"(platform: "/mobile", type: TrackType.Event) {}

    "/sell/update/quantity_maximum_free_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/location"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/picture_preview_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/quantity"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/technical_specifications"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/product_identifier"(platform: "/mobile", type: TrackType.View) {
        value_type(required:true, description: "Indicates the type of PI value that the input has", type: PropertyType.String, values:["none", "single_value", "multi_value"])
    }
    "/sell/update/shipping"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/shipping/flex"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/shipping/flex/free_shipping_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/shipping/flex/optin"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/shipping/flex/optin/date_selection"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/shipping/optin_lazy_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/shipping/flex/optin/comunication"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/shipping/flex_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/shipping_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/shipping_mandatory_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/variations"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/pictures_variations"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/pictures_variations/album_selector"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/pictures_variations/pictures_selector"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/pictures_variations/editor"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/sip/publish"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/sip/publish/fail"(platform: "/mobile", type: TrackType.Event) {
        error_message(required: false, description: "Error message", type: PropertyType.String)
    }

    "/sell/update/color_selection"(platform: "/", type: TrackType.View) {}
    "/sell/update/color_selection/custom_color"(platform: "/web", type: TrackType.Event) {
        session_id(required: true, description: "Session Id of the update flow, that dies when the flow ends", type: PropertyType.String)
        is_custom_name(required: true, description: "True:The user changed the color´s name", type: PropertyType.Boolean)
    }
    "/sell/update/condition"(platform: "/", type: TrackType.View) {}
    "/sell/update/condition_confirmation_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/description"(platform: "/", type: TrackType.View) {}
    "/sell/update/payment_methods"(platform: "/", type: TrackType.View) {}
    "/sell/update/warranty_type"(platform: "/", type: TrackType.View) {}
    "/sell/update/warranty_time"(platform: "/", type: TrackType.View) {}
    "/sell/update/warranty_type_catalog"(platform: "/", type: TrackType.View) {}
    "/sell/update/warranty_time_catalog"(platform: "/", type: TrackType.View) {}
    "/sell/update/warranty_type_force_change"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/warranty_time_force_change"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/whatsapp"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/phone"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/pictures"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures/album_selector"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures/pictures_selector"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures/editor"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures/crop"(platform: "/", type: TrackType.View) {}
    "/sell/update/variations_pi"(platform: "/mobile", type: TrackType.View) {
        value_type(required:true, description: "Indicates the type of PI value that the input has", type: PropertyType.String, values:["none", "single_value", "multi_value"])
    }
    "/sell/update/pictures/crop/crop_accepted"(platform: "/", type: TrackType.Event) {}
    "/sell/update/pictures/crop/crop_canceled"(platform: "/", type: TrackType.Event) {}
    "/sell/update/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
        album_name(required: true, description: "Album name", type: PropertyType.String)
    }
    "/sell/update/price"(platform: "/", type: TrackType.View) {}
    "/sell/update/title"(platform: "/", type: TrackType.View) {}
    "/sell/update/shipping_options_me"(platform: "/", type: TrackType.View) {}
    "/sell/update"(platform: "/", isAbstract: true) {}
    "/sell/update/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/update/listing_type_not_available_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/free_shipping"(platform: "/", type: TrackType.View) {}
    "/sell/update/statistics"(platform: "/", type: TrackType.View) {}
    "/sell/update/health_goal_loss_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/quotable_category_landing"(platform: "/mobile", type: TrackType.View) {}

    "/sell/update/technical_spec_goal_not_supported_landing"(platform: "/mobile", type: TrackType.Event) {
        item_id(required: true, description: "Item id")
        seller_profile(required: true, type: PropertyType.String, description: "Type of seller")
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
    }
    "/sell/update/video_goal_not_supported_landing"(platform: "/mobile", type: TrackType.Event) {
        item_id(required: true, description: "Item id")
        seller_profile(required: true, type: PropertyType.String, description: "Type of seller")
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
    }

    "/sell/list/pictures_uploader"(platform: "/web/desktop", isAbstract: true){}
    "/sell/list/pictures_uploader/validations"(platform: "/web/desktop", type: TrackType.Event){
        error_key(required: true, description: "Error raised after picture validation", type: PropertyType.String)
    }
    "/sell/list/modal_attributes"(platform: "/web", type: TrackType.View) {
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        condition(required: false, description: "Item condition", type: PropertyType.String)
        na_attrs_not_pk(required: false, description: "Quantity of attributes not PK with N/A", type: PropertyType.Numeric)
        na_attrs_pk(required: false, description: "Quantity of attributes PK with N/A", type: PropertyType.Numeric)
        empty_attrs_pk(required: false, description: "Quantity of attributes PK", type: PropertyType.Numeric)
        empty_attrs_not_pk(required: false, description: "Quantity of attributes not PK", type: PropertyType.Numeric)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
    }
    "/sell/list/modal_attributes/submit"(platform: "/web", type: TrackType.Event) {
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        hierarchy(required: false, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        option_selected(required: true, description: "Radio option selected", values:["completed", "no_data", "not_possible", "other"], PropertyType.String)
        value(required:true, description: "Value for attribute or feedback", type: PropertyType.String)
    }

    "/sell/update/modal_attributes"(platform: "/web", isAbstract: true){
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        session_id(required: false, description: "Session id for a specific user flow", type: PropertyType.String)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
    }
    "/sell/update/modal_attributes"(platform: "/web", type: TrackType.View) {
        condition(required: false, description: "Item condition", type: PropertyType.String, values:["new", "used", "not_specified", "refurbished"])
        empty_attrs_pk(required: false, description: "Quantity of attributes PK", type: PropertyType.Numeric)
        empty_attrs_not_pk(required: false, description: "Quantity of attributes not PK", type: PropertyType.Numeric)
        na_attrs_not_pk(required: false, description: "Quantity of attributes not PK with N/A", type: PropertyType.Numeric)
        na_attrs_pk(required: false, description: "Quantity of attributes PK with N/A", type: PropertyType.Numeric)
    }
    "/sell/update/modal_attributes/submit"(platform: "/web", type: TrackType.Event) {
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        hierarchy(required: true, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        option_selected(required: true, description: "Radio option selected", values:["completed", "no_data", "not_possible", "other"], PropertyType.String)
        value(required:true, description: "Value for attribute or feedback", type: PropertyType.String)
    }
    "/sell/upgrade/"(platform: "/", isAbstract: true){
        item_id (required: true, type: PropertyType.String)
        session_id (required: false, type: PropertyType.String)
    }
    "/sell/upgrade/listing_types"(platform: "/mobile", type: TrackType.View){}
    "/sell/upgrade/congrats"(platform: "/mobile", type: TrackType.View){}
    "/sell/upgrade/congrats/payment_pending"(platform: "/mobile", type: TrackType.View){}

    "/sell/upgrade/payment_experience"(platform: "/mobile", type: TrackType.View){
        catalogFlowMobile
    }

    "/sell/sip_upgrade"(platform: "/mobile", type: TrackType.Event){
        source(required: true, values: ["section"], description: "Upgrade intention source's", type: PropertyType.String)
        vertical(required: true, values: ["core", "motors", "realEstate", "services"], description: "Item Vertical: core/service/motor/realEstate/etc...")
        seller_segment(required: false, type: PropertyType.String, description: "Seller segment by GMV")
        seller_profile(required: false, description: "Type of seller", type: PropertyType.String)
    }

    // Relist flow
    "/sell/relist"(platform: "/", isAbstract: true) {
        item_id (required: true, type: PropertyType.String)
    }
    "/sell/relist/congrats"(platform: "/web/desktop", type: TrackType.View) {
        can_complete_attributes(required: true, description: "Field to identify if link to update was offered.", type: PropertyType.Boolean)
        session_id(required: false, description: "Session ID for Supply Re V4 use case")
        listing_type(required: false, description: "Listing type id used to resell item")
    }
    "/sell/relist/congrats"(platform: "/mobile", type: TrackType.View) {}

    // QR tracking
    "/sell/qr"(platform: "/", isAbstract: true) {}

    // Tracks for Web mobile removed
    "/sell/landing_download_app"(platform: "/web/mobile", type: TrackType.View){
        vertical(required: false, values: ["core", "motors", "realEstate", "services"], description: "Item Vertical: core/service/motor/realEstate/etc...")
    }
    "/sell/landing_download_app/download_intention"(platform: "/web/mobile", type: TrackType.Event){}
    "/sell/landing_hub"(platform: "/web/mobile", type: TrackType.View){}
    "/sell/landing_hub/sell_intention"(platform: "/web/mobile", type: TrackType.Event){
        vertical(required: true, values: ["core", "motors", "realEstate", "services"], description: "Item Vertical: core/service/motor/realEstate/etc...")
    }

    // Mobile flow - Push notification complete technical specifications
    "/sell/complete_technical_specifications"(platform: "/mobile", isAbstract: true) {
        item_id (required: true, type: PropertyType.String)
    }
    "/sell/complete_technical_specifications/technical_specifications"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/landing_finish_no_complete"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/landing_continue"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/landing_no_items"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/congrats_finish"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/landing_intro"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/congrats_has_more"(platform: "/mobile", type: TrackType.View){}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS SYI v4
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/sell/draft"(platform: "/web", type: TrackType.View) {}

    "/sell/hub"(platform: "/web", type: TrackType.View) {}
    "/sell/hub/select_vertical"(platform: "/web", type: TrackType.Event) {
        sellGroup
        vertical(required: true, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        mshopsGroup
    }

    "/sell/item_data"(platform: "/web", type: TrackType.View) {
        sellGroup
        item_type(required: true, description: "item type", values:["default", "product", "no_prediction"], type: PropertyType.String)
        item_from(required: false, description: "Map with information about the original item in the LIST SIMILAR/LIST EQUAL/LIST AGAIN/CHANGE_CATEGORY  V4 flows.", PropertyType.Map(item_from_map))
        mshopsGroup

    }
    "/sell/item_data/title"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/title/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/title/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/redirect_syi_core"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/redirect_syi_core/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/title/redirect_store"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/category_suggested"(platform: "/web", isAbstract: true) {
        categoryFlow
        productFinderGroup
    }
    "/sell/item_data/category_suggested/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/category_suggested/confirm"(platform: "/web", type: TrackType.Event) {
        confirm_category_detail(required: true, description: "category detail confirmation", values:["true", "false", "not_present"], type: PropertyType.String)
    }
    "/sell/item_data/category_suggested/wrong_category"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/category"(platform: "/web", isAbstract: true) {
        categoryFlow
        productFinderGroup
    }
    "/sell/item_data/category/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/category/confirm"(platform: "/web", type: TrackType.Event) {
        confirm_category_detail(required: false, description: "category detail confirmation", values:["true", "false", "not_present"], type: PropertyType.String)
    }
    "/sell/item_data/category/wrong_category"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_data/category/leave_suggestion_link"(isAbstract: true) {}
    "/sell/item_data/category/leave_suggestion_link/show"(platform: "/web", type: TrackType.Event) {
        sellGroup
    }

    "/sell/item_data/category/default_product_link"(isAbstract: true) {} 
    "/sell/item_data/category/default_product_link/show"(platform: "/web", type: TrackType.Event) {
        sellGroup
    }
    
    "/sell/item_data/product_bullet_resume"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/product_bullet_resume/show"(platform: "/web", type: TrackType.Event) {
        categoryFlow
        productFinderGroup
        product_title(required: true, description: "title of catalog product", type: PropertyType.String)
    }
    "/sell/item_data/product_identifier"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/product_identifier/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/product_identifier/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/product_identifier/required"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/flow_decision"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/flow_decision/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/flow_decision/confirm"(platform: "/web", type: TrackType.Event) {
        flow_decision(required: true, description: "Flow decision - true if is catalog", type: PropertyType.Boolean)
        catalog_forced(required: false, description: "Indicates if the flow decision card is forcing catalog", type: PropertyType.Boolean)
    }
    "/sell/item_data/quantity_with_specifications"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/quantity_with_specifications/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/quantity_with_specifications/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/consequences_modal"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/consequences_modal/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/consequences_modal/confirm"(platform: "/web", parentPropertiesInherited: false, type: TrackType.Event) {
        seller_profile(required: true, description: "Type of seller", type: PropertyType.String)
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation")
        list_mode(required: false, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST", "LIST_AGAIN", "CHANGE_CATEGORY"])
    }
    "/sell/item_data/pks"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/pks/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/pks/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/item_condition"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/item_condition/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/item_condition/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/main_variation"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/main_variation/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/main_variation/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/variations"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/variations/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/variations/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/specifications"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/specifications/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/specifications/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/technical_specifications"(platform: "/web", isAbstract: true) {
        listingTypeFlow
    }
    "/sell/item_data/technical_specifications/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/technical_specifications/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/legal_requirements"(platform: "/web", isAbstract: true) {
        listingTypeFlow
    }
    "/sell/item_data/legal_requirements/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/legal_requirements/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/multivalue"(platform: "/web", type: TrackType.Event) {
        category_domain(required: true, description: "Category Domain", type: PropertyType.String)
        attribute_id(required: true, type: PropertyType.String, description: "Id of the attribute")
        hierarchy(required: false, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        quantity(required: true, type: PropertyType.Numeric, description: "Added values")
        previous_quantity(required: true, type: PropertyType.Numeric, description: "Previous values")
        container(required: true, description: "Id or name of the container (card, modal, other) where you are", type: PropertyType.String)
    }
    "/sell/item_data/autocomplete"(platform: "/web", type: TrackType.Event) {
        category_domain(required: true, description: "Category Domain", type: PropertyType.String)
        attribute_id(required: true, type: PropertyType.String, description: "Id of the attribute")
        hierarchy(required: false, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        type(required: true, type: PropertyType.String, description: "Suggestion type", values: ["suggested", "dynamic", "other"])
        container(required: true, description: "Id or name of the container (card, modal, other) where you are", type: PropertyType.String)
    }
    "/sell/item_data/category_breadcrumb"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/category_breadcrumb/update"(platform: "/web", type: TrackType.Event) {
        sellGroup
        categoryFlow
        productFinderGroup
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
    }
    "/sell/item_data/category_breadcrumb/mount"(platform: "/web", type: TrackType.Event) {
        sellGroup
        categoryFlow
        productFinderGroup
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
    }
    "/sell/item_data/category_breadcrumb/previous"(platform: "/web", type: TrackType.Event) {
        sellGroup
        categoryFlow
        productFinderGroup
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
    }
    "/sell/item_data/category_breadcrumb/navigate"(platform: "/web", type: TrackType.Event) {
        sellGroup
        categoryFlow
        productFinderGroup
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
    }
    "/sell/item_data/catalog_decision"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/catalog_decision/show"(platform: "/web", type: TrackType.Event) {
        sellGroup
        domain_id(required: true, PropertyType.String, description: "Item's domain_id")
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST"])
        item_type(required: true, type: PropertyType.String, description: "item type", values:["default", "product"])
        parent_product_id(required: true, type: PropertyType.String, description: "Catalog product parent id for item")
    }
    "/sell/item_data/catalog_decision/confirm"(platform: "/web", type: TrackType.Event) {
        sellGroup
        domain_id(required: true, PropertyType.String, description: "Item's domain_id")
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST"])
        item_type(required: true, type: PropertyType.String, description: "item type", values:["default", "product"])
        parent_product_id(required: true, type: PropertyType.String, description: "Catalog product parent id for item")
        flow_decision(required: true, type: PropertyType.Boolean, description: "Flow decision - true if is catalog")
        catalog_forced(required: true, type: PropertyType.Boolean, description: "Indicates if the flow decision card is forcing catalog")
    }
    
    "/sell/item_data/catalog_optional"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/catalog_optional/show"(platform: "/web", type: TrackType.Event) {
        sellGroup
    }
    "/sell/item_data/catalog_optional/confirm"(platform: "/web", type: TrackType.Event) {
        sellGroup
    }

    "/sell/item_data/catalog_forced"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/catalog_forced/show"(platform: "/web", type: TrackType.Event) {
        sellGroup
        domain_id(required: true, PropertyType.String, description: "Item's domain_id")
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST"])
        item_type(required: true, type: PropertyType.String, description: "item type", values:["default", "product"])
        parent_product_id(required: true, type: PropertyType.String, description: "Catalog product parent id for item")
    }
    "/sell/item_data/catalog_forced/confirm"(platform: "/web", type: TrackType.Event) {
        sellGroup
        domain_id(required: true, PropertyType.String, description: "Item's domain_id")
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST"])
        item_type(required: true, type: PropertyType.String, description: "item type", values:["default", "product"])
        parent_product_id(required: true, type: PropertyType.String, description: "Catalog product parent id for item")
        flow_decision(required: true, type: PropertyType.Boolean, description: "Flow decision - true if is catalog")
        catalog_forced(required: true, type: PropertyType.Boolean, description: "Indicates if the flow decision card is forcing catalog")
    }
    "/sell/item_data/marketplace_customizer"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/marketplace_customizer/show"(platform: "/web", type: TrackType.Event) {
        sellGroup
        domain_id(required: true, PropertyType.String, description: "Item's domain_id")
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST"])
        item_type(required: true, type: PropertyType.String, description: "item type", values:["default", "product"])
        parent_product_id(required: true, type: PropertyType.String, description: "Catalog product parent id for item")
    }
    "/sell/item_data/marketplace_customizer/confirm"(platform: "/web", type: TrackType.Event) {
        sellGroup
        domain_id(required: true, PropertyType.String, description: "Item's domain_id")
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST"])
        item_type(required: true, type: PropertyType.String, description: "item type", values:["default", "product"])
        parent_product_id(required: true, type: PropertyType.String, description: "Catalog product parent id for item")
    }
    "/sell/item_data/marketplace_customizer/edit"(platform: "/web", type: TrackType.Event) {
        sellGroup
        domain_id(required: true, PropertyType.String, description: "Item's domain_id")
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST"])
        item_type(required: true, type: PropertyType.String, description: "item type", values:["default", "product"])
        parent_product_id(required: true, type: PropertyType.String, description: "Catalog product parent id for item")
        id(required: true, PropertyType.String, description: "id from inner edited component")
        new_value(required: true, PropertyType.String, description: "new value from inner edited component")
    }

    "/sell/item_data/kilometers"(platform: "/web", parentPropertiesInherited: false, isAbstract: true) {
        seller_profile(required: true, description: "Type of seller", type: PropertyType.String)
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation")
        list_mode(required: false, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST", "LIST_AGAIN", "CHANGE_CATEGORY"])
    }
    "/sell/item_data/kilometers/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/kilometers/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/license_plate"(platform: "/web", parentPropertiesInherited: false, isAbstract: true) {
        seller_profile(required: true, description: "Type of seller", type: PropertyType.String)
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation")
        list_mode(required: false, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST", "LIST_AGAIN", "CHANGE_CATEGORY"])
    }
    "/sell/item_data/license_plate/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/license_plate/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/color"(platform: "/web", parentPropertiesInherited: false, isAbstract: true) {
        seller_profile(required: true, description: "Type of seller", type: PropertyType.String)
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation")
        list_mode(required: false, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST", "LIST_AGAIN", "CHANGE_CATEGORY"])
    }
    "/sell/item_data/color/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/color/confirm"(platform: "/web", type: TrackType.Event) {}

    //--------------------------------------------------------------------------------------------------------------------
    // Product Finder (Start)
    //--------------------------------------------------------------------------------------------------------------------
    "/sell/item_data/products_finder"(platform: "/web", isAbstract: true) {
        categoryFlow
        productFinderGroup
    }
    "/sell/item_data/products_finder/update"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/products_finder/category_selection"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/products_finder/product_selection"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/products_finder/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/products_finder/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/products_finder/restart"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/products_finder_bar"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/products_finder_bar/confirm"(platform: "/web", type: TrackType.Event) {
        categoryFlow
        productFinderGroup
    }
    "/sell/item_data/carrier"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/carrier/show"(platform: "/web", type: TrackType.Event) {
        categoryFlow
        productFinderGroup
    }
    "/sell/item_data/carrier/confirm"(platform: "/web", type: TrackType.Event) {
        categoryFlow
        productFinderGroup
    }
    "/sell/item_data/product_resume"(platform: "/web", isAbstract: true) {}
    "/sell/item_data/product_resume/previous"(platform: "/web", type: TrackType.Event) {
        categoryFlow
        productFinderGroup
    }
   //--------------------------------------------------------------------------------------------------------------------
    // Product Finder (End)
    //--------------------------------------------------------------------------------------------------------------------

    "/sell/item_conditions"(platform: "/web", type: TrackType.View) {
        sellGroup
        item_type(required: true, description: "item type", values:["default", "product", "no_prediction"], type: PropertyType.String)
        mshopsGroup
    }
    "/sell/item_conditions/price_and_currency"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/price_and_currency/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/price_and_currency/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/listing_types"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/listing_types/show"(platform: "/web", type: TrackType.Event) {
        has_free(required: true, type: PropertyType.Boolean)
    }
    "/sell/item_conditions/listing_types/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/listing_types/free"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/listing_types/free/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/free_shipping"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/free_shipping/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/free_shipping/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/consequences_modal"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/consequences_modal/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/consequences_modal/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/calculator"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/calculator/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/calculator/hide"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/shipping"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/shipping/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/shipping/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/localpickup"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/localpickup/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/localpickup/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/payment_methods"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/payment_methods/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/payment_methods/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/warranty"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/warranty/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/warranty/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/manufacturing_time"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/manufacturing_time/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/manufacturing_time/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/description"(platform: "/web", isAbstract: true) {
        listingTypeFlow
    }
    "/sell/item_conditions/description/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/description/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/video"(platform: "/web", isAbstract: true) {
        listingTypeFlow
    }
    "/sell/item_conditions/video/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/video/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/invoice"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/invoice/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/invoice/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_conditions/sidebar_listing_type"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/sidebar_listing_type/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/sidebar_listing_type/hide"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_conditions/reservation_info"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/reservation_info/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/reservation_info/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_conditions/location"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/location/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/location/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_conditions/seller_contact"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/seller_contact/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/seller_contact/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_conditions/instant_pay_listings"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/instant_pay_listings/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/instant_pay_listings/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_conditions/instant_pay_listings_free"(platform: "/web", isAbstract: true) {}
    "/sell/item_conditions/instant_pay_listings_free/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/instant_pay_listings_free/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_conditions/location/default_address"(platform: "/web", type: TrackType.View) {}
    "/sell/item_conditions/location/default_address/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/location/default_address/wrong_suggestion"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_data/pictures"(platform: "/web", type: TrackType.View) {}
    "/sell/item_data/pictures/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/pictures/add_intention"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/pictures/add_more_intention"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/pictures/delete"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/pictures/suggestions_modal_show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/pictures/upload_errors"(platform: "/web", type: TrackType.Event) {
        limit_errors(required: true, description: "The quantity of pictures uploaded was exceeded", type: PropertyType.Boolean)
        format_errors(required: true, description: "How many files didn't match the allowed format", type: PropertyType.Numeric)
        size_errors(required: true, description: "How many files didn't match the minimum size", type: PropertyType.Numeric)
    }
    "/sell/item_data/pictures/upload"(platform: "/web", type: TrackType.Event) {
        quantity(required: true, description: "The quantity of pictures uploaded successfully", type: PropertyType.Numeric)
    }

    "/sell/item_conditions/seller_contact/phone"(platform: "/web", type: TrackType.View) {}
    "/sell/item_conditions/seller_contact/phone/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_conditions/seller_contact/whatsapp"(platform: "/web", type: TrackType.View) {}
    "/sell/item_conditions/seller_contact/whatsapp/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/congrats"(platform: "/web", type: TrackType.View) {
        sellGroup
        categoryFlow
        productFinderGroup
        listingTypeFlow
        item_id(required: true, type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        health_card_shown(required: false, type: PropertyType.Boolean, description: "Flag for Health card")
        kyc_card_shown(required: false, type: PropertyType.Boolean, description: "Flag for KYC card")
        share_card_shown(required: false, type: PropertyType.Boolean, description: "Flag for share in social network card")
        decision_flow_label(required: false,  values:["BY_MARKETPLACE", "BY_CATALOG", "BY_CATALOG_AND_MARKETPLACE", "NONE"], type: PropertyType.String, description: "Which path (ctl / mk) selected for the listing")
        mshopsGroup
    }

    "/sell/congrats/show"(platform: "/web", parentPropertiesInherited: false, type: TrackType.Event) {
        sellGroup
        categoryFlow
        productFinderGroup
        item_id(required: false, type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
    }
    "/sell/congrats/listing_types"(platform: "/web", isAbstract: true) {}
    "/sell/congrats/listing_types/show"(platform: "/web", parentPropertiesInherited: false, type: TrackType.Event) {
        sellGroup
        categoryFlow
        productFinderGroup
        item_id(required: false, type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        has_free(required: true, type: PropertyType.Boolean)
    }
    "/sell/congrats/congrats_catalog_items"(platform: "/web", isAbstract: true) {}
    "/sell/congrats/congrats_catalog_items/show"(platform: "/web", parentPropertiesInherited: false, type: TrackType.Event) {
        sellGroup
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        list_mode(required: true, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST"])
    }

    "/sell/congrats/share_task"(platform: "/web", isAbstract: true) {}
    "/sell/congrats/share_task/email"(platform: "/web", type: TrackType.Event) {}
    "/sell/congrats/share_task/facebook"(platform: "/web", type: TrackType.Event) {}
    "/sell/congrats/share_task/twitter"(platform: "/web", type: TrackType.Event) {}

    "/sell/congrats/go_kyc_onboarding"(platform: "/web", type: TrackType.Event) {
        seller_type(required: true, description: "Seller type: normal, real_estate_agency, etc", values:["normal", "car_dealer", "real_estate_agency", "brand"], type: PropertyType.String)
        seller_id(required: true, type: PropertyType.Numeric)
    }

    "/sell/congrats/go_health_action"(platform: "/web", type: TrackType.Event) {
        action(required: true, description: "Health action: picture, price, video, etc", values:["publish", "price", "whatsapp", "video", "picture", "upgrade_listing", "technical_specification"], type: PropertyType.String)
    }

    "/sell/presip"(platform: "/web", type: TrackType.View) {
        sellGroup
        item_type(required: true, description: "item type", values:["default", "product", "no_prediction"], type: PropertyType.String)
    }
    "/sell/presip/review"(platform: "/web", type: TrackType.Event) {}
    "/sell/presip/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/sip"(platform: "/web", type: TrackType.View) {
        sellGroup
        listingTypeFlow
        item_type(required: true, description: "item type", values:["default", "product", "no_prediction"], type: PropertyType.String)
    }
    "/sell/sip/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/sip/calculator"(platform: "/web", isAbstract: true) {}
    "/sell/sip/calculator/show"(platform: "/web", type: TrackType.Event) {}

    "/sell/sip/sidebar_listing_type"(platform: "/web", isAbstract: true) {
        listingTypeFlow
    }
    "/sell/sip/sidebar_listing_type/show"(platform: "/web", type: TrackType.Event) {
        listingTypeFlow
    }

    "/sell/congrats/instant_pay_listings"(platform: "/web", isAbstract: true) {}
    "/sell/congrats/instant_pay_listings/show"(platform: "/web", type: TrackType.Event) {
        listingTypeFlow
    }

    // Catalog Optin flow for apps
    "/sell/catalog_optin"(platform: "/mobile", isAbstract: true) {
        item_id(required: true, description: "Session id for a specific user flow", type: PropertyType.String)
        session_id(required: false, description: "Session id for a specific user flow", type: PropertyType.String)
    }
    "/sell/catalog_optin/init"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/catalog_optin/on_boarding"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/confirmation_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/variation_selection"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/product_detail"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/category_navigation"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/condition"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/warranty_type"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/warranty_time"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/invoice"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/congrats"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/congrats_invalid_product"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/color_selection_buybox"(platform: "/mobile", type: TrackType.View) {}
    "/sell/catalog_optin/attributes_confirmation"(platform: "/mobile", type: TrackType.View) {}

    "/sell/variation_selection"(platform: "/web", isAbstract: true) {
        sellGroup
    }

    "/sell/variation_selection/source_variations"(platform: "/web", isAbstract: true) {}

    "/sell/variation_selection/source_variations/show"(platform: "/web", type: TrackType.Event) {
        variations_id(required: true, platform: "/web", description: "ids of variations showed", type: PropertyType.ArrayList(PropertyType.Numeric))
    }

    "/sell/variation_selection/source_variations/confirm_variation"(platform: "/web", type: TrackType.Event) {
        variation_id(required: false, description: "variation id picked", type: PropertyType.Numeric)
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS SYI v4 - RealEstate
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/sell/item_data/location"(platform: "/web", parentPropertiesInherited: false, isAbstract: true) {
        listingTypeFlow
        seller_profile(required: true, description: "Type of seller", type: PropertyType.String)
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation")
        list_mode(required: false, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST", "LIST_AGAIN", "CHANGE_CATEGORY"])
        category_id(required: true, PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Item's category tree")
        user_type(required: false, type: PropertyType.String, description: "The user type")
        business(required: false,  values:["classified", "none", "marketplace"], type: PropertyType.String, description: "this is the user site business")
        platform(required: false, values:["pi", "ml", "mp"], type: PropertyType.String, description: "this is the user site platform")
    }
    "/sell/item_data/location/show"(platform: "/web", type: TrackType.Event) { }
    "/sell/item_data/location/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/location/intent"(platform: "/web", type: TrackType.Event) {
        intentGroup
    }

    "/sell/item_data/pictures"(platform: "/web", isAbstract: true) {
        listingTypeFlow
    }
    "/sell/item_data/pictures/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/pictures/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/pictures/intent"(platform: "/web", type: TrackType.Event) {
        pictureIntentGroup
    }

    "/sell/item_data/plans"(platform: "/web", isAbstract: true) {
        sellGroup
        listingTypeFlow
    }
    "/sell/item_data/plans/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_data/pictures_modal"(platform: "/web", isAbstract: true) {
        sellGroup
        listingTypeFlow
    }
    "/sell/item_data/pictures_modal/show"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_data/title_and_description"(platform: "/web", parentPropertiesInherited: false, isAbstract: true) {
        listingTypeFlow
        seller_profile(required: true, description: "Type of seller", type: PropertyType.String)
        seller_segment(required: true, type: PropertyType.String, description: "Seller segment by GMV")
        session_id(required: true, type: PropertyType.String, description: "Id for user session")
        vertical(required: false, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        item_type(required: true, description: "item type", values:["default", "product"], type: PropertyType.String)
        seller_reputation(required: true, type: PropertyType.String, description: "Seller's reputation")
        list_mode(required: false, type: PropertyType.String, description: "Listing mode", values: ["LIST_EQUALS", "LIST_SIMILAR", "LIST", "LIST_AGAIN", "CHANGE_CATEGORY"])
        category_id(required: true, PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Item's category tree")
        user_type(required: false, type: PropertyType.String, description: "The user type")
        business(required: false,  values:["classified", "none", "marketplace"], type: PropertyType.String, description: "this is the user site business")
        platform(required: false, values:["pi", "ml", "mp"], type: PropertyType.String, description: "this is the user site platform")
    }
    "/sell/item_data/title_and_description/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/title_and_description/confirm"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/technical_specifications/intent"(platform: "/web", type: TrackType.Event) {
        technicalSpecsIntentsGroup
    }

    "/sell/onboarding"(platform: "/web", isAbstract: true) {
        business(required: true,  values:["classified", "none", "marketplace"], type: PropertyType.String, description: "this is the user site business")
        vertical(required: true, description: "item vertical", values:["core", "motors", "real_estate", "services"], type: PropertyType.String)
        platform(required: true, values:["pi", "ml", "mp"], type: PropertyType.String, description: "this is the user site platform")
        category_path(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Item's category tree")

    }
    "/sell/onboarding/splash"(platform: "/web", isAbstract: true) {}
    "/sell/onboarding/splash/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/onboarding/splash/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/error_step"(platform: "/web", isAbstract: true) {
        shieldGroup
        seller_reputation(required: false, type: PropertyType.String, description: "Seller's reputation")
        item_type(required: false, description: "item type", values:["default", "product"], type: PropertyType.String)
    }
    "/sell/error_step/package_error"(platform: "/web", isAbstract: true) {}
    "/sell/error_step/package_error/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/error_step/package_error/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/error_step/package_empty"(platform: "/web", isAbstract: true) {}
    "/sell/error_step/package_empty/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/error_step/package_empty/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/error_step/user_has_debt_error"(platform: "/web", isAbstract: true) {}
    "/sell/error_step/user_has_debt_error/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/error_step/user_has_debt_error/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/item_data/video"(platform: "/web", isAbstract: true) {
        listingTypeFlow
    }
    "/sell/item_data/video/show"(platform: "/web", type: TrackType.Event) {}
    "/sell/item_data/video/confirm"(platform: "/web", type: TrackType.Event) {}

    "/sell/product_suggestion"(platform: "/", isAbstract: true) {}

    "/sell/product_suggestion/title"(platform: "/", isAbstract: true) {}

    "/sell/product_suggestion/title/personal_data_validation"(platform: "/web", type: TrackType.Event) {
        text(required: true, description: "Suggested title of catalog product", type: PropertyType.String)
        seller_profile(required: true, description: "Type of seller", type: PropertyType.String)
        domain_id(required: true, description: "Product domain id", type: PropertyType.String)
        product_id(required: true, description: "Catalog product id", type: PropertyType.String)
        has_validation_error(required: true, description: "Title has personal validation error or not", type: PropertyType.Boolean)
        error_references(required: true, description: "List of validation error references", PropertyType.ArrayList(PropertyType.String))
    }

    "/sell/product_suggestion/other_suggestion"(platform: "/", isAbstract: true) {}

    "/sell/product_suggestion/other_suggestion/personal_data_validation"(platform: "/web", type: TrackType.Event) {
        text(required: true, description: "Other suggestion of catalog product", type: PropertyType.String)
        seller_profile(required: true, description: "Type of seller", type: PropertyType.String)
        domain_id(required: true, description: "Product domain id", type: PropertyType.String)
        product_id(required: true, description: "Catalog product id", type: PropertyType.String)
        has_validation_error(required: true, description: "Other suggestion has personal validation error or not", type: PropertyType.Boolean)
        error_references(required: true, description: "List of validation error references", PropertyType.ArrayList(PropertyType.String))
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS SYI v4 - Motors
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    // Flash Offer Experiment
    "/sell/flash_offer"(platform: "/web", isAbstract: true) {}
    "/sell/flash_offer/hub"(platform: "/web", type: TrackType.View) {}
    "/sell/flash_offer/hub/sell_by_my_self"(platform: "/web", type: TrackType.Event){}
    "/sell/flash_offer/hub/sell_fast"(platform: "/web", type: TrackType.Event){}
    "/sell/flash_offer/info"(platform: "/web", type: TrackType.View){}
    "/sell/flash_offer/info/go_to_sell"(platform: "/web", type: TrackType.Event){}


}
