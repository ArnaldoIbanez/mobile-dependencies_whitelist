//Cart list
//"vip/cart/shipping/select_option"(platform: "/") {} // Esta page no deberia existir... revisarlo

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

"/cart"(platform: "/", isAbstract: true) {
    listing_type(required:false, type: PropertyType.String)
    international_delivery_mode(required:false, type: PropertyType.String)
    mercado_lider(required:false, type: PropertyType.String)
    reputation_level(required:false, type: PropertyType.String)
    free_shipping_benefit(required:false, type: PropertyType.Boolean)
    resolution(required:false, type: PropertyType.String)
    loyalty_level(required:false, type: PropertyType.Numeric)
    is_empty(required:false, type: PropertyType.Boolean)
    connection_type(required:false, type: PropertyType.String)
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