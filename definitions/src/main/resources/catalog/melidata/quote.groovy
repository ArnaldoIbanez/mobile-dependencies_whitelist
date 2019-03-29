import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    propertyDefinitions {
        vertical(required: true, type:PropertyType.String, values: ["services"] ,description: "Vertical services")
        seller_id(required: true, type:PropertyType.Numeric, description: "Seller ID")
    }
    propertyGroups {
        quoteSellerGroup(vertical, seller_id)
        quoteBuyerGroup(vertical)
    }

    //Quote
    "/quote"(platform: "/", isAbstract: true) {}

    //Quote Seller Tracks
    "/quote/seller"(platform: "/") {
        quoteSellerGroup
    }

    //Quote Seller :: Listing
    "/quote/seller/listing"(platform: "/web", type: TrackType.View) {
    }

    //Quote seller :: Listing - rows
    "/quote/seller/listing"(platform: "/web", type: TrackType.Event) {
        action(required: false, type:PropertyType.String, description: "rows actions (go_messages, go_quote)")
    }

    //quote seller :: Listing - news
    "/quote/seller/listing/news"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String, description: "action click on news")
    }

    //quote seller :: Listing - filters
    "/quote/seller/listing/filters"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String, values: ["filter_intention","search_submit","search_reset"], description: "action click on filters)")
    }

    //quote seller :: Listing - menu
    "/quote/seller/listing/menu"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String, description: "action selected from menu quotes(cancel,sent,reject,delete,copy)")
    }

    //quote seller :: Listing - modal
    "/quote/seller/listing/filters/modal"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String,  values: ["reset","submit_filter"], description: "filter modal actions (reset,submit_filter)")
    }

    //quote seller :: Quote Detail
    "/quote/seller/detail"(platform: "/web", type: TrackType.View) {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList, description: 'the path of the category')
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: true, type:PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, description: "the status quote demand")
        quote_id(required: true, type:PropertyType.Numeric, description: "Quote id")
        quote_status(required: true, type: PropertyType.String, description: "the status quote")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
    }

    //quote seller :: Quote Detail - menu
    "/quote/seller/detail/menu"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String, description: "action selected from menu quotes(cancel,sent,reject,delete,copy)")
    }

    //quote seller :: Quote Detail - modal
    "/quote/seller/detail/messages"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String, values: ["show_modal_messages"], description: "show modal messages")
    }

    //quote seller :: Quote Messages
    "/quote/seller/messages"(platform: "/web", type: TrackType.View) {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList, description: 'the path of the category')
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: true, type:PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, description: "the status quote demand")
        quote_id(required: true, type:PropertyType.Numeric, description: "Quote id")
        quote_status(required: true, type: PropertyType.String, description: "the status quote")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
    }

    //quote seller :: Quote Messages - create
    "/quote/seller/messages"(platform: "/web", type: TrackType.Event) {
        action(required: false, type:PropertyType.String, description: "Create quote action")
    }

    //quote seller :: Quote Messages - menu
    "/quote/seller/messages/menu"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String, description: "action selected from menu quotes(cancel,sent,reject,delete,copy)")
    }

    //quote seller :: Quote Create
    "/quote/seller/create"(platform: "/web", type: TrackType.View) {
        item_id(required: true, type:PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: true, type: PropertyType.ArrayList, description: 'the path of the category')
        buyer_id(required: false, type:PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: false, type:PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: false, type: PropertyType.String, description: "the status quote demand")
        quote_id(required: false, type:PropertyType.Numeric, description: "Quote id")
        quote_status(required: false, type: PropertyType.String, description: "the status quote")
    }

    //quote seller :: Quote Create - steps
    "/quote/seller/create/new"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String, values: ["step", "submit"], description: "steps action clicks")
    }

    //quote seller :: Quote Create - modal messages
    "/quote/seller/create/messages"(platform: "/web", type: TrackType.Event) {
        action(required: true, type:PropertyType.String, values: ["show_modal_messages"], description: "show modal messages action")
    }

    //quote seller :: Quote confirmation
    "/quote/seller/create/confirmation"(platform: "/web", type: TrackType.View) {
        quote_demand_id(required: true, type:PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, description: "the status quote demand")
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer id")
    }

    //quote seller :: Quote Create - confirmation
    "/quote/seller/create/confirmation"(platform: "/web", type: TrackType.Event) {
        action(required: false, type:PropertyType.String, description: "create quote action (send_quote)")
    }

    //quote seller :: Quote Edit
    "/quote/seller/create/edit"(platform: "/web", type: TrackType.View) {
        quote_demand_id(required: true, type:PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, description: "Quote demand status")
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer id")
    }

    //quote seller :: Quote Edit - confirmation
    "/quote/seller/create/edit"(platform: "/web", type: TrackType.Event) {
        action(required: false, type:PropertyType.String, description: "edit quote (confirmation_edit,cancel_edit)")
    }

    //quote seller :: Quote Congrats
    "/quote/seller/create/congrats"(platform: "/web", type: TrackType.View) {
        quote_demand_id(required: true, type:PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, description: "the status quote demand")
        quote_id(required: true, type:PropertyType.Numeric, description: "Quote id")
        quote_status(required: true, type: PropertyType.String, description: "the status quote")
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer id")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
    }

    //quote seller :: Quote Congrats - go listing
    "/quote/seller/create/congrats"(platform: "/web", type: TrackType.Event) {
        action(required: false, type:PropertyType.String, description: "Go to listing path (go_listing)")
    }

    //Quote Buyer Tracks
    "/quote/buyer/"(platform: "/", isAbstract: true) {
        quoteBuyerGroup
    }

    //Quote Buyer :: Listing
    "/quote/buyer/listing"(platform: "/mobile", type: TrackType.View) {}

    //Quote Buyer :: Listing - Empty
    "/quote/buyer/listing/empty"(platform: "/mobile", type: TrackType.View) {
        buying_mode(required: true, type:PropertyType.String, description: "Indicates buying mode type")
    }

    //Quote Buyer :: Listing - Filters
    "/quote/buyer/listing/filters"(platform: "/mobile", type: TrackType.View) {}

    //Quote Buyer :: Listing - News
    "/quote/buyer/listing/news"(platform: "/mobile", type: TrackType.Event) {}

    //Quote Buyer :: Listing - Detail
    "/quote/buyer/listing/detail"(platform: "/mobile", type: TrackType.View) {
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer ID")
        buying_mode(required: true, type:PropertyType.String, description: "Indicates buying mode type")
        demand_id(required: true, type:PropertyType.Numeric, description: "Demand id")
    }

    //Quote Buyer :: VIP
    "/quote/buyer/vip"(platform: "/mobile", type: TrackType.Event) {
        quote_id(required: true, type:PropertyType.String, description: "Quote id")
        quote_demand_id(required: true, type:PropertyType.String, description: "Quote Demand id")
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer ID")
        item_id(required: true, type:PropertyType.String, description: "Item id")
        status_quote(required: true, type:PropertyType.String,  values: ["vencido","cancelado","activo"], description: "Indicates the quote status")
    }

    //Quote Buyer :: Buying Flow
    "/quote/buyer/buyingflow"(platform: "/mobile", type: TrackType.Event) {
        quote_id(required: true, type:PropertyType.String, description: "Quote id")
        quote_demand_id(required: true, type:PropertyType.String, description: "Quote Demand id")
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer ID")
        item_id(required: true, type:PropertyType.String, description: "Item id")
        status_quote(required: true, type:PropertyType.String,  values: ["vencido","cancelado","activo"], description: "Indicates the quote status")
    }

    //Quote Buyer :: Message
    "/quote/buyer/message"(platform: "/mobile", type: TrackType.Event) {
        quote_id(required: true, type:PropertyType.String, description: "Quote id")
        quote_demand_id(required: true, type:PropertyType.String, description: "Quote Demand id")
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer ID")
        item_id(required: true, type:PropertyType.String, description: "Item id")
        status_quote(required: true, type:PropertyType.String,  values: ["vencido","cancelado","activo"], description: "Indicates the quote status")
    }

    //Quote Buyer :: Detail
    "/quote/buyer/detail"(platform: "/mobile", type: TrackType.View) {
        quote_id(required: true, type:PropertyType.String, description: "Quote id")
        quote_demand_id(required: true, type:PropertyType.String, description: "Quote Demand id")
        buyer_id(required: true, type:PropertyType.Numeric, description: "Buyer ID")
        item_id(required: true, type:PropertyType.String, description: "Item id")
        status_quote(required: true, type:PropertyType.String,  values: ["vencido","cancelado","activo"], description: "Indicates the quote status")
    }

    //Quote Buyer :: OnBoarding
    "/quote/buyer/onboarding"(platform: "/mobile", type: TrackType.View) {}
}
