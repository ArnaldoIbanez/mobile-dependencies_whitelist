package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Quote :: Show listing seller tracking") {
        //Quote Seller Tracks
        "/quote/seller"(platform: "/") {
           vertical = "services"
           seller_id = 33624088
        }

        //Quote Seller :: Listing - Query String
        "/quote/seller/listing"(platform: "/web",type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            querystring = "url=?page=2&&filter=32"
        }

        //quote seller :: Listing - news
        "/quote/seller/listing/news"(platform: "/web",type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "newsAction"
        }

        //quote seller :: Listing - filters
        "/quote/seller/listing/filters"(platform: "/web",type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "search_reset"
        }

        //quote seller :: Listing - menu
        "/quote/seller/listing/menu"(platform: "/web",type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "cancel"
        }

        //quote seller :: Listing - row
        "/quote/seller/listing"(platform: "/web",type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "go_messages"
        }

        //quote seller :: Listing - modal
        "/quote/seller/listing/filters/modal"(platform: "/web",type: TrackType.Event) {
            vertical = "services"
            seller_id = 33624088
            action = "submit_filter"
        }
    }

    test("quote :: Show quote Detail tracking") {
        //quote seller :: Quote Detail
        "/quote/seller/detail"(platform: "/web") {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            quote_demand_status = "active"
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            price = 15.3
            currency_id = "ARS"
        }
        //quote seller :: Quote Detail - menu
        "/quote/seller/detail/menu"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            quote_demand_status = "active"
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            price = 15.3
            currency_id = "ARS"
            action = "cancel"
        }

        //quote seller :: Quote Detail - modal
        "/quote/seller/detail/messages"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            quote_demand_status = "active"
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            price = 15.3
            currency_id = "ARS"
            action = "show_modal_messages"
        }
    }

    test("quote :: Show quote Messages tracking") {
        //quote seller :: Quote Messages
        "/quote/seller/messages"(platform: "/web") {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            quote_demand_status = "active"
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            price = 15.3
            currency_id = "ARS"
        }
        //quote seller :: Quote Messages - menu
        "/quote/seller/messages/menu"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            quote_demand_status = "active"
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            price = 15.3
            currency_id = "ARS"
            action = "cancel"
        }

        //quote seller :: Quote Messages - create
        "/quote/seller/messages"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            quote_demand_status = "active"
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            price = 15.3
            currency_id = "ARS"
            action = "show_modal_messages"
        }
    }

    test("quote :: Show quote Create tracking") {
        //quote seller :: Quote Create
        "/quote/seller/create"(platform: "/web") {
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            quote_demand_id = 69866976
            quote_demand_status = "active"
            quote_id = 65732
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            vertical = "services"
        }

        //quote seller :: Quote Create - steps
        "/quote/seller/create/new"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            quote_demand_id = 69866976
            quote_demand_status = "active"
            quote_id = 65732
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            vertical = "services"
            action = "step"
        }
        //quote seller :: Quote Create - submit
        "/quote/seller/create/new"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            quote_demand_id = 69866976
            quote_demand_status = "active"
            quote_id = 65732
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            vertical = "services"
            action = "submit"
        }
        //quote seller :: Quote Create - modal messages
        "/quote/seller/create/messages"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            quote_demand_id = 69866976
            quote_demand_status = "active"
            quote_id = 65732
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            vertical = "services"
            action = "show_modal_messages"
        }
    }

    test("quote :: Quote confirmation tracking") {
        //quote seller :: Quote confirmation
        "/quote/seller/create/confirmation"(platform: "/web") {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            quote_demand_status = "active"
            buyer_id = 64567088
            seller_id = 33624088
            vertical = "services"
        }
        //quote seller :: Quote Create - confirmation
        "/quote/seller/create/confirmation"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_demand_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            action = "send_quote"
        }

    }

    test("quote :: quote edit tracking") {
        //quote seller :: Quote Edit
        "/quote/seller/create/edit"(platform: "/web") {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
        }
        //quote seller :: Quote Edit - confirmation
        "/quote/seller/create/edit"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            action = "confirmation_edit"
        }
    }

    test("quote :: Show congrats tracking") {
        //quote seller :: Quote Congrats
        "/quote/seller/create/congrats"(platform: "/web") {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            quote_demand_status = "active"
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234", "MLA6789"]
            vertical = "services"
            price = 15.3
            currency_id = "ARS"
        }
        //quote seller :: Quote Congrats - go listing
        "/quote/seller/create/congrats"(platform: "/web",type: TrackType.Event) {
            item_id = "MLA698669764"
            quote_demand_id = 698669764
            quote_id = 65732
            quote_demand_status = "active"
            quote_status = "active"
            seller_id = 33624088
            buyer_id = 64567088
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            vertical = "services"
            price = 15.3
            currency_id = "ARS"
            action = "go_listing"
        }
    }
   //BUYER
    test("Quote :: Show buyer tracking") {
        //Quote Seller Tracks
        "/quote/buyer"(platform: "/") {
        }
    }
}