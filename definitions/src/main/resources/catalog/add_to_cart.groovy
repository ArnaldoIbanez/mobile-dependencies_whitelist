import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    propertyDefinitions {
        add_to_cart_availability(required: false, type: PropertyType.String, values: ["yes_default", "yes_discount", "yes_fs", "no_high_ratio", "no_too_many_items", "no_item_price_too_low"], 
                description: "Indicates which add_to_cart button the VIP is showing (Default, Discount, Free Shipping). In case it doesn't show it, also indicates the reason why it doesn't show it (High Ratio, Item price too low, Too many items in cart)")
        main_action(required: false, type: PropertyType.String, values: ["buy", "a2c_fs", "a2c_discount", "a2c_default"],
                description: "Indicates which button the VIP is showing as main_action (ie, shown as blue button). If it is a2c, it then specifies which button type (default, fs, discount)")   
        context(required: false, values: ["/search","/myml","/cart","/recommendations","/bookmarks","/vip", "UNKWOWN"],
                description: "The page or section where the add_cart_intention action is taking place")
    }
    
    propertyGroups {
        add_cart_info(add_to_cart_availability, main_action, context)
    }

    "/add_to_cart"(platform: "/", type: TrackType.Event) {
        items( required: true,description: "Item ids that are being added", type: PropertyType.ArrayList )
        //currency_id
        //item
            //id
            //category_id
        //quantity
        //unit_price

        context( required: true, values: ["/search","/myml","/cart","/recommendations","/bookmarks","/vip", "/loyalty", "/cart/saved_for_later","/item_add", "UNKWOWN"] ,
                description: "The page or section where the add_to_cart action is taking place" )
    }

    "/add_cart_intention"(platform: "/", type: TrackType.Event) {
        add_cart_info
    }

}
