import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    //VIP FLOW

    "/vip"(platform: "/") {
        item_id(required: true, description: "Item ID")
        category_id(required: true, description: "Item's category id")
        deal_ids(required: false, description: "IDs of applied discounts")
        buying_mode(required: false, description: "Indicates if it's an aution, buy_it_now or classified")
        official_store_id(required: false, description: "Id of item's official store")
        item_status(required: false, description: "Whenever the items is active, closed or paused")
        category_path(required: false, "Category path of the the item")
        vertical(deprecated: true, required: false)
        quantity(deprecated: true, required: false)
        item_condition(deprecated: true, required: false)
        currency_id(deprecated: true, required: false)
        price(deprecated: true, required: false)
        seller_id(deprecated: true, required: false)
        power_seller_status(deprecated: true, required: false)
        listing_type_id(deprecated: true, required: false)
        start_time(deprecated: true, required: false)
        stop_time(deprecated: true, required: false)
        shipping_mode(deprecated: true, required: false)
        free_shipping(deprecated: true, required: false)
        local_pick_up(deprecated: true, required: false)
        promoted_items_clicked(required: false, descripcion: 'Indicates whether clicked promoted items before reaching this vip')
        billboard_clicked_position(required:false, type: PropertyType.Numeric)
        store_type(required: false, description: "Indicates store type")
        reputation_level(required: false, description: "Seller's reputation level")
        quotation_available(required: false, type: PropertyType.Boolean, description: "Indicates if the item can be quoted (cotizado)")
        fulfillment(required: false, type: PropertyType.Boolean, description: "Indicates if the item has fulfillment")
        cart_content(required: false, type: PropertyType.Boolean, description: "Indicates if the VIP has cart features")
        loyalty_level(required: false, description: "User's loyalty level")
        free_shipping_benefit(required: false, type: PropertyType.Boolean, description: "Indicates if the user has free shipping benefit")
    }

    "/vip"(platform: "/web") {
        review_rate(inheritable: false)
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
        //TODO. remove this when inhereted from / is solved
        mode(required: false)
        sent_again(required: false)
        from_background(required: false)
        context(required: false)
    }

    "/vip/item_gallery/back"(platform: "/mobile") {}

    "/vip/contact_seller"(platform: "/", type: TrackType.Event) {
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/call_seller"(platform: "/", type: TrackType.Event) {
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/show_phone"(platform: "/", type: TrackType.Event) {
        vertical(required: false, description: "Vertical name over show phone event is displayed")
        listing_type_id(required: false, description: "Item bucket, ex: premium, gold, etc")
        item_seller_type(required: false, description: "Seller type: normal, real_estate_user, etc")
    }

    "/vip/map/"(platform: "/mobile") {}

    "/vip/buy_intention"(platform: "/mobile") {}

    "/vip/payment_method"(platform: "/mobile") {}

    "/vip/payment_method/back"(platform: "/mobile") {}

    "/vip/variations"(platform: "/mobile") {}

    "/vip/variations/back"(platform: "/mobile") {}

    "/vip/protected_purchase"(platform: "/web/mobile", type: TrackType.Event, isAbstract: true) {}

    "/vip/protected_purchase/show"(platform: "/web/mobile", type: TrackType.Event) {}

    "/vip/protected_purchase/close"(platform: "/web/mobile", type: TrackType.Event) {}

    "/vip/quantity"(platform: "/mobile") {}


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


}
