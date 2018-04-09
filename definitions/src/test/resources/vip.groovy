import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    //VIP FLOW
    test("Vip min core tracking in android") {
        def dataSet = {
            item_id = "MLA533657947"
        }

        "/vip"(platform:"/mobile", dataSet)

        "/vip"(platform:"/mobile", {
            dataSet()
            quotation_available = false
        })

        "/vip/failure"(platform:"/mobile", {
            item_id = "MLA533657947"
            error_message = "any message"
        })

        "/vip/abort"(platform:"/mobile", dataSet)

        "/vip/back"(platform:"/mobile", dataSet)

        "/vip/color_and_size"(platform:"/mobile", dataSet)

        "/vip/description"(platform:"/mobile", {
            item_id = "MLA533657947"
            empty_description = false
            context="/vip"
        })

        "/vip/description"(platform:"/mobile", {
            item_id = "MLA533657947"
            empty_description = false
        })

        "/vip/description/abort"(platform:"/mobile", dataSet)

        "/vip/description/back"(platform:"/mobile", dataSet)

        "/vip/description/failure"(platform:"/mobile", dataSet)

        "/vip/contact_seller"(platform:"/mobile", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/contact_seller"(platform: "/web/desktop", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/contact_seller"(platform: "/web/mobile", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/call_seller"(platform:"/mobile", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/call_seller"(platform:"/web/desktop", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/call_seller"(platform:"/web/mobile", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/mobile", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/desktop", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/mobile", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/desktop", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/mobile", type: TrackType.Event, {
            item_id = "MLA533657947"
            category_id = "3323"
            vertical = "REAL-ESTATE"
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/description/failure"(platform:"/mobile", dataSet)

        "/vip/item_gallery"(platform:"/mobile") {
            context = "/vip"
        }

        "/vip/item_gallery/back"(platform:"/mobile") {}

        "/vip/map"(platform:"/mobile", dataSet)

        "/vip/seller_reputation"(platform:"/mobile", dataSet)

        "/vip/seller_reputation/ratings"(platform:"/mobile", dataSet)

        "/vip/payment_method"(platform: "/mobile", dataSet)

        "/vip/payment_method/back"(platform: "/mobile", dataSet)

        "/vip/variations"(platform: "/mobile", dataSet)

        "/vip/variations/back"(platform: "/mobile", dataSet)

        "/vip/quantity"(platform: "/mobile", dataSet)
    }

    test("Vip web mobile tracking without reviews") {

        "/vip"(platform:"/web/mobile") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=-1
        }
    }


    test("Vip web mobile with reviews") {
        "/vip"(platform:"/web/mobile") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=3.5
        }
    }

    test("Vip web desktop without reviews") {
        "/vip"(platform:"/web/desktop") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=-1
        }
    }

    test("Vip web desktop with reviews") {
        "/vip"(platform:"/web/desktop") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=5
        }
    }

    test("Vip core tracking in android deprecated") {
        def dataSet = {
            item_id = "MLA533657947"
            buying_mode = "buy_it_now"
            vertical = "code"
            category_id = "MLA43718"
            quantity = 3
            item_condition = "new"
            currency_id = "ARS"
            price = 15.3
            item_status = "active"
            official_store_id = "1"
            seller_id = "131662738"
            power_seller_status = "platinum"
            listing_type_id = "gold_special"
            start_time = "2014-11-17T14:00:50.000Z"
            stop_time = "2015-01-16T14:00:50.000Z"
            shipping_mode = "me2"
            free_shipping = true
            local_pick_up = false
            category_path = ["MLA1234","MLA6789"]
            reputation_level = "green_5"
            fulfillment = true
            resolution = "high"
            cart_content = false
            search_query = "monitor"
            page_vertical = "motors"
        }

        "/vip"(platform:"/mobile", dataSet)

        "/vip/color_and_size"(platform:"/mobile", {
            item_id = "MLA533657947"
        })

        "/vip/description"(platform:"/mobile", {
            item_id = "MLA533657947"
            buying_mode = "buy_it_now"
            category_id = "MLA43718"
            quantity = 3
            currency_id = "ARS"
            price = 15.3
            item_status = "active"
            seller_id = "131662738"
            listing_type_id = "gold_special"
            shipping_mode = "me2"
            free_shipping = true
            local_pick_up = false
            empty_description = false
        })

        "/vip/description/abort"(platform:"/mobile", dataSet)

        "/vip/description/back"(platform:"/mobile", dataSet)
    }

    test("Vip tracking in web") {
        def dataSet = {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            buying_mode = "buy_it_now"
            official_store_id = "1"
            deal_ids = ["MLA24"]
            review_rate=5
            gallery_pattern = "XXXXX"
            specifications_size = 1
        }

        "/vip"(platform:"/web", dataSet)
    }

    test("Vip protected purchase") {
        "/vip/protected_purchase/show" (platform:"/web/mobile", type: TrackType.Event) {
            category_id = "MLA1234"
            item_id="MLA1891239"
        }

        "/vip/protected_purchase/close" (platform:"/web/mobile", type: TrackType.Event) {
            category_id = "MLA1234"
            item_id="MLA1891239"
        }
    }


    test("melidata vip track") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
        }

        def trackModals = {
            show = "fae_details"
            item_id = "MLA213512313"
            category_id = "MLA123"
        }

        "/vip/variations"(platform: "/web") {
            defaultTrackInformation()
        }

        "/vip/reviews"(platform: "/", type: TrackType.View) {
            trackModals()
        }

        "/vip/coordinate_availability"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/vip/contract_intention"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("New Shipping calculator"){

        "/vip/shipping/calculator/calculate"(platform: "/mobile/ios") {
            cp_autocomplete = true
        }

        "/vip/shipping/calculator/i_dont_know_my_code"(platform: "/mobile/ios") {
        }

        "/vip/shipping/calculator/calculate_error"(platform: "/mobile/ios") {
            error_type = "error code"
        }

        "/vip/shipping/calculator/agencies/show_agencies_map_for_pickup"(platform: "/mobile/ios") {
        }

        "/vip/shipping/calculator/choose_state"(platform: "/mobile/ios") {
        }

        "/vip/shipping/calculator/choose_city"(platform: "/mobile/ios") {
        }

        def defaultShipping = {
        shipping_type = "delivery"
        shipping_method_id = 123
        shipping_benefit = "loyalty"
        shipping_price = {
            price = 0
            currency_id  = "ARS"
        }
        shipping_days = {
            min = 4
            max = 5
        }
        recommend = true
        }

        def otherShipping = {
        shipping_type = "delivery"
        shipping_method_id = 1234
        shipping_price = {
            price = 100
            currency_id  = "ARS"
        }
        shipping_days = {
            min = 4
            max = 5
        }
        recommend = false
        }

        "/vip/shipping/calculator/go_to_vip"(platform: "/mobile/ios") {
            item_id = "MLA123"
            item_selected_quantity = 1
            item_shipping_quantity = 1
            shipping_default = defaultShipping
            shipping_selected = defaultShipping
            shipping_available_opcion = [
            defaultShipping,
            otherShipping
        ]
        }
    
    }
}
