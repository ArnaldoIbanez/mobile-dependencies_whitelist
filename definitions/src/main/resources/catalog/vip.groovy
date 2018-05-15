import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    //VIP FLOW

    "/vip"(platform: "/") {

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

        // ONLY CORE FIELDS
        quantity( required: false, type: PropertyType.Numeric, description: "Available items quantity show at this vip")
        // TODO, podemos hacerlo required? Hay casos donde un item no tengan price?
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        discount_reasons( required: false, type: PropertyType.ArrayList, description: "The discounts applied to this item original_price, to finally show price (loyalty, deal)")

        review_rate(required: false, type: PropertyType.Numeric, inheritable: false,
                description: "The rating average of the reviews")
        reviews_attributes(required: false, type: PropertyType.ArrayList, inheritable: false,
                description: "Reviewable catalog attribute names")
        return_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has free return for the item")
        cart_content(required: false, type: PropertyType.Boolean,
                description: "Indicates if the VIP has cart features (only for core items)")

        //SELLER FIELDS
        seller_id(required: true, type: PropertyType.Numeric)
        power_seller_status(required: false, type: PropertyType.String, values: ["silver", "gold", "platinum"],
                description: "Seller's Mercado Lider level")
        reputation_level(required: false, type: PropertyType.String,
                values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"],
                description: "Seller's reputation level")

        // CLASI FIELDS
        reservation_price(required: false, description: "Price of the reservation")
        quotation_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item can be quoted (cotizado)")
        comparator_available(required: false, type: PropertyType.Boolean,
                description: "Indicates if clasi item has model comparator available")
        gallery_pattern(required: false, type: PropertyType.String,
                description: "String in which each char indicates if the image's maxSize is bigger than the " +
                        "double of the gallery size ('X'), smaller than the double but bigger than de gallery size ('Y'), " +
                        "or smaller than the gallery size ('Z')")

        // OFFICIAL_STORES
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        store_type(required: false, type: PropertyType.String, values: ["normal", "brand"], description: "Indicates store type")

        // SHIPPING ( NOT PRESENT IN CLASI )
        shipping_preference(required: false, type: PropertyType.String,
                description: "Shipping method's name shown when the user has zipcode/location preloaded")
        shipping_mode(required: false, type: PropertyType.String, values: ["not_specified", "custom", "me1", "me2"],
                description: "Mercado Envios mode")
        free_shipping(required: false, type: PropertyType.Boolean,
                description: "Indicates if the items has free shipping")
        local_pick_up(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has local pick up")
        logistic_type(required: false,
                values: ["not_specified", "default", "drop_off", "xd_drop_off", "custom", "cross_docking", "fulfillment"],
                type: PropertyType.String, description: "Indicates the logistic type of the item")
        free_shipping_benefit(required: false, type: PropertyType.Boolean,
                description: "Indicates if the user has free shipping for loyalty benefit")
        shipping_promise(required: false, description: "Array of shippping promise in the order with following data")
        //afterDispatch: if unknown or unknown_frame (true/false)
        //min_days: minimum number of days of the promise. (int)
        //max_days: maximun number of days of the promise. (int or null -If it doesn´t apply-)  

        // USER FIELD
        loyalty_level(required: false, type: PropertyType.Numeric, description: "User's loyalty level")

        // SUBSCRIPTIONS (ONLY CORE)
        available_subscriptions(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has available subscriptions")
        subscription_discount(required: false, type: PropertyType.Numeric,
                description: "The value of the discount when the user subscribes to the item")
        default_tab(required: false, type: PropertyType.String, values: ["buy", "subscription"],
                description: "Indicates if the 'buy' tab or the 'subscription' tab is shown by default in the short description")
    }

    "/vip"(platform: "/web") {
        specifications_size(required: false, type: PropertyType.Numeric, description: "Specifications attributes quantity")
        description_type(required: false, description: "Description type: plain text, html, both, none",
                values: ["plain_text", "html", "both", "none"])
        max_size_gallery(required: false, type: PropertyType.String, description: "Max_size of first picture gallery")
    }

    "/vip"(platform: "/mobile") {
        context(required: false)
        resolution(required: false, description: "Indicates if the device has high or low resolution")
    }

    "/vip/abort"(platform: "/mobile", type: TrackType.Event) {}

    "/vip/failure"(platform: "/mobile", type: TrackType.Event) {
        error_message()
    }

    "/vip/back"(platform: "/mobile", type: TrackType.Event) {}

    "/vip/seller_reputation"(platform: "/mobile") {}

    "/vip/seller_reputation/ratings"(platform: "/mobile") {}

    "/vip/color_and_size"(platform: "/mobile") {}

    "/vip/description"(platform: "/mobile") {
        empty_description(type: PropertyType.Boolean, required: false, inheritable: false)
    }

    "/vip/description/failure"(platform: "/mobile") {}

    "/vip/description/abort"(platform: "/mobile") {}

    "/vip/description/back"(platform: "/mobile") {}

    "/vip/item_gallery"(platform: "/mobile", parentPropertiesInherited: false) {
        context(required: false)
    }

    "/vip/item_gallery/back"(platform: "/mobile") {}

    "/vip/contact_seller"(platform: "/", type: TrackType.Event) {
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        source(required: false, description: "Source of the referred")
    }

    "/vip/call_seller"(platform: "/", type: TrackType.Event) {
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        source(required: false, description: "Source of the referred")
    }

    "/vip/show_phone"(platform: "/", type: TrackType.Event) {
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
        source(required: false, description: "Source of the referred")
    }

    "/vip/coordinate_availability"(platform: "/mobile", type: TrackType.Event) {}

    "/vip/contract_intention"(platform: "/mobile", type: TrackType.Event) {}

    "/vip/map/"(platform: "/mobile") {}

    "/vip/payment_method"(platform: "/mobile") {}

    "/vip/payment_method/back"(platform: "/mobile") {}

    "/vip/variations"(platform: "/") {}

    "/vip/variations/back"(platform: "/mobile") {}

    "/vip/protected_purchase"(platform: "/web/mobile", type: TrackType.Event, isAbstract: true) {}

    "/vip/protected_purchase/show"(platform: "/web/mobile", type: TrackType.Event) {}

    "/vip/protected_purchase/close"(platform: "/web/mobile", type: TrackType.Event) {}

    "/vip/quantity"(platform: "/mobile") {}

    "/vip/reviews"(platform: "/", type: TrackType.View) {
        show(required: false, inheritable: false, type: PropertyType.String)
    }

    // ADDRESS

    "/address"(platform: "/mobile", isAbstract: true) {}

    "/address/add_address"(platform: "/mobile", type: TrackType.View) {
        context()
    }

    "/address/add_address/back"(platform: "/mobile", type: TrackType.Event) {}

    "/address/add_address/apply"(platform: "/mobile", type: TrackType.Event) {}


    // SHIPPING FLOW

    "/shipping"(platform: '/mobile', isAbstract: true) {}

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

    "/vip/shipping/calculator"(platform: "/", isAbstract: true) {
    }

    "/vip/shipping/calculator/calculate"(platform: "/", type: TrackType.Event) {
        cp_autocomplete(type: PropertyType.Boolean)
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
}
