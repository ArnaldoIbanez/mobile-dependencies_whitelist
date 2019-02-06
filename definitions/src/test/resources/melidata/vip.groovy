package src.test.resources.melidata

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
            add_to_cart_availability = "no_high_ratio"
            main_action = "buy"
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
            price_comparison_available = true
            price_comparison_position =  0.75
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
            item_id = "MLA533657947"
            error_message = "any message"
        })

        "/vip/abort"(platform:"/mobile", mandatory)

        "/vip/back"(platform:"/mobile", mandatory)

        "/vip/color_and_size"(platform:"/mobile", mandatory)

        "/vip/description/abort"(platform:"/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/description/back"(platform:"/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/description/failure"(platform:"/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/price_comparison"(platform:"/", type: TrackType.Event, {
            mandatory()
            optionals()
        })

        "/vip/contact_seller"(platform:"/mobile", type: TrackType.Event, {
            mandatory()
            listing_type_id = "GOLD"
            item_seller_type = "AB001"
            unregister = false
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

        "/vip/description/failure"(platform:"/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/item_gallery"(platform:"/mobile") {
            context = "/vip"
        }

        "/vip/item_gallery/back"(platform:"/mobile") {}

        "/vip/map"(platform:"/mobile", mandatory)

        "/vip/seller_reputation"(platform:"/mobile") {}

        "/vip/seller_reputation/ratings"(platform:"/mobile") {}

        "/vip/payment_method"(platform: "/mobile") {}

        "/vip/payment_method/back"(platform: "/mobile") {}

        "/vip/variations"(platform: "/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/variations/back"(platform: "/mobile"){
            item_id = "MLA533657947"
        }

        "/vip/quantity"(platform: "/mobile") {
            item_id = "MLA533657947"
        }
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

        "/vip/sizechart"(platform: "/", type: TrackType.View) {
            item_id = "MLA533657947"
        }

        "/vip/sizechart/tutorial"(platform: "/mobile", type: TrackType.View) {
            item_id = "MLA533657947"
        }
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
            item_id = "MLA213512313"
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

        "/vip/similar_vehicles"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }        


        "/vip/free_shipping_cart_available"(platform: "/web", type:TrackType.Event){
            defaultTrackInformation()
        }

        "/vip/description"(platform: "/web", type: TrackType.View){
            item_id = "MLA213512313"
        }

        "/vip/technical_specs"(platform: "/web", type: TrackType.View){
            item_id = "MLA213512313"
            vertical = "core"
        }

        "/vip/question"(platform: "/", type: TrackType.View){
            item_id = "MLA213512313"
            unregister = false

        }
    }

    test("New Shipping calculator"){

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
            vertical = "core"
        }

        "/vip/shipping/calculator/calculate"(platform: "/") {
            defaultTrackInformation()
            cp_autocomplete = "yes"
        }

        "/vip/shipping/calculator/i_dont_know_my_code"(platform: "/") {
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/calculate_error"(platform: "/") {
            defaultTrackInformation()
            error_type = "error code"
        }

        "/vip/shipping/calculator/agencies/show_agencies_map_for_pickup"(platform: "/") {
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/choose_state"(platform: "/") {
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/choose_city"(platform: "/") {
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/preloaded"(platform: "/web/mobile"){
            defaultTrackInformation()
        }

        "/vip/shipping/calculator/shipping_options"(platform: "/web/mobile"){
            defaultTrackInformation()
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

        "/vip/shipping/calculator/go_to_vip"(platform: "/") {
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

    test("VIP Web Classifieds services track click on link to landing_services") {
        "/vip/landing_services"(platform: "/web", type: TrackType.Event) {
            item_id = "MLA213512313"
            category_id = "MLA123"
            vertical = "services"
            buying_mode = "classified"
            category_path = ["MLA1234","MLA6789"]
            item_condition = "new"
            listing_type_id = "gold_special"
            item_status = "active"
            deal_ids = []
            seller_id = 123456789
        }
    }

    // RESERVATION

    test("VIP Web reservation onboard ") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
            category_path = ["MLA1234","MLA6789"]
            vertical = "motors"
            listing_type_id = "gold_premium"
            item_seller_type = "car_dealer"
            item_condition = "new"

        }

        def onboardInformation = {
            item_status = "active"
            buying_mode = "classified"
            deal_ids = []
            seller_id = 123456789
            contract_available = false
            comparator_available = true
            gallery_pattern = "XXXXXXXX"
            description_type = "plain_text"
            reputation_level = "5_green"
        }

        "/vip/reservation_onboard"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
            onboardInformation()
        }

        "/vip/reservation_onboard/ok"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
            onboardInformation()
        }

        "/vip/reservation_onboard/close"(platform: "/web", type: TrackType.Event) {
            defaultTrackInformation()
            onboardInformation()
        }

        "/vip/reservation_payment_options"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }

        "/vip/reservation_information"(platform: "/web", type: TrackType.View) {
            defaultTrackInformation()
        }

    }

    test("VIP Actions") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            quantity = 1
        }

        def cartInformation = {
            cart_content = false
            add_to_cart_availability = "yes_default"
            main_action = "buy"
        }

        def shippingInformation = {
            shipping_preference = "Normal a Domicilio"
            shipping_mode = "me1"
            free_shipping = false
            local_pick_up = false
            logistic_type = "default"
            free_shipping_benefit = false
            shipping_promise = {
                afterDispatch = true
                min_days = 2
                max_days = 12
                price = {
                    amount = 10000
                    currency_id = "ARS"
                    is_loyalty_discount = false
                }
                destination = "1429"
            }
        }

        "/vip/buy_action"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            cartInformation()
            shippingInformation()
        }

         "/vip/add_cart_action"(platform: "/", type: TrackType.View) {
            defaultTrackInformation()
            cartInformation()
            shippingInformation()
        }
        
        def shipping_method = { 
            shipping_method = {
                id = 531332827
                name = "Retiro en Correo Argentino"
                currency_id = "ARS"
                list_cost =  178.49
                cost = 178.49
                base_cost = 169.99
                display = "recommended"
                shipping_method_id = 503045
                shipping_method_type = "standard"
                shipping_option_type = "agency"
                estimated_delivery_time = {
                    type = "unknown_frame"
                    date = "2018-12-06T00:00:00.000-03:00"
                    shipping = 48
                    unit =  "hour"
                    offset = {
                        date =  "2018-12-10T00:00:00.000-03:00"
                        shipping = 48
                    }
                }      
            }
        }
        
        "/vip/quantity_change"(platform: "/", type: TrackType.Event) {
            item_id = "MLA533657947"
            price = 123
            zip_code = 123
            quantity = 2
            has_shipping = false
            has_stock = false
            shipping_method()
        }
    }

    test("VIP zipcode") {

        "/vip/input_zip_code"(platform: "/", type: TrackType.View) {}

         "/vip/input_zip_code/dont_know_my_zip_code"(platform: "/", type: TrackType.Event) {}
    }

    test("VIP fulfillment modal") {

        "/vip/show_fulfillment_popup"(platform: "/", type: TrackType.Event) {
            item_id = "MLA533657947"
            category_id = "MLA43718"
            category_path = ["MLA1234","MLA6789"]
            item_condition = "new"
            seller_id = 131662738
            price = 15.3
            currency_id = "ARS"
            original_price = 18.0
        }
    }

    test("VIP Shipping Calculator"){

        def model = {
            location = {
                type = "zip_code"
                value = "1234"
            }
            shipping_methods = [{
                cost = 50
                promoted_amount = 12
                delivery_type = "seller_agreement"
                selected = false
                promise = {
                    to = 4
                    from = 5
                    deferred = true
                }}]
        }

        def shipping_method = {
            selected_method = {
                cost = 50
                promoted_amount = 12
                delivery_type = "seller_agreement"
                selected = false
                promise = {
                    to = 4
                    from = 5
                    deferred = true
                }
            }
        }

        "/vip/shipping_calculator"(platform: "/", type: TrackType.View) {
            model()
        }

         "/vip/shipping_calculator/select"(platform: "/", type: TrackType.Event) {
            model()
            shipping_method()
        }

        "/vip/shipping_calculator/cancel"(platform: "/", type: TrackType.Event) {
            model()
        }
        
        "/vip/shipping_calculator/modify"(platform: "/", type: TrackType.Event) {}
        
        "/vip/shipping_calculator/show_map"(platform: "/", type: TrackType.Event) {
             model()
        }
        
        
        //Apps
        "/vip/shipping_calculator"(platform: "/mobile/ios", type: TrackType.View) {
            model()
        }

         "/vip/shipping_calculator/select"(platform: "/mobile/ios", type: TrackType.Event) {
            model()
            shipping_method()
        }

        "/vip/shipping_calculator/cancel"(platform: "/mobile/ios", type: TrackType.Event) {
            model()
        }
        
        "/vip/shipping_calculator/modify"(platform: "/mobile/ios", type: TrackType.Event) { }
        
        "/vip/shipping_calculator/show_map"(platform: "/mobile/ios", type: TrackType.Event) {
            model()
        }
    }
}
