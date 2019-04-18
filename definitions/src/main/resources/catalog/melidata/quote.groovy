import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    propertyDefinitions {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        item_id(required: false, type: PropertyType.String, description: "Item id")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: false, type: PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: false, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted"], description: "the status quote demand")
        quote_id(required: false, type: PropertyType.Numeric, description: "Quote id")
        quote_status(required: false, type: PropertyType.String, values: ["sent", "cancelled_by_seller", "accepted", "expired", "rejected_by_seller"], description: "the status quote")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")


    }
    propertyGroups {
        quoteSellerGroup(vertical, seller_id)
        quoteSellerItemGroup(item_id, category_id, buyer_id, quote_demand_id, quote_demand_status)
        quoteBuyerGroup(vertical)
        quoteBuyerItemGroup(item_id,category_id,buyer_id,quote_demand_id,quote_demand_status,quote_id,quote_status)
    }

    //Quote
    "/quote"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start:  Seller
     ******************************************/

    //Quote Seller Tracks
    "/quote/seller"(platform: "/") {
        quoteSellerGroup
    }

    /***** Create Quote ******/

    // Quote Create -  Loading
    "/quote/seller/create/loading"(platform: "/", type: TrackType.View) {}

    // Quote  Create - Price form
    "/quote/seller/create/input_price"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create  Similar- Price form
    "/quote/seller/create/edit_price"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create - Expiration date form
    "/quote/seller/create/input_expiration_date"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create similar - Expiration date form
    "/quote/seller/create/edit_expiration_date"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create  - Conditions form
    "/quote/seller/create/input_conditions"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create similar - Conditions form
    "/quote/seller/create/edit_conditions"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create  - Confirmation
    "/quote/seller/create/confirmation"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")

    }

    // Quote  Create  Confirmation
    "/quote/seller/create/confirmation"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["send_quote"], description: "action click on `Enviar Presupuesto` )")

    }

    // Quote  Create Web
    "/quote/seller/create"(platform: "/web", type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_messages"], description: "action click on `Ver Pedido` )")

    }

    // Quote  Create Edit Web
    "/quote/seller/create/edit"(platform: "/web", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create Edit Web
    "/quote/seller/create/edit"(platform: "/web", type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["cancel_edit", "confirmation"], description: "action click on Cancelar o Confirmar when edit a quote")
    }

    // Quote  Create - See Request Detail
    "/quote/seller/create"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_messages"], description: "action click on `Ver Pedido` )")

    }

    // Quote  Create  - Congrats
    "/quote/seller/create/congrats"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
        quoteBuyerItemGroup
    }

    // Quote  Create  - Congrats Event
    "/quote/seller/create/congrats"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        quoteBuyerItemGroup
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "action click on `Intentar de nuevo aaa` )")
    }

    // Quote  Create  - Congrats Error
    "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create  - Congrats Error Event
    "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_edit"], description: "action click on `Intentar de nuevo aaa` )")
    }

    /***** Listing ******/

    // Demands  Listing
    "/quote/seller/listing"(platform: "/", type: TrackType.View) {}

    // Demands Listing Events
    "/quote/seller/listing"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_messages", "go_quote_detail", "go_quotes_list", "go_filters", "news", "search_submit"], description: "all action click on listing )")
    }

    // Demands Listing Options Events
    "/quote/seller/listing/options"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_messages", "go_reject", "go_contract", "go_cancel", "go_create_similar", "go_delete"], description: "all actions when click the three dots options")
    }

    // Demands Listing Filters Events
    "/quote/seller/listing/filters"(platform: "/", type: TrackType.Event) {
        action(required: false, type: PropertyType.String, values: ["reset", "submit_filter"], description: "all action click on filters )")
    }

    // Demand Detail in Messages
    "/quote/seller/messages"(platform: "/web", type: TrackType.View) {
        quoteSellerGroup
    }

    // Demand Detail in Messages Event
    "/quote/seller/messages"(platform: "/web", type: TrackType.Event) {
        quoteSellerGroup
        action(required: false, type: PropertyType.String, values: ["create_quote"], description: "action click on create quote")
    }

    // Demand Detail in Messages Event Options
    "/quote/seller/messages/options"(platform: "/web", type: TrackType.Event) {
        quoteSellerGroup
        action(required: false, type: PropertyType.String, values: ["go_cancel", "go_create_similar", "go_delete"], description: "action click on messages options")
    }

    // Quotes Listing - uses Case : Two or more quotes
    "/quote/seller/quote_listing"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  go_quotes_list - uses Case : Two or more demands
    "/quote/seller/quote_listing"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_quote_detail"], description: "all action click on quote Listing )")
    }

    // Quote Detail
    "/quote/seller/detail"(platform: "/", type: TrackType.View) {
        quoteBuyerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    // Quote - Detail Events
    "/quote/seller/detail/options"(platform: "/", type: TrackType.Event) {
        quoteBuyerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_messages", "go_reject", "go_contract", "go_cancel", "go_create_similar", "go_delete"], description: "all action click on detail )")
    }

    //Quote - Cancel View
    "/quote/seller/cancel"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }
    //Quote - Cancel Event
    "/quote/seller/cancel"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["MLA_CANCEL_001", "MLA_CANCEL_002", "MLA_CANCEL_003", "MLA_CANCEL_004", "MLA_CANCEL_005"], description: "all action click on Cancel  )")
    }

    //Quote - Cancel Congrats
    "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Cancel Congrats Event
    "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats  )")
    }

    //Quote - Cancel Congrats Error
    "/quote/seller/cancel/congrats_error"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Cancel Congrats Error Event
    "/quote/seller/cancel/congrats_error"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats  )")
    }

    //Quote - Reject View
    "/quote/seller/reject"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
    }
    //Quote - Reject Event
    "/quote/seller/reject"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["MLA_REJECT_001", "MLA_REJECT_002", "MLA_REJECT_003", "MLA_REJECT_004", "MLA_REJECT_005"], description: "all action click on Reject")
    }

    //Quote - Reject Congrats
    "/quote/seller/reject/congrats"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Reject Congrats Event
    "/quote/seller/reject/congrats"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats  )")
    }

    //Quote - Reject Congrats Error
    "/quote/seller/reject/congrats_error"(platform: "/", type: TrackType.View) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Reject Congrats Error Event
    "/quote/seller/reject/congrats_error"(platform: "/", type: TrackType.Event) {
        quoteSellerItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats  )")
    }

    /******************************************
     *       End: Seller
     ******************************************/

    /******************************************
     *       Start: Buyer
     ******************************************/

    //Quote Buyer Tracks
    "/quote/buyer/"(platform: "/", isAbstract: true) {
        quoteBuyerGroup
    }

    //Quote Buyer :: Listing
    "/quote_demand"(platform: "/", type: TrackType.View) {
        quoteBuyerGroup
    }
    //Quote Buyer :: Listing
    "/quote_demand/buyer"(platform: "/", type: TrackType.View) {
        quoteBuyerGroup
     }

    //Quote Buyer :: Create Quote
    "/quote_demand/buyer/create"(platform: "/", type: TrackType.View) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        item_id(required: true, type: PropertyType.String, description: "Item id")
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
    }

    //Quote Buyer :: Create Quote Event
    "/quote_demand/buyer/create"(platform: "/", type: TrackType.Event) {
        action(required: false, type: PropertyType.String, values: ["create_quote_demand"], description: "all action click on create demand  )")
    }

    //Quote Buyer :: Listing
    "/quote/buyer/listing"(platform: "/", type: TrackType.View) {
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        buying_mode(required: false, type:PropertyType.String, description: "Indicates buying mode type")
    }

    //Quote Buyer :: Listing event
    "/quote/buyer/listing"(platform: "/", type: TrackType.Event) {
        quoteBuyerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_messages","go_quote_detail","go_quotes_list", "go_filters", "news"], description: "all action click on buyer listing  )")
    }

    //go_quotes_list - uses Case : Two or more demands
    "/quote/buyer/quote_listing"(platform: "/", type: TrackType.View) {
        quoteBuyerItemGroup

    }

    // go_quotes_list - uses Case : Two or more demands
    "/quote/buyer/quote_listing"(platform: "/", type: TrackType.Event) {
        quoteBuyerItemGroup
        buying_mode(required: false, type:PropertyType.String, description: "Indicates buying mode type")
        action(required: false, type: PropertyType.String, values: ["go_quote_detail"], description: "all action click on quote listing  )")
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")

    }

    "/quote/buyer/detail"(platform: "/", type: TrackType.View) {
        quoteBuyerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")
    }


    "/quote/buyer/detail"(platform: "/", type: TrackType.Event) {
        quoteBuyerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_message", "contract_quote", "go_contract"], description: "all action click on detail  )")
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")
    }

    "/quote/buyer/detail"(platform: "/", type: TrackType.View) {
        quoteBuyerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")
    }

    /******************************************
     *       End: Buyer
     ******************************************/


}
