
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

    "/melidata"(platform: "/mobile", isAbstract: true) {}

    "/melidata/statistics"(platform: "/mobile", type: TrackType.Event) {
        errors_counter(type: PropertyType.Map)
        last_send_timestamp()
        total_pending_tracks()
        send_counter()
        database_size()
        tracks_counter()
        average_ok_time()
        average_error_time()
        last_statistics_timestamp(required: false)
    }

    "/melidata/null_track"(platform: "/mobile") {
        context()
    }

    "/melidata/delete_old_tracks"(platform: "/mobile") {
        count()
    }

    "/melidata/shrink_database"(platform: "/mobile", isAbstract: true) {
        delete_records( type: PropertyType.Numeric, description: "Number of records/tracks deleted when shrinking")
        previous_size (type: PropertyType.Numeric, description: "Size of database before shrinking in bytes")
        current_size (type: PropertyType.Numeric , description: "Size of database after shrinking in bytes")
    }

    "/melidata/shrink_database"(platform: "/mobile/android", type: TrackType.Control ) {}
    "/melidata/shrink_database"(platform: "/mobile/ios", type: TrackType.Event ) {}

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

    "/home/failure"(platform: "/mobile") {
        error_message(required: false)
    }

    "/home/back"(platform: "/mobile") {
    }

    "/home/pulltorefresh"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/pulltorefresh/abort"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll"(platform: "/mobile", type: TrackType.Event) {
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
        billboard_shown(required: false, PropertyType.Boolean)
    }

    "/search"(platform: "/web") {
        visual_id(required: false)
        config_version(required: false)
        filters(required: false)
        only_in_type(required: false)
        click_banner(required: false, description:'Indicates that this listing has apppeared after clicking on a banner')
        // exhibitors_id
        banners(required: false, description:'Banner showed in this listing info, if showed')
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

    //VIP FLOW

    "/vip"(platform: "/") {
        item_id(required: true, description: "Item ID")
        category_id(required: true, description: "Item's category id")
        deal_ids(required: false, description: "IDs of applied discounts")
        buying_mode(required: false, description: "Indicates if it's an aution, buy_it_now or classified")
        official_store_id(required: false, description: "Id of item's official store")
        vertical(deprecated: true, required: false)
        quantity(deprecated: true, required: false)
        item_condition(deprecated: true, required: false)
        currency_id(deprecated: true, required: false)
        price(deprecated: true, required: false)
        item_status(deprecated: true, required: false)
        seller_id(deprecated: true, required: false)
        power_seller_status(deprecated: true, required: false)
        listing_type_id(deprecated: true, required: false)
        start_time(deprecated: true, required: false)
        stop_time(deprecated: true, required: false)
        shipping_mode(deprecated: true, required: false)
        free_shipping(deprecated: true, required: false)
        local_pick_up(deprecated: true, required: false)
        category_path(deprecated: true, required: false)
        promoted_items_clicked(required: false, descripcion: 'indicates whether clicked promoted items before reaching this vip')
        billboard_clicked_position(required:false, type: PropertyType.Numeric)
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
    }

    "/bookmarks/action/delete"(platform: "/mobile", type: TrackType.Event) {
        item_id()
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
        order_items()
        //item
        //id
        //variation_id
        //buying_mode
        //category_id
        //deal_ids
        //quantity
        //unit_price
        //currency_id
        platform()

        buyer()
        //id
        //nickname
        seller()
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

        order_items( description: "Array of items in the order" )
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

        order_items( description: "Array of items in the order" )
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

        seller(required: false)
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

        order_items( description: "Array of items in the order" )
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

        seller(required: true)
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

        order_items(required: false, description: "Array of items in the order" )
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

        seller(required: false)
        //id
        //nickname
        //View specific data
        success(required: true, type: PropertyType.Boolean)
        location(required: false, type: PropertyType.String)
        geolocation_method(required: false, type: PropertyType.String)
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

        order_items(required: true, description: "Array of items in the order" )
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

        seller(required: true)
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
    "/checkout/shipping/location/address"(platform:"/mobile") {
        //View specific data
        edit_flow(required: true, type: PropertyType.Boolean)
    }
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

        order_items(required: true, description: "Array of items in the order" )
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

        seller(required: true)
        //id
        //nickname
    }
    "/checkout/payments/select_method"(platform:"/mobile") {
        //List of available payment_methods and coupon info
        available_methods(required: true, type: PropertyType.ArrayList)
        coupon(required: false, type:  PropertyType.Boolean)
        coupon_discoun(required: false, type:  PropertyType.Numeric)
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
    "/checkout/payments/pay_point"(platform:"/mobile", isAbstract: true) {}
    "/checkout/payments/pay_point/select_store"(platform:"/mobile") {
         available_methods(required: true, type: PropertyType.ArrayList)
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

        order_items(required: true, description: "Array of items in the order" )
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

        seller(required: true)
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

        order_items(required: false, description: "Array of items in the order" )
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

        seller(required: false)
        //id
        //nickname

        /****************************************/
        //Legacy App Congrats Tracks
        duplicated_error(required: false)
        congrats_seq(serverSide: true)
        total_amount_local(serverSide: true)
        total_amount_usd(serverSide: true)
        first_for_order(serverSide: true)
    }
    "/checkout/congrats/error"(platform: "/mobile") {
        available_actions(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/congrats/call_for_auth"(platform: "/mobile") {
        available_actions(required: true, type: PropertyType.ArrayList)
    }
    "/checkout/congrats/call_for_auth/instructions"(platform: "/mobile") {
        available_actions(required: false, type: PropertyType.ArrayList)
    }
    "/checkout/congrats/call_for_auth/later"(platform: "/mobile") {
        available_actions(required: false, type: PropertyType.ArrayList)
    }
    "/checkout/congrats/invalid_sec_code"(platform: "/mobile") {
        available_actions(required: true, type: PropertyType.ArrayList)
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

        order_items(required: false, description: "Array of items in the order" )
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

        seller(required: false)
        //id
        //nickname
        error_code(required: true, type: PropertyType.String)
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

    // REGISTER

    "/register"(platform: "/mobile", isAbstract: true) {}

    "/register/success"(platform: "/") {
        source()
    }

    "/register/failure"(platform: "/mobile") {
        source()
    }

    "/register/facebook_permissions"(platform: "/mobile"){
        login_status(type: PropertyType.String, description: "Success, Cancel, Error" )
        email(type: PropertyType.Boolean, description : " Needed  to access date (day and month) of the user birthday.")
        user_birthday(type: PropertyType.Boolean, description : " Needed  to access the user main email address.")
        user_likes(type: PropertyType.Boolean, description : " Needed  to access user liked pages.")
    }

    //REGISTER WEB

    "/register/form"(platform:"/web", type: TrackType.View) {
        app(type: PropertyType.String, description: "Registration app", required:true)
        source(type: PropertyType.String, description: "Source (on mobile is facebook/email, on web at the moment is only email)", required:true)
        item_id(type: PropertyType.String, description: "Item", required:false)
    }

    "/register/form/error"(platform:"/web", type: TrackType.View) {}

    "/register/success"(platform:"/web", type: TrackType.Event) {
        app(type: PropertyType.String, description: "Registration app", required:true)
        item_id(type: PropertyType.String, description: "Item", required:false)
    }

    "/traffic"(platform: "/", isAbstract: true) {}

    "/traffic/inbound"(platform: "/", isAbstract: true) {}

    "/traffic/inbound/matt"(platform: "/") {
        tool(type: PropertyType.Numeric, description: "Referrer's ID, this could identify Google, Facebook or any other channel")
        word(type: PropertyType.String, description: "This is the name of the marketing campaign.")
        go(required: false, type: PropertyType.String, description: "Destination URL of the marketing campaign.")
    }

    "/notification_center"(platform: "/mobile", type: TrackType.Event) {}

    "/notification_center/abort"(platform: "/mobile", type: TrackType.Event) {}

    "/notification_center/back"(platform: "/mobile", type: TrackType.Event) {}

    "/notification_center/failure"(platform: "/mobile", type: TrackType.Event) {}

    /**
     * NOTIFICATIONS
     * disclaimer: when the action_type is set, the event_type should be always 'open'
     **/
    "/notification"(platform: "/mobile") {
        news_id(required: false, description: "Identifier of the notification generated")
        event_type(required: true, values: ["sent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown", "swipe"], description: "Type of notification event")
        action_type(required: false, values: ["deeplinking", "directions", "favorite", "reply", "ask", "postpone"])
        deeplink(required: false, description: "The link were the notification should navigate to, if applies")
        status(required: false, values: ["read", "unread"], description: "The current notification status, used only when tracking from notification center.")
        notification_style(required: false, description: "The notification style used when displaying the notification to the user.")
        context(required: false, values: ["notification", "notification_center"], description: "Current context of the notification")
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
    //MKT Deals DEPRECADO
    "/notification/deals_campaigns"(platform: "/mobile") {
        deal_id(required: true, description: "Id of the deal related to the mkt notification sent.")
    }

    //MKT Deals
    "/notification/campaigns_deals"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the mkt notification sent.")
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
    //Loyalty
    "/notification/reputation_buyer_in"(platform: "/mobile") {}

    //Mediations
    "/notification/mediations_complainant"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.String, description: "The order related to the claim")
        claim_id(required: true, type: PropertyType.String)
    }

    //Moderation
    "/notification/moderation_item_to_patch"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }

    "/notification/moderation_item_forbidden"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }


    "/notification/moderation_item_warning"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }


    "/notification/moderation_message_banned"(platform: "/mobile") {
    }

    //Payments
    "/notification/payments_pending_remainder"(platform: "/mobile") {
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

    "/notification/orders_cancelled"(platform: "/mobile") {
        item_id(required: true, type: PropertyType.String)
    }

    //Messages
    "/notification/messages_new"(platform: "/mobile") {
    }

    "/orders"(platform: "/", isAbstract: true) {}

    "/orders/ordercreated"(platform: "/") {
        order_id(required: true, description: "order identifier")
        status(required: true, description: "status of this order at creation")
        status_detail(required: false, description: "status description")
        total_amount(required: true, description: "order amount, does not include shipping or interests")
        total_amount_with_shipping(required: false, description: "order amount including shipping cost")
        order_items(description: "Array of items in the order")
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
        seller(required: true, description: "seller information") // id, nickname
    }

    "/email"(platform: "/email", isAbstract: true) {}

    "/email/orders"(platform: "/email") {
        order_id(required: true)
        order_date_created(required: true)
        order_status(required: true)
        seller_id(required: true)
        is_risk_user(required: false)
        email_template(required: true)
        event_type(required: true)
        total_amount(required: true)
    }

    "/official_stores"(platform: "/web", isAbstract: true) {}

    "/official_stores/home"(platform: "/web", type: TrackType.View) {
        from(required: false,  description: "Who is redirecting")
    }
    "/official_stores/landing"(platform: "/web", type: TrackType.View) {
        is_tool_tip_present(type: PropertyType.Boolean, required: false,  description: "Is true only if the tooltip si displayed")
    }
    "/official_stores/checkon"(platform: "/web", type: TrackType.View) {
        is_tool_tip_present(type: PropertyType.Boolean, required: false,  description: "Is true only if the tooltip si displayed")
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

    "/download-app"(platform: "/web") {}
    "/download-app/send"(platform: "/web", type: TrackType.Event) {
        phone_number()
    }
    "/download-app/send/success"(platform: "/web", type: TrackType.Event) {
        phone_number()
    }
    "/download-app/send/error"(platform: "/web", type: TrackType.Event) {
        phone_number()
    }
}

