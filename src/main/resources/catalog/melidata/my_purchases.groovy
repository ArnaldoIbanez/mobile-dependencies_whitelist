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

    propertyGroups {
        newPurchasesGroup(items, payments, shipping, seller, buyer, purchases_flow, purchase_status, checkout_flow, pack_ids, order_ids, garex, vertical_case_id, vertical_sub_case_id, x_mc_request_id, purchase_id, pack_id, order_id)
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
        newPurchasesEventGroup
    }

    "/my_purchases/status/show_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/show_faq"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/click_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/click_faq"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/my_purchases/status/click_view_item"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
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
        newPurchasesEventGroup
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

}
