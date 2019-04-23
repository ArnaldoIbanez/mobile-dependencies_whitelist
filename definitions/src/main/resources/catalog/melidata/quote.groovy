import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    propertyDefinitions {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        item_id(required: true, type: PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted"], description: "the status quote demand")
        quote_id(required: true, type: PropertyType.Numeric, description: "Quote id")
        quote_status(required: true, type: PropertyType.String, values: ["sent", "cancelled_by_seller", "accepted", "expired", "rejected_by_seller"], description: "the status quote")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")


    }
    propertyGroups {
        quoteSellerGroup(vertical, seller_id)
        quoteBuyerGroup(vertical, buyer_id)
        demandItemGroup(item_id, category_id, buyer_id, quote_demand_id, quote_demand_status)
        quoteItemGroup(item_id,category_id,quote_demand_id,quote_demand_status,quote_id,quote_status)
    }

    //Quote
    "/quote"(platform: "/", isAbstract: true) {}

    //Quote Demand
    "/quote_demand"(platform: "/", isAbstract: true) {}

    /******************************************
     *       Start:  Seller
     ******************************************/

    //Quote Seller Tracks
    "/quote/seller"(platform: "/") {
        quoteSellerGroup
    }

    /***** Create Quote ******/

    // Quote Create -  Loading
    "/quote/seller/create/loading"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

    // Quote  Create - Price form
    "/quote/seller/create/input_price"(platform: "/mobile", type: TrackType.View) {
        demandItemGroup
    }

    // Quote  Create - Expiration date form
    "/quote/seller/create/input_expiration_date"(platform: "/mobile", type: TrackType.View) {
        demandItemGroup
    }

    // Quote  Create  - Conditions form
    "/quote/seller/create/input_conditions"(platform: "/mobile", type: TrackType.View) {
        demandItemGroup
    }

    /***** Create Similar Quote ******/
    // Quote  Create  Similar- Price form
    "/quote/seller/create/edit_price"(platform: "/mobile", type: TrackType.View) {
        demandItemGroup
    }
    // Quote  Create similar - Conditions form
    "/quote/seller/create/edit_conditions"(platform: "/mobile", type: TrackType.View) {
        demandItemGroup
    }

    // Quote  Create similar - Expiration date form
    "/quote/seller/create/edit_expiration_date"(platform: "/mobile", type: TrackType.View) {
        demandItemGroup
    }

    /***** Create Quote Confirmation ******/
    // Quote  Create  - Confirmation
    "/quote/seller/create/confirmation"(platform: "/", type: TrackType.View) {
        demandItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")

    }

    // Quote  Create  Confirmation Event
    "/quote/seller/create/confirmation"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        action(required: false, type: PropertyType.String, values: ["send_quote"], description: "action click on `Enviar Presupuesto`")

    }

    /***** Create Quote (See demand detail and create quote web) ******/

    // Quote Create Web
    "/quote/seller/create"(platform: "/web", type: TrackType.View) {
        demandItemGroup
    }

    // Quote Create Web - See Request Detail
    "/quote/seller/create"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        action(required: false, type: PropertyType.String, values: ["go_messages"], description: "action click on `Ver Pedido`")

    }

    // Quote  Create Edit Web
    "/quote/seller/create/edit"(platform: "/web", type: TrackType.View) {
        demandItemGroup
    }

    // Quote  Create Edit Web
    "/quote/seller/create/edit"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
        action(required: false, type: PropertyType.String, values: ["cancel_edit", "confirmation"], description: "action click on Cancelar o Confirmar when edit a quote")
    }


    /***** Create Quote Congrats ******/

    // Quote  Create  - Congrats
    "/quote/seller/create/congrats"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    // Quote  Create  - Congrats Event
    "/quote/seller/create/congrats"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "action click on `Intentar de nuevo aaa`")
    }

    // Quote  Create  - Congrats Error
    "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.View) {
        quoteItemGroup
    }

    // Quote  Create  - Congrats Error Event
    "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        action(required: false, type: PropertyType.String, values: ["go_edit"], description: "action click on `Intentar de nuevo aaa` )")
    }

    /***** Listing (Demands) ******/

    // Demands  Listing
    "/quote/seller/listing"(platform: "/", type: TrackType.View) {}

    // Demands Listing Events
    "/quote/seller/listing"(platform: "/", type: TrackType.Event) {
        item_id(required: false, type: PropertyType.String, description: "Item id")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: false, type: PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: false, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted"], description: "the status quote demand")
        action(required: false, type: PropertyType.String, values: ["go_messages", "go_quote_detail", "go_quotes_list", "go_filters", "news", "search_submit"], description: "all action click on listing")
    }

    // Demands Listing Options Events
    "/quote/seller/listing/options"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
        action(required: true, type: PropertyType.String, values: ["go_messages", "go_reject", "go_contract", "go_cancel", "go_create_similar", "go_delete"], description: "all actions when click the three dots web options")
    }

    // Demands Listing Filters Events
    "/quote/seller/listing/filters"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, values: ["reset", "submit_filter"], description: "all action click on filters )")
    }

    /***** Quote Demand Detail in Messages ******/

    // Demand Detail in Messages
    "/quote/seller/messages"(platform: "/web", type: TrackType.View) {
        demandItemGroup
    }

    // Demand Detail in Messages Event
    "/quote/seller/messages"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
        action(required: false, type: PropertyType.String, values: ["create_quote"], description: "action click on create quote")
    }

    // Demand Detail in Messages Event Options
    "/quote/seller/messages/options"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
        action(required: true, type: PropertyType.String, values: ["go_cancel", "go_create_similar", "go_delete"], description: "action click on messages options")
    }

    /***** Listing (Quotes) ******/
    // Quotes Listing - uses Case : Two or more quotes
    "/quote/seller/quote_listing"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }

    // Quote  go_quotes_list - uses Case : Two or more demands
    "/quote/seller/quote_listing"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        action(required: false, type: PropertyType.String, values: ["go_quote_detail"], description: "all action click on quote Listing )")
    }

    /***** Quote detail ******/
    // Quote Detail
    "/quote/seller/detail"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    // Quote - Detail Events
    "/quote/seller/detail/options"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: true, type: PropertyType.String, values: ["go_messages", "go_reject", "go_contract", "go_cancel", "go_create_similar", "go_delete"], description: "all action click on detail )")
    }

    /***** Cancel Quote ******/

    //Quote - Cancel View
    "/quote/seller/cancel"(platform: "/", type: TrackType.View) {
        item_id(required: true, type: PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted"], description: "the status quote demand")
        quote_id(required: true, type: PropertyType.Numeric, description: "Quote id")
    }
    //Quote - Cancel Event
    "/quote/seller/cancel"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted"], description: "the status quote demand")
        quote_id(required: true, type: PropertyType.Numeric, description: "Quote id")
        action(required: false, type: PropertyType.String, values: ["MLA_CANCEL_001", "MLA_CANCEL_002", "MLA_CANCEL_003", "MLA_CANCEL_004", "MLA_CANCEL_005"], description: "all action click on Cancel  )")
    }

    //Quote - Cancel Congrats
    "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Cancel Congrats Event
    "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats  )")
    }

    //Quote - Cancel Congrats Error
    "/quote/seller/cancel/congrats_error"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Cancel Congrats Error Event
    "/quote/seller/cancel/congrats_error"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats")
    }

    /***** Reject Demand ******/

    //Quote - Reject View
    "/quote/seller/reject"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }
    //Quote - Reject Event
    "/quote/seller/reject"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        action(required: false, type: PropertyType.String, values: ["MLA_REJECT_001", "MLA_REJECT_002", "MLA_REJECT_003", "MLA_REJECT_004", "MLA_REJECT_005"], description: "all action click on Reject")
    }

    //Quote - Reject Congrats
    "/quote/seller/reject/congrats"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }

    //Quote - Reject Congrats Event
    "/quote/seller/reject/congrats"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats")
    }

    //Quote - Reject Congrats Error
    "/quote/seller/reject/congrats_error"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }

    //Quote - Reject Congrats Error Event
    "/quote/seller/reject/congrats_error"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats Error")
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

    //Quote Demand Buyer Tracks
    "/quote_demand/buyer"(platform: "/", type: TrackType.View) {
        quoteBuyerGroup
     }

    /***** Create Quote Demand ******/

    //Quote Buyer :: Create Quote
    "/quote_demand/buyer/create"(platform: "/", type: TrackType.View) {
        quoteSellerGroup
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        item_id(required: true, type: PropertyType.String, description: "Item id")
    }

    //Quote Buyer :: Create Quote Event
    "/quote_demand/buyer/create"(platform: "/", type: TrackType.Event) {
        quoteSellerGroup
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        item_id(required: true, type: PropertyType.String, description: "Item id")
        action(required: false, type: PropertyType.String, values: ["create_quote_demand"], description: "all action click on create demand  )")
    }

    /***** Quote Demands Listing ******/

    //Quote Buyer :: Listing
    "/quote/buyer/listing"(platform: "/", type: TrackType.View) {}

    //Quote Buyer :: Listing event
    "/quote/buyer/listing"(platform: "/", type: TrackType.Event) {
        item_id(required: false, type: PropertyType.String, description: "Item id")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: false, type: PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: false, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted"], description: "the status quote demand")
        action(required: false, type: PropertyType.String, values: ["go_messages","go_quote_detail","go_quotes_list", "go_filters", "news"], description: "all action click on buyer listing  )")
    }

    //Quote Buyer :: Filters Events
    "/quote/buyer/listing/filters"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, values: ["reset","submit_filter"], description: "all action click on filters")
    }

    /***** Quotes Listing ******/

    //Quotes Listing
    "/quote/buyer/quote_listing"(platform: "/mobile", type: TrackType.View) {
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
    }

    //Quotes Listing Event
    "/quote/buyer/quote_listing"(platform: "/mobile", type: TrackType.Event) {
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        item_id(required: false, type: PropertyType.String, description: "Item id")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        quote_demand_status(required: false, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted"], description: "the status quote demand")
        quote_id(required: false, type: PropertyType.Numeric, description: "Quote id")
        quote_status(required: false, type: PropertyType.String, values: ["sent", "cancelled_by_seller", "accepted", "expired", "rejected_by_seller"], description: "the status quote")
        action(required: false, type: PropertyType.String, values: ["go_quote_detail"], description: "all action click on quote listing  )")

    }

    /***** Quote Detail ******/

    "/quote/buyer/detail"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    "/quote/buyer/detail"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_messages", "contract_quote", "go_contract"], description: "all action click on detail  )")
    }

    /***** Quote Demand Detail in Messages ******/

    //Quote Demand Detail
    "/quote/buyer/messages"(platform: "/web", type: TrackType.View) {
        quoteSellerGroup
        demandItemGroup
    }

    //Quote Demand Detail Events
    "/quote/buyer/messages"(platform: "/web", type: TrackType.Event) {
        quoteSellerGroup
        demandItemGroup
        action(required: false, type: PropertyType.String, values: ["go_detail"], description: "all action click on detail  )")
    }

    /******************************************
     *       End: Buyer
     ******************************************/


}
