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

    //Bookmark and question tracking from feeds for Emkt
    "/bookmarks/action/post" (platform: "/web", type: TrackType.Event) {
        item_id()
        context()
        action_location(required:false, type: PropertyType.String)
    }

    "/questions/ask/post" (platform: "/web", type: TrackType.Event) {
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

    "/questions/ask/post"(platform: "/", type: TrackType.Event) {
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


    //Navigation
    "/navigation"(platform: "/mobile/android") {
        origin(required: true, type: PropertyType.String, description: "Analytic's name of the screen where the menu was opened")
    }

    //Logout
    "/logout"(platform: "/", isAbstract: true) {}
    "/logout/modal"(platform: "/mobile") {
        action(required: true, type:PropertyType.String, description: "Indicates whether the logout action was either confirmed or canceled")
    }


    //Feedback
    "/feedback"(platform: "/", isAbstract: true) {}

    "/feedback/congrats"(platform: "/") {}


   //Recommendations => Should be embebed in host tracks, except for client-side clientes ( i.e. /vip )
   "/recommendations"(platform: "/") {

    }

    "/application"(platform:"/mobile", isAbstract: true) {}
    "/application/open"(platform:"/mobile", type: TrackType.Event) { }
    "/application/install_event" (platform: "/mobile", type: TrackType.Event){
        deeplink (required: false, type: PropertyType.String)
        exception (required: false, type: PropertyType.String)
    }

    //Landings Deals

    "/deals"(platform: "/", isAbstract: true) {}

    "/deals/landing"(platform: "/") {
        deal_id(required: false, type: PropertyType.String)
    }

    // Subscriptions
    "/subscriptions"(platform: "/", isAbstract: true) {}

    "/subscriptions/frequency"(platform: "/", type: TrackType.View) {}
    "/subscriptions/change_frequency"(platform: "/", type: TrackType.Event) {
        frequency(required: true, type: PropertyType.String)
        frequency_before(type: PropertyType.String)
        context(required: true, type: PropertyType.String)
    }

    "/subscriptions/review"(platform: "/", type: TrackType.View) {}
    "/subscriptions/review/confirm"(platform: "/", type: TrackType.Event) {
        context(required: true, type: PropertyType.String)
    }

    "/subscriptions/congrats"(platform: "/", type: TrackType.View) {}
    "/subscriptions/congrats/view_subscription"(platform: "/", type: TrackType.Event) {}

    "/subscriptions/summary"(platform: "/", type: TrackType.View) {}
    "/subscriptions/detail"(platform: "/", type: TrackType.View) {}

    "/subscriptions/detail/cancel"(platform: "/", isAbstract: true) {}
    "/subscriptions/detail/cancel/now"(platform: "/", type: TrackType.Event) {}
    "/subscriptions/detail/cancel/skip"(platform: "/", type: TrackType.Event) {}
    "/subscriptions/detail/cancel/subscription"(platform: "/", type: TrackType.Event) {}
    
    "/sso" (platform: "/mobile", isAbstract: true){}
    "/sso/login_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/logout_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/attempt_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/attempt_error" (platform: "/mobile", type: TrackType.Event){}

    "/cx" (platform: "/mobile", isAbstract: true){}
    "/cx/click_on_article" (platform: "/mobile", type: TrackType.Event){
        article_id(required: true, type: PropertyType.String)
    }
    "/cx/click_on_help" (platform: "/mobile", type: TrackType.Event){}
    "/cx/click_on_error" (platform: "/mobile", type: TrackType.Event){}
    "/cx/click_on_suggestion" (platform: "/mobile", type: TrackType.Event){}
    "/cx/contact_types" (platform: "/mobile", isAbstract: true){}
    "/cx/contact_types/click_on_contact_form" (platform: "/mobile", type: TrackType.Event){}
}
