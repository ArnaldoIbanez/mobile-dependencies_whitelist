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
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        /******  Create Similar Quote **********/
        "/quote/seller/create_similar"(platform: "/") {}

        // Quote Create -  Loading
        "/quote/seller/create_similar/loading"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
        }

        // Quote  Create Similar - Price form
        "/quote/seller/create/edit_price"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        /***** Create Quote (See demand detail and create quote web) ******/

        //Create Quote Web
        "/quote/seller/create"(platform: "/web", type: TrackType.View) {
            item_id = "MLA782192768"
            quote_demand_id = 109654
            category_id = "MLA91072"
            category_path = ["MLA123", "MLA123"]
            vertical = "services"
            quote_demand_status = "pending_by_seller"
            seller_id = 427851517
            buyer_id = 400833138
        }

        //Create Quote Web - Step Price
        "/quote/seller/create/new"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA782192768"
            quote_demand_id = 109654
            category_id = "MLA91072"
            category_path = ["MLA123", "MLA123"]
            vertical = "services"
            quote_demand_status = "pending_by_seller"
            seller_id = 427851517
            buyer_id = 400833138
            action = "step_price"
        }

        //Create Quote (See demand detail)
        "/quote/seller/create/go_messages"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        "/quote/seller/edit"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
        }

        "/quote/seller/edit/go_messages"(platform: "/mobile", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create  Edit
        "/quote/seller/create/edit"(platform: "/web", type: TrackType.View) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            category_id = "MLA1540"
            category_path = ["MLA123", "MLA123"]
            vertical = "services"
            quote_demand_status = "answered"
            seller_id = 33624088
            buyer_id = 64567088
        }

        // Quote  Create  Edit Events
        "/quote/seller/create/edit/action"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            category_id = "MLA1540"
            category_path = ["MLA123", "MLA123"]
            vertical = "services"
            quote_demand_status = "answered"
            seller_id = 33624088
            buyer_id =  64567088
            action = "confirmation_edit"
        }

        /***** Create Quote Confirmation ******/

        // Quote  Create  - Confirmation
        "/quote/seller/create/confirmation"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create  - Confirmation Event
        "/quote/seller/create/confirmation/send_quote"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        /***** Create Quote Confirmation ******/

        // Quote  Create  - Congrats
        "/quote/seller/create/congrats"(platform: "/", type: TrackType.View) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            category_id = "MLA1540"
            category_path = ["MLA123", "MLA123"]
            vertical = "services"
            quote_demand_status = "pending_by_seller"
            quote_status = "sent"
            seller_id = 33624088
            buyer_id = 64567088
            price = 300.00
            currency_id = "CLP"
        }

        // Quote  Create  - Congrats
        "/quote/seller/create/congrats/go_listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_id = 65732
            quote_status = "sent"
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            price = 300.00
            currency_id = "CLP"
        }

        // Quote  Create  - Congrats Error
        "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            quote_demand_id = 23423423
            quote_demand_status = "answered"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
        }

        // Quote  Create  - Congrats Error
        "/quote/seller/create/congrats_error/go_edit"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            quote_demand_id = 23423423
            quote_demand_status = "answered"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
        }

        /***** Quote Demands Listing ******/

        // Quote Listing Seller
        "/quote/seller/listing"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
        }

        // Quote Listing Seller Events
        "/quote/seller/listing/action"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_messages"
        }

        // Quote Listing Seller Events (three dots web listing)
        "/quote/seller/listing/options"(platform: "/web", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_reject"
        }

        // Quote Listing Seller Events (three dots web listing)
        "/quote/seller/listing/options"(platform: "/web", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_delete"
        }

        // Quote Listing Seller Event News
        "/quote/seller/listing/cards_actions"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "news"
        }

        // Quote Listing Seller Event Go Filters
        "/quote/seller/listing/go_filters"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
        }

        // Quote  Seller Filters Events
        "/quote/seller/listing/filters"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
        }

        "/quote/seller/listing/filters/action"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "reset"
        }

        // Quote Listing Seller Event Search submit
        "/quote/seller/listing/search_submit"(platform: "/web", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
        }

        /***** Quotes Listing ******/

        "/quote/seller/quote_listing"(platform: "/", type: TrackType.View) {
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status ="answered"
            seller_id = 33624088
            vertical = "services"
        }

        "/quote/seller/quote_listing/go_quote_detail"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_id = 698669764
            quote_status = "sent"

        }

        "/quote/seller/quote_listing/options"(platform: "/web", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_id = 698669764
            quote_status = "sent"
            action = "go_messages"
        }

        /***** Quote Detail ******/
        // Quote Detail -  Loading
        "/quote/seller/details"(platform: "/") {
            vertical = "services"
        }

        // Quote Detail -  Loading
        "/quote/seller/details/loading"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
        }

        // Quote Detail
        "/quote/seller/detail"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote Seller Messages Events
        "/quote/seller/messages/create_quote"(platform: "/web", type: TrackType.Event) {
            seller_id = 33624088
            vertical = "services"
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote Seller Messages Options Events
        "/quote/seller/messages/options"(platform: "/web", type: TrackType.Event) {
            seller_id = 33624088
            vertical = "services"
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_create_similar"
        }

        // Quote Seller Messages Options Events
        "/quote/seller/messages/options"(platform: "/web", type: TrackType.Event) {
            seller_id = 33624088
            vertical = "services"
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "go_delete"
        }

        /***** Quote Cancel ******/
        // Cancel Quote -  Loading
        "/quote/seller/cancel/loading"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
        }

        //Quote - Cancel
        "/quote/seller/cancel"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_id = 698669764
        }

        //Quote - Cancel Event
        "/quote/seller/cancel/action"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_status = "sent"
            quote_id = 698669764
            price = 15.3
            currency_id = "ARG"
        }

        //Quote - Cancel Congrats Event
        "/quote/seller/cancel/congrats/go_listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_status = "sent"
            quote_id = 698669764
            price = 15.3
            currency_id = "ARG"
        }

        //Quote - Cancel Congrats Error
        "/quote/seller/cancel/congrats_error"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_status = "sent"
            quote_id = 698669764
            price = 15.3
            currency_id = "ARG"
        }

        //Quote - Cancel Congrats Error Event
        "/quote/seller/cancel/congrats_error/go_listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            quote_status = "sent"
            quote_id = 698669764
            price = 15.3
            currency_id = "ARG"
        }

        /***** Quote Demand Reject ******/
        // Reject Quote -  Loading
        "/quote/seller/reject/loading"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
        }

        //Quote - Reject
        "/quote/seller/reject"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Reject Event
        "/quote/seller/reject/action"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Congrats Event
        "/quote/seller/reject/congrats/go_listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Reject Congrats Error
        "/quote/seller/reject/congrats_error"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Reject Congrats Error Event
        "/quote/seller/reject/congrats_error/go_listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        /***** Quote Demand Delete ******/
        // Delete Quote -  Loading
        "/quote/seller/delete/loading"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
        }

        //Quote - Delete
        "/quote/seller/delete"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Delete Event
        "/quote/seller/delete/action"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            action = "MLA_DELETE_001"
        }


        //Quote - Delete Congrats
        "/quote/seller/delete/congrats"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Delete Congrats Event
        "/quote/seller/delete/congrats/go_listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Delete Congrats Error
        "/quote/seller/delete/congrats_error"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        //Quote - Delete Congrats Error Event
        "/quote/seller/delete/congrats_error/go_listing"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        /***** Listing onBoarding ******/

        //Onboarding View
        "/quote/seller/onboarding"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
        }

        //Onboarding Skip button click
        "/quote/seller/onboarding/skip"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
        }

        //Onboarding Understood button click
        "/quote/seller/onboarding/got_it"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
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

        "/quote/buyer/quote"(platform: "/") {
            vertical = "services"
        }

        "/quote_demand/buyer"(platform: "/",type: TrackType.View) {
            vertical = "services"
            buyer_id = 64567088
        }

        /******  Create Quote Demand **********/
        // Quote DemandCreate -  Loading
        "/quote/buyer/quote/loading"(platform: "/mobile", type: TrackType.View) {
            vertical = "services"
        }

        //Create Quote Demand
        "/quote_demand/buyer/create"(platform: "/",type: TrackType.View) {
            vertical = "services"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            item_id = "MLA77777"
            buyer_id= 234234324
            seller_id = 23423423
        }

        //Create Quote Demand Event
        "/quote_demand/buyer/create/submit_quote_demand"(platform: "/",type: TrackType.Event) {
            vertical = "services"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            item_id = "MLA77777"
            buyer_id= 234234324
            seller_id = 23423423
        }

        //Create Quote Demand Event with new vip version
        "/quote_demand/buyer/create/submit_quote_demand"(platform: "/",type: TrackType.Event) {
            vertical = "services"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            item_id = "MLA77777"
            buyer_id= 234234324
            seller_id = 23423423
            vip_version = "new"
        }

        //Create Quote Demand
        "/quote_demand/buyer/create"(platform: "/",type: TrackType.View) {
            vertical = "services"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            item_id = "MLA77777"
            seller_id = 23423423
        }

        //Create Quote Demand Event without buyer id
        "/quote_demand/buyer/create/submit_quote_demand"(platform: "/",type: TrackType.Event) {
            vertical = "services"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            item_id = "MLA77777"
            seller_id = 23423423
        }

        /******  Demands Listing **********/

        //Demands Listing
        "/quote/buyer/listing"(platform: "/", type: TrackType.View) {
            vertical = "services"
            buyer_id= 234234324
        }

        //Demands Listing Events
        "/quote/buyer/listing/action"(platform: "/", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            buyer_id= 234234324
            seller_id= 234234324
            vertical = "services"
            quote_demand_id = 234234
            quote_demand_status = "answered"
            action = "go_quote_detail"
        }

        "/quote/buyer/listing/action"(platform: "/", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            buyer_id= 234234324
            seller_id= 234234324
            vertical = "services"
            quote_demand_id = 234234
            quote_demand_status = "answered"
            action = "go_messages"
        }

        //Demands Listing Event: Filters
        "/quote/buyer/listing/go_filters"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            buyer_id= 234234324
        }

        //Demands Listing Event: Cards
        "/quote/buyer/listing/cards_actions"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            buyer_id= 234234324
            action = "news"
        }

        //Demands Listing Event: Search submit Web
        "/quote/buyer/listing/search_submit"(platform: "/web", type: TrackType.Event) {
            vertical = "services"
            buyer_id= 234234324
        }

        //Demands Listing Filters
        "/quote/buyer/listing/filters"(platform: "/", type: TrackType.View) {
            vertical = "services"
            buyer_id= 234234324
        }
        "/quote/buyer/listing/filters/action"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            buyer_id= 234234324
            action = "reset"
        }

        /******  Quotes Listing **********/

        //Quotes Listing Event - Go Detail
        "/quote/buyer/quote_listing"(platform: "/", type: TrackType.View) {
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA123", "MLA123"]
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status ="answered"
            seller_id = 33624088
            vertical = "services"

        }

        //Quotes Listing Event - Go Detail
        "/quote/buyer/quote_listing/go_quote_detail"(platform: "/", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            buyer_id=3234
            quote_demand_id=34243
            quote_demand_status ="answered"
            quote_id=34243
            quote_status ="sent"
            seller_id=234234
            vertical = "services"
        }

        //Quotes Listing Event - Contract Quote - Web
        "/quote/buyer/quote_listing/contract_quote"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
            buyer_id=3234
            quote_demand_id=34243
            quote_demand_status ="answered"
            quote_id=34243
            quote_status ="sent"
            seller_id=234234
            vertical = "services"
        }

        /******  Quote Detail **********/

        //Quote Detail
        "/quote/buyer/detail"(platform: "/", type: TrackType.View) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
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
        "/quote/buyer/detail/action"(platform: "/", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            category_path = ["MLA123", "MLA123"]
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
            category_path = ["MLA123", "MLA123"]
            vertical = "services"
            quote_demand_id = 107004
            quote_demand_status = "answered"
            seller_id = 427851517
            buyer_id = 426245022
        }

        //Quote Demand Detail Event
        "/quote/buyer/messages/go_detail"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA782192768"
            category_id = "MLA91072"
            category_path = ["MLA123", "MLA123"]
            vertical = "services"
            quote_demand_id = 107004
            quote_demand_status = "answered"
            seller_id = 427851517
            buyer_id = 426245022
        }

        /***** Listing onBoarding ******/

        //Onboarding View
        "/quote/buyer/onboarding"(platform: "/", type: TrackType.View) {
            vertical = "services"
            buyer_id = 33624088
        }

        //Onboarding Skip button click
        "/quote/buyer/onboarding/skip"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            buyer_id = 33624088
        }

        //Onboarding Understood button click
        "/quote/buyer/onboarding/got_it"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            buyer_id = 33624088
        }

    }

    /******************************************
     *       End: Buyer - Test
     ******************************************/


}
