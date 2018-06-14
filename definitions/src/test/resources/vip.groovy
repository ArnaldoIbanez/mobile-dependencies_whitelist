import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    //VIP FLOW
    test("Vip min core tracking in android") {
        def mandatory= {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "core"
            item_condition = "new"
            listing_type_id = "gold_special"
            item_status = "active"
            deal_ids = []
            seller_id = 131662738

            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
            discount_reasons = ["loyalty","deal"]
        }

        def optionals = {
            quantity = 3

            return_available = false
            cart_content = false
            power_seller_status = "platinum"
            reputation_level = "5_green"
            official_store_id = 1
            store_type = "brand"
            shipping_mode = "me2"
            free_shipping = true
            local_pick_up = false
            logistic_type = "fulfillment"
            free_shipping_benefit = false
            loyalty_level = 2
        }

        "/vip"(platform:"/mobile", {
            mandatory()
            optionals()
        })

        "/vip"(platform:"/mobile", {
            mandatory()
            optionals()
            shipping_preference = "Express a domicilio"
            available_subscriptions = true
            subscription_discount = 10
            default_tab = "subscription"
        })

        "/vip/failure"(platform:"/mobile", {
            mandatory()
            item_id = "MLA533657947"
            error_message = "any message"
        })

        "/vip/abort"(platform:"/mobile", mandatory)

        "/vip/back"(platform:"/mobile", mandatory)

        "/vip/color_and_size"(platform:"/mobile", mandatory)

        "/vip/description/abort"(platform:"/mobile", mandatory)

        "/vip/description/back"(platform:"/mobile", mandatory)

        "/vip/description/failure"(platform:"/mobile", mandatory)

        "/vip/contact_seller"(platform:"/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/contact_seller"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/contact_seller"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/call_seller"(platform:"/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/call_seller"(platform:"/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/call_seller"(platform:"/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/desktop", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/show_phone"(platform: "/web/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
        })

        "/vip/description/failure"(platform:"/mobile", mandatory)

        "/vip/item_gallery"(platform:"/mobile") {
            context = "/vip"
        }

        "/vip/item_gallery/back"(platform:"/mobile") {}

        "/vip/map"(platform:"/mobile", mandatory)

        "/vip/seller_reputation"(platform:"/mobile", mandatory)

        "/vip/seller_reputation/ratings"(platform:"/mobile", mandatory)

        "/vip/payment_method"(platform: "/mobile", mandatory)

        "/vip/payment_method/back"(platform: "/mobile", mandatory)

        "/vip/variations"(platform: "/mobile", mandatory)

        "/vip/variations/back"(platform: "/mobile", mandatory)

        "/vip/quantity"(platform: "/mobile", mandatory)
    }

    test("Vip web mobile tracking without reviews") {

        "/vip"(platform:"/web/mobile") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=-1
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
            contract_available = false
        }
    }


    test("Vip web mobile with reviews") {
        "/vip"(platform:"/web/mobile") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=3.5
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
            contract_available = false
        }
    }

    test("Vip web desktop without reviews") {
        "/vip"(platform:"/web/desktop") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=-1
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
        }
    }

    test("Vip web desktop with reviews") {
        "/vip"(platform:"/web/desktop") {
            category_id = "MLA1234"
            item_id="MLA1891239"
            review_rate=5
            buying_mode = "buy_it_now"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
        }
    }

    test("Vip tracking in web") {
        def dataSet = {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            buying_mode = "buy_it_now"
            official_store_id = 1
            deal_ids = ["MLA24"]
            review_rate=5
            specifications_size = 1
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
        }

        "/vip"(platform:"/web", dataSet)
    }

    test("Vip protected purchase") {
        "/vip/protected_purchase/show" (platform:"/web/mobile", type: TrackType.Event) {
            category_id = "MLA1234"
            item_id="MLA1891239"
            category_path = ["MLA1234","MLA6789"]
            buying_mode = "buy_it_now"
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
        }

        "/vip/protected_purchase/close" (platform:"/web/mobile", type: TrackType.Event) {
            category_id = "MLA1234"
            category_path = ["MLA1234","MLA6789"]
            item_id="MLA1891239"
            buying_mode = "buy_it_now"
            vertical = "motors"
            item_condition = "new"
            item_status = "paused"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = ["MLA100"]
        }
    }


    test("melidata vip track") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
            category_path = ["MLA1234","MLA6789"]
            buying_mode = "buy_it_now"
            vertical = "motors"
            item_condition = "new"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            power_seller_status = "platinum"
            deal_ids = []
            billboard_clicked_position = "3"
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
            defaultTrackInformation()
            trackModals()
        }

        "/vip/coordinate_availability"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/vip/contract_intention"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }


        "/vip/free_shipping_cart_available"(platform: "/web", type:TrackType.Event){}

        "/vip/description"(platform: "/web", type: TrackType.View){
            defaultTrackInformation()
        }

        "/vip/question"(platform: "/", type: TrackType.View){

            defaultTrackInformation()
        }
    }

    test("New Shipping calculator"){

        "/vip/shipping/calculator/calculate"(platform: "/mobile/ios") {
            cp_autocomplete = "yes"
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

        def defaultShipping = [
        shipping_type : "delivery",
        shipping_method_id : 123,
        shipping_benefit : "loyalty",
        shipping_price : [
            price : 0,
            currency_id  : "ARS",
        ],
        shipping_days : [
            min : 4,
            max : 5
        ],
        recommend : true
        ]

        def otherShipping = [
        shipping_type : "delivery",
        shipping_method_id : 1234,
        shipping_price : [
            price : 100 ,
            currency_id  : "ARS"
        ],
        shipping_days : [
            min : 4,
            max : 5
        ],
        recommend : false
        ]

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
