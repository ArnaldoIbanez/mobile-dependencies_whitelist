package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


// Tracks indicating a purchase or an order created on the backend side. They include the important uid fields
// and they are send from this bigque consumer project https://github.com/mercadolibre/melidata-jobs

tracks {

    initiative = "1145"

    "/orders"(platform: "/", isAbstract: true) {}

    "/orders/ordercreated"(platform: "/") {
        order_id(required: true, description: "order identifier")
        status(required: true, description: "status of this order at creation")
        status_detail(required: false, description: "status description")
        total_amount(required: true, description: "order amount, does not include shipping or interests")
        total_amount_with_shipping(required: false, description: "order amount including shipping cost")
        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
        //id
        //title
        //selle_custom_fields
        //variation_attributes
        //category_id
        //variation_id
        //quantity
        //unit_price
        //currency_id
        //sale_fee

        shipping(required: false)
        //id
        //cost
        //shipping_mode
        //shipping_option
        //id
        //name
        //shipping_method_id

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method
        // payment_type
        // paid_amount
        // installments
        // without_fee
        // status
        // status_detail

        buyer(required: true, description: "buyer information") // id, nickname
        seller(required: true, type:PropertyType.ArrayList, description: "Array of sellers with their data") // id, nickname
        is_carrito(required: true, description: "Whetever this order was created by a carrito or not ")
        reservation(required: true, type: PropertyType.Boolean, description: "If the order came from a motor reservation")
        subscription(required: true, type: PropertyType.Boolean, description: "If the order was generated from a subscription")

        total_amount_local(serverSide: true) // -> Lo completa Melidata automaticamente
        total_amount_usd(serverSide: true) // -> Lo completa Melidata automaticamente
        new_buyer(serverSide: true) // -> Lo completa Melidata automaticamente (eliminar al deployar en consumers)
        buyer_segment(serverSide: true) // -> Lo completa Melidata automaticamente
        loyalty_buyer(serverSide: true) // -> Lo completa Melidata automaticamente
        is_pdp(serverSide: true) // -> Lo completa Melidata automaticamente
        has_garex(serverSide: true) // -> Lo completa Melidata automaticamente
        tags(serverSide: true) // -> Lo completa Melidata automaticamente
        internal_tags(serverSide: true) // -> Lo completa Melidata automaticamente
    }

    "/purchases"(platform: "/", isAbstract: true) {}

    "/purchases/purchasecreated"(platform: "/") {
        purchase_id(required: true, description: "purchase identifier")
        orders( required: true, type:PropertyType.ArrayList, description: "Array of orders_ids associated to this purchase" )
        packs ( required: true, type:PropertyType.ArrayList, description: "Array of packs_ids associated to this purchase" )
        
        status(required: true, description: "status of this order at creation")
        status_detail(required: false, description: "status description")
        total_amount(required: true, description: "order amount, does not include shipping or interests")
        total_amount_with_shipping(required: false, description: "order amount including shipping cost")
        items( required: true, type:PropertyType.ArrayList, description: "Array of items in the order with following data" )
        //item
        //        id
        //        review_rate
        //        differential_pricing_id
        //        seller_custom_field
        //        condition
        //        deal_ids
        //        category_path
        //        listing_type_id
        //        buying_mode
        //        category_id
        //        sale_fee
        //        warranty

        shipping(required: false)
        //id
        //cost
        //shipping_mode
        //shipping_option
        //  id
        //  shipping_method_id

        payments(required: false, description: "Array of payments information")
        // id
        // payment_method
        // payment_type
        // paid_amount
        // installments
        // without_fee
        // status
        // status_detail

        buyer(required: true, description: "buyer information") // id, nickname
        seller(required: true, type:PropertyType.ArrayList, description: "Array of sellers with their data") // id, nickname

        total_amount_local(serverSide: true) // -> Lo completa Melidata automaticamente
        total_amount_usd(serverSide: true) // -> Lo completa Melidata automaticamente
        new_buyer(serverSide: true) // -> Lo completa Melidata automaticamente (eliminar al deployar en consumers)
        buyer_segment(serverSide: true) // -> Lo completa Melidata automaticamente
        loyalty_buyer(serverSide: true) // -> Lo completa Melidata automaticamente
        is_pdp(serverSide: true) // -> Lo completa Melidata automaticamente
        orders(required: true, description: "orders associated to the purchase", PropertyType.ArrayList(PropertyType.String))
    }

}
