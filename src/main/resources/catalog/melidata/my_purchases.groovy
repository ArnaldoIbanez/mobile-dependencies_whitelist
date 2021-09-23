package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1198"

    propertyDefinitions {

        items(required: true, type: PropertyType.ArrayList, description: "Items in this purchase")
        // business
        // page_vertical
        // domain
        // category_l1
        // category_l2
        // category_l3 (optional)
        // category_l4 (optional)
        // category_l5 (optional)
        // listing_type
        // item_id
        // quantity
        // variation_id (optional)
        // condition
        // product_id (optional)
        // deals (optional)

        payments(required: false, type: PropertyType.ArrayList, description: "Payments in this purchase")
        // payment_method_type
        // payment_method_id
        // payment_status
        // payment_status_detail

        shipping(required: false, type: PropertyType.ArrayList, description: "Shipments in this purchase")
        // shipping_method
        // shipping_mode
        // logistic_type
        // shipping_status
        // shipping_sub_status

        seller(required: true, type:PropertyType.ArrayList, description: "Array of sellers with their data")
        // id
        // nickname
        // mercado_lider
        // reputation_level
        // messages_count

        buyer(required: true, type:PropertyType.ArrayList, description: "Array of buyers with their data")
        // id
        // nickname
        // loyalty_level
        // is_prime

        purchase_status(required: true, type: PropertyType.String, description: "Purchase status")
        purchases_flow(required: true, type: PropertyType.String, description: "Flow identification to know if it is the new or old flow")
        checkout_flow(required: false, type: PropertyType.String, values: ["pack", "order"], description: "cart (pack) or direct (order) purchase")
        pack_ids(required: false, type: PropertyType.ArrayList, description: "Pack ids involved in the purchase")
        order_ids(required: false, type: PropertyType.ArrayList, description: "Order ids involved in the purchase")
        garex(required: false, type: PropertyType.String, values: ["yes", "no"], description: "the type of extended warranty of this purchase")
        vertical_case_id(required: true, type: PropertyType.String, description: "Case identified for the purchase status")
        vertical_sub_case_id(required: false, type: PropertyType.String, description: "Sub case identified for the purchase status")
        x_mc_request_id(required: true, type: PropertyType.String, description: "Session id for this purchase")
        purchase_id(required: true, type: PropertyType.Numeric, description: "The id of the purchase selected")
        pack_id(required: false, type: PropertyType.Numeric, description: "The id of the pack selected")
        order_id(required: false, type: PropertyType.Numeric, description: "The id of the order selected")
        label(required: false, type: PropertyType.String, description: "The action that was tracked")
    }

    def seller_def = objectSchemaDefinitions {
        messages_count(required: true, description: "Number of messages to seller", type: PropertyType.Numeric, name: "messages_count")
        nickname(required: true, description: "Username of the seller", type: PropertyType.String, name: "nickname")
        id(required: true, description: "id of the seller", type: PropertyType.Numeric, name: "id")
    }

    def shipping_def = objectSchemaDefinitions {
        shipping_mode(required: true, description: "Way of delivering (example: me2)", type: PropertyType.String, name: "shipping_mode", values: ["not_specified", "me1", "me2", "custom"])
        shipping_method(required: false, description: "Delivering method (example: standard)", type: PropertyType.String,  name: "shipping_method")
        shipping_sub_status(required: true, description: "Delivery sub-status (example: ready_to_print)", type: PropertyType.String,  name: "shipping_sub_status")
        logistic_type(required: true, description: "Delivering method variant (example: drop_off)", type: PropertyType.String, name: "logistic_type", values: ["not_specified", "default", "drop_off", "xd_drop_off", "custom", "cross_docking", "fulfillment", "self_service"])
        shipping_status(required: true, description: "Delivery status (example: ready_to_ship)", type: PropertyType.String, name: "shipping_status")
    }

    def payments_def = objectSchemaDefinitions {
        payment_method_type(required: true, description: "How the buyer actually paid", type: PropertyType.String, name: "payment_method_type")
        payment_method_id(required: true, description: "Id of the method type", type: PropertyType.String, name: "payment_method_id")
        payment_status_detail(required: true, description: "States if the buyer has the money or not", type: PropertyType.String, name: "payment_status_detail", values: ["pending_capture","accredited", "cc_rejected_blacklist", "cc_rejected_high_risk", "cc_rejected_insufficient_amount", "cc_rejected_invalid_installments", "cc_rejected_other_reason", "cc_rejected_max_attempts", "cc_rejected_bad_filled_card_number", "cc_rejected_bad_filled_other", "cc_rejected_bad_filled_date", "cc_rejected_bad_filled_security_code", "cc_rejected_call_for_authorize", "cc_rejected_card_disabled", "default", "accord", "pending_contingency", "pending_review_manual", "pending_challenge", "cc_rejected_fraud", "cc_rejected_duplicated_payment", "cc_rejected_bad_filled_invalid_date", "account_rejected_high_risk", "rejected_by_regulations", "rejected_insufficient_data", "rejected_by_bank", "error_bi_without_cnpj", "error_bi_different_ie", "error_bi_cnpj_non_operational", "error_bi_ie_invalid_state", "phone_verification"])
        payment_status(required: true, description: "States if the payment has been approved or not", type: PropertyType.String, name: "payment_status")
    }

    def items_def = objectSchemaDefinitions {
        category_l3(required: true, description: "Category id for l3", type: PropertyType.String, name: "category_l3")
        category_l4(required: true, description: "Category id for l4",  type: PropertyType.String, name: "category_l4")
        quantity(required: true, description: "How many were actually bought by the buyer", type: PropertyType.Numeric, name: "quantity")
        business(required: true, description: "Where the purchase occurred (example: marketplace)", type: PropertyType.String, name: "business")
        item_id(required: true, description: "Id of the item", type: PropertyType.String, name: "item_id")
        page_vertical(required: true, description: "Case identified for the purchase status", type: PropertyType.String, name: "page_vertical")
        listing_type(required: true, description: "Identifier of the item category", PropertyType.String, name: "listing_type")
        category_l1(required: true, description: "Category id for l1", type: PropertyType.String, name: "category_l1")
        category_l2(required: true, description: "Category id for l2",  type: PropertyType.String, name: "category_l2")
        international_delivery_mode(required: true, description: "Indicates if the item has international delivery or not", type: PropertyType.String, name: "international_delivery_mode")
        condition(required: true, description: "States if it is old or new", type: PropertyType.String, name: "condition")
        variation_id(required: true, description: "Id of the item variation", type: PropertyType.Numeric, name: "variation_id")
        domain(required: true, description: "Item's domain id", type: PropertyType.String, name: "domain")
        product_id(required: true, description: "Item id", type: PropertyType.String, name: "product_id")
    }

    def buyer_def = objectSchemaDefinitions {
        id(required: true, description: "Id of the buyer", type: PropertyType.Numeric, name: "id")
        is_prime(required: true, description: "Indicator of the id primality", type: PropertyType.String, name: "is_prime")
    }

    propertyGroups {
        newPurchasesGroup(items, payments, shipping, seller, buyer, purchases_flow, purchase_status, checkout_flow, pack_ids, order_ids, garex, vertical_case_id, vertical_sub_case_id, x_mc_request_id, purchase_id, pack_id, order_id)
        newPurchasesEventGroupFull(label, x_mc_request_id, vertical_case_id, vertical_sub_case_id, items, payments, shipping, seller, buyer, purchases_flow, purchase_status, checkout_flow, pack_ids, order_ids, garex, vertical_case_id, vertical_sub_case_id, x_mc_request_id, purchase_id, pack_id, order_id)
        newPurchasesEventGroup(label, x_mc_request_id, vertical_case_id, vertical_sub_case_id)
    }

    // BASE PATH FOR MY PURCHASES

    "/my_purchases"(platform:"/", isAbstract: true) {}


    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES STATUS
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/status"(platform:"/", type: TrackType.View) {
        newPurchasesGroup
    }

    "/my_purchases/status/show_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroupFull
    }

    "/my_purchases/status/show_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroupFull
    }

    "/my_purchases/status/show_faq"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroupFull
    }

    "/my_purchases/status/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroupFull
    }

    "/my_purchases/status/click_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroupFull
    }

    "/my_purchases/status/click_faq"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroupFull
    }

    "/my_purchases/status/click_view_item"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroupFull
    }

    "/my_purchases/status/click_view_messages"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/click_driver_messages"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/click_contact_us"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES STATUS_DETAIL
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/status_detail"(platform:"/", type: TrackType.View) {
        newPurchasesGroup
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES STATUS ITEMS
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/status/items"(platform:"/", type: TrackType.View) {}

    "/my_purchases/status/items/click_view_item"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroupFull
    }


    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES STATUS INSTRUCTIONS
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/status/instructions"(platform:"/", type: TrackType.View) {}

    "/my_purchases/status/instructions/click_view_item"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/instructions/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }


    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES STATUS MESSAGES
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/status/messages"(platform:"/", type: TrackType.View) {}

    "/my_purchases/status/messages/click_view_messages"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }


    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES STATUS MODALS
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/status/cancel_purchase"(platform:"/", type: TrackType.View) {}

    "/my_purchases/status/return_purchase"(platform:"/", type: TrackType.View) {}

    "/my_purchases/status/cancel_purchase/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/return_purchase/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES STATUS PLACES
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/status/places"(platform:"/", type: TrackType.View) {}

    "/my_purchases/status/places/show_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/places/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES DETAIL
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/detail"(platform:"/", type: TrackType.View) {
        newPurchasesGroup
    }

    "/my_purchases/detail/show_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/detail/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/detail/click_shipment_detail"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/detail/click_view_item"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/detail/click_download_invoice"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/detail/click_pack_link_modal"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/detail/click_go_to_insurance"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }
    "/my_purchases/detail/click_payment_link_modal"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES REFUND DETAIL
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/refund_detail"(platform:"/", type: TrackType.View) {
    }

    "/my_purchases/refund_detail/show_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/refund_detail/show_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/refund_detail/show_faq"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/refund_detail/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/refund_detail/click_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/refund_detail/click_faq"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MY PURCHASES LIST
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/my_purchases/list"(platform:"/", type: TrackType.View) {
    }

    "/my_purchases/list/repurchase_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        seller(required: true, description: "Seller data", type: PropertyType.ArrayList(PropertyType.Map(seller_def)), name: "seller")
        garex(required: true, description: "Indicator of garex", type: PropertyType.String, name: "garex")
        shipping(required: false, description: "Shipping data", type: PropertyType.ArrayList(PropertyType.Map(shipping_def)), name: "shipping")
        purchases_flow(required: false, description: "Version of purchases list", type: PropertyType.String, name: "purchases_flow")
        x_mc_request_id(required: true, description: "Session id of the purchase", type: PropertyType.String, name: "x_mc_request_id")
        purchase_status(required: true, description: "Status of the purchase", type: PropertyType.String, name: "purchase_status")
        payments(required: true, description: "Payments data", type: PropertyType.ArrayList(PropertyType.Map(payments_def)), name: "payments")
        items(required: false, description: "Items data", type: PropertyType.ArrayList(PropertyType.Map(items_def)), name: "items")
        checkout_flow(required: true, description: "Indicates if it is a direct or cart purchase", type: PropertyType.String, name: "checkout_flow")
        buyer(required: true, description: "Buyer data", type: PropertyType.ArrayList(PropertyType.Map(buyer_def)), name: "buyer")
    }

    "/my_purchases/list/repurchase"(platform:"/", type:TrackType.View, parentPropertiesInherited: false) {
    }
}
