package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1033"

    propertyDefinitions {
	    cart_content(required:false, type: PropertyType.String)
        CartContent(required:false, type: PropertyType.String)//solo va a existir por un mes, hasta que hagamos la subida para mobile
	    status(required:false, type: PropertyType.String)
        purchase_status(required:false, type: PropertyType.String)
        PurchaseStatus(required:false, type: PropertyType.String)//solo va a existir por un mes, hasta que hagamos la subida para mobile

	    seller(required: false, type:PropertyType.ArrayList, description: "Array of sellers with their data")
	    // id
	    // nickname
	    // mercado_lider
	    // reputation_level
        // messages_count

	    buyer(required: false, type:PropertyType.ArrayList, description: "Array of buyers with their data")
	    // id
	    // nickname
	    // loyalty_level
        // is_prime

        render_buy_it_again(required: false, type: PropertyType.String, description: "Has render the buy_it_again button")

        // new purchases
        items(required: false, type: PropertyType.ArrayList, description: "Items in this purchase")
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

        checkout_flow(required: false, type: PropertyType.String, values: ["pack", "order"], description: "cart (pack) or direct (order) purchase")
        garex(required: false, type: PropertyType.String, values: ["yes", "no"], description: "the type of extended warranty of this purchase")

        purchases_flow(required: false, type: PropertyType.String, description: "Flow identification to know if it is the new or old flow")
        vertical_case_id(required: false, type: PropertyType.String, description: "Case identified for the purchase status")
        vertical_sub_case_id(required: false, type: PropertyType.String, description: "Sub case identified for the purchase status")
        x_mc_request_id(required: false, type: PropertyType.String, description: "Session id for this purchase")
        purchase_id(required: false, type: PropertyType.Numeric, description: "The id of the purchase selected")
        pack_id(required: false, type: PropertyType.Numeric, description: "The id of the pack selected")
        order_id(required: false, type: PropertyType.Numeric, description: "The id of the order selected")
        label(required:false, type: PropertyType.String, description: "The action that was tracked")

    }

    propertyGroups {
        mymlGroup(cart_content, CartContent, status, purchase_status, PurchaseStatus, seller, buyer, render_buy_it_again)
        newPurchasesGroup(items, payments, shipping, seller, buyer, checkout_flow, garex, vertical_case_id, vertical_sub_case_id, x_mc_request_id, purchase_id, pack_id, order_id)
        newPurchasesEventGroup(label, x_mc_request_id)
    }

    // ---------------- Sales

    "/myml/sales"(platform: "/", isAbstract: true) {
        mymlGroup
    }

    // Deprecar en Julio
    "/myml/sales"(platform: "/mobile", isAbstract: true) {
        dimensions(required: false, description: "Temporal for 1 months")
    }
    //

    "/myml/sales/list"(platform: "/", type: TrackType.View) {}

    "/myml/sales/vop"(platform: "/", type: TrackType.Event) {}

    "/myml/sales/status"(platform: "/") {}

    "/myml/sales/status/call_to_carrier"(platform: "/", type: TrackType.Event) {
    	carrier(required:false, type: PropertyType.String)
    }

    "/myml/sales/status/pack_tutorial"(platform: "/", type: TrackType.Event) {}

    "/myml/sales/detail/pack_tutorial"(platform: "/", type: TrackType.Event) {}

    "/myml/sales/detail"(platform: "/") {}

    "/myml/sales/detail/refund_money"(platform: "/", type: TrackType.Event) {}

    "/myml/sales/detail/print_label"(platform: "/", type: TrackType.Event) {}

    "/myml/sales/order"(platform: "/") {}

    "/myml/sales/shipping"(platform: "/", type: TrackType.View) {}

    "/myml/sales/shipping_detail"(platform: "/") {}

    "/myml/sales/messages"(platform: "/") {}

    "/myml/sales/questions"(platform: "/") {}

    "/myml/sales/questions/history"(platform: "/mobile") {}

    "/myml/sales/questions/answer_question"(platform: "/mobile") {}

    "/myml/sales/questions/response"(platform: "/") {
        unregistered_contact(required: true, type: PropertyType.Boolean, "User is unregister type")
    }

    "/myml/sales/buyer"(platform:"/", type: TrackType.View) {}

    "/myml/sales/item"(platform:"/", type: TrackType.View) {}


    // ---------------- Purchases


    "/myml/purchases"(platform: "/", isAbstract: true) {
    	mymlGroup
    }

    // Deprecar en Julio
    "/myml/purchases"(platform: "/mobile", isAbstract: true) {
        dimensions(required: false, description: "Temporal for 1 months")
    }

    "/myml/purchases/list"(platform: "/") {
        return_available(required: false, type: PropertyType.String, values: ["Yes", "No"], description: "Indicates if there is at least one item that has free return")
    }

    "/myml/purchases/list/returns_action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Indicates the button that have been clicked",
                values: ['return_item', 'cancel_return', 'change_return_pickup', 'prepare_package', 'return_agencies', 'print_return_label', 'return_not_delivered', 'return_delivered_problem', 'track_return', 'cant_return'])
    }

    "/myml/purchases/vop"(platform: "/") {}

    "/myml/purchases/vop/returns_action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Indicates the button that have been clicked",
                values: ['return_item', 'cancel_return', 'change_return_pickup', 'prepare_package', 'return_agencies', 'print_return_label', 'return_not_delivered', 'return_delivered_problem', 'track_return', 'cant_return'])
    }

    "/myml/purchases/detail"(platform: "/") {}

    "/myml/purchases/detail/delete_purchase"(platform: "/", type: TrackType.Event) {}

    "/myml/purchases/detail/what_do_if_i_pay"(platform: "/", type: TrackType.Event) {}

    "/myml/purchases/detail/call_to_carrier"(platform: "/", type: TrackType.Event) {
    	carrier(required:false, type: PropertyType.String)
    }

    "/myml/purchases/detail/history"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/print_label"(platform: "/") {}

    "/myml/purchases/print_label/show_stores_map"(platform: "/", type: TrackType.Event) {}

    "/myml/purchases/shipping"(platform: "/", type: TrackType.View) {}

    "/myml/purchases/shipping_detail"(platform: "/") {}

    "/myml/purchases/shipping_detail/refund_details"(platform: "/", type: TrackType.Event) {}

    "/myml/purchases/messages"(platform: "/") {}

    "/myml/purchases/questions"(platform: "/") {}

    "/myml/purchases/questions/asked_questions"(platform: "/mobile") {}

    "/myml/purchases/questions/history"(platform: "/mobile") {}

    "/myml/purchases/canceled"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/order"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/feedback"(platform: "/mobile", isAbstract: true) {}

    "/myml/purchases/feedback/rating"(platform: "/mobile", type: TrackType.View) {}

    "/myml/purchases/feedback/message"(platform: "/mobile", type: TrackType.View) {}

    "/myml/purchases/feedback/congrats"(platform: "/mobile", type: TrackType.View) {}

    "/myml/purchases/feedback/congrats#action"(platform: "/mobile", type: TrackType.Event) {
    	target(required: true, type: PropertyType.String)
    }

    "/myml/purchases/feedback/error"(platform: "/mobile", type: TrackType.View) {}

    "/myml/purchases/item"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/seller"(platform:"/", type: TrackType.View) {}
    
    // ---------------- Purchases status

    "/myml/purchases/status"(platform:"/", type: TrackType.View) {
        newPurchasesGroup
    }

    "/myml/purchases/status/items"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/status/instructions"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/status/messages"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/status/cancel_purchase"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/status/return_purchase"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/status/show_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/show_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/show_faq"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/click_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/click_faq"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/click_view_item"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/click_view_messages"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/click_contact_us"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/items/click_view_item"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/instructions/click_view_item"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/instructions/click_action"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/messages/click_view_messages"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false) {
        newPurchasesEventGroup
    }

    "/myml/purchases/status/buy_it_again"(platform:"/mobile", type: TrackType.Event) {
        item_id(required: true,type: PropertyType.String, description: "Item id")
        buy_it_again_experiment(required: true,type: PropertyType.String, description: "Is the user in the experiment")
        buy_it_again_lead_checkout(required: true,type: PropertyType.String, description: "Is the button going to redirect to checkout")
    }


    // ---------------- Listings


    "/myml"(platform: "/", isAbstract: true) {}
    "/myml/listings"(platform: "/web", type: TrackType.View) {
        label(required: true, description: "Selected label: active/closed/paused/...")
    }

    "/myml/listings/show"(platform: "/web", type: TrackType.View) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: true, description: "Adevrtasement segmentation ")
        reputation_level(required: true, description: "Reputation for Pads")
    }

    "/myml/listings/hide"(platform: "/web", type: TrackType.Event) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: true, description: "Adevrtasement segmentation ")
        reputation_level(required: true, description: "Reputation for Pads")
    }

    "/myml/listings/go"(platform: "/web", type: TrackType.Event) {
        placement(required: true, description: "Place where track was dispatched")
        adv_segmentation(required: true, description: "Adevrtasement segmentation ")
        reputation_level(required: true, description: "Reputation for Pads")
    }

    "/myml/listings/active"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/listings/closed"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/listings/detail"(platform: "/mobile", type: TrackType.Event) {}

    "/myml/bookmarks"(platform: "/web", type: TrackType.View) {}
    "/myml/questions"(platform: "/web", type: TrackType.View) {}

    "/myml/summary"(platform: "/web", type: TrackType.View) {}

    "/myml/summary/show"(platform: "/web", type: TrackType.View) {
        placement(required: false, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Adevrtasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
    }

    "/myml/summary/hide"(platform: "/web", type: TrackType.Event) {
        placement(required: false, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Adevrtasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
    }

    "/myml/summary/go"(platform: "/web", type: TrackType.Event) {
        placement(required: false, description: "Place where track was dispatched")
        adv_segmentation(required: false, description: "Adevrtasement segmentation ")
        reputation_level(required: false, description: "Reputation for Pads")
    }

    // Myml - Suggested Discounts
    "/myml/suggested_discounts"(platform: "/mobile", isAbstract: true){
        item_id(required: false, description: "Item id")
        item_original_price(required: false, description: "Item price")
        item_title(required: false, description: "Item title")
    }
    "/myml/suggested_discounts/landing"(platform: "/mobile", type: TrackType.View) {}
    "/myml/suggested_discounts/landing/about"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/landing/start"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/landing/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/landing/abandon"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/about"(platform: "/mobile", type: TrackType.View) {
        onboarding_step(required: false, description: "Onboarding step number")
    }
    "/myml/suggested_discounts/about/skip"(platform: "/mobile", type: TrackType.Event) {
        onboarding_step(required: false, description: "Onboarding step number")
    }
    "/myml/suggested_discounts/about/start"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/about/abandon"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/about/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/select_discount"(platform: "/mobile", type: TrackType.View) {}
    "/myml/suggested_discounts/select_discount/apply"(platform: "/mobile", type: TrackType.Event) {
        selected_discount(required: true, description: "Selected discount option")
    }
    "/myml/suggested_discounts/review_discount"(platform: "/mobile", type: TrackType.View) {}
    "/myml/suggested_discounts/review_discount/confirm"(platform: "/mobile", type: TrackType.Event) {
        selected_discount(required: true, description: "Selected discount option")
    }
    "/myml/suggested_discounts/select_discount/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/review_discount/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/info"(platform: "/mobile", type: TrackType.View) {
        discount_status(required: false, description: "Current deal status")
      }
    "/myml/suggested_discounts/info/exit"(platform: "/mobile", type: TrackType.Event) {
        action(required: true, description: "Selected exit action")
    }
    "/myml/suggested_discounts/info/back"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/suggested_discounts/error"(platform: "/mobile", type: TrackType.View) {}
    "/myml/suggested_discounts/error/back"(platform: "/mobile", type: TrackType.Event) {}

    "/myml/account_balance"(platform: "/mobile", type: TrackType.View) {}

    "/myml/account_balance/withdraw"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: false, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/send_money"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: false, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/cellphone_recharge"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: false, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/bill_payments"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: false, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/generic_error"(platform: "/mobile", type: TrackType.View) {
        additional_info (required:false, description: "Extra info")
    }
    "/myml/account_balance/digital_goods"(platform: "/mobile", type: TrackType.View) {}

    "/myml/account_balance/fund_travel_card"(platform: "/mobile", type: TrackType.View) {}

    "/myml/account_balance/gas_station"(platform: "/mobile", type: TrackType.View) {}

    "/myml/account_balance/mp"(platform: "/mobile", type: TrackType.View) {}
    "/myml/account_balance/mp/install"(platform: "/mobile", type: TrackType.View) {}

    "/myml/account_balance/my_money"(platform: "/mobile", type: TrackType.View) {}

    "/myml/account_balance/scan_qr"(platform: "/mobile", type: TrackType.View) {}

    "/myml/account_balance/install"(platform: "/mobile", type: TrackType.View) {}
    "/myml/account_balance/install/go_to_store"(platform: "/mobile", type: TrackType.Event) {}

    "/myml/sales"(platform: "/mobile", isAbstract: true) {}
    "/myml/sales/detail"(platform: "/mobile", isAbstract: true) {}
    "/myml/sales/detail/flow_selector"(platform: "/mobile", type: TrackType.View) {
        flow_selected(required: true, type: PropertyType.String, description: "use case selected based on incoming parameters")
    }
    "/myml/sales/detail/deliver_product"(platform: "/mobile", type: TrackType.View) {}
    "/myml/sales/detail/deliver_product#submit"(platform: "/mobile/android", type: TrackType.Event) {
        action_label(required: true, type: PropertyType.String, description: "action selected when submitting: send_feedback or update shipping")
    }
    "/myml/sales/detail/deliver_product#submit"(platform: "/mobile/ios", type: TrackType.Event) {
        action_label(required: false, type: PropertyType.String, description: "action selected when submitting: send_feedback or update shipping")
    }
    "/myml/sales/detail/date_will_receive_product"(platform: "/mobile", type: TrackType.View) {}
    "/myml/sales/detail/deliver_product/action"(platform: "/mobile", type: TrackType.Event) {
        action_label(required:true, type: PropertyType.String, description: "action performed, post feedback or update shipping")
        order_id(required: true, type: PropertyType.String)
        shipping_id(required: false, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean, description: "true if the action was successful")
    }
    "/myml/sales/detail/send_feedback"(platform: "/mobile", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.String)
        success(required: true, type: PropertyType.Boolean)
    }

    "/myml/main"(platform: "/mobile", type: TrackType.View) {
        messages(required: false, PropertyType.String)
    }

    // Price parity massive items editor
    "/myml/market_prices_editor"(platform: "/", type: TrackType.View) {}

    "/myml/market_prices_editor/save"(platform: "/", type: TrackType.Event) {
        total_items(required: true, type: PropertyType.Numeric, description: "Quantity of items selected to be massively modified.")
    }

    "/myml/market_prices_editor/get_suggested_price"(platform: "/", type: TrackType.Event) {
        total_items(required: true, type: PropertyType.Numeric, description: "Quantity of items selected to retrieve their suggested price.")
    }

    // Eventos relacionados al item
    "/item"(platform: "/", isAbstract: true) {
        item_id(required: true, description: "Item id")
    }

    "/item/update"(platform: "/", type: TrackType.Event) {
        variations_changed(required: false, type: PropertyType.Boolean, description: "Add new variation, delete a variation or change attribute combination from an existing.")
        title_changed(required: false, type: PropertyType.Boolean, description: "Change the title.")
        stock_changed(required: false, type: PropertyType.Boolean, description: "Change the available quantity from the items or variations.")
        price_changed(required: false, type: PropertyType.Boolean, description: "Change the price.")
    }

    "/item/create"(platform: "/", type: TrackType.Event) {
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: true, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: true, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified/refurbished", type: PropertyType.String)
        price(required: false, description: "Item price", type: PropertyType.Numeric)
        category_id(required: true, description: "Item category_id")
        category_path(required: true, type: PropertyType.ArrayList, description: "Item's category tree")
        has_whatsapp(required: false, type: PropertyType.Boolean, description: "Determine if the item has whatsapp")

        // Category sugestion
        suggested_category_id(required: false, description: "Category id suggested")
        suggested_category_is_leaf(required: false, type: PropertyType.Boolean, description: "The category suggested is leaf")
        suggested_category_path(required: false, type: PropertyType.ArrayList, description: "Item's suggested category tree")
    }

    "/item/change_listing_type"(platform: "/", type: TrackType.Event) {
        from(required: true, description: "Previous Listing type")
        to(required: true, description: "New Listing type")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        source(required: false, description: "upgrade flow that was used to change the listing type")
    }


    "/item/relist"(platform: "/", type: TrackType.Event) {
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: true, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: true, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified/refurbished", type: PropertyType.String)
        price(required: false, description: "Item price", type: PropertyType.Numeric)
        parent_id(required: false, description: "Parent item listing type id")
        parent_listing_type_id(required: false, description: "Parent item listing type id")
        change_listing_type(required: false, description: "If the listing type changed compare to its parent. Values: upgrade/no_change/downgrade")
        source(required: false, description: "Relist flow that was used to relist the item")
        quantity(required: false, description: "Item quantity")
    }

    "/myml/profile"(platform: "/mobile", type: TrackType.View) {}
    "/myml/profile/review_data"(platform: "/mobile", type: TrackType.View) {}
    "/myml/profile/complete_data"(platform: "/mobile", type: TrackType.View) {}
    "/myml/profile/update_form"(platform: "/mobile", type: TrackType.View) {
        has_inferred_data(required:true, type: PropertyType.Boolean)
    }
    "/myml/profile/update_success"(platform: "/mobile", type: TrackType.View) {}
    "/myml/profile/review_data/confirm"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/profile/card_details"(platform: "/mobile", type: TrackType.View) {}
    "/myml/company_profile"(platform: "/mobile", type: TrackType.View){}
    "/myml/fiscal_data_edit"(platform: "/mobile", type:TrackType.View){}

    // Loyalty discounts. May need to add parentPropertiesInherited: false property
    "/myml/loyal_discounts" (platform: "/", type: TrackType.View) {
        item(required: true, description: "Item to apply discounts")
    }
    "/myml/loyal_discounts/add" (platform: "/web", type: TrackType.Event) {
        item (required: true)
        percentage (required: true)
        type (required: true, values: ["LOW_LOYAL", "HIGH_LOYAL"])
    }
    "/myml/loyal_discounts/delete" (platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {
        item_id (required: true)
        type (required: true, values: ["LOW_LOYAL", "HIGH_LOYAL"])
    }

    //:::: MYML - FISCAL INFORMATION
    "/myml/fiscal_information"(platform: "/", isAbstract: true) {}
    "/myml/fiscal_information/mobile"(platform: "/", type: TrackType.View) {}
    "/myml/fiscal_information/not_found"(platform: "/", type: TrackType.View) {}

    // Message page
    "/myml/fiscal_information/message"(platform: "/", type: TrackType.View) {
        code(required: false, type: PropertyType.String, description: "Message code to display")
    }

    // Tax information form page
    "/myml/fiscal_information/tax_information"(platform: "/", type: TrackType.View) {
        url(required: true, type: PropertyType.String, description: "Page url")
        item_id(required: true, type: PropertyType.String, description: "Meli item id")
        order_id(required: false, type: PropertyType.String, description: "Meli order id")
        query_type(required: false, type: PropertyType.String, values: ["single", "bundle"], description: "Type of fiscal information")
        query_data(required: false, type: PropertyType.String, description: "Base64 code with order informations")
    }

    "/myml/fiscal_information/tax_information/form"(platform: "/", isAbstract: true) {}
    "/myml/fiscal_information/tax_information/form/save"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_information/tax_information/form/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Fiscal information to sending to api")
    }

    "/myml/fiscal_information/tax_information/form/save/response"(platform: "/", type: TrackType.Event) {
        callback_url(required: true, type: PropertyType.String, description: "Url to redirect")
        error(required: true, type: PropertyType.Boolean, description: "Has error on api?")
        data(required: true, description: "Fiscal information received from api")
    }

    // Tax information form page, modal price
    "/myml/fiscal_information/tax_information/modal_price"(platform: "/", type: TrackType.Event) {
        price(required: true, type: PropertyType.Numeric, description: "Item/Order price")
        form_percentages(required: true, type: PropertyType.ArrayList, description: "List products percentage on form")
        rounded_percentages(required: true, type: PropertyType.ArrayList, description: "List products percentage on rounded")
    }

    "/myml/fiscal_information/tax_information/modal_price/cancel"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_information/tax_information/modal_price/confirm"(platform: "/", type: TrackType.Event) {
        user_edited(required: true, type: PropertyType.Boolean, description: "User has edited prices?")
        user_rounded(required: true, type: PropertyType.Boolean, description: "User has rounded after change prices?")
    }

    // Tax information difference form page
    "/myml/fiscal_information/tax_information/difference"(platform: "/", type: TrackType.View) {}

    "/myml/fiscal_information/tax_information/difference/form"(platform: "/", isAbstract: true) {}
    "/myml/fiscal_information/tax_information/difference/form/save"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_information/tax_information/difference/form/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Fiscal information to sending to api")
    }

    "/myml/fiscal_information/tax_information/difference/form/save/response"(platform: "/", type: TrackType.Event) {
        callback_url(required: true, type: PropertyType.String, description: "Url to redirect")
        error(required: true, type: PropertyType.Boolean, description: "Has error on api?")
        data(required: true, description: "Fiscal information received from api")
    }

    // Tax information rejection form page
    "/myml/fiscal_information/tax_information/rejection"(platform: "/", type: TrackType.View) {}

    "/myml/fiscal_information/tax_information/rejection/form"(platform: "/", isAbstract: true) {}
    "/myml/fiscal_information/tax_information/rejection/form/save"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_information/tax_information/rejection/form/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Fiscal information to sending to api")
    }

    "/myml/fiscal_information/tax_information/rejection/form/save/response"(platform: "/", type: TrackType.Event) {
        callback_url(required: true, type: PropertyType.String, description: "Url to redirect")
        error(required: true, type: PropertyType.Boolean, description: "Has error on api?")
        data(required: true, description: "Fiscal information received from api")
    }

    // Tax information success page
    "/myml/fiscal_information/tax_information/success"(platform: "/", type: TrackType.View) {}

    "/myml/fiscal_information/tax_information/success/btn"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_information/tax_information/success/btn/listings"(platform: "/", type: TrackType.Event) {}

    // Tax substitution page
    "/myml/fiscal_information/tax_substitution"(platform: "/", type: TrackType.View) {
        query_sku(required: true, type: PropertyType.String, description: "Sku of tax information")
        query_item_id(required: true, type: PropertyType.String, description: "Meli item id")
        query_inbound_id(required: true, type: PropertyType.String, description: "Inbound id from panel")
    }

    "/myml/fiscal_information/tax_substitution/btn"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_information/tax_substitution/btn/backtoinbound"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_information/tax_substitution/form"(platform: "/", isAbstract: true) {}
    "/myml/fiscal_information/tax_substitution/form/save"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_information/tax_substitution/form/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Tax substitution to sending to api")
    }

    "/myml/fiscal_information/tax_substitution/form/save/response"(platform: "/", type: TrackType.Event) {
        error(required: true, type: PropertyType.Boolean, description: "Has error on api?")
        data(required: true, description: "Fiscal information received from api")
    }

    // Type page
    "/myml/fiscal_information/type"(platform: "/", type: TrackType.View) {
        url(required: true, type: PropertyType.String, description: "Page url")
        item_id(required: true, type: PropertyType.String, description: "Meli item id")
        order_id(required: false, type: PropertyType.String, description: "Meli order id")
        query_data(required: false, type: PropertyType.String, description: "Base64 code with order informations")
    }

    "/myml/fiscal_information/type/selection"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, values: ["single", "bundle"], description: "Type of fiscal information")
    }

    //:::: SELLER - INVOICES
    "/myml/invoices"(platform: "/", isAbstract: true) {}

    // Invoices Documents
    "/myml/invoices/documents"(platform: "/", isAbstract: true) {}
    "/myml/invoices/documents/mobile"(platform: "/", type: TrackType.View) {}
    "/myml/invoices/documents/not_found"(platform: "/", type: TrackType.View) {}

    // Message page
    "/myml/invoices/documents/message"(platform: "/", type: TrackType.View) {
        code(required: false, type: PropertyType.String, description: "Message code to display")
    }

    // Type page
    "/myml/invoices/documents/type"(platform: "/", type: TrackType.View) {}

    "/myml/invoices/documents/type/selection"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, values: ["nfe", "gnre"], description: "Type of download page")
    }

    // Success page
    "/myml/invoices/documents/success"(platform: "/", type: TrackType.View) {
        query_data(required: false, type: PropertyType.String, description: "Base64 code with zip informations")
    }

    "/myml/invoices/documents/success/btn"(platform: "/", isAbstract: true) {}
    "/myml/invoices/documents/success/btn/listings"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/documents/success/btn/download"(platform: "/", type: TrackType.Event) {}

    // GNRE page
    "/myml/invoices/documents/gnre"(platform: "/", type: TrackType.View) {
        start(required: false, type: PropertyType.String, description: "Date start")
        end(required: false, type: PropertyType.String, description: "Date end")
        printed(required: false, type: PropertyType.Boolean, description: "With last printed")
    }

    "/myml/invoices/documents/gnre/btn"(platform: "/", isAbstract: true) {}
    "/myml/invoices/documents/gnre/btn/export"(platform: "/", type: TrackType.Event) {
        start(required: true, type: PropertyType.String, description: "Date start")
        end(required: true, type: PropertyType.String, description: "Date end")
        printed(required: true, type: PropertyType.Boolean, description: "With last printed")
    }

    //:::: Sales list
    "/myml/invoices/sales_list"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sales_list/create_invoice"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/sales_list/zip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/sales_list/zip/download"(platform: "/", type: TrackType.Event) {
        pdf(required: true, type: PropertyType.Boolean, description: "Checkbox value to define if the user is requesting .pdf alongside with your invoice .xml file")
    }

    //:::: Optin flow
    "/myml/invoices/company-info"(platform: "/", isAbstract: true) {
        error(required: false, type:  PropertyType.String, description: "Error message that pop to user after request")
        errorValidation(required: false, type:  PropertyType.String, description: "Error message when value is invalid")
        url(required: false, type:  PropertyType.String, description: "Url to redirect after response")
        campaign(required: false, type: PropertyType.String, description: "Campaign description")
        campaign_source(required: false, type: PropertyType.String, description: "Campaign source")
    }

    "/myml/invoices/optin"(platform: "/", isAbstract: true) {}
    "/myml/invoices/optin/home"(platform: "/", type: TrackType.View) {
        seller_type(required: true,  values: ["PF", "PJ"], description: "Seller profile is PF or PJ")
    }

    // Tracking click - if seller profile needs go to previous page
    "/myml/invoices/optin/home/back_page"(platform: "/", type: TrackType.Event) {
        seller_type(required: true,  values: ["PF", "PJ"], description: "Seller profile is PF or PJ")
    }

    // Tracking click - if seller profile needs help
    "/myml/invoices/optin/home/needs_help"(platform: "/", type: TrackType.Event) {
        seller_type(required: true,  values: ["PF", "PJ"], description: "Seller profile is PF or PJ")
    }

    // Tracking click -  if seller profile needs change yours data
    "/myml/invoices/optin/home/modify_data"(platform: "/", type: TrackType.Event) {
        seller_type(required: true,  values: ["PF", "PJ"], description: "Seller profile is PF or PJ")
    }

    // Tracking click - if seller profile accept use biller (facturador)
    "/myml/invoices/optin/home/enabled_for_biller"(platform: "/", type: TrackType.Event) {
        seller_type(required: true,  values: ["PF", "PJ"], description: "Seller profile is PF or PJ")
    }

    //not found
    "/myml/invoices/not-found"(platform: "/") {}

    //landing
    "/myml/invoices/landing"(platform: "/") {}
    "/myml/invoices/landing/optin"(platform: "/", type: TrackType.Event) {
        type (required: true, values: ["top", "bottom"], description: "Top or bottom button")
    }

    //certificate
    "/myml/invoices/company-info/certificate"(platform: "/") {}
    "/myml/invoices/company-info/certificate/help_tooltip"(platform: "/", type: TrackType.Event) {}

    "/myml/invoices/company-info/certificate/a1"(platform: "/") {
        campaign(required: false, type: PropertyType.String, description: "Campaign description")
        campaign_source(required: false, type: PropertyType.String, description: "Campaign source")
    }
    "/myml/invoices/company-info/certificate/a1/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/certificate/a1/installer_download"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/certificate/a1/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/certificate/a1/save/request"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/certificate/a1/save/response"(platform: "/", type: TrackType.Event) {
        error(required: false, description: "Error type when user uploads an A1 digital certificate")
        message(required: false, description: "Description of error when user uploads an A1 digital certificate")
        url(required: false, type:  PropertyType.String, description: "Url to redirect after response")
        certificateFrom(required: false, type:  PropertyType.String, description: "Certificate type that the seller had before uploading")
        certificateTo(required: false, type:  PropertyType.String, description: "Certificate type uploaded by seller")
        campaign(required: false, type: PropertyType.String, description: "Campaign description")
        campaign_source(required: false, type: PropertyType.String, description: "Campaign source")
    }

    "/myml/invoices/company-info/certificate/a3"(platform: "/") {}
    "/myml/invoices/company-info/certificate/a3/handshake"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/certificate/a3/handshake/request"(platform: "/", type: TrackType.Event) {
        cnpj(required: true, type: PropertyType.String, description: "Company doc number")
        certificateId(required: true, type: PropertyType.Numeric, description: "Certificate ID")
        callback(required: true, type:  PropertyType.String, description: "Url to redirect after response")
        editing(required: true, type: PropertyType.Boolean, description: "Parameter to allow user to modify information on the page")
    }
    "/myml/invoices/company-info/certificate/a3/handshake/response"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "A3 certificate Handshake event infos")
    }

    //serie
    "/myml/invoices/company-info/serie"(platform: "/") {}
    "/myml/invoices/company-info/serie/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/serie/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/serie/save/request"(platform: "/", type: TrackType.Event) {
        serie(required: true, description: "Serie number input and url to redirect")
        callback(required: true, type:  PropertyType.String, description: "Url to redirect after response")
        editing(required: true, type: PropertyType.Boolean, description: "Parameter to allow user to modify information on the page")
        url(required: true, type:  PropertyType.String, description: "Url to redirect after response")
    }
    "/myml/invoices/company-info/serie/save/response"(platform: "/", type: TrackType.Event) {
      url(required: true, type:  PropertyType.String, description: "Url to redirect after response")
    }

    //export nfe
    "/myml/invoices/company-info/zip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/zip/download"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/zip/download/response"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/zip/download/request"(platform: "/", type: TrackType.Event) {
        pdf(required: true, type: PropertyType.Boolean, description: "Value to indicate if the user is requesting .pdf alongside with your invoice .xml file")
        month(required: true, type: PropertyType.Numeric, description: "Which month user is requesting your invoice xml file")
        year(required: true, type: PropertyType.Numeric, description: "Which year user is requesting your invoice xml file")
    }

    //cst
    "/myml/invoices/company-info/cst"(platform: "/") {}
    "/myml/invoices/company-info/cst/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/cst/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/cst/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Tax information of selected fields")
        callback(required: true, type:  PropertyType.String, description: "Url to redirect after response")
        editing(required: true, type: PropertyType.Boolean, description: "Parameter to allow user to modify information on the page")
        url(required: true, type:  PropertyType.String, description: "Url to redirect after response")
    }
    "/myml/invoices/company-info/cst/save/response"(platform: "/", type: TrackType.Event) {}

    //csosn
    "/myml/invoices/company-info/csosn"(platform: "/") {}
    "/myml/invoices/company-info/csosn/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/csosn/save"(platform: "/", isAbstract: true) {
        code(required: true, type: PropertyType.String, description: "Icms code id (tax information) input")
    }
    "/myml/invoices/company-info/csosn/save/request"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/csosn/save/response"(platform: "/", type: TrackType.Event) {}

    //ie
    "/myml/invoices/company-info/ie"(platform: "/") {}
    "/myml/invoices/company-info/ie/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/ie/save/request"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/ie/save/response"(platform: "/", type: TrackType.Event) {
        error(required: false, type: PropertyType.Boolean, description: "State registration saving error")
    }
    //confirm
    "/myml/invoices/company-info/confirm"(platform: "/") {
        campaign(required: false, type: PropertyType.String, description: "Campaign description")
        campaign_source(required: false, type: PropertyType.String, description: "Campaign source")
    }
    "/myml/invoices/company-info/confirm/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/confirm/save/request"(platform: "/", type: TrackType.Event) {
        enabled_for_fulfillment(required: true, type:  PropertyType.Boolean, description: "Boolean if seller profile is fulfillment")
        tax_payer_type(required: true, type:  PropertyType.String, description: "Tax payer type seller info")
        certificate_type(required: true, type:  PropertyType.String, description: "Certificate type that seller is using on optin")
    }
    "/myml/invoices/company-info/confirm/save/response"(platform: "/", type: TrackType.Event) {
        error(required: false, type:  PropertyType.String, description: "Error message that pop to user after request")
        url(required: false, type:  PropertyType.String, description: "Url to redirect after response")
    }
    "/myml/invoices/company-info/confirm/help_tooltip"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/confirm/help_tooltip/serie"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/confirm/help_tooltip/freight"(platform: "/", type: TrackType.Event) {}

    //confirm-normal
    "/myml/invoices/company-info/confirm-normal"(platform: "/") {
        campaign(required: false, type: PropertyType.String, description: "Campaign description")
        campaign_source(required: false, type: PropertyType.String, description: "Campaign source")
    }
    "/myml/invoices/company-info/confirm-normal/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/confirm-normal/save/request"(platform: "/", type: TrackType.Event) {
        serie(required: true, type:  PropertyType.Numeric, description: "Invoice serie number input")
        include_freight(required: true, type:  PropertyType.Boolean, description: "Include freight option for sellers")
        url(required: true, type:  PropertyType.String, description: "Url from the page that made the request")
        callback(required: true, type:  PropertyType.String, description: "Url to redirect after response")
    }
    "/myml/invoices/company-info/confirm-normal/save/response"(platform: "/", type: TrackType.Event) {
        message(required: false, type:  PropertyType.String, description: "Error message that pop to user after request")
    }
    "/myml/invoices/company-info/confirm-normal/help_tooltip"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/confirm-normal/help_tooltip/freight"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/confirm-normal/help_tooltip/serie"(platform: "/", type: TrackType.Event) {}

    "/myml/invoices/company-info/success"(platform: "/") {}

    "/myml/invoices/company-info/include-freight"(platform: "/") {}
    "/myml/invoices/company-info/include-freight/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/include-freight/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/include-freight/save/request"(platform: "/", type: TrackType.Event) {
        code(required: true, type:  PropertyType.String, description: "Boolean with user preference to include freight")
        url(required: true, type: PropertyType.String, description: "Redirect url value before save")
        callback(required: true, type: PropertyType.String, description: "Redirect url after save")
        editing(required: true, type: PropertyType.Boolean, description: "Parameter to allow user to modify information on the page")
    }
    "/myml/invoices/company-info/include-freight/save/response"(platform: "/", type: TrackType.Event) {
        redirect_url(required: false, type: PropertyType.String, description: "Redirect url after save on success")
        success(required: true, type: PropertyType.Boolean, description: "Boolean if request was success or not ")
        message(required: false, type: PropertyType.String, description: "Error message that pops on page on error")
    }
    "/myml/invoices/company-info/success"(platform: "/") {}

    //tax-rules-information
    "/myml/invoices/company-info/tax-rules-information"(platform: "/") {}

    //emission-validation/success
    "/myml/invoices/company-info/emission-validation"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/emission-validation/success"(platform: "/") {
        emission_validation_status(required: true, PropertyType.String, description: "Success status of the emission validation" )
    }

    //emission-validation/error
    "/myml/invoices/company-info/emission-validation/error"(platform: "/") {
        emission_validation_status(required: true, PropertyType.String, description: "Error status of the emission validation" )
    }

    //:::: Order
    "/myml/invoices/order"(platform: "/", isAbstract: true) {
        error(required: false, type:  PropertyType.String, description: "Error message that pop to user after request")
        error_validation(required: false, type:  PropertyType.String, description: "Error message when value is invalid")
        url(required: false, type:  PropertyType.String, description: "Url to redirect after response")
    }

    //devolution
    "/myml/invoices/order/devolution"(platform: "/") {}
    "/myml/invoices/order/devolution/confirm"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/order/devolution/success"(platform: "/", type: TrackType.Event) {
        devolution_type(require: true, type: PropertyType.String, description: "Successfully issues a devolution NF-e.")
    }

    //buyer
    "/myml/invoices/order/buyer-info"(platform: "/") {}
    "/myml/invoices/order/buyer-info/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/order/buyer-info/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Form values, receiver adress info, User billing info, order status")
    }
    "/myml/invoices/order/buyer-info/save/response"(platform: "/", type: TrackType.Event) {}

    //carrier
    "/myml/invoices/order/carrier"(platform: "/") {}
    "/myml/invoices/order/carrier/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/order/carrier/save/request"(platform: "/", type: TrackType.Event) {
      data(required: true, description: "Form values, buyer, transport company, quantiy and value that user inputs")
    }
    "/myml/invoices/order/carrier/save/response"(platform: "/", type: TrackType.Event) {}
    "/myml/sales/list/set_user_fiscal_order_action"(platform: "/web", type: TrackType.Event) {
        option(required: true, type: PropertyType.String, description: "Radio button value to set invoice preferences")
    }

    //V2 sku pages
    "/myml/invoices/sku"(platform: "/", isAbstract: true) {}

    "/myml/invoices/sku/sku"(platform: "/") {}
    "/myml/invoices/sku/sku/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sku/sku/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "MLB itemId")
        kit(required: true, type: PropertyType.Boolean, description: "Boolean if sku is a kit")
        redirect_to(required: true, type: PropertyType.String, description: "Redirect url value before save")
        variation_id(required: false, type: PropertyType.String, description: "variationId of item | null")
        sku(required: true, type: PropertyType.String, description: "Sku id value")
    }
    "/myml/invoices/sku/sku/save/response"(platform: "/", type: TrackType.Event) {
        redirect_to(required: false, type: PropertyType.String, description: "Redirect url after save")
        success(required: false, type: PropertyType.Boolean, description: "Boolean if request was success")
        message(required: false, type: PropertyType.String, description: "Error message that pops on page")
        sku_invalid(required: false, type: PropertyType.Boolean, description: "Boolean if sku value is invalid")
    }

    "/myml/invoices/sku/ean"(platform: "/") {}
    "/myml/invoices/sku/ean/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sku/ean/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "MLB itemId")
        redirect_to(required: true, type: PropertyType.String, description: "Redirect url value before save")
        variation_id(required: false, type: PropertyType.String, description: "variationId of item | null")
        ean(required: true, type: PropertyType.String, description: "Ean(europen article code) of item")
    }
    "/myml/invoices/sku/ean/save/response"(platform: "/", type: TrackType.Event) {
        redirect_to(required: false, type: PropertyType.String, description: "Redirect url after save")
        success(required: false, type: PropertyType.Boolean, description: "Boolean if request was success")
        message(required: false, type: PropertyType.String, description: "Error message that pops on page")
        ean_invalid(required: false, type: PropertyType.Boolean, description: "Boolean if ean value is invalid")
    }

    "/myml/invoices/sku/ncm"(platform: "/") {}
    "/myml/invoices/sku/ncm/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sku/ncm/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "MLB itemId")
        redirect_to(required: true, type: PropertyType.String, description: "Redirect url value before save")
        variation_id(required: false, type: PropertyType.String, description: "variationId of item | null")
        ncm(required: true, type: PropertyType.String, description: "Ncm (tax information) of item")
    }
    "/myml/invoices/sku/ncm/save/response"(platform: "/", type: TrackType.Event) {
        redirect_to(required: false, type: PropertyType.String, description: "Redirect url after save")
        success(required: false, type: PropertyType.Boolean, description: "Boolean if request was success")
        message(required: false, type: PropertyType.String, description: "Error message that pops on page")
    }

    "/myml/invoices/sku/product-origin"(platform: "/") {}
    "/myml/invoices/sku/product-origin/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sku/product-origin/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "MLB itemId")
        code(required: true, type: PropertyType.String, description: "item origin code")
        redirect_to(required: true, type: PropertyType.String, description: "Redirect url value before save")
        origin_discrimination(required: true, type: PropertyType.String, description: "item origin code description")
        variation_id(required: false, type: PropertyType.String, description: "variationId of item | null")
    }
    "/myml/invoices/sku/product-origin/save/response"(platform: "/", type: TrackType.Event) {
        redirect_to(required: false, type: PropertyType.String, description: "Redirect url after save")
        success(required: false, type: PropertyType.Boolean, description: "Boolean if request was success")
        message(required: false, type: PropertyType.String, description: "Error message that pops on page")
    }

    "/myml/invoices/sku/product-type"(platform: "/") {}
    "/myml/invoices/sku/product-type/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sku/product-type/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "MLB itemId")
        code(required: true, type: PropertyType.String, description: "item type code")
        redirect_to(required: true, type: PropertyType.String, description: "Redirect url value before save")
        variation_id(required: false, type: PropertyType.String, description: "variationId of item | null")
    }
    "/myml/invoices/sku/product-type/save/response"(platform: "/", type: TrackType.Event) {
        redirect_to(required: false, type: PropertyType.String, description: "Redirect url after save")
        success(required: false, type: PropertyType.Boolean, description: "Boolean if request was success")
        message(required: false, type: PropertyType.String, description: "Error message that pops on page")
    }

    "/myml/invoices/sku/csosn"(platform: "/") {}
    "/myml/invoices/sku/csosn/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sku/csosn/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "MLB itemId")
        csosn(required: true, type: PropertyType.String, description: "item tax information code")
        redirect_to(required: true, type: PropertyType.String, description: "Redirect url value before save")
        variation_id(required: false, type: PropertyType.String, description: "variationId of item | null")
    }
    "/myml/invoices/sku/csosn/save/response"(platform: "/", type: TrackType.Event) {
        redirect_to(required: false, type: PropertyType.String, description: "Redirect url after save")
        success(required: false, type: PropertyType.Boolean, description: "Boolean if request was success")
        message(required: false, type: PropertyType.String, description: "Error message that pops on page")
    }

    "/myml/invoices/sku/review"(platform: "/") {}
    "/myml/invoices/sku/review/confirm"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sku/review/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/sku/review/confirm/request"(platform: "/", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.String, description: "MLB orderId")
        comments(required: true, type: PropertyType.String, description: "Commentaries added on review page")
    }
    "/myml/invoices/sku/review/confirm/response"(platform: "/", type: TrackType.Event) {
        redirect_to(required: false, type: PropertyType.String, description: "Redirect url after save")
        error_type(required: false, type: PropertyType.String, description: "Type of error")
        error(required: false, type: PropertyType.Boolean, description: "Boolean if request was error")
        message(required: false, type: PropertyType.String, description: "Error message that pops on page")
    }

    "/myml/invoices/error"(platform: "/") {
        error(required: true, type: PropertyType.String, values:[
            "not_legal_entity",
            "not_valid_address",
            "not_tax_regime_allowed",
            "not_right_tax_regime",
            "not_cnpj_user",
            "not_order_owner",
            "is_not_admin",
        ], description: "Error code")
    }

    "/myml/invoices/sku/status"(platform: "/") {}

    "/myml/invoices/sku/detail"(platform: "/") {}
    "/myml/invoices/sku/processing"(platform: "/") {}
    "/myml/invoices/sku/disabled"(platform: "/") {}
    "/myml/invoices/sku/detail/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, values:[
            "print_danfe",
            "download_xml",
            "cancel_nfe",
            "create_correction_letter",
            "create_devolution_invoice",
        ], description: "Wich action triggered by the user")
    }

    //Backoffice pages
    "/myml/invoices/backoffice"(platform: "/", isAbstract: true) {}

    "/myml/invoices/backoffice/search"(platform: "/", isAbstract: true) {}

    "/myml/invoices/backoffice/search/invoice"(platform: "/", type: TrackType.Event) {
        searchType(required: true, type: PropertyType.String, description: "Invoice searched by")
        searchValue(required: true, type: PropertyType.String, description: "Value inputed related searchType in Invoice Search")
    }

    "/myml/invoices/backoffice/search/reissueinvoice"(platform: "/", type: TrackType.Event) {
        invoiceId(required: true, type: PropertyType.String, description: "Invoice Id")
        orderIds(required: true, type: PropertyType.String, description: "Invoice order Ids")
        userId(required: true, type: PropertyType.String, description: "Id of the invoice issuer")
        reason(required: true, type: PropertyType.String, description: "Invoice reprocess reason")
        detailedReason(required: false, type: PropertyType.String, description: "Detailed reason for invoice reprocessing")
    }

    "/myml/invoices/backoffice/search/disableinvoice"(platform: "/", type: TrackType.Event) {
        invoiceId(required: true, type: PropertyType.String, description: "Invoice Id")
        userId(required: true, type: PropertyType.String, description: "Id of the invoice issuer")
        reason(required: true, type: PropertyType.String, description: "Invoice disabling reason")
        detailedReason(required: false, type: PropertyType.String, description: "Detailed reason for invoice disabling")
    }

    "/myml/invoices/backoffice/search/invoiceslist"(platform: "/", type: TrackType.Event) {
        invoiceId(required: false, type: PropertyType.String, description: "Massive invoice search by id")
        orderId(required: false, type: PropertyType.String, description: "Massive invoice search by order id")
        status(required: false, type: PropertyType.String, description: "Massive invoice search by status id")
        inboundId(required: false, type: PropertyType.String, description: "Massive invoice search by inbound id")
        shipmentId(required: false, type: PropertyType.String, description: "Massive invoice search by shipment id")
        shipmentLogisticType(required: false, type: PropertyType.String, description: "Massive invoice search by shipment logistic type")
        offset(required: false, type: PropertyType.String, description: "Massive invoice search by offset")
        limit(required: false, type: PropertyType.String, description: "Massive invoice search by limit")
        invoiceCreationDateFrom(required: false, type: PropertyType.String, description: "Massive invoice search by invoice creation date from")
        invoiceCreationDateTo(required: false, type: PropertyType.String, description: "Massive invoice search by invoice creation date to")
        invoiceNumber(required: false, type: PropertyType.String, description: "Massive invoice search by invoice number")
        invoiceNumberTo(required: false, type: PropertyType.String, description: "Massive invoice search by invoice number to")
        invoiceNumberFrom(required: false, type: PropertyType.String, description: "Massive invoice search by invoice number from")
        recipientCnpj(required: false, type: PropertyType.String, description: "Massive invoice search by recipient cnpj")
        recipientCpf(required: false, type: PropertyType.String, description: "Massive invoice search by recipient cpf")
        recipientName(required: false, type: PropertyType.String, description: "Massive invoice search by recipient name")
        recipientUf(required: false, type: PropertyType.String, description: "Massive invoice search by recipient uf")
        invoiceSerie(required: false, type: PropertyType.String, description: "Massive invoice search by invoice serie")
        userId(required: false, type: PropertyType.String, description: "Massive invoice search by user id")
        issuerCnpj(required: false, type: PropertyType.String, description: "Massive invoice search by issuer cnpj")
        issuerUf(required: false, type: PropertyType.String, description: "Massive invoice search by issuer uf")
        taxRuleId(required: false, type: PropertyType.String, description: "Massive invoice search by issuer tax rule id")
        nickname(required: false, type: PropertyType.String, description: "Massive invoice search by nickname")
        email(required: false, type: PropertyType.String, description: "Massive invoice search by email")
        transactionType(required: false, type: PropertyType.String, description: "Massive invoice search by transaction type")
        externalProductId(required: false, type: PropertyType.String, description: "Massive invoice search by external product id")
    }

    "/myml/invoices/backoffice/search/invoiceslist/export_csv"(platform: "/", type: TrackType.Event) {
        seller_id(required: false, type: PropertyType.String, description: "Seller id used to generate csv")
        status(required: false, type: PropertyType.String, description: "Invoice status used to generate csv")
        environment(required: false, type: PropertyType.String, description: "Which environment was selected to generate csv")
        external_order_id(required: false, type: PropertyType.String, description: "Order id used to generate csv")
        series(required: false, type: PropertyType.String, description: "Invoice series used to generate csv")
        invoice_number(required: false, type: PropertyType.String, description: "Invoice number used to generate csv")
        issuer_cnpj(required: false, type: PropertyType.String, description: "Issuer cnpj used to generate csv")
        shipment_logistic_type(required: false, type: PropertyType.String, description: "Logistic type used to generate csv")
        shipment_fiscal_model(required: false, type: PropertyType.String, description: "Fiscal model used to generate csv")
        recipient_cnpj(required: false, type: PropertyType.String, description: "Recipient cnpj used to generate csv")
        invoice_creation_date_from(required: false, type: PropertyType.String, description: "Invoice creation date used to generate csv")
        invoice_creation_date_to(required: false, type: PropertyType.String, description: "Invoice creation date to used to generate csv")
        invoice_id(required: false, type: PropertyType.String, description: "Invoice id used to generate csv")
        invoice_key(required: false, type: PropertyType.String, description: "Invoice key used to generate csv")
        shipment_id(required: false, type: PropertyType.String, description: "Shipment id used to generate csv")
        invoice_number_from(required: false, type: PropertyType.String, description: "Invoice number from used to generate csv")
        invoice_number_to(required: false, type: PropertyType.String, description: "Invoice number to used to generate csv")
        tax_rule_id(required: false, type: PropertyType.String, description: "Tax rule id used to generate csv")
        transaction_type(required: false, type: PropertyType.String, description: "Transaction type used to generate csv")
        external_product_id(required: false, type: PropertyType.String, description: "Item id used to generate csv")
        issuer_address_state(required: false, type: PropertyType.String, description: "Issuer state address used to generate csv")
        recipient_cpf(required: false, type: PropertyType.String, description: "Recipient cpf used to generate csv")
        recipient_id(required: false, type: PropertyType.String, description: "Recipient id used to generate csv")
        recipient_name(required: false, type: PropertyType.String, description: "Recipient name used to generate csv")
        recipient_address_state(required: false, type: PropertyType.String, description: "Recipient state address used to generate csv")
        with_items(required: false, type: PropertyType.String, description: "Should consider items to generate csv")
        sort(required: false, type: PropertyType.String, description: "Sorting used to generate csv")
        limit(required: false, type: PropertyType.String, description: "Limit of pages used to generate csv")
        offset(required: false, type: PropertyType.String, description: "Offset used to generate csv")
        transaction_status(required: false, type: PropertyType.String, description: "Invoice transaction status used to generate csv")
    }

    "/myml/invoices/backoffice/view"(platform: "/", isAbstract: true) {}

    "/myml/invoices/backoffice/view/invoiceslist"(platform: "/") {}


    //Opt-in pages

    "/myml/invoices/opt_in"(platform: "/", isAbstract: true) {}

    "/myml/invoices/opt_in/difal"(platform: "/") {}

    "/myml/invoices/opt_in/difal/button"(platform: "/", isAbstract: true) {}
    "/myml/invoices/opt_in/difal/button/save"(platform: "/") {}

    // rule composition
    "/myml/invoices/opt_in"(platform: "/", isAbstract: true) {}
    "/myml/invoices/opt_in/rule-composition"(platform: "/") {}

    "/myml/invoices/opt_in/rule-composition/button"(platform: "/", isAbstract: true) {}
    "/myml/invoices/opt_in/rule-composition/button/save"(platform: "/") {}

    // cst nfe devolution
    "/myml/invoices/opt_in"(platform: "/", isAbstract: true) {}
    "/myml/invoices/opt_in/cst-devolution"(platform: "/") {}

    "/myml/invoices/opt_in/cst-devolution/button"(platform: "/", isAbstract: true) {}
    "/myml/invoices/opt_in/cst-devolution/button/save"(platform: "/") {}


    //:::: SELLER - INVOICES

    "/myml/buy_it_again"(platform: "/mobile") {}

    "/myml/account_security"(platform: "/mobile") {}

    "/myml/activity"(platform: "/mobile") {}

    "/myml/activity/list"(platform: "/mobile") {}

    "/myml/bookmarks"(platform: "/mobile") {}

    "/myml/bookmarks/list"(platform: "/mobile") {}

    "/myml/portal_ayuda"(platform: "/mobile") {}

    "/myml/myreputation"(platform: "/mobile") {}

    "/myml/settings"(platform: "/mobile", type: TrackType.View) {}

    "/myml/message"(platform: "/mobile") {}

    "/myml/message/activity"(platform:"/mobile", type: TrackType.View) {}

    "/myml/message/questions"(platform: "/mobile", type: TrackType.View) {}

    "/myml/message/pack_detail"(platform:"/mobile", type: TrackType.View) {}

    "/myml/message/attachments_uploader"(platform:"/mobile", type: TrackType.View) {}

    "/myml/message/attachment_viewer"(platform:"/mobile/ios", type: TrackType.View) {}

    //Fiscal Rules Page

    "/myml/fiscal_rules"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/message"(platform: "/", type: TrackType.View){
        code(required: true, type: PropertyType.Numeric, description: "Code of return message")
    }

    "/myml/fiscal_rules/listing"(platform: "/", type: TrackType.View) {
        page(required: true, type: PropertyType.Numeric, description: "Current Page")
        per_page(required: true, type: PropertyType.Numeric, description: "Amount per page")
        selected(required: true, type: PropertyType.String, description: "Base64 of ids list")
    }

    "/myml/fiscal_rules/listing/button"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/listing/button/new_rules"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/listing/button/edit_rules"(platform: "/", type: TrackType.Event) {
        ids(required: true, type: PropertyType.String, description: "Ids of list for update rules")
    }

    "/myml/fiscal_rules/listing/button/remove_rules"(platform: "/", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Id for remove rules")
    }

    "/myml/fiscal_rules/listing/checkbox"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/listing/checkbox/header"(platform: "/", type: TrackType.Event) {
        status(required: true, type: PropertyType.Boolean, description: "Status of checkbox on header")
    }

    "/myml/fiscal_rules/listing/checkbox/list"(platform: "/", type: TrackType.Event) {
        status(required: true, type: PropertyType.Boolean, description: "Status of checkbox on list")
        id(required: true, type: PropertyType.Numeric, description: "Id of rule")
    }

    "/myml/fiscal_rules/listing/modal"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/listing/modal/confirm"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/listing/modal/cancel"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/listing/pagination"(platform: "/", type: TrackType.Event) {
        current_page(required: true, type: PropertyType.Numeric , description: "Current page")
        next_page(required: true, type: PropertyType.Numeric , description: "Next page")
        amount(required: true, type: PropertyType.Numeric , description: "Amount per page")
    }

    // Massive Page

    "/myml/fiscal_rules/massive"(platform: "/", type: TrackType.View) {
        callback(required: true, type: PropertyType.String, description: "Callback URL")
        action(required: true, type: PropertyType.String, description: "Action of sheets")
        selected(required: true, type: PropertyType.String, description: "Ids selected")
    }

    "/myml/fiscal_rules/massive/button"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/massive/button/download"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Action type of download")
        selected(required: true, type: PropertyType.String, description: "Ids of download")
    }

    "/myml/fiscal_rules/massive/button/upload"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/modal"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/download"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/massive/download/helper"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/download/button"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/massive/download/button/start"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/download/action"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/massive/download/action/primary"(platform: "/", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Link of button primary")
    }

    "/myml/fiscal_rules/massive/download/action/secondary"(platform: "/", type: TrackType.Event) {
        link(required: true, type: PropertyType.String, description: "Link of button secondary")
    }

    "/myml/fiscal_rules/massive/upload"(platform: "/", type: TrackType.View) {}

    "/myml/fiscal_rules/massive/upload/modal"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/status"(platform: "/", type: TrackType.View) {
        status(required: true, type: PropertyType.String, description: "Status of upload")
    }

    "/myml/fiscal_rules/massive/upload/status/helpers"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/action"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/massive/upload/action/upload"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/action/edit"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/action/advanced_tax_settings"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/action/download"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/actions"(platform: "/", isAbstract: true) {}

    "/myml/fiscal_rules/massive/upload/actions/helper"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/button"(platform: "/", isAbstract: true) {}
    
    "/myml/fiscal_rules/massive/upload/button/start"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/button/remove"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/upload/button/uplater"(platform: "/", type: TrackType.Event) {}

    "/myml/fiscal_rules/massive/wizard"(platform: "/", type: TrackType.Event) {
        show(required: true, type: PropertyType.Boolean, description: "Visible or hidden")
        times(required: true, type: PropertyType.Numeric, description: "Quantity of view")
    }

    //TRACKS MYML Search Bookmarks Alerts
    "/myml/search_alerts"(type: TrackType.View, isAbstract: true) {}
    "/myml/search_alerts/list"(platform: "/", type: TrackType.View) {
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of search alerts")
    }

    //TRACKS MYML MYContact Section
    "/myml/mycontact" (type: TrackType.View, isAbstract: true) {}
    "/myml/mycontact/main" (type: TrackType.View) {}
}
