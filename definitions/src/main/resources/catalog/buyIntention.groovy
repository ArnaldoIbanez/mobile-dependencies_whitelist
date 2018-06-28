import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// This tracks will be representing the user intention to buy. ( Meaning clicking the buy button
// Currently this can be done from several places ( carrito, vip, carrito( from an individual item )
// In any of them the way of tracking will be the same. A "from" attribute could be used to distinguish from where
// buy_intention was produced
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

"/buy_intention"(platform: "/",type: TrackType.Event) {
    seller(required: true, type:PropertyType.ArrayList, description: "Array of sellers with their data")
        //id
        //nickname
        //mercado_lider
        //reputation_level

    // Array of items will be sent. The definition is the same across all the checkout-flow.
    // The array is extensible, but can have 1 item or many ( carrito case )
    items(required: true, type:PropertyType.ArrayList, description: "Array of items that will be purchased")
    //currency_id
    //item
        //id
        //category_id
        //variation_id   
        //review_rate -> Lo completa Melidata automaticamente
        //category_path -> Lo completa Melidata automaticamente
        //deal_id -> Lo completa Melidata automaticamente
        //buying_mode -> Lo completa Melidata automaticamente
        //official_store -> Lo completa Melidata automaticamente
        //condition (new / used) -> Lo completa Melidata automaticamente
        //listing_type -> Lo completa Melidata automaticamente
    //quantity
    //unit_price

    total_amount(required: true, type: PropertyType.Numeric, description: "totalAmount")
    context(required:true, description: "Indicates from where the buy_intention was initiated. Where did the user pressed de 'COMPRAR' button", values: ["vip", "saved_for_later", "cart", "cart_item", "item_add", "UNKNOWN"])
    
    // checkout flow debiera ser la misma nomeclatura que seguimos en CHO => https://github.com/mercadolibre/melidata-catalog/blob/5246718a3ed30b73dad66066c37f42329d64d0e6/definitions/src/main/resources/catalog/checkout.groovy#L92
    checkout_flow(required: true, type: PropertyType.String, values: ["contract", "reservation", "subscription", "direct"])
}

}
