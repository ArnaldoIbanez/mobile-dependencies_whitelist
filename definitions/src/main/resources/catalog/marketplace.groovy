
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

/**
*
* The events means actions that happens without launch a View,
* as example of that we can consider Bookmark an item in a VIP page
* Every event is an action, so the verbs available are:
*
* - back:  the event of back from a page, specially in mobile
* - abort: the user abort the action (e.g: back pressed before api response)
* - delete: when something is deleted
* - apply: when a criteria is applied
* - post: create a new entity
*/

tracks {
    def categoryRegex = /(ROOT|[a-zA-Z]{1,3}[0-9]+)/
    def categoryPathRegex = /\[([a-zA-Z]{1,3}[0-9]+(, )?)*\]/

    "/"(platform: "/", isAbstract: true) {
        //Recommendations data
        recommendations (required: false, description: "Recommendations data map")
            // has_errors,
            // hidden_by_client,
            // client,
            // backend_id,
            // track_info:[
            //              has_recommendations,
            //              item_category,
            //              recommended_items:[]
            //              recommended_categories:[]      
            //    ]
            //
    }

    "/"(platform: "/mobile", isAbstract: true) {
        mode(required: false)
        deferred_time(required: false)
        sent_again(required: false)
        from_background(required: false)
    }

    "/"(platform: "/web", isAbstract: true) {
        headers(required: false)
        cookies(required: false)
        http_url(required: false)
        http_referer(required: false)
    }

    //EXTERNAL
    //TODO revisar /external/XXX

    "/external/"(platform: "/mobile") {
        query(required: false)
        limit(type: PropertyType.Numeric, required: false)
        offset(type: PropertyType.Numeric, required: false)
        total(description: "amount of search items returned", type: PropertyType.Numeric, required: false)
        category_id(regex: categoryRegex, required: false)
        category_path(description: "path from root category", regex: categoryPathRegex, type: PropertyType.ArrayList, required: false)
        sort_id(required: false)
        filters(required: false)
        filter_user_applied(deprecated: true, required: false)

        news_id(required: false)
        notification_type(required: false)
        deal_id(required: false)
        url(required: false)
    }

    "/external/search"(platform: "/mobile") {
    }

    "/external/failure"(platform: "/mobile") {
        error_message()
    }

    "/external/abort"(platform: "/mobile") {}

    "/external/back"(platform: "/mobile") {}

    "/external/vip"(platform: "/mobile") {
        item_id()
    }

    //HOME FLOW

    "/home"(platform: "/mobile") {
        retry_after_error(required: false)
    }

    "/home/failure"(platform: "/mobile", type: TrackType.Event) {
          error_message(required: false)
    }

    // long_press y contextual_menu son la misma acción, se preservan por temas de compatibilidad.
    "/home/long_press"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/contextual_menu"(platform: "/mobile", type: TrackType.Event) {
        item_id()
    }

    // share y contextual_menu/share son la misma acción, se preservan por temas de compatibilidad.
    "/home/share"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/contextual_menu/share"(platform: "/mobile", type: TrackType.Event) {
        item_id()
    }

    "/home/back"(platform: "/mobile") {
    }

    "/home/pulltorefresh"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/pulltorefresh/failure"(platform: "/mobile", type:TrackType.Event) {
    }

    "/home/pulltorefresh/abort"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll/failure"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll/abort"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/abort"(platform: "/mobile") {
    }

    "/home/tap"(platform: "/mobile") {
        position(type: PropertyType.Numeric)
        section()
        tag_id()
    }

    "/home/carousel"(platform: "/mobile", isAbstract: true) {
    }

    "/home/carousel/firstTO"(platform: "/mobile") {
    }

    "/home/carousel/lastcard"(platform: "/mobile") {
    }

    //REVIEWS FRONTEND
    "/reviews/form"(platform: "/") {
        item_id()
    }

    "/reviews/edit"(platform: "/") {
        item_id()
    }

    "/reviews/congrats/delete"(platform: "/") {
        item_id()
    }

    "/reviews/congrats/edit"(platform: "/") {
        item_id()
        review_length()
    }

    "/reviews/congrats"(platform: "/") {
        item_id()
        review_length(inheritable: false)
    }

    "/reviews/error"(platform: "/") {
        item_id()
    }

    "/reviews/email"(platform: "/email") {
        item_id()
    }

    "/reviews"(platform: "/") {
        item_id()
    }

    //SEARCH FLOW

    "/search"(platform: "/") {
        query(required: false)
        limit(type: PropertyType.Numeric)
        offset(type: PropertyType.Numeric)
        total(description: "amount of search items returned", type: PropertyType.Numeric, required: false)
        category_id(regex: categoryRegex, required: false)
        category_path(description: "path from root category", regex: categoryPathRegex, type: PropertyType.ArrayList, required: false)
        sort_id(required: false)
        filters(required: false)
        autoselected_filters(required: false, PropertyType.ArrayList)
        view_mode(required: false, description: "MOSAIC, LIST or GALLERY")
        filter_user_applied(deprecated: true, required: false)
        tienda_oficial(deprecated: true, required: false)
        official_store_id(deprecated: true, required: false)
        deal(deprecated: true, required: false)
        filter_tags(required: false, PropertyType.ArrayList)
        results(required: false, PropertyType.ArrayList,description:"item ids from search result")
        billboards(required: false, PropertyType.ArrayList, descriptoion: "items ids from billboard results")
        isRetina(required: false, description: 'Whether the screen is retina display')
        //Tracks from Search Backend:
        backend_data(required: false)
            //ab(required: false, description:'ab testing related. to be deprecated')
            //ab_bucket(required: false, PropertyType.ArrayList, description:'ab testing related. to be doprecated')
            //aa(required: false, PropertyType.ArrayList, description:'applied search algorithim tag. Comblinable')
            //ac(required: false, PropertyType.ArrayList, description:'applied search algorithim tag. Not Comblinable')
            //ap(required: false, PropertyType.ArrayList, description:'applied search algorithim tag. Combinable with other pages')
            //fsm(required: false, description:'indicates on each result of paged if its full or soft match')
            //qas(required: false, PropertyType.ArrayList, description:'auto selected filters')
            //canonical(required: false, description:'url canonical')
            //cli_rel_qty_configured(required: false, description:'client relationship')
            //cli_rel_qty_link_to_category(required: false, description:'client relationship link to category')
            //corrections(required: false, description:'corrections over query')
            //processed_query(required: false, description:'processed query by backend')
            //stems(required: false, description:'stems list which returns backend to stand out in frontend'
    }

    "/search"(platform: "/web") {
        visual_id(required: false)
        config_version(required: false)
        filters(required: false)
        only_in_type(required: false)
        click_banner(required: false, description:'Indicates that this listing has apppeared after clicking on a banner')
        // exhibitors_id
        banner(required: false, description:'Banner showed in this listing info, if showed')
        //deal_id
        // exhibitors_id
        related_searches(required: false, description:'indicates whether clicked search related')
        //query
        // position
        //quantity
        autosuggest(required: false, description:'indicates whether clicked autosuggest')
        //suggest_position
        //last_search_position
        //block_store_position
        landing(required:false, description:'indicates landing base, premium, etc')
        pads(required: false, description:'item_id from the pads returned for listings')
        layout(required: false, description:'layout of search')
        geolocation(required: false, description:'geolocation')
        landing(required: false, description:'landings: base, premium, etc')
        layout_forced(required: false, description:'true if layout is changed by the user')
}

    "/search"(platform: "/mobile") {
        filter_user_applied(deprecated: true, required: false)
        context(required: false)
    }

    "/search/failure"(platform: "/mobile", type: TrackType.Event) {
        error_message()
        limit(required: false, description: "override required property")
        offset(required: false, description: "override required property")
    }

    "/search/long_press" (platform: "/mobile", type: TrackType.Event){
        item_id()
    }

    "/search/share" (platform: "/mobile", type: TrackType.Event){
        item_id()
    }

    "/search/back" (platform: "/mobile", type: TrackType.Event) {}

    "/search/abort"(platform: "/mobile", type: TrackType.Event) {
        limit(required: false, description: "override required property")
        offset(required: false, description: "override required property")
    }

    "/search/filters"(platform: "/mobile") {}

    "/search/refine"(platform: "/mobile") {}

    "/search/refine/apply"(platform: "/mobile", type: TrackType.Event) {}

    "/search/refine/back"(platform: "/mobile", type: TrackType.Event) {}

    "/search/refine/select_filter"(platform: "/mobile") {
        filter_id()
    }

    "/search/refine/select_filter/apply"(platform: "/mobile") {
        filter_value_id()
        filter_value_name()
    }

    "/search/change_view"(platform: "/mobile") {}

    "/search/change_view/apply"(platform: "/mobile", type: TrackType.Event) {
        list_mode()
    }

    "/search/input"(platform: "/mobile", parentPropertiesInherited: false) {
        //TODO. remove this when inhereted from / is solved
        mode(required: false)
        sent_again(required: false)
        from_background(required: false)
    }

    "/search/input/back"(platform: "/mobile") {}

    "/search/promoted_items/"(platform: "/web", isAbstract: true) {}

    "/search/promoted_items/show"(platform: "/web", type: TrackType.View) {
        item_type(required: true, values: ["properties", "projects"])
    }

    "/search/billboard"(platform: "/", type: TrackType.Event) {
        position_shown(required: false, type: PropertyType.Numeric)
        move(required: false, values: ["forward","backward"])
    }

    "/search/billboard/resize"(platform: "/web", type: TrackType.Event) {
        action(required: true, values: ["expand","collapse"])
    }

    "/search/carousel"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        carousel_used(required: true, values: ["next","prev","select"])
    }

    "/search/save"(platform: "/", type: TrackType.Event) {
    }

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
        promoted_items_clicked(required: false, descripcion: 'indicates whether clicked promoted items before reaching this vip')
        billboard_clicked_position(required:false, type: PropertyType.Numeric)
        store_type(required: false, description: "Indicates store type")
        reputation_level(required: false, description: "Seller's reputation level")
        quotation_available(required: false, type: PropertyType.Boolean, description: "Indicates if the item can be quoted (cotizado)")
        fulfillment(required: false, type: PropertyType.Boolean, description: "Indicates if the item has fulfillment")
    }

    "/vip"(platform: "/web") {
        review_rate(inheritable: false)
    }

    "/vip"(platform: "/mobile") {
        category_id(required: false, description: "Item's category id")
        context(required: false)
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

    //BOOKMARKS

    "/bookmarks/action"(platform: "/mobile", isAbstract: true) {}

    "/bookmarks"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {
        context(required: false)
    }

    //deprecated: true
    "/bookmarks/post"(platform: "/mobile", type: TrackType.Event) {
        item_id()
    }

    //deprecated: true
    "/bookmarks/delete"(platform: "/mobile", type: TrackType.Event) {
        item_id()
    }

    "/bookmarks/action/post"(platform: "/mobile", type: TrackType.Event) {
        item_id()
        action_location(required:false, type: PropertyType.String)
    }

    "/bookmarks/action/delete"(platform: "/mobile", type: TrackType.Event) {
        item_id()
        action_location(required:false, type: PropertyType.String)
    }

    // Questions
    "/questions"(platform: "/mobile", isAbstract: true) {
        item_id(required: false)
        context()
    }

    "/questions/list"(platform: "/mobile") {}

    "/questions/ask"(platform: "/mobile") {}

    "/questions/ask/post"(platform: "/mobile", type: TrackType.Event) {
        //TODO revisar si no conviene pasar failed() a otro path "/questions/ask/post/failed"
        failed()
        question_id(required: false, description: "it has no value if failed is true")
    }

    "/questions/ask/back"(platform: "/mobile", type: TrackType.Event) {
    }

    "/questions/answer"(platform: "/mobile") {
        from_deeplink(required: false, description: "True, when it access from deeplink, otherwise not")
    }

    "/questions/answer/post"(platform: "/mobile", type: TrackType.Event) {
        failed()
        question_id(required: false, description: "it has no value if failed is true")
        attach_id(required: false, description: "Attached Item id")
    }

    "/questions/answer/back"(platform: "/mobile", type: TrackType.Event) {
    }

    "/questions/back"(platform: "/mobile") {}

    //CHECKOUT FLOW

    "/checkout"(platform: "/", isAbstract: true) {
    }

    "/checkout/ordercreated"(platform: "/web", type: TrackType.Event) {
        order_id()
        status()
        total_amount()
        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id
        platform()

        buyer()
        //id
        //nickname
        seller(type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
        errors()

        congrats_seq(serverSide: true)
        first_for_order(serverSide: true)
        total_amount_local(serverSide: true)
        total_amount_usd(serverSide: true)
    }

    "/checkout/login"(platform:"/web", isAbstract: true) {
        vip_parameters(required: true, description: "Parameters that came from the VIP")
        //cht
        //pm
        //inst
        //bp
        //zip_code
        //shipping_method_id
        //ship_method_id
        //ship_option_id
        //cc_issuer
        //is_logged
        //prefs_on
    }
    "/checkout/login/confirm_authenticated"(platform: "/web") {}
    "/checkout/login/first_purchase_not_authenticated"(platform: "/web") {}
    "/checkout/login/confirm_not_authenticated"(platform: "/web") {}

    "/checkout/payments"(platform:"/web", isAbstract: true) {
        order_id(required: true, description: "OrderId")
        status(required: true, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform()

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
            //item
                //id
                //variation_id
                //buying_mode
                //shipping_mode
                //category_id
                //deal_ids
            //quantity
            //unit_price
            //currency_id

        tracking_referer_page(required: false, description: "tracking referer page from where the request came")
    }
    "/checkout/payments/select_payment_method"(platform: "/web") {}
    "/checkout/payments/select_payment_type"(platform: "/web") {}
    "/checkout/payments/select_split_payment"(platform: "/web") {}
    "/checkout/payments/input_proactive_payment_amount"(platform: "/web") {}

    "/checkout/payments/installments#submit"(platform:"/web", type: TrackType.Event) {
        pay_pref_id(required: true, description: "payment preference Id")
        total_price(required: true, description: "Total price")
        preferred_installment(required: true, description: "preferred Installment")
        max_installments_without_fee(required: true, description: "max Installments Without Fee")
        selected_installment(required: true, description: "selected Installment")
    }

    //Web and Apps track is the same
    "/checkout/review"(platform:"/") {
        order_id(required: false, description: "OrderId") //Apps might not have an order
        status(required: false, description: "status") //Apps might not have an order
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform()

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
            //item
                //id
                //variation_id
                //buying_mode
                //shipping_mode
                //category_id
                //deal_ids
            //quantity
            //unit_price
            //currency_id
        buyer(required: false)
        //id
        //nickname

        seller(required: false,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }

    "/checkout/congrats"(platform:"/web") {
        order_id(required: true, description: "OrderId")
        status(required: true, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: true, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform()

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: true)
        //id
        //nickname

        seller(required: true,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname

        proactive_two_payment(required: false, description: "tracking proactive two payment selection")
        total_amount_local(serverSide: true)
        total_amount_usd(serverSide: true)
    }

    /*******************************************************************/
    //Mobile Checkout Apps
    "/checkout/wrapper"(platform:"/mobile") {} //Melidata experiment
    "/checkout/init"(platform:"/mobile") {
        //Might not have most of status values in case of requestFailure
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: false, description: "totalAmount")
        total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: false, description: "BP flag")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        platform(required: true)

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: false)
        //id
        //nickname

        seller(required: false,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
        //View specific data
        success(required: true, type: PropertyType.Boolean)
        location(required: false, type: PropertyType.String)
        geolocation_method(required: false, type: PropertyType.String)
    }
    "/checkout/geolocation" (platform: "/mobile", type: TrackType.Event) {
        geolocation_error(required: true, description: "Why the geo failed")
    }
    "/checkout/shipping"(platform: "/mobile", isAbstract: true) {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)

        payments(required: true, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: true)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: true)
        //id
        //nickname

        seller(required: true,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }
    //Fallback/Custom shipping
    "/checkout/shipping/select_method"(platform: "/mobile") {
        //View specific data
        selections(required: true, type: PropertyType.ArrayList)
    }
    //Fallback/inconsistency
    "/checkout/shipping/select_method/inconsistency"(platform: "/mobile") {
        //View specific data
        error_code(required: false, type: PropertyType.String)
        inconsistency(required: false, type: PropertyType.String)
    }
    //Geolocation on fallback
    "/checkout/shipping/select_method/ask_enable_geolocation"(platform: "/mobile") {}
    "/checkout/shipping/select_method/ask_enable_geolocation#geolocation_permission_ask"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        granted(required: true, type: PropertyType.String)
    }
    "/checkout/shipping/select_method/ask_enable_geolocation#geolocation_enabled"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        status(required: true, type: PropertyType.String)
    }
    "/checkout/shipping/select_method/ask_enable_geolocation#unable_to_use_location_services"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    //Geolocation
    "/checkout/shipping/select_method/geolocated"(platform:"/mobile") {}
    "/checkout/shipping/custom_address"(platform: "/mobile", isAbstract: true) {}
    //Input zip_code
    "/checkout/shipping/custom_address/zip_code"(platform:"/mobile") {}
    "/checkout/shipping/custom_address/zip_code#submit"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    //Query zip code
    "/checkout/shipping/custom_address/zip_code/query"(platform:"/mobile", type: TrackType.View, parentPropertiesInherited: false) {}
    "/checkout/shipping/custom_address/zip_code/query#submit"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        query_parameters (required: false, type: PropertyType.String)
        failing_url (required: false, type: PropertyType.String)
    }
    "/checkout/shipping/custom_address/zip_code/query/back"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/checkout/shipping/select_option"(platform: "/mobile", isAbstract: true) {
        //View specific data
        shipping_options(required: true, type: PropertyType.ArrayList)
        //shipping_options: [
        //  [
        //    method_name: "Normal",
        //    price: 0.0,
        //    currency_id: "ARS",
        //    free_shipping: true
        //  ]
        //]
    }
    //Select shippingOptions
    "/checkout/shipping/select_option/mercado_envios"(platform:"/mobile") {}
    "/checkout/shipping/select_option/free_shipping"(platform:"/mobile") {}
    "/checkout/shipping/select_option/custom"(platform:"/mobile") {}
    //Input address flow
    "/checkout/shipping/select_contact"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        is_from_preload_address(required: true, type: PropertyType.Boolean)
    }

    "/checkout/shipping/location"(platform: "/mobile", isAbstract: true) {}
    "/checkout/shipping/location/address#street_name"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        street_name(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#street_number"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        street_number(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#additional_info"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        additional_info(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#internal_number"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        internal_number(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#between_streets"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        between_streets(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#references"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        references(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address#neighborhood"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        neighborhood(required: false, type: PropertyType.String)
    }
    "/checkout/shipping/location/address"(platform:"/mobile") {
        //View specific data
        edit_flow(required: true, type: PropertyType.Boolean)
    }
    "/checkout/shipping/location/select_state"(platform:"/mobile") {}
    "/checkout/shipping/location/select_city"(platform:"/mobile") {}
    "/checkout/shipping/location/select_contact#submit"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        success(required: true, type: PropertyType.Boolean)
        error_codes(required: false, type: PropertyType.ArrayList)
    }
    "/checkout/shipping/location/select_contact"(platform:"/mobile") {
        //View specific data
        available_options(required: true, type: PropertyType.Numeric)
    }
    "/checkout/shipping/location/find_contact"(platform:"/mobile") {}
    "/checkout/shipping/location/new_contact"(platform:"/mobile") {
        //View specific data
        //Contact name/phone
        contact_name(required: false, type: PropertyType.String)
        contact_phone(required: false, type: PropertyType.String)
    }
    //Select address
    "/checkout/shipping/select_address"(platform: "/mobile") {
        //View specific data
        //List of available shipping_options
        shipping_options(required: true, type: PropertyType.ArrayList)
        //shipping_options: [
        //  [
        //    method_name: "Normal",
        //    price: 0.0,
        //    currency_id: "ARS",
        //    free_shipping: true
        //  ]
        //]
    }
    "/checkout/shipping/select_address/list"(platform:"/mobile") {
        shipping_options(required: false, type: PropertyType.ArrayList)
    }
    //Select paymentMethod
    "/checkout/payments/preload_credit_card"(platform:"/mobile", type:TrackType.View) {}//Melidata experiment
    "/checkout/payments"(platform: "/mobile", isAbstract: true) {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)

        payments(required: true, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: true)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: true)
        //id
        //nickname

        seller(required: true,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }
    "/checkout/payments/select_method"(platform:"/mobile") {
        //List of available payment_methods and coupon info
        available_methods(required: true, type: PropertyType.ArrayList)
        coupon(required: false, type:  PropertyType.Boolean)
        coupon_discount(required: false, type:  PropertyType.Numeric)
    }
    "/checkout/payments/select_method#new_payment_method_selected"(platform:"/mobile",  type: TrackType.Event, parentPropertiesInherited: false) {
        payment_method_id(required: false, type: PropertyType.String)
        payment_type_id(required: false, type: PropertyType.String)
    }
    "/checkout/payments/coupon_detail"(platform:"/mobile") {}
    // Add card form
    "/checkout/payments/add_debit_card"(platform:"/mobile") {}
    "/checkout/payments/add_debit_card#card_config"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        bin(required: true, type:  PropertyType.String)
        success(required: true, type:  PropertyType.Boolean)
    }
    "/checkout/payments/add_debit_card/select_bank"(platform:"/mobile") {
        available_issuers(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payments/add_prepaid_card"(platform:"/mobile") {}
    "/checkout/payments/add_prepaid_card#card_config"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        bin(required: true, type:  PropertyType.String)
        success(required: true, type:  PropertyType.Boolean)
    }
    "/checkout/payments/add_card"(platform:"/mobile") {}
    "/checkout/payments/add_card#card_config"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        bin(required: true, type:  PropertyType.String)
        success(required: true, type:  PropertyType.Boolean)
    }
    "/checkout/payments/add_card/select_bank"(platform:"/mobile") {
        available_issuers(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payments/add_card/installments"(platform:"/mobile") {
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/payments/stored_card"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payments/stored_card/security_code"(platform:"/mobile") {}
    "/checkout/payments/stored_card/installments"(platform:"/mobile") {
        credit_card_id(required: false, type: PropertyType.String)
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/payments/stored_card/installments#change_payment_method"(platform:"/mobile",  type: TrackType.Event, parentPropertiesInherited: false) {
        event_source(required: true, type: PropertyType.String)
    }
    "/checkout/payments/account_money"(platform: "/mobile", isAbstract: true) {}
    "/checkout/payments/account_money/create"(platform:"/mobile") {}
    "/checkout/payments/account_money/password"(platform:"/mobile") {}
    "/checkout/payments/account_money/password#submit"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/checkout/payments/select_issuer"(platform:"/mobile") {}
    // mlm grouping
    "/checkout/payments/cash"(platform:"/mobile", isAbstract: true) {}
    "/checkout/payments/cash/select_store"(platform:"/mobile") {
         available_methods(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payments/cash/select_store/select_address"(platform:"/mobile", parentPropertiesInherited: false) {}
    "/checkout/payments/cash/select_store#request_permissions"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
      permissions(required: true, type: PropertyType.String)
      extended(required: true, type: PropertyType.Boolean)
    }
    "/checkout/payments/transfer"(platform:"/mobile", isAbstract: true) {}
    "/checkout/payments/transfer/select_bank"(platform:"/mobile") {
        available_methods(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/payments/billing_info"(platform:"/mobile") {}
    "/checkout/payments/billing_info#submit"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        billing_info_state(required: true, type: PropertyType.String)
    }
    //"/checkout/review" //shared between web and app, already defined in web section.
    "/checkout/review#submit"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        status(required: true, type: PropertyType.String)
        credit_card_id(required: false, type: PropertyType.String)
    }
    "/checkout/review/quantity#submit"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        old_quantity(required: true, type: PropertyType.Numeric)
        selected_quantity(required: true, type: PropertyType.Numeric)
    }
    "/checkout/review/quantity"(platform:"/mobile") {}
    "/checkout/review/quantity/input"(platform:"/mobile") {}
    "/checkout/review/inconsistency"(platform: "/mobile", isAbstract: true) {}
    "/checkout/review/inconsistency/quantity"(platform: "/mobile") {
        error_code(required: false, type:  PropertyType.String)
    }
    "/checkout/review/inconsistency/price_changed"(platform: "/mobile") {}
    "/checkout/review/edit_shipping#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        //old_value, new_value
        old_value(required: true, type:  PropertyType.String)
        new_value(required: true, type:  PropertyType.String)
    }
    "/checkout/review/edit_shipping"(platform:"/mobile") {
        //List of available shipping_options
        shipping_options(required: true, type: PropertyType.ArrayList)
        //shipping_options: [
        //  [
        //    method_name: "Normal",
        //    price: 0.0,
        //    currency_id: "ARS",
        //    free_shipping: true
        //  ]
        //]
    }
    "/checkout/review/inconsistency/edit_shipping"(platform: "/mobile") {
        error_code(required: true, type:  PropertyType.String)
    }
    "/checkout/review/edit_installments#submit"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        //old_value, new_value
        old_value(required: true, type:  PropertyType.Numeric)
        new_value(required: true, type:  PropertyType.Numeric)
    }
    "/checkout/review/edit_installments"(platform: "/mobile") {
        //List of available installments
        available_installments(required: true, type: PropertyType.ArrayList)
        //installments: [
        //    [
        //      installment: 1,
        //      amount: 20.6,
        //      without_fee: true
        //    ]
    }
    "/checkout/additional_info"(platform: "/mobile") {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)

        payments(required: true, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: true)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: true)
        //id
        //nickname

        seller(required: true,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }
    //Congrats tracks - shared between Legacy App and new App (Required False to prevent catalog validation failures)
    "/checkout/congrats"(platform: "/mobile") {
        /****************************************/
        //Desktop and New CHO congrats tracs
        //TODO chage to required: true once legacy
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: false, description: "totalAmount")
        total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: false, description: "BP flag")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        register_int(required: false, description: "Integrated registration")
        platform(required: false)

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: false)
        //id
        //nickname

        seller(required: false,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
        available_actions(required: false, type: PropertyType.ArrayList, description: "Action presented on the screen, for ex: call_seller, email_seller, etc.")

        /****************************************/
        //Legacy App Congrats Tracks
        duplicated_error(required: false)
        congrats_seq(serverSide: true)
        total_amount_local(serverSide: true)
        total_amount_usd(serverSide: true)
        first_for_order(serverSide: true)
    }
    "/checkout/finish#click"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
         action(required: true, description: "Action executed, for ex: call_seller, email_seller, etc")
    }
    "/checkout/congrats/error"(platform: "/mobile") {}

    "/checkout/congrats/call_for_auth"(platform: "/mobile") {}

    "/checkout/congrats/call_for_auth/instructions"(platform: "/mobile") {}

    "/checkout/congrats/call_for_auth/later"(platform: "/mobile") {}

    "/checkout/congrats/invalid_sec_code"(platform: "/mobile") {}

    "/checkout/congrats/invalid_sec_code/input"(platform: "/mobile", parentPropertiesInherited: false) {

    }
    "/checkout/congrats/pending"(platform: "/mobile") {}

    "/checkout/error"(platform: "/mobile") {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: false, description: "totalAmount")
        total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: false, description: "BP flag")
        recovery_flow(required: false, description: "Is recovery CHO flow")
        platform(required: false)

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: false)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: false, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: false)
        //id
        //nickname

        seller(required: false,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
        error_code(required: true, type: PropertyType.String)
    }

    "/checkout/show_ticket"(platform: "/mobile") {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)
        payment_method(required: true)

        payments(required: true, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: true)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: true)
        //id
        //nickname

        seller(required: true,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }
    "/checkout/show_ticket#save"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/checkout/show_geolocation_map"(platform: "/mobile") {
        order_id(required: false, description: "OrderId")
        status(required: false, description: "status")
        total_amount(required: true, description: "totalAmount")
        total_amount_with_shipping(required: true, description: "totalAmount with shipping cost")
        total_paid_amount(required: false, description: "total pais Amount is total_amount_with_shipping plus installments fee")

        buy_equal_pay(required: true, description: "BP flag")
        recovery_flow(required: true, description: "Is recovery CHO flow")
        platform(required: true)
        payment_method(required: true)

        payments(required: true, description: "Array of payments information")
        // id
        // payment_method,
        // payment_type,
        // installments,
        // paid_amount,
        // installment_amount
        // without_fee
        // status
        // status_detail

        shipping(required: true)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //variation_id
            //buying_mode
            //shipping_mode
            //category_id
            //deal_ids
        //quantity
        //unit_price
        //currency_id

        buyer(required: true)
        //id
        //nickname

        seller(required: true,type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
    }
    "/checkout/show_geolocation_map/search"(platform: "/mobile") {}
    "/checkout/show_geolocation_map/search#location"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/checkout/show_geolocation_map/search#preloaded"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/checkout/show_geolocation_map/search#select"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/checkout/show_geolocation_map#agencies_request"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        agencies(required: true)
        payment_method(required: true)

    }

    /*******************************************************************/
    //Mobile Checkout Legacy Apps
    "/checkout"(platform:"/mobile") {
        order_id(required: false)
        status(required:false)
        total_amount(required: false, type: PropertyType.Numeric)
        order_items(required: false, description: "Array of items in the order. New: optional for old versions of mobile")
        //item
        //id
        //variation_id
        //buying_mode
        //category_id
        //deal_ids
        //quantity
        //unit_price
        //currency_id

        shipping(required: false)
        //shipping_type
        //shipping_option

        payments(required: false, description: "Array of payment information") //
        // id
        // payment_method,
        // payment_type,
        // installments,
        // selected_card
        // financed_order_cost_for_card
        // payment_must_call_for_authorize

        status_detail(required: false)
        reloaded(required: false)
        quantity_pre_selected(required: false)
        order_payment_required(required: false)
        shipping_pre_selected(required: false)

        item_id(deprecated: true, required: false)
        quantity(deprecated: true, required: false)
        order_cost(deprecated: true, required: false)
    }

    "/checkout/abort"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/congrats/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/failure"(platform: "/mobile", type: TrackType.Event) {
        error()
        message()
    }

    "/checkout/quantity_changed"(platform: "/mobile", type: TrackType.Event) {
        quantity()
    }

    //--> SHIPPING flow

    "/checkout/shipping_selection"(platform: "/mobile") {  //TODO flow
        available_types()
        current_type(required: false)
        current_option(required: false)
        available_other_methods(required: false)
    }

    "/checkout/shipping_selection/apply"(platform: "/mobile", type: TrackType.Event) {
        type()
        option(required: false)
    }

    "/checkout/shipping_selection/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/shipping_selection/address_selection"(platform: "/mobile", type: TrackType.View) {
        invalid_address()
        valid_address()
        available_other_methods(required: false)
    }

    "/checkout/shipping_selection/address_selection/back"(platform: "/mobile", type: TrackType.Event) {
        invalid_address()
        valid_address()
    }

    "/checkout/shipping_cost"(platform: "/mobile") {}

    "/checkout/shipping_cost/back"(platform: "/mobile") {}

    "/checkout/shipping_cost/apply"(platform: "/mobile", type: TrackType.Event) {
        //TODO
    }

    "/checkout/payment_selection"(platform: "/mobile") {
        available_types(type: PropertyType.ArrayList)
        available_other_methods(type: PropertyType.Boolean)
        current_type(required: false)
        current_method(required: false)
        method(required: false)
    }

    "/checkout/payment_selection/apply"(platform: "/mobile", type: TrackType.Event) {
        type()
    }

    "/checkout/payment_selection/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/payment_selection/othertype"(platform: "/mobile") {
        available_methods()
    }

    "/checkout/payment_selection/othertype/back"(platform: "/mobile") {}

    "/checkout/order_total"(platform: "/mobile") {}

    "/checkout/order_total/back"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/contact_seller_call"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/contact_seller_email"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/contact_add"(platform: "/mobile", type: TrackType.Event) {}

    "/checkout/screenshot"(platform: "/mobile", type: TrackType.Event) {}

    // ADDRESS

    "/address"(platform: "/mobile", isAbstract: true) {}

    "/address/add_address"(platform: "/mobile", type: TrackType.View) {
        context()
    }

    "/address/add_address/back"(platform: "/mobile", type: TrackType.Event) {}

    "/address/add_address/apply"(platform: "/mobile", type: TrackType.Event) {}

    // CREDIT CARDS

    "/credit_cards"(platform: "/mobile", type: TrackType.View) {
        available_cards()
        context()
    }

    "/credit_cards/abort"(platform: "/mobile", type: TrackType.Event) {
        available_cards(required: false)
    }

    "/credit_cards/back"(platform: "/mobile", type: TrackType.Event) {
        available_cards(required: false)
    }

    "/credit_cards/new_card"(platform: "/mobile", type: TrackType.View) {
        available_cards(required: false)
        payment_method_id()
    }

    "/credit_cards/new_card/apply"(platform: "/mobile", type: TrackType.Event) {
        available_cards(required: false)
        card_number()
    }

    "/credit_cards/new_card/back"(platform: "/mobile", type: TrackType.Event) {}

    "/credit_cards/new_card/installments"(platform: "/mobile", type: TrackType.View) {
        available_cards(required: false)
        available_installments()
        payment_method_id(required: false)
    }

    "/credit_cards/new_card/installments/apply"(platform: "/mobile", type: TrackType.Event) {
        available_cards(required: false)
        installment()
    }

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

    // PAYMENTS FLOW

    "/payments"(platform: "/mobile", type: TrackType.View) {
        context()
        item_id()
    }

    "/payments/back"(platform: "/mobile", type: TrackType.Event) {}

    // SELLER

    "/seller_reputation"(platform: "/mobile") {
        context()
        item_id(required: false)
    }

    "/seller_reputation/back"(platform: "/mobile") {}

    "/seller_reputation/ratings"(platform: "/mobile") {}

    "/seller_reputation/ratings/back"(platform: "/mobile") {}

    "/traffic"(platform: "/", isAbstract: true) {}

    "/traffic/inbound"(platform: "/", isAbstract: true) {}

    "/traffic/inbound/matt"(platform: "/") {
        tool(type: PropertyType.Numeric, description: "Referrer's ID, this could identify Google, Facebook or any other channel")
        word(type: PropertyType.String, description: "This is the name of the marketing campaign.")
        go(required: false, type: PropertyType.String, description: "Destination URL of the marketing campaign.")
    }

    /**
     * DEVICES
     */

    "/devices_settings"(platform:"/mobile", isAbstract:true) {}

    //Bloqueo de notificaciones (Android > = API 19)
    "/devices_settings/notifications"(platform:"/mobile", type:TrackType.Event) {
        enable(required:true, type:PropertyType.Boolean)
        registration_id(required:true, type:PropertyType.String)
        device_id(required:true, type:PropertyType.String)
    }


    /**
    * NOTIFICATIONS
    */

    /**
    * NOTIFICATIONS CENTER
    */
    "/notification_center"(platform: "/mobile", type: TrackType.Event) {
        newsgroup_id(required: false, type: PropertyType.String)
        status(required: false, type: PropertyType.String, values:["unread", "read"])
        event_type(required: false, values: ["open", "pull_to_refresh", "swipe"])
        deeplink(required: false, type: PropertyType.String)
        action_type(required: false, type: PropertyType.String,  values: ["messages", "message", "vop", "picture", "shipping_print_label", "claims", "tracking", "feedback", "changepayment", "reply", "ask", "questions-buy"])
        type_layout(required: false, type: PropertyType.String, values: ["bullet_list", "order", "picture", "standard"])
    }

    "/notification_center/abort"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/back"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/failure"(platform: "/mobile", type: TrackType.Event) {}

    "/notification_center/questions-buyer"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/questions-seller"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/orders-buyer"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/orders-seller"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/security-enrollment-legacy"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/mediations-complainant-legacy"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/purchase-pending-legacy"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/loyalty"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/listings"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/campaigns-deals"(platform: "/mobile", type: TrackType.Event) {
        campaign_id(required: false, type: PropertyType.String, description: "Id of the campaign related to the mkt notification sent.")
        deal_id(required: false, description: "Id of the deal related to the mkt notification sent.")
    }
    "/notification_center/campaigns-campaigns"(platform: "/mobile", type: TrackType.Event) {
        campaign_id(required: false, description: "Id of the campaign related to the campaigns notification sent.")
    }

    "/notification_center/campaigns-suggested_discounts_buyer"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/campaigns-suggested_discounts_seller"(platform: "/mobile", type: TrackType.Event) {}
    "/notification_center/fraud-identity_validation"(platform: "/mobile", type: TrackType.Event) {}

    /**
     * NOTIFICATIONS TRAY
     **/
    "/notification"(platform: "/mobile") {
        event_type(required: true,
                values: ["sent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown", "action_open", "control", "carousel"],
        description: "Type of notification event")
        action_type(required: false,
                values: ["deeplinking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer", "action_carousel"])
        deeplink(required: false, description: "The link were the notification should navigate to, if applies")

        //For event_type:autodismiss, indicates why the notification was dismissed
        source(required: false,
               values: ["notification_center","logout","overwrite"])

        news_id(required: false, description: "Identifier of the notification generated")
        notification_style(required: false, description: "The notification style used when displaying the notification to the user.")

        status(required: false, values: ["read", "unread"], deprecated: true, description: "*Deprecated*: Just for old NotifCenter.")
    }
    //Tu producto está en camino
    "/notification/shipping_shipped"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order of the bought item which has been shipped")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Retiro en sucursal
    "/notification/shipping_agency_withdrawal"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
        agency_to_agency(required:false, type:PropertyType.Boolean, description: "Indicates if package was sent to an agency in the first place or was shipped there because the user wasnt found in his address")
    }
    //Devolución de costo de envío por demora
    "/notification/shipping_delayed_bonus"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Tienes que despachar (para el vendedor)
    "/notification/shipping_pending"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Devolución por no entrega, a su dirección de despacho (para el vendedor)
    "/notification/shipping_returning_to_sender"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Te demoraste en el handling time (para el vendedor)
    "/notification/shipping_delayed_sender"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Tu paquete está demorado (para el comprador)
    "/notification/shipping_delayed_receiver"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
        delay_reason(required: true, type: PropertyType.String, description: "shipping_time or handling_time")
    }
    //Hubo un problema con tu paquete y te vamos a pagar (para el vendedor)
    "/notification/shipping_not_delivered_sender"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }
    //Hubo un problema con el envío (para el comprador)
    "/notification/shipping_not_delivered_receiver"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }

    //Paquete entregado
    "/notification/shipping_delivered"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the product that is available to withdrawal")
        shipment_id(required: true, type: PropertyType.Numeric)
    }

    //Seller questions
    "/notification/questions_new"(platform: "/mobile") {
        question_id(required: true)
    }
    //Buyer questions
    "/notification/questions_answered"(platform: "/mobile") {
        question_id(required: true, type: PropertyType.Numeric)
    }
    //New Sale
    "/notification/orders_new"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String)
    }

    //Generic Campaigns
    "/notification/campaigns_campaigns"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
    }

    //MKT Deals
    "/notification/campaigns_deals"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the mkt notification sent.")
        deal_id(required: true, description: "Id of the deal related to the mkt notification sent.")
    }

    //Freemium SYI
    "/notification/campaigns_syi_freemium"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the SYI Freemium notification sent.")
    }
    //Tu cobro fué acreditado
    "/notification/collections_approved"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String)
    }

    //Dropout de CHO
    "/notification/purchase_pending"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }
    "/notification/orders_pending"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }

    //Mediations
    "/notification/mediations_complainant"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the claim")
        claim_id(required: true, type: PropertyType.String)
    }

    //Moderation
    "/notification/moderations_item_to_patch"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }

    "/notification/moderations_item_forbidden"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }

    "/notification/moderations_item_warning"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }

    "/notification/moderations_message_banned"(platform: "/mobile") {
    }

    //Carousel
    "/notification/carousel"(platform: "/mobile") {
        action_carousel(required: true, values: ["next", "prev"])
    }

    //Payments
    "/notification/payments_pending_reminder"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
        order_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/payments_approved"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
        order_id(required: true, type: PropertyType.Numeric)
    }

    "/notification/payments_rejected"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
        order_id(required: true, type: PropertyType.Numeric)
    }

    //Deprecated - typo
    "/notification/payments_pending_remainder"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
        order_id(required: true, type: PropertyType.Numeric)
    }

    //Messages
    "/notification/messages_new"(platform: "/mobile") {}

    //Notification suggested discounts
    "/notification/campaigns_suggested_discounts_seller"(platform: "/mobile") {}
    "/notification/campaigns_suggested_discounts_buyer"(platform: "/mobile") {}

    //Fraud
    "/notification/fraud_identity_validation"(platform: "/mobile") {}

    //Loyalty
    "/notification/loyalty_welcome"(platform: "/mobile") {}
    "/notification/loyalty_milestone"(platform: "/mobile") {}
    "/notification/loyalty_change_level"(platform: "/mobile") {}

    //Reviews
    "/notification/reviews_reminder"(platform: "/mobile") {}

    //Security
    "/notification/security_enrollment"(platform: "/mobile") {}

    /**
     * END NOTIFICATIONS
     **/

    "/landing"(platform: "/mobile", isAbstract: true) {}

    "/landing/generic"(platform: "/mobile") {
        url(required:true, descripcion:"The url to be loaded by the generic landing")
        is_main_url(required:false, type: PropertyType.Boolean, 
            descripcion: "True if the url is the first url to be loaded. Next urls will have this flag in false (redirects, taps)")
    }
    
    "/orders"(platform: "/", isAbstract: true) {}

    "/orders/ordercreated"(platform: "/") {
        order_id(required: true, description: "order identifier")
        status(required: true, description: "status of this order at creation")
        status_detail(required: false, description: "status description")
        total_amount(required: true, description: "order amount, does not include shipping or interests")
        total_amount_with_shipping(required: false, description: "order amount including shipping cost")
        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
            //id
            //title
            //selle_custom_fields
            //variation_attributes
            //category_id
            //variation_id
        //quantity
        //unit_price
        //currency_id
        //sale_fee

        shipping(required: false)
        //id
        //cost
        //shipping_mode
        //shipping_option
        //id
        //name
        //shipping_method_id

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method
        // payment_type
        // paid_amount
        // installments
        // without_fee
        // status
        // status_detail

        buyer(required: true, description: "buyer information") // id, nickname
        seller(required: true, type:PropertyType.ArrayList, description: "Array of sellers with their data") // id, nickname
        is_carrito(required: true, description: "Whetever this order was created by a carrito or not ")
    }

    "/email"(platform: "/email", isAbstract: true) {
        email_template(required: true)
        event_type(required: true,
                values: ["send", "open", "cancel"],
                description: "Type of email event")
        email_id(required: false)
        subject(required: false)
        sent_date(required: false)
    }

    "/email/orders"(platform: "/email") {
        order_id(required: true)
        order_date_created(required: true)
        order_status(required: true)
        seller_id(required: true)
        is_risk_user(required: false)
        total_amount(required: true)
    }

    "/email/generic"(platform: "/email"){}

    "/email/question"(platform: "/email"){}

    "/email/checkout"(platform: "/email"){}

    "/email/reputation"(platform: "/email"){}

    "/email/access"(platform: "/email"){}

    "/email/sale"(platform: "/email"){}

    "/email/mediation"(platform: "/email"){}

    "/email/auction_end"(platform: "/email"){}

    "/email/withdrawal"(platform: "/email"){}

    "/email/fup_feedback"(platform: "/email"){}

    "/email/message"(platform: "/email"){}


    "/official_stores"(platform: "/web", isAbstract: true) {}

    "/official_stores/home"(platform: "/web", type: TrackType.View) {
        from(required: false,  description: "Who is redirecting")
    }
    "/official_stores/landing"(platform: "/web", type: TrackType.View) {
        is_tool_tip_present(type: PropertyType.Boolean, required: false,  description: "Is true only if the tooltip si displayed")
        exit_to_store(type: PropertyType.Boolean, required: false,  description: "Is true only if you continue searching in a OS")
    }
    "/official_stores/checkon"(platform: "/web", type: TrackType.View) {
        is_tool_tip_present(type: PropertyType.Boolean, required: false,  description: "Is true only if the tooltip si displayed")
        uncheck(type: PropertyType.Boolean, required: false,  description: "Is true only if the check is Unchecked")
    }
    "/official_stores/fewItemsPage"(platform: "/web", type: TrackType.View) {
        store(required: false,  description: "Store in the search")
        query(required: false,  description: "Query item looking for")
    }
    "/official_stores/zrp"(platform: "/web", type: TrackType.View) {
        in_store(type: PropertyType.Boolean, required: false,  description: "If the zrp is rendered, and experiment redirects inside the sotre or outside")
        use_link(type: PropertyType.Boolean, required: false,  description: "Is true if the zrp message link is used.")
        check_on_exp(type: PropertyType.Boolean, required: false,  description: "Is true if the checkon experiment mantains the checkon")
        checked(type: PropertyType.Boolean, required: false,  description: "Is true only if the checkon is checked")
        exit_to_store(type: PropertyType.Boolean, required: false,  description: "Is true only if you continue searching in a OS")
    }

    /**
     * OFFICIAL STORES LISTING
     **/
    "/official_stores/"(platform: "/mobile", isAbstract: true) {}

    "/official_stores/search/"(platform: "/mobile", type: TrackType.View) {}

    "/official_stores/search/open"(platform: "/mobile", type: TrackType.Event) {
        query(required: true, description: "Official store name written in search box")
        official_store_id(required: true, description: "Official store id")
        official_store_name(required: true, description: "Official store id")
    }

    "/official_stores/search/abort"(platform: "/mobile", type: TrackType.Event) {
        query(required: false, description: "Official store name written in search box")
    }

    "/official_stores/search/back"(platform: "/mobile", type: TrackType.Event) {
        query(required: false, description: "Official store name written in search box")
    }

    //Breadcrumb
    "/home/category"(platform: "/", type: TrackType.View) {
        from(required: false,  description: "Who is redirecting")
        category_id(required: true,  description: "Home's category")
    }

    "/home"(platform: "/web", type: TrackType.View) {
        from(required: false,  description: "Who is redirecting")
    }

    "/permissions"(platform: "/mobile", isAbstract: true){}
    "/permissions/location"(platform: "/mobile", type: TrackType.View){
        context(required: "true", description: "Where are we requesting the permissions")
    }
    "/permissions/location/custom"(platform: "/mobile", isAbstract: true){}
    "/permissions/location/custom/accept"(platform: "/mobile", type: TrackType.Event){}
    "/permissions/location/custom/deny"(platform: "/mobile", type: TrackType.Event){}
    "/permissions/location/native"(platform: "/mobile", isAbstract: true){}
    "/permissions/location/native/accept"(platform: "/mobile", type: TrackType.Event){}
    "/permissions/location/native/deny"(platform: "/mobile", type: TrackType.Event){}

    // Real estate page view
    "/home/category/real-estate"(platform: "/", type: TrackType.View) {
        filters(required: false, description: "Filter applied in the last search")
        carousels(required: false, description: "Carousels in the home page to the properties")
    }

    // Sell
    "/sell"(platform: "/", isAbstract: true) {}
    "/sell/list"(platform: "/", isAbstract: true){ }
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
    }

    "/sell/modify_and_relist/single/row"(platform: "/web", type: TrackType.View){}
    "/sell/modify_and_relist/single/cards"(platform: "/web", type: TrackType.View){}

    "/sell/modify_and_relist/massive"(platform: "/web", isAbstract: true){
        items_amount(required: true, description: "Amount of items affected")
    }
    "/sell/modify_and_relist/massive/row"(platform: "/web", type: TrackType.View){}

    // Tambien se utiliza para Apps
    "/sell/list/congrats"(platform: "/", type: TrackType.View){
        item_id(required: false, description: "Item id")
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
    }
    // Upgrade Off = El upgrade de clasificados
    "/sell/upgradeOff"(platform:"/", type: TrackType.View){
        item_id(required: true, description: "Item id")
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        referer(required:false , description: "Referer link from where the request came")
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
    "/sell/list/drafts"(platform: "/", type: TrackType.View) {}
    "/sell/list/hub"(platform: "/", type: TrackType.View) {}
    "/sell/list/walkthrough"(platform: "/", type: TrackType.View) {}
    "/sell/list/hub_old"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip"(platform: "/", type: TrackType.View) {}
    "/sell/list/category_sugestion"(platform: "/", type: TrackType.View) {}
    "/sell/list/category_navigation"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/condition"(platform: "/", type: TrackType.View) {}
    "/sell/list/condition_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/description"(platform: "/", type: TrackType.View) {}
    "/sell/list/description_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/payment_methods"(platform: "/", type: TrackType.View) {}
    "/sell/list/payment_methods_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/gallery"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/editor"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/crop"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/gallery"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/editor"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/crop"(platform: "/", type: TrackType.View) {}
    "/sell/list/price_core"(platform: "/", type: TrackType.View) {}
    "/sell/list/price_core/similar_products"(platform: "/", type: TrackType.View) {}
    "/sell/list/price_core_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/price_core_review/similar_products"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration_zip_code"(platform: "/", type: TrackType.View) {}
    "/sell/list/size_selection"(platform: "/", type: TrackType.View) {}
    "/sell/list/size_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/title_core"(platform: "/", type: TrackType.View) {}
    "/sell/list/title_core_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_options_me"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_options_me_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/registration_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/registration_zip_code_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_price_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_shipping_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_condition_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_condition_lt_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_condition_listing_type_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/title_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update"(platform: "/", isAbstract: true) {}
    "/sell/update/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/update/listing_types_upgrade"(platform: "/", type: TrackType.View) {}
    "/sell/update/congrats_upgrade"(platform: "/", type: TrackType.View) {}

    // Eventos relacionados al item
    "/item"(platform: "/", isAbstract: true) {
        item_id(required: true, description: "Item id")
    }

    "/item/create"(platform: "/", type: TrackType.Event) {
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: true, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: true, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: true, description: "Item condition: used/new/not_specified")
        price(required: true, description: "Item price")
        category_id(required: true, description: "Item category_id")

        // Category sugestion
        suggested_category_id(required: false, description: "Category id suggested")
        suggested_category_is_leaf(required: false, type: PropertyType.Boolean, description: "The category suggested is leaf")
    }

    "/item/change_listing_type"(platform: "/", type: TrackType.Event) {
        from(required: true, description: "Previous Listing type")
        to(required: true, description: "New Listing type")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        source(required: false, description: "upgrade flow that was used to change the listing type")
    }


    "/item/relist"(platform: "/", type: TrackType.Event) {
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: true, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: true, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: true, description: "Item condition: used/new/not_specified")
        price(required: true, description: "Item price")
        parent_id(required: false, description: "Parent item listing type id")
        parent_listing_type_id(required: false, description: "Parent item listing type id")
        change_listing_type(required: false, description: "If the listing type changed compare to its parent. Values: upgrade/no_change/downgrade")
        source(required: false, description: "Relist flow that was used to relist the item")
    }

    // Myml
    "/myml"(platform: "/", isAbstract: true) {}
    "/myml/listings"(platform: "/web", type: TrackType.View) {
        label(required: true, description: "Selected label: active/closed/paused/...")
    }

    "/myml/bookmarks"(platform: "/web", type: TrackType.View) {}
    "/myml/questions"(platform: "/web", type: TrackType.View) {}

    "/myml/summary"(platform: "/web", type: TrackType.View) {}

    // Myml - Suggested Discounts
    "/myml/suggested_discounts"(platform: "/mobile", isAbstract: true){
        item_id(required: false, description: "Item id")
        item_original_price(required: false, description: "Item price")
        item_title(required: false, description: "Item title")
    }
    "/myml/suggested_discounts/landing"(platform: "/mobile", type: TrackType.View) {}
    "/myml/suggested_discounts/landing/about"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/landing/start"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/landing/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/landing/abandon"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/about"(platform: "/mobile", type: TrackType.View) {
        onboarding_step(required: false, description: "Onboarding step number")
    }
    "/myml/suggested_discounts/about/skip"(platform: "/mobile", type: TrackType.Event) {
        onboarding_step(required: false, description: "Onboarding step number")
    }
    "/myml/suggested_discounts/about/start"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/about/abandon"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/about/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/select_discount"(platform: "/mobile", type: TrackType.View) {}
    "/myml/suggested_discounts/select_discount/apply"(platform: "/mobile", type: TrackType.Event) {
        selected_discount(required: true, description: "Selected discount option")
    }
    "/myml/suggested_discounts/review_discount"(platform: "/mobile", type: TrackType.View) {}
    "/myml/suggested_discounts/review_discount/confirm"(platform: "/mobile", type: TrackType.Event) {
        selected_discount(required: true, description: "Selected discount option")
    }
    "/myml/suggested_discounts/select_discount/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/review_discount/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/info"(platform: "/mobile", type: TrackType.View) {
        discount_status(required: false, description: "Current deal status")
      }
    "/myml/suggested_discounts/info/exit"(platform: "/mobile", type: TrackType.Event) {
        action(required: true, description: "Selected exit action")
    }
    "/myml/suggested_discounts/info/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/error"(platform: "/mobile", type: TrackType.View) {}
    "/myml/suggested_discounts/error/back"(platform: "/mobile", type: TrackType.Event) {}

    "/myml/account_balance"(platform: "/mobile", type: TrackType.View) {}
    "/myml/account_balance/withdraw"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: true, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/send_money"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: true, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/cellphone_recharge"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: true, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/bill_payments"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: true, type:  PropertyType.Boolean, description: "true if MP is installed")
    }

    "/myml/account_balance/install"(platform: "/mobile", type: TrackType.View) {}
    "/myml/account_balance/install/go_to_store"(platform: "/mobile", type: TrackType.Event) {}

    "/myml/sales"(platform: "/mobile", isAbstract: true) {}
    "/myml/sales/detail"(platform: "/mobile", isAbstract: true) {}
    "/myml/sales/detail/flow_selector"(platform: "/mobile", type: TrackType.View) {
        flow_selected(required: true, type: PropertyType.String, description: "use case selected based on incoming parameters")
    }
    "/myml/sales/detail/deliver_product"(platform: "/mobile", type: TrackType.View) {}
    "/myml/sales/detail/deliver_product#submit"(platform: "/mobile", type: TrackType.Event) {
        action_label(required: true, type: PropertyType.String, description: "action selected when submitting: send_feedback or update shipping")
    }
    "/myml/sales/detail/date_will_receive_product"(platform: "/mobile", type: TrackType.View) {}
    "/myml/sales/detail/deliver_product/action"(platform: "/mobile", type: TrackType.Event) {
        action_label(required:true, type: PropertyType.String, description: "action performed, post feedback or update shipping")
        order_id(required: true, type: PropertyType.String)
        shipping_id(required: false, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean, description: "true if the action was successful")
    }
    "/myml/sales/detail/send_feedback"(platform: "/mobile", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean)
    }

    "/download-app"(platform: "/web") {}
    "/download-app/send"(platform: "/web", type: TrackType.Event) {
        user_phone_number()
        final_phone_number()
    }
    "/download-app/send/success"(platform: "/web", type: TrackType.Event) {
        user_phone_number()
        final_phone_number()
    }
    "/download-app/send/error"(platform: "/web", type: TrackType.Event) {
        user_phone_number()
        final_phone_number()
        error_type()
    }

    //Loyalty

    "/loyalty"(platform: "/", isAbstract: true) {
        level(type: PropertyType.Numeric, required: false)
        points(type: PropertyType.Numeric, required: false)
        percentage(type: PropertyType.Numeric, required: false)
    }

    "/loyalty/score"(type: TrackType.View) {}

    "/loyalty/score/milestones"(type: TrackType.View) {} //Milestones tab
    "/loyalty/score/benefits"(type: TrackType.View) {} //Benefits tab
    "/loyalty/score/achievements"(type: TrackType.View) {} //Achievements tab


    "/loyalty/notification"(type: TrackType.Event) {
        event_type(required: true,
                values: ["received", "dismiss", "open", "shown", "delayed"],
                description: "Type of loyalty notification event")
    }

    //Navigation
    "/navigation"(platform: "/mobile/android") {
        origin(required: true, type: PropertyType.String, description: "Analytic's name of the screen where the menu was opened")
    }

    //Logout
    "/logout"(platform: "/", isAbstract: true) {}
    "/logout/modal"(platform: "/mobile") {
        action(required: true, type:PropertyType.String, description: "Indicates whether the logout action was either confirmed or canceled")
    }

    //Loyalty Program User Tracking
    "/loyalty/user"(platform: "/", type: TrackType.Event) {
        in_loyalty_program(
            required: true,
            type:PropertyType.Boolean,
            description: "Indicates if the user is in or out of the loyalty program"
        )
    }
    //Feedback
    "/feedback"(platform: "/", isAbstract: true) {}

    "/feedback/congrats"(platform: "/") {}

    //Quotation
    "/quotation"(platform: "/", isAbstract: true) {}

    //Quotation :: Details
    "/quotation/details"(platform: "/") {
        item_id(required: true, type:PropertyType.String,description: "Item id")
    }

    "/quotation/details"(platform: "/web") {
        category_id(required: true, type:PropertyType.String, description: "Item category id")
        seller_id(required: true, type:PropertyType.Numeric)
        listing_type_id(required: true, type:PropertyType.String, description: "Item listing type id")
        item_status(required: true, type:PropertyType.String, description: "Item status")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
    }

    "/quotation/details"(platform: "/mobile") {
        model_id(required: false, type:PropertyType.String, description: "Model id")
    }

    //Quotation :: Gallery
    "/quotation/gallery"(platform: "/mobile") { }

    // Quotation :: Models
    "/quotation/models"(platform: "/mobile") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        model_id(required: false, type:PropertyType.String, description: "Model id")
    }

    //Quotation :: Units
    "/quotation/units"(platform: "/mobile") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        unit_id(required: false, type:PropertyType.String, description: "Unit id")
    }

    //Quotation :: Disclaimer
    "/quotation/disclaimer"(platform: "/mobile") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
    }

    //Quotation :: Quote intention
    "/quotation/quote_intention"(platform: "/mobile", type: TrackType.Event) {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        model_id(required: true, type:PropertyType.String, description: "Model id")
        unit_id(required: true, type:PropertyType.String, description: "Unit id")
    }

    //Quotation :: Congrats
    "/quotation/congrats"(platform: "/") {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        unit_id(required: true, type:PropertyType.String, description: "Unit id")
    }

    "/quotation/congrats"(platform: "/web") {
        category_id(required: true, type:PropertyType.String, description: "Item category id")
        seller_id(required: true, type:PropertyType.Numeric)
        listing_type_id(required: true, type:PropertyType.String, description: "Item listing type id")
        item_status(required: true, type:PropertyType.String, description: "Item status")
        vertical(required: false, type:PropertyType.String, description: "Item Vertical: SERVICE/MOTOR/REAL_ESTATE/etc...")
        error_type(required: false, type:PropertyType.String)
        model_id(required: true, type:PropertyType.Numeric )
    }
    
   //Recommendations => Should be embebed in host tracks, except for client-side clientes ( i.e. /vip ) 
   "/recommendations"(platform: "/") {

    }

}
