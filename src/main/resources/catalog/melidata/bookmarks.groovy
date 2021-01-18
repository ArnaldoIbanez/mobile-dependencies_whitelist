package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = "1171"


    "/bookmarks"(platform: "/", type: TrackType.Event, isAbstract: true) {
        item_id( required: false ,description: "Item id")
        context( required:false ,description: "The page or section where the bookmark action is taking place" , values: ["/search","/vip","/myml","/home", "/pdp"])
    }

    "/bookmarks/action"(platform: "/", isAbstract: true) {
        item_id( description: "item id in which we are performing the action")
        action_location(required:false ,type: PropertyType.String, description:"Where the action can be performed. Ej: navbar,maininfo ")
        context( required:true ,description: "The page or section where the bookmark action is taking place" , values: ["/search","/vip","/myml","/home", "/pdp", "/history"])
        catalog_product_id(required: false, description: "Id of the product", PropertyType.String)
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
    }

    "/bookmarks/action/post"(platform: "/", type: TrackType.Event) {
    }

    "/bookmarks/action/delete"(platform: "/", type: TrackType.Event) {
    }

    // TODO Borrar => Lo estamos standarizando hacía la definición de add_to_cart.groovy
    "/bookmarks/add_to_cart" (platform: "/", type: TrackType.Event) {}

    //Bookmark show
    "/bookmarks/show_bookmarks"(platform: "/", type: TrackType.Event) {}

    //Bookmark load more
    "/bookmarks/load_more"(platform: "/", type: TrackType.Event) {}

    //Bookmarks refresh view
    "/bookmarks/refresh"(platform: "/", type: TrackType.Event) {}

    //Bookmarks Server error view
    "/bookmarks/show_server_error"(platform: "/", type: TrackType.Event) {}

    //Bookmarks Retry
    "/bookmarks/retry_after_error"(platform: "/", type: TrackType.Event) {}

    //Bookmarks If doesn't have session show feedback
    "/bookmarks/show_not_logged_in_feedback"(platform: "/", type: TrackType.Event) {}

    //Bookmarks Go to Login
    "/bookmarks/go_to_login"(platform: "/", type: TrackType.Event) {}

    //Bookmarks show ZRP
    "/bookmarks/show_ZRP"(platform: "/", type: TrackType.Event) {}



}
