import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = "1104"

    def garexTrackStructure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String)
        period(required: true, type: PropertyType.Numeric)
        cost(required: true, type: PropertyType.Numeric)
        revenue_share_fee(required: true, type: PropertyType.Numeric)
        revenue(required: true, type: PropertyType.Numeric)
        currency_id(required: true, type: PropertyType.String)
    }

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// This tracks will be representing the user intention to buy. ( Meaning clicking the buy button
// Currently this can be done from several places ( carrito, vip, carrito( from an individual item )
// In any of them the way of tracking will be the same. A "from" attribute could be used to distinguish from where
// buy_intention was produced
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

"/buy_intention"(platform: "/",type: TrackType.Event) {
    seller(required: true, type:PropertyType.ArrayList, description: "Array of sellers with their data. Not every client has this data available")
        //id (required: true)
        //nickname (required: false)
        //mercado_lider (required: false)
        //reputation_level (required: false)

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
    context(required:true, description: "Indicates from where the buy_intention was initiated. Where did the user pressed de 'COMPRAR' button", values: ["vip", "pdp", "saved_for_later", "cart", "cart_item", "vip_combo", "item_add", "UNKNOWN", "cart_combo_reco", "checkout_recovery_combo", "home_cart-overview", "home_dropout", "home_last-buy", "mycart", "catalog_listing_from_saved_for_later", "mshops_from_mycart", "mshops_from_saved_for_later", "mshops_catalog_listing_from_mycart", "mshops_catalog_listing_from_saved_for_later", "mshops_mycart,catalog_listing_from_mycart", "mycart,catalog_listing_from_mycart","garex"])
    checkout_flow(required: true, type: PropertyType.String, values: ["subscription", "direct","cart", "contract", "reservation", "subscription", "direct"],  description: "The type of CHO that is starting by this buy intention. Reservation/contracts CHO's are excluded by the moment")

    //tracks específicos del flujo de checkout. TODO CHECK si hace sentido que lo mandemos o podemos dejar un track más limpio
    total_amount_with_shipping(required: false, description: "totalAmount with shipping cost")

    payments(required: false, description: "Array of payment information") //
        // id
        // payment_method,
        // payment_type,
        // installments,
        // selected_card
        // financed_order_cost_for_card
        // payment_must_call_for_authorize

    session_id(required:true, description:"Session in which the checkout is being held")

    vertical(required:true, description: "Vertical of the item to be bought")

    resolution(required:false, type: PropertyType.String, description: "resolution of the device")

    available_methods(required: false, type: PropertyType.ArrayList, description: "Available payment methods for this flow")

    buy_equal_pay(required: false, description: "BP flag")

    shipping_pick_up_in_store(required:false, type: PropertyType.String, description: "If the item has puis available")

    shipping(required: false, type:PropertyType.ArrayList)
        // shipping_type
        // cost
        // shipping_option,
        // id,
        // name,
        // shipping_method_id
        // id
        // shipping_mode

    operation_status(required: false, description: "status")

    loyalty_level(required:true, description:"The loyalty level of the buyer")

    recovery_flow(required: false, description: "Is recovery CHO flow")

    available_consumer_credit(required:false, type: PropertyType.String, values:["YES", "NO"], description:"If the user has active consumer credits")

    account_money_info(required:false, type: PropertyType.Map, description: "Map with data of the account money of the buyer")
        //skipPassword
        //useAccountMoneyWithAnotherPM
        //availableAccountMoney

    nearest_store_distance(required: false, description: "Distance to the nearest store")

    available_subscription(required:false, description:"If the item is elegible for subscription")

    order_id(required: false, type: PropertyType.Numeric, description: "order_id")

    applies_cart_ratio(required: false, type: PropertyType.String, description: "appliesCartRatio")

    item_with_garex(required: false, type: PropertyType.Boolean, description: 'Item has available warranty')
    total_amount_including_garex(required: false, type: PropertyType.Numeric, description: 'Total amount (include garex if applies)')
    garex(required: false, type: PropertyType.Map(garexTrackStructure), description: 'User selects a warranty option')
    stored_cards_quantity(required: false, type: PropertyType.Numeric, description: "Stored cards quantity of the buyer")

}

}
