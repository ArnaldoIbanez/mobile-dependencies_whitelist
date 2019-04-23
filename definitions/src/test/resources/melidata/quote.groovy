package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    /******************************************
     *       Start: Seller - Test
     ******************************************/
    test("Quote :: Show listing seller tracking") {

        //Quote Seller Test
        "/quote/seller"(platform: "/") {
            vertical = "services"
            seller_id = 33624088
        }

        /******  Create Quote **********/

        // Quote Create -  Loading
        "/quote/seller/create/loading"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
        }

        // Quote  Create - Price form
        "/quote/seller/create/input_price"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create - Expiration date form
        "/quote/seller/create/input_expiration_date"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create - Conditions  form
        "/quote/seller/create/input_conditions"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        /******  Create Similar Quote **********/

        // Quote  Create Similar - Price form
        "/quote/seller/create/edit_price"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create Similar - Expiration date form
        "/quote/seller/create/edit_expiration_date"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create Similar - Conditions  form
        "/quote/seller/create/edit_conditions"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        /***** Create Quote (See demand detail and create quote web) ******/

        //Create Quote (See demand detail)
        "/quote/seller/create"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_messages"
        }

        // Quote  Create  Edit
        "/quote/seller/create/edit"(platform: "/web", type: TrackType.View) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            category_id = "MLA1540"
            vertical = "services"
            quote_demand_status = "answered"
            seller_id = 33624088
            buyer_id = 64567088
        }

        // Quote  Create  Edit Events
        "/quote/seller/create/edit"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            category_id = "MLA1540"
            vertical = "services"
            quote_demand_status = "answered"
            seller_id = 33624088
            buyer_id =  64567088
            action = "cancel_edit"
        }

        /***** Create Quote Confirmation ******/

        // Quote  Create  - Confirmation
        "/quote/seller/create/confirmation"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            price = 15.3
            currency_id = "ARG"
        }

        // Quote  Create  - Confirmation Event
        "/quote/seller/create/confirmation"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            price = 15.3
            currency_id = "ARG"
            action = "send_quote"
        }

        /***** Create Quote Confirmation ******/

        // Quote  Create  - Congrats
        "/quote/seller/create/congrats"(platform: "/", type: TrackType.View) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            category_id = "MLA1540"
            vertical = "services"
            quote_demand_status = "pending_by_seller"
            quote_status = "sent"
            seller_id = 33624088
            buyer_id = 64567088
            price = 300.00
            currency_id = "CLP"
        }

        // Quote  Create  - Congrats
        "/quote/seller/create/congrats"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_id = 65732
            quote_status = "sent"
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            price = 300.00
            currency_id = "CLP"
            action = "go_listing"
        }

        // Quote  Create  - Congrats Error
        "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            quote_demand_id = 23423423
            quote_demand_status = "answered"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_id = 23423423
            quote_status = "accepted"
        }

        // Quote  Create  - Congrats Error
        "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            quote_demand_id = 23423423
            quote_demand_status = "answered"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_id = 23423423
            quote_status = "accepted"
            action = "go_edit"
        }

        /***** Quote Demands Listing ******/

        // Quote Listing Seller
        "/quote/seller/listing"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
        }

        // Quote Listing Seller Events
        "/quote/seller/listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_messages"
        }

        // Quote Listing Seller Event News
        "/quote/seller/listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "news"
        }

        // Quote Listing Seller Event Go Filters
        "/quote/seller/listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "go_filters"
        }

        // Quote  Seller Filters Events
        "/quote/seller/listing/filters"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "reset"
        }

        // Quote  Seller Options Events
        "/quote/seller/listing/options"(platform: "/web", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_reject"
        }

        /***** Quotes Listing ******/

        // Quotes Listing
        "/quote/seller/quote_listing"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quotes Listing Events
        "/quote/seller/quote_listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_quote_detail"

        }

        /***** Quote Detail ******/

        // Quote Detail
        "/quote/seller/detail"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_id = 65732
            quote_status = "accepted"
            price = 15.3
            currency_id = "ARG"
        }

        // Quote Detail Events
        "/quote/seller/detail/options"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_id = 698669764
            quote_status = "accepted"
            price = 15.3
            currency_id = "ARG"
            action = "go_messages"
        }

        /***** Quote Demand Detail in Messages ******/

        // Quote Seller Messages
        "/quote/seller/messages"(platform: "/web", type: TrackType.View) {
            seller_id = 33624088
            vertical = "services"
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote Seller Messages Events
        "/quote/seller/messages"(platform: "/web", type: TrackType.Event) {
            seller_id = 33624088
            vertical = "services"
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "create_quote"
        }

        // Quote Seller Messages Options Events
        "/quote/seller/messages/options"(platform: "/web", type: TrackType.Event) {
            seller_id = 33624088
            vertical = "services"
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_create_similar"
        }

        /***** Quote Cancel ******/

        //Quote - Cancel
        "/quote/seller/cancel"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Cancel Event
        "/quote/seller/cancel"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_id = 698669764
            action = "MLA_CANCEL_001"
        }

        //Quote - Cancel Congrats
        "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_status = "sent"
            quote_id = 698669764
            price = 15.3
            currency_id = "ARG"
        }

        //Quote - Cancel Congrats Event
        "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_status = "sent"
            quote_id = 698669764
            price = 15.3
            currency_id = "ARG"
            action = "go_listing"
        }

        //Quote - Cancel Congrats Error
        "/quote/seller/cancel/congrats_error"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_status = "sent"
            quote_id = 698669764
            price = 15.3
            currency_id = "ARG"
        }

        //Quote - Cancel Congrats Error Event
        "/quote/seller/cancel/congrats_error"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_status = "sent"
            quote_id = 698669764
            price = 15.3
            currency_id = "ARG"
            action = "go_listing"
        }

        /***** Quote Demand Reject ******/

        //Quote - Reject
        "/quote/seller/reject"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Reject Event
        "/quote/seller/reject"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "MLA_REJECT_001"
        }


        //Quote - Reject Congrats
        "/quote/seller/reject/congrats"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Congrats Event
        "/quote/seller/reject/congrats"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_listing"
        }

        //Quote - Reject Congrats Error
        "/quote/seller/reject/congrats_error"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Reject Congrats Error Event
        "/quote/seller/reject/congrats_error"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_listing"
        }
    }

    /******************************************
     *       End: Seller - Test
     ******************************************/

    /******************************************
     *       Start: Buyer - Test
     ******************************************/

    test("Quote :: buyer tracking") {
        //Quote Buyer Tracks
        "/quote/buyer"(platform: "/") {
            vertical = "services"
            buyer_id = 64567088
        }

        "/quote_demand/buyer"(platform: "/",type: TrackType.View) {
            vertical = "services"
            buyer_id = 64567088
        }

        /******  Create Quote Demand **********/

        //Create Quote Demand
        "/quote_demand/buyer/create"(platform: "/",type: TrackType.View) {
            vertical = "services"
            category_id= "MLA123214"
            item_id = "MLA77777"
            buyer_id= 234234324
            seller_id = 23423423
        }

        //Create Quote Demand Event
        "/quote_demand/buyer/create"(platform: "/",type: TrackType.Event) {
            vertical = "services"
            category_id= "MLA123214"
            item_id = "MLA77777"
            buyer_id= 234234324
            seller_id = 23423423
            action = "create_quote_demand"
        }

        /******  Demands Listing **********/

        //Demands Listing
        "/quote/buyer/listing"(platform: "/", type: TrackType.View) {
            vertical = "services"
            buyer_id= 234234324
        }

        //Demands Listing Events
        "/quote/buyer/listing"(platform: "/", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            buyer_id= 234234324
            vertical = "services"
            quote_demand_id = 234234
            quote_demand_status = "answered"
            action = "go_quote_detail"
        }

        //Demands Listing Event: Filters
        "/quote/buyer/listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            buyer_id= 234234324
            action = "go_filters"
        }

        //Demands Listing Filters
        "/quote/buyer/listing/filters"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            buyer_id= 234234324
            action = "reset"
        }

        /******  Quotes Listing **********/

        //Quotes Listing
        "/quote/buyer/quote_listing"(platform: "/mobile", type: TrackType.View) {
            buyer_id=3234
            seller_id=234234
            quote_demand_id=34243
            vertical = "services"
        }

        //Quotes Listing Event
        "/quote/buyer/quote_listing"(platform: "/mobile", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            buyer_id=3234
            quote_demand_id=34243
            quote_demand_status ="answered"
            quote_id=34243
            quote_status ="sent"
            seller_id=234234
            vertical = "services"
            action = "go_quote_detail"
        }

        /******  Quote Detail **********/

        //Quote Detail
        "/quote/buyer/detail"(platform: "/", type: TrackType.View) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            buyer_id=3234
            quote_demand_id=34243
            quote_id=323423
            quote_demand_status ="answered"
            seller_id=234234
            vertical = "services"
            quote_status="sent"
            price=23.4
            currency_id = "ARG"
        }

        //Quote Detail Events
        "/quote/buyer/detail"(platform: "/", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            buyer_id=3234
            quote_demand_id=34243
            quote_id=323423
            quote_demand_status ="answered"
            seller_id=234234
            vertical = "services"
            quote_status="sent"
            price=23.4
            currency_id = "ARG"
            action = "go_messages"
        }

        /***** Quote Demand Detail in Messages ******/

        //Quote Demand Detail
        "/quote/buyer/messages"(platform: "/web", type: TrackType.View) {
            item_id = "MLA782192768"
            category_id = "MLA91072"
            vertical = "services"
            quote_demand_id = 107004
            quote_demand_status = "answered"
            seller_id = 427851517
            buyer_id = 426245022
        }

        //Quote Demand Detail Event
        "/quote/buyer/messages"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA782192768"
            category_id = "MLA91072"
            vertical = "services"
            quote_demand_id = 107004
            quote_demand_status = "answered"
            seller_id = 427851517
            buyer_id = 426245022
            action = "go_detail"
        }

    }

    /******************************************
     *       End: Buyer - Test
     ******************************************/


}