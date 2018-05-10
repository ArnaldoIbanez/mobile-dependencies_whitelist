import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    propertyDefinitions {
	    cartContent(required:false, type: PropertyType.Boolean)
	    status(required:false, type: PropertyType.String)

	    seller(required: false, type:PropertyType.ArrayList, description: "Array of sellers with their data")
	    //id
	    //nickname
	    //mercado_lider
	    //reputation_level

	    buyer(required: false, type:PropertyType.ArrayList, description: "Array of buyers with their data")
	    //id
	    //nickname
	    //loyalty_level
    }

    propertyGroups {
        mymlGroup(cartContent, status, seller, buyer)
    }


    "/myml/sales"(platform: "/", isAbstract: true) {
        mymlGroup
    }

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

    "/myml/sales/shipping_detail"(platform: "/") {}

    "/myml/sales/messages"(platform: "/") {}

    "/myml/sales/questions"(platform: "/") {}

    "/myml/purchases"(platform: "/", isAbstract: true) {
    	mymlGroup
    }

    "/myml/purchases/list"(platform: "/") {
        return_available(required: false, type: PropertyType.String, values: ["Yes", "No"], description: "Indicates if there is at least one item that has free return")
    }

    "/myml/purchases/detail"(platform: "/") {}

    "/myml/purchases/detail/delete_purchase"(platform: "/", type: TrackType.Event) {}

    "/myml/purchases/detail/what_do_if_i_pay"(platform: "/", type: TrackType.Event) {}

    "/myml/purchases/detail/call_to_carrier"(platform: "/", type: TrackType.Event) {
    	carrier(required:false, type: PropertyType.String)
    }

    "/myml/purchases/print_label"(platform: "/") {}

    "/myml/purchases/print_label/show_stores_map"(platform: "/", type: TrackType.Event) {}

    "/myml/purchases/shipping_detail"(platform: "/") {}

    "/myml/purchases/shipping_detail/refund_details"(platform: "/", type: TrackType.Event) {}

    "/myml/purchases/messages"(platform: "/") {}

    "/myml/purchases/questions"(platform: "/") {}

    "/myml/purchases/canceled"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/order"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/detail/history"(platform:"/", type: TrackType.View) {}

    "/myml/purchases/feedback"(platform: "/mobile", isAbstract: true) {}

    "/myml/purchases/feedback/rating"(platform: "/mobile", type: TrackType.View) {}

    "/myml/purchases/feedback/message"(platform: "/mobile", type: TrackType.View) {}

    "/myml/purchases/feedback/congrats"(platform: "/mobile", type: TrackType.View) {}

    "/myml/purchases/feedback/congrats#action"(platform: "/mobile", type: TrackType.Event) {
    	target(required: true, type: PropertyType.String)
    }

    "/myml/purchases/feedback/error"(platform: "/mobile", type: TrackType.View) {}


    "/myml"(platform: "/", isAbstract: true) {}
    "/myml/listings"(platform: "/web", type: TrackType.View) {
        label(required: true, description: "Selected label: active/closed/paused/...")
    }

    "/myml/bookmarks"(platform: "/web", type: TrackType.View) {}
    "/myml/questions"(platform: "/web", type: TrackType.View) {}

    "/myml/summary"(platform: "/web", type: TrackType.View) {}

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
        mp_installed(required: true, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/send_money"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: true, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/cellphone_recharge"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: true, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/bill_payments"(platform: "/mobile", type: TrackType.Event) {
        mp_installed(required: true, type:  PropertyType.Boolean, description: "true if MP is installed")
    }
    "/myml/account_balance/generic_error"(platform: "/mobile", type: TrackType.View) {
        additional_info (required:false, description: "Extra info")
    }
    "/myml/account_balance/scan_qr"(platform: "/mobile", type: TrackType.View) {}

    "/myml/account_balance/install"(platform: "/mobile", type: TrackType.View) {}
    "/myml/account_balance/install/go_to_store"(platform: "/mobile", type: TrackType.Event) {}

    "/myml/sales"(platform: "/mobile", isAbstract: true) {}
    "/myml/sales/detail"(platform: "/mobile", isAbstract: true) {}
    "/myml/sales/detail/flow_selector"(platform: "/mobile", type: TrackType.View) {
        flow_selected(required: true, type: PropertyType.String, description: "use case selected based on incoming parameters")
    }
    "/myml/sales/detail/deliver_product"(platform: "/mobile", type: TrackType.View) {}
    "/myml/sales/detail/deliver_product#submit"(platform: "/mobile", type: TrackType.Event) {
        action_label(required: true, type: PropertyType.String, description: "action selected when submitting: send_feedback or update shipping")
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



    // Eventos relacionados al item
    "/item"(platform: "/", isAbstract: true) {
        item_id(required: true, description: "Item id")
    }

    "/item/update"(platform: "/", type: TrackType.Event) {

    }

    "/item/create"(platform: "/", type: TrackType.Event) {
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: true, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: true, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: true, description: "Item condition: used/new/not_specified")
        price(required: true, description: "Item price")
        category_id(required: true, description: "Item category_id")

        // Category sugestion
        suggested_category_id(required: false, description: "Category id suggested")
        suggested_category_is_leaf(required: false, type: PropertyType.Boolean, description: "The category suggested is leaf")
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
        condition(required: true, description: "Item condition: used/new/not_specified")
        price(required: true, description: "Item price")
        parent_id(required: false, description: "Parent item listing type id")
        parent_listing_type_id(required: false, description: "Parent item listing type id")
        change_listing_type(required: false, description: "If the listing type changed compare to its parent. Values: upgrade/no_change/downgrade")
        source(required: false, description: "Relist flow that was used to relist the item")
    }

    "/myml/profile"(platform: "/mobile", type: TrackType.View) {}
    "/myml/profile/review_data"(platform: "/mobile", type: TrackType.View) {}
    "/myml/profile/complete_data"(platform: "/mobile", type: TrackType.View) {}
    "/myml/profile/update_form"(platform: "/mobile", type: TrackType.View) {
        has_inferred_data(required:true, type: PropertyType.Boolean)
    }
    "/myml/profile/update_success"(platform: "/mobile", type: TrackType.View) {}
    "/myml/profile/review_data/confirm"(platform: "/mobile", type: TrackType.Event) {}
    "/myml/company_profile"(platform: "/mobile", type: TrackType.View){}
    "/myml/fiscal_data_edit"(platform: "/mobile", type:TrackType.View){}

    // Loyalty discounts. May need to add parentPropertiesInherited: false property
    "/myml/loyal_discounts" (platform: "/", type: TrackType.View) {}
    "/myml/loyal_discounts/add" (platform: "/web", type: TrackType.Event) {
        item (required: true)
        percentage (required: true)
        type (required: true, values: ["LOW_LOYAL", "HIGH_LOYAL"])
    }
    "/myml/loyal_discounts/delete" (platform: "/", type: TrackType.Event) {
        item_id (required: true)
        type (required: true, values: ["LOW_LOYAL", "HIGH_LOYAL"])
    }

    //:::: MYML - INVOICES
    "/myml/invoices"(platform: "/", isAbstract: true) {}

    //:::: Create Invoice flow items
    "/myml/invoices/items"(platform: "/", isAbstract: true) {
        error(required: false, type:  PropertyType.String, description: "Error message that pop to user after request")
        errorValidation(required: false, type:  PropertyType.String, description: "Error message when value is invalid")
        url(required: false, type:  PropertyType.String, description: "Url to redirect after response")
    }

    //review
    "/myml/invoices/review"(platform: "/") {}
    "/myml/invoices/review/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/review/create_invoice"(platform: "/", type: TrackType.Event) {}
    
    "/myml/invoices/items/review"(platform: "/") {}
    "/myml/invoices/items/review/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/items/review/save/request"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/review/save/response"(platform: "/", type: TrackType.Event) {}
    
    //origin
    "/myml/invoices/items/origin"(platform: "/") {}
    "/myml/invoices/items/origin/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/origin/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/items/origin/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Product Origin type and aditional infos")
        item_id(required: true, type: PropertyType.String, description: "itemId of product")
        variationId(required: false, type: PropertyType.String, description: "variationId of product")
    }
    "/myml/invoices/items/origin/save/response"(platform: "/", type: TrackType.Event) {}

    //sku
    "/myml/invoices/items/sku"(platform: "/") {}
    "/myml/invoices/items/sku/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/sku/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/items/sku/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "itemId of product")
        variationId(required: false, type: PropertyType.String, description: "variationId of product")
        sku(required: true, type: PropertyType.String, description: "Sku id input")
    }
    "/myml/invoices/items/sku/save/response"(platform: "/", type: TrackType.Event) {}

    //csosn
    "/myml/invoices/items/csosn"(platform: "/") {}
    "/myml/invoices/items/csosn/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/csosn/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/items/csosn/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Product tax information and aditional infos")
    }
    "/myml/invoices/items/csosn/save/response"(platform: "/", type: TrackType.Event) {}

    //ean
    "/myml/invoices/items/ean"(platform: "/") {}
    "/myml/invoices/items/ean/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/ean/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/items/ean/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "itemId of product")
        data(required: true, description: "Ean(europen article code) and aditional infos")
    }
    "/myml/invoices/items/ean/save/response"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/ean/validate"(platform: "/", type: TrackType.Event) {
        ean(required: true, type: PropertyType.String, description: "Ean(europen article code) id input value")
    }

    //product-type
    "/myml/invoices/items/product-type"(platform: "/") {}
    "/myml/invoices/items/product-type/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/product-type/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/items/product-type/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "itemId of product")
        variationId(required: false, type: PropertyType.String, description: "variationId of product")
        data(required: true, description: "Product type selected and aditional infos")
    }
    "/myml/invoices/items/product-type/save/response"(platform: "/", type: TrackType.Event) {}

    //ncm
    "/myml/invoices/items/ncm"(platform: "/") {}
    "/myml/invoices/items/ncm/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/ncm/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/items/ncm/save/request"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "itemId of product")
        data(required: true, description: "Ncm (tax information)")
        variationId(required: false, type: PropertyType.String, description: "variationId of product")
    }
    "/myml/invoices/items/ncm/save/response"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/ncm/search"(platform: "/", isAbstract: true) {}
    "/myml/invoices/items/ncm/search/request"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/items/ncm/search/response"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Search ncm info when user input code")
    }

    //:::: Sales list
    "/myml/invoices/sales_list"(platform: "/", isAbstract: true) {}
    "/myml/invoices/sales_list/create_invoice"(platform: "/", type: TrackType.Event) {}

    //:::: Optin flow
    "/myml/invoices/company-info"(platform: "/", isAbstract: true) {
        error(required: false, type:  PropertyType.String, description: "Error message that pop to user after request")
        errorValidation(required: false, type:  PropertyType.String, description: "Error message when value is invalid")
        url(required: false, type:  PropertyType.String, description: "Url to redirect after response")
    }
    
    //landing
    "/myml/invoices/landing"(platform: "/") {}
    "/myml/invoices/landing/optin"(platform: "/", type: TrackType.Event) {
        type (required: true, values: ["top", "bottom"], description: "Top or bottom button")
    }
    
    //certificate
    "/myml/invoices/company-info/certificate"(platform: "/") {}
    "/myml/invoices/company-info/certificate/help_tooltip"(platform: "/", type: TrackType.Event) {}
    
    "/myml/invoices/company-info/certificate/a1"(platform: "/") {}
    "/myml/invoices/company-info/certificate/a1/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/certificate/a3"(platform: "/") {}
    "/myml/invoices/company-info/certificate/a3/handshake"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/certificate/a3/handshake/request"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/certificate/a3/handshake/response"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "A3 certificate Handshake event infos")
    }
    
    //serie
    "/myml/invoices/company-info/serie"(platform: "/") {}
    "/myml/invoices/company-info/serie/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/serie/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/serie/save/request"(platform: "/", type: TrackType.Event) {
        serie(required: true, description: "Serie number input and url to redirect")
    }
    "/myml/invoices/company-info/serie/save/response"(platform: "/", type: TrackType.Event) {}
    
    //cst
    "/myml/invoices/company-info/cst"(platform: "/") {}
    "/myml/invoices/company-info/cst/help_tooltip"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/cst/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/cst/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, description: "Tax information of selected fields")
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
    "/myml/invoices/company-info/ie/save/request"(platform: "/", type: TrackType.Event) {
        data(required: true, type: PropertyType.String, description: "User state registration code (tax information) input")
    }
    "/myml/invoices/company-info/ie/save/response"(platform: "/", type: TrackType.Event) {}
    
    //confirm
    "/myml/invoices/company-info/confirm"(platform: "/") {}
    "/myml/invoices/company-info/confirm/save"(platform: "/", isAbstract: true) {}
    "/myml/invoices/company-info/confirm/save/request"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/confirm/save/response"(platform: "/", type: TrackType.Event) {}
    "/myml/invoices/company-info/success"(platform: "/") {}

}
