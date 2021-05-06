package catalog.melidata

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

    "/external/"(platform: "/mobile", initiative : "1127") {
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

    "/payments"(platform: "/mobile", type: TrackType.View, initiative: "1145") {
        context()
        item_id()
    }

    "/payments/back"(platform: "/mobile", type: TrackType.Event) {}

    // SELLER

    "/seller_reputation"(platform: "/mobile", initiative : "1029") {
        context()
        item_id(required: false)
    }

    "/seller_reputation/back"(platform: "/mobile") {}

    "/seller_reputation/ratings"(platform: "/mobile") {}

    "/seller_reputation/ratings/back"(platform: "/mobile") {}


    "/webkit" (platform: "/mobile", isAbstract: true, initiative: "1096"){}
    "/webkit/deeplink_open"(platform: "/mobile", isAbstract: true) {}

    "/webkit/deeplink_open/error"(platform: "/mobile", type:TrackType.Event) {
        url(required:true, type: PropertyType.String, descripcion:"The url opening the deeplink")
        deeplink(required: true, type: PropertyType.String, description: "the deeplink been opened")
    }

    // siguientes tracks no pertenecen a mobile-arquitectura, sino que es de otro team que trackea sobre /landing

    "/landing/brands"(platform: "/mobile", isAbstract: true, initiative : "1063"){}

    "/landing/brands/abort"(platform: "/mobile") {
        query(required:true, type: PropertyType.String, descripcion:"Query used in screen")
    }

    "/landing/brands/open"(platform: "/mobile") {
        query(required:true, type: PropertyType.String, descripcion:"Query used in screen")
        official_store_id(required:true, type: PropertyType.String, descripcion:"Oficial store id opened")
        official_store_name(required:true, type: PropertyType.String, descripcion:"Oficial store name opened")
    }

    "/download-app"(platform: "/web", initiative: "1144") {}
    "/download-app/send"(platform: "/web", type: TrackType.Event) {
        user_phone_number()
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
    "/logout"(platform: "/", isAbstract: true, initiative : "1127") {}
    "/logout/modal"(platform: "/mobile") {
        action(required: true, type:PropertyType.String, description: "Indicates whether the logout action was either confirmed or canceled")
    }

    //Feedback
    "/feedback"(platform: "/", isAbstract: true, initiative: "1110") {}

    "/feedback/congrats"(platform: "/") {}


    // Merchant Acquisition
    "/merchant_acquisition"(platform: "/", isAbstract: true, initiative: "1175" ) {}
    "/merchant_acquisition/qr"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/qr/landing"(platform:"/", isAbstract: true) {}
    "/merchant_acquisition/qr/landing/buyers"(platform:"/", type: TrackType.View) {}

}
