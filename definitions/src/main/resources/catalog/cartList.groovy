//Cart list
//"vip/cart/shipping/select_option"(platform: "/") {} // Esta page no deberia existir... revisarlo

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    propertyDefinitions {
        item(required: true, description: "Item that is being taken in/out of carrito")
            //id
            //listing_type
            //international_delivery_mode
        currency_id(required:true, description: "Currency_id of the item that is taken in/out of carrito")
        unit_price(required:true, description: "Unit price of the item added/changed/deleted")
        quantity(required:true,  description: "Current quantity of the item at carrito")
        quantity_change(required: false, decription: "Quantity that the item has been increased/decreased")
    }

    propertyGroups {
        item_info(currency_id, item, unit_price, quantity,quantity_change)
    }



    "/cart"(platform: "/", isAbstract: true) {

	items(required: false, type:PropertyType.ArrayList, description: "Array of items in the cart with following data")
    //currency_id
    //item
        //id
        //review_rate -> Lo completa Melidata automaticamente
        //shipping_mode
        //international_delivery_mode
        //category_path -> Lo completa Melidata automaticamente
        //deal_id -> Lo completa Melidata automaticamente
        //buying_mode -> Lo completa Melidata automaticamente
        //category_id -> Lo completa Melidata automaticamente
        //official_store
        //condition (new / used)
        //listing_type
        //variation_id
    //quantity
    //unit_price


	free_shipping_benefit(required:false, type: PropertyType.Boolean)
    loyalty_level(required:false, type: PropertyType.Numeric)
    is_empty(required:false, type: PropertyType.Boolean)
}

"/cart/my_cart"(platform: "/") {}

"/cart/my_cart/save_for_later"(platform: "/", type: TrackType.Event) {
    item_info
}

"/cart/my_cart/delete_item"(platform: "/", type: TrackType.Event) {
    item_info
}

"/cart/my_cart/change_quantity"(platform: "/", type: TrackType.Event) {
    item_info
}

"/cart/my_cart/select_address"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/dont_know_cp"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/view_similar"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/open_change_notification"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/close_change_notification"(platform: "/", type: TrackType.Event) {}

"/cart/saved_for_later"(platform: "/") {}

"/cart/saved_for_later/add_to_cart"(platform: "/", type: TrackType.Event) {
    item_info
}

"/cart/saved_for_later/delete_item"(platform: "/", type: TrackType.Event) {
    item_info
}

"/cart/my_cart/confirm_address"(platform: "/", type:TrackType.Event){}

"/cart/my_cart/change_address"(platform: "/") {}

"/cart/my_cart/add_cp"(platform: "/", isAbstract: true, parentPropertiesInherited: false) {}

"/cart/my_cart/my_addresses"(platform: "/", type: TrackType.Event){}

"/cart/my_cart/confirm_cp"(platform: "/", type: TrackType.Event)

"/cart/my_cart/add_cp/confirm_cp"(platform: "/", type: TrackType.Event){}

"/cart/my_cart/add_cp/dont_know_cp"(platform: "/", type: TrackType.Event){}



}