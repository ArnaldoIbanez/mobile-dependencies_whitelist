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
        sent_again(required: false, description: "This field is sent by mobile apps if a track is being re-sent. Probably due to a bad impl on native module. It shouldn't be present on event_data, in fact, we remove it on our consumers. But we catalog it, for desa catalogo validations, while we remove it")
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
        version(required:false, descripcion: "Version of generic landing")
        url(required:true, descripcion:"The url to be loaded by the generic landing")
        is_main_url(required:false, type: PropertyType.Boolean,
                descripcion: "True if the url is the first url to be loaded. Next urls will have this flag in false (redirects, taps)")
    }

    "/webkit" (platform: "/mobile", isAbstract: true){}

    "/webkit/deeplink_open"(platform: "/mobile", type:TrackType.Event) {
        url(required:true, type: PropertyType.String, descripcion:"The url opening the deeplink")
        deeplink(required: true, type: PropertyType.String, description: "the deeplink been opened")
        opened(required: true, type: PropertyType.Boolean, description: "flag indicating if the deeplink exists in app")
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


    // Merchant Acquisition
    "/merchant_acquisition"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/qr"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/qr/landing"(platform:"/", isAbstract: true) {}
    "/merchant_acquisition/qr/landing/buyers"(platform:"/", type: TrackType.View) {}

    // Payers Growth Landings
    "/payers_growth"(platform: "/", isAbstract: true) {}
    "/payers_growth/landings"(platform: "/") {
        product (type: PropertyType.String, required: true, description: "Product name, example: 'mkt-combustibles'")
    }
    
    //Landings Deals

    "/deals"(platform: "/", isAbstract: true) {}

    "/deals/landing"(platform: "/") {
        deal_id(required: false, type: PropertyType.String)
    }

    "/sso" (platform: "/mobile", isAbstract: true){}
    "/sso/login_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/logout_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/attempt_successful" (platform: "/mobile", type: TrackType.Event){}
    "/sso/attempt_error" (platform: "/mobile", type: TrackType.Event){}

    "/recommendations/print" (platform: "/"){}



}
