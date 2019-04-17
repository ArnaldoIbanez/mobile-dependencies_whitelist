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
        quote_id(required: false, type: PropertyType.Numeric, description: "Quote id")
        quote_status(required: false, type: PropertyType.String, values: ["sent", "cancelled_by_seller", "accepted", "expired", "rejected_by_seller"], description: "the status quote")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        quote_demand_status(required: false, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted"], description: "the status quote demand")

    }
    propertyGroups {
        quoteSellerGroup(vertical, seller_id)
        quoteSellerItemGroup(item_id, category_id, buyer_id, quote_demand_id, quote_demand_status)
        quoteBuyerGroup(vertical)
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

    // Quote Create -  Loading
    "/quote/seller/create/loading"(platform: "/" ,type: TrackType.View) {
    }

    // Quote  Create - Price form
    "/quote/seller/create/input_price"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create  Similar- Price form
    "/quote/seller/create/edit_price"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create - Expiration date form
    "/quote/seller/create/input_expiration_date"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create similar - Expiration date form
    "/quote/seller/create/edit_expiration_date"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create  - Conditions form
    "/quote/seller/create/input_conditions"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
    }
    // Quote  Create similar - Conditions form
    "/quote/seller/create/edit_conditions"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  Create similar - Conditions form
    "/quote/seller/create"(platform: "/",type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_messages"], description: "action click on `Ver Pedido` )")

    }

     // Quote  Create  - Confirmation
    "/quote/seller/create/confirmation"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")

    }

    // Quote  Create  Confirmation
    "/quote/seller/create/confirmation"(platform: "/",type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["send_quote"], description: "action click on `Enviar Presupuesto` )")

    }

    // Quote  Create  - Congrats Error
    "/quote/seller/create/congrats_error"(platform: "/",type: TrackType.View) {
        item_id(required: true, type: PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        quote_status(required: false, type: PropertyType.String, values: ["sent", "cancelled_by_seller", "accepted", "expired", "rejected_by_seller"], description: "the status quote")
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")
    }

    // Quote  Create  - Congrats Error
    "/quote/seller/create/congrats_error"(platform: "/",type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        quote_status(required: false, type: PropertyType.String, values: ["sent", "cancelled_by_seller", "accepted", "expired", "rejected_by_seller"], description: "the status quote")
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")
        action(required: false, type: PropertyType.String, values: ["go_edit"], description: "action click on `Intentar de nuevo` )")
    }

    // Quote  Create  - Congrats
    "/quote/seller/create/congrats"(platform: "/",type: TrackType.View) {
        item_id(required: true, type: PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        quote_status(required: false, type: PropertyType.String, values: ["sent", "cancelled_by_seller", "accepted", "expired", "rejected_by_seller"], description: "the status quote")
        action(required: false, type: PropertyType.String, values: ["go_edit"], description: "action click on `Intentar de nuevo` )")
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")

    }

    // Quote  Listing
    "/quote/seller/listing"(platform: "/",type: TrackType.View) {
    }

    // Quote  Event Listing
    "/quote/seller/listing"(platform: "/",type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_messages","go_quote_detail","go_quotes_list", "go_filters", "news"], description: "all action click on listing )")

    }
    // Quote  Filters
    "/quote/seller/listing/filters"(platform: "/",type: TrackType.View) {
    }
    // Quote  Event Filters
    "/quote/seller/listing/filters"(platform: "/",type: TrackType.Event) {
        action(required: false, type: PropertyType.String, values: ["reset", "submit_filtter"], description: "all action click on filsters )")
    }

    // Quote  go_quotes_list - uses Case : Two or more demands
    "/quote/seller/quote_listing"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
    }

    // Quote  go_quotes_list - uses Case : Two or more demands
    "/quote/seller/quote_listing"(platform: "/",type: TrackType.Event) {
        quoteSellerItemGroup
        action(required: false, type: PropertyType.String, values: ["go_quote_detail"], description: "all action click on quote Listing )")
    }

    // Quote Detail
    "/quote/seller/detail"(platform: "/",type: TrackType.View) {
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    // Quote - Detail Events
    "/quote/seller/detail/options"(platform: "/",type: TrackType.Event){
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_messages", "go_reject","go_contract", "go_cancel","go_create_similar", "go_delete"], description: "all action click on detail )")
    }

    //Quote - Cancel View
    "/quote/seller/cancel"(platform: "/",type: TrackType.View){
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }
    //Quote - Cancel View
    "/quote/seller/cancel"(platform: "/",type: TrackType.Event){
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["MLA_CANCEL_001","MLA_CANCEL_002","MLA_CANCEL_003","MLA_CANCEL_004","MLA_CANCEL_005"], description: "all action click on Cancel  )")
    }

    //Quote - Congrats
    "/quote/seller/cancel/congrats"(platform: "/",type: TrackType.View){
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }


    //Quote - Congrats Event
    "/quote/seller/cancel/congrats"(platform: "/",type: TrackType.Event){
        quoteSellerItemGroup
        currency_id(required: false, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: false, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        action(required: false, type: PropertyType.String, values: ["go_listing"], description: "all action click on Congrats  )")

    }


    /******************************************
     *       End: Seller
     ******************************************/

    /******************************************
     *       Start: Buyer
     ******************************************/

    /******************************************
     *       End: Buyer
     ******************************************/


}
