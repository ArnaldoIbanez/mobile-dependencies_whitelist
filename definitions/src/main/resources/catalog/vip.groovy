import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    //VIP FLOW

    "/vip"(platform: "/") {

        // ITEM FIELDS
        item_id(required: true, description: "Item ID")
        category_id(required: true, description: "Item's category id")
        buying_mode(required: true, values: ["buy_it_now", "auction","classified"], description: "Indicates if it's an aution, buy_it_now or classified")
        item_status(required: false, values: ["active", "closed","paused"], description: "Whenever the items is active, closed or paused")
        category_path(required: true, "Category path of the the item")
        // TODO ADD DESCRIPTIONS
        vertical(required: true , description: "Vertical of the item")
        item_condition(required: true, values: ["new","used","refurbish"])
        currency_id( required: true)
        price( required: false, description: "The price the user finally sees. Not send in classi")
        item_price(required: false, type: PropertyType.Map, description: "Indicates the item price in different currencies")
        listing_type_id(required: true)
        deal_ids(required: false, description: "IDs of applied discounts")
        review_rate(required: false, inheritable: false)
        reviews_attributes(required: false, inheritable: false)
        return_available(required: false, type: PropertyType.String, values: ["yes", "no"], description: "Indicates if the user has free return for the item")

        //SELLER FIELDS
        seller_id( required: true)
        power_seller_status(required: true )
        reputation_level(required: false, description: "Seller's reputation level")

        // CLASI FIELDS
        reservation_price( required: false, description: "")
        quotation_available(required: false, type: PropertyType.Boolean, description: "Indicates if the item can be quoted (cotizado)")

        // OFFICIAL_STORES
        official_store_id(required: false, description: "Id of item's official store")
        store_type(required: false, description: "Indicates store type")

        // SHIPPING ( NOT PRESENT IN CLASI )
        shipping_mode(required: false)
        free_shipping(required: false)
        local_pick_up(required: false)
        fulfillment(required: false, type: PropertyType.Boolean, description: "Indicates if the item has fulfillment")
        free_shipping_benefit(required: false, type: PropertyType.Boolean, description: "Indicates if the user has free shipping benefit")

        cart_content(required: false, type: PropertyType.Boolean, description: "Indicates if the VIP has cart features")
        loyalty_level(required: false, description: "User's loyalty level")
    }

    "/vip"(platform: "/web") {
        specifications_size(required: false, description: "Specifications attributes quantity")
        description_type(required: false, description: "Description type: plain text, html, both, none", values: ["plain_text", "html", "both", "none"])
        max_size_gallery(required: false, description: "Max_size of first picture gallery")
    }

    "/vip"(platform: "/mobile") {
        category_id(required: false, description: "Item's category id")
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
