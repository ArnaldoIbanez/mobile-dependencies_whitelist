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

        // Quote Create -  Loading
        "/quote/seller/create/loading"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
        }

        // Quote  Create - Price form
        "/quote/seller/create/input_price"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create  Similar- Price form
        "/quote/seller/create/edit_price"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create - Expiration date form
        "/quote/seller/create/input_expiration_date"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create Similar - Expiration date form
        "/quote/seller/create/edit_expiration_date"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create - Conditions  form
        "/quote/seller/create/input_conditions"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create Similar - Conditions  form
        "/quote/seller/create/edit_conditions"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  Create Similar - Conditions  form
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

        // Quote  Create  - Confirmation
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

        // Quote  Create  - Congrats Error
        "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            quote_demand_status = "answered"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_status = "sent"

        }

        // Quote  Create  - Congrats Error
        "/quote/seller/create/congrats_error"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            quote_demand_status = "answered"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_status = "sent"
            action = "go_edit"

        }

        // Quote  Create  - Congrats
        "/quote/seller/create/congrats"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_status = "sent"
            quote_demand_id = 698669764
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

        // Quote  Create  - Congrats
        "/quote/seller/listing"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
        }

        // Quote  Create Similar - Conditions  form
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

        // Quote  Seller Filters
        "/quote/seller/listing/filters"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
        }
        // Quote  Seller Filters Events
        "/quote/seller/listing/filters"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "reset"
        }

        // Quote  Seller Options Events
        "/quote/seller/listing/options"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "go_reject"
        }

        // Quote  go_quotes_list - uses Case : Two or more demands
        "/quote/seller/quote_listing"(platform: "/", type: TrackType.View) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
        }

        // Quote  go_quotes_list - uses Case : Two or more demands
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

        // Quote Detail Events
        "/quote/seller/detail/options"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            price = 15.3
            currency_id = "ARG"
            action = "go_messages"
        }

        // Quote Detail
        "/quote/seller/detail"(platform: "/", type: TrackType.View) {
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

        //Quote - Congrats
        "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.View) {
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

        //Quote - Congrats
        "/quote/seller/cancel/congrats"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            price = 15.3
            currency_id = "ARG"
            action = "go_listing"
        }
        //Quote - Cancel
        "/quote/seller/cancel"(platform: "/", type: TrackType.View) {
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

        //Quote - Cancel
        "/quote/seller/cancel"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            price = 15.3
            currency_id = "ARG"
            action = "MLA_CANCEL_001"
        }

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

        //Quote - Reject Events
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


        //Quote - Congrats
        "/quote/seller/reject/congrats"(platform: "/", type: TrackType.View) {
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

        //Quote - Congrats
        "/quote/seller/reject/congrats"(platform: "/", type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            item_id = "MLA698669764"
            category_id = "MLA43718"
            buyer_id = 64567088
            quote_demand_id = 698669764
            quote_demand_status = "answered"
            price = 15.3
            currency_id = "ARG"
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
        }

        "/quote_demand"(platform: "/",type: TrackType.View) {
            vertical = "services"
        }

        "/quote_demand/buyer"(platform: "/",type: TrackType.View) {
            vertical = "services"
        }

        //Quote Buyer :: Create Quote
        "/quote_demand/buyer/create"(platform: "/",type: TrackType.View) {
            vertical = "services"
            category_id= "MLA123214"
            item_id = "MLA77777"
            buyer_id= 234234324
            seller_id = 23423423
        }

        //Quote Buyer :: Create Quote Event
        "/quote_demand/buyer/create"(platform: "/",type: TrackType.Event) {
            vertical = "services"
            category_id= "MLA123214"
            item_id = "MLA77777"
            buyer_id= 234234324
            seller_id = 23423423
            action = "create_quote_demand"
        }

        //Quote Buyer :: Listing
        "/quote/buyer/listing"(platform: "/", type: TrackType.View) {
            vertical = "services"
            buyer_id= 234234324
            buying_mode = "classified"
        }

        //Quote Buyer :: Listing event
        "/quote/buyer/listing"(platform: "/", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            buyer_id= 234234324
            vertical = "services"
            buying_mode = "classified"
            demand_id = 234234
            action = "go_quote_detail"

        }

        // go_quotes_list - uses Case : Two or more demands
        "/quote/buyer/quote_listing"(platform: "/", type: TrackType.View) {
            buyer_id=234234
            buying_mode = "classified"
            demand_id = 234234
            vertical = "services"
        }

        // go_quotes_list - uses Case : Two or more demands
        "/quote/buyer/quote_listing"(platform: "/", type: TrackType.Event) {
            item_id = "MLA77777"
            category_id= "MLA123214"
            buyer_id=3234
            quote_demand_id=34243
            quote_id=323423
            quote_demand_status ="answered"
            seller_id=234234
            vertical = "services"
            action = "go_quote_detail"
        }

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
            action = "go_message"
        }


    }





    /******************************************
     *       End: Buyer - Test
     ******************************************/


}