package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = "1171"

    propertyDefinitions {
        add_to_cart_availability(required: false, type: PropertyType.String, values: ["yes_default", "yes_discount", "yes_fs", "no_high_ratio", "no_too_many_items", "no_item_price_too_low"], 
                description: "Indicates which add_to_cart button the VIP is showing (Default, Discount, Free Shipping). In case it doesn't show it, also indicates the reason why it doesn't show it (High Ratio, Item price too low, Too many items in cart)")
        main_action(required: false, type: PropertyType.String, values: ["buy", "a2c_fs", "a2c_discount", "a2c_default"],
                description: "Indicates which button the VIP is showing as main_action (ie, shown as blue button). If it is a2c, it then specifies which button type (default, fs, discount)")   
        context(required: true, values: ["search","cart","recommendations","bookmarks_widget","vip","pdp","cart/saved_for_later", "supermarket_home", "UNKNOWN"],
                description: "The page or section where the add_cart_intention action is taking place")
    }
    
    propertyGroups {
        add_cart_info(add_to_cart_availability, main_action, context)
    }

    // THE IMPORTANT TRACK. Is tracked automatically by page X. If you don't redirect to page X, you are repsonsible for tracking it 
    "/add_to_cart"(platform: "/", type: TrackType.Event) {
        items( required: true,description: "Item ids that are being added", type: PropertyType.ArrayList )
        //currency_id
        //item
            //id
            //category_id
        //quantity
        //unit_price
        add_cart_info
        carousel_type(required: false, type: PropertyType.String, values: ["normal", "home"], description: "Indicates the type of variation of the carousel, in case it comes from a carousel")
        carousel_label(required: false, type: PropertyType.String, description: "Carousel label, in case it comes from a carousel")
        component(required: false, type: PropertyType.Numeric, description: "Component number on the page")
    }

    // Optional indicating you may want to try to add things to a carrito
    "/add_cart_intention"(platform: "/", type: TrackType.Event) {
        items(required: true, description: "Item ids that are being added", type: PropertyType.ArrayList)
         //currency_id
         //item
             //id
             //category_id
         //quantity
         //unit_price
        add_cart_info
    }

    "/remove_from_cart"(platform: "/", type: TrackType.Event){
        /** Track example:
         {
            "context": "search",
            “items: [
                {
                    “currency_id” : “MXN”,
                    “item”: {
                        “id”: “MLA1234”,
                        “category_id”: “MLM123456”
                    },
                    “remaining_quantity”: 2,
                    “unit_price”: 100,
                }
            ]
         }
         */
        context(required: true, values: ["search", "cart", "supermarket_home", "UNKNOWN"])
        items(required: true, type: PropertyType.ArrayList, description: "The list of items removed from cart")
    }
}
