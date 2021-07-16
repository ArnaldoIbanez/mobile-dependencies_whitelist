package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1075"

    propertyDefinitions {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        item_id(required: true, type: PropertyType.String, description: "Item id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        quote_demand_id(required: true, type: PropertyType.Numeric, description: "Quote Demand id")
        quote_demand_status(required: true, type: PropertyType.String, values: ["pending_by_seller", "answered", "rejected_by_seller", "accepted", "deleted", "cancelled", "expired"], description: "the status quote demand")
        quote_id(required: true, type: PropertyType.Numeric, description: "Quote id")
        quote_status(required: true, type: PropertyType.String, values: ["sent", "cancelled_by_seller", "accepted", "expired", "rejected_by_seller"], description: "the status quote")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        action(required: true, type: PropertyType.String, values: ["go_messages", "go_reject", "go_contract", "go_cancel", "go_create_similar", "go_delete", "go_quote_detail", "go_quotes_list", "contract_quote"], description: "available actions in options")


    }
    propertyGroups {
        quoteSellerGroup(vertical, seller_id)
        quoteBuyerGroup(vertical, buyer_id)
        demandItemGroup(item_id, category_id, category_path, buyer_id, quote_demand_id, quote_demand_status)
        quoteItemGroup(item_id,category_id, category_path, quote_demand_id,quote_demand_status,quote_id,quote_status)
        actionGroup(action)
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

    /***** `Ver Pedido` ******/

    // See Request Detail
    "/quote/seller/create/go_messages"(platform: "/", type: TrackType.Event) {
        demandItemGroup
    }

    "/quote/seller/edit"(platform: "/", type: TrackType.View) {}

    "/quote/seller/edit/go_messages"(platform: "/mobile", type: TrackType.Event) {
        demandItemGroup
    }

    /***** Create Quote Mobile ******/

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

    /***** Create Similar Quote Mobile ******/
    // Quote Create -  Loading
    "/quote/seller/create_similar"(platform: "/", parentPropertiesInherited: false) {}

    // Quote Create -  Loading
    "/quote/seller/create_similar/loading"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

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

    /***** Create Quote Web ******/

    // Quote Create Web
    "/quote/seller/create"(platform: "/web", type: TrackType.View) {
        demandItemGroup
    }

    // Quote Create Web - See Request Detail
    "/quote/seller/create/new"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
        action(required: true, type: PropertyType.String, values: ["step_price", "step_conditions", "step_expire", "submit_quote_demand"], description: "steps in create quote")

    }

    // Quote  Create Edit Web
    "/quote/seller/create/edit"(platform: "/web", type: TrackType.View) {
        demandItemGroup
    }

    // Quote  Create Edit Web
    "/quote/seller/create/edit/action"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
        action(required: true, type: PropertyType.String, values: ["cancel_edit", "confirmation_edit"], description: "action click on Cancelar o Confirmar when edit a quote")
    }

    /***** Create Quote Confirmation ******/
    // Quote  Create  - Confirmation
    "/quote/seller/create/confirmation"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }

    // Quote  Create  Confirmation Event
    "/quote/seller/create/confirmation/send_quote"(platform: "/", type: TrackType.Event) {
        demandItemGroup
    }

    /***** Create Quote Congrats ******/

    // Quote  Create  - Congrats
    "/quote/seller/create/congrats"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    // Quote  Create  - Congrats Event
    "/quote/seller/create/congrats/go_listing"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
    }

    // Quote  Create  - Congrats Error
    "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.View) {
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        demandItemGroup
    }

    // Quote  Create  - Congrats Error Event
    "/quote/seller/create/congrats_error/go_edit"(platform: "/", type: TrackType.Event) {
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        demandItemGroup
    }

    /***** Listing (Demands) ******/

    // Demands  Listing
    "/quote/seller/listing"(platform: "/", type: TrackType.View) {}

    // Demands Listing Rows Events
    "/quote/seller/listing/action"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        actionGroup
    }

    // Demands Listing Cards Events
    "/quote/seller/listing/cards_actions"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "action click on listing cards")
    }

    // Demands Listing Go filters Event
    "/quote/seller/listing/go_filters"(platform: "/", type: TrackType.Event) {}

    // Demands Listing Search Submit Event
    "/quote/seller/listing/search_submit"(platform: "/web", type: TrackType.Event) {}

    // Demands Listing Options Events
    "/quote/seller/listing/options"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
        actionGroup
    }

    // Demands Listing Filters Events
    "/quote/seller/listing/filters"(platform: "/", type: TrackType.View) {
    }

    "/quote/seller/listing/filters/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "all action click on filters )")
    }

    /***** Quote Demand Detail in Messages ******/

    // Demand Detail in Messages
    "/quote/seller/messages"(platform: "/web", type: TrackType.View) {
        demandItemGroup
    }

    // Demand Detail in Messages Event
    "/quote/seller/messages/create_quote"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
    }

    // Demand Detail in Messages Event Options
    "/quote/seller/messages/options"(platform: "/web", type: TrackType.Event) {
        demandItemGroup
        actionGroup
    }

    // Quote  List - Go detail
    "/quote/seller/quote_listing"(platform: "/", type: TrackType.View) {
        demandItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
    }

    // Quote  List - Go detail
    "/quote/seller/quote_listing/go_quote_detail"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
    }

    // Quote list Web - Options
    "/quote/seller/quote_listing/options"(platform: "/web", type: TrackType.Event) {
        quoteItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        actionGroup
    }

    /***** Quote detail ******/
    "/quote/seller/details"(platform: "/", parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

    // Quote Detail -  Loading
    "/quote/seller/details/loading"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

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
        actionGroup
    }

    /***** Cancel Quote ******/
    // Cancel Quote -  Loading
    "/quote/seller/cancel/loading"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

    //Quote - Cancel View
    "/quote/seller/cancel"(platform: "/", type: TrackType.View) {
        demandItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        quote_id(required: true, type: PropertyType.Numeric, description: "Quote id")
    }

    //Quote - Cancel Event
    "/quote/seller/cancel/action"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        quote_id(required: true, type: PropertyType.Numeric, description: "Quote id")
        action(required: true, type: PropertyType.String, description: "cancel reason selected")
    }

    //Quote - Cancel Congrats
    "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Cancel Congrats Event
    "/quote/seller/cancel/congrats/go_listing"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        buyer_id(required: true, type: PropertyType.Numeric, description: "Buyer id")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Cancel Congrats Error
    "/quote/seller/cancel/congrats_error"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    //Quote - Cancel Congrats Error Event
    "/quote/seller/cancel/congrats_error/go_listing"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    /***** Reject Demand ******/
    // Reject Quote Demand -  Loading
    "/quote/seller/reject/loading"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

    //Quote - Reject View
    "/quote/seller/reject"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }
    //Quote - Reject Event
    "/quote/seller/reject/action"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        action(required: true, type: PropertyType.String, description: "reject reason selected")
    }

    //Quote - Reject Congrats
    "/quote/seller/reject/congrats"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }

    //Quote - Reject Congrats Event
    "/quote/seller/reject/congrats/go_listing"(platform: "/", type: TrackType.Event) {
        demandItemGroup
    }

    //Quote - Reject Congrats Error
    "/quote/seller/reject/congrats_error"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }

    //Quote - Reject Congrats Error Event
    "/quote/seller/reject/congrats_error/go_listing"(platform: "/", type: TrackType.Event) {
        demandItemGroup
    }

    /***** Delete Demand ******/
    // Delete Quote Demand -  Loading
    "/quote/seller/delete/loading"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

    //Quote - Delete View
    "/quote/seller/delete"(platform: "/", type: TrackType.View) {
        demandItemGroup
    }
    //Quote - Delete Event
    "/quote/seller/delete/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "delete reason selected")
    }

    //Quote - Delete Congrats
    "/quote/seller/delete/congrats"(platform: "/", type: TrackType.View) {}

    //Quote - Delete Congrats Event
    "/quote/seller/delete/congrats/go_listing"(platform: "/", type: TrackType.Event) {}

    //Quote - Delete Congrats Error
    "/quote/seller/delete/congrats_error"(platform: "/", type: TrackType.View) {}

    //Quote - Delete Congrats Error Event
    "/quote/seller/delete/congrats_error/go_listing"(platform: "/", type: TrackType.Event) {}

    /***** Listing onBoarding ******/

    //Onboarding View
    "/quote/seller/onboarding"(platform: "/", type: TrackType.View) {}

    //Onboarding Skip button click
    "/quote/seller/onboarding/skip"(platform: "/", type: TrackType.Event) {}

    //Onboarding Understood button click
    "/quote/seller/onboarding/got_it"(platform: "/", type: TrackType.Event) {}

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

    "/quote/buyer/quote"(platform: "/", parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

    //Quote Demand Buyer Tracks
    "/quote_demand/buyer"(platform: "/", type: TrackType.View) {
        quoteBuyerGroup
     }

    /***** Create Quote Demand ******/
    // Create Quote Demand -  Loading
    "/quote/buyer/quote/loading"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        vertical(required: true, type: PropertyType.String, values: ["services"], description: "Vertical services")
    }

    //Quote Buyer :: Create Quote
    "/quote_demand/buyer/create"(platform: "/", type: TrackType.View) {
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
        item_id(required: true, type: PropertyType.String, description: "Item id")
    }

    //Quote Buyer :: Create Quote Event
    "/quote_demand/buyer/create/submit_quote_demand"(platform: "/", type: TrackType.Event) {
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        buyer_id(required: false, type: PropertyType.Numeric, description: "Buyer id")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        category_path(required: false, type: PropertyType.ArrayList, description: "Item's category tree")
        item_id(required: true, type: PropertyType.String, description: "Item id")
        vip_version(required: false, type: PropertyType.String, description: "vip version for query new experience")
    }

    /***** Quote Demands Listing ******/

    //Quote Buyer :: Listing
    "/quote/buyer/listing"(platform: "/", type: TrackType.View) {}

    //Quote Buyer :: Listing event
    "/quote/buyer/listing/action"(platform: "/", type: TrackType.Event) {
        demandItemGroup
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        actionGroup
    }

    //Quote Buyer :: Go Filters
    "/quote/buyer/listing/go_filters"(platform: "/", type: TrackType.Event) {}

    //Quote Buyer :: Search web
    "/quote/buyer/listing/search_submit"(platform: "/web", type: TrackType.Event) {}

    //Quote Buyer :: Cards Events
    "/quote/buyer/listing/cards_actions"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "cards in actions")
    }

    //Quote Buyer :: Filters Events
    "/quote/buyer/listing/filters"(platform: "/", type: TrackType.View) {
    }

    "/quote/buyer/listing/filters/action"(platform: "/", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "all action click on filters")
    }

    /***** Quotes Listing ******/

    "/quote/buyer/quote_listing"(platform: "/", type: TrackType.View) {
        demandItemGroup
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
    }

    //Quotes Listing Event
    "/quote/buyer/quote_listing/go_quote_detail"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
    }

    //Quotes Listing Event
    "/quote/buyer/quote_listing/contract_quote"(platform: "/web", type: TrackType.Event) {
        quoteItemGroup
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
    }

    /***** Quote Detail ******/

    "/quote/buyer/detail"(platform: "/", type: TrackType.View) {
        quoteItemGroup
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
    }

    "/quote/buyer/detail/action"(platform: "/", type: TrackType.Event) {
        quoteItemGroup
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        currency_id(required: true, type: PropertyType.String, description: "The currency in which the prices amounts are expressed")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user")
        actionGroup
    }

    /***** Quote Demand Detail in Messages ******/

    //Quote Demand Detail
    "/quote/buyer/messages"(platform: "/web", type: TrackType.View) {
        quoteSellerGroup
        demandItemGroup
    }

    //Quote Demand Detail Events
    "/quote/buyer/messages/go_detail"(platform: "/web", type: TrackType.Event) {
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        demandItemGroup
    }

    /***** Listing onBoarding ******/

    //Onboarding View
    "/quote/buyer/onboarding"(platform: "/", type: TrackType.View) {}

    //Onboarding Skip button click
    "/quote/buyer/onboarding/skip"(platform: "/", type: TrackType.Event) {}

    //Onboarding Understood button click
    "/quote/buyer/onboarding/got_it"(platform: "/", type: TrackType.Event) {}

    /******************************************
     *       End: Buyer
     ******************************************/


}
