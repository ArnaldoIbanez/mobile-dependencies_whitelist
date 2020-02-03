package catalog.melidata
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
        currency_id(required:true, type: PropertyType.String, description: "Currency_id of the item that is taken in/out of carrito")
        unit_price(required:true, type: PropertyType.Numeric, description: "Unit price of the item added/changed/deleted")
        quantity(required:true, type: PropertyType.Numeric, description: "Current quantity of the item at carrito")
        quantity_change(required: false, type: PropertyType.Numeric, decription: "Quantity that the item has been increased/decreased")
    }

    propertyGroups {
        item_info(currency_id, item, unit_price, quantity,quantity_change)
    }

    def propertyCost  = objectSchemaDefinitions {
        symbol(required:true, type: PropertyType.String, description:  "Currency symbol")
        amount(required:true, type: PropertyType.Numeric, description:  "Cost amount")
    }

    def propertySummary  = objectSchemaDefinitions {
        total(required:true, type: PropertyType.Map(propertyCost), description: "Total cost of the items")
        shipping_total(required:true, type: PropertyType.Map(propertyCost), description: "Total cost of shipping with discount applied")
        shipping_promoted_amount(required:true, type: PropertyType.Numeric, description:  "Total cost of shipping without discount")
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
    is_empty(required:false, type: PropertyType.String)
    page_vertical(required: false, type: PropertyType.String, description: "The vertical of the items")
    item_attributes(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "attributes for each item")
}

"/cart/my_cart"(platform: "/") {
    resolution(required:false, type: PropertyType.String)
    cart_ratio(required: false, type: PropertyType.String, values: ["applies", "not_applies"])
    summary(required: false, type: PropertyType.Map,
            description: "Map with information from the summary: total cost, total shipping cost and striked promoted amount if it exists")
    //total
        //amount
        //symbol
    //shipping_total
        //amount
        //symbol
    //shipping_promoted_amount -> va a tener el mismo symbol que shipping_total
}

"/cart/my_cart/save_for_later"(platform: "/", type: TrackType.Event) {
    item_info
}

"/cart/my_cart/delete_item"(platform: "/", type: TrackType.Event) {
    item_info
}

"/cart/my_cart/more_seller_items"(platform: "/", type: TrackType.Event) {
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

"/cart/saved_for_later"(platform: "/") {
    cart_ratio(required: false, type: PropertyType.String, values: ["applies", "not_applies"])
    summary(required: false, type: PropertyType.Map(propertySummary), description: "Map with information from the summary: total cost, total shipping cost and striked promoted amount if it exists")
    resolution(required: false, type: PropertyType.String, description: "resolution of the device")
}

"/cart/saved_for_later/open_change_notification"(platform: "/", type: TrackType.Event) {}

"/cart/saved_for_later/close_change_notification"(platform: "/", type: TrackType.Event) {}

// TODO Borrar => Lo estamos standarizando hacía la definición de add_to_cart.groovy
"/cart/saved_for_later/add_to_cart"(platform: "/", type: TrackType.Event) {
    item_info
}

"/cart/saved_for_later/delete_item"(platform: "/", type: TrackType.Event) {
    item_info
}


"/cart/saved_for_later/change_quantity"(platform: "/", type: TrackType.Event) {
    item_info
}


"/cart/my_cart/confirm_address"(platform: "/", type:TrackType.Event){}

"/cart/my_cart/change_address"(platform: "/") {}

"/cart/my_cart/add_cp"(platform: "/", isAbstract: true, type: TrackType.View) {}

"/cart/my_cart/my_addresses"(platform: "/", type: TrackType.Event){}

"/cart/my_cart/confirm_cp"(platform: "/", type: TrackType.Event){}

"/cart/my_cart/add_cp/confirm_cp"(platform: "/", type: TrackType.Event){}

"/cart/my_cart/add_cp/dont_know_cp"(platform: "/", type: TrackType.Event){}

"/cart/item_add"(platform: "/", type: TrackType.View) {
    items(required: true, type:PropertyType.ArrayList, description: "Array of items that are being added")
    context(required: false, values: ["search","myml","cart","recommendations","bookmarks","bookmarks_widget","vip","loyalty","cart/saved_for_later","item_add","UNKNOWN"],
            description: "The page or section where the add_cart_intention action is taking place")
    free_shipping_benefit(required: false, type: PropertyType.Boolean)
    cart_ratio(required: false, type: PropertyType.String, values: ["applies", "not_applies"])
    error_type(required: false, type: PropertyType.String)
}

"/cart/item_add/error"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
    error_type(required: true, type: PropertyType.String)
}


//modals on saved_for_later
"/cart/saved_for_later/cant_add_to_cart"(platform: "/", type: TrackType.Event){
    cant_add_motive(required: true, type: PropertyType.String, values: ["ratio", "zip_code", "low_price"])
}

"/cart/saved_for_later/cant_add_to_cart/buy_now"(platform: "/", type: TrackType.Event){}

//modals on active items
"/cart/my_cart/free_shipping_lost_warning"(platform: "/", type: TrackType.Event){
    cant_update_motive(required: true, type: PropertyType.String, values:  ["delete", "zip_code", "quantity_up",
                           "quantity_down", "saved_for_later", "variation_quantity", "unknown"])
    cart_ratio(required: true, type: PropertyType.String, values: ["applies", "not_applies"])
}

"/cart/my_cart/free_shipping_lost_warning/dismiss"(platform: "/", type: TrackType.Event){}

"/cart/my_cart/free_shipping_lost_warning/confirm"(platform: "/", type: TrackType.Event){}

"/cart/my_cart/change_free_shipping_progress_status"(platform: "/", type: TrackType.Event){
    motive(required: true, type: PropertyType.String, values: ["delete", "quantity",
           "saved_for_later", "variation_quantity", "unknown"])
    cart_ratio(required: true, type: PropertyType.String, values: ["applies", "not_applies"])
    previous_free_shipping_progress(required: true, type: PropertyType.Numeric)
    actual_free_shipping_progress(required: true, type: PropertyType.Numeric)
}

}
