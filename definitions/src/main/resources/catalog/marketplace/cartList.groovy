//Cart list
//"vip/cart/shipping/select_option"(platform: "/") {} // Esta page no deberia existir... revisarlo

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

"/cart"(platform: "/", isAbstract: true) {

	items(required: true, type:PropertyType.ArrayList, description: "Array of items in the cart with following data")
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

    seller(required: true, type:PropertyType.ArrayList, description: "Array of sellers with their data")
    //id
    //nickname
    //mercado_lider
    //reputation_level

	free_shipping_benefit(required:false, type: PropertyType.Boolean)
    loyalty_level(required:false, type: PropertyType.Numeric)
    is_empty(required:false, type: PropertyType.Boolean)
}

"/cart/my_cart"(platform: "/") {}

"/cart/my_cart/save_for_later"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/delete_item"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/change_quantity"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/select_address"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/dont_know_cp"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/view_similar"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/open_change_notification"(platform: "/", type: TrackType.Event) {}

"/cart/my_cart/close_change_notification"(platform: "/", type: TrackType.Event) {}

"/cart/saved_for_later"(platform: "/") {}

"/cart/saved_for_later/add_to_cart"(platform: "/", type: TrackType.Event) {}

"/cart/saved_for_later/delete_item"(platform: "/", type: TrackType.Event) {}

"/cart/change_address"(platform: "/") {}

"/cart/add_cp"(platform: "/") {}

}